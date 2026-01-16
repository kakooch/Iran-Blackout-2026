package io.sentry.android.replay;

import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C11322co6;
import ir.nasim.InterfaceC14603iB2;

/* loaded from: classes3.dex */
public final class v {
    public static final v a = new v();
    private static final C11322co6 b = new C11322co6("SentryPrivacy", a.e);
    public static final int c = C11322co6.d;

    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(String str, String str2) {
            AbstractC13042fc3.i(str2, "<anonymous parameter 1>");
            return str;
        }
    }

    private v() {
    }

    public final C11322co6 a() {
        return b;
    }
}
