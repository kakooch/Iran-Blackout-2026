package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class RubinoCameraTypeItem extends PresenterItem {
    public RubinoCameraTypeEnum typeEnum;

    public enum RubinoCameraTypeEnum {
        normal,
        live,
        boomerang,
        layout,
        superzoom,
        handsFree
    }

    public RubinoCameraTypeItem(RubinoCameraTypeEnum rubinoCameraTypeEnum) {
        this.typeEnum = rubinoCameraTypeEnum;
    }

    public String getName() {
        RubinoCameraTypeEnum rubinoCameraTypeEnum = this.typeEnum;
        return rubinoCameraTypeEnum == RubinoCameraTypeEnum.normal ? "NORMAL" : rubinoCameraTypeEnum == RubinoCameraTypeEnum.live ? "LIVE" : rubinoCameraTypeEnum == RubinoCameraTypeEnum.boomerang ? "BOOMERANG" : rubinoCameraTypeEnum == RubinoCameraTypeEnum.layout ? "LAYOUT" : rubinoCameraTypeEnum == RubinoCameraTypeEnum.superzoom ? "SUPERZOOM" : rubinoCameraTypeEnum == RubinoCameraTypeEnum.handsFree ? "HANDS-FREE" : BuildConfig.FLAVOR;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.rubinoCameraType;
    }
}
