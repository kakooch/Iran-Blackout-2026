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
import ir.resaneh1.iptv.model.Rubino;
import ir.resaneh1.iptv.model.RubinoPostObject;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class ThreePostOneBigView extends FrameLayout {
    private int classGuid;
    public FrameLayout container1;
    public FrameLayout container2;
    public FrameLayout containerBig;
    private boolean hasBigPlayableItem;
    public Context mContext;
    public ExplorePostGridCell postCell1;
    public ExplorePostGridCell postCell2;
    public ExplorePostGridCell postCellBig;
    public RubinoPostObject postObject1;
    public RubinoPostObject postObject2;
    public RubinoPostObject postObject3;

    public ThreePostOneBigView(Context context, int i) {
        super(context);
        this.hasBigPlayableItem = true;
        this.mContext = context;
        this.classGuid = i;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.explore_three_post_big_row, (ViewGroup) null, false);
        addView(viewInflate, LayoutHelper.createFrame(-1, -2, 3));
        this.container1 = (FrameLayout) viewInflate.findViewById(R.id.linearLayout1);
        this.container2 = (FrameLayout) viewInflate.findViewById(R.id.linearLayout2);
        this.containerBig = (FrameLayout) viewInflate.findViewById(R.id.linearLayout3);
        Activity activity = (Activity) context;
        int screenWidth = (DimensionHelper.getScreenWidth(activity) - AndroidUtilities.dp(4.0f)) / 3;
        int screenWidth2 = (DimensionHelper.getScreenWidth(activity) - screenWidth) - AndroidUtilities.dp(2.0f);
        if (this.container1.getLayoutParams().width != screenWidth || ((FrameLayout.LayoutParams) ((View) this.container1.getParent()).getLayoutParams()).leftMargin != AndroidUtilities.dp(2.0f) + screenWidth2) {
            ((FrameLayout.LayoutParams) ((View) this.container1.getParent()).getLayoutParams()).leftMargin = AndroidUtilities.dp(2.0f) + screenWidth2;
            this.containerBig.getLayoutParams().width = screenWidth2;
            this.containerBig.getLayoutParams().height = screenWidth2;
            this.container1.getLayoutParams().width = screenWidth;
            this.container1.getLayoutParams().height = screenWidth;
            this.container2.getLayoutParams().width = screenWidth;
            this.container2.getLayoutParams().height = screenWidth;
        }
        ExplorePostGridCell explorePostGridCell = new ExplorePostGridCell(context);
        this.postCell1 = explorePostGridCell;
        this.container1.addView(explorePostGridCell, LayoutHelper.createFrame(-1, -1.0f));
        ExplorePostGridCell explorePostGridCell2 = new ExplorePostGridCell(context);
        this.postCell2 = explorePostGridCell2;
        this.container2.addView(explorePostGridCell2, LayoutHelper.createFrame(-1, -1.0f));
        ExplorePostGridCell explorePostGridCell3 = new ExplorePostGridCell(context);
        this.postCellBig = explorePostGridCell3;
        this.containerBig.addView(explorePostGridCell3, LayoutHelper.createFrame(-1, -1.0f));
    }

    public void setDelegate(ExplorePostGridCell.SharedPhotoVideoCellDelegate sharedPhotoVideoCellDelegate) {
        ExplorePostGridCell explorePostGridCell = this.postCell1;
        if (explorePostGridCell == null) {
            return;
        }
        explorePostGridCell.setDelegate(sharedPhotoVideoCellDelegate);
        this.postCell2.setDelegate(sharedPhotoVideoCellDelegate);
        this.postCellBig.setDelegate(sharedPhotoVideoCellDelegate);
    }

    public void setData(RubinoPostObject rubinoPostObject, RubinoPostObject rubinoPostObject2, RubinoPostObject rubinoPostObject3, int i) {
        if (rubinoPostObject != null && rubinoPostObject.post.size == 2) {
            this.postObject3 = rubinoPostObject;
            this.postObject1 = rubinoPostObject2;
            this.postObject2 = rubinoPostObject3;
        } else if (rubinoPostObject2 != null && rubinoPostObject2.post.size == 2) {
            this.postObject3 = rubinoPostObject2;
            this.postObject1 = rubinoPostObject;
            this.postObject2 = rubinoPostObject3;
        } else {
            this.postObject1 = rubinoPostObject;
            this.postObject2 = rubinoPostObject2;
            this.postObject3 = rubinoPostObject3;
        }
        if (this.postObject1 != null) {
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
            this.containerBig.setVisibility(0);
            RubinoPostObject rubinoPostObject4 = this.postObject3;
            boolean z = rubinoPostObject4.post.file_type == Rubino.FileTypeEnum.Video;
            this.hasBigPlayableItem = z;
            this.postCellBig.setItem(rubinoPostObject4, z, this.classGuid, i, 0);
            return;
        }
        this.containerBig.setVisibility(4);
    }

    public boolean hasBigPlayableItem() {
        return this.hasBigPlayableItem;
    }

    public void playBigPlayableItem() {
        this.postCellBig.playVideo();
    }
}
