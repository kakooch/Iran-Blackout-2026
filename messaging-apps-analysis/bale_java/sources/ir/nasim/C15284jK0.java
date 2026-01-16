package ir.nasim;

import android.content.Context;
import java.util.Objects;

/* renamed from: ir.nasim.jK0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C15284jK0 extends OL4 {
    private final String c;
    private final String d;
    private final int e;
    private final String f;

    public C15284jK0(C11909dl1 c11909dl1) {
        super(c11909dl1);
        C6759Ow c6759Ow = (C6759Ow) ((C15784kA) c11909dl1.c()).u();
        this.c = c6759Ow.z();
        this.d = c6759Ow.y();
        this.e = c6759Ow.u();
        this.f = c6759Ow.w();
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        return context.getString(AbstractC12217eE5.message_holder_content_charge);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        C15284jK0 c15284jK0 = (C15284jK0) obj;
        return this.e == c15284jK0.e && Objects.equals(this.c, c15284jK0.c) && Objects.equals(this.d, c15284jK0.d) && Objects.equals(this.f, c15284jK0.f);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.c, this.d, Integer.valueOf(this.e), this.f);
    }
}
