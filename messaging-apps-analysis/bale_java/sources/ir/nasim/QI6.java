package ir.nasim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class QI6 {
    private final AbstractC10243bK0 a;
    private final boolean b;
    private final c c;
    private final int d;

    class a implements c {
        final /* synthetic */ AbstractC10243bK0 a;

        /* renamed from: ir.nasim.QI6$a$a, reason: collision with other inner class name */
        class C0591a extends b {
            C0591a(QI6 qi6, CharSequence charSequence) {
                super(qi6, charSequence);
            }

            @Override // ir.nasim.QI6.b
            int e(int i) {
                return i + 1;
            }

            @Override // ir.nasim.QI6.b
            int f(int i) {
                return a.this.a.c(this.c, i);
            }
        }

        a(AbstractC10243bK0 abstractC10243bK0) {
            this.a = abstractC10243bK0;
        }

        @Override // ir.nasim.QI6.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(QI6 qi6, CharSequence charSequence) {
            return new C0591a(qi6, charSequence);
        }
    }

    private static abstract class b extends W0 {
        final CharSequence c;
        final AbstractC10243bK0 d;
        final boolean e;
        int f = 0;
        int g;

        protected b(QI6 qi6, CharSequence charSequence) {
            this.d = qi6.a;
            this.e = qi6.b;
            this.g = qi6.d;
            this.c = charSequence;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ir.nasim.W0
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a() {
            int iF;
            int i = this.f;
            while (true) {
                int i2 = this.f;
                if (i2 == -1) {
                    return (String) b();
                }
                iF = f(i2);
                if (iF == -1) {
                    iF = this.c.length();
                    this.f = -1;
                } else {
                    this.f = e(iF);
                }
                int i3 = this.f;
                if (i3 == i) {
                    int i4 = i3 + 1;
                    this.f = i4;
                    if (i4 > this.c.length()) {
                        this.f = -1;
                    }
                } else {
                    while (i < iF && this.d.e(this.c.charAt(i))) {
                        i++;
                    }
                    while (iF > i && this.d.e(this.c.charAt(iF - 1))) {
                        iF--;
                    }
                    if (!this.e || i != iF) {
                        break;
                    }
                    i = this.f;
                }
            }
            int i5 = this.g;
            if (i5 == 1) {
                iF = this.c.length();
                this.f = -1;
                while (iF > i && this.d.e(this.c.charAt(iF - 1))) {
                    iF--;
                }
            } else {
                this.g = i5 - 1;
            }
            return this.c.subSequence(i, iF).toString();
        }

        abstract int e(int i);

        abstract int f(int i);
    }

    private interface c {
        Iterator a(QI6 qi6, CharSequence charSequence);
    }

    private QI6(c cVar) {
        this(cVar, false, AbstractC10243bK0.f(), Integer.MAX_VALUE);
    }

    public static QI6 d(char c2) {
        return e(AbstractC10243bK0.d(c2));
    }

    public static QI6 e(AbstractC10243bK0 abstractC10243bK0) {
        AbstractC4029Dj5.j(abstractC10243bK0);
        return new QI6(new a(abstractC10243bK0));
    }

    private Iterator g(CharSequence charSequence) {
        return this.c.a(this, charSequence);
    }

    public List f(CharSequence charSequence) {
        AbstractC4029Dj5.j(charSequence);
        Iterator itG = g(charSequence);
        ArrayList arrayList = new ArrayList();
        while (itG.hasNext()) {
            arrayList.add((String) itG.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    private QI6(c cVar, boolean z, AbstractC10243bK0 abstractC10243bK0, int i) {
        this.c = cVar;
        this.b = z;
        this.a = abstractC10243bK0;
        this.d = i;
    }
}
