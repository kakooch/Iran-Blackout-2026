package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ViewListObject extends PresenterItem {
    public String api_url;
    public int itemCount;
    public int itemWidthPx;
    public ArrayList<String> keys;
    public String title;
    public TypeEnum type;
    public ViewGroupObject view;

    public enum TypeEnum {
        Grid,
        List
    }

    public boolean hasTitle() {
        String str;
        return (!this.view.has_title || (str = this.title) == null || str.isEmpty()) ? false : true;
    }
}
