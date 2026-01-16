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
import ir.resaneh1.iptv.presenters.EditTextCardNoPresenter;
import ir.resaneh1.iptv.presenters.EditTextCostPresenter;
import ir.resaneh1.iptv.presenters.TextViewPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class TransferFragment extends PresenterFragment {
    EditTextCostPresenter.MyViewHolder costHolder;
    EditTextCardNoPresenter.MyViewHolder fromCardNoHolder;
    private TextViewPresenter.MyViewHolder textViewHolder;
    EditTextCardNoPresenter.MyViewHolder toCardNoHolder;

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
        this.toolbarMaker.setToolbarWithBackButtonAndTextGrey((Activity) this.mContext, "کارت به کارت");
        getToken();
        makeLayout();
        callGetDetailList();
    }

    private void makeLayout() {
        TextViewPresenter textViewPresenter = new TextViewPresenter(this.mContext);
        this.textViewHolder = textViewPresenter.createViewHolderAndBind(new TextViewItem(BuildConfig.FLAVOR));
        EditTextItem editTextItem = new EditTextItem(BuildConfig.FLAVOR, "شماره کارت مبدا");
        EditTextItem editTextItem2 = new EditTextItem(BuildConfig.FLAVOR, "شماره کارت مقصد");
        EditTextItem editTextItem3 = new EditTextItem(BuildConfig.FLAVOR, "مبلغ(ریال)");
        EditTextCardNoPresenter editTextCardNoPresenter = new EditTextCardNoPresenter(this.mContext);
        this.fromCardNoHolder = editTextCardNoPresenter.createViewHolderAndBind(editTextItem);
        this.toCardNoHolder = editTextCardNoPresenter.createViewHolderAndBind(editTextItem2);
        this.costHolder = new EditTextCostPresenter(this.mContext).createViewHolderAndBind(editTextItem3);
        this.linearLayout.addView(textViewPresenter.createViewHolderAndBind(new TextViewItem("  ")).itemView);
        this.linearLayout.addView(this.fromCardNoHolder.itemView);
        this.linearLayout.addView(this.toCardNoHolder.itemView);
        this.linearLayout.addView(this.costHolder.itemView);
        this.linearLayout.addView(new ButtonPresenter(this.mContext).createViewHolderAndBind(new ButtonItem("ادامه", new View.OnClickListener() { // from class: ir.resaneh1.iptv.fragment.TransferFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (EditTextCardNoPresenter.isValid(((EditTextItem) TransferFragment.this.fromCardNoHolder.item).text) && EditTextCardNoPresenter.isValid(((EditTextItem) TransferFragment.this.toCardNoHolder.item).text) && !((EditTextItem) TransferFragment.this.costHolder.item).text.equals(BuildConfig.FLAVOR)) {
                    TransferFragment.this.getCardInfo();
                } else {
                    ToastiLikeSnack.showL(TransferFragment.this.mContext, "اطلاعات وارد شده صحیح نیست.");
                }
            }
        })).itemView);
        this.linearLayout.addView(this.textViewHolder.itemView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getCardInfo() {
        BuyInput buyInput = new BuyInput();
        buyInput.service_type = 6;
        buyInput.pan = ((EditTextItem) this.fromCardNoHolder.item).text;
        buyInput.amount = getInt(((EditTextItem) this.costHolder.item).text);
        MyLog.e("TransferFragment", "callPayServiceGetToCardInfo: " + buyInput.amount);
        buyInput.add_data = ((EditTextItem) this.toCardNoHolder.item).text;
        presentFragment(new CardInfoToPayWithCvvFragment(buyInput, BuildConfig.FLAVOR));
    }

    private int getInt(String str) {
        try {
            return Integer.parseInt(str.replace(EditTextCostPresenter.space, BuildConfig.FLAVOR));
        } catch (Exception unused) {
            return 0;
        }
    }

    public void callGetToken() {
        this.progressBar.setVisibility(0);
        ApiRequestIPTV.getInstance(this.currentAccount).getTokenPay(new GetTokenPayInput(UpdateUtils.getAppVersion(this.mContext), getAppPreferences().getUserPhoneNumber(), DeviceInfo.getDeviceID(this.mContext), BuildConfig.FLAVOR), new ApiRequestIPTV.Listener() { // from class: ir.resaneh1.iptv.fragment.TransferFragment.2
            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onResponse(Call call, Response response) {
                MyLog.e("TransferFragment", "onResponse: ");
                TransferFragment.this.progressBar.setVisibility(4);
                GetTokenPayObject getTokenPayObject = ((GetTokenPayOutput2) response.body()).result;
                TransferFragment.this.getAppPreferences().setString(AppPreferences.Key.token780, getTokenPayObject.token);
                TransferFragment.this.getAppPreferences().setString(AppPreferences.Key.sessionKey780, getTokenPayObject.session_key);
                TransferFragment.this.getAppPreferences().setString(AppPreferences.Key.pinKey780, getTokenPayObject.pin_key);
            }

            @Override // ir.resaneh1.iptv.apiIPTV.ApiRequestIPTV.Listener
            public void onFailure(Call call, Throwable th) {
                MyLog.e("TransferFragment", "onFailure: ");
                TransferFragment.this.progressBar.setVisibility(4);
            }
        });
    }

    private void callGetDetailList() {
        this.progressBar.setVisibility(0);
        new ItemListRequest().load(this.mContext, new ListInput("getdetail_var", getAppPreferences().getUserPhoneNumber()), new ItemListRequest.Listener() { // from class: ir.resaneh1.iptv.fragment.TransferFragment.3
            @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
            public void onResponse(ArrayList<? extends PresenterItem> arrayList, GetListOutput getListOutput) {
                TransferFragment.this.progressBar.setVisibility(4);
                Iterator<? extends PresenterItem> it = arrayList.iterator();
                while (it.hasNext()) {
                    GetListPayObject.Item item = (GetListPayObject.Item) it.next();
                    if (item.value.equals("card2carddesc")) {
                        TransferFragment.this.textViewHolder.textView.setText(item.name);
                        return;
                    }
                }
            }

            @Override // ir.resaneh1.iptv.helper.ItemListRequest.Listener
            public void onFailure(Throwable th) {
                TransferFragment.this.progressBar.setVisibility(4);
            }
        });
    }

    private void getToken() {
        String string = getAppPreferences().getString(AppPreferences.Key.token780);
        if (string == null || string.equals(BuildConfig.FLAVOR)) {
            callGetToken();
        }
    }
}
