package ir.aaap.messengercore.usecase;

import ir.aaap.messengercore.CoreMainClassImpl;
import ir.aaap.messengercore.LoadListener;
import java.util.Set;

/* loaded from: classes3.dex */
public class LoadAbsUsecase {
    private CoreMainClassImpl coreMainClass;

    public LoadAbsUsecase(CoreMainClassImpl coreMainClassImpl) {
        this.coreMainClass = coreMainClassImpl;
    }

    public void loadAbs(Set<String> set, boolean z, LoadListener<Set<String>> loadListener) {
        this.coreMainClass.loadAbs(set, z, loadListener);
    }
}
