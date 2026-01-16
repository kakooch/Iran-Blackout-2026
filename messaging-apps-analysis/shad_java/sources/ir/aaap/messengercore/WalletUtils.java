package ir.aaap.messengercore;

import ir.aaap.messengercore.model.WalletTransferMessageObject;
import ir.aaap.messengercore.model.api.GetWalletTransactionMessageInput;
import ir.aaap.messengercore.model.api.GetWalletTransactionMessageOutput;
import ir.aaap.messengercore.network.ApiServerException;
import ir.aaap.messengercore.network.NetworkHelper;
import ir.aaap.messengercore.network.RetryObject;
import ir.aaap.messengercore.utilites.CoreLog;

/* loaded from: classes3.dex */
public class WalletUtils {
    private CoreLog coreLog;

    public WalletUtils(CoreLog coreLog) {
        this.coreLog = coreLog;
    }

    public int getWalletTransferMessage(String str, String str2, String str3, NetworkHelper networkHelper, final LoadListener<WalletTransferMessageObject> loadListener) {
        try {
            return networkHelper.getWalletTransferMessage(str3, new GetWalletTransactionMessageInput(str, str2), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetWalletTransactionMessageOutput>(this) { // from class: ir.aaap.messengercore.WalletUtils.1
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetWalletTransactionMessageOutput getWalletTransactionMessageOutput) {
                    if (getWalletTransactionMessageOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(getWalletTransactionMessageOutput.wallet_transfer_message);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(new Exception(exc));
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(new Exception(e));
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }
}
