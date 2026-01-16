package ir.nasim;

import ai.bale.proto.CollectionsStruct$Int64Value;
import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.PushOuterClass$RequestRegisterPush;
import ai.bale.proto.PushOuterClass$RequestUnregisterGooglePush;
import ai.bale.proto.PushOuterClass$ResponseRegisterPush;
import ai.bale.proto.PushStruct$FirebaseRegister;
import ai.bale.proto.PushStruct$RegisterPush;
import android.content.SharedPreferences;
import android.util.Base64;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.protobuf.GeneratedMessageLite;
import ir.nasim.core.network.RpcException;
import ir.nasim.database.dailogLists.DialogEntity;

/* renamed from: ir.nasim.yy5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24650yy5 extends AbstractC6360Ng4 {
    public static final a o = new a(null);
    public static final int p = 8;
    private final C9057Yh4 m;
    private SharedPreferences n;

    /* renamed from: ir.nasim.yy5$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.yy5$b */
    public static final class b {
    }

    /* renamed from: ir.nasim.yy5$c */
    public static final class c {
        private final long a;
        private final String b;

        public c(long j, String str) {
            AbstractC13042fc3.i(str, "token");
            this.a = j;
            this.b = str;
        }

        public final long a() {
            return this.a;
        }

        public final String b() {
            return this.b;
        }
    }

    /* renamed from: ir.nasim.yy5$d */
    public static final class d implements InterfaceC15283jK {
        private final String a;

        public d(String str) {
            AbstractC13042fc3.i(str, "token");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }
    }

    public C24650yy5(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        this.m = c9057Yh4;
        b0("sequences_synced");
    }

    private final void i0() {
        if (!W().h("push.google", false) || W().h("push.google.registered", false)) {
            return;
        }
        long j = W().getLong("push.google.id", 0L);
        String string = W().getString("push.google.token", "");
        AbstractC13042fc3.f(string);
        j0(j, string);
    }

    private final void j0(long j, String str) {
        long jO = AbstractC20507s76.o() - C7183Qq.p().getLong("push_heartbeat_last_date", 0L);
        if (W().h("push.google", false) && W().h("push.google.registered", false) && AbstractC13042fc3.d(str, W().e("push.google.token")) && j == W().getLong("push.google.id", 0L)) {
            C9057Yh4 c9057Yh4 = this.m;
            AbstractC13042fc3.f(c9057Yh4);
            if (jO < c9057Yh4.S().F3()) {
                C19406qI3.a("PushManager", "[registerGooglePush] Ignored google push registration", new Object[0]);
                return;
            }
        }
        W().g("push.google", true);
        W().g("push.google.registered", false);
        W().putLong("push.google.id", j);
        W().putString("push.google.token", str);
        long jO2 = AbstractC20507s76.o();
        C9057Yh4 c9057Yh42 = this.m;
        AbstractC13042fc3.f(c9057Yh42);
        GeneratedMessageLite generatedMessageLiteA = PushOuterClass$RequestRegisterPush.newBuilder().B((PushStruct$RegisterPush) PushStruct$RegisterPush.newBuilder().A((PushStruct$FirebaseRegister) PushStruct$FirebaseRegister.newBuilder().B(false).D(str).C(j).A((CollectionsStruct$Int64Value) CollectionsStruct$Int64Value.newBuilder().A(jO2 + c9057Yh42.S().E3()).a()).a()).a()).A(1).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        PushOuterClass$ResponseRegisterPush defaultInstance = PushOuterClass$ResponseRegisterPush.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        M(new C22871vx5("/ai.bale.pushak.Push/RegisterPush", generatedMessageLiteA, defaultInstance), 16500L).m0(new InterfaceC24449ye1() { // from class: ir.nasim.ty5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C24650yy5.k0(this.a, (PushOuterClass$ResponseRegisterPush) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.uy5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C24650yy5.l0((Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(C24650yy5 c24650yy5, PushOuterClass$ResponseRegisterPush pushOuterClass$ResponseRegisterPush) {
        AbstractC13042fc3.i(c24650yy5, "this$0");
        C19406qI3.a("PushManager", "Firebase token was sent successfully", new Object[0]);
        c24650yy5.W().g("push.google.registered", true);
        c24650yy5.W().putLong("push_heartbeat_last_date", AbstractC20507s76.o());
        String strEncodeToString = Base64.encodeToString(pushOuterClass$ResponseRegisterPush.getEncryptionKey().a0(), 2);
        SharedPreferences sharedPreferences = c24650yy5.n;
        if (sharedPreferences == null) {
            AbstractC13042fc3.y("encryptedSharedPreferences");
            sharedPreferences = null;
        }
        sharedPreferences.edit().putString("push_encrypted_key", strEncodeToString).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(Exception exc) {
        C19406qI3.a("PushManager", "Firebase token register error: " + exc.getMessage(), new Object[0]);
        if ((exc instanceof RpcException) && AbstractC13042fc3.d(((RpcException) exc).getAndroid.gov.nist.javax.sip.header.ParameterNames.TAG java.lang.String(), "not registered")) {
            FirebaseMessaging.n().k();
        }
    }

    private final C6517Nv5 m0(String str) {
        W().remove("push.google");
        W().remove("push.google.registered");
        W().remove("push.google.id");
        W().remove("push.google.token");
        GeneratedMessageLite generatedMessageLiteA = PushOuterClass$RequestUnregisterGooglePush.newBuilder().A(str).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C6517Nv5 c6517Nv5E = L(new C22871vx5("/ai.bale.pushak.Push/UnregisterGooglePush", generatedMessageLiteA, defaultInstance)).h0(new InterfaceC17569nB2() { // from class: ir.nasim.vy5
            @Override // ir.nasim.InterfaceC17569nB2
            public final Object apply(Object obj) {
                return C24650yy5.n0((Misc$ResponseVoid) obj);
            }
        }).m0(new InterfaceC24449ye1() { // from class: ir.nasim.wy5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C24650yy5.o0(this.a, (C14505i18) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.xy5
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C24650yy5.p0((Exception) obj);
            }
        });
        AbstractC13042fc3.h(c6517Nv5E, "failure(...)");
        return c6517Nv5E;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C14505i18 n0(Misc$ResponseVoid misc$ResponseVoid) {
        return C14505i18.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(C24650yy5 c24650yy5, C14505i18 c14505i18) {
        AbstractC13042fc3.i(c24650yy5, "this$0");
        c24650yy5.W().g("push.google.registered", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(Exception exc) {
        AbstractC13042fc3.i(exc, "exception");
        C19406qI3.d("NON_FATAL_EXCEPTION", exc);
    }

    @Override // ir.nasim.AbstractC17647nK
    public C6517Nv5 G(Object obj) {
        if (obj instanceof d) {
            return m0(((d) obj).a());
        }
        C6517Nv5 c6517Nv5G = super.G(obj);
        AbstractC13042fc3.f(c6517Nv5G);
        return c6517Nv5G;
    }

    @Override // ir.nasim.AbstractC6360Ng4
    public void V() {
        r().d(new b());
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (obj instanceof b) {
            i0();
        } else if (!(obj instanceof c)) {
            super.m(obj);
        } else {
            c cVar = (c) obj;
            j0(cVar.a(), cVar.b());
        }
    }

    @Override // ir.nasim.K6
    public void o() {
        this.n = C21653tu1.b(((InterfaceC15767k82) C92.a(C5721Ko.a.d(), InterfaceC15767k82.class)).L0(), 0, 1, null);
    }
}
