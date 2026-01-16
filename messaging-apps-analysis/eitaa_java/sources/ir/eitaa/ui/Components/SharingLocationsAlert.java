package ir.eitaa.ui.Components;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.LocationController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Cells.SharingLiveLocationCell;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.ContentPreviewViewer;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class SharingLocationsAlert extends BottomSheet implements NotificationCenter.NotificationCenterDelegate {
    private ListAdapter adapter;
    private SharingLocationsAlertDelegate delegate;
    private boolean ignoreLayout;
    private RecyclerListView listView;
    private int scrollOffsetY;
    private Drawable shadowDrawable;
    private TextView textView;

    public interface SharingLocationsAlertDelegate {
        void didSelectLocation(LocationController.SharingLocationInfo info);
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet
    protected boolean canDismissWithSwipe() {
        return false;
    }

    public SharingLocationsAlert(Context context, SharingLocationsAlertDelegate sharingLocationsAlertDelegate, Theme.ResourcesProvider resourcesProvider) {
        super(context, false, resourcesProvider);
        NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.liveLocationsChanged);
        this.delegate = sharingLocationsAlertDelegate;
        Drawable drawableMutate = context.getResources().getDrawable(R.drawable.sheet_shadow_round).mutate();
        this.shadowDrawable = drawableMutate;
        drawableMutate.setColorFilter(new PorterDuffColorFilter(getThemedColor("dialogBackground"), PorterDuff.Mode.MULTIPLY));
        FrameLayout frameLayout = new FrameLayout(context) { // from class: ir.eitaa.ui.Components.SharingLocationsAlert.1
            @Override // android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                if (ev.getAction() == 0 && SharingLocationsAlert.this.scrollOffsetY != 0 && ev.getY() < SharingLocationsAlert.this.scrollOffsetY) {
                    SharingLocationsAlert.this.dismiss();
                    return true;
                }
                return super.onInterceptTouchEvent(ev);
            }

            @Override // android.view.View
            public boolean onTouchEvent(MotionEvent e) {
                return !SharingLocationsAlert.this.isDismissed() && super.onTouchEvent(e);
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                int iDp;
                int size = View.MeasureSpec.getSize(heightMeasureSpec);
                if (Build.VERSION.SDK_INT >= 21) {
                    size -= AndroidUtilities.statusBarHeight;
                }
                getMeasuredWidth();
                int iDp2 = AndroidUtilities.dp(56.0f) + AndroidUtilities.dp(56.0f) + 1 + (LocationController.getLocationsCount() * AndroidUtilities.dp(54.0f));
                int i = size / 5;
                if (iDp2 < i * 3) {
                    iDp = AndroidUtilities.dp(8.0f);
                } else {
                    iDp = i * 2;
                    if (iDp2 < size) {
                        iDp -= size - iDp2;
                    }
                }
                if (SharingLocationsAlert.this.listView.getPaddingTop() != iDp) {
                    SharingLocationsAlert.this.ignoreLayout = true;
                    SharingLocationsAlert.this.listView.setPadding(0, iDp, 0, AndroidUtilities.dp(8.0f));
                    SharingLocationsAlert.this.ignoreLayout = false;
                }
                super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.min(iDp2, size), 1073741824));
            }

            @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                super.onLayout(changed, left, top, right, bottom);
                SharingLocationsAlert.this.updateLayout();
            }

            @Override // android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (SharingLocationsAlert.this.ignoreLayout) {
                    return;
                }
                super.requestLayout();
            }

            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                SharingLocationsAlert.this.shadowDrawable.setBounds(0, SharingLocationsAlert.this.scrollOffsetY - ((BottomSheet) SharingLocationsAlert.this).backgroundPaddingTop, getMeasuredWidth(), getMeasuredHeight());
                SharingLocationsAlert.this.shadowDrawable.draw(canvas);
            }
        };
        this.containerView = frameLayout;
        frameLayout.setWillNotDraw(false);
        ViewGroup viewGroup = this.containerView;
        int i = this.backgroundPaddingLeft;
        viewGroup.setPadding(i, 0, i, 0);
        RecyclerListView recyclerListView = new RecyclerListView(context) { // from class: ir.eitaa.ui.Components.SharingLocationsAlert.2
            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
            public boolean onInterceptTouchEvent(MotionEvent event) {
                return super.onInterceptTouchEvent(event) || ContentPreviewViewer.getInstance().onInterceptTouchEvent(event, SharingLocationsAlert.this.listView, 0, null, this.resourcesProvider);
            }

            @Override // ir.eitaa.ui.Components.RecyclerListView, androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
            public void requestLayout() {
                if (SharingLocationsAlert.this.ignoreLayout) {
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
        this.listView.setGlowColor(getThemedColor("dialogScrollGlow"));
        this.listView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ir.eitaa.ui.Components.SharingLocationsAlert.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                SharingLocationsAlert.this.updateLayout();
            }
        });
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$SharingLocationsAlert$dGKfzNtH3cEKyfEBeKWI9D7P6Z0
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i2) {
                this.f$0.lambda$new$0$SharingLocationsAlert(view, i2);
            }
        });
        this.containerView.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f, 51, 0.0f, 0.0f, 0.0f, 48.0f));
        View view = new View(context);
        view.setBackgroundResource(R.drawable.header_shadow_reverse);
        this.containerView.addView(view, LayoutHelper.createFrame(-1, 3.0f, 83, 0.0f, 0.0f, 0.0f, 48.0f));
        PickerBottomLayout pickerBottomLayout = new PickerBottomLayout(context, false);
        pickerBottomLayout.setBackgroundColor(getThemedColor("dialogBackground"));
        this.containerView.addView(pickerBottomLayout, LayoutHelper.createFrame(-1, 48, 83));
        pickerBottomLayout.cancelButton.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
        pickerBottomLayout.cancelButton.setTextColor(getThemedColor("dialogTextRed"));
        pickerBottomLayout.cancelButton.setText(LocaleController.getString("StopAllLocationSharings", R.string.StopAllLocationSharings));
        pickerBottomLayout.cancelButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$SharingLocationsAlert$dwKCe706Unh_1qZnAamztoGbH5U
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$1$SharingLocationsAlert(view2);
            }
        });
        pickerBottomLayout.doneButtonTextView.setTextColor(getThemedColor("dialogTextBlue2"));
        pickerBottomLayout.doneButtonTextView.setText(LocaleController.getString("Close", R.string.Close).toUpperCase());
        pickerBottomLayout.doneButton.setPadding(AndroidUtilities.dp(18.0f), 0, AndroidUtilities.dp(18.0f), 0);
        pickerBottomLayout.doneButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$SharingLocationsAlert$Zyv2IwD5tST3vQQLS29cetWFz_E
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.lambda$new$2$SharingLocationsAlert(view2);
            }
        });
        pickerBottomLayout.doneButtonBadgeTextView.setVisibility(8);
        this.adapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$0$SharingLocationsAlert(View view, int i) {
        int i2 = i - 1;
        if (i2 < 0 || i2 >= LocationController.getLocationsCount()) {
            return;
        }
        this.delegate.didSelectLocation(getLocation(i2));
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$SharingLocationsAlert(View view) {
        for (int i = 0; i < 3; i++) {
            LocationController.getInstance(i).removeAllLocationSharings();
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$2$SharingLocationsAlert(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
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
        int top = childAt.getTop() - AndroidUtilities.dp(8.0f);
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

    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.liveLocationsChanged) {
            if (LocationController.getLocationsCount() == 0) {
                dismiss();
            } else {
                this.adapter.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LocationController.SharingLocationInfo getLocation(int position) {
        for (int i = 0; i < 3; i++) {
            ArrayList<LocationController.SharingLocationInfo> arrayList = LocationController.getInstance(i).sharingLocationsUI;
            if (position >= arrayList.size()) {
                position -= arrayList.size();
            } else {
                return arrayList.get(position);
            }
        }
        return null;
    }

    @Override // ir.eitaa.ui.ActionBar.BottomSheet, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.liveLocationsChanged);
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context context;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            return position == 0 ? 1 : 0;
        }

        public ListAdapter(Context context) {
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return LocationController.getLocationsCount() + 1;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            return holder.getItemViewType() == 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            FrameLayout sharingLiveLocationCell;
            if (viewType == 0) {
                sharingLiveLocationCell = new SharingLiveLocationCell(this.context, false, 54, ((BottomSheet) SharingLocationsAlert.this).resourcesProvider);
            } else {
                sharingLiveLocationCell = new FrameLayout(this.context) { // from class: ir.eitaa.ui.Components.SharingLocationsAlert.ListAdapter.1
                    @Override // android.widget.FrameLayout, android.view.View
                    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                        super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(48.0f) + 1, 1073741824));
                    }

                    @Override // android.view.View
                    protected void onDraw(Canvas canvas) {
                        canvas.drawLine(0.0f, AndroidUtilities.dp(40.0f), getMeasuredWidth(), AndroidUtilities.dp(40.0f), Theme.dividerPaint);
                    }
                };
                sharingLiveLocationCell.setWillNotDraw(false);
                SharingLocationsAlert.this.textView = new TextView(this.context);
                SharingLocationsAlert.this.textView.setTextColor(SharingLocationsAlert.this.getThemedColor("dialogIcon"));
                SharingLocationsAlert.this.textView.setTextSize(1, 14.0f);
                SharingLocationsAlert.this.textView.setGravity(17);
                SharingLocationsAlert.this.textView.setPadding(0, 0, 0, AndroidUtilities.dp(8.0f));
                sharingLiveLocationCell.addView(SharingLocationsAlert.this.textView, LayoutHelper.createFrame(-1, 40.0f));
            }
            return new RecyclerListView.Holder(sharingLiveLocationCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int itemViewType = holder.getItemViewType();
            if (itemViewType != 0) {
                if (itemViewType == 1 && SharingLocationsAlert.this.textView != null) {
                    SharingLocationsAlert.this.textView.setText(LocaleController.formatString("SharingLiveLocationTitle", R.string.SharingLiveLocationTitle, LocaleController.formatPluralString("Chats", LocationController.getLocationsCount())));
                    return;
                }
                return;
            }
            ((SharingLiveLocationCell) holder.itemView).setDialog(SharingLocationsAlert.this.getLocation(position - 1));
        }
    }
}
