package ir.eitaa.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$TL_chatInviteExported;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.Components.SizeNotifierFrameLayout;
import ir.eitaa.ui.Components.SlideChooseView;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class LinkEditActivity extends BaseFragment {
    private TextView buttonTextView;
    private Callback callback;
    private final long chatId;
    int currentInviteDate;
    private TextInfoPrivacyCell divider;
    private TextInfoPrivacyCell dividerUses;
    private boolean finished;
    private boolean ignoreSet;
    TLRPC$TL_chatInviteExported inviteToEdit;
    boolean loading;
    AlertDialog progressDialog;
    private TextSettingsCell revokeLink;
    boolean scrollToEnd;
    private ScrollView scrollView;
    private SlideChooseView timeChooseView;
    private TextView timeEditText;
    private HeaderCell timeHeaderCell;
    private int type;
    private SlideChooseView usesChooseView;
    private EditText usesEditText;
    private HeaderCell usesHeaderCell;
    private ArrayList<Integer> dispalyedDates = new ArrayList<>();
    private final int[] defaultDates = {3600, 86400, 604800};
    private ArrayList<Integer> dispalyedUses = new ArrayList<>();
    private final int[] defaultUses = {1, 10, 100};

    public interface Callback {
        void onLinkCreated(TLObject response);

        void onLinkEdited(TLRPC$TL_chatInviteExported inviteToEdit, TLObject response);

        void onLinkRemoved(TLRPC$TL_chatInviteExported inviteFinal);

        void revokeLink(TLRPC$TL_chatInviteExported inviteFinal);
    }

    public LinkEditActivity(int type, long chatId) {
        this.type = type;
        this.chatId = chatId;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        int i = this.type;
        if (i == 0) {
            this.actionBar.setTitle(LocaleController.getString("NewLink", R.string.NewLink));
        } else if (i == 1) {
            this.actionBar.setTitle(LocaleController.getString("EditLink", R.string.EditLink));
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.LinkEditActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                if (id == -1) {
                    LinkEditActivity.this.finishFragment();
                    AndroidUtilities.hideKeyboard(LinkEditActivity.this.usesEditText);
                }
            }
        });
        this.scrollView = new ScrollView(context);
        SizeNotifierFrameLayout sizeNotifierFrameLayout = new SizeNotifierFrameLayout(context) { // from class: ir.eitaa.ui.LinkEditActivity.2
            int oldKeyboardHeight;

            @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayout
            protected AdjustPanLayoutHelper createAdjustPanLayoutHelper() {
                AdjustPanLayoutHelper adjustPanLayoutHelper = new AdjustPanLayoutHelper(this) { // from class: ir.eitaa.ui.LinkEditActivity.2.1
                    @Override // ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper
                    protected void onTransitionStart(boolean keyboardVisible, int contentHeight) {
                        super.onTransitionStart(keyboardVisible, contentHeight);
                        LinkEditActivity.this.scrollView.getLayoutParams().height = contentHeight;
                    }

                    @Override // ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper
                    protected void onTransitionEnd() {
                        super.onTransitionEnd();
                        LinkEditActivity.this.scrollView.getLayoutParams().height = -1;
                        LinkEditActivity.this.scrollView.requestLayout();
                    }

                    @Override // ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper
                    protected void onPanTranslationUpdate(float y, float progress, boolean keyboardVisible) {
                        super.onPanTranslationUpdate(y, progress, keyboardVisible);
                        setTranslationY(0.0f);
                    }

                    @Override // ir.eitaa.ui.ActionBar.AdjustPanLayoutHelper
                    protected boolean heightAnimationEnabled() {
                        return !LinkEditActivity.this.finished;
                    }
                };
                adjustPanLayoutHelper.setCheckHierarchyHeight(true);
                return adjustPanLayoutHelper;
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onAttachedToWindow() {
                super.onAttachedToWindow();
                this.adjustPanLayoutHelper.onAttach();
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                this.adjustPanLayoutHelper.onDetach();
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                measureKeyboardHeight();
                int i2 = this.oldKeyboardHeight;
                int i3 = this.keyboardHeight;
                if (i2 != i3 && i3 > AndroidUtilities.dp(20.0f)) {
                    LinkEditActivity.this.scrollToEnd = true;
                    invalidate();
                }
                if (this.keyboardHeight < AndroidUtilities.dp(20.0f)) {
                    LinkEditActivity.this.usesEditText.clearFocus();
                }
                this.oldKeyboardHeight = this.keyboardHeight;
            }

            @Override // ir.eitaa.ui.Components.SizeNotifierFrameLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean changed, int l, int t, int r, int b) {
                int scrollY = LinkEditActivity.this.scrollView.getScrollY();
                super.onLayout(changed, l, t, r, b);
                if (scrollY != LinkEditActivity.this.scrollView.getScrollY()) {
                    LinkEditActivity linkEditActivity = LinkEditActivity.this;
                    if (linkEditActivity.scrollToEnd) {
                        return;
                    }
                    linkEditActivity.scrollView.setTranslationY(LinkEditActivity.this.scrollView.getScrollY() - scrollY);
                    LinkEditActivity.this.scrollView.animate().cancel();
                    LinkEditActivity.this.scrollView.animate().translationY(0.0f).setDuration(250L).setInterpolator(AdjustPanLayoutHelper.keyboardInterpolator).start();
                }
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                super.dispatchDraw(canvas);
                LinkEditActivity linkEditActivity = LinkEditActivity.this;
                if (linkEditActivity.scrollToEnd) {
                    linkEditActivity.scrollToEnd = false;
                    linkEditActivity.scrollView.smoothScrollTo(0, Math.max(0, LinkEditActivity.this.scrollView.getChildAt(0).getMeasuredHeight() - LinkEditActivity.this.scrollView.getMeasuredHeight()));
                }
            }
        };
        this.fragmentView = sizeNotifierFrameLayout;
        LinearLayout linearLayout = new LinearLayout(context) { // from class: ir.eitaa.ui.LinkEditActivity.3
            boolean firstLayout = true;

            @Override // android.widget.LinearLayout, android.view.View
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                int iDp;
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                int size = View.MeasureSpec.getSize(heightMeasureSpec);
                int measuredHeight = 0;
                for (int i2 = 0; i2 < getChildCount(); i2++) {
                    View childAt = getChildAt(i2);
                    if (childAt != LinkEditActivity.this.buttonTextView) {
                        measuredHeight += childAt.getMeasuredHeight();
                    }
                }
                int iDp2 = size - ((AndroidUtilities.dp(48.0f) + AndroidUtilities.dp(24.0f)) + AndroidUtilities.dp(16.0f));
                if (measuredHeight >= iDp2) {
                    iDp = AndroidUtilities.dp(24.0f);
                } else {
                    iDp = (AndroidUtilities.dp(24.0f) + iDp2) - measuredHeight;
                }
                if (((LinearLayout.LayoutParams) LinkEditActivity.this.buttonTextView.getLayoutParams()).topMargin != iDp) {
                    int i3 = ((LinearLayout.LayoutParams) LinkEditActivity.this.buttonTextView.getLayoutParams()).topMargin;
                    ((LinearLayout.LayoutParams) LinkEditActivity.this.buttonTextView.getLayoutParams()).topMargin = iDp;
                    if (!this.firstLayout) {
                        LinkEditActivity.this.buttonTextView.setTranslationY(i3 - iDp);
                        LinkEditActivity.this.buttonTextView.animate().translationY(0.0f).setDuration(250L).setInterpolator(AdjustPanLayoutHelper.keyboardInterpolator).start();
                    }
                    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                }
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void dispatchDraw(Canvas canvas) {
                super.dispatchDraw(canvas);
                this.firstLayout = false;
            }
        };
        linearLayout.setOrientation(1);
        this.scrollView.addView(linearLayout);
        TextView textView = new TextView(context);
        this.buttonTextView = textView;
        textView.setPadding(AndroidUtilities.dp(34.0f), 0, AndroidUtilities.dp(34.0f), 0);
        this.buttonTextView.setGravity(17);
        this.buttonTextView.setTextSize(1, 14.0f);
        this.buttonTextView.setTypeface(AndroidUtilities.getFontFamily(true));
        int i2 = this.type;
        if (i2 == 0) {
            this.buttonTextView.setText(LocaleController.getString("CreateLink", R.string.CreateLink));
        } else if (i2 == 1) {
            this.buttonTextView.setText(LocaleController.getString("SaveLink", R.string.SaveLink));
        }
        HeaderCell headerCell = new HeaderCell(context);
        this.timeHeaderCell = headerCell;
        headerCell.setText(LocaleController.getString("LimitByPeriod", R.string.LimitByPeriod));
        linearLayout.addView(this.timeHeaderCell);
        SlideChooseView slideChooseView = new SlideChooseView(context);
        this.timeChooseView = slideChooseView;
        linearLayout.addView(slideChooseView);
        TextView textView2 = new TextView(context);
        this.timeEditText = textView2;
        textView2.setPadding(AndroidUtilities.dp(22.0f), 0, AndroidUtilities.dp(22.0f), 0);
        this.timeEditText.setGravity(16);
        this.timeEditText.setTextSize(1, 16.0f);
        this.timeEditText.setHint(LocaleController.getString("TimeLimitHint", R.string.TimeLimitHint));
        this.timeEditText.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LinkEditActivity$fZfKdGaf2uLRCjHQIdrMwckeiEI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$1$LinkEditActivity(context, view);
            }
        });
        this.timeChooseView.setCallback(new SlideChooseView.Callback() { // from class: ir.eitaa.ui.-$$Lambda$LinkEditActivity$dQRa_7rvkZzTmdXz8HTM_rnbbEA
            @Override // ir.eitaa.ui.Components.SlideChooseView.Callback
            public final void onOptionSelected(int i3) {
                this.f$0.lambda$createView$2$LinkEditActivity(i3);
            }

            @Override // ir.eitaa.ui.Components.SlideChooseView.Callback
            public /* synthetic */ void onTouchEnd() {
                SlideChooseView.Callback.CC.$default$onTouchEnd(this);
            }
        });
        resetDates();
        linearLayout.addView(this.timeEditText, LayoutHelper.createLinear(-1, 50));
        TextInfoPrivacyCell textInfoPrivacyCell = new TextInfoPrivacyCell(context);
        this.divider = textInfoPrivacyCell;
        textInfoPrivacyCell.setText(LocaleController.getString("TimeLimitHelp", R.string.TimeLimitHelp));
        linearLayout.addView(this.divider);
        HeaderCell headerCell2 = new HeaderCell(context);
        this.usesHeaderCell = headerCell2;
        headerCell2.setText(LocaleController.getString("LimitNumberOfUses", R.string.LimitNumberOfUses));
        linearLayout.addView(this.usesHeaderCell);
        SlideChooseView slideChooseView2 = new SlideChooseView(context);
        this.usesChooseView = slideChooseView2;
        slideChooseView2.setCallback(new SlideChooseView.Callback() { // from class: ir.eitaa.ui.-$$Lambda$LinkEditActivity$QT0esugy24wYiYfVxUi99POYz3Y
            @Override // ir.eitaa.ui.Components.SlideChooseView.Callback
            public final void onOptionSelected(int i3) {
                this.f$0.lambda$createView$3$LinkEditActivity(i3);
            }

            @Override // ir.eitaa.ui.Components.SlideChooseView.Callback
            public /* synthetic */ void onTouchEnd() {
                SlideChooseView.Callback.CC.$default$onTouchEnd(this);
            }
        });
        resetUses();
        linearLayout.addView(this.usesChooseView);
        EditText editText = new EditText(context) { // from class: ir.eitaa.ui.LinkEditActivity.4
            @Override // android.widget.TextView, android.view.View
            public boolean onTouchEvent(MotionEvent event) {
                if (event.getAction() == 1) {
                    setCursorVisible(true);
                }
                return super.onTouchEvent(event);
            }
        };
        this.usesEditText = editText;
        editText.setPadding(AndroidUtilities.dp(22.0f), 0, AndroidUtilities.dp(22.0f), 0);
        this.usesEditText.setGravity(16);
        this.usesEditText.setTextSize(1, 16.0f);
        this.usesEditText.setHint(LocaleController.getString("UsesLimitHint", R.string.UsesLimitHint));
        this.usesEditText.setKeyListener(DigitsKeyListener.getInstance("0123456789."));
        this.usesEditText.setInputType(2);
        this.usesEditText.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.LinkEditActivity.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i1, int i22) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i1, int i22) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) throws NumberFormatException {
                if (LinkEditActivity.this.ignoreSet) {
                    return;
                }
                if (editable.toString().equals("0")) {
                    LinkEditActivity.this.usesEditText.setText("");
                    return;
                }
                try {
                    int i3 = Integer.parseInt(editable.toString());
                    if (i3 > 100000) {
                        LinkEditActivity.this.resetUses();
                    } else {
                        LinkEditActivity.this.chooseUses(i3);
                    }
                } catch (NumberFormatException unused) {
                    LinkEditActivity.this.resetUses();
                }
            }
        });
        linearLayout.addView(this.usesEditText, LayoutHelper.createLinear(-1, 50));
        TextInfoPrivacyCell textInfoPrivacyCell2 = new TextInfoPrivacyCell(context);
        this.dividerUses = textInfoPrivacyCell2;
        textInfoPrivacyCell2.setText(LocaleController.getString("UsesLimitHelp", R.string.UsesLimitHelp));
        linearLayout.addView(this.dividerUses);
        if (this.type == 1) {
            TextSettingsCell textSettingsCell = new TextSettingsCell(context);
            this.revokeLink = textSettingsCell;
            textSettingsCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
            this.revokeLink.setText(LocaleController.getString("RevokeLink", R.string.RevokeLink), false);
            this.revokeLink.setTextColor(Theme.getColor("windowBackgroundWhiteRedText5"));
            this.revokeLink.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LinkEditActivity$-SUjjIgW1hwL_4bZBTcMgvq1qDk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$createView$5$LinkEditActivity(view);
                }
            });
            linearLayout.addView(this.revokeLink);
        }
        sizeNotifierFrameLayout.addView(this.scrollView, LayoutHelper.createFrame(-1, -1.0f));
        linearLayout.addView(this.buttonTextView, LayoutHelper.createFrame(-1, 48.0f, 80, 16.0f, 15.0f, 16.0f, 16.0f));
        this.timeHeaderCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        this.timeChooseView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        this.timeEditText.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        this.usesHeaderCell.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        this.usesChooseView.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        this.usesEditText.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        sizeNotifierFrameLayout.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        this.buttonTextView.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LinkEditActivity$2fR59ekrtyYH_J1uEYlt8e1CHuI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$10$LinkEditActivity(context, view);
            }
        });
        this.buttonTextView.setTextColor(Theme.getColor("featuredStickers_buttonText"));
        this.dividerUses.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
        this.divider.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider, "windowBackgroundGrayShadow"));
        this.buttonTextView.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(6.0f), Theme.getColor("featuredStickers_addButton"), Theme.getColor("featuredStickers_addButtonPressed")));
        this.usesEditText.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.usesEditText.setHintTextColor(Theme.getColor("windowBackgroundWhiteGrayText"));
        this.timeEditText.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.timeEditText.setHintTextColor(Theme.getColor("windowBackgroundWhiteGrayText"));
        this.usesEditText.setCursorVisible(false);
        setInviteToEdit(this.inviteToEdit);
        sizeNotifierFrameLayout.setClipChildren(false);
        this.scrollView.setClipChildren(false);
        linearLayout.setClipChildren(false);
        return sizeNotifierFrameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$LinkEditActivity(boolean z, int i) {
        chooseDate(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$1$LinkEditActivity(Context context, View view) {
        AlertsCreator.createDatePickerDialog(context, -1L, new AlertsCreator.ScheduleDatePickerDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LinkEditActivity$Y-YwZuZuC26HLwYAprFEXZOM-6o
            @Override // ir.eitaa.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
            public final void didSelectDate(boolean z, int i) {
                this.f$0.lambda$createView$0$LinkEditActivity(z, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$LinkEditActivity(int i) {
        if (i < this.dispalyedDates.size()) {
            this.timeEditText.setText(LocaleController.formatDateAudio(this.dispalyedDates.get(i).intValue() + getConnectionsManager().getCurrentTime(), false));
        } else {
            this.timeEditText.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$LinkEditActivity(int i) {
        this.usesEditText.clearFocus();
        this.ignoreSet = true;
        if (i < this.dispalyedUses.size()) {
            this.usesEditText.setText(this.dispalyedUses.get(i).toString());
        } else {
            this.usesEditText.setText("");
        }
        this.ignoreSet = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$5$LinkEditActivity(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setMessage(LocaleController.getString("RevokeAlert", R.string.RevokeAlert));
        builder.setTitle(LocaleController.getString("RevokeLink", R.string.RevokeLink));
        builder.setPositiveButton(LocaleController.getString("RevokeButton", R.string.RevokeButton), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$LinkEditActivity$FxbppMwZBEruJL4tjrXI8m5AR2I
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$createView$4$LinkEditActivity(dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$LinkEditActivity(DialogInterface dialogInterface, int i) {
        this.callback.revokeLink(this.inviteToEdit);
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:49:0x017e  */
    /* renamed from: lambda$createView$10, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$createView$10$LinkEditActivity(android.content.Context r6, android.view.View r7) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.LinkEditActivity.lambda$createView$10$LinkEditActivity(android.content.Context, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$7$LinkEditActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LinkEditActivity$4VTqcXFPPO1qYxcEWZ6tmGuNqZ4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$6$LinkEditActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$6$LinkEditActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        this.loading = false;
        AlertDialog alertDialog = this.progressDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (tLRPC$TL_error == null) {
            Callback callback = this.callback;
            if (callback != null) {
                callback.onLinkCreated(tLObject);
            }
            finishFragment();
            return;
        }
        AlertsCreator.showSimpleAlert(this, tLRPC$TL_error.text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$9$LinkEditActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$LinkEditActivity$oWKnCBi3cujQvnN_tjpIBmB1qzI
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$8$LinkEditActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$8$LinkEditActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        this.loading = false;
        AlertDialog alertDialog = this.progressDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (tLRPC$TL_error == null) {
            Callback callback = this.callback;
            if (callback != null) {
                callback.onLinkEdited(this.inviteToEdit, tLObject);
            }
            finishFragment();
            return;
        }
        AlertsCreator.showSimpleAlert(this, tLRPC$TL_error.text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chooseUses(int customUses) {
        this.dispalyedUses.clear();
        int i = 0;
        boolean z = false;
        int length = 0;
        while (true) {
            int[] iArr = this.defaultUses;
            if (i >= iArr.length) {
                break;
            }
            if (!z && customUses <= iArr[i]) {
                if (customUses != iArr[i]) {
                    this.dispalyedUses.add(Integer.valueOf(customUses));
                }
                length = i;
                z = true;
            }
            this.dispalyedUses.add(Integer.valueOf(this.defaultUses[i]));
            i++;
        }
        if (!z) {
            this.dispalyedUses.add(Integer.valueOf(customUses));
            length = this.defaultUses.length;
        }
        int size = this.dispalyedUses.size() + 1;
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 == size - 1) {
                strArr[i2] = LocaleController.getString("NoLimit", R.string.NoLimit);
            } else {
                strArr[i2] = this.dispalyedUses.get(i2).toString();
            }
        }
        this.usesChooseView.setOptions(length, strArr);
    }

    private void chooseDate(int selectedDate) {
        long j = selectedDate;
        this.timeEditText.setText(LocaleController.formatDateAudio(j, false));
        int currentTime = selectedDate - getConnectionsManager().getCurrentTime();
        this.dispalyedDates.clear();
        int i = 0;
        boolean z = false;
        int length = 0;
        while (true) {
            int[] iArr = this.defaultDates;
            if (i >= iArr.length) {
                break;
            }
            if (!z && currentTime < iArr[i]) {
                this.dispalyedDates.add(Integer.valueOf(currentTime));
                length = i;
                z = true;
            }
            this.dispalyedDates.add(Integer.valueOf(this.defaultDates[i]));
            i++;
        }
        if (!z) {
            this.dispalyedDates.add(Integer.valueOf(currentTime));
            length = this.defaultDates.length;
        }
        int size = this.dispalyedDates.size() + 1;
        String[] strArr = new String[size];
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 == size - 1) {
                strArr[i2] = LocaleController.getString("NoLimit", R.string.NoLimit);
            } else if (this.dispalyedDates.get(i2).intValue() == this.defaultDates[0]) {
                strArr[i2] = LocaleController.formatPluralString("Hours", 1);
            } else if (this.dispalyedDates.get(i2).intValue() == this.defaultDates[1]) {
                strArr[i2] = LocaleController.formatPluralString("Days", 1);
            } else if (this.dispalyedDates.get(i2).intValue() == this.defaultDates[2]) {
                strArr[i2] = LocaleController.formatPluralString("Weeks", 1);
            } else {
                long j2 = currentTime;
                if (j2 < 86400) {
                    strArr[i2] = LocaleController.getString("MessageScheduleToday", R.string.MessageScheduleToday);
                } else if (j2 < 31449600) {
                    strArr[i2] = LocaleController.getInstance().formatterScheduleDay.format(j * 1000);
                } else {
                    strArr[i2] = LocaleController.getInstance().formatterYear.format(j * 1000);
                }
            }
        }
        this.timeChooseView.setOptions(length, strArr);
    }

    private void resetDates() {
        this.dispalyedDates.clear();
        int i = 0;
        while (true) {
            int[] iArr = this.defaultDates;
            if (i < iArr.length) {
                this.dispalyedDates.add(Integer.valueOf(iArr[i]));
                i++;
            } else {
                this.timeChooseView.setOptions(4, LocaleController.formatPluralString("Hours", 1), LocaleController.formatPluralString("Days", 1), LocaleController.formatPluralString("Weeks", 1), LocaleController.getString("NoLimit", R.string.NoLimit));
                return;
            }
        }
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetUses() {
        this.dispalyedUses.clear();
        int i = 0;
        while (true) {
            int[] iArr = this.defaultUses;
            if (i < iArr.length) {
                this.dispalyedUses.add(Integer.valueOf(iArr[i]));
                i++;
            } else {
                this.usesChooseView.setOptions(4, "1", "10", "100", LocaleController.getString("NoLimit", R.string.NoLimit));
                return;
            }
        }
    }

    public void setInviteToEdit(TLRPC$TL_chatInviteExported invite) {
        this.inviteToEdit = invite;
        if (this.fragmentView == null || invite == null) {
            return;
        }
        int i = invite.expire_date;
        if (i > 0) {
            chooseDate(i);
            this.currentInviteDate = this.dispalyedDates.get(this.timeChooseView.getSelectedIndex()).intValue();
        } else {
            this.currentInviteDate = 0;
        }
        int i2 = invite.usage_limit;
        if (i2 > 0) {
            chooseUses(i2);
            this.usesEditText.setText(Integer.toString(invite.usage_limit));
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void finishFragment() {
        this.scrollView.getLayoutParams().height = this.scrollView.getHeight();
        this.finished = true;
        super.finishFragment();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$LinkEditActivity$86kv34HLF_gUJsj5dDA23sh6Dgg
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$11$LinkEditActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.timeHeaderCell, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.usesHeaderCell, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.timeHeaderCell, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.usesHeaderCell, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.timeChooseView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.usesChooseView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.timeEditText, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.usesEditText, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.revokeLink, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.divider, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.dividerUses, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "featuredStickers_addButton"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "featuredStickers_addButtonPressed"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "windowBackgroundWhiteGrayText"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "featuredStickers_buttonText"));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "windowBackgroundWhiteRedText5"));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$11$LinkEditActivity() {
        TextInfoPrivacyCell textInfoPrivacyCell = this.dividerUses;
        if (textInfoPrivacyCell != null) {
            Context context = textInfoPrivacyCell.getContext();
            this.dividerUses.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
            this.divider.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider, "windowBackgroundGrayShadow"));
            this.buttonTextView.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(6.0f), Theme.getColor("featuredStickers_addButton"), Theme.getColor("featuredStickers_addButtonPressed")));
            this.usesEditText.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.usesEditText.setHintTextColor(Theme.getColor("windowBackgroundWhiteGrayText"));
            this.timeEditText.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.timeEditText.setHintTextColor(Theme.getColor("windowBackgroundWhiteGrayText"));
            this.buttonTextView.setTextColor(Theme.getColor("featuredStickers_buttonText"));
            TextSettingsCell textSettingsCell = this.revokeLink;
            if (textSettingsCell != null) {
                textSettingsCell.setTextColor(Theme.getColor("windowBackgroundWhiteRedText5"));
            }
        }
    }
}
