package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class ThreePostObject extends PresenterItem {
    public InstaPostObject instaPostObject1;
    public InstaPostObject instaPostObject2;
    public InstaPostObject instaPostObject3;

    public ThreePostObject(InstaPostObject instaPostObject, InstaPostObject instaPostObject2, InstaPostObject instaPostObject3) {
        if (instaPostObject != null && instaPostObject.size == 2) {
            this.instaPostObject3 = instaPostObject;
            this.instaPostObject1 = instaPostObject2;
            this.instaPostObject2 = instaPostObject3;
        } else if (instaPostObject2 != null && instaPostObject2.size == 2) {
            this.instaPostObject3 = instaPostObject2;
            this.instaPostObject1 = instaPostObject;
            this.instaPostObject2 = instaPostObject3;
        } else {
            this.instaPostObject1 = instaPostObject;
            this.instaPostObject2 = instaPostObject2;
            this.instaPostObject3 = instaPostObject3;
        }
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        InstaPostObject instaPostObject;
        InstaPostObject instaPostObject2;
        InstaPostObject instaPostObject3 = this.instaPostObject1;
        if ((instaPostObject3 != null && instaPostObject3.size > 1) || (((instaPostObject = this.instaPostObject2) != null && instaPostObject.size > 1) || ((instaPostObject2 = this.instaPostObject3) != null && instaPostObject2.size > 1))) {
            return PresenterItemType.threePostBig;
        }
        return PresenterItemType.threePostSmall;
    }
}
