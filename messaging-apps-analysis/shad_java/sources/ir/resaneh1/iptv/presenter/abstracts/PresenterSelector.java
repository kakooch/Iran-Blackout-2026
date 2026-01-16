package ir.resaneh1.iptv.presenter.abstracts;

/* loaded from: classes.dex */
public abstract class PresenterSelector {
    public boolean isGrid = false;

    public abstract AbstractPresenter getPresenter(PresenterItemType presenterItemType);
}
