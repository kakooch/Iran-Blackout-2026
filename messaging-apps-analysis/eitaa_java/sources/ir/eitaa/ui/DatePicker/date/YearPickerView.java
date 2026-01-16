package ir.eitaa.ui.DatePicker.date;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import ir.eitaa.ui.DatePicker.date.DatePickerDialog;
import ir.eitaa.ui.DatePicker.util.LanguageUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class YearPickerView extends RecyclerListView implements RecyclerListView.OnItemClickListener, DatePickerDialog.OnDateChangedListener {
    private YearAdapterR mAdapter;
    private int mChildSize;
    private final DatePickerController mController;
    private TextViewWithCircularIndicator mSelectedView;
    private int mViewSize;

    public YearPickerView(Context context, DatePickerController controller) {
        super(context);
        this.mController = controller;
        controller.registerOnDateChangedListener(this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        context.getResources();
        this.mViewSize = AndroidUtilities.dp(252.0f);
        this.mChildSize = AndroidUtilities.dp(64.0f);
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(this.mChildSize / 3);
        init(context);
        setOnItemClickListener(this);
        setLayoutManager(new LinearLayoutManager(context));
        onDateChanged();
    }

    private void init(Context context) {
        ArrayList arrayList = new ArrayList();
        for (int minYear = this.mController.getMinYear(); minYear <= this.mController.getMaxYear(); minYear++) {
            arrayList.add(String.format("%d", Integer.valueOf(minYear)));
        }
        YearAdapterR yearAdapterR = new YearAdapterR(context, LanguageUtils.getPersianNumbers((ArrayList<String>) arrayList));
        this.mAdapter = yearAdapterR;
        setAdapter(yearAdapterR);
    }

    private static int getYearFromTextView(TextView view) {
        return Integer.valueOf(LanguageUtils.getLatinNumbers(view.getText().toString())).intValue();
    }

    @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListener
    public void onItemClick(View view, int position) {
        TextViewWithCircularIndicator textViewWithCircularIndicator = (TextViewWithCircularIndicator) view;
        if (textViewWithCircularIndicator != null) {
            TextViewWithCircularIndicator textViewWithCircularIndicator2 = this.mSelectedView;
            if (textViewWithCircularIndicator != textViewWithCircularIndicator2) {
                if (textViewWithCircularIndicator2 != null) {
                    textViewWithCircularIndicator2.drawIndicator(false);
                    this.mSelectedView.requestLayout();
                }
                textViewWithCircularIndicator.drawIndicator(true);
                textViewWithCircularIndicator.requestLayout();
                this.mSelectedView = textViewWithCircularIndicator;
            }
            this.mController.onYearSelected(getYearFromTextView(textViewWithCircularIndicator));
            this.mAdapter.notifyDataSetChanged();
        }
    }

    private class YearAdapterR extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        Context context;
        List<String> objects;

        public YearAdapterR(Context context, List<String> objects) {
            this.objects = objects;
            this.context = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextViewWithCircularIndicator textViewWithCircularIndicator = new TextViewWithCircularIndicator(this.context, null);
            textViewWithCircularIndicator.setLayoutParams(LayoutHelper.createFrame(-1, 64, 17));
            textViewWithCircularIndicator.setGravity(17);
            textViewWithCircularIndicator.setTextColor(Theme.getColor("dialogTextBlack"));
            textViewWithCircularIndicator.setTextSize(22.0f);
            textViewWithCircularIndicator.setTypeface(AndroidUtilities.getFontFamily(false));
            return new RecyclerListView.Holder(textViewWithCircularIndicator);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) throws NumberFormatException {
            TextViewWithCircularIndicator textViewWithCircularIndicator = (TextViewWithCircularIndicator) holder.itemView;
            textViewWithCircularIndicator.requestLayout();
            int i = Integer.parseInt(LanguageUtils.getLatinNumbers(this.objects.get(position)));
            textViewWithCircularIndicator.setText(this.objects.get(position));
            boolean z = YearPickerView.this.mController.getSelectedDay().year == i;
            textViewWithCircularIndicator.drawIndicator(z);
            if (z) {
                YearPickerView.this.mSelectedView = textViewWithCircularIndicator;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.objects.size();
        }
    }

    public void postSetSelectionCentered(final int position) {
        postSetSelectionFromTop(position, (this.mViewSize / 2) - (this.mChildSize / 2));
    }

    public void postSetSelectionFromTop(final int position, final int offset) {
        post(new Runnable() { // from class: ir.eitaa.ui.DatePicker.date.YearPickerView.1
            @Override // java.lang.Runnable
            public void run() {
                YearPickerView.this.requestLayout();
            }
        });
    }

    public int getFirstPositionOffset() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return childAt.getTop();
    }

    @Override // ir.eitaa.ui.DatePicker.date.DatePickerDialog.OnDateChangedListener
    public void onDateChanged() {
        this.mAdapter.notifyDataSetChanged();
        postSetSelectionCentered(this.mController.getSelectedDay().year - this.mController.getMinYear());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        if (event.getEventType() == 4096) {
            event.setFromIndex(0);
            event.setToIndex(0);
        }
    }
}
