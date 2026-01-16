package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class BasketItemObject extends PresenterItem {
    public String category_id;
    public long count;
    public String description;
    public long fee_after_discount;
    public long fee_before_discount;
    public String image_url;
    public String item_id;
    public String title;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.product;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getTitle() {
        String str = this.title;
        return str == null ? BuildConfig.FLAVOR : str;
    }

    public String getDescription() {
        String str = this.description;
        return str == null ? BuildConfig.FLAVOR : str;
    }

    public String getPriceString() {
        long j = this.fee_after_discount;
        if (j <= 0 && this.fee_before_discount <= 0) {
            return "رایگان";
        }
        if (j > 0) {
            return NumberUtils.getPriceStringWithToman(j, true);
        }
        return NumberUtils.getPriceStringWithToman(this.fee_before_discount, true);
    }
}
