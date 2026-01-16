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
import ir.resaneh1.iptv.presenters.EditTextPresenter;
import ir.resaneh1.iptv.presenters.TextLikeEditTextPresenter;
import ir.resaneh1.iptv.presenters.TextViewPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.rbmain.messenger.LocaleController;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class BuyInternetFragment extends PresenterFragment {
    private static final Pattern phonePattern = Pattern.compile("\\d{11}$");
    TextLikeEditTextPresenter.MyViewHolder costHolder;
    ItemPickerDialog dialog;
    EditTextPresenter.MyViewHolder phoneHolder;
    GetListPayObject.Item selectedCost;
    GetListPayObject.Item selectedType;
    private TextViewPresenter.MyViewHolder textViewHolder;
    TextLikeEditTextPresenter.MyViewHolder typeHolder;
    public boolean onButtonSendClicked = false;
    String error = LocaleController.getString(R.string.infoError);
    DialogInterface.OnDismissListener onDismissListener = new DialogInterface.OnDismissListener() { // from class: ir.resaneh1.iptv.fragment.BuyInternetFragment.4
        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            BuyInternetFragment.this.onButtonSendClicked = false;
        }
    };
    View.OnClickListener onTypeClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.BuyInternetFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BuyInternetFragment buyInternetFragment = BuyInternetFragment.this;
            if (buyInternetFragment.onButtonSendClicked) {
                return;
            }
            buyInternetFragment.callGetAmountList();
        }
    };
    View.OnClickListener onCostClickListener = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.BuyInternetFragment.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BuyInternetFragment buyInternetFragment = BuyInternetFragment.this;
            if (buyInternetFragment.onButtonSendClicked) {
                return;
            }
            GetListPayObject.Item item = buyInternetFragment.selectedType;
            if (item == null) {
                ToastiLikeSnack.showL(buyInternetFragment.mContext, "لطفا نوع دوره را انتخاب نمایید");
            } else {
                buyInternetFragment.onButtonSendClicked = true;
                buyInternetFragment.showDialog(item.value, "انتخاب بسته", new OnItemSelectedListener() { // from class: ir.resaneh1.iptv.fragment.BuyInternetFragment.7.1
                    @Override // ir.resaneh1.iptv.OnItemSelectedListener
                    public void onItemSelect(PresenterItem presenterItem) {
                        BuyInternetFragment.this.costHolder.textView.setText(presenterItem.getTitle());
                        BuyInternetFragment buyInternetFragment2 = BuyInternetFragment.this;
                        buyInternetFragment2.selectedCost = (GetListPayObject.Item) presenterItem;
                        buyInternetFragment2.dialog.dismiss();
                    }
                });
            }
        }
    };

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
        getFragmentView().setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        this.progressBar.setVisibility(4);
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, LocaleController.getString(R.string.buy_internet_package));
        makeLayout();
        getToken();
    }

    private void makeLayout() {
        TextViewPresenter textViewPresenter = new TextViewPresenter(this.mContext);
        this.textViewHolder = textViewPresenter.createViewHolderAndBind(new TextViewItem(BuildConfig.FLAVOR + LocaleController.getString(R.string.enter_internet_package_details)));
        TextLikeEditTextPresenter textLikeEditTextPresenter = new TextLikeEditTextPresenter(this.mContext);
        EditTextPresenter editTextPresenter = new EditTextPresenter(this.mContext);
        EditTextItem editTextItem = new EditTextItem(BuildConfig.FLAVOR, "(۰۹xxxxxxxxx) شماره موبایل");
        EditTextItem editTextItem2 = new EditTextItem(BuildConfig.FLAVOR, LocaleController.getString(R.string.select_duration));
        editTextItem2.isEditable = false;
        editTextItem2.onClickListener = this.onTypeClickListener;
        EditTextItem editTextItem3 = new EditTextItem(BuildConfig.FLAVOR, LocaleController.getString(R.string.select_package));
        editTextItem3.isEditable = false;
        editTextItem3.onClickListener = this.onCostClickListener;
        EditTextPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind = editTextPresenter.createViewHolderAndBind(editTextItem);
        this.phoneHolder = myViewHolderCreateViewHolderAndBind;
        myViewHolderCreateViewHolderAndBind.edittext.setInputType(3);
        this.phoneHolder.edittext.addTextChangedListener(new TextWatcher() { // from class: ir.resaneh1.iptv.fragment.BuyInternetFragment.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                BuyInternetFragment.this.typeHolder.textView.setText(BuildConfig.FLAVOR);
                BuyInternetFragment.this.costHolder.textView.setText(BuildConfig.FLAVOR);
                BuyInternetFragment buyInternetFragment = BuyInternetFragment.this;
                buyInternetFragment.selectedType = null;
                buyInternetFragment.selectedCost = null;
                buyInternetFragment.onButtonSendClicked = false;
            }
        });
        this.typeHolder = textLikeEditTextPresenter.createViewHolderAndBind(editTextItem2);
        this.costHolder = textLikeEditTextPresenter.createViewHolderAndBind(editTextItem3);
        this.linearLayout.addView(textViewPresenter.createViewHolderAndBind(new TextViewItem("  ")).itemView);
        this.linearLayout.addView(this.phoneHolder.itemView);
        this.linearLayout.addView(this.typeHolder.itemView);
        this.linearLayout.addView(this.costHolder.itemView);
        this.linearLayout.addView(new ButtonPresenter(this.mContext).createViewHolderAndBind(new ButtonItem(LocaleController.getString(R.string.buy), new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.BuyInternetFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BuyInternetFragment buyInternetFragment = BuyInternetFragment.this;
                if (buyInternetFragment.isPhoneValid(((EditTextItem) buyInternetFragment.phoneHolder.item).text)) {
                    BuyInternetFragment buyInternetFragment2 = BuyInternetFragment.this;
                    if (buyInternetFragment2.selectedType != null && buyInternetFragment2.selectedCost != null) {
                        BuyInput buyInput = new BuyInput();
                        buyInput.service_type = 2;
                        buyInput.product_type = BuyInternetFragment.this.selectedCost.getValue();
                        buyInput.amount = BuyInternetFragment.this.selectedCost.getDec();
                        buyInput.target_mobile = ((EditTextItem) BuyInternetFragment.this.phoneHolder.item).text;
                        BuyInternetFragment.this.presentFragment(new CardInfoToPayWithCvvFragment(buyInput, ((EditTextItem) BuyInternetFragment.this.phoneHolder.item).text + " / " + BuyInternetFragment.this.selectedType.name + " / " + BuyInternetFragment.this.selectedCost.name));
                        return;
                    }
                }
                BuyInternetFragment buyInternetFragment3 = BuyInternetFragment.this;
                if (!buyInternetFragment3.isPhoneValid(((EditTextItem) buyInternetFragment3.phoneHolder.item).text)) {
                    BuyInternetFragment.this.showErrorMessage();
                    return;
                }
                BuyInternetFragment buyInternetFragment4 = BuyInternetFragment.this;
                if (buyInternetFragment4.selectedType == null) {
                    buyInternetFragment4.error = LocaleController.getString(R.string.select_package_duration);
                    BuyInternetFragment.this.showErrorMessage();
                } else if (buyInternetFragment4.selectedCost == null) {
                    buyInternetFragment4.error = LocaleController.getString(R.string.please_select_package);
                    BuyInternetFragment.this.showErrorMessage();
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
        new ItemListRequest().load(this.mContext, new ListInput("3g", str), new ItemListRequest.Listener() { // from class: ir.resaneh1.iptv.fragment.BuyInternetFragment.3
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
                        BuyInternetFragment.this.showDialog(((GetListPayObject.Item) next).value, LocaleController.getString(R.string.select_duration), new OnItemSelectedListener() { // from class: ir.resaneh1.iptv.fragment.BuyInternetFragment.3.1
                            @Override // ir.resaneh1.iptv.OnItemSelectedListener
                            public void onItemSelect(PresenterItem presenterItem) {
                                BuyInternetFragment.this.typeHolder.textView.setText(presenterItem.getTitle());
                                BuyInternetFragment buyInternetFragment = BuyInternetFragment.this;
                                buyInternetFragment.selectedType = (GetListPayObject.Item) presenterItem;
                                buyInternetFragment.costHolder.textView.setText(BuildConfig.FLAVOR);
                                BuyInternetFragment buyInternetFragment2 = BuyInternetFragment.this;
                                buyInternetFragment2.selectedCost = null;
                                buyInternetFragment2.onButtonSendClicked = false;
                                buyInternetFragment2.dialog.dismiss();
                            }
                        });
                        z = true;
                        break;
                    }
                }
                if (z) {
                    return;
                }
                ToastiLikeSnack.showL(BuyInternetFragment.this.mContext, LocaleController.getString(R.string.incorrect_phone_number));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPhoneValid(String str) {
        if (str.equals(BuildConfig.FLAVOR)) {
            this.error = LocaleController.getString(R.string.please_enter_phone_number);
        } else if (!phonePattern.matcher(str).matches() || !str.startsWith("09")) {
            this.error = LocaleController.getString(R.string.incorrect_phone_number);
        } else {
            this.error = LocaleController.getString(R.string.infoError);
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
        ApiRequestIPTV.getInstance(this.currentAccount).getTokenPay(new GetTokenPayInput(UpdateUtils.getAppVersion(this.mContext), getAppPreferences().getUserPhoneNumber(), DeviceInfo.getDeviceID(this.mContext), BuildConfig.FLAVOR), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.BuyInternetFragment.5
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                MyLog.e("BuyMobile", "onResponse: ");
                BuyInternetFragment.this.progressBar.setVisibility(4);
                GetTokenPayObject getTokenPayObject = ((GetTokenPayOutput2) response.body()).result;
                BuyInternetFragment.this.getAppPreferences().setString(AppPreferences.Key.token780, getTokenPayObject.token);
                BuyInternetFragment.this.getAppPreferences().setString(AppPreferences.Key.sessionKey780, getTokenPayObject.session_key);
                BuyInternetFragment.this.getAppPreferences().setString(AppPreferences.Key.pinKey780, getTokenPayObject.pin_key);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                MyLog.e("BuyMobile", "onFailure: ");
                BuyInternetFragment.this.progressBar.setVisibility(4);
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
}
