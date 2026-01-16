package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.wG4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC23052wG4 {
    public Object[] a;
    public int b;

    /* renamed from: ir.nasim.wG4$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(Object obj) {
            return obj == AbstractC23052wG4.this ? "(this)" : String.valueOf(obj);
        }
    }

    public /* synthetic */ AbstractC23052wG4(int i, ED1 ed1) {
        this(i);
    }

    public static /* synthetic */ String j(AbstractC23052wG4 abstractC23052wG4, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, UA2 ua2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
        }
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
        return abstractC23052wG4.i(charSequence, charSequence5, charSequence6, i3, charSequence7, ua2);
    }

    public final boolean a(Object obj) {
        return f(obj) >= 0;
    }

    public final boolean b(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "elements");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            if (!a(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Object c() {
        if (g()) {
            AbstractC22970w76.d("ObjectList is empty.");
        }
        return this.a[0];
    }

    public final Object d(int i) {
        if (i < 0 || i >= this.b) {
            l(i);
        }
        return this.a[i];
    }

    public final int e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof AbstractC23052wG4) {
            AbstractC23052wG4 abstractC23052wG4 = (AbstractC23052wG4) obj;
            int i = abstractC23052wG4.b;
            int i2 = this.b;
            if (i == i2) {
                Object[] objArr = this.a;
                Object[] objArr2 = abstractC23052wG4.a;
                C24411ya3 c24411ya3Y = AbstractC23053wG5.y(0, i2);
                int iO = c24411ya3Y.o();
                int iT = c24411ya3Y.t();
                if (iO > iT) {
                    return true;
                }
                while (AbstractC13042fc3.d(objArr[iO], objArr2[iO])) {
                    if (iO == iT) {
                        return true;
                    }
                    iO++;
                }
                return false;
            }
        }
        return false;
    }

    public final int f(Object obj) {
        int i = 0;
        if (obj == null) {
            Object[] objArr = this.a;
            int i2 = this.b;
            while (i < i2) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        Object[] objArr2 = this.a;
        int i3 = this.b;
        while (i < i3) {
            if (obj.equals(objArr2[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public final boolean g() {
        return this.b == 0;
    }

    public final boolean h() {
        return this.b != 0;
    }

    public int hashCode() {
        Object[] objArr = this.a;
        int i = this.b;
        int iHashCode = 0;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = objArr[i2];
            iHashCode += (obj != null ? obj.hashCode() : 0) * 31;
        }
        return iHashCode;
    }

    public final String i(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, UA2 ua2) {
        AbstractC13042fc3.i(charSequence, "separator");
        AbstractC13042fc3.i(charSequence2, "prefix");
        AbstractC13042fc3.i(charSequence3, "postfix");
        AbstractC13042fc3.i(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        Object[] objArr = this.a;
        int i2 = this.b;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                sb.append(charSequence3);
                break;
            }
            Object obj = objArr[i3];
            if (i3 == i) {
                sb.append(charSequence4);
                break;
            }
            if (i3 != 0) {
                sb.append(charSequence);
            }
            if (ua2 == null) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) ua2.invoke(obj));
            }
            i3++;
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    public final int k(Object obj) {
        if (obj == null) {
            Object[] objArr = this.a;
            for (int i = this.b - 1; -1 < i; i--) {
                if (objArr[i] == null) {
                    return i;
                }
            }
        } else {
            Object[] objArr2 = this.a;
            for (int i2 = this.b - 1; -1 < i2; i2--) {
                if (obj.equals(objArr2[i2])) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public final void l(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("Index ");
        sb.append(i);
        sb.append(" must be in 0..");
        sb.append(this.b - 1);
        AbstractC22970w76.c(sb.toString());
    }

    public String toString() {
        return j(this, null, "[", "]", 0, null, new a(), 25, null);
    }

    private AbstractC23052wG4(int i) {
        this.a = i == 0 ? AbstractC23642xG4.a : new Object[i];
    }
}
