package ir.nasim;

import android.content.Context;
import java.util.Objects;

/* renamed from: ir.nasim.re0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C20212re0 extends OL4 {
    private final String c;
    private final int d;
    private final int e;

    public C20212re0(C11909dl1 c11909dl1) {
        super(c11909dl1);
        C16829lw c16829lw = (C16829lw) ((C15784kA) c11909dl1.c()).u();
        this.c = c16829lw.y();
        this.d = c16829lw.u();
        this.e = c16829lw.w();
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        return context.getString(AbstractC12217eE5.message_holder_content_bill);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        C20212re0 c20212re0 = (C20212re0) obj;
        return this.d == c20212re0.d && this.e == c20212re0.e && Objects.equals(this.c, c20212re0.c);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.c, Integer.valueOf(this.d), Integer.valueOf(this.e));
    }
}
