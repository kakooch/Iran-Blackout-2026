package ir.resaneh1.iptv.model;

import com.google.gson.annotations.SerializedName;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;

/* loaded from: classes3.dex */
public class GetStreamUrlInput extends PresenterItem {

    @SerializedName("id")
    public String stream_id;

    @SerializedName("type")
    public String stream_type;

    public GetStreamUrlInput(String str, String str2) {
        this.stream_id = str;
        this.stream_type = str2;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.StreamUrlInput;
    }
}
