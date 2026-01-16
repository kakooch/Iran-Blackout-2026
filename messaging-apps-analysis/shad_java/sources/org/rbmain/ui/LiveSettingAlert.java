package org.rbmain.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.RadioCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes4.dex */
public class LiveSettingAlert extends BottomSheet {
    private int currentType;
    private final LiveSettingsDelegate delegate;
    private boolean enableAnimation;
    private int lastCheckedType;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private int liveBroadcastInfo;
    private int liveDone;
    private int liveExternal;
    private int liveInternal;
    private int rowCount;
    private int sectionRow;

    public interface LiveSettingsDelegate {
        void onChangeLiveSettings(Boolean bool);
    }

    public LiveSettingAlert(Context context, boolean z, LiveSettingsDelegate liveSettingsDelegate) {
        super(context, false);
        this.lastCheckedType = -1;
        this.liveBroadcastInfo = -1;
        this.delegate = liveSettingsDelegate;
        FrameLayout frameLayout = new FrameLayout(context);
        setCustomView(frameLayout);
        this.listAdapter = new ListAdapter(context);
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.listView.setVerticalScrollBarEnabled(false);
        frameLayout.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        this.listView.setAdapter(this.listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListener() { // from class: org.rbmain.ui.LiveSettingAlert$$ExternalSyntheticLambda0
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListener
            public final void onItemClick(View view, int i) {
                this.f$0.lambda$new$0(view, i);
            }
        });
        this.currentType = z ? 1 : 0;
        updateRows();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view, int i) {
        int i2;
        int i3 = this.liveInternal;
        if (i == i3 || i == this.liveExternal) {
            int i4 = this.currentType;
            if (i == i3) {
                i2 = 0;
            } else {
                i2 = i == this.liveExternal ? 1 : i4;
            }
            if (i2 == i4) {
                return;
            }
            this.enableAnimation = true;
            this.lastCheckedType = i4;
            this.currentType = i2;
            updateRows();
        }
    }

