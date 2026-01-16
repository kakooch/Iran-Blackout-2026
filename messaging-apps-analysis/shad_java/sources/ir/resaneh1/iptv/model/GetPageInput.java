package ir.resaneh1.iptv.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GetPageInput {

    @SerializedName("filters")
    ArrayList<TagObject> filters;

    @SerializedName("search_txt")
    String search_txt;

    @SerializedName("type")
    public String type;

    public GetPageInput(String str, ArrayList<TagObject> arrayList, String str2) {
        this.type = str;
        this.filters = arrayList;
        this.search_txt = str2;
    }
}
