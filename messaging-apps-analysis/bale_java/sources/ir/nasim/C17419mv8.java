package ir.nasim;

import java.io.IOException;
import java.util.Iterator;

/* renamed from: ir.nasim.mv8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C17419mv8 implements Iterable {
    final /* synthetic */ CharSequence a;
    final /* synthetic */ Cv8 b;

    C17419mv8(Cv8 cv8, CharSequence charSequence) {
        this.b = cv8;
        this.a = charSequence;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.b.h(this.a);
    }

    public final String toString() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator it = iterator();
        try {
            if (it.hasNext()) {
                sb.append(AbstractC19182pu8.a(it.next(), ", "));
                while (it.hasNext()) {
                    sb.append((CharSequence) ", ");
                    sb.append(AbstractC19182pu8.a(it.next(), ", "));
                }
            }
            sb.append(']');
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
