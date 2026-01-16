package ir.resaneh1.iptv.model;

import com.google.gson.annotations.SerializedName;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.iranlms.asemnavideoplayerlibrary.player.models.PlayObject;

/* loaded from: classes3.dex */
public class GetStreamUrlOutput extends StatusOutput {

    @SerializedName("stream")
    public PlayObject playObject;

    @SerializedName("stream_url")
    public String stream_url;

    @SerializedName("view_key")
    public String viewId = BuildConfig.FLAVOR;
}
