package ir.nasim;

import ir.nasim.R82;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class P82 {
    public static final P82 b = new P82(new R82.a());
    public static final P82 c = new P82(new R82.e());
    public static final P82 d = new P82(new R82.g());
    public static final P82 e = new P82(new R82.f());
    public static final P82 f = new P82(new R82.b());
    public static final P82 g = new P82(new R82.d());
    public static final P82 h = new P82(new R82.c());
    private final e a;

    private static class b implements e {
        private final R82 a;

        @Override // ir.nasim.P82.e
        public Object a(String str) {
            Iterator it = P82.b("GmsCore_OpenSSL", "AndroidOpenSSL").iterator();
            Exception exc = null;
            while (it.hasNext()) {
                try {
                    return this.a.a(str, (Provider) it.next());
                } catch (Exception e) {
                    if (exc == null) {
                        exc = e;
                    }
                }
            }
            return this.a.a(str, null);
        }

        private b(R82 r82) {
            this.a = r82;
        }
    }

    private static class c implements e {
        private final R82 a;

        @Override // ir.nasim.P82.e
        public Object a(String str) {
            return this.a.a(str, null);
        }

        private c(R82 r82) {
            this.a = r82;
        }
    }

    private static class d implements e {
        private final R82 a;

        @Override // ir.nasim.P82.e
        public Object a(String str) throws GeneralSecurityException {
            Iterator it = P82.b("GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt").iterator();
            Exception exc = null;
            while (it.hasNext()) {
                try {
                    return this.a.a(str, (Provider) it.next());
                } catch (Exception e) {
                    if (exc == null) {
                        exc = e;
                    }
                }
            }
            throw new GeneralSecurityException("No good Provider found.", exc);
        }

        private d(R82 r82) {
            this.a = r82;
        }
    }

    private interface e {
        Object a(String str);
    }

    public P82(R82 r82) {
        if (AbstractC5747Kq7.c()) {
            this.a = new d(r82);
        } else if (E07.a()) {
            this.a = new b(r82);
        } else {
            this.a = new c(r82);
        }
    }

    public static List b(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            }
        }
        return arrayList;
    }

    public Object a(String str) {
        return this.a.a(str);
    }
}
