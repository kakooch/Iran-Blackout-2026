package ir.aaap.messengercore.usecase;

import ir.aaap.messengercore.CoreMainClassImpl;
import ir.aaap.messengercore.model.Link;

/* loaded from: classes3.dex */
public class LinkUsecase {
    private CoreMainClassImpl coreMainClass;

    public LinkUsecase(CoreMainClassImpl coreMainClassImpl) {
        this.coreMainClass = coreMainClassImpl;
    }

    public void onLinkClick(Link link) {
        this.coreMainClass.onLinkClick(link);
    }
}
