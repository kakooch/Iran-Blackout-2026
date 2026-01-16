package ir.nasim;

import androidx.recyclerview.widget.i;
import ir.nasim.InterfaceC23337wl;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.il, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14947il extends i.f {
    private final boolean f(C8967Xz7 c8967Xz7, C8967Xz7 c8967Xz72) {
        Q64 q64H = c8967Xz7.h();
        Q64 q64H2 = c8967Xz72.h();
        return q64H.i() == q64H2.i() && q64H.h() == q64H2.h();
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(C14339hl c14339hl, C14339hl c14339hl2) {
        AbstractC13042fc3.i(c14339hl, "oldItem");
        AbstractC13042fc3.i(c14339hl2, "newItem");
        if (AbstractC13042fc3.d(c14339hl.e(), c14339hl2.e()) && c14339hl.d().j().L() == c14339hl2.d().j().L()) {
            C23345wl7 c23345wl7L = c14339hl.d().j().F().l();
            String strV = c23345wl7L != null ? c23345wl7L.v() : null;
            C23345wl7 c23345wl7L2 = c14339hl2.d().j().F().l();
            if (AbstractC13042fc3.d(strV, c23345wl7L2 != null ? c23345wl7L2.v() : null)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean b(C14339hl c14339hl, C14339hl c14339hl2) {
        AbstractC13042fc3.i(c14339hl, "oldItem");
        AbstractC13042fc3.i(c14339hl2, "newItem");
        return f(c14339hl.d(), c14339hl2.d());
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public List c(C14339hl c14339hl, C14339hl c14339hl2) {
        AbstractC13042fc3.i(c14339hl, "oldItem");
        AbstractC13042fc3.i(c14339hl2, "newItem");
        ArrayList arrayList = new ArrayList();
        if (!AbstractC13042fc3.d(c14339hl.e(), c14339hl2.e())) {
            if (c14339hl.e() == null) {
                arrayList.add(new InterfaceC23337wl.c(true));
            } else if (c14339hl2.e() == null) {
                arrayList.add(new InterfaceC23337wl.c(false));
            }
            arrayList.add(new InterfaceC23337wl.b(c14339hl2));
        }
        C23345wl7 c23345wl7L = c14339hl.d().j().F().l();
        String strV = c23345wl7L != null ? c23345wl7L.v() : null;
        C23345wl7 c23345wl7L2 = c14339hl2.d().j().F().l();
        if (!AbstractC13042fc3.d(strV, c23345wl7L2 != null ? c23345wl7L2.v() : null) || c14339hl.d().j().L() != c14339hl2.d().j().L()) {
            arrayList.add(new InterfaceC23337wl.a(c14339hl2));
        }
        return arrayList;
    }
}
