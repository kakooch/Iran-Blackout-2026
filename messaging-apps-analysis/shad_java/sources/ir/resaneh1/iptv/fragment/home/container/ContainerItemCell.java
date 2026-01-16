package ir.resaneh1.iptv.fragment.home.container;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import ir.appp.common.utils.LayoutHelper;
import ir.resaneh1.iptv.fragment.home.sectionInfo.BottomInfoCell;
import ir.resaneh1.iptv.helper.VisibilityHelper;
import ir.resaneh1.iptv.model.HomePageModels;

/* loaded from: classes3.dex */
public class ContainerItemCell extends LinearLayout {
    private final BottomInfoCell infoCell;
    private final View lineView;

    private boolean isValidData(HomePageModels.ContainerSectionItem containerSectionItem) {
        return containerSectionItem != null;
    }

    public ContainerItemCell(Context context) {
        super(context);
        setOrientation(1);
        View viewCreateLine = VisibilityHelper.createLine(context);
        this.lineView = viewCreateLine;
        BottomInfoCell bottomInfoCell = new BottomInfoCell(context);
        this.infoCell = bottomInfoCell;
        addView(bottomInfoCell, LayoutHelper.createLinear(-1, -2, 0, 0, 0, 0, 0));
        addView(viewCreateLine, LayoutHelper.createLinear(-1, 1, 17, 0, 8, 0, 0));
    }

    public void setData(HomePageModels.ContainerSectionItem containerSectionItem, Boolean bool) {
        resetData();
        if (isValidData(containerSectionItem)) {
            VisibilityHelper.showViews(this);
            this.infoCell.setData(containerSectionItem);
            if (bool.booleanValue()) {
                this.lineView.setVisibility(0);
                return;
            } else {
                this.lineView.setVisibility(0);
                return;
            }
        }
        VisibilityHelper.hideViews(this);
    }

    private void resetData() {
        this.infoCell.resetData();
    }
}
