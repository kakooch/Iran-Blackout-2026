package ir.nasim;

/* renamed from: ir.nasim.bK0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC10243bK0 implements InterfaceC11281ck5 {

    /* renamed from: ir.nasim.bK0$a */
    static abstract class a extends AbstractC10243bK0 {
        a() {
        }

        @Override // ir.nasim.InterfaceC11281ck5
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.b((Character) obj);
        }
    }

    /* renamed from: ir.nasim.bK0$b */
    private static final class b extends a {
        private final char a;

        b(char c) {
            this.a = c;
        }

        @Override // ir.nasim.AbstractC10243bK0
        public boolean e(char c) {
            return c == this.a;
        }

        public String toString() {
            String strG = AbstractC10243bK0.g(this.a);
            StringBuilder sb = new StringBuilder(String.valueOf(strG).length() + 18);
            sb.append("CharMatcher.is('");
            sb.append(strG);
            sb.append("')");
            return sb.toString();
        }
    }

    /* renamed from: ir.nasim.bK0$c */
    static abstract class c extends a {
        private final String a;

        c(String str) {
            this.a = (String) AbstractC4029Dj5.j(str);
        }

        public final String toString() {
            return this.a;
        }
    }

    /* renamed from: ir.nasim.bK0$d */
    private static final class d extends c {
        static final d b = new d();

        private d() {
            super("CharMatcher.none()");
        }

        @Override // ir.nasim.AbstractC10243bK0
        public int c(CharSequence charSequence, int i) {
            AbstractC4029Dj5.l(i, charSequence.length());
            return -1;
        }

        @Override // ir.nasim.AbstractC10243bK0
        public boolean e(char c) {
            return false;
        }
    }

    protected AbstractC10243bK0() {
    }

    public static AbstractC10243bK0 d(char c2) {
        return new b(c2);
    }

    public static AbstractC10243bK0 f() {
        return d.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(char c2) {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public boolean b(Character ch) {
        return e(ch.charValue());
    }

    public int c(CharSequence charSequence, int i) {
        int length = charSequence.length();
        AbstractC4029Dj5.l(i, length);
        while (i < length) {
            if (e(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public abstract boolean e(char c2);
}
