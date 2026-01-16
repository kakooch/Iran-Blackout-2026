package ir.nasim;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.jI6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C15272jI6 implements Appendable, CharSequence {
    private final StringBuilder a;
    private final Deque b;

    /* renamed from: ir.nasim.jI6$a */
    public static class a {
        public final Object a;
        public int b;
        public int c;
        public final int d;

        a(Object obj, int i, int i2, int i3) {
            this.a = obj;
            this.b = i;
            this.c = i2;
            this.d = i3;
        }
    }

    /* renamed from: ir.nasim.jI6$b */
    static class b extends SpannableStringBuilder {
        b(CharSequence charSequence) {
            super(charSequence);
        }
    }

    public C15272jI6() {
        this("");
    }

    private void e(int i, CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            boolean z = spanned instanceof b;
            Object[] spans = spanned.getSpans(0, spanned.length(), Object.class);
            int length = spans != null ? spans.length : 0;
            if (length > 0) {
                if (!z) {
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj = spans[i2];
                        j(obj, spanned.getSpanStart(obj) + i, spanned.getSpanEnd(obj) + i, spanned.getSpanFlags(obj));
                    }
                    return;
                }
                for (int i3 = length - 1; i3 >= 0; i3--) {
                    Object obj2 = spans[i3];
                    j(obj2, spanned.getSpanStart(obj2) + i, spanned.getSpanEnd(obj2) + i, spanned.getSpanFlags(obj2));
                }
            }
        }
    }

    static boolean g(int i, int i2, int i3) {
        return i3 > i2 && i2 >= 0 && i3 <= i;
    }

    public static void k(C15272jI6 c15272jI6, Object obj, int i, int i2) {
        if (obj == null || !g(c15272jI6.length(), i, i2)) {
            return;
        }
        l(c15272jI6, obj, i, i2);
    }

    private static void l(C15272jI6 c15272jI6, Object obj, int i, int i2) {
        if (obj != null) {
            if (!obj.getClass().isArray()) {
                c15272jI6.j(obj, i, i2, 33);
                return;
            }
            for (Object obj2 : (Object[]) obj) {
                l(c15272jI6, obj2, i, i2);
            }
        }
    }

    @Override // java.lang.Appendable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C15272jI6 append(char c) {
        this.a.append(c);
        return this;
    }

    @Override // java.lang.Appendable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C15272jI6 append(CharSequence charSequence) {
        e(length(), charSequence);
        this.a.append(charSequence);
        return this;
    }

    @Override // java.lang.Appendable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C15272jI6 append(CharSequence charSequence, int i, int i2) {
        CharSequence charSequenceSubSequence = charSequence.subSequence(i, i2);
        e(length(), charSequenceSubSequence);
        this.a.append(charSequenceSubSequence);
        return this;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.a.charAt(i);
    }

    public C15272jI6 d(String str) {
        this.a.append(str);
        return this;
    }

    public List f(int i, int i2) {
        int i3;
        int length = length();
        if (!g(length, i, i2)) {
            return Collections.emptyList();
        }
        if (i == 0 && length == i2) {
            ArrayList arrayList = new ArrayList(this.b);
            Collections.reverse(arrayList);
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(0);
        Iterator itDescendingIterator = this.b.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            a aVar = (a) itDescendingIterator.next();
            int i4 = aVar.b;
            if ((i4 >= i && i4 < i2) || (((i3 = aVar.c) <= i2 && i3 > i) || (i4 < i && i3 > i2))) {
                arrayList2.add(aVar);
            }
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public char h() {
        return this.a.charAt(length() - 1);
    }

    public C15272jI6 i(Object obj, int i, int i2) {
        return j(obj, i, i2, 33);
    }

    public C15272jI6 j(Object obj, int i, int i2, int i3) {
        this.b.push(new a(obj, i, i2, i3));
        return this;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.a.length();
    }

    public SpannableStringBuilder m() {
        b bVar = new b(this.a);
        for (a aVar : this.b) {
            bVar.setSpan(aVar.a, aVar.b, aVar.c, aVar.d);
        }
        return bVar;
    }

    public CharSequence n() {
        return m();
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        List<a> listF = f(i, i2);
        if (listF.isEmpty()) {
            return this.a.subSequence(i, i2);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.a.subSequence(i, i2));
        int length = spannableStringBuilder.length();
        for (a aVar : listF) {
            int iMax = Math.max(0, aVar.b - i);
            spannableStringBuilder.setSpan(aVar.a, iMax, Math.min(length, (aVar.c - aVar.b) + iMax), aVar.d);
        }
        return spannableStringBuilder;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.a.toString();
    }

    public C15272jI6(CharSequence charSequence) {
        this.b = new ArrayDeque(8);
        this.a = new StringBuilder(charSequence);
        e(0, charSequence);
    }
}
