package ir.resaneh1.iptv.barcode;

import android.content.DialogInterface;
import android.os.Build;
import androidMessenger.utilites.BotButtonHandler;
import androidMessenger.utilites.MyLog;
import androidMessenger.utilites.ToastiLikeSnack;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.model.MiniFunctionModels;
import ir.aaap.messengercore.model.MiniFunctionObject;
import ir.medu.shad.R;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger;
import ir.resaneh1.iptv.dialog.LoadingDialog;
import ir.resaneh1.iptv.helper.PaymentManager;
import ir.resaneh1.iptv.model.GetBarcodeActionInput;
import ir.resaneh1.iptv.model.GetBarcodeActionOutput;
import ir.resaneh1.iptv.model.Link;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.util.ArrayList;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.LocaleController;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.ui.ActionBar.BaseFragment;
import retrofit2.Call;

/* loaded from: classes3.dex */
public class BarcodeHelper {
    private static Link.BarcodescanData barcodeScanData;
    public static Listener listener;
    public static String title;

    public interface Listener {
        void onDone(String str);
    }

    public static void readBarcode(int i, Listener listener2, String str, Link.BarcodescanData barcodescanData) {
        listener = listener2;
        title = str;
        barcodeScanData = barcodescanData;
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23 && ApplicationLoader.applicationActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
            ApplicationLoader.applicationActivity.requestPermissions(new String[]{"android.permission.CAMERA"}, 1352);
        } else {
            startScan();
        }
    }

    public static void startScan() {
        ApplicationLoader.applicationActivity.lambda$runLinkRequest$40(new NewBarcodeScannerFragment(listener, title, barcodeScanData));
        listener = null;
    }

    public static void requestBarcodeAction(final int i, final String str, final String str2, String str3, String str4, final Link link, final String str5) {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        final LoadingDialog loadingDialog = new LoadingDialog(ApplicationLoader.applicationActivity);
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.barcode.BarcodeHelper$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                loadingDialog.show();
            }
        });
        GetBarcodeActionInput getBarcodeActionInput = new GetBarcodeActionInput();
        getBarcodeActionInput.barcode = str2;
        getBarcodeActionInput.type = str;
        getBarcodeActionInput.input_value = str3;
        getBarcodeActionInput.track_input = str4;
        final Call<MessangerOutput<GetBarcodeActionOutput>> barcodeAction = ApiRequestMessanger.getInstance(i).getBarcodeAction(getBarcodeActionInput, new ApiRequestMessanger.Listener() { // from class: ir.resaneh1.iptv.barcode.BarcodeHelper.1
            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onResponse(Call call, Object obj) {
                if (call.isCanceled()) {
                    return;
                }
                try {
                    LoadingDialog loadingDialog2 = loadingDialog;
                    loadingDialog2.getClass();
                    AndroidUtilities.runOnUIThread(new BarcodeHelper$1$$ExternalSyntheticLambda0(loadingDialog2));
                    BarcodeHelper.handleBarcodeAction(i, str, str2, (GetBarcodeActionOutput) obj, link, str5);
                } catch (Exception e) {
                    MyLog.handleException(e);
                }
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onFailure(Call call, Throwable th) {
                LoadingDialog loadingDialog2 = loadingDialog;
                loadingDialog2.getClass();
                AndroidUtilities.runOnUIThread(new BarcodeHelper$1$$ExternalSyntheticLambda0(loadingDialog2));
                if (call.isCanceled()) {
                    return;
                }
                ToastiLikeSnack.showNoInternet();
            }

            @Override // ir.resaneh1.iptv.apiMessanger.ApiRequestMessanger.Listener
            public void onError(MessangerOutput messangerOutput) {
                LoadingDialog loadingDialog2 = loadingDialog;
                loadingDialog2.getClass();
                AndroidUtilities.runOnUIThread(new BarcodeHelper$1$$ExternalSyntheticLambda0(loadingDialog2));
            }
        });
        loadingDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ir.resaneh1.iptv.barcode.BarcodeHelper$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                barcodeAction.cancel();
            }
        });
    }

    public static void handleBarcodeAction(final int i, final String str, final String str2, final GetBarcodeActionOutput getBarcodeActionOutput, final Link link, final String str3) {
        try {
            GetBarcodeActionOutput.Status status = getBarcodeActionOutput.status;
            if (status == GetBarcodeActionOutput.Status.Invalid) {
                ToastiLikeSnack.showMessageLikeToast(LocaleController.getString("invalid_request", R.string.invalid_request), 200);
                return;
            }
            if (status == GetBarcodeActionOutput.Status.OK) {
                GetBarcodeActionOutput.TypeActionEnum typeActionEnum = getBarcodeActionOutput.type_action;
                if (typeActionEnum == GetBarcodeActionOutput.TypeActionEnum.Link) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.barcode.BarcodeHelper.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ApplicationLoader.applicationActivity != null) {
                                new MainClickHandler().onLinkClick(ApplicationLoader.applicationActivity.getLastFragment(), getBarcodeActionOutput.link);
                            }
                        }
                    }, 200L);
                    return;
                }
                if (typeActionEnum == GetBarcodeActionOutput.TypeActionEnum.Payment) {
                    PaymentManager.getInstance().payByPaymentInfoObject(getBarcodeActionOutput.payment_info, str3, new PaymentManager.PayDoneListener() { // from class: ir.resaneh1.iptv.barcode.BarcodeHelper.3
                        @Override // ir.resaneh1.iptv.helper.PaymentManager.PayDoneListener
                        public void onPayDone() {
                        }

                        @Override // ir.resaneh1.iptv.helper.PaymentManager.PayDoneListener
                        public void onPayFaild() {
                        }

                        @Override // ir.resaneh1.iptv.helper.PaymentManager.PayDoneListener
                        public void onDoneAfterDismiss() {
                            if (link != null) {
                                AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.resaneh1.iptv.barcode.BarcodeHelper.3.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        new MainClickHandler().onLinkClick(link);
                                    }
                                });
                            }
                        }
                    });
                    return;
                }
                if (typeActionEnum != GetBarcodeActionOutput.TypeActionEnum.GetInput || ApplicationLoader.applicationActivity == null) {
                    return;
                }
                BaseFragment lastFragment = ApplicationLoader.applicationActivity.getLastFragment();
                MiniFunctionObject miniFunctionObject = new MiniFunctionObject() { // from class: ir.resaneh1.iptv.barcode.BarcodeHelper.4
                    @Override // ir.aaap.messengercore.model.MiniFunctionObject
                    public String getTitle() {
                        return getBarcodeActionOutput.input.message;
                    }
                };
                miniFunctionObject.type = MiniFunctionModels.ButtonType.Textbox;
                MiniFunctionModels.ButtonEditText buttonEditText = new MiniFunctionModels.ButtonEditText();
                miniFunctionObject.button_textbox = buttonEditText;
                GetBarcodeActionOutput.Input input = getBarcodeActionOutput.input;
                buttonEditText.default_value = input.default_value;
                buttonEditText.place_holder = BuildConfig.FLAVOR;
                if (input.type == GetBarcodeActionOutput.Input.Type.Numeric) {
                    buttonEditText.type_keypad = MiniFunctionModels.ButtonEditText.TypeKeypad.Number;
                } else {
                    buttonEditText.type_keypad = MiniFunctionModels.ButtonEditText.TypeKeypad.String;
                }
                BotButtonHandler.handleButtonClick(lastFragment, 0L, miniFunctionObject, null, new BotButtonHandler.Delegate() { // from class: ir.resaneh1.iptv.barcode.BarcodeHelper.5
                    @Override // androidMessenger.utilites.BotButtonHandler.Delegate
                    public void notSupported() {
                    }

                    @Override // androidMessenger.utilites.BotButtonHandler.Delegate
                    public void onLocationSelected(TLRPC$MessageMedia tLRPC$MessageMedia) {
                    }

                    @Override // androidMessenger.utilites.BotButtonHandler.Delegate
                    public void uploadFileDone(String str4, String str5) {
                    }

                    @Override // androidMessenger.utilites.BotButtonHandler.Delegate
                    public void done(String str4, ArrayList<String> arrayList) {
                        BarcodeHelper.requestBarcodeAction(i, str, str2, str4, getBarcodeActionOutput.input.track_input, link, str3);
                    }
                });
            }
        } catch (Exception e) {
            MyLog.handleException(e);
        }
    }
}
