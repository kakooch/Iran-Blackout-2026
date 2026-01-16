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
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Property;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wallet.AutoResolveHelper;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.PaymentData;
import com.google.android.gms.wallet.PaymentDataRequest;
import com.google.android.gms.wallet.PaymentsClient;
import com.google.android.gms.wallet.Wallet;
import com.stripe.android.Stripe;
import com.stripe.android.TokenCallback;
import com.stripe.android.exception.APIConnectionException;
import com.stripe.android.exception.APIException;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;
import com.stripe.android.net.TokenParser;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import j$.util.Optional;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rbmain.PhoneFormat.PhoneFormat;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.FileLog;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.messenger.SRPHelper;
import org.rbmain.messenger.SharedConfig;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$InputPaymentCredentials;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$PasswordKdfAlgo;
import org.rbmain.tgnet.TLRPC$TL_account_confirmPasswordEmail;
import org.rbmain.tgnet.TLRPC$TL_account_getPassword;
import org.rbmain.tgnet.TLRPC$TL_account_getTmpPassword;
import org.rbmain.tgnet.TLRPC$TL_account_password;
import org.rbmain.tgnet.TLRPC$TL_account_passwordInputSettings;
import org.rbmain.tgnet.TLRPC$TL_account_resendPasswordEmail;
import org.rbmain.tgnet.TLRPC$TL_account_tmpPassword;
import org.rbmain.tgnet.TLRPC$TL_account_updatePasswordSettings;
import org.rbmain.tgnet.TLRPC$TL_boolTrue;
import org.rbmain.tgnet.TLRPC$TL_dataJSON;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_inputCheckPasswordEmpty;
import org.rbmain.tgnet.TLRPC$TL_inputCheckPasswordSRP;
import org.rbmain.tgnet.TLRPC$TL_inputPaymentCredentialsGooglePay;
import org.rbmain.tgnet.TLRPC$TL_invoice;
import org.rbmain.tgnet.TLRPC$TL_labeledPrice;
import org.rbmain.tgnet.TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow;
import org.rbmain.tgnet.TLRPC$TL_paymentRequestedInfo;
import org.rbmain.tgnet.TLRPC$TL_paymentSavedCredentialsCard;
import org.rbmain.tgnet.TLRPC$TL_payments_clearSavedInfo;
import org.rbmain.tgnet.TLRPC$TL_payments_paymentForm;
import org.rbmain.tgnet.TLRPC$TL_payments_paymentReceipt;
import org.rbmain.tgnet.TLRPC$TL_payments_paymentResult;
import org.rbmain.tgnet.TLRPC$TL_payments_paymentVerificationNeeded;
import org.rbmain.tgnet.TLRPC$TL_payments_sendPaymentForm;
import org.rbmain.tgnet.TLRPC$TL_payments_validateRequestedInfo;
import org.rbmain.tgnet.TLRPC$TL_payments_validatedRequestedInfo;
import org.rbmain.tgnet.TLRPC$TL_postAddress;
import org.rbmain.tgnet.TLRPC$TL_shippingOption;
import org.rbmain.tgnet.TLRPC$TL_updateNewChannelMessage;
import org.rbmain.tgnet.TLRPC$TL_updateNewMessage;
import org.rbmain.tgnet.TLRPC$Update;
import org.rbmain.tgnet.TLRPC$Updates;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.ui.ActionBar.ActionBar;
import org.rbmain.ui.ActionBar.ActionBarMenuItem;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.ActionBar.BottomSheet;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.ActionBar.ThemeDescription;
import org.rbmain.ui.Cells.EditTextSettingsCell;
import org.rbmain.ui.Cells.HeaderCell;
import org.rbmain.ui.Cells.PaymentInfoCell;
import org.rbmain.ui.Cells.RadioCell;
import org.rbmain.ui.Cells.ShadowSectionCell;
import org.rbmain.ui.Cells.TextCheckCell;
import org.rbmain.ui.Cells.TextDetailSettingsCell;
import org.rbmain.ui.Cells.TextInfoPrivacyCell;
import org.rbmain.ui.Cells.TextPriceCell;
import org.rbmain.ui.Cells.TextSettingsCell;
import org.rbmain.ui.Components.AlertsCreator;
import org.rbmain.ui.Components.ContextProgressView;
import org.rbmain.ui.Components.EditTextBoldCursor;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.CountrySelectActivity;

/* loaded from: classes4.dex */
public class PaymentFormActivity extends BaseFragment implements NotificationCenter.NotificationCenterDelegate {
    private TLRPC$User botUser;
    private TextInfoPrivacyCell[] bottomCell;
    private FrameLayout bottomLayout;
    private boolean canceled;
    private String cardName;
    private TextCheckCell checkCell1;
    private EditTextSettingsCell codeFieldCell;
    private HashMap<String, String> codesMap;
    private ArrayList<String> countriesArray;
    private HashMap<String, String> countriesMap;
    private String countryName;
    private String currentBotName;
    private String currentItemName;
    private TLRPC$TL_account_password currentPassword;
    private int currentStep;
    private PaymentFormActivityDelegate delegate;
    private TextDetailSettingsCell[] detailSettingsCell;
    private ArrayList<View> dividers;
    private ActionBarMenuItem doneItem;
    private AnimatorSet doneItemAnimation;
    private boolean donePressed;
    private int emailCodeLength;
    private FrameLayout googlePayButton;
    private FrameLayout googlePayContainer;
    private String googlePayCountryCode;
    private TLRPC$TL_inputPaymentCredentialsGooglePay googlePayCredentials;
    private JSONObject googlePayParameters;
    private String googlePayPublicKey;
    private HeaderCell[] headerCell;
    private boolean ignoreOnCardChange;
    private boolean ignoreOnPhoneChange;
    private boolean ignoreOnTextChange;
    private boolean initGooglePay;
    private EditTextBoldCursor[] inputFields;
    private boolean isWebView;
    private LinearLayout linearLayout2;
    private boolean loadingPasswordInfo;
    private MessageObject messageObject;
    private boolean need_card_country;
    private boolean need_card_name;
    private boolean need_card_postcode;
    private BaseFragment parentFragment;
    private PaymentFormActivity passwordFragment;
    private boolean passwordOk;
    private TextView payTextView;
    private TLRPC$TL_payments_paymentForm paymentForm;
    private PaymentInfoCell paymentInfoCell;
    private String paymentJson;
    private TLRPC$TL_payments_paymentReceipt paymentReceipt;
    private PaymentsClient paymentsClient;
    private HashMap<String, String> phoneFormatMap;
    private ArrayList<TLRPC$TL_labeledPrice> prices;
    private ContextProgressView progressView;
    private ContextProgressView progressViewButton;
    private String providerApiKey;
    private RadioCell[] radioCells;
    private TLRPC$TL_payments_validatedRequestedInfo requestedInfo;
    private boolean saveCardInfo;
    private boolean saveShippingInfo;
    private ScrollView scrollView;
    private ShadowSectionCell[] sectionCell;
    private TextSettingsCell[] settingsCell;
    private TLRPC$TL_shippingOption shippingOption;
    private Runnable shortPollRunnable;
    private boolean shouldNavigateBack;
    private boolean swipeBackEnabled;
    private TextView textView;
    private Long tipAmount;
    private LinearLayout tipLayout;
    private TextPriceCell totalCell;
    private String[] totalPrice;
    private TLRPC$TL_payments_validateRequestedInfo validateRequest;
    private boolean waitingForEmail;
    private WebView webView;
    private String webViewUrl;
    private boolean webviewLoading;

    private interface PaymentFormActivityDelegate {

