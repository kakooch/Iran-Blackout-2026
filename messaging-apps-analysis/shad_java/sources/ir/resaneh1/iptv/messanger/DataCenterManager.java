package ir.resaneh1.iptv.messanger;

import androidMessenger.utilites.AppFavorUtils;
import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ir.resaneh1.iptv.helper.AppPreferences;
import ir.resaneh1.iptv.logger.MyLog;
import ir.resaneh1.iptv.model.GetDcsOutput;
import java.util.ArrayList;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.UserConfig;
import org.rbmain.messenger.Utilities;

/* loaded from: classes3.dex */
public class DataCenterManager extends BaseController {
    private static final DataCenterManager[] Instance = new DataCenterManager[3];
    public int apiCounter;
    private DisposableObserver<Integer> getDcsObservableLocal;
    GetDcsOutput getDcsOutput;

    public static DataCenterManager getInstance(int i) {
        DataCenterManager[] dataCenterManagerArr = Instance;
        DataCenterManager dataCenterManager = dataCenterManagerArr[i];
        if (dataCenterManager == null) {
            synchronized (DataCenterManager.class) {
                dataCenterManager = dataCenterManagerArr[i];
                if (dataCenterManager == null) {
                    dataCenterManager = new DataCenterManager(i);
                    dataCenterManagerArr[i] = dataCenterManager;
                }
            }
        }
        return dataCenterManager;
    }

    public static DataCenterManager getInstance() {
        return getInstance(UserConfig.selectedAccount);
    }

    private DataCenterManager(int i) {
        super(i);
        this.apiCounter = 0;
    }

    public void increastApiCouner() {
        this.apiCounter++;
    }

    public String getApiUrl() {
        ArrayList<String> arrayList;
        setDcsObjectFromAppPrefrencesIfNeeeded();
        if (MyLog.isDebugAble) {
            return "https://shadmessenger2.iranlms.ir";
        }
        GetDcsOutput getDcsOutput = this.getDcsOutput;
        if (getDcsOutput != null && (arrayList = getDcsOutput.default_api_urls) != null && arrayList.size() > 0) {
            ArrayList<String> arrayList2 = this.getDcsOutput.default_api_urls;
            return arrayList2.get(this.apiCounter % arrayList2.size());
        }
        ArrayList<String> arrayList3 = AppFavorUtils.MESSENGER_URL_DEFAULT;
        return arrayList3.get(Utilities.random.nextInt(arrayList3.size()));
    }

    public void setDcsObjectFromAppPrefrencesIfNeeeded() {
        if (this.getDcsOutput != null) {
            return;
        }
        DisposableObserver<Integer> disposableObserver = this.getDcsObservableLocal;
        if (disposableObserver == null || disposableObserver.isDisposed()) {
            this.getDcsObservableLocal = (DisposableObserver) Observable.just(0).observeOn(Schedulers.io()).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.messanger.DataCenterManager.1
                @Override // io.reactivex.Observer
                public void onNext(Integer num) {
                    String string = DataCenterManager.this.getAppPreferences().getString(AppPreferences.Key.getDataCenterOutputObject);
                    if (string == null || string.isEmpty()) {
                        return;
                    }
                    try {
                        DataCenterManager.this.getDcsOutput = (GetDcsOutput) ApplicationLoader.getGson().fromJson(string, GetDcsOutput.class);
                        DataCenterManager.this.getApiRequestMessangerRx().setRestApiService();
                    } catch (Exception unused) {
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    if (DataCenterManager.this.getDcsObservableLocal != null) {
                        DataCenterManager.this.getDcsObservableLocal.dispose();
                    }
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    if (DataCenterManager.this.getDcsObservableLocal != null) {
                        DataCenterManager.this.getDcsObservableLocal.dispose();
                    }
                }
            });
        }
    }
}
