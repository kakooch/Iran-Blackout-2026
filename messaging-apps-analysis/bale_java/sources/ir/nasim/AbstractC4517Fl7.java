package ir.nasim;

import java.util.Locale;

/* renamed from: ir.nasim.Fl7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC4517Fl7 {
    public static final InterfaceC4283El7 a = new e(null, false);
    public static final InterfaceC4283El7 b = new e(null, true);
    public static final InterfaceC4283El7 c;
    public static final InterfaceC4283El7 d;
    public static final InterfaceC4283El7 e;
    public static final InterfaceC4283El7 f;

    /* renamed from: ir.nasim.Fl7$a */
    private static class a implements c {
        static final a b = new a(true);
        private final boolean a;

        private a(boolean z) {
            this.a = z;
        }

        @Override // ir.nasim.AbstractC4517Fl7.c
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                int iA = AbstractC4517Fl7.a(Character.getDirectionality(charSequence.charAt(i)));
                if (iA != 0) {
                    if (iA != 1) {
                        continue;
                        i++;
                        z = z;
                    } else if (!this.a) {
                        return 1;
                    }
                } else if (this.a) {
                    return 0;
                }
                z = true;
                i++;
                z = z;
            }
            if (z) {
                return this.a ? 1 : 0;
            }
            return 2;
        }
    }

    /* renamed from: ir.nasim.Fl7$b */
    private static class b implements c {
        static final b a = new b();

        private b() {
        }

        @Override // ir.nasim.AbstractC4517Fl7.c
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int iB = 2;
            while (i < i3 && iB == 2) {
                iB = AbstractC4517Fl7.b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return iB;
        }
    }

    /* renamed from: ir.nasim.Fl7$c */
    private interface c {
        int a(CharSequence charSequence, int i, int i2);
    }

    /* renamed from: ir.nasim.Fl7$d */
    private static abstract class d implements InterfaceC4283El7 {
        private final c a;

        d(c cVar) {
            this.a = cVar;
        }

        private boolean c(CharSequence charSequence, int i, int i2) {
            int iA = this.a.a(charSequence, i, i2);
            if (iA == 0) {
                return true;
            }
            if (iA != 1) {
                return b();
            }
            return false;
        }

        @Override // ir.nasim.InterfaceC4283El7
        public boolean a(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            }
            return this.a == null ? b() : c(charSequence, i, i2);
        }

        protected abstract boolean b();
    }

    /* renamed from: ir.nasim.Fl7$e */
    private static class e extends d {
        private final boolean b;

        e(c cVar, boolean z) {
            super(cVar);
            this.b = z;
        }

        @Override // ir.nasim.AbstractC4517Fl7.d
        protected boolean b() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.Fl7$f */
    private static class f extends d {
        static final f b = new f();

        f() {
            super(null);
        }

        @Override // ir.nasim.AbstractC4517Fl7.d
        protected boolean b() {
            return AbstractC14985io7.a(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.a;
        c = new e(bVar, false);
        d = new e(bVar, true);
        e = new e(a.b, false);
        f = f.b;
    }

    static int a(int i) {
        if (i != 0) {
            return (i == 1 || i == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return 0;
            }
            switch (i) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
