package ir.nasim;

import ai.bale.proto.AppzarOuterClass$ResponseGetMiniAppUrl;
import com.google.protobuf.StringValue;

/* renamed from: ir.nasim.zD, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24794zD implements InterfaceC14123hO3 {
    private final InterfaceC14123hO3 a;

    public C24794zD(InterfaceC14123hO3 interfaceC14123hO3) {
        AbstractC13042fc3.i(interfaceC14123hO3, "apiWebAppScreenModeToWebAppScreenMode");
        this.a = interfaceC14123hO3;
    }

    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public S68 a(AppzarOuterClass$ResponseGetMiniAppUrl appzarOuterClass$ResponseGetMiniAppUrl) {
        AbstractC13042fc3.i(appzarOuterClass$ResponseGetMiniAppUrl, "input");
        String url = appzarOuterClass$ResponseGetMiniAppUrl.getUrl();
        AbstractC13042fc3.h(url, "getUrl(...)");
        InterfaceC14123hO3 interfaceC14123hO3 = this.a;
        CG screenMode = appzarOuterClass$ResponseGetMiniAppUrl.getScreenMode();
        AbstractC13042fc3.h(screenMode, "getScreenMode(...)");
        EnumC23552x68 enumC23552x68 = (EnumC23552x68) interfaceC14123hO3.a(screenMode);
        StringValue queryId = appzarOuterClass$ResponseGetMiniAppUrl.getQueryId();
        return new S68(url, enumC23552x68, queryId != null ? queryId.getValue() : null);
    }
}
