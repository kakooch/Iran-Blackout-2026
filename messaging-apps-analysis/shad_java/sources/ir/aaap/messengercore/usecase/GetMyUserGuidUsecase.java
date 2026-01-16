package ir.aaap.messengercore.usecase;

import ir.aaap.messengercore.CoreMainClassImpl;

/* loaded from: classes3.dex */
public class GetMyUserGuidUsecase {
    private CoreMainClassImpl coreMainClass;

    public GetMyUserGuidUsecase(CoreMainClassImpl coreMainClassImpl) {
        this.coreMainClass = coreMainClassImpl;
    }

    public String getMyGuid() {
        return this.coreMainClass.getMyGuid();
    }
}
