package ir.nasim;

import ir.nasim.C9475a16;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.internal.Util;

/* renamed from: ir.nasim.kH4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC15852kH4 {

    /* renamed from: ir.nasim.kH4$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Call e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Call call) {
            super(1);
            this.e = call;
        }

        public final void a(Throwable th) {
            this.e.cancel();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.kH4$b */
    public static final class b implements Callback {
        final /* synthetic */ HE0 a;

        /* renamed from: ir.nasim.kH4$b$a */
        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ Response e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Response response) {
                super(1);
                this.e = response;
            }

            public final void a(Throwable th) throws IOException {
                AbstractC13042fc3.i(th, "it");
                Util.closeQuietly(this.e);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) throws IOException {
                a((Throwable) obj);
                return C19938rB7.a;
            }
        }

        b(HE0 he0) {
            this.a = he0;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            AbstractC13042fc3.i(call, "call");
            AbstractC13042fc3.i(iOException, "e");
            HE0 he0 = this.a;
            C9475a16.a aVar = C9475a16.b;
            he0.resumeWith(C9475a16.b(AbstractC10685c16.a(iOException)));
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            AbstractC13042fc3.i(call, "call");
            AbstractC13042fc3.i(response, "response");
            this.a.N(response, new a(response));
        }
    }

    public static final Object a(Call call, InterfaceC20295rm1 interfaceC20295rm1) {
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        ie0.J(new a(call));
        call.enqueue(new b(ie0));
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT;
    }
}
