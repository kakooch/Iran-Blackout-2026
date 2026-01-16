package ir.nasim;

/* loaded from: classes5.dex */
public abstract class G15 {
    private static final C20035rM5 a;
    public static final C15 b;
    public static final C15 c;

    public static class a {
        public static final C15 a = G15.a.a("<(\"[^\"]*\"|'[^']*'|[^'\">])*>");
        public static final C15 b = G15.a.a("<a href\\s?=\\s?\"([^\"]+)\">");
        public static final C15 c = G15.a.a("<code(?![^>]+class).*?>|<code class\\s?=\\s?\"([^\"]+)\">");
        public static final C15 d = G15.a.a("<code(?![^>]+class).*?>|<code class\\s?=\\s?\"([^\"]+)\">|</code>");

        public static RU3 a(String str) {
            return G15.b(d, str);
        }

        public static RU3 b(String str) {
            return G15.b(b, str);
        }

        public static RU3 c(String str) {
            return G15.b(a, str);
        }
    }

    static {
        C20035rM5 c20035rM5 = new C20035rM5();
        a = c20035rM5;
        b = c20035rM5.a("((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?(?:(([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]([a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\-]{0,61}[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef]){0,1}\\.)+[a-zA-Z -\ud7ff豈-﷏ﷰ-\uffef]{2,63}|((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))))(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9 -\ud7ff豈-﷏ﷰ-\uffef\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");
        c = c20035rM5.a("^\\s*(0[0-9]|1[0-9]|2[0-3]|[0-9]):([0-5][0-9]|[0-9])\\s*,\\s*(0[0-9]|1[0-9]|2[0-3]|[0-9]):([0-5][0-9]|[0-9])\\s*$");
    }

    public static RU3 b(C15 c15, String str) {
        return c15.a(str);
    }

    public static boolean c(RU3 ru3) {
        return ru3.d() && ru3.a();
    }
}
