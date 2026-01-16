package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.e;
import androidx.emoji2.text.l;
import ir.nasim.AbstractC22956w62;
import ir.nasim.C14674iI6;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
final class h {
    private final e.j a;
    private final l b;
    private e.InterfaceC0085e c;
    private final boolean d;
    private final int[] e;

    private static final class a {
        static int a(CharSequence charSequence, int i, int i2) {
            int length = charSequence.length();
            if (i < 0 || length < i || i2 < 0) {
                return -1;
            }
            while (true) {
                boolean z = false;
                while (i2 != 0) {
                    i--;
                    if (i < 0) {
                        return z ? -1 : 0;
                    }
                    char cCharAt = charSequence.charAt(i);
                    if (z) {
                        if (!Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        i2--;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i2--;
                    } else {
                        if (Character.isHighSurrogate(cCharAt)) {
                            return -1;
                        }
                        z = true;
                    }
                }
                return i;
            }
        }

        static int b(CharSequence charSequence, int i, int i2) {
            int length = charSequence.length();
            if (i < 0 || length < i || i2 < 0) {
                return -1;
            }
            while (true) {
                boolean z = false;
                while (i2 != 0) {
                    if (i >= length) {
                        if (z) {
                            return -1;
                        }
                        return length;
                    }
                    char cCharAt = charSequence.charAt(i);
                    if (z) {
                        if (!Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i2--;
                        i++;
                    } else if (!Character.isSurrogate(cCharAt)) {
                        i2--;
                        i++;
                    } else {
                        if (Character.isLowSurrogate(cCharAt)) {
                            return -1;
                        }
                        i++;
                        z = true;
                    }
                }
                return i;
            }
        }
    }

    private static class b implements c {
        public n a;
        private final e.j b;

        b(n nVar, e.j jVar) {
            this.a = nVar;
            this.b = jVar;
        }

        @Override // androidx.emoji2.text.h.c
        public boolean a(CharSequence charSequence, int i, int i2, m mVar) {
            if (mVar.k()) {
                return true;
            }
            if (this.a == null) {
                this.a = new n(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
            }
            this.a.setSpan(this.b.a(mVar), i, i2, 33);
            return true;
        }

        @Override // androidx.emoji2.text.h.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public n getResult() {
            return this.a;
        }
    }

    private interface c {
        boolean a(CharSequence charSequence, int i, int i2, m mVar);

        Object getResult();
    }

    private static class d implements c {
        private final int a;
        public int b = -1;
        public int c = -1;

        d(int i) {
            this.a = i;
        }

        @Override // androidx.emoji2.text.h.c
        public boolean a(CharSequence charSequence, int i, int i2, m mVar) {
            int i3 = this.a;
            if (i > i3 || i3 >= i2) {
                return i2 <= i3;
            }
            this.b = i;
            this.c = i2;
            return false;
        }

        @Override // androidx.emoji2.text.h.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public d getResult() {
            return this;
        }
    }

    private static class e implements c {
        private final String a;

        e(String str) {
            this.a = str;
        }

        @Override // androidx.emoji2.text.h.c
        public boolean a(CharSequence charSequence, int i, int i2, m mVar) {
            if (!TextUtils.equals(charSequence.subSequence(i, i2), this.a)) {
                return true;
            }
            mVar.l(true);
            return false;
        }

        @Override // androidx.emoji2.text.h.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e getResult() {
            return this;
        }
    }

    static final class f {
        private int a = 1;
        private final l.a b;
        private l.a c;
        private l.a d;
        private int e;
        private int f;
        private final boolean g;
        private final int[] h;

        f(l.a aVar, boolean z, int[] iArr) {
            this.b = aVar;
            this.c = aVar;
            this.g = z;
            this.h = iArr;
        }

        private static boolean d(int i) {
            return i == 65039;
        }

        private static boolean f(int i) {
            return i == 65038;
        }

        private int g() {
            this.a = 1;
            this.c = this.b;
            this.f = 0;
            return 1;
        }

