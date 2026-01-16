package ir.nasim;

import java.io.IOException;

/* renamed from: ir.nasim.jZ6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract class AbstractC15425jZ6 {
    public static Appendable a(Appendable appendable, CharSequence... charSequenceArr) throws IOException {
        AbstractC13042fc3.i(appendable, "<this>");
        AbstractC13042fc3.i(charSequenceArr, "value");
        for (CharSequence charSequence : charSequenceArr) {
            appendable.append(charSequence);
        }
        return appendable;
    }

    public static void b(Appendable appendable, Object obj, UA2 ua2) {
        AbstractC13042fc3.i(appendable, "<this>");
        if (ua2 != null) {
            appendable.append((CharSequence) ua2.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            appendable.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            appendable.append(((Character) obj).charValue());
        } else {
            appendable.append(String.valueOf(obj));
        }
    }
}
