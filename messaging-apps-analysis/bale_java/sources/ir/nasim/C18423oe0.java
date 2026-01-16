package ir.nasim;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* renamed from: ir.nasim.oe0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18423oe0 {
    static final InterfaceC4283El7 d;
    private static final String e;
    private static final String f;
    static final C18423oe0 g;
    static final C18423oe0 h;
    private final boolean a;
    private final int b;
    private final InterfaceC4283El7 c;

    /* renamed from: ir.nasim.oe0$b */
    private static class b {
        private static final byte[] f = new byte[1792];
        private final CharSequence a;
        private final boolean b;
        private final int c;
        private int d;
        private char e;

        static {
            for (int i = 0; i < 1792; i++) {
                f[i] = Character.getDirectionality(i);
            }
        }

        b(CharSequence charSequence, boolean z) {
            this.a = charSequence;
            this.b = z;
            this.c = charSequence.length();
        }

        private static byte c(char c) {
            return c < 1792 ? f[c] : Character.getDirectionality(c);
        }

        private byte f() {
            char cCharAt;
            int i = this.d;
            do {
                int i2 = this.d;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.a;
                int i3 = i2 - 1;
                this.d = i3;
                cCharAt = charSequence.charAt(i3);
                this.e = cCharAt;
                if (cCharAt == '&') {
                    return (byte) 12;
                }
            } while (cCharAt != ';');
            this.d = i;
            this.e = ';';
            return (byte) 13;
        }

        private byte g() {
            char cCharAt;
            do {
                int i = this.d;
                if (i >= this.c) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.a;
                this.d = i + 1;
                cCharAt = charSequence.charAt(i);
                this.e = cCharAt;
            } while (cCharAt != ';');
            return (byte) 12;
        }

        private byte h() {
            char cCharAt;
            int i = this.d;
            while (true) {
                int i2 = this.d;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.a;
                int i3 = i2 - 1;
                this.d = i3;
                char cCharAt2 = charSequence.charAt(i3);
                this.e = cCharAt2;
                if (cCharAt2 == '<') {
                    return (byte) 12;
                }
                if (cCharAt2 == '>') {
                    break;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i4 = this.d;
                        if (i4 > 0) {
                            CharSequence charSequence2 = this.a;
                            int i5 = i4 - 1;
                            this.d = i5;
                            cCharAt = charSequence2.charAt(i5);
                            this.e = cCharAt;
                        }
                    } while (cCharAt != cCharAt2);
                }
            }
            this.d = i;
            this.e = '>';
            return (byte) 13;
        }

        private byte i() {
            char cCharAt;
            int i = this.d;
            while (true) {
                int i2 = this.d;
                if (i2 >= this.c) {
                    this.d = i;
                    this.e = '<';
                    return (byte) 13;
                }
                CharSequence charSequence = this.a;
                this.d = i2 + 1;
                char cCharAt2 = charSequence.charAt(i2);
                this.e = cCharAt2;
                if (cCharAt2 == '>') {
                    return (byte) 12;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i3 = this.d;
                        if (i3 < this.c) {
                            CharSequence charSequence2 = this.a;
                            this.d = i3 + 1;
                            cCharAt = charSequence2.charAt(i3);
                            this.e = cCharAt;
                        }
                    } while (cCharAt != cCharAt2);
                }
            }
        }

        byte a() {
            char cCharAt = this.a.charAt(this.d - 1);
            this.e = cCharAt;
            if (Character.isLowSurrogate(cCharAt)) {
                int iCodePointBefore = Character.codePointBefore(this.a, this.d);
                this.d -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.d--;
            byte bC = c(this.e);
            if (!this.b) {
                return bC;
            }
            char c = this.e;
            return c == '>' ? h() : c == ';' ? f() : bC;
        }

        byte b() {
            char cCharAt = this.a.charAt(this.d);
            this.e = cCharAt;
            if (Character.isHighSurrogate(cCharAt)) {
                int iCodePointAt = Character.codePointAt(this.a, this.d);
                this.d += Character.charCount(iCodePointAt);
                return Character.getDirectionality(iCodePointAt);
            }
            this.d++;
            byte bC = c(this.e);
            if (!this.b) {
                return bC;
            }
            char c = this.e;
            return c == '<' ? i() : c == '&' ? g() : bC;
        }

        int d() {
            this.d = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.d < this.c && i == 0) {
                byte b = b();
                if (b != 0) {
                    if (b == 1 || b == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (b != 9) {
                        switch (b) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                continue;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                continue;
                            case 18:
                                i3--;
                                i2 = 0;
                                continue;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                }
                i = i3;
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i == i3) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i == i3) {
                            return 1;
                        }
                        break;
                    case 18:
                        i3++;
                        continue;
                }
                i3--;
            }
            return 0;
        }

        int e() {
            this.d = this.c;
            int i = 0;
            while (true) {
                int i2 = i;
                while (this.d > 0) {
                    byte bA = a();
                    if (bA != 0) {
                        if (bA == 1 || bA == 2) {
                            if (i == 0) {
                                return 1;
                            }
                            if (i2 == 0) {
                                break;
                            }
                        } else if (bA != 9) {
                            switch (bA) {
                                case 14:
                                case 15:
                                    if (i2 == i) {
                                        return -1;
                                    }
                                    i--;
                                    break;
                                case 16:
                                case 17:
                                    if (i2 == i) {
                                        return 1;
                                    }
                                    i--;
                                    break;
                                case 18:
                                    i++;
                                    break;
                                default:
                                    if (i2 != 0) {
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } else {
                            continue;
                        }
                    } else {
                        if (i == 0) {
                            return -1;
                        }
                        if (i2 == 0) {
                            break;
                        }
                    }
                }
                return 0;
            }
        }
    }

    static {
        InterfaceC4283El7 interfaceC4283El7 = AbstractC4517Fl7.c;
        d = interfaceC4283El7;
        e = Character.toString((char) 8206);
        f = Character.toString((char) 8207);
        g = new C18423oe0(false, 2, interfaceC4283El7);
        h = new C18423oe0(true, 2, interfaceC4283El7);
    }

    C18423oe0(boolean z, int i, InterfaceC4283El7 interfaceC4283El7) {
        this.a = z;
        this.b = i;
        this.c = interfaceC4283El7;
    }

    private static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static C18423oe0 c() {
        return new a().a();
    }

    public static C18423oe0 d(boolean z) {
        return new a(z).a();
    }

    static boolean f(Locale locale) {
        return AbstractC14985io7.a(locale) == 1;
    }

    private String g(CharSequence charSequence, InterfaceC4283El7 interfaceC4283El7) {
        boolean zA = interfaceC4283El7.a(charSequence, 0, charSequence.length());
        return (this.a || !(zA || b(charSequence) == 1)) ? this.a ? (!zA || b(charSequence) == -1) ? f : "" : "" : e;
    }

    private String h(CharSequence charSequence, InterfaceC4283El7 interfaceC4283El7) {
        boolean zA = interfaceC4283El7.a(charSequence, 0, charSequence.length());
        return (this.a || !(zA || a(charSequence) == 1)) ? this.a ? (!zA || a(charSequence) == -1) ? f : "" : "" : e;
    }

    public boolean e() {
        return (this.b & 2) != 0;
    }

    public CharSequence i(CharSequence charSequence) {
        return j(charSequence, this.c, true);
    }

    public CharSequence j(CharSequence charSequence, InterfaceC4283El7 interfaceC4283El7, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean zA = interfaceC4283El7.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (e() && z) {
            spannableStringBuilder.append((CharSequence) h(charSequence, zA ? AbstractC4517Fl7.b : AbstractC4517Fl7.a));
        }
        if (zA != this.a) {
            spannableStringBuilder.append(zA ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) g(charSequence, zA ? AbstractC4517Fl7.b : AbstractC4517Fl7.a));
        }
        return spannableStringBuilder;
    }

    public String k(String str) {
        return l(str, this.c, true);
    }

    public String l(String str, InterfaceC4283El7 interfaceC4283El7, boolean z) {
        if (str == null) {
            return null;
        }
        return j(str, interfaceC4283El7, z).toString();
    }

    /* renamed from: ir.nasim.oe0$a */
    public static final class a {
        private boolean a;
        private int b;
        private InterfaceC4283El7 c;

        public a() {
            c(C18423oe0.f(Locale.getDefault()));
        }

        private static C18423oe0 b(boolean z) {
            return z ? C18423oe0.h : C18423oe0.g;
        }

        private void c(boolean z) {
            this.a = z;
            this.c = C18423oe0.d;
            this.b = 2;
        }

        public C18423oe0 a() {
            return (this.b == 2 && this.c == C18423oe0.d) ? b(this.a) : new C18423oe0(this.a, this.b, this.c);
        }

        public a(boolean z) {
            c(z);
        }
    }
}
