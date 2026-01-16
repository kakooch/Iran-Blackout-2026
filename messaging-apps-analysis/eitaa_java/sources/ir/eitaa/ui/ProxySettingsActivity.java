package ir.eitaa.ui;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.RadioCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Components.CubicBezierInterpolator;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.LayoutHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ProxySettingsActivity extends BaseFragment {
    private boolean addingNewProxy;
    private TextInfoPrivacyCell[] bottomCells;
    private ClipboardManager.OnPrimaryClipChangedListener clipChangedListener;
    private ClipboardManager clipboardManager;
    private SharedConfig.ProxyInfo currentProxyInfo;
    private int currentType;
    private ActionBarMenuItem doneItem;
    private HeaderCell headerCell;
    private boolean ignoreOnTextChange;
    private EditTextBoldCursor[] inputFields;
    private LinearLayout inputFieldsContainer;
    private LinearLayout linearLayout2;
    private TextSettingsCell pasteCell;
    private String[] pasteFields;
    private String pasteString;
    private int pasteType;
    private ScrollView scrollView;
    private ShadowSectionCell[] sectionCell;
    private TextSettingsCell shareCell;
    private ValueAnimator shareDoneAnimator;
    private boolean shareDoneEnabled;
    private float shareDoneProgress;
    private float[] shareDoneProgressAnimValues;
    private RadioCell[] typeCell;

    public ProxySettingsActivity() {
        this.sectionCell = new ShadowSectionCell[3];
        this.bottomCells = new TextInfoPrivacyCell[2];
        this.typeCell = new RadioCell[2];
        this.currentType = -1;
        this.pasteType = -1;
        this.shareDoneProgress = 1.0f;
        this.shareDoneProgressAnimValues = new float[2];
        this.shareDoneEnabled = true;
        this.clipChangedListener = new ClipboardManager.OnPrimaryClipChangedListener() { // from class: ir.eitaa.ui.-$$Lambda$ProxySettingsActivity$_VOYy2PB2GjSe2sERe9r1UerRXw
            @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
            public final void onPrimaryClipChanged() {
                this.f$0.updatePasteCell();
            }
        };
        this.currentProxyInfo = new SharedConfig.ProxyInfo("", 1080, "", "", "");
        this.addingNewProxy = true;
    }

    public ProxySettingsActivity(SharedConfig.ProxyInfo proxyInfo) {
        this.sectionCell = new ShadowSectionCell[3];
        this.bottomCells = new TextInfoPrivacyCell[2];
        this.typeCell = new RadioCell[2];
        this.currentType = -1;
        this.pasteType = -1;
        this.shareDoneProgress = 1.0f;
        this.shareDoneProgressAnimValues = new float[2];
        this.shareDoneEnabled = true;
        this.clipChangedListener = new ClipboardManager.OnPrimaryClipChangedListener() { // from class: ir.eitaa.ui.-$$Lambda$ProxySettingsActivity$_VOYy2PB2GjSe2sERe9r1UerRXw
            @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
            public final void onPrimaryClipChanged() {
                this.f$0.updatePasteCell();
            }
        };
        this.currentProxyInfo = proxyInfo;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
        this.clipboardManager.addPrimaryClipChangedListener(this.clipChangedListener);
        updatePasteCell();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onPause() {
        super.onPause();
        this.clipboardManager.removePrimaryClipChangedListener(this.clipChangedListener);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public View createView(Context context) throws NoSuchFieldException {
        this.actionBar.setTitle(LocaleController.getString("ProxyDetails", R.string.ProxyDetails));
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setAllowOverlayTitle(false);
        if (AndroidUtilities.isTablet()) {
            this.actionBar.setOccupyStatusBar(false);
        }
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: ir.eitaa.ui.ProxySettingsActivity.1
            @Override // ir.eitaa.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int id) {
                boolean z;
                if (id == -1) {
                    ProxySettingsActivity.this.finishFragment();
                    return;
                }
                if (id != 1 || ProxySettingsActivity.this.getParentActivity() == null) {
                    return;
                }
                ProxySettingsActivity.this.currentProxyInfo.address = ProxySettingsActivity.this.inputFields[0].getText().toString();
                ProxySettingsActivity.this.currentProxyInfo.port = Utilities.parseInt(ProxySettingsActivity.this.inputFields[1].getText().toString()).intValue();
                if (ProxySettingsActivity.this.currentType == 0) {
                    ProxySettingsActivity.this.currentProxyInfo.secret = "";
                    ProxySettingsActivity.this.currentProxyInfo.username = ProxySettingsActivity.this.inputFields[2].getText().toString();
                    ProxySettingsActivity.this.currentProxyInfo.password = ProxySettingsActivity.this.inputFields[3].getText().toString();
                } else {
                    ProxySettingsActivity.this.currentProxyInfo.secret = ProxySettingsActivity.this.inputFields[4].getText().toString();
                    ProxySettingsActivity.this.currentProxyInfo.username = "";
                    ProxySettingsActivity.this.currentProxyInfo.password = "";
                }
                SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
                SharedPreferences.Editor editorEdit = globalMainSettings.edit();
                if (ProxySettingsActivity.this.addingNewProxy) {
                    SharedConfig.addProxy(ProxySettingsActivity.this.currentProxyInfo);
                    SharedConfig.currentProxy = ProxySettingsActivity.this.currentProxyInfo;
                    editorEdit.putBoolean("proxy_enabled", true);
                    z = true;
                } else {
                    boolean z2 = globalMainSettings.getBoolean("proxy_enabled", false);
                    SharedConfig.saveProxyList();
                    z = z2;
                }
                if (ProxySettingsActivity.this.addingNewProxy || SharedConfig.currentProxy == ProxySettingsActivity.this.currentProxyInfo) {
                    editorEdit.putString("proxy_ip", ProxySettingsActivity.this.currentProxyInfo.address);
                    editorEdit.putString("proxy_pass", ProxySettingsActivity.this.currentProxyInfo.password);
                    editorEdit.putString("proxy_user", ProxySettingsActivity.this.currentProxyInfo.username);
                    editorEdit.putInt("proxy_port", ProxySettingsActivity.this.currentProxyInfo.port);
                    editorEdit.putString("proxy_secret", ProxySettingsActivity.this.currentProxyInfo.secret);
                    ConnectionsManager.setProxySettings(z, ProxySettingsActivity.this.currentProxyInfo.address, ProxySettingsActivity.this.currentProxyInfo.port, ProxySettingsActivity.this.currentProxyInfo.username, ProxySettingsActivity.this.currentProxyInfo.password, ProxySettingsActivity.this.currentProxyInfo.secret);
                }
                editorEdit.commit();
                NotificationCenter.getGlobalInstance().postNotificationName(NotificationCenter.proxySettingsChanged, new Object[0]);
                ProxySettingsActivity.this.finishFragment();
            }
        });
        ActionBarMenuItem actionBarMenuItemAddItemWithWidth = this.actionBar.createMenu().addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f));
        this.doneItem = actionBarMenuItemAddItemWithWidth;
        actionBarMenuItemAddItemWithWidth.setContentDescription(LocaleController.getString("Done", R.string.Done));
        FrameLayout frameLayout = new FrameLayout(context);
        this.fragmentView = frameLayout;
        FrameLayout frameLayout2 = frameLayout;
        frameLayout.setBackgroundColor(Theme.getColor("windowBackgroundGray"));
        ScrollView scrollView = new ScrollView(context);
        this.scrollView = scrollView;
        scrollView.setFillViewport(true);
        AndroidUtilities.setScrollViewEdgeEffectColor(this.scrollView, Theme.getColor("actionBarDefault"));
        frameLayout2.addView(this.scrollView, LayoutHelper.createFrame(-1, -1.0f));
        LinearLayout linearLayout = new LinearLayout(context);
        this.linearLayout2 = linearLayout;
        linearLayout.setOrientation(1);
        this.scrollView.addView(this.linearLayout2, new FrameLayout.LayoutParams(-1, -2));
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProxySettingsActivity$UC4T4RSTvuUtg5y8YK-FyVNxgZ4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$0$ProxySettingsActivity(view);
            }
        };
        int i = 0;
        while (i < 2) {
            this.typeCell[i] = new RadioCell(context);
            this.typeCell[i].setBackground(Theme.getSelectorDrawable(true));
            this.typeCell[i].setTag(Integer.valueOf(i));
            if (i == 0) {
                this.typeCell[i].setText(LocaleController.getString("UseProxySocks5", R.string.UseProxySocks5), i == this.currentType, true);
            } else {
                this.typeCell[i].setText(LocaleController.getString("UseProxyEitaa ", R.string.UseProxyEitaa), i == this.currentType, false);
            }
            this.linearLayout2.addView(this.typeCell[i], LayoutHelper.createLinear(-1, 50));
            this.typeCell[i].setOnClickListener(onClickListener);
            i++;
        }
        this.sectionCell[0] = new ShadowSectionCell(context);
        this.linearLayout2.addView(this.sectionCell[0], LayoutHelper.createLinear(-1, -2));
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.inputFieldsContainer = linearLayout2;
        linearLayout2.setOrientation(1);
        this.inputFieldsContainer.setBackgroundColor(Theme.getColor("windowBackgroundWhite"));
        if (Build.VERSION.SDK_INT >= 21) {
            this.inputFieldsContainer.setElevation(AndroidUtilities.dp(1.0f));
            this.inputFieldsContainer.setOutlineProvider(null);
        }
        this.linearLayout2.addView(this.inputFieldsContainer, LayoutHelper.createLinear(-1, -2));
        this.inputFields = new EditTextBoldCursor[5];
        int i2 = 0;
        for (int i3 = 5; i2 < i3; i3 = 5) {
            FrameLayout frameLayout3 = new FrameLayout(context);
            this.inputFieldsContainer.addView(frameLayout3, LayoutHelper.createLinear(-1, 64));
            this.inputFields[i2] = new EditTextBoldCursor(context);
            this.inputFields[i2].setTag(Integer.valueOf(i2));
            this.inputFields[i2].setTextSize(1, 16.0f);
            this.inputFields[i2].setHintColor(Theme.getColor("windowBackgroundWhiteHintText"));
            this.inputFields[i2].setTextColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.inputFields[i2].setBackground(null);
            this.inputFields[i2].setCursorColor(Theme.getColor("windowBackgroundWhiteBlackText"));
            this.inputFields[i2].setCursorSize(AndroidUtilities.dp(20.0f));
            this.inputFields[i2].setCursorWidth(1.5f);
            this.inputFields[i2].setSingleLine(true);
            this.inputFields[i2].setGravity((LocaleController.isRTL ? 5 : 3) | 16);
            this.inputFields[i2].setHeaderHintColor(Theme.getColor("windowBackgroundWhiteBlueHeader"));
            this.inputFields[i2].setTransformHintToHeader(true);
            this.inputFields[i2].setLineColors(Theme.getColor("windowBackgroundWhiteInputField"), Theme.getColor("windowBackgroundWhiteInputFieldActivated"), Theme.getColor("windowBackgroundWhiteRedText3"));
            if (i2 == 0) {
                this.inputFields[i2].setInputType(524305);
                this.inputFields[i2].addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.ProxySettingsActivity.2
                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable s) {
                        ProxySettingsActivity.this.checkShareDone(true);
                    }
                });
            } else if (i2 == 1) {
                this.inputFields[i2].setInputType(2);
                this.inputFields[i2].addTextChangedListener(new TextWatcher() { // from class: ir.eitaa.ui.ProxySettingsActivity.3
                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable s) {
                        if (ProxySettingsActivity.this.ignoreOnTextChange) {
                            return;
                        }
                        EditTextBoldCursor editTextBoldCursor = ProxySettingsActivity.this.inputFields[1];
                        int selectionStart = editTextBoldCursor.getSelectionStart();
                        String string = editTextBoldCursor.getText().toString();
                        StringBuilder sb = new StringBuilder(string.length());
                        int i4 = 0;
                        while (i4 < string.length()) {
                            int i5 = i4 + 1;
                            String strSubstring = string.substring(i4, i5);
                            if ("0123456789".contains(strSubstring)) {
                                sb.append(strSubstring);
                            }
                            i4 = i5;
                        }
                        ProxySettingsActivity.this.ignoreOnTextChange = true;
                        int iIntValue = Utilities.parseInt(sb.toString()).intValue();
                        if (iIntValue < 0 || iIntValue > 65535 || !string.equals(sb.toString())) {
                            if (iIntValue < 0) {
                                editTextBoldCursor.setText("0");
                            } else if (iIntValue > 65535) {
                                editTextBoldCursor.setText("65535");
                            } else {
                                editTextBoldCursor.setText(sb.toString());
                            }
                        } else if (selectionStart >= 0) {
                            editTextBoldCursor.setSelection(Math.min(selectionStart, editTextBoldCursor.length()));
                        }
                        ProxySettingsActivity.this.ignoreOnTextChange = false;
                        ProxySettingsActivity.this.checkShareDone(true);
                    }
                });
            } else if (i2 == 3) {
                this.inputFields[i2].setInputType(129);
                this.inputFields[i2].setTypeface(Typeface.DEFAULT);
                this.inputFields[i2].setTransformationMethod(PasswordTransformationMethod.getInstance());
            } else {
                this.inputFields[i2].setInputType(524289);
            }
            this.inputFields[i2].setImeOptions(268435461);
            if (i2 == 0) {
                this.inputFields[i2].setHintText(LocaleController.getString("UseProxyAddress", R.string.UseProxyAddress));
                this.inputFields[i2].setText(this.currentProxyInfo.address);
            } else if (i2 == 1) {
                this.inputFields[i2].setHintText(LocaleController.getString("UseProxyPort", R.string.UseProxyPort));
                this.inputFields[i2].setText("" + this.currentProxyInfo.port);
            } else if (i2 == 2) {
                this.inputFields[i2].setHintText(LocaleController.getString("UseProxyUsername", R.string.UseProxyUsername));
                this.inputFields[i2].setText(this.currentProxyInfo.username);
            } else if (i2 == 3) {
                this.inputFields[i2].setHintText(LocaleController.getString("UseProxyPassword", R.string.UseProxyPassword));
                this.inputFields[i2].setText(this.currentProxyInfo.password);
            } else if (i2 == 4) {
                this.inputFields[i2].setHintText(LocaleController.getString("UseProxySecret", R.string.UseProxySecret));
                this.inputFields[i2].setText(this.currentProxyInfo.secret);
            }
            EditTextBoldCursor[] editTextBoldCursorArr = this.inputFields;
            editTextBoldCursorArr[i2].setSelection(editTextBoldCursorArr[i2].length());
            this.inputFields[i2].setPadding(0, 0, 0, 0);
            frameLayout3.addView(this.inputFields[i2], LayoutHelper.createFrame(-1, -1.0f, 51, 17.0f, i2 == 0 ? 12.0f : 0.0f, 17.0f, 0.0f));
            this.inputFields[i2].setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ir.eitaa.ui.-$$Lambda$ProxySettingsActivity$oFWHu7Mm4KtmunvMEVjbVo7Lr0c
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
                    return this.f$0.lambda$createView$1$ProxySettingsActivity(textView, i4, keyEvent);
                }
            });
            i2++;
        }
        for (int i4 = 0; i4 < 2; i4++) {
            this.bottomCells[i4] = new TextInfoPrivacyCell(context);
            this.bottomCells[i4].setBackground(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
            if (i4 == 0) {
                this.bottomCells[i4].setText(LocaleController.getString("UseProxyInfo", R.string.UseProxyInfo));
            } else {
                this.bottomCells[i4].setText(LocaleController.getString("UseProxyEitaaInfo", R.string.UseProxyEitaaInfo) + "\n\n" + LocaleController.getString("UseProxyEitaaInfo2", R.string.UseProxyEitaaInfo2));
                this.bottomCells[i4].setVisibility(8);
            }
            this.linearLayout2.addView(this.bottomCells[i4], LayoutHelper.createLinear(-1, -2));
        }
        TextSettingsCell textSettingsCell = new TextSettingsCell(this.fragmentView.getContext());
        this.pasteCell = textSettingsCell;
        textSettingsCell.setBackground(Theme.getSelectorDrawable(true));
        this.pasteCell.setText(LocaleController.getString("PasteFromClipboard", R.string.PasteFromClipboard), false);
        this.pasteCell.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText4"));
        this.pasteCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProxySettingsActivity$OanL-rxJEhF1FJGuJEEGppUzRF8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$3$ProxySettingsActivity(view);
            }
        });
        this.linearLayout2.addView(this.pasteCell, 0, LayoutHelper.createLinear(-1, -2));
        this.pasteCell.setVisibility(8);
        this.sectionCell[2] = new ShadowSectionCell(this.fragmentView.getContext());
        this.sectionCell[2].setBackground(Theme.getThemedDrawable(this.fragmentView.getContext(), R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
        this.linearLayout2.addView(this.sectionCell[2], 1, LayoutHelper.createLinear(-1, -2));
        this.sectionCell[2].setVisibility(8);
        TextSettingsCell textSettingsCell2 = new TextSettingsCell(context);
        this.shareCell = textSettingsCell2;
        textSettingsCell2.setBackgroundDrawable(Theme.getSelectorDrawable(true));
        this.shareCell.setText(LocaleController.getString("ShareFile", R.string.ShareFile), false);
        this.shareCell.setTextColor(Theme.getColor("windowBackgroundWhiteBlueText4"));
        this.linearLayout2.addView(this.shareCell, LayoutHelper.createLinear(-1, -2));
        this.shareCell.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$ProxySettingsActivity$gph9iA7qft2FvOWrX0mpCANofOU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$createView$4$ProxySettingsActivity(view);
            }
        });
        this.sectionCell[1] = new ShadowSectionCell(context);
        this.sectionCell[1].setBackgroundDrawable(Theme.getThemedDrawable(context, R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
        this.linearLayout2.addView(this.sectionCell[1], LayoutHelper.createLinear(-1, -2));
        this.clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        this.shareDoneEnabled = true;
        this.shareDoneProgress = 1.0f;
        checkShareDone(false);
        this.currentType = -1;
        setProxyType(!TextUtils.isEmpty(this.currentProxyInfo.secret) ? 1 : 0, false);
        this.pasteType = -1;
        this.pasteString = null;
        updatePasteCell();
        return this.fragmentView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$ProxySettingsActivity(View view) {
        setProxyType(((Integer) view.getTag()).intValue(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$1$ProxySettingsActivity(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5) {
            if (i != 6) {
                return false;
            }
            finishFragment();
            return true;
        }
        int iIntValue = ((Integer) textView.getTag()).intValue() + 1;
        EditTextBoldCursor[] editTextBoldCursorArr = this.inputFields;
        if (iIntValue < editTextBoldCursorArr.length) {
            editTextBoldCursorArr[iIntValue].requestFocus();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$ProxySettingsActivity(View view) {
        if (this.pasteType == -1) {
            return;
        }
        int i = 0;
        while (true) {
            String[] strArr = this.pasteFields;
            if (i < strArr.length) {
                int i2 = this.pasteType;
                if ((i2 != 0 || i != 4) && (i2 != 1 || (i != 2 && i != 3))) {
                    if (strArr[i] != null) {
                        try {
                            this.inputFields[i].setText(URLDecoder.decode(strArr[i], "UTF-8"));
                        } catch (UnsupportedEncodingException unused) {
                            this.inputFields[i].setText(this.pasteFields[i]);
                        }
                    } else {
                        this.inputFields[i].setText((CharSequence) null);
                    }
                }
                i++;
            } else {
                EditTextBoldCursor[] editTextBoldCursorArr = this.inputFields;
                editTextBoldCursorArr[0].setSelection(editTextBoldCursorArr[0].length());
                setProxyType(this.pasteType, true, new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$ProxySettingsActivity$HehzgK-XNc4uz6q063HgUwOlPyg
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$createView$2$ProxySettingsActivity();
                    }
                });
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$2$ProxySettingsActivity() {
        AndroidUtilities.hideKeyboard(this.inputFieldsContainer.findFocus());
        for (int i = 0; i < this.pasteFields.length; i++) {
            int i2 = this.pasteType;
            if ((i2 != 0 || i == 4) && (i2 != 1 || i == 2 || i == 3)) {
                this.inputFields[i].setText((CharSequence) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$ProxySettingsActivity(View view) {
        String str;
        StringBuilder sb = new StringBuilder();
        String string = this.inputFields[0].getText().toString();
        String string2 = this.inputFields[3].getText().toString();
        String string3 = this.inputFields[2].getText().toString();
        String string4 = this.inputFields[1].getText().toString();
        String string5 = this.inputFields[4].getText().toString();
        try {
            if (!TextUtils.isEmpty(string)) {
                sb.append("server=");
                sb.append(URLEncoder.encode(string, "UTF-8"));
            }
            if (!TextUtils.isEmpty(string4)) {
                if (sb.length() != 0) {
                    sb.append("&");
                }
                sb.append("port=");
                sb.append(URLEncoder.encode(string4, "UTF-8"));
            }
            if (this.currentType == 1) {
                str = "https://eitaa.com/proxy?";
                if (sb.length() != 0) {
                    sb.append("&");
                }
                sb.append("secret=");
                sb.append(URLEncoder.encode(string5, "UTF-8"));
            } else {
                str = "https://eitaa.com/socks?";
                if (!TextUtils.isEmpty(string3)) {
                    if (sb.length() != 0) {
                        sb.append("&");
                    }
                    sb.append("user=");
                    sb.append(URLEncoder.encode(string3, "UTF-8"));
                }
                if (!TextUtils.isEmpty(string2)) {
                    if (sb.length() != 0) {
                        sb.append("&");
                    }
                    sb.append("pass=");
                    sb.append(URLEncoder.encode(string2, "UTF-8"));
                }
            }
            if (sb.length() == 0) {
                return;
            }
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", str + sb.toString());
            Intent intentCreateChooser = Intent.createChooser(intent, LocaleController.getString("ShareLink", R.string.ShareLink));
            intentCreateChooser.setFlags(268435456);
            getParentActivity().startActivity(intentCreateChooser);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updatePasteCell() {
        /*
            Method dump skipped, instructions count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.ProxySettingsActivity.updatePasteCell():void");
    }

    private void setShareDoneEnabled(boolean enabled, boolean animated) {
        if (this.shareDoneEnabled != enabled) {
            ValueAnimator valueAnimator = this.shareDoneAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            } else if (animated) {
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                this.shareDoneAnimator = valueAnimatorOfFloat;
                valueAnimatorOfFloat.setDuration(200L);
                this.shareDoneAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ir.eitaa.ui.-$$Lambda$ProxySettingsActivity$8GqFD-bsN-pfWbBmrplH4OJO3ps
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                        this.f$0.lambda$setShareDoneEnabled$5$ProxySettingsActivity(valueAnimator2);
                    }
                });
            }
            if (animated) {
                float[] fArr = this.shareDoneProgressAnimValues;
                fArr[0] = this.shareDoneProgress;
                fArr[1] = enabled ? 1.0f : 0.0f;
                this.shareDoneAnimator.start();
            } else {
                this.shareDoneProgress = enabled ? 1.0f : 0.0f;
                this.shareCell.setTextColor(Theme.getColor(enabled ? "windowBackgroundWhiteBlueText4" : "windowBackgroundWhiteGrayText2"));
                this.doneItem.setAlpha(enabled ? 1.0f : 0.5f);
            }
            this.shareCell.setEnabled(enabled);
            this.doneItem.setEnabled(enabled);
            this.shareDoneEnabled = enabled;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$setShareDoneEnabled$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$setShareDoneEnabled$5$ProxySettingsActivity(ValueAnimator valueAnimator) {
        this.shareDoneProgress = AndroidUtilities.lerp(this.shareDoneProgressAnimValues, valueAnimator.getAnimatedFraction());
        this.shareCell.setTextColor(ColorUtils.blendARGB(Theme.getColor("windowBackgroundWhiteGrayText2"), Theme.getColor("windowBackgroundWhiteBlueText4"), this.shareDoneProgress));
        this.doneItem.setAlpha((this.shareDoneProgress / 2.0f) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkShareDone(boolean animated) {
        if (this.shareCell == null || this.doneItem == null) {
            return;
        }
        EditTextBoldCursor[] editTextBoldCursorArr = this.inputFields;
        boolean z = false;
        if (editTextBoldCursorArr[0] == null || editTextBoldCursorArr[1] == null) {
            return;
        }
        if (editTextBoldCursorArr[0].length() != 0 && Utilities.parseInt(this.inputFields[1].getText().toString()).intValue() != 0) {
            z = true;
        }
        setShareDoneEnabled(z, animated);
    }

    private void setProxyType(int type, boolean animated) {
        setProxyType(type, animated, null);
    }

    private void setProxyType(int type, boolean animated, final Runnable onTransitionEnd) {
        if (this.currentType != type) {
            this.currentType = type;
            int i = Build.VERSION.SDK_INT;
            if (i >= 23) {
                TransitionManager.endTransitions(this.linearLayout2);
            }
            if (animated && i >= 21) {
                TransitionSet duration = new TransitionSet().addTransition(new Fade(2)).addTransition(new ChangeBounds()).addTransition(new Fade(1)).setInterpolator((TimeInterpolator) CubicBezierInterpolator.DEFAULT).setDuration(250L);
                if (onTransitionEnd != null) {
                    duration.addListener(new Transition.TransitionListener() { // from class: ir.eitaa.ui.ProxySettingsActivity.4
                        @Override // android.transition.Transition.TransitionListener
                        public void onTransitionCancel(Transition transition) {
                        }

                        @Override // android.transition.Transition.TransitionListener
                        public void onTransitionPause(Transition transition) {
                        }

                        @Override // android.transition.Transition.TransitionListener
                        public void onTransitionResume(Transition transition) {
                        }

                        @Override // android.transition.Transition.TransitionListener
                        public void onTransitionStart(Transition transition) {
                        }

                        @Override // android.transition.Transition.TransitionListener
                        public void onTransitionEnd(Transition transition) {
                            onTransitionEnd.run();
                        }
                    });
                }
                TransitionManager.beginDelayedTransition(this.linearLayout2, duration);
            }
            int i2 = this.currentType;
            if (i2 == 0) {
                this.bottomCells[0].setVisibility(0);
                this.bottomCells[1].setVisibility(8);
                ((View) this.inputFields[4].getParent()).setVisibility(8);
                ((View) this.inputFields[3].getParent()).setVisibility(0);
                ((View) this.inputFields[2].getParent()).setVisibility(0);
            } else if (i2 == 1) {
                this.bottomCells[0].setVisibility(8);
                this.bottomCells[1].setVisibility(0);
                ((View) this.inputFields[4].getParent()).setVisibility(0);
                ((View) this.inputFields[3].getParent()).setVisibility(8);
                ((View) this.inputFields[2].getParent()).setVisibility(8);
            }
            this.typeCell[0].setChecked(this.currentType == 0, animated);
            this.typeCell[1].setChecked(this.currentType == 1, animated);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        if (isOpen && !backward && this.addingNewProxy) {
            this.inputFields[0].requestFocus();
            AndroidUtilities.showKeyboard(this.inputFields[0]);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: ir.eitaa.ui.-$$Lambda$ProxySettingsActivity$XUyAInOwOsUfkxGH-DL0ERWJfBg
            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$6$ProxySettingsActivity();
            }

            @Override // ir.eitaa.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public /* synthetic */ void onAnimationProgress(float f) {
                ThemeDescription.ThemeDescriptionDelegate.CC.$default$onAnimationProgress(this, f);
            }
        };
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.scrollView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCH, null, null, null, null, "actionBarDefaultSearch"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCHPLACEHOLDER, null, null, null, null, "actionBarDefaultSearchPlaceholder"));
        arrayList.add(new ThemeDescription(this.inputFieldsContainer, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.linearLayout2, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.shareCell, ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.shareCell, ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription((View) null, 0, (Class[]) null, (String[]) null, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, "windowBackgroundWhiteBlueText4"));
        arrayList.add(new ThemeDescription((View) null, 0, (Class[]) null, (String[]) null, (Paint[]) null, (Drawable[]) null, themeDescriptionDelegate, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.pasteCell, ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.pasteCell, ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, "listSelectorSDK21"));
        arrayList.add(new ThemeDescription(this.pasteCell, 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueText4"));
        for (int i = 0; i < this.typeCell.length; i++) {
            arrayList.add(new ThemeDescription(this.typeCell[i], ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, "windowBackgroundWhite"));
            arrayList.add(new ThemeDescription(this.typeCell[i], ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, "listSelectorSDK21"));
            arrayList.add(new ThemeDescription(this.typeCell[i], 0, new Class[]{RadioCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
            arrayList.add(new ThemeDescription(this.typeCell[i], ThemeDescription.FLAG_CHECKBOX, new Class[]{RadioCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "radioBackground"));
            arrayList.add(new ThemeDescription(this.typeCell[i], ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{RadioCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "radioBackgroundChecked"));
        }
        if (this.inputFields != null) {
            for (int i2 = 0; i2 < this.inputFields.length; i2++) {
                arrayList.add(new ThemeDescription(this.inputFields[i2], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                arrayList.add(new ThemeDescription(this.inputFields[i2], ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
                arrayList.add(new ThemeDescription(this.inputFields[i2], ThemeDescription.FLAG_HINTTEXTCOLOR | ThemeDescription.FLAG_PROGRESSBAR, null, null, null, null, "windowBackgroundWhiteBlueHeader"));
                arrayList.add(new ThemeDescription(this.inputFields[i2], ThemeDescription.FLAG_CURSORCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "windowBackgroundWhiteInputField"));
                arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "windowBackgroundWhiteInputFieldActivated"));
                arrayList.add(new ThemeDescription(null, 0, null, null, null, themeDescriptionDelegate, "windowBackgroundWhiteRedText3"));
            }
        } else {
            arrayList.add(new ThemeDescription(null, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
            arrayList.add(new ThemeDescription(null, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
        }
        arrayList.add(new ThemeDescription(this.headerCell, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.headerCell, 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        int i3 = 0;
        while (true) {
            ShadowSectionCell[] shadowSectionCellArr = this.sectionCell;
            if (i3 >= shadowSectionCellArr.length) {
                break;
            }
            if (shadowSectionCellArr[i3] != null) {
                arrayList.add(new ThemeDescription(this.sectionCell[i3], ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
            }
            i3++;
        }
        for (int i4 = 0; i4 < this.bottomCells.length; i4++) {
            arrayList.add(new ThemeDescription(this.bottomCells[i4], ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
            arrayList.add(new ThemeDescription(this.bottomCells[i4], 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
            arrayList.add(new ThemeDescription(this.bottomCells[i4], ThemeDescription.FLAG_LINKCOLOR, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteLinkText"));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$getThemeDescriptions$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$getThemeDescriptions$6$ProxySettingsActivity() {
        ValueAnimator valueAnimator;
        if (this.shareCell != null && ((valueAnimator = this.shareDoneAnimator) == null || !valueAnimator.isRunning())) {
            this.shareCell.setTextColor(Theme.getColor(this.shareDoneEnabled ? "windowBackgroundWhiteBlueText4" : "windowBackgroundWhiteGrayText2"));
        }
        if (this.inputFields == null) {
            return;
        }
        int i = 0;
        while (true) {
            EditTextBoldCursor[] editTextBoldCursorArr = this.inputFields;
            if (i >= editTextBoldCursorArr.length) {
                return;
            }
            editTextBoldCursorArr[i].setLineColors(Theme.getColor("windowBackgroundWhiteInputField"), Theme.getColor("windowBackgroundWhiteInputFieldActivated"), Theme.getColor("windowBackgroundWhiteRedText3"));
            i++;
        }
    }
}
