package ir.resaneh1.iptv.model;

import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes3.dex */
public class GetTokenPayInput {
    public String app_version;
    public String device_id;
    public String email;
    public String mobile_no;

    public GetTokenPayInput(String str, String str2, String str3, String str4) {
        this.email = BuildConfig.FLAVOR;
        this.app_version = str;
        this.mobile_no = str2;
        this.device_id = str3;
        this.email = str4;
    }
}
