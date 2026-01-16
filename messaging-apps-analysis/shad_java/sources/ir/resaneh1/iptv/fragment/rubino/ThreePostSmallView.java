package ir.resaneh1.iptv.fragment.rubino;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.ExplorePostGridCell;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.model.RubinoPostObject;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class ThreePostSmallView extends FrameLayout {
    public FrameLayout container1;
    public FrameLayout container2;
    public FrameLayout container3;
    public Context mContext;
    public ExplorePostGridCell postCell1;
    public ExplorePostGridCell postCell2;
    public ExplorePostGridCell postCell3;
    public RubinoPostObject postObject1;
    public RubinoPostObject postObject2;
    public RubinoPostObject postObject3;

    public ThreePostSmallView(Context context) {
        super(context);
        this.mContext = context;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.explore_three_post_small_row, (ViewGroup) null, false);
        addView(viewInflate, LayoutHelper.createFrame(-1, -2.0f));
        this.container1 = (FrameLayout) viewInflate.findViewById(R.id.linearLayout1);
        this.container2 = (FrameLayout) viewInflate.findViewById(R.id.linearLayout2);
        this.container3 = (FrameLayout) viewInflate.findViewById(R.id.linearLayout3);
        int screenWidth = (DimensionHelper.getScreenWidth((Activity) context) - AndroidUtilities.dp(4.0f)) / 3;
        if (this.container1.getLayoutParams().width != screenWidth) {
            this.container1.getLayoutParams().width = screenWidth;
            this.container1.getLayoutParams().height = screenWidth;
            this.container2.getLayoutParams().width = screenWidth;
            this.container2.getLayoutParams().height = screenWidth;
            this.container3.getLayoutParams().width = screenWidth;
            this.container3.getLayoutParams().height = screenWidth;
        }
        ExplorePostGridCell explorePostGridCell = new ExplorePostGridCell(context);
        this.postCell1 = explorePostGridCell;
        this.container1.addView(explorePostGridCell, LayoutHelper.createFrame(-1, -1.0f));
        ExplorePostGridCell explorePostGridCell2 = new ExplorePostGridCell(context);
        this.postCell2 = explorePostGridCell2;
        this.container2.addView(explorePostGridCell2, LayoutHelper.createFrame(-1, -1.0f));
        ExplorePostGridCell explorePostGridCell3 = new ExplorePostGridCell(context);
        this.postCell3 = explorePostGridCell3;
        this.container3.addView(explorePostGridCell3, LayoutHelper.createFrame(-1, -1.0f));
    }

    public void setDelegate(ExplorePostGridCell.SharedPhotoVideoCellDelegate sharedPhotoVideoCellDelegate) {
        ExplorePostGridCell explorePostGridCell = this.postCell1;
        if (explorePostGridCell == null) {
            return;
        }
        explorePostGridCell.setDelegate(sharedPhotoVideoCellDelegate);
        this.postCell2.setDelegate(sharedPhotoVideoCellDelegate);
        this.postCell3.setDelegate(sharedPhotoVideoCellDelegate);
    }

    public void setData(RubinoPostObject rubinoPostObject, RubinoPostObject rubinoPostObject2, RubinoPostObject rubinoPostObject3, int i) {
        this.postObject1 = rubinoPostObject;
        this.postObject2 = rubinoPostObject2;
        this.postObject3 = rubinoPostObject3;
        if (rubinoPostObject != null) {
            this.container1.setVisibility(0);
            this.postCell1.setItem(this.postObject1, i, 2);
        } else {
            this.container1.setVisibility(4);
        }
        if (this.postObject2 != null) {
            this.container2.setVisibility(0);
            this.postCell2.setItem(this.postObject2, i, 1);
        } else {
            this.container2.setVisibility(4);
        }
        if (this.postObject3 != null) {
            this.container3.setVisibility(0);
            this.postCell3.setItem(this.postObject3, i, 0);
        } else {
            this.container3.setVisibility(4);
        }
    }
}
