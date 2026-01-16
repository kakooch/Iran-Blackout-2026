package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenters.EditTextCostPresenter;

/* loaded from: classes3.dex */
public class DeliveryTypeObject extends PresenterItem {
    public long amount;
    public String delivery_type_id;
    public String title;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getTitle() {
        String string;
        StringBuilder sb = new StringBuilder();
        sb.append(this.title);
        if (this.amount > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("   (");
            sb2.append(NumberUtils.toPersian(EditTextCostPresenter.setFormat(this.amount + BuildConfig.FLAVOR)));
            sb2.append(" تومان)");
            string = sb2.toString();
        } else {
            string = "(رایگان)";
        }
        sb.append(string);
        return sb.toString();
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getSearchAbleName() {
        return this.title;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public String getId() {
        return this.delivery_type_id;
    }
}
