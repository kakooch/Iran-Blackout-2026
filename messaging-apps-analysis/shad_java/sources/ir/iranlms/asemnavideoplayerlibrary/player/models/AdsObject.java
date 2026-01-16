package ir.iranlms.asemnavideoplayerlibrary.player.models;

import com.google.gson.annotations.SerializedName;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.model.Link;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class AdsObject {
    public ArrayList<String> click_calls;
    public ArrayList<String> complete_calls;
    public boolean has_link;
    public Link link;
    public String link_text;
    public ArrayList<String> skip_calls;
    public ArrayList<String> start_calls;

    @SerializedName("type")
    public AdsType type = AdsType.image;

    @SerializedName("time_location")
    public int time_location = 0;

    @SerializedName("src_url")
    public String url = BuildConfig.FLAVOR;

    @SerializedName("total_duration")
    public int totalDuration = 0;

    @SerializedName("skip_duration")
    public int skip_duration = 0;
    public boolean isShowed = false;

    public enum AdsType {
        video,
        image
    }
}
