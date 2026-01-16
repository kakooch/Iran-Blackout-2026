package ir.nasim;

import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.Mi0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C6135Mi0 extends AbstractC12750f83 {
    public static final a f = new a(null);
    public static final int g = 8;
    private static final Pattern h;
    private final C5668Ki0 e;

    /* renamed from: ir.nasim.Mi0$a */
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
    }

    public C6135Mi0(C5668Ki0 c5668Ki0) {
        AbstractC13042fc3.i(c5668Ki0, "botData");
        this.e = c5668Ki0;
    }

    @Override // ir.nasim.AbstractC12750f83
    protected TA4 e() {
        String strD;
        if (this.e.a() != ExPeerType.BOT && this.e.a() != ExPeerType.GROUP) {
            return null;
        }
        String str = this.c;
        AbstractC13042fc3.h(str, "input");
        Character chT1 = AbstractC22039uZ6.t1(str, this.d - 1);
        String str2 = this.c;
        AbstractC13042fc3.h(str2, "input");
        Character chT12 = AbstractC22039uZ6.t1(str2, this.d + 1);
        if ((chT1 != null && !AbstractC10868cL0.d(chT1.charValue())) || ((chT12 != null && AbstractC10868cL0.d(chT12.charValue())) || ((chT12 != null && chT12.charValue() == '/') || (strD = d(h)) == null))) {
            return null;
        }
        String str3 = this.c;
        AbstractC13042fc3.h(str3, "input");
        Character chT13 = AbstractC22039uZ6.t1(str3, this.d);
        if (chT13 != null && chT13.charValue() == '/') {
            return null;
        }
        return new C11266cj0(strD, this.e);
    }

    @Override // ir.nasim.AbstractC12750f83
    public char m() {
        return '/';
    }
}
