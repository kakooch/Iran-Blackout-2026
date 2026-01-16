package org.rbmain.ui;

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
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.LocaleController;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$TL_chatInviteExported;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.AdjustPanLayoutHelper;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.SizeNotifierFrameLayout;
import org.rbmain.ui.Components.SlideChooseView;

/* loaded from: classes4.dex */
public class LinkEditActivity extends BaseFragment {
    private TextView buttonTextView;
    private Callback callback;
    private final int chatId;
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
        void onLinkCreated(TLObject tLObject);

        void onLinkEdited(TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported, TLObject tLObject);

        void onLinkRemoved(TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported);

        void revokeLink(TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported);
    }

    public LinkEditActivity(int i, int i2) {
        this.type = i;
        this.chatId = i2;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        int i = this.type;
        if (i == 0) {
            this.actionBar.setTitle(LocaleController.getString("NewLink", R.string.NewLink));
        } else if (i == 1) {
            this.actionBar.setTitle(LocaleController.getString("EditLink", R.string.EditLink));
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.LinkEditActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i2) {
                if (i2 == -1) {
                    LinkEditActivity.this.finishFragment();
                    AndroidUtilities.hideKeyboard(LinkEditActivity.this.usesEditText);
                }
            }
        });
        this.scrollView = new ScrollView(context);
        SizeNotifierFrameLayout sizeNotifierFrameLayout = new SizeNotifierFrameLayout(context) { // from class: org.rbmain.ui.LinkEditActivity.2
            int oldKeyboardHeight;

            @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout
            protected AdjustPanLayoutHelper createAdjustPanLayoutHelper() {
                AdjustPanLayoutHelper adjustPanLayoutHelper = new AdjustPanLayoutHelper(this) { // from class: org.rbmain.ui.LinkEditActivity.2.1
                    @Override // org.rbmain.ui.ActionBar.AdjustPanLayoutHelper
                    protected void onTransitionStart(boolean z, int i2) {
                        super.onTransitionStart(z, i2);
                        LinkEditActivity.this.scrollView.getLayoutParams().height = i2;
                    }

                    @Override // org.rbmain.ui.ActionBar.AdjustPanLayoutHelper
                    protected void onTransitionEnd() {
                        super.onTransitionEnd();
                        LinkEditActivity.this.scrollView.getLayoutParams().height = -1;
                        LinkEditActivity.this.scrollView.requestLayout();
                    }

                    @Override // org.rbmain.ui.ActionBar.AdjustPanLayoutHelper
                    protected void onPanTranslationUpdate(float f, float f2, boolean z) {
                        super.onPanTranslationUpdate(f, f2, z);
                        setTranslationY(0.0f);
                    }

                    @Override // org.rbmain.ui.ActionBar.AdjustPanLayoutHelper
                    protected boolean heightAnimationEnabled() {
                        return !LinkEditActivity.this.finished;
                    }
                };
                adjustPanLayoutHelper.setCheckHierarchyHeight(true);
                return adjustPanLayoutHelper;
            }

            @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout, android.view.ViewGroup, android.view.View
            protected void onAttachedToWindow() {
                super.onAttachedToWindow();
                this.adjustPanLayoutHelper.onAttach();
            }

            @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout, android.view.ViewGroup, android.view.View
            protected void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                this.adjustPanLayoutHelper.onDetach();
            }

            @Override // android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i2, int i3) {
                super.onMeasure(i2, i3);
                measureKeyboardHeight();
                int i4 = this.oldKeyboardHeight;
                int i5 = this.keyboardHeight;
                if (i4 != i5 && i5 > AndroidUtilities.dp(20.0f)) {
                    LinkEditActivity.this.scrollToEnd = true;
                    invalidate();
                }
                if (this.keyboardHeight < AndroidUtilities.dp(20.0f)) {
                    LinkEditActivity.this.usesEditText.clearFocus();
                }
                this.oldKeyboardHeight = this.keyboardHeight;
            }

            @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
            protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
                int scrollY = LinkEditActivity.this.scrollView.getScrollY();
                super.onLayout(z, i2, i3, i4, i5);
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

            @Override // org.rbmain.ui.Components.SizeNotifierFrameLayout, android.view.ViewGroup, android.view.View
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
        LinearLayout linearLayout = new LinearLayout(context) { // from class: org.rbmain.ui.LinkEditActivity.3
            boolean firstLayout = true;

            @Override // android.widget.LinearLayout, android.view.View
            protected void onMeasure(int i2, int i3) {
                int iDp;
                super.onMeasure(i2, i3);
                int size = View.MeasureSpec.getSize(i3);
                int measuredHeight = 0;
                for (int i4 = 0; i4 < getChildCount(); i4++) {
                    View childAt = getChildAt(i4);
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
                    int i5 = ((LinearLayout.LayoutParams) LinkEditActivity.this.buttonTextView.getLayoutParams()).topMargin;
                    ((LinearLayout.LayoutParams) LinkEditActivity.this.buttonTextView.getLayoutParams()).topMargin = iDp;
                    if (!this.firstLayout) {
                        LinkEditActivity.this.buttonTextView.setTranslationY(i5 - iDp);
                        LinkEditActivity.this.buttonTextView.animate().translationY(0.0f).setDuration(250L).setInterpolator(AdjustPanLayoutHelper.keyboardInterpolator).start();
                    }
                    super.onMeasure(i2, i3);
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
        this.buttonTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
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
        this.timeEditText.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LinkEditActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$1(context, view);
            }
        });
        this.timeChooseView.setCallback(new SlideChooseView.Callback() { // from class: org.rbmain.ui.LinkEditActivity$$ExternalSyntheticLambda9
            @Override // org.rbmain.ui.Components.SlideChooseView.Callback
            public final void onOptionSelected(int i3) {
                this.f$0.lambda$createView$2(i3);
            }

            @Override // org.rbmain.ui.Components.SlideChooseView.Callback
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
        slideChooseView2.setCallback(new SlideChooseView.Callback() { // from class: org.rbmain.ui.LinkEditActivity$$ExternalSyntheticLambda10
            @Override // org.rbmain.ui.Components.SlideChooseView.Callback
            public final void onOptionSelected(int i3) {
                this.f$0.lambda$createView$3(i3);
            }

            @Override // org.rbmain.ui.Components.SlideChooseView.Callback
            public /* synthetic */ void onTouchEnd() {
                SlideChooseView.Callback.CC.$default$onTouchEnd(this);
            }
        });
        resetUses();
        linearLayout.addView(this.usesChooseView);
        EditText editText = new EditText(this, context) { // from class: org.rbmain.ui.LinkEditActivity.4
            @Override // android.widget.TextView, android.view.View
            public boolean onTouchEvent(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    setCursorVisible(true);
                }
                return super.onTouchEvent(motionEvent);
            }
        };
        this.usesEditText = editText;
        editText.setPadding(AndroidUtilities.dp(22.0f), 0, AndroidUtilities.dp(22.0f), 0);
        this.usesEditText.setGravity(16);
        this.usesEditText.setTextSize(1, 16.0f);
        this.usesEditText.setHint(LocaleController.getString("UsesLimitHint", R.string.UsesLimitHint));
        this.usesEditText.setKeyListener(DigitsKeyListener.getInstance("0123456789."));
        this.usesEditText.setInputType(2);
        this.usesEditText.addTextChangedListener(new TextWatcher() { // from class: org.rbmain.ui.LinkEditActivity.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) throws NumberFormatException {
                if (LinkEditActivity.this.ignoreSet) {
                    return;
                }
                if (editable.toString().equals("0")) {
                    LinkEditActivity.this.usesEditText.setText(BuildConfig.FLAVOR);
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
            textSettingsCell.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhite));
            this.revokeLink.setText(LocaleController.getString("RevokeLink", R.string.RevokeLink), false);
            this.revokeLink.setTextColor(Theme.getColor(Theme.key_text_RedRegular));
            this.revokeLink.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LinkEditActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$createView$5(view);
                }
            });
            linearLayout.addView(this.revokeLink);
        }
        sizeNotifierFrameLayout.addView(this.scrollView, LayoutHelper.createFrame(-1, -1.0f));
        linearLayout.addView(this.buttonTextView, LayoutHelper.createFrame(-1, 48.0f, 80, 16.0f, 15.0f, 16.0f, 16.0f));
        HeaderCell headerCell3 = this.timeHeaderCell;
        int i3 = Theme.key_windowBackgroundWhite;
        headerCell3.setBackgroundColor(Theme.getColor(i3));
        this.timeChooseView.setBackgroundColor(Theme.getColor(i3));
        this.timeEditText.setBackgroundColor(Theme.getColor(i3));
        this.usesHeaderCell.setBackgroundColor(Theme.getColor(i3));
        this.usesChooseView.setBackgroundColor(Theme.getColor(i3));
        this.usesEditText.setBackgroundColor(Theme.getColor(i3));
        sizeNotifierFrameLayout.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundGray));
        this.buttonTextView.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.LinkEditActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$10(context, view);
            }
        });
        this.buttonTextView.setTextColor(Theme.getColor(Theme.key_featuredStickers_buttonText));
        TextInfoPrivacyCell textInfoPrivacyCell3 = this.dividerUses;
        int i4 = Theme.key_windowBackgroundGrayShadow;
        textInfoPrivacyCell3.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, i4));
        this.divider.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider, i4));
        this.buttonTextView.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(6.0f), Theme.getColor(Theme.key_featuredStickers_addButton), Theme.getColor(Theme.key_featuredStickers_addButtonPressed)));
        EditText editText2 = this.usesEditText;
        int i5 = Theme.key_windowBackgroundWhiteBlackText;
        editText2.setTextColor(Theme.getColor(i5));
        EditText editText3 = this.usesEditText;
        int i6 = Theme.key_windowBackgroundWhiteGrayText;
        editText3.setHintTextColor(Theme.getColor(i6));
        this.timeEditText.setTextColor(Theme.getColor(i5));
        this.timeEditText.setHintTextColor(Theme.getColor(i6));
        this.usesEditText.setCursorVisible(false);
        setInviteToEdit(this.inviteToEdit);
        sizeNotifierFrameLayout.setClipChildren(false);
        this.scrollView.setClipChildren(false);
        linearLayout.setClipChildren(false);
        return sizeNotifierFrameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$1(Context context, View view) {
        AlertsCreator.createDatePickerDialog(context, -1L, new AlertsCreator.ScheduleDatePickerDelegate() { // from class: org.rbmain.ui.LinkEditActivity$$ExternalSyntheticLambda8
            @Override // org.rbmain.ui.Components.AlertsCreator.ScheduleDatePickerDelegate
            public final void didSelectDate(boolean z, int i) {
                this.f$0.lambda$createView$0(z, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(boolean z, int i) {
        chooseDate(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$2(int i) {
        if (i < this.dispalyedDates.size()) {
            this.timeEditText.setText(LocaleController.formatDateAudio(this.dispalyedDates.get(i).intValue() + getConnectionsManager().getCurrentTime(), false));
        } else {
            this.timeEditText.setText(BuildConfig.FLAVOR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$3(int i) {
        this.usesEditText.clearFocus();
        this.ignoreSet = true;
        if (i < this.dispalyedUses.size()) {
            this.usesEditText.setText(this.dispalyedUses.get(i).toString());
        } else {
            this.usesEditText.setText(BuildConfig.FLAVOR);
        }
        this.ignoreSet = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$5(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setMessage(LocaleController.getString("RevokeAlert", R.string.RevokeAlert));
        builder.setTitle(LocaleController.getString("RevokeLink", R.string.RevokeLink));
        builder.setPositiveButton(LocaleController.getString("RevokeButton", R.string.RevokeButton), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.LinkEditActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$createView$4(dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$4(DialogInterface dialogInterface, int i) {
        this.callback.revokeLink(this.inviteToEdit);
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:49:0x017f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$createView$10(android.content.Context r6, android.view.View r7) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.LinkEditActivity.lambda$createView$10(android.content.Context, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$7(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LinkEditActivity$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$6(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$6(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
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
    public /* synthetic */ void lambda$createView$9(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.LinkEditActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$createView$8(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$8(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
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
    public void chooseUses(int i) {
        this.dispalyedUses.clear();
        int i2 = 0;
        boolean z = false;
        int length = 0;
        while (true) {
            int[] iArr = this.defaultUses;
            if (i2 >= iArr.length) {
                break;
            }
            if (!z && i <= iArr[i2]) {
                if (i != iArr[i2]) {
                    this.dispalyedUses.add(Integer.valueOf(i));
                }
                length = i2;
                z = true;
            }
            this.dispalyedUses.add(Integer.valueOf(this.defaultUses[i2]));
            i2++;
        }
        if (!z) {
            this.dispalyedUses.add(Integer.valueOf(i));
            length = this.defaultUses.length;
        }
        int size = this.dispalyedUses.size() + 1;
        String[] strArr = new String[size];
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 == size - 1) {
                strArr[i3] = LocaleController.getString("NoLimit", R.string.NoLimit);
            } else {
                strArr[i3] = this.dispalyedUses.get(i3).toString();
            }
        }
        this.usesChooseView.setOptions(length, strArr);
    }

    private void chooseDate(int i) {
        long j = i;
        this.timeEditText.setText(LocaleController.formatDateAudio(j, false));
        int currentTime = i - getConnectionsManager().getCurrentTime();
        this.dispalyedDates.clear();
        int i2 = 0;
        boolean z = false;
        int length = 0;
        while (true) {
            int[] iArr = this.defaultDates;
            if (i2 >= iArr.length) {
                break;
            }
            if (!z && currentTime < iArr[i2]) {
                this.dispalyedDates.add(Integer.valueOf(currentTime));
                length = i2;
                z = true;
            }
            this.dispalyedDates.add(Integer.valueOf(this.defaultDates[i2]));
            i2++;
        }
        if (!z) {
            this.dispalyedDates.add(Integer.valueOf(currentTime));
            length = this.defaultDates.length;
        }
        int size = this.dispalyedDates.size() + 1;
        String[] strArr = new String[size];
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 == size - 1) {
                strArr[i3] = LocaleController.getString("NoLimit", R.string.NoLimit);
            } else if (this.dispalyedDates.get(i3).intValue() == this.defaultDates[0]) {
                strArr[i3] = LocaleController.formatPluralString("Hours", 1);
            } else if (this.dispalyedDates.get(i3).intValue() == this.defaultDates[1]) {
                strArr[i3] = LocaleController.formatPluralString("Days", 1);
            } else if (this.dispalyedDates.get(i3).intValue() == this.defaultDates[2]) {
                strArr[i3] = LocaleController.formatPluralString("Weeks", 1);
            } else {
                long j2 = currentTime;
                if (j2 < 86400) {
                    strArr[i3] = LocaleController.getString("MessageScheduleToday", R.string.MessageScheduleToday);
                } else if (j2 < 31449600) {
                    strArr[i3] = LocaleController.getInstance().formatterScheduleDay.format(j * 1000);
                } else {
                    strArr[i3] = LocaleController.getInstance().formatterYear.format(j * 1000);
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

    public void setInviteToEdit(TLRPC$TL_chatInviteExported tLRPC$TL_chatInviteExported) {
        this.inviteToEdit = tLRPC$TL_chatInviteExported;
        if (this.fragmentView == null || tLRPC$TL_chatInviteExported == null) {
            return;
        }
        int i = tLRPC$TL_chatInviteExported.expire_date;
        if (i > 0) {
            chooseDate(i);
            this.currentInviteDate = this.dispalyedDates.get(this.timeChooseView.getSelectedIndex()).intValue();
        } else {
            this.currentInviteDate = 0;
        }
        int i2 = tLRPC$TL_chatInviteExported.usage_limit;
        if (i2 > 0) {
            chooseUses(i2);
            this.usesEditText.setText(Integer.toString(tLRPC$TL_chatInviteExported.usage_limit));
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void finishFragment() {
        this.scrollView.getLayoutParams().height = this.scrollView.getHeight();
        this.finished = true;
        super.finishFragment();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.LinkEditActivity.6
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public void didSetColor() {
                if (LinkEditActivity.this.dividerUses != null) {
                    Context context = LinkEditActivity.this.dividerUses.getContext();
                    TextInfoPrivacyCell textInfoPrivacyCell = LinkEditActivity.this.dividerUses;
                    int i = Theme.key_windowBackgroundGrayShadow;
                    textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, i));
                    LinkEditActivity.this.divider.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider, i));
                    LinkEditActivity.this.buttonTextView.setBackgroundDrawable(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(6.0f), Theme.getColor(Theme.key_featuredStickers_addButton), Theme.getColor(Theme.key_featuredStickers_addButtonPressed)));
                    EditText editText = LinkEditActivity.this.usesEditText;
                    int i2 = Theme.key_windowBackgroundWhiteBlackText;
                    editText.setTextColor(Theme.getColor(i2));
                    EditText editText2 = LinkEditActivity.this.usesEditText;
                    int i3 = Theme.key_windowBackgroundWhiteGrayText;
                    editText2.setHintTextColor(Theme.getColor(i3));
                    LinkEditActivity.this.timeEditText.setTextColor(Theme.getColor(i2));
                    LinkEditActivity.this.timeEditText.setHintTextColor(Theme.getColor(i3));
                    LinkEditActivity.this.buttonTextView.setTextColor(Theme.getColor(Theme.key_featuredStickers_buttonText));
                    if (LinkEditActivity.this.revokeLink != null) {
                        LinkEditActivity.this.revokeLink.setTextColor(Theme.getColor(Theme.key_text_RedRegular));
                    }
                }
            }
        };
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        int i = Theme.key_windowBackgroundWhiteBlueHeader;
        arrayList.add(new ThemeDescription(this.timeHeaderCell, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i));
        arrayList.add(new ThemeDescription(this.usesHeaderCell, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i));
        HeaderCell headerCell = this.timeHeaderCell;
        int i2 = ThemeDescription.FLAG_BACKGROUND;
        int i3 = Theme.key_windowBackgroundWhite;
        arrayList.add(new ThemeDescription(headerCell, i2, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.usesHeaderCell, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.timeChooseView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.usesChooseView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.timeEditText, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.usesEditText, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.revokeLink, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, i3));
        int i4 = Theme.key_windowBackgroundWhiteGrayText4;
        arrayList.add(new ThemeDescription(this.divider, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.dividerUses, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i4));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundGray));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_actionBarDefault));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_windowBackgroundGrayShadow));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_featuredStickers_addButton));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_featuredStickers_addButtonPressed));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_windowBackgroundWhiteBlackText));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_windowBackgroundWhiteGrayText));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_featuredStickers_buttonText));
        arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, Theme.key_text_RedRegular));
        return arrayList;
    }
}
