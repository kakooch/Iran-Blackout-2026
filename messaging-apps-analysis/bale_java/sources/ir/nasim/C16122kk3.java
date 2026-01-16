package ir.nasim;

import android.content.Context;
import java.util.Objects;

/* renamed from: ir.nasim.kk3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C16122kk3 extends AbstractC17457n0 {
    private String c;

    public C16122kk3(C11909dl1 c11909dl1) {
        super(c11909dl1);
        this.c = ((C8664Wy) c11909dl1.c()).u();
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        return InterfaceC25103zk1.e(context);
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.c, ((C16122kk3) obj).c);
    }

    public int hashCode() {
        return Objects.hashCode(this.c);
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        return null;
    }

    public String r() {
        return this.c;
    }
}
