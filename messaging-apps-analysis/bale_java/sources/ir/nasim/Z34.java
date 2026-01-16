package ir.nasim;

import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class Z34 extends AbstractC12750f83 {
    public static final a f = new a(null);
    public static final int g = 8;
    private static final Pattern h;
    private static final Pattern i;
    private final X34 e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        Pattern patternCompile = Pattern.compile("\\w+");
        AbstractC13042fc3.h(patternCompile, "compile(...)");
        h = patternCompile;
        Pattern patternCompile2 = Pattern.compile("(?m)(?<!/)(?<![a-zA-Z0-9_.])@(?![a-zA-Z0-9_.]+@[a-zA-Z0-9_.])([0-9a-zA-Z_]{1,32}|[0-9]{2})");
        AbstractC13042fc3.h(patternCompile2, "compile(...)");
        i = patternCompile2;
    }

    public Z34(X34 x34) {
        AbstractC13042fc3.i(x34, "mentionData");
        this.e = x34;
    }

    @Override // ir.nasim.AbstractC12750f83
    protected TA4 e() {
        String strD;
        if (i.matcher(this.c).find() && (strD = d(h)) != null) {
            return new C9503a44(strD, this.e);
        }
        return null;
    }

    @Override // ir.nasim.AbstractC12750f83
    public char m() {
        return '@';
    }
}
