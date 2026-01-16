package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class GetDeliveryTimesInput {
    public String basket_id;
    public String delivery_info_id;
    public String delivery_type_id;

    public GetDeliveryTimesInput(String str, String str2, String str3) {
        this.basket_id = str;
        this.delivery_info_id = str2;
        this.delivery_type_id = str3;
    }
}
