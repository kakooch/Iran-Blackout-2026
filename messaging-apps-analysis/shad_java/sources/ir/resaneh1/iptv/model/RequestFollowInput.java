package ir.resaneh1.iptv.model;

/* loaded from: classes3.dex */
public class RequestFollowInput {
    public RequestEnum f_type;
    public String followee_id;

    public enum RequestEnum {
        Follow
    }

    public RequestFollowInput(RequestEnum requestEnum, String str) {
        this.f_type = requestEnum;
        this.followee_id = str;
    }
}
