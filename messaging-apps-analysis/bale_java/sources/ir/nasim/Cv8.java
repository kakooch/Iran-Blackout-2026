package ir.nasim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class Cv8 {
    private final AbstractC9994at8 a;
    private final boolean b;
    private final C12628ev8 c;

    private Cv8(C12628ev8 c12628ev8, boolean z, AbstractC9994at8 abstractC9994at8, int i) {
        this.c = c12628ev8;
        this.b = z;
        this.a = abstractC9994at8;
    }

    public static Cv8 c(AbstractC9994at8 abstractC9994at8) {
        return new Cv8(new C12628ev8(abstractC9994at8), false, C22820vs8.b, Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Iterator h(CharSequence charSequence) {
        return new Vu8(this.c, this, charSequence);
    }

    public final Cv8 b() {
        return new Cv8(this.c, true, this.a, Integer.MAX_VALUE);
    }

    public final Iterable d(CharSequence charSequence) {
        return new C17419mv8(this, charSequence);
    }

    public final List f(CharSequence charSequence) {
        charSequence.getClass();
        Iterator itH = h(charSequence);
        ArrayList arrayList = new ArrayList();
        while (itH.hasNext()) {
            arrayList.add((String) itH.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