    private void updateRows() {
        this.rowCount = 0;
        int i = 0 + 1;
        this.rowCount = i;
        this.sectionRow = 0;
        int i2 = i + 1;
        this.rowCount = i2;
        this.liveInternal = i;
        int i3 = i2 + 1;
        this.rowCount = i3;
        this.liveExternal = i2;
        int i4 = i3 + 1;
        this.rowCount = i4;
        this.liveBroadcastInfo = i3;
        this.rowCount = i4 + 1;
        this.liveDone = i4;
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    public static class BottomSheetCell extends FrameLayout {
        private View background;
        private TextView textView;

        public BottomSheetCell(Context context) {
            super(context);
            View view = new View(context);
            this.background = view;
            view.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), Theme.getColor(Theme.key_featuredStickers_addButton), Theme.getColor(Theme.key_featuredStickers_addButtonPressed)));
            addView(this.background, LayoutHelper.createFrame(-1, -1.0f, 0, 16.0f, 16.0f, 16.0f, 16.0f));
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setLines(1);
            this.textView.setSingleLine(true);
            this.textView.setGravity(1);
            this.textView.setEllipsize(TextUtils.TruncateAt.END);
            this.textView.setGravity(17);
            this.textView.setTextColor(Theme.getColor(Theme.key_featuredStickers_buttonText));
            this.textView.setTextSize(1, 14.0f);
            this.textView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            addView(this.textView, LayoutHelper.createFrame(-2, -2, 17));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(80.0f), 1073741824));
        }

        public void setText(CharSequence charSequence) {
            this.textView.setText(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private final Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int adapterPosition = viewHolder.getAdapterPosition();
            return adapterPosition == LiveSettingAlert.this.liveInternal || adapterPosition == LiveSettingAlert.this.liveExternal;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return LiveSettingAlert.this.rowCount;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$0(View view) {
            if (LiveSettingAlert.this.delegate != null) {
                LiveSettingAlert.this.delegate.onChangeLiveSettings(Boolean.valueOf(LiveSettingAlert.this.currentType == 1));
            }
            LiveSettingAlert.this.dismiss();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            FrameLayout textInfoPrivacyCell;
            if (i == 0) {
                FrameLayout textSettingsCell = new TextSettingsCell(this.mContext);
                textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                textInfoPrivacyCell = textSettingsCell;
            } else if (i == 1) {
                textInfoPrivacyCell = new TextInfoPrivacyCell(this.mContext);
            } else if (i == 2) {
                FrameLayout headerCell = new HeaderCell(this.mContext);
                headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                textInfoPrivacyCell = headerCell;
            } else if (i == 4) {
                BottomSheetCell bottomSheetCell = new BottomSheetCell(this.mContext);
                bottomSheetCell.setBackground(null);
                bottomSheetCell.background.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LiveSettingAlert$ListAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onCreateViewHolder$0(view);
                    }
                });
                textInfoPrivacyCell = bottomSheetCell;
            } else {
                FrameLayout radioCell = new RadioCell(this.mContext);
                radioCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                textInfoPrivacyCell = radioCell;
            }
            return new RecyclerListView.Holder(textInfoPrivacyCell);
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0075  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r5, int r6) {
            /*
                r4 = this;
                int r0 = r5.getItemViewType()
                if (r0 == 0) goto Lc8
                r1 = 1
                if (r0 == r1) goto Laa
                r2 = 2
                if (r0 == r2) goto L91
                r3 = 3
                if (r0 == r3) goto L26
                r6 = 4
                if (r0 == r6) goto L14
                goto Lcc
            L14:
                android.view.View r5 = r5.itemView
                org.rbmain.ui.LiveSettingAlert$BottomSheetCell r5 = (org.rbmain.ui.LiveSettingAlert.BottomSheetCell) r5
                r6 = 2131889383(0x7f120ce7, float:1.9413428E38)
                java.lang.String r0 = "LiveBroadCastSettingsApplyChanges"
                java.lang.String r6 = org.rbmain.messenger.LocaleController.getString(r0, r6)
                r5.setText(r6)
                goto Lcc
            L26:
                android.view.View r5 = r5.itemView
                org.rbmain.ui.Cells.RadioCell r5 = (org.rbmain.ui.Cells.RadioCell) r5
                org.rbmain.ui.LiveSettingAlert r0 = org.rbmain.ui.LiveSettingAlert.this
                int r0 = org.rbmain.ui.LiveSettingAlert.access$000(r0)
                r3 = 0
                if (r6 != r0) goto L4b
                r6 = 2131893236(0x7f121bf4, float:1.9421243E38)
                java.lang.String r0 = "liveSettingInternalBroadCast"
                java.lang.String r6 = org.rbmain.messenger.LocaleController.getString(r0, r6)
                org.rbmain.ui.LiveSettingAlert r0 = org.rbmain.ui.LiveSettingAlert.this
                int r0 = org.rbmain.ui.LiveSettingAlert.access$600(r0)
                if (r0 != 0) goto L46
                r0 = 1
                goto L47
            L46:
                r0 = 0
            L47:
                r5.setText(r6, r0, r1)
                goto L6c
            L4b:
                org.rbmain.ui.LiveSettingAlert r0 = org.rbmain.ui.LiveSettingAlert.this
                int r0 = org.rbmain.ui.LiveSettingAlert.access$100(r0)
                if (r6 != r0) goto L6c
                r6 = 2131893235(0x7f121bf3, float:1.942124E38)
                java.lang.String r0 = "liveSettingExternalBroadCast"
                java.lang.String r6 = org.rbmain.messenger.LocaleController.getString(r0, r6)
                org.rbmain.ui.LiveSettingAlert r0 = org.rbmain.ui.LiveSettingAlert.this
                int r0 = org.rbmain.ui.LiveSettingAlert.access$600(r0)
                if (r0 != r2) goto L66
                r0 = 1
                goto L67
            L66:
                r0 = 0
            L67:
                r5.setText(r6, r0, r3)
                r6 = 1
                goto L6d
            L6c:
                r6 = 0
            L6d:
                org.rbmain.ui.LiveSettingAlert r0 = org.rbmain.ui.LiveSettingAlert.this
                int r0 = org.rbmain.ui.LiveSettingAlert.access$600(r0)
                if (r0 != r6) goto L7f
                org.rbmain.ui.LiveSettingAlert r6 = org.rbmain.ui.LiveSettingAlert.this
                boolean r6 = org.rbmain.ui.LiveSettingAlert.access$700(r6)
                r5.setChecked(r3, r6)
                goto Lcc
            L7f:
                org.rbmain.ui.LiveSettingAlert r0 = org.rbmain.ui.LiveSettingAlert.this
                int r0 = org.rbmain.ui.LiveSettingAlert.access$800(r0)
                if (r0 != r6) goto Lcc
                org.rbmain.ui.LiveSettingAlert r6 = org.rbmain.ui.LiveSettingAlert.this
                boolean r6 = org.rbmain.ui.LiveSettingAlert.access$700(r6)
                r5.setChecked(r1, r6)
                goto Lcc
            L91:
                android.view.View r5 = r5.itemView
                org.rbmain.ui.Cells.HeaderCell r5 = (org.rbmain.ui.Cells.HeaderCell) r5
                org.rbmain.ui.LiveSettingAlert r0 = org.rbmain.ui.LiveSettingAlert.this
                int r0 = org.rbmain.ui.LiveSettingAlert.access$500(r0)
                if (r6 != r0) goto Lcc
                r6 = 2131893234(0x7f121bf2, float:1.9421239E38)
                java.lang.String r0 = "liveSettingBroadCastMode"
                java.lang.String r6 = org.rbmain.messenger.LocaleController.getString(r0, r6)
                r5.setText(r6)
                goto Lcc
            Laa:
                android.view.View r5 = r5.itemView
                org.rbmain.ui.Cells.TextInfoPrivacyCell r5 = (org.rbmain.ui.Cells.TextInfoPrivacyCell) r5
                java.lang.String r0 = ""
                r5.setText(r0)
                org.rbmain.ui.LiveSettingAlert r0 = org.rbmain.ui.LiveSettingAlert.this
                int r0 = org.rbmain.ui.LiveSettingAlert.access$400(r0)
                if (r6 != r0) goto Lcc
                r6 = 2131893229(0x7f121bed, float:1.9421229E38)
                java.lang.String r0 = "liveBroadCastModeHelp"
                java.lang.String r6 = org.rbmain.messenger.LocaleController.getString(r0, r6)
                r5.setText(r6)
                goto Lcc
            Lc8:
                android.view.View r5 = r5.itemView
                org.rbmain.ui.Cells.TextSettingsCell r5 = (org.rbmain.ui.Cells.TextSettingsCell) r5
            Lcc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.LiveSettingAlert.ListAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == LiveSettingAlert.this.sectionRow) {
                return 2;
            }
            if (i == LiveSettingAlert.this.liveInternal || i == LiveSettingAlert.this.liveExternal) {
                return 3;
            }
            if (i == LiveSettingAlert.this.liveBroadcastInfo) {
                return 1;
            }
            return i == LiveSettingAlert.this.liveDone ? 4 : 0;
        }
    }
}
