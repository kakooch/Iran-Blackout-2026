package ir.eitaa.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
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
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.stripe.android.Stripe;
import com.stripe.android.TokenCallback;
import com.stripe.android.exception.APIConnectionException;
import com.stripe.android.exception.APIException;
import com.stripe.android.model.Card;
import com.stripe.android.model.Token;
import ir.eitaa.PhoneFormat.PhoneFormat;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.LocaleController;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.R;
import ir.eitaa.messenger.SRPHelper;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$InputPaymentCredentials;
import ir.eitaa.tgnet.TLRPC$Message;
import ir.eitaa.tgnet.TLRPC$PasswordKdfAlgo;
import ir.eitaa.tgnet.TLRPC$TL_account_confirmPasswordEmail;
import ir.eitaa.tgnet.TLRPC$TL_account_getPassword;
import ir.eitaa.tgnet.TLRPC$TL_account_getTmpPassword;
import ir.eitaa.tgnet.TLRPC$TL_account_password;
import ir.eitaa.tgnet.TLRPC$TL_account_passwordInputSettings;
import ir.eitaa.tgnet.TLRPC$TL_account_resendPasswordEmail;
import ir.eitaa.tgnet.TLRPC$TL_account_tmpPassword;
import ir.eitaa.tgnet.TLRPC$TL_account_updatePasswordSettings;
import ir.eitaa.tgnet.TLRPC$TL_boolTrue;
import ir.eitaa.tgnet.TLRPC$TL_dataJSON;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputCheckPasswordEmpty;
import ir.eitaa.tgnet.TLRPC$TL_inputCheckPasswordSRP;
import ir.eitaa.tgnet.TLRPC$TL_inputPaymentCredentialsGooglePay;
import ir.eitaa.tgnet.TLRPC$TL_invoice;
import ir.eitaa.tgnet.TLRPC$TL_labeledPrice;
import ir.eitaa.tgnet.TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow;
import ir.eitaa.tgnet.TLRPC$TL_paymentRequestedInfo;
import ir.eitaa.tgnet.TLRPC$TL_paymentSavedCredentialsCard;
import ir.eitaa.tgnet.TLRPC$TL_payments_clearSavedInfo;
import ir.eitaa.tgnet.TLRPC$TL_payments_paymentForm;
import ir.eitaa.tgnet.TLRPC$TL_payments_paymentReceipt;
import ir.eitaa.tgnet.TLRPC$TL_payments_paymentResult;
import ir.eitaa.tgnet.TLRPC$TL_payments_paymentVerificationNeeded;
import ir.eitaa.tgnet.TLRPC$TL_payments_sendPaymentForm;
import ir.eitaa.tgnet.TLRPC$TL_payments_validateRequestedInfo;
import ir.eitaa.tgnet.TLRPC$TL_payments_validatedRequestedInfo;
import ir.eitaa.tgnet.TLRPC$TL_postAddress;
import ir.eitaa.tgnet.TLRPC$TL_shippingOption;
import ir.eitaa.tgnet.TLRPC$TL_updateNewChannelMessage;
import ir.eitaa.tgnet.TLRPC$TL_updateNewMessage;
import ir.eitaa.tgnet.TLRPC$Update;
import ir.eitaa.tgnet.TLRPC$Updates;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.ui.ActionBar.ActionBar;
import ir.eitaa.ui.ActionBar.ActionBarMenuItem;
import ir.eitaa.ui.ActionBar.AlertDialog;
import ir.eitaa.ui.ActionBar.BaseFragment;
import ir.eitaa.ui.ActionBar.BottomSheet;
import ir.eitaa.ui.ActionBar.Theme;
import ir.eitaa.ui.ActionBar.ThemeDescription;
import ir.eitaa.ui.Cells.EditTextSettingsCell;
import ir.eitaa.ui.Cells.HeaderCell;
import ir.eitaa.ui.Cells.PaymentInfoCell;
import ir.eitaa.ui.Cells.RadioCell;
import ir.eitaa.ui.Cells.ShadowSectionCell;
import ir.eitaa.ui.Cells.TextCheckCell;
import ir.eitaa.ui.Cells.TextDetailSettingsCell;
import ir.eitaa.ui.Cells.TextInfoPrivacyCell;
import ir.eitaa.ui.Cells.TextPriceCell;
import ir.eitaa.ui.Cells.TextSettingsCell;
import ir.eitaa.ui.Components.AlertsCreator;
import ir.eitaa.ui.Components.ContextProgressView;
import ir.eitaa.ui.Components.EditTextBoldCursor;
import ir.eitaa.ui.Components.LayoutHelper;
import ir.eitaa.ui.CountrySelectActivity;
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
import org.linphone.mediastream.Factory;

