package ir.resaneh1.iptv.model;

import android.util.SparseArray;
import android.view.View;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import java.util.ArrayList;
import org.rbmain.ui.ActionBar.BaseFragment;

/* loaded from: classes3.dex */
public class TabListObject extends PresenterItem {
    public SparseArray<BaseFragment> fragmentSparseArray;
    public ArrayList<BaseFragment> fragments;
    public View.OnClickListener onClickListener;
    public String selectedName;
    public ArrayList<String> tabNames;
    public ArrayList<TabIcon> tabIcons = new ArrayList<>();
    public ArrayList<TabObject> tabObjects = new ArrayList<>();
    public int selectedPosision = -1;

    public static class TabIcon {
        public int icon;
        public int selectedIcon;
        public TabNameEnum tabNameEnum;

        public enum TabNameEnum {
            bookmark,
            postList,
            postGrid,
            sale
        }

        public TabIcon(TabNameEnum tabNameEnum, int i, int i2) {
            this.tabNameEnum = tabNameEnum;
            this.icon = i;
            this.selectedIcon = i2;
        }
    }
}
