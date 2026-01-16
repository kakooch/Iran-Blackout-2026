package ir.eitaa.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.EditTextSettingsCell;
import ir.eitaa.ui.Cells.TextCheckCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class QuickRepliesSettingsActivity extends BaseFragment {
    private int explanationRow;
    private ListAdapter listAdapter;
    private RecyclerListView listView;
    private int reply1Row;
    private int reply2Row;
    private int reply3Row;
    private int reply4Row;
    private int rowCount;
    private EditTextSettingsCell[] textCells = new EditTextSettingsCell[4];

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        super.onFragmentCreate();
        this.rowCount = 0;
        int i = 0 + 1;
        this.rowCount = i;
        this.reply1Row = 0;
        int i2 = i + 1;
        this.rowCount = i2;
        this.reply2Row = i;
        int i3 = i2 + 1;
        this.rowCount = i3;
        this.reply3Row = i2;
        int i4 = i3 + 1;
        this.rowCount = i4;
        this.reply4Row = i3;
        this.rowCount = i4 + 1;
        this.explanationRow = i4;
        return true;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setTitle(LocaleController.getString("VoipQuickReplies", R.string.VoipQuickReplies));
        if (AndroidUtilities.isTablet()) {
            this.actionBar.setOccupyStatusBar(false);
        }
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.QuickRepliesSettingsActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    QuickRepliesSettingsActivity.this.finishFragment();
                }
            }
        });
        this.listAdapter = new ListAdapter(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        FrameLayout frameLayout2 = (FrameLayout) this.fragmentView;
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        recyclerListView.setVerticalScrollBarEnabled(false);
        this.listView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1, 51));
        this.listView.setAdapter(this.listAdapter);
        return this.fragmentView;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        int i = 0;
        SharedPreferences.Editor editorEdit = getParentActivity().getSharedPreferences("mainconfig", 0).edit();
        while (true) {
            EditTextSettingsCell[] editTextSettingsCellArr = this.textCells;
            if (i < editTextSettingsCellArr.length) {
                if (editTextSettingsCellArr[i] != null) {
                    String string = editTextSettingsCellArr[i].getTextView().getText().toString();
                    if (!TextUtils.isEmpty(string)) {
                        editorEdit.putString("quick_reply_msg" + (i + 1), string);
                    } else {
                        editorEdit.remove("quick_reply_msg" + (i + 1));
                    }
                }
                i++;
            } else {
                editorEdit.commit();
                return;
            }
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.listAdapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    private class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return QuickRepliesSettingsActivity.this.rowCount;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r8, int r9) {
            /*
                r7 = this;
                int r0 = r8.getItemViewType()
                if (r0 == 0) goto Lb1
                r1 = 1
                if (r0 == r1) goto Lac
                r2 = 4
                java.lang.String r3 = "mainconfig"
                r4 = 0
                if (r0 == r2) goto L8b
                switch(r0) {
                    case 9: goto L14;
                    case 10: goto L14;
                    case 11: goto L14;
                    case 12: goto L14;
                    default: goto L12;
                }
            L12:
                goto Lcf
            L14:
                android.view.View r8 = r8.itemView
                ir.eitaa.ui.Cells.EditTextSettingsCell r8 = (ir.eitaa.ui.Cells.EditTextSettingsCell) r8
                ir.eitaa.ui.QuickRepliesSettingsActivity r0 = ir.eitaa.ui.QuickRepliesSettingsActivity.this
                int r0 = ir.eitaa.ui.QuickRepliesSettingsActivity.access$100(r0)
                r2 = 0
                if (r9 != r0) goto L30
                r0 = 2131693633(0x7f0f1041, float:1.90164E38)
                java.lang.String r2 = "QuickReplyDefault1"
                java.lang.String r2 = ir.eitaa.messenger.LocaleController.getString(r2, r0)
                java.lang.String r0 = "quick_reply_msg1"
            L2c:
                r6 = r2
                r2 = r0
                r0 = r6
                goto L6d
            L30:
                ir.eitaa.ui.QuickRepliesSettingsActivity r0 = ir.eitaa.ui.QuickRepliesSettingsActivity.this
                int r0 = ir.eitaa.ui.QuickRepliesSettingsActivity.access$200(r0)
                if (r9 != r0) goto L44
                r0 = 2131693634(0x7f0f1042, float:1.9016402E38)
                java.lang.String r2 = "QuickReplyDefault2"
                java.lang.String r2 = ir.eitaa.messenger.LocaleController.getString(r2, r0)
                java.lang.String r0 = "quick_reply_msg2"
                goto L2c
            L44:
                ir.eitaa.ui.QuickRepliesSettingsActivity r0 = ir.eitaa.ui.QuickRepliesSettingsActivity.this
                int r0 = ir.eitaa.ui.QuickRepliesSettingsActivity.access$300(r0)
                if (r9 != r0) goto L58
                r0 = 2131693635(0x7f0f1043, float:1.9016404E38)
                java.lang.String r2 = "QuickReplyDefault3"
                java.lang.String r2 = ir.eitaa.messenger.LocaleController.getString(r2, r0)
                java.lang.String r0 = "quick_reply_msg3"
                goto L2c
            L58:
                ir.eitaa.ui.QuickRepliesSettingsActivity r0 = ir.eitaa.ui.QuickRepliesSettingsActivity.this
                int r0 = ir.eitaa.ui.QuickRepliesSettingsActivity.access$400(r0)
                if (r9 != r0) goto L6c
                r0 = 2131693636(0x7f0f1044, float:1.9016406E38)
                java.lang.String r2 = "QuickReplyDefault4"
                java.lang.String r2 = ir.eitaa.messenger.LocaleController.getString(r2, r0)
                java.lang.String r0 = "quick_reply_msg4"
                goto L2c
            L6c:
                r0 = r2
            L6d:
                ir.eitaa.ui.QuickRepliesSettingsActivity r5 = ir.eitaa.ui.QuickRepliesSettingsActivity.this
                android.app.Activity r5 = r5.getParentActivity()
                android.content.SharedPreferences r3 = r5.getSharedPreferences(r3, r4)
                java.lang.String r5 = ""
                java.lang.String r2 = r3.getString(r2, r5)
                ir.eitaa.ui.QuickRepliesSettingsActivity r3 = ir.eitaa.ui.QuickRepliesSettingsActivity.this
                int r3 = ir.eitaa.ui.QuickRepliesSettingsActivity.access$400(r3)
                if (r9 == r3) goto L86
                goto L87
            L86:
                r1 = 0
            L87:
                r8.setTextAndHint(r2, r0, r1)
                goto Lcf
            L8b:
                android.view.View r8 = r8.itemView
                ir.eitaa.ui.Cells.TextCheckCell r8 = (ir.eitaa.ui.Cells.TextCheckCell) r8
                r9 = 2131689882(0x7f0f019a, float:1.9008792E38)
                java.lang.String r0 = "AllowCustomQuickReply"
                java.lang.String r9 = ir.eitaa.messenger.LocaleController.getString(r0, r9)
                ir.eitaa.ui.QuickRepliesSettingsActivity r0 = ir.eitaa.ui.QuickRepliesSettingsActivity.this
                android.app.Activity r0 = r0.getParentActivity()
                android.content.SharedPreferences r0 = r0.getSharedPreferences(r3, r4)
                java.lang.String r2 = "quick_reply_allow_custom"
                boolean r0 = r0.getBoolean(r2, r1)
                r8.setTextAndCheck(r9, r0, r4)
                goto Lcf
            Lac:
                android.view.View r8 = r8.itemView
                ir.eitaa.ui.Cells.TextSettingsCell r8 = (ir.eitaa.ui.Cells.TextSettingsCell) r8
                goto Lcf
            Lb1:
                android.view.View r8 = r8.itemView
                ir.eitaa.ui.Cells.TextInfoPrivacyCell r8 = (ir.eitaa.ui.Cells.TextInfoPrivacyCell) r8
                android.content.Context r9 = r7.mContext
                r0 = 2131231090(0x7f080172, float:1.8078251E38)
                java.lang.String r1 = "windowBackgroundGrayShadow"
                android.graphics.drawable.Drawable r9 = ir.eitaa.ui.ActionBar.Theme.getThemedDrawable(r9, r0, r1)
                r8.setBackgroundDrawable(r9)
                r9 = 2131695068(0x7f0f15dc, float:1.901931E38)
                java.lang.String r0 = "VoipQuickRepliesExplain"
                java.lang.String r9 = ir.eitaa.messenger.LocaleController.getString(r0, r9)
                r8.setText(r9)
            Lcf:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.QuickRepliesSettingsActivity.ListAdapter.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int adapterPosition = holder.getAdapterPosition();
            return adapterPosition == QuickRepliesSettingsActivity.this.reply1Row || adapterPosition == QuickRepliesSettingsActivity.this.reply2Row || adapterPosition == QuickRepliesSettingsActivity.this.reply3Row || adapterPosition == QuickRepliesSettingsActivity.this.reply4Row;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View textInfoPrivacyCell;
            if (viewType == 0) {
                textInfoPrivacyCell = new TextInfoPrivacyCell(this.mContext);
            } else if (viewType == 1) {
                textInfoPrivacyCell = new TextSettingsCell(this.mContext);
                textInfoPrivacyCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            } else {
                switch (viewType) {
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        textInfoPrivacyCell = new EditTextSettingsCell(this.mContext);
                        textInfoPrivacyCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                        QuickRepliesSettingsActivity.this.textCells[viewType - 9] = textInfoPrivacyCell;
                        break;
                    default:
                        textInfoPrivacyCell = new TextCheckCell(this.mContext);
                        textInfoPrivacyCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                        break;
                }
            }
            textInfoPrivacyCell.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new RecyclerListView.Holder(textInfoPrivacyCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == QuickRepliesSettingsActivity.this.explanationRow) {
                return 0;
            }
            if (position == QuickRepliesSettingsActivity.this.reply1Row || position == QuickRepliesSettingsActivity.this.reply2Row || position == QuickRepliesSettingsActivity.this.reply3Row || position == QuickRepliesSettingsActivity.this.reply4Row) {
                return (position - QuickRepliesSettingsActivity.this.reply1Row) + 9;
            }
            return 1;
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextSettingsCell.class, TextCheckCell.class, EditTextSettingsCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{EditTextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_HINTTEXTCOLOR, new Class[]{EditTextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteHintText"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteValueText"));
        return arrayList;
    }
}
