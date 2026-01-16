package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class PhoneBookObject extends PresenterItem {
    public String first_name = BuildConfig.FLAVOR;
    public String last_name = BuildConfig.FLAVOR;
    public String phone = BuildConfig.FLAVOR;
    public transient String shortPhone = BuildConfig.FLAVOR;

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PhoneBookObject)) {
            return false;
        }
        PhoneBookObject phoneBookObject = (PhoneBookObject) obj;
        return phoneBookObject.last_name.equals(this.last_name) && phoneBookObject.first_name.equals(this.first_name) && phoneBookObject.phone.equals(this.phone);
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.phoneBook;
    }
}
