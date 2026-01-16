package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class AddToBasketInput {
    public BasketItemPointerObject item;

    public AddToBasketInput(BasketItemPointerObject basketItemPointerObject) {
        this.item = basketItemPointerObject;
    }

    public AddToBasketInput(String str, String str2) {
        this.item = new BasketItemPointerObject(str, str2);
    }
}
