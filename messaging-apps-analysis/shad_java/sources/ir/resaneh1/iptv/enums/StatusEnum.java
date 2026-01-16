package ir.resaneh1.iptv.enums;

/* loaded from: classes3.dex */
public enum StatusEnum {
    error(0),
    ok(1),
    invalid_token(2),
    invalid_username_or_pass(3),
    invalid_header(4),
    access_denied(5),
    duplicate_request(6),
    show_message(7);

    StatusEnum(int i) {
    }
}
