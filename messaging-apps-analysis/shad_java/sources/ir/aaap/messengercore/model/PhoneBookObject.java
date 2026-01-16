package ir.aaap.messengercore.model;

import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.utilites.Objects;

/* loaded from: classes3.dex */
public class PhoneBookObject {
    public String first_name = BuildConfig.FLAVOR;
    public String last_name = BuildConfig.FLAVOR;
    public String phone = BuildConfig.FLAVOR;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhoneBookObject)) {
            return false;
        }
        PhoneBookObject phoneBookObject = (PhoneBookObject) obj;
        return Objects.equals(this.first_name, phoneBookObject.first_name) && Objects.equals(this.last_name, phoneBookObject.last_name) && Objects.equals(this.phone, phoneBookObject.phone);
    }

    public int hashCode() {
        return Objects.hash(this.first_name, this.last_name, this.phone);
    }
}
