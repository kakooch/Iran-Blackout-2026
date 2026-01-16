package ir.nasim;

import ir.nasim.N88;
import java.net.URL;

/* loaded from: classes5.dex */
public final class N88 extends Z6 {
    public static final a b = new a(null);

    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final K6 c(C9057Yh4 c9057Yh4) {
            AbstractC13042fc3.i(c9057Yh4, "$context");
            return new L88(c9057Yh4);
        }

        public final C9528a7 b(final C9057Yh4 c9057Yh4) {
            AbstractC13042fc3.i(c9057Yh4, "context");
            C9528a7 c9528a7E = C12736f7.n().e("webview/router", new V6() { // from class: ir.nasim.M88
                @Override // ir.nasim.V6
                public final K6 create() {
                    return N88.a.c(c9057Yh4);
                }
            }, true);
            AbstractC13042fc3.h(c9528a7E, "actorOf(...)");
            return c9528a7E;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N88(C9057Yh4 c9057Yh4) {
        super(b.b(c9057Yh4));
        AbstractC13042fc3.i(c9057Yh4, "context");
    }

    public final void j(String str) {
        AbstractC13042fc3.i(str, "url");
        URL url = new URL(str);
        String str2 = url.getProtocol() + "://" + url.getHost();
        if (url.getPort() != 80 && url.getPort() != 443) {
            str2 = str2 + ":" + url.getPort();
        }
        i(new C19444qM5(str2));
    }
}
