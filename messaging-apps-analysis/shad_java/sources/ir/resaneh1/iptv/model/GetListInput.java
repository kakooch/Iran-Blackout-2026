package ir.resaneh1.iptv.model;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes3.dex */
public class GetListInput {

    @SerializedName("first_index")
    String first_index;

    @SerializedName("last_index")
    String last_index;

    @SerializedName("tag")
    public TagObject tag;

    public GetListInput(TagObject tagObject, String str, String str2) {
        this.tag = tagObject;
        this.first_index = str;
        this.last_index = str2;
    }
}
