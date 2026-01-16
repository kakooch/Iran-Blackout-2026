package ir.aaap.messengercore.model;

import ir.aaap.messengercore.utilites.Objects;

/* loaded from: classes3.dex */
public class ContactMessageObject {
    public String first_name;
    public String last_name;
    public String phone_number;
    public String user_guid;
    public String vcard;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContactMessageObject)) {
            return false;
        }
        ContactMessageObject contactMessageObject = (ContactMessageObject) obj;
        return Objects.equals(this.phone_number, contactMessageObject.phone_number) && Objects.equals(this.first_name, contactMessageObject.first_name) && Objects.equals(this.last_name, contactMessageObject.last_name) && Objects.equals(this.user_guid, contactMessageObject.user_guid) && Objects.equals(this.vcard, contactMessageObject.vcard);
    }

    public int hashCode() {
        return Objects.hash(this.phone_number, this.first_name, this.last_name, this.user_guid, this.vcard);
    }
}
