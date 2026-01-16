package ir.nasim;

import ai.bale.proto.Misc$ResponseVoid;
import ai.bale.proto.UsersOuterClass$RequestNotifyAboutDeviceInfo;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.StringValue;
import java.util.List;
import java.util.Locale;

/* renamed from: ir.nasim.cK1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10860cK1 extends AbstractC6360Ng4 {
    private final C9057Yh4 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10860cK1(C9057Yh4 c9057Yh4) {
        super(c9057Yh4);
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.m = c9057Yh4;
        b0("sequences_synced");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence f0(String str) {
        AbstractC13042fc3.f(str);
        Locale locale = Locale.getDefault();
        AbstractC13042fc3.h(locale, "getDefault(...)");
        String lowerCase = str.toLowerCase(locale);
        AbstractC13042fc3.h(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(C10860cK1 c10860cK1, String str, String str2, Misc$ResponseVoid misc$ResponseVoid) {
        AbstractC13042fc3.i(c10860cK1, "this$0");
        AbstractC13042fc3.i(str, "$expectedLangs");
        AbstractC13042fc3.i(str2, "$timeZone");
        c10860cK1.W().putString("device_info_langs", str);
        c10860cK1.W().putString("device_info_timezone", str2);
    }

    @Override // ir.nasim.AbstractC6360Ng4
    public void V() {
        String[] strArrG = this.m.z().g();
        AbstractC13042fc3.h(strArrG, "getPreferredLanguages(...)");
        List listF1 = AbstractC10242bK.f1(strArrG);
        final String strA0 = AbstractC15401jX0.A0(listF1, ",", null, null, 0, null, new UA2() { // from class: ir.nasim.aK1
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C10860cK1.f0((String) obj);
            }
        }, 30, null);
        final String strH = this.m.z().h();
        AbstractC13042fc3.h(strH, "getTimeZone(...)");
        if (AbstractC13042fc3.d(strA0, W().e("device_info_langs")) && AbstractC13042fc3.d(strH, W().e("device_info_timezone"))) {
            return;
        }
        GeneratedMessageLite generatedMessageLiteA = UsersOuterClass$RequestNotifyAboutDeviceInfo.newBuilder().B(StringValue.of(strH)).A(listF1).a();
        AbstractC13042fc3.h(generatedMessageLiteA, "build(...)");
        Misc$ResponseVoid defaultInstance = Misc$ResponseVoid.getDefaultInstance();
        AbstractC13042fc3.h(defaultInstance, "getDefaultInstance(...)");
        L(new C22871vx5("/bale.users.v1.Users/NotifyAboutDeviceInfo", generatedMessageLiteA, defaultInstance)).m0(new InterfaceC24449ye1() { // from class: ir.nasim.bK1
            @Override // ir.nasim.InterfaceC24449ye1
            public final void apply(Object obj) {
                C10860cK1.g0(this.a, strA0, strH, (Misc$ResponseVoid) obj);
            }
        });
    }
}
