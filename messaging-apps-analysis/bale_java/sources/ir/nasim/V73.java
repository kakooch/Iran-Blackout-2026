package ir.nasim;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class V73 extends AbstractC17457n0 {
    private final List c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V73(C11909dl1 c11909dl1) {
        C5343Iy c5343IyW;
        super(c11909dl1);
        AbstractC13042fc3.i(c11909dl1, "remoteContainer");
        this.c = new ArrayList();
        AbstractC24063xz abstractC24063xzC = c11909dl1.c();
        AbstractC13042fc3.g(abstractC24063xzC, "null cannot be cast to non-null type ir.nasim.core.api.ApiTemplateMessage");
        TC tc = (TC) abstractC24063xzC;
        List<C5109Hy> listQ = null;
        if (tc.w() != null && (c5343IyW = tc.w()) != null) {
            listQ = c5343IyW.q();
        }
        if (listQ != null) {
            for (C5109Hy c5109Hy : listQ) {
                if (c5109Hy != null) {
                    this.c.add(new W73(c5109Hy));
                }
            }
        }
    }

    @Override // ir.nasim.InterfaceC25103zk1
    public String b(Context context, int i, String str, boolean z) {
        AbstractC13042fc3.i(context, "context");
        return InterfaceC25103zk1.a.a(context);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbstractC13042fc3.d(V73.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.messaging.entity.content.InlineKeyboardButtonMarkup");
        return AbstractC13042fc3.d(this.c, ((V73) obj).c);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    @Override // ir.nasim.AbstractC17457n0
    public C23345wl7 l() {
        return null;
    }

    public final List r() {
        return this.c;
    }
}
