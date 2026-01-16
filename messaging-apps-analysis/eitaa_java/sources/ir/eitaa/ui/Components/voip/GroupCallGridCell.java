package ir.eitaa.ui.Components.voip;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import ir.eitaa.messenger.AccountInstance;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ChatObject;
import ir.eitaa.ui.GroupCallActivity;
import ir.eitaa.ui.GroupCallTabletGridAdapter;

/* loaded from: classes3.dex */
public class GroupCallGridCell extends FrameLayout {
    public boolean attached;
    public GroupCallTabletGridAdapter gridAdapter;
    private final boolean isTabletGrid;
    ChatObject.VideoParticipant participant;
    public int position;
    GroupCallMiniTextureView renderer;
    public int spanCount;

    public GroupCallGridCell(Context context, boolean isTabletGrid) {
        super(context);
        this.isTabletGrid = isTabletGrid;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size;
        if (this.isTabletGrid) {
            ((View) getParent()).getMeasuredWidth();
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(this.gridAdapter.getItemHeight(this.position), 1073741824));
            return;
        }
        float f = GroupCallActivity.isLandscapeMode ? 3.0f : 2.0f;
        if (getParent() != null) {
            size = ((View) getParent()).getMeasuredWidth();
        } else {
            size = View.MeasureSpec.getSize(widthMeasureSpec);
        }
        float f2 = size;
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec((int) ((GroupCallActivity.isTabletMode ? f2 / 2.0f : f2 / f) + AndroidUtilities.dp(4.0f)), 1073741824));
    }

    public void setData(AccountInstance accountInstance, ChatObject.VideoParticipant participant, ChatObject.Call call, long selfPeerId) {
        this.participant = participant;
    }

    public ChatObject.VideoParticipant getParticipant() {
        return this.participant;
    }

    public void setRenderer(GroupCallMiniTextureView renderer) {
        this.renderer = renderer;
    }

    public GroupCallMiniTextureView getRenderer() {
        return this.renderer;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.attached = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.attached = false;
    }

    public float getItemHeight() {
        int measuredHeight;
        GroupCallTabletGridAdapter groupCallTabletGridAdapter = this.gridAdapter;
        if (groupCallTabletGridAdapter != null) {
            measuredHeight = groupCallTabletGridAdapter.getItemHeight(this.position);
        } else {
            measuredHeight = getMeasuredHeight();
        }
        return measuredHeight;
    }
}
