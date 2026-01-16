package ir.resaneh1.iptv.UIView;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import ir.resaneh1.iptv.helper.DimensionHelper;
import ir.resaneh1.iptv.model.RubinoCameraTypeItem;
import ir.resaneh1.iptv.presenter.abstracts.AbstractPresenter;
import ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItemType;
import ir.resaneh1.iptv.presenter.abstracts.PresenterSelector;
import ir.resaneh1.iptv.presenter.adapter.MainAdapter;
import ir.resaneh1.iptv.presenters.RubinoCameraTypeCellPresenter;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class UI_rubinoCameraTypeRow {
    public FrameLayout frameLayout;
    int lastSnapPosition;
    CustomLayoutManager layoutManager;
    public SelectItemListener listener;
    RubinoCameraTypeCellPresenter presenter;
    public RecyclerView recyclerView;
    SnapHelper snapHelper;
    public View view;

    public interface SelectItemListener {
        void onSelectItem(RubinoCameraTypeItem rubinoCameraTypeItem);
    }

    public View createView(Activity activity, int i, ArrayList<RubinoCameraTypeItem> arrayList, SelectItemListener selectItemListener) throws IllegalStateException {
        FrameLayout frameLayout = new FrameLayout(activity);
        this.frameLayout = frameLayout;
        this.view = frameLayout;
        this.listener = selectItemListener;
        this.lastSnapPosition = -1;
        this.presenter = new RubinoCameraTypeCellPresenter(activity);
        this.recyclerView = new RecyclerView(activity);
        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        this.snapHelper = linearSnapHelper;
        linearSnapHelper.attachToRecyclerView(this.recyclerView);
        CustomLayoutManager customLayoutManager = new CustomLayoutManager(this, activity, 0, Build.VERSION.SDK_INT < 17, DimensionHelper.getScreenWidth(ApplicationLoader.applicationActivity) - AndroidUtilities.dp(100.0f), AndroidUtilities.dp(80.0f));
        this.layoutManager = customLayoutManager;
        this.recyclerView.setLayoutManager(customLayoutManager);
        this.recyclerView.setHorizontalScrollBarEnabled(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, AndroidUtilities.dp(i));
        layoutParams.gravity = 16;
        this.recyclerView.setFadingEdgeLength(AndroidUtilities.dp(20.0f));
        this.recyclerView.setHorizontalFadingEdgeEnabled(true);
        this.recyclerView.setClipToPadding(false);
        this.frameLayout.addView(this.recyclerView, layoutParams);
        this.recyclerView.setAdapter(new MainAdapter(activity, arrayList, new PresenterSelector() { // from class: ir.resaneh1.iptv.UIView.UI_rubinoCameraTypeRow.1
            @Override // ir.resaneh1.iptv.presenter.abstracts.PresenterSelector
            public AbstractPresenter getPresenter(PresenterItemType presenterItemType) {
                if (presenterItemType == PresenterItemType.rubinoCameraType) {
                    return UI_rubinoCameraTypeRow.this.presenter;
                }
                return null;
            }
        }, new OnPresenterItemClickListener() { // from class: ir.resaneh1.iptv.UIView.UI_rubinoCameraTypeRow.2
            @Override // ir.resaneh1.iptv.presenter.abstracts.OnPresenterItemClickListener
            public void onClick(AbstractPresenter.AbstractViewHolder abstractViewHolder) {
                try {
                    UI_rubinoCameraTypeRow.this.recyclerView.smoothScrollToPosition(abstractViewHolder.getAdapterPosition());
                } catch (Exception unused) {
                }
            }
        }, null));
        if (this.listener != null) {
            this.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.UIView.UI_rubinoCameraTypeRow.3
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                    if (i2 == 0) {
                        UI_rubinoCameraTypeRow.this.checkPageSelected();
                    }
                }
            });
        }
        return this.view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPageSelected() {
        int position;
        View viewFindSnapView = this.snapHelper.findSnapView(this.layoutManager);
        if (viewFindSnapView == null || this.lastSnapPosition == (position = this.layoutManager.getPosition(viewFindSnapView))) {
            return;
        }
        this.lastSnapPosition = position;
        SelectItemListener selectItemListener = this.listener;
        if (selectItemListener != null) {
            selectItemListener.onSelectItem((RubinoCameraTypeItem) ((RubinoCameraTypeCellPresenter.ViewHolder) viewFindSnapView.getTag()).item);
        }
    }

    public class CustomLayoutManager extends LinearLayoutManager {
        private int mItemWidth;
        private int mParentWidth;

        public CustomLayoutManager(UI_rubinoCameraTypeRow uI_rubinoCameraTypeRow, Context context, int i, boolean z, int i2, int i3) {
            super(context, i, z);
            this.mParentWidth = i2;
            this.mItemWidth = i3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public int getPaddingLeft() {
            return Math.round((this.mParentWidth / 2.0f) - (this.mItemWidth / 2.0f));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public int getPaddingRight() {
            return getPaddingLeft();
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
            if (getOrientation() != 0) {
                return 0;
            }
            int iScrollHorizontallyBy = super.scrollHorizontallyBy(i, recycler, state);
            float width = getWidth() / 2.0f;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                float fAbs = Math.abs(width - ((getDecoratedRight(childAt) + getDecoratedLeft(childAt)) / 2.0f));
                RubinoCameraTypeCellPresenter.ViewHolder viewHolder = (RubinoCameraTypeCellPresenter.ViewHolder) childAt.getTag();
                if (fAbs > this.mItemWidth / 2) {
                    viewHolder.textView1.setTextColor(1728053247);
                } else {
                    viewHolder.textView1.setTextColor(-1);
                }
            }
            return iScrollHorizontallyBy;
        }
    }
}
