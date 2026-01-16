package ir.nasim;

import android.content.Context;
import java.util.ArrayList;
import java.util.Objects;

/* renamed from: ir.nasim.vk7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C22739vk7 extends AbstractC17457n0 {
    private final long c;
    private final String d;

    public C22739vk7(C11909dl1 c11909dl1) {
        super(c11909dl1);
        this.c = ((VC) c11909dl1.c()).u();
        this.d = ((VC) c11909dl1.c()).w();
    }

    public static C22739vk7 r(String str, Long l) {
        return new C22739vk7(new C11909dl1(new VC(str, l.longValue(), null)));
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        return context.getString(AbstractC12217eE5.message_holder_content_template_response);
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C22739vk7 c22739vk7 = (C22739vk7) obj;
        return this.c == c22739vk7.c && Objects.equals(this.d, c22739vk7.d);
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.c), this.d);
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        return new C23345wl7(new C11909dl1(new ZC(t(), new ArrayList(), null, null)));
    }

    public long s() {
        return this.c;
    }

    public String t() {
        return this.d;
    }
}