        /* renamed from: org.rbmain.ui.PaymentFormActivity$PaymentFormActivityDelegate$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$currentPasswordUpdated(PaymentFormActivityDelegate paymentFormActivityDelegate, TLRPC$TL_account_password tLRPC$TL_account_password) {
            }

            public static void $default$didSelectNewAddress(PaymentFormActivityDelegate paymentFormActivityDelegate, TLRPC$TL_payments_validateRequestedInfo tLRPC$TL_payments_validateRequestedInfo) {
            }

            public static boolean $default$didSelectNewCard(PaymentFormActivityDelegate paymentFormActivityDelegate, String str, String str2, boolean z, TLRPC$TL_inputPaymentCredentialsGooglePay tLRPC$TL_inputPaymentCredentialsGooglePay) {
                return false;
            }

            public static void $default$onFragmentDestroyed(PaymentFormActivityDelegate paymentFormActivityDelegate) {
            }
        }

        void currentPasswordUpdated(TLRPC$TL_account_password tLRPC$TL_account_password);

        void didSelectNewAddress(TLRPC$TL_payments_validateRequestedInfo tLRPC$TL_payments_validateRequestedInfo);

        boolean didSelectNewCard(String str, String str2, boolean z, TLRPC$TL_inputPaymentCredentialsGooglePay tLRPC$TL_inputPaymentCredentialsGooglePay);

        void onFragmentDestroyed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createView$10(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createView$25(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendForm$46(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    class RubikaWebviewProxy {
        private RubikaWebviewProxy() {
        }

        @JavascriptInterface
        public void postEvent(final String str, final String str2) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PaymentFormActivity$RubikaWebviewProxy$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$postEvent$0(str, str2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$postEvent$0(String str, String str2) {
            if (PaymentFormActivity.this.getParentActivity() != null && str.equals("payment_form_submit")) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    JSONObject jSONObject2 = jSONObject.getJSONObject("credentials");
                    PaymentFormActivity.this.paymentJson = jSONObject2.toString();
                    PaymentFormActivity.this.cardName = jSONObject.getString("title");
                } catch (Throwable th) {
                    PaymentFormActivity.this.paymentJson = str2;
                    FileLog.e(th);
                }
                PaymentFormActivity.this.goToNextStep();
            }
        }
    }

    public class LinkSpan extends ClickableSpan {
        public LinkSpan() {
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            PaymentFormActivity.this.presentFragment(new TwoStepVerificationSetupActivity(6, PaymentFormActivity.this.currentPassword));
        }
    }

    public PaymentFormActivity(TLRPC$TL_payments_paymentReceipt tLRPC$TL_payments_paymentReceipt) {
        this.countriesArray = new ArrayList<>();
        this.countriesMap = new HashMap<>();
        this.codesMap = new HashMap<>();
        this.phoneFormatMap = new HashMap<>();
        this.swipeBackEnabled = true;
        this.headerCell = new HeaderCell[3];
        this.dividers = new ArrayList<>();
        this.sectionCell = new ShadowSectionCell[3];
        this.bottomCell = new TextInfoPrivacyCell[3];
        this.settingsCell = new TextSettingsCell[2];
        this.detailSettingsCell = new TextDetailSettingsCell[7];
        this.emailCodeLength = 6;
        this.currentStep = 5;
        TLRPC$TL_payments_paymentForm tLRPC$TL_payments_paymentForm = new TLRPC$TL_payments_paymentForm();
        this.paymentForm = tLRPC$TL_payments_paymentForm;
        this.paymentReceipt = tLRPC$TL_payments_paymentReceipt;
        tLRPC$TL_payments_paymentForm.bot_id = tLRPC$TL_payments_paymentReceipt.bot_id;
        tLRPC$TL_payments_paymentForm.invoice = tLRPC$TL_payments_paymentReceipt.invoice;
        tLRPC$TL_payments_paymentForm.provider_id = tLRPC$TL_payments_paymentReceipt.provider_id;
        tLRPC$TL_payments_paymentForm.users = tLRPC$TL_payments_paymentReceipt.users;
        this.shippingOption = tLRPC$TL_payments_paymentReceipt.shipping;
        long j = tLRPC$TL_payments_paymentReceipt.tip_amount;
        if (j != 0) {
            this.tipAmount = Long.valueOf(j);
        }
        TLRPC$User user = getMessagesController().getUser(Integer.valueOf(tLRPC$TL_payments_paymentReceipt.bot_id));
        this.botUser = user;
        if (user != null) {
            this.currentBotName = user.first_name;
        } else {
            this.currentBotName = BuildConfig.FLAVOR;
        }
        this.currentItemName = tLRPC$TL_payments_paymentReceipt.title;
        if (tLRPC$TL_payments_paymentReceipt.info != null) {
            TLRPC$TL_payments_validateRequestedInfo tLRPC$TL_payments_validateRequestedInfo = new TLRPC$TL_payments_validateRequestedInfo();
            this.validateRequest = tLRPC$TL_payments_validateRequestedInfo;
            tLRPC$TL_payments_validateRequestedInfo.peer = getMessagesController().getInputPeer(tLRPC$TL_payments_paymentReceipt.bot_id);
            this.validateRequest.info = tLRPC$TL_payments_paymentReceipt.info;
        }
        this.cardName = tLRPC$TL_payments_paymentReceipt.credentials_title;
    }

    public PaymentFormActivity(TLRPC$TL_payments_paymentForm tLRPC$TL_payments_paymentForm, MessageObject messageObject, BaseFragment baseFragment) {
        int i;
        this.countriesArray = new ArrayList<>();
        this.countriesMap = new HashMap<>();
        this.codesMap = new HashMap<>();
        this.phoneFormatMap = new HashMap<>();
        this.swipeBackEnabled = true;
        this.headerCell = new HeaderCell[3];
        this.dividers = new ArrayList<>();
        this.sectionCell = new ShadowSectionCell[3];
        this.bottomCell = new TextInfoPrivacyCell[3];
        this.settingsCell = new TextSettingsCell[2];
        this.detailSettingsCell = new TextDetailSettingsCell[7];
        this.emailCodeLength = 6;
        TLRPC$TL_invoice tLRPC$TL_invoice = tLRPC$TL_payments_paymentForm.invoice;
        if (tLRPC$TL_invoice.shipping_address_requested || tLRPC$TL_invoice.email_requested || tLRPC$TL_invoice.name_requested || tLRPC$TL_invoice.phone_requested) {
            i = 0;
        } else if (tLRPC$TL_payments_paymentForm.saved_credentials != null) {
            if (UserConfig.getInstance(this.currentAccount).tmpPassword != null && UserConfig.getInstance(this.currentAccount).tmpPassword.valid_until < ConnectionsManager.getInstance(this.currentAccount).getCurrentTime() + 60) {
                UserConfig.getInstance(this.currentAccount).tmpPassword = null;
                UserConfig.getInstance(this.currentAccount).saveConfig(false);
            }
            i = UserConfig.getInstance(this.currentAccount).tmpPassword != null ? 4 : 3;
        } else {
            i = 2;
        }
        init(tLRPC$TL_payments_paymentForm, messageObject, i, null, null, null, null, null, null, false, null, baseFragment);
    }

    private PaymentFormActivity(TLRPC$TL_payments_paymentForm tLRPC$TL_payments_paymentForm, MessageObject messageObject, int i, TLRPC$TL_payments_validatedRequestedInfo tLRPC$TL_payments_validatedRequestedInfo, TLRPC$TL_shippingOption tLRPC$TL_shippingOption, Long l, String str, String str2, TLRPC$TL_payments_validateRequestedInfo tLRPC$TL_payments_validateRequestedInfo, boolean z, TLRPC$TL_inputPaymentCredentialsGooglePay tLRPC$TL_inputPaymentCredentialsGooglePay, BaseFragment baseFragment) {
        this.countriesArray = new ArrayList<>();
        this.countriesMap = new HashMap<>();
        this.codesMap = new HashMap<>();
        this.phoneFormatMap = new HashMap<>();
        this.swipeBackEnabled = true;
        this.headerCell = new HeaderCell[3];
        this.dividers = new ArrayList<>();
        this.sectionCell = new ShadowSectionCell[3];
        this.bottomCell = new TextInfoPrivacyCell[3];
        this.settingsCell = new TextSettingsCell[2];
        this.detailSettingsCell = new TextDetailSettingsCell[7];
        this.emailCodeLength = 6;
        init(tLRPC$TL_payments_paymentForm, messageObject, i, tLRPC$TL_payments_validatedRequestedInfo, tLRPC$TL_shippingOption, l, str, str2, tLRPC$TL_payments_validateRequestedInfo, z, tLRPC$TL_inputPaymentCredentialsGooglePay, baseFragment);
    }

    private void setCurrentPassword(TLRPC$TL_account_password tLRPC$TL_account_password) {
        if (tLRPC$TL_account_password.has_password) {
            if (getParentActivity() == null) {
                return;
            }
            goToNextStep();
        } else {
            this.currentPassword = tLRPC$TL_account_password;
            this.waitingForEmail = !TextUtils.isEmpty(tLRPC$TL_account_password.email_unconfirmed_pattern);
            updatePasswordFields();
        }
    }

    private void setDelegate(PaymentFormActivityDelegate paymentFormActivityDelegate) {
        this.delegate = paymentFormActivityDelegate;
    }

    private void init(TLRPC$TL_payments_paymentForm tLRPC$TL_payments_paymentForm, MessageObject messageObject, int i, TLRPC$TL_payments_validatedRequestedInfo tLRPC$TL_payments_validatedRequestedInfo, TLRPC$TL_shippingOption tLRPC$TL_shippingOption, Long l, String str, String str2, TLRPC$TL_payments_validateRequestedInfo tLRPC$TL_payments_validateRequestedInfo, boolean z, TLRPC$TL_inputPaymentCredentialsGooglePay tLRPC$TL_inputPaymentCredentialsGooglePay, BaseFragment baseFragment) {
        this.currentStep = i;
        this.parentFragment = baseFragment;
        this.paymentJson = str;
        this.googlePayCredentials = tLRPC$TL_inputPaymentCredentialsGooglePay;
        this.requestedInfo = tLRPC$TL_payments_validatedRequestedInfo;
        this.paymentForm = tLRPC$TL_payments_paymentForm;
        this.shippingOption = tLRPC$TL_shippingOption;
        this.tipAmount = l;
        this.messageObject = messageObject;
        this.saveCardInfo = z;
        this.isWebView = ("stripe".equals(tLRPC$TL_payments_paymentForm.native_provider) || "smartglocal".equals(this.paymentForm.native_provider)) ? false : true;
        TLRPC$User user = getMessagesController().getUser(Integer.valueOf(tLRPC$TL_payments_paymentForm.bot_id));
        this.botUser = user;
        if (user != null) {
            this.currentBotName = user.first_name;
        } else {
            this.currentBotName = BuildConfig.FLAVOR;
        }
        this.currentItemName = messageObject.messageOwner.media.title;
        this.validateRequest = tLRPC$TL_payments_validateRequestedInfo;
        this.saveShippingInfo = true;
        if (z || this.currentStep == 4) {
            this.saveCardInfo = z;
        } else {
            this.saveCardInfo = this.paymentForm.saved_credentials != null;
        }
        if (str2 == null) {
            TLRPC$TL_paymentSavedCredentialsCard tLRPC$TL_paymentSavedCredentialsCard = tLRPC$TL_payments_paymentForm.saved_credentials;
            if (tLRPC$TL_paymentSavedCredentialsCard != null) {
                this.cardName = tLRPC$TL_paymentSavedCredentialsCard.title;
                return;
            }
            return;
        }
        this.cardName = str2;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onResume() {
        super.onResume();
        AndroidUtilities.requestAdjustResize(getParentActivity(), this.classGuid);
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                int i = this.currentStep;
                if ((i == 2 || i == 6) && !this.paymentForm.invoice.test) {
                    getParentActivity().getWindow().setFlags(8192, 8192);
                } else if (SharedConfig.passcodeHash.length() == 0 || SharedConfig.allowScreenCapture) {
                    getParentActivity().getWindow().clearFlags(8192);
                }
            } catch (Throwable th) {
                FileLog.e(th);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:451:0x0f67  */
    /* JADX WARN: Removed duplicated region for block: B:565:0x1837  */
    /* JADX WARN: Removed duplicated region for block: B:571:0x18af  */
    /* JADX WARN: Removed duplicated region for block: B:574:0x18cf  */
    /* JADX WARN: Removed duplicated region for block: B:578:0x18e7  */
    /* JADX WARN: Removed duplicated region for block: B:583:0x18ff  */
    /* JADX WARN: Removed duplicated region for block: B:592:0x194b  */
    /* JADX WARN: Removed duplicated region for block: B:595:0x1951  */
    /* JADX WARN: Removed duplicated region for block: B:625:0x1aa9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0318  */
    /* JADX WARN: Type inference failed for: r0v112, types: [org.rbmain.ui.Cells.TextDetailSettingsCell[]] */
    /* JADX WARN: Type inference failed for: r0v113, types: [org.rbmain.ui.Cells.TextDetailSettingsCell] */
    /* JADX WARN: Type inference failed for: r0v82, types: [android.widget.FrameLayout, org.rbmain.ui.ActionBar.ActionBarMenuItem] */
    /* JADX WARN: Type inference failed for: r0v95, types: [android.webkit.WebSettings] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r2v429, types: [android.view.View, android.view.ViewGroup, android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r2v433, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r2v434, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r2v471, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r3v38, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v146, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r9v301, types: [android.widget.LinearLayout] */
    @Override // org.rbmain.ui.ActionBar.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View createView(android.content.Context r32) throws org.json.JSONException, java.lang.NoSuchFieldException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 7158
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PaymentFormActivity.createView(android.content.Context):android.view.View");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$1(View view, MotionEvent motionEvent) {
        if (getParentActivity() == null) {
            return false;
        }
        if (motionEvent.getAction() == 1) {
            CountrySelectActivity countrySelectActivity = new CountrySelectActivity(false);
            countrySelectActivity.setCountrySelectActivityDelegate(new CountrySelectActivity.CountrySelectActivityDelegate() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda58
                @Override // org.rbmain.ui.CountrySelectActivity.CountrySelectActivityDelegate
                public final void didSelectCountry(String str, String str2) {
                    this.f$0.lambda$createView$0(str, str2);
                }
            });
            presentFragment(countrySelectActivity);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$0(String str, String str2) {
        this.inputFields[4].setText(str);
        this.countryName = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$2(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5) {
            if (i != 6) {
                return false;
            }
            this.doneItem.performClick();
            return true;
        }
        int iIntValue = ((Integer) textView.getTag()).intValue();
        while (true) {
            iIntValue++;
            EditTextBoldCursor[] editTextBoldCursorArr = this.inputFields;
            if (iIntValue < editTextBoldCursorArr.length) {
                if (iIntValue != 4 && ((View) editTextBoldCursorArr[iIntValue].getParent()).getVisibility() == 0) {
                    this.inputFields[iIntValue].requestFocus();
                    break;
                }
            } else {
                break;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$3(View view) {
        boolean z = !this.saveShippingInfo;
        this.saveShippingInfo = z;
        this.checkCell1.setChecked(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$4(View view) {
        boolean z = !this.saveCardInfo;
        this.saveCardInfo = z;
        this.checkCell1.setChecked(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$6(View view, MotionEvent motionEvent) {
        if (getParentActivity() == null) {
            return false;
        }
        if (motionEvent.getAction() == 1) {
            CountrySelectActivity countrySelectActivity = new CountrySelectActivity(false);
            countrySelectActivity.setCountrySelectActivityDelegate(new CountrySelectActivity.CountrySelectActivityDelegate() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda57
                @Override // org.rbmain.ui.CountrySelectActivity.CountrySelectActivityDelegate
                public final void didSelectCountry(String str, String str2) {
                    this.f$0.lambda$createView$5(str, str2);
                }
            });
            presentFragment(countrySelectActivity);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$5(String str, String str2) {
        this.inputFields[4].setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$7(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5) {
            if (i != 6) {
                return false;
            }
            this.doneItem.performClick();
            return true;
        }
        int iIntValue = ((Integer) textView.getTag()).intValue();
        while (true) {
            iIntValue++;
            EditTextBoldCursor[] editTextBoldCursorArr = this.inputFields;
            if (iIntValue >= editTextBoldCursorArr.length) {
                break;
            }
            if (iIntValue == 4) {
                iIntValue++;
            }
            if (((View) editTextBoldCursorArr[iIntValue].getParent()).getVisibility() == 0) {
                this.inputFields[iIntValue].requestFocus();
                break;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$8(View view) {
        boolean z = !this.saveCardInfo;
        this.saveCardInfo = z;
        this.checkCell1.setChecked(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$9(View view) {
        int iIntValue = ((Integer) view.getTag()).intValue();
        int i = 0;
        while (true) {
            RadioCell[] radioCellArr = this.radioCells;
            if (i >= radioCellArr.length) {
                return;
            }
            radioCellArr[i].setChecked(iIntValue == i, true);
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$11(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.doneItem.performClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$12(View view) {
        this.passwordOk = false;
        goToNextStep();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$13(View view) {
        this.inputFields[0].requestFocus();
        AndroidUtilities.showKeyboard(this.inputFields[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$createView$14(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        AndroidUtilities.hideKeyboard(textView);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$15(TextView textView, long j, View view) {
        long jLongValue = ((Long) textView.getTag()).longValue();
        Long l = this.tipAmount;
        if (l != null && jLongValue == l.longValue()) {
            this.ignoreOnTextChange = true;
            this.inputFields[0].setText(BuildConfig.FLAVOR);
            this.ignoreOnTextChange = false;
            this.tipAmount = 0L;
            updateTotalPrice();
        } else {
            this.inputFields[0].setText(LocaleController.getInstance().formatCurrencyString(j, false, true, true, this.paymentForm.invoice.currency));
        }
        EditTextBoldCursor[] editTextBoldCursorArr = this.inputFields;
        editTextBoldCursorArr[0].setSelection(editTextBoldCursorArr[0].length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$17(View view) {
        if (getParentActivity() == null) {
            return;
        }
        BottomSheet.Builder builder = new BottomSheet.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("PaymentCheckoutMethod", R.string.PaymentCheckoutMethod), true);
        builder.setItems(new CharSequence[]{this.cardName, LocaleController.getString("PaymentCheckoutMethodNewCard", R.string.PaymentCheckoutMethodNewCard)}, new int[]{R.drawable.payment_card, R.drawable.msg_addbot}, new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$createView$16(dialogInterface, i);
            }
        });
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$16(DialogInterface dialogInterface, int i) {
        if (i == 1) {
            PaymentFormActivity paymentFormActivity = new PaymentFormActivity(this.paymentForm, this.messageObject, 2, this.requestedInfo, this.shippingOption, this.tipAmount, null, this.cardName, this.validateRequest, this.saveCardInfo, null, this.parentFragment);
            paymentFormActivity.setDelegate(new PaymentFormActivityDelegate() { // from class: org.rbmain.ui.PaymentFormActivity.13
                @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
                public /* synthetic */ void currentPasswordUpdated(TLRPC$TL_account_password tLRPC$TL_account_password) {
                    PaymentFormActivityDelegate.CC.$default$currentPasswordUpdated(this, tLRPC$TL_account_password);
                }

                @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
                public /* synthetic */ void didSelectNewAddress(TLRPC$TL_payments_validateRequestedInfo tLRPC$TL_payments_validateRequestedInfo) {
                    PaymentFormActivityDelegate.CC.$default$didSelectNewAddress(this, tLRPC$TL_payments_validateRequestedInfo);
                }

                @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
                public /* synthetic */ void onFragmentDestroyed() {
                    PaymentFormActivityDelegate.CC.$default$onFragmentDestroyed(this);
                }

                @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
                public boolean didSelectNewCard(String str, String str2, boolean z, TLRPC$TL_inputPaymentCredentialsGooglePay tLRPC$TL_inputPaymentCredentialsGooglePay) {
                    PaymentFormActivity.this.paymentForm.saved_credentials = null;
                    PaymentFormActivity.this.paymentJson = str;
                    PaymentFormActivity.this.saveCardInfo = z;
                    PaymentFormActivity.this.cardName = str2;
                    PaymentFormActivity.this.googlePayCredentials = tLRPC$TL_inputPaymentCredentialsGooglePay;
                    PaymentFormActivity.this.detailSettingsCell[0].setTextAndValue(PaymentFormActivity.this.cardName, LocaleController.getString("PaymentCheckoutMethod", R.string.PaymentCheckoutMethod), true);
                    return false;
                }
            });
            presentFragment(paymentFormActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$18(View view) {
        PaymentFormActivity paymentFormActivity = new PaymentFormActivity(this.paymentForm, this.messageObject, 0, this.requestedInfo, this.shippingOption, this.tipAmount, null, this.cardName, this.validateRequest, this.saveCardInfo, null, this.parentFragment);
        paymentFormActivity.setDelegate(new PaymentFormActivityDelegate() { // from class: org.rbmain.ui.PaymentFormActivity.14
            @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ void currentPasswordUpdated(TLRPC$TL_account_password tLRPC$TL_account_password) {
                PaymentFormActivityDelegate.CC.$default$currentPasswordUpdated(this, tLRPC$TL_account_password);
            }

            @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ boolean didSelectNewCard(String str, String str2, boolean z, TLRPC$TL_inputPaymentCredentialsGooglePay tLRPC$TL_inputPaymentCredentialsGooglePay) {
                return PaymentFormActivityDelegate.CC.$default$didSelectNewCard(this, str, str2, z, tLRPC$TL_inputPaymentCredentialsGooglePay);
            }

            @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ void onFragmentDestroyed() {
                PaymentFormActivityDelegate.CC.$default$onFragmentDestroyed(this);
            }

            @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public void didSelectNewAddress(TLRPC$TL_payments_validateRequestedInfo tLRPC$TL_payments_validateRequestedInfo) {
                PaymentFormActivity.this.validateRequest = tLRPC$TL_payments_validateRequestedInfo;
                PaymentFormActivity.this.setAddressFields();
            }
        });
        presentFragment(paymentFormActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$19(View view) {
        PaymentFormActivity paymentFormActivity = new PaymentFormActivity(this.paymentForm, this.messageObject, 0, this.requestedInfo, this.shippingOption, this.tipAmount, null, this.cardName, this.validateRequest, this.saveCardInfo, null, this.parentFragment);
        paymentFormActivity.setDelegate(new PaymentFormActivityDelegate() { // from class: org.rbmain.ui.PaymentFormActivity.15
            @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ void currentPasswordUpdated(TLRPC$TL_account_password tLRPC$TL_account_password) {
                PaymentFormActivityDelegate.CC.$default$currentPasswordUpdated(this, tLRPC$TL_account_password);
            }

            @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ boolean didSelectNewCard(String str, String str2, boolean z, TLRPC$TL_inputPaymentCredentialsGooglePay tLRPC$TL_inputPaymentCredentialsGooglePay) {
                return PaymentFormActivityDelegate.CC.$default$didSelectNewCard(this, str, str2, z, tLRPC$TL_inputPaymentCredentialsGooglePay);
            }

            @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ void onFragmentDestroyed() {
                PaymentFormActivityDelegate.CC.$default$onFragmentDestroyed(this);
            }

            @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public void didSelectNewAddress(TLRPC$TL_payments_validateRequestedInfo tLRPC$TL_payments_validateRequestedInfo) {
                PaymentFormActivity.this.validateRequest = tLRPC$TL_payments_validateRequestedInfo;
                PaymentFormActivity.this.setAddressFields();
            }
        });
        presentFragment(paymentFormActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$20(View view) {
        PaymentFormActivity paymentFormActivity = new PaymentFormActivity(this.paymentForm, this.messageObject, 0, this.requestedInfo, this.shippingOption, this.tipAmount, null, this.cardName, this.validateRequest, this.saveCardInfo, null, this.parentFragment);
        paymentFormActivity.setDelegate(new PaymentFormActivityDelegate() { // from class: org.rbmain.ui.PaymentFormActivity.16
            @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ void currentPasswordUpdated(TLRPC$TL_account_password tLRPC$TL_account_password) {
                PaymentFormActivityDelegate.CC.$default$currentPasswordUpdated(this, tLRPC$TL_account_password);
            }

            @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ boolean didSelectNewCard(String str, String str2, boolean z, TLRPC$TL_inputPaymentCredentialsGooglePay tLRPC$TL_inputPaymentCredentialsGooglePay) {
                return PaymentFormActivityDelegate.CC.$default$didSelectNewCard(this, str, str2, z, tLRPC$TL_inputPaymentCredentialsGooglePay);
            }

            @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ void onFragmentDestroyed() {
                PaymentFormActivityDelegate.CC.$default$onFragmentDestroyed(this);
            }

            @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public void didSelectNewAddress(TLRPC$TL_payments_validateRequestedInfo tLRPC$TL_payments_validateRequestedInfo) {
                PaymentFormActivity.this.validateRequest = tLRPC$TL_payments_validateRequestedInfo;
                PaymentFormActivity.this.setAddressFields();
            }
        });
        presentFragment(paymentFormActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$21(View view) {
        PaymentFormActivity paymentFormActivity = new PaymentFormActivity(this.paymentForm, this.messageObject, 0, this.requestedInfo, this.shippingOption, this.tipAmount, null, this.cardName, this.validateRequest, this.saveCardInfo, null, this.parentFragment);
        paymentFormActivity.setDelegate(new PaymentFormActivityDelegate() { // from class: org.rbmain.ui.PaymentFormActivity.17
            @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ void currentPasswordUpdated(TLRPC$TL_account_password tLRPC$TL_account_password) {
                PaymentFormActivityDelegate.CC.$default$currentPasswordUpdated(this, tLRPC$TL_account_password);
            }

            @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ boolean didSelectNewCard(String str, String str2, boolean z, TLRPC$TL_inputPaymentCredentialsGooglePay tLRPC$TL_inputPaymentCredentialsGooglePay) {
                return PaymentFormActivityDelegate.CC.$default$didSelectNewCard(this, str, str2, z, tLRPC$TL_inputPaymentCredentialsGooglePay);
            }

            @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ void onFragmentDestroyed() {
                PaymentFormActivityDelegate.CC.$default$onFragmentDestroyed(this);
            }

            @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public void didSelectNewAddress(TLRPC$TL_payments_validateRequestedInfo tLRPC$TL_payments_validateRequestedInfo) {
                PaymentFormActivity.this.validateRequest = tLRPC$TL_payments_validateRequestedInfo;
                PaymentFormActivity.this.setAddressFields();
            }
        });
        presentFragment(paymentFormActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$23(String str, View view) {
        TLRPC$User tLRPC$User = this.botUser;
        if (tLRPC$User != null && !tLRPC$User.verified) {
            String str2 = "payment_warning_" + this.botUser.id;
            SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(this.currentAccount);
            if (!notificationsSettings.getBoolean(str2, false)) {
                notificationsSettings.edit().putBoolean(str2, true).apply();
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                builder.setTitle(LocaleController.getString("PaymentWarning", R.string.PaymentWarning));
                builder.setMessage(LocaleController.formatString("PaymentWarningText", R.string.PaymentWarningText, this.currentBotName, str));
                builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$createView$22(dialogInterface, i);
                    }
                });
                showDialog(builder.create());
                return;
            }
            showPayAlert(this.totalPrice[0]);
            return;
        }
        showPayAlert(this.totalPrice[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$22(DialogInterface dialogInterface, int i) {
        showPayAlert(this.totalPrice[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$24(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        sendSavePassword(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$26(View view) {
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLRPC$TL_account_resendPasswordEmail(), new RequestDelegate() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda55
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                PaymentFormActivity.lambda$createView$25(tLObject, tLRPC$TL_error);
            }
        });
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setMessage(LocaleController.getString("ResendCodeInfo", R.string.ResendCodeInfo));
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$28(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        String string = LocaleController.getString("TurnPasswordOffQuestion", R.string.TurnPasswordOffQuestion);
        if (this.currentPassword.has_secure_values) {
            string = string + "\n\n" + LocaleController.getString("TurnPasswordOffPassport", R.string.TurnPasswordOffPassport);
        }
        builder.setMessage(string);
        builder.setTitle(LocaleController.getString("TurnPasswordOffQuestionTitle", R.string.TurnPasswordOffQuestionTitle));
        builder.setPositiveButton(LocaleController.getString("Disable", R.string.Disable), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$createView$27(dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        AlertDialog alertDialogCreate = builder.create();
        showDialog(alertDialogCreate);
        TextView textView = (TextView) alertDialogCreate.getButton(-1);
        if (textView != null) {
            textView.setTextColor(Theme.getColor(Theme.key_text_RedBold));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createView$27(DialogInterface dialogInterface, int i) {
        sendSavePassword(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$createView$29(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            this.doneItem.performClick();
            return true;
        }
        if (i != 5) {
            return false;
        }
        int iIntValue = ((Integer) textView.getTag()).intValue();
        if (iIntValue == 0) {
            this.inputFields[1].requestFocus();
            return false;
        }
        if (iIntValue != 1) {
            return false;
        }
        this.inputFields[2].requestFocus();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAddressFields() {
        TLRPC$TL_postAddress tLRPC$TL_postAddress = this.validateRequest.info.shipping_address;
        if (tLRPC$TL_postAddress != null) {
            this.detailSettingsCell[2].setTextAndValueAndIcon(String.format("%s %s, %s, %s, %s, %s", tLRPC$TL_postAddress.street_line1, tLRPC$TL_postAddress.street_line2, tLRPC$TL_postAddress.city, tLRPC$TL_postAddress.state, tLRPC$TL_postAddress.country_iso2, tLRPC$TL_postAddress.post_code), LocaleController.getString("PaymentShippingAddress", R.string.PaymentShippingAddress), R.drawable.payment_address, true);
        }
        String str = this.validateRequest.info.name;
        if (str != null) {
            this.detailSettingsCell[3].setTextAndValueAndIcon(str, LocaleController.getString("PaymentCheckoutName", R.string.PaymentCheckoutName), R.drawable.payment_name, true);
        }
        if (this.validateRequest.info.phone != null) {
            this.detailSettingsCell[4].setTextAndValueAndIcon(PhoneFormat.getInstance().format(this.validateRequest.info.phone), LocaleController.getString("PaymentCheckoutPhoneNumber", R.string.PaymentCheckoutPhoneNumber), R.drawable.payment_phone, (this.validateRequest.info.email == null && this.shippingOption == null) ? false : true);
        }
        String str2 = this.validateRequest.info.email;
        if (str2 != null) {
            this.detailSettingsCell[5].setTextAndValueAndIcon(str2, LocaleController.getString("PaymentCheckoutEmail", R.string.PaymentCheckoutEmail), R.drawable.payment_email, this.shippingOption != null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTotalPrice() {
        this.totalPrice[0] = getTotalPriceString(this.prices);
        this.totalCell.setTextAndValue(LocaleController.getString("PaymentTransactionTotal", R.string.PaymentTransactionTotal), this.totalPrice[0], true);
        TextView textView = this.payTextView;
        if (textView != null) {
            textView.setText(LocaleController.formatString("PaymentCheckoutPay", R.string.PaymentCheckoutPay, this.totalPrice[0]));
        }
        if (this.tipLayout != null) {
            int color = Theme.getColor(Theme.key_contacts_inviteBackground);
            int childCount = this.tipLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                TextView textView2 = (TextView) this.tipLayout.getChildAt(i);
                if (textView2.getTag().equals(this.tipAmount)) {
                    Theme.setDrawableColor(textView2.getBackground(), color);
                    textView2.setTextColor(Theme.getColor(Theme.key_contacts_inviteText));
                } else {
                    Theme.setDrawableColor(textView2.getBackground(), 536870911 & color);
                    textView2.setTextColor(Theme.getColor(Theme.key_chats_secretName));
                }
                textView2.invalidate();
            }
        }
    }

    private void createGooglePayButton(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        this.googlePayContainer = frameLayout;
        frameLayout.setBackgroundDrawable(Theme.getSelectorDrawable(true));
        this.googlePayContainer.setVisibility(8);
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.googlePayButton = frameLayout2;
        frameLayout2.setClickable(true);
        this.googlePayButton.setFocusable(true);
        this.googlePayButton.setBackgroundResource(R.drawable.googlepay_button_no_shadow_background);
        if (this.googlePayPublicKey == null) {
            this.googlePayButton.setPadding(AndroidUtilities.dp(10.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(10.0f), AndroidUtilities.dp(2.0f));
        } else {
            this.googlePayButton.setPadding(AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f), AndroidUtilities.dp(2.0f));
        }
        this.googlePayContainer.addView(this.googlePayButton, LayoutHelper.createFrame(-1, 48.0f));
        this.googlePayButton.setOnClickListener(new View.OnClickListener() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException {
                this.f$0.lambda$createGooglePayButton$30(view);
            }
        });
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setWeightSum(2.0f);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(1);
        linearLayout.setDuplicateParentStateEnabled(true);
        this.googlePayButton.addView(linearLayout, LayoutHelper.createFrame(-1, -1.0f));
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setDuplicateParentStateEnabled(true);
        imageView.setImageResource(R.drawable.buy_with_googlepay_button_content);
        linearLayout.addView(imageView, LayoutHelper.createLinear(-1, 0, 1.0f));
        ImageView imageView2 = new ImageView(context);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView2.setDuplicateParentStateEnabled(true);
        imageView2.setImageResource(R.drawable.googlepay_button_overlay);
        this.googlePayButton.addView(imageView2, LayoutHelper.createFrame(-1, -1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createGooglePayButton$30(View view) throws JSONException {
        this.googlePayButton.setClickable(false);
        try {
            JSONObject baseRequest = getBaseRequest();
            JSONObject baseCardPaymentMethod = getBaseCardPaymentMethod();
            if (this.googlePayPublicKey != null && this.googlePayParameters == null) {
                baseCardPaymentMethod.put("tokenizationSpecification", new JSONObject() { // from class: org.rbmain.ui.PaymentFormActivity.22
                    {
                        put("type", "DIRECT");
                        put("parameters", new JSONObject() { // from class: org.rbmain.ui.PaymentFormActivity.22.1
                            {
                                put("protocolVersion", "ECv2");
                                put("publicKey", PaymentFormActivity.this.googlePayPublicKey);
                            }
                        });
                    }
                });
            } else {
                baseCardPaymentMethod.put("tokenizationSpecification", new JSONObject() { // from class: org.rbmain.ui.PaymentFormActivity.23
                    {
                        put("type", "PAYMENT_GATEWAY");
                        if (PaymentFormActivity.this.googlePayParameters != null) {
                            put("parameters", PaymentFormActivity.this.googlePayParameters);
                        } else {
                            put("parameters", new JSONObject() { // from class: org.rbmain.ui.PaymentFormActivity.23.1
                                {
                                    put("gateway", "stripe");
                                    put("stripe:publishableKey", PaymentFormActivity.this.providerApiKey);
                                    put("stripe:version", "3.5.0");
                                }
                            });
                        }
                    }
                });
            }
            baseRequest.put("allowedPaymentMethods", new JSONArray().put(baseCardPaymentMethod));
            JSONObject jSONObject = new JSONObject();
            ArrayList<TLRPC$TL_labeledPrice> arrayList = new ArrayList<>(this.paymentForm.invoice.prices);
            TLRPC$TL_shippingOption tLRPC$TL_shippingOption = this.shippingOption;
            if (tLRPC$TL_shippingOption != null) {
                arrayList.addAll(tLRPC$TL_shippingOption.prices);
            }
            jSONObject.put("totalPrice", getTotalPriceDecimalString(arrayList));
            jSONObject.put("totalPriceStatus", "FINAL");
            if (!TextUtils.isEmpty(this.googlePayCountryCode)) {
                jSONObject.put("countryCode", this.googlePayCountryCode);
            }
            jSONObject.put("currencyCode", this.paymentForm.invoice.currency);
            jSONObject.put("checkoutOption", "COMPLETE_IMMEDIATE_PURCHASE");
            baseRequest.put("transactionInfo", jSONObject);
            baseRequest.put("merchantInfo", new JSONObject().put("merchantName", this.currentBotName));
            PaymentDataRequest paymentDataRequestFromJson = PaymentDataRequest.fromJson(baseRequest.toString());
            if (paymentDataRequestFromJson != null) {
                AutoResolveHelper.resolveTask(this.paymentsClient.loadPaymentData(paymentDataRequestFromJson), getParentActivity(), 991);
            }
        } catch (JSONException e) {
            FileLog.e(e);
        }
    }

    private void updatePasswordFields() {
        if (this.currentStep != 6 || this.bottomCell[2] == null) {
            return;
        }
        int i = 0;
        this.doneItem.setVisibility(0);
        if (this.currentPassword == null) {
            showEditDoneProgress(true, true);
            this.bottomCell[2].setVisibility(8);
            this.settingsCell[0].setVisibility(8);
            this.settingsCell[1].setVisibility(8);
            this.codeFieldCell.setVisibility(8);
            this.headerCell[0].setVisibility(8);
            this.headerCell[1].setVisibility(8);
            this.bottomCell[0].setVisibility(8);
            for (int i2 = 0; i2 < 3; i2++) {
                ((View) this.inputFields[i2].getParent()).setVisibility(8);
            }
            while (i < this.dividers.size()) {
                this.dividers.get(i).setVisibility(8);
                i++;
            }
            return;
        }
        showEditDoneProgress(true, false);
        if (this.waitingForEmail) {
            TextInfoPrivacyCell textInfoPrivacyCell = this.bottomCell[2];
            Object[] objArr = new Object[1];
            String str = this.currentPassword.email_unconfirmed_pattern;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            objArr[0] = str;
            textInfoPrivacyCell.setText(LocaleController.formatString("EmailPasswordConfirmText2", R.string.EmailPasswordConfirmText2, objArr));
            this.bottomCell[2].setVisibility(0);
            this.settingsCell[0].setVisibility(0);
            this.settingsCell[1].setVisibility(0);
            this.codeFieldCell.setVisibility(0);
            this.bottomCell[1].setText(BuildConfig.FLAVOR);
            this.headerCell[0].setVisibility(8);
            this.headerCell[1].setVisibility(8);
            this.bottomCell[0].setVisibility(8);
            for (int i3 = 0; i3 < 3; i3++) {
                ((View) this.inputFields[i3].getParent()).setVisibility(8);
            }
            while (i < this.dividers.size()) {
                this.dividers.get(i).setVisibility(8);
                i++;
            }
            return;
        }
        this.bottomCell[2].setVisibility(8);
        this.settingsCell[0].setVisibility(8);
        this.settingsCell[1].setVisibility(8);
        this.bottomCell[1].setText(LocaleController.getString("PaymentPasswordEmailInfo", R.string.PaymentPasswordEmailInfo));
        this.codeFieldCell.setVisibility(8);
        this.headerCell[0].setVisibility(0);
        this.headerCell[1].setVisibility(0);
        this.bottomCell[0].setVisibility(0);
        for (int i4 = 0; i4 < 3; i4++) {
            ((View) this.inputFields[i4].getParent()).setVisibility(0);
        }
        for (int i5 = 0; i5 < this.dividers.size(); i5++) {
            this.dividers.get(i5).setVisibility(0);
        }
    }

    private void loadPasswordInfo() {
        if (this.loadingPasswordInfo) {
            return;
        }
        this.loadingPasswordInfo = true;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLRPC$TL_account_getPassword(), new RequestDelegate() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda48
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadPasswordInfo$33(tLObject, tLRPC$TL_error);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPasswordInfo$33(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda39
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadPasswordInfo$32(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPasswordInfo$32(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        this.loadingPasswordInfo = false;
        if (tLRPC$TL_error == null) {
            TLRPC$TL_account_password tLRPC$TL_account_password = (TLRPC$TL_account_password) tLObject;
            this.currentPassword = tLRPC$TL_account_password;
            if (!TwoStepVerificationActivity.canHandleCurrentPassword(tLRPC$TL_account_password, false)) {
                AlertsCreator.showUpdateAppAlert(getParentActivity(), LocaleController.getString("UpdateAppAlert", R.string.UpdateAppAlert), true);
                return;
            }
            TLRPC$TL_payments_paymentForm tLRPC$TL_payments_paymentForm = this.paymentForm;
            if (tLRPC$TL_payments_paymentForm != null && this.currentPassword.has_password) {
                tLRPC$TL_payments_paymentForm.password_missing = false;
                tLRPC$TL_payments_paymentForm.can_save_credentials = true;
                updateSavePaymentField();
            }
            TwoStepVerificationActivity.initPasswordNewAlgo(this.currentPassword);
            PaymentFormActivity paymentFormActivity = this.passwordFragment;
            if (paymentFormActivity != null) {
                paymentFormActivity.setCurrentPassword(this.currentPassword);
            }
            if (this.currentPassword.has_password || this.shortPollRunnable != null) {
                return;
            }
            Runnable runnable = new Runnable() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda31
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadPasswordInfo$31();
                }
            };
            this.shortPollRunnable = runnable;
            AndroidUtilities.runOnUIThread(runnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadPasswordInfo$31() {
        if (this.shortPollRunnable == null) {
            return;
        }
        loadPasswordInfo();
        this.shortPollRunnable = null;
    }

    private void showAlertWithText(String str, String str2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.setTitle(str);
        builder.setMessage(str2);
        showDialog(builder.create());
    }

    private void showPayAlert(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("PaymentTransactionReview", R.string.PaymentTransactionReview));
        builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("PaymentTransactionMessage2", R.string.PaymentTransactionMessage2, str, this.currentBotName, this.currentItemName)));
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showPayAlert$34(dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPayAlert$34(DialogInterface dialogInterface, int i) {
        setDonePressed(true);
        sendData();
    }

    private JSONObject getBaseRequest() throws JSONException {
        return new JSONObject().put("apiVersion", 2).put("apiVersionMinor", 0);
    }

    private JSONObject getBaseCardPaymentMethod() throws JSONException {
        List listAsList = Arrays.asList("AMEX", "DISCOVER", "JCB", "MASTERCARD", "VISA");
        List listAsList2 = Arrays.asList("PAN_ONLY", "CRYPTOGRAM_3DS");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "CARD");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("allowedAuthMethods", new JSONArray((Collection) listAsList2));
        jSONObject2.put("allowedCardNetworks", new JSONArray((Collection) listAsList));
        jSONObject.put("parameters", jSONObject2);
        return jSONObject;
    }

    public Optional<JSONObject> getIsReadyToPayRequest() throws JSONException {
        try {
            JSONObject baseRequest = getBaseRequest();
            baseRequest.put("allowedPaymentMethods", new JSONArray().put(getBaseCardPaymentMethod()));
            return Optional.of(baseRequest);
        } catch (JSONException unused) {
            return Optional.empty();
        }
    }

    private void initGooglePay(Context context) throws JSONException {
        IsReadyToPayRequest isReadyToPayRequestFromJson;
        if (Build.VERSION.SDK_INT < 19 || getParentActivity() == null) {
            return;
        }
        this.paymentsClient = Wallet.getPaymentsClient(context, new Wallet.WalletOptions.Builder().setEnvironment(this.paymentForm.invoice.test ? 3 : 1).setTheme(1).build());
        Optional<JSONObject> isReadyToPayRequest = getIsReadyToPayRequest();
        if (isReadyToPayRequest.isPresent() && (isReadyToPayRequestFromJson = IsReadyToPayRequest.fromJson(isReadyToPayRequest.get().toString())) != null) {
            this.paymentsClient.isReadyToPay(isReadyToPayRequestFromJson).addOnCompleteListener(getParentActivity(), new OnCompleteListener() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda30
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    this.f$0.lambda$initGooglePay$35(task);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initGooglePay$35(Task task) {
        if (task.isSuccessful()) {
            FrameLayout frameLayout = this.googlePayContainer;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ObjectAnimator.ofFloat(this.googlePayContainer, (Property<FrameLayout, Float>) View.ALPHA, 0.0f, 1.0f));
                animatorSet.setInterpolator(new DecelerateInterpolator());
                animatorSet.setDuration(180L);
                animatorSet.start();
                return;
            }
            return;
        }
        FileLog.e("isReadyToPay failed", task.getException());
    }

    private String getTotalPriceString(ArrayList<TLRPC$TL_labeledPrice> arrayList) {
        long jLongValue = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            jLongValue += arrayList.get(i).amount;
        }
        Long l = this.tipAmount;
        if (l != null) {
            jLongValue += l.longValue();
        }
        return LocaleController.getInstance().formatCurrencyString(jLongValue, this.paymentForm.invoice.currency);
    }

    private String getTotalPriceDecimalString(ArrayList<TLRPC$TL_labeledPrice> arrayList) {
        long j = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            j += arrayList.get(i).amount;
        }
        return LocaleController.getInstance().formatCurrencyDecimalString(j, this.paymentForm.invoice.currency, false);
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.twoStepPasswordChanged);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.didRemoveTwoStepPassword);
        if (this.currentStep != 4) {
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.paymentFinished);
        }
        return super.onFragmentCreate();
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() {
        PaymentFormActivityDelegate paymentFormActivityDelegate = this.delegate;
        if (paymentFormActivityDelegate != null) {
            paymentFormActivityDelegate.onFragmentDestroyed();
        }
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.twoStepPasswordChanged);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.didRemoveTwoStepPassword);
        if (this.currentStep != 4) {
            NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.paymentFinished);
        }
        WebView webView = this.webView;
        if (webView != null) {
            try {
                ViewParent parent = webView.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(this.webView);
                }
                this.webView.stopLoading();
                this.webView.loadUrl("about:blank");
                this.webViewUrl = null;
                this.webView.destroy();
                this.webView = null;
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
        try {
            int i = this.currentStep;
            if ((i == 2 || i == 6) && Build.VERSION.SDK_INT >= 23 && (SharedConfig.passcodeHash.length() == 0 || SharedConfig.allowScreenCapture)) {
                getParentActivity().getWindow().clearFlags(8192);
            }
        } catch (Throwable th) {
            FileLog.e(th);
        }
        super.onFragmentDestroy();
        this.canceled = true;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationEnd(boolean z, boolean z2) {
        if (!z || z2) {
            return;
        }
        WebView webView = this.webView;
        if (webView != null) {
            if (this.currentStep != 4) {
                String str = this.paymentForm.url;
                this.webViewUrl = str;
                webView.loadUrl(str);
                return;
            }
            return;
        }
        int i = this.currentStep;
        if (i == 2) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda32
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onTransitionAnimationEnd$36();
                }
            }, 100L);
            return;
        }
        if (i == 3) {
            this.inputFields[1].requestFocus();
            AndroidUtilities.showKeyboard(this.inputFields[1]);
            return;
        }
        if (i == 4) {
            EditTextBoldCursor[] editTextBoldCursorArr = this.inputFields;
            if (editTextBoldCursorArr != null) {
                editTextBoldCursorArr[0].requestFocus();
                return;
            }
            return;
        }
        if (i != 6 || this.waitingForEmail) {
            return;
        }
        this.inputFields[0].requestFocus();
        AndroidUtilities.showKeyboard(this.inputFields[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTransitionAnimationEnd$36() {
        this.inputFields[0].requestFocus();
        AndroidUtilities.showKeyboard(this.inputFields[0]);
    }

    @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int i, int i2, Object... objArr) {
        if (i == NotificationCenter.twoStepPasswordChanged) {
            TLRPC$TL_payments_paymentForm tLRPC$TL_payments_paymentForm = this.paymentForm;
            tLRPC$TL_payments_paymentForm.password_missing = false;
            tLRPC$TL_payments_paymentForm.can_save_credentials = true;
            updateSavePaymentField();
            return;
        }
        if (i == NotificationCenter.didRemoveTwoStepPassword) {
            TLRPC$TL_payments_paymentForm tLRPC$TL_payments_paymentForm2 = this.paymentForm;
            tLRPC$TL_payments_paymentForm2.password_missing = true;
            tLRPC$TL_payments_paymentForm2.can_save_credentials = false;
            updateSavePaymentField();
            return;
        }
        if (i == NotificationCenter.paymentFinished) {
            removeSelfFromStack();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int i, final int i2, final Intent intent) {
        if (i == 991) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda33
                @Override // java.lang.Runnable
                public final void run() throws JSONException {
                    this.f$0.lambda$onActivityResultFragment$37(i2, intent);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v5, types: [org.rbmain.tgnet.TLRPC$InputPaymentCredentials, org.rbmain.tgnet.TLRPC$TL_inputPaymentCredentialsGooglePay] */
    public /* synthetic */ void lambda$onActivityResultFragment$37(int i, Intent intent) throws JSONException {
        String json;
        if (i == -1) {
            PaymentData fromIntent = PaymentData.getFromIntent(intent);
            if (fromIntent == null || (json = fromIntent.toJson()) == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(json).getJSONObject("paymentMethodData");
                JSONObject jSONObject2 = jSONObject.getJSONObject("tokenizationData");
                jSONObject2.getString("type");
                String string = jSONObject2.getString("token");
                if (this.googlePayPublicKey != null || this.googlePayParameters != null) {
                    ?? r2 = new TLRPC$InputPaymentCredentials() { // from class: org.rbmain.tgnet.TLRPC$TL_inputPaymentCredentialsGooglePay
                        public static int constructor = -1966921727;

                        @Override // org.rbmain.tgnet.TLObject
                        public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
                            this.payment_token = TLRPC$TL_dataJSON.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                        }

                        @Override // org.rbmain.tgnet.TLObject
                        public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                            abstractSerializedData.writeInt32(constructor);
                            this.payment_token.serializeToStream(abstractSerializedData);
                        }
                    };
                    this.googlePayCredentials = r2;
                    r2.payment_token = new TLRPC$TL_dataJSON();
                    this.googlePayCredentials.payment_token.data = jSONObject2.toString();
                    String strOptString = jSONObject.optString("description");
                    if (!TextUtils.isEmpty(strOptString)) {
                        this.cardName = strOptString;
                    } else {
                        this.cardName = "Android Pay";
                    }
                } else {
                    Token token = TokenParser.parseToken(string);
                    this.paymentJson = String.format(Locale.US, "{\"type\":\"%1$s\", \"id\":\"%2$s\"}", token.getType(), token.getId());
                    Card card = token.getCard();
                    this.cardName = card.getType() + " *" + card.getLast4();
                }
                goToNextStep();
            } catch (JSONException e) {
                FileLog.e(e);
            }
        } else if (i == 1) {
            Status statusFromIntent = AutoResolveHelper.getStatusFromIntent(intent);
            StringBuilder sb = new StringBuilder();
            sb.append("android pay error ");
            sb.append(statusFromIntent != null ? statusFromIntent.getStatusMessage() : BuildConfig.FLAVOR);
            FileLog.e(sb.toString());
        }
        showEditDoneProgress(true, false);
        setDonePressed(false);
        this.googlePayButton.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToNextStep() {
        boolean z;
        int i;
        int i2;
        int i3 = this.currentStep;
        if (i3 == 0) {
            PaymentFormActivityDelegate paymentFormActivityDelegate = this.delegate;
            if (paymentFormActivityDelegate != null) {
                paymentFormActivityDelegate.didSelectNewAddress(this.validateRequest);
                finishFragment();
                return;
            }
            TLRPC$TL_payments_paymentForm tLRPC$TL_payments_paymentForm = this.paymentForm;
            if (tLRPC$TL_payments_paymentForm.invoice.flexible) {
                i2 = 1;
            } else if (tLRPC$TL_payments_paymentForm.saved_credentials != null) {
                if (UserConfig.getInstance(this.currentAccount).tmpPassword != null && UserConfig.getInstance(this.currentAccount).tmpPassword.valid_until < ConnectionsManager.getInstance(this.currentAccount).getCurrentTime() + 60) {
                    UserConfig.getInstance(this.currentAccount).tmpPassword = null;
                    UserConfig.getInstance(this.currentAccount).saveConfig(false);
                }
                i2 = UserConfig.getInstance(this.currentAccount).tmpPassword != null ? 4 : 3;
            } else {
                i2 = 2;
            }
            presentFragment(new PaymentFormActivity(this.paymentForm, this.messageObject, i2, this.requestedInfo, null, null, null, this.cardName, this.validateRequest, this.saveCardInfo, this.googlePayCredentials, this.parentFragment), this.isWebView);
            return;
        }
        if (i3 == 1) {
            if (this.paymentForm.saved_credentials != null) {
                if (UserConfig.getInstance(this.currentAccount).tmpPassword != null && UserConfig.getInstance(this.currentAccount).tmpPassword.valid_until < ConnectionsManager.getInstance(this.currentAccount).getCurrentTime() + 60) {
                    UserConfig.getInstance(this.currentAccount).tmpPassword = null;
                    UserConfig.getInstance(this.currentAccount).saveConfig(false);
                }
                i = UserConfig.getInstance(this.currentAccount).tmpPassword != null ? 4 : 3;
            } else {
                i = 2;
            }
            presentFragment(new PaymentFormActivity(this.paymentForm, this.messageObject, i, this.requestedInfo, this.shippingOption, this.tipAmount, null, this.cardName, this.validateRequest, this.saveCardInfo, this.googlePayCredentials, this.parentFragment), this.isWebView);
            return;
        }
        if (i3 != 2) {
            if (i3 == 3) {
                presentFragment(new PaymentFormActivity(this.paymentForm, this.messageObject, this.passwordOk ? 4 : 2, this.requestedInfo, this.shippingOption, this.tipAmount, this.paymentJson, this.cardName, this.validateRequest, this.saveCardInfo, this.googlePayCredentials, this.parentFragment), true);
                return;
            }
            if (i3 == 4) {
                NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.paymentFinished, new Object[0]);
                finishFragment();
                return;
            } else {
                if (i3 == 6) {
                    if (!this.delegate.didSelectNewCard(this.paymentJson, this.cardName, this.saveCardInfo, this.googlePayCredentials)) {
                        presentFragment(new PaymentFormActivity(this.paymentForm, this.messageObject, 4, this.requestedInfo, this.shippingOption, this.tipAmount, this.paymentJson, this.cardName, this.validateRequest, this.saveCardInfo, this.googlePayCredentials, this.parentFragment), true);
                        return;
                    } else {
                        finishFragment();
                        return;
                    }
                }
                return;
            }
        }
        TLRPC$TL_payments_paymentForm tLRPC$TL_payments_paymentForm2 = this.paymentForm;
        if (tLRPC$TL_payments_paymentForm2.password_missing && (z = this.saveCardInfo)) {
            PaymentFormActivity paymentFormActivity = new PaymentFormActivity(tLRPC$TL_payments_paymentForm2, this.messageObject, 6, this.requestedInfo, this.shippingOption, this.tipAmount, this.paymentJson, this.cardName, this.validateRequest, z, this.googlePayCredentials, this.parentFragment);
            this.passwordFragment = paymentFormActivity;
            paymentFormActivity.setCurrentPassword(this.currentPassword);
            this.passwordFragment.setDelegate(new PaymentFormActivityDelegate() { // from class: org.rbmain.ui.PaymentFormActivity.24
                @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
                public /* synthetic */ void didSelectNewAddress(TLRPC$TL_payments_validateRequestedInfo tLRPC$TL_payments_validateRequestedInfo) {
                    PaymentFormActivityDelegate.CC.$default$didSelectNewAddress(this, tLRPC$TL_payments_validateRequestedInfo);
                }

                @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
                public boolean didSelectNewCard(String str, String str2, boolean z2, TLRPC$TL_inputPaymentCredentialsGooglePay tLRPC$TL_inputPaymentCredentialsGooglePay) {
                    if (PaymentFormActivity.this.delegate != null) {
                        PaymentFormActivity.this.delegate.didSelectNewCard(str, str2, z2, tLRPC$TL_inputPaymentCredentialsGooglePay);
                    }
                    if (PaymentFormActivity.this.isWebView) {
                        PaymentFormActivity.this.removeSelfFromStack();
                    }
                    return PaymentFormActivity.this.delegate != null;
                }

                @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
                public void onFragmentDestroyed() {
                    PaymentFormActivity.this.passwordFragment = null;
                }

                @Override // org.rbmain.ui.PaymentFormActivity.PaymentFormActivityDelegate
                public void currentPasswordUpdated(TLRPC$TL_account_password tLRPC$TL_account_password) {
                    PaymentFormActivity.this.currentPassword = tLRPC$TL_account_password;
                }
            });
            presentFragment(this.passwordFragment, this.isWebView);
            return;
        }
        PaymentFormActivityDelegate paymentFormActivityDelegate2 = this.delegate;
        if (paymentFormActivityDelegate2 != null) {
            paymentFormActivityDelegate2.didSelectNewCard(this.paymentJson, this.cardName, this.saveCardInfo, this.googlePayCredentials);
            finishFragment();
        } else {
            presentFragment(new PaymentFormActivity(tLRPC$TL_payments_paymentForm2, this.messageObject, 4, this.requestedInfo, this.shippingOption, this.tipAmount, this.paymentJson, this.cardName, this.validateRequest, this.saveCardInfo, this.googlePayCredentials, this.parentFragment), this.isWebView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSavePaymentField() {
        if (this.bottomCell[0] == null || this.sectionCell[2] == null) {
            return;
        }
        TLRPC$TL_payments_paymentForm tLRPC$TL_payments_paymentForm = this.paymentForm;
        if ((tLRPC$TL_payments_paymentForm.password_missing || tLRPC$TL_payments_paymentForm.can_save_credentials) && (this.webView == null || !this.webviewLoading)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(LocaleController.getString("PaymentCardSavePaymentInformationInfoLine1", R.string.PaymentCardSavePaymentInformationInfoLine1));
            if (this.paymentForm.password_missing) {
                loadPasswordInfo();
                spannableStringBuilder.append((CharSequence) "\n");
                int length = spannableStringBuilder.length();
                String string = LocaleController.getString("PaymentCardSavePaymentInformationInfoLine2", R.string.PaymentCardSavePaymentInformationInfoLine2);
                int iIndexOf = string.indexOf(42);
                int iLastIndexOf = string.lastIndexOf(42);
                spannableStringBuilder.append((CharSequence) string);
                if (iIndexOf != -1 && iLastIndexOf != -1) {
                    int i = iIndexOf + length;
                    int i2 = iLastIndexOf + length;
                    this.bottomCell[0].getTextView().setMovementMethod(new AndroidUtilities.LinkMovementMethodMy());
                    spannableStringBuilder.replace(i2, i2 + 1, (CharSequence) BuildConfig.FLAVOR);
                    spannableStringBuilder.replace(i, i + 1, (CharSequence) BuildConfig.FLAVOR);
                    spannableStringBuilder.setSpan(new LinkSpan(), i, i2 - 1, 33);
                }
            }
            this.checkCell1.setEnabled(true);
            this.bottomCell[0].setText(spannableStringBuilder);
            this.checkCell1.setVisibility(0);
            this.bottomCell[0].setVisibility(0);
            ShadowSectionCell[] shadowSectionCellArr = this.sectionCell;
            shadowSectionCellArr[2].setBackgroundDrawable(Theme.getThemedDrawable(shadowSectionCellArr[2].getContext(), R.drawable.greydivider, Theme.key_windowBackgroundGrayShadow));
            return;
        }
        this.checkCell1.setVisibility(8);
        this.bottomCell[0].setVisibility(8);
        ShadowSectionCell[] shadowSectionCellArr2 = this.sectionCell;
        shadowSectionCellArr2[2].setBackgroundDrawable(Theme.getThemedDrawable(shadowSectionCellArr2[2].getContext(), R.drawable.greydivider_bottom, Theme.key_windowBackgroundGrayShadow));
    }

    public void fillNumber(String str) {
        boolean z;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) ApplicationLoader.applicationContext.getSystemService("phone");
            if (str == null && (telephonyManager.getSimState() == 1 || telephonyManager.getPhoneType() == 0)) {
                return;
            }
            boolean z2 = Build.VERSION.SDK_INT < 23 || getParentActivity().checkSelfPermission("android.permission.READ_PHONE_STATE") == 0;
            if (str != null || z2) {
                if (str == null) {
                    str = PhoneFormat.stripExceptNumbers(telephonyManager.getLine1Number());
                }
                String strSubstring = null;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                int i = 4;
                if (str.length() > 4) {
                    while (true) {
                        if (i < 1) {
                            z = false;
                            break;
                        }
                        String strSubstring2 = str.substring(0, i);
                        if (this.codesMap.get(strSubstring2) != null) {
                            strSubstring = str.substring(i);
                            this.inputFields[8].setText(strSubstring2);
                            z = true;
                            break;
                        }
                        i--;
                    }
                    if (!z) {
                        strSubstring = str.substring(1);
                        this.inputFields[8].setText(str.substring(0, 1));
                    }
                }
                if (strSubstring != null) {
                    this.inputFields[9].setText(strSubstring);
                    EditTextBoldCursor[] editTextBoldCursorArr = this.inputFields;
                    editTextBoldCursorArr[9].setSelection(editTextBoldCursorArr[9].length());
                }
            }
        } catch (Exception e) {
            FileLog.e(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSavePassword(final boolean z) {
        final String str;
        final String str2;
        if (!z && this.codeFieldCell.getVisibility() == 0) {
            String text = this.codeFieldCell.getText();
            if (text.length() == 0) {
                shakeView(this.codeFieldCell);
                return;
            }
            showEditDoneProgress(true, true);
            TLRPC$TL_account_confirmPasswordEmail tLRPC$TL_account_confirmPasswordEmail = new TLRPC$TL_account_confirmPasswordEmail();
            tLRPC$TL_account_confirmPasswordEmail.code = text;
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_confirmPasswordEmail, new RequestDelegate() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda47
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$sendSavePassword$39(tLObject, tLRPC$TL_error);
                }
            }, 10);
            return;
        }
        final TLRPC$TL_account_updatePasswordSettings tLRPC$TL_account_updatePasswordSettings = new TLRPC$TL_account_updatePasswordSettings();
        if (z) {
            this.doneItem.setVisibility(0);
            TLRPC$TL_account_passwordInputSettings tLRPC$TL_account_passwordInputSettings = new TLRPC$TL_account_passwordInputSettings();
            tLRPC$TL_account_updatePasswordSettings.new_settings = tLRPC$TL_account_passwordInputSettings;
            tLRPC$TL_account_passwordInputSettings.flags = 2;
            tLRPC$TL_account_passwordInputSettings.email = BuildConfig.FLAVOR;
            tLRPC$TL_account_updatePasswordSettings.password = new TLRPC$TL_inputCheckPasswordEmpty();
            str2 = null;
            str = null;
        } else {
            String string = this.inputFields[0].getText().toString();
            if (TextUtils.isEmpty(string)) {
                shakeField(0);
                return;
            }
            if (!string.equals(this.inputFields[1].getText().toString())) {
                try {
                    Toast.makeText(getParentActivity(), LocaleController.getString("PasswordDoNotMatch", R.string.PasswordDoNotMatch), 0).show();
                } catch (Exception e) {
                    FileLog.e(e);
                }
                shakeField(1);
                return;
            }
            String string2 = this.inputFields[2].getText().toString();
            if (string2.length() < 3) {
                shakeField(2);
                return;
            }
            int iLastIndexOf = string2.lastIndexOf(46);
            int iLastIndexOf2 = string2.lastIndexOf(64);
            if (iLastIndexOf2 < 0 || iLastIndexOf < iLastIndexOf2) {
                shakeField(2);
                return;
            }
            tLRPC$TL_account_updatePasswordSettings.password = new TLRPC$TL_inputCheckPasswordEmpty();
            TLRPC$TL_account_passwordInputSettings tLRPC$TL_account_passwordInputSettings2 = new TLRPC$TL_account_passwordInputSettings();
            tLRPC$TL_account_updatePasswordSettings.new_settings = tLRPC$TL_account_passwordInputSettings2;
            int i = tLRPC$TL_account_passwordInputSettings2.flags | 1;
            tLRPC$TL_account_passwordInputSettings2.flags = i;
            tLRPC$TL_account_passwordInputSettings2.hint = BuildConfig.FLAVOR;
            tLRPC$TL_account_passwordInputSettings2.new_algo = this.currentPassword.new_algo;
            tLRPC$TL_account_passwordInputSettings2.flags = i | 2;
            tLRPC$TL_account_passwordInputSettings2.email = string2.trim();
            str = string;
            str2 = string2;
        }
        showEditDoneProgress(true, true);
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda45
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendSavePassword$45(z, str2, str, tLRPC$TL_account_updatePasswordSettings);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendSavePassword$39(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda38
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendSavePassword$38(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendSavePassword$38(TLRPC$TL_error tLRPC$TL_error) {
        String pluralString;
        showEditDoneProgress(true, false);
        if (tLRPC$TL_error == null) {
            if (getParentActivity() == null) {
                return;
            }
            Runnable runnable = this.shortPollRunnable;
            if (runnable != null) {
                AndroidUtilities.cancelRunOnUIThread(runnable);
                this.shortPollRunnable = null;
            }
            goToNextStep();
            return;
        }
        if (tLRPC$TL_error.text.startsWith("CODE_INVALID")) {
            shakeView(this.codeFieldCell);
            this.codeFieldCell.setText(BuildConfig.FLAVOR, false);
        } else {
            if (tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
                int iIntValue = Utilities.parseInt(tLRPC$TL_error.text).intValue();
                if (iIntValue < 60) {
                    pluralString = LocaleController.formatPluralString("Seconds", iIntValue);
                } else {
                    pluralString = LocaleController.formatPluralString("Minutes", iIntValue / 60);
                }
                showAlertWithText(LocaleController.getString("AppName", R.string.AppName), LocaleController.formatString("FloodWaitTime", R.string.FloodWaitTime, pluralString));
                return;
            }
            showAlertWithText(LocaleController.getString("AppName", R.string.AppName), tLRPC$TL_error.text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendSavePassword$44(final boolean z, final String str, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda44
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendSavePassword$43(tLRPC$TL_error, z, tLObject, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendSavePassword$45(final boolean z, final String str, String str2, TLRPC$TL_account_updatePasswordSettings tLRPC$TL_account_updatePasswordSettings) {
        RequestDelegate requestDelegate = new RequestDelegate() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda54
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$sendSavePassword$44(z, str, tLObject, tLRPC$TL_error);
            }
        };
        if (!z) {
            byte[] stringBytes = AndroidUtilities.getStringBytes(str2);
            TLRPC$PasswordKdfAlgo tLRPC$PasswordKdfAlgo = this.currentPassword.new_algo;
            if (tLRPC$PasswordKdfAlgo instanceof TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) {
                tLRPC$TL_account_updatePasswordSettings.new_settings.new_password_hash = SRPHelper.getVBytes(stringBytes, (TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) tLRPC$PasswordKdfAlgo);
                if (tLRPC$TL_account_updatePasswordSettings.new_settings.new_password_hash == null) {
                    TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                    tLRPC$TL_error.text = "ALGO_INVALID";
                    requestDelegate.run(null, tLRPC$TL_error);
                }
                ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_updatePasswordSettings, requestDelegate, 10);
                return;
            }
            TLRPC$TL_error tLRPC$TL_error2 = new TLRPC$TL_error();
            tLRPC$TL_error2.text = "PASSWORD_HASH_INVALID";
            requestDelegate.run(null, tLRPC$TL_error2);
            return;
        }
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_updatePasswordSettings, requestDelegate, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendSavePassword$43(TLRPC$TL_error tLRPC$TL_error, final boolean z, TLObject tLObject, final String str) {
        String pluralString;
        if (tLRPC$TL_error != null && "SRP_ID_INVALID".equals(tLRPC$TL_error.text)) {
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLRPC$TL_account_getPassword(), new RequestDelegate() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda53
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$sendSavePassword$41(z, tLObject2, tLRPC$TL_error2);
                }
            }, 8);
            return;
        }
        showEditDoneProgress(true, false);
        if (z) {
            TLRPC$TL_account_password tLRPC$TL_account_password = this.currentPassword;
            tLRPC$TL_account_password.has_password = false;
            tLRPC$TL_account_password.current_algo = null;
            this.delegate.currentPasswordUpdated(tLRPC$TL_account_password);
            finishFragment();
            return;
        }
        if (tLRPC$TL_error == null && (tLObject instanceof TLRPC$TL_boolTrue)) {
            if (getParentActivity() == null) {
                return;
            }
            goToNextStep();
            return;
        }
        if (tLRPC$TL_error != null) {
            if (tLRPC$TL_error.text.equals("EMAIL_UNCONFIRMED") || tLRPC$TL_error.text.startsWith("EMAIL_UNCONFIRMED_")) {
                this.emailCodeLength = Utilities.parseInt(tLRPC$TL_error.text).intValue();
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda4
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$sendSavePassword$42(str, dialogInterface, i);
                    }
                });
                builder.setMessage(LocaleController.getString("YourEmailAlmostThereText", R.string.YourEmailAlmostThereText));
                builder.setTitle(LocaleController.getString("YourEmailAlmostThere", R.string.YourEmailAlmostThere));
                Dialog dialogShowDialog = showDialog(builder.create());
                if (dialogShowDialog != null) {
                    dialogShowDialog.setCanceledOnTouchOutside(false);
                    dialogShowDialog.setCancelable(false);
                    return;
                }
                return;
            }
            if (tLRPC$TL_error.text.equals("EMAIL_INVALID")) {
                showAlertWithText(LocaleController.getString("AppName", R.string.AppName), LocaleController.getString("PasswordEmailInvalid", R.string.PasswordEmailInvalid));
                return;
            }
            if (tLRPC$TL_error.text.startsWith("FLOOD_WAIT")) {
                int iIntValue = Utilities.parseInt(tLRPC$TL_error.text).intValue();
                if (iIntValue < 60) {
                    pluralString = LocaleController.formatPluralString("Seconds", iIntValue);
                } else {
                    pluralString = LocaleController.formatPluralString("Minutes", iIntValue / 60);
                }
                showAlertWithText(LocaleController.getString("AppName", R.string.AppName), LocaleController.formatString("FloodWaitTime", R.string.FloodWaitTime, pluralString));
                return;
            }
            showAlertWithText(LocaleController.getString("AppName", R.string.AppName), tLRPC$TL_error.text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendSavePassword$41(final boolean z, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda42
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendSavePassword$40(tLRPC$TL_error, tLObject, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendSavePassword$40(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, boolean z) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_account_password tLRPC$TL_account_password = (TLRPC$TL_account_password) tLObject;
            this.currentPassword = tLRPC$TL_account_password;
            TwoStepVerificationActivity.initPasswordNewAlgo(tLRPC$TL_account_password);
            sendSavePassword(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendSavePassword$42(String str, DialogInterface dialogInterface, int i) {
        this.waitingForEmail = true;
        this.currentPassword.email_unconfirmed_pattern = str;
        updatePasswordFields();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sendCardData() throws NumberFormatException {
        Integer num;
        Integer num2;
        String[] strArrSplit = this.inputFields[1].getText().toString().split("/");
        if (strArrSplit.length == 2) {
            Integer num3 = Utilities.parseInt(strArrSplit[0]);
            num2 = Utilities.parseInt(strArrSplit[1]);
            num = num3;
        } else {
            num = null;
            num2 = null;
        }
        final Card card = new Card(this.inputFields[0].getText().toString(), num, num2, this.inputFields[3].getText().toString(), this.inputFields[2].getText().toString(), null, null, null, null, this.inputFields[5].getText().toString(), this.inputFields[4].getText().toString(), null);
        this.cardName = card.getType() + " *" + card.getLast4();
        if (!card.validateNumber()) {
            shakeField(0);
            return false;
        }
        if (!card.validateExpMonth() || !card.validateExpYear() || !card.validateExpiryDate()) {
            shakeField(1);
            return false;
        }
        if (this.need_card_name && this.inputFields[2].length() == 0) {
            shakeField(2);
            return false;
        }
        if (!card.validateCVC()) {
            shakeField(3);
            return false;
        }
        if (this.need_card_country && this.inputFields[4].length() == 0) {
            shakeField(4);
            return false;
        }
        if (this.need_card_postcode && this.inputFields[5].length() == 0) {
            shakeField(5);
            return false;
        }
        showEditDoneProgress(true, true);
        try {
            if ("stripe".equals(this.paymentForm.native_provider)) {
                new Stripe(this.providerApiKey).createToken(card, new AnonymousClass25());
            } else if ("smartglocal".equals(this.paymentForm.native_provider)) {
                new AsyncTask<Object, Object, String>() { // from class: org.rbmain.ui.PaymentFormActivity.26
                    /* JADX INFO: Access modifiers changed from: protected */
                    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0139: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:37:0x0139 */
                    /* JADX WARN: Removed duplicated region for block: B:39:0x013c  */
                    @Override // android.os.AsyncTask
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public java.lang.String doInBackground(java.lang.Object... r13) throws java.lang.Throwable {
                        /*
                            Method dump skipped, instructions count: 320
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.ui.PaymentFormActivity.AnonymousClass26.doInBackground(java.lang.Object[]):java.lang.String");
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public void onPostExecute(String str) {
                        if (PaymentFormActivity.this.canceled) {
                            return;
                        }
                        if (str != null) {
                            PaymentFormActivity.this.paymentJson = str;
                            PaymentFormActivity.this.goToNextStep();
                        } else {
                            AlertsCreator.showSimpleToast(PaymentFormActivity.this, LocaleController.getString("PaymentConnectionFailed", R.string.PaymentConnectionFailed));
                        }
                        PaymentFormActivity.this.showEditDoneProgress(true, false);
                        PaymentFormActivity.this.setDonePressed(false);
                    }
                }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null, null, null);
            }
            return true;
        } catch (Exception e) {
            FileLog.e(e);
            return true;
        }
    }

    /* renamed from: org.rbmain.ui.PaymentFormActivity$25, reason: invalid class name */
    class AnonymousClass25 implements TokenCallback {
        AnonymousClass25() {
        }

        @Override // com.stripe.android.TokenCallback
        public void onSuccess(Token token) {
            if (PaymentFormActivity.this.canceled) {
                return;
            }
            PaymentFormActivity.this.paymentJson = String.format(Locale.US, "{\"type\":\"%1$s\", \"id\":\"%2$s\"}", token.getType(), token.getId());
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PaymentFormActivity$25$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onSuccess$0();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$0() {
            PaymentFormActivity.this.goToNextStep();
            PaymentFormActivity.this.showEditDoneProgress(true, false);
            PaymentFormActivity.this.setDonePressed(false);
        }

        @Override // com.stripe.android.TokenCallback
        public void onError(Exception exc) {
            if (PaymentFormActivity.this.canceled) {
                return;
            }
            PaymentFormActivity.this.showEditDoneProgress(true, false);
            PaymentFormActivity.this.setDonePressed(false);
            if ((exc instanceof APIConnectionException) || (exc instanceof APIException)) {
                AlertsCreator.showSimpleToast(PaymentFormActivity.this, LocaleController.getString("PaymentConnectionFailed", R.string.PaymentConnectionFailed));
            } else {
                AlertsCreator.showSimpleToast(PaymentFormActivity.this, exc.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getResponseBody(InputStream inputStream) throws IOException {
        String next = new Scanner(inputStream, Utf8Charset.NAME).useDelimiter("\\A").next();
        inputStream.close();
        return next;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendForm() {
        if (this.canceled) {
            return;
        }
        showEditDoneProgress(true, true);
        TLRPC$TL_payments_validateRequestedInfo tLRPC$TL_payments_validateRequestedInfo = new TLRPC$TL_payments_validateRequestedInfo();
        this.validateRequest = tLRPC$TL_payments_validateRequestedInfo;
        tLRPC$TL_payments_validateRequestedInfo.peer = getMessagesController().getInputPeer(this.messageObject.messageOwner.peer_id);
        TLRPC$TL_payments_validateRequestedInfo tLRPC$TL_payments_validateRequestedInfo2 = this.validateRequest;
        tLRPC$TL_payments_validateRequestedInfo2.save = this.saveShippingInfo;
        tLRPC$TL_payments_validateRequestedInfo2.msg_id = this.messageObject.getId();
        this.validateRequest.info = new TLRPC$TL_paymentRequestedInfo();
        if (this.paymentForm.invoice.name_requested) {
            this.validateRequest.info.name = this.inputFields[6].getText().toString();
            this.validateRequest.info.flags |= 1;
        }
        if (this.paymentForm.invoice.phone_requested) {
            this.validateRequest.info.phone = "+" + this.inputFields[8].getText().toString() + this.inputFields[9].getText().toString();
            TLRPC$TL_paymentRequestedInfo tLRPC$TL_paymentRequestedInfo = this.validateRequest.info;
            tLRPC$TL_paymentRequestedInfo.flags = tLRPC$TL_paymentRequestedInfo.flags | 2;
        }
        if (this.paymentForm.invoice.email_requested) {
            this.validateRequest.info.email = this.inputFields[7].getText().toString().trim();
            this.validateRequest.info.flags |= 4;
        }
        if (this.paymentForm.invoice.shipping_address_requested) {
            this.validateRequest.info.shipping_address = new TLRPC$TL_postAddress();
            this.validateRequest.info.shipping_address.street_line1 = this.inputFields[0].getText().toString();
            this.validateRequest.info.shipping_address.street_line2 = this.inputFields[1].getText().toString();
            this.validateRequest.info.shipping_address.city = this.inputFields[2].getText().toString();
            this.validateRequest.info.shipping_address.state = this.inputFields[3].getText().toString();
            TLRPC$TL_postAddress tLRPC$TL_postAddress = this.validateRequest.info.shipping_address;
            String str = this.countryName;
            if (str == null) {
                str = BuildConfig.FLAVOR;
            }
            tLRPC$TL_postAddress.country_iso2 = str;
            tLRPC$TL_postAddress.post_code = this.inputFields[5].getText().toString();
            this.validateRequest.info.flags |= 8;
        }
        final TLRPC$TL_payments_validateRequestedInfo tLRPC$TL_payments_validateRequestedInfo3 = this.validateRequest;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(this.validateRequest, new RequestDelegate() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda50
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$sendForm$49(tLRPC$TL_payments_validateRequestedInfo3, tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendForm$49(final TLObject tLObject, final TLObject tLObject2, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject2 instanceof TLRPC$TL_payments_validatedRequestedInfo) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda35
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$sendForm$47(tLObject2);
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda40
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$sendForm$48(tLRPC$TL_error, tLObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendForm$47(TLObject tLObject) {
        this.requestedInfo = (TLRPC$TL_payments_validatedRequestedInfo) tLObject;
        if (this.paymentForm.saved_info != null && !this.saveShippingInfo) {
            TLRPC$TL_payments_clearSavedInfo tLRPC$TL_payments_clearSavedInfo = new TLRPC$TL_payments_clearSavedInfo();
            tLRPC$TL_payments_clearSavedInfo.info = true;
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_payments_clearSavedInfo, new RequestDelegate() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda56
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
                    PaymentFormActivity.lambda$sendForm$46(tLObject2, tLRPC$TL_error);
                }
            });
        }
        goToNextStep();
        setDonePressed(false);
        showEditDoneProgress(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendForm$48(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
        setDonePressed(false);
        showEditDoneProgress(true, false);
        if (tLRPC$TL_error != null) {
            String str = tLRPC$TL_error.text;
            str.hashCode();
            switch (str) {
                case "ADDRESS_CITY_INVALID":
                    shakeField(2);
                    break;
                case "ADDRESS_STREET_LINE1_INVALID":
                    shakeField(0);
                    break;
                case "ADDRESS_COUNTRY_INVALID":
                    shakeField(4);
                    break;
                case "REQ_INFO_NAME_INVALID":
                    shakeField(6);
                    break;
                case "ADDRESS_POSTCODE_INVALID":
                    shakeField(5);
                    break;
                case "ADDRESS_STATE_INVALID":
                    shakeField(3);
                    break;
                case "REQ_INFO_PHONE_INVALID":
                    shakeField(9);
                    break;
                case "ADDRESS_STREET_LINE2_INVALID":
                    shakeField(1);
                    break;
                case "REQ_INFO_EMAIL_INVALID":
                    shakeField(7);
                    break;
                default:
                    AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, this, tLObject, new Object[0]);
                    break;
            }
        }
    }

    private void sendData() {
        String str;
        if (this.canceled) {
            return;
        }
        showEditDoneProgress(false, true);
        final TLRPC$TL_payments_sendPaymentForm tLRPC$TL_payments_sendPaymentForm = new TLRPC$TL_payments_sendPaymentForm();
        tLRPC$TL_payments_sendPaymentForm.msg_id = this.messageObject.getId();
        tLRPC$TL_payments_sendPaymentForm.peer = getMessagesController().getInputPeer(this.messageObject.messageOwner.peer_id);
        tLRPC$TL_payments_sendPaymentForm.form_id = this.paymentForm.form_id;
        if (UserConfig.getInstance(this.currentAccount).tmpPassword != null && this.paymentForm.saved_credentials != null) {
            TLRPC$InputPaymentCredentials tLRPC$InputPaymentCredentials = new TLRPC$InputPaymentCredentials() { // from class: org.rbmain.tgnet.TLRPC$TL_inputPaymentCredentialsSaved
                public static int constructor = -1056001329;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
                    this.id = abstractSerializedData.readString(z);
                    this.tmp_password = abstractSerializedData.readByteArray(z);
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                    abstractSerializedData.writeInt32(constructor);
                    abstractSerializedData.writeString(this.id);
                    abstractSerializedData.writeByteArray(this.tmp_password);
                }
            };
            tLRPC$TL_payments_sendPaymentForm.credentials = tLRPC$InputPaymentCredentials;
            tLRPC$InputPaymentCredentials.id = this.paymentForm.saved_credentials.id;
            tLRPC$InputPaymentCredentials.tmp_password = UserConfig.getInstance(this.currentAccount).tmpPassword.tmp_password;
        } else {
            TLRPC$TL_inputPaymentCredentialsGooglePay tLRPC$TL_inputPaymentCredentialsGooglePay = this.googlePayCredentials;
            if (tLRPC$TL_inputPaymentCredentialsGooglePay != null) {
                tLRPC$TL_payments_sendPaymentForm.credentials = tLRPC$TL_inputPaymentCredentialsGooglePay;
            } else {
                TLRPC$InputPaymentCredentials tLRPC$InputPaymentCredentials2 = new TLRPC$InputPaymentCredentials() { // from class: org.rbmain.tgnet.TLRPC$TL_inputPaymentCredentials
                    public static int constructor = 873977640;

                    @Override // org.rbmain.tgnet.TLObject
                    public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
                        int int32 = abstractSerializedData.readInt32(z);
                        this.flags = int32;
                        this.save = (int32 & 1) != 0;
                        this.data = TLRPC$TL_dataJSON.TLdeserialize(abstractSerializedData, abstractSerializedData.readInt32(z), z);
                    }

                    @Override // org.rbmain.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                        abstractSerializedData.writeInt32(constructor);
                        int i = this.save ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        abstractSerializedData.writeInt32(i);
                        this.data.serializeToStream(abstractSerializedData);
                    }
                };
                tLRPC$TL_payments_sendPaymentForm.credentials = tLRPC$InputPaymentCredentials2;
                tLRPC$InputPaymentCredentials2.save = this.saveCardInfo;
                tLRPC$InputPaymentCredentials2.data = new TLRPC$TL_dataJSON();
                tLRPC$TL_payments_sendPaymentForm.credentials.data.data = this.paymentJson;
            }
        }
        TLRPC$TL_payments_validatedRequestedInfo tLRPC$TL_payments_validatedRequestedInfo = this.requestedInfo;
        if (tLRPC$TL_payments_validatedRequestedInfo != null && (str = tLRPC$TL_payments_validatedRequestedInfo.id) != null) {
            tLRPC$TL_payments_sendPaymentForm.requested_info_id = str;
            tLRPC$TL_payments_sendPaymentForm.flags = 1 | tLRPC$TL_payments_sendPaymentForm.flags;
        }
        TLRPC$TL_shippingOption tLRPC$TL_shippingOption = this.shippingOption;
        if (tLRPC$TL_shippingOption != null) {
            tLRPC$TL_payments_sendPaymentForm.shipping_option_id = tLRPC$TL_shippingOption.id;
            tLRPC$TL_payments_sendPaymentForm.flags |= 2;
        }
        if ((this.paymentForm.invoice.flags & 256) != 0) {
            Long l = this.tipAmount;
            tLRPC$TL_payments_sendPaymentForm.tip_amount = l != null ? l.longValue() : 0L;
            tLRPC$TL_payments_sendPaymentForm.flags |= 4;
        }
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_payments_sendPaymentForm, new RequestDelegate() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda52
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$sendData$53(tLRPC$TL_payments_sendPaymentForm, tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendData$53(final TLRPC$TL_payments_sendPaymentForm tLRPC$TL_payments_sendPaymentForm, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject != null) {
            if (tLObject instanceof TLRPC$TL_payments_paymentResult) {
                TLRPC$Updates tLRPC$Updates = ((TLRPC$TL_payments_paymentResult) tLObject).updates;
                final TLRPC$Message[] tLRPC$MessageArr = new TLRPC$Message[1];
                int size = tLRPC$Updates.updates.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    TLRPC$Update tLRPC$Update = tLRPC$Updates.updates.get(i);
                    if (tLRPC$Update instanceof TLRPC$TL_updateNewMessage) {
                        tLRPC$MessageArr[0] = ((TLRPC$TL_updateNewMessage) tLRPC$Update).message;
                        break;
                    } else {
                        if (tLRPC$Update instanceof TLRPC$TL_updateNewChannelMessage) {
                            tLRPC$MessageArr[0] = ((TLRPC$TL_updateNewChannelMessage) tLRPC$Update).message;
                            break;
                        }
                        i++;
                    }
                }
                getMessagesController().processUpdates(tLRPC$Updates, false);
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda46
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$sendData$50(tLRPC$MessageArr);
                    }
                });
                return;
            }
            if (tLObject instanceof TLRPC$TL_payments_paymentVerificationNeeded) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda34
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$sendData$51(tLObject);
                    }
                });
                return;
            }
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda43
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendData$52(tLRPC$TL_error, tLRPC$TL_payments_sendPaymentForm);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendData$50(TLRPC$Message[] tLRPC$MessageArr) {
        goToNextStep();
        if (this.parentFragment instanceof ChatActivity) {
            ((ChatActivity) this.parentFragment).getUndoView().showWithAction(0L, 77, AndroidUtilities.replaceTags(LocaleController.formatString("PaymentInfoHint", R.string.PaymentInfoHint, this.totalPrice[0], this.currentItemName)), tLRPC$MessageArr[0], null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendData$51(TLObject tLObject) {
        NotificationCenter.getInstance(this.currentAccount).postNotificationName(NotificationCenter.paymentFinished, new Object[0]);
        setDonePressed(false);
        this.webviewLoading = true;
        showEditDoneProgress(true, true);
        ContextProgressView contextProgressView = this.progressView;
        if (contextProgressView != null) {
            contextProgressView.setVisibility(0);
        }
        ActionBarMenuItem actionBarMenuItem = this.doneItem;
        if (actionBarMenuItem != null) {
            actionBarMenuItem.setEnabled(false);
            this.doneItem.getContentView().setVisibility(4);
        }
        WebView webView = this.webView;
        if (webView != null) {
            webView.setVisibility(0);
            WebView webView2 = this.webView;
            String str = ((TLRPC$TL_payments_paymentVerificationNeeded) tLObject).url;
            this.webViewUrl = str;
            webView2.loadUrl(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendData$52(TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_payments_sendPaymentForm tLRPC$TL_payments_sendPaymentForm) {
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, this, tLRPC$TL_payments_sendPaymentForm, new Object[0]);
        setDonePressed(false);
        showEditDoneProgress(false, false);
    }

    private void shakeField(int i) {
        shakeView(this.inputFields[i]);
    }

    private void shakeView(View view) {
        Vibrator vibrator = (Vibrator) getParentActivity().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(200L);
        }
        AndroidUtilities.shakeView(view, 2.0f, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDonePressed(boolean z) {
        this.donePressed = z;
        this.swipeBackEnabled = !z;
        ActionBar actionBar = this.actionBar;
        if (actionBar != null) {
            actionBar.getBackButton().setEnabled(!this.donePressed);
        }
        TextDetailSettingsCell[] textDetailSettingsCellArr = this.detailSettingsCell;
        if (textDetailSettingsCellArr[0] != null) {
            textDetailSettingsCellArr[0].setEnabled(!this.donePressed);
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean isSwipeBackEnabled(MotionEvent motionEvent) {
        return this.swipeBackEnabled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPassword() {
        if (UserConfig.getInstance(this.currentAccount).tmpPassword != null && UserConfig.getInstance(this.currentAccount).tmpPassword.valid_until < ConnectionsManager.getInstance(this.currentAccount).getCurrentTime() + 60) {
            UserConfig.getInstance(this.currentAccount).tmpPassword = null;
            UserConfig.getInstance(this.currentAccount).saveConfig(false);
        }
        if (UserConfig.getInstance(this.currentAccount).tmpPassword != null) {
            sendData();
            return;
        }
        if (this.inputFields[1].length() == 0) {
            Vibrator vibrator = (Vibrator) ApplicationLoader.applicationContext.getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(200L);
            }
            AndroidUtilities.shakeView(this.inputFields[1], 2.0f, 0);
            return;
        }
        final String string = this.inputFields[1].getText().toString();
        showEditDoneProgress(true, true);
        setDonePressed(true);
        final TLRPC$TL_account_getPassword tLRPC$TL_account_getPassword = new TLRPC$TL_account_getPassword();
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_getPassword, new RequestDelegate() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda49
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$checkPassword$58(string, tLRPC$TL_account_getPassword, tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkPassword$58(final String str, final TLRPC$TL_account_getPassword tLRPC$TL_account_getPassword, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda41
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkPassword$57(tLRPC$TL_error, tLObject, str, tLRPC$TL_account_getPassword);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkPassword$57(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, String str, TLRPC$TL_account_getPassword tLRPC$TL_account_getPassword) {
        if (tLRPC$TL_error == null) {
            final TLRPC$TL_account_password tLRPC$TL_account_password = (TLRPC$TL_account_password) tLObject;
            if (!TwoStepVerificationActivity.canHandleCurrentPassword(tLRPC$TL_account_password, false)) {
                AlertsCreator.showUpdateAppAlert(getParentActivity(), LocaleController.getString("UpdateAppAlert", R.string.UpdateAppAlert), true);
                return;
            } else if (!tLRPC$TL_account_password.has_password) {
                this.passwordOk = false;
                goToNextStep();
                return;
            } else {
                final byte[] stringBytes = AndroidUtilities.getStringBytes(str);
                Utilities.globalQueue.postRunnable(new Runnable() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda37
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$checkPassword$56(tLRPC$TL_account_password, stringBytes);
                    }
                });
                return;
            }
        }
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, this, tLRPC$TL_account_getPassword, new Object[0]);
        showEditDoneProgress(true, false);
        setDonePressed(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkPassword$56(TLRPC$TL_account_password tLRPC$TL_account_password, byte[] bArr) {
        TLRPC$PasswordKdfAlgo tLRPC$PasswordKdfAlgo = tLRPC$TL_account_password.current_algo;
        byte[] x = tLRPC$PasswordKdfAlgo instanceof TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow ? SRPHelper.getX(bArr, (TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) tLRPC$PasswordKdfAlgo) : null;
        final TLRPC$TL_account_getTmpPassword tLRPC$TL_account_getTmpPassword = new TLRPC$TL_account_getTmpPassword();
        tLRPC$TL_account_getTmpPassword.period = 1800;
        RequestDelegate requestDelegate = new RequestDelegate() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda51
            @Override // org.rbmain.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$checkPassword$55(tLRPC$TL_account_getTmpPassword, tLObject, tLRPC$TL_error);
            }
        };
        TLRPC$PasswordKdfAlgo tLRPC$PasswordKdfAlgo2 = tLRPC$TL_account_password.current_algo;
        if (tLRPC$PasswordKdfAlgo2 instanceof TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) {
            TLRPC$TL_inputCheckPasswordSRP tLRPC$TL_inputCheckPasswordSRPStartCheck = SRPHelper.startCheck(x, tLRPC$TL_account_password.srp_id, tLRPC$TL_account_password.srp_B, (TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) tLRPC$PasswordKdfAlgo2);
            tLRPC$TL_account_getTmpPassword.password = tLRPC$TL_inputCheckPasswordSRPStartCheck;
            if (tLRPC$TL_inputCheckPasswordSRPStartCheck == null) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "ALGO_INVALID";
                requestDelegate.run(null, tLRPC$TL_error);
                return;
            }
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_getTmpPassword, requestDelegate, 10);
            return;
        }
        TLRPC$TL_error tLRPC$TL_error2 = new TLRPC$TL_error();
        tLRPC$TL_error2.text = "PASSWORD_HASH_INVALID";
        requestDelegate.run(null, tLRPC$TL_error2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkPassword$55(final TLRPC$TL_account_getTmpPassword tLRPC$TL_account_getTmpPassword, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.ui.PaymentFormActivity$$ExternalSyntheticLambda36
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkPassword$54(tLObject, tLRPC$TL_error, tLRPC$TL_account_getTmpPassword);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkPassword$54(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_account_getTmpPassword tLRPC$TL_account_getTmpPassword) {
        showEditDoneProgress(true, false);
        setDonePressed(false);
        if (tLObject != null) {
            this.passwordOk = true;
            UserConfig.getInstance(this.currentAccount).tmpPassword = (TLRPC$TL_account_tmpPassword) tLObject;
            UserConfig.getInstance(this.currentAccount).saveConfig(false);
            goToNextStep();
            return;
        }
        if (tLRPC$TL_error.text.equals("PASSWORD_HASH_INVALID")) {
            Vibrator vibrator = (Vibrator) ApplicationLoader.applicationContext.getSystemService("vibrator");
            if (vibrator != null) {
                vibrator.vibrate(200L);
            }
            AndroidUtilities.shakeView(this.inputFields[1], 2.0f, 0);
            this.inputFields[1].setText(BuildConfig.FLAVOR);
            return;
        }
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, this, tLRPC$TL_account_getTmpPassword, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEditDoneProgress(boolean z, final boolean z2) {
        AnimatorSet animatorSet = this.doneItemAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        if (z && this.doneItem != null) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.doneItemAnimation = animatorSet2;
            if (z2) {
                this.progressView.setVisibility(0);
                this.doneItem.setEnabled(false);
                this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.progressView, (Property<ContextProgressView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.progressView, (Property<ContextProgressView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.progressView, (Property<ContextProgressView, Float>) View.ALPHA, 1.0f));
            } else if (this.webView != null) {
                animatorSet2.playTogether(ObjectAnimator.ofFloat(this.progressView, (Property<ContextProgressView, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.progressView, (Property<ContextProgressView, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.progressView, (Property<ContextProgressView, Float>) View.ALPHA, 0.0f));
            } else {
                this.doneItem.getContentView().setVisibility(0);
                this.doneItem.setEnabled(true);
                this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.progressView, (Property<ContextProgressView, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.progressView, (Property<ContextProgressView, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.progressView, (Property<ContextProgressView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.doneItem.getContentView(), (Property<View, Float>) View.ALPHA, 1.0f));
            }
            this.doneItemAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.PaymentFormActivity.27
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PaymentFormActivity.this.doneItemAnimation == null || !PaymentFormActivity.this.doneItemAnimation.equals(animator)) {
                        return;
                    }
                    if (!z2) {
                        PaymentFormActivity.this.progressView.setVisibility(4);
                    } else {
                        PaymentFormActivity.this.doneItem.getContentView().setVisibility(4);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (PaymentFormActivity.this.doneItemAnimation == null || !PaymentFormActivity.this.doneItemAnimation.equals(animator)) {
                        return;
                    }
                    PaymentFormActivity.this.doneItemAnimation = null;
                }
            });
            this.doneItemAnimation.setDuration(150L);
            this.doneItemAnimation.start();
            return;
        }
        if (this.payTextView != null) {
            this.doneItemAnimation = new AnimatorSet();
            if (z2) {
                this.progressViewButton.setVisibility(0);
                this.bottomLayout.setEnabled(false);
                this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.payTextView, (Property<TextView, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.payTextView, (Property<TextView, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.payTextView, (Property<TextView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.progressViewButton, (Property<ContextProgressView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.progressViewButton, (Property<ContextProgressView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.progressViewButton, (Property<ContextProgressView, Float>) View.ALPHA, 1.0f));
            } else {
                this.payTextView.setVisibility(0);
                this.bottomLayout.setEnabled(true);
                this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.progressViewButton, (Property<ContextProgressView, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.progressViewButton, (Property<ContextProgressView, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.progressViewButton, (Property<ContextProgressView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.payTextView, (Property<TextView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.payTextView, (Property<TextView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.payTextView, (Property<TextView, Float>) View.ALPHA, 1.0f));
            }
            this.doneItemAnimation.addListener(new AnimatorListenerAdapter() { // from class: org.rbmain.ui.PaymentFormActivity.28
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PaymentFormActivity.this.doneItemAnimation == null || !PaymentFormActivity.this.doneItemAnimation.equals(animator)) {
                        return;
                    }
                    if (!z2) {
                        PaymentFormActivity.this.progressViewButton.setVisibility(4);
                    } else {
                        PaymentFormActivity.this.payTextView.setVisibility(4);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (PaymentFormActivity.this.doneItemAnimation == null || !PaymentFormActivity.this.doneItemAnimation.equals(animator)) {
                        return;
                    }
                    PaymentFormActivity.this.doneItemAnimation = null;
                }
            });
            this.doneItemAnimation.setDuration(150L);
            this.doneItemAnimation.start();
        }
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        if (this.shouldNavigateBack) {
            this.webView.loadUrl(this.webViewUrl);
            this.shouldNavigateBack = false;
            return false;
        }
        return !this.donePressed;
    }

    @Override // org.rbmain.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundGray));
        ActionBar actionBar = this.actionBar;
        int i = ThemeDescription.FLAG_BACKGROUND;
        int i2 = Theme.key_actionBarDefault;
        arrayList.add(new ThemeDescription(actionBar, i, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.scrollView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, i2));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, Theme.key_actionBarDefaultIcon));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, Theme.key_actionBarDefaultTitle));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, Theme.key_actionBarDefaultSelector));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCH, null, null, null, null, Theme.key_actionBarDefaultSearch));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCHPLACEHOLDER, null, null, null, null, Theme.key_actionBarDefaultSearchPlaceholder));
        arrayList.add(new ThemeDescription(this.linearLayout2, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, Theme.key_divider));
        ContextProgressView contextProgressView = this.progressView;
        int i3 = Theme.key_contextProgressInner2;
        arrayList.add(new ThemeDescription(contextProgressView, 0, null, null, null, null, i3));
        ContextProgressView contextProgressView2 = this.progressView;
        int i4 = Theme.key_contextProgressOuter2;
        arrayList.add(new ThemeDescription(contextProgressView2, 0, null, null, null, null, i4));
        arrayList.add(new ThemeDescription(this.progressViewButton, 0, null, null, null, null, i3));
        arrayList.add(new ThemeDescription(this.progressViewButton, 0, null, null, null, null, i4));
        if (this.inputFields != null) {
            for (int i5 = 0; i5 < this.inputFields.length; i5++) {
                arrayList.add(new ThemeDescription((View) this.inputFields[i5].getParent(), ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundWhite));
                arrayList.add(new ThemeDescription(this.inputFields[i5], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlackText));
                arrayList.add(new ThemeDescription(this.inputFields[i5], ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteHintText));
            }
        } else {
            arrayList.add(new ThemeDescription(null, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlackText));
            arrayList.add(new ThemeDescription(null, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteHintText));
        }
        if (this.radioCells != null) {
            for (int i6 = 0; i6 < this.radioCells.length; i6++) {
                arrayList.add(new ThemeDescription(this.radioCells[i6], ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, Theme.key_windowBackgroundWhite));
                arrayList.add(new ThemeDescription(this.radioCells[i6], ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, Theme.key_listSelector));
                arrayList.add(new ThemeDescription(this.radioCells[i6], 0, new Class[]{RadioCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlackText));
                arrayList.add(new ThemeDescription(this.radioCells[i6], ThemeDescription.FLAG_CHECKBOX, new Class[]{RadioCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_radioBackground));
                arrayList.add(new ThemeDescription(this.radioCells[i6], ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{RadioCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_radioBackgroundChecked));
            }
        } else {
            arrayList.add(new ThemeDescription((View) null, 0, new Class[]{RadioCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlackText));
            arrayList.add(new ThemeDescription((View) null, ThemeDescription.FLAG_CHECKBOX, new Class[]{RadioCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_radioBackground));
            arrayList.add(new ThemeDescription((View) null, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{RadioCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_radioBackgroundChecked));
        }
        for (int i7 = 0; i7 < this.headerCell.length; i7++) {
            arrayList.add(new ThemeDescription(this.headerCell[i7], ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundWhite));
            arrayList.add(new ThemeDescription(this.headerCell[i7], 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlueHeader));
        }
        for (int i8 = 0; i8 < this.sectionCell.length; i8++) {
            arrayList.add(new ThemeDescription(this.sectionCell[i8], ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, Theme.key_windowBackgroundGrayShadow));
        }
        for (int i9 = 0; i9 < this.bottomCell.length; i9++) {
            arrayList.add(new ThemeDescription(this.bottomCell[i9], ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, Theme.key_windowBackgroundGrayShadow));
            arrayList.add(new ThemeDescription(this.bottomCell[i9], 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText4));
            arrayList.add(new ThemeDescription(this.bottomCell[i9], ThemeDescription.FLAG_LINKCOLOR, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteLinkText));
        }
        for (int i10 = 0; i10 < this.dividers.size(); i10++) {
            arrayList.add(new ThemeDescription(this.dividers.get(i10), ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundWhite));
        }
        EditTextSettingsCell editTextSettingsCell = this.codeFieldCell;
        int i11 = ThemeDescription.FLAG_BACKGROUND;
        int i12 = Theme.key_windowBackgroundWhite;
        arrayList.add(new ThemeDescription(editTextSettingsCell, i11, null, null, null, null, i12));
        int i13 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.codeFieldCell, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{EditTextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i13));
        arrayList.add(new ThemeDescription(this.codeFieldCell, ThemeDescription.FLAG_HINTTEXTCOLOR, new Class[]{EditTextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteHintText));
        arrayList.add(new ThemeDescription(this.textView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, i13));
        arrayList.add(new ThemeDescription(this.checkCell1, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i13));
        arrayList.add(new ThemeDescription(this.checkCell1, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrack));
        arrayList.add(new ThemeDescription(this.checkCell1, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_switchTrackChecked));
        arrayList.add(new ThemeDescription(this.checkCell1, ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, i12));
        arrayList.add(new ThemeDescription(this.checkCell1, ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, Theme.key_listSelector));
        for (int i14 = 0; i14 < this.settingsCell.length; i14++) {
            arrayList.add(new ThemeDescription(this.settingsCell[i14], ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, Theme.key_windowBackgroundWhite));
            arrayList.add(new ThemeDescription(this.settingsCell[i14], ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, Theme.key_listSelector));
            arrayList.add(new ThemeDescription(this.settingsCell[i14], 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlackText));
        }
        arrayList.add(new ThemeDescription(this.payTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, Theme.key_windowBackgroundWhiteBlueText6));
        int i15 = Theme.key_windowBackgroundWhite;
        arrayList.add(new ThemeDescription(this.linearLayout2, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextPriceCell.class}, null, null, null, i15));
        int i16 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.linearLayout2, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextPriceCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i16));
        arrayList.add(new ThemeDescription(this.linearLayout2, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextPriceCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i16));
        int i17 = Theme.key_windowBackgroundWhiteGrayText2;
        arrayList.add(new ThemeDescription(this.linearLayout2, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextPriceCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i17));
        arrayList.add(new ThemeDescription(this.linearLayout2, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextPriceCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i17));
        arrayList.add(new ThemeDescription(this.detailSettingsCell[0], ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, i15));
        arrayList.add(new ThemeDescription(this.detailSettingsCell[0], ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, Theme.key_listSelector));
        for (int i18 = 1; i18 < this.detailSettingsCell.length; i18++) {
            arrayList.add(new ThemeDescription(this.detailSettingsCell[i18], ThemeDescription.FLAG_BACKGROUND, null, null, null, null, Theme.key_windowBackgroundWhite));
            arrayList.add(new ThemeDescription(this.detailSettingsCell[i18], 0, new Class[]{TextDetailSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteBlackText));
            arrayList.add(new ThemeDescription(this.detailSettingsCell[i18], 0, new Class[]{TextDetailSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText2));
        }
        PaymentInfoCell paymentInfoCell = this.paymentInfoCell;
        int i19 = ThemeDescription.FLAG_BACKGROUND;
        int i20 = Theme.key_windowBackgroundWhite;
        arrayList.add(new ThemeDescription(paymentInfoCell, i19, null, null, null, null, i20));
        int i21 = Theme.key_windowBackgroundWhiteBlackText;
        arrayList.add(new ThemeDescription(this.paymentInfoCell, 0, new Class[]{PaymentInfoCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i21));
        arrayList.add(new ThemeDescription(this.paymentInfoCell, 0, new Class[]{PaymentInfoCell.class}, new String[]{"detailTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, i21));
        arrayList.add(new ThemeDescription(this.paymentInfoCell, 0, new Class[]{PaymentInfoCell.class}, new String[]{"detailExTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, Theme.key_windowBackgroundWhiteGrayText2));
        arrayList.add(new ThemeDescription(this.bottomLayout, ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, i20));
        arrayList.add(new ThemeDescription(this.bottomLayout, ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, Theme.key_listSelector));
        return arrayList;
    }
}
