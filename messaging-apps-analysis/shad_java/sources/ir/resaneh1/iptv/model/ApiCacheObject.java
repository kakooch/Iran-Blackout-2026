package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class ApiCacheObject {
    public String appVersion;
    public Long expiredTime;
    public String input;
    public String methodName;
    public String output;

    public ApiCacheObject(String str, String str2, String str3, String str4, Long l) {
        this.methodName = str;
        this.input = str2;
        this.output = str4;
        this.expiredTime = l;
        this.appVersion = str3;
    }
}
