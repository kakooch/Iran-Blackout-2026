package ir.nasim.core.modules.settings;

import ai.bale.proto.ConfigsOuterClass$RequestEditParameter;
import ai.bale.proto.ConfigsOuterClass$RequestGetParameters;
import ai.bale.proto.ConfigsOuterClass$ResponseGetParameters;
import ai.bale.proto.ConfigsStruct$Parameter;
import ai.bale.proto.Misc$ResponseSeq;
import android.gov.nist.core.Separators;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13610gX0;
import ir.nasim.AbstractC20153rZ6;
import ir.nasim.AbstractC20507s76;
import ir.nasim.AbstractC20762sZ6;
import ir.nasim.AbstractC21784u76;
import ir.nasim.AbstractC6360Ng4;
import ir.nasim.C12228eF7;
import ir.nasim.C12889fL5;
import ir.nasim.C19406qI3;
import ir.nasim.C19791qw6;
import ir.nasim.C22871vx5;
import ir.nasim.C23453ww6;
import ir.nasim.C24043xw6;
import ir.nasim.C9057Yh4;
import ir.nasim.ED1;
import ir.nasim.InterfaceC24449ye1;
import ir.nasim.InterfaceC3570Bk5;
import ir.nasim.O66;
import ir.nasim.UA2;
import ir.nasim.core.network.RpcException;
import ir.nasim.database.dailogLists.DialogEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class a extends AbstractC6360Ng4 {
    public static final b p = new b(null);
    public static final int q = 8;
    private final C9057Yh4 m;
    private C23453ww6 n;
    private final List o;

    /* renamed from: ir.nasim.core.modules.settings.a$a, reason: collision with other inner class name */
    public static final class C0998a {
        private final String a;
        private final String b;

        public C0998a(String str, String str2) {
            AbstractC13042fc3.i(str, "key");
            AbstractC13042fc3.i(str2, "value");
            this.a = str;
            this.b = str2;
        }

        public final String a() {
            return this.a;
        }

        public final String b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0998a)) {
                return false;
            }
            C0998a c0998a = (C0998a) obj;
            return AbstractC13042fc3.d(this.a, c0998a.a) && AbstractC13042fc3.d(this.b, c0998a.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            return "ChangeSettings(key=" + this.a + ", value=" + this.b + Separators.RPAREN;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public static final class c implements O66 {
        final /* synthetic */ C12889fL5 a;
        final /* synthetic */ a b;
        final /* synthetic */ C19791qw6 c;

        c(C12889fL5 c12889fL5, a aVar, C19791qw6 c19791qw6) {
            this.a = c12889fL5;
            this.b = aVar;
            this.c = c19791qw6;
        }

        @Override // ir.nasim.O66
        public void b(RpcException rpcException) {
            AbstractC13042fc3.i(rpcException, "e");
            C12889fL5 c12889fL5 = this.a;
            if (((Long) c12889fL5.a) != null) {
                this.b.o.remove(c12889fL5.a);
            }
            C19406qI3.a("SettingsSyncActor", "EditParameter failure: " + rpcException.getIr.nasim.database.dailogLists.DialogEntity.COLUMN_MESSAGE java.lang.String(), new Object[0]);
        }

        @Override // ir.nasim.O66
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Misc$ResponseSeq misc$ResponseSeq) {
            AbstractC13042fc3.i(misc$ResponseSeq, "response");
            C12889fL5 c12889fL5 = this.a;
            if (((Long) c12889fL5.a) != null) {
                this.b.o.remove(c12889fL5.a);
            }
            C23453ww6 c23453ww6 = this.b.n;
            if (c23453ww6 == null) {
                AbstractC13042fc3.y("syncState");
                c23453ww6 = null;
            }
            c23453ww6.q().remove(this.c);
            this.b.q0();
            this.b.m.V().S(misc$ResponseSeq.getSeq(), misc$ResponseSeq.getState().a0(), new C12228eF7(this.c.getKey(), this.c.getValue()), 0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.m = c9057Yh4;
        this.o = new ArrayList();
        b0("sequences_synced");
    }

    private final void m0(final ConfigsOuterClass$ResponseGetParameters configsOuterClass$ResponseGetParameters) {
        SettingsModule settingsModuleS = this.m.S();
        String strG2 = settingsModuleS.G2();
        String strH2 = settingsModuleS.H2();
        final int i = 0;
        for (ConfigsStruct$Parameter configsStruct$Parameter : configsOuterClass$ResponseGetParameters.getParametersList()) {
            String key = configsStruct$Parameter.getKey();
            AbstractC13042fc3.f(key);
            if (!AbstractC20153rZ6.S(key, "category.web.", false, 2, null) && !AbstractC20153rZ6.S(key, "app.web.", false, 2, null) && !AbstractC20153rZ6.S(key, "category.ios.", false, 2, null) && !AbstractC20153rZ6.S(key, "app.ios.", false, 2, null) && !AbstractC20153rZ6.S(key, "category.desktop.", false, 2, null) && !AbstractC20153rZ6.S(key, "app.webdesktop.", false, 2, null) && ((!AbstractC20153rZ6.S(key, "category.", false, 2, null) || !AbstractC20153rZ6.C(key, ".current_version", false, 2, null) || AbstractC13042fc3.d(key, strG2)) && (!AbstractC20153rZ6.S(key, "category.", false, 2, null) || !AbstractC20153rZ6.C(key, ".last_version", false, 2, null) || AbstractC13042fc3.d(key, strH2)))) {
                if (AbstractC20153rZ6.S(key, "drafts_", false, 2, null)) {
                    if (configsStruct$Parameter.getValue() != null) {
                        String value = configsStruct$Parameter.getValue();
                        AbstractC13042fc3.h(value, "getValue(...)");
                        if (value.length() == 0) {
                        }
                    }
                }
                String key2 = configsStruct$Parameter.getKey();
                AbstractC13042fc3.h(key2, "getKey(...)");
                settingsModuleS.S5(key2, configsStruct$Parameter.getValue());
            }
            i++;
        }
        W().g("settings_sync_state_loaded_v2", true);
        C9057Yh4 c9057Yh4 = this.m;
        SettingsModule settingsModuleS2 = c9057Yh4.S();
        String strR = AbstractC20507s76.r();
        AbstractC13042fc3.h(strR, "getVersion(...)");
        settingsModuleS2.O7(strR);
        c9057Yh4.a().f(new C24043xw6());
        c9057Yh4.v().N();
        AbstractC21784u76.e(new Runnable() { // from class: ir.nasim.vw6
            @Override // java.lang.Runnable
            public final void run() {
                ir.nasim.core.modules.settings.a.n0(i, configsOuterClass$ResponseGetParameters);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(int i, ConfigsOuterClass$ResponseGetParameters configsOuterClass$ResponseGetParameters) {
        AbstractC13042fc3.i(configsOuterClass$ResponseGetParameters, "$responseGetParameters");
        C19406qI3.a("SettingsSyncActor", "Filter results on ResponseGetParameters (filtered: " + i + ", from: " + configsOuterClass$ResponseGetParameters.getParametersCount() + Separators.RPAREN, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o0(C19791qw6 c19791qw6, C19791qw6 c19791qw62) {
        AbstractC13042fc3.i(c19791qw6, "$action");
        AbstractC13042fc3.i(c19791qw62, "it");
        return AbstractC13042fc3.d(c19791qw62.getKey(), c19791qw6.getKey());
    }

    private final void p0(C19791qw6 c19791qw6) {
        C12889fL5 c12889fL5 = new C12889fL5();
        try {
            if (AbstractC20762sZ6.X(c19791qw6.getKey(), "drafts_", false, 2, null)) {
                String strSubstring = c19791qw6.getKey().substring(7);
                AbstractC13042fc3.h(strSubstring, "substring(...)");
                Long lValueOf = Long.valueOf(Long.parseLong(strSubstring));
                c12889fL5.a = lValueOf;
                if (this.o.contains(lValueOf)) {
                    Q(((Number) c12889fL5.a).longValue());
                } else {
                    this.o.add(c12889fL5.a);
                }
            }
        } catch (Exception e) {
            C19406qI3.c("SettingsSyncActor", "Unable to extract the peer id because ", e);
        }
        GeneratedMessageLite generatedMessageLiteA = ConfigsOuterClass$RequestEditParameter.newBuilder().A(c19791qw6.getKey()).B(StringValue.newBuilder().A(c19791qw6.getValue())).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseSeq defaultInstance = Misc$ResponseSeq.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        C22871vx5 c22871vx5 = new C22871vx5("/bale.v1.Configs/EditParameter", generatedMessageLiteA, defaultInstance);
        c cVar = new c(c12889fL5, this, c19791qw6);
        Long l = (Long) c12889fL5.a;
        Y(c22871vx5, cVar, Long.valueOf(l != null ? l.longValue() : -1L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0() {
        InterfaceC3570Bk5 interfaceC3570Bk5W = W();
        C23453ww6 c23453ww6 = this.n;
        if (c23453ww6 == null) {
            AbstractC13042fc3.y("syncState");
            c23453ww6 = null;
        }
        interfaceC3570Bk5W.f("settings_sync_state_v2", c23453ww6.toByteArray());
    }

    private final void r0() {
        if (W().h("settings_sync_state_loaded_v2", false)) {
            AbstractC20507s76.k(new Runnable() { // from class: ir.nasim.uw6
                @Override // java.lang.Runnable
                public final void run() {
                    ir.nasim.core.modules.settings.a.u0(this.a);
                }
            });
            return;
        }
        GeneratedMessageLite generatedMessageLiteA = ConfigsOuterClass$RequestGetParameters.newBuilder().a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        ConfigsOuterClass$ResponseGetParameters defaultInstance = ConfigsOuterClass$ResponseGetParameters.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        L(new C22871vx5("/bale.v1.Configs/GetParameters", generatedMessageLiteA, defaultInstance)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.sw6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ir.nasim.core.modules.settings.a.s0(this.a, (ConfigsOuterClass$ResponseGetParameters) obj);
            }
        }).E(new InterfaceC24449ye1() { // from class: ir.nasim.tw6
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                ir.nasim.core.modules.settings.a.t0((Exception) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(a aVar, ConfigsOuterClass$ResponseGetParameters configsOuterClass$ResponseGetParameters) {
        AbstractC13042fc3.i(aVar, "this$0");
        AbstractC13042fc3.i(configsOuterClass$ResponseGetParameters, "res");
        aVar.m0(configsOuterClass$ResponseGetParameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(Exception exc) {
        C19406qI3.j("SettingsSyncActor", "failure in GetParameters: " + exc.getMessage(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(a aVar) {
        AbstractC13042fc3.i(aVar, "this$0");
        SettingsModule settingsModuleS = aVar.m.S();
        String strR = AbstractC20507s76.r();
        AbstractC13042fc3.h(strR, "getVersion(...)");
        settingsModuleS.O7(strR);
    }

    @Override // ir.nasim.AbstractC6360Ng4
    public void V() {
        C23453ww6 c23453ww6 = this.n;
        if (c23453ww6 == null) {
            AbstractC13042fc3.y("syncState");
            c23453ww6 = null;
        }
        Iterator it = c23453ww6.q().iterator();
        while (it.hasNext()) {
            p0((C19791qw6) it.next());
        }
        r0();
    }

    @Override // ir.nasim.AbstractC17647nK, ir.nasim.K6
    public void m(Object obj) throws Exception {
        AbstractC13042fc3.i(obj, DialogEntity.COLUMN_MESSAGE);
        if (!(obj instanceof C0998a)) {
            super.m(obj);
            return;
        }
        C0998a c0998a = (C0998a) obj;
        final C19791qw6 c19791qw6 = new C19791qw6(c0998a.a(), c0998a.b());
        C23453ww6 c23453ww6 = this.n;
        C23453ww6 c23453ww62 = null;
        if (c23453ww6 == null) {
            AbstractC13042fc3.y("syncState");
            c23453ww6 = null;
        }
        AbstractC13610gX0.K(c23453ww6.q(), new UA2() { // from class: ir.nasim.rw6
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(ir.nasim.core.modules.settings.a.o0(c19791qw6, (C19791qw6) obj2));
            }
        });
        C23453ww6 c23453ww63 = this.n;
        if (c23453ww63 == null) {
            AbstractC13042fc3.y("syncState");
        } else {
            c23453ww62 = c23453ww63;
        }
        c23453ww62.q().add(c19791qw6);
        q0();
        p0(c19791qw6);
    }

    @Override // ir.nasim.K6
    public void o() {
        super.o();
        this.n = new C23453ww6();
        byte[] bArrB = W().b("settings_sync_state_v2");
        if (bArrB != null) {
            try {
                this.n = C23453ww6.b.a(bArrB);
            } catch (IOException e) {
                C19406qI3.c("SettingsSyncActor", "preStart", e);
            }
        }
    }
}