        private boolean h() {
            if (this.c.b().j() || d(this.e)) {
                return true;
            }
            if (this.g) {
                if (this.h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.h, this.c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }

        int a(int i) {
            l.a aVarA = this.c.a(i);
            int iG = 2;
            if (this.a != 2) {
                if (aVarA == null) {
                    iG = g();
                } else {
                    this.a = 2;
                    this.c = aVarA;
                    this.f = 1;
                }
            } else if (aVarA != null) {
                this.c = aVarA;
                this.f++;
            } else if (f(i)) {
                iG = g();
            } else if (!d(i)) {
                if (this.c.b() != null) {
                    iG = 3;
                    if (this.f != 1 || h()) {
                        this.d = this.c;
                        g();
                    } else {
                        iG = g();
                    }
                } else {
                    iG = g();
                }
            }
            this.e = i;
            return iG;
        }

        m b() {
            return this.c.b();
        }

        m c() {
            return this.d.b();
        }

        boolean e() {
            return this.a == 2 && this.c.b() != null && (this.f > 1 || h());
        }
    }

    h(l lVar, e.j jVar, e.InterfaceC0085e interfaceC0085e, boolean z, int[] iArr, Set set) {
        this.a = jVar;
        this.b = lVar;
        this.c = interfaceC0085e;
        this.d = z;
        this.e = iArr;
        i(set);
    }

    private static boolean a(Editable editable, KeyEvent keyEvent, boolean z) {
        AbstractC22956w62[] abstractC22956w62Arr;
        if (h(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!g(selectionStart, selectionEnd) && (abstractC22956w62Arr = (AbstractC22956w62[]) editable.getSpans(selectionStart, selectionEnd, AbstractC22956w62.class)) != null && abstractC22956w62Arr.length > 0) {
            for (AbstractC22956w62 abstractC22956w62 : abstractC22956w62Arr) {
                int spanStart = editable.getSpanStart(abstractC22956w62);
                int spanEnd = editable.getSpanEnd(abstractC22956w62);
                if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean d(InputConnection inputConnection, Editable editable, int i, int i2, boolean z) {
        int iMax;
        int iMin;
        if (editable != null && inputConnection != null && i >= 0 && i2 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (g(selectionStart, selectionEnd)) {
                return false;
            }
            if (z) {
                iMax = a.a(editable, selectionStart, Math.max(i, 0));
                iMin = a.b(editable, selectionEnd, Math.max(i2, 0));
                if (iMax == -1 || iMin == -1) {
                    return false;
                }
            } else {
                iMax = Math.max(selectionStart - i, 0);
                iMin = Math.min(selectionEnd + i2, editable.length());
            }
            AbstractC22956w62[] abstractC22956w62Arr = (AbstractC22956w62[]) editable.getSpans(iMax, iMin, AbstractC22956w62.class);
            if (abstractC22956w62Arr != null && abstractC22956w62Arr.length > 0) {
                for (AbstractC22956w62 abstractC22956w62 : abstractC22956w62Arr) {
                    int spanStart = editable.getSpanStart(abstractC22956w62);
                    int spanEnd = editable.getSpanEnd(abstractC22956w62);
                    iMax = Math.min(spanStart, iMax);
                    iMin = Math.max(spanEnd, iMin);
                }
                int iMax2 = Math.max(iMax, 0);
                int iMin2 = Math.min(iMin, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(iMax2, iMin2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    static boolean e(Editable editable, int i, KeyEvent keyEvent) {
        if (!(i != 67 ? i != 112 ? false : a(editable, keyEvent, true) : a(editable, keyEvent, false))) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    private boolean f(CharSequence charSequence, int i, int i2, m mVar) {
        if (mVar.d() == 0) {
            mVar.m(this.c.a(charSequence, i, i2, mVar.h()));
        }
        return mVar.d() == 2;
    }

    private static boolean g(int i, int i2) {
        return i == -1 || i2 == -1 || i != i2;
    }

    private static boolean h(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    private void i(Set set) {
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            k(str, 0, str.length(), 1, true, new e(str));
        }
    }

    private Object k(CharSequence charSequence, int i, int i2, int i3, boolean z, c cVar) {
        int iCharCount;
        f fVar = new f(this.b.f(), this.d, this.e);
        int i4 = 0;
        boolean zA = true;
        int iCodePointAt = Character.codePointAt(charSequence, i);
        loop0: while (true) {
            iCharCount = i;
            while (i < i2 && i4 < i3 && zA) {
                int iA = fVar.a(iCodePointAt);
                if (iA == 1) {
                    iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                    if (iCharCount < i2) {
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                    }
                    i = iCharCount;
                } else if (iA == 2) {
                    i += Character.charCount(iCodePointAt);
                    if (i < i2) {
                        iCodePointAt = Character.codePointAt(charSequence, i);
                    }
                } else if (iA == 3) {
                    if (z || !f(charSequence, iCharCount, i, fVar.c())) {
                        zA = cVar.a(charSequence, iCharCount, i, fVar.c());
                        i4++;
                    }
                }
            }
            break loop0;
        }
        if (fVar.e() && i4 < i3 && zA && (z || !f(charSequence, iCharCount, i, fVar.b()))) {
            cVar.a(charSequence, iCharCount, i, fVar.b());
        }
        return cVar.getResult();
    }

    int b(CharSequence charSequence, int i) {
        if (i < 0 || i >= charSequence.length()) {
            return -1;
        }
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            AbstractC22956w62[] abstractC22956w62Arr = (AbstractC22956w62[]) spanned.getSpans(i, i + 1, AbstractC22956w62.class);
            if (abstractC22956w62Arr.length > 0) {
                return spanned.getSpanEnd(abstractC22956w62Arr[0]);
            }
        }
        return ((d) k(charSequence, Math.max(0, i - 16), Math.min(charSequence.length(), i + 16), Integer.MAX_VALUE, true, new d(i))).c;
    }

    int c(CharSequence charSequence, int i) {
        if (i < 0 || i >= charSequence.length()) {
            return -1;
        }
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            AbstractC22956w62[] abstractC22956w62Arr = (AbstractC22956w62[]) spanned.getSpans(i, i + 1, AbstractC22956w62.class);
            if (abstractC22956w62Arr.length > 0) {
                return spanned.getSpanStart(abstractC22956w62Arr[0]);
            }
        }
        return ((d) k(charSequence, Math.max(0, i - 16), Math.min(charSequence.length(), i + 16), Integer.MAX_VALUE, true, new d(i))).b;
    }

    CharSequence j(CharSequence charSequence, int i, int i2, int i3, boolean z) {
        n nVar;
        AbstractC22956w62[] abstractC22956w62Arr;
        boolean z2 = charSequence instanceof C14674iI6;
        if (z2) {
            ((C14674iI6) charSequence).a();
        }
        if (!z2) {
            try {
                nVar = charSequence instanceof Spannable ? new n((Spannable) charSequence) : (!(charSequence instanceof Spanned) || ((Spanned) charSequence).nextSpanTransition(i + (-1), i2 + 1, AbstractC22956w62.class) > i2) ? null : new n(charSequence);
            } finally {
                if (z2) {
                    ((C14674iI6) charSequence).d();
                }
            }
        }
        if (nVar != null && (abstractC22956w62Arr = (AbstractC22956w62[]) nVar.getSpans(i, i2, AbstractC22956w62.class)) != null && abstractC22956w62Arr.length > 0) {
            for (AbstractC22956w62 abstractC22956w62 : abstractC22956w62Arr) {
                int spanStart = nVar.getSpanStart(abstractC22956w62);
                int spanEnd = nVar.getSpanEnd(abstractC22956w62);
                if (spanStart != i2) {
                    nVar.removeSpan(abstractC22956w62);
                }
                i = Math.min(spanStart, i);
                i2 = Math.max(spanEnd, i2);
            }
        }
        int i4 = i2;
        if (i != i4 && i < charSequence.length()) {
            if (i3 != Integer.MAX_VALUE && nVar != null) {
                i3 -= ((AbstractC22956w62[]) nVar.getSpans(0, nVar.length(), AbstractC22956w62.class)).length;
            }
            n nVar2 = (n) k(charSequence, i, i4, i3, z, new b(nVar, this.a));
            if (nVar2 == null) {
                if (z2) {
                    ((C14674iI6) charSequence).d();
                }
                return charSequence;
            }
            Spannable spannableB = nVar2.b();
            if (z2) {
                ((C14674iI6) charSequence).d();
            }
            return spannableB;
        }
        return charSequence;
    }
}
