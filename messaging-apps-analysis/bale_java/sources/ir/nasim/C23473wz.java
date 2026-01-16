package ir.nasim;

import ai.bale.proto.AppzarStruct$BotMenuButton;
import ai.bale.proto.AppzarStruct$MiniAppButton;
import ir.nasim.AbstractC15729k44;

/* renamed from: ir.nasim.wz, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C23473wz implements InterfaceC14123hO3 {
    @Override // ir.nasim.InterfaceC14123hO3
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractC15729k44 a(AppzarStruct$BotMenuButton appzarStruct$BotMenuButton) {
        AbstractC13042fc3.i(appzarStruct$BotMenuButton, "input");
        if (!appzarStruct$BotMenuButton.hasMiniApp()) {
            return AbstractC15729k44.a.a;
        }
        AppzarStruct$MiniAppButton miniApp = appzarStruct$BotMenuButton.getMiniApp();
        String text = miniApp.getText();
        AbstractC13042fc3.h(text, "getText(...)");
        String url = miniApp.getUrl();
        AbstractC13042fc3.h(url, "getUrl(...)");
        return new AbstractC15729k44.b(text, url);
    }
}
