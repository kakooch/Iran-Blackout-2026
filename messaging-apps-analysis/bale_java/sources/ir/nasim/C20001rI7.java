package ir.nasim;

import ir.nasim.InterfaceC24357yU3;
import ir.nasim.core.markdown.mention.MentionSpans;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.rI7, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C20001rI7 extends AbstractC16876m1 {
    public static final a b = new a(null);
    public static final int c = 8;
    private static final Pattern d = Pattern.compile("^" + Pattern.quote("uid:") + "(\\d+)$");
    private final X34 a;

    /* renamed from: ir.nasim.rI7$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.rI7$b */
    static final class b implements InterfaceC24357yU3.c {
        b() {
        }

        @Override // ir.nasim.InterfaceC24357yU3.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void a(InterfaceC24357yU3 interfaceC24357yU3, C9452Zz3 c9452Zz3) {
            Integer numO;
            AbstractC13042fc3.i(interfaceC24357yU3, "visitor");
            AbstractC13042fc3.i(c9452Zz3, "link");
            String strM = c9452Zz3.m();
            C15272jI6 c15272jI6M = interfaceC24357yU3.m();
            AbstractC13042fc3.h(c15272jI6M, "builder(...)");
            int length = c15272jI6M.length();
            interfaceC24357yU3.q(c9452Zz3);
            int length2 = c15272jI6M.length();
            if (strM != null && AbstractC20153rZ6.S(strM, "uid:", false, 2, null)) {
                Matcher matcher = C20001rI7.d.matcher(strM);
                if (matcher.matches()) {
                    String strGroup = matcher.group(1);
                    C15272jI6.k(c15272jI6M, new MentionSpans("", X34.b(C20001rI7.this.a, null, false, 1, null), (strGroup == null || (numO = AbstractC19562qZ6.o(strGroup)) == null) ? 0 : numO.intValue()), length, length2);
                    return;
                }
            }
            AbstractC7392Rn1.e.d(interfaceC24357yU3.o(), strM);
            interfaceC24357yU3.p(c9452Zz3, length);
        }
    }

    public C20001rI7(X34 x34) {
        AbstractC13042fc3.i(x34, "mentionData");
        this.a = x34;
    }

    @Override // ir.nasim.AbstractC16876m1, ir.nasim.InterfaceC21991uU3
    public void i(InterfaceC24357yU3.b bVar) {
        AbstractC13042fc3.i(bVar, "builder");
        bVar.a(C9452Zz3.class, new b());
    }
}
