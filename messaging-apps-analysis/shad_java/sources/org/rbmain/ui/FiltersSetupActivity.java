package org.rbmain.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ir.medu.shad.R;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.Emoji;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$InputPeer;
import org.rbmain.tgnet.TLRPC$TL_dialogFilter;
import org.rbmain.tgnet.TLRPC$TL_dialogFilterSuggested;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_messages_updateDialogFilter;
import org.rbmain.tgnet.TLRPC$TL_messages_updateDialogFiltersOrder;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.SimpleTextView;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Components.CombinedDrawable;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.ProgressButton;
import org.rbmain.ui.Components.RLottieImageView;
import org.rbmain.ui.Components.RecyclerListView;

/* loaded from: classes4.dex */
public class FiltersSetupActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private ListAdapter adapter;
    private int createFilterRow;
    private int createSectionRow;
    private int filterHelpRow;
    private int filtersEndRow;
    private int filtersHeaderRow;
    private int filtersStartRow;
    private boolean ignoreUpdates;
    private ItemTouchHelper itemTouchHelper;
    private RecyclerListView listView;
    private boolean orderChanged;
    private int recommendedEndRow;
    private int recommendedHeaderRow;
    private int recommendedSectionRow;
    private int recommendedStartRow;
    private int rowCount = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onFragmentDestroy$0(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    public static class TextCell extends FrameLayout {
        private ImageView imageView;
        private SimpleTextView textView;

        public TextCell(Context context) {
            super(context);
            SimpleTextView simpleTextView = new SimpleTextView(context);
            this.textView = simpleTextView;
            simpleTextView.setTextSize(16);
            this.textView.setGravity(LocaleController.isRTL ? 5 : 3);
            SimpleTextView simpleTextView2 = this.textView;
            int i = Theme.key_windowBackgroundWhiteBlueText2;
            simpleTextView2.setTextColor(Theme.getColor(i));
            this.textView.setTag(Integer.valueOf(i));
            addView(this.textView);
            ImageView imageView = new ImageView(context);
            this.imageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            addView(this.imageView);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int size = View.MeasureSpec.getSize(i);
            AndroidUtilities.dp(48.0f);
            this.textView.measure(View.MeasureSpec.makeMeasureSpec(size - AndroidUtilities.dp(94.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(20.0f), 1073741824));
            this.imageView.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(50.0f), 1073741824));
            setMeasuredDimension(size, AndroidUtilities.dp(50.0f));
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int iDp;
            int i5 = i3 - i;
            int textHeight = ((i4 - i2) - this.textView.getTextHeight()) / 2;
            if (LocaleController.isRTL) {
                iDp = (getMeasuredWidth() - this.textView.getMeasuredWidth()) - AndroidUtilities.dp(this.imageView.getVisibility() != 0 ? 23.0f : 64.0f);
            } else {
                iDp = AndroidUtilities.dp(this.imageView.getVisibility() != 0 ? 23.0f : 64.0f);
            }
            SimpleTextView simpleTextView = this.textView;
            simpleTextView.layout(iDp, textHeight, simpleTextView.getMeasuredWidth() + iDp, this.textView.getMeasuredHeight() + textHeight);
            int iDp2 = !LocaleController.isRTL ? AndroidUtilities.dp(20.0f) : (i5 - this.imageView.getMeasuredWidth()) - AndroidUtilities.dp(20.0f);
            ImageView imageView = this.imageView;
            imageView.layout(iDp2, 0, imageView.getMeasuredWidth() + iDp2, this.imageView.getMeasuredHeight());
        }

        public void setTextAndIcon(String str, Drawable drawable, boolean z) {
            this.textView.setText(str);
            this.imageView.setImageDrawable(drawable);
        }
    }

    public static class SuggestedFilterCell extends FrameLayout {
        private ProgressButton addButton;
        private boolean needDivider;
        private TLRPC$TL_dialogFilterSuggested suggestedFilter;
        private TextView textView;
        private TextView valueTextView;

        public SuggestedFilterCell(Context context) {
            super(context);
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
            this.textView.setTextSize(1, 16.0f);
            this.textView.setLines(1);
            this.textView.setMaxLines(1);
            this.textView.setSingleLine(true);
            this.textView.setEllipsize(TextUtils.TruncateAt.END);
            this.textView.setGravity(LocaleController.isRTL ? 5 : 3);
            addView(this.textView, LayoutHelper.createFrame(-2, -2.0f, LocaleController.isRTL ? 5 : 3, 22.0f, 10.0f, 22.0f, 0.0f));
            TextView textView2 = new TextView(context);
            this.valueTextView = textView2;
            textView2.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText2));
            this.valueTextView.setTextSize(1, 13.0f);
            this.valueTextView.setLines(1);
            this.valueTextView.setMaxLines(1);
            this.valueTextView.setSingleLine(true);
            this.valueTextView.setEllipsize(TextUtils.TruncateAt.END);
            this.valueTextView.setGravity(LocaleController.isRTL ? 5 : 3);
            addView(this.valueTextView, LayoutHelper.createFrame(-2, -2.0f, LocaleController.isRTL ? 5 : 3, 22.0f, 35.0f, 22.0f, 0.0f));
            ProgressButton progressButton = new ProgressButton(context);
            this.addButton = progressButton;
            progressButton.setText(LocaleController.getString("Add", R.string.Add));
            this.addButton.setTextColor(Theme.getColor(Theme.key_featuredStickers_buttonText));
            this.addButton.setProgressColor(Theme.getColor(Theme.key_featuredStickers_buttonProgress));
            this.addButton.setBackgroundRoundRect(Theme.getColor(Theme.key_featuredStickers_addButton), Theme.getColor(Theme.key_featuredStickers_addButtonPressed));
            addView(this.addButton, LayoutHelper.createFrameRelatively(-2.0f, 28.0f, 8388661, 0.0f, 18.0f, 14.0f, 0.0f));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            setMeasuredDimension(View.MeasureSpec.getSize(i), AndroidUtilities.dp(64.0f));
            measureChildWithMargins(this.addButton, i, 0, i2, 0);
            measureChildWithMargins(this.textView, i, this.addButton.getMeasuredWidth(), i2, 0);
            measureChildWithMargins(this.valueTextView, i, this.addButton.getMeasuredWidth(), i2, 0);
        }

        public void setFilter(TLRPC$TL_dialogFilterSuggested tLRPC$TL_dialogFilterSuggested, boolean z) {
            this.needDivider = z;
            this.suggestedFilter = tLRPC$TL_dialogFilterSuggested;
            setWillNotDraw(!z);
            this.textView.setText(tLRPC$TL_dialogFilterSuggested.filter.title);
            this.valueTextView.setText(tLRPC$TL_dialogFilterSuggested.description);
        }

        public TLRPC$TL_dialogFilterSuggested getSuggestedFilter() {
            return this.suggestedFilter;
        }

        public void setAddOnClickListener(View.OnClickListener onClickListener) {
            this.addButton.setOnClickListener(onClickListener);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.needDivider) {
                canvas.drawLine(0.0f, getHeight() - 1, getWidth() - getPaddingRight(), getHeight() - 1, Theme.dividerPaint);
            }
        }
    }

    public static class HintInnerCell extends FrameLayout {
        private RLottieImageView imageView;
        private TextView messageTextView;

        public HintInnerCell(Context context) {
            super(context);
            RLottieImageView rLottieImageView = new RLottieImageView(context);
            this.imageView = rLottieImageView;
            rLottieImageView.setAnimation(R.raw.filters, 90, 90);
            this.imageView.setScaleType(ImageView.ScaleType.CENTER);
            this.imageView.playAnimation();
            addView(this.imageView, LayoutHelper.createFrame(90, 90.0f, 49, 0.0f, 14.0f, 0.0f, 0.0f));
            this.imageView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.FiltersSetupActivity$HintInnerCell$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0(view);
                }
            });
            TextView textView = new TextView(context);
            this.messageTextView = textView;
            textView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText4));
            this.messageTextView.setTextSize(1, 14.0f);
            this.messageTextView.setGravity(17);
            this.messageTextView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("CreateNewFilterInfo", R.string.CreateNewFilterInfo, new Object[0])));
            addView(this.messageTextView, LayoutHelper.createFrame(-1, -2.0f, 49, 40.0f, 121.0f, 40.0f, 24.0f));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) {
            if (this.imageView.isPlaying()) {
                return;
            }
            this.imageView.setProgress(0.0f);
            this.imageView.playAnimation();
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), i2);
        }
    }

    public static class FilterCell extends FrameLayout {
        private MessagesController.DialogFilter currentFilter;
        private ImageView moveImageView;
        private boolean needDivider;
        private ImageView optionsImageView;
        private TextView textView;
        private TextView valueTextView;

        public FilterCell(Context context) {
            super(context);
            setWillNotDraw(false);
            ImageView imageView = new ImageView(context);
            this.moveImageView = imageView;
            imageView.setFocusable(false);
            this.moveImageView.setScaleType(ImageView.ScaleType.CENTER);
            this.moveImageView.setImageResource(R.drawable.list_reorder);
            ImageView imageView2 = this.moveImageView;
            int i = Theme.key_stickers_menu;
            imageView2.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY));
            this.moveImageView.setContentDescription(LocaleController.getString("FilterReorder", R.string.FilterReorder));
            this.moveImageView.setClickable(true);
            addView(this.moveImageView, LayoutHelper.createFrame(48, 48.0f, (LocaleController.isRTL ? 5 : 3) | 16, 6.0f, 0.0f, 6.0f, 0.0f));
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
            this.textView.setTextSize(1, 16.0f);
            this.textView.setLines(1);
            this.textView.setMaxLines(1);
            this.textView.setSingleLine(true);
            this.textView.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
            this.textView.setEllipsize(TextUtils.TruncateAt.END);
            TextView textView2 = this.textView;
            boolean z = LocaleController.isRTL;
            addView(textView2, LayoutHelper.createFrame(-1, -2.0f, (z ? 5 : 3) | 48, z ? 80.0f : 64.0f, 14.0f, z ? 64.0f : 80.0f, 0.0f));
            TextView textView3 = new TextView(context);
            this.valueTextView = textView3;
            textView3.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText2));
            this.valueTextView.setTextSize(1, 13.0f);
            this.valueTextView.setGravity(LocaleController.isRTL ? 5 : 3);
            this.valueTextView.setLines(1);
            this.valueTextView.setMaxLines(1);
            this.valueTextView.setSingleLine(true);
            this.valueTextView.setPadding(0, 0, 0, 0);
            this.valueTextView.setEllipsize(TextUtils.TruncateAt.END);
            TextView textView4 = this.valueTextView;
            boolean z2 = LocaleController.isRTL;
            addView(textView4, LayoutHelper.createFrame(-2, -2.0f, (z2 ? 5 : 3) | 48, z2 ? 80.0f : 64.0f, 35.0f, z2 ? 64.0f : 80.0f, 0.0f));
            this.valueTextView.setVisibility(8);
            ImageView imageView3 = new ImageView(context);
            this.optionsImageView = imageView3;
            imageView3.setFocusable(false);
            this.optionsImageView.setScaleType(ImageView.ScaleType.CENTER);
            this.optionsImageView.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor(Theme.key_stickers_menuSelector)));
            this.optionsImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i), PorterDuff.Mode.MULTIPLY));
            this.optionsImageView.setImageResource(R.drawable.msg_actions);
            this.optionsImageView.setContentDescription(LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
            addView(this.optionsImageView, LayoutHelper.createFrame(40, 40.0f, (LocaleController.isRTL ? 3 : 5) | 16, 6.0f, 0.0f, 6.0f, 0.0f));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(50.0f), 1073741824));
        }

        public void setFilter(MessagesController.DialogFilter dialogFilter, boolean z) {
            this.currentFilter = dialogFilter;
            StringBuilder sb = new StringBuilder();
            int i = dialogFilter.flags;
            int i2 = MessagesController.DIALOG_FILTER_FLAG_ALL_CHATS;
            if ((i & i2) == i2) {
                sb.append(LocaleController.getString("FilterAllChats", R.string.FilterAllChats));
            } else {
                if ((i & MessagesController.DIALOG_FILTER_FLAG_CONTACTS) != 0) {
                    if (sb.length() != 0) {
                        sb.append(", ");
                    }
                    sb.append(LocaleController.getString("FilterContacts", R.string.FilterContacts));
                }
                if ((dialogFilter.flags & MessagesController.DIALOG_FILTER_FLAG_NON_CONTACTS) != 0) {
                    if (sb.length() != 0) {
                        sb.append(", ");
                    }
                    sb.append(LocaleController.getString("FilterNonContacts", R.string.FilterNonContacts));
                }
                if ((dialogFilter.flags & MessagesController.DIALOG_FILTER_FLAG_GROUPS) != 0) {
                    if (sb.length() != 0) {
                        sb.append(", ");
                    }
                    sb.append(LocaleController.getString("FilterGroups", R.string.FilterGroups));
                }
                if ((dialogFilter.flags & MessagesController.DIALOG_FILTER_FLAG_CHANNELS) != 0) {
                    if (sb.length() != 0) {
                        sb.append(", ");
                    }
                    sb.append(LocaleController.getString("FilterChannels", R.string.FilterChannels));
                }
                if ((dialogFilter.flags & MessagesController.DIALOG_FILTER_FLAG_BOTS) != 0) {
                    if (sb.length() != 0) {
                        sb.append(", ");
                    }
                    sb.append(LocaleController.getString("FilterBots", R.string.FilterBots));
                }
            }
            if (!dialogFilter.alwaysShow.isEmpty() || !dialogFilter.neverShow.isEmpty()) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append(LocaleController.formatPluralString("Exception", dialogFilter.alwaysShow.size() + dialogFilter.neverShow.size()));
            }
            if (sb.length() == 0) {
                sb.append(LocaleController.getString("FilterNoChats", R.string.FilterNoChats));
            }
            TextView textView = this.textView;
            textView.setText(Emoji.replaceEmoji(dialogFilter.name, textView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(20.0f), false));
            this.valueTextView.setText(sb);
            this.needDivider = z;
        }

        public MessagesController.DialogFilter getCurrentFilter() {
            return this.currentFilter;
        }

        public void setOnOptionsClick(View.OnClickListener onClickListener) {
            this.optionsImageView.setOnClickListener(onClickListener);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.needDivider) {
                canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(62.0f), getMeasuredHeight() - 1, getMeasuredWidth() - (LocaleController.isRTL ? AndroidUtilities.dp(62.0f) : 0), getMeasuredHeight() - 1, Theme.dividerPaint);
            }
        }

        public void setOnReorderButtonTouchListener(View.OnTouchListener onTouchListener) {
            this.moveImageView.setOnTouchListener(onTouchListener);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        updateRows(true);
        getMessagesController().loadRemoteFilters(true);
        getNotificationCenter().addObserver(this, NotificationCenter.dialogFiltersUpdated);
        getNotificationCenter().addObserver(this, NotificationCenter.suggestedFiltersLoaded);
        getMessagesController().loadSuggestedFilters();
        return super.onFragmentCreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRows(boolean z) {
        ListAdapter listAdapter;
        this.recommendedHeaderRow = -1;
        this.recommendedStartRow = -1;
        this.recommendedEndRow = -1;
        this.recommendedSectionRow = -1;
        ArrayList<TLRPC$TL_dialogFilterSuggested> arrayList = getMessagesController().suggestedFilters;
        this.rowCount = 0;
        this.rowCount = 0 + 1;
        this.filterHelpRow = 0;
        int size = getMessagesController().dialogFilters.size();
        if (!arrayList.isEmpty() && size < 10) {
            int i = this.rowCount;
            int i2 = i + 1;
            this.rowCount = i2;
            this.recommendedHeaderRow = i;
            this.recommendedStartRow = i2;
            int size2 = i2 + arrayList.size();
            this.rowCount = size2;
            this.recommendedEndRow = size2;
            this.rowCount = size2 + 1;
            this.recommendedSectionRow = size2;
        }
        if (size != 0) {
            int i3 = this.rowCount;
            int i4 = i3 + 1;
            this.rowCount = i4;
            this.filtersHeaderRow = i3;
            this.filtersStartRow = i4;
            int i5 = i4 + size;
            this.rowCount = i5;
            this.filtersEndRow = i5;
        } else {
            this.filtersHeaderRow = -1;
            this.filtersStartRow = -1;
            this.filtersEndRow = -1;
        }
        if (size < getAccountInstance().getCoreMainClass().getMaxFoldersCount()) {
            int i6 = this.rowCount;
            this.rowCount = i6 + 1;
            this.createFilterRow = i6;
        } else {
            this.createFilterRow = -1;
        }
        int i7 = this.rowCount;
        this.rowCount = i7 + 1;
        this.createSectionRow = i7;
        if (!z || (listAdapter = this.adapter) == null) {
            return;
        }
        listAdapter.notifyDataSetChanged();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        NotificationCenter notificationCenter = getNotificationCenter();
        int i = NotificationCenter.dialogFiltersUpdated;
        notificationCenter.removeObserver(this, i);
        getNotificationCenter().removeObserver(this, NotificationCenter.suggestedFiltersLoaded);
        if (this.orderChanged) {
            getNotificationCenter().postNotificationName(i, new Object[0]);
            getMessagesStorage().saveDialogFiltersOrder();
            TLRPC$TL_messages_updateDialogFiltersOrder tLRPC$TL_messages_updateDialogFiltersOrder = new TLRPC$TL_messages_updateDialogFiltersOrder();
            ArrayList<MessagesController.DialogFilter> arrayList = getMessagesController().dialogFilters;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.get(i2);
                tLRPC$TL_messages_updateDialogFiltersOrder.order.add(Integer.valueOf(arrayList.get(i2).id));
            }
            getDialogsProxy().saveDialogFiltersOrder(tLRPC$TL_messages_updateDialogFiltersOrder, new RequestDelegate() { // from class: org.rbmain.ui.FiltersSetupActivity$$ExternalSyntheticLambda0
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    FiltersSetupActivity.lambda$onFragmentDestroy$0(tLObject, tLRPC$TL_error);
                }
            });
        }
        super.onFragmentDestroy();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString("Filters", R.string.Filters));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.FiltersSetupActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == -1) {
                    FiltersSetupActivity.this.finishFragment();
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        RecyclerListView recyclerListView = new RecyclerListView(context);
        this.listView = recyclerListView;
        ((DefaultItemAnimator) recyclerListView.getItemAnimator()).setDelayAnimations(false);
        this.listView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        this.listView.setVerticalScrollBarEnabled(false);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new TouchHelperCallback());
        this.itemTouchHelper = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(this.listView);
        frameLayout2.addView(this.listView, LayoutHelper.createFrame(-1, -1.0f));
        RecyclerListView recyclerListView2 = this.listView;
        ListAdapter listAdapter = new ListAdapter(context);
        this.adapter = listAdapter;
        recyclerListView2.setAdapter(listAdapter);
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListenerExtended() { // from class: org.rbmain.ui.FiltersSetupActivity$$ExternalSyntheticLambda1
            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public /* synthetic */ boolean hasDoubleTap(View view, int i) {
                return RecyclerListView.OnItemClickListenerExtended.CC.$default$hasDoubleTap(this, view, i);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public /* synthetic */ void onDoubleTap(View view, int i, float f, float f2) {
                RecyclerListView.OnItemClickListenerExtended.CC.$default$onDoubleTap(this, view, i, f, f2);
            }

            @Override // org.rbmain.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public final void onItemClick(View view, int i, float f, float f2) {
                this.f$0.lambda$createView$1(view, i, f, f2);
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$1(View view, int i, float f, float f2) {
        if (i >= this.filtersStartRow && i < this.filtersEndRow) {
            presentFragment(new FilterCreateActivity(getMessagesController().dialogFilters.get(i - this.filtersStartRow)));
        } else if (i == this.createFilterRow) {
            presentFragment(new FilterCreateActivity());
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.adapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.dialogFiltersUpdated) {
            if (this.ignoreUpdates) {
                return;
            }
            updateRows(true);
        } else if (i == NotificationCenter.suggestedFiltersLoaded) {
            updateRows(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // org.rbmain.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            return (itemViewType == 3 || itemViewType == 0 || itemViewType == 5 || itemViewType == 1) ? false : true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return FiltersSetupActivity.this.rowCount;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$onCreateViewHolder$0(FilterCell filterCell, View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            FiltersSetupActivity.this.itemTouchHelper.startDrag(FiltersSetupActivity.this.listView.getChildViewHolder(filterCell));
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$5(View view) {
            final MessagesController.DialogFilter currentFilter = ((FilterCell) view.getParent()).getCurrentFilter();
            AlertDialog.Builder builder = new AlertDialog.Builder(FiltersSetupActivity.this.getParentActivity());
            TextPaint textPaint = new TextPaint(1);
            textPaint.setTextSize(AndroidUtilities.dp(20.0f));
            builder.setTitle(Emoji.replaceEmoji(currentFilter.name, textPaint.getFontMetricsInt(), AndroidUtilities.dp(20.0f), false));
            builder.setItems(new CharSequence[]{LocaleController.getString("FilterEditItem", R.string.FilterEditItem), LocaleController.getString("FilterDeleteItem", R.string.FilterDeleteItem)}, new int[]{R.drawable.msg_edit, R.drawable.msg_delete}, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.FiltersSetupActivity$ListAdapter$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onCreateViewHolder$4(currentFilter, dialogInterface, i);
                }
            });
            AlertDialog alertDialogCreate = builder.create();
            FiltersSetupActivity.this.showDialog(alertDialogCreate);
            alertDialogCreate.setItemColor(1, Theme.getColor(Theme.key_text_RedBold), Theme.getColor(Theme.key_text_RedRegular));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$4(final MessagesController.DialogFilter dialogFilter, DialogInterface dialogInterface, int i) {
            if (i == 0) {
                FiltersSetupActivity.this.presentFragment(new FilterCreateActivity(dialogFilter));
                return;
            }
            if (i == 1) {
                AlertDialog.Builder builder = new AlertDialog.Builder(FiltersSetupActivity.this.getParentActivity());
                builder.setTitle(LocaleController.getString("FilterDelete", R.string.FilterDelete));
                builder.setMessage(LocaleController.getString("FilterDeleteAlert", R.string.FilterDeleteAlert));
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                builder.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.FiltersSetupActivity$ListAdapter$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface2, int i2) {
                        this.f$0.lambda$onCreateViewHolder$3(dialogFilter, dialogInterface2, i2);
                    }
                });
                AlertDialog alertDialogCreate = builder.create();
                FiltersSetupActivity.this.showDialog(alertDialogCreate);
                TextView textView = (TextView) alertDialogCreate.getButton(-1);
                if (textView != null) {
                    textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$3(final MessagesController.DialogFilter dialogFilter, DialogInterface dialogInterface, int i) {
            final AlertDialog alertDialog;
            if (FiltersSetupActivity.this.getParentActivity() != null) {
                alertDialog = new AlertDialog(FiltersSetupActivity.this.getParentActivity(), 3);
                alertDialog.setCanCancel(false);
                alertDialog.show();
            } else {
                alertDialog = null;
            }
            TLRPC$TL_messages_updateDialogFilter tLRPC$TL_messages_updateDialogFilter = new TLRPC$TL_messages_updateDialogFilter();
            tLRPC$TL_messages_updateDialogFilter.id = dialogFilter.id;
            FiltersSetupActivity.this.getDialogsProxy().deleteDialogFilter(tLRPC$TL_messages_updateDialogFilter, new RequestDelegate() { // from class: org.rbmain.ui.FiltersSetupActivity$ListAdapter$$ExternalSyntheticLambda7
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$onCreateViewHolder$2(alertDialog, dialogFilter, tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$2(final AlertDialog alertDialog, final MessagesController.DialogFilter dialogFilter, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.FiltersSetupActivity$ListAdapter$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCreateViewHolder$1(alertDialog, tLRPC$TL_error, dialogFilter);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$1(AlertDialog alertDialog, TLRPC$TL_error tLRPC$TL_error, MessagesController.DialogFilter dialogFilter) {
            if (alertDialog != null) {
                try {
                    alertDialog.dismiss();
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            if (tLRPC$TL_error != null) {
                return;
            }
            int iIndexOf = FiltersSetupActivity.this.getMessagesController().dialogFilters.indexOf(dialogFilter);
            if (iIndexOf >= 0) {
                iIndexOf += FiltersSetupActivity.this.filtersStartRow;
            }
            FiltersSetupActivity.this.ignoreUpdates = true;
            FiltersSetupActivity.this.getMessagesController().removeFilter(dialogFilter);
            FiltersSetupActivity.this.ignoreUpdates = false;
            int i = FiltersSetupActivity.this.createFilterRow;
            int i2 = FiltersSetupActivity.this.recommendedHeaderRow;
            FiltersSetupActivity.this.updateRows(iIndexOf == -1);
            if (iIndexOf != -1) {
                if (FiltersSetupActivity.this.filtersStartRow == -1) {
                    FiltersSetupActivity.this.adapter.notifyItemRangeRemoved(iIndexOf - 1, 2);
                } else {
                    FiltersSetupActivity.this.adapter.notifyItemRemoved(iIndexOf);
                }
                if (i2 == -1 && FiltersSetupActivity.this.recommendedHeaderRow != -1) {
                    FiltersSetupActivity.this.adapter.notifyItemRangeInserted(i2, (FiltersSetupActivity.this.recommendedSectionRow - FiltersSetupActivity.this.recommendedHeaderRow) + 1);
                }
                if (i != -1 || FiltersSetupActivity.this.createFilterRow == -1) {
                    return;
                }
                FiltersSetupActivity.this.adapter.notifyItemInserted(FiltersSetupActivity.this.createFilterRow);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View shadowSectionCell;
            if (i == 0) {
                View headerCell = new HeaderCell(this.mContext);
                headerCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                shadowSectionCell = headerCell;
            } else if (i == 1) {
                View hintInnerCell = new HintInnerCell(this.mContext);
                hintInnerCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_top, Theme.key_windowBackgroundGrayShadow));
                shadowSectionCell = hintInnerCell;
            } else if (i == 2) {
                final FilterCell filterCell = new FilterCell(this.mContext);
                filterCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                filterCell.setOnReorderButtonTouchListener(new View.OnTouchListener() { // from class: org.rbmain.ui.FiltersSetupActivity$ListAdapter$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return this.f$0.lambda$onCreateViewHolder$0(filterCell, view, motionEvent);
                    }
                });
                filterCell.setOnOptionsClick(new View.OnClickListener() { // from class: org.rbmain.ui.FiltersSetupActivity$ListAdapter$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onCreateViewHolder$5(view);
                    }
                });
                shadowSectionCell = filterCell;
            } else if (i == 3) {
                shadowSectionCell = new ShadowSectionCell(this.mContext);
            } else if (i == 4) {
                View textCell = new TextCell(this.mContext);
                textCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                shadowSectionCell = textCell;
            } else {
                final SuggestedFilterCell suggestedFilterCell = new SuggestedFilterCell(this.mContext);
                suggestedFilterCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
                suggestedFilterCell.setAddOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.FiltersSetupActivity$ListAdapter$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.lambda$onCreateViewHolder$7(suggestedFilterCell, view);
                    }
                });
                shadowSectionCell = suggestedFilterCell;
            }
            return new RecyclerListView.Holder(shadowSectionCell);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$7(SuggestedFilterCell suggestedFilterCell, View view) {
            final TLRPC$TL_dialogFilterSuggested suggestedFilter = suggestedFilterCell.getSuggestedFilter();
            MessagesController.DialogFilter dialogFilter = new MessagesController.DialogFilter();
            TLRPC$TL_dialogFilter tLRPC$TL_dialogFilter = suggestedFilter.filter;
            dialogFilter.name = tLRPC$TL_dialogFilter.title;
            dialogFilter.isSuggested = tLRPC$TL_dialogFilter.is_suggested;
            dialogFilter.suggestedFolderId = tLRPC$TL_dialogFilter.suggested_folder_id;
            dialogFilter.unreadCount = -1;
            dialogFilter.pendingUnreadCount = -1;
            int i = 0;
            while (i < 2) {
                TLRPC$TL_dialogFilter tLRPC$TL_dialogFilter2 = suggestedFilter.filter;
                ArrayList<TLRPC$InputPeer> arrayList = i == 0 ? tLRPC$TL_dialogFilter2.include_peers : tLRPC$TL_dialogFilter2.exclude_peers;
                ArrayList<Integer> arrayList2 = i == 0 ? dialogFilter.alwaysShow : dialogFilter.neverShow;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    TLRPC$InputPeer tLRPC$InputPeer = arrayList.get(i2);
                    int i3 = tLRPC$InputPeer.user_id;
                    if (i3 == 0) {
                        int i4 = tLRPC$InputPeer.chat_id;
                        i3 = i4 != 0 ? -i4 : -tLRPC$InputPeer.channel_id;
                    }
                    arrayList2.add(Integer.valueOf(i3));
                }
                i++;
            }
            TLRPC$TL_dialogFilter tLRPC$TL_dialogFilter3 = suggestedFilter.filter;
            if (tLRPC$TL_dialogFilter3.groups) {
                dialogFilter.flags |= MessagesController.DIALOG_FILTER_FLAG_GROUPS;
            }
            if (tLRPC$TL_dialogFilter3.bots) {
                dialogFilter.flags |= MessagesController.DIALOG_FILTER_FLAG_BOTS;
            }
            if (tLRPC$TL_dialogFilter3.contacts) {
                dialogFilter.flags |= MessagesController.DIALOG_FILTER_FLAG_CONTACTS;
            }
            if (tLRPC$TL_dialogFilter3.non_contacts) {
                dialogFilter.flags |= MessagesController.DIALOG_FILTER_FLAG_NON_CONTACTS;
            }
            if (tLRPC$TL_dialogFilter3.broadcasts) {
                dialogFilter.flags |= MessagesController.DIALOG_FILTER_FLAG_CHANNELS;
            }
            if (tLRPC$TL_dialogFilter3.exclude_archived) {
                dialogFilter.flags |= MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_ARCHIVED;
            }
            if (tLRPC$TL_dialogFilter3.exclude_read) {
                dialogFilter.flags |= MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_READ;
            }
            if (tLRPC$TL_dialogFilter3.exclude_muted) {
                dialogFilter.flags |= MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_MUTED;
            }
            FiltersSetupActivity.this.ignoreUpdates = true;
            FilterCreateActivity.saveFilterToServer(dialogFilter, dialogFilter.flags, dialogFilter.name, dialogFilter.alwaysShow, dialogFilter.neverShow, dialogFilter.pinnedDialogs, true, true, true, true, false, FiltersSetupActivity.this, new Runnable() { // from class: org.rbmain.ui.FiltersSetupActivity$ListAdapter$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCreateViewHolder$6(suggestedFilter);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCreateViewHolder$6(TLRPC$TL_dialogFilterSuggested tLRPC$TL_dialogFilterSuggested) {
            FiltersSetupActivity.this.getNotificationCenter().postNotificationName(NotificationCenter.dialogFiltersUpdated, new Object[0]);
            FiltersSetupActivity.this.ignoreUpdates = false;
            ArrayList<TLRPC$TL_dialogFilterSuggested> arrayList = FiltersSetupActivity.this.getMessagesController().suggestedFilters;
            int iIndexOf = arrayList.indexOf(tLRPC$TL_dialogFilterSuggested);
            if (iIndexOf != -1) {
                boolean z = FiltersSetupActivity.this.filtersStartRow == -1;
                arrayList.remove(iIndexOf);
                int i = iIndexOf + FiltersSetupActivity.this.recommendedStartRow;
                int i2 = FiltersSetupActivity.this.createFilterRow;
                int i3 = FiltersSetupActivity.this.recommendedHeaderRow;
                int i4 = FiltersSetupActivity.this.recommendedSectionRow;
                FiltersSetupActivity.this.updateRows(false);
                if (i2 != -1 && FiltersSetupActivity.this.createFilterRow == -1) {
                    FiltersSetupActivity.this.adapter.notifyItemRemoved(i2);
                }
                if (i3 == -1 || FiltersSetupActivity.this.recommendedHeaderRow != -1) {
                    FiltersSetupActivity.this.adapter.notifyItemRemoved(i);
                } else {
                    FiltersSetupActivity.this.adapter.notifyItemRangeRemoved(i3, (i4 - i3) + 1);
                }
                if (z) {
                    FiltersSetupActivity.this.adapter.notifyItemInserted(FiltersSetupActivity.this.filtersHeaderRow);
                }
                FiltersSetupActivity.this.adapter.notifyItemInserted(FiltersSetupActivity.this.filtersStartRow);
                return;
            }
            FiltersSetupActivity.this.updateRows(true);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) throws Resources.NotFoundException {
            int itemViewType = viewHolder.getItemViewType();
            if (itemViewType == 0) {
                HeaderCell headerCell = (HeaderCell) viewHolder.itemView;
                if (i != FiltersSetupActivity.this.filtersHeaderRow) {
                    if (i == FiltersSetupActivity.this.recommendedHeaderRow) {
                        headerCell.setText(LocaleController.getString("FilterRecommended", R.string.FilterRecommended));
                        return;
                    }
                    return;
                }
                headerCell.setText(LocaleController.getString("Filters", R.string.Filters));
                return;
            }
            if (itemViewType == 2) {
                ((FilterCell) viewHolder.itemView).setFilter(FiltersSetupActivity.this.getMessagesController().dialogFilters.get(i - FiltersSetupActivity.this.filtersStartRow), true);
                return;
            }
            if (itemViewType == 3) {
                if (i == FiltersSetupActivity.this.createSectionRow) {
                    viewHolder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
                    return;
                } else {
                    viewHolder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
                    return;
                }
            }
            if (itemViewType != 4) {
                if (itemViewType != 5) {
                    return;
                }
                ((SuggestedFilterCell) viewHolder.itemView).setFilter(FiltersSetupActivity.this.getMessagesController().suggestedFilters.get(i - FiltersSetupActivity.this.recommendedStartRow), FiltersSetupActivity.this.recommendedStartRow != FiltersSetupActivity.this.recommendedEndRow - 1);
                return;
            }
            TextCell textCell = (TextCell) viewHolder.itemView;
            MessagesController.getNotificationsSettings(((BaseFragment) FiltersSetupActivity.this).currentAccount);
            if (i == FiltersSetupActivity.this.createFilterRow) {
                Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.poll_add_circle);
                Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.poll_add_plus);
                drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_switchTrackChecked), PorterDuff.Mode.MULTIPLY));
                drawable2.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_checkboxCheck), PorterDuff.Mode.MULTIPLY));
                textCell.setTextAndIcon(LocaleController.getString("CreateNewFilter", R.string.CreateNewFilter), new CombinedDrawable(drawable, drawable2), false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (i == FiltersSetupActivity.this.filtersHeaderRow || i == FiltersSetupActivity.this.recommendedHeaderRow) {
                return 0;
            }
            if (i == FiltersSetupActivity.this.filterHelpRow) {
                return 1;
            }
            if (i >= FiltersSetupActivity.this.filtersStartRow && i < FiltersSetupActivity.this.filtersEndRow) {
                return 2;
            }
            if (i == FiltersSetupActivity.this.createSectionRow || i == FiltersSetupActivity.this.recommendedSectionRow) {
                return 3;
            }
            return i == FiltersSetupActivity.this.createFilterRow ? 4 : 5;
        }

        public void swapElements(int i, int i2) {
            int i3 = i - FiltersSetupActivity.this.filtersStartRow;
            int i4 = i2 - FiltersSetupActivity.this.filtersStartRow;
            int i5 = FiltersSetupActivity.this.filtersEndRow - FiltersSetupActivity.this.filtersStartRow;
            if (i3 < 0 || i4 < 0 || i3 >= i5 || i4 >= i5) {
                return;
            }
            ArrayList<MessagesController.DialogFilter> arrayList = FiltersSetupActivity.this.getMessagesController().dialogFilters;
            MessagesController.DialogFilter dialogFilter = arrayList.get(i3);
            MessagesController.DialogFilter dialogFilter2 = arrayList.get(i4);
            int i6 = dialogFilter.order;
            dialogFilter.order = dialogFilter2.order;
            dialogFilter2.order = i6;
            arrayList.set(i3, dialogFilter2);
            arrayList.set(i4, dialogFilter);
            FiltersSetupActivity.this.orderChanged = true;
            notifyItemMoved(i, i2);
        }
    }

    public class TouchHelperCallback extends ItemTouchHelper.Callback {
        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        }

        public TouchHelperCallback() {
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            if (viewHolder.getItemViewType() != 2) {
                return ItemTouchHelper.Callback.makeMovementFlags(0, 0);
            }
            return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            if (viewHolder.getItemViewType() != viewHolder2.getItemViewType()) {
                return false;
            }
            FiltersSetupActivity.this.adapter.swapElements(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
            super.onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, z);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
            if (i != 0) {
                FiltersSetupActivity.this.listView.cancelClickRunnables(false);
                viewHolder.itemView.setPressed(true);
            }
            super.onSelectedChanged(viewHolder, i);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            super.clearView(recyclerView, viewHolder);
            viewHolder.itemView.setPressed(false);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{HeaderCell.class, TextCell.class, FilterCell.class, SuggestedFilterCell.class}, null, null, null, Theme.key_windowBackgroundWhite));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundGray));
        ActionBar actionBar = this.actionBar;
        int i = ThemeDescription.FLAG_BACKGROUND;
        int i2 = Theme.key_actionBarDefault;
        arrayList.add(new ThemeDescription(actionBar, i, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, Theme.key_listSelector));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueHeader));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{FilterCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlackText));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{FilterCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText2));
        int i3 = Theme.key_stickers_menu;
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{FilterCell.class}, new String[]{"moveImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{FilterCell.class}, new String[]{"optionsImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i3));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, new Class[]{FilterCell.class}, new String[]{"optionsImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_stickers_menuSelector));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueText2));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrackChecked));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_checkboxCheck));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, Theme.key_windowBackgroundGrayShadow));
        return arrayList;
    }
}
