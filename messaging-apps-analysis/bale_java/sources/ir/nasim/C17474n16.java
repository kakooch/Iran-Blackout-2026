package ir.nasim;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: ir.nasim.n16, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C17474n16 implements G6, InterfaceC11747dX7 {
    private final Set a = new HashSet();
    private boolean b = false;

    public void a() {
        AbstractC14995ip7.a();
        this.b = true;
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            AbstractC18350oW3.a(it.next());
            throw null;
        }
    }
}
