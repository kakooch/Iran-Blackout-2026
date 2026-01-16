package ir.resaneh1.iptv.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class EPGListTVOutput extends StatusOutput {

    @SerializedName("list")
    public ArrayList<TvEpisodeObjectAbs> list = new ArrayList<>();
}
