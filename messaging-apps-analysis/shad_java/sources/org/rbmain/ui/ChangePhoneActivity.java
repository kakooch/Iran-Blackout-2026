package org.rbmain.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidMessenger.proxy.ContactsProxy;
import com.facebook.stetho.websocket.CloseCodes;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import org.rbmain.PhoneFormat.PhoneFormat;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BuildVars;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.MessagesStorage;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$TL_account_changePhone;
import org.rbmain.tgnet.TLRPC$TL_account_sendChangePhoneCode;
import org.rbmain.tgnet.TLRPC$TL_auth_cancelCode;
import org.rbmain.tgnet.TLRPC$TL_auth_codeTypeCall;
import org.rbmain.tgnet.TLRPC$TL_auth_codeTypeFlashCall;
import org.rbmain.tgnet.TLRPC$TL_auth_codeTypeSms;
import org.rbmain.tgnet.TLRPC$TL_auth_resendCode;
import org.rbmain.tgnet.TLRPC$TL_auth_sentCode;
import org.rbmain.tgnet.TLRPC$TL_auth_sentCodeTypeApp;
import org.rbmain.tgnet.TLRPC$TL_auth_sentCodeTypeCall;
import org.rbmain.tgnet.TLRPC$TL_auth_sentCodeTypeFlashCall;
import org.rbmain.tgnet.TLRPC$TL_auth_sentCodeTypeSms;
import org.rbmain.tgnet.TLRPC$TL_codeSettings;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$auth_CodeType;
import org.rbmain.tgnet.TLRPC$auth_SentCodeType;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.ChangePhoneActivity;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.HintEditText;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RLottieDrawable;
import org.rbmain.ui.Components.RLottieImageView;
import org.rbmain.ui.Components.SlideView;
import org.rbmain.ui.CountrySelectActivity;
import org.rbmain.ui.LoginActivityAppp;

/* loaded from: classes4.dex */
public class ChangePhoneActivity extends BaseFragment {
    private View doneButton;
    private Dialog permissionsDialog;
    private AlertDialog progressDialog;
    private int scrollHeight;
    private int currentViewNum = 0;
    private SlideView[] views = new SlideView[5];
    private ArrayList<String> permissionsItems = new ArrayList<>();
    private boolean checkPermissions = false;

    private class ProgressView extends View {
        private Paint paint;
        private Paint paint2;
        private float progress;

        public ProgressView(ChangePhoneActivity changePhoneActivity, Context context) {
            super(context);
            this.paint = new Paint();
            this.paint2 = new Paint();
            this.paint.setColor(Theme.getColor(Theme.key_login_progressInner));
            this.paint2.setColor(Theme.getColor(Theme.key_login_progressOuter));
        }

