package ir.resaneh1.iptv.presenters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.helper.StoryEntityView;
import ir.resaneh1.iptv.model.StoryEntityItem;
import ir.resaneh1.iptv.model.StoryEntityItemArray;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class RubinoEntityArrayEmojiPresenter extends AbstractPresenter<StoryEntityItemArray, MyViewHolder> {
    int count;
    private float itemSizeHeightPx;
    float itemSizeWidthPx;
    private SelectItemListner listener;
    Context mContext;
    private int marginInPx;
    View.OnClickListener onClickListener;
    private int rightAndLeftMargin;

    public interface SelectItemListner {
        void onSelectItem(StoryEntityItem storyEntityItem);
    }

    public RubinoEntityArrayEmojiPresenter(Context context, int i, int i2, SelectItemListner selectItemListner) {
        super(context);
        this.rightAndLeftMargin = AndroidUtilities.dp(8.0f);
        this.onClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.presenters.RubinoEntityArrayEmojiPresenter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RubinoEntityArrayEmojiPresenter.this.listener != null) {
                    RubinoEntityArrayEmojiPresenter.this.listener.onSelectItem((StoryEntityItem) view.getTag());
                }
            }
        };
        this.mContext = context;
        this.marginInPx = i;
        this.count = i2;
        this.listener = selectItemListner;
        float screenWidth = (((DimensionHelper.getScreenWidth((Activity) context) - (this.rightAndLeftMargin * 2)) * 1.0f) / i2) - (this.marginInPx * 2);
        this.itemSizeWidthPx = screenWidth;
        this.itemSizeHeightPx = screenWidth;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(1);
        linearLayout.setClipToPadding(false);
        linearLayout.setClipChildren(false);
        int i = this.rightAndLeftMargin;
        linearLayout.setPadding(i, 0, i, 0);
        MyViewHolder myViewHolder = new MyViewHolder(this, linearLayout);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) this.itemSizeWidthPx, (int) this.itemSizeHeightPx);
        layoutParams.gravity = 17;
        int i2 = this.marginInPx;
        layoutParams.topMargin = i2;
        layoutParams.bottomMargin = i2;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i2;
        for (int i3 = 0; i3 < this.count; i3++) {
            myViewHolder.entityViews[i3] = new StoryEntityView(this.mContext);
            if (this.listener != null) {
                myViewHolder.entityViews[i3].setOnClickListener(this.onClickListener);
            }
            linearLayout.addView(myViewHolder.entityViews[i3], 0, layoutParams);
        }
        return myViewHolder;
    }

    @Override // ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter
    public void onBindViewHolder(MyViewHolder myViewHolder, StoryEntityItemArray storyEntityItemArray) {
        super.onBindViewHolder((RubinoEntityArrayEmojiPresenter) myViewHolder, (MyViewHolder) storyEntityItemArray);
        for (int i = 0; i < this.count; i++) {
            myViewHolder.entityViews[i].setVisibility(4);
        }
        if (storyEntityItemArray.array != null) {
            for (int i2 = 0; i2 < this.count && i2 < storyEntityItemArray.array.size(); i2++) {
                myViewHolder.entityViews[i2].setVisibility(0);
                myViewHolder.entityViews[i2].setTag(storyEntityItemArray.array.get(i2));
                float fDp = AndroidUtilities.dp(storyEntityItemArray.array.get(i2).getSizeDp());
                float f = this.itemSizeWidthPx;
                if (fDp > f && f > 0.0f) {
                    storyEntityItemArray.array.get(i2).maxWidthInArray = this.itemSizeWidthPx;
                } else {
                    storyEntityItemArray.array.get(i2).maxWidthInArray = 0.0f;
                }
                StoryEntityItem storyEntityItem = storyEntityItemArray.array.get(i2);
                myViewHolder.entityViews[i2].setOrEditEntityItem(storyEntityItem);
                myViewHolder.entityViews[i2].setScale((this.itemSizeWidthPx * 1.0f) / (storyEntityItem.getPreviewRealWidth() + ((storyEntityItem.getPreviewPaddingPercentage() * storyEntityItem.getPreviewRealWidth()) * 2.0f)));
            }
        }
    }

    public class MyViewHolder extends AbstractPresenter.AbstractViewHolder<StoryEntityItemArray> {
        private StoryEntityView[] entityViews;

        public MyViewHolder(RubinoEntityArrayEmojiPresenter rubinoEntityArrayEmojiPresenter, View view) {
            super(view);
            this.entityViews = new StoryEntityView[6];
        }
    }
}
