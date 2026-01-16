package ir.eitaa.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$TL_account_createTheme;
import ir.eitaa.tgnet.TLRPC$TL_account_updateTheme;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputDocumentEmpty;
import ir.eitaa.tgnet.TLRPC$TL_inputTheme;
import ir.eitaa.tgnet.TLRPC$TL_theme;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Cells.ThemePreviewMessagesCell;
import ir.eitaa.ui.Cells.ThemesHorizontalListCell;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.BulletinFactory;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.LayoutHelper;
import java.util.ArrayList;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class ThemeSetUrlActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private TextInfoPrivacyCell checkInfoCell;
    private int checkReqId;
    private Runnable checkRunnable;
    private TextSettingsCell createCell;
    private TextInfoPrivacyCell createInfoCell;
    private boolean creatingNewTheme;
    private View divider;
    private View doneButton;
    private EditTextBoldCursor editText;
    private HeaderCell headerCell;
    private TextInfoPrivacyCell helpInfoCell;
    private boolean ignoreCheck;
    private TLRPC$TL_theme info;
    private CharSequence infoText;
    private String lastCheckName;
    private boolean lastNameAvailable;
    private LinearLayout linearLayoutTypeContainer;
    private EditTextBoldCursor linkField;
    private ThemePreviewMessagesCell messagesCell;
    private EditTextBoldCursor nameField;
    private AlertDialog progressDialog;
    private Theme.ThemeAccent themeAccent;
    private Theme.ThemeInfo themeInfo;

    static /* synthetic */ boolean lambda$createView$0(View view, MotionEvent motionEvent) {
        return true;
    }

    static /* synthetic */ boolean lambda$createView$4(View view, MotionEvent motionEvent) {
        return true;
    }

    static /* synthetic */ void lambda$saveTheme$9(DialogInterface dialogInterface) {
    }

    public class LinkSpan extends ClickableSpan {
        private String url;

        public LinkSpan(String value) {
            this.url = value;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            try {
                ((ClipboardManager) ApplicationLoader.applicationContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", this.url));
                if (BulletinFactory.canShowBulletin(ThemeSetUrlActivity.this)) {
                    BulletinFactory.createCopyLinkBulletin(ThemeSetUrlActivity.this).show();
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    private static class LinkMovementMethodMy extends LinkMovementMethod {
        private LinkMovementMethodMy() {
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
            try {
                boolean zOnTouchEvent = super.onTouchEvent(widget, buffer, event);
                if (event.getAction() == 1 || event.getAction() == 3) {
                    Selection.removeSelection(buffer);
                }
                return zOnTouchEvent;
            } catch (Exception e) {
                FileLog.e(e);
                return false;
            }
        }
    }

    public ThemeSetUrlActivity(Theme.ThemeInfo theme, Theme.ThemeAccent accent, boolean newTheme) {
        this.themeInfo = theme;
        this.themeAccent = accent;
        this.info = accent != null ? accent.info : theme.info;
        this.currentAccount = accent != null ? accent.account : theme.account;
        this.creatingNewTheme = newTheme;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        getNotificationCenter().addObserver(this, NotificationCenter.themeUploadedToServer);
        getNotificationCenter().addObserver(this, NotificationCenter.themeUploadError);
        return super.onFragmentCreate();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
        super.onFragmentDestroy();
        getNotificationCenter().removeObserver(this, NotificationCenter.themeUploadedToServer);
        getNotificationCenter().removeObserver(this, NotificationCenter.themeUploadError);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(final Context context) {
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(true);
        if (this.creatingNewTheme) {
            this.actionBar.setTitle(LocaleController.getString("NewThemeTitle", R.string.NewThemeTitle));
        } else {
            this.actionBar.setTitle(LocaleController.getString("EditThemeTitle", R.string.EditThemeTitle));
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.ThemeSetUrlActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) throws Throwable {
                if (id == -1) {
                    ThemeSetUrlActivity.this.finishFragment();
                } else if (id == 1) {
                    ThemeSetUrlActivity.this.saveTheme();
                }
            }
        });
        this.doneButton = this.actionBar.createMenu().addItem(1, LocaleController.getString("Done", R.string.Done).toUpperCase());
        LinearLayout linearLayout = new LinearLayout(context);
        this.fragmentView = linearLayout;
        linearLayout.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        LinearLayout linearLayout2 = (LinearLayout) this.fragmentView;
        linearLayout2.setOrientation(1);
        this.fragmentView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemeSetUrlActivity$FxXXP2i2iy9ueBUtaGMnn0yS15c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ThemeSetUrlActivity.lambda$createView$0(view, motionEvent);
            }
        });
        LinearLayout linearLayout3 = new LinearLayout(context);
        this.linearLayoutTypeContainer = linearLayout3;
        linearLayout3.setOrientation(1);
        this.linearLayoutTypeContainer.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        linearLayout2.addView(this.linearLayoutTypeContainer, LayoutHelper.createLinear(-1, -2));
        HeaderCell headerCell = new HeaderCell(context, 23);
        this.headerCell = headerCell;
        headerCell.setText(LocaleController.getString("Info", R.string.Info));
        this.linearLayoutTypeContainer.addView(this.headerCell);
        EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
        this.nameField = editTextBoldCursor;
        editTextBoldCursor.setTextSize(1, 18.0f);
        this.nameField.setTypeface(AndroidUtilities.getFontFamily(false));
        this.nameField.setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
        this.nameField.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.nameField.setMaxLines(1);
        this.nameField.setLines(1);
        this.nameField.setGravity((LocaleController.isRTL ? 5 : 3) | 16);
        this.nameField.setBackgroundDrawable(null);
        this.nameField.setPadding(0, 0, 0, 0);
        this.nameField.setSingleLine(true);
        this.nameField.setFilters(new InputFilter[]{new InputFilter.LengthFilter(128)});
        this.nameField.setInputType(163872);
        this.nameField.setImeOptions(6);
        this.nameField.setHint(LocaleController.getString("ThemeNamePlaceholder", R.string.ThemeNamePlaceholder));
        this.nameField.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.nameField.setCursorSize(AndroidUtilities.dp(20.0f));
        this.nameField.setCursorWidth(1.5f);
        this.linearLayoutTypeContainer.addView(this.nameField, LayoutHelper.createLinear(-1, 50, 23.0f, 0.0f, 23.0f, 0.0f));
        this.nameField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemeSetUrlActivity$Qdu6gP3OHrHGbvPbcP5R2Sw7G7A
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$createView$1$ThemeSetUrlActivity(textView, i, keyEvent);
            }
        });
        View view = new View(context) { // from class: ir.eitaa.ui.ThemeSetUrlActivity.2
            @Override // android.view.View
            protected void onDraw(Canvas canvas) {
                canvas.drawLine(LocaleController.isRTL ? 0.0f : AndroidUtilities.dp(20.0f), getMeasuredHeight() - 1, getMeasuredWidth() - (LocaleController.isRTL ? AndroidUtilities.dp(20.0f) : 0), getMeasuredHeight() - 1, Theme.dividerPaint);
            }
        };
        this.divider = view;
        this.linearLayoutTypeContainer.addView(view, new LinearLayout.LayoutParams(-1, 1));
        LinearLayout linearLayout4 = new LinearLayout(context);
        linearLayout4.setOrientation(0);
        this.linearLayoutTypeContainer.addView(linearLayout4, LayoutHelper.createLinear(-1, 50, 23.0f, 0.0f, 23.0f, 0.0f));
        EditTextBoldCursor editTextBoldCursor2 = new EditTextBoldCursor(context);
        this.editText = editTextBoldCursor2;
        editTextBoldCursor2.setText(getMessagesController().linkPrefix + "/addtheme/");
        this.editText.setTextSize(1, 18.0f);
        this.editText.setTypeface(AndroidUtilities.getFontFamily(false));
        this.editText.setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
        this.editText.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.editText.setMaxLines(1);
        this.editText.setLines(1);
        this.editText.setEnabled(false);
        this.editText.setBackgroundDrawable(null);
        this.editText.setPadding(0, 0, 0, 0);
        this.editText.setSingleLine(true);
        this.editText.setInputType(163840);
        this.editText.setImeOptions(6);
        linearLayout4.addView(this.editText, LayoutHelper.createLinear(-2, 50));
        EditTextBoldCursor editTextBoldCursor3 = new EditTextBoldCursor(context);
        this.linkField = editTextBoldCursor3;
        editTextBoldCursor3.setTextSize(1, 18.0f);
        this.linkField.setTypeface(AndroidUtilities.getFontFamily(false));
        this.linkField.setHintTextColor(Theme.getColor("windowBackgroundWhiteHintText"));
        this.linkField.setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.linkField.setMaxLines(1);
        this.linkField.setLines(1);
        this.linkField.setBackgroundDrawable(null);
        this.linkField.setPadding(0, 0, 0, 0);
        this.linkField.setSingleLine(true);
        this.linkField.setInputType(163872);
        this.linkField.setImeOptions(6);
        this.linkField.setHint(LocaleController.getString("SetUrlPlaceholder", R.string.SetUrlPlaceholder));
        this.linkField.setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
        this.linkField.setCursorSize(AndroidUtilities.dp(20.0f));
        this.linkField.setCursorWidth(1.5f);
        linearLayout4.addView(this.linkField, LayoutHelper.createLinear(-1, 50));
        this.linkField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemeSetUrlActivity$RzkmFVDBG2p35L7AycU_TFyENI4
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return this.f$0.lambda$createView$2$ThemeSetUrlActivity(textView, i, keyEvent);
            }
        });
        this.linkField.addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.ThemeSetUrlActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (ThemeSetUrlActivity.this.ignoreCheck) {
                    return;
                }
                ThemeSetUrlActivity themeSetUrlActivity = ThemeSetUrlActivity.this;
                themeSetUrlActivity.checkUrl(themeSetUrlActivity.linkField.getText().toString(), false);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (ThemeSetUrlActivity.this.creatingNewTheme) {
                    return;
                }
                if (ThemeSetUrlActivity.this.linkField.length() <= 0) {
                    ThemeSetUrlActivity.this.helpInfoCell.setText(ThemeSetUrlActivity.this.infoText);
                    return;
                }
                String str = "https://" + ThemeSetUrlActivity.this.getMessagesController().linkPrefix + "/addtheme/" + ((Object) ThemeSetUrlActivity.this.linkField.getText());
                String string = LocaleController.formatString("ThemeHelpLink", R.string.ThemeHelpLink, str);
                int iIndexOf = string.indexOf(str);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
                if (iIndexOf >= 0) {
                    spannableStringBuilder.setSpan(ThemeSetUrlActivity.this.new LinkSpan(str), iIndexOf, str.length() + iIndexOf, 33);
                }
                ThemeSetUrlActivity.this.helpInfoCell.setText(TextUtils.concat(ThemeSetUrlActivity.this.infoText, "\n\n", spannableStringBuilder));
            }
        });
        if (this.creatingNewTheme) {
            this.linkField.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemeSetUrlActivity$MWBiZEYDl0vTIqeaqkljApNxMD8
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view2, boolean z) {
                    this.f$0.lambda$createView$3$ThemeSetUrlActivity(view2, z);
                }
            });
        }
        TextInfoPrivacyCell textInfoPrivacyCell = new TextInfoPrivacyCell(context);
        this.checkInfoCell = textInfoPrivacyCell;
        textInfoPrivacyCell.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
        this.checkInfoCell.setVisibility(8);
        this.checkInfoCell.setBottomPadding(0);
        linearLayout2.addView(this.checkInfoCell, LayoutHelper.createLinear(-1, -2));
        TextInfoPrivacyCell textInfoPrivacyCell2 = new TextInfoPrivacyCell(context);
        this.helpInfoCell = textInfoPrivacyCell2;
        textInfoPrivacyCell2.getTextView().setMovementMethod(new LinkMovementMethodMy());
        this.helpInfoCell.getTextView().setHighlightColor(Theme.getColor("windowBackgroundWhiteLinkSelection"));
        if (this.creatingNewTheme) {
            this.helpInfoCell.setText(AndroidUtilities.replaceTags(LocaleController.getString("ThemeCreateHelp", R.string.ThemeCreateHelp)));
        } else {
            TextInfoPrivacyCell textInfoPrivacyCell3 = this.helpInfoCell;
            SpannableStringBuilder spannableStringBuilderReplaceTags = AndroidUtilities.replaceTags(LocaleController.getString("ThemeSetUrlHelp", R.string.ThemeSetUrlHelp));
            this.infoText = spannableStringBuilderReplaceTags;
            textInfoPrivacyCell3.setText(spannableStringBuilderReplaceTags);
        }
        linearLayout2.addView(this.helpInfoCell, LayoutHelper.createLinear(-1, -2));
        if (this.creatingNewTheme) {
            this.helpInfoCell.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider, "windowBackgroundGrayShadow"));
            ThemePreviewMessagesCell themePreviewMessagesCell = new ThemePreviewMessagesCell(context, this.parentLayout, 1);
            this.messagesCell = themePreviewMessagesCell;
            linearLayout2.addView(themePreviewMessagesCell, LayoutHelper.createLinear(-1, -2));
            TextSettingsCell textSettingsCell = new TextSettingsCell(context);
            this.createCell = textSettingsCell;
            textSettingsCell.setBackgroundDrawable(Theme.getSelectorDrawable(true));
            this.createCell.setText(LocaleController.getString("UseDifferentTheme", R.string.UseDifferentTheme), false);
            linearLayout2.addView(this.createCell, LayoutHelper.createLinear(-1, -2));
            this.createCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemeSetUrlActivity$55N1D7TjgmYWpqAiyNuqWhcNqxw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.lambda$createView$5$ThemeSetUrlActivity(context, view2);
                }
            });
            TextInfoPrivacyCell textInfoPrivacyCell4 = new TextInfoPrivacyCell(context);
            this.createInfoCell = textInfoPrivacyCell4;
            textInfoPrivacyCell4.setText(AndroidUtilities.replaceTags(LocaleController.getString("UseDifferentThemeInfo", R.string.UseDifferentThemeInfo)));
            this.createInfoCell.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
            linearLayout2.addView(this.createInfoCell, LayoutHelper.createLinear(-1, -2));
        } else {
            this.helpInfoCell.setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
        }
        TLRPC$TL_theme tLRPC$TL_theme = this.info;
        if (tLRPC$TL_theme != null) {
            this.ignoreCheck = true;
            this.nameField.setText(tLRPC$TL_theme.title);
            EditTextBoldCursor editTextBoldCursor4 = this.nameField;
            editTextBoldCursor4.setSelection(editTextBoldCursor4.length());
            this.linkField.setText(this.info.slug);
            EditTextBoldCursor editTextBoldCursor5 = this.linkField;
            editTextBoldCursor5.setSelection(editTextBoldCursor5.length());
            this.ignoreCheck = false;
        }
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$1$ThemeSetUrlActivity(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        AndroidUtilities.hideKeyboard(this.nameField);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$2$ThemeSetUrlActivity(TextView textView, int i, KeyEvent keyEvent) {
        View view;
        if (i != 6 || (view = this.doneButton) == null) {
            return false;
        }
        view.performClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$ThemeSetUrlActivity(View view, boolean z) {
        if (z) {
            this.helpInfoCell.setText(AndroidUtilities.replaceTags(LocaleController.getString("ThemeCreateHelp2", R.string.ThemeCreateHelp2)));
        } else {
            this.helpInfoCell.setText(AndroidUtilities.replaceTags(LocaleController.getString("ThemeCreateHelp", R.string.ThemeCreateHelp)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$5$ThemeSetUrlActivity(Context context, View view) {
        if (getParentActivity() == null) {
            return;
        }
        final BottomSheet.Builder builder = new BottomSheet.Builder(getParentActivity(), false);
        builder.setApplyBottomPadding(false);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setText(LocaleController.getString("ChooseTheme", R.string.ChooseTheme));
        textView.setTextColor(Theme.getColor("dialogTextBlack"));
        textView.setTextSize(1, 20.0f);
        textView.setTypeface(AndroidUtilities.getFontFamily(true));
        linearLayout.addView(textView, LayoutHelper.createLinear(-1, -2, 51, 22, 12, 22, 4));
        textView.setOnTouchListener(new View.OnTouchListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemeSetUrlActivity$po1hvIHfdX8onk581_m4FEAtaqw
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return ThemeSetUrlActivity.lambda$createView$4(view2, motionEvent);
            }
        });
        builder.setCustomView(linearLayout);
        ArrayList arrayList = new ArrayList();
        int size = Theme.themes.size();
        for (int i = 0; i < size; i++) {
            Theme.ThemeInfo themeInfo = Theme.themes.get(i);
            TLRPC$TL_theme tLRPC$TL_theme = themeInfo.info;
            if (tLRPC$TL_theme == null || tLRPC$TL_theme.document != null) {
                arrayList.add(themeInfo);
            }
        }
        ThemesHorizontalListCell themesHorizontalListCell = new ThemesHorizontalListCell(context, 2, arrayList, new ArrayList()) { // from class: ir.eitaa.ui.ThemeSetUrlActivity.4
            @Override // ir.eitaa.ui.Cells.ThemesHorizontalListCell
            protected void updateRows() {
                builder.getDismissRunnable().run();
            }
        };
        linearLayout.addView(themesHorizontalListCell, LayoutHelper.createLinear(-1, 148, 0.0f, 7.0f, 0.0f, 1.0f));
        themesHorizontalListCell.scrollToCurrentTheme(this.fragmentView.getMeasuredWidth(), false);
        showDialog(builder.create());
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        if (!MessagesController.getGlobalMainSettings().getBoolean("view_animations", true) && this.creatingNewTheme) {
            this.linkField.requestFocus();
            AndroidUtilities.showKeyboard(this.linkField);
        }
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
        AndroidUtilities.removeAdjustResize(getParentActivity(), this.classGuid);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        AlertDialog alertDialog;
        AlertDialog alertDialog2;
        if (id == NotificationCenter.themeUploadedToServer) {
            Theme.ThemeInfo themeInfo = (Theme.ThemeInfo) args[0];
            Theme.ThemeAccent themeAccent = (Theme.ThemeAccent) args[1];
            if (themeInfo == this.themeInfo && themeAccent == this.themeAccent && (alertDialog2 = this.progressDialog) != null) {
                try {
                    alertDialog2.dismiss();
                    this.progressDialog = null;
                } catch (Exception e) {
                    FileLog.e(e);
                }
                Theme.applyTheme(this.themeInfo, false);
                finishFragment();
                return;
            }
            return;
        }
        if (id == NotificationCenter.themeUploadError) {
            Theme.ThemeInfo themeInfo2 = (Theme.ThemeInfo) args[0];
            Theme.ThemeAccent themeAccent2 = (Theme.ThemeAccent) args[1];
            if (themeInfo2 == this.themeInfo && themeAccent2 == this.themeAccent && (alertDialog = this.progressDialog) != null) {
                try {
                    alertDialog.dismiss();
                    this.progressDialog = null;
                } catch (Exception e2) {
                    FileLog.e(e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkUrl(final String url, boolean alert) {
        String str;
        Runnable runnable = this.checkRunnable;
        if (runnable != null) {
            AndroidUtilities.cancelRunOnUIThread(runnable);
            this.checkRunnable = null;
            this.lastCheckName = null;
            if (this.checkReqId != 0) {
                ConnectionsManager.getInstance(this.currentAccount).cancelRequest(this.checkReqId, true);
            }
        }
        this.lastNameAvailable = false;
        if (url != null) {
            if (url.startsWith("_") || url.endsWith("_")) {
                setCheckText(LocaleController.getString("SetUrlInvalid", R.string.SetUrlInvalid), "windowBackgroundWhiteRedText4");
                return false;
            }
            for (int i = 0; i < url.length(); i++) {
                char cCharAt = url.charAt(i);
                if (i == 0 && cCharAt >= '0' && cCharAt <= '9') {
                    if (alert) {
                        AlertsCreator.showSimpleAlert(this, LocaleController.getString("Theme", R.string.Theme), LocaleController.getString("SetUrlInvalidStartNumber", R.string.SetUrlInvalidStartNumber));
                    } else {
                        setCheckText(LocaleController.getString("SetUrlInvalidStartNumber", R.string.SetUrlInvalidStartNumber), "windowBackgroundWhiteRedText4");
                    }
                    return false;
                }
                if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && cCharAt != '_'))) {
                    if (alert) {
                        AlertsCreator.showSimpleAlert(this, LocaleController.getString("Theme", R.string.Theme), LocaleController.getString("SetUrlInvalid", R.string.SetUrlInvalid));
                    } else {
                        setCheckText(LocaleController.getString("SetUrlInvalid", R.string.SetUrlInvalid), "windowBackgroundWhiteRedText4");
                    }
                    return false;
                }
            }
        }
        if (url == null || url.length() < 5) {
            if (alert) {
                AlertsCreator.showSimpleAlert(this, LocaleController.getString("Theme", R.string.Theme), LocaleController.getString("SetUrlInvalidShort", R.string.SetUrlInvalidShort));
            } else {
                setCheckText(LocaleController.getString("SetUrlInvalidShort", R.string.SetUrlInvalidShort), "windowBackgroundWhiteRedText4");
            }
            return false;
        }
        if (url.length() > 64) {
            if (alert) {
                AlertsCreator.showSimpleAlert(this, LocaleController.getString("Theme", R.string.Theme), LocaleController.getString("SetUrlInvalidLong", R.string.SetUrlInvalidLong));
            } else {
                setCheckText(LocaleController.getString("SetUrlInvalidLong", R.string.SetUrlInvalidLong), "windowBackgroundWhiteRedText4");
            }
            return false;
        }
        if (!alert) {
            TLRPC$TL_theme tLRPC$TL_theme = this.info;
            if (tLRPC$TL_theme == null || (str = tLRPC$TL_theme.slug) == null) {
                str = "";
            }
            if (url.equals(str)) {
                setCheckText(LocaleController.formatString("SetUrlAvailable", R.string.SetUrlAvailable, url), "windowBackgroundWhiteGreenText");
                return true;
            }
            setCheckText(LocaleController.getString("SetUrlChecking", R.string.SetUrlChecking), "windowBackgroundWhiteGrayText8");
            this.lastCheckName = url;
            Runnable runnable2 = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ThemeSetUrlActivity$NMjQK9POd1K4gAbF7xX7loEPGqY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$checkUrl$8$ThemeSetUrlActivity(url);
                }
            };
            this.checkRunnable = runnable2;
            AndroidUtilities.runOnUIThread(runnable2, 300L);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkUrl$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkUrl$8$ThemeSetUrlActivity(final String str) {
        TLRPC$TL_account_createTheme tLRPC$TL_account_createTheme = new TLRPC$TL_account_createTheme();
        tLRPC$TL_account_createTheme.slug = str;
        tLRPC$TL_account_createTheme.title = "";
        tLRPC$TL_account_createTheme.document = new TLRPC$TL_inputDocumentEmpty();
        this.checkReqId = ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_createTheme, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ThemeSetUrlActivity$L3sr75GcWWnnDl8SN5gzAexqYho
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$checkUrl$7$ThemeSetUrlActivity(str, tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkUrl$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkUrl$7$ThemeSetUrlActivity(final String str, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ThemeSetUrlActivity$hQp1chH0J_tWz9eNUoM--hQslXA
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkUrl$6$ThemeSetUrlActivity(str, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkUrl$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkUrl$6$ThemeSetUrlActivity(String str, TLRPC$TL_error tLRPC$TL_error) {
        this.checkReqId = 0;
        String str2 = this.lastCheckName;
        if (str2 == null || !str2.equals(str)) {
            return;
        }
        if (tLRPC$TL_error == null || (!"THEME_SLUG_INVALID".equals(tLRPC$TL_error.text) && !"THEME_SLUG_OCCUPIED".equals(tLRPC$TL_error.text))) {
            setCheckText(LocaleController.formatString("SetUrlAvailable", R.string.SetUrlAvailable, str), "windowBackgroundWhiteGreenText");
            this.lastNameAvailable = true;
        } else {
            setCheckText(LocaleController.getString("SetUrlInUse", R.string.SetUrlInUse), "windowBackgroundWhiteRedText4");
            this.lastNameAvailable = false;
        }
    }

    private void setCheckText(String text, String colorKey) {
        if (TextUtils.isEmpty(text)) {
            this.checkInfoCell.setVisibility(8);
            if (this.creatingNewTheme) {
                this.helpInfoCell.setBackgroundDrawable(Theme.getThemedDrawable(getParentActivity(), R.drawable.greydivider, "windowBackgroundGrayShadow"));
                return;
            } else {
                this.helpInfoCell.setBackgroundDrawable(Theme.getThemedDrawable(getParentActivity(), R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
                return;
            }
        }
        this.checkInfoCell.setVisibility(0);
        this.checkInfoCell.setText(text);
        this.checkInfoCell.setTag(colorKey);
        this.checkInfoCell.setTextColor(colorKey);
        if (this.creatingNewTheme) {
            this.helpInfoCell.setBackgroundDrawable(Theme.getThemedDrawable(getParentActivity(), R.drawable.greydivider_top, "windowBackgroundGrayShadow"));
        } else {
            this.helpInfoCell.setBackgroundDrawable(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveTheme() throws Throwable {
        if (checkUrl(this.linkField.getText().toString(), true) && getParentActivity() != null) {
            if (this.nameField.length() == 0) {
                AlertsCreator.showSimpleAlert(this, LocaleController.getString("Theme", R.string.Theme), LocaleController.getString("ThemeNameInvalid", R.string.ThemeNameInvalid));
                return;
            }
            if (this.creatingNewTheme) {
                TLRPC$TL_theme tLRPC$TL_theme = this.info;
                String str = tLRPC$TL_theme.title;
                String str2 = tLRPC$TL_theme.slug;
                AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
                this.progressDialog = alertDialog;
                alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemeSetUrlActivity$tCbDIjcOjfC4-Z3UNpzdUEwZx2Q
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        ThemeSetUrlActivity.lambda$saveTheme$9(dialogInterface);
                    }
                });
                this.progressDialog.show();
                Theme.ThemeInfo themeInfo = this.themeInfo;
                TLRPC$TL_theme tLRPC$TL_theme2 = this.info;
                String string = this.nameField.getText().toString();
                tLRPC$TL_theme2.title = string;
                themeInfo.name = string;
                this.themeInfo.info.slug = this.linkField.getText().toString();
                Theme.saveCurrentTheme(this.themeInfo, true, true, true);
                return;
            }
            TLRPC$TL_theme tLRPC$TL_theme3 = this.info;
            String str3 = tLRPC$TL_theme3.slug;
            if (str3 == null) {
                str3 = "";
            }
            String str4 = tLRPC$TL_theme3.title;
            String str5 = str4 != null ? str4 : "";
            String string2 = this.linkField.getText().toString();
            String string3 = this.nameField.getText().toString();
            if (str3.equals(string2) && str5.equals(string3)) {
                finishFragment();
                return;
            }
            this.progressDialog = new AlertDialog(getParentActivity(), 3);
            final TLRPC$TL_account_updateTheme tLRPC$TL_account_updateTheme = new TLRPC$TL_account_updateTheme();
            TLRPC$TL_inputTheme tLRPC$TL_inputTheme = new TLRPC$TL_inputTheme();
            TLRPC$TL_theme tLRPC$TL_theme4 = this.info;
            tLRPC$TL_inputTheme.id = tLRPC$TL_theme4.id;
            tLRPC$TL_inputTheme.access_hash = tLRPC$TL_theme4.access_hash;
            tLRPC$TL_account_updateTheme.theme = tLRPC$TL_inputTheme;
            tLRPC$TL_account_updateTheme.format = "android";
            tLRPC$TL_account_updateTheme.slug = string2;
            int i = tLRPC$TL_account_updateTheme.flags | 1;
            tLRPC$TL_account_updateTheme.flags = i;
            tLRPC$TL_account_updateTheme.title = string3;
            tLRPC$TL_account_updateTheme.flags = i | 2;
            final int iSendRequest = ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_updateTheme, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ThemeSetUrlActivity$0ZjO-1l4d-q18ZXI19FJcGB5PmA
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$saveTheme$12$ThemeSetUrlActivity(tLRPC$TL_account_updateTheme, tLObject, tLRPC$TL_error);
                }
            }, 2);
            ConnectionsManager.getInstance(this.currentAccount).bindRequestToGuid(iSendRequest, this.classGuid);
            this.progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.eitaa.ui.-$$Lambda$ThemeSetUrlActivity$9wwzwLYh_MtDVYMnWiN5hIbxuMk
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    this.f$0.lambda$saveTheme$13$ThemeSetUrlActivity(iSendRequest, dialogInterface);
                }
            });
            this.progressDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveTheme$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveTheme$12$ThemeSetUrlActivity(final TLRPC$TL_account_updateTheme tLRPC$TL_account_updateTheme, TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject instanceof TLRPC$TL_theme) {
            final TLRPC$TL_theme tLRPC$TL_theme = (TLRPC$TL_theme) tLObject;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ThemeSetUrlActivity$5P-fJR7Z1rmCykg-XE-imnpuWis
                @Override // java.lang.Runnable
                public final void run() throws JSONException {
                    this.f$0.lambda$saveTheme$10$ThemeSetUrlActivity(tLRPC$TL_theme);
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ThemeSetUrlActivity$APrvaroYGqwdMCsVAYLNA1e62io
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$saveTheme$11$ThemeSetUrlActivity(tLRPC$TL_error, tLRPC$TL_account_updateTheme);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveTheme$10, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveTheme$10$ThemeSetUrlActivity(TLRPC$TL_theme tLRPC$TL_theme) throws JSONException {
        try {
            this.progressDialog.dismiss();
            this.progressDialog = null;
        } catch (Exception e) {
            FileLog.e(e);
        }
        Theme.setThemeUploadInfo(this.themeInfo, this.themeAccent, tLRPC$TL_theme, this.currentAccount, false);
        finishFragment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveTheme$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveTheme$11$ThemeSetUrlActivity(TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_account_updateTheme tLRPC$TL_account_updateTheme) {
        try {
            this.progressDialog.dismiss();
            this.progressDialog = null;
        } catch (Exception e) {
            FileLog.e(e);
        }
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, this, tLRPC$TL_account_updateTheme, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$saveTheme$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$saveTheme$13$ThemeSetUrlActivity(int i, DialogInterface dialogInterface) {
        ConnectionsManager.getInstance(this.currentAccount).cancelRequest(i, true);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        if (!isOpen || this.creatingNewTheme) {
            return;
        }
        this.linkField.requestFocus();
        AndroidUtilities.showKeyboard(this.linkField);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.linearLayoutTypeContainer, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.headerCell, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        arrayList.add(new ThemeDescription(this.createInfoCell, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.createInfoCell, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.helpInfoCell, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.helpInfoCell, 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
        arrayList.add(new ThemeDescription(this.checkInfoCell, ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        arrayList.add(new ThemeDescription(this.checkInfoCell, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteRedText4"));
        arrayList.add(new ThemeDescription(this.checkInfoCell, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText8"));
        arrayList.add(new ThemeDescription(this.checkInfoCell, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGreenText"));
        arrayList.add(new ThemeDescription(this.createCell, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.createCell, ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.createCell, ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.linkField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.linkField, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
        arrayList.add(new ThemeDescription(this.linkField, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputField"));
        arrayList.add(new ThemeDescription(this.linkField, ThemeDescription.FLAG_DRAWABLESELECTEDSTATE | ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, "windowBackgroundWhiteInputFieldActivated"));
        arrayList.add(new ThemeDescription(this.linkField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.linkField, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
        arrayList.add(new ThemeDescription(this.linkField, ThemeDescription.FLAG_CURSORCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.nameField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.nameField, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
        arrayList.add(new ThemeDescription(this.nameField, ThemeDescription.FLAG_CURSORCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.editText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.editText, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
        arrayList.add(new ThemeDescription(this.divider, 0, null, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.divider, ThemeDescription.FLAG_BACKGROUND, null, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, new Drawable[]{Theme.chat_msgInDrawable, Theme.chat_msgInMediaDrawable}, null, "chat_inBubble"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, new Drawable[]{Theme.chat_msgInSelectedDrawable, Theme.chat_msgInMediaSelectedDrawable}, null, "chat_inBubbleSelected"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, Theme.chat_msgInDrawable.getShadowDrawables(), null, "chat_inBubbleShadow"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, Theme.chat_msgInMediaDrawable.getShadowDrawables(), null, "chat_inBubbleShadow"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, new Drawable[]{Theme.chat_msgOutDrawable, Theme.chat_msgOutMediaDrawable}, null, "chat_outBubble"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, new Drawable[]{Theme.chat_msgOutDrawable, Theme.chat_msgOutMediaDrawable}, null, "chat_outBubbleGradient"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, new Drawable[]{Theme.chat_msgOutDrawable, Theme.chat_msgOutMediaDrawable}, null, "chat_outBubbleGradient2"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, new Drawable[]{Theme.chat_msgOutDrawable, Theme.chat_msgOutMediaDrawable}, null, "chat_outBubbleGradient3"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, new Drawable[]{Theme.chat_msgOutSelectedDrawable, Theme.chat_msgOutMediaSelectedDrawable}, null, "chat_outBubbleSelected"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, Theme.chat_msgOutDrawable.getShadowDrawables(), null, "chat_outBubbleShadow"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, Theme.chat_msgOutMediaDrawable.getShadowDrawables(), null, "chat_outBubbleShadow"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, null, null, "chat_messageTextIn"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, null, null, "chat_messageTextOut"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, new Drawable[]{Theme.chat_msgOutCheckDrawable}, null, "chat_outSentCheck"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, new Drawable[]{Theme.chat_msgOutCheckSelectedDrawable}, null, "chat_outSentCheckSelected"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, new Drawable[]{Theme.chat_msgOutCheckReadDrawable, Theme.chat_msgOutHalfCheckDrawable}, null, "chat_outSentCheckRead"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, new Drawable[]{Theme.chat_msgOutCheckReadSelectedDrawable, Theme.chat_msgOutHalfCheckSelectedDrawable}, null, "chat_outSentCheckReadSelected"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, new Drawable[]{Theme.chat_msgMediaCheckDrawable, Theme.chat_msgMediaHalfCheckDrawable}, null, "chat_mediaSentCheck"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, null, null, "chat_inReplyLine"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, null, null, "chat_outReplyLine"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, null, null, "chat_inReplyNameText"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, null, null, "chat_outReplyNameText"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, null, null, "chat_inReplyMessageText"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, null, null, "chat_outReplyMessageText"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, null, null, "chat_inReplyMediaMessageSelectedText"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, null, null, "chat_outReplyMediaMessageSelectedText"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, null, null, "chat_inTimeText"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, null, null, "chat_outTimeText"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, null, null, "chat_inTimeSelectedText"));
        arrayList.add(new ThemeDescription(this.messagesCell, 0, null, null, null, null, "chat_outTimeSelectedText"));
        return arrayList;
    }
}
