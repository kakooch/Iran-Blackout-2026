package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class GetListPayInput {
    public String app_version;
    public String ip = "255.255.255.255";
    public int lang = 1;
    public String multi_list_name;
    public String target_mobile;
    public String timestamp_list;
    public String token;

    public GetListPayInput(String str, String str2, String str3, String str4) {
        this.token = str;
        this.multi_list_name = str2;
        this.app_version = str3;
        this.target_mobile = str4;
    }
}
