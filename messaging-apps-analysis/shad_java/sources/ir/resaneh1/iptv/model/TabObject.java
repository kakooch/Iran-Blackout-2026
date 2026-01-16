package ir.resaneh1.iptv.model;

import ir.medu.shad.R;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import java.util.ArrayList;
import org.rbmain.messenger.LocaleController;

/* loaded from: classes3.dex */
public class TabObject extends PresenterItem {
    public boolean has_suggestion;
    public boolean has_tabs;
    public String image_url;
    public boolean is_hardcode;
    public ArrayList<TabObject> items;
    public String tab_id;
    public String title;
    public TypeEnum type;
    public ViewTagObject view_tag;

    public enum TypeEnum {
        rubino,
        rubinoProfile,
        rubinoHashtag,
        viewTag
    }

    public TabObject(String str, TypeEnum typeEnum) {
        this.title = str;
        this.type = typeEnum;
    }

    public TabObject() {
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
    public PresenterItemType getPresenterType() {
        return PresenterItemType.searchTab;
    }

    public void setRubinoTab() {
        this.type = TypeEnum.rubino;
        this.title = LocaleController.getString(R.string.RubinoNameFarsi);
        this.has_tabs = true;
        ArrayList<TabObject> arrayList = new ArrayList<>();
        this.items = arrayList;
        arrayList.add(new TabObject("کاربر", TypeEnum.rubinoProfile));
        this.items.add(new TabObject("هشتگ", TypeEnum.rubinoHashtag));
    }
}