/* loaded from: classes3.dex */
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
    private String totalPriceDecimal;
    private TLRPC$TL_payments_validateRequestedInfo validateRequest;
    private boolean waitingForEmail;
    private WebView webView;
    private String webViewUrl;
    private boolean webviewLoading;

    private interface PaymentFormActivityDelegate {

        /* renamed from: ir.eitaa.ui.PaymentFormActivity$PaymentFormActivityDelegate$-CC, reason: invalid class name */
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

        void currentPasswordUpdated(TLRPC$TL_account_password password);

        void didSelectNewAddress(TLRPC$TL_payments_validateRequestedInfo validateRequested);

        boolean didSelectNewCard(String tokenJson, String card, boolean saveCard, TLRPC$TL_inputPaymentCredentialsGooglePay googlePay);

        void onFragmentDestroyed();
    }

    static /* synthetic */ boolean lambda$createView$10(View view, MotionEvent motionEvent) {
        return true;
    }

    static /* synthetic */ void lambda$createView$25(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    static /* synthetic */ void lambda$sendForm$45(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    class EitaaWebviewProxy {
        private EitaaWebviewProxy() {
        }

        @JavascriptInterface
        public void postEvent(final String eventName, final String eventData) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$EitaaWebviewProxy$yAHAGk8xJLpJwkzE6gIn_Rw4mGY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$postEvent$0$PaymentFormActivity$EitaaWebviewProxy(eventName, eventData);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$postEvent$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$postEvent$0$PaymentFormActivity$EitaaWebviewProxy(String str, String str2) {
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
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setUnderlineText(false);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            PaymentFormActivity paymentFormActivity = PaymentFormActivity.this;
            paymentFormActivity.presentFragment(new TwoStepVerificationSetupActivity(6, paymentFormActivity.currentPassword));
        }
    }

    public PaymentFormActivity(TLRPC$TL_payments_paymentReceipt receipt) {
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
        this.paymentReceipt = receipt;
        tLRPC$TL_payments_paymentForm.bot_id = receipt.bot_id;
        tLRPC$TL_payments_paymentForm.invoice = receipt.invoice;
        tLRPC$TL_payments_paymentForm.provider_id = receipt.provider_id;
        tLRPC$TL_payments_paymentForm.users = receipt.users;
        this.shippingOption = receipt.shipping;
        long j = receipt.tip_amount;
        if (j != 0) {
            this.tipAmount = Long.valueOf(j);
        }
        TLRPC$User user = getMessagesController().getUser(Long.valueOf(receipt.bot_id));
        this.botUser = user;
        if (user != null) {
            this.currentBotName = user.first_name;
        } else {
            this.currentBotName = "";
        }
        this.currentItemName = receipt.title;
        if (receipt.info != null) {
            TLRPC$TL_payments_validateRequestedInfo tLRPC$TL_payments_validateRequestedInfo = new TLRPC$TL_payments_validateRequestedInfo();
            this.validateRequest = tLRPC$TL_payments_validateRequestedInfo;
            tLRPC$TL_payments_validateRequestedInfo.peer = getMessagesController().getInputPeer(receipt.bot_id);
            this.validateRequest.info = receipt.info;
        }
        this.cardName = receipt.credentials_title;
    }

    public PaymentFormActivity(TLRPC$TL_payments_paymentForm form, MessageObject message, BaseFragment parentFragment) {
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
        TLRPC$TL_invoice tLRPC$TL_invoice = form.invoice;
        if (tLRPC$TL_invoice.shipping_address_requested || tLRPC$TL_invoice.email_requested || tLRPC$TL_invoice.name_requested || tLRPC$TL_invoice.phone_requested) {
            i = 0;
        } else if (form.saved_credentials != null) {
            if (UserConfig.getInstance(this.currentAccount).tmpPassword != null && UserConfig.getInstance(this.currentAccount).tmpPassword.valid_until < ConnectionsManager.getInstance(this.currentAccount).getCurrentTime() + 60) {
                UserConfig.getInstance(this.currentAccount).tmpPassword = null;
                UserConfig.getInstance(this.currentAccount).saveConfig(false);
            }
            i = UserConfig.getInstance(this.currentAccount).tmpPassword != null ? 4 : 3;
        } else {
            i = 2;
        }
        init(form, message, i, null, null, null, null, null, null, false, null, parentFragment);
    }

    private PaymentFormActivity(TLRPC$TL_payments_paymentForm form, MessageObject message, int step, TLRPC$TL_payments_validatedRequestedInfo validatedRequestedInfo, TLRPC$TL_shippingOption shipping, Long tips, String tokenJson, String card, TLRPC$TL_payments_validateRequestedInfo request, boolean saveCard, TLRPC$TL_inputPaymentCredentialsGooglePay googlePay, BaseFragment parent) {
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
        init(form, message, step, validatedRequestedInfo, shipping, tips, tokenJson, card, request, saveCard, googlePay, parent);
    }

    private void setCurrentPassword(TLRPC$TL_account_password password) {
        if (password.has_password) {
            if (getParentActivity() == null) {
                return;
            }
            goToNextStep();
        } else {
            this.currentPassword = password;
            this.waitingForEmail = !TextUtils.isEmpty(password.email_unconfirmed_pattern);
            updatePasswordFields();
        }
    }

    private void setDelegate(PaymentFormActivityDelegate paymentFormActivityDelegate) {
        this.delegate = paymentFormActivityDelegate;
    }

    private void init(TLRPC$TL_payments_paymentForm form, MessageObject message, int step, TLRPC$TL_payments_validatedRequestedInfo validatedRequestedInfo, TLRPC$TL_shippingOption shipping, Long tips, String tokenJson, String card, TLRPC$TL_payments_validateRequestedInfo request, boolean saveCard, TLRPC$TL_inputPaymentCredentialsGooglePay googlePay, BaseFragment parent) {
        this.currentStep = step;
        this.parentFragment = parent;
        this.paymentJson = tokenJson;
        this.requestedInfo = validatedRequestedInfo;
        this.paymentForm = form;
        this.shippingOption = shipping;
        this.tipAmount = tips;
        this.messageObject = message;
        this.saveCardInfo = saveCard;
        this.isWebView = ("stripe".equals(form.native_provider) || "smartglocal".equals(this.paymentForm.native_provider)) ? false : true;
        TLRPC$User user = getMessagesController().getUser(Long.valueOf(form.bot_id));
        this.botUser = user;
        if (user != null) {
            this.currentBotName = user.first_name;
        } else {
            this.currentBotName = "";
        }
        this.currentItemName = message.messageOwner.media.title;
        this.validateRequest = request;
        this.saveShippingInfo = true;
        if (saveCard || this.currentStep == 4) {
            this.saveCardInfo = saveCard;
        } else {
            this.saveCardInfo = this.paymentForm.saved_credentials != null;
        }
        if (card == null) {
            TLRPC$TL_paymentSavedCredentialsCard tLRPC$TL_paymentSavedCredentialsCard = form.saved_credentials;
            if (tLRPC$TL_paymentSavedCredentialsCard != null) {
                this.cardName = tLRPC$TL_paymentSavedCredentialsCard.title;
                return;
            }
            return;
        }
        this.cardName = card;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
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
    /* JADX WARN: Removed duplicated region for block: B:461:0x0fb9  */
    /* JADX WARN: Removed duplicated region for block: B:506:0x1344  */
    /* JADX WARN: Removed duplicated region for block: B:512:0x13d7  */
    /* JADX WARN: Removed duplicated region for block: B:514:0x13f5  */
    /* JADX WARN: Removed duplicated region for block: B:520:0x141d  */
    /* JADX WARN: Removed duplicated region for block: B:523:0x144a  */
    /* JADX WARN: Removed duplicated region for block: B:524:0x144c  */
    /* JADX WARN: Removed duplicated region for block: B:527:0x1477  */
    /* JADX WARN: Removed duplicated region for block: B:528:0x14af  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0320  */
    /* JADX WARN: Type inference failed for: r0v112, types: [ir.eitaa.ui.Cells.TextDetailSettingsCell[]] */
    /* JADX WARN: Type inference failed for: r0v113, types: [ir.eitaa.ui.Cells.TextDetailSettingsCell] */
    /* JADX WARN: Type inference failed for: r0v82, types: [android.widget.FrameLayout, ir.eitaa.ui.ActionBar.ActionBarMenuItem] */
    /* JADX WARN: Type inference failed for: r0v95, types: [android.webkit.WebSettings] */
    /* JADX WARN: Type inference failed for: r3v30, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v202, types: [android.view.View, android.view.ViewGroup, android.widget.FrameLayout] */
    /* JADX WARN: Type inference failed for: r4v206, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r4v207, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r4v244, types: [android.view.View, android.view.ViewGroup, android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v195, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v196 */
    /* JADX WARN: Type inference failed for: r9v110, types: [ir.eitaa.ui.Components.EditTextBoldCursor[]] */
    /* JADX WARN: Type inference failed for: r9v111, types: [android.widget.EditText] */
    /* JADX WARN: Type inference failed for: r9v176, types: [ir.eitaa.ui.Components.EditTextBoldCursor[]] */
    /* JADX WARN: Type inference failed for: r9v177, types: [android.widget.EditText] */
    /* JADX WARN: Type inference failed for: r9v179, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v36, types: [android.widget.LinearLayout] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v75, types: [ir.eitaa.ui.Components.EditTextBoldCursor[]] */
    /* JADX WARN: Type inference failed for: r9v76, types: [android.widget.EditText] */
    /* JADX WARN: Type inference failed for: r9v81, types: [ir.eitaa.ui.Components.EditTextBoldCursor[]] */
    /* JADX WARN: Type inference failed for: r9v82, types: [android.widget.EditText] */
    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    @android.annotation.SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View createView(android.content.Context r36) throws java.lang.NoSuchFieldException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 7260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PaymentFormActivity.createView(android.content.Context):android.view.View");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$1$PaymentFormActivity(View view, MotionEvent motionEvent) {
        if (getParentActivity() == null) {
            return false;
        }
        if (motionEvent.getAction() == 1) {
            CountrySelectActivity countrySelectActivity = new CountrySelectActivity(false);
            countrySelectActivity.setCountrySelectActivityDelegate(new CountrySelectActivity.CountrySelectActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$anknfz_10ydPFGkMR_cwxZf9qx8
                @Override // ir.eitaa.ui.CountrySelectActivity.CountrySelectActivityDelegate
                public final void didSelectCountry(CountrySelectActivity.Country country) {
                    this.f$0.lambda$createView$0$PaymentFormActivity(country);
                }
            });
            presentFragment(countrySelectActivity);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$0$PaymentFormActivity(CountrySelectActivity.Country country) {
        this.inputFields[4].setText(country.name);
        this.countryName = country.shortname;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$2$PaymentFormActivity(TextView textView, int i, KeyEvent keyEvent) {
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
    /* renamed from: lambda$createView$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$3$PaymentFormActivity(View view) {
        boolean z = !this.saveShippingInfo;
        this.saveShippingInfo = z;
        this.checkCell1.setChecked(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$4$PaymentFormActivity(View view) {
        boolean z = !this.saveCardInfo;
        this.saveCardInfo = z;
        this.checkCell1.setChecked(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$6$PaymentFormActivity(View view, MotionEvent motionEvent) {
        if (getParentActivity() == null) {
            return false;
        }
        if (motionEvent.getAction() == 1) {
            CountrySelectActivity countrySelectActivity = new CountrySelectActivity(false);
            countrySelectActivity.setCountrySelectActivityDelegate(new CountrySelectActivity.CountrySelectActivityDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$INFhMH6VfCKr7172LCMBd6j3NZ4
                @Override // ir.eitaa.ui.CountrySelectActivity.CountrySelectActivityDelegate
                public final void didSelectCountry(CountrySelectActivity.Country country) {
                    this.f$0.lambda$createView$5$PaymentFormActivity(country);
                }
            });
            presentFragment(countrySelectActivity);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$5$PaymentFormActivity(CountrySelectActivity.Country country) {
        this.inputFields[4].setText(country.name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$7, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$7$PaymentFormActivity(TextView textView, int i, KeyEvent keyEvent) {
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
    /* renamed from: lambda$createView$8, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$8$PaymentFormActivity(View view) {
        boolean z = !this.saveCardInfo;
        this.saveCardInfo = z;
        this.checkCell1.setChecked(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$9, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$9$PaymentFormActivity(View view) {
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
    /* renamed from: lambda$createView$11, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$11$PaymentFormActivity(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.doneItem.performClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$12, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$12$PaymentFormActivity(View view) {
        this.passwordOk = false;
        goToNextStep();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$13, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$13$PaymentFormActivity(View view) {
        this.inputFields[0].requestFocus();
        AndroidUtilities.showKeyboard(this.inputFields[0]);
    }

    static /* synthetic */ boolean lambda$createView$14(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        AndroidUtilities.hideKeyboard(textView);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$15, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$15$PaymentFormActivity(TextView textView, long j, View view) {
        long jLongValue = ((Long) textView.getTag()).longValue();
        Long l = this.tipAmount;
        if (l != null && jLongValue == l.longValue()) {
            this.ignoreOnTextChange = true;
            this.inputFields[0].setText("");
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
    /* renamed from: lambda$createView$17, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$17$PaymentFormActivity(View view) {
        if (getParentActivity() == null) {
            return;
        }
        BottomSheet.Builder builder = new BottomSheet.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("PaymentCheckoutMethod", R.string.PaymentCheckoutMethod), true);
        builder.setItems(new CharSequence[]{this.cardName, LocaleController.getString("PaymentCheckoutMethodNewCard", R.string.PaymentCheckoutMethodNewCard)}, new int[]{R.drawable.payment_card, R.drawable.msg_addbot}, new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$DK1hJJ3qtMN4E3Wczmjqz1o07zc
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$createView$16$PaymentFormActivity(dialogInterface, i);
            }
        });
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$16, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$16$PaymentFormActivity(DialogInterface dialogInterface, int i) {
        if (i == 1) {
            PaymentFormActivity paymentFormActivity = new PaymentFormActivity(this.paymentForm, this.messageObject, 2, this.requestedInfo, this.shippingOption, this.tipAmount, null, this.cardName, this.validateRequest, this.saveCardInfo, null, this.parentFragment);
            paymentFormActivity.setDelegate(new PaymentFormActivityDelegate() { // from class: ir.eitaa.ui.PaymentFormActivity.13
                @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
                public /* synthetic */ void currentPasswordUpdated(TLRPC$TL_account_password tLRPC$TL_account_password) {
                    PaymentFormActivityDelegate.CC.$default$currentPasswordUpdated(this, tLRPC$TL_account_password);
                }

                @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
                public /* synthetic */ void didSelectNewAddress(TLRPC$TL_payments_validateRequestedInfo tLRPC$TL_payments_validateRequestedInfo) {
                    PaymentFormActivityDelegate.CC.$default$didSelectNewAddress(this, tLRPC$TL_payments_validateRequestedInfo);
                }

                @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
                public /* synthetic */ void onFragmentDestroyed() {
                    PaymentFormActivityDelegate.CC.$default$onFragmentDestroyed(this);
                }

                @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
                public boolean didSelectNewCard(String tokenJson, String card, boolean saveCard, TLRPC$TL_inputPaymentCredentialsGooglePay googlePay) {
                    PaymentFormActivity.this.paymentForm.saved_credentials = null;
                    PaymentFormActivity.this.paymentJson = tokenJson;
                    PaymentFormActivity.this.saveCardInfo = saveCard;
                    PaymentFormActivity.this.cardName = card;
                    PaymentFormActivity.this.googlePayCredentials = googlePay;
                    PaymentFormActivity.this.detailSettingsCell[0].setTextAndValue(PaymentFormActivity.this.cardName, LocaleController.getString("PaymentCheckoutMethod", R.string.PaymentCheckoutMethod), true);
                    return false;
                }
            });
            presentFragment(paymentFormActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$18, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$18$PaymentFormActivity(View view) {
        PaymentFormActivity paymentFormActivity = new PaymentFormActivity(this.paymentForm, this.messageObject, 0, this.requestedInfo, this.shippingOption, this.tipAmount, null, this.cardName, this.validateRequest, this.saveCardInfo, null, this.parentFragment);
        paymentFormActivity.setDelegate(new PaymentFormActivityDelegate() { // from class: ir.eitaa.ui.PaymentFormActivity.14
            @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ void currentPasswordUpdated(TLRPC$TL_account_password tLRPC$TL_account_password) {
                PaymentFormActivityDelegate.CC.$default$currentPasswordUpdated(this, tLRPC$TL_account_password);
            }

            @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ boolean didSelectNewCard(String str, String str2, boolean z, TLRPC$TL_inputPaymentCredentialsGooglePay tLRPC$TL_inputPaymentCredentialsGooglePay) {
                return PaymentFormActivityDelegate.CC.$default$didSelectNewCard(this, str, str2, z, tLRPC$TL_inputPaymentCredentialsGooglePay);
            }

            @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ void onFragmentDestroyed() {
                PaymentFormActivityDelegate.CC.$default$onFragmentDestroyed(this);
            }

            @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public void didSelectNewAddress(TLRPC$TL_payments_validateRequestedInfo validateRequested) {
                PaymentFormActivity.this.validateRequest = validateRequested;
                PaymentFormActivity.this.setAddressFields();
            }
        });
        presentFragment(paymentFormActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$19, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$19$PaymentFormActivity(View view) {
        PaymentFormActivity paymentFormActivity = new PaymentFormActivity(this.paymentForm, this.messageObject, 0, this.requestedInfo, this.shippingOption, this.tipAmount, null, this.cardName, this.validateRequest, this.saveCardInfo, null, this.parentFragment);
        paymentFormActivity.setDelegate(new PaymentFormActivityDelegate() { // from class: ir.eitaa.ui.PaymentFormActivity.15
            @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ void currentPasswordUpdated(TLRPC$TL_account_password tLRPC$TL_account_password) {
                PaymentFormActivityDelegate.CC.$default$currentPasswordUpdated(this, tLRPC$TL_account_password);
            }

            @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ boolean didSelectNewCard(String str, String str2, boolean z, TLRPC$TL_inputPaymentCredentialsGooglePay tLRPC$TL_inputPaymentCredentialsGooglePay) {
                return PaymentFormActivityDelegate.CC.$default$didSelectNewCard(this, str, str2, z, tLRPC$TL_inputPaymentCredentialsGooglePay);
            }

            @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ void onFragmentDestroyed() {
                PaymentFormActivityDelegate.CC.$default$onFragmentDestroyed(this);
            }

            @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public void didSelectNewAddress(TLRPC$TL_payments_validateRequestedInfo validateRequested) {
                PaymentFormActivity.this.validateRequest = validateRequested;
                PaymentFormActivity.this.setAddressFields();
            }
        });
        presentFragment(paymentFormActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$20, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$20$PaymentFormActivity(View view) {
        PaymentFormActivity paymentFormActivity = new PaymentFormActivity(this.paymentForm, this.messageObject, 0, this.requestedInfo, this.shippingOption, this.tipAmount, null, this.cardName, this.validateRequest, this.saveCardInfo, null, this.parentFragment);
        paymentFormActivity.setDelegate(new PaymentFormActivityDelegate() { // from class: ir.eitaa.ui.PaymentFormActivity.16
            @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ void currentPasswordUpdated(TLRPC$TL_account_password tLRPC$TL_account_password) {
                PaymentFormActivityDelegate.CC.$default$currentPasswordUpdated(this, tLRPC$TL_account_password);
            }

            @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ boolean didSelectNewCard(String str, String str2, boolean z, TLRPC$TL_inputPaymentCredentialsGooglePay tLRPC$TL_inputPaymentCredentialsGooglePay) {
                return PaymentFormActivityDelegate.CC.$default$didSelectNewCard(this, str, str2, z, tLRPC$TL_inputPaymentCredentialsGooglePay);
            }

            @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ void onFragmentDestroyed() {
                PaymentFormActivityDelegate.CC.$default$onFragmentDestroyed(this);
            }

            @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public void didSelectNewAddress(TLRPC$TL_payments_validateRequestedInfo validateRequested) {
                PaymentFormActivity.this.validateRequest = validateRequested;
                PaymentFormActivity.this.setAddressFields();
            }
        });
        presentFragment(paymentFormActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$21, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$21$PaymentFormActivity(View view) {
        PaymentFormActivity paymentFormActivity = new PaymentFormActivity(this.paymentForm, this.messageObject, 0, this.requestedInfo, this.shippingOption, this.tipAmount, null, this.cardName, this.validateRequest, this.saveCardInfo, null, this.parentFragment);
        paymentFormActivity.setDelegate(new PaymentFormActivityDelegate() { // from class: ir.eitaa.ui.PaymentFormActivity.17
            @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ void currentPasswordUpdated(TLRPC$TL_account_password tLRPC$TL_account_password) {
                PaymentFormActivityDelegate.CC.$default$currentPasswordUpdated(this, tLRPC$TL_account_password);
            }

            @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ boolean didSelectNewCard(String str, String str2, boolean z, TLRPC$TL_inputPaymentCredentialsGooglePay tLRPC$TL_inputPaymentCredentialsGooglePay) {
                return PaymentFormActivityDelegate.CC.$default$didSelectNewCard(this, str, str2, z, tLRPC$TL_inputPaymentCredentialsGooglePay);
            }

            @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public /* synthetic */ void onFragmentDestroyed() {
                PaymentFormActivityDelegate.CC.$default$onFragmentDestroyed(this);
            }

            @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
            public void didSelectNewAddress(TLRPC$TL_payments_validateRequestedInfo validateRequested) {
                PaymentFormActivity.this.validateRequest = validateRequested;
                PaymentFormActivity.this.setAddressFields();
            }
        });
        presentFragment(paymentFormActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$23, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$23$PaymentFormActivity(String str, View view) {
        TLRPC$User tLRPC$User = this.botUser;
        if (tLRPC$User != null && !tLRPC$User.verified) {
            String str2 = "payment_warning_" + this.botUser.id;
            SharedPreferences notificationsSettings = MessagesController.getNotificationsSettings(this.currentAccount);
            if (!notificationsSettings.getBoolean(str2, false)) {
                notificationsSettings.edit().putBoolean(str2, true).commit();
                AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
                builder.setTitle(LocaleController.getString("PaymentWarning", R.string.PaymentWarning));
                builder.setMessage(LocaleController.formatString("PaymentWarningText", R.string.PaymentWarningText, this.currentBotName, str));
                builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$xBkeBN6h2O4V-lYSl8n111Ym1t0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$createView$22$PaymentFormActivity(dialogInterface, i);
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
    /* renamed from: lambda$createView$22, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$22$PaymentFormActivity(DialogInterface dialogInterface, int i) {
        showPayAlert(this.totalPrice[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$24, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$24$PaymentFormActivity(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        sendSavePassword(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$26, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$26$PaymentFormActivity(View view) {
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLRPC$TL_account_resendPasswordEmail(), new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$CXHpHau5v5VGZBAtKkDkrXHssuA
            @Override // ir.eitaa.tgnet.RequestDelegate
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
    /* renamed from: lambda$createView$28, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$28$PaymentFormActivity(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        String string = LocaleController.getString("TurnPasswordOffQuestion", R.string.TurnPasswordOffQuestion);
        if (this.currentPassword.has_secure_values) {
            string = string + "\n\n" + LocaleController.getString("TurnPasswordOffPassport", R.string.TurnPasswordOffPassport);
        }
        builder.setMessage(string);
        builder.setTitle(LocaleController.getString("TurnPasswordOffQuestionTitle", R.string.TurnPasswordOffQuestionTitle));
        builder.setPositiveButton(LocaleController.getString("Disable", R.string.Disable), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$Lt6IFGW4HcEflG42jmcWUfJqLUY
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$createView$27$PaymentFormActivity(dialogInterface, i);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$27, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createView$27$PaymentFormActivity(DialogInterface dialogInterface, int i) {
        sendSavePassword(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$createView$29, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ boolean lambda$createView$29$PaymentFormActivity(TextView textView, int i, KeyEvent keyEvent) {
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
            int color = Theme.getColor("contacts_inviteBackground");
            int childCount = this.tipLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                TextView textView2 = (TextView) this.tipLayout.getChildAt(i);
                if (textView2.getTag().equals(this.tipAmount)) {
                    Theme.setDrawableColor(textView2.getBackground(), color);
                    textView2.setTextColor(Theme.getColor("contacts_inviteText"));
                } else {
                    Theme.setDrawableColor(textView2.getBackground(), 536870911 & color);
                    textView2.setTextColor(Theme.getColor("chats_secretName"));
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
        this.googlePayButton.setOnClickListener(new View.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$3PcEdtiTusYYIXYlApwypkxOwu8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException {
                this.f$0.lambda$createGooglePayButton$30$PaymentFormActivity(view);
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
    /* renamed from: lambda$createGooglePayButton$30, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$createGooglePayButton$30$PaymentFormActivity(View view) throws JSONException {
        this.googlePayButton.setClickable(false);
        try {
            JSONObject baseRequest = getBaseRequest();
            JSONObject baseCardPaymentMethod = getBaseCardPaymentMethod();
            if (this.googlePayPublicKey != null && this.googlePayParameters == null) {
                baseCardPaymentMethod.put("tokenizationSpecification", new JSONObject() { // from class: ir.eitaa.ui.PaymentFormActivity.22
                    {
                        put("type", "DIRECT");
                        put("parameters", new JSONObject() { // from class: ir.eitaa.ui.PaymentFormActivity.22.1
                            {
                                put("protocolVersion", "ECv2");
                                put("publicKey", PaymentFormActivity.this.googlePayPublicKey);
                            }
                        });
                    }
                });
            } else {
                baseCardPaymentMethod.put("tokenizationSpecification", new JSONObject() { // from class: ir.eitaa.ui.PaymentFormActivity.23
                    {
                        put("type", "PAYMENT_GATEWAY");
                        if (PaymentFormActivity.this.googlePayParameters != null) {
                            put("parameters", PaymentFormActivity.this.googlePayParameters);
                        } else {
                            put("parameters", new JSONObject() { // from class: ir.eitaa.ui.PaymentFormActivity.23.1
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
            String totalPriceDecimalString = getTotalPriceDecimalString(arrayList);
            this.totalPriceDecimal = totalPriceDecimalString;
            jSONObject.put("totalPrice", totalPriceDecimalString);
            jSONObject.put("totalPriceStatus", "FINAL");
            if (!TextUtils.isEmpty(this.googlePayCountryCode)) {
                jSONObject.put("countryCode", this.googlePayCountryCode);
            }
            jSONObject.put("currencyCode", this.paymentForm.invoice.currency);
            jSONObject.put("checkoutOption", "COMPLETE_IMMEDIATE_PURCHASE");
            baseRequest.put("transactionInfo", jSONObject);
            baseRequest.put("merchantInfo", new JSONObject().put("merchantName", this.currentBotName));
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
                str = "";
            }
            objArr[0] = str;
            textInfoPrivacyCell.setText(LocaleController.formatString("EmailPasswordConfirmText2", R.string.EmailPasswordConfirmText2, objArr));
            this.bottomCell[2].setVisibility(0);
            this.settingsCell[0].setVisibility(0);
            this.settingsCell[1].setVisibility(0);
            this.codeFieldCell.setVisibility(0);
            this.bottomCell[1].setText("");
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
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLRPC$TL_account_getPassword(), new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$x8zRVui6fYFvBqipORmuKXwwcao
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$loadPasswordInfo$33$PaymentFormActivity(tLObject, tLRPC$TL_error);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPasswordInfo$33, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPasswordInfo$33$PaymentFormActivity(final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$xMivB-DA64b6QIm9EfW8pUvFwko
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$loadPasswordInfo$32$PaymentFormActivity(tLRPC$TL_error, tLObject);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPasswordInfo$32, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPasswordInfo$32$PaymentFormActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
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
            Runnable runnable = new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$yHQLTJ4esJdMRWes3_LTbEfEO84
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadPasswordInfo$31$PaymentFormActivity();
                }
            };
            this.shortPollRunnable = runnable;
            AndroidUtilities.runOnUIThread(runnable, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$loadPasswordInfo$31, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$loadPasswordInfo$31$PaymentFormActivity() {
        if (this.shortPollRunnable == null) {
            return;
        }
        loadPasswordInfo();
        this.shortPollRunnable = null;
    }

    private void showAlertWithText(String title, String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.setTitle(title);
        builder.setMessage(text);
        showDialog(builder.create());
    }

    private void showPayAlert(final String totalPrice) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getParentActivity());
        builder.setTitle(LocaleController.getString("PaymentTransactionReview", R.string.PaymentTransactionReview));
        builder.setMessage(AndroidUtilities.replaceTags(LocaleController.formatString("PaymentTransactionMessage2", R.string.PaymentTransactionMessage2, totalPrice, this.currentBotName, this.currentItemName)));
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$Tp0moKHTADmfINXUe9rPCPwCmuY
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f$0.lambda$showPayAlert$34$PaymentFormActivity(dialogInterface, i);
            }
        });
        builder.setNegativeButton(LocaleController.getString("Cancel", R.string.Cancel), null);
        showDialog(builder.create());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$showPayAlert$34, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$showPayAlert$34$PaymentFormActivity(DialogInterface dialogInterface, int i) {
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

    private void initGooglePay(Context context) {
        if (Build.VERSION.SDK_INT < 19 || getParentActivity() == null || !getIsReadyToPayRequest().isPresent()) {
        }
    }

    private String getTotalPriceString(ArrayList<TLRPC$TL_labeledPrice> prices) {
        long jLongValue = 0;
        for (int i = 0; i < prices.size(); i++) {
            jLongValue += prices.get(i).amount;
        }
        Long l = this.tipAmount;
        if (l != null) {
            jLongValue += l.longValue();
        }
        return LocaleController.getInstance().formatCurrencyString(jLongValue, this.paymentForm.invoice.currency);
    }

    private String getTotalPriceDecimalString(ArrayList<TLRPC$TL_labeledPrice> prices) {
        long j = 0;
        for (int i = 0; i < prices.size(); i++) {
            j += prices.get(i).amount;
        }
        return LocaleController.getInstance().formatCurrencyDecimalString(j, this.paymentForm.invoice.currency, false);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onFragmentCreate() {
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.twoStepPasswordChanged);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.didRemoveTwoStepPassword);
        if (this.currentStep != 4) {
            NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.paymentFinished);
        }
        return super.onFragmentCreate();
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onFragmentDestroy() throws InterruptedException {
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

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    protected void onTransitionAnimationEnd(boolean isOpen, boolean backward) {
        if (!isOpen || backward) {
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
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$31cygFeWg0ulusbEn5o5Pooo1lc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onTransitionAnimationEnd$35$PaymentFormActivity();
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
    /* renamed from: lambda$onTransitionAnimationEnd$35, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onTransitionAnimationEnd$35$PaymentFormActivity() {
        this.inputFields[0].requestFocus();
        AndroidUtilities.showKeyboard(this.inputFields[0]);
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment, ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    public void didReceivedNotification(int id, int account, Object... args) {
        if (id == NotificationCenter.twoStepPasswordChanged) {
            TLRPC$TL_payments_paymentForm tLRPC$TL_payments_paymentForm = this.paymentForm;
            tLRPC$TL_payments_paymentForm.password_missing = false;
            tLRPC$TL_payments_paymentForm.can_save_credentials = true;
            updateSavePaymentField();
            return;
        }
        if (id == NotificationCenter.didRemoveTwoStepPassword) {
            TLRPC$TL_payments_paymentForm tLRPC$TL_payments_paymentForm2 = this.paymentForm;
            tLRPC$TL_payments_paymentForm2.password_missing = true;
            tLRPC$TL_payments_paymentForm2.can_save_credentials = false;
            updateSavePaymentField();
            return;
        }
        if (id == NotificationCenter.paymentFinished) {
            removeSelfFromStack();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public void onActivityResultFragment(int requestCode, final int resultCode, Intent data) {
        if (requestCode == 991) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$ZiCQgIp3xtxJhruzLSr4HRvpcBQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onActivityResultFragment$36$PaymentFormActivity(resultCode);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onActivityResultFragment$36, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onActivityResultFragment$36$PaymentFormActivity(int i) {
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
            this.passwordFragment.setDelegate(new PaymentFormActivityDelegate() { // from class: ir.eitaa.ui.PaymentFormActivity.24
                @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
                public /* synthetic */ void didSelectNewAddress(TLRPC$TL_payments_validateRequestedInfo tLRPC$TL_payments_validateRequestedInfo) {
                    PaymentFormActivityDelegate.CC.$default$didSelectNewAddress(this, tLRPC$TL_payments_validateRequestedInfo);
                }

                @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
                public boolean didSelectNewCard(String tokenJson, String card, boolean saveCard, TLRPC$TL_inputPaymentCredentialsGooglePay googlePay) {
                    if (PaymentFormActivity.this.delegate != null) {
                        PaymentFormActivity.this.delegate.didSelectNewCard(tokenJson, card, saveCard, googlePay);
                    }
                    if (PaymentFormActivity.this.isWebView) {
                        PaymentFormActivity.this.removeSelfFromStack();
                    }
                    return PaymentFormActivity.this.delegate != null;
                }

                @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
                public void onFragmentDestroyed() {
                    PaymentFormActivity.this.passwordFragment = null;
                }

                @Override // ir.eitaa.ui.PaymentFormActivity.PaymentFormActivityDelegate
                public void currentPasswordUpdated(TLRPC$TL_account_password password) {
                    PaymentFormActivity.this.currentPassword = password;
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
                    spannableStringBuilder.replace(i2, i2 + 1, (CharSequence) "");
                    spannableStringBuilder.replace(i, i + 1, (CharSequence) "");
                    spannableStringBuilder.setSpan(new LinkSpan(), i, i2 - 1, 33);
                }
            }
            this.checkCell1.setEnabled(true);
            this.bottomCell[0].setText(spannableStringBuilder);
            this.checkCell1.setVisibility(0);
            this.bottomCell[0].setVisibility(0);
            ShadowSectionCell[] shadowSectionCellArr = this.sectionCell;
            shadowSectionCellArr[2].setBackgroundDrawable(Theme.getThemedDrawable(shadowSectionCellArr[2].getContext(), R.drawable.greydivider, "windowBackgroundGrayShadow"));
            return;
        }
        this.checkCell1.setVisibility(8);
        this.bottomCell[0].setVisibility(8);
        ShadowSectionCell[] shadowSectionCellArr2 = this.sectionCell;
        shadowSectionCellArr2[2].setBackgroundDrawable(Theme.getThemedDrawable(shadowSectionCellArr2[2].getContext(), R.drawable.greydivider_bottom, "windowBackgroundGrayShadow"));
    }

    @SuppressLint({"HardwareIds"})
    public void fillNumber(String number) {
        boolean z;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) ApplicationLoader.applicationContext.getSystemService("phone");
            if (number == null && (telephonyManager.getSimState() == 1 || telephonyManager.getPhoneType() == 0)) {
                return;
            }
            boolean z2 = Build.VERSION.SDK_INT < 23 || getParentActivity().checkSelfPermission("android.permission.READ_PHONE_STATE") == 0;
            if (number != null || z2) {
                String strSubstring = null;
                if (TextUtils.isEmpty(number)) {
                    return;
                }
                int i = 4;
                if (number.length() > 4) {
                    while (true) {
                        if (i < 1) {
                            z = false;
                            break;
                        }
                        String strSubstring2 = number.substring(0, i);
                        if (this.codesMap.get(strSubstring2) != null) {
                            strSubstring = number.substring(i);
                            this.inputFields[8].setText(strSubstring2);
                            z = true;
                            break;
                        }
                        i--;
                    }
                    if (!z) {
                        strSubstring = number.substring(1);
                        this.inputFields[8].setText(number.substring(0, 1));
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
    public void sendSavePassword(final boolean clear) {
        final String str;
        final String str2;
        if (!clear && this.codeFieldCell.getVisibility() == 0) {
            String text = this.codeFieldCell.getText();
            if (text.length() == 0) {
                shakeView(this.codeFieldCell);
                return;
            }
            showEditDoneProgress(true, true);
            TLRPC$TL_account_confirmPasswordEmail tLRPC$TL_account_confirmPasswordEmail = new TLRPC$TL_account_confirmPasswordEmail();
            tLRPC$TL_account_confirmPasswordEmail.code = text;
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_confirmPasswordEmail, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$rSKnX7GVbSOsrHEA-xrNgTvsIzY
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$sendSavePassword$38$PaymentFormActivity(tLObject, tLRPC$TL_error);
                }
            }, 10);
            return;
        }
        final TLRPC$TL_account_updatePasswordSettings tLRPC$TL_account_updatePasswordSettings = new TLRPC$TL_account_updatePasswordSettings();
        if (clear) {
            this.doneItem.setVisibility(0);
            TLRPC$TL_account_passwordInputSettings tLRPC$TL_account_passwordInputSettings = new TLRPC$TL_account_passwordInputSettings();
            tLRPC$TL_account_updatePasswordSettings.new_settings = tLRPC$TL_account_passwordInputSettings;
            tLRPC$TL_account_passwordInputSettings.flags = 2;
            tLRPC$TL_account_passwordInputSettings.email = "";
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
            tLRPC$TL_account_passwordInputSettings2.hint = "";
            tLRPC$TL_account_passwordInputSettings2.new_algo = this.currentPassword.new_algo;
            tLRPC$TL_account_passwordInputSettings2.flags = i | 2;
            tLRPC$TL_account_passwordInputSettings2.email = string2.trim();
            str = string;
            str2 = string2;
        }
        showEditDoneProgress(true, true);
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$FtsNIVl7J34zFUWXBMbW2eunxkU
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendSavePassword$44$PaymentFormActivity(clear, str2, str, tLRPC$TL_account_updatePasswordSettings);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendSavePassword$38, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendSavePassword$38$PaymentFormActivity(TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$2ic7NRzyHTDjcvC9nWmC4lqbKK8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendSavePassword$37$PaymentFormActivity(tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendSavePassword$37, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendSavePassword$37$PaymentFormActivity(TLRPC$TL_error tLRPC$TL_error) {
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
            this.codeFieldCell.setText("", false);
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
    /* renamed from: lambda$sendSavePassword$43, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendSavePassword$43$PaymentFormActivity(final boolean z, final String str, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$VuRTO1vmqaXwlCqFPr1_8_hjxB4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendSavePassword$42$PaymentFormActivity(tLRPC$TL_error, z, tLObject, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendSavePassword$44, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendSavePassword$44$PaymentFormActivity(final boolean z, final String str, String str2, TLRPC$TL_account_updatePasswordSettings tLRPC$TL_account_updatePasswordSettings) {
        RequestDelegate requestDelegate = new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$uJkCZ0-ONnB-4W5efxgWbd9LPMc
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$sendSavePassword$43$PaymentFormActivity(z, str, tLObject, tLRPC$TL_error);
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
    /* renamed from: lambda$sendSavePassword$42, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendSavePassword$42$PaymentFormActivity(TLRPC$TL_error tLRPC$TL_error, final boolean z, TLObject tLObject, final String str) {
        String pluralString;
        if (tLRPC$TL_error != null && "SRP_ID_INVALID".equals(tLRPC$TL_error.text)) {
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(new TLRPC$TL_account_getPassword(), new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$5iej_5WWVD5nrigYcbgYdEfx5Ls
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error2) {
                    this.f$0.lambda$sendSavePassword$40$PaymentFormActivity(z, tLObject2, tLRPC$TL_error2);
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
                builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), new DialogInterface.OnClickListener() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$TPHas6EEqs5hkd3VhlOTkxb2ajE
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.f$0.lambda$sendSavePassword$41$PaymentFormActivity(str, dialogInterface, i);
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
    /* renamed from: lambda$sendSavePassword$40, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendSavePassword$40$PaymentFormActivity(final boolean z, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$Rc8KceJ2mObKGfdvcEO_ARtBpiw
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendSavePassword$39$PaymentFormActivity(tLRPC$TL_error, tLObject, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendSavePassword$39, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendSavePassword$39$PaymentFormActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, boolean z) {
        if (tLRPC$TL_error == null) {
            TLRPC$TL_account_password tLRPC$TL_account_password = (TLRPC$TL_account_password) tLObject;
            this.currentPassword = tLRPC$TL_account_password;
            TwoStepVerificationActivity.initPasswordNewAlgo(tLRPC$TL_account_password);
            sendSavePassword(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendSavePassword$41, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendSavePassword$41$PaymentFormActivity(String str, DialogInterface dialogInterface, int i) {
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
                new AsyncTask<Object, Object, String>() { // from class: ir.eitaa.ui.PaymentFormActivity.26
                    /* JADX INFO: Access modifiers changed from: protected */
                    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0137: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:37:0x0137 */
                    /* JADX WARN: Removed duplicated region for block: B:39:0x013a  */
                    @Override // android.os.AsyncTask
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public java.lang.String doInBackground(java.lang.Object... r13) throws java.lang.Throwable {
                        /*
                            Method dump skipped, instructions count: 318
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.ui.PaymentFormActivity.AnonymousClass26.doInBackground(java.lang.Object[]):java.lang.String");
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // android.os.AsyncTask
                    public void onPostExecute(String result) {
                        if (PaymentFormActivity.this.canceled) {
                            return;
                        }
                        if (result != null) {
                            PaymentFormActivity.this.paymentJson = result;
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

    /* renamed from: ir.eitaa.ui.PaymentFormActivity$25, reason: invalid class name */
    class AnonymousClass25 implements TokenCallback {
        AnonymousClass25() {
        }

        @Override // com.stripe.android.TokenCallback
        public void onSuccess(Token token) {
            if (PaymentFormActivity.this.canceled) {
                return;
            }
            PaymentFormActivity.this.paymentJson = String.format(Locale.US, "{\"type\":\"%1$s\", \"id\":\"%2$s\"}", token.getType(), token.getId());
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$25$g7xHCsO7slbq8SnBNUXd1fzQ7hc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onSuccess$0$PaymentFormActivity$25();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$onSuccess$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$onSuccess$0$PaymentFormActivity$25() {
            PaymentFormActivity.this.goToNextStep();
            PaymentFormActivity.this.showEditDoneProgress(true, false);
            PaymentFormActivity.this.setDonePressed(false);
        }

        @Override // com.stripe.android.TokenCallback
        public void onError(Exception error) {
            if (PaymentFormActivity.this.canceled) {
                return;
            }
            PaymentFormActivity.this.showEditDoneProgress(true, false);
            PaymentFormActivity.this.setDonePressed(false);
            if ((error instanceof APIConnectionException) || (error instanceof APIException)) {
                AlertsCreator.showSimpleToast(PaymentFormActivity.this, LocaleController.getString("PaymentConnectionFailed", R.string.PaymentConnectionFailed));
            } else {
                AlertsCreator.showSimpleToast(PaymentFormActivity.this, error.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getResponseBody(InputStream responseStream) throws IOException {
        String next = new Scanner(responseStream, "UTF-8").useDelimiter("\\A").next();
        responseStream.close();
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
                str = "";
            }
            tLRPC$TL_postAddress.country_iso2 = str;
            tLRPC$TL_postAddress.post_code = this.inputFields[5].getText().toString();
            this.validateRequest.info.flags |= 8;
        }
        final TLRPC$TL_payments_validateRequestedInfo tLRPC$TL_payments_validateRequestedInfo3 = this.validateRequest;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(this.validateRequest, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$94If81O2IvTQqFEMtO869WiQafM
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$sendForm$48$PaymentFormActivity(tLRPC$TL_payments_validateRequestedInfo3, tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendForm$48, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendForm$48$PaymentFormActivity(final TLObject tLObject, final TLObject tLObject2, final TLRPC$TL_error tLRPC$TL_error) {
        if (tLObject2 instanceof TLRPC$TL_payments_validatedRequestedInfo) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$BJ1kJ2fzWa8Q-1Malr9a0ME4ock
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$sendForm$46$PaymentFormActivity(tLObject2);
                }
            });
        } else {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$J3uvzVf6qrGx1neCnnpAxLrT_00
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$sendForm$47$PaymentFormActivity(tLRPC$TL_error, tLObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendForm$46, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendForm$46$PaymentFormActivity(TLObject tLObject) {
        this.requestedInfo = (TLRPC$TL_payments_validatedRequestedInfo) tLObject;
        if (this.paymentForm.saved_info != null && !this.saveShippingInfo) {
            TLRPC$TL_payments_clearSavedInfo tLRPC$TL_payments_clearSavedInfo = new TLRPC$TL_payments_clearSavedInfo();
            tLRPC$TL_payments_clearSavedInfo.info = true;
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_payments_clearSavedInfo, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$hbBF03VqkoujdFKN-r_oZE-L85w
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject2, TLRPC$TL_error tLRPC$TL_error) {
                    PaymentFormActivity.lambda$sendForm$45(tLObject2, tLRPC$TL_error);
                }
            });
        }
        goToNextStep();
        setDonePressed(false);
        showEditDoneProgress(true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendForm$47, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendForm$47$PaymentFormActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject) {
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
            TLRPC$InputPaymentCredentials tLRPC$InputPaymentCredentials = new TLRPC$InputPaymentCredentials() { // from class: ir.eitaa.tgnet.TLRPC$TL_inputPaymentCredentialsSaved
                public static int constructor = -1056001329;

                @Override // ir.eitaa.tgnet.TLObject
                public void readParams(AbstractSerializedData stream, boolean exception) {
                    this.id = stream.readString(exception);
                    this.tmp_password = stream.readByteArray(exception);
                }

                @Override // ir.eitaa.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData stream) {
                    stream.writeInt32(constructor);
                    stream.writeString(this.id);
                    stream.writeByteArray(this.tmp_password);
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
                TLRPC$InputPaymentCredentials tLRPC$InputPaymentCredentials2 = new TLRPC$InputPaymentCredentials() { // from class: ir.eitaa.tgnet.TLRPC$TL_inputPaymentCredentials
                    public static int constructor = 873977640;

                    @Override // ir.eitaa.tgnet.TLObject
                    public void readParams(AbstractSerializedData stream, boolean exception) {
                        int int32 = stream.readInt32(exception);
                        this.flags = int32;
                        this.save = (int32 & 1) != 0;
                        this.data = TLRPC$TL_dataJSON.TLdeserialize(stream, stream.readInt32(exception), exception);
                    }

                    @Override // ir.eitaa.tgnet.TLObject
                    public void serializeToStream(AbstractSerializedData stream) {
                        stream.writeInt32(constructor);
                        int i = this.save ? this.flags | 1 : this.flags & (-2);
                        this.flags = i;
                        stream.writeInt32(i);
                        this.data.serializeToStream(stream);
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
        if ((this.paymentForm.invoice.flags & Factory.DEVICE_HAS_CRAPPY_OPENSLES) != 0) {
            Long l = this.tipAmount;
            tLRPC$TL_payments_sendPaymentForm.tip_amount = l != null ? l.longValue() : 0L;
            tLRPC$TL_payments_sendPaymentForm.flags |= 4;
        }
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_payments_sendPaymentForm, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$C56gun4U3q0PFMGNwQx4VAFbLHA
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$sendData$52$PaymentFormActivity(tLRPC$TL_payments_sendPaymentForm, tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendData$52, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendData$52$PaymentFormActivity(final TLRPC$TL_payments_sendPaymentForm tLRPC$TL_payments_sendPaymentForm, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
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
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$vm2YC00z0MzIGXd8OgWtZvkn8l0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$sendData$49$PaymentFormActivity(tLRPC$MessageArr);
                    }
                });
                return;
            }
            if (tLObject instanceof TLRPC$TL_payments_paymentVerificationNeeded) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$wE08Cw6Qc0N9eKDJJMSuckg74Qc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$sendData$50$PaymentFormActivity(tLObject);
                    }
                });
                return;
            }
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$fCxFXy7o2Xnl2OnMmsbBYPDLvjE
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$sendData$51$PaymentFormActivity(tLRPC$TL_error, tLRPC$TL_payments_sendPaymentForm);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendData$49, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendData$49$PaymentFormActivity(TLRPC$Message[] tLRPC$MessageArr) {
        goToNextStep();
        if (this.parentFragment instanceof ChatActivity) {
            ((ChatActivity) this.parentFragment).getUndoView().showWithAction(0L, 77, AndroidUtilities.replaceTags(LocaleController.formatString("PaymentInfoHint", R.string.PaymentInfoHint, this.totalPrice[0], this.currentItemName)), tLRPC$MessageArr[0], (Runnable) null, (Runnable) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendData$50, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendData$50$PaymentFormActivity(TLObject tLObject) {
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
    /* renamed from: lambda$sendData$51, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendData$51$PaymentFormActivity(TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_payments_sendPaymentForm tLRPC$TL_payments_sendPaymentForm) {
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, this, tLRPC$TL_payments_sendPaymentForm, new Object[0]);
        setDonePressed(false);
        showEditDoneProgress(false, false);
    }

    private void shakeField(int field) {
        shakeView(this.inputFields[field]);
    }

    private void shakeView(View view) {
        Vibrator vibrator = (Vibrator) getParentActivity().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(200L);
        }
        AndroidUtilities.shakeView(view, 2.0f, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDonePressed(boolean value) {
        this.donePressed = value;
        this.swipeBackEnabled = !value;
        ActionBar actionBar = this.actionBar;
        if (actionBar != null) {
            actionBar.getBackButton().setEnabled(!this.donePressed);
        }
        TextDetailSettingsCell[] textDetailSettingsCellArr = this.detailSettingsCell;
        if (textDetailSettingsCellArr[0] != null) {
            textDetailSettingsCellArr[0].setEnabled(!this.donePressed);
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean isSwipeBackEnabled(MotionEvent event) {
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
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_account_getPassword, new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$uGuypLs_BWKEEvKQLOY0If2bJe8
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$checkPassword$57$PaymentFormActivity(string, tLRPC$TL_account_getPassword, tLObject, tLRPC$TL_error);
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkPassword$57, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkPassword$57$PaymentFormActivity(final String str, final TLRPC$TL_account_getPassword tLRPC$TL_account_getPassword, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$m41p1h_E3AB3pOL0vj9cqqX7mQs
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkPassword$56$PaymentFormActivity(tLRPC$TL_error, tLObject, str, tLRPC$TL_account_getPassword);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkPassword$56, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkPassword$56$PaymentFormActivity(TLRPC$TL_error tLRPC$TL_error, TLObject tLObject, String str, TLRPC$TL_account_getPassword tLRPC$TL_account_getPassword) {
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
                Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$R3dGCeULPo3wshPPz2zAt6dUWwM
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$checkPassword$55$PaymentFormActivity(tLRPC$TL_account_password, stringBytes);
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
    /* renamed from: lambda$checkPassword$55, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkPassword$55$PaymentFormActivity(TLRPC$TL_account_password tLRPC$TL_account_password, byte[] bArr) {
        TLRPC$PasswordKdfAlgo tLRPC$PasswordKdfAlgo = tLRPC$TL_account_password.current_algo;
        byte[] x = tLRPC$PasswordKdfAlgo instanceof TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow ? SRPHelper.getX(bArr, (TLRPC$TL_passwordKdfAlgoSHA256SHA256PBKDF2HMACSHA512iter100000SHA256ModPow) tLRPC$PasswordKdfAlgo) : null;
        final TLRPC$TL_account_getTmpPassword tLRPC$TL_account_getTmpPassword = new TLRPC$TL_account_getTmpPassword();
        tLRPC$TL_account_getTmpPassword.period = 1800;
        RequestDelegate requestDelegate = new RequestDelegate() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$KSg8UmceEQFXuRx_HrMlIypFbgo
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$checkPassword$54$PaymentFormActivity(tLRPC$TL_account_getTmpPassword, tLObject, tLRPC$TL_error);
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
    /* renamed from: lambda$checkPassword$54, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkPassword$54$PaymentFormActivity(final TLRPC$TL_account_getTmpPassword tLRPC$TL_account_getTmpPassword, final TLObject tLObject, final TLRPC$TL_error tLRPC$TL_error) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.ui.-$$Lambda$PaymentFormActivity$fZuWTllvDy4_z7neUAKAmH7dYLg
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkPassword$53$PaymentFormActivity(tLObject, tLRPC$TL_error, tLRPC$TL_account_getTmpPassword);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$checkPassword$53, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$checkPassword$53$PaymentFormActivity(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error, TLRPC$TL_account_getTmpPassword tLRPC$TL_account_getTmpPassword) {
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
            this.inputFields[1].setText("");
            return;
        }
        AlertsCreator.processError(this.currentAccount, tLRPC$TL_error, this, tLRPC$TL_account_getTmpPassword, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEditDoneProgress(final boolean animateDoneItem, final boolean show) {
        AnimatorSet animatorSet = this.doneItemAnimation;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        if (animateDoneItem && this.doneItem != null) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.doneItemAnimation = animatorSet2;
            if (show) {
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
            this.doneItemAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PaymentFormActivity.27
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (PaymentFormActivity.this.doneItemAnimation == null || !PaymentFormActivity.this.doneItemAnimation.equals(animation)) {
                        return;
                    }
                    if (!show) {
                        PaymentFormActivity.this.progressView.setVisibility(4);
                    } else {
                        PaymentFormActivity.this.doneItem.getContentView().setVisibility(4);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    if (PaymentFormActivity.this.doneItemAnimation == null || !PaymentFormActivity.this.doneItemAnimation.equals(animation)) {
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
            if (show) {
                this.progressViewButton.setVisibility(0);
                this.bottomLayout.setEnabled(false);
                this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.payTextView, (Property<TextView, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.payTextView, (Property<TextView, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.payTextView, (Property<TextView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.progressViewButton, (Property<ContextProgressView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.progressViewButton, (Property<ContextProgressView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.progressViewButton, (Property<ContextProgressView, Float>) View.ALPHA, 1.0f));
            } else {
                this.payTextView.setVisibility(0);
                this.bottomLayout.setEnabled(true);
                this.doneItemAnimation.playTogether(ObjectAnimator.ofFloat(this.progressViewButton, (Property<ContextProgressView, Float>) View.SCALE_X, 0.1f), ObjectAnimator.ofFloat(this.progressViewButton, (Property<ContextProgressView, Float>) View.SCALE_Y, 0.1f), ObjectAnimator.ofFloat(this.progressViewButton, (Property<ContextProgressView, Float>) View.ALPHA, 0.0f), ObjectAnimator.ofFloat(this.payTextView, (Property<TextView, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.payTextView, (Property<TextView, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.payTextView, (Property<TextView, Float>) View.ALPHA, 1.0f));
            }
            this.doneItemAnimation.addListener(new AnimatorListenerAdapter() { // from class: ir.eitaa.ui.PaymentFormActivity.28
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    if (PaymentFormActivity.this.doneItemAnimation == null || !PaymentFormActivity.this.doneItemAnimation.equals(animation)) {
                        return;
                    }
                    if (!show) {
                        PaymentFormActivity.this.progressViewButton.setVisibility(4);
                    } else {
                        PaymentFormActivity.this.payTextView.setVisibility(4);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    if (PaymentFormActivity.this.doneItemAnimation == null || !PaymentFormActivity.this.doneItemAnimation.equals(animation)) {
                        return;
                    }
                    PaymentFormActivity.this.doneItemAnimation = null;
                }
            });
            this.doneItemAnimation.setDuration(150L);
            this.doneItemAnimation.start();
        }
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public boolean onBackPressed() {
        if (this.shouldNavigateBack) {
            this.webView.loadUrl(this.webViewUrl);
            this.shouldNavigateBack = false;
            return false;
        }
        return !this.donePressed;
    }

    @Override // ir.eitaa.ui.ActionBar.BaseFragment
    public ArrayList<ThemeDescription> getThemeDescriptions() {
        ArrayList<ThemeDescription> arrayList = new ArrayList<>();
        arrayList.add(new ThemeDescription(this.fragmentView, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundGray"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.scrollView, ThemeDescription.FLAG_LISTGLOWCOLOR, null, null, null, null, "actionBarDefault"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_ITEMSCOLOR, null, null, null, null, "actionBarDefaultIcon"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_TITLECOLOR, null, null, null, null, "actionBarDefaultTitle"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SELECTORCOLOR, null, null, null, null, "actionBarDefaultSelector"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCH, null, null, null, null, "actionBarDefaultSearch"));
        arrayList.add(new ThemeDescription(this.actionBar, ThemeDescription.FLAG_AB_SEARCHPLACEHOLDER, null, null, null, null, "actionBarDefaultSearchPlaceholder"));
        arrayList.add(new ThemeDescription(this.linearLayout2, 0, new Class[]{View.class}, Theme.dividerPaint, null, null, "divider"));
        arrayList.add(new ThemeDescription(this.progressView, 0, null, null, null, null, "contextProgressInner2"));
        arrayList.add(new ThemeDescription(this.progressView, 0, null, null, null, null, "contextProgressOuter2"));
        arrayList.add(new ThemeDescription(this.progressViewButton, 0, null, null, null, null, "contextProgressInner2"));
        arrayList.add(new ThemeDescription(this.progressViewButton, 0, null, null, null, null, "contextProgressOuter2"));
        if (this.inputFields != null) {
            for (int i = 0; i < this.inputFields.length; i++) {
                arrayList.add(new ThemeDescription((View) this.inputFields[i].getParent(), ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
                arrayList.add(new ThemeDescription(this.inputFields[i], ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
                arrayList.add(new ThemeDescription(this.inputFields[i], ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
            }
        } else {
            arrayList.add(new ThemeDescription(null, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
            arrayList.add(new ThemeDescription(null, ThemeDescription.FLAG_HINTTEXTCOLOR, null, null, null, null, "windowBackgroundWhiteHintText"));
        }
        if (this.radioCells != null) {
            for (int i2 = 0; i2 < this.radioCells.length; i2++) {
                arrayList.add(new ThemeDescription(this.radioCells[i2], ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, "windowBackgroundWhite"));
                arrayList.add(new ThemeDescription(this.radioCells[i2], ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, "listSelectorSDK21"));
                arrayList.add(new ThemeDescription(this.radioCells[i2], 0, new Class[]{RadioCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
                arrayList.add(new ThemeDescription(this.radioCells[i2], ThemeDescription.FLAG_CHECKBOX, new Class[]{RadioCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "radioBackground"));
                arrayList.add(new ThemeDescription(this.radioCells[i2], ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{RadioCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "radioBackgroundChecked"));
            }
        } else {
            arrayList.add(new ThemeDescription((View) null, 0, new Class[]{RadioCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
            arrayList.add(new ThemeDescription((View) null, ThemeDescription.FLAG_CHECKBOX, new Class[]{RadioCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "radioBackground"));
            arrayList.add(new ThemeDescription((View) null, ThemeDescription.FLAG_CHECKBOXCHECK, new Class[]{RadioCell.class}, new String[]{"radioButton"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "radioBackgroundChecked"));
        }
        for (int i3 = 0; i3 < this.headerCell.length; i3++) {
            arrayList.add(new ThemeDescription(this.headerCell[i3], ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
            arrayList.add(new ThemeDescription(this.headerCell[i3], 0, new Class[]{HeaderCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlueHeader"));
        }
        for (int i4 = 0; i4 < this.sectionCell.length; i4++) {
            arrayList.add(new ThemeDescription(this.sectionCell[i4], ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{ShadowSectionCell.class}, null, null, null, "windowBackgroundGrayShadow"));
        }
        for (int i5 = 0; i5 < this.bottomCell.length; i5++) {
            arrayList.add(new ThemeDescription(this.bottomCell[i5], ThemeDescription.FLAG_BACKGROUNDFILTER, new Class[]{TextInfoPrivacyCell.class}, null, null, null, "windowBackgroundGrayShadow"));
            arrayList.add(new ThemeDescription(this.bottomCell[i5], 0, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText4"));
            arrayList.add(new ThemeDescription(this.bottomCell[i5], ThemeDescription.FLAG_LINKCOLOR, new Class[]{TextInfoPrivacyCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteLinkText"));
        }
        for (int i6 = 0; i6 < this.dividers.size(); i6++) {
            arrayList.add(new ThemeDescription(this.dividers.get(i6), ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        }
        arrayList.add(new ThemeDescription(this.codeFieldCell, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.codeFieldCell, ThemeDescription.FLAG_TEXTCOLOR, new Class[]{EditTextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.codeFieldCell, ThemeDescription.FLAG_HINTTEXTCOLOR, new Class[]{EditTextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteHintText"));
        arrayList.add(new ThemeDescription(this.textView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.checkCell1, 0, new Class[]{TextCheckCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.checkCell1, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrack"));
        arrayList.add(new ThemeDescription(this.checkCell1, 0, new Class[]{TextCheckCell.class}, new String[]{"checkBox"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "switchTrackChecked"));
        arrayList.add(new ThemeDescription(this.checkCell1, ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.checkCell1, ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, "listSelectorSDK21"));
        for (int i7 = 0; i7 < this.settingsCell.length; i7++) {
            arrayList.add(new ThemeDescription(this.settingsCell[i7], ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, "windowBackgroundWhite"));
            arrayList.add(new ThemeDescription(this.settingsCell[i7], ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, "listSelectorSDK21"));
            arrayList.add(new ThemeDescription(this.settingsCell[i7], 0, new Class[]{TextSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        }
        arrayList.add(new ThemeDescription(this.payTextView, ThemeDescription.FLAG_TEXTCOLOR, null, null, null, null, "windowBackgroundWhiteBlueText6"));
        arrayList.add(new ThemeDescription(this.linearLayout2, ThemeDescription.FLAG_CELLBACKGROUNDCOLOR, new Class[]{TextPriceCell.class}, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.linearLayout2, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextPriceCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.linearLayout2, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextPriceCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.linearLayout2, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextPriceCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.linearLayout2, ThemeDescription.FLAG_CHECKTAG, new Class[]{TextPriceCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.detailSettingsCell[0], ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.detailSettingsCell[0], ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, "listSelectorSDK21"));
        for (int i8 = 1; i8 < this.detailSettingsCell.length; i8++) {
            arrayList.add(new ThemeDescription(this.detailSettingsCell[i8], ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
            arrayList.add(new ThemeDescription(this.detailSettingsCell[i8], 0, new Class[]{TextDetailSettingsCell.class}, new String[]{"textView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
            arrayList.add(new ThemeDescription(this.detailSettingsCell[i8], 0, new Class[]{TextDetailSettingsCell.class}, new String[]{"valueTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        }
        arrayList.add(new ThemeDescription(this.paymentInfoCell, ThemeDescription.FLAG_BACKGROUND, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.paymentInfoCell, 0, new Class[]{PaymentInfoCell.class}, new String[]{"nameTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.paymentInfoCell, 0, new Class[]{PaymentInfoCell.class}, new String[]{"detailTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteBlackText"));
        arrayList.add(new ThemeDescription(this.paymentInfoCell, 0, new Class[]{PaymentInfoCell.class}, new String[]{"detailExTextView"}, (Paint[]) null, (Drawable[]) null, (ThemeDescription.ThemeDescriptionDelegate) null, "windowBackgroundWhiteGrayText2"));
        arrayList.add(new ThemeDescription(this.bottomLayout, ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, "windowBackgroundWhite"));
        arrayList.add(new ThemeDescription(this.bottomLayout, ThemeDescription.FLAG_SELECTORWHITE, null, null, null, null, "listSelectorSDK21"));
        return arrayList;
    }
}
