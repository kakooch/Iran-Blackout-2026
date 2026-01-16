package ir.resaneh1.iptv.model;

import com.google.gson.annotations.SerializedName;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes3.dex */
public class VodObjectDet extends PresenterItem {

    @SerializedName("characteristics")
    public Map<String, String> characteristics;
    public TagObject comments;
    public String director;
    public VODObjectAbs object_abs;
    public TagObject related;

    @SerializedName("snapshots")
    public ArrayList<String> snapshots;
    public String description = BuildConfig.FLAVOR;
    public String cast = BuildConfig.FLAVOR;

    @SerializedName("send_message")
    public Boolean send_message = Boolean.FALSE;

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.VodDet;
    }
}
