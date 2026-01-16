package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenters.ViewGroupCellPresenter;

/* loaded from: classes3.dex */
public class CommandInfoObject {
    public ViewDataObject clickedDataObject;
    public DynamicPageCommandObject commandObject;
    public ViewGroupCellPresenter.LoadingObject loadingObject;

    public CommandInfoObject(DynamicPageCommandObject dynamicPageCommandObject, ViewDataObject viewDataObject, ViewGroupCellPresenter.LoadingObject loadingObject) {
        this.commandObject = dynamicPageCommandObject;
        this.clickedDataObject = viewDataObject;
        this.loadingObject = loadingObject;
    }
}
