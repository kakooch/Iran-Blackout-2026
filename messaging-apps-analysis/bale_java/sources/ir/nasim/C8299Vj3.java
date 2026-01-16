package ir.nasim;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/* renamed from: ir.nasim.Vj3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C8299Vj3 {
    private final String a;

    private C8299Vj3(String str) {
        this.a = (String) AbstractC4029Dj5.j(str);
    }

    public static C8299Vj3 d(char c) {
        return new C8299Vj3(String.valueOf(c));
    }

    public Appendable a(Appendable appendable, Iterator it) throws IOException {
        AbstractC4029Dj5.j(appendable);
        if (it.hasNext()) {
            appendable.append(e(it.next()));
            while (it.hasNext()) {
                appendable.append(this.a);
                appendable.append(e(it.next()));
            }
        }
        return appendable;
    }

    public final StringBuilder b(StringBuilder sb, Iterable iterable) {
        return c(sb, iterable.iterator());
    }

    public final StringBuilder c(StringBuilder sb, Iterator it) {
        try {
            a(sb, it);
            return sb;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    CharSequence e(Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }
}
