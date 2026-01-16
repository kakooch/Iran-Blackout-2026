package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.ItemPickerDialog;
import ir.resaneh1.iptv.OnItemSelectedListener;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.appUpdate.UpdateUtils;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.helper.DeviceInfo;
import ir.resaneh1.iptv.helper.ItemListRequest;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.ButtonItem;
import ir.resaneh1.iptv.model.BuyInput;
import ir.resaneh1.iptv.model.EditTextItem;
import ir.resaneh1.iptv.model.GetListOutput;
import ir.resaneh1.iptv.model.GetListPayObject;
import ir.resaneh1.iptv.model.GetTokenPayInput;
import ir.resaneh1.iptv.model.GetTokenPayObject;
import ir.resaneh1.iptv.model.GetTokenPayOutput2;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.TextViewItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenters.ButtonPresenter;
import ir.resaneh1.iptv.presenters.EditTextCostPresenter;
import ir.resaneh1.iptv.presenters.EditTextPresenter;
import ir.resaneh1.iptv.presenters.TextLikeEditTextPresenter;
import ir.resaneh1.iptv.presenters.TextViewPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class BuyMobileChargeFragment extends PresenterFragment {
    private static final Pattern phonePattern = Pattern.compile("\\d{11}$");
    TextLikeEditTextPresenter.MyViewHolder costHolder;
    EditTextCostPresenter.MyViewHolder customCostHolder;
    ItemPickerDialog dialog;
    EditTextPresenter.MyViewHolder phoneHolder;
    GetListPayObject.Item selectedCost;
    GetListPayObject.Item selectedType;
    private TextViewPresenter.MyViewHolder textViewHolder;
    TextLikeEditTextPresenter.MyViewHolder typeHolder;
    public boolean onButtonSendClicked = false;
    String error = "اطلاعات وارد شده صحیح نیست";
    DialogInterface.OnDismissListener onDismissListener = new DialogInterface.OnDismissListener() { // from class: ir.resaneh1.iptv.fragment.BuyMobileChargeFragment.4
        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            BuyMobileChargeFragment.this.onButtonSendClicked = false;
        }
    };
    View.OnClickListener onTypeClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.BuyMobileChargeFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BuyMobileChargeFragment buyMobileChargeFragment = BuyMobileChargeFragment.this;
            if (buyMobileChargeFragment.onButtonSendClicked) {
                return;
            }
            buyMobileChargeFragment.callGetAmountList();
        }
    };
    View.OnClickListener onCostClickListener = new AnonymousClass7();

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_just_linearlayout;
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void findView() {
        super.findView();
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.progressBar.setVisibility(4);
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, "خرید شارژ");
        makeLayout();
        getToken();
    }

    private void makeLayout() {
        TextViewPresenter textViewPresenter = new TextViewPresenter(this.mContext);
        this.textViewHolder = textViewPresenter.createViewHolderAndBind(new TextViewItem("برای خرید شارژ لطفا شماره موبایل، نوع شارژ و مبلغ را وارد نمایید"));
        EditTextPresenter editTextPresenter = new EditTextPresenter(this.mContext);
        TextLikeEditTextPresenter textLikeEditTextPresenter = new TextLikeEditTextPresenter(this.mContext);
        EditTextItem editTextItem = new EditTextItem(BuildConfig.FLAVOR, "(۰۹xxxxxxxxx) شماره موبایل");
        EditTextItem editTextItem2 = new EditTextItem(BuildConfig.FLAVOR, "نوع شارژ");
        editTextItem2.isEditable = false;
        editTextItem2.onClickListener = this.onTypeClickListener;
        EditTextItem editTextItem3 = new EditTextItem(BuildConfig.FLAVOR, "مبلغ(ریال)");
        editTextItem3.isEditable = false;
        editTextItem3.onClickListener = this.onCostClickListener;
        EditTextCostPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind = new EditTextCostPresenter(this.mContext).createViewHolderAndBind(new EditTextItem(BuildConfig.FLAVOR, "مبلغ دلخواه(ریال)"));
        this.customCostHolder = myViewHolderCreateViewHolderAndBind;
        myViewHolderCreateViewHolderAndBind.itemView.setVisibility(4);
        EditTextPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind2 = editTextPresenter.createViewHolderAndBind(editTextItem);
        this.phoneHolder = myViewHolderCreateViewHolderAndBind2;
        myViewHolderCreateViewHolderAndBind2.edittext.setInputType(3);
        this.phoneHolder.edittext.addTextChangedListener(new TextWatcher() { // from class: ir.resaneh1.iptv.fragment.BuyMobileChargeFragment.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                BuyMobileChargeFragment.this.typeHolder.textView.setText(BuildConfig.FLAVOR);
                BuyMobileChargeFragment.this.costHolder.textView.setText(BuildConfig.FLAVOR);
                BuyMobileChargeFragment buyMobileChargeFragment = BuyMobileChargeFragment.this;
                buyMobileChargeFragment.selectedType = null;
                buyMobileChargeFragment.selectedCost = null;
                buyMobileChargeFragment.customCostHolder.itemView.setVisibility(4);
                BuyMobileChargeFragment.this.onButtonSendClicked = false;
            }
        });
        this.typeHolder = textLikeEditTextPresenter.createViewHolderAndBind(editTextItem2);
        this.costHolder = textLikeEditTextPresenter.createViewHolderAndBind(editTextItem3);
        this.linearLayout.addView(textViewPresenter.createViewHolderAndBind(new TextViewItem("  ")).itemView);
        this.linearLayout.addView(this.phoneHolder.itemView);
        this.linearLayout.addView(this.typeHolder.itemView);
        this.linearLayout.addView(this.costHolder.itemView);
        this.linearLayout.addView(this.customCostHolder.itemView);
        this.linearLayout.addView(new ButtonPresenter(this.mContext).createViewHolderAndBind(new ButtonItem("خرید", new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.BuyMobileChargeFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BuyMobileChargeFragment buyMobileChargeFragment = BuyMobileChargeFragment.this;
                if (buyMobileChargeFragment.isPhoneValid(((EditTextItem) buyMobileChargeFragment.phoneHolder.item).text)) {
                    BuyMobileChargeFragment buyMobileChargeFragment2 = BuyMobileChargeFragment.this;
                    if (buyMobileChargeFragment2.selectedType != null && buyMobileChargeFragment2.selectedCost != null) {
                        BuyInput buyInput = new BuyInput();
                        buyInput.service_type = 1;
                        buyInput.product_type = BuyMobileChargeFragment.this.selectedCost.getValue();
                        buyInput.amount = BuyMobileChargeFragment.this.selectedCost.getDec();
                        buyInput.target_mobile = ((EditTextItem) BuyMobileChargeFragment.this.phoneHolder.item).text;
                        String str = ((EditTextItem) BuyMobileChargeFragment.this.phoneHolder.item).text + " / " + BuyMobileChargeFragment.this.selectedType.name + " / " + BuyMobileChargeFragment.this.selectedCost.name;
                        MyLog.e("BuyMobileCharge", "onClick: " + buyInput.amount);
                        BuyMobileChargeFragment.this.presentFragment(new CardInfoToPayWithCvvFragment(buyInput, str));
                        return;
                    }
                }
                BuyMobileChargeFragment buyMobileChargeFragment3 = BuyMobileChargeFragment.this;
                if (!buyMobileChargeFragment3.isPhoneValid(((EditTextItem) buyMobileChargeFragment3.phoneHolder.item).text)) {
                    BuyMobileChargeFragment.this.showErrorMessage();
                    return;
                }
                BuyMobileChargeFragment buyMobileChargeFragment4 = BuyMobileChargeFragment.this;
                if (buyMobileChargeFragment4.selectedType == null) {
                    buyMobileChargeFragment4.error = "لطفا نوع شارژ را انتخاب نمایید";
                    buyMobileChargeFragment4.showErrorMessage();
                } else if (buyMobileChargeFragment4.selectedCost == null) {
                    buyMobileChargeFragment4.error = "لطفا مبلغ را انتخاب نمایید";
                    buyMobileChargeFragment4.showErrorMessage();
                }
            }
        })).itemView);
        this.linearLayout.addView(this.textViewHolder.itemView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callGetAmountList() {
        final String str = ((EditTextItem) this.phoneHolder.item).text;
        if (!isPhoneValid(str)) {
            ToastiLikeSnack.showL(this.mContext, this.error);
            return;
        }
        this.onButtonSendClicked = true;
        new ItemListRequest().load(this.mContext, new ListInput("amountlist", str), new ItemListRequest.Listener() { // from class: ir.resaneh1.iptv.fragment.BuyMobileChargeFragment.3
            @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
            public void onFailure(Throwable th) {
            }

            @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
            public void onResponse(ArrayList<? extends PresenterItem> arrayList, GetListOutput getListOutput) {
                boolean z;
                Iterator<? extends PresenterItem> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    PresenterItem next = it.next();
                    if (str.startsWith(next.getTitle())) {
                        BuyMobileChargeFragment.this.showDialog(((GetListPayObject.Item) next).value, "انتخاب شارژ", new OnItemSelectedListener() { // from class: ir.resaneh1.iptv.fragment.BuyMobileChargeFragment.3.1
                            @Override // ir.resaneh1.iptv.OnItemSelectedListener
                            public void onItemSelect(PresenterItem presenterItem) {
                                BuyMobileChargeFragment.this.typeHolder.textView.setText(presenterItem.getTitle());
                                BuyMobileChargeFragment buyMobileChargeFragment = BuyMobileChargeFragment.this;
                                buyMobileChargeFragment.selectedType = (GetListPayObject.Item) presenterItem;
                                buyMobileChargeFragment.costHolder.textView.setText(BuildConfig.FLAVOR);
                                BuyMobileChargeFragment buyMobileChargeFragment2 = BuyMobileChargeFragment.this;
                                buyMobileChargeFragment2.selectedCost = null;
                                buyMobileChargeFragment2.customCostHolder.itemView.setVisibility(4);
                                BuyMobileChargeFragment buyMobileChargeFragment3 = BuyMobileChargeFragment.this;
                                buyMobileChargeFragment3.onButtonSendClicked = false;
                                buyMobileChargeFragment3.dialog.dismiss();
                            }
                        });
                        z = true;
                        break;
                    }
                }
                if (z) {
                    return;
                }
                ToastiLikeSnack.showL(BuyMobileChargeFragment.this.mContext, "شماره موبایل وارد شده صحیح نیست.");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPhoneValid(String str) {
        if (str.equals(BuildConfig.FLAVOR)) {
            this.error = "لطفا شماره موبایل را وارد نمایید.";
        } else if (!phonePattern.matcher(str).matches() || !str.startsWith("09")) {
            this.error = "شماره موبایل وارد شده صحیح نیست.";
        } else {
            this.error = "اطلاعات وارد شده صحیح نیست.";
        }
        return phonePattern.matcher(str).matches() && str.startsWith("09");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String str, String str2, OnItemSelectedListener onItemSelectedListener) {
        if (str == null || str.equals(BuildConfig.FLAVOR)) {
            return;
        }
        ItemPickerDialog itemPickerDialog = new ItemPickerDialog((Activity) this.mContext, new ListInput(str, ((EditTextItem) this.phoneHolder.item).text), str2, false, onItemSelectedListener, false);
        this.dialog = itemPickerDialog;
        itemPickerDialog.show();
        this.dialog.setOnDismissListener(this.onDismissListener);
    }

    public void callGetToken() {
        this.progressBar.setVisibility(0);
        ApiRequestIPTV.getInstance(this.currentAccount).getTokenPay(new GetTokenPayInput(UpdateUtils.getAppVersion(this.mContext), getAppPreferences().getUserPhoneNumber(), DeviceInfo.getDeviceID(this.mContext), BuildConfig.FLAVOR), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.BuyMobileChargeFragment.5
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                MyLog.e("BuyMobile", "onResponse: ");
                BuyMobileChargeFragment.this.progressBar.setVisibility(4);
                GetTokenPayObject getTokenPayObject = ((GetTokenPayOutput2) response.body()).result;
                BuyMobileChargeFragment.this.getAppPreferences().setString(AppPreferences.Key.token780, getTokenPayObject.token);
                BuyMobileChargeFragment.this.getAppPreferences().setString(AppPreferences.Key.sessionKey780, getTokenPayObject.session_key);
                BuyMobileChargeFragment.this.getAppPreferences().setString(AppPreferences.Key.pinKey780, getTokenPayObject.pin_key);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                MyLog.e("BuyMobile", "onFailure: ");
                BuyMobileChargeFragment.this.progressBar.setVisibility(4);
            }
        });
    }

    public void showErrorMessage() {
        ToastiLikeSnack.showL(this.mContext, this.error);
    }

    private void getToken() {
        String string = getAppPreferences().getString(AppPreferences.Key.token780);
        if (string == null || string.equals(BuildConfig.FLAVOR)) {
            callGetToken();
        }
    }

    /* renamed from: ir.resaneh1.iptv.fragment.BuyMobileChargeFragment$7, reason: invalid class name */
    class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BuyMobileChargeFragment buyMobileChargeFragment = BuyMobileChargeFragment.this;
            if (buyMobileChargeFragment.onButtonSendClicked) {
                return;
            }
            GetListPayObject.Item item = buyMobileChargeFragment.selectedType;
            if (item == null) {
                ToastiLikeSnack.showL(buyMobileChargeFragment.mContext, "لطفا نوع شارژ را انتخاب نمایید");
            } else {
                buyMobileChargeFragment.onButtonSendClicked = true;
                buyMobileChargeFragment.showDialog(item.value, "انتخاب مبلغ", new OnItemSelectedListener() { // from class: ir.resaneh1.iptv.fragment.BuyMobileChargeFragment.7.1
                    @Override // ir.resaneh1.iptv.OnItemSelectedListener
                    public void onItemSelect(PresenterItem presenterItem) {
                        BuyMobileChargeFragment.this.customCostHolder.itemView.setVisibility(4);
                        BuyMobileChargeFragment.this.costHolder.textView.setText(presenterItem.getTitle());
                        GetListPayObject.Item item2 = (GetListPayObject.Item) presenterItem;
                        BuyMobileChargeFragment.this.selectedCost = item2;
                        if (item2.desc.equals(BuildConfig.FLAVOR)) {
                            BuyMobileChargeFragment.this.customCostHolder.itemView.setVisibility(0);
                            BuyMobileChargeFragment.this.customCostHolder.edittext.addTextChangedListener(new TextWatcher() { // from class: ir.resaneh1.iptv.fragment.BuyMobileChargeFragment.7.1.1
                                @Override // android.text.TextWatcher
                                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                }

                                @Override // android.text.TextWatcher
                                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                }

                                @Override // android.text.TextWatcher
                                public void afterTextChanged(Editable editable) {
                                    BuyMobileChargeFragment buyMobileChargeFragment2 = BuyMobileChargeFragment.this;
                                    buyMobileChargeFragment2.selectedCost.desc = buyMobileChargeFragment2.customCostHolder.edittext.getText().toString().replace(EditTextCostPresenter.space, BuildConfig.FLAVOR);
                                    BuyMobileChargeFragment.this.selectedCost.name = " " + BuyMobileChargeFragment.this.customCostHolder.edittext.getText().toString() + " ریال";
                                }
                            });
                        }
                        BuyMobileChargeFragment.this.dialog.dismiss();
                    }
                });
            }
        }
    }
}
