package ir.nasim;

import android.gov.nist.javax.sip.parser.TokenNames;
import ir.nasim.C9475a16;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class UQ {
    public static final a a;
    public static final UQ b = new UQ("TAB_DEFAULT", 0);
    public static final UQ c = new UQ("AUTH_START", 1);
    public static final UQ d = new UQ("AUTH_PHONE", 2);
    public static final UQ e = new UQ("SIGN_UP", 3);
    public static final UQ f = new UQ("LOGGED_IN", 4);
    public static final UQ g = new UQ(TokenNames.INVITE, 5);
    public static final UQ h = new UQ("INVITE_CODE", 6);
    public static final UQ i = new UQ("SKIP_INVITE", 7);
    private static final /* synthetic */ UQ[] j;
    private static final /* synthetic */ F92 k;

    public static final class a {
        private a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final UQ a(String str, UQ uq) {
            UQ uqB;
            AbstractC13042fc3.i(uq, "defaultValue");
            try {
                C9475a16.a aVar = C9475a16.b;
                if (str == null) {
                    str = "";
                }
                uqB = C9475a16.b(UQ.valueOf(str));
            } catch (Throwable th) {
                C9475a16.a aVar2 = C9475a16.b;
                uqB = C9475a16.b(AbstractC10685c16.a(th));
            }
            if (!C9475a16.g(uqB)) {
                uq = uqB;
            }
            return uq;
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static {
        UQ[] uqArrA = a();
        j = uqArrA;
        k = G92.a(uqArrA);
        a = new a(null);
    }

    private UQ(String str, int i2) {
    }

    private static final /* synthetic */ UQ[] a() {
        return new UQ[]{b, c, d, e, f, g, h, i};
    }

    public static UQ valueOf(String str) {
        return (UQ) Enum.valueOf(UQ.class, str);
    }

    public static UQ[] values() {
        return (UQ[]) j.clone();
    }
}
