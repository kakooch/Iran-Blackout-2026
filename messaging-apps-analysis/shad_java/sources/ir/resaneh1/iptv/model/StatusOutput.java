package ir.resaneh1.iptv.model;

import com.google.gson.annotations.SerializedName;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.enums.StatusEnum;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class StatusOutput {

    @SerializedName("errors")
    public ArrayList<Error> errors;

    @SerializedName("status")
    public StatusEnum status = StatusEnum.ok;

    @SerializedName("status_link")
    public Link status_link;

    @SerializedName("status_message")
    public String status_message;

    public class Error {

        @SerializedName("error_code")
        public String errorCode;

        @SerializedName("error_message")
        public String errorMessage;

        @SerializedName("object_name")
        public String objectName = BuildConfig.FLAVOR;

        public Error() {
        }
    }
}
