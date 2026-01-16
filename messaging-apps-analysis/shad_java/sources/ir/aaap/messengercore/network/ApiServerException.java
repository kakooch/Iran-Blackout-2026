package ir.aaap.messengercore.network;

/* loaded from: classes3.dex */
public class ApiServerException extends Exception {
    public EnumStatus status;
    public EnumStatusDet status_det;

    public enum EnumStatus {
        OK,
        ERROR_BAD_ENC,
        ERROR_TRY_AGAIN,
        ERROR_IGNORE,
        ERROR_MESSAGE_TRY,
        ERROR_MESSAGE_IGN,
        ERROR_GENERIC,
        ERROR_ACTION,
        NOT_REGISTERED
    }

    public enum EnumStatusDet {
        OK,
        INVALID_INPUT,
        NOT_SUPPORTED_API_VERSION,
        SERVER_ERROR,
        INVALID_METHOD,
        CODE_IS_USED,
        NOT_REGISTERED,
        INVALID_AUTH,
        CODE_IS_EXPIRED,
        USERNAME_NOT_EXIST,
        TOO_REQUESTS,
        SHOW_MESSAGE
    }

    public ApiServerException(String str, String str2) {
        this.status = str != null ? EnumStatus.valueOf(str) : null;
        this.status_det = str2 != null ? EnumStatusDet.valueOf(str2) : null;
    }

    public ApiServerException() {
        this.status = EnumStatus.ERROR_TRY_AGAIN;
        this.status_det = EnumStatusDet.SERVER_ERROR;
    }
}
