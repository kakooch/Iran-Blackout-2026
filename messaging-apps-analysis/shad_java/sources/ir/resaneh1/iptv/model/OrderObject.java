package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.helper.DateFormatUtils;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class OrderObject extends PresenterItem {
    public BasketObject basket;
    public DeliveryInfoObject delivery_info;
    public DeliveryTimeObject delivery_time;
    public DeliveryTypeObject delivery_type;
    public long discount_amount;
    public long final_amount;
    public String order_id;
    private long payment_time;
    public ColorObject status_color;
    public String status_message;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.orderObject;
    }

    public String getPersianDate() {
        try {
            return DateFormatUtils.getDateForOrders(this.payment_time);
        } catch (Exception unused) {
            return BuildConfig.FLAVOR;
        }
    }
}
