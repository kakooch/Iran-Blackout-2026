package ir.resaneh1.iptv.model;

import com.google.gson.annotations.SerializedName;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes3.dex */
public class TVObjectDet extends PresenterItem {

    @SerializedName("characteristics")
    public Map<String, String> characteristics;

    @SerializedName("description")
    public String description;

    @SerializedName("object_abs")
    public TvEpisodeObjectAbs object_abs;

    @SerializedName("related")
    public TagObject related;

    @SerializedName("send_message")
    public Boolean send_message;

    @SerializedName("snapshots")
    public ArrayList<String> snapshots;
}
