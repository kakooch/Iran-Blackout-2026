package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.appUpdate.UpdateUtils;
import ir.resaneh1.iptv.dialog.ThreeButtonDialog;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.helper.AsteriskPasswordTransformationMethod;
import ir.resaneh1.iptv.helper.DeviceInfo;
import ir.resaneh1.iptv.helper.EncryptionHelper;
import ir.resaneh1.iptv.helper.FirebaseEventSender;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.ButtonItem;
import ir.resaneh1.iptv.model.BuyInput;
import ir.resaneh1.iptv.model.CardNumbers;
import ir.resaneh1.iptv.model.EditTextItem;
import ir.resaneh1.iptv.model.GetBuyServiceInput;
import ir.resaneh1.iptv.model.GetBuyServiceObject;
import ir.resaneh1.iptv.model.GetBuyServiceOutput2;
import ir.resaneh1.iptv.model.GetTokenPayInput;
import ir.resaneh1.iptv.model.GetTokenPayObject;
import ir.resaneh1.iptv.model.GetTokenPayOutput2;
import ir.resaneh1.iptv.model.TextViewItem;
import ir.resaneh1.iptv.model.TwoEditTextItem;
import ir.resaneh1.iptv.presenters.ButtonPresenter;
import ir.resaneh1.iptv.presenters.EditTextCardNoPresenter;
import ir.resaneh1.iptv.presenters.EditTextPasswordPresenter;
import ir.resaneh1.iptv.presenters.EditTextPresenter;
import ir.resaneh1.iptv.presenters.EditTextTwoPresenter;
import ir.resaneh1.iptv.presenters.TextViewPresenter;
import java.util.regex.Pattern;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.LaunchActivity;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class CardInfoToPayWithCvvFragment extends PresenterFragment {
    private static final Pattern timePattern = Pattern.compile("\\d{2}$");
    ButtonPresenter.MyViewHolder buttonHolder;
    private BuyInput buyInput;
    EditTextCardNoPresenter.MyViewHolder cardNoHolder;
    EditTextPresenter.MyViewHolder cvv2Holder;
    public boolean onButtonSendClicked = false;
    EditTextPasswordPresenter.MyViewHolder passwordHolder;
    String text;
    private TextViewPresenter.MyViewHolder textViewHolder;
    EditTextTwoPresenter.MyViewHolder timeHolder;

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_just_linearlayout;
    }

    public CardInfoToPayWithCvvFragment(BuyInput buyInput, String str) {
        this.text = str;
        this.buyInput = buyInput;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        this.progressBar.setVisibility(4);
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, "اطلاعات کارت");
        makeLayout();
    }

    private void makeLayout() {
        ButtonItem buttonItem;
        TextViewPresenter textViewPresenter = new TextViewPresenter(this.mContext);
        this.textViewHolder = textViewPresenter.createViewHolderAndBind(new TextViewItem(this.text));
        EditTextCardNoPresenter editTextCardNoPresenter = new EditTextCardNoPresenter(this.mContext);
        EditTextItem editTextItem = new EditTextItem(BuildConfig.FLAVOR, "شماره کارت");
        String str = this.buyInput.pan;
        if (str != null && !str.equals(BuildConfig.FLAVOR)) {
            editTextItem.text = EditTextCardNoPresenter.setFormat(this.buyInput.pan);
            editTextItem.isEditable = false;
        }
        EditTextItem editTextItem2 = new EditTextItem(BuildConfig.FLAVOR, "رمز دوم");
        EditTextItem editTextItem3 = new EditTextItem(BuildConfig.FLAVOR, "cvv2");
        TwoEditTextItem twoEditTextItem = new TwoEditTextItem(BuildConfig.FLAVOR, "ماه", BuildConfig.FLAVOR, "سال");
        this.cardNoHolder = editTextCardNoPresenter.createViewHolderAndBind(editTextItem);
        EditTextPasswordPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind = new EditTextPasswordPresenter(this.mContext).createViewHolderAndBind(editTextItem2);
        this.passwordHolder = myViewHolderCreateViewHolderAndBind;
        myViewHolderCreateViewHolderAndBind.edittext.setInputType(3);
        this.passwordHolder.edittext.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        EditTextPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind2 = new EditTextPresenter(this.mContext).createViewHolderAndBind(editTextItem3);
        this.cvv2Holder = myViewHolderCreateViewHolderAndBind2;
        myViewHolderCreateViewHolderAndBind2.edittext.setInputType(3);
        this.cvv2Holder.edittext.setGravity(3);
        this.cvv2Holder.edittext.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4) { // from class: ir.resaneh1.iptv.fragment.CardInfoToPayWithCvvFragment.1
            @Override // android.text.InputFilter.LengthFilter, android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if (charSequence != null && TextUtils.indexOf(charSequence, '\n') != -1) {
                    return BuildConfig.FLAVOR;
                }
                CharSequence charSequenceFilter = super.filter(charSequence, i, i2, spanned, i3, i4);
                if (charSequenceFilter != null && charSequence != null && charSequenceFilter.length() != charSequence.length()) {
                    ToastiLikeSnack.showL(CardInfoToPayWithCvvFragment.this.mContext, "کد cvv2 حداکثر ۴ رقمی است");
                    AndroidUtilities.shakeView(CardInfoToPayWithCvvFragment.this.cvv2Holder.itemView, 2.0f, 0);
                }
                return charSequenceFilter;
            }
        }});
        EditTextTwoPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind3 = new EditTextTwoPresenter(this.mContext).createViewHolderAndBind(twoEditTextItem);
        this.timeHolder = myViewHolderCreateViewHolderAndBind3;
        myViewHolderCreateViewHolderAndBind3.monthEdittext.setInputType(3);
        this.timeHolder.yearEdittext.setInputType(3);
        this.linearLayout.addView(textViewPresenter.createViewHolderAndBind(new TextViewItem("  ")).itemView);
        this.linearLayout.addView(this.cardNoHolder.itemView);
        this.linearLayout.addView(this.passwordHolder.itemView);
        this.linearLayout.addView(this.cvv2Holder.itemView);
        this.linearLayout.addView(this.timeHolder.itemView);
        ButtonPresenter buttonPresenter = new ButtonPresenter(this.mContext);
        if (this.buyInput.service_type == 6) {
            buttonItem = new ButtonItem("استعلام", new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.CardInfoToPayWithCvvFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment = CardInfoToPayWithCvvFragment.this;
                    if (cardInfoToPayWithCvvFragment.onButtonSendClicked) {
                        return;
                    }
                    if (EditTextCardNoPresenter.isValid(((EditTextItem) cardInfoToPayWithCvvFragment.cardNoHolder.item).text) && !((EditTextItem) CardInfoToPayWithCvvFragment.this.passwordHolder.item).text.equals(BuildConfig.FLAVOR) && !((EditTextItem) CardInfoToPayWithCvvFragment.this.cvv2Holder.item).text.equals(BuildConfig.FLAVOR)) {
                        CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment2 = CardInfoToPayWithCvvFragment.this;
                        if (cardInfoToPayWithCvvFragment2.isValidMonth(((TwoEditTextItem) cardInfoToPayWithCvvFragment2.timeHolder.item).text1)) {
                            CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment3 = CardInfoToPayWithCvvFragment.this;
                            if (cardInfoToPayWithCvvFragment3.isValidYear(((TwoEditTextItem) cardInfoToPayWithCvvFragment3.timeHolder.item).text2)) {
                                CardInfoToPayWithCvvFragment.this.callPayServiceGetToCardInfo();
                                return;
                            }
                        }
                    }
                    CardInfoToPayWithCvvFragment.this.showErrorMessage();
                }
            });
        } else {
            buttonItem = new ButtonItem("پرداخت", new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.CardInfoToPayWithCvvFragment.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment = CardInfoToPayWithCvvFragment.this;
                    if (cardInfoToPayWithCvvFragment.onButtonSendClicked) {
                        return;
                    }
                    if (EditTextCardNoPresenter.isValid(((EditTextItem) cardInfoToPayWithCvvFragment.cardNoHolder.item).text) && !((EditTextItem) CardInfoToPayWithCvvFragment.this.passwordHolder.item).text.equals(BuildConfig.FLAVOR) && !((EditTextItem) CardInfoToPayWithCvvFragment.this.cvv2Holder.item).text.equals(BuildConfig.FLAVOR)) {
                        CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment2 = CardInfoToPayWithCvvFragment.this;
                        if (cardInfoToPayWithCvvFragment2.isValidMonth(((TwoEditTextItem) cardInfoToPayWithCvvFragment2.timeHolder.item).text1)) {
                            CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment3 = CardInfoToPayWithCvvFragment.this;
                            if (cardInfoToPayWithCvvFragment3.isValidYear(((TwoEditTextItem) cardInfoToPayWithCvvFragment3.timeHolder.item).text2)) {
                                CardInfoToPayWithCvvFragment.this.callPayService();
                                return;
                            }
                        }
                    }
                    CardInfoToPayWithCvvFragment.this.showErrorMessage();
                }
            });
        }
        ButtonPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind4 = buttonPresenter.createViewHolderAndBind(buttonItem);
        this.buttonHolder = myViewHolderCreateViewHolderAndBind4;
        this.linearLayout.addView(myViewHolderCreateViewHolderAndBind4.itemView);
        this.linearLayout.addView(this.textViewHolder.itemView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callPayService() {
        String strDecrypt;
        String strDecrypt2;
        String strEncrypt;
        String strEncrypt2 = BuildConfig.FLAVOR;
        if (this.onButtonSendClicked) {
            return;
        }
        this.onButtonSendClicked = true;
        this.progressBar.setVisibility(0);
        BuyInput buyInput = this.buyInput;
        buyInput.cvv = ((EditTextItem) this.cvv2Holder.item).text;
        buyInput.exp_date = ((TwoEditTextItem) this.timeHolder.item).text2 + ((TwoEditTextItem) this.timeHolder.item).text1;
        MyLog.e("GetCardBalanceFragment", "callPayService: " + this.buyInput.service_type + this.buyInput.exp_date);
        this.buyInput.pan = ((EditTextItem) this.cardNoHolder.item).text;
        String str = ((EditTextItem) this.passwordHolder.item).text;
        String string = getAppPreferences().getString(AppPreferences.Key.sessionKey780);
        String string2 = getAppPreferences().getString(AppPreferences.Key.pinKey780);
        try {
            strDecrypt = EncryptionHelper.decrypt(string, EncryptionHelper.keyMaster1 + EncryptionHelper.keyMaster2);
        } catch (Exception e) {
            e = e;
            strDecrypt = BuildConfig.FLAVOR;
        }
        try {
            strDecrypt2 = EncryptionHelper.decrypt(string2, EncryptionHelper.keyMaster1 + EncryptionHelper.keyMaster2);
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            strDecrypt2 = BuildConfig.FLAVOR;
            String strEncodeToString = Base64.encodeToString(str.getBytes(), 0);
            MyLog.e("CardInfoToPayFragment", "passwordBase64 " + strEncodeToString);
            strEncrypt = EncryptionHelper.encrypt(strEncodeToString, strDecrypt2);
            try {
                MyLog.e("CardInfoToPayFragment", "encryptedPin " + strEncrypt);
            } catch (Exception unused) {
            }
            this.buyInput.pin = strEncrypt;
            GetBuyServiceInput getBuyServiceInput = new GetBuyServiceInput();
            getBuyServiceInput.ip = "255.255.255.255";
            getBuyServiceInput.token = getAppPreferences().getString(AppPreferences.Key.token780);
            strEncrypt2 = EncryptionHelper.encrypt(Base64.encodeToString(ApplicationLoader.getGson().toJson(this.buyInput).getBytes(), 0), strDecrypt);
            getBuyServiceInput.enc_msg = strEncrypt2;
            MyLog.e("CardInfoToPayFragment", this.buyInput.service_type + " " + this.buyInput.amount);
            ApiRequestIPTV.getInstance(this.currentAccount).getBuyServicePay(getBuyServiceInput, new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.CardInfoToPayWithCvvFragment.4
                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                public void onResponse(Call call, Response response) {
                    GetBuyServiceObject getBuyServiceObject;
                    GetBuyServiceObject getBuyServiceObject2;
                    GetBuyServiceObject.ResultInfo resultInfo;
                    int i;
                    MyLog.e("CardInfoToPayFragment", "onResponse: ");
                    CardInfoToPayWithCvvFragment.this.progressBar.setVisibility(4);
                    GetBuyServiceOutput2 getBuyServiceOutput2 = (GetBuyServiceOutput2) response.body();
                    if (getBuyServiceOutput2 == null || (getBuyServiceObject = getBuyServiceOutput2.result) == null || getBuyServiceObject.equals(BuildConfig.FLAVOR) || (i = (resultInfo = (getBuyServiceObject2 = getBuyServiceOutput2.result).result_info).responsecode) == 80090) {
                        CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment = CardInfoToPayWithCvvFragment.this;
                        cardInfoToPayWithCvvFragment.onButtonSendClicked = false;
                        cardInfoToPayWithCvvFragment.callGetToken();
                        ToastiLikeSnack.showL(CardInfoToPayWithCvvFragment.this.mContext, "لطفا دوباره تلاش نمایید");
                        return;
                    }
                    if (resultInfo != null) {
                        if (i == 0) {
                            CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment2 = CardInfoToPayWithCvvFragment.this;
                            cardInfoToPayWithCvvFragment2.onButtonSendClicked = true;
                            cardInfoToPayWithCvvFragment2.showInfoDialog(getBuyServiceObject2);
                            CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment3 = CardInfoToPayWithCvvFragment.this;
                            cardInfoToPayWithCvvFragment3.addCardNumber(((BaseFragment) cardInfoToPayWithCvvFragment3).currentAccount);
                            return;
                        }
                        CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment4 = CardInfoToPayWithCvvFragment.this;
                        cardInfoToPayWithCvvFragment4.onButtonSendClicked = false;
                        FirebaseEventSender.sendEvent(cardInfoToPayWithCvvFragment4.mContext, "payment_failed" + CardInfoToPayWithCvvFragment.this.buyInput.service_type, BuildConfig.FLAVOR);
                        String str2 = getBuyServiceObject2.add_data;
                        if (str2 != null && !str2.equals(BuildConfig.FLAVOR)) {
                            CardInfoToPayWithCvvFragment.this.textViewHolder.textView.setText(getBuyServiceObject2.add_data);
                            return;
                        }
                        String str3 = getBuyServiceObject2.result_info.responsedesc;
                        if (str3 == null || str3.equals(BuildConfig.FLAVOR)) {
                            CardInfoToPayWithCvvFragment.this.textViewHolder.textView.setText("عملیات ناموفق");
                        } else {
                            CardInfoToPayWithCvvFragment.this.textViewHolder.textView.setText(getBuyServiceObject2.result_info.responsedesc);
                        }
                    }
                }

                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                public void onFailure(Call call, Throwable th) {
                    CardInfoToPayWithCvvFragment.this.progressBar.setVisibility(4);
                    CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment = CardInfoToPayWithCvvFragment.this;
                    cardInfoToPayWithCvvFragment.onButtonSendClicked = false;
                    cardInfoToPayWithCvvFragment.textViewHolder.textView.setText("عملیات ناموفق");
                    MyLog.e("CardInfoToPayFragment", "onFailure: ");
                }
            });
        }
        try {
            String strEncodeToString2 = Base64.encodeToString(str.getBytes(), 0);
            MyLog.e("CardInfoToPayFragment", "passwordBase64 " + strEncodeToString2);
            strEncrypt = EncryptionHelper.encrypt(strEncodeToString2, strDecrypt2);
            MyLog.e("CardInfoToPayFragment", "encryptedPin " + strEncrypt);
        } catch (Exception unused2) {
            strEncrypt = BuildConfig.FLAVOR;
        }
        this.buyInput.pin = strEncrypt;
        GetBuyServiceInput getBuyServiceInput2 = new GetBuyServiceInput();
        getBuyServiceInput2.ip = "255.255.255.255";
        getBuyServiceInput2.token = getAppPreferences().getString(AppPreferences.Key.token780);
        try {
            strEncrypt2 = EncryptionHelper.encrypt(Base64.encodeToString(ApplicationLoader.getGson().toJson(this.buyInput).getBytes(), 0), strDecrypt);
        } catch (Exception unused3) {
        }
        getBuyServiceInput2.enc_msg = strEncrypt2;
        MyLog.e("CardInfoToPayFragment", this.buyInput.service_type + " " + this.buyInput.amount);
        ApiRequestIPTV.getInstance(this.currentAccount).getBuyServicePay(getBuyServiceInput2, new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.CardInfoToPayWithCvvFragment.4
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                GetBuyServiceObject getBuyServiceObject;
                GetBuyServiceObject getBuyServiceObject2;
                GetBuyServiceObject.ResultInfo resultInfo;
                int i;
                MyLog.e("CardInfoToPayFragment", "onResponse: ");
                CardInfoToPayWithCvvFragment.this.progressBar.setVisibility(4);
                GetBuyServiceOutput2 getBuyServiceOutput2 = (GetBuyServiceOutput2) response.body();
                if (getBuyServiceOutput2 == null || (getBuyServiceObject = getBuyServiceOutput2.result) == null || getBuyServiceObject.equals(BuildConfig.FLAVOR) || (i = (resultInfo = (getBuyServiceObject2 = getBuyServiceOutput2.result).result_info).responsecode) == 80090) {
                    CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment = CardInfoToPayWithCvvFragment.this;
                    cardInfoToPayWithCvvFragment.onButtonSendClicked = false;
                    cardInfoToPayWithCvvFragment.callGetToken();
                    ToastiLikeSnack.showL(CardInfoToPayWithCvvFragment.this.mContext, "لطفا دوباره تلاش نمایید");
                    return;
                }
                if (resultInfo != null) {
                    if (i == 0) {
                        CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment2 = CardInfoToPayWithCvvFragment.this;
                        cardInfoToPayWithCvvFragment2.onButtonSendClicked = true;
                        cardInfoToPayWithCvvFragment2.showInfoDialog(getBuyServiceObject2);
                        CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment3 = CardInfoToPayWithCvvFragment.this;
                        cardInfoToPayWithCvvFragment3.addCardNumber(((BaseFragment) cardInfoToPayWithCvvFragment3).currentAccount);
                        return;
                    }
                    CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment4 = CardInfoToPayWithCvvFragment.this;
                    cardInfoToPayWithCvvFragment4.onButtonSendClicked = false;
                    FirebaseEventSender.sendEvent(cardInfoToPayWithCvvFragment4.mContext, "payment_failed" + CardInfoToPayWithCvvFragment.this.buyInput.service_type, BuildConfig.FLAVOR);
                    String str2 = getBuyServiceObject2.add_data;
                    if (str2 != null && !str2.equals(BuildConfig.FLAVOR)) {
                        CardInfoToPayWithCvvFragment.this.textViewHolder.textView.setText(getBuyServiceObject2.add_data);
                        return;
                    }
                    String str3 = getBuyServiceObject2.result_info.responsedesc;
                    if (str3 == null || str3.equals(BuildConfig.FLAVOR)) {
                        CardInfoToPayWithCvvFragment.this.textViewHolder.textView.setText("عملیات ناموفق");
                    } else {
                        CardInfoToPayWithCvvFragment.this.textViewHolder.textView.setText(getBuyServiceObject2.result_info.responsedesc);
                    }
                }
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                CardInfoToPayWithCvvFragment.this.progressBar.setVisibility(4);
                CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment = CardInfoToPayWithCvvFragment.this;
                cardInfoToPayWithCvvFragment.onButtonSendClicked = false;
                cardInfoToPayWithCvvFragment.textViewHolder.textView.setText("عملیات ناموفق");
                MyLog.e("CardInfoToPayFragment", "onFailure: ");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCardNumber(int i) {
        CardNumbers cardNumbers = getAppPreferences().getCardNumbers();
        cardNumbers.addNumberIfNotExist(i, this.buyInput.pan);
        getAppPreferences().setCardNumbers(cardNumbers);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInfoDialog(GetBuyServiceObject getBuyServiceObject) {
        FirebaseEventSender.sendEvent(this.mContext, "payment_success" + this.buyInput.service_type, BuildConfig.FLAVOR);
        final ThreeButtonDialog threeButtonDialog = new ThreeButtonDialog(this.mContext, "تراکنش موفق\n" + getBuyServiceObject.msg_out + "\n کد رهگیری : " + getBuyServiceObject.trace_no + "\n شماره مرجع بانکی: " + getBuyServiceObject.rrn);
        threeButtonDialog.button1.setText("باشه");
        threeButtonDialog.button1.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.CardInfoToPayWithCvvFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                threeButtonDialog.dismiss();
            }
        });
        threeButtonDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ir.resaneh1.iptv.fragment.CardInfoToPayWithCvvFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.lambda$showInfoDialog$1(dialogInterface);
            }
        });
        threeButtonDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showInfoDialog$1(DialogInterface dialogInterface) {
        LaunchActivity launchActivity = (LaunchActivity) this.mContext;
        BaseFragment secondLastFragment = launchActivity.getSecondLastFragment();
        if ((secondLastFragment instanceof TransferFragment) || (secondLastFragment instanceof PayBillFragment) || (secondLastFragment instanceof BuyMobileChargeFragment) || (secondLastFragment instanceof BuyInternetFragment)) {
            launchActivity.getActionBarLayout().removeFragmentFromStack(secondLastFragment);
            launchActivity.onBackPressed();
        }
    }

    public void showErrorMessage() {
        ToastiLikeSnack.showL(this.mContext, "اطلاعات وارد شده صحیح نیست.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValidMonth(String str) {
        if (timePattern.matcher(str).matches()) {
            try {
                if (Integer.parseInt(str) < 13) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValidYear(String str) {
        if (timePattern.matcher(str).matches()) {
            try {
                if (Integer.parseInt(str) < 100) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callPayServiceGetToCardInfo() {
        String strDecrypt;
        String strDecrypt2;
        String strEncrypt;
        String strEncrypt2 = BuildConfig.FLAVOR;
        if (this.onButtonSendClicked) {
            return;
        }
        this.onButtonSendClicked = true;
        this.progressBar.setVisibility(0);
        BuyInput buyInput = this.buyInput;
        buyInput.cvv = ((EditTextItem) this.cvv2Holder.item).text;
        buyInput.exp_date = ((TwoEditTextItem) this.timeHolder.item).text2 + ((TwoEditTextItem) this.timeHolder.item).text1;
        String str = ((EditTextItem) this.passwordHolder.item).text;
        String string = getAppPreferences().getString(AppPreferences.Key.sessionKey780);
        String string2 = getAppPreferences().getString(AppPreferences.Key.pinKey780);
        try {
            strDecrypt = EncryptionHelper.decrypt(string, EncryptionHelper.keyMaster1 + EncryptionHelper.keyMaster2);
        } catch (Exception e) {
            e = e;
            strDecrypt = BuildConfig.FLAVOR;
        }
        try {
            strDecrypt2 = EncryptionHelper.decrypt(string2, EncryptionHelper.keyMaster1 + EncryptionHelper.keyMaster2);
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            strDecrypt2 = BuildConfig.FLAVOR;
            String strEncodeToString = Base64.encodeToString(str.getBytes(), 0);
            MyLog.e("CardInfoToPayFragment", "passwordBase64 " + strEncodeToString);
            strEncrypt = EncryptionHelper.encrypt(strEncodeToString, strDecrypt2);
            try {
                MyLog.e("CardInfoToPayFragment", "encryptedPin " + strEncrypt);
            } catch (Exception unused) {
            }
            this.buyInput.pin = strEncrypt;
            GetBuyServiceInput getBuyServiceInput = new GetBuyServiceInput();
            getBuyServiceInput.ip = "255.255.255.255";
            getBuyServiceInput.token = getAppPreferences().getString(AppPreferences.Key.token780);
            strEncrypt2 = EncryptionHelper.encrypt(Base64.encodeToString(ApplicationLoader.getGson().toJson(this.buyInput).getBytes(), 0), strDecrypt);
            getBuyServiceInput.enc_msg = strEncrypt2;
            ApiRequestIPTV.getInstance(this.currentAccount).getBuyServicePay(getBuyServiceInput, new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.CardInfoToPayWithCvvFragment.5
                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                public void onResponse(Call call, Response response) {
                    String str2;
                    CardInfoToPayWithCvvFragment.this.progressBar.setVisibility(4);
                    CardInfoToPayWithCvvFragment.this.onButtonSendClicked = false;
                    MyLog.e("TransferFragment", "onResponse: ");
                    GetBuyServiceOutput2 getBuyServiceOutput2 = (GetBuyServiceOutput2) response.body();
                    GetBuyServiceObject getBuyServiceObject = getBuyServiceOutput2.result;
                    if (getBuyServiceObject == null || getBuyServiceObject.equals(BuildConfig.FLAVOR) || getBuyServiceOutput2.result.result_info.responsecode == 80090) {
                        CardInfoToPayWithCvvFragment.this.callGetToken();
                        ToastiLikeSnack.showL(CardInfoToPayWithCvvFragment.this.mContext, "لطفا دوباره تلاش نمایید");
                        return;
                    }
                    GetBuyServiceObject.ResultInfo resultInfo = getBuyServiceObject.result_info;
                    if (resultInfo != null) {
                        if (resultInfo.responsecode == 0) {
                            CardInfoToPayWithCvvFragment.this.textViewHolder.textView.setText(" مبلغ " + CardInfoToPayWithCvvFragment.this.buyInput.amount + " ریال انتقال به حساب  " + getBuyServiceObject.add_data);
                            CardInfoToPayWithCvvFragment.this.buttonHolder.button.setText("پرداخت");
                            CardInfoToPayWithCvvFragment.this.buttonHolder.button.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.CardInfoToPayWithCvvFragment.5.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment = CardInfoToPayWithCvvFragment.this;
                                    if (cardInfoToPayWithCvvFragment.onButtonSendClicked) {
                                        return;
                                    }
                                    if (EditTextCardNoPresenter.isValid(((EditTextItem) cardInfoToPayWithCvvFragment.cardNoHolder.item).text) && !((EditTextItem) CardInfoToPayWithCvvFragment.this.passwordHolder.item).text.equals(BuildConfig.FLAVOR) && !((EditTextItem) CardInfoToPayWithCvvFragment.this.cvv2Holder.item).text.equals(BuildConfig.FLAVOR)) {
                                        CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment2 = CardInfoToPayWithCvvFragment.this;
                                        if (cardInfoToPayWithCvvFragment2.isValidMonth(((TwoEditTextItem) cardInfoToPayWithCvvFragment2.timeHolder.item).text1)) {
                                            CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment3 = CardInfoToPayWithCvvFragment.this;
                                            if (cardInfoToPayWithCvvFragment3.isValidYear(((TwoEditTextItem) cardInfoToPayWithCvvFragment3.timeHolder.item).text2)) {
                                                CardInfoToPayWithCvvFragment.this.buyInput.service_type = 7;
                                                CardInfoToPayWithCvvFragment.this.callPayService();
                                                return;
                                            }
                                        }
                                    }
                                    CardInfoToPayWithCvvFragment.this.showErrorMessage();
                                }
                            });
                            return;
                        }
                        String str3 = getBuyServiceObject.add_data;
                        if (str3 != null && !str3.equals(BuildConfig.FLAVOR)) {
                            str2 = getBuyServiceObject.add_data;
                        } else {
                            String str4 = getBuyServiceObject.result_info.responsedesc;
                            str2 = (str4 == null || str4.equals(BuildConfig.FLAVOR)) ? "عملیات ناموفق" : getBuyServiceObject.result_info.responsedesc;
                        }
                        CardInfoToPayWithCvvFragment.this.textViewHolder.textView.setText(str2);
                        ToastiLikeSnack.showL(CardInfoToPayWithCvvFragment.this.mContext, str2);
                    }
                }

                @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
                public void onFailure(Call call, Throwable th) {
                    MyLog.e("TransferFragment", "onFailure: ");
                    CardInfoToPayWithCvvFragment.this.progressBar.setVisibility(4);
                    CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment = CardInfoToPayWithCvvFragment.this;
                    cardInfoToPayWithCvvFragment.onButtonSendClicked = false;
                    cardInfoToPayWithCvvFragment.textViewHolder.textView.setText("عملیات ناموفق");
                    ToastiLikeSnack.showL(CardInfoToPayWithCvvFragment.this.mContext, "لطفا مجددا تلاش نمایید");
                }
            });
        }
        try {
            String strEncodeToString2 = Base64.encodeToString(str.getBytes(), 0);
            MyLog.e("CardInfoToPayFragment", "passwordBase64 " + strEncodeToString2);
            strEncrypt = EncryptionHelper.encrypt(strEncodeToString2, strDecrypt2);
            MyLog.e("CardInfoToPayFragment", "encryptedPin " + strEncrypt);
        } catch (Exception unused2) {
            strEncrypt = BuildConfig.FLAVOR;
        }
        this.buyInput.pin = strEncrypt;
        GetBuyServiceInput getBuyServiceInput2 = new GetBuyServiceInput();
        getBuyServiceInput2.ip = "255.255.255.255";
        getBuyServiceInput2.token = getAppPreferences().getString(AppPreferences.Key.token780);
        try {
            strEncrypt2 = EncryptionHelper.encrypt(Base64.encodeToString(ApplicationLoader.getGson().toJson(this.buyInput).getBytes(), 0), strDecrypt);
        } catch (Exception unused3) {
        }
        getBuyServiceInput2.enc_msg = strEncrypt2;
        ApiRequestIPTV.getInstance(this.currentAccount).getBuyServicePay(getBuyServiceInput2, new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.CardInfoToPayWithCvvFragment.5
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                String str2;
                CardInfoToPayWithCvvFragment.this.progressBar.setVisibility(4);
                CardInfoToPayWithCvvFragment.this.onButtonSendClicked = false;
                MyLog.e("TransferFragment", "onResponse: ");
                GetBuyServiceOutput2 getBuyServiceOutput2 = (GetBuyServiceOutput2) response.body();
                GetBuyServiceObject getBuyServiceObject = getBuyServiceOutput2.result;
                if (getBuyServiceObject == null || getBuyServiceObject.equals(BuildConfig.FLAVOR) || getBuyServiceOutput2.result.result_info.responsecode == 80090) {
                    CardInfoToPayWithCvvFragment.this.callGetToken();
                    ToastiLikeSnack.showL(CardInfoToPayWithCvvFragment.this.mContext, "لطفا دوباره تلاش نمایید");
                    return;
                }
                GetBuyServiceObject.ResultInfo resultInfo = getBuyServiceObject.result_info;
                if (resultInfo != null) {
                    if (resultInfo.responsecode == 0) {
                        CardInfoToPayWithCvvFragment.this.textViewHolder.textView.setText(" مبلغ " + CardInfoToPayWithCvvFragment.this.buyInput.amount + " ریال انتقال به حساب  " + getBuyServiceObject.add_data);
                        CardInfoToPayWithCvvFragment.this.buttonHolder.button.setText("پرداخت");
                        CardInfoToPayWithCvvFragment.this.buttonHolder.button.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.CardInfoToPayWithCvvFragment.5.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment = CardInfoToPayWithCvvFragment.this;
                                if (cardInfoToPayWithCvvFragment.onButtonSendClicked) {
                                    return;
                                }
                                if (EditTextCardNoPresenter.isValid(((EditTextItem) cardInfoToPayWithCvvFragment.cardNoHolder.item).text) && !((EditTextItem) CardInfoToPayWithCvvFragment.this.passwordHolder.item).text.equals(BuildConfig.FLAVOR) && !((EditTextItem) CardInfoToPayWithCvvFragment.this.cvv2Holder.item).text.equals(BuildConfig.FLAVOR)) {
                                    CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment2 = CardInfoToPayWithCvvFragment.this;
                                    if (cardInfoToPayWithCvvFragment2.isValidMonth(((TwoEditTextItem) cardInfoToPayWithCvvFragment2.timeHolder.item).text1)) {
                                        CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment3 = CardInfoToPayWithCvvFragment.this;
                                        if (cardInfoToPayWithCvvFragment3.isValidYear(((TwoEditTextItem) cardInfoToPayWithCvvFragment3.timeHolder.item).text2)) {
                                            CardInfoToPayWithCvvFragment.this.buyInput.service_type = 7;
                                            CardInfoToPayWithCvvFragment.this.callPayService();
                                            return;
                                        }
                                    }
                                }
                                CardInfoToPayWithCvvFragment.this.showErrorMessage();
                            }
                        });
                        return;
                    }
                    String str3 = getBuyServiceObject.add_data;
                    if (str3 != null && !str3.equals(BuildConfig.FLAVOR)) {
                        str2 = getBuyServiceObject.add_data;
                    } else {
                        String str4 = getBuyServiceObject.result_info.responsedesc;
                        str2 = (str4 == null || str4.equals(BuildConfig.FLAVOR)) ? "عملیات ناموفق" : getBuyServiceObject.result_info.responsedesc;
                    }
                    CardInfoToPayWithCvvFragment.this.textViewHolder.textView.setText(str2);
                    ToastiLikeSnack.showL(CardInfoToPayWithCvvFragment.this.mContext, str2);
                }
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                MyLog.e("TransferFragment", "onFailure: ");
                CardInfoToPayWithCvvFragment.this.progressBar.setVisibility(4);
                CardInfoToPayWithCvvFragment cardInfoToPayWithCvvFragment = CardInfoToPayWithCvvFragment.this;
                cardInfoToPayWithCvvFragment.onButtonSendClicked = false;
                cardInfoToPayWithCvvFragment.textViewHolder.textView.setText("عملیات ناموفق");
                ToastiLikeSnack.showL(CardInfoToPayWithCvvFragment.this.mContext, "لطفا مجددا تلاش نمایید");
            }
        });
    }

    public void callGetToken() {
        this.progressBar.setVisibility(0);
        ApiRequestIPTV.getInstance(this.currentAccount).getTokenPay(new GetTokenPayInput(UpdateUtils.getAppVersion(this.mContext), getAppPreferences().getUserPhoneNumber(), DeviceInfo.getDeviceID(this.mContext), BuildConfig.FLAVOR), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.CardInfoToPayWithCvvFragment.6
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                MyLog.e("TransferFragment", "onResponse: ");
                CardInfoToPayWithCvvFragment.this.progressBar.setVisibility(4);
                GetTokenPayObject getTokenPayObject = ((GetTokenPayOutput2) response.body()).result;
                CardInfoToPayWithCvvFragment.this.getAppPreferences().setString(AppPreferences.Key.token780, getTokenPayObject.token);
                CardInfoToPayWithCvvFragment.this.getAppPreferences().setString(AppPreferences.Key.sessionKey780, getTokenPayObject.session_key);
                CardInfoToPayWithCvvFragment.this.getAppPreferences().setString(AppPreferences.Key.pinKey780, getTokenPayObject.pin_key);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                MyLog.e("TransferFragment", "onFailure: ");
                CardInfoToPayWithCvvFragment.this.progressBar.setVisibility(4);
            }
        });
    }
}
