package ir.resaneh1.iptv.fragment.home;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.UIView.CirclePagerIndicatorDecorationAdSection;
import ir.resaneh1.iptv.fragment.home.ServiceRecyclerCell;
import ir.resaneh1.iptv.fragment.home.sectionInfo.DummyIndicator;
import ir.resaneh1.iptv.model.HomePageModels;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes3.dex */
public class ServiceViewPagerCell extends HomeCell {
    private ArrayList<HomePageModels.ServiceObject> arrayList;
    private ImageView arrowLeftImage;
    private ImageView arrowRightImage;
    private final boolean arrowsEnabled;
    private boolean canEdit;
    private int columnCount;
    private DragDelegate delegate;
    private int draggingPosition;
    private Boolean hasTopView;
    private CirclePagerIndicatorDecorationAdSection indicator;
    private FrameLayout innerFrameLayout;
    private int itemHeightInPx;
    private LinearLayoutManager layoutManager;
    private RecyclerListView listView;
    private final int[] location;
    private OnEditClickListener onEditClick;
    private int pageCount;
    private final Rect rect;
    private int rightAndLeftMargin;
    private int rowCount;
    private String sectionId;
    private ServiceListAdapter serviceListAdapter;
    private final int type;

    public interface DragDelegate {
        void onDragStartEvent(int i);
    }

    public interface OnEditClickListener {
        void onEditClick();
    }

    public void setTitle(String str) {
    }

