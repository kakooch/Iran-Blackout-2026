package ir.nasim;

import ir.nasim.core.markdown.card.BankCardSpan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class F40 extends AbstractC16876m1 {
    public static final a a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    @Override // ir.nasim.AbstractC16876m1, ir.nasim.InterfaceC21991uU3
    public void h(TA4 ta4, InterfaceC24357yU3 interfaceC24357yU3) {
        AbstractC13042fc3.i(ta4, "node");
        AbstractC13042fc3.i(interfaceC24357yU3, "visitor");
        C15272jI6 c15272jI6M = interfaceC24357yU3.m();
        AbstractC13042fc3.h(c15272jI6M, "builder(...)");
        Matcher matcher = Pattern.compile("\\b\\d{4}(?:[\\s-]?\\d{4}){3}\\b").matcher(c15272jI6M.n().toString());
        while (matcher.find()) {
            C20481s50 c20481s50 = C20481s50.a;
            String strGroup = matcher.group();
            AbstractC13042fc3.h(strGroup, "group(...)");
            if (c20481s50.g(strGroup)) {
                String strSubstring = XY6.k(matcher.group()).substring(0, 6);
                AbstractC13042fc3.h(strSubstring, "substring(...)");
                if (c20481s50.c(strSubstring) != null) {
                    int iStart = matcher.start();
                    int iStart2 = matcher.start() + matcher.group().length();
                    String strGroup2 = matcher.group();
                    AbstractC13042fc3.h(strGroup2, "group(...)");
                    c15272jI6M.j(new BankCardSpan(strGroup2), iStart, iStart2, 33);
                }
            }
        }
    }
}
