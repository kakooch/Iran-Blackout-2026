package ir.nasim;

import android.content.Context;
import java.util.Objects;

/* loaded from: classes5.dex */
public class QM5 extends E50 {
    private C14517i30 c;
    private long d;

    public QM5(C11909dl1 c11909dl1) {
        super(c11909dl1);
        C13265fw c13265fw = (C13265fw) ((C12038dw) c11909dl1.c()).u();
        this.c = new C14517i30(c13265fw.u());
        this.d = c13265fw.w();
    }

    @Override // ir.nasim.E50, ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        return context.getString(AbstractC12217eE5.message_holder_content_bank_remain);
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        QM5 qm5 = (QM5) obj;
        return this.d == qm5.d && Objects.equals(this.c, qm5.c);
    }

    public int hashCode() {
        return Objects.hash(this.c, Long.valueOf(this.d));
    }

    public C14517i30 r() {
        return this.c;
    }

    public long s() {
        return this.d;
    }
}
