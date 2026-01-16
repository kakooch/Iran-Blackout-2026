package ir.eitaa.ui;

import android.annotation.SuppressLint;
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
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.Emoji;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$InputPeer;
import ir.eitaa.tgnet.TLRPC$TL_boolTrue;
import ir.eitaa.tgnet.TLRPC$TL_dialogFilter;
import ir.eitaa.tgnet.TLRPC$TL_dialogFilterSuggested;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_messages_updateDialogFilter;
import ir.eitaa.tgnet.TLRPC$TL_messages_updateDialogFiltersOrder;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.SimpleTextView;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextCheckCell;
import ir.eitaa.ui.Cells.TextDetailSettingsCell;
import ir.eitaa.ui.Components.CombinedDrawable;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.ProgressButton;
import ir.eitaa.ui.Components.RLottieImageView;
import ir.eitaa.ui.Components.RecyclerListView;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class FiltersSetupActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private ListAdapter adapter;
    private int createFilterRow;
    private int createSectionRow;
    private int filterHelpRow;
    private int filtersEndRow;
    private int filtersHeaderRow;
    private int filtersStartRow;
    private int filtersVisibilityRow;
    private boolean ignoreUpdates;
    private ItemTouchHelper itemTouchHelper;
    private RecyclerListView listView;
    private boolean orderChanged;
    private int recommendedEndRow;
    private int recommendedHeaderRow;
    private int recommendedSectionRow;
    private int recommendedStartRow;
    private int resetRow;
    private int rowCount = 0;
    private boolean hasResetFilters = false;

    static /* synthetic */ void lambda$onFragmentDestroy$0(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    public static class TextCell extends FrameLayout {
        private ImageView imageView;
        private SimpleTextView textView;

        public TextCell(Context context) {
            super(context);
            SimpleTextView simpleTextView = new SimpleTextView(context);
            this.textView = simpleTextView;
            simpleTextView.setTextSize(16);
            this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.textView.setGravity(LocaleController.isRTL ? 5 : 3);
            this.textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText2"));
            this.textView.setTag("windowBackgroundWhiteBlueText2");
            addView(this.textView);
            ImageView imageView = new ImageView(context);
            this.imageView = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            addView(this.imageView);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int size = View.MeasureSpec.getSize(widthMeasureSpec);
            AndroidUtilities.dp(48.0f);
            this.textView.measure(View.MeasureSpec.makeMeasureSpec(size - AndroidUtilities.dp(94.0f), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(20.0f), 1073741824));
            this.imageView.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(50.0f), 1073741824));
            setMeasuredDimension(size, AndroidUtilities.dp(50.0f));
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
            int iDp;
            int i = right - left;
            int textHeight = ((bottom - top) - this.textView.getTextHeight()) / 2;
            if (LocaleController.isRTL) {
                iDp = (getMeasuredWidth() - this.textView.getMeasuredWidth()) - AndroidUtilities.dp(this.imageView.getVisibility() != 0 ? 23.0f : 64.0f);
            } else {
                iDp = AndroidUtilities.dp(this.imageView.getVisibility() != 0 ? 23.0f : 64.0f);
            }
            SimpleTextView simpleTextView = this.textView;
            simpleTextView.layout(iDp, textHeight, simpleTextView.getMeasuredWidth() + iDp, this.textView.getMeasuredHeight() + textHeight);
            int iDp2 = !LocaleController.isRTL ? AndroidUtilities.dp(20.0f) : (i - this.imageView.getMeasuredWidth()) - AndroidUtilities.dp(20.0f);
            ImageView imageView = this.imageView;
            imageView.layout(iDp2, 0, imageView.getMeasuredWidth() + iDp2, this.imageView.getMeasuredHeight());
        }

        public void setTextAndIcon(String text, Drawable icon, boolean divider) {
            this.textView.setText(text);
            this.imageView.setImageDrawable(icon);
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
            textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.textView.setTextSize(1, 16.0f);
            this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.textView.setLines(1);
            this.textView.setMaxLines(1);
            this.textView.setSingleLine(true);
            this.textView.setEllipsize(TextUtils.TruncateAt.END);
            this.textView.setGravity(LocaleController.isRTL ? 5 : 3);
            addView(this.textView, LayoutHelper.createFrame(-2, -2.0f, LocaleController.isRTL ? 5 : 3, 22.0f, 10.0f, 22.0f, 0.0f));
            TextView textView2 = new TextView(context);
            this.valueTextView = textView2;
            textView2.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText2"));
            this.valueTextView.setTextSize(1, 13.0f);
            this.valueTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.valueTextView.setLines(1);
            this.valueTextView.setMaxLines(1);
            this.valueTextView.setSingleLine(true);
            this.valueTextView.setEllipsize(TextUtils.TruncateAt.END);
            this.valueTextView.setGravity(LocaleController.isRTL ? 5 : 3);
            addView(this.valueTextView, LayoutHelper.createFrame(-2, -2.0f, LocaleController.isRTL ? 5 : 3, 22.0f, 35.0f, 22.0f, 0.0f));
            ProgressButton progressButton = new ProgressButton(context);
            this.addButton = progressButton;
            progressButton.setText(LocaleController.getString("Add", R.string.Add));
            this.addButton.setTextColor(Theme.getColor("featuredStickers_buttonText"));
            this.addButton.setProgressColor(Theme.getColor("featuredStickers_buttonProgress"));
            this.addButton.setBackgroundRoundRect(Theme.getColor("featuredStickers_addButton"), Theme.getColor("featuredStickers_addButtonPressed"));
            addView(this.addButton, LayoutHelper.createFrameRelatively(-2.0f, 28.0f, 8388661, 0.0f, 18.0f, 14.0f, 0.0f));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), AndroidUtilities.dp(64.0f));
            measureChildWithMargins(this.addButton, widthMeasureSpec, 0, heightMeasureSpec, 0);
            measureChildWithMargins(this.textView, widthMeasureSpec, this.addButton.getMeasuredWidth(), heightMeasureSpec, 0);
            measureChildWithMargins(this.valueTextView, widthMeasureSpec, this.addButton.getMeasuredWidth(), heightMeasureSpec, 0);
        }

        public void setFilter(TLRPC$TL_dialogFilterSuggested filter, boolean divider) {
            this.needDivider = divider;
            this.suggestedFilter = filter;
            setWillNotDraw(!divider);
            this.textView.setText(filter.filter.title);
            this.valueTextView.setText(filter.description);
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
            this.imageView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$FiltersSetupActivity$HintInnerCell$Akplg0wsWgi9lEzX7KtOKzeu6SI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$0$FiltersSetupActivity$HintInnerCell(view);
                }
            });
            TextView textView = new TextView(context);
            this.messageTextView = textView;
            textView.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText4"));
            this.messageTextView.setTextSize(1, 14.0f);
            this.messageTextView.setTypeface(AndroidUtilities.getFontFamily(false));
            this.messageTextView.setGravity(17);
            this.messageTextView.setText(AndroidUtilities.replaceTags(LocaleController.formatString("CreateNewFilterInfo", R.string.CreateNewFilterInfo, new Object[0])));
            addView(this.messageTextView, LayoutHelper.createFrame(-1, -2.0f, 49, 40.0f, 121.0f, 40.0f, 24.0f));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$FiltersSetupActivity$HintInnerCell(View view) {
            if (this.imageView.isPlaying()) {
                return;
            }
            this.imageView.setProgress(0.0f);
            this.imageView.playAnimation();
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), heightMeasureSpec);
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
            this.moveImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("stickers_menu"), PorterDuff.Mode.MULTIPLY));
            this.moveImageView.setContentDescription(LocaleController.getString("FilterReorder", R.string.FilterReorder));
            this.moveImageView.setClickable(true);
            addView(this.moveImageView, LayoutHelper.createFrame(48, 48.0f, (LocaleController.isRTL ? 5 : 3) | 16, 6.0f, 0.0f, 6.0f, 0.0f));
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.textView.setTextSize(1, 16.0f);
            this.textView.setTypeface(AndroidUtilities.getFontFamily(false));
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
            textView3.setTextColor(Theme.getColor("windowBackgroundWhiteGrayText2"));
            this.valueTextView.setTextSize(1, 13.0f);
            this.valueTextView.setTypeface(AndroidUtilities.getFontFamily(false));
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
            ImageView imageView2 = new ImageView(context);
            this.optionsImageView = imageView2;
            imageView2.setFocusable(false);
            this.optionsImageView.setScaleType(ImageView.ScaleType.CENTER);
            this.optionsImageView.setBackgroundDrawable(Theme.createSelectorDrawable(Theme.getColor("stickers_menuSelector")));
            this.optionsImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor("stickers_menu"), PorterDuff.Mode.MULTIPLY));
            this.optionsImageView.setImageResource(R.drawable.msg_actions);
            this.optionsImageView.setContentDescription(LocaleController.getString("AccDescrMoreOptions", R.string.AccDescrMoreOptions));
            addView(this.optionsImageView, LayoutHelper.createFrame(40, 40.0f, (LocaleController.isRTL ? 3 : 5) | 16, 6.0f, 0.0f, 6.0f, 0.0f));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(widthMeasureSpec), 1073741824), View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(50.0f), 1073741824));
        }

        public void setFilter(MessagesController.DialogFilter filter, boolean divider) {
            this.currentFilter = filter;
            StringBuilder sb = new StringBuilder();
            int i = filter.flags;
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
                if ((filter.flags & MessagesController.DIALOG_FILTER_FLAG_NON_CONTACTS) != 0) {
                    if (sb.length() != 0) {
                        sb.append(", ");
                    }
                    sb.append(LocaleController.getString("FilterNonContacts", R.string.FilterNonContacts));
                }
                if ((filter.flags & MessagesController.DIALOG_FILTER_FLAG_GROUPS) != 0) {
                    if (sb.length() != 0) {
                        sb.append(", ");
                    }
                    sb.append(LocaleController.getString("FilterGroups", R.string.FilterGroups));
                }
                if ((filter.flags & MessagesController.DIALOG_FILTER_FLAG_CHANNELS) != 0) {
                    if (sb.length() != 0) {
                        sb.append(", ");
                    }
                    sb.append(LocaleController.getString("FilterChannels", R.string.FilterChannels));
                }
                if ((filter.flags & MessagesController.DIALOG_FILTER_FLAG_BOTS) != 0) {
                    if (sb.length() != 0) {
                        sb.append(", ");
                    }
                    sb.append(LocaleController.getString("FilterBots", R.string.FilterBots));
                }
            }
            if (!filter.alwaysShow.isEmpty() || !filter.neverShow.isEmpty()) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append(LocaleController.formatPluralString("Exception", filter.alwaysShow.size() + filter.neverShow.size()));
            }
            if (sb.length() == 0) {
                sb.append(LocaleController.getString("FilterNoChats", R.string.FilterNoChats));
            }
            TextView textView = this.textView;
            textView.setText(Emoji.replaceEmoji(filter.name, textView.getPaint().getFontMetricsInt(), AndroidUtilities.dp(20.0f), false));
            this.valueTextView.setText(sb);
            this.needDivider = divider;
        }

        public MessagesController.DialogFilter getCurrentFilter() {
            return this.currentFilter;
        }

        public void setOnOptionsClick(View.OnClickListener listener) {
            this.optionsImageView.setOnClickListener(listener);
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.needDivider) {
                canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(62.0f), getMeasuredHeight() - 1, getMeasuredWidth() - (LocaleController.isRTL ? AndroidUtilities.dp(62.0f) : 0), getMeasuredHeight() - 1, Theme.dividerPaint);
            }
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public void setOnReorderButtonTouchListener(View.OnTouchListener listener) {
            this.moveImageView.setOnTouchListener(listener);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        updateRows(true);
        getMessagesController().loadRemoteFilters(true);
        getNotificationCenter().addObserver(this, NotificationCenter.dialogFiltersUpdated);
        getNotificationCenter().addObserver(this, NotificationCenter.suggestedFiltersLoaded);
        if (getMessagesController().suggestedFilters.isEmpty()) {
            getMessagesController().loadSuggestedFilters();
        }
        return super.onFragmentCreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRows(boolean notify) {
        ListAdapter listAdapter;
        this.recommendedHeaderRow = -1;
        this.recommendedStartRow = -1;
        this.recommendedEndRow = -1;
        this.recommendedSectionRow = -1;
        ArrayList<TLRPC$TL_dialogFilterSuggested> arrayList = getMessagesController().suggestedFilters;
        this.rowCount = 0;
        int i = 0 + 1;
        this.rowCount = i;
        this.filterHelpRow = 0;
        this.rowCount = i + 1;
        this.filtersVisibilityRow = i;
        int size = getMessagesController().dialogFilters.size();
        if (!arrayList.isEmpty() && size < 10) {
            int i2 = this.rowCount;
            int i3 = i2 + 1;
            this.rowCount = i3;
            this.recommendedHeaderRow = i2;
            this.recommendedStartRow = i3;
            int size2 = i3 + arrayList.size();
            this.rowCount = size2;
            this.recommendedEndRow = size2;
            this.rowCount = size2 + 1;
            this.recommendedSectionRow = size2;
        }
        if (size != 0) {
            int i4 = this.rowCount;
            int i5 = i4 + 1;
            this.rowCount = i5;
            this.filtersHeaderRow = i4;
            this.filtersStartRow = i5;
            int i6 = i5 + size;
            this.rowCount = i6;
            this.filtersEndRow = i6;
        } else {
            this.filtersHeaderRow = -1;
            this.filtersStartRow = -1;
            this.filtersEndRow = -1;
        }
        if (size < 10) {
            int i7 = this.rowCount;
            this.rowCount = i7 + 1;
            this.createFilterRow = i7;
        } else {
            this.createFilterRow = -1;
        }
        int i8 = this.rowCount;
        int i9 = i8 + 1;
        this.rowCount = i9;
        this.resetRow = i8;
        this.rowCount = i9 + 1;
        this.createSectionRow = i9;
        if (!notify || (listAdapter = this.adapter) == null) {
            return;
        }
        listAdapter.notifyDataSetChanged();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
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
            getConnectionsManager().sendRequest(tLRPC$TL_messages_updateDialogFiltersOrder, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$FiltersSetupActivity$ruR6v89UuVvbkTK0vHbIf_wCQbc
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    FiltersSetupActivity.lambda$onFragmentDestroy$0(tLObject, tLRPC$TL_error);
                }
            });
        }
        super.onFragmentDestroy();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        this.actionBar.setTitle(LocaleController.getString("Filters", R.string.Filters));
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.FiltersSetupActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    FiltersSetupActivity.this.finishFragment();
                }
            }
        });
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout2.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
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
        this.listView.setOnItemClickListener(new RecyclerListView.OnItemClickListenerExtended() { // from class: ir.eitaa.ui.-$$Lambda$FiltersSetupActivity$ucLsvqNjV18xvrB8oXUuSeTfhCw
            @Override // ir.eitaa.ui.Components.RecyclerListView.OnItemClickListenerExtended
            public final void onItemClick(View view, int i, float f, float f2) {
                this.f$0.lambda$createView$4$FiltersSetupActivity(view, i, f, f2);
            }
        });
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$FiltersSetupActivity(View view, int i, float f, float f2) {
        if (i >= this.filtersStartRow && i < this.filtersEndRow) {
            presentFragment(new FilterCreateActivity(getMessagesController().dialogFilters.get(i - this.filtersStartRow)));
            return;
        }
        if (i == this.createFilterRow) {
            presentFragment(new FilterCreateActivity());
            return;
        }
        if (i == this.filtersVisibilityRow) {
            SharedConfig.updateFiltersVisibility(!SharedConfig.filtersVisibility);
            ((TextCheckCell) view).setChecked(SharedConfig.filtersVisibility);
            this.parentLayout.rebuildAllFragmentViews(false, false);
        } else if (i == this.resetRow) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
            builder.setTitle(LocaleController.getString("ResetFoldersAlertTitle", R.string.ResetFoldersAlertTitle));
            builder.setMessage(LocaleController.getString("ResetFoldersAlert", R.string.ResetFoldersAlert));
            builder.setPositiveButton(LocaleController.getString("Reset", R.string.Reset), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$FiltersSetupActivity$JnPJYlTuovz9rzkSwZWi7Yd6WMU
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    this.f$0.lambda$createView$3$FiltersSetupActivity(dialogInterface, i2);
                }
            });
            builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
            AlertDialog alertDialogCreate = builder.create();
            showDialog(alertDialogCreate);
            TextView textView = (TextView) alertDialogCreate.getButton(-1);
            if (textView != null) {
                textView.setTextColor(Theme.getColor("dialogTextRed2"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$FiltersSetupActivity(DialogInterface dialogInterface, int i) {
        if (this.hasResetFilters) {
            return;
        }
        final AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
        alertDialog.setCanCacnel(false);
        alertDialog.show();
        TLRPC$TL_messages_updateDialogFilter tLRPC$TL_messages_updateDialogFilter = new TLRPC$TL_messages_updateDialogFilter();
        tLRPC$TL_messages_updateDialogFilter.flags = 4;
        getConnectionsManager().sendRequest(tLRPC$TL_messages_updateDialogFilter, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$FiltersSetupActivity$Lk-4sFHYKboOrGseYpbHZpGfwF0
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$createView$2$FiltersSetupActivity(alertDialog, tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$FiltersSetupActivity(final AlertDialog alertDialog, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$FiltersSetupActivity$8iEmGVwHbq-GMew1TNWceMQZiE8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$1$FiltersSetupActivity(tLObject, alertDialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$FiltersSetupActivity(TLObject tLObject, AlertDialog alertDialog) {
        try {
            if (tLObject instanceof TLRPC$TL_boolTrue) {
                getMessagesController().loadRemoteFilters(true);
            }
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        ListAdapter listAdapter = this.adapter;
        if (listAdapter != null) {
            listAdapter.notifyDataSetChanged();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.dialogFiltersUpdated) {
            if (this.ignoreUpdates) {
                return;
            }
            updateRows(true);
        } else if (id == NotificationCenter.suggestedFiltersLoaded) {
            updateRows(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ListAdapter extends RecyclerListView.SelectionAdapter {
        private Context mContext;

        public ListAdapter(Context context) {
            this.mContext = context;
        }

        @Override // ir.eitaa.ui.Components.RecyclerListView.SelectionAdapter
        public boolean isEnabled(RecyclerView.ViewHolder holder) {
            int itemViewType = holder.getItemViewType();
            return (itemViewType == 3 || itemViewType == 0 || itemViewType == 5 || itemViewType == 1) ? false : true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return FiltersSetupActivity.this.rowCount;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ boolean lambda$onCreateViewHolder$0$FiltersSetupActivity$ListAdapter(FilterCell filterCell, View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            FiltersSetupActivity.this.itemTouchHelper.startDrag(FiltersSetupActivity.this.listView.getChildViewHolder(filterCell));
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$5$FiltersSetupActivity$ListAdapter(View view) {
            final MessagesController.DialogFilter currentFilter = ((FilterCell) view.getParent()).getCurrentFilter();
            AlertDialog.Builder builder = new AlertDialog.Builder(FiltersSetupActivity.this.getParentActivity());
            TextPaint textPaint = new TextPaint(1);
            textPaint.setTextSize(AndroidUtilities.dp(20.0f));
            textPaint.setTypeface(AndroidUtilities.getFontFamily(false));
            builder.setTitle(Emoji.replaceEmoji(currentFilter.name, textPaint.getFontMetricsInt(), AndroidUtilities.dp(20.0f), false));
            builder.setItems(new CharSequence[]{LocaleController.getString("FilterEditItem", R.string.FilterEditItem), LocaleController.getString("FilterDeleteItem", R.string.FilterDeleteItem)}, new int[]{R.drawable.msg_edit, R.drawable.msg_delete}, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$FiltersSetupActivity$ListAdapter$5LEO4wwqH_8ux4JU6Py0MbJ4SGg
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.lambda$onCreateViewHolder$4$FiltersSetupActivity$ListAdapter(currentFilter, dialogInterface, i);
                }
            });
            AlertDialog alertDialogCreate = builder.create();
            FiltersSetupActivity.this.showDialog(alertDialogCreate);
            alertDialogCreate.setItemColor(1, Theme.getColor("dialogTextRed2"), Theme.getColor("dialogRedIcon"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$4$FiltersSetupActivity$ListAdapter(final MessagesController.DialogFilter dialogFilter, DialogInterface dialogInterface, int i) {
            if (i == 0) {
                FiltersSetupActivity.this.presentFragment(new FilterCreateActivity(dialogFilter));
                return;
            }
            if (i == 1) {
                AlertDialog.Builder builder = new AlertDialog.Builder(FiltersSetupActivity.this.getParentActivity());
                builder.setTitle(LocaleController.getString("FilterDelete", R.string.FilterDelete));
                builder.setMessage(LocaleController.getString("FilterDeleteAlert", R.string.FilterDeleteAlert));
                builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
                builder.setPositiveButton(LocaleController.getString("Delete", R.string.Delete), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$FiltersSetupActivity$ListAdapter$c__PSp_GloYFMXG5f2srYZDzmTg
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface2, int i2) {
                        this.f$0.lambda$onCreateViewHolder$3$FiltersSetupActivity$ListAdapter(dialogFilter, dialogInterface2, i2);
                    }
                });
                AlertDialog alertDialogCreate = builder.create();
                FiltersSetupActivity.this.showDialog(alertDialogCreate);
                TextView textView = (TextView) alertDialogCreate.getButton(-1);
                if (textView != null) {
                    textView.setTextColor(Theme.getColor("dialogTextRed2"));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$3$FiltersSetupActivity$ListAdapter(final MessagesController.DialogFilter dialogFilter, DialogInterface dialogInterface, int i) {
            final AlertDialog alertDialog;
            if (FiltersSetupActivity.this.getParentActivity() != null) {
                alertDialog = new AlertDialog(FiltersSetupActivity.this.getParentActivity(), 3);
                alertDialog.setCanCacnel(false);
                alertDialog.show();
            } else {
                alertDialog = null;
            }
            TLRPC$TL_messages_updateDialogFilter tLRPC$TL_messages_updateDialogFilter = new TLRPC$TL_messages_updateDialogFilter();
            tLRPC$TL_messages_updateDialogFilter.id = dialogFilter.id;
            FiltersSetupActivity.this.getConnectionsManager().sendRequest(tLRPC$TL_messages_updateDialogFilter, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$FiltersSetupActivity$ListAdapter$wFZWAfNEIau1S17QH7BpuIDUBrU
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$onCreateViewHolder$2$FiltersSetupActivity$ListAdapter(alertDialog, dialogFilter, tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$2$FiltersSetupActivity$ListAdapter(final AlertDialog alertDialog, final MessagesController.DialogFilter dialogFilter, TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$FiltersSetupActivity$ListAdapter$yM8z6V_Nt8AwZgueaN2GF8Jrd30
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCreateViewHolder$1$FiltersSetupActivity$ListAdapter(alertDialog, dialogFilter);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$1$FiltersSetupActivity$ListAdapter(AlertDialog alertDialog, MessagesController.DialogFilter dialogFilter) {
            if (alertDialog != null) {
                try {
                    alertDialog.dismiss();
                } catch (Exception e) {
                    FileLog.e(e);
                }
            }
            int iIndexOf = FiltersSetupActivity.this.getMessagesController().dialogFilters.indexOf(dialogFilter);
            if (iIndexOf >= 0) {
                iIndexOf += FiltersSetupActivity.this.filtersStartRow;
            }
            FiltersSetupActivity.this.ignoreUpdates = true;
            FiltersSetupActivity.this.getMessagesController().removeFilter(dialogFilter);
            FiltersSetupActivity.this.getMessagesStorage().deleteDialogFilter(dialogFilter);
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
            switch (i) {
                case 0:
                    View headerCell = new HeaderCell(this.mContext);
                    headerCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    shadowSectionCell = headerCell;
                    break;
                case 1:
                    View hintInnerCell = new HintInnerCell(this.mContext);
                    hintInnerCell.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_top, "windowBackgroundGrayShadow"));
                    shadowSectionCell = hintInnerCell;
                    break;
                case 2:
                    final FilterCell filterCell = new FilterCell(this.mContext);
                    filterCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    filterCell.setOnReorderButtonTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$FiltersSetupActivity$ListAdapter$5HMQ42zxlcuE3O41iX-cX6w65ZI
                        @Override // android.view.View.OnTouchListener
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            return this.f$0.lambda$onCreateViewHolder$0$FiltersSetupActivity$ListAdapter(filterCell, view, motionEvent);
                        }
                    });
                    filterCell.setOnOptionsClick(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$FiltersSetupActivity$ListAdapter$B3huX7uF0sliqg03kR0kwT57gmg
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$onCreateViewHolder$5$FiltersSetupActivity$ListAdapter(view);
                        }
                    });
                    shadowSectionCell = filterCell;
                    break;
                case 3:
                    shadowSectionCell = new ShadowSectionCell(this.mContext);
                    break;
                case 4:
                    View textCell = new TextCell(this.mContext);
                    textCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    shadowSectionCell = textCell;
                    break;
                case 5:
                case 6:
                    View textCheckCell = new TextCheckCell(this.mContext);
                    textCheckCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    shadowSectionCell = textCheckCell;
                    break;
                case 7:
                    View textDetailSettingsCell = new TextDetailSettingsCell(this.mContext);
                    textDetailSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    shadowSectionCell = textDetailSettingsCell;
                    break;
                default:
                    final SuggestedFilterCell suggestedFilterCell = new SuggestedFilterCell(this.mContext);
                    suggestedFilterCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
                    suggestedFilterCell.setAddOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$FiltersSetupActivity$ListAdapter$hqqNrex7F-PXuuXOM17bU9JrhY0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.lambda$onCreateViewHolder$7$FiltersSetupActivity$ListAdapter(suggestedFilterCell, view);
                        }
                    });
                    shadowSectionCell = suggestedFilterCell;
                    break;
            }
            return new RecyclerListView.Holder(shadowSectionCell);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$7, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$7$FiltersSetupActivity$ListAdapter(SuggestedFilterCell suggestedFilterCell, View view) {
            final TLRPC$TL_dialogFilterSuggested suggestedFilter = suggestedFilterCell.getSuggestedFilter();
            MessagesController.DialogFilter dialogFilter = new MessagesController.DialogFilter();
            dialogFilter.name = suggestedFilter.filter.title;
            dialogFilter.id = 2;
            while (FiltersSetupActivity.this.getMessagesController().dialogFiltersById.get(dialogFilter.id) != null) {
                dialogFilter.id++;
            }
            dialogFilter.unreadCount = -1;
            dialogFilter.pendingUnreadCount = -1;
            int i = 0;
            while (i < 2) {
                TLRPC$TL_dialogFilter tLRPC$TL_dialogFilter = suggestedFilter.filter;
                ArrayList<TLRPC$InputPeer> arrayList = i == 0 ? tLRPC$TL_dialogFilter.include_peers : tLRPC$TL_dialogFilter.exclude_peers;
                ArrayList<Long> arrayList2 = i == 0 ? dialogFilter.alwaysShow : dialogFilter.neverShow;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    TLRPC$InputPeer tLRPC$InputPeer = arrayList.get(i2);
                    long j = tLRPC$InputPeer.user_id;
                    if (j == 0) {
                        long j2 = tLRPC$InputPeer.chat_id;
                        j = j2 != 0 ? -j2 : -tLRPC$InputPeer.channel_id;
                    }
                    arrayList2.add(Long.valueOf(j));
                }
                i++;
            }
            TLRPC$TL_dialogFilter tLRPC$TL_dialogFilter2 = suggestedFilter.filter;
            if (tLRPC$TL_dialogFilter2.groups) {
                dialogFilter.flags |= MessagesController.DIALOG_FILTER_FLAG_GROUPS;
            }
            if (tLRPC$TL_dialogFilter2.bots) {
                dialogFilter.flags |= MessagesController.DIALOG_FILTER_FLAG_BOTS;
            }
            if (tLRPC$TL_dialogFilter2.contacts) {
                dialogFilter.flags |= MessagesController.DIALOG_FILTER_FLAG_CONTACTS;
            }
            if (tLRPC$TL_dialogFilter2.non_contacts) {
                dialogFilter.flags |= MessagesController.DIALOG_FILTER_FLAG_NON_CONTACTS;
            }
            if (tLRPC$TL_dialogFilter2.broadcasts) {
                dialogFilter.flags |= MessagesController.DIALOG_FILTER_FLAG_CHANNELS;
            }
            if (tLRPC$TL_dialogFilter2.admin) {
                dialogFilter.flags |= MessagesController.DIALOG_FILTER_FLAG_ADMIN;
            }
            if (tLRPC$TL_dialogFilter2.favourite) {
                dialogFilter.flags |= MessagesController.DIALOG_FILTER_FLAG_FAVORITE;
            }
            if (tLRPC$TL_dialogFilter2.media_channel) {
                dialogFilter.flags |= MessagesController.DIALOG_FILTER_FLAG_MEDIA_CHANNEL;
            }
            if (tLRPC$TL_dialogFilter2.exclude_archived) {
                dialogFilter.flags |= MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_ARCHIVED;
            }
            if (tLRPC$TL_dialogFilter2.exclude_read) {
                dialogFilter.flags |= MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_READ;
            }
            if (tLRPC$TL_dialogFilter2.exclude_muted) {
                dialogFilter.flags |= MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_MUTED;
            }
            FiltersSetupActivity.this.ignoreUpdates = true;
            FilterCreateActivity.saveFilterToServer(dialogFilter, dialogFilter.flags, dialogFilter.name, dialogFilter.alwaysShow, dialogFilter.neverShow, dialogFilter.pinnedDialogs, true, true, true, true, false, FiltersSetupActivity.this, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$FiltersSetupActivity$ListAdapter$SD7Sd8Pu-hxVtGV7Nd6SlFVXxQc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onCreateViewHolder$6$FiltersSetupActivity$ListAdapter(suggestedFilter);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onCreateViewHolder$6, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onCreateViewHolder$6$FiltersSetupActivity$ListAdapter(TLRPC$TL_dialogFilterSuggested tLRPC$TL_dialogFilterSuggested) {
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
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) throws Resources.NotFoundException {
            int itemViewType = holder.getItemViewType();
            if (itemViewType != 0) {
                switch (itemViewType) {
                    case 2:
                        ((FilterCell) holder.itemView).setFilter(FiltersSetupActivity.this.getMessagesController().dialogFilters.get(position - FiltersSetupActivity.this.filtersStartRow), true);
                        break;
                    case 3:
                        if (position == FiltersSetupActivity.this.createSectionRow) {
                            holder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                            break;
                        } else {
                            holder.itemView.setBackgroundDrawable(Theme.getThemedDrawable(this.mContext, R.drawable.greydivider, "windowBackgroundGrayShadow"));
                            break;
                        }
                    case 4:
                        TextCell textCell = (TextCell) holder.itemView;
                        MessagesController.getNotificationsSettings(((BaseFragment) FiltersSetupActivity.this).currentAccount);
                        if (position == FiltersSetupActivity.this.createFilterRow) {
                            Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.poll_add_circle);
                            Drawable drawable2 = this.mContext.getResources().getDrawable(R.drawable.poll_add_plus);
                            drawable.setColorFilter(new PorterDuffColorFilter(Theme.getColor("switchTrackChecked"), PorterDuff.Mode.MULTIPLY));
                            drawable2.setColorFilter(new PorterDuffColorFilter(Theme.getColor("checkboxCheck"), PorterDuff.Mode.MULTIPLY));
                            textCell.setTextAndIcon(LocaleController.getString("CreateNewFilter", R.string.CreateNewFilter), new CombinedDrawable(drawable, drawable2), true);
                            break;
                        }
                        break;
                    case 5:
                        ((SuggestedFilterCell) holder.itemView).setFilter(FiltersSetupActivity.this.getMessagesController().suggestedFilters.get(position - FiltersSetupActivity.this.recommendedStartRow), FiltersSetupActivity.this.recommendedStartRow != FiltersSetupActivity.this.recommendedEndRow - 1);
                        break;
                    case 6:
                        ((TextCheckCell) holder.itemView).setTextAndCheck(LocaleController.getString("FoldersVisibility", R.string.FoldersVisibility), SharedConfig.filtersVisibility, true);
                        break;
                    case 7:
                        ((TextDetailSettingsCell) holder.itemView).setTextAndValue(LocaleController.getString("ResetAllFolders", R.string.ResetAllFolders), "", true);
                        break;
                }
                return;
            }
            HeaderCell headerCell = (HeaderCell) holder.itemView;
            if (position != FiltersSetupActivity.this.filtersHeaderRow) {
                if (position == FiltersSetupActivity.this.recommendedHeaderRow) {
                    headerCell.setText(LocaleController.getString("FilterRecommended", R.string.FilterRecommended));
                    return;
                }
                return;
            }
            headerCell.setText(LocaleController.getString("Filters", R.string.Filters));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int position) {
            if (position == FiltersSetupActivity.this.filtersHeaderRow || position == FiltersSetupActivity.this.recommendedHeaderRow) {
                return 0;
            }
            if (position == FiltersSetupActivity.this.filterHelpRow) {
                return 1;
            }
            if (position >= FiltersSetupActivity.this.filtersStartRow && position < FiltersSetupActivity.this.filtersEndRow) {
                return 2;
            }
            if (position == FiltersSetupActivity.this.createSectionRow || position == FiltersSetupActivity.this.recommendedSectionRow) {
                return 3;
            }
            if (position == FiltersSetupActivity.this.createFilterRow) {
                return 4;
            }
            if (position == FiltersSetupActivity.this.filtersVisibilityRow) {
                return 6;
            }
            return position == FiltersSetupActivity.this.resetRow ? 7 : 5;
        }

        public void swapElements(int fromIndex, int toIndex) {
            int i = fromIndex - FiltersSetupActivity.this.filtersStartRow;
            int i2 = toIndex - FiltersSetupActivity.this.filtersStartRow;
            int i3 = FiltersSetupActivity.this.filtersEndRow - FiltersSetupActivity.this.filtersStartRow;
            if (i < 0 || i2 < 0 || i >= i3 || i2 >= i3) {
                return;
            }
            ArrayList<MessagesController.DialogFilter> arrayList = FiltersSetupActivity.this.getMessagesController().dialogFilters;
            MessagesController.DialogFilter dialogFilter = arrayList.get(i);
            MessagesController.DialogFilter dialogFilter2 = arrayList.get(i2);
            int i4 = dialogFilter.order;
            dialogFilter.order = dialogFilter2.order;
            dialogFilter2.order = i4;
            arrayList.set(i, dialogFilter2);
            arrayList.set(i2, dialogFilter);
            FiltersSetupActivity.this.orderChanged = true;
            notifyItemMoved(fromIndex, toIndex);
        }
    }

    public class TouchHelperCallback extends ItemTouchHelper.Callback {
        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
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
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder source, RecyclerView.ViewHolder target) {
            if (source.getItemViewType() != target.getItemViewType()) {
                return false;
            }
            FiltersSetupActivity.this.adapter.swapElements(source.getAdapterPosition(), target.getAdapterPosition());
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
            if (actionState != 0) {
                FiltersSetupActivity.this.listView.cancelClickRunnables(false);
                viewHolder.itemView.setPressed(true);
            }
            super.onSelectedChanged(viewHolder, actionState);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            super.clearView(recyclerView, viewHolder);
            viewHolder.itemView.setPressed(false);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{HeaderCell.class, TextCell.class, FilterCell.class, SuggestedFilterCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_SELECTOR, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{FilterCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{FilterCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{FilterCell.class}, new String[]{"moveImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "stickers_menu"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{FilterCell.class}, new String[]{"optionsImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "stickers_menu"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_USEBACKGROUNDDRAWABLE | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, new Class[]{FilterCell.class}, new String[]{"optionsImageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "stickers_menuSelector"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueText2"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrackChecked"));
        arrayList.add(new ThemeDescription(this.listView, 0, new Class[]{TextCell.class}, new String[]{"imageView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "checkboxCheck"));
        arrayList.add(new ThemeDescription(this.listView, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        return arrayList;
    }
}
