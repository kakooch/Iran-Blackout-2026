package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ViewGroupObject extends PresenterItem {
    public CardViewObject card_view;
    public boolean has_more;
    public boolean has_title;
    public ArrayList<ImageViewObject> images;
    public boolean is_card_view;
    public ArrayList<LinkViewObject> links;
    public SizeObject size;
    public ArrayList<TextViewObject> texts;
    public TypeEnum type;
    public String view_key;
    public String view_version;
    public float h_space = 0.0f;
    public float v_space = 0.0f;
    public float row_space = 0.0f;
    public boolean hasVideo = false;

    public enum TypeEnum {
        Normal,
        List
    }

    public boolean hasVideo() {
        return false;
    }
}
