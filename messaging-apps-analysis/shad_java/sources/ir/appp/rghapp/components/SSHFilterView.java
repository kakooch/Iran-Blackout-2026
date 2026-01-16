package ir.appp.rghapp.components;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import ir.appp.rghapp.components.SSHThumbnailFilterGenerator;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes3.dex */
public class SSHFilterView extends FrameLayout implements TextureView.SurfaceTextureListener {
    private final boolean blurThumbnails;
    private Bitmap currentBitmap;
    private FilterViewDelegate delegate;
    private final ArrayList<FilterItem> filters;
    private final LinearLayoutManager layoutManager;
    private final ListAdapter listAdapter;
    private final RecyclerListView listView;
    private int newSelectedPosition;
    private int selectedPosition;
    private SSHThumbnailFilterGenerator thumbnailFilterGenerator;

    public interface FilterViewDelegate {
        void onFilterChanged(FilterItem filterItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface OnFilterClicked {
        void onClick(View view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface OnItemClickedListener {
        void onClick(View view, int i);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SSHFilterView(Context context, boolean z, boolean z2) {
        super(context);
        this.filters = new ArrayList<>();
        this.selectedPosition = 0;
        this.newSelectedPosition = 0;
        this.blurThumbnails = z;
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, context, 0, 0 == true ? 1 : 0) { // from class: ir.appp.rghapp.components.SSHFilterView.1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
                LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(this, recyclerView.getContext()) { // from class: ir.appp.rghapp.components.SSHFilterView.1.1
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
                ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (getWidth() / 3.55f);
                ((ViewGroup.MarginLayoutParams) layoutParams).height = getHeight();
                return true;
            }
        };
        this.layoutManager = linearLayoutManager;
        recyclerListView.setLayoutManager(linearLayoutManager);
        recyclerListView.setItemAnimator(null);
        recyclerListView.setClipToPadding(false);
        recyclerListView.setPadding(AndroidUtilities.dp(16.0f), 0, AndroidUtilities.dp(16.0f), 0);
        ListAdapter listAdapter = new ListAdapter(context, z2);
        this.listAdapter = listAdapter;
        recyclerListView.setAdapter(listAdapter);
        addView(recyclerListView, LayoutHelper.createFrame(-1, -1, 16));
        listAdapter.setOnItemClickedListener(new OnItemClickedListener() { // from class: ir.appp.rghapp.components.SSHFilterView$$ExternalSyntheticLambda0
            @Override // ir.appp.rghapp.components.SSHFilterView.OnItemClickedListener
            public final void onClick(View view, int i) {
                this.f$0.lambda$new$0(view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view, int i) {
        scrollToPosition(i, true);
        int i2 = this.selectedPosition;
        this.selectedPosition = i;
        this.listAdapter.notifyItemChanged(i2);
        this.listAdapter.notifyItemChanged(this.selectedPosition);
        FilterViewDelegate filterViewDelegate = this.delegate;
        if (filterViewDelegate != null) {
            filterViewDelegate.onFilterChanged(this.filters.get(this.selectedPosition));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size2, 1073741824), View.MeasureSpec.makeMeasureSpec(size - size2, 1073741824));
    }

    public void setSelectedPosition(int i) {
        this.newSelectedPosition = i;
    }

    public void setBitmapPath(Bitmap bitmap) {
        this.currentBitmap = bitmap;
        this.filters.add(new FilterItem(0, "Normal", null, 100, 0, 100));
        this.filters.add(new FilterItem(1, "Amaro", null, 100, 0, 100));
        this.filters.add(new FilterItem(2, "Rise", null, 100, 0, 100));
        this.filters.add(new FilterItem(3, "Hudson", null, 100, 0, 100));
        this.filters.add(new FilterItem(4, "Valencia", null, 100, 0, 100));
        this.filters.add(new FilterItem(5, "Sierra", null, 100, 0, 100));
        this.filters.add(new FilterItem(6, "X-Pro Ⅱ", null, 100, 0, 100));
        this.filters.add(new FilterItem(7, "Willow", null, 100, 0, 100));
        this.filters.add(new FilterItem(8, "Lo-Fi", null, 100, 0, 100));
        this.filters.add(new FilterItem(9, "Inkwell", null, 100, 0, 100));
        this.filters.add(new FilterItem(10, "Hefe", null, 100, 0, 100));
        this.filters.add(new FilterItem(11, "Juno", null, 100, 0, 100));
        this.filters.add(new FilterItem(12, "Aden", null, 100, 0, 100));
        this.filters.add(new FilterItem(13, "Crema", null, 100, 0, 100));
        this.filters.add(new FilterItem(14, "Mayfair", null, 100, 0, 100));
        this.filters.add(new FilterItem(15, "Moon", null, 100, 0, 100));
        this.filters.add(new FilterItem(16, "Gingham", null, 100, 0, 100));
        this.filters.add(new FilterItem(17, "Nashville", null, 100, 0, 100));
        this.listAdapter.notifyDataSetChanged();
    }

    public int getSelectedItemPosition() {
        return this.selectedPosition;
    }

    public FilterItem getSelectedFilter() {
        return this.filters.get(this.selectedPosition);
    }

    public void updateSelectedFilter(int i) {
        this.listAdapter.notifyItemChanged(i);
    }

    public void scrollToPosition(int i, boolean z) {
        if (i < 0 || i >= this.filters.size()) {
            return;
        }
        if (!z) {
            int i2 = AndroidUtilities.displayMetrics.widthPixels;
            this.layoutManager.scrollToPositionWithOffset(i - 1, (int) (i2 - ((i2 / 3.6f) * 4.0f)));
            return;
        }
        int iFindFirstVisibleItemPosition = this.layoutManager.findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = this.layoutManager.findLastVisibleItemPosition();
        if ((iFindFirstVisibleItemPosition == 0 || this.selectedPosition > iFindFirstVisibleItemPosition) && (i < iFindFirstVisibleItemPosition || i > iFindLastVisibleItemPosition - 2)) {
            int i3 = i + 1;
            if (i3 < this.filters.size()) {
                this.listView.smoothScrollToPosition(i3);
                return;
            }
            return;
        }
        int i4 = i - 1;
        if (i4 >= 0) {
            this.listView.smoothScrollToPosition(i4);
        } else {
            this.listView.smoothScrollToPosition(i);
        }
    }

    public void setDelegate(FilterViewDelegate filterViewDelegate) {
        this.delegate = filterViewDelegate;
    }

    public static class FilterItem {
        public Bitmap bitmap;
        public int id;
        public int max;
        public int min;
        public int progress;
        public String title;

        public FilterItem(int i, String str, Bitmap bitmap, int i2, int i3, int i4) {
            this.id = i;
            this.title = str;
            this.bitmap = bitmap;
            this.progress = i2;
            this.min = i3;
            this.max = i4;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.thumbnailFilterGenerator == null) {
            SSHThumbnailFilterGenerator sSHThumbnailFilterGenerator = new SSHThumbnailFilterGenerator(getContext(), surfaceTexture, this.currentBitmap, this.blurThumbnails, new SSHThumbnailFilterGenerator.FilteredThumbnailGeneratorListener() { // from class: ir.appp.rghapp.components.SSHFilterView$$ExternalSyntheticLambda1
                @Override // ir.appp.rghapp.components.SSHThumbnailFilterGenerator.FilteredThumbnailGeneratorListener
                public final void onFilteredBitmapReady(Bitmap bitmap, int i3) {
                    this.f$0.lambda$onSurfaceTextureAvailable$1(bitmap, i3);
                }
            });
            this.thumbnailFilterGenerator = sSHThumbnailFilterGenerator;
            sSHThumbnailFilterGenerator.startProcess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSurfaceTextureAvailable$1(Bitmap bitmap, int i) {
        this.filters.get(i).bitmap = bitmap;
        this.listAdapter.notifyItemChanged(i);
        int i2 = this.newSelectedPosition;
        if (i == i2) {
            if (i2 >= 0 && i2 < this.filters.size()) {
                scrollToPosition(this.newSelectedPosition, true);
            }
            int i3 = this.selectedPosition;
            this.selectedPosition = this.newSelectedPosition;
            if (i3 >= 0 && i3 < this.filters.size()) {
                this.listAdapter.notifyItemChanged(i3);
            }
            int i4 = this.selectedPosition;
            if (i4 < 0 || i4 >= this.filters.size()) {
                return;
            }
            this.listAdapter.notifyItemChanged(this.selectedPosition);
        }
    }

    private class SSHFilterCell extends FrameLayout {
        private final int activeTextColorKey;
        private final FrameLayout aspectRatioFrameLayout;
        private Animator checkAnimator;
        private final ImageView imageView;
        public boolean isScaleDown;
        private OnFilterClicked listener;
        private final TextView nameChar;
        private final Paint paint;
        private float scaleState;
        public boolean selected;
        private float startX;
        private float startY;
        private final TextView textView;
        private final TextureView textureView;
        private final int unactiveTextColorKey;

        @Override // android.view.View
        public boolean hasOverlappingRendering() {
            return false;
        }

        public SSHFilterCell(SSHFilterView sSHFilterView, Context context) {
            super(context);
            setWillNotDraw(false);
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            linearLayout.setOrientation(1);
            Paint paint = new Paint(1);
            this.paint = paint;
            paint.setShadowLayer(AndroidUtilities.dp(10.0f), 0.0f, AndroidUtilities.dp(12.0f), 620756992);
            this.activeTextColorKey = Theme.getColor(Theme.key_rubino_add_post_TabActiveText);
            this.unactiveTextColorKey = Theme.getColor(Theme.key_rubino_add_post_TabUnactiveText);
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setIncludeFontPadding(false);
            textView.setGravity(49);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTypeface(Theme.getRubinoTypeFaceMedium());
            textView.setTextColor(Theme.getColor(Theme.key_dialogTextGray2));
            textView.setTextSize(1, 12.0f);
            textView.setPadding(0, 0, 0, AndroidUtilities.dp(4.0f));
            linearLayout.addView(textView, LayoutHelper.createFrame(-1, -2, 49));
            FrameLayout frameLayout = new FrameLayout(this, context, sSHFilterView) { // from class: ir.appp.rghapp.components.SSHFilterView.SSHFilterCell.1
                @Override // android.widget.FrameLayout, android.view.View
                protected void onMeasure(int i, int i2) {
                    int iMin = Math.min(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i)) - AndroidUtilities.dp(8.0f);
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), View.MeasureSpec.makeMeasureSpec(iMin, 1073741824));
                }
            };
            this.aspectRatioFrameLayout = frameLayout;
            linearLayout.addView(frameLayout, LayoutHelper.createFrame(-1, -2, 17));
            TextureView textureView = new TextureView(context);
            this.textureView = textureView;
            textureView.setSurfaceTextureListener(sSHFilterView);
            textureView.setPivotX(0.0f);
            textureView.setPivotY(0.0f);
            textureView.setOpaque(false);
            textureView.setVisibility(8);
            frameLayout.addView(textureView, LayoutHelper.createFrame(-1, -1, 17));
            ImageView imageView = new ImageView(context);
            this.imageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            frameLayout.addView(imageView, LayoutHelper.createFrame(-1, -1, 17));
            TextView textView2 = new TextView(context);
            this.nameChar = textView2;
            textView2.setGravity(17);
            textView2.setTypeface(Theme.getRubinoTypeFaceBold());
            textView2.setTextColor(-1);
            textView2.setTextSize(1, 18.0f);
            textView2.setVisibility(8);
            frameLayout.addView(textView2, LayoutHelper.createFrame(-2, -2, 17));
            addView(linearLayout, LayoutHelper.createFrame(-1, -1, 17));
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent == null) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                this.startX = motionEvent.getX();
                this.startY = motionEvent.getY();
                updateScaleState(true, true);
                return true;
            }
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                updateScaleState(false, true);
                int iAbs = (int) Math.abs(motionEvent.getX() - this.startX);
                int iAbs2 = (int) Math.abs(motionEvent.getY() - this.startY);
                if (this.listener != null && iAbs < AndroidUtilities.dp(32.0f) && iAbs2 < AndroidUtilities.dp(32.0f)) {
                    this.listener.onClick(this);
                } else {
                    setSelected(this.selected);
                }
                return true;
            }
            motionEvent.getAction();
            return true;
        }

        public void setOnFilterClicked(OnFilterClicked onFilterClicked) {
            this.listener = onFilterClicked;
        }

        public void updateScaleState(boolean z, boolean z2) {
            this.isScaleDown = z;
            Animator animator = this.checkAnimator;
            if (animator != null) {
                animator.cancel();
            }
            if (z2) {
                float[] fArr = new float[1];
                fArr[0] = z ? 1.0f : 0.0f;
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "scaleState", fArr);
                this.checkAnimator = objectAnimatorOfFloat;
                objectAnimatorOfFloat.setDuration(200L);
                this.checkAnimator.start();
                return;
            }
            setScaleState(z ? 1.0f : 0.0f);
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            this.selected = z;
            this.textView.setTextColor(z ? this.activeTextColorKey : this.unactiveTextColorKey);
        }

        @Keep
        public float getScaleState() {
            return this.scaleState;
        }

        @Keep
        public void setScaleState(float f) {
            this.scaleState = f;
            float f2 = 1.0f - (f * 0.06f);
            setScaleX(f2);
            setScaleY(f2);
            this.textView.setTextColor((this.isScaleDown || this.selected) ? this.activeTextColorKey : this.unactiveTextColorKey);
            invalidate();
        }

        public void setTextAndIcon(CharSequence charSequence, Bitmap bitmap) {
            this.textView.setText(charSequence);
            if (charSequence.length() >= 1) {
                this.nameChar.setText(String.valueOf(charSequence.charAt(0)));
            }
            this.imageView.setImageBitmap(bitmap);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            canvas.drawRect(this.aspectRatioFrameLayout.getLeft(), this.aspectRatioFrameLayout.getTop(), this.aspectRatioFrameLayout.getRight(), this.aspectRatioFrameLayout.getBottom(), this.paint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private OnItemClickedListener listener;
        private final Context mContext;
        private final boolean showNameChar;

        public ListAdapter(Context context, boolean z) {
            this.mContext = context;
            this.showNameChar = z;
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
            return SSHFilterView.this.filters.size();
        }

        public FilterItem getItem(int i) {
            return (FilterItem) SSHFilterView.this.filters.get(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            RecyclerListView.Holder holder = new RecyclerListView.Holder(new SSHFilterCell(SSHFilterView.this, this.mContext));
            ((SSHFilterCell) holder.itemView).setOnFilterClicked(new OnFilterClicked() { // from class: ir.appp.rghapp.components.SSHFilterView$ListAdapter$$ExternalSyntheticLambda0
                @Override // ir.appp.rghapp.components.SSHFilterView.OnFilterClicked
                public final void onClick(View view) {
                    this.f$0.lambda$onCreateViewHolder$0(view);
                }
            });
            return holder;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$0(View view) {
            OnItemClickedListener onItemClickedListener = this.listener;
            if (onItemClickedListener != null) {
                onItemClickedListener.onClick(view, ((Integer) view.getTag()).intValue());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            FilterItem item = getItem(i);
            SSHFilterCell sSHFilterCell = (SSHFilterCell) viewHolder.itemView;
            sSHFilterCell.setSelected(i == SSHFilterView.this.selectedPosition);
            sSHFilterCell.setTextAndIcon(item.title, item.bitmap);
            if (i != 0 && this.showNameChar) {
                sSHFilterCell.nameChar.setVisibility(0);
            } else {
                viewHolder.setIsRecyclable(false);
                sSHFilterCell.textureView.setVisibility(0);
                sSHFilterCell.nameChar.setVisibility(8);
            }
            sSHFilterCell.setTag(Integer.valueOf(i));
        }
    }
}
