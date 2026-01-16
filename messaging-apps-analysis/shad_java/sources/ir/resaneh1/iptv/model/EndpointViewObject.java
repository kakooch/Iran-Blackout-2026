package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;

/* loaded from: classes3.dex */
public class EndpointViewObject extends PresenterItem {
    public TypeEnum type;
    public ViewListObject view_list;
    public ViewTagObject view_tag;

    public enum TypeEnum {
        ViewList,
        ViewTag
    }

    public String getUrl() {
        ViewTagObject viewTagObject;
        ViewListObject viewListObject;
        TypeEnum typeEnum = this.type;
        if (typeEnum == TypeEnum.ViewList && (viewListObject = this.view_list) != null) {
            return viewListObject.api_url;
        }
        if (typeEnum != TypeEnum.ViewTag || (viewTagObject = this.view_tag) == null) {
            return null;
        }
        return viewTagObject.api_url;
    }
}
