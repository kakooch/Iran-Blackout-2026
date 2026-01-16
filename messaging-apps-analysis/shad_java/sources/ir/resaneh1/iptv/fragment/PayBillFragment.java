package ir.resaneh1.iptv.fragment;

import android.app.Activity;
import android.view.View;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.medu.shad.R;
import ir.resaneh1.iptv.PresenterFragment;
import ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV;
import ir.resaneh1.iptv.appUpdate.UpdateUtils;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.helper.DeviceInfo;
import ir.resaneh1.iptv.helper.ToastiLikeSnack;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.ButtonItem;
import ir.resaneh1.iptv.model.EditTextItem;
import ir.resaneh1.iptv.model.GetTokenPayInput;
import ir.resaneh1.iptv.model.GetTokenPayObject;
import ir.resaneh1.iptv.model.GetTokenPayOutput2;
import ir.resaneh1.iptv.model.TextViewItem;
import ir.resaneh1.iptv.presenters.ButtonPresenter;
import ir.resaneh1.iptv.presenters.EditTextCostPresenter;
import ir.resaneh1.iptv.presenters.EditTextPresenter;
import ir.resaneh1.iptv.presenters.TextViewPresenter;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class PayBillFragment extends PresenterFragment {
    EditTextPresenter.MyViewHolder billHolder;
    String error = "اطلاعات وارد شده صحیح نیست";
    int[] factor = {0, 2, 3, 4, 5, 6, 7, 2, 3, 4, 5, 6, 7, 2, 3, 4, 5, 6, 7, 2, 3, 4, 5, 6, 7, 2, 3, 4, 5, 6, 7, 2, 3, 4, 5, 6, 7, 2};
    EditTextPresenter.MyViewHolder payHolder;
    private TextViewPresenter.MyViewHolder textViewHolder;

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
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, "پرداخت قبض");
        getToken();
        makeLayout();
    }

    private void makeLayout() {
        TextViewPresenter textViewPresenter = new TextViewPresenter(this.mContext);
        this.textViewHolder = textViewPresenter.createViewHolderAndBind(new TextViewItem("برای پرداخت قبض لطفا شناسه قبض و شناسه پرداخت را وارد نمایید"));
        EditTextPresenter editTextPresenter = new EditTextPresenter(this.mContext);
        EditTextItem editTextItem = new EditTextItem(BuildConfig.FLAVOR, "شناسه قبض");
        EditTextItem editTextItem2 = new EditTextItem(BuildConfig.FLAVOR, "شناسه پرداخت");
        EditTextPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind = editTextPresenter.createViewHolderAndBind(editTextItem);
        this.billHolder = myViewHolderCreateViewHolderAndBind;
        myViewHolderCreateViewHolderAndBind.edittext.setInputType(3);
        EditTextPresenter.MyViewHolder myViewHolderCreateViewHolderAndBind2 = editTextPresenter.createViewHolderAndBind(editTextItem2);
        this.payHolder = myViewHolderCreateViewHolderAndBind2;
        myViewHolderCreateViewHolderAndBind2.edittext.setInputType(3);
        this.linearLayout.addView(textViewPresenter.createViewHolderAndBind(new TextViewItem("  ")).itemView);
        this.linearLayout.addView(this.billHolder.itemView);
        this.linearLayout.addView(this.payHolder.itemView);
        this.linearLayout.addView(new ButtonPresenter(this.mContext).createViewHolderAndBind(new ButtonItem("پرداخت قبض", new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.PayBillFragment.1
            /* JADX WARN: Removed duplicated region for block: B:20:0x00de  */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onClick(android.view.View r4) {
                /*
                    Method dump skipped, instructions count: 234
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.fragment.PayBillFragment.AnonymousClass1.onClick(android.view.View):void");
            }
        })).itemView);
        this.linearLayout.addView(this.textViewHolder.itemView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getAmount(String str) {
        while (str.startsWith("0")) {
            str = str.substring(1);
        }
        String string = new StringBuilder(str).reverse().toString();
        String str2 = "000";
        for (int i = 5; i < string.length(); i++) {
            str2 = str2 + string.charAt(i);
        }
        return EditTextCostPresenter.setFormat(new StringBuilder(str2).reverse().toString());
    }

    private String getUserPhoneNumber() {
        String myPhone = getAppPreferences().getMyPhone();
        return myPhone != null ? myPhone : BuildConfig.FLAVOR;
    }

    public void showErrorMessage() {
        ToastiLikeSnack.showL(this.mContext, this.error);
    }

    public String getServiceType(String str) throws NumberFormatException {
        int i;
        try {
            i = Integer.parseInt(str.charAt(str.length() - 2) + BuildConfig.FLAVOR);
        } catch (Exception unused) {
            i = 0;
        }
        switch (i) {
            case 1:
                return "آب";
            case 2:
                return "برق";
            case 3:
                return "گاز";
            case 4:
                return "تلفن ثابت";
            case 5:
                return "تلفن همراه";
            case 6:
                return "عوارض شهرداری";
            case 7:
            default:
                return BuildConfig.FLAVOR;
            case 8:
                return "سازمان مالیات";
            case 9:
                return "جرایم راهنمایی و رانندگی";
        }
    }

    public boolean isIdValid(String str) {
        return str != null && str.length() >= 6 && str.length() <= 13;
    }

    public void callGetToken() {
        this.progressBar.setVisibility(0);
        ApiRequestIPTV.getInstance(this.currentAccount).getTokenPay(new GetTokenPayInput(UpdateUtils.getAppVersion(this.mContext), getUserPhoneNumber(), DeviceInfo.getDeviceID(this.mContext), BuildConfig.FLAVOR), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.PayBillFragment.2
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                MyLog.e("BuyMobile", "onResponse: ");
                PayBillFragment.this.progressBar.setVisibility(4);
                GetTokenPayObject getTokenPayObject = ((GetTokenPayOutput2) response.body()).result;
                PayBillFragment.this.getAppPreferences().setString(AppPreferences.Key.token780, getTokenPayObject.token);
                PayBillFragment.this.getAppPreferences().setString(AppPreferences.Key.sessionKey780, getTokenPayObject.session_key);
                PayBillFragment.this.getAppPreferences().setString(AppPreferences.Key.pinKey780, getTokenPayObject.pin_key);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                MyLog.e("BuyMobile", "onFailure: ");
                PayBillFragment.this.progressBar.setVisibility(4);
            }
        });
    }

    private void getToken() {
        String string = getAppPreferences().getString(AppPreferences.Key.token780);
        if (string == null || string.equals(BuildConfig.FLAVOR)) {
            callGetToken();
        }
    }

    public boolean checkBillId(String str) {
        String string = new StringBuilder(str).reverse().toString();
        int[] iArr = new int[string.length()];
        int i = 0;
        for (int i2 = 0; i2 < string.length(); i2++) {
            iArr[i2] = string.charAt(i2) - '0';
            MyLog.e("payBill", "checkBillId: " + iArr[i2]);
            i += iArr[i2] * this.factor[i2];
        }
        int i3 = i % 11;
        MyLog.e("payBill", "checkBillId: " + i3);
        return (i3 == 0 || i3 == 1) ? iArr[0] == 0 : 11 - i3 == iArr[0];
    }

    public boolean checkPayId(String str, String str2) {
        String strSubstring = str.substring(0, str.length() - 1);
        MyLog.e("payBill", "checkPayId: " + strSubstring);
        if (!checkBillId(strSubstring)) {
            return false;
        }
        MyLog.e("payBill", "checkPayId: checkbill");
        while (str2.startsWith("0")) {
            str2 = str2.substring(1);
        }
        while (str.startsWith("0")) {
            str = str.substring(1);
        }
        return checkBillId(str2 + str);
    }
}
