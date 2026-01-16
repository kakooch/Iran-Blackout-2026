package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9475a16;
import ir.nasim.EX1;
import ir.nasim.MY1;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* renamed from: ir.nasim.nN5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C17680nN5 implements InterfaceC17089mN5 {
    private static final a g = new a(null);
    private final InterfaceC16847ly a;
    private final AbstractC13778go1 b;
    private final InterfaceC16443lH4 c;
    private final InterfaceC14123hO3 d;
    private final InterfaceC14123hO3 e;
    private final InterfaceC14123hO3 f;

    /* renamed from: ir.nasim.nN5$a */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.nN5$b */
    static final class b implements UA2 {
        final /* synthetic */ Call a;

        b(Call call) {
            this.a = call;
        }

        public final void a(Throwable th) {
            if (this.a.getCanceled()) {
                return;
            }
            this.a.cancel();
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.nN5$c */
    public static final class c implements Callback {
        final /* synthetic */ HE0 a;
        final /* synthetic */ C17680nN5 b;

        c(HE0 he0, C17680nN5 c17680nN5) {
            this.a = he0;
            this.b = c17680nN5;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            AbstractC13042fc3.i(call, "call");
            AbstractC13042fc3.i(iOException, "e");
            if (this.a.b()) {
                EX1 dVar = (EX1) this.b.e.a(iOException);
                if (dVar == null) {
                    dVar = new EX1.b.d(iOException);
                }
                HE0 he0 = this.a;
                C9475a16.a aVar = C9475a16.b;
                he0.resumeWith(C9475a16.b(new MY1.a(dVar)));
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            byte[] bArrBytes;
            AbstractC13042fc3.i(call, "call");
            AbstractC13042fc3.i(response, "response");
            try {
                if (!this.a.b()) {
                    ResponseBody responseBodyBody = response.body();
                    if (responseBodyBody != null) {
                        responseBodyBody.close();
                        return;
                    }
                    return;
                }
                if (response.isSuccessful()) {
                    ResponseBody responseBodyBody2 = response.body();
                    if (responseBodyBody2 == null || (bArrBytes = responseBodyBody2.bytes()) == null) {
                        bArrBytes = new byte[0];
                    }
                    HE0 he0 = this.a;
                    C9475a16.a aVar = C9475a16.b;
                    he0.resumeWith(C9475a16.b(new MY1.b(bArrBytes)));
                } else {
                    EX1 ex1 = (EX1) this.b.d.a(Integer.valueOf(response.code()));
                    HE0 he02 = this.a;
                    C9475a16.a aVar2 = C9475a16.b;
                    he02.resumeWith(C9475a16.b(new MY1.a(ex1)));
                }
                ResponseBody responseBodyBody3 = response.body();
                if (responseBodyBody3 != null) {
                    responseBodyBody3.close();
                }
            } catch (Throwable th) {
                ResponseBody responseBodyBody4 = response.body();
                if (responseBodyBody4 != null) {
                    responseBodyBody4.close();
                }
                throw th;
            }
        }
    }

    /* renamed from: ir.nasim.nN5$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;
        final /* synthetic */ C17680nN5 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, int i, int i2, C17680nN5 c17680nN5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = str;
            this.d = i;
            this.e = i2;
            this.f = c17680nN5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                HttpUrl httpUrl = HttpUrl.INSTANCE.parse(this.c);
                if (httpUrl == null) {
                    return new MY1.a(EX1.c.d.b);
                }
                Request requestBuild = new Request.Builder().url(httpUrl).addHeader("Range", "bytes=" + this.d + "-" + this.e).build();
                C17680nN5 c17680nN5 = this.f;
                Call callA = c17680nN5.c.a(requestBuild);
                this.b = 1;
                obj = c17680nN5.g(callA, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.nN5$e */
    static final class e extends AbstractC22163um1 {
        Object a;
        /* synthetic */ Object b;
        int d;

        e(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= RecyclerView.UNDEFINED_DURATION;
            return C17680nN5.this.a(null, this);
        }
    }

    public C17680nN5(InterfaceC16847ly interfaceC16847ly, AbstractC13778go1 abstractC13778go1, InterfaceC16443lH4 interfaceC16443lH4, InterfaceC14123hO3 interfaceC14123hO3, InterfaceC14123hO3 interfaceC14123hO32, InterfaceC14123hO3 interfaceC14123hO33) {
        AbstractC13042fc3.i(interfaceC16847ly, "apiGateway");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        AbstractC13042fc3.i(interfaceC16443lH4, "okHttpCallProvider");
        AbstractC13042fc3.i(interfaceC14123hO3, "statusCodeToDownloadErrorMapper");
        AbstractC13042fc3.i(interfaceC14123hO32, "throwableToDownloadErrorMapper");
        AbstractC13042fc3.i(interfaceC14123hO33, "fileLocationToStructFileLocationMapper");
        this.a = interfaceC16847ly;
        this.b = abstractC13778go1;
        this.c = interfaceC16443lH4;
        this.d = interfaceC14123hO3;
        this.e = interfaceC14123hO32;
        this.f = interfaceC14123hO33;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object g(Call call, InterfaceC20295rm1 interfaceC20295rm1) {
        IE0 ie0 = new IE0(AbstractC14251hc3.c(interfaceC20295rm1), 1);
        ie0.w();
        call.enqueue(new c(ie0, this));
        ie0.J(new b(call));
        Object objT = ie0.t();
        if (objT == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objT;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // ir.nasim.InterfaceC17089mN5
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(ir.nasim.C4995Hl2 r10, ir.nasim.InterfaceC20295rm1 r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof ir.nasim.C17680nN5.e
            if (r0 == 0) goto L14
            r0 = r11
            ir.nasim.nN5$e r0 = (ir.nasim.C17680nN5.e) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.d = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            ir.nasim.nN5$e r0 = new ir.nasim.nN5$e
            r0.<init>(r11)
            goto L12
        L1a:
            java.lang.Object r11 = r6.b
            java.lang.Object r0 = ir.nasim.AbstractC13660gc3.e()
            int r1 = r6.d
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r10 = r6.a
            ir.nasim.nN5 r10 = (ir.nasim.C17680nN5) r10
            ir.nasim.AbstractC10685c16.b(r11)
            goto L77
        L2f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L37:
            ir.nasim.AbstractC10685c16.b(r11)
            ir.nasim.vx5 r11 = new ir.nasim.vx5
            ai.bale.proto.FilesOuterClass$RequestGetNasimFileUrl$a r1 = ai.bale.proto.FilesOuterClass$RequestGetNasimFileUrl.newBuilder()
            ir.nasim.hO3 r3 = r9.f
            java.lang.Object r10 = r3.a(r10)
            ai.bale.proto.FilesStruct$FileLocation r10 = (ai.bale.proto.FilesStruct$FileLocation) r10
            ai.bale.proto.FilesOuterClass$RequestGetNasimFileUrl$a r10 = r1.A(r10)
            com.google.protobuf.GeneratedMessageLite r10 = r10.a()
            java.lang.String r1 = "build(...)"
            ir.nasim.AbstractC13042fc3.h(r10, r1)
            ai.bale.proto.FilesOuterClass$ResponseGetNasimFileUrl r1 = ai.bale.proto.FilesOuterClass$ResponseGetNasimFileUrl.getDefaultInstance()
            java.lang.String r3 = "getDefaultInstance(...)"
            ir.nasim.AbstractC13042fc3.h(r1, r3)
            java.lang.String r3 = "/ai.bale.server.Files/GetNasimFileUrl"
            r11.<init>(r3, r10, r1)
            ir.nasim.ly r1 = r9.a
            r6.a = r9
            r6.d = r2
            r3 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r2 = r11
            java.lang.Object r11 = ir.nasim.InterfaceC16847ly.c(r1, r2, r3, r5, r6, r7, r8)
            if (r11 != r0) goto L76
            return r0
        L76:
            r10 = r9
        L77:
            ir.nasim.Z06 r11 = (ir.nasim.Z06) r11
            boolean r0 = r11 instanceof ir.nasim.Z06.b
            if (r0 == 0) goto L98
            ir.nasim.Z06$b r11 = (ir.nasim.Z06.b) r11
            com.google.protobuf.P r10 = r11.a()
            ai.bale.proto.FilesOuterClass$ResponseGetNasimFileUrl r10 = (ai.bale.proto.FilesOuterClass$ResponseGetNasimFileUrl) r10
            ai.bale.proto.FilesStruct$FileUrlDescription r10 = r10.getFileUrl()
            java.lang.String r10 = r10.getUrl()
            java.lang.String r11 = "getUrl(...)"
            ir.nasim.AbstractC13042fc3.h(r10, r11)
            ir.nasim.MY1$b r11 = new ir.nasim.MY1$b
            r11.<init>(r10)
            goto Lbb
        L98:
            boolean r0 = r11 instanceof ir.nasim.Z06.a
            if (r0 == 0) goto Lbc
            ir.nasim.MY1$a r0 = new ir.nasim.MY1$a
            ir.nasim.hO3 r10 = r10.e
            ir.nasim.Z06$a r11 = (ir.nasim.Z06.a) r11
            ir.nasim.core.network.RpcException r1 = r11.a()
            java.lang.Object r10 = r10.a(r1)
            ir.nasim.EX1 r10 = (ir.nasim.EX1) r10
            if (r10 != 0) goto Lb7
            ir.nasim.EX1$c$i r10 = new ir.nasim.EX1$c$i
            ir.nasim.core.network.RpcException r11 = r11.a()
            r10.<init>(r11)
        Lb7:
            r0.<init>(r10)
            r11 = r0
        Lbb:
            return r11
        Lbc:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C17680nN5.a(ir.nasim.Hl2, ir.nasim.rm1):java.lang.Object");
    }

    @Override // ir.nasim.InterfaceC17089mN5
    public Object b(String str, int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(this.b, new d(str, i, i2, this, null), interfaceC20295rm1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C17680nN5(InterfaceC16847ly interfaceC16847ly, InterfaceC16443lH4 interfaceC16443lH4, AbstractC13778go1 abstractC13778go1) {
        this(interfaceC16847ly, abstractC13778go1, interfaceC16443lH4, C20645sM6.a, C19131pp7.a, C5463Jl2.a);
        AbstractC13042fc3.i(interfaceC16847ly, "apiGateway");
        AbstractC13042fc3.i(interfaceC16443lH4, "okHttpCallProvider");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
    }
}
