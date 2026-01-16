package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: ir.nasim.sA, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20530sA {
    private final ArrayList a = new ArrayList();

    public final void a(PW4 pw4) {
        AbstractC13042fc3.i(pw4, "extension");
        this.a.add(pw4);
    }

    public final AbstractC10745c76 b(int i, byte[] bArr) throws IOException {
        Iterator it = this.a.iterator();
        AbstractC13042fc3.h(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            AbstractC13042fc3.h(next, "next(...)");
            try {
                return (AbstractC10745c76) ((PW4) next).a().a(i, bArr);
            } catch (Exception e) {
                C19406qI3.d("ApiParserConfig Exception", e);
            }
        }
        throw new IOException("Unknown package");
    }
}
