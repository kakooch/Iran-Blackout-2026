package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class ProgressObject extends PresenterItem {
    public int progress = 0;
    public ProgressState state = ProgressState.init;
    public String textFinished;
    public String textInit;

    public enum ProgressState {
        downloading,
        finish,
        init
    }

    public ProgressObject(String str, String str2) {
        this.textInit = str;
        this.textFinished = str2;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.progressObject;
    }
}
