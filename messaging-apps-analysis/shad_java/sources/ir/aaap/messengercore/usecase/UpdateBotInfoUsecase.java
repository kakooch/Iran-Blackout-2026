package ir.aaap.messengercore.usecase;

import ir.aaap.messengercore.CoreMainClassImpl;
import ir.aaap.messengercore.model.ChatType;

/* loaded from: classes3.dex */
public class UpdateBotInfoUsecase {
    private CoreMainClassImpl coreMainClass;

    public UpdateBotInfoUsecase(CoreMainClassImpl coreMainClassImpl) {
        this.coreMainClass = coreMainClassImpl;
    }

    public long getBotInfoUpdateDuration() {
        return this.coreMainClass.getBotInfoUpdateDuration();
    }

    public void decreaseBotInfoDurationLevel(String str, ChatType chatType) {
        this.coreMainClass.decreaseBotInfoDurationLevel(str, chatType);
    }
}
