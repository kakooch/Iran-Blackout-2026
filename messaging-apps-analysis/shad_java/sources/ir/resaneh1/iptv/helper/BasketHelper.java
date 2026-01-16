package ir.resaneh1.iptv.helper;

import android.content.DialogInterface;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.resaneh1.iptv.activity.MainTabFragment;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.dialog.LoadingDialog;
import ir.resaneh1.iptv.fragment.BasketDetailsFragment;
import ir.resaneh1.iptv.fragment.BasketListFragment;
import ir.resaneh1.iptv.fragment.OrderListFragment;
import ir.resaneh1.iptv.model.GetBasketInput;
import ir.resaneh1.iptv.model.GetBasketOutput;
import ir.resaneh1.iptv.model.GetBasketStatusOutput;
import ir.resaneh1.iptv.model.MessangerOutput;
import java.util.ArrayList;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.UserConfig;
import org.rbmain.ui.ActionBar.BaseFragment;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class BasketHelper {
    public static void backToBasket(int i, String str) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        final LoadingDialog loadingDialog = new LoadingDialog(ApplicationLoader.applicationActivity);
        loadingDialog.show();
        ApiRequestMessanger.getInstance(i).getBasket(new GetBasketInput(str), new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.helper.BasketHelper.1
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call, Object obj) {
                BaseFragment baseFragment;
                loadingDialog.dismiss();
                GetBasketOutput getBasketOutput = (GetBasketOutput) obj;
                if (ApplicationLoader.applicationActivity != null) {
                    ArrayList<BaseFragment> arrayList = ApplicationLoader.applicationActivity.getActionBarLayout().fragmentsStack;
                    for (int size = arrayList.size() - 2; size >= 0; size--) {
                        try {
                            baseFragment = arrayList.get(size);
                        } catch (Exception unused) {
                        }
                        if (!(baseFragment instanceof MainTabFragment) && !(baseFragment instanceof BasketDetailsFragment)) {
                            baseFragment.removeSelfFromStack();
                        } else if (baseFragment instanceof BasketDetailsFragment) {
                            baseFragment.removeSelfFromStack();
                        }
                    }
                }
                try {
                    BaseFragment secondLastFragment = ApplicationLoader.applicationActivity.getSecondLastFragment();
                    if (secondLastFragment instanceof BasketListFragment) {
                        ((BasketListFragment) secondLastFragment).refreshOnResume = true;
                    }
                } catch (Exception unused2) {
                }
                ApplicationLoader.applicationActivity.onBackPressed();
                if (getBasketOutput != null && getBasketOutput.basket != null) {
                    ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new BasketDetailsFragment(getBasketOutput.basket));
                } else {
                    ToastiLikeSnack.showL(ApplicationLoader.applicationContext, "سبد خرید نامعتبر است");
                }
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call, Throwable th) {
                loadingDialog.dismiss();
                ToastiLikeSnack.showNoInternet();
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
                loadingDialog.dismiss();
                ToastiLikeSnack.showNoInternet();
            }
        });
    }

    public static void openOrderListAndCloseBasketFragments() {
        BaseFragment lastFragment;
        BaseFragment baseFragment;
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        ArrayList<BaseFragment> arrayList = ApplicationLoader.applicationActivity.getActionBarLayout().fragmentsStack;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            try {
                baseFragment = arrayList.get(size);
            } catch (Exception unused) {
            }
            if (!(baseFragment instanceof MainTabFragment) && !(baseFragment instanceof BasketDetailsFragment)) {
                baseFragment.removeSelfFromStack();
            } else {
                if (baseFragment instanceof BasketDetailsFragment) {
                    baseFragment.removeSelfFromStack();
                }
                lastFragment = ApplicationLoader.applicationActivity.getLastFragment();
                if (lastFragment != null && (lastFragment instanceof BasketListFragment)) {
                    ((BasketListFragment) lastFragment).refreshOnResume = true;
                }
                ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new OrderListFragment(BuildConfig.FLAVOR));
            }
        }
        lastFragment = ApplicationLoader.applicationActivity.getLastFragment();
        if (lastFragment != null) {
            ((BasketListFragment) lastFragment).refreshOnResume = true;
        }
        ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new OrderListFragment(BuildConfig.FLAVOR));
    }

    public static void openBasketOrBasketList() {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        final LoadingDialog loadingDialog = new LoadingDialog(ApplicationLoader.applicationActivity);
        loadingDialog.show();
        final Call<MessangerOutput<GetBasketStatusOutput>> basketsStatus = ApiRequestMessanger.getInstance(UserConfig.selectedAccount).getBasketsStatus(new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.helper.BasketHelper.2
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call, Object obj) {
                GetBasketStatusOutput getBasketStatusOutput;
                loadingDialog.dismiss();
                if (call.isCanceled() || (getBasketStatusOutput = (GetBasketStatusOutput) obj) == null) {
                    return;
                }
                long j = getBasketStatusOutput.basket_count;
                if (j == 1) {
                    ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new BasketDetailsFragment(BuildConfig.FLAVOR));
                } else if (j > 1) {
                    ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new BasketListFragment());
                }
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call, Throwable th) {
                loadingDialog.dismiss();
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
                loadingDialog.dismiss();
            }
        });
        loadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.resaneh1.iptv.helper.BasketHelper.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                basketsStatus.cancel();
            }
        });
    }
}
