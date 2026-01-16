package ir.resaneh1.iptv.fragment.home;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import ir.medu.shad.R;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.fragment.home.ServiceRecyclerCell;
import ir.resaneh1.iptv.fragment.home.ServiceViewPagerCell;
import ir.resaneh1.iptv.model.HomePageModels;
import ir.resaneh1.iptv.model.MessangerOutput;
import java.util.ArrayList;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.ViewHelper;

/* loaded from: classes3.dex */
public class EditFavoriteServicesBottomSheet extends BottomSheet {
    private final ListAdapter adapter;
    private final ServiceViewPagerCell allServices;
    private int allServicesRow;
    private int draggingAdapterType;
    private int favServicesRow;
    private FavoriteServiceCallback favoriteServiceCallback;
    private final ServiceViewPagerCell favoriteServices;
    private boolean ignoreLayout;
    private int infoRow;
    private final View.OnDragListener listDragListener;
    private RecyclerListView listView;
    private HomeLoadingCell loadingCell;
    private int mode;
    private int preDraggingAdapterType;
    private HomePageModels.ServiceObject removedItem;
    private int rowCount;
    private int scrollOffsetY;
    private TextView textViewButton;
    private String title1;
    private int title1Row;
    private String title2;
    private int title2Row;

    public interface FavoriteServiceCallback {
        void onSave(ArrayList<HomePageModels.ServiceObject> arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(View view, DragEvent dragEvent) {
        HomePageModels.ServiceObject serviceObject;
        int i;
        Object localState = dragEvent.getLocalState();
        ServiceViewPagerCell serviceViewPagerCell = (ServiceViewPagerCell) view;
        int currentPosition = serviceViewPagerCell.getCurrentPosition(dragEvent);
        if (currentPosition == -1) {
            currentPosition = serviceViewPagerCell.getCurrentCount() - 1;
        }
        switch (dragEvent.getAction()) {
            case 1:
                if (localState instanceof ServiceRecyclerCell.ServiceCell) {
                    ((ServiceRecyclerCell.ServiceCell) localState).refreshView();
                }
                return true;
            case 2:
                serviceViewPagerCell.moveDraggingItemPosition(currentPosition);
                serviceViewPagerCell.onDragPosition(dragEvent);
                return true;
            case 4:
                if (this.draggingAdapterType == 0 && (serviceObject = this.removedItem) != null && ((i = this.preDraggingAdapterType) == 1 || i == 2)) {
                    serviceViewPagerCell.insertOnDragEntered(serviceObject, -1);
                }
                this.preDraggingAdapterType = -1;
                this.removedItem = null;
                serviceViewPagerCell.refresh();
                save();
                break;
            case 3:
                return true;
            case 5:
                if (serviceViewPagerCell.getType() != this.draggingAdapterType) {
                    this.draggingAdapterType = serviceViewPagerCell.getType();
                    serviceViewPagerCell.insertOnDragEntered(this.removedItem, currentPosition);
                    this.removedItem = null;
                }
                return true;
            case 6:
                int type = serviceViewPagerCell.getType();
                int i2 = this.draggingAdapterType;
                if (type == i2) {
                    if (this.preDraggingAdapterType == -1) {
                        this.preDraggingAdapterType = i2;
                    }
                    this.draggingAdapterType = 0;
                    this.removedItem = serviceViewPagerCell.removeOnDragExited();
                }
                return true;
            default:
                return false;
        }
    }

    public EditFavoriteServicesBottomSheet(Context context, FavoriteServiceCallback favoriteServiceCallback) {
        super(context, true);
        this.draggingAdapterType = -1;
        this.preDraggingAdapterType = -1;
        this.removedItem = null;
        View.OnDragListener onDragListener = new View.OnDragListener() { // from class: ir.resaneh1.iptv.fragment.home.EditFavoriteServicesBottomSheet$$ExternalSyntheticLambda1
            @Override // android.view.View.OnDragListener
            public final boolean onDrag(View view, DragEvent dragEvent) {
                return this.f$0.lambda$new$0(view, dragEvent);
            }
        };
        this.listDragListener = onDragListener;
        this.title1Row = -1;
        this.title2Row = -1;
        this.infoRow = -1;
        this.allServicesRow = -1;
        this.favServicesRow = -1;
        this.rowCount = 0;
        this.favoriteServiceCallback = favoriteServiceCallback;
        this.containerView = new FrameLayout(context) { // from class: ir.resaneh1.iptv.fragment.home.EditFavoriteServicesBottomSheet.1
            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 && EditFavoriteServicesBottomSheet.this.scrollOffsetY != 0 && motionEvent.getY() < EditFavoriteServicesBottomSheet.this.scrollOffsetY) {
                    EditFavoriteServicesBottomSheet.this.dismiss();
                    return true;
                }
                return super.onInterceptTouchEvent(motionEvent);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                return !EditFavoriteServicesBottomSheet.this.isDismissed() && super.onTouchEvent(motionEvent);
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                int size = View.MeasureSpec.getSize(i2);
                if (Build.VERSION.SDK_INT >= 21) {
                    size -= AndroidUtilities.statusBarHeight;
                }
                ((FrameLayout.LayoutParams) EditFavoriteServicesBottomSheet.this.listView.getLayoutParams()).topMargin = AndroidUtilities.dp(65.0f);
                getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                double d = measuredHeight;
                double d2 = size / 5.0f;
                Double.isNaN(d2);
                int i3 = d < d2 * 3.2d ? 0 : (size / 5) * 2;
                if (i3 != 0 && measuredHeight < size) {
                    i3 -= size - measuredHeight;
                }
                if (i3 == 0) {
                    i3 = ((BottomSheet) EditFavoriteServicesBottomSheet.this).backgroundPaddingTop;
                }
                if (EditFavoriteServicesBottomSheet.this.listView.getPaddingTop() != i3) {
                    EditFavoriteServicesBottomSheet.this.ignoreLayout = true;
                    EditFavoriteServicesBottomSheet.this.listView.setPadding(0, i3, 0, 0);
                    EditFavoriteServicesBottomSheet.this.ignoreLayout = false;
                }
                super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, 1073741824));
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
                super.onLayout(z, i, i2, i3, i4);
                EditFavoriteServicesBottomSheet.this.updateLayout();
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (EditFavoriteServicesBottomSheet.this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                super.onDraw(canvas);
                ((BottomSheet) EditFavoriteServicesBottomSheet.this).shadowDrawable.setBounds(0, (EditFavoriteServicesBottomSheet.this.scrollOffsetY - ((BottomSheet) EditFavoriteServicesBottomSheet.this).backgroundPaddingTop) + AndroidUtilities.statusBarHeight, getMeasuredWidth(), getMeasuredHeight());
                ((BottomSheet) EditFavoriteServicesBottomSheet.this).shadowDrawable.draw(canvas);
            }
        };
        Drawable drawableMutate = context.getResources().getDrawable(R.drawable.sheet_shadow_round).mutate();
        this.shadowDrawable = drawableMutate;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_dialogBackground), PorterDuff.Mode.MULTIPLY));
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.resaneh1.iptv.fragment.home.EditFavoriteServicesBottomSheet.2
            @Override // org.rbmain.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (EditFavoriteServicesBottomSheet.this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }
        };
        this.listView = recyclerListView;
        recyclerListView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        RecyclerListView recyclerListView2 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.adapter = listAdapter;
        recyclerListView2.setAdapter(listAdapter);
        this.listView.setVerticalScrollBarEnabled(false);
        this.listView.setClipToPadding(false);
        this.listView.setEnabled(true);
        this.listView.setGlowColor(Theme.getColor(Theme.key_dialogScrollGlow));
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.resaneh1.iptv.fragment.home.EditFavoriteServicesBottomSheet.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                EditFavoriteServicesBottomSheet.this.updateLayout();
            }
        });
        this.containerView.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackground(context.getResources().getDrawable(R.drawable.shape_grey_background_round));
        TextView textViewCreateTextViewBlack = ViewHelper.createTextViewBlack(context, 12, false);
        this.textViewButton = textViewCreateTextViewBlack;
        textViewCreateTextViewBlack.setPadding(AndroidUtilities.dp(16.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(16.0f), AndroidUtilities.dp(8.0f));
        this.textViewButton.setMinimumWidth(AndroidUtilities.dp(112.0f));
        this.textViewButton.setGravity(17);
        frameLayout.addView(this.textViewButton, LayoutHelper.createFrame(-2, -2.0f));
        HomeLoadingCell homeLoadingCell = new HomeLoadingCell(context, 16);
        this.loadingCell = homeLoadingCell;
        frameLayout.addView(homeLoadingCell, LayoutHelper.createFrame(18, 18, 17));
        ServiceViewPagerCell serviceViewPagerCell = new ServiceViewPagerCell(context, 1, false, false, AndroidUtilities.dp(32.0f));
        this.favoriteServices = serviceViewPagerCell;
        serviceViewPagerCell.setDelegate(new ServiceViewPagerCell.DragDelegate() { // from class: ir.resaneh1.iptv.fragment.home.EditFavoriteServicesBottomSheet$$ExternalSyntheticLambda2
            @Override // ir.resaneh1.iptv.fragment.home.ServiceViewPagerCell.DragDelegate
            public final void onDragStartEvent(int i) {
                this.f$0.lambda$new$1(i);
            }
        });
        ServiceViewPagerCell serviceViewPagerCell2 = new ServiceViewPagerCell(context, 2, false, false, AndroidUtilities.dp(32.0f));
        this.allServices = serviceViewPagerCell2;
        serviceViewPagerCell2.setDelegate(new ServiceViewPagerCell.DragDelegate() { // from class: ir.resaneh1.iptv.fragment.home.EditFavoriteServicesBottomSheet$$ExternalSyntheticLambda3
            @Override // ir.resaneh1.iptv.fragment.home.ServiceViewPagerCell.DragDelegate
            public final void onDragStartEvent(int i) {
                this.f$0.lambda$new$2(i);
            }
        });
        serviceViewPagerCell.setOnDragListener(onDragListener);
        serviceViewPagerCell2.setOnDragListener(onDragListener);
        this.mode = 1;
        this.containerView.setWillNotDraw(false);
        ViewGroup viewGroup = this.containerView;
        int i = this.backgroundPaddingLeft;
        viewGroup.setPadding(i, 0, i, 0);
        changeMode(this.mode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(int i) {
        this.draggingAdapterType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(int i) {
        this.draggingAdapterType = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeMode(int i) {
        if (i != 1) {
            return;
        }
        this.mode = i;
        this.textViewButton.setText(BuildConfig.FLAVOR);
        this.textViewButton.setOnClickListener(null);
        this.loadingCell.setVisibility(4);
        this.favoriteServices.setCanEdit(i == 1);
        this.allServices.setCanEdit(i == 1);
        if (i == 0) {
            this.textViewButton.setText(LocaleController.getString("btnEdit", R.string.btnEdit));
            this.textViewButton.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.home.EditFavoriteServicesBottomSheet$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$changeMode$3(view);
                }
            });
        } else if (i == 1) {
            this.textViewButton.setText(LocaleController.getString("btnSave", R.string.btnSave));
            this.textViewButton.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.home.EditFavoriteServicesBottomSheet.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EditFavoriteServicesBottomSheet.this.save();
                }
            });
        } else if (i == 2) {
            this.textViewButton.setText(BuildConfig.FLAVOR);
            this.loadingCell.setVisibility(0);
            this.textViewButton.setOnClickListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeMode$3(View view) {
        changeMode(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void save() {
        changeMode(2);
        HomePageModels.SetUserFavoriteServicesInput setUserFavoriteServicesInput = new HomePageModels.SetUserFavoriteServicesInput();
        ArrayList<HomePageModels.ServiceObject> list = this.favoriteServices.getList();
        ArrayList<HomePageModels.InputServiceObject> arrayList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            Iterator<HomePageModels.ServiceObject> it = this.favoriteServices.getList().iterator();
            while (it.hasNext()) {
                arrayList.add(HomePageModels.InputServiceObject.createFromServiceObject(it.next()));
            }
        }
        setUserFavoriteServicesInput.services_list = arrayList;
        setUserFavoriteServicesInput.section_id = this.favoriteServices.getSectionId();
        final AlertDialog alertDialog = new AlertDialog(getContext(), 3);
        alertDialog.show();
        ApplicationLoader.applicationActivity.mainCompositeDisposable.add((Disposable) ApiRequestMessangerRx.getInstance(UserConfig.selectedAccount).setUserFavoriteServices(setUserFavoriteServicesInput).subscribeWith(new DisposableObserver<MessangerOutput<HomePageModels.SetUserFavoriteServicesOutput>>() { // from class: ir.resaneh1.iptv.fragment.home.EditFavoriteServicesBottomSheet.5
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<HomePageModels.SetUserFavoriteServicesOutput> messangerOutput) {
                EditFavoriteServicesBottomSheet.this.changeMode(0);
                EditFavoriteServicesBottomSheet.this.favoriteServiceCallback.onSave(EditFavoriteServicesBottomSheet.this.favoriteServices.getList());
                alertDialog.dismiss();
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                alertDialog.dismiss();
                EditFavoriteServicesBottomSheet.this.changeMode(0);
            }
        }));
        changeMode(0);
    }

    public void setItems(HomePageModels.HomePageSectionObject homePageSectionObject, HomePageModels.UserFavoriteServicesSectionObject userFavoriteServicesSectionObject, HomePageModels.HomePageSectionObject homePageSectionObject2) {
        HomePageModels.HeaderInfoObject headerInfoObject;
        String str;
        HomePageModels.HeaderInfoObject headerInfoObject2;
        String str2;
        this.favoriteServices.setItem(homePageSectionObject.id, new ArrayList<>(userFavoriteServicesSectionObject.user_favorite_services_list), userFavoriteServicesSectionObject.column, userFavoriteServicesSectionObject.row, true, true);
        HomePageModels.CommonSectionDataObject commonSectionDataObject = homePageSectionObject.common_section_data;
        if (commonSectionDataObject != null && (headerInfoObject2 = commonSectionDataObject.header_info) != null && (str2 = headerInfoObject2.title) != null) {
            this.title1 = str2;
        } else {
            this.title1 = BuildConfig.FLAVOR;
        }
        HomePageModels.CommonSectionDataObject commonSectionDataObject2 = homePageSectionObject2.common_section_data;
        if (commonSectionDataObject2 != null && (headerInfoObject = commonSectionDataObject2.header_info) != null && (str = headerInfoObject.title) != null) {
            this.title2 = str;
        } else {
            this.title2 = BuildConfig.FLAVOR;
        }
        ArrayList<HomePageModels.ServiceObject> arrayList = new ArrayList<>();
        Iterator<HomePageModels.ServiceObject> it = homePageSectionObject2.all_services_section.all_services_items_list.iterator();
        while (true) {
            boolean z = false;
            if (it.hasNext()) {
                HomePageModels.ServiceObject next = it.next();
                Iterator<HomePageModels.ServiceObject> it2 = userFavoriteServicesSectionObject.user_favorite_services_list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    HomePageModels.ServiceObject next2 = it2.next();
                    String str3 = next.id;
                    if (str3 != null && str3.equals(next2.id)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    arrayList.add(next);
                }
            } else {
                this.allServices.setItem(BuildConfig.FLAVOR, arrayList, userFavoriteServicesSectionObject.column, 3, true, true);
                this.allServices.setData(homePageSectionObject, false);
                this.favoriteServices.setData(homePageSectionObject, false);
                updateRows();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayout() {
        if (this.listView.getChildCount() <= 0) {
            RecyclerListView recyclerListView = this.listView;
            int paddingTop = recyclerListView.getPaddingTop();
            this.scrollOffsetY = paddingTop;
            recyclerListView.setTopGlowOffset(paddingTop);
            this.containerView.invalidate();
            return;
        }
        int i = 0;
        View childAt = this.listView.getChildAt(0);
        RecyclerListView.Holder holder = (RecyclerListView.Holder) this.listView.findContainingViewHolder(childAt);
        int top = childAt.getTop() - AndroidUtilities.dp(9.0f);
        if (top > 0 && holder != null && holder.getAdapterPosition() == 0) {
            i = top;
        }
        if (this.scrollOffsetY != i) {
            RecyclerListView recyclerListView2 = this.listView;
            this.scrollOffsetY = i;
            recyclerListView2.setTopGlowOffset(i);
            this.containerView.invalidate();
        }
    }

    private void updateRows() {
        this.title1Row = -1;
        this.title2Row = -1;
        this.infoRow = -1;
        this.allServicesRow = -1;
        this.favServicesRow = -1;
        this.rowCount = 0;
        if (!TextUtils.isEmpty(this.title1)) {
            int i = this.rowCount;
            this.rowCount = i + 1;
            this.title1Row = i;
        }
        int i2 = this.rowCount;
        int i3 = i2 + 1;
        this.rowCount = i3;
        this.infoRow = i2;
        this.rowCount = i3 + 1;
        this.favServicesRow = i3;
        if (!TextUtils.isEmpty(this.title2)) {
            int i4 = this.rowCount;
            this.rowCount = i4 + 1;
            this.title2Row = i4;
        }
        int i5 = this.rowCount;
        this.rowCount = i5 + 1;
        this.allServicesRow = i5;
        ListAdapter listAdapter = this.adapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context context;

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        public ListAdapter(Context context) {
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return EditFavoriteServicesBottomSheet.this.rowCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == EditFavoriteServicesBottomSheet.this.title1Row) {
                return 0;
            }
            if (i == EditFavoriteServicesBottomSheet.this.title2Row) {
                return 1;
            }
            if (i == EditFavoriteServicesBottomSheet.this.infoRow) {
                return 2;
            }
            if (i == EditFavoriteServicesBottomSheet.this.favServicesRow) {
                return 3;
            }
            return i == EditFavoriteServicesBottomSheet.this.allServicesRow ? 4 : 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View viewCreateTextViewBlack;
            if (i == 3 || i == 4) {
                viewCreateTextViewBlack = i == 3 ? EditFavoriteServicesBottomSheet.this.favoriteServices : EditFavoriteServicesBottomSheet.this.allServices;
            } else {
                viewCreateTextViewBlack = ViewHelper.createTextViewBlack(this.context, 12, i != 2);
            }
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
            layoutParams.setMargins(AndroidUtilities.dp(16.0f), i != 0 ? AndroidUtilities.dp(8.0f) : 0, AndroidUtilities.dp(16.0f), i == 4 ? AndroidUtilities.dp(16.0f) : 0);
            viewCreateTextViewBlack.setLayoutParams(layoutParams);
            return new RecyclerListView.Holder(viewCreateTextViewBlack);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (i == EditFavoriteServicesBottomSheet.this.title1Row) {
                ((TextView) viewHolder.itemView).setText(EditFavoriteServicesBottomSheet.this.title1);
            } else {
                if (i != EditFavoriteServicesBottomSheet.this.infoRow) {
                    if (i == EditFavoriteServicesBottomSheet.this.title2Row) {
                        ((TextView) viewHolder.itemView).setText(EditFavoriteServicesBottomSheet.this.title2);
                        return;
                    }
                    return;
                }
                ((TextView) viewHolder.itemView).setText(LocaleController.getString("userFavoriteServicesInfo", R.string.userFavoriteServicesInfo));
            }
        }
    }
}
