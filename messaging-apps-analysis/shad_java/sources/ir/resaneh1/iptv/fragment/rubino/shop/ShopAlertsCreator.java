package ir.resaneh1.iptv.fragment.rubino.shop;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.appp.common.utils.LayoutHelper;
import ir.medu.shad.R;
import ir.resaneh1.iptv.fragment.rubino.RecyclerListView;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.model.ShopModels;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.GraySectionCell;
import org.rbmain.ui.Cells.LoadingCell;

/* loaded from: classes3.dex */
public class ShopAlertsCreator {

    public interface ItemPickerDelegate {
        void didSelectItems(ArrayList<? extends ShopModels.ShopSelectableItem> arrayList);

        void selectedItemChanged(ArrayList<? extends ShopModels.ShopSelectableItem> arrayList);
    }

    public interface SelectionItemDelegate {
        void didClickItem(TextAndImageView textAndImageView, ShopModels.ShopSelectableItem shopSelectableItem);
    }

    public static AlertDialog.Builder createItemPickerDialog(final Context context, String str, boolean z, final boolean z2, final ArrayList<? extends ShopModels.ShopSelectableItem> arrayList, final ItemPickerDelegate itemPickerDelegate) {
        if (context == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setWeightSum(1.0f);
        linearLayout.setBackgroundColor(Theme.getColor(Theme.key_chat_emojiPanelBackground));
        Calendar.getInstance().setTimeInMillis(System.currentTimeMillis());
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            Iterator<? extends ShopModels.ShopSelectableItem> it = arrayList.iterator();
            while (it.hasNext()) {
                ShopModels.ShopSelectableItem next = it.next();
                if (next.isSelected) {
                    arrayList2.add(next);
                }
            }
        }
        builder.setView(linearLayout);
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        builder.setPositiveButton(LocaleController.getString("Done", R.string.Done), new DialogInterface.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ShopAlertsCreator.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (arrayList.size() == 0 && !z2) {
                    ToastiLikeSnack.showL(context, LocaleController.getString(R.string.shop_error_select));
                    return;
                }
                ItemPickerDelegate itemPickerDelegate2 = itemPickerDelegate;
                if (itemPickerDelegate2 != null) {
                    itemPickerDelegate2.didSelectItems(arrayList2);
                }
                builder.getDismissRunnable().run();
            }
        });
        RecyclerListView recyclerListView = new RecyclerListView(context);
        recyclerListView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        recyclerListView.setVerticalScrollBarEnabled(false);
        recyclerListView.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(2.0f));
        recyclerListView.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
        linearLayout.addView(recyclerListView, LayoutHelper.createFrame(-1, -1));
        if (z) {
            FrameLayout frameLayout = new FrameLayout(context);
            TextView textView = new TextView(context);
            textView.setText(str);
            textView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
            textView.setTextSize(1, 16.0f);
            textView.setTypeface(AndroidUtilities.getTypeface("fonts/iranyekanwebregular.ttf"));
            textView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setSingleLine(true);
            frameLayout.addView(textView, LayoutHelper.createFrame(-2, 32, (LocaleController.isRTL ? 5 : 3) | 48, 32.0f, 19.0f, 24.0f, 10.0f));
            builder.setTopViewAspectRatio(0.16559829f);
            builder.setTopView(frameLayout);
        } else {
            builder.setTitle(str);
        }
        recyclerListView.setAdapter(new ItemSelectionAdapter(context, arrayList, arrayList2, z, new ItemPickerDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ShopAlertsCreator.2
            @Override // ir.resaneh1.iptv.fragment.rubino.shop.ShopAlertsCreator.ItemPickerDelegate
            public void selectedItemChanged(ArrayList<? extends ShopModels.ShopSelectableItem> arrayList3) {
            }

            @Override // ir.resaneh1.iptv.fragment.rubino.shop.ShopAlertsCreator.ItemPickerDelegate
            public void didSelectItems(ArrayList<? extends ShopModels.ShopSelectableItem> arrayList3) {
                ItemPickerDelegate itemPickerDelegate2 = itemPickerDelegate;
                if (itemPickerDelegate2 != null) {
                    itemPickerDelegate2.didSelectItems(arrayList3);
                }
                builder.getDismissRunnable().run();
            }
        }));
        return builder;
    }

    public static class ItemSelectionAdapter extends RecyclerListView.SelectionAdapter {
        ItemPickerDelegate delegate;
        int endItemRow;
        private boolean isMultiSelection;
        boolean isSearch;
        ArrayList<? extends ShopModels.ShopSelectableItem> items;
        Context mContext;
        ArrayList<ShopModels.ShopSelectableItem> selectedItems;
        int startItemRow;
        ArrayList<ShopModels.ShopSelectableItem> searchResults = new ArrayList<>();
        int columnsCount = 1;

        public ItemSelectionAdapter(Context context, ArrayList<? extends ShopModels.ShopSelectableItem> arrayList, ArrayList<ShopModels.ShopSelectableItem> arrayList2, boolean z, ItemPickerDelegate itemPickerDelegate) {
            this.items = arrayList;
            this.isMultiSelection = z;
            this.selectedItems = arrayList2;
            this.delegate = itemPickerDelegate;
            this.mContext = context;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View loadingCell;
            if (i == 1) {
                loadingCell = new LoadingCell(this.mContext);
            } else if (i == 2) {
                TextAndImageView textAndImageView = new TextAndImageView(this.mContext);
                textAndImageView.setDelegate(new SelectionItemDelegate() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ShopAlertsCreator.ItemSelectionAdapter.1
                    @Override // ir.resaneh1.iptv.fragment.rubino.shop.ShopAlertsCreator.SelectionItemDelegate
                    public void didClickItem(TextAndImageView textAndImageView2, ShopModels.ShopSelectableItem shopSelectableItem) {
                        ItemSelectionAdapter itemSelectionAdapter = ItemSelectionAdapter.this;
                        if (itemSelectionAdapter.delegate != null) {
                            if (itemSelectionAdapter.selectedItems == null) {
                                itemSelectionAdapter.selectedItems = new ArrayList<>();
                            }
                            if (!ItemSelectionAdapter.this.isMultiSelection && shopSelectableItem.isSelected) {
                                Iterator<ShopModels.ShopSelectableItem> it = ItemSelectionAdapter.this.selectedItems.iterator();
                                while (it.hasNext()) {
                                    it.next().isSelected = false;
                                }
                                ItemSelectionAdapter.this.selectedItems.clear();
                            }
                            if (shopSelectableItem.isSelected) {
                                ItemSelectionAdapter.this.selectedItems.add(shopSelectableItem);
                            } else {
                                ItemSelectionAdapter.this.selectedItems.remove(shopSelectableItem);
                            }
                            if (ItemSelectionAdapter.this.isMultiSelection) {
                                textAndImageView2.setItem(shopSelectableItem);
                                ItemSelectionAdapter itemSelectionAdapter2 = ItemSelectionAdapter.this;
                                itemSelectionAdapter2.delegate.selectedItemChanged(itemSelectionAdapter2.selectedItems);
                            } else {
                                ArrayList<? extends ShopModels.ShopSelectableItem> arrayList = new ArrayList<>();
                                arrayList.add(shopSelectableItem);
                                ItemSelectionAdapter.this.notifyDataSetChanged();
                                ItemSelectionAdapter.this.delegate.didSelectItems(arrayList);
                            }
                        }
                    }
                });
                loadingCell = textAndImageView;
            } else {
                loadingCell = new GraySectionCell(this.mContext);
            }
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -2);
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = AndroidUtilities.dp(1.0f);
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = AndroidUtilities.dp(1.0f);
            loadingCell.setLayoutParams(layoutParams);
            return new RecyclerListView.Holder(loadingCell);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (viewHolder.getItemViewType() != 2) {
                return;
            }
            TextAndImageView textAndImageView = (TextAndImageView) viewHolder.itemView;
            int i2 = 0;
            while (true) {
                int i3 = this.columnsCount;
                if (i2 < i3) {
                    int i4 = ((i - this.startItemRow) * i3) + i2;
                    if (i4 < (this.isSearch ? this.searchResults : this.items).size()) {
                        ShopModels.ShopSelectableItem shopSelectableItem = (ShopModels.ShopSelectableItem) (this.isSearch ? this.searchResults : this.items).get(i4);
                        textAndImageView.setTag(Integer.valueOf(i));
                        textAndImageView.setItem(shopSelectableItem);
                    } else {
                        textAndImageView.setItem(null);
                    }
                    i2++;
                } else {
                    textAndImageView.requestLayout();
                    return;
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x000e  */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int getItemCount() {
            /*
                r4 = this;
                boolean r0 = r4.isSearch
                r1 = 0
                if (r0 == 0) goto L10
                java.util.ArrayList<ir.resaneh1.iptv.model.ShopModels$ShopSelectableItem> r0 = r4.searchResults
                if (r0 == 0) goto Le
                int r0 = r0.size()
                goto L18
            Le:
                r0 = 0
                goto L18
            L10:
                java.util.ArrayList<? extends ir.resaneh1.iptv.model.ShopModels$ShopSelectableItem> r0 = r4.items
                if (r0 == 0) goto Le
                int r0 = r0.size()
            L18:
                float r0 = (float) r0
                int r2 = r4.columnsCount
                float r2 = (float) r2
                float r0 = r0 / r2
                double r2 = (double) r0
                double r2 = java.lang.Math.ceil(r2)
                int r0 = (int) r2
                r4.startItemRow = r1
                r4.endItemRow = r0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.rubino.shop.ShopAlertsCreator.ItemSelectionAdapter.getItemCount():int");
        }

        @Override // ir.resaneh1.iptv.fragment.rubino.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            return viewHolder.getItemViewType() == 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            return (i < this.startItemRow || i >= this.endItemRow) ? 1 : 2;
        }
    }

    private static class TextAndImageView extends FrameLayout {
        Context context;
        private ShopModels.ShopSelectableItem currentItem;
        private SelectionItemDelegate delegate;
        public ImageView imageView;
        private TextView textView;

        public TextAndImageView(Context context) {
            super(context);
            this.context = context;
            setBackgroundDrawable(Theme.getSelectorDrawable(false));
            setPadding(AndroidUtilities.dp(4.0f), 0, AndroidUtilities.dp(4.0f), 0);
            ImageView imageView = new ImageView(context);
            this.imageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            addView(this.imageView, LayoutHelper.createFrame(20, 20, 21, 4.0f, 8.0f, 4.0f, 8.0f));
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setLines(1);
            this.textView.setSingleLine(true);
            this.textView.setGravity(17);
            this.textView.setEllipsize(TextUtils.TruncateAt.END);
            this.textView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
            this.textView.setTextSize(1, 16.0f);
            addView(this.textView, LayoutHelper.createFrame(-2, -2, 21, 4.0f, 4.0f, 52.0f, 4.0f));
            setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.rubino.shop.ShopAlertsCreator.TextAndImageView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TextAndImageView.this.currentItem.isSelected = !TextAndImageView.this.currentItem.isSelected;
                    if (TextAndImageView.this.delegate != null) {
                        SelectionItemDelegate selectionItemDelegate = TextAndImageView.this.delegate;
                        TextAndImageView textAndImageView = TextAndImageView.this;
                        selectionItemDelegate.didClickItem(textAndImageView, textAndImageView.currentItem);
                    }
                }
            });
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            if (this.currentItem.hasImage()) {
                ((FrameLayout.LayoutParams) this.textView.getLayoutParams()).rightMargin = AndroidUtilities.dp(52.0f);
            } else {
                ((FrameLayout.LayoutParams) this.textView.getLayoutParams()).rightMargin = AndroidUtilities.dp(4.0f);
            }
            super.onLayout(z, i, i2, i3, i4);
        }

        public void setDelegate(SelectionItemDelegate selectionItemDelegate) {
            this.delegate = selectionItemDelegate;
        }

        public void setItem(ShopModels.ShopSelectableItem shopSelectableItem) {
            this.currentItem = shopSelectableItem;
            this.textView.setText(shopSelectableItem.getName());
            if (shopSelectableItem.hasImage()) {
                this.imageView.setVisibility(0);
                this.imageView.setImageDrawable(shopSelectableItem.getImage(this.context));
            } else {
                this.imageView.setVisibility(4);
            }
            if (this.currentItem.isSelected) {
                setBackground(ContextCompat.getDrawable(this.context, R.drawable.shop_rectangle_border_blue));
            } else {
                setBackground(ContextCompat.getDrawable(this.context, R.drawable.shop_rectangle_border_grey));
            }
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setText(this.currentItem.getName());
            if (this.currentItem.isSelected) {
                accessibilityNodeInfo.setCheckable(true);
                accessibilityNodeInfo.setChecked(true);
            }
        }
    }
}
