package ir.appp.wallet;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidMessenger.ServiceLocator;
import androidMessenger.utilites.ChatConverter;
import androidMessenger.utilites.MessageConverter;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ir.aaap.messengercore.CoreMainClass;
import ir.aaap.messengercore.model.ChatAbsObject;
import ir.aaap.messengercore.model.UserInfo;
import ir.aaap.messengercore.model.WalletTransferDataObject;
import ir.aaap.messengercore.model.WalletTransferMessageObject;
import ir.appp.wallet.cell.component.WalletShareAlert;
import ir.appp.wallet.helper.ViewCreator;
import ir.appp.wallet.interfaces.WalletTransferListener;
import ir.medu.shad.R;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.helper.NumberUtils;
import ir.resaneh1.iptv.messanger.browser.Browser;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.wallet.CashOutInput;
import ir.resaneh1.iptv.model.wallet.CashOutOutput;
import ir.resaneh1.iptv.model.wallet.ChargeWalletByTokenInput;
import ir.resaneh1.iptv.model.wallet.ChargeWalletByTokenOutput;
import ir.resaneh1.iptv.model.wallet.ChargeWalletByUrlInput;
import ir.resaneh1.iptv.model.wallet.ChargeWalletByUrlOutput;
import ir.resaneh1.iptv.model.wallet.CheckAllowReceiveInput;
import ir.resaneh1.iptv.model.wallet.CheckAllowReceiveOutput;
import ir.resaneh1.iptv.model.wallet.CreditObject;
import ir.resaneh1.iptv.model.wallet.CurrencyObject;
import ir.resaneh1.iptv.model.wallet.GetCurrenciesInput;
import ir.resaneh1.iptv.model.wallet.GetCurrenciesOutput;
import ir.resaneh1.iptv.model.wallet.GetWalletByShareLinkInput;
import ir.resaneh1.iptv.model.wallet.GetWalletByShareLinkOutput;
import ir.resaneh1.iptv.model.wallet.GetWalletShareLinkInput;
import ir.resaneh1.iptv.model.wallet.GetWalletShareLinkOutput;
import ir.resaneh1.iptv.model.wallet.GetWalletStatusInput;
import ir.resaneh1.iptv.model.wallet.GetWalletStatusOutput;
import ir.resaneh1.iptv.model.wallet.GetWalletTransactionsInput;
import ir.resaneh1.iptv.model.wallet.GetWalletTransactionsOutput;
import ir.resaneh1.iptv.model.wallet.TransferCreditInput;
import ir.resaneh1.iptv.model.wallet.TransferCreditOutput;
import ir.resaneh1.iptv.model.wallet.WalletItemObject;
import ir.resaneh1.iptv.model.wallet.WalletObject;
import ir.resaneh1.iptv.model.wallet.WalletTransactionObject;
import ir.resaneh1.iptv.presenter.MainClickHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.LocaleController;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.SendMessagesHelper;
import org.rbmain.messenger.UserConfig;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.tgnet.TLRPC$MessageMedia;
import org.rbmain.tgnet.TLRPC$ReplyMarkup;
import org.rbmain.tgnet.TLRPC$TL_messageMediaWallet;
import org.rbmain.tgnet.TLRPC$WebPage;
import org.rbmain.ui.ActionBar.AlertDialog;
import org.rbmain.ui.ActionBar.BaseFragment;
import org.rbmain.ui.Components.AlertsCreator;

/* loaded from: classes3.dex */
public class WalletController extends BaseController {
    private static final WalletController[] Instance = new WalletController[3];

    public interface LoadListener<T> {
        void onComplete(T t, Exception exc);
    }

    public WalletController(int i) {
        super(i);
    }

    public static WalletController getInstance(int i) {
        WalletController[] walletControllerArr = Instance;
        WalletController walletController = walletControllerArr[i];
        if (walletController == null) {
            synchronized (WalletController.class) {
                walletController = walletControllerArr[i];
                if (walletController == null) {
                    walletController = new WalletController(i);
                    walletControllerArr[i] = walletController;
                }
            }
        }
        return walletController;
    }

