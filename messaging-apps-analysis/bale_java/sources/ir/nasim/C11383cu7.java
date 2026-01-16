package ir.nasim;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* renamed from: ir.nasim.cu7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C11383cu7 extends E50 {
    private List c;

    public C11383cu7(C11909dl1 c11909dl1) {
        super(c11909dl1);
        C13856gw c13856gw = (C13856gw) ((C12038dw) c11909dl1.c()).u();
        this.c = new ArrayList();
        Iterator it = c13856gw.u().iterator();
        while (it.hasNext()) {
            this.c.add(new C10003au7((C12811fD) it.next()));
        }
    }

    @Override // ir.nasim.E50, ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        return context.getString(AbstractC12217eE5.message_holder_content_bank_transaction);
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.c, ((C11383cu7) obj).c);
    }

    public int hashCode() {
        return Objects.hashCode(this.c);
    }

    public List r() {
        return this.c;
    }
}
