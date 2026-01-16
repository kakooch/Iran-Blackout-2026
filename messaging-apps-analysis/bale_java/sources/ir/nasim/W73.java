package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class W73 {
    private final List a;

    public W73(C5109Hy c5109Hy) {
        AbstractC13042fc3.i(c5109Hy, "apiInlineKeyboardButtonList");
        this.a = new ArrayList();
        for (C4875Gy c4875Gy : c5109Hy.q()) {
            List list = this.a;
            AbstractC13042fc3.f(c4875Gy);
            list.add(new U73(c4875Gy));
        }
    }

    public final List a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(W73.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.InlineKeyboardRow");
        return AbstractC13042fc3.d(this.a, ((W73) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