    public void getWalletTransferMessage(final MessageObject messageObject, final LoadListener<MessageObject> loadListener) {
        TLRPC$Message tLRPC$Message;
        if (messageObject != null && (tLRPC$Message = messageObject.messageOwner) != null) {
            TLRPC$MessageMedia tLRPC$MessageMedia = tLRPC$Message.media;
            if ((tLRPC$MessageMedia instanceof TLRPC$TL_messageMediaWallet) && ((TLRPC$TL_messageMediaWallet) tLRPC$MessageMedia).wallet_transfer_data != null && ((TLRPC$TL_messageMediaWallet) tLRPC$MessageMedia).wallet_transfer_data.transfer_id != null && ((TLRPC$TL_messageMediaWallet) tLRPC$MessageMedia).wallet_transfer_data.access_transfer != null) {
                CoreMainClass coreMainClass = getCoreMainClass();
                TLRPC$MessageMedia tLRPC$MessageMedia2 = messageObject.messageOwner.media;
                coreMainClass.getWalletTransferMessage(((TLRPC$TL_messageMediaWallet) tLRPC$MessageMedia2).wallet_transfer_data.transfer_id, ((TLRPC$TL_messageMediaWallet) tLRPC$MessageMedia2).wallet_transfer_data.access_transfer, new ir.aaap.messengercore.LoadListener<WalletTransferMessageObject>() { // from class: ir.appp.wallet.WalletController.1
                    @Override // ir.aaap.messengercore.LoadListener
                    public void onDidLoad(WalletTransferMessageObject walletTransferMessageObject) {
                        if (walletTransferMessageObject != null) {
                            ((TLRPC$TL_messageMediaWallet) messageObject.messageOwner.media).walletTransferMessageObject = MessageConverter.convertWalletTransferMessage(WalletController.this.getCoreMainClass(), walletTransferMessageObject);
                            MessageObject messageObject2 = messageObject;
                            messageObject2.forceUpdate = true;
                            LoadListener loadListener2 = loadListener;
                            if (loadListener2 != null) {
                                loadListener2.onComplete(messageObject2, null);
                                return;
                            }
                            return;
                        }
                        LoadListener loadListener3 = loadListener;
                        if (loadListener3 != null) {
                            loadListener3.onComplete(null, new Exception());
                        }
                    }

                    @Override // ir.aaap.messengercore.LoadListener
                    public void onError(Exception exc) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onComplete(null, new Exception(exc));
                        }
                    }
                });
                return;
            }
        }
        if (loadListener != null) {
            loadListener.onComplete(null, new Exception());
        }
    }

    public void updateCurrencies(final WalletObject walletObject, CompositeDisposable compositeDisposable, final LoadListener<WalletObject> loadListener) {
        if (compositeDisposable == null) {
            return;
        }
        compositeDisposable.add((Disposable) ApiRequestMessangerRx.getInstance(this.currentAccount).getCurrencies(new GetCurrenciesInput()).subscribeWith(new DisposableObserver<MessangerOutput<GetCurrenciesOutput>>(this) { // from class: ir.appp.wallet.WalletController.2
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<GetCurrenciesOutput> messangerOutput) {
                GetCurrenciesOutput getCurrenciesOutput;
                HashMap map = new HashMap();
                if (messangerOutput != null && (getCurrenciesOutput = messangerOutput.data) != null) {
                    Iterator<CurrencyObject> it = getCurrenciesOutput.currency_objects.iterator();
                    while (it.hasNext()) {
                        CurrencyObject next = it.next();
                        map.put(next.currency_code, next);
                    }
                }
                WalletObject walletObject2 = walletObject;
                if (walletObject2 != null) {
                    Iterator<WalletItemObject> it2 = walletObject2.wallet_items.iterator();
                    while (it2.hasNext()) {
                        WalletItemObject next2 = it2.next();
                        next2.currencyObject = (CurrencyObject) map.get(next2.currency_code);
                    }
                }
                loadListener.onComplete(walletObject, null);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                loadListener.onComplete(null, new Exception(th));
            }
        }));
    }

    public void getWalletStatus(CompositeDisposable compositeDisposable, final LoadListener<WalletObject> loadListener) {
        String myGuid = getCoreMainClass().getMyGuid();
        if (compositeDisposable != null) {
            final WalletObject[] walletObjectArr = new WalletObject[1];
            compositeDisposable.add((Disposable) ApiRequestMessangerRx.getInstance(this.currentAccount).getWalletStatus(new GetWalletStatusInput(myGuid)).flatMap(new Function<MessangerOutput<GetWalletStatusOutput>, Observable<MessangerOutput<GetCurrenciesOutput>>>() { // from class: ir.appp.wallet.WalletController.4
                @Override // io.reactivex.functions.Function
                public Observable<MessangerOutput<GetCurrenciesOutput>> apply(final MessangerOutput<GetWalletStatusOutput> messangerOutput) throws Exception {
                    return ApiRequestMessangerRx.getInstance(((BaseController) WalletController.this).currentAccount).getCurrencies(new GetCurrenciesInput()).observeOn(Schedulers.io()).doOnNext(new Consumer<MessangerOutput<GetCurrenciesOutput>>() { // from class: ir.appp.wallet.WalletController.4.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // io.reactivex.functions.Consumer
                        public void accept(MessangerOutput<GetCurrenciesOutput> messangerOutput2) throws Exception {
                            T t;
                            GetCurrenciesOutput getCurrenciesOutput;
                            HashMap map = new HashMap();
                            if (messangerOutput2 != null && (getCurrenciesOutput = messangerOutput2.data) != null) {
                                Iterator<CurrencyObject> it = getCurrenciesOutput.currency_objects.iterator();
                                while (it.hasNext()) {
                                    CurrencyObject next = it.next();
                                    map.put(next.currency_code, next);
                                }
                            }
                            MessangerOutput messangerOutput3 = messangerOutput;
                            if (messangerOutput3 != null && (t = messangerOutput3.data) != 0 && ((GetWalletStatusOutput) t).wallet != null) {
                                Iterator<WalletItemObject> it2 = ((GetWalletStatusOutput) t).wallet.wallet_items.iterator();
                                while (it2.hasNext()) {
                                    WalletItemObject next2 = it2.next();
                                    next2.currencyObject = (CurrencyObject) map.get(next2.currency_code);
                                }
                            }
                            walletObjectArr[0] = ((GetWalletStatusOutput) messangerOutput.data).wallet;
                        }
                    });
                }
            }).observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<MessangerOutput<GetCurrenciesOutput>>(this) { // from class: ir.appp.wallet.WalletController.3
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput<GetCurrenciesOutput> messangerOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onComplete(walletObjectArr[0], null);
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onComplete(null, new Exception(th));
                    }
                }
            }));
        } else if (loadListener != null) {
            loadListener.onComplete(null, new Exception());
        }
    }

    public void getWalletTransactions(String str, String str2, CompositeDisposable compositeDisposable, final LoadListener<GetWalletTransactionsOutput> loadListener) {
        String myGuid = getCoreMainClass().getMyGuid();
        if (compositeDisposable == null) {
            if (loadListener != null) {
                loadListener.onComplete(null, new Exception());
                return;
            }
            return;
        }
        GetWalletTransactionsInput getWalletTransactionsInput = new GetWalletTransactionsInput();
        getWalletTransactionsInput.currency_code = str;
        getWalletTransactionsInput.wallet_id = myGuid;
        if (str2 == null || str2.isEmpty()) {
            str2 = null;
        }
        getWalletTransactionsInput.start_id = str2;
        compositeDisposable.add((Disposable) ApiRequestMessangerRx.getInstance(this.currentAccount).getWalletTransactions(getWalletTransactionsInput).subscribeWith(new DisposableObserver<MessangerOutput<GetWalletTransactionsOutput>>(this) { // from class: ir.appp.wallet.WalletController.5
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<GetWalletTransactionsOutput> messangerOutput) {
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onComplete(messangerOutput.data, null);
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onComplete(null, new Exception(th));
                }
            }
        }));
    }

    public void checkAllowReceive(String str, CompositeDisposable compositeDisposable, final LoadListener<CheckAllowReceiveOutput> loadListener) {
        if (compositeDisposable != null && str != null) {
            compositeDisposable.add((Disposable) ApiRequestMessangerRx.getInstance(this.currentAccount).checkAllowReceive(new CheckAllowReceiveInput(str)).subscribeWith(new DisposableObserver<MessangerOutput<CheckAllowReceiveOutput>>(this) { // from class: ir.appp.wallet.WalletController.6
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput<CheckAllowReceiveOutput> messangerOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onComplete(messangerOutput.data, null);
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onComplete(null, new Exception(th));
                    }
                }
            }));
        } else if (loadListener != null) {
            loadListener.onComplete(null, new Exception());
        }
    }

    public void chargeWalletByToken(String str, CompositeDisposable compositeDisposable, final LoadListener<ChargeWalletByTokenOutput> loadListener) {
        String myGuid = getCoreMainClass().getMyGuid();
        if (compositeDisposable != null && myGuid != null && str != null) {
            compositeDisposable.add((Disposable) ApiRequestMessangerRx.getInstance(this.currentAccount).chargeWalletByToken(new ChargeWalletByTokenInput(myGuid, NumberUtils.toEnglish(str))).subscribeWith(new DisposableObserver<MessangerOutput<ChargeWalletByTokenOutput>>(this) { // from class: ir.appp.wallet.WalletController.7
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput<ChargeWalletByTokenOutput> messangerOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onComplete(messangerOutput.data, null);
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onComplete(null, new Exception(th));
                    }
                }
            }));
        } else if (loadListener != null) {
            loadListener.onComplete(null, new Exception());
        }
    }

    public void transferCredit(String str, final ChatAbsObject chatAbsObject, ArrayList<CreditObject> arrayList, String str2, String str3, CompositeDisposable compositeDisposable, final LoadListener<TransferCreditOutput> loadListener) {
        if (compositeDisposable == null || str == null || chatAbsObject == null) {
            if (loadListener != null) {
                loadListener.onComplete(null, new Exception());
                return;
            }
            return;
        }
        TransferCreditInput transferCreditInput = new TransferCreditInput();
        transferCreditInput.sender_wallet_id = str;
        transferCreditInput.receiver_wallet_id = chatAbsObject.object_guid;
        transferCreditInput.credits = arrayList;
        transferCreditInput.local_transaction_id = str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = null;
        }
        transferCreditInput.description = str3;
        compositeDisposable.add((Disposable) ApiRequestMessangerRx.getInstance(this.currentAccount).transferCredit(transferCreditInput).subscribeWith(new DisposableObserver<MessangerOutput<TransferCreditOutput>>() { // from class: ir.appp.wallet.WalletController.8
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<TransferCreditOutput> messangerOutput) {
                TransferCreditOutput transferCreditOutput = messangerOutput.data;
                if (transferCreditOutput != null && transferCreditOutput.status == TransferCreditOutput.TransferCreditStatusEnum.OK) {
                    WalletController.this.onTransferSuccess(chatAbsObject, transferCreditOutput.wallet_transaction);
                }
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onComplete(messangerOutput.data, null);
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onComplete(null, new Exception(th));
                }
            }
        }));
    }

    public void cashOut(String str, String str2, CompositeDisposable compositeDisposable, final LoadListener<CashOutOutput> loadListener) {
        String myGuid = getCoreMainClass().getMyGuid();
        if (compositeDisposable == null || myGuid == null || str2 == null) {
            if (loadListener != null) {
                loadListener.onComplete(null, new Exception());
                return;
            }
            return;
        }
        CashOutInput cashOutInput = new CashOutInput();
        cashOutInput.wallet_id = myGuid;
        cashOutInput.amount = NumberUtils.toEnglish(str2.replaceAll(",", BuildConfig.FLAVOR));
        cashOutInput.local_transaction_id = AndroidUtilities.getNextRnd() + BuildConfig.FLAVOR;
        if (str == null || str.isEmpty()) {
            str = null;
        }
        cashOutInput.currency_code = str;
        compositeDisposable.add((Disposable) ApiRequestMessangerRx.getInstance(this.currentAccount).cashOut(cashOutInput).subscribeWith(new DisposableObserver<MessangerOutput<CashOutOutput>>(this) { // from class: ir.appp.wallet.WalletController.9
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<CashOutOutput> messangerOutput) {
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onComplete(messangerOutput.data, null);
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onComplete(null, new Exception(th));
                }
            }
        }));
    }

    public void shareWalletLink() {
        if (ApplicationLoader.applicationActivity == null) {
            return;
        }
        ApplicationLoader.applicationActivity.mainCompositeDisposable.add((Disposable) ApiRequestMessangerRx.getInstance(this.currentAccount).getWalletShareLink(new GetWalletShareLinkInput(getCoreMainClass().getMyGuid())).subscribeWith(new DisposableObserver<MessangerOutput<GetWalletShareLinkOutput>>() { // from class: ir.appp.wallet.WalletController.10
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<GetWalletShareLinkOutput> messangerOutput) {
                GetWalletShareLinkOutput getWalletShareLinkOutput;
                if (ApplicationLoader.applicationActivity == null || (getWalletShareLinkOutput = messangerOutput.data) == null || getWalletShareLinkOutput.share_url == null) {
                    return;
                }
                new MainClickHandler().shareStringOrLink(ApplicationLoader.applicationActivity, messangerOutput.data.share_url);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                if (ApplicationLoader.applicationActivity != null) {
                    WalletController.this.showAlertDialog(LocaleController.getString("wallet_retry", R.string.wallet_retry), ApplicationLoader.applicationActivity.getLastFragment());
                }
            }
        }));
    }

    public void getWalletByShareLink(String str, BaseFragment baseFragment) {
        if (ApplicationLoader.applicationActivity == null || baseFragment == null) {
            return;
        }
        GetWalletByShareLinkInput getWalletByShareLinkInput = new GetWalletByShareLinkInput(str);
        AlertDialog alertDialog = new AlertDialog(baseFragment.getContext(), 3);
        alertDialog.show();
        ApplicationLoader.applicationActivity.mainCompositeDisposable.add((Disposable) ApiRequestMessangerRx.getInstance(this.currentAccount).getWalletByShareLink(getWalletByShareLinkInput).subscribeWith(new AnonymousClass11(alertDialog, baseFragment)));
    }

    /* renamed from: ir.appp.wallet.WalletController$11, reason: invalid class name */
    class AnonymousClass11 extends DisposableObserver<MessangerOutput<GetWalletByShareLinkOutput>> {
        final /* synthetic */ BaseFragment val$baseFragment;
        final /* synthetic */ AlertDialog val$loadingDialog;

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        AnonymousClass11(AlertDialog alertDialog, BaseFragment baseFragment) {
            this.val$loadingDialog = alertDialog;
            this.val$baseFragment = baseFragment;
        }

        @Override // io.reactivex.Observer
        public void onNext(MessangerOutput<GetWalletByShareLinkOutput> messangerOutput) {
            if (ApplicationLoader.applicationActivity == null) {
                this.val$loadingDialog.dismiss();
                return;
            }
            GetWalletByShareLinkOutput getWalletByShareLinkOutput = messangerOutput.data;
            if (getWalletByShareLinkOutput != null) {
                if (getWalletByShareLinkOutput.is_valid && getWalletByShareLinkOutput.allow_receive && getWalletByShareLinkOutput.wallet_id != null) {
                    WalletController.this.getCoreMainClass().getChatAbs(messangerOutput.data.wallet_id, new AnonymousClass1(messangerOutput));
                    return;
                }
                this.val$loadingDialog.dismiss();
                GetWalletByShareLinkOutput getWalletByShareLinkOutput2 = messangerOutput.data;
                if (!getWalletByShareLinkOutput2.is_valid) {
                    WalletController.this.showAlertDialog(LocaleController.getString("WalletByShareLinkError", R.string.WalletByShareLinkError), this.val$baseFragment);
                } else {
                    if (getWalletByShareLinkOutput2.allow_receive) {
                        return;
                    }
                    WalletController.this.showAlertDialog(LocaleController.getString("WalletTransferError", R.string.WalletTransferError), this.val$baseFragment);
                }
            }
        }

        /* renamed from: ir.appp.wallet.WalletController$11$1, reason: invalid class name */
        class AnonymousClass1 implements ir.aaap.messengercore.LoadListener<ChatAbsObject> {
            final /* synthetic */ MessangerOutput val$output;

            AnonymousClass1(MessangerOutput messangerOutput) {
                this.val$output = messangerOutput;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(final ChatAbsObject chatAbsObject) {
                AnonymousClass11.this.val$loadingDialog.dismiss();
                if (chatAbsObject == null) {
                    WalletController.this.showAlertDialog(LocaleController.getString("wallet_retry", R.string.wallet_retry), AnonymousClass11.this.val$baseFragment);
                    return;
                }
                ViewCreator.Companion companion = ViewCreator.Companion;
                Context context = AnonymousClass11.this.val$baseFragment.getContext();
                final MessangerOutput messangerOutput = this.val$output;
                String str = ((GetWalletByShareLinkOutput) messangerOutput.data).default_currency_title;
                AnonymousClass11 anonymousClass11 = AnonymousClass11.this;
                final BaseFragment baseFragment = anonymousClass11.val$baseFragment;
                final AlertDialog alertDialog = anonymousClass11.val$loadingDialog;
                companion.initTransferBottomSheet(context, chatAbsObject, str, new WalletTransferListener() { // from class: ir.appp.wallet.WalletController$11$1$$ExternalSyntheticLambda0
                    @Override // ir.appp.wallet.interfaces.WalletTransferListener
                    public final void transfer(BottomSheetDialog bottomSheetDialog, String str2, String str3) {
                        this.f$0.lambda$onDidLoad$1(baseFragment, messangerOutput, chatAbsObject, alertDialog, bottomSheetDialog, str2, str3);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            public /* synthetic */ void lambda$onDidLoad$1(final BaseFragment baseFragment, MessangerOutput messangerOutput, final ChatAbsObject chatAbsObject, final AlertDialog alertDialog, final BottomSheetDialog bottomSheetDialog, final String str, final String str2) {
                String str3;
                if (ApplicationLoader.applicationActivity == null) {
                    return;
                }
                Context context = baseFragment.getContext();
                Object[] objArr = new Object[2];
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                if (((GetWalletByShareLinkOutput) messangerOutput.data).default_currency_title != null) {
                    str3 = " " + ((GetWalletByShareLinkOutput) messangerOutput.data).default_currency_title;
                } else {
                    str3 = BuildConfig.FLAVOR;
                }
                sb.append(str3);
                objArr[0] = sb.toString();
                objArr[1] = WalletController.getChatAbsTitle(chatAbsObject);
                AlertsCreator.showAskAlert(context, LocaleController.formatString(R.string.confirm_transfer_question, objArr).toString(), new AlertsCreator.AskAlertDelegate() { // from class: ir.appp.wallet.WalletController$11$1$$ExternalSyntheticLambda1
                    @Override // org.rbmain.ui.Components.AlertsCreator.AskAlertDelegate
                    public final void onAccepted() {
                        this.f$0.lambda$onDidLoad$0(str, alertDialog, chatAbsObject, str2, baseFragment, bottomSheetDialog);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onDidLoad$0(String str, final AlertDialog alertDialog, ChatAbsObject chatAbsObject, String str2, final BaseFragment baseFragment, final BottomSheetDialog bottomSheetDialog) {
                String myGuid = WalletController.this.getCoreMainClass().getMyGuid();
                CreditObject creditObject = new CreditObject();
                creditObject.amount = NumberUtils.toEnglish(str.replaceAll(",", BuildConfig.FLAVOR));
                int nextRnd = AndroidUtilities.getNextRnd();
                ArrayList<CreditObject> arrayList = new ArrayList<>();
                arrayList.add(creditObject);
                alertDialog.show();
                WalletController.this.transferCredit(myGuid, chatAbsObject, arrayList, nextRnd + BuildConfig.FLAVOR, str2, ApplicationLoader.applicationActivity.mainCompositeDisposable, new LoadListener<TransferCreditOutput>() { // from class: ir.appp.wallet.WalletController.11.1.1
                    @Override // ir.appp.wallet.WalletController.LoadListener
                    public void onComplete(TransferCreditOutput transferCreditOutput, Exception exc) {
                        String string;
                        alertDialog.dismiss();
                        if (exc != null) {
                            WalletController.this.showAlertDialog(LocaleController.getString("wallet_retry", R.string.wallet_retry), baseFragment);
                        } else {
                            TransferCreditOutput.TransferCreditStatusEnum transferCreditStatusEnum = transferCreditOutput.status;
                            if (transferCreditStatusEnum == TransferCreditOutput.TransferCreditStatusEnum.OK) {
                                string = LocaleController.getString("wallet_transfer_success", R.string.wallet_transfer_success);
                            } else if (transferCreditStatusEnum == TransferCreditOutput.TransferCreditStatusEnum.NotSufficientAmount) {
                                string = LocaleController.getString("wallet_transfer_not_sufficent_amount", R.string.wallet_transfer_not_sufficent_amount);
                            } else if (transferCreditStatusEnum == TransferCreditOutput.TransferCreditStatusEnum.TransferError) {
                                string = LocaleController.getString("wallet_transfer_error", R.string.wallet_transfer_error);
                            } else {
                                string = transferCreditStatusEnum == TransferCreditOutput.TransferCreditStatusEnum.DupLocalID ? LocaleController.getString("wallet_transfer_dupLocal_ID", R.string.wallet_transfer_dupLocal_ID) : BuildConfig.FLAVOR;
                            }
                            WalletController.this.showAlertDialog(string, baseFragment);
                        }
                        bottomSheetDialog.dismiss();
                    }
                });
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                AnonymousClass11.this.val$loadingDialog.dismiss();
                WalletController.this.showAlertDialog(LocaleController.getString("wallet_retry", R.string.wallet_retry), AnonymousClass11.this.val$baseFragment);
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.val$loadingDialog.dismiss();
            WalletController.this.showAlertDialog(LocaleController.getString("wallet_retry", R.string.wallet_retry), this.val$baseFragment);
        }
    }

    public ChatAbsObject getChatAbs(String str) {
        return getCoreMainClass().getAbsInstant(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTransferSuccess(ChatAbsObject chatAbsObject, WalletTransactionObject walletTransactionObject) {
        if (chatAbsObject == null || walletTransactionObject == null) {
            return;
        }
        WalletTransactionObject.TransactionTypeEnum transactionTypeEnum = walletTransactionObject.type;
        if (transactionTypeEnum == WalletTransactionObject.TransactionTypeEnum.Send || transactionTypeEnum == WalletTransactionObject.TransactionTypeEnum.Receive) {
            WalletTransferDataObject walletTransferDataObject = new WalletTransferDataObject();
            walletTransferDataObject.access_transfer = walletTransactionObject.access_transfer;
            walletTransferDataObject.transfer_id = walletTransactionObject.transfer_id;
            new ArrayList().add(walletTransferDataObject);
            sendWalletTransactionMessage(chatAbsObject, walletTransferDataObject);
        }
    }

    public static TLObject convertChatAbsToTlObject(ChatAbsObject chatAbsObject) {
        return ChatConverter.convertChatAbsToTlObject(ServiceLocator.getInstance(UserConfig.selectedAccount).getCoreMainClass(), chatAbsObject);
    }

    public static String getChatAbsTitle(ChatAbsObject chatAbsObject) {
        String str = BuildConfig.FLAVOR;
        if (chatAbsObject == null) {
            return BuildConfig.FLAVOR;
        }
        String str2 = chatAbsObject.title;
        if (str2 != null && !str2.isEmpty()) {
            return chatAbsObject.title;
        }
        if (chatAbsObject.is_deleted) {
            return LocaleController.getString("HiddenName", R.string.HiddenName);
        }
        String str3 = chatAbsObject.first_name;
        String str4 = chatAbsObject.last_name;
        if (str3 == null) {
            str3 = BuildConfig.FLAVOR;
        }
        if (str4 != null) {
            str = str4;
        }
        if (str3.isEmpty() && str.isEmpty()) {
            return LocaleController.getString("UnknownName", R.string.UnknownName);
        }
        return UserInfo.formatName(str3, str);
    }

    public void sendWalletTransactionMessage(ChatAbsObject chatAbsObject, WalletTransferDataObject walletTransferDataObject) {
        if (chatAbsObject == null || walletTransferDataObject == null) {
            return;
        }
        long dialogId = ChatConverter.getDialogId(chatAbsObject.object_guid, chatAbsObject.type);
        try {
            try {
                SendMessagesHelper.getInstance(this.currentAccount).sendMessage((TLRPC$TL_messageMediaWallet) MessageConverter.convertToTLWallet(walletTransferDataObject), dialogId, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, true, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
        }
    }

    public void checkToTransfer(String str, final String str2, final String str3, final CompositeDisposable compositeDisposable, final BaseFragment baseFragment, final LoadListener<WalletObject> loadListener) {
        if (baseFragment == null) {
            return;
        }
        final ChatAbsObject chatAbs = getChatAbs(str);
        final AlertDialog alertDialog = new AlertDialog(baseFragment.getContext(), 3);
        alertDialog.show();
        checkAllowReceive(str, compositeDisposable, new LoadListener() { // from class: ir.appp.wallet.WalletController$$ExternalSyntheticLambda0
            @Override // ir.appp.wallet.WalletController.LoadListener
            public final void onComplete(Object obj, Exception exc) {
                this.f$0.lambda$checkToTransfer$4(alertDialog, chatAbs, baseFragment, str3, str2, compositeDisposable, loadListener, (CheckAllowReceiveOutput) obj, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkToTransfer$4(final AlertDialog alertDialog, final ChatAbsObject chatAbsObject, final BaseFragment baseFragment, final String str, final String str2, final CompositeDisposable compositeDisposable, final LoadListener loadListener, final CheckAllowReceiveOutput checkAllowReceiveOutput, final Exception exc) {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.appp.wallet.WalletController$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$checkToTransfer$3(alertDialog, exc, checkAllowReceiveOutput, chatAbsObject, baseFragment, str, str2, compositeDisposable, loadListener);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkToTransfer$3(final AlertDialog alertDialog, Exception exc, CheckAllowReceiveOutput checkAllowReceiveOutput, final ChatAbsObject chatAbsObject, final BaseFragment baseFragment, final String str, final String str2, final CompositeDisposable compositeDisposable, final LoadListener loadListener) {
        alertDialog.dismiss();
        if (exc == null) {
            if (!checkAllowReceiveOutput.allow_receive) {
                showAlertDialog(LocaleController.getString("WalletTransferError", R.string.WalletTransferError), baseFragment);
                return;
            } else {
                if (chatAbsObject != null) {
                    ViewCreator.Companion.initTransferBottomSheet(baseFragment.getContext(), chatAbsObject, str, new WalletTransferListener() { // from class: ir.appp.wallet.WalletController$$ExternalSyntheticLambda3
                        @Override // ir.appp.wallet.interfaces.WalletTransferListener
                        public final void transfer(BottomSheetDialog bottomSheetDialog, String str3, String str4) {
                            this.f$0.lambda$checkToTransfer$2(baseFragment, str, chatAbsObject, str2, alertDialog, compositeDisposable, loadListener, bottomSheetDialog, str3, str4);
                        }
                    });
                    return;
                }
                return;
            }
        }
        showAlertDialog(LocaleController.getString("wallet_retry", R.string.wallet_retry), baseFragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkToTransfer$2(final BaseFragment baseFragment, String str, final ChatAbsObject chatAbsObject, final String str2, final AlertDialog alertDialog, final CompositeDisposable compositeDisposable, final LoadListener loadListener, final BottomSheetDialog bottomSheetDialog, final String str3, final String str4) {
        AlertsCreator.showAskAlert(baseFragment.getContext(), LocaleController.formatString(R.string.confirm_transfer_question, str3 + " " + str, getChatAbsTitle(chatAbsObject)).toString(), new AlertsCreator.AskAlertDelegate() { // from class: ir.appp.wallet.WalletController$$ExternalSyntheticLambda5
            @Override // org.rbmain.ui.Components.AlertsCreator.AskAlertDelegate
            public final void onAccepted() {
                this.f$0.lambda$checkToTransfer$1(str3, str2, alertDialog, chatAbsObject, str4, compositeDisposable, baseFragment, loadListener, bottomSheetDialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkToTransfer$1(String str, String str2, final AlertDialog alertDialog, ChatAbsObject chatAbsObject, String str3, CompositeDisposable compositeDisposable, final BaseFragment baseFragment, final LoadListener loadListener, final BottomSheetDialog bottomSheetDialog) {
        String myGuid = getCoreMainClass().getMyGuid();
        CreditObject creditObject = new CreditObject();
        creditObject.amount = NumberUtils.toEnglish(str.replaceAll(",", BuildConfig.FLAVOR));
        if (str2 != null && !str2.isEmpty()) {
            creditObject.currency_code = str2;
        }
        int nextRnd = AndroidUtilities.getNextRnd();
        ArrayList<CreditObject> arrayList = new ArrayList<>();
        arrayList.add(creditObject);
        alertDialog.show();
        transferCredit(myGuid, chatAbsObject, arrayList, nextRnd + BuildConfig.FLAVOR, str3, compositeDisposable, new LoadListener() { // from class: ir.appp.wallet.WalletController$$ExternalSyntheticLambda2
            @Override // ir.appp.wallet.WalletController.LoadListener
            public final void onComplete(Object obj, Exception exc) {
                this.f$0.lambda$checkToTransfer$0(alertDialog, baseFragment, loadListener, bottomSheetDialog, (TransferCreditOutput) obj, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkToTransfer$0(AlertDialog alertDialog, BaseFragment baseFragment, LoadListener loadListener, BottomSheetDialog bottomSheetDialog, TransferCreditOutput transferCreditOutput, Exception exc) {
        WalletObject walletObject;
        String string;
        String string2;
        boolean z;
        alertDialog.dismiss();
        boolean z2 = false;
        if (exc == null) {
            TransferCreditOutput.TransferCreditStatusEnum transferCreditStatusEnum = transferCreditOutput.status;
            if (transferCreditStatusEnum == TransferCreditOutput.TransferCreditStatusEnum.OK) {
                string2 = LocaleController.getString("wallet_transfer_success", R.string.wallet_transfer_success);
                z = true;
            } else {
                if (transferCreditStatusEnum == TransferCreditOutput.TransferCreditStatusEnum.NotSufficientAmount) {
                    string = LocaleController.getString("wallet_transfer_not_sufficent_amount", R.string.wallet_transfer_not_sufficent_amount);
                } else if (transferCreditStatusEnum == TransferCreditOutput.TransferCreditStatusEnum.TransferError) {
                    string = LocaleController.getString("wallet_transfer_error", R.string.wallet_transfer_error);
                } else {
                    string = transferCreditStatusEnum == TransferCreditOutput.TransferCreditStatusEnum.DupLocalID ? LocaleController.getString("wallet_transfer_dupLocal_ID", R.string.wallet_transfer_dupLocal_ID) : BuildConfig.FLAVOR;
                }
                string2 = string;
                z = false;
            }
            showAlertDialog(string2, baseFragment);
            z2 = z;
        }
        if (loadListener != null && transferCreditOutput != null && (walletObject = transferCreditOutput.wallet) != null) {
            loadListener.onComplete(walletObject, null);
        }
        if (z2) {
            bottomSheetDialog.dismiss();
        }
    }

    public void openShareDialogToSendWalletTransactionMessage(BaseFragment baseFragment, WalletTransactionObject walletTransactionObject) {
        if (walletTransactionObject == null || TextUtils.isEmpty(walletTransactionObject.access_transfer) || TextUtils.isEmpty(walletTransactionObject.transaction_id)) {
            return;
        }
        WalletTransferDataObject walletTransferDataObject = new WalletTransferDataObject();
        walletTransferDataObject.access_transfer = walletTransactionObject.access_transfer;
        walletTransferDataObject.transfer_id = walletTransactionObject.transfer_id;
        TLRPC$TL_messageMediaWallet tLRPC$TL_messageMediaWallet = new TLRPC$TL_messageMediaWallet();
        tLRPC$TL_messageMediaWallet.wallet_transfer_data = walletTransferDataObject;
        baseFragment.showDialog(new WalletShareAlert(baseFragment.getContext(), tLRPC$TL_messageMediaWallet, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAlertDialog(String str, BaseFragment baseFragment) {
        if (baseFragment == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(baseFragment.getContext());
        builder.setMessage(str);
        builder.setPositiveButton(LocaleController.getString("OK", R.string.OK), null);
        builder.setTitle(LocaleController.getString("AppName", R.string.AppName));
        baseFragment.showDialog(builder.create());
    }

    public void chargeWalletByUrl(final BaseFragment baseFragment, String str, String str2, CompositeDisposable compositeDisposable, final LoadListener<ChargeWalletByUrlOutput.Status> loadListener) {
        if (baseFragment == null || ApplicationLoader.applicationActivity == null) {
            return;
        }
        CreditObject creditObject = new CreditObject();
        creditObject.amount = NumberUtils.toEnglish(str.replaceAll(",", BuildConfig.FLAVOR));
        if (!TextUtils.isEmpty(str2)) {
            creditObject.currency_code = str2;
        }
        final AlertDialog alertDialog = new AlertDialog(baseFragment.getContext(), 3);
        alertDialog.show();
        chargeWalletByUrl(new ArrayList<>(Collections.singleton(creditObject)), compositeDisposable, new LoadListener() { // from class: ir.appp.wallet.WalletController$$ExternalSyntheticLambda1
            @Override // ir.appp.wallet.WalletController.LoadListener
            public final void onComplete(Object obj, Exception exc) {
                this.f$0.lambda$chargeWalletByUrl$5(alertDialog, loadListener, baseFragment, (ChargeWalletByUrlOutput) obj, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$chargeWalletByUrl$5(AlertDialog alertDialog, LoadListener loadListener, BaseFragment baseFragment, ChargeWalletByUrlOutput chargeWalletByUrlOutput, Exception exc) {
        alertDialog.dismiss();
        if (exc != null) {
            loadListener.onComplete(null, exc);
            return;
        }
        if (chargeWalletByUrlOutput != null) {
            ChargeWalletByUrlOutput.Status status = chargeWalletByUrlOutput.status;
            if (status == ChargeWalletByUrlOutput.Status.OK) {
                if (ApplicationLoader.applicationActivity != null) {
                    openUrl(chargeWalletByUrlOutput.url, ApplicationLoader.applicationActivity);
                }
            } else if (status == ChargeWalletByUrlOutput.Status.ChargeError || status == ChargeWalletByUrlOutput.Status.DupLocalID) {
                showAlertDialog(LocaleController.getString(R.string.wallet_charge_error), baseFragment);
            }
            loadListener.onComplete(chargeWalletByUrlOutput.status, null);
        }
    }

    private void openUrl(String str, Context context) {
        if (Browser.openUrl(context, Uri.parse(str))) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(Intent.createChooser(intent, LocaleController.getString(R.string.OpenWith)));
        }
    }

    private void chargeWalletByUrl(ArrayList<CreditObject> arrayList, CompositeDisposable compositeDisposable, final LoadListener<ChargeWalletByUrlOutput> loadListener) {
        String myGuid = getCoreMainClass().getMyGuid();
        if (compositeDisposable == null || TextUtils.isEmpty(myGuid) || arrayList == null || arrayList.isEmpty()) {
            if (loadListener != null) {
                loadListener.onComplete(null, new Exception());
                return;
            }
            return;
        }
        ChargeWalletByUrlInput chargeWalletByUrlInput = new ChargeWalletByUrlInput();
        chargeWalletByUrlInput.wallet_id = myGuid;
        chargeWalletByUrlInput.credits = arrayList;
        chargeWalletByUrlInput.local_transaction_id = AndroidUtilities.getNextRnd() + BuildConfig.FLAVOR;
        compositeDisposable.add((Disposable) ApiRequestMessangerRx.getInstance(this.currentAccount).chargeWalletByUrl(chargeWalletByUrlInput).subscribeWith(new DisposableObserver<MessangerOutput<ChargeWalletByUrlOutput>>(this) { // from class: ir.appp.wallet.WalletController.12
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<ChargeWalletByUrlOutput> messangerOutput) {
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onComplete(messangerOutput.data, null);
                }
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                LoadListener loadListener2 = loadListener;
                if (loadListener2 != null) {
                    loadListener2.onComplete(null, new Exception(th));
                }
            }
        }));
    }
}
