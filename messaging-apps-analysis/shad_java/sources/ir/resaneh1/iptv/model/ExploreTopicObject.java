package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class ExploreTopicObject extends PresenterItem {
    public ExploreRubinoTopicObject rubinoTopicObject;
    public TabObject tabObject;
    public TypeEnum type;

    public enum TypeEnum {
        rubino,
        tab
    }

    public ExploreTopicObject(ExploreRubinoTopicObject exploreRubinoTopicObject) {
        this.rubinoTopicObject = exploreRubinoTopicObject;
        this.type = TypeEnum.rubino;
    }

    public ExploreTopicObject(TabObject tabObject) {
        this.tabObject = tabObject;
        this.type = TypeEnum.tab;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.exploreTopic;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getId() {
        if (this.type == TypeEnum.rubino) {
            return this.rubinoTopicObject.id;
        }
        return this.tabObject.tab_id;
    }

    public String getTopic() {
        if (this.type == TypeEnum.rubino) {
            return this.rubinoTopicObject.topic;
        }
        return this.tabObject.title;
    }

    public String getImageUrl() {
        if (this.type == TypeEnum.rubino) {
            return this.rubinoTopicObject.full_thumbnail_url;
        }
        return this.tabObject.image_url;
    }

    public boolean isMain() {
        if (this.type == TypeEnum.rubino) {
            return this.rubinoTopicObject.is_main;
        }
        return false;
    }

    public boolean hasUserImage() {
        if (this.type == TypeEnum.rubino) {
            return this.rubinoTopicObject.hasUserImage;
        }
        return false;
    }

    public void setHasUserImageUrl(boolean z) {
        if (this.type == TypeEnum.rubino) {
            this.rubinoTopicObject.hasUserImage = z;
        }
    }
}
