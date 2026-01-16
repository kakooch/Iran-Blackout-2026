package ir.nasim;

import android.gov.nist.javax.sip.header.extensions.ReferencesHeader;
import ir.nasim.C9475a16;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* renamed from: ir.nasim.zJ6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24855zJ6 implements Interceptor {
    private static final a b = new a(null);
    private final InterfaceC7720Sx5 a;

    /* renamed from: ir.nasim.zJ6$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C24855zJ6(InterfaceC7720Sx5 interfaceC7720Sx5) {
        AbstractC13042fc3.i(interfaceC7720Sx5, "securityModuleProvider");
        this.a = interfaceC7720Sx5;
    }

    private final void a() {
        Object objB;
        try {
            C9475a16.a aVar = C9475a16.b;
            objB = C9475a16.b((InterfaceC15524jj6) this.a.get());
        } catch (Throwable th) {
            C9475a16.a aVar2 = C9475a16.b;
            objB = C9475a16.b(AbstractC10685c16.a(th));
        }
        if (C9475a16.g(objB)) {
            objB = null;
        }
        InterfaceC15524jj6 interfaceC15524jj6 = (InterfaceC15524jj6) objB;
        if (interfaceC15524jj6 != null) {
            interfaceC15524jj6.n();
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws SSLHandshakeException {
        AbstractC13042fc3.i(chain, ReferencesHeader.CHAIN);
        try {
            return chain.proceed(chain.request());
        } catch (SSLHandshakeException e) {
            if (e.getCause() instanceof CertificateException) {
                a();
                C19406qI3.d("SPChecker", e);
            }
            throw e;
        }
    }
}
