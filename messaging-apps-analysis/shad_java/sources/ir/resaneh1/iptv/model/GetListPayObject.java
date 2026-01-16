package ir.resaneh1.iptv.model;

import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GetListPayObject {
    public ArrayList<List> multi_list_resp;

    public class List {
        public ArrayList<Item> item_list;
        public String list_name;
        public String timestamp;

        public List() {
        }
    }

    public class Item extends PresenterItem {
        public String desc;
        public String name;
        public String value;

        public Item() {
        }

        @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
        public String getTitle() {
            return this.name;
        }

        @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterItem
        public String getSearchAbleName() {
            return this.name;
        }

        public int getValue() {
            try {
                return Integer.parseInt(this.value);
            } catch (Exception unused) {
                return 0;
            }
        }

        public int getDec() {
            try {
                return Integer.parseInt(this.desc);
            } catch (Exception unused) {
                return 0;
            }
        }
    }
}
