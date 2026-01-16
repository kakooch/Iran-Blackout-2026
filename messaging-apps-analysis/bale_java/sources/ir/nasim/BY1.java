package ir.nasim;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* loaded from: classes6.dex */
public interface BY1 {
    public static final a a = a.a;

    public static final class a {
        static final /* synthetic */ a a = new a();

        /* renamed from: ir.nasim.BY1$a$a, reason: collision with other inner class name */
        /* synthetic */ class C0295a implements InterfaceC16443lH4, InterfaceC22409vB2 {
            final /* synthetic */ OkHttpClient a;

            C0295a(OkHttpClient okHttpClient) {
                this.a = okHttpClient;
            }

            @Override // ir.nasim.InterfaceC16443lH4
            public final Call a(Request request) {
                AbstractC13042fc3.i(request, "p0");
                return this.a.newCall(request);
            }

            @Override // ir.nasim.InterfaceC22409vB2
            public final InterfaceC18751pB2 b() {
                return new EB2(1, this.a, OkHttpClient.class, "newCall", "newCall(Lokhttp3/Request;)Lokhttp3/Call;", 0);
            }

            public final boolean equals(Object obj) {
                if ((obj instanceof InterfaceC16443lH4) && (obj instanceof InterfaceC22409vB2)) {
                    return AbstractC13042fc3.d(b(), ((InterfaceC22409vB2) obj).b());
                }
                return false;
            }

            public final int hashCode() {
                return b().hashCode();
            }
        }

        private a() {
        }

        public final InterfaceC16443lH4 a(OkHttpClient okHttpClient, AbstractC13778go1 abstractC13778go1) {
            AbstractC13042fc3.i(okHttpClient, "okHttpClient");
            AbstractC13042fc3.i(abstractC13778go1, "dispatcher");
            return new C0295a(okHttpClient);
        }
    }
}
