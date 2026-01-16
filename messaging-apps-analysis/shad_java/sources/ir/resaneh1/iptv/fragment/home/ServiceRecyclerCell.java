package ir.resaneh1.iptv.fragment.home;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidMessenger.helper.GlideHelper;
import androidx.recyclerview.widget.RecyclerView;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.RtlGridLayoutManager;
import ir.resaneh1.iptv.model.HomePageModels;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;
import org.rbmain.ui.Components.ViewHelper;

/* loaded from: classes3.dex */
public class ServiceRecyclerCell extends FrameLayout {
    private ServiceListAdapter adapter;
    private ArrayList<HomePageModels.ServiceObject> arrayList;
    private int columnCount;
    private ServiceCellDelegate delegate;
    private float editingAnimationProgress;
    private boolean editingForwardAnimation;
    private float editingStartAnimationProgress;
    private int endIndex;
    private boolean isEditing;
    private long lastEditingAnimationTime;
    private RtlGridLayoutManager layoutManager;
    RecyclerListView listView;
    private final int rightAndLeftMargin;
    private int startIndex;
    private int totalHeight;

    public interface ServiceCellDelegate {
        boolean onLongClick(View view, int i);
    }

    public void setIsEditing(boolean z) {
        this.isEditing = z;
        invalidateViews();
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0099  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected boolean drawChild(android.graphics.Canvas r9, android.view.View r10, long r11) {
        /*
            r8 = this;
            boolean r9 = super.drawChild(r9, r10, r11)
            long r10 = android.os.SystemClock.elapsedRealtime()
            long r0 = r8.lastEditingAnimationTime
            long r0 = r10 - r0
            r2 = 17
            long r0 = java.lang.Math.min(r2, r0)
            r8.lastEditingAnimationTime = r10
            boolean r10 = r8.isEditing
            r11 = 0
            r12 = 1065353216(0x3f800000, float:1.0)
            r2 = 1
            r3 = 0
            if (r10 != 0) goto L23
            float r4 = r8.editingAnimationProgress
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 == 0) goto L6f
        L23:
            boolean r4 = r8.editingForwardAnimation
            r5 = 1123024896(0x42f00000, float:120.0)
            if (r4 == 0) goto L4c
            float r4 = r8.editingAnimationProgress
            int r6 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r6 > 0) goto L31
            r6 = 1
            goto L32
        L31:
            r6 = 0
        L32:
            float r7 = (float) r0
            float r7 = r7 / r5
            float r4 = r4 + r7
            r8.editingAnimationProgress = r4
            if (r10 != 0) goto L41
            if (r6 == 0) goto L41
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 < 0) goto L41
            r8.editingAnimationProgress = r3
        L41:
            float r4 = r8.editingAnimationProgress
            int r4 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r4 < 0) goto L6e
            r8.editingAnimationProgress = r12
            r8.editingForwardAnimation = r11
            goto L6e
        L4c:
            float r4 = r8.editingAnimationProgress
            int r6 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r6 < 0) goto L53
            r11 = 1
        L53:
            float r6 = (float) r0
            float r6 = r6 / r5
            float r4 = r4 - r6
            r8.editingAnimationProgress = r4
            if (r10 != 0) goto L62
            if (r11 == 0) goto L62
            int r11 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r11 > 0) goto L62
            r8.editingAnimationProgress = r3
        L62:
            float r11 = r8.editingAnimationProgress
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r11 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r11 > 0) goto L6e
            r8.editingAnimationProgress = r4
            r8.editingForwardAnimation = r2
        L6e:
            r11 = 1
        L6f:
            r4 = 1127481344(0x43340000, float:180.0)
            if (r10 == 0) goto L85
            float r10 = r8.editingStartAnimationProgress
            int r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r3 >= 0) goto L99
            float r11 = (float) r0
            float r11 = r11 / r4
            float r10 = r10 + r11
            r8.editingStartAnimationProgress = r10
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 <= 0) goto L9a
            r8.editingStartAnimationProgress = r12
            goto L9a
        L85:
            if (r10 != 0) goto L99
            float r10 = r8.editingStartAnimationProgress
            int r12 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r12 <= 0) goto L99
            float r11 = (float) r0
            float r11 = r11 / r4
            float r10 = r10 - r11
            r8.editingStartAnimationProgress = r10
            int r10 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r10 >= 0) goto L9a
            r8.editingStartAnimationProgress = r3
            goto L9a
        L99:
            r2 = r11
        L9a:
            if (r2 == 0) goto La4
            org.rbmain.ui.Components.RecyclerListView r10 = r8.listView
            r10.invalidateViews()
            r8.invalidate()
        La4:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.home.ServiceRecyclerCell.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
    }

    public void invalidateViews() {
        invalidate();
    }

    public ServiceRecyclerCell(Context context, int i) {
        super(context);
        this.totalHeight = 0;
        this.columnCount = 1;
        this.startIndex = -1;
        this.endIndex = -1;
        setWillNotDraw(false);
        this.rightAndLeftMargin = i;
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        RtlGridLayoutManager rtlGridLayoutManager = new RtlGridLayoutManager(context, this.columnCount);
        this.layoutManager = rtlGridLayoutManager;
        recyclerListView.setLayoutManager(rtlGridLayoutManager);
        this.listView.setVerticalScrollBarEnabled(false);
        addView(this.listView, LayoutHelper.createFrame(-1, -1, 48));
        RecyclerListView recyclerListView2 = this.listView;
        ServiceListAdapter serviceListAdapter = new ServiceListAdapter();
        this.adapter = serviceListAdapter;
        recyclerListView2.setAdapter(serviceListAdapter);
    }

    public void setDelegate(ServiceCellDelegate serviceCellDelegate) {
        this.delegate = serviceCellDelegate;
    }

    public void setItem(ArrayList<HomePageModels.ServiceObject> arrayList, int i, int i2, int i3, int i4) {
        this.columnCount = i3;
        this.layoutManager.setSpanCount(i3);
        this.arrayList = arrayList;
        this.startIndex = arrayList.size() > i ? i : -1;
        this.endIndex = Math.min(arrayList.size(), i + i2);
        this.totalHeight = i4;
        this.adapter.notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.arrayList.size();
    }

    public int getCurrentPosition(DragEvent dragEvent) {
        View viewFindChildViewUnder = this.listView.findChildViewUnder(dragEvent.getX(), dragEvent.getY());
        if (viewFindChildViewUnder != null) {
            return this.listView.getChildAdapterPosition(viewFindChildViewUnder) + this.startIndex;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ServiceListAdapter extends RecyclerListView.SelectionAdapter {
        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return true;
        }

        private ServiceListAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            final ServiceCell serviceCell = ServiceRecyclerCell.this.new ServiceCell(viewGroup.getContext(), ServiceRecyclerCell.this.columnCount, ServiceRecyclerCell.this.rightAndLeftMargin, ServiceRecyclerCell.this.totalHeight);
            serviceCell.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.resaneh1.iptv.fragment.home.ServiceRecyclerCell$ServiceListAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return this.f$0.lambda$onCreateViewHolder$0(serviceCell, view);
                }
            });
            return new RecyclerListView.Holder(serviceCell);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$onCreateViewHolder$0(ServiceCell serviceCell, View view) {
            return ServiceRecyclerCell.this.delegate != null && ServiceRecyclerCell.this.delegate.onLongClick(view, ServiceRecyclerCell.this.startIndex + ServiceRecyclerCell.this.listView.getChildAdapterPosition(serviceCell));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int i2 = i + ServiceRecyclerCell.this.startIndex;
            if (i2 < 0 || i2 >= ServiceRecyclerCell.this.arrayList.size()) {
                return;
            }
            ((ServiceCell) viewHolder.itemView).setItem((HomePageModels.ServiceObject) ServiceRecyclerCell.this.arrayList.get(i2));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (ServiceRecyclerCell.this.startIndex < 0) {
                return 0;
            }
            return ServiceRecyclerCell.this.endIndex - ServiceRecyclerCell.this.startIndex;
        }
    }

    public static int getItemWidthInPx(int i, int i2) {
        Point point = AndroidUtilities.displaySize;
        return (Math.min(point.x, point.y) - i2) / i;
    }

    public static int getItemHeightInPx(int i, int i2) {
        return getItemWidthInPx(i, i2) + AndroidUtilities.dp(20.0f);
    }

    public class ServiceCell extends FrameLayout {
        Context context;
        HomePageModels.ServiceObject currentObject;
        float imageRatio;
        ImageView imageView;
        TextView textView1;
        int widthInPx;

        public ServiceCell(Context context, int i, int i2, int i3) {
            super(context);
            this.imageRatio = 0.5f;
            setWillNotDraw(false);
            this.context = context;
            int itemWidthInPx = ServiceRecyclerCell.getItemWidthInPx(i, i2);
            this.widthInPx = itemWidthInPx;
            int i4 = (int) (itemWidthInPx * this.imageRatio);
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setGravity(1);
            addView(linearLayout, new FrameLayout.LayoutParams(this.widthInPx, i3 == 0 ? -2 : i3, 17));
            this.imageView = new ImageView(context);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i4, 1);
            layoutParams.topMargin = AndroidUtilities.dp(2.0f);
            linearLayout.addView(this.imageView, layoutParams);
            TextView textViewCreateTextViewBlack = ViewHelper.createTextViewBlack(context, 11, false);
            this.textView1 = textViewCreateTextViewBlack;
            textViewCreateTextViewBlack.setText(BuildConfig.FLAVOR);
            this.textView1.setMaxLines(1);
            this.textView1.setEllipsize(TextUtils.TruncateAt.END);
            this.textView1.setGravity(1);
            FrameLayout.LayoutParams layoutParamsCreateFrame = LayoutHelper.createFrame(-2, -2, 1);
            layoutParamsCreateFrame.bottomMargin = AndroidUtilities.dp(2.0f);
            layoutParamsCreateFrame.topMargin = AndroidUtilities.dp(4.0f);
            linearLayout.addView(this.textView1, layoutParamsCreateFrame);
            setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.home.ServiceRecyclerCell$ServiceCell$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            HomePageModels.ServiceObject serviceObject = this.currentObject;
            if (serviceObject == null || serviceObject.action_link == null) {
                return;
            }
            new MainClickHandler().onLinkClick(this.currentObject.action_link);
        }

        public void setItem(HomePageModels.ServiceObject serviceObject) {
            this.currentObject = serviceObject;
            refreshView();
        }

        public void refreshView() {
            HomePageModels.ServiceObject serviceObject = this.currentObject;
            String str = BuildConfig.FLAVOR;
            if (serviceObject != null) {
                if (serviceObject.isDragging) {
                    this.textView1.setText(BuildConfig.FLAVOR);
                    GlideHelper.load(this.context, this.imageView, null, R.drawable.shape_circle_gray_stroke);
                    return;
                }
                TextView textView = this.textView1;
                String str2 = serviceObject.title;
                if (str2 != null) {
                    str = str2;
                }
                textView.setText(str);
                GlideHelper.load(this.context, this.imageView, this.currentObject.image_url, R.drawable.shape_circle_gray_stroke);
                return;
            }
            this.textView1.setText(BuildConfig.FLAVOR);
            GlideHelper.load(this.context, this.imageView, null, R.drawable.shape_circle_gray_stroke);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (ServiceRecyclerCell.this.editingAnimationProgress != 0.0f) {
                canvas.save();
                float f = ServiceRecyclerCell.this.editingAnimationProgress * 2.0f;
                HomePageModels.ServiceObject serviceObject = this.currentObject;
                float f2 = 1.0f;
                if (serviceObject != null && serviceObject.priority % 2 != 0) {
                    f2 = -1.0f;
                }
                float f3 = f * f2;
                canvas.translate(AndroidUtilities.dp(0.66f) * f3, 0.0f);
                canvas.rotate(f3, getMeasuredWidth() / 2, getMeasuredHeight() / 2);
            }
        }
    }
}