    @Override // ir.resaneh1.iptv.fragment.home.HomeCell
    public View createMainView(Context context) throws IllegalStateException {
        FrameLayout frameLayout = new FrameLayout(context);
        this.innerFrameLayout = new FrameLayout(context);
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 0, true);
        this.layoutManager = linearLayoutManager;
        recyclerListView.setLayoutManager(linearLayoutManager);
        ServiceListAdapter serviceListAdapter = new ServiceListAdapter();
        this.serviceListAdapter = serviceListAdapter;
        this.listView.setAdapter(serviceListAdapter);
        if (this.arrowsEnabled) {
            this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.home.ServiceViewPagerCell.1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                    super.onScrolled(recyclerView, i, i2);
                    ServiceViewPagerCell.this.updateArrows(false);
                }
            });
        }
        new PagerSnapHelper().attachToRecyclerView(this.listView);
        if (Build.VERSION.SDK_INT >= 21) {
            this.listView.setNestedScrollingEnabled(false);
        }
        this.innerFrameLayout.addView(this.listView);
        CirclePagerIndicatorDecorationAdSection circlePagerIndicatorDecorationAdSection = new CirclePagerIndicatorDecorationAdSection();
        this.indicator = circlePagerIndicatorDecorationAdSection;
        circlePagerIndicatorDecorationAdSection.setColorActive(Color.parseColor("#4a1e73"));
        this.indicator.setColorInactive(Color.parseColor("#a8a8a8"));
        this.indicator.setRtlLayout(true);
        this.indicator.setIndicatorItemSize(AndroidUtilities.dp(8.0f));
        this.indicator.setIndicatorItemPadding(AndroidUtilities.dp(6.0f));
        this.listView.addItemDecoration(this.indicator);
        frameLayout.addView(this.innerFrameLayout, LayoutHelper.createFrame(-1, -1, 17, 8.0f, 11.0f, 8.0f, 6.0f));
        return frameLayout;
    }

    public ServiceViewPagerCell(Context context, int i, boolean z, boolean z2, int i2) {
        super(context);
        this.arrayList = new ArrayList<>();
        this.rowCount = 2;
        this.itemHeightInPx = AndroidUtilities.dp(220.0f);
        this.draggingPosition = -1;
        this.rect = new Rect();
        this.location = new int[2];
        this.type = i;
        this.rightAndLeftMargin = i2;
        this.arrowsEnabled = z2;
        this.hasTopView = Boolean.valueOf(z);
        if (z) {
            getHeaderInfoCell().overrideClickListeners(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.home.ServiceViewPagerCell$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0(view);
                }
            });
            getHeaderInfoCell().setImageLongClickListeners(new View.OnLongClickListener() { // from class: ir.resaneh1.iptv.fragment.home.ServiceViewPagerCell$$ExternalSyntheticLambda3
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return this.f$0.lambda$new$1(view);
                }
            });
        }
        if (z2) {
            ImageView imageView = new ImageView(context);
            this.arrowLeftImage = imageView;
            imageView.setImageResource(R.drawable.arrow_left);
            ImageView imageView2 = new ImageView(context);
            this.arrowRightImage = imageView2;
            imageView2.setImageResource(R.drawable.arrow_right);
            initArrowClickListener();
            this.innerFrameLayout.addView(this.arrowLeftImage, org.rbmain.ui.Components.LayoutHelper.createFrame(24, 24.0f, 19, 0.0f, 0.0f, 0.0f, 0.0f));
            this.innerFrameLayout.addView(this.arrowRightImage, org.rbmain.ui.Components.LayoutHelper.createFrame(24, 24.0f, 21, 0.0f, 0.0f, 0.0f, 0.0f));
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.itemHeightInPx, 48);
        layoutParams.topMargin = 2;
        int iDp = z2 ? AndroidUtilities.dp(24.0f) : 0;
        layoutParams.rightMargin = iDp;
        layoutParams.leftMargin = iDp;
        this.listView.setLayoutParams(layoutParams);
        DummyIndicator dummyIndicator = getDummyIndicator();
        dummyIndicator.setVisibility(0);
        dummyIndicator.setRecyclerView(this.listView);
        dummyIndicator.setIndicator(this.indicator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view) {
        OnEditClickListener onEditClickListener = this.onEditClick;
        if (onEditClickListener != null) {
            onEditClickListener.onEditClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$1(View view) {
        OnEditClickListener onEditClickListener = this.onEditClick;
        if (onEditClickListener == null) {
            return true;
        }
        onEditClickListener.onEditClick();
        return true;
    }

    private void initArrowClickListener() {
        this.arrowLeftImage.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.home.ServiceViewPagerCell$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initArrowClickListener$2(view);
            }
        });
        this.arrowRightImage.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.home.ServiceViewPagerCell$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$initArrowClickListener$3(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initArrowClickListener$2(View view) {
        goToNextPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initArrowClickListener$3(View view) {
        goToPreviousPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateArrows(boolean z) {
        if (this.arrowsEnabled) {
            int iFindFirstCompletelyVisibleItemPosition = this.layoutManager.findFirstCompletelyVisibleItemPosition();
            if (z || iFindFirstCompletelyVisibleItemPosition != -1) {
                int i = this.pageCount;
                if (i < 2) {
                    this.arrowLeftImage.setVisibility(4);
                    this.arrowRightImage.setVisibility(4);
                } else if (iFindFirstCompletelyVisibleItemPosition < i - 1 || z) {
                    this.arrowRightImage.setVisibility(4);
                    this.arrowLeftImage.setVisibility(0);
                } else {
                    this.arrowLeftImage.setVisibility(4);
                    this.arrowRightImage.setVisibility(0);
                }
            }
        }
    }

    public void setOnEditClick(OnEditClickListener onEditClickListener) {
        this.onEditClick = onEditClickListener;
    }

    public void updateItem(ArrayList<HomePageModels.ServiceObject> arrayList) {
        this.arrayList = arrayList;
        this.serviceListAdapter.notifyDataSetChanged();
    }

    public void setData(HomePageModels.HomePageSectionObject homePageSectionObject) {
        setData(homePageSectionObject, true);
    }

    public void setData(HomePageModels.HomePageSectionObject homePageSectionObject, boolean z) {
        HomePageModels.IndicatorInfoObject indicatorInfoObject;
        if (homePageSectionObject != null) {
            setServiceInfo(homePageSectionObject.common_section_data, homePageSectionObject.type, this.hasTopView.booleanValue());
            DummyIndicator dummyIndicator = getDummyIndicator();
            HomePageModels.CommonSectionDataObject commonSectionDataObject = homePageSectionObject.common_section_data;
            if (commonSectionDataObject != null && (indicatorInfoObject = commonSectionDataObject.indicator_info) != null) {
                this.indicator.setActive(true);
                dummyIndicator.setActive(false);
                String str = indicatorInfoObject.selected_color_code;
                if (str != null) {
                    this.indicator.setColorActive(Color.parseColor(str));
                } else {
                    this.indicator.setColorActive(Color.parseColor("#4a1e73"));
                }
                String str2 = indicatorInfoObject.unselected_color_code;
                if (str2 != null) {
                    this.indicator.setColorInactive(Color.parseColor(str2));
                } else {
                    this.indicator.setColorInactive(Color.parseColor("#334a1e73"));
                }
                int i = AnonymousClass2.$SwitchMap$ir$resaneh1$iptv$model$HomePageModels$IndicatorSizeType[indicatorInfoObject.size.ordinal()];
                this.indicator.setIndicatorItemSize(AndroidUtilities.dp(i != 1 ? i != 2 ? 8.0f : 6.0f : 10.0f));
            }
            if (z) {
                return;
            }
            setCardElevation(AndroidUtilities.dp(2.0f));
        }
    }

    /* renamed from: ir.resaneh1.iptv.fragment.home.ServiceViewPagerCell$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$ir$resaneh1$iptv$model$HomePageModels$IndicatorSizeType;

        static {
            int[] iArr = new int[HomePageModels.IndicatorSizeType.values().length];
            $SwitchMap$ir$resaneh1$iptv$model$HomePageModels$IndicatorSizeType = iArr;
            try {
                iArr[HomePageModels.IndicatorSizeType.Big.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ir$resaneh1$iptv$model$HomePageModels$IndicatorSizeType[HomePageModels.IndicatorSizeType.Small.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void setItem(String str, ArrayList<HomePageModels.ServiceObject> arrayList, double d, int i, boolean z, boolean z2) {
        this.sectionId = str;
        this.columnCount = d > 0.0d ? (int) d : 1;
        if (i <= 0) {
            i = 1;
        }
        this.rowCount = i;
        this.arrayList = arrayList;
        this.pageCount = (arrayList == null || arrayList.isEmpty() || this.columnCount <= 0 || this.rowCount <= 0) ? 1 : (int) Math.ceil((this.arrayList.size() * 1.0f) / (this.columnCount * this.rowCount));
        this.itemHeightInPx = ServiceRecyclerCell.getItemHeightInPx(this.columnCount, AndroidUtilities.dp(64.0f)) * this.rowCount;
        if (this.listView.getLayoutParams().height != this.itemHeightInPx) {
            this.listView.getLayoutParams().height = this.itemHeightInPx;
        }
        if (!z2) {
            updateHeight();
        }
        updateArrows(true);
        this.serviceListAdapter.notifyDataSetChanged();
    }

    public void updateHeight() {
        if (this.arrayList.size() < 5) {
            this.listView.getLayoutParams().height = this.itemHeightInPx / 2;
        } else {
            this.listView.getLayoutParams().height = this.itemHeightInPx;
        }
    }

    public void updateItems() {
        ArrayList<HomePageModels.ServiceObject> arrayList = this.arrayList;
        this.pageCount = (arrayList == null || arrayList.isEmpty() || this.columnCount <= 0) ? 1 : (int) Math.ceil((this.arrayList.size() * 1.0f) / (this.columnCount * this.rowCount));
        this.serviceListAdapter.notifyDataSetChanged();
        updateArrows(false);
    }

    private void goToNextPage() {
        int iFindFirstCompletelyVisibleItemPosition = this.layoutManager.findFirstCompletelyVisibleItemPosition() + 1;
        if (iFindFirstCompletelyVisibleItemPosition < this.pageCount) {
            this.layoutManager.scrollToPosition(iFindFirstCompletelyVisibleItemPosition);
        }
    }

    private void goToPreviousPage() {
        int iFindFirstCompletelyVisibleItemPosition = this.layoutManager.findFirstCompletelyVisibleItemPosition() - 1;
        if (iFindFirstCompletelyVisibleItemPosition >= 0) {
            this.layoutManager.scrollToPosition(iFindFirstCompletelyVisibleItemPosition);
        }
    }

    public ArrayList<HomePageModels.ServiceObject> getList() {
        for (int i = 0; i < this.arrayList.size(); i++) {
            this.arrayList.get(i).priority = i;
        }
        return this.arrayList;
    }

    public String getSectionId() {
        return this.sectionId;
    }

    public void onDragPosition(final DragEvent dragEvent) {
        if (dragEvent == null || !this.arrowsEnabled) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.fragment.home.ServiceViewPagerCell$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onDragPosition$4(dragEvent);
            }
        }, 10L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDragPosition$4(DragEvent dragEvent) {
        if (this.arrowLeftImage.getVisibility() == 0) {
            if (isInViewBounds((int) dragEvent.getX(), (int) dragEvent.getY(), this.arrowLeftImage)) {
                goToNextPage();
            }
        } else if (this.arrowRightImage.getVisibility() == 0 && isInViewBounds((int) dragEvent.getX(), (int) dragEvent.getY(), this.arrowRightImage)) {
            goToPreviousPage();
        }
    }

    private boolean isInViewBounds(int i, int i2, ImageView imageView) {
        if (imageView == null) {
            return false;
        }
        imageView.getDrawingRect(this.rect);
        imageView.getLocationOnScreen(this.location);
        Rect rect = this.rect;
        int[] iArr = this.location;
        rect.offset(iArr[0], iArr[1]);
        return this.rect.contains(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ServiceListAdapter extends RecyclerListView.SelectionAdapter {
        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        private ServiceListAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            ServiceRecyclerCell serviceRecyclerCell = new ServiceRecyclerCell(viewGroup.getContext(), ServiceViewPagerCell.this.rightAndLeftMargin);
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -1);
            serviceRecyclerCell.setDelegate(new ServiceRecyclerCell.ServiceCellDelegate() { // from class: ir.resaneh1.iptv.fragment.home.ServiceViewPagerCell$ServiceListAdapter$$ExternalSyntheticLambda0
                @Override // ir.resaneh1.iptv.fragment.home.ServiceRecyclerCell.ServiceCellDelegate
                public final boolean onLongClick(View view, int i2) {
                    return this.f$0.lambda$onCreateViewHolder$0(view, i2);
                }
            });
            serviceRecyclerCell.setLayoutParams(layoutParams);
            return new RecyclerListView.Holder(serviceRecyclerCell);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$onCreateViewHolder$0(View view, int i) {
            if (!ServiceViewPagerCell.this.canEdit) {
                return false;
            }
            if (ServiceViewPagerCell.this.delegate != null) {
                ServiceViewPagerCell.this.delegate.onDragStartEvent(ServiceViewPagerCell.this.getType());
            }
            ServiceViewPagerCell.this.draggingPosition = i;
            ((HomePageModels.ServiceObject) ServiceViewPagerCell.this.arrayList.get(ServiceViewPagerCell.this.draggingPosition)).isDragging = true;
            ClipData clipDataNewPlainText = ClipData.newPlainText(BuildConfig.FLAVOR, BuildConfig.FLAVOR);
            View.DragShadowBuilder dragShadowBuilder = new View.DragShadowBuilder(view);
            if (Build.VERSION.SDK_INT >= 24) {
                view.startDragAndDrop(clipDataNewPlainText, dragShadowBuilder, view, 0);
            } else {
                view.startDrag(clipDataNewPlainText, dragShadowBuilder, view, 0);
            }
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            ServiceRecyclerCell serviceRecyclerCell = (ServiceRecyclerCell) viewHolder.itemView;
            int i2 = ServiceViewPagerCell.this.columnCount * i * ServiceViewPagerCell.this.rowCount;
            serviceRecyclerCell.setTag(Integer.valueOf(i));
            serviceRecyclerCell.setIsEditing(ServiceViewPagerCell.this.canEdit);
            serviceRecyclerCell.setItem(ServiceViewPagerCell.this.arrayList, i2, ServiceViewPagerCell.this.columnCount * ServiceViewPagerCell.this.rowCount, ServiceViewPagerCell.this.columnCount, (ServiceViewPagerCell.this.itemHeightInPx - AndroidUtilities.dp(24.0f)) / ServiceViewPagerCell.this.rowCount);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return ServiceViewPagerCell.this.pageCount;
        }
    }

    public void setDelegate(DragDelegate dragDelegate) {
        this.delegate = dragDelegate;
    }

    public int getCurrentCount() {
        View currentRecyclerCell = getCurrentRecyclerCell();
        if (currentRecyclerCell instanceof ServiceRecyclerCell) {
            return ((ServiceRecyclerCell) currentRecyclerCell).getItemCount();
        }
        return 0;
    }

    public int getCurrentPosition(DragEvent dragEvent) {
        View currentRecyclerCell = getCurrentRecyclerCell();
        if (currentRecyclerCell instanceof ServiceRecyclerCell) {
            return ((ServiceRecyclerCell) currentRecyclerCell).getCurrentPosition(dragEvent);
        }
        return -1;
    }

    public int getType() {
        return this.type;
    }

    public HomePageModels.ServiceObject removeOnDragExited() {
        int i = this.draggingPosition;
        if (i < 0 || i > this.arrayList.size() - 1) {
            return null;
        }
        HomePageModels.ServiceObject serviceObjectRemove = this.arrayList.remove(this.draggingPosition);
        updateItems();
        this.draggingPosition = -1;
        return serviceObjectRemove;
    }

    public void insertOnDragEntered(HomePageModels.ServiceObject serviceObject, int i) {
        if (serviceObject == null) {
            return;
        }
        if (i == -1) {
            i = this.arrayList.size();
        }
        this.arrayList.add(i, serviceObject);
        updateItems();
        this.draggingPosition = i;
    }

    public View getCurrentRecyclerCell() {
        if (this.listView == null) {
            return null;
        }
        return this.listView.findViewWithTag(Integer.valueOf(this.layoutManager.findLastCompletelyVisibleItemPosition()));
    }

    public void moveDraggingItemPosition(int i) {
        int i2 = this.draggingPosition;
        if (i == i2 || i == -1 || i2 == -1 || !(getCurrentRecyclerCell() instanceof ServiceRecyclerCell)) {
            return;
        }
        this.arrayList.add(i, this.arrayList.remove(this.draggingPosition));
        onRefreshList();
        this.draggingPosition = i;
    }

    private void onRefreshList() {
        ServiceListAdapter serviceListAdapter = this.serviceListAdapter;
        if (serviceListAdapter != null) {
            serviceListAdapter.notifyDataSetChanged();
        }
    }

    public void refresh() {
        if (this.draggingPosition != -1 && (getCurrentRecyclerCell() instanceof ServiceRecyclerCell)) {
            this.arrayList.get(this.draggingPosition).isDragging = false;
            onRefreshList();
            this.draggingPosition = -1;
        }
    }

    public void setCanEdit(boolean z) {
        this.canEdit = z;
        View currentRecyclerCell = getCurrentRecyclerCell();
        if (currentRecyclerCell instanceof ServiceRecyclerCell) {
            ((ServiceRecyclerCell) currentRecyclerCell).setIsEditing(z);
        }
    }
}
