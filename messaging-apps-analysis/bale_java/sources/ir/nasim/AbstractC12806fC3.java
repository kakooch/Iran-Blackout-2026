package ir.nasim;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.fC3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC12806fC3 {
    private static final void a(Appendable appendable, Object obj, UA2 ua2) throws IOException {
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

    public static final List b(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj = list.get(i);
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private static final Appendable c(List list, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, UA2 ua2) throws IOException {
        appendable.append(charSequence2);
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            i2++;
            if (i2 > 1) {
                appendable.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            a(appendable, obj, ua2);
        }
        if (i >= 0 && i2 > i) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String d(List list, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, UA2 ua2) {
        return ((StringBuilder) c(list, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, ua2)).toString();
    }

    public static /* synthetic */ String e(List list, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, UA2 ua2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        if ((i2 & 8) != 0) {
            i = -1;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            ua2 = null;
        }
        return d(list, charSequence, charSequence5, charSequence6, i3, charSequence7, ua2);
    }

    public static final void f(String str) {
        throw new UnsupportedOperationException(str);
    }
}
