package ir.appp.rghapp.components;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import ir.appp.rghapp.components.SSHPhotoEditCell;
import ir.medu.shad.R;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes3.dex */
public class SSHPhotoEditView extends FrameLayout {
    private ArrayList<EditListItem> editList;
    private LinearLayoutManager layoutManager;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private OnPhotoEditClickedListener listener;
    private int selectedPosition;

    /* JADX INFO: Access modifiers changed from: private */
    interface OnItemClickedListener {
        void onClick(SSHPhotoEditCell sSHPhotoEditCell, int i);
    }

    public interface OnPhotoEditClickedListener {
        void onItemClicked(EditListItem editListItem);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SSHPhotoEditView(Context context) {
        super(context);
        this.selectedPosition = 0;
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, context, 0, 0 == true ? 1 : 0) { // from class: ir.appp.rghapp.components.SSHPhotoEditView.1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
                LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(this, recyclerView.getContext()) { // from class: ir.appp.rghapp.components.SSHPhotoEditView.1.1
                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    protected int getVerticalSnapPreference() {
                        return 1;
                    }

                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    public int calculateDxToMakeVisible(View view, int i2) {
                        int iCalculateDxToMakeVisible = super.calculateDxToMakeVisible(view, i2);
                        if (iCalculateDxToMakeVisible < 0) {
                            return iCalculateDxToMakeVisible + AndroidUtilities.dp(16.0f);
                        }
                        return iCalculateDxToMakeVisible == 0 ? iCalculateDxToMakeVisible : iCalculateDxToMakeVisible - AndroidUtilities.dp(16.0f);
                    }

                    @Override // androidx.recyclerview.widget.LinearSmoothScroller
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return 100.0f / displayMetrics.densityDpi;
                    }
                };
                linearSmoothScroller.setTargetPosition(i);
                startSmoothScroll(linearSmoothScroller);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).width = AndroidUtilities.dp(88.0f);
                ((ViewGroup.MarginLayoutParams) layoutParams).height = getHeight();
                return true;
            }
        };
        this.layoutManager = linearLayoutManager;
        recyclerListView.setLayoutManager(linearLayoutManager);
        ArrayList<EditListItem> arrayList = new ArrayList<>();
        this.editList = arrayList;
        arrayList.add(new EditListItem(0, 1, "Adjust", R.drawable.ic_adjust, false, null));
        this.editList.add(new EditListItem(1, 0, "Brightness", R.drawable.ic_brightness, false, new SeekBarValue(0, -100, 100)));
        this.editList.add(new EditListItem(2, 0, "Contrast", R.drawable.ic_contrast, false, new SeekBarValue(0, -100, 100)));
        this.editList.add(new EditListItem(3, 0, "Warmth", R.drawable.ic_warmth, false, new SeekBarValue(0, -100, 100)));
        this.editList.add(new EditListItem(4, 0, "Saturation", R.drawable.ic_saturation, false, new SeekBarValue(0, -100, 100)));
        this.editList.add(new EditListItem(5, 2, "Color", R.drawable.ic_color, false, null));
        this.editList.add(new EditListItem(6, 0, "Fade", R.drawable.ic_fade, false, new SeekBarValue(0, -100, 100)));
        this.editList.add(new EditListItem(7, 0, "Highlights", R.drawable.ic_highlights, false, new SeekBarValue(0, -100, 100)));
        this.editList.add(new EditListItem(8, 0, "Shadows", R.drawable.ic_shadows, false, new SeekBarValue(0, -100, 100)));
        this.editList.add(new EditListItem(9, 0, "Vignette", R.drawable.ic_vignette, false, new SeekBarValue(0, 0, 100)));
        this.editList.add(new EditListItem(10, 3, "Tilt Shift", R.drawable.ic_tilt_shift, false, null));
        this.editList.add(new EditListItem(11, 0, "Sharpen", R.drawable.ic_sharpen, false, new SeekBarValue(0, 0, 100)));
        this.listView.setItemAnimator(null);
        this.listView.setClipToPadding(false);
        this.listView.setPadding(AndroidUtilities.dp(16.0f), 0, AndroidUtilities.dp(16.0f), 0);
        RecyclerListView recyclerListView2 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.listAdapter = listAdapter;
        recyclerListView2.setAdapter(listAdapter);
        addView(this.listView, LayoutHelper.createFrame(-1, -1, 16));
        this.listAdapter.setOnItemClickedListener(new OnItemClickedListener() { // from class: ir.appp.rghapp.components.SSHPhotoEditView$$ExternalSyntheticLambda0
            @Override // ir.appp.rghapp.components.SSHPhotoEditView.OnItemClickedListener
            public final void onClick(SSHPhotoEditCell sSHPhotoEditCell, int i) {
                this.f$0.lambda$new$0(sSHPhotoEditCell, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(SSHPhotoEditCell sSHPhotoEditCell, int i) {
        scrollToPosition(i, true);
        int i2 = this.selectedPosition;
        this.selectedPosition = i;
        this.listAdapter.notifyItemChanged(i2);
        this.listAdapter.notifyItemChanged(this.selectedPosition);
        OnPhotoEditClickedListener onPhotoEditClickedListener = this.listener;
        if (onPhotoEditClickedListener != null) {
            onPhotoEditClickedListener.onItemClicked(getSelectedItem());
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size2, 1073741824), View.MeasureSpec.makeMeasureSpec(size - size2, 1073741824));
    }

    public int getSelectedItemPosition() {
        return this.selectedPosition;
    }

    public EditListItem getSelectedItem() {
        return this.editList.get(this.selectedPosition);
    }

    public void updateSelectedFilter(int i) {
        this.listAdapter.notifyItemChanged(i);
    }

    public void scrollToPosition(int i, boolean z) {
        if (i < 0 || i >= this.editList.size()) {
            return;
        }
        int iFindFirstVisibleItemPosition = this.layoutManager.findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = this.layoutManager.findLastVisibleItemPosition();
        if ((iFindFirstVisibleItemPosition == 0 || this.selectedPosition > iFindFirstVisibleItemPosition) && (i < iFindFirstVisibleItemPosition || i > iFindLastVisibleItemPosition - 2)) {
            int i2 = i + 1;
            if (i2 < this.editList.size()) {
                this.listView.smoothScrollToPosition(i2);
                return;
            }
            return;
        }
        int i3 = i - 1;
        if (i3 >= 0) {
            this.listView.smoothScrollToPosition(i3);
        } else {
            this.listView.smoothScrollToPosition(i);
        }
    }

    public void setOnPhotoEditClickedListener(OnPhotoEditClickedListener onPhotoEditClickedListener) {
        this.listener = onPhotoEditClickedListener;
    }

    public static class EditListItem {
        public int drawable;
        public int id;
        public int mode;
        public SeekBarValue seekBarValue;
        public boolean selected;
        public String title;

        public EditListItem(int i, int i2, String str, int i3, boolean z, SeekBarValue seekBarValue) {
            this.id = i;
            this.mode = i2;
            this.title = str;
            this.drawable = i3;
            this.selected = z;
            this.seekBarValue = seekBarValue;
        }
    }

    public static class SeekBarValue {
        public int defaultValue;
        public int max;
        public int min;
        public int progress;

        public SeekBarValue(int i, int i2, int i3) {
            this.progress = i;
            this.min = i2;
            this.max = i3;
            this.defaultValue = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private OnItemClickedListener listener;
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
            this.listener = onItemClickedListener;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.getItemViewType() == 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return SSHPhotoEditView.this.editList.size();
        }

        public EditListItem getItem(int i) {
            return (EditListItem) SSHPhotoEditView.this.editList.get(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new RecyclerListView.Holder(new SSHPhotoEditCell(this.mContext));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
            EditListItem item = getItem(i);
            SSHPhotoEditCell sSHPhotoEditCell = (SSHPhotoEditCell) viewHolder.itemView;
            SeekBarValue seekBarValue = item.seekBarValue;
            if (seekBarValue != null) {
                sSHPhotoEditCell.setSelected(seekBarValue.progress != seekBarValue.defaultValue);
            } else {
                sSHPhotoEditCell.setSelected(item.selected);
            }
            sSHPhotoEditCell.setTextAndIcon(item.title, item.drawable);
            sSHPhotoEditCell.setOnViewClickListener(new SSHPhotoEditCell.OnViewClickListener() { // from class: ir.appp.rghapp.components.SSHPhotoEditView$ListAdapter$$ExternalSyntheticLambda0
                @Override // ir.appp.rghapp.components.SSHPhotoEditCell.OnViewClickListener
                public final void onClick(SSHPhotoEditCell sSHPhotoEditCell2) {
                    this.f$0.lambda$onBindViewHolder$0(i, sSHPhotoEditCell2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(int i, SSHPhotoEditCell sSHPhotoEditCell) {
            OnItemClickedListener onItemClickedListener = this.listener;
            if (onItemClickedListener != null) {
                onItemClickedListener.onClick(sSHPhotoEditCell, i);
            }
        }
    }
}