        public void setProgress(float f) {
            this.progress = f;
            invalidate();
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            float measuredWidth = (int) (getMeasuredWidth() * this.progress);
            canvas.drawRect(0.0f, 0.0f, measuredWidth, getMeasuredHeight(), this.paint2);
            canvas.drawRect(measuredWidth, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.paint);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        super.onFragmentDestroy();
        int i = 0;
        while (true) {
            SlideView[] slideViewArr = this.views;
            if (i >= slideViewArr.length) {
                break;
            }
            if (slideViewArr[i] != null) {
                slideViewArr[i].onDestroyActivity();
            }
            i++;
        }
        AlertDialog alertDialog = this.progressDialog;
        if (alertDialog != null) {
            try {
                alertDialog.dismiss();
            } catch (Exception e) {
                FileLog.e(e);
            }
            this.progressDialog = null;
        }
        AndroidUtilities.removeAdjustResize(getParentActivity(), this.classGuid);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public View createView(Context context) {
        this.actionBar.setTitle(LocaleController.getString("AppName", R.string.AppName));
        this.actionBar.setBackButtonImage(R.drawable.ic_ab_back);
        this.actionBar.setActionBarMenuOnItemClick(new ActionBar.ActionBarMenuOnItemClick() { // from class: org.rbmain.ui.ChangePhoneActivity.1
            @Override // org.rbmain.ui.ActionBar.ActionBar.ActionBarMenuOnItemClick
            public void onItemClick(int i) {
                if (i == 1) {
                    ChangePhoneActivity.this.views[ChangePhoneActivity.this.currentViewNum].onNextPressed();
                } else if (i == -1) {
                    ChangePhoneActivity.this.finishFragment();
                }
            }
        });
        this.doneButton = this.actionBar.createMenu().addItemWithWidth(1, R.drawable.ic_done, AndroidUtilities.dp(56.0f), LocaleController.getString("Done", R.string.Done));
        ScrollView scrollView = new ScrollView(context) { // from class: org.rbmain.ui.ChangePhoneActivity.2
            @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
            public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
                if (ChangePhoneActivity.this.currentViewNum == 1 || ChangePhoneActivity.this.currentViewNum == 2 || ChangePhoneActivity.this.currentViewNum == 4) {
                    rect.bottom += AndroidUtilities.dp(40.0f);
                }
                return super.requestChildRectangleOnScreen(view, rect, z);
            }

            @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
            protected void onMeasure(int i, int i2) {
                ChangePhoneActivity.this.scrollHeight = View.MeasureSpec.getSize(i2) - AndroidUtilities.dp(30.0f);
                super.onMeasure(i, i2);
            }
        };
        scrollView.setFillViewport(true);
        this.fragmentView = scrollView;
        FrameLayout frameLayout = new FrameLayout(context);
        scrollView.addView(frameLayout, LayoutHelper.createScroll(-1, -2, 51));
        this.views[0] = new PhoneView(context);
        this.views[1] = new LoginActivitySmsView(context, 1);
        this.views[2] = new LoginActivitySmsView(context, 2);
        this.views[3] = new LoginActivitySmsView(context, 3);
        this.views[4] = new LoginActivitySmsView(context, 4);
        int i = 0;
        while (true) {
            SlideView[] slideViewArr = this.views;
            if (i < slideViewArr.length) {
                slideViewArr[i].setVisibility(i == 0 ? 0 : 8);
                frameLayout.addView(this.views[i], LayoutHelper.createFrame(-1, i == 0 ? -2.0f : -1.0f, 51, AndroidUtilities.isTablet() ? 26.0f : 18.0f, 30.0f, AndroidUtilities.isTablet() ? 26.0f : 18.0f, 0.0f));
                i++;
            } else {
                this.actionBar.setTitle(slideViewArr[0].getHeaderName());
                return this.fragmentView;
            }
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onRequestPermissionsResultFragment(int i, String[] strArr, int[] iArr) {
        if (i == 6) {
            this.checkPermissions = false;
            int i2 = this.currentViewNum;
            if (i2 == 0) {
                this.views[i2].onNextPressed();
            }
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onDialogDismiss(Dialog dialog) {
        if (Build.VERSION.SDK_INT < 23 || dialog != this.permissionsDialog || this.permissionsItems.isEmpty()) {
            return;
        }
        getParentActivity().requestPermissions((String[]) this.permissionsItems.toArray(new String[0]), 6);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        int i = this.currentViewNum;
        int i2 = 0;
        if (i != 0) {
            if (this.views[i].onBackPressed(false)) {
                setPage(0, true, null, true);
            }
            return false;
        }
        while (true) {
            SlideView[] slideViewArr = this.views;
            if (i2 >= slideViewArr.length) {
                return true;
            }
            if (slideViewArr[i2] != null) {
                slideViewArr[i2].onDestroyActivity();
            }
            i2++;
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onTransitionAnimationEnd(boolean z, boolean z2) {
        if (z) {
            this.views[this.currentViewNum].onShow();
        }
    }

    public void needShowProgress() {
        if (getParentActivity() == null || getParentActivity().isFinishing() || this.progressDialog != null) {
            return;
        }
        AlertDialog alertDialog = new AlertDialog(getParentActivity(), 3);
        this.progressDialog = alertDialog;
        alertDialog.setCanCancel(false);
        this.progressDialog.show();
    }

    public void needHideProgress() {
        AlertDialog alertDialog = this.progressDialog;
        if (alertDialog == null) {
            return;
        }
        try {
            alertDialog.dismiss();
        } catch (Exception e) {
            FileLog.e(e);
        }
        this.progressDialog = null;
    }

    public void setPage(int i, boolean z, Bundle bundle, boolean z2) {
        if (i == 3) {
            this.doneButton.setVisibility(8);
        } else {
            if (i == 0) {
                this.checkPermissions = true;
            }
            this.doneButton.setVisibility(0);
        }
        SlideView[] slideViewArr = this.views;
        final SlideView slideView = slideViewArr[this.currentViewNum];
        final SlideView slideView2 = slideViewArr[i];
        this.currentViewNum = i;
        slideView2.setParams(bundle, false);
        this.actionBar.setTitle(slideView2.getHeaderName());
        slideView2.onShow();
        int i2 = AndroidUtilities.displaySize.x;
        if (z2) {
            i2 = -i2;
        }
        slideView2.setX(i2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.setDuration(300L);
        Animator[] animatorArr = new Animator[2];
        float[] fArr = new float[1];
        fArr[0] = z2 ? AndroidUtilities.displaySize.x : -AndroidUtilities.displaySize.x;
        animatorArr[0] = ObjectAnimator.ofFloat(slideView, "translationX", fArr);
        animatorArr[1] = ObjectAnimator.ofFloat(slideView2, "translationX", 0.0f);
        animatorSet.playTogether(animatorArr);
        animatorSet.addListener(new AnimatorListenerAdapter(this) { // from class: org.rbmain.ui.ChangePhoneActivity.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                slideView2.setVisibility(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                slideView.setVisibility(8);
                slideView.setX(0.0f);
            }
        });
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillNextCodeParams(Bundle bundle, TLRPC$TL_auth_sentCode tLRPC$TL_auth_sentCode) {
        bundle.putString("phoneHash", tLRPC$TL_auth_sentCode.phone_code_hash);
        TLRPC$auth_CodeType tLRPC$auth_CodeType = tLRPC$TL_auth_sentCode.next_type;
        if (tLRPC$auth_CodeType instanceof TLRPC$TL_auth_codeTypeCall) {
            bundle.putInt("nextType", 4);
        } else if (tLRPC$auth_CodeType instanceof TLRPC$TL_auth_codeTypeFlashCall) {
            bundle.putInt("nextType", 3);
        } else if (tLRPC$auth_CodeType instanceof TLRPC$TL_auth_codeTypeSms) {
            bundle.putInt("nextType", 2);
        }
        if (tLRPC$TL_auth_sentCode.type instanceof TLRPC$TL_auth_sentCodeTypeApp) {
            bundle.putInt("type", 1);
            bundle.putInt("length", tLRPC$TL_auth_sentCode.type.length);
            setPage(1, true, bundle, false);
            return;
        }
        if (tLRPC$TL_auth_sentCode.timeout == 0) {
            tLRPC$TL_auth_sentCode.timeout = 60;
        }
        bundle.putInt("timeout", tLRPC$TL_auth_sentCode.timeout * CloseCodes.NORMAL_CLOSURE);
        TLRPC$auth_SentCodeType tLRPC$auth_SentCodeType = tLRPC$TL_auth_sentCode.type;
        if (tLRPC$auth_SentCodeType instanceof TLRPC$TL_auth_sentCodeTypeCall) {
            bundle.putInt("type", 4);
            bundle.putInt("length", tLRPC$TL_auth_sentCode.type.length);
            setPage(4, true, bundle, false);
        } else if (tLRPC$auth_SentCodeType instanceof TLRPC$TL_auth_sentCodeTypeFlashCall) {
            bundle.putInt("type", 3);
            bundle.putString("pattern", tLRPC$TL_auth_sentCode.type.pattern);
            setPage(3, true, bundle, false);
        } else if (tLRPC$auth_SentCodeType instanceof TLRPC$TL_auth_sentCodeTypeSms) {
            bundle.putInt("type", 2);
            bundle.putInt("length", tLRPC$TL_auth_sentCode.type.length);
            setPage(2, true, bundle, false);
        }
    }

    public class PhoneView extends SlideView implements AdapterView.OnItemSelectedListener {
        private EditTextBoldCursor codeField;
        private HashMap<String, String> codesMap;
        private ArrayList<String> countriesArray;
        private HashMap<String, String> countriesMap;
        private TextView countryButton;
        private int countryState;
        private boolean ignoreOnPhoneChange;
        private boolean ignoreOnTextChange;
        private boolean ignoreSelection;
        private boolean nextPressed;
        private HintEditText phoneField;
        private HashMap<String, String> phoneFormatMap;
        private TextView textView;
        private TextView textView2;
        private View view;

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }

        public PhoneView(Context context) throws IOException {
            String str;
            TelephonyManager telephonyManager;
            super(context);
            this.countryState = 0;
            this.countriesArray = new ArrayList<>();
            this.countriesMap = new HashMap<>();
            this.codesMap = new HashMap<>();
            this.phoneFormatMap = new HashMap<>();
            this.ignoreSelection = false;
            this.ignoreOnTextChange = false;
            this.ignoreOnPhoneChange = false;
            this.nextPressed = false;
            setOrientation(1);
            TextView textView = new TextView(context);
            this.countryButton = textView;
            textView.setTextSize(1, 18.0f);
            this.countryButton.setPadding(AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f), AndroidUtilities.dp(4.0f));
            TextView textView2 = this.countryButton;
            int i = Theme.key_windowBackgroundWhiteBlackText;
            textView2.setTextColor(Theme.getColor(i));
            this.countryButton.setMaxLines(1);
            this.countryButton.setSingleLine(true);
            this.countryButton.setEllipsize(TextUtils.TruncateAt.END);
            this.countryButton.setGravity((LocaleController.isRTL ? 5 : 3) | 1);
            this.countryButton.setBackground(Theme.createSelectorDrawable(Theme.getColor(Theme.key_listSelector), 7));
            addView(this.countryButton, LayoutHelper.createLinear(-1, 36, 0.0f, 0.0f, 0.0f, 14.0f));
            this.countryButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.ChangePhoneActivity$PhoneView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$new$2(view);
                }
            });
            View view = new View(context);
            this.view = view;
            view.setPadding(AndroidUtilities.dp(12.0f), 0, AndroidUtilities.dp(12.0f), 0);
            this.view.setBackgroundColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayLine));
            addView(this.view, LayoutHelper.createLinear(-1, 1, 4.0f, -17.5f, 4.0f, 0.0f));
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            addView(linearLayout, LayoutHelper.createLinear(-1, -2, 0.0f, 20.0f, 0.0f, 0.0f));
            TextView textView3 = new TextView(context);
            this.textView = textView3;
            textView3.setText("+");
            this.textView.setTextColor(Theme.getColor(i));
            this.textView.setTextSize(1, 18.0f);
            linearLayout.addView(this.textView, LayoutHelper.createLinear(-2, -2));
            EditTextBoldCursor editTextBoldCursor = new EditTextBoldCursor(context);
            this.codeField = editTextBoldCursor;
            editTextBoldCursor.setInputType(3);
            this.codeField.setTextColor(Theme.getColor(i));
            this.codeField.setCursorColor(Theme.getColor(i));
            this.codeField.setCursorSize(AndroidUtilities.dp(20.0f));
            this.codeField.setCursorWidth(1.5f);
            this.codeField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
            this.codeField.setPadding(AndroidUtilities.dp(10.0f), 0, 0, 0);
            this.codeField.setTextSize(1, 18.0f);
            this.codeField.setMaxLines(1);
            this.codeField.setGravity(19);
            this.codeField.setImeOptions(268435461);
            this.codeField.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
            linearLayout.addView(this.codeField, LayoutHelper.createLinear(55, 36, -9.0f, 0.0f, 16.0f, 0.0f));
            this.codeField.addTextChangedListener(new TextWatcher(ChangePhoneActivity.this) { // from class: org.rbmain.ui.ChangePhoneActivity.PhoneView.1
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    String str2;
                    boolean z;
                    int iIndexOf;
                    if (PhoneView.this.ignoreOnTextChange) {
                        return;
                    }
                    PhoneView.this.ignoreOnTextChange = true;
                    String strStripExceptNumbers = PhoneFormat.stripExceptNumbers(PhoneView.this.codeField.getText().toString());
                    PhoneView.this.codeField.setText(strStripExceptNumbers);
                    if (strStripExceptNumbers.length() == 0) {
                        PhoneView.this.countryButton.setText(LocaleController.getString("ChooseCountry", R.string.ChooseCountry));
                        PhoneView.this.phoneField.setHintText((String) null);
                        PhoneView.this.countryState = 1;
                    } else {
                        int i2 = 4;
                        if (strStripExceptNumbers.length() > 4) {
                            PhoneView.this.ignoreOnTextChange = true;
                            while (true) {
                                if (i2 < 1) {
                                    str2 = null;
                                    z = false;
                                    break;
                                }
                                String strSubstring = strStripExceptNumbers.substring(0, i2);
                                if (((String) PhoneView.this.codesMap.get(strSubstring)) != null) {
                                    String str3 = strStripExceptNumbers.substring(i2) + PhoneView.this.phoneField.getText().toString();
                                    PhoneView.this.codeField.setText(strSubstring);
                                    z = true;
                                    str2 = str3;
                                    strStripExceptNumbers = strSubstring;
                                    break;
                                }
                                i2--;
                            }
                            if (!z) {
                                PhoneView.this.ignoreOnTextChange = true;
                                str2 = strStripExceptNumbers.substring(1) + PhoneView.this.phoneField.getText().toString();
                                EditTextBoldCursor editTextBoldCursor2 = PhoneView.this.codeField;
                                strStripExceptNumbers = strStripExceptNumbers.substring(0, 1);
                                editTextBoldCursor2.setText(strStripExceptNumbers);
                            }
                        } else {
                            str2 = null;
                            z = false;
                        }
                        String str4 = (String) PhoneView.this.codesMap.get(strStripExceptNumbers);
                        if (str4 == null || (iIndexOf = PhoneView.this.countriesArray.indexOf(str4)) == -1) {
                            PhoneView.this.countryButton.setText(LocaleController.getString("WrongCountry", R.string.WrongCountry));
                            PhoneView.this.phoneField.setHintText((String) null);
                            PhoneView.this.countryState = 2;
                        } else {
                            PhoneView.this.ignoreSelection = true;
                            PhoneView.this.countryButton.setText((CharSequence) PhoneView.this.countriesArray.get(iIndexOf));
                            String str5 = (String) PhoneView.this.phoneFormatMap.get(strStripExceptNumbers);
                            PhoneView.this.phoneField.setHintText(str5 != null ? str5.replace('X', (char) 8211) : null);
                            PhoneView.this.countryState = 0;
                        }
                        if (!z) {
                            PhoneView.this.codeField.setSelection(PhoneView.this.codeField.getText().length());
                        }
                        if (str2 != null) {
                            PhoneView.this.phoneField.requestFocus();
                            PhoneView.this.phoneField.setText(str2);
                            PhoneView.this.phoneField.setSelection(PhoneView.this.phoneField.length());
                        }
                    }
                    PhoneView.this.ignoreOnTextChange = false;
                }
            });
            this.codeField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.ChangePhoneActivity$PhoneView$$ExternalSyntheticLambda3
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView4, int i2, KeyEvent keyEvent) {
                    return this.f$0.lambda$new$3(textView4, i2, keyEvent);
                }
            });
            HintEditText hintEditText = new HintEditText(context);
            this.phoneField = hintEditText;
            hintEditText.setInputType(3);
            this.phoneField.setTextColor(Theme.getColor(i));
            this.phoneField.setHintTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteHintText));
            this.phoneField.setBackgroundDrawable(Theme.createEditTextDrawable(context, false));
            this.phoneField.setPadding(0, 0, 0, 0);
            this.phoneField.setCursorColor(Theme.getColor(i));
            this.phoneField.setCursorSize(AndroidUtilities.dp(20.0f));
            this.phoneField.setCursorWidth(1.5f);
            this.phoneField.setTextSize(1, 18.0f);
            this.phoneField.setMaxLines(1);
            this.phoneField.setGravity(19);
            this.phoneField.setImeOptions(268435461);
            linearLayout.addView(this.phoneField, LayoutHelper.createFrame(-1, 36.0f));
            this.phoneField.addTextChangedListener(new TextWatcher(ChangePhoneActivity.this) { // from class: org.rbmain.ui.ChangePhoneActivity.PhoneView.2
                private int actionPosition;
                private int characterAction = -1;

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    if (i3 == 0 && i4 == 1) {
                        this.characterAction = 1;
                        return;
                    }
                    if (i3 == 1 && i4 == 0) {
                        if (charSequence.charAt(i2) == ' ' && i2 > 0) {
                            this.characterAction = 3;
                            this.actionPosition = i2 - 1;
                            return;
                        } else {
                            this.characterAction = 2;
                            return;
                        }
                    }
                    this.characterAction = -1;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    int i2;
                    int i3;
                    if (PhoneView.this.ignoreOnPhoneChange) {
                        return;
                    }
                    int selectionStart = PhoneView.this.phoneField.getSelectionStart();
                    String string = PhoneView.this.phoneField.getText().toString();
                    if (this.characterAction == 3) {
                        string = string.substring(0, this.actionPosition) + string.substring(this.actionPosition + 1);
                        selectionStart--;
                    }
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
                    PhoneView.this.ignoreOnPhoneChange = true;
                    String hintText = PhoneView.this.phoneField.getHintText();
                    if (hintText != null) {
                        int i6 = 0;
                        while (true) {
                            if (i6 >= sb.length()) {
                                break;
                            }
                            if (i6 < hintText.length()) {
                                if (hintText.charAt(i6) == ' ') {
                                    sb.insert(i6, ' ');
                                    i6++;
                                    if (selectionStart == i6 && (i3 = this.characterAction) != 2 && i3 != 3) {
                                        selectionStart++;
                                    }
                                }
                                i6++;
                            } else {
                                sb.insert(i6, ' ');
                                if (selectionStart == i6 + 1 && (i2 = this.characterAction) != 2 && i2 != 3) {
                                    selectionStart++;
                                }
                            }
                        }
                    }
                    PhoneView.this.phoneField.setText(sb);
                    if (selectionStart >= 0) {
                        HintEditText hintEditText2 = PhoneView.this.phoneField;
                        if (selectionStart > PhoneView.this.phoneField.length()) {
                            selectionStart = PhoneView.this.phoneField.length();
                        }
                        hintEditText2.setSelection(selectionStart);
                    }
                    PhoneView.this.phoneField.onTextChange();
                    PhoneView.this.ignoreOnPhoneChange = false;
                }
            });
            this.phoneField.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.ChangePhoneActivity$PhoneView$$ExternalSyntheticLambda2
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView4, int i2, KeyEvent keyEvent) {
                    return this.f$0.lambda$new$4(textView4, i2, keyEvent);
                }
            });
            this.phoneField.setOnKeyListener(new View.OnKeyListener() { // from class: org.rbmain.ui.ChangePhoneActivity$PhoneView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view2, int i2, KeyEvent keyEvent) {
                    return this.f$0.lambda$new$5(view2, i2, keyEvent);
                }
            });
            TextView textView4 = new TextView(context);
            this.textView2 = textView4;
            textView4.setText(LocaleController.getString("ChangePhoneHelp", R.string.ChangePhoneHelp));
            this.textView2.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText6));
            this.textView2.setTextSize(1, 14.0f);
            this.textView2.setGravity(LocaleController.isRTL ? 5 : 3);
            this.textView2.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            addView(this.textView2, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3, 0, 28, 0, 10));
            HashMap map = new HashMap();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getResources().getAssets().open("countries.txt")));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] strArrSplit = line.split(";");
                    this.countriesArray.add(0, strArrSplit[2]);
                    this.countriesMap.put(strArrSplit[2], strArrSplit[0]);
                    this.codesMap.put(strArrSplit[0], strArrSplit[2]);
                    if (strArrSplit.length > 3) {
                        this.phoneFormatMap.put(strArrSplit[0], strArrSplit[3]);
                    }
                    map.put(strArrSplit[1], strArrSplit[2]);
                }
                bufferedReader.close();
            } catch (Exception e) {
                FileLog.e(e);
            }
            Collections.sort(this.countriesArray, ChangePhoneActivity$PhoneView$$ExternalSyntheticLambda6.INSTANCE);
            try {
                telephonyManager = (TelephonyManager) ApplicationLoader.applicationContext.getSystemService("phone");
            } catch (Exception e2) {
                FileLog.e(e2);
            }
            String upperCase = telephonyManager != null ? telephonyManager.getSimCountryIso().toUpperCase() : null;
            if (upperCase != null && (str = (String) map.get(upperCase)) != null && this.countriesArray.indexOf(str) != -1) {
                this.codeField.setText(this.countriesMap.get(str));
                this.countryState = 0;
            }
            if (this.codeField.length() == 0) {
                this.countryButton.setText(LocaleController.getString("ChooseCountry", R.string.ChooseCountry));
                this.phoneField.setHintText((String) null);
                this.countryState = 1;
            }
            if (this.codeField.length() != 0) {
                AndroidUtilities.showKeyboard(this.phoneField);
                this.phoneField.requestFocus();
                HintEditText hintEditText2 = this.phoneField;
                hintEditText2.setSelection(hintEditText2.length());
                return;
            }
            AndroidUtilities.showKeyboard(this.codeField);
            this.codeField.requestFocus();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$2(View view) {
            CountrySelectActivity countrySelectActivity = new CountrySelectActivity(true);
            countrySelectActivity.setCountrySelectActivityDelegate(new CountrySelectActivity.CountrySelectActivityDelegate() { // from class: org.rbmain.ui.ChangePhoneActivity$PhoneView$$ExternalSyntheticLambda8
                @Override // org.rbmain.ui.CountrySelectActivity.CountrySelectActivityDelegate
                public final void didSelectCountry(String str, String str2) {
                    this.f$0.lambda$new$1(str, str2);
                }
            });
            ChangePhoneActivity.this.presentFragment(countrySelectActivity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$1(String str, String str2) {
            selectCountry(str);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChangePhoneActivity$PhoneView$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$new$0();
                }
            }, 300L);
            this.phoneField.requestFocus();
            HintEditText hintEditText = this.phoneField;
            hintEditText.setSelection(hintEditText.length());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0() {
            AndroidUtilities.showKeyboard(this.phoneField);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$new$3(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 5) {
                return false;
            }
            this.phoneField.requestFocus();
            HintEditText hintEditText = this.phoneField;
            hintEditText.setSelection(hintEditText.length());
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$new$4(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 5) {
                return false;
            }
            onNextPressed();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$new$5(View view, int i, KeyEvent keyEvent) {
            if (i != 67 || this.phoneField.length() != 0) {
                return false;
            }
            this.codeField.requestFocus();
            EditTextBoldCursor editTextBoldCursor = this.codeField;
            editTextBoldCursor.setSelection(editTextBoldCursor.length());
            this.codeField.dispatchKeyEvent(keyEvent);
            return true;
        }

        public void selectCountry(String str) {
            if (this.countriesArray.indexOf(str) != -1) {
                this.ignoreOnTextChange = true;
                String str2 = this.countriesMap.get(str);
                this.codeField.setText(str2);
                this.countryButton.setText(str);
                String str3 = this.phoneFormatMap.get(str2);
                this.phoneField.setHintText(str3 != null ? str3.replace('X', (char) 8211) : null);
                this.countryState = 0;
                this.ignoreOnTextChange = false;
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.ignoreSelection) {
                this.ignoreSelection = false;
                return;
            }
            this.ignoreOnTextChange = true;
            this.codeField.setText(this.countriesMap.get(this.countriesArray.get(i)));
            this.ignoreOnTextChange = false;
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void onCancelPressed() {
            this.nextPressed = false;
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void onNextPressed() {
            boolean z;
            if (ChangePhoneActivity.this.getParentActivity() == null || this.nextPressed) {
                return;
            }
            TelephonyManager telephonyManager = (TelephonyManager) ApplicationLoader.applicationContext.getSystemService("phone");
            boolean z2 = (telephonyManager.getSimState() == 1 || telephonyManager.getPhoneType() == 0) ? false : true;
            if (Build.VERSION.SDK_INT < 23 || !z2) {
                z = true;
            } else {
                z = ChangePhoneActivity.this.getParentActivity().checkSelfPermission("android.permission.READ_PHONE_STATE") == 0;
                if (ChangePhoneActivity.this.checkPermissions) {
                    ChangePhoneActivity.this.permissionsItems.clear();
                    if (!z) {
                        ChangePhoneActivity.this.permissionsItems.add("android.permission.READ_PHONE_STATE");
                    }
                    if (!ChangePhoneActivity.this.permissionsItems.isEmpty()) {
                        SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
                        if (!globalMainSettings.getBoolean("firstlogin", true) && !ChangePhoneActivity.this.getParentActivity().shouldShowRequestPermissionRationale("android.permission.READ_PHONE_STATE")) {
                            ChangePhoneActivity.this.getParentActivity().requestPermissions((String[]) ChangePhoneActivity.this.permissionsItems.toArray(new String[0]), 6);
                            return;
                        }
                        globalMainSettings.edit().putBoolean("firstlogin", false).apply();
                        AlertDialog.Builder builder = new AlertDialog.Builder(ChangePhoneActivity.this.getParentActivity());
                        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
                        builder.setMessage(LocaleController.getString("AllowReadCall", R.string.AllowReadCall));
                        ChangePhoneActivity changePhoneActivity = ChangePhoneActivity.this;
                        changePhoneActivity.permissionsDialog = changePhoneActivity.showDialog(builder.create());
                        return;
                    }
                }
            }
            if (this.countryState == 1) {
                AlertsCreator.showSimpleAlert(ChangePhoneActivity.this, LocaleController.getString("ChooseCountry", R.string.ChooseCountry));
                return;
            }
            if (this.codeField.length() == 0) {
                AlertsCreator.showSimpleAlert(ChangePhoneActivity.this, LocaleController.getString("InvalidPhoneNumber", R.string.InvalidPhoneNumber));
                return;
            }
            TLRPC$TL_account_sendChangePhoneCode tLRPC$TL_account_sendChangePhoneCode = new TLRPC$TL_account_sendChangePhoneCode();
            String strReplaceFirst = this.phoneField.getText().toString().replaceFirst("^0+(?!$)", BuildConfig.FLAVOR);
            String strStripExceptNumbers = PhoneFormat.stripExceptNumbers(BuildConfig.FLAVOR + ((Object) this.codeField.getText()) + strReplaceFirst);
            tLRPC$TL_account_sendChangePhoneCode.phone_number = strStripExceptNumbers;
            TLRPC$TL_codeSettings tLRPC$TL_codeSettings = new TLRPC$TL_codeSettings();
            tLRPC$TL_account_sendChangePhoneCode.settings = tLRPC$TL_codeSettings;
            tLRPC$TL_codeSettings.allow_flashcall = z2 && z;
            tLRPC$TL_codeSettings.allow_app_hash = ApplicationLoader.hasPlayServices;
            SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", 0);
            if (tLRPC$TL_account_sendChangePhoneCode.settings.allow_app_hash) {
                sharedPreferences.edit().putString("sms_hash", BuildVars.SMS_HASH).apply();
            } else {
                sharedPreferences.edit().remove("sms_hash").apply();
            }
            if (tLRPC$TL_account_sendChangePhoneCode.settings.allow_flashcall) {
                try {
                    String line1Number = telephonyManager.getLine1Number();
                    if (!TextUtils.isEmpty(line1Number)) {
                        tLRPC$TL_account_sendChangePhoneCode.settings.current_number = PhoneNumberUtils.compare(strStripExceptNumbers, line1Number);
                        TLRPC$TL_codeSettings tLRPC$TL_codeSettings2 = tLRPC$TL_account_sendChangePhoneCode.settings;
                        if (!tLRPC$TL_codeSettings2.current_number) {
                            tLRPC$TL_codeSettings2.allow_flashcall = false;
                        }
                    } else {
                        tLRPC$TL_account_sendChangePhoneCode.settings.current_number = false;
                    }
                } catch (Exception e) {
                    tLRPC$TL_account_sendChangePhoneCode.settings.allow_flashcall = false;
                    FileLog.e(e);
                }
            }
            final Bundle bundle = new Bundle();
            bundle.putString("phone", "+" + PhoneFormat.stripExceptNumbers(String.valueOf(this.codeField.getText())) + " " + PhoneFormat.stripExceptNumbers(strReplaceFirst));
            try {
                bundle.putString("ephone", "+" + PhoneFormat.stripExceptNumbers(this.codeField.getText().toString()) + " " + PhoneFormat.stripExceptNumbers(strReplaceFirst));
            } catch (Exception e2) {
                FileLog.e(e2);
                bundle.putString("ephone", "+" + strStripExceptNumbers);
            }
            bundle.putString("phoneFormated", strStripExceptNumbers);
            this.nextPressed = true;
            ChangePhoneActivity.this.needShowProgress();
            ContactsProxy.getInstance(((BaseFragment) ChangePhoneActivity.this).currentAccount).changePhoneNumber(tLRPC$TL_account_sendChangePhoneCode, new RequestDelegate() { // from class: org.rbmain.ui.ChangePhoneActivity$PhoneView$$ExternalSyntheticLambda7
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$onNextPressed$7(bundle, tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onNextPressed$7(final Bundle bundle, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChangePhoneActivity$PhoneView$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onNextPressed$6(tLRPC$TL_error, bundle, tLObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onNextPressed$6(TLRPC$TL_error tLRPC$TL_error, Bundle bundle, TLObject tLObject) {
            this.nextPressed = false;
            if (tLRPC$TL_error == null) {
                ChangePhoneActivity.this.fillNextCodeParams(bundle, (TLRPC$TL_auth_sentCode) tLObject);
            } else if (tLRPC$TL_error.text.contains("PHONE_NUMBER_INVALID")) {
                AlertsCreator.showSimpleAlert(ChangePhoneActivity.this, LocaleController.getString("InvalidPhoneNumber", R.string.InvalidPhoneNumber));
            } else if (tLRPC$TL_error.text.startsWith("PHONE_NUMBER_OCCUPIED")) {
                AlertsCreator.showSimpleAlert(ChangePhoneActivity.this, LocaleController.formatString("ChangePhoneNumberOccupied", R.string.ChangePhoneNumberOccupied, bundle.getString("phone")));
            } else {
                AlertsCreator.processLoginException(ChangePhoneActivity.this, tLRPC$TL_error.text);
            }
            ChangePhoneActivity.this.needHideProgress();
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void onShow() {
            super.onShow();
            if (this.phoneField != null) {
                if (this.codeField.length() != 0) {
                    AndroidUtilities.showKeyboard(this.phoneField);
                    this.phoneField.requestFocus();
                    HintEditText hintEditText = this.phoneField;
                    hintEditText.setSelection(hintEditText.length());
                    return;
                }
                AndroidUtilities.showKeyboard(this.codeField);
                this.codeField.requestFocus();
            }
        }

        @Override // org.rbmain.ui.Components.SlideView
        public String getHeaderName() {
            return LocaleController.getString("ChangePhoneNewNumber", R.string.ChangePhoneNewNumber);
        }
    }

    public class LoginActivitySmsView extends SlideView implements NotificationCenter.NotificationCenterDelegate {
        private ImageView blackImageView;
        private RLottieImageView blueImageView;
        private EditTextBoldCursor[] codeField;
        private LinearLayout codeFieldContainer;
        private int codeTime;
        private Timer codeTimer;
        private TextView confirmTextView;
        private int currentType;
        private String emailPhone;
        RLottieDrawable hintDrawable;
        private boolean ignoreOnTextChange;
        private double lastCodeTime;
        private double lastCurrentTime;
        private String lastError;
        private int length;
        private boolean nextPressed;
        private int nextType;
        private String pattern;
        private String phone;
        private String phoneHash;
        private TextView problemText;
        private ProgressView progressView;
        private String requestPhone;
        private int time;
        private TextView timeText;
        private Timer timeTimer;
        private int timeout;
        private final Object timerSync;
        private TextView titleTextView;
        private boolean waitingForEvent;

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onBackPressed$9(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        }

        @Override // org.rbmain.ui.Components.SlideView
        public boolean needBackButton() {
            return true;
        }

        static /* synthetic */ int access$2426(LoginActivitySmsView loginActivitySmsView, double d) {
            double d2 = loginActivitySmsView.codeTime;
            Double.isNaN(d2);
            int i = (int) (d2 - d);
            loginActivitySmsView.codeTime = i;
            return i;
        }

        static /* synthetic */ int access$3026(LoginActivitySmsView loginActivitySmsView, double d) {
            double d2 = loginActivitySmsView.time;
            Double.isNaN(d2);
            int i = (int) (d2 - d);
            loginActivitySmsView.time = i;
            return i;
        }

        public LoginActivitySmsView(Context context, int i) {
            super(context);
            this.timerSync = new Object();
            this.time = 60000;
            this.codeTime = 15000;
            this.lastError = BuildConfig.FLAVOR;
            this.pattern = "*";
            this.currentType = i;
            setOrientation(1);
            TextView textView = new TextView(context);
            this.confirmTextView = textView;
            int i2 = Theme.key_windowBackgroundWhiteGrayText6;
            textView.setTextColor(Theme.getColor(i2));
            this.confirmTextView.setTextSize(1, 14.0f);
            this.confirmTextView.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            TextView textView2 = new TextView(context);
            this.titleTextView = textView2;
            int i3 = Theme.key_windowBackgroundWhiteBlackText;
            textView2.setTextColor(Theme.getColor(i3));
            this.titleTextView.setTextSize(1, 18.0f);
            this.titleTextView.setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
            this.titleTextView.setGravity(LocaleController.isRTL ? 5 : 3);
            this.titleTextView.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            this.titleTextView.setGravity(49);
            if (this.currentType == 3) {
                this.confirmTextView.setGravity((LocaleController.isRTL ? 5 : 3) | 48);
                FrameLayout frameLayout = new FrameLayout(context);
                addView(frameLayout, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3));
                ImageView imageView = new ImageView(context);
                imageView.setImageResource(R.drawable.phone_activate);
                boolean z = LocaleController.isRTL;
                if (z) {
                    frameLayout.addView(imageView, LayoutHelper.createFrame(64, 76.0f, 19, 2.0f, 2.0f, 0.0f, 0.0f));
                    frameLayout.addView(this.confirmTextView, LayoutHelper.createFrame(-1, -2.0f, LocaleController.isRTL ? 5 : 3, 82.0f, 0.0f, 0.0f, 0.0f));
                } else {
                    frameLayout.addView(this.confirmTextView, LayoutHelper.createFrame(-1, -2.0f, z ? 5 : 3, 0.0f, 0.0f, 82.0f, 0.0f));
                    frameLayout.addView(imageView, LayoutHelper.createFrame(64, 76.0f, 21, 0.0f, 2.0f, 0.0f, 2.0f));
                }
            } else {
                this.confirmTextView.setGravity(49);
                FrameLayout frameLayout2 = new FrameLayout(context);
                addView(frameLayout2, LayoutHelper.createLinear(-2, -2, 49));
                if (this.currentType == 1) {
                    ImageView imageView2 = new ImageView(context);
                    this.blackImageView = imageView2;
                    imageView2.setImageResource(R.drawable.sms_devices);
                    this.blackImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(i3), PorterDuff.Mode.MULTIPLY));
                    frameLayout2.addView(this.blackImageView, LayoutHelper.createFrame(-2, -2.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
                    RLottieImageView rLottieImageView = new RLottieImageView(context);
                    this.blueImageView = rLottieImageView;
                    rLottieImageView.setImageResource(R.drawable.sms_bubble);
                    this.blueImageView.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_chats_actionBackground), PorterDuff.Mode.MULTIPLY));
                    frameLayout2.addView(this.blueImageView, LayoutHelper.createFrame(-2, -2.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
                    this.titleTextView.setText(LocaleController.getString("SentAppCodeTitle", R.string.SentAppCodeTitle));
                } else {
                    this.blueImageView = new RLottieImageView(context);
                    RLottieDrawable rLottieDrawable = new RLottieDrawable(R.raw.sms_incoming_info, "2131820642", AndroidUtilities.dp(64.0f), AndroidUtilities.dp(64.0f), true, null);
                    this.hintDrawable = rLottieDrawable;
                    int i4 = Theme.key_chats_actionBackground;
                    rLottieDrawable.setLayerColor("Bubble.**", Theme.getColor(i4));
                    this.hintDrawable.setLayerColor("Phone.**", Theme.getColor(i4));
                    this.blueImageView.setAnimation(this.hintDrawable);
                    frameLayout2.addView(this.blueImageView, LayoutHelper.createFrame(-2, -2.0f, 51, 0.0f, 0.0f, 0.0f, 0.0f));
                    this.titleTextView.setText(LocaleController.getString("SentSmsCodeTitle", R.string.SentSmsCodeTitle));
                }
                addView(this.titleTextView, LayoutHelper.createLinear(-2, -2, 49, 0, 18, 0, 0));
                addView(this.confirmTextView, LayoutHelper.createLinear(-2, -2, 49, 0, 17, 0, 0));
            }
            LinearLayout linearLayout = new LinearLayout(context);
            this.codeFieldContainer = linearLayout;
            linearLayout.setOrientation(0);
            addView(this.codeFieldContainer, LayoutHelper.createLinear(-2, 36, 1));
            if (this.currentType == 3) {
                this.codeFieldContainer.setVisibility(8);
            }
            TextView textView3 = new TextView(this, context, ChangePhoneActivity.this) { // from class: org.rbmain.ui.ChangePhoneActivity.LoginActivitySmsView.1
                @Override // android.widget.TextView, android.view.View
                protected void onMeasure(int i5, int i6) {
                    super.onMeasure(i5, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(100.0f), Integer.MIN_VALUE));
                }
            };
            this.timeText = textView3;
            textView3.setTextColor(Theme.getColor(i2));
            this.timeText.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            if (this.currentType == 3) {
                this.timeText.setTextSize(1, 14.0f);
                addView(this.timeText, LayoutHelper.createLinear(-2, -2, LocaleController.isRTL ? 5 : 3));
                this.progressView = new ProgressView(ChangePhoneActivity.this, context);
                this.timeText.setGravity(LocaleController.isRTL ? 5 : 3);
                addView(this.progressView, LayoutHelper.createLinear(-1, 3, 0.0f, 12.0f, 0.0f, 0.0f));
            } else {
                this.timeText.setPadding(0, AndroidUtilities.dp(2.0f), 0, AndroidUtilities.dp(10.0f));
                this.timeText.setTextSize(1, 15.0f);
                this.timeText.setGravity(49);
                addView(this.timeText, LayoutHelper.createLinear(-2, -2, 49));
            }
            TextView textView4 = new TextView(this, context, ChangePhoneActivity.this) { // from class: org.rbmain.ui.ChangePhoneActivity.LoginActivitySmsView.2
                @Override // android.widget.TextView, android.view.View
                protected void onMeasure(int i5, int i6) {
                    super.onMeasure(i5, View.MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(100.0f), Integer.MIN_VALUE));
                }
            };
            this.problemText = textView4;
            textView4.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlueText4));
            this.problemText.setLineSpacing(AndroidUtilities.dp(2.0f), 1.0f);
            this.problemText.setPadding(0, AndroidUtilities.dp(2.0f), 0, AndroidUtilities.dp(10.0f));
            this.problemText.setTextSize(1, 15.0f);
            this.problemText.setGravity(49);
            if (this.currentType == 1) {
                this.problemText.setText(LocaleController.getString("DidNotGetTheCodeSms", R.string.DidNotGetTheCodeSms));
            } else {
                this.problemText.setText(LocaleController.getString("DidNotGetTheCode", R.string.DidNotGetTheCode));
            }
            addView(this.problemText, LayoutHelper.createLinear(-2, -2, 49));
            this.problemText.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.ChangePhoneActivity$LoginActivitySmsView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws PackageManager.NameNotFoundException {
                    this.f$0.lambda$new$0(view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view) throws PackageManager.NameNotFoundException {
            if (this.nextPressed) {
                return;
            }
            int i = this.nextType;
            if (!((i == 4 && this.currentType == 2) || i == 0)) {
                resendCode();
                return;
            }
            try {
                PackageInfo packageInfo = ApplicationLoader.applicationContext.getPackageManager().getPackageInfo(ApplicationLoader.applicationContext.getPackageName(), 0);
                String str = String.format(Locale.US, "%s (%d)", packageInfo.versionName, Integer.valueOf(packageInfo.versionCode));
                Intent intent = new Intent("android.intent.action.SENDTO");
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra("android.intent.extra.EMAIL", new String[]{"sms@stel.com"});
                intent.putExtra("android.intent.extra.SUBJECT", "Android registration/login issue " + str + " " + this.emailPhone);
                intent.putExtra("android.intent.extra.TEXT", "Phone: " + this.requestPhone + "\nApp version: " + str + "\nOS version: SDK " + Build.VERSION.SDK_INT + "\nDevice Name: " + Build.MANUFACTURER + Build.MODEL + "\nLocale: " + Locale.getDefault() + "\nError: " + this.lastError);
                getContext().startActivity(Intent.createChooser(intent, "Send email..."));
            } catch (Exception unused) {
                AlertsCreator.showSimpleAlert(ChangePhoneActivity.this, LocaleController.getString("NoMailInstalled", R.string.NoMailInstalled));
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            RLottieImageView rLottieImageView;
            super.onMeasure(i, i2);
            if (this.currentType == 3 || (rLottieImageView = this.blueImageView) == null) {
                return;
            }
            int measuredHeight = rLottieImageView.getMeasuredHeight() + this.titleTextView.getMeasuredHeight() + this.confirmTextView.getMeasuredHeight() + AndroidUtilities.dp(35.0f);
            int iDp = AndroidUtilities.dp(80.0f);
            int iDp2 = AndroidUtilities.dp(291.0f);
            if (ChangePhoneActivity.this.scrollHeight - measuredHeight >= iDp) {
                if (ChangePhoneActivity.this.scrollHeight <= iDp2) {
                    setMeasuredDimension(getMeasuredWidth(), ChangePhoneActivity.this.scrollHeight);
                    return;
                } else {
                    setMeasuredDimension(getMeasuredWidth(), iDp2);
                    return;
                }
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight + iDp);
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int i5;
            super.onLayout(z, i, i2, i3, i4);
            if (this.currentType == 3 || this.blueImageView == null) {
                return;
            }
            int bottom = this.confirmTextView.getBottom();
            int measuredHeight = getMeasuredHeight() - bottom;
            if (this.problemText.getVisibility() == 0) {
                int measuredHeight2 = this.problemText.getMeasuredHeight();
                i5 = (measuredHeight + bottom) - measuredHeight2;
                TextView textView = this.problemText;
                textView.layout(textView.getLeft(), i5, this.problemText.getRight(), measuredHeight2 + i5);
            } else if (this.timeText.getVisibility() == 0) {
                int measuredHeight3 = this.timeText.getMeasuredHeight();
                i5 = (measuredHeight + bottom) - measuredHeight3;
                TextView textView2 = this.timeText;
                textView2.layout(textView2.getLeft(), i5, this.timeText.getRight(), measuredHeight3 + i5);
            } else {
                i5 = measuredHeight + bottom;
            }
            int measuredHeight4 = this.codeFieldContainer.getMeasuredHeight();
            int i6 = (((i5 - bottom) - measuredHeight4) / 2) + bottom;
            LinearLayout linearLayout = this.codeFieldContainer;
            linearLayout.layout(linearLayout.getLeft(), i6, this.codeFieldContainer.getRight(), measuredHeight4 + i6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void resendCode() {
            final Bundle bundle = new Bundle();
            bundle.putString("phone", this.phone);
            bundle.putString("ephone", this.emailPhone);
            bundle.putString("phoneFormated", this.requestPhone);
            this.nextPressed = true;
            ChangePhoneActivity.this.needShowProgress();
            final TLRPC$TL_auth_resendCode tLRPC$TL_auth_resendCode = new TLRPC$TL_auth_resendCode();
            tLRPC$TL_auth_resendCode.phone_number = this.requestPhone;
            tLRPC$TL_auth_resendCode.phone_code_hash = this.phoneHash;
            ConnectionsManager.getInstance(((BaseFragment) ChangePhoneActivity.this).currentAccount).sendRequest(tLRPC$TL_auth_resendCode, new RequestDelegate() { // from class: org.rbmain.ui.ChangePhoneActivity$LoginActivitySmsView$$ExternalSyntheticLambda8
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$resendCode$3(bundle, tLRPC$TL_auth_resendCode, tLObject, tLRPC$TL_error);
                }
            }, 2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$resendCode$3(final Bundle bundle, final TLRPC$TL_auth_resendCode tLRPC$TL_auth_resendCode, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChangePhoneActivity$LoginActivitySmsView$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$resendCode$2(tLRPC$TL_error, bundle, tLObject, tLRPC$TL_auth_resendCode);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$resendCode$2(TLRPC$TL_error tLRPC$TL_error, Bundle bundle, TLObject tLObject, TLRPC$TL_auth_resendCode tLRPC$TL_auth_resendCode) {
            this.nextPressed = false;
            if (tLRPC$TL_error == null) {
                ChangePhoneActivity.this.fillNextCodeParams(bundle, (TLRPC$TL_auth_sentCode) tLObject);
            } else {
                AlertDialog alertDialog = (AlertDialog) AlertsCreator.processError(((BaseFragment) ChangePhoneActivity.this).currentAccount, tLRPC$TL_error, ChangePhoneActivity.this, tLRPC$TL_auth_resendCode, new Object[0]);
                if (alertDialog != null && tLRPC$TL_error.text.contains("PHONE_CODE_EXPIRED")) {
                    alertDialog.setPositiveButtonListener(new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ChangePhoneActivity$LoginActivitySmsView$$ExternalSyntheticLambda0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.f$0.lambda$resendCode$1(dialogInterface, i);
                        }
                    });
                }
            }
            ChangePhoneActivity.this.needHideProgress();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$resendCode$1(DialogInterface dialogInterface, int i) {
            onBackPressed(true);
            ChangePhoneActivity.this.finishFragment();
        }

        @Override // org.rbmain.ui.Components.SlideView
        public String getHeaderName() {
            if (this.currentType == 1) {
                return this.phone;
            }
            return LocaleController.getString("YourCode", R.string.YourCode);
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void onCancelPressed() {
            this.nextPressed = false;
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void setParams(Bundle bundle, boolean z) {
            int i;
            int i2;
            if (bundle == null) {
                return;
            }
            this.waitingForEvent = true;
            int i3 = this.currentType;
            if (i3 == 2) {
                AndroidUtilities.setWaitingForSms(true);
                NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didReceiveSmsCode);
            } else if (i3 == 3) {
                AndroidUtilities.setWaitingForCall(true);
                NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didReceiveCall);
            }
            this.phone = bundle.getString("phone");
            this.emailPhone = bundle.getString("ephone");
            this.requestPhone = bundle.getString("phoneFormated");
            this.phoneHash = bundle.getString("phoneHash");
            int i4 = bundle.getInt("timeout");
            this.time = i4;
            this.timeout = i4;
            this.nextType = bundle.getInt("nextType");
            this.pattern = bundle.getString("pattern");
            int i5 = bundle.getInt("length");
            this.length = i5;
            if (i5 == 0) {
                this.length = 5;
            }
            EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
            CharSequence charSequenceReplaceTags = BuildConfig.FLAVOR;
            if (editTextBoldCursorArr != null && editTextBoldCursorArr.length == this.length) {
                int i6 = 0;
                while (true) {
                    EditTextBoldCursor[] editTextBoldCursorArr2 = this.codeField;
                    if (i6 >= editTextBoldCursorArr2.length) {
                        break;
                    }
                    editTextBoldCursorArr2[i6].setText(BuildConfig.FLAVOR);
                    i6++;
                }
            } else {
                this.codeField = new EditTextBoldCursor[this.length];
                final int i7 = 0;
                while (i7 < this.length) {
                    this.codeField[i7] = new EditTextBoldCursor(getContext());
                    EditTextBoldCursor editTextBoldCursor = this.codeField[i7];
                    int i8 = Theme.key_windowBackgroundWhiteBlackText;
                    editTextBoldCursor.setTextColor(Theme.getColor(i8));
                    this.codeField[i7].setCursorColor(Theme.getColor(i8));
                    this.codeField[i7].setCursorSize(AndroidUtilities.dp(20.0f));
                    this.codeField[i7].setCursorWidth(1.5f);
                    Drawable drawableMutate = getResources().getDrawable(R.drawable.search_dark_activated).mutate();
                    drawableMutate.setColorFilter(new PorterDuffColorFilter(Theme.getColor(Theme.key_windowBackgroundWhiteInputFieldActivated), PorterDuff.Mode.MULTIPLY));
                    this.codeField[i7].setBackgroundDrawable(drawableMutate);
                    this.codeField[i7].setImeOptions(268435461);
                    this.codeField[i7].setTextSize(1, 20.0f);
                    this.codeField[i7].setMaxLines(1);
                    this.codeField[i7].setTypeface(AndroidUtilities.getTypeface(AndroidUtilities.TYPEFACE_ROBOTO_MEDIUM));
                    this.codeField[i7].setPadding(0, 0, 0, 0);
                    this.codeField[i7].setGravity(49);
                    if (this.currentType == 3) {
                        this.codeField[i7].setEnabled(false);
                        this.codeField[i7].setInputType(0);
                        this.codeField[i7].setVisibility(8);
                    } else {
                        this.codeField[i7].setInputType(3);
                    }
                    this.codeFieldContainer.addView(this.codeField[i7], LayoutHelper.createLinear(34, 36, 1, 0, 0, i7 != this.length - 1 ? 7 : 0, 0));
                    this.codeField[i7].addTextChangedListener(new TextWatcher() { // from class: org.rbmain.ui.ChangePhoneActivity.LoginActivitySmsView.3
                        @Override // android.text.TextWatcher
                        public void beforeTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
                        }

                        @Override // android.text.TextWatcher
                        public void onTextChanged(CharSequence charSequence, int i9, int i10, int i11) {
                        }

                        @Override // android.text.TextWatcher
                        public void afterTextChanged(Editable editable) {
                            int length;
                            if (!LoginActivitySmsView.this.ignoreOnTextChange && (length = editable.length()) >= 1) {
                                if (length > 1) {
                                    String string = editable.toString();
                                    LoginActivitySmsView.this.ignoreOnTextChange = true;
                                    for (int i9 = 0; i9 < Math.min(LoginActivitySmsView.this.length - i7, length); i9++) {
                                        if (i9 != 0) {
                                            LoginActivitySmsView.this.codeField[i7 + i9].setText(string.substring(i9, i9 + 1));
                                        } else {
                                            editable.replace(0, length, string.substring(i9, i9 + 1));
                                        }
                                    }
                                    LoginActivitySmsView.this.ignoreOnTextChange = false;
                                }
                                if (i7 != LoginActivitySmsView.this.length - 1) {
                                    LoginActivitySmsView.this.codeField[i7 + 1].setSelection(LoginActivitySmsView.this.codeField[i7 + 1].length());
                                    LoginActivitySmsView.this.codeField[i7 + 1].requestFocus();
                                }
                                if ((i7 == LoginActivitySmsView.this.length - 1 || (i7 == LoginActivitySmsView.this.length - 2 && length >= 2)) && LoginActivitySmsView.this.getCode().length() == LoginActivitySmsView.this.length) {
                                    LoginActivitySmsView.this.onNextPressed();
                                }
                            }
                        }
                    });
                    this.codeField[i7].setOnKeyListener(new View.OnKeyListener() { // from class: org.rbmain.ui.ChangePhoneActivity$LoginActivitySmsView$$ExternalSyntheticLambda3
                        @Override // android.view.View.OnKeyListener
                        public final boolean onKey(View view, int i9, KeyEvent keyEvent) {
                            return this.f$0.lambda$setParams$4(i7, view, i9, keyEvent);
                        }
                    });
                    this.codeField[i7].setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: org.rbmain.ui.ChangePhoneActivity$LoginActivitySmsView$$ExternalSyntheticLambda4
                        @Override // android.widget.TextView.OnEditorActionListener
                        public final boolean onEditorAction(TextView textView, int i9, KeyEvent keyEvent) {
                            return this.f$0.lambda$setParams$5(textView, i9, keyEvent);
                        }
                    });
                    i7++;
                }
            }
            ProgressView progressView = this.progressView;
            if (progressView != null) {
                progressView.setVisibility(this.nextType != 0 ? 0 : 8);
            }
            if (this.phone == null) {
                return;
            }
            String str = PhoneFormat.getInstance().format(this.phone);
            int i9 = this.currentType;
            if (i9 == 1) {
                charSequenceReplaceTags = AndroidUtilities.replaceTags(LocaleController.getString("SentAppCode", R.string.SentAppCode));
            } else if (i9 == 2) {
                charSequenceReplaceTags = AndroidUtilities.replaceTags(LocaleController.formatString("SentSmsCode", R.string.SentSmsCode, LocaleController.addNbsp(str)));
            } else if (i9 == 3) {
                charSequenceReplaceTags = AndroidUtilities.replaceTags(LocaleController.formatString("SentCallCode", R.string.SentCallCode, LocaleController.addNbsp(str)));
            } else if (i9 == 4) {
                charSequenceReplaceTags = AndroidUtilities.replaceTags(LocaleController.formatString("SentCallOnly", R.string.SentCallOnly, LocaleController.addNbsp(str)));
            }
            this.confirmTextView.setText(charSequenceReplaceTags);
            if (this.currentType != 3) {
                AndroidUtilities.showKeyboard(this.codeField[0]);
                this.codeField[0].requestFocus();
            } else {
                AndroidUtilities.hideKeyboard(this.codeField[0]);
            }
            destroyTimer();
            destroyCodeTimer();
            this.lastCurrentTime = System.currentTimeMillis();
            int i10 = this.currentType;
            if (i10 == 1) {
                this.problemText.setVisibility(0);
                this.timeText.setVisibility(8);
                return;
            }
            if (i10 == 3 && ((i2 = this.nextType) == 4 || i2 == 2)) {
                this.problemText.setVisibility(8);
                this.timeText.setVisibility(0);
                int i11 = this.nextType;
                if (i11 == 4) {
                    this.timeText.setText(LocaleController.formatString("CallText", R.string.CallText, 1, 0));
                } else if (i11 == 2) {
                    this.timeText.setText(LocaleController.formatString("SmsText", R.string.SmsText, 1, 0));
                }
                createTimer();
                return;
            }
            if (i10 == 2 && ((i = this.nextType) == 4 || i == 3)) {
                this.timeText.setText(LocaleController.formatString("CallText", R.string.CallText, 2, 0));
                this.problemText.setVisibility(this.time < 1000 ? 0 : 8);
                this.timeText.setVisibility(this.time >= 1000 ? 0 : 8);
                createTimer();
                return;
            }
            if (i10 == 4 && this.nextType == 2) {
                this.timeText.setText(LocaleController.formatString("SmsText", R.string.SmsText, 2, 0));
                this.problemText.setVisibility(this.time < 1000 ? 0 : 8);
                this.timeText.setVisibility(this.time >= 1000 ? 0 : 8);
                createTimer();
                return;
            }
            this.timeText.setVisibility(8);
            this.problemText.setVisibility(8);
            createCodeTimer();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$setParams$4(int i, View view, int i2, KeyEvent keyEvent) {
            if (i2 != 67 || this.codeField[i].length() != 0 || i <= 0) {
                return false;
            }
            EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
            int i3 = i - 1;
            editTextBoldCursorArr[i3].setSelection(editTextBoldCursorArr[i3].length());
            this.codeField[i3].requestFocus();
            this.codeField[i3].dispatchKeyEvent(keyEvent);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$setParams$5(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 5) {
                return false;
            }
            onNextPressed();
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void createCodeTimer() {
            if (this.codeTimer != null) {
                return;
            }
            this.codeTime = 15000;
            this.codeTimer = new Timer();
            this.lastCodeTime = System.currentTimeMillis();
            this.codeTimer.schedule(new AnonymousClass4(), 0L, 1000L);
        }

        /* renamed from: org.rbmain.ui.ChangePhoneActivity$LoginActivitySmsView$4, reason: invalid class name */
        class AnonymousClass4 extends TimerTask {
            AnonymousClass4() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChangePhoneActivity$LoginActivitySmsView$4$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$0();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$run$0() {
                double dCurrentTimeMillis = System.currentTimeMillis();
                double d = LoginActivitySmsView.this.lastCodeTime;
                Double.isNaN(dCurrentTimeMillis);
                LoginActivitySmsView.this.lastCodeTime = dCurrentTimeMillis;
                LoginActivitySmsView.access$2426(LoginActivitySmsView.this, dCurrentTimeMillis - d);
                if (LoginActivitySmsView.this.codeTime <= 1000) {
                    LoginActivitySmsView.this.problemText.setVisibility(0);
                    LoginActivitySmsView.this.timeText.setVisibility(8);
                    LoginActivitySmsView.this.destroyCodeTimer();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroyCodeTimer() {
            try {
                synchronized (this.timerSync) {
                    Timer timer = this.codeTimer;
                    if (timer != null) {
                        timer.cancel();
                        this.codeTimer = null;
                    }
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        private void createTimer() {
            if (this.timeTimer != null) {
                return;
            }
            Timer timer = new Timer();
            this.timeTimer = timer;
            timer.schedule(new AnonymousClass5(), 0L, 1000L);
        }

        /* renamed from: org.rbmain.ui.ChangePhoneActivity$LoginActivitySmsView$5, reason: invalid class name */
        class AnonymousClass5 extends TimerTask {
            AnonymousClass5() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (LoginActivitySmsView.this.timeTimer == null) {
                    return;
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChangePhoneActivity$LoginActivitySmsView$5$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$2();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$run$2() {
                double dCurrentTimeMillis = System.currentTimeMillis();
                double d = LoginActivitySmsView.this.lastCurrentTime;
                Double.isNaN(dCurrentTimeMillis);
                LoginActivitySmsView.access$3026(LoginActivitySmsView.this, dCurrentTimeMillis - d);
                LoginActivitySmsView.this.lastCurrentTime = dCurrentTimeMillis;
                if (LoginActivitySmsView.this.time >= 1000) {
                    int i = (LoginActivitySmsView.this.time / CloseCodes.NORMAL_CLOSURE) / 60;
                    int i2 = (LoginActivitySmsView.this.time / CloseCodes.NORMAL_CLOSURE) - (i * 60);
                    if (LoginActivitySmsView.this.nextType == 4 || LoginActivitySmsView.this.nextType == 3) {
                        LoginActivitySmsView.this.timeText.setText(LocaleController.formatString("CallText", R.string.CallText, Integer.valueOf(i), Integer.valueOf(i2)));
                    } else if (LoginActivitySmsView.this.nextType == 2) {
                        LoginActivitySmsView.this.timeText.setText(LocaleController.formatString("SmsText", R.string.SmsText, Integer.valueOf(i), Integer.valueOf(i2)));
                    }
                    if (LoginActivitySmsView.this.progressView != null) {
                        LoginActivitySmsView.this.progressView.setProgress(1.0f - (LoginActivitySmsView.this.time / LoginActivitySmsView.this.timeout));
                        return;
                    }
                    return;
                }
                if (LoginActivitySmsView.this.progressView != null) {
                    LoginActivitySmsView.this.progressView.setProgress(1.0f);
                }
                LoginActivitySmsView.this.destroyTimer();
                if (LoginActivitySmsView.this.currentType != 3) {
                    if (LoginActivitySmsView.this.currentType == 2 || LoginActivitySmsView.this.currentType == 4) {
                        if (LoginActivitySmsView.this.nextType == 4 || LoginActivitySmsView.this.nextType == 2) {
                            if (LoginActivitySmsView.this.nextType == 4) {
                                LoginActivitySmsView.this.timeText.setText(LocaleController.getString("Calling", R.string.Calling));
                            } else {
                                LoginActivitySmsView.this.timeText.setText(LocaleController.getString("SendingSms", R.string.SendingSms));
                            }
                            LoginActivitySmsView.this.createCodeTimer();
                            TLRPC$TL_auth_resendCode tLRPC$TL_auth_resendCode = new TLRPC$TL_auth_resendCode();
                            tLRPC$TL_auth_resendCode.phone_number = LoginActivitySmsView.this.requestPhone;
                            tLRPC$TL_auth_resendCode.phone_code_hash = LoginActivitySmsView.this.phoneHash;
                            ConnectionsManager.getInstance(((BaseFragment) ChangePhoneActivity.this).currentAccount).sendRequest(tLRPC$TL_auth_resendCode, new RequestDelegate() { // from class: org.rbmain.ui.ChangePhoneActivity$LoginActivitySmsView$5$$ExternalSyntheticLambda2
                                @Override // org.rbmain.tgnet.RequestDelegate
                                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                                    this.f$0.lambda$run$1(tLObject, tLRPC$TL_error);
                                }
                            }, 2);
                            return;
                        }
                        if (LoginActivitySmsView.this.nextType == 3) {
                            AndroidUtilities.setWaitingForSms(false);
                            NotificationCenter.getGlobalInstance().removeObserver(LoginActivitySmsView.this, NotificationCenter.didReceiveSmsCode);
                            LoginActivitySmsView.this.waitingForEvent = false;
                            LoginActivitySmsView.this.destroyCodeTimer();
                            LoginActivitySmsView.this.resendCode();
                            return;
                        }
                        return;
                    }
                    return;
                }
                AndroidUtilities.setWaitingForCall(false);
                NotificationCenter.getGlobalInstance().removeObserver(LoginActivitySmsView.this, NotificationCenter.didReceiveCall);
                LoginActivitySmsView.this.waitingForEvent = false;
                LoginActivitySmsView.this.destroyCodeTimer();
                LoginActivitySmsView.this.resendCode();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$run$1(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
                if (tLRPC$TL_error == null || tLRPC$TL_error.text == null) {
                    return;
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChangePhoneActivity$LoginActivitySmsView$5$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$run$0(tLRPC$TL_error);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$run$0(TLRPC$TL_error tLRPC$TL_error) {
                LoginActivitySmsView.this.lastError = tLRPC$TL_error.text;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void destroyTimer() {
            try {
                synchronized (this.timerSync) {
                    Timer timer = this.timeTimer;
                    if (timer != null) {
                        timer.cancel();
                        this.timeTimer = null;
                    }
                }
            } catch (Exception e) {
                FileLog.e(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getCode() {
            if (this.codeField == null) {
                return BuildConfig.FLAVOR;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
                if (i < editTextBoldCursorArr.length) {
                    sb.append(PhoneFormat.stripExceptNumbers(editTextBoldCursorArr[i].getText().toString()));
                    i++;
                } else {
                    return sb.toString();
                }
            }
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void onNextPressed() {
            if (this.nextPressed) {
                return;
            }
            String code = getCode();
            if (TextUtils.isEmpty(code)) {
                AndroidUtilities.shakeView(this.codeFieldContainer, 2.0f, 0);
                return;
            }
            this.nextPressed = true;
            int i = this.currentType;
            if (i == 2) {
                AndroidUtilities.setWaitingForSms(false);
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didReceiveSmsCode);
            } else if (i == 3) {
                AndroidUtilities.setWaitingForCall(false);
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didReceiveCall);
            }
            this.waitingForEvent = false;
            final TLRPC$TL_account_changePhone tLRPC$TL_account_changePhone = new TLRPC$TL_account_changePhone();
            tLRPC$TL_account_changePhone.phone_number = this.requestPhone;
            tLRPC$TL_account_changePhone.phone_code = code;
            tLRPC$TL_account_changePhone.phone_code_hash = this.phoneHash;
            destroyTimer();
            ChangePhoneActivity.this.needShowProgress();
            ContactsProxy.getInstance(((BaseFragment) ChangePhoneActivity.this).currentAccount).verifyChangePhoneNumber(tLRPC$TL_account_changePhone, new RequestDelegate() { // from class: org.rbmain.ui.ChangePhoneActivity$LoginActivitySmsView$$ExternalSyntheticLambda9
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$onNextPressed$7(tLRPC$TL_account_changePhone, tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onNextPressed$7(final TLRPC$TL_account_changePhone tLRPC$TL_account_changePhone, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChangePhoneActivity$LoginActivitySmsView$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onNextPressed$6(tLRPC$TL_error, tLObject, tLRPC$TL_account_changePhone);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onNextPressed$6(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, TLRPC$TL_account_changePhone tLRPC$TL_account_changePhone) {
            int i;
            int i2;
            ChangePhoneActivity.this.needHideProgress();
            this.nextPressed = false;
            if (tLRPC$TL_error == null) {
                TLRPC$User tLRPC$User = (TLRPC$User) tLObject;
                destroyTimer();
                destroyCodeTimer();
                UserConfig.getInstance(((BaseFragment) ChangePhoneActivity.this).currentAccount).setCurrentUser(tLRPC$User);
                UserConfig.getInstance(((BaseFragment) ChangePhoneActivity.this).currentAccount).saveConfig(true);
                ArrayList<TLRPC$User> arrayList = new ArrayList<>();
                arrayList.add(tLRPC$User);
                MessagesStorage.getInstance(((BaseFragment) ChangePhoneActivity.this).currentAccount).putUsersAndChats(arrayList, null, true, true);
                MessagesController.getInstance(((BaseFragment) ChangePhoneActivity.this).currentAccount).putUser(tLRPC$User, false);
                ChangePhoneActivity.this.finishFragment();
                NotificationCenter.getInstance(((BaseFragment) ChangePhoneActivity.this).currentAccount).postNotificationName(NotificationCenter.mainUserInfoChanged, new Object[0]);
                return;
            }
            this.lastError = tLRPC$TL_error.text;
            int i3 = this.currentType;
            if ((i3 == 3 && ((i2 = this.nextType) == 4 || i2 == 2)) || ((i3 == 2 && ((i = this.nextType) == 4 || i == 3)) || (i3 == 4 && this.nextType == 2))) {
                createTimer();
            }
            int i4 = this.currentType;
            if (i4 == 2) {
                AndroidUtilities.setWaitingForSms(true);
                NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didReceiveSmsCode);
            } else if (i4 == 3) {
                AndroidUtilities.setWaitingForCall(true);
                NotificationCenter.getGlobalInstance().addObserver(this, NotificationCenter.didReceiveCall);
            }
            this.waitingForEvent = true;
            if (this.currentType != 3) {
                AlertsCreator.processError(((BaseFragment) ChangePhoneActivity.this).currentAccount, tLRPC$TL_error, ChangePhoneActivity.this, tLRPC$TL_account_changePhone, new Object[0]);
            }
            if (!tLRPC$TL_error.text.contains("PHONE_CODE_EMPTY") && !tLRPC$TL_error.text.contains("PHONE_CODE_INVALID")) {
                if (tLRPC$TL_error.text.contains("PHONE_CODE_EXPIRED")) {
                    onBackPressed(true);
                    ChangePhoneActivity.this.setPage(0, true, null, true);
                    return;
                }
                return;
            }
            int i5 = 0;
            while (true) {
                EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
                if (i5 < editTextBoldCursorArr.length) {
                    editTextBoldCursorArr[i5].setText(BuildConfig.FLAVOR);
                    i5++;
                } else {
                    editTextBoldCursorArr[0].requestFocus();
                    return;
                }
            }
        }

        @Override // org.rbmain.ui.Components.SlideView
        public boolean onBackPressed(boolean z) {
            if (!z) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChangePhoneActivity.this.getParentActivity());
                builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
                builder.setMessage(LocaleController.getString("StopVerification", R.string.StopVerification));
                builder.setPositiveButton(LocaleController.getString("Continue", R.string.Continue), null);
                builder.setNegativeButton(LocaleController.getString("Stop", R.string.Stop), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.ChangePhoneActivity$LoginActivitySmsView$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$onBackPressed$8(dialogInterface, i);
                    }
                });
                ChangePhoneActivity.this.showDialog(builder.create());
                return false;
            }
            TLRPC$TL_auth_cancelCode tLRPC$TL_auth_cancelCode = new TLRPC$TL_auth_cancelCode();
            tLRPC$TL_auth_cancelCode.phone_number = this.requestPhone;
            tLRPC$TL_auth_cancelCode.phone_code_hash = this.phoneHash;
            ConnectionsManager.getInstance(((BaseFragment) ChangePhoneActivity.this).currentAccount).sendRequest(tLRPC$TL_auth_cancelCode, new RequestDelegate() { // from class: org.rbmain.ui.ChangePhoneActivity$LoginActivitySmsView$$ExternalSyntheticLambda10
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    ChangePhoneActivity.LoginActivitySmsView.lambda$onBackPressed$9(tLObject, tLRPC$TL_error);
                }
            }, 10);
            destroyTimer();
            destroyCodeTimer();
            int i = this.currentType;
            if (i == 2) {
                AndroidUtilities.setWaitingForSms(false);
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didReceiveSmsCode);
            } else if (i == 3) {
                AndroidUtilities.setWaitingForCall(false);
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didReceiveCall);
            }
            this.waitingForEvent = false;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onBackPressed$8(DialogInterface dialogInterface, int i) {
            onBackPressed(true);
            ChangePhoneActivity.this.setPage(0, true, null, true);
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void onDestroyActivity() {
            super.onDestroyActivity();
            int i = this.currentType;
            if (i == 2) {
                AndroidUtilities.setWaitingForSms(false);
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didReceiveSmsCode);
            } else if (i == 3) {
                AndroidUtilities.setWaitingForCall(false);
                NotificationCenter.getGlobalInstance().removeObserver(this, NotificationCenter.didReceiveCall);
            }
            this.waitingForEvent = false;
            destroyTimer();
            destroyCodeTimer();
        }

        @Override // org.rbmain.ui.Components.SlideView
        public void onShow() {
            super.onShow();
            if (this.currentType == 3) {
                return;
            }
            RLottieDrawable rLottieDrawable = this.hintDrawable;
            if (rLottieDrawable != null) {
                rLottieDrawable.setCurrentFrame(0);
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.ChangePhoneActivity$LoginActivitySmsView$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onShow$10();
                }
            }, 100L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onShow$10() {
            EditTextBoldCursor[] editTextBoldCursorArr = this.codeField;
            if (editTextBoldCursorArr != null) {
                for (int length = editTextBoldCursorArr.length - 1; length >= 0; length--) {
                    if (length == 0 || this.codeField[length].length() != 0) {
                        this.codeField[length].requestFocus();
                        EditTextBoldCursor[] editTextBoldCursorArr2 = this.codeField;
                        editTextBoldCursorArr2[length].setSelection(editTextBoldCursorArr2[length].length());
                        AndroidUtilities.showKeyboard(this.codeField[length]);
                        break;
                    }
                }
            }
            RLottieDrawable rLottieDrawable = this.hintDrawable;
            if (rLottieDrawable != null) {
                rLottieDrawable.start();
            }
        }

        @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
        public void didReceivedNotification(int i, int i2, Object... objArr) {
            EditTextBoldCursor[] editTextBoldCursorArr;
            if (!this.waitingForEvent || (editTextBoldCursorArr = this.codeField) == null) {
                return;
            }
            if (i == NotificationCenter.didReceiveSmsCode) {
                editTextBoldCursorArr[0].setText(BuildConfig.FLAVOR + objArr[0]);
                onNextPressed();
                return;
            }
            if (i == NotificationCenter.didReceiveCall) {
                String str = BuildConfig.FLAVOR + objArr[0];
                if (AndroidUtilities.checkPhonePattern(this.pattern, str)) {
                    this.ignoreOnTextChange = true;
                    this.codeField[0].setText(str);
                    this.ignoreOnTextChange = false;
                    onNextPressed();
                }
            }
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        SlideView[] slideViewArr = this.views;
        PhoneView phoneView = (PhoneView) slideViewArr[0];
        LoginActivitySmsView loginActivitySmsView = (LoginActivitySmsView) slideViewArr[1];
        LoginActivitySmsView loginActivitySmsView2 = (LoginActivitySmsView) slideViewArr[2];
        LoginActivitySmsView loginActivitySmsView3 = (LoginActivitySmsView) slideViewArr[3];
        LoginActivitySmsView loginActivitySmsView4 = (LoginActivitySmsView) slideViewArr[4];
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        ThemeDescription.ThemeDescriptionDelegate themeDescriptionDelegate = new ThemeDescription.ThemeDescriptionDelegate() { // from class: org.rbmain.ui.ChangePhoneActivity$$ExternalSyntheticLambda0
            @Override // org.rbmain.ui.ActionBar.ThemeDescription.ThemeDescriptionDelegate
            public final void didSetColor() {
                this.f$0.lambda$getThemeDescriptions$0();
            }
        };
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundWhite));
        ActionBar actionBar = this.actionBar;
        int i = ThemeDescription.FLAG_BACKGROUND;
        int i2 = Theme.key_actionBarDefault;
        arrayList.add(new ThemeDescription(actionBar, i, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        TextView textView = phoneView.countryButton;
        int i3 = ThemeDescription.FLAG_TEXTCOLOR;
        int i4 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(textView, i3, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(phoneView.countryButton, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, Theme.key_listSelector));
        arrayList.add(new ThemeDescription(phoneView.view, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundWhiteGrayLine));
        arrayList.add(new ThemeDescription(phoneView.textView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(phoneView.codeField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i4));
        EditTextBoldCursor editTextBoldCursor = phoneView.codeField;
        int i5 = ThemeDescription.FLAG_BACKGROUNDFILTER;
        int i6 = Theme.key_windowBackgroundWhiteInputField;
        arrayList.add(new ThemeDescription(editTextBoldCursor, i5, null, null, null, null, i6));
        EditTextBoldCursor editTextBoldCursor2 = phoneView.codeField;
        int i7 = ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE;
        int i8 = Theme.key_windowBackgroundWhiteInputFieldActivated;
        arrayList.add(new ThemeDescription(editTextBoldCursor2, i7, null, null, null, null, i8));
        arrayList.add(new ThemeDescription(phoneView.phoneField, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(phoneView.phoneField, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteHintText));
        arrayList.add(new ThemeDescription(phoneView.phoneField, ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, i6));
        arrayList.add(new ThemeDescription(phoneView.phoneField, ThemeDescription.FLAG_BACKGROUNDFILTER | ThemeDescription.FLAG_DRAWABLESELECTEDSTATE, null, null, null, null, i8));
        TextView textView2 = phoneView.textView2;
        int i9 = ThemeDescription.FLAG_TEXTCOLOR;
        int i10 = Theme.key_windowBackgroundWhiteGrayText6;
        arrayList.add(new ThemeDescription(textView2, i9, null, null, null, null, i10));
        arrayList.add(new ThemeDescription(loginActivitySmsView.confirmTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i10));
        arrayList.add(new ThemeDescription(loginActivitySmsView.titleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i4));
        if (loginActivitySmsView.codeField != null) {
            for (int i11 = 0; i11 < loginActivitySmsView.codeField.length; i11++) {
                arrayList.add(new ThemeDescription(loginActivitySmsView.codeField[i11], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlackText));
                arrayList.add(new ThemeDescription(loginActivitySmsView.codeField[i11], ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_windowBackgroundWhiteInputFieldActivated));
            }
        }
        TextView textView3 = loginActivitySmsView.timeText;
        int i12 = ThemeDescription.FLAG_TEXTCOLOR;
        int i13 = Theme.key_windowBackgroundWhiteGrayText6;
        arrayList.add(new ThemeDescription(textView3, i12, null, null, null, null, i13));
        arrayList.add(new ThemeDescription(loginActivitySmsView.problemText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlueText4));
        arrayList.add(new ThemeDescription(loginActivitySmsView.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_login_progressInner));
        arrayList.add(new ThemeDescription(loginActivitySmsView.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_login_progressOuter));
        ImageView imageView = loginActivitySmsView.blackImageView;
        int i14 = ThemeDescription.FLAG_IMAGECOLOR;
        int i15 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(imageView, i14, null, null, null, null, i15));
        arrayList.add(new ThemeDescription(loginActivitySmsView.blueImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, Theme.key_chats_actionBackground));
        arrayList.add(new ThemeDescription(loginActivitySmsView2.confirmTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i13));
        arrayList.add(new ThemeDescription(loginActivitySmsView2.titleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i15));
        if (loginActivitySmsView2.codeField != null) {
            for (int i16 = 0; i16 < loginActivitySmsView2.codeField.length; i16++) {
                arrayList.add(new ThemeDescription(loginActivitySmsView2.codeField[i16], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlackText));
                arrayList.add(new ThemeDescription(loginActivitySmsView2.codeField[i16], ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_windowBackgroundWhiteInputFieldActivated));
            }
        }
        TextView textView4 = loginActivitySmsView2.timeText;
        int i17 = ThemeDescription.FLAG_TEXTCOLOR;
        int i18 = Theme.key_windowBackgroundWhiteGrayText6;
        arrayList.add(new ThemeDescription(textView4, i17, null, null, null, null, i18));
        arrayList.add(new ThemeDescription(loginActivitySmsView2.problemText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlueText4));
        arrayList.add(new ThemeDescription(loginActivitySmsView2.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_login_progressInner));
        arrayList.add(new ThemeDescription(loginActivitySmsView2.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_login_progressOuter));
        ImageView imageView2 = loginActivitySmsView2.blackImageView;
        int i19 = ThemeDescription.FLAG_IMAGECOLOR;
        int i20 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(imageView2, i19, null, null, null, null, i20));
        arrayList.add(new ThemeDescription(loginActivitySmsView2.blueImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, Theme.key_chats_actionBackground));
        arrayList.add(new ThemeDescription(loginActivitySmsView3.confirmTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i18));
        arrayList.add(new ThemeDescription(loginActivitySmsView3.titleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i20));
        if (loginActivitySmsView3.codeField != null) {
            for (int i21 = 0; i21 < loginActivitySmsView3.codeField.length; i21++) {
                arrayList.add(new ThemeDescription(loginActivitySmsView3.codeField[i21], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlackText));
                arrayList.add(new ThemeDescription(loginActivitySmsView3.codeField[i21], ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_windowBackgroundWhiteInputFieldActivated));
            }
        }
        TextView textView5 = loginActivitySmsView3.timeText;
        int i22 = ThemeDescription.FLAG_TEXTCOLOR;
        int i23 = Theme.key_windowBackgroundWhiteGrayText6;
        arrayList.add(new ThemeDescription(textView5, i22, null, null, null, null, i23));
        arrayList.add(new ThemeDescription(loginActivitySmsView3.problemText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlueText4));
        arrayList.add(new ThemeDescription(loginActivitySmsView3.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_login_progressInner));
        arrayList.add(new ThemeDescription(loginActivitySmsView3.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_login_progressOuter));
        ImageView imageView3 = loginActivitySmsView3.blackImageView;
        int i24 = ThemeDescription.FLAG_IMAGECOLOR;
        int i25 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(imageView3, i24, null, null, null, null, i25));
        arrayList.add(new ThemeDescription(loginActivitySmsView3.blueImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, Theme.key_chats_actionBackground));
        arrayList.add(new ThemeDescription(loginActivitySmsView4.confirmTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i23));
        arrayList.add(new ThemeDescription(loginActivitySmsView4.titleTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i25));
        if (loginActivitySmsView4.codeField != null) {
            for (int i26 = 0; i26 < loginActivitySmsView4.codeField.length; i26++) {
                arrayList.add(new ThemeDescription(loginActivitySmsView4.codeField[i26], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlackText));
                arrayList.add(new ThemeDescription(loginActivitySmsView4.codeField[i26], ThemeDescription.FLAG_BACKGROUNDFILTER, null, null, null, null, Theme.key_windowBackgroundWhiteInputFieldActivated));
            }
        }
        arrayList.add(new ThemeDescription(loginActivitySmsView4.timeText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteGrayText6));
        arrayList.add(new ThemeDescription(loginActivitySmsView4.problemText, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlueText4));
        arrayList.add(new ThemeDescription(loginActivitySmsView4.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_login_progressInner));
        arrayList.add(new ThemeDescription(loginActivitySmsView4.progressView, 0, new Class[]{ProgressView.class}, new String[]{"paint"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_login_progressOuter));
        arrayList.add(new ThemeDescription(loginActivitySmsView4.blackImageView, ThemeDescription.FLAG_IMAGECOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlackText));
        RLottieImageView rLottieImageView = loginActivitySmsView4.blueImageView;
        int i27 = ThemeDescription.FLAG_IMAGECOLOR;
        int i28 = Theme.key_chats_actionBackground;
        arrayList.add(new ThemeDescription(rLottieImageView, i27, null, null, null, null, i28));
        arrayList.add(new ThemeDescription(loginActivitySmsView4.blueImageView, 0, null, null, null, themeDescriptionDelegate, i28));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getThemeDescriptions$0() {
        LoginActivityAppp.LoginActivityApppSmsView loginActivityApppSmsView;
        RLottieDrawable rLottieDrawable;
        int i = 0;
        while (true) {
            SlideView[] slideViewArr = this.views;
            if (i >= slideViewArr.length) {
                return;
            }
            if ((slideViewArr[i] instanceof LoginActivityAppp.LoginActivityApppSmsView) && (rLottieDrawable = (loginActivityApppSmsView = (LoginActivityAppp.LoginActivityApppSmsView) slideViewArr[i]).hintDrawable) != null) {
                int i2 = Theme.key_chats_actionBackground;
                rLottieDrawable.setLayerColor("Bubble.**", Theme.getColor(i2));
                loginActivityApppSmsView.hintDrawable.setLayerColor("Phone.**", Theme.getColor(i2));
            }
            i++;
        }
    }
}
