package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.dialog.PresenterItemPickerDialog;
import ir.resaneh1.iptv.helper.InputFilterHelper;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.model.AddDeliveryInfoInput;
import ir.resaneh1.iptv.model.AddDeliveryInfoOutput;
import ir.resaneh1.iptv.model.BasketObject;
import ir.resaneh1.iptv.model.ButtonItem;
import ir.resaneh1.iptv.model.DeliveryCityObject;
import ir.resaneh1.iptv.model.DeliveryInfoObject;
import ir.resaneh1.iptv.model.DeliveryProvinceObject;
import ir.resaneh1.iptv.model.EditTextItem;
import ir.resaneh1.iptv.model.ListInput;
import ir.resaneh1.iptv.model.LocationObject;
import ir.resaneh1.iptv.model.MapItem;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.TwoEditTextItem;
import ir.resaneh1.iptv.presenter.abstracts.PresenterItem;
import ir.resaneh1.iptv.presenters.ButtonPresenter;
import ir.resaneh1.iptv.presenters.EditTextAutoCompletePresenter;
import ir.resaneh1.iptv.presenters.EditTextPresenter;
import ir.resaneh1.iptv.presenters.MapPresenter;
import ir.resaneh1.iptv.presenters.TwoTextLikeEditTextPresenter;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.tgnet.TLRPC$GeoPoint;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$TL_messageMediaGeo;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.LocationActivity;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class AddOrEditDeliveryInfoFragment extends PresenterFragment {
    EditTextPresenter.MyViewHolder addressHolder;
    BasketObject basketObject;
    ButtonPresenter.MyViewHolder buttonHolder;
    TwoTextLikeEditTextPresenter.MyViewHolder cityHolder;
    EditTextPresenter.MyViewHolder codeHolder;
    DeliveryInfoObject deliveryInfoObject;
    MapPresenter.MyViewHolder mapHolder;
    private MapItem mapItem;
    private MapPresenter mapPresenter;
    EditTextAutoCompletePresenter.MyViewHolder mobileHolder;
    EditTextAutoCompletePresenter.MyViewHolder nameHolder;
    EditTextPresenter.MyViewHolder phoneHolder;
    public String selectedCityId;
    public String selectedProvinceId;
    public String errorMessage = LocaleController.getString(R.string.incorrect_input);
    View.OnClickListener onProvinceClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddOrEditDeliveryInfoFragment.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new PresenterItemPickerDialog(LocaleController.getString("PaymentShippingStatePlaceholder", R.string.PaymentShippingStatePlaceholder), new ListInput(ListInput.ItemType.province), new PresenterItemPickerDialog.Listener() { // from class: ir.resaneh1.iptv.fragment.AddOrEditDeliveryInfoFragment.2.1
                @Override // ir.resaneh1.iptv.dialog.PresenterItemPickerDialog.Listener
                public void onItemsSelected(PresenterItem presenterItem) {
                    AddOrEditDeliveryInfoFragment addOrEditDeliveryInfoFragment = AddOrEditDeliveryInfoFragment.this;
                    addOrEditDeliveryInfoFragment.selectedCityId = BuildConfig.FLAVOR;
                    addOrEditDeliveryInfoFragment.cityHolder.textView2.setText(BuildConfig.FLAVOR);
                    AddOrEditDeliveryInfoFragment.this.selectedProvinceId = presenterItem.getId();
                    AddOrEditDeliveryInfoFragment.this.cityHolder.textView1.setText(presenterItem.getTitle());
                }
            }, true).show();
        }
    };
    View.OnClickListener onCityClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddOrEditDeliveryInfoFragment.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = AddOrEditDeliveryInfoFragment.this.selectedProvinceId;
            if (str == null || str.isEmpty()) {
                ToastiLikeSnack.showL(AddOrEditDeliveryInfoFragment.this.mContext, LocaleController.getString("provinceError2", R.string.provinceError2));
                return;
            }
            ListInput listInput = new ListInput(ListInput.ItemType.city);
            listInput.provinceId = AddOrEditDeliveryInfoFragment.this.selectedProvinceId;
            new PresenterItemPickerDialog(LocaleController.getString("PaymentShippingCityPlaceholder", R.string.PaymentShippingCityPlaceholder), listInput, new PresenterItemPickerDialog.Listener() { // from class: ir.resaneh1.iptv.fragment.AddOrEditDeliveryInfoFragment.3.1
                @Override // ir.resaneh1.iptv.dialog.PresenterItemPickerDialog.Listener
                public void onItemsSelected(PresenterItem presenterItem) {
                    AddOrEditDeliveryInfoFragment.this.selectedCityId = presenterItem.getId();
                    AddOrEditDeliveryInfoFragment.this.cityHolder.textView2.setText(presenterItem.getTitle());
                }
            }, true).show();
        }
    };
    View.OnClickListener onAddAddressClick = new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddOrEditDeliveryInfoFragment.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AddOrEditDeliveryInfoFragment.this.isValid()) {
                AddDeliveryInfoInput addDeliveryInfoInput = new AddDeliveryInfoInput();
                addDeliveryInfoInput.address = ((Object) AddOrEditDeliveryInfoFragment.this.addressHolder.edittext.getText()) + BuildConfig.FLAVOR;
                AddOrEditDeliveryInfoFragment addOrEditDeliveryInfoFragment = AddOrEditDeliveryInfoFragment.this;
                addDeliveryInfoInput.city_id = addOrEditDeliveryInfoFragment.selectedCityId;
                addDeliveryInfoInput.province_id = addOrEditDeliveryInfoFragment.selectedProvinceId;
                addDeliveryInfoInput.is_default = false;
                addDeliveryInfoInput.location = addOrEditDeliveryInfoFragment.mapItem.locationObject;
                addDeliveryInfoInput.recipient_mobile = NumberUtils.toEnglish(((Object) AddOrEditDeliveryInfoFragment.this.mobileHolder.edittext.getText()) + BuildConfig.FLAVOR);
                addDeliveryInfoInput.recipient_name = ((Object) AddOrEditDeliveryInfoFragment.this.nameHolder.edittext.getText()) + BuildConfig.FLAVOR;
                addDeliveryInfoInput.recipient_phone = NumberUtils.toEnglish(((Object) AddOrEditDeliveryInfoFragment.this.phoneHolder.edittext.getText()) + BuildConfig.FLAVOR);
                addDeliveryInfoInput.postal_code = NumberUtils.toEnglish(((Object) AddOrEditDeliveryInfoFragment.this.codeHolder.edittext.getText()) + BuildConfig.FLAVOR);
                addDeliveryInfoInput.is_default = true;
                AddOrEditDeliveryInfoFragment addOrEditDeliveryInfoFragment2 = AddOrEditDeliveryInfoFragment.this;
                DeliveryInfoObject deliveryInfoObject = addOrEditDeliveryInfoFragment2.deliveryInfoObject;
                if (deliveryInfoObject == null) {
                    addOrEditDeliveryInfoFragment2.buttonHolder.showLoading();
                    ApiRequestMessanger.getInstance(((BaseFragment) AddOrEditDeliveryInfoFragment.this).currentAccount).addDeliveryInfo(addDeliveryInfoInput, new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.fragment.AddOrEditDeliveryInfoFragment.4.1
                        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                        public void onResponse(Call call, Object obj) {
                            AddOrEditDeliveryInfoFragment.this.buttonHolder.hideLoading();
                            AddDeliveryInfoOutput addDeliveryInfoOutput = (AddDeliveryInfoOutput) obj;
                            if (addDeliveryInfoOutput == null || addDeliveryInfoOutput.delivery_info == null || ApplicationLoader.applicationActivity == null) {
                                return;
                            }
                            if (ApplicationLoader.applicationActivity.getSecondLastFragment() instanceof DeliveryInfosListFragment) {
                                ((DeliveryInfosListFragment) ApplicationLoader.applicationActivity.getSecondLastFragment()).refreshOnResume = true;
                                ((DeliveryInfosListFragment) ApplicationLoader.applicationActivity.getSecondLastFragment()).deliveryInfoObjectLastEditedOrAdded = addDeliveryInfoOutput.delivery_info;
                                ApplicationLoader.applicationActivity.onBackPressed();
                                return;
                            }
                            if (ApplicationLoader.applicationActivity.getSecondLastFragment() instanceof BasketDetailsFragment) {
                                AddOrEditDeliveryInfoFragment addOrEditDeliveryInfoFragment3 = AddOrEditDeliveryInfoFragment.this;
                                if (addOrEditDeliveryInfoFragment3.basketObject == null || addDeliveryInfoOutput.delivery_info == null) {
                                    return;
                                }
                                addOrEditDeliveryInfoFragment3.presentFragment(new BasketDeliveryTypeAndTimeFragment(AddOrEditDeliveryInfoFragment.this.basketObject, addDeliveryInfoOutput.delivery_info));
                                AddOrEditDeliveryInfoFragment.this.removeSelfFromStack();
                            }
                        }

                        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                        public void onFailure(Call call, Throwable th) {
                            AddOrEditDeliveryInfoFragment.this.buttonHolder.hideLoading();
                        }

                        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                        public void onError(MessangerOutput messangerOutput) {
                            AddOrEditDeliveryInfoFragment.this.buttonHolder.hideLoading();
                        }
                    });
                } else {
                    addDeliveryInfoInput.delivery_info_id = deliveryInfoObject.delivery_info_id;
                    ApiRequestMessanger.getInstance(((BaseFragment) addOrEditDeliveryInfoFragment2).currentAccount).editDeliveryInfo(addDeliveryInfoInput, new ApiRequestMessanger.Listener(this) { // from class: ir.resaneh1.iptv.fragment.AddOrEditDeliveryInfoFragment.4.2
                        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                        public void onError(MessangerOutput messangerOutput) {
                        }

                        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                        public void onFailure(Call call, Throwable th) {
                        }

                        @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
                        public void onResponse(Call call, Object obj) {
                            AddDeliveryInfoOutput addDeliveryInfoOutput = (AddDeliveryInfoOutput) obj;
                            if (ApplicationLoader.applicationActivity != null) {
                                if (ApplicationLoader.applicationActivity.getSecondLastFragment() instanceof DeliveryInfosListFragment) {
                                    ((DeliveryInfosListFragment) ApplicationLoader.applicationActivity.getSecondLastFragment()).refreshOnResume = true;
                                    if (addDeliveryInfoOutput != null && addDeliveryInfoOutput.delivery_info != null) {
                                        ((DeliveryInfosListFragment) ApplicationLoader.applicationActivity.getSecondLastFragment()).deliveryInfoObjectLastEditedOrAdded = addDeliveryInfoOutput.delivery_info;
                                    }
                                }
                                ApplicationLoader.applicationActivity.onBackPressed();
                            }
                        }
                    });
                }
            }
        }
    };

    @Override // ir.resaneh1.iptv.PresenterFragment
    public int getLayoutId() {
        return R.layout.activity_presenter_base_with_just_linearlayout;
    }

    public AddOrEditDeliveryInfoFragment(DeliveryInfoObject deliveryInfoObject) {
        this.deliveryInfoObject = deliveryInfoObject;
        this.fragmentName = "AddOrEditDeliveryInfoFragment";
    }

    public AddOrEditDeliveryInfoFragment() {
        this.fragmentName = "AddOrEditDeliveryInfoFragment";
    }

    public AddOrEditDeliveryInfoFragment(BasketObject basketObject) {
        this.basketObject = basketObject;
        this.fragmentName = "AddOrEditDeliveryInfoFragment";
    }

    private void setToolbar() {
        if (this.deliveryInfoObject == null) {
            this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, LocaleController.getString(R.string.add_new_address));
        } else {
            this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, LocaleController.getString(R.string.edit_address));
        }
    }

    @Override // ir.resaneh1.iptv.PresenterFragment
    protected void init() {
        super.init();
        this.progressBar.setVisibility(4);
        this.fragmentView.setBackgroundColor(this.mContext.getResources().getColor(R.color.backgroundColorGrey));
        setToolbar();
        makeLayout();
    }

    private void makeLayout() {
        String str;
        EditTextPresenter editTextPresenter = new EditTextPresenter(this.mContext);
        EditTextAutoCompletePresenter editTextAutoCompletePresenter = new EditTextAutoCompletePresenter(this.mContext);
        EditTextItem editTextItem = new EditTextItem(BuildConfig.FLAVOR, LocaleController.getString("fullNameHint", R.string.fullNameHint));
        if (getAppPreferences().getMyFullName() != null && !getAppPreferences().getMyFullName().isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>();
            editTextItem.suggestions = arrayList;
            arrayList.add(getAppPreferences().getMyFullName());
        }
        EditTextItem editTextItem2 = new EditTextItem(BuildConfig.FLAVOR, LocaleController.getString("PhoneHintText", R.string.PhoneHintText));
        if (getAppPreferences().getMyPhone() != null && !getAppPreferences().getMyPhone().isEmpty()) {
            editTextItem2.suggestions = new ArrayList<>();
            if (getAppPreferences().getMyPhone().startsWith("98")) {
                str = "0" + getAppPreferences().getMyPhone().substring(2);
            } else {
                str = BuildConfig.FLAVOR;
            }
            editTextItem2.suggestions.add(str);
        }
        EditTextItem editTextItem3 = new EditTextItem(BuildConfig.FLAVOR, LocaleController.getString("PaymentShippingPhoneNumber", R.string.PaymentShippingPhoneNumber));
        TwoEditTextItem twoEditTextItem = new TwoEditTextItem(BuildConfig.FLAVOR, LocaleController.getString("PaymentShippingStatePlaceholder", R.string.PaymentShippingStatePlaceholder), BuildConfig.FLAVOR, LocaleController.getString("PaymentShippingCityPlaceholder", R.string.PaymentShippingCityPlaceholder));
        EditTextItem editTextItem4 = new EditTextItem(BuildConfig.FLAVOR, LocaleController.getString("PaymentShippingZipPlaceholder", R.string.PaymentShippingZipPlaceholder));
        EditTextItem editTextItem5 = new EditTextItem(BuildConfig.FLAVOR, LocaleController.getString("PaymentShippingAddress", R.string.PaymentShippingAddress));
        MapItem mapItem = new MapItem();
        this.mapItem = mapItem;
        mapItem.locationObject = new LocationObject();
        MapItem mapItem2 = this.mapItem;
        LocationObject locationObject = mapItem2.locationObject;
        locationObject.longitude = 0.0d;
        locationObject.latitude = 0.0d;
        DeliveryInfoObject deliveryInfoObject = this.deliveryInfoObject;
        if (deliveryInfoObject != null) {
            editTextItem.text = deliveryInfoObject.recipient_name;
            editTextItem2.text = deliveryInfoObject.recipient_mobile;
            editTextItem3.text = deliveryInfoObject.recipient_phone;
            DeliveryProvinceObject deliveryProvinceObject = deliveryInfoObject.province;
            twoEditTextItem.text1 = deliveryProvinceObject.name;
            DeliveryCityObject deliveryCityObject = deliveryInfoObject.city;
            twoEditTextItem.text2 = deliveryCityObject.name;
            editTextItem4.text = deliveryInfoObject.postal_code;
            editTextItem5.text = deliveryInfoObject.address;
            mapItem2.locationObject = deliveryInfoObject.location;
            this.selectedCityId = deliveryCityObject.city_id;
            this.selectedProvinceId = deliveryProvinceObject.province_id;
        }
        ButtonItem buttonItem = new ButtonItem(LocaleController.getString("OK", R.string.OK), this.onAddAddressClick);
        this.nameHolder = editTextAutoCompletePresenter.createViewHolderAndBind(editTextItem);
        EditTextAutoCompletePresenter.MyViewHolder myViewHolderCreateViewHolderAndBind = editTextAutoCompletePresenter.createViewHolderAndBind(editTextItem2);
        this.mobileHolder = myViewHolderCreateViewHolderAndBind;
        myViewHolderCreateViewHolderAndBind.edittext.setInputType(3);
        EditTextPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind2 = editTextPresenter.createViewHolderAndBind(editTextItem3);
        this.phoneHolder = myViewHolderCreateViewHolderAndBind2;
        myViewHolderCreateViewHolderAndBind2.edittext.setInputType(3);
        EditTextPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind3 = editTextPresenter.createViewHolderAndBind(editTextItem4);
        this.codeHolder = myViewHolderCreateViewHolderAndBind3;
        myViewHolderCreateViewHolderAndBind3.edittext.setInputType(3);
        EditTextPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind4 = editTextPresenter.createViewHolderAndBind(editTextItem5);
        this.addressHolder = myViewHolderCreateViewHolderAndBind4;
        myViewHolderCreateViewHolderAndBind4.edittext.setSingleLine(false);
        this.addressHolder.edittext.setImeOptions(1073741824);
        this.addressHolder.edittext.setMinLines(2);
        EditText editText = this.addressHolder.edittext;
        editText.setFilters(InputFilterHelper.getFilter(300, 5, editText));
        TwoTextLikeEditTextPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind5 = new TwoTextLikeEditTextPresenter(this.mContext).createViewHolderAndBind(twoEditTextItem);
        this.cityHolder = myViewHolderCreateViewHolderAndBind5;
        myViewHolderCreateViewHolderAndBind5.textView1.setOnClickListener(this.onProvinceClick);
        this.cityHolder.textView2.setOnClickListener(this.onCityClick);
        MapPresenter mapPresenter = new MapPresenter(this.mContext);
        this.mapPresenter = mapPresenter;
        MapPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind6 = mapPresenter.createViewHolderAndBind(this.mapItem);
        this.mapHolder = myViewHolderCreateViewHolderAndBind6;
        myViewHolderCreateViewHolderAndBind6.clickableFrame.setOnClickListener(new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.AddOrEditDeliveryInfoFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AddOrEditDeliveryInfoFragment.this.onSelectLocationClicked();
            }
        });
        this.buttonHolder = new ButtonPresenter(this.mContext).createViewHolderAndBind(buttonItem);
        this.linearLayout.addView(this.nameHolder.itemView);
        this.linearLayout.addView(this.mobileHolder.itemView);
        this.linearLayout.addView(this.phoneHolder.itemView);
        this.linearLayout.addView(this.cityHolder.itemView);
        this.linearLayout.addView(this.codeHolder.itemView);
        this.linearLayout.addView(this.addressHolder.itemView);
        this.linearLayout.addView(this.mapHolder.itemView);
        this.linearLayout.addView(this.buttonHolder.itemView);
    }

    public boolean isValid() {
        if (!isNameValid(this.nameHolder.edittext.getText().toString())) {
            showErrorMessage();
            return false;
        }
        if (!isMobileValid(this.mobileHolder.edittext.getText().toString())) {
            showErrorMessage();
            return false;
        }
        if (!isPhoneValid(this.phoneHolder.edittext.getText().toString())) {
            showErrorMessage();
            return false;
        }
        if (!isCityOrProvinceValid()) {
            showErrorMessage();
            return false;
        }
        this.codeHolder.edittext.getText().toString();
        if (isAddressValid(this.addressHolder.edittext.getText().toString())) {
            return true;
        }
        showErrorMessage();
        return false;
    }

    public boolean isNameValid(String str) {
        if (!str.replace(" ", BuildConfig.FLAVOR).isEmpty()) {
            return true;
        }
        this.errorMessage = LocaleController.getString("fullNameError", R.string.fullNameError);
        return false;
    }

    public boolean isCityOrProvinceValid() {
        String str = this.selectedProvinceId;
        if (str == null || str.isEmpty()) {
            this.errorMessage = LocaleController.getString("provinceError", R.string.provinceError);
            return false;
        }
        String str2 = this.selectedCityId;
        if (str2 != null && !str2.isEmpty()) {
            return true;
        }
        this.errorMessage = LocaleController.getString("cityError", R.string.cityError);
        return false;
    }

    public boolean isAddressValid(String str) {
        if (!str.replace(" ", BuildConfig.FLAVOR).isEmpty()) {
            return true;
        }
        this.errorMessage = LocaleController.getString("addressError", R.string.addressError);
        return false;
    }

    public boolean isMobileValid(String str) {
        if (str.replace(" ", BuildConfig.FLAVOR).isEmpty()) {
            this.errorMessage = LocaleController.getString("phoneError", R.string.phoneError);
            return false;
        }
        if (Pattern.compile("^09\\d{9}$").matcher(NumberUtils.toEnglish(str)).matches()) {
            return true;
        }
        this.errorMessage = LocaleController.getString("phoneError2", R.string.phoneError2);
        return false;
    }

    private boolean isPhoneValid(String str) {
        if (str.replace(" ", BuildConfig.FLAVOR).isEmpty()) {
            return true;
        }
        Pattern patternCompile = Pattern.compile("\\d+$");
        String strReplace = NumberUtils.toEnglish(str).replace(" ", BuildConfig.FLAVOR).replace("-", BuildConfig.FLAVOR).replace("+", BuildConfig.FLAVOR);
        if (strReplace.length() < 15 && strReplace.length() > 2) {
            if (patternCompile.matcher(strReplace).matches()) {
                return true;
            }
            this.errorMessage = LocaleController.getString("phoneError3", R.string.phoneError3);
            return false;
        }
        this.errorMessage = LocaleController.getString("phoneError3", R.string.phoneError3);
        return false;
    }

    public void showErrorMessage() {
        if (this.errorMessage.isEmpty()) {
            this.errorMessage = LocaleController.getString("infoError", R.string.infoError);
        }
        ToastiLikeSnack.showL(this.mContext, this.errorMessage);
    }

    void onSelectLocationClicked() {
        LocationActivity locationActivity = new LocationActivity(0);
        locationActivity.setDelegate(new LocationActivity.LocationActivityDelegate() { // from class: ir.resaneh1.iptv.fragment.AddOrEditDeliveryInfoFragment$$ExternalSyntheticLambda0
            @Override // org.rbmain.ui.LocationActivity.LocationActivityDelegate
            public final void didSelectLocation(TLRPC$MessageMedia tLRPC$MessageMedia, int i, boolean z, int i2) {
                this.f$0.lambda$onSelectLocationClicked$0(tLRPC$MessageMedia, i, z, i2);
            }
        });
        presentFragment(locationActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSelectLocationClicked$0(TLRPC$MessageMedia tLRPC$MessageMedia, int i, boolean z, int i2) {
        if (tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaGeo) {
            MapItem mapItem = this.mapItem;
            LocationObject locationObject = mapItem.locationObject;
            TLRPC$GeoPoint tLRPC$GeoPoint = tLRPC$MessageMedia.geo;
            locationObject.longitude = tLRPC$GeoPoint.lat;
            locationObject.latitude = tLRPC$GeoPoint._long;
            this.mapPresenter.onBindViewHolder(this.mapHolder, mapItem);
        }
    }
}
