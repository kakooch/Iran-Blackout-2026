package ir.aaap.messengercore.usecase;

import ir.aaap.messengercore.CoreMainClassImpl;
import ir.aaap.messengercore.model.ChatAbsObject;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class NotificationUsecase {
    private CoreMainClassImpl coreMainClass;

    public NotificationUsecase(CoreMainClassImpl coreMainClassImpl) {
        this.coreMainClass = coreMainClassImpl;
    }

    public void addToAbsIfNotExist(ArrayList<ChatAbsObject> arrayList, long j) {
        this.coreMainClass.addToAbsIfNotExist(arrayList, j);
    }
}
