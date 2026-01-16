package ir.nasim;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.xU2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C23766xU2 extends AbstractC12750f83 {
    public static final a e = new a(null);
    private static final Pattern f;
    private static final Pattern g;

    /* renamed from: ir.nasim.xU2$a */
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
        f = patternCompile;
        Pattern patternCompile2 = Pattern.compile("\\n?#\\w+");
        AbstractC13042fc3.h(patternCompile2, "compile(...)");
        g = patternCompile2;
    }

    private final boolean q() {
        Pattern patternCompile = Pattern.compile("((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))))(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");
        String str = this.c;
        AbstractC13042fc3.h(str, "input");
        String strSubstring = str.substring(0, this.d + 1);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        Matcher matcher = patternCompile.matcher(strSubstring);
        String strGroup = null;
        while (matcher.find()) {
            strGroup = matcher.group();
        }
        if (strGroup == null) {
            return false;
        }
        String str2 = this.c;
        AbstractC13042fc3.h(str2, "input");
        return (AbstractC20762sZ6.r0(str2, strGroup, 0, false, 6, null) + strGroup.length()) - 1 == this.d;
    }

    @Override // ir.nasim.AbstractC12750f83
    protected TA4 e() {
        String strD;
        if (q()) {
            return null;
        }
        Pattern pattern = g;
        String str = this.c;
        AbstractC13042fc3.h(str, "input");
        String strSubstring = str.substring(this.d);
        AbstractC13042fc3.h(strSubstring, "substring(...)");
        if (pattern.matcher(strSubstring).lookingAt() && (strD = d(f)) != null) {
            return new C24356yU2(strD);
        }
        return null;
    }

    @Override // ir.nasim.AbstractC12750f83
    public char m() {
        return '#';
    }
}
