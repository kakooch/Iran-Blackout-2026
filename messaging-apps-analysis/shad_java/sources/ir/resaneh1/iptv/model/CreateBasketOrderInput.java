package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class CreateBasketOrderInput {
    public String basket_id;
    public String delivery_info_id;
    public String delivery_time_id;
    public String delivery_type_id;
    public long total_amount;

    public CreateBasketOrderInput(String str, String str2, String str3, String str4, long j) {
        this.basket_id = str;
        this.delivery_info_id = str2;
        this.delivery_type_id = str3;
        this.delivery_time_id = str4;
        this.total_amount = j;
    }
}
