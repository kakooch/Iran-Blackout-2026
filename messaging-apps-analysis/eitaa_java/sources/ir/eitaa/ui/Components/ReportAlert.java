package ir.eitaa.ui.Components;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.R;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;

/* loaded from: classes3.dex */
public class ReportAlert extends BottomSheet {
    private BottomSheetCell clearButton;
    private EditTextBoldCursor editText;

    protected void onSend(int type, String message) {
        throw null;
    }

    public static class BottomSheetCell extends FrameLayout {
        private View background;
        private TextView textView;

        public BottomSheetCell(Context context) {
            super(context);
            View view = new View(context);
            this.background = view;
            view.setBackground(Theme.createSimpleSelectorRoundRectDrawable(AndroidUtilities.dp(4.0f), Theme.getColor("featuredStickers_addButton"), Theme.getColor("featuredStickers_addButtonPressed")));
            addView(this.background, LayoutHelper.createFrame(-1, -1.0f, 0, 16.0f, 16.0f, 16.0f, 16.0f));
            TextView textView = new TextView(context);
            this.textView = textView;
            textView.setLines(1);
            this.textView.setSingleLine(true);
            this.textView.setGravity(1);
            this.textView.setEllipsize(TextUtils.TruncateAt.END);
            this.textView.setGravity(17);
            this.textView.setTextColor(Theme.getColor("featuredStickers_buttonText"));
            this.textView.setTextSize(1, 14.0f);
            this.textView.setTypeface(AndroidUtilities.getFontFamily(true));
            addView(this.textView, LayoutHelper.createFrame(-2, -2, 17));
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(80.0f), 1073741824));
        }

        public void setText(CharSequence text) {
            this.textView.setText(text);
        }
    }

    public ReportAlert(final Context context, final int type) {
        super(context, true);
        setApplyBottomPadding(false);
        setApplyTopPadding(false);
        ScrollView scrollView = new ScrollView(context);
        scrollView.setFillViewport(true);
        setCustomView(scrollView);
        FrameLayout frameLayout = new FrameLayout(context);
        scrollView.addView(frameLayout, LayoutHelper.createScroll(-1, -2, 51));
        TextView textView = new TextView(context);
        textView.setTypeface(AndroidUtilities.getFontFamily(true));
        textView.setTextSize(1, 24.0f);
        textView.setTextColor(Theme.getColor("dialogTextBlack"));
        textView.setText(LocaleController.getString("ReportChat", R.string.ReportChat));
        frameLayout.addView(textView, LayoutHelper.createFrame(-2, -2.0f, 49, 17.0f, 17.0f, 17.0f, 0.0f));
        TextView textView2 = new TextView(context);
        textView2.setTextSize(1, 14.0f);
        textView2.setTextColor(Theme.getColor("dialogTextGray3"));
        textView2.setGravity(1);
        textView2.setText(LocaleController.getString("ReportInfo", R.string.ReportInfo));
        frameLayout.addView(textView2, LayoutHelper.createFrame(-2, -2.0f, 49, 30.0f, 56.0f, 30.0f, 44.0f));
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
        this.editText = editTextBoldCursor;
        editTextBoldCursor.setTextSize(1, 18.0f);
        this.editText.setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
        this.editText.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.editText.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
        this.editText.setMaxLines(1);
        this.editText.setLines(1);
        this.editText.setPadding(0, 0, 0, 0);
        this.editText.setSingleLine(true);
        this.editText.setGravity(LocaleController.isRTL ? 5 : 3);
        this.editText.setInputType(180224);
        this.editText.setImeOptions(6);
        this.editText.setHint(LocaleController.getString("ReportHint", R.string.ReportHint));
        this.editText.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.editText.setCursorSize(AndroidUtilities.dp(20.0f));
        this.editText.setCursorWidth(1.5f);
        this.editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ReportAlert$cMQW-xax4Ual9T_lSsJh4aVreeI
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView3, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$new$0$ReportAlert(textView3, i, keyEvent);
            }
        });
        frameLayout.addView(this.editText, LayoutHelper.createFrame(-1, 36.0f, 51, 17.0f, 108.0f, 17.0f, 0.0f));
        BottomSheetCell bottomSheetCell = new BottomSheetCell(context);
        this.clearButton = bottomSheetCell;
        bottomSheetCell.setBackground(null);
        this.clearButton.setText(LocaleController.getString("ReportSend", R.string.ReportSend));
        this.clearButton.background.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.Components.-$$Lambda$ReportAlert$po4vuas9V2FqQRpmGeo8PwgreyQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$new$1$ReportAlert(type, view);
            }
        });
        frameLayout.addView(this.clearButton, LayoutHelper.createFrame(-1, 50.0f, 51, 0.0f, 160.0f, 0.0f, 0.0f));
        this.smoothKeyboardAnimationEnabled = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$new$0$ReportAlert(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.clearButton.background.callOnClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$new$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$new$1$ReportAlert(int i, View view) {
        AndroidUtilities.hideKeyboard(this.editText);
        onSend(i, this.editText.getText().toString());
        dismiss();
    }
}
