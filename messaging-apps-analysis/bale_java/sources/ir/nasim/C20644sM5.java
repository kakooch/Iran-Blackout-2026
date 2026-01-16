package ir.nasim;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.sM5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C20644sM5 implements Serializable {
    public static final a b = new a(null);
    private final Pattern a;

    /* renamed from: ir.nasim.sM5$a */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b(int i) {
            return (i & 2) != 0 ? i | 64 : i;
        }

        public final String c(String str) {
            AbstractC13042fc3.i(str, "literal");
            String strQuote = Pattern.quote(str);
            AbstractC13042fc3.h(strQuote, "quote(...)");
            return strQuote;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.sM5$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ CharSequence f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(CharSequence charSequence, int i) {
            super(0);
            this.f = charSequence;
            this.g = i;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final OU3 invoke() {
            return C20644sM5.this.b(this.f, this.g);
        }
    }

    /* renamed from: ir.nasim.sM5$c */
    /* synthetic */ class c extends EB2 implements UA2 {
        public static final c a = new c();

        c() {
            super(1, OU3.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // ir.nasim.UA2
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public final OU3 invoke(OU3 ou3) {
            AbstractC13042fc3.i(ou3, "p0");
            return ou3.next();
        }
    }

    public C20644sM5(Pattern pattern) {
        AbstractC13042fc3.i(pattern, "nativePattern");
        this.a = pattern;
    }

    public static /* synthetic */ OU3 c(C20644sM5 c20644sM5, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return c20644sM5.b(charSequence, i);
    }

    public static /* synthetic */ InterfaceC23384wp6 e(C20644sM5 c20644sM5, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return c20644sM5.d(charSequence, i);
    }

    public final boolean a(CharSequence charSequence) {
        AbstractC13042fc3.i(charSequence, "input");
        return this.a.matcher(charSequence).find();
    }

    public final OU3 b(CharSequence charSequence, int i) {
        AbstractC13042fc3.i(charSequence, "input");
        Matcher matcher = this.a.matcher(charSequence);
        AbstractC13042fc3.h(matcher, "matcher(...)");
        return AbstractC22511vM5.e(matcher, i, charSequence);
    }

    public final InterfaceC23384wp6 d(CharSequence charSequence, int i) {
        AbstractC13042fc3.i(charSequence, "input");
        if (i >= 0 && i <= charSequence.length()) {
            return AbstractC9962aq6.i(new b(charSequence, i), c.a);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i + ", input length: " + charSequence.length());
    }

    public final OU3 f(CharSequence charSequence) {
        AbstractC13042fc3.i(charSequence, "input");
        Matcher matcher = this.a.matcher(charSequence);
        AbstractC13042fc3.h(matcher, "matcher(...)");
        return AbstractC22511vM5.f(matcher, charSequence);
    }

    public final boolean g(CharSequence charSequence) {
        AbstractC13042fc3.i(charSequence, "input");
        return this.a.matcher(charSequence).matches();
    }

    public final String j(CharSequence charSequence, UA2 ua2) {
        AbstractC13042fc3.i(charSequence, "input");
        AbstractC13042fc3.i(ua2, "transform");
        int iIntValue = 0;
        OU3 ou3C = c(this, charSequence, 0, 2, null);
        if (ou3C == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(charSequence, iIntValue, ou3C.c().f().intValue());
            sb.append((CharSequence) ua2.invoke(ou3C));
            iIntValue = ou3C.c().j().intValue() + 1;
            ou3C = ou3C.next();
            if (iIntValue >= length) {
                break;
            }
        } while (ou3C != null);
        if (iIntValue < length) {
            sb.append(charSequence, iIntValue, length);
        }
        String string = sb.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    public final String k(CharSequence charSequence, String str) {
        AbstractC13042fc3.i(charSequence, "input");
        AbstractC13042fc3.i(str, "replacement");
        String strReplaceAll = this.a.matcher(charSequence).replaceAll(str);
        AbstractC13042fc3.h(strReplaceAll, "replaceAll(...)");
        return strReplaceAll;
    }

    public final String l(CharSequence charSequence, String str) {
        AbstractC13042fc3.i(charSequence, "input");
        AbstractC13042fc3.i(str, "replacement");
        String strReplaceFirst = this.a.matcher(charSequence).replaceFirst(str);
        AbstractC13042fc3.h(strReplaceFirst, "replaceFirst(...)");
        return strReplaceFirst;
    }

    public final List m(CharSequence charSequence, int i) {
        AbstractC13042fc3.i(charSequence, "input");
        AbstractC20762sZ6.I0(i);
        Matcher matcher = this.a.matcher(charSequence);
        if (i == 1 || !matcher.find()) {
            return AbstractC9766aX0.e(charSequence.toString());
        }
        ArrayList arrayList = new ArrayList(i > 0 ? AbstractC23053wG5.i(i, 10) : 10);
        int i2 = i - 1;
        int iEnd = 0;
        do {
            arrayList.add(charSequence.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
            if (i2 >= 0 && arrayList.size() == i2) {
                break;
            }
        } while (matcher.find());
        arrayList.add(charSequence.subSequence(iEnd, charSequence.length()).toString());
        return arrayList;
    }

    public String toString() {
        String string = this.a.toString();
        AbstractC13042fc3.h(string, "toString(...)");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C20644sM5(String str) {
        AbstractC13042fc3.i(str, "pattern");
        Pattern patternCompile = Pattern.compile(str);
        AbstractC13042fc3.h(patternCompile, "compile(...)");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C20644sM5(String str, EnumC23107wM5 enumC23107wM5) {
        AbstractC13042fc3.i(str, "pattern");
        AbstractC13042fc3.i(enumC23107wM5, "option");
        Pattern patternCompile = Pattern.compile(str, b.b(enumC23107wM5.j()));
        AbstractC13042fc3.h(patternCompile, "compile(...)");
        this(patternCompile);
    }
}
