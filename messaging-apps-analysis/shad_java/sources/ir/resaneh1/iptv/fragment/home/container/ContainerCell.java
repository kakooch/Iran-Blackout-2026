package ir.resaneh1.iptv.fragment.home.container;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import ir.resaneh1.iptv.fragment.home.HomeCell;
import ir.resaneh1.iptv.helper.VisibilityHelper;
import ir.resaneh1.iptv.model.HomePageModels;
import java.util.ArrayList;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes3.dex */
public class ContainerCell extends HomeCell {
    private ContainerAdapter adapter;
    private RecyclerListView listView;

    public ContainerCell(Context context) {
        super(context);
    }

    @Override // ir.resaneh1.iptv.fragment.home.HomeCell
    public View createMainView(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        initListView(context);
        linearLayout.addView(this.listView, LayoutHelper.createLinear(-1, -2, 80, 16, 16, 16, 0));
        return linearLayout;
    }

    private void initListView(Context context) {
        this.listView = new RecyclerListView(context);
        ContainerAdapter containerAdapter = new ContainerAdapter(context);
        this.adapter = containerAdapter;
        this.listView.setAdapter(containerAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(1);
        this.listView.setLayoutManager(linearLayoutManager);
    }

    public void setData(HomePageModels.HomePageSectionObject homePageSectionObject) {
        resetData();
        if (isValidData(homePageSectionObject)) {
            VisibilityHelper.showViews(this);
            setSectionInfoData(homePageSectionObject.common_section_data, homePageSectionObject.type);
            this.adapter.setContainers(homePageSectionObject.container_section.container_items_list);
            return;
        }
        VisibilityHelper.hideViews(this);
    }

    private void resetData() {
        this.adapter.setContainers(null);
    }

    private boolean isValidData(HomePageModels.HomePageSectionObject homePageSectionObject) {
        HomePageModels.ContainerSectionObject containerSectionObject;
        ArrayList<HomePageModels.ContainerSectionItem> arrayList;
        return (homePageSectionObject == null || (containerSectionObject = homePageSectionObject.container_section) == null || (arrayList = containerSectionObject.container_items_list) == null || arrayList.isEmpty()) ? false : true;
    }
}
