package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class BasketObject extends PresenterItem {
    public String basket_id;
    public ArrayList<BasketCategoryObject> categories;
    public long create_time;
    public ArrayList<BasketItemObject> items;
    public String provider_title;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.basket;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getId() {
        return this.basket_id;
    }

    public long getTotalAmount() {
        ArrayList<BasketItemObject> arrayList = this.items;
        long j = 0;
        if (arrayList != null) {
            Iterator<BasketItemObject> it = arrayList.iterator();
            while (it.hasNext()) {
                BasketItemObject next = it.next();
                j += next.fee_after_discount * next.count;
            }
        }
        return j;
    }
}
