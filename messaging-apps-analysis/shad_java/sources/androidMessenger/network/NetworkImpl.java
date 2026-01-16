package androidMessenger.network;

import androidMessenger.model.MessangerInput2;
import androidMessenger.model.MessangerOutput2;
import androidMessenger.utilites.AppFavorUtils;
import androidMessenger.utilites.MyLog;
import io.github.inflationx.calligraphy3.BuildConfig;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ir.aaap.messengercore.network.ApiServerException;
import ir.aaap.messengercore.network.Network;
import ir.aaap.messengercore.network.NetworkHelper;
import ir.aaap.messengercore.network.RetryObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import org.rbmain.messenger.Utilities;
import retrofit2.Response;

/* loaded from: classes.dex */
public class NetworkImpl implements Network {
    static RxHelper rxHelper = new RxHelper();
    private CompositeDisposable compositeDisposable;
    private int currentAccount;
    public Network.NetworkErrorListener networkErrorListener;
    private NetworkHelper.VersionEncryptionHelper versionEncryptionHelper;
    Map<Integer, DisposableObserver<Response<ResponseBody>>> disposableMap = new HashMap();
    private AtomicInteger networkReqNumber = new AtomicInteger(1);

    @Override // ir.aaap.messengercore.network.Network
    public String getDefaultSocketUrl() {
        return "wss://shsocket1.iranlms.ir:80";
    }

    public NetworkImpl(int i) {
        this.currentAccount = i;
    }

    @Override // ir.aaap.messengercore.network.Network
    public void init(String str) {
        ApiRequestMessangerRx.getInstance().init(str);
        FileRequestMessangerRx.getInstance().init(str);
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            this.compositeDisposable = new CompositeDisposable();
        }
    }

    @Override // ir.aaap.messengercore.network.Network
    public void setVersionHelper(NetworkHelper.VersionEncryptionHelper versionEncryptionHelper) {
        this.versionEncryptionHelper = versionEncryptionHelper;
    }

    @Override // ir.aaap.messengercore.network.Network
    public void setNetworkErrorListener(Network.NetworkErrorListener networkErrorListener) {
        this.networkErrorListener = networkErrorListener;
        ApiRequestMessangerRx.getInstance().setNetworkErrorListener(networkErrorListener);
        FileRequestMessangerRx.getInstance().setNetworkErrorListener(networkErrorListener);
    }

    private void checkAndAddDisposable(DisposableObserver<Response<ResponseBody>> disposableObserver) {
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            this.compositeDisposable = new CompositeDisposable();
        }
        this.compositeDisposable.add(disposableObserver);
    }

    @Override // ir.aaap.messengercore.network.Network
    public int sendV5OrV6(String str, String str2, String str3, JSONObject jSONObject, RetryObject retryObject, Network.ResponseListener responseListener) throws Exception {
        Observable<Response<ResponseBody>> sendToUrlObservable;
        if (str == null) {
            sendToUrlObservable = getSendObservable(true, false, str2, str3, jSONObject);
        } else {
            sendToUrlObservable = getSendToUrlObservable(true, false, str, str2, str3, jSONObject);
        }
        return sendInner(sendToUrlObservable, str2, null, str3, jSONObject, retryObject, responseListener);
    }

    @Override // ir.aaap.messengercore.network.Network
    public int sendV4(String str, String str2, String str3, JSONObject jSONObject, RetryObject retryObject, Network.ResponseListener responseListener) throws Exception {
        Observable<Response<ResponseBody>> sendToUrlObservable;
        if (str == null) {
            sendToUrlObservable = getSendObservable(false, false, str2, str3, jSONObject);
        } else {
            sendToUrlObservable = getSendToUrlObservable(false, false, str, str2, str3, jSONObject);
        }
        return sendInner(sendToUrlObservable, str2, null, str3, jSONObject, retryObject, responseListener);
    }

    @Override // ir.aaap.messengercore.network.Network
    public int sendV5OrV6(String str, String str2, JSONObject jSONObject, RetryObject retryObject, Network.ResponseListener responseListener) throws Exception {
        return sendInner(getSendObservable(true, false, str, str2, jSONObject), str, null, str2, jSONObject, retryObject, responseListener);
    }

    @Override // ir.aaap.messengercore.network.Network
    public int sendV5(String str, String str2, JSONObject jSONObject, RetryObject retryObject, Network.ResponseListener responseListener) throws Exception {
        return sendInner(getSendObservable(true, true, str, str2, jSONObject), str, null, str2, jSONObject, retryObject, responseListener);
    }

    @Override // ir.aaap.messengercore.network.Network
    public int sendTempSessionV6(String str, String str2, JSONObject jSONObject, RetryObject retryObject, Network.ResponseListener responseListener) throws Exception {
        return sendInner(getSendTempSessionObservableV6(str, str2, jSONObject), null, str, str2, jSONObject, retryObject, responseListener);
    }

    public int sendInner(Observable<Response<ResponseBody>> observable, final String str, final String str2, final String str3, JSONObject jSONObject, RetryObject retryObject, final Network.ResponseListener responseListener) {
        if (observable == null) {
            return 0;
        }
        final int andIncrement = this.networkReqNumber.getAndIncrement();
        if (MyLog.isDebugAble) {
            StringBuilder sb = new StringBuilder();
            sb.append("method: ");
            sb.append(str3);
            sb.append(" aaa ");
            sb.append(andIncrement);
            sb.append(" input ");
            sb.append(jSONObject != null ? jSONObject.toString() : "null");
            MyLog.e("ApiRequest", sb.toString());
        }
        try {
            DisposableObserver<Response<ResponseBody>> disposableObserver = (DisposableObserver) handleRetry(observable, retryObject).subscribeWith(new DisposableObserver<Response<ResponseBody>>() { // from class: androidMessenger.network.NetworkImpl.2
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onNext(Response<ResponseBody> response) throws ApiServerException {
                    Network.NetworkErrorListener networkErrorListener;
                    NetworkImpl.this.disposableMap.remove(Integer.valueOf(andIncrement));
                    NetworkImpl.this.compositeDisposable.remove(this);
                    if (response.isSuccessful()) {
                        String str4 = response.headers().get("content-type");
                        if (str4 == null || !str4.trim().toLowerCase().contains("application/json")) {
                            return;
                        }
                        try {
                            if (response.body() == null) {
                                throw new ApiServerException();
                            }
                            MessangerOutput2 fromJson = MessangerOutput2.getFromJson(new JSONObject(response.body().string()), str, str2);
                            if (MyLog.isDebugAble) {
                                MyLog.e("ApiReqCore", "method: " + str3 + " bbb output status " + fromJson.status + " data " + fromJson.data);
                            }
                            if (fromJson.status == MessangerOutput2.EnumStatus.OK) {
                                Network.ResponseListener responseListener2 = responseListener;
                                if (responseListener2 != null) {
                                    responseListener2.onResponse(fromJson.data);
                                }
                            } else {
                                ApiServerException apiServerException = new ApiServerException(fromJson.status + BuildConfig.FLAVOR, fromJson.status_det + BuildConfig.FLAVOR);
                                MessangerOutput2.EnumStatus enumStatus = fromJson.status;
                                MessangerOutput2.EnumStatus enumStatus2 = MessangerOutput2.EnumStatus.ERROR_ACTION;
                                if (enumStatus == enumStatus2 && fromJson.status_det == MessangerOutput2.EnumStatusDet.NOT_REGISTERED) {
                                    Network.NetworkErrorListener networkErrorListener2 = NetworkImpl.this.networkErrorListener;
                                    if (networkErrorListener2 != null) {
                                        networkErrorListener2.onNotRegistered();
                                    }
                                } else if (enumStatus == enumStatus2 && fromJson.status_det == MessangerOutput2.EnumStatusDet.INVALID_AUTH) {
                                    Network.NetworkErrorListener networkErrorListener3 = NetworkImpl.this.networkErrorListener;
                                    if (networkErrorListener3 != null) {
                                        networkErrorListener3.onInvalidAuth();
                                    }
                                } else {
                                    NetworkImpl.this.networkErrorListener.handleError(apiServerException, fromJson.message_data);
                                }
                                Network.ResponseListener responseListener3 = responseListener;
                                if (responseListener3 != null) {
                                    responseListener3.onError(apiServerException);
                                }
                            }
                            Object obj = fromJson.client_show_message;
                            if (obj == null || (networkErrorListener = NetworkImpl.this.networkErrorListener) == null) {
                                return;
                            }
                            networkErrorListener.onShowMessage(obj);
                            return;
                        } catch (Exception e) {
                            if (response.body() != null) {
                                MyLog.e("ApiReqCore", "outputmethod:" + str3 + " error" + response.body().toString());
                            } else {
                                MyLog.e("ApiReqCore", "outputmethod:" + str3 + " errorresponseBodyResponse.body() null");
                            }
                            Network.ResponseListener responseListener4 = responseListener;
                            if (responseListener4 != null) {
                                responseListener4.onError(e);
                                return;
                            }
                            return;
                        }
                    }
                    Network.ResponseListener responseListener5 = responseListener;
                    if (responseListener5 != null) {
                        responseListener5.onError(new Exception(new ApiServerException()));
                    }
                    MyLog.e("ApiReqCore", "outputmethod:" + str3 + " bbb !!!!! error " + response.code());
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    NetworkImpl.this.disposableMap.remove(Integer.valueOf(andIncrement));
                    NetworkImpl.this.compositeDisposable.remove(this);
                    Network.ResponseListener responseListener2 = responseListener;
                    if (responseListener2 != null) {
                        responseListener2.onError(new Exception(th));
                    }
                    MyLog.e("ApiReqCore", "output method: " + str3 + " error ");
                }
            });
            checkAndAddDisposable(disposableObserver);
            this.disposableMap.put(Integer.valueOf(andIncrement), disposableObserver);
            return andIncrement;
        } catch (Exception e) {
            if (responseListener != null) {
                responseListener.onError(new Exception(e));
            }
            MyLog.handleException(e);
            return -1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Observable<Response<ResponseBody>> handleRetry(Observable<Response<ResponseBody>> observable, RetryObject retryObject) {
        Observable observableCompose;
        MyLog.e("NetworkImpl", "handleRetry 1");
        if (observable == null) {
            return null;
        }
        RetryObject.RetryTypeEnum retryTypeEnum = retryObject.type;
        if (retryTypeEnum == RetryObject.RetryTypeEnum.CountAndDelay) {
            observableCompose = observable.compose(rxHelper.addRetryAndDelay(retryObject.retryCount, retryObject.retryDelaySecond));
        } else if (retryTypeEnum == RetryObject.RetryTypeEnum.DelayArray) {
            observableCompose = observable.compose(rxHelper.addRetryAndDelay(retryObject.retryDelaySecondArray));
        } else {
            observableCompose = observable;
            if (retryTypeEnum != RetryObject.RetryTypeEnum.NoRetry) {
                observableCompose = observable;
                if (retryTypeEnum == RetryObject.RetryTypeEnum.DelayWithTimeLimit) {
                    observableCompose = observable.compose(rxHelper.addRetryAndDelayWithTime(retryObject.diffTime, retryObject.retryDelaySecondArray));
                }
            }
        }
        return observableCompose.doOnNext(new Consumer() { // from class: androidMessenger.network.NetworkImpl$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                NetworkImpl.lambda$handleRetry$0((Response) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$handleRetry$0(Response response) throws Exception {
        if (response.isSuccessful()) {
        } else {
            throw new Exception(response.errorBody() != null ? response.errorBody().string() : "Null Error Body");
        }
    }

    @Override // ir.aaap.messengercore.network.Network
    public int getBytes(String str, String str2, HashMap<String, String> map, RetryObject retryObject, final Network.BodyResponseListener bodyResponseListener) {
        if (MyLog.isDebugAble) {
            MyLog.e("ApiRequest", "input " + map.toString() + " url " + str);
            MyLog.e("DownloadApiRequest", "input " + map + " url " + str);
        }
        final int andIncrement = this.networkReqNumber.getAndIncrement();
        try {
            DisposableObserver<Response<ResponseBody>> disposableObserver = (DisposableObserver) handleRetry(getFileObservable(str, str2, map), retryObject).doOnNext(new Consumer() { // from class: androidMessenger.network.NetworkImpl$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    NetworkImpl.lambda$getBytes$1((Response) obj);
                }
            }).subscribeWith(new DisposableObserver<Response<ResponseBody>>() { // from class: androidMessenger.network.NetworkImpl.3
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onNext(Response<ResponseBody> response) throws Exception {
                    NetworkImpl.this.disposableMap.remove(Integer.valueOf(andIncrement));
                    NetworkImpl.this.compositeDisposable.remove(this);
                    if (response.isSuccessful()) {
                        try {
                            String str3 = response.headers().get("total_length");
                            if (str3 == null) {
                                throw new Exception("there is no total_length parameter in headers");
                            }
                            int i = Integer.parseInt(str3);
                            if (response.body() != null) {
                                byte[] bArrBytes = response.body().bytes();
                                Network.BodyResponseListener bodyResponseListener2 = bodyResponseListener;
                                if (bodyResponseListener2 != null) {
                                    bodyResponseListener2.onResponse(i, bArrBytes);
                                    return;
                                }
                                return;
                            }
                            throw new Exception("response body is empty");
                        } catch (Exception e) {
                            Network.BodyResponseListener bodyResponseListener3 = bodyResponseListener;
                            if (bodyResponseListener3 != null) {
                                bodyResponseListener3.onError(e);
                                return;
                            }
                            return;
                        }
                    }
                    Network.BodyResponseListener bodyResponseListener4 = bodyResponseListener;
                    if (bodyResponseListener4 != null) {
                        bodyResponseListener4.onError(new Exception());
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    NetworkImpl.this.disposableMap.remove(Integer.valueOf(andIncrement));
                    NetworkImpl.this.compositeDisposable.remove(this);
                    Network.BodyResponseListener bodyResponseListener2 = bodyResponseListener;
                    if (bodyResponseListener2 != null) {
                        bodyResponseListener2.onError(new Exception(th));
                    }
                }
            });
            checkAndAddDisposable(disposableObserver);
            this.disposableMap.put(Integer.valueOf(andIncrement), disposableObserver);
            return andIncrement;
        } catch (Exception e) {
            if (bodyResponseListener != null) {
                bodyResponseListener.onError(new Exception(e));
            }
            MyLog.handleExceptionThrowOnDebug(e);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getBytes$1(Response response) throws Exception {
        if (!response.isSuccessful()) {
            throw new Exception(response.errorBody().string());
        }
    }

    @Override // ir.aaap.messengercore.network.Network
    public int getBytesCdn(String str, String str2, String str3, HashMap<String, String> map, RetryObject retryObject, final Network.BodyResponseListener bodyResponseListener) {
        if (MyLog.isDebugAble) {
            MyLog.e("ApiReqCoreReq", "getFile input " + map.toString() + " cdn " + str2);
        }
        final int andIncrement = this.networkReqNumber.getAndIncrement();
        try {
            DisposableObserver<Response<ResponseBody>> disposableObserver = (DisposableObserver) handleRetry(getFileCdnObservable(str, str2, str3, map), retryObject).doOnNext(new Consumer() { // from class: androidMessenger.network.NetworkImpl$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    NetworkImpl.lambda$getBytesCdn$2((Response) obj);
                }
            }).subscribeWith(new DisposableObserver<Response<ResponseBody>>() { // from class: androidMessenger.network.NetworkImpl.4
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onNext(Response<ResponseBody> response) throws Exception {
                    NetworkImpl.this.disposableMap.remove(Integer.valueOf(andIncrement));
                    NetworkImpl.this.compositeDisposable.remove(this);
                    if (response.isSuccessful()) {
                        try {
                            String strSubstring = response.headers().get("total_length");
                            if (strSubstring == null) {
                                strSubstring = response.headers().get("content-range");
                                if (strSubstring != null) {
                                    try {
                                        if (strSubstring.contains("/")) {
                                            strSubstring = strSubstring.substring(strSubstring.indexOf("/") + 1);
                                        }
                                        Integer.parseInt(strSubstring);
                                    } catch (Exception unused) {
                                        throw new Exception("there is no total_length parameter in headers");
                                    }
                                } else {
                                    throw new Exception("there is no total_length parameter in headers");
                                }
                            }
                            int i = Integer.parseInt(strSubstring);
                            if (response.body() != null) {
                                byte[] bArrBytes = response.body().bytes();
                                Network.BodyResponseListener bodyResponseListener2 = bodyResponseListener;
                                if (bodyResponseListener2 != null) {
                                    bodyResponseListener2.onResponse(i, bArrBytes);
                                    return;
                                }
                                return;
                            }
                            throw new Exception("response body is empty");
                        } catch (Exception e) {
                            Network.BodyResponseListener bodyResponseListener3 = bodyResponseListener;
                            if (bodyResponseListener3 != null) {
                                bodyResponseListener3.onError(e);
                                return;
                            }
                            return;
                        }
                    }
                    Network.BodyResponseListener bodyResponseListener4 = bodyResponseListener;
                    if (bodyResponseListener4 != null) {
                        bodyResponseListener4.onError(new Exception());
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    NetworkImpl.this.disposableMap.remove(Integer.valueOf(andIncrement));
                    NetworkImpl.this.compositeDisposable.remove(this);
                    Network.BodyResponseListener bodyResponseListener2 = bodyResponseListener;
                    if (bodyResponseListener2 != null) {
                        bodyResponseListener2.onError(new Exception(th));
                    }
                }
            });
            checkAndAddDisposable(disposableObserver);
            this.disposableMap.put(Integer.valueOf(andIncrement), disposableObserver);
            return andIncrement;
        } catch (Exception e) {
            if (bodyResponseListener != null) {
                bodyResponseListener.onError(new Exception(e));
            }
            MyLog.handleExceptionThrowOnDebug(e);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getBytesCdn$2(Response response) throws Exception {
        if (!response.isSuccessful()) {
            throw new Exception(response.errorBody().string());
        }
    }

    @Override // ir.aaap.messengercore.network.Network
    public int sendBytes(String str, final String str2, byte[] bArr, HashMap<String, String> map, RetryObject retryObject, final Network.ResponseListener responseListener) {
        if (MyLog.isDebugAble) {
            MyLog.e("ApiRequest", "input " + map.toString() + " url " + str);
        }
        final int andIncrement = this.networkReqNumber.getAndIncrement();
        try {
            DisposableObserver<Response<ResponseBody>> disposableObserver = (DisposableObserver) handleRetry(getSendFileObservable(str, str2, bArr, map), retryObject).subscribeWith(new DisposableObserver<Response<ResponseBody>>() { // from class: androidMessenger.network.NetworkImpl.5
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onNext(Response<ResponseBody> response) throws Exception {
                    String str3;
                    Network.NetworkErrorListener networkErrorListener;
                    NetworkImpl.this.disposableMap.remove(Integer.valueOf(andIncrement));
                    NetworkImpl.this.compositeDisposable.remove(this);
                    if (response.isSuccessful() && (str3 = response.headers().get("content-type")) != null && str3.trim().toLowerCase().contains("application/json")) {
                        try {
                            if (response.body() != null) {
                                JSONObject jSONObject = new JSONObject(response.body().string());
                                if (MyLog.isDebugAble) {
                                    MyLog.e("ApiRequest", "bbb" + andIncrement + "output " + jSONObject.toString());
                                }
                                MessangerOutput2 fromJson = MessangerOutput2.getFromJson(jSONObject, str2, null);
                                MessangerOutput2.EnumStatus enumStatus = fromJson.status;
                                if (enumStatus == MessangerOutput2.EnumStatus.OK) {
                                    Network.ResponseListener responseListener2 = responseListener;
                                    if (responseListener2 != null) {
                                        responseListener2.onResponse(fromJson.data);
                                        return;
                                    }
                                    return;
                                }
                                MessangerOutput2.EnumStatus enumStatus2 = MessangerOutput2.EnumStatus.ERROR_ACTION;
                                if (enumStatus == enumStatus2 && fromJson.status_det == MessangerOutput2.EnumStatusDet.NOT_REGISTERED) {
                                    Network.NetworkErrorListener networkErrorListener2 = NetworkImpl.this.networkErrorListener;
                                    if (networkErrorListener2 != null) {
                                        networkErrorListener2.onNotRegistered();
                                    }
                                } else if (enumStatus == enumStatus2 && fromJson.status_det == MessangerOutput2.EnumStatusDet.INVALID_AUTH && (networkErrorListener = NetworkImpl.this.networkErrorListener) != null) {
                                    networkErrorListener.onInvalidAuth();
                                }
                                Network.ResponseListener responseListener3 = responseListener;
                                if (responseListener3 != null) {
                                    responseListener3.onError(new ApiServerException(fromJson.status + BuildConfig.FLAVOR, fromJson.status_det + BuildConfig.FLAVOR));
                                    return;
                                }
                                return;
                            }
                            throw new Exception("response body is empty");
                        } catch (Exception e) {
                            Network.ResponseListener responseListener4 = responseListener;
                            if (responseListener4 != null) {
                                responseListener4.onError(e);
                            }
                        }
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    NetworkImpl.this.disposableMap.remove(Integer.valueOf(andIncrement));
                    NetworkImpl.this.compositeDisposable.remove(this);
                    Network.ResponseListener responseListener2 = responseListener;
                    if (responseListener2 != null) {
                        responseListener2.onError(new Exception(th));
                    }
                }
            });
            checkAndAddDisposable(disposableObserver);
            this.disposableMap.put(Integer.valueOf(andIncrement), disposableObserver);
            return andIncrement;
        } catch (Exception e) {
            if (responseListener != null) {
                responseListener.onError(new Exception(e));
            }
            MyLog.handleExceptionThrowOnDebug(e);
            return -1;
        }
    }

    @Override // ir.aaap.messengercore.network.Network
    public int getBytes(String str, String str2, RetryObject retryObject, final Network.BodyResponseListener bodyResponseListener) {
        if (MyLog.isDebugAble) {
            MyLog.e("ApiRequest", " url " + str);
        }
        try {
            DisposableObserver<Response<ResponseBody>> disposableObserver = (DisposableObserver) handleRetry(getExternalFileObservable(str), retryObject).subscribeWith(new DisposableObserver<Response<ResponseBody>>(this) { // from class: androidMessenger.network.NetworkImpl.6
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onNext(Response<ResponseBody> response) throws NumberFormatException {
                    if (response.isSuccessful()) {
                        try {
                            String str3 = response.headers().get("total_length");
                            int i = -1;
                            if (str3 != null && !str3.isEmpty()) {
                                i = Integer.parseInt(str3);
                            }
                            ResponseBody responseBodyBody = response.body();
                            byte[] bArrBytes = responseBodyBody != null ? responseBodyBody.bytes() : null;
                            Network.BodyResponseListener bodyResponseListener2 = bodyResponseListener;
                            if (bodyResponseListener2 != null) {
                                bodyResponseListener2.onResponse(i, bArrBytes);
                                return;
                            }
                            return;
                        } catch (IOException unused) {
                            Network.BodyResponseListener bodyResponseListener3 = bodyResponseListener;
                            if (bodyResponseListener3 != null) {
                                bodyResponseListener3.onError(new Exception());
                                return;
                            }
                            return;
                        }
                    }
                    Network.BodyResponseListener bodyResponseListener4 = bodyResponseListener;
                    if (bodyResponseListener4 != null) {
                        bodyResponseListener4.onError(new Exception());
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    Network.BodyResponseListener bodyResponseListener2 = bodyResponseListener;
                    if (bodyResponseListener2 != null) {
                        bodyResponseListener2.onError(new Exception(th));
                    }
                }
            });
            checkAndAddDisposable(disposableObserver);
            int andIncrement = this.networkReqNumber.getAndIncrement();
            this.disposableMap.put(Integer.valueOf(andIncrement), disposableObserver);
            return andIncrement;
        } catch (Exception e) {
            if (bodyResponseListener != null) {
                bodyResponseListener.onError(new Exception(e));
            }
            MyLog.handleExceptionThrowOnDebug(e);
            return -1;
        }
    }

    private Observable<Response<ResponseBody>> getSendObservable(boolean z, boolean z2, String str, String str2, JSONObject jSONObject) throws IOException {
        if (MyLog.isDebugAble) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.currentAccount);
            sb.append(" method: ");
            sb.append(str2);
            sb.append(" aaa  input ");
            sb.append(jSONObject != null ? jSONObject.toString() : "null");
            MyLog.e("ApiReqCoreReq", sb.toString());
        }
        JSONObject jsonInput = getJsonInput(z, z2, str, str2, jSONObject);
        if (MyLog.isDebugAble) {
            MyLog.e("ApiReqCoreReq", this.currentAccount + "input: " + jsonInput.toString());
        }
        return ApiRequestMessangerRx.getInstance().send(jsonInput).subscribeOn(Schedulers.io());
    }

    private JSONObject getJsonInput(boolean z, boolean z2, String str, String str2, JSONObject jSONObject) {
        NetworkHelper.VersionEncryptionHelper versionEncryptionHelper;
        MessangerInput2 messangerInput2 = new MessangerInput2(str);
        if (z && !z2 && (versionEncryptionHelper = this.versionEncryptionHelper) != null && versionEncryptionHelper.isVersion6()) {
            return messangerInput2.getJsonObjectV6(str2, jSONObject, this.versionEncryptionHelper.getPrivateKey());
        }
        if (!z) {
            return messangerInput2.getJsonObject(str2, jSONObject != null ? jSONObject.toString() : null);
        }
        if (!z2 && this.versionEncryptionHelper != null) {
            this.compositeDisposable.add((Disposable) Observable.timer(100L, TimeUnit.MILLISECONDS).subscribeWith(new DisposableObserver<Long>() { // from class: androidMessenger.network.NetworkImpl.7
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(Long l) {
                    if (NetworkImpl.this.versionEncryptionHelper != null) {
                        NetworkImpl.this.versionEncryptionHelper.switchToV6();
                    }
                }
            }));
        }
        return messangerInput2.getJsonObjectV5(str2, jSONObject);
    }

    private Observable<Response<ResponseBody>> getSendTempSessionObservableV6(String str, String str2, JSONObject jSONObject) throws JSONException, IOException {
        if (MyLog.isDebugAble) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.currentAccount);
            sb.append(" method: ");
            sb.append(str2);
            sb.append(" aaa  input ");
            sb.append(jSONObject != null ? jSONObject.toString() : "null");
            MyLog.e("ApiReqCoreReq", sb.toString());
        }
        MessangerInput2 messangerInput2 = new MessangerInput2(null);
        messangerInput2.tmp_session = str;
        JSONObject jsonObjectV5 = messangerInput2.getJsonObjectV5(str2, jSONObject);
        try {
            jsonObjectV5.put("api_version", 6);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return ApiRequestMessangerRx.getInstance().send(jsonObjectV5).subscribeOn(Schedulers.io());
    }

    private Observable<Response<ResponseBody>> getSendToUrlObservable(boolean z, boolean z2, String str, String str2, String str3, JSONObject jSONObject) throws IOException {
        if (MyLog.isDebugAble) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.currentAccount);
            sb.append(" method: ");
            sb.append(str3);
            sb.append(" aaa  url: ");
            sb.append(str);
            sb.append(" input ");
            sb.append(jSONObject != null ? jSONObject.toString() : "null");
            MyLog.e("ApiReqCoreReq", sb.toString());
        }
        return ApiRequestMessangerRx.getInstance().sendToUrl(str, getJsonInput(z, z2, str2, str3, jSONObject)).subscribeOn(Schedulers.io());
    }

    private Observable<Response<ResponseBody>> getFileObservable(String str, String str2, HashMap<String, String> map) throws IOException {
        if (map == null) {
            map = new HashMap<>();
        }
        MessangerInput2 messangerInput2 = new MessangerInput2(str2);
        map.put("auth", str2);
        map.put("client-app-version", messangerInput2.client.app_version);
        map.put("client-platform", messangerInput2.client.platform);
        map.put("client-app-name", messangerInput2.client.app_name);
        map.put("client-package", messangerInput2.client.packageName);
        return FileRequestMessangerRx.getInstance().getFile(str, map).subscribeOn(Schedulers.io());
    }

    private Observable<Response<ResponseBody>> getFileCdnObservable(String str, String str2, String str3, HashMap<String, String> map) throws IOException {
        if (map == null) {
            map = new HashMap<>();
        }
        MessangerInput2 messangerInput2 = new MessangerInput2(str3);
        map.put("auth", str3);
        map.put("client-app-version", messangerInput2.client.app_version);
        map.put("client-platform", messangerInput2.client.platform);
        map.put("client-app-name", messangerInput2.client.app_name);
        map.put("client-package", messangerInput2.client.packageName);
        return FileRequestMessangerRx.getInstance().getFileCdn(str, str2, map).subscribeOn(Schedulers.io());
    }

    private Observable<Response<ResponseBody>> getExternalFileObservable(String str) throws IOException {
        return FileRequestMessangerRx.getInstance().getExternalFile(str).compose(rxHelper.addRegularRetryAndDelay()).subscribeOn(Schedulers.io());
    }

    private Observable<Response<ResponseBody>> getSendFileObservable(String str, String str2, byte[] bArr, HashMap<String, String> map) throws IOException {
        if (map == null) {
            map = new HashMap<>();
        }
        MessangerInput2 messangerInput2 = new MessangerInput2(str2);
        map.put("auth", str2);
        map.put("client-app-version", messangerInput2.client.app_version);
        map.put("client-platform", messangerInput2.client.platform);
        map.put("client-app-name", messangerInput2.client.app_name);
        map.put("client-package", messangerInput2.client.packageName);
        return FileRequestMessangerRx.getInstance().sendFile(str, RequestBody.create(MediaType.parse("application/octet-stream"), bArr), map).compose(rxHelper.addRegularRetryAndDelay()).subscribeOn(Schedulers.io());
    }

    @Override // ir.aaap.messengercore.network.Network
    public void cancelCall(int i) {
        try {
            DisposableObserver<Response<ResponseBody>> disposableObserver = this.disposableMap.get(Integer.valueOf(i));
            if (disposableObserver != null) {
                disposableObserver.dispose();
            }
        } catch (Exception unused) {
        }
    }

    @Override // ir.aaap.messengercore.network.Network
    public void setMessengerUrl(String str) {
        ApiRequestMessangerRx.getInstance().setMessengerUrl(str);
        FileRequestMessangerRx.getInstance().setMessengerUrl(str);
    }

    @Override // ir.aaap.messengercore.network.Network
    public void disposeObservables() {
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            return;
        }
        this.compositeDisposable.dispose();
        this.compositeDisposable = null;
    }

    @Override // ir.aaap.messengercore.network.Network
    public void checkDisposables() {
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            this.compositeDisposable = new CompositeDisposable();
        }
    }

    @Override // ir.aaap.messengercore.network.Network
    public String getDefaultMessengerUrl() {
        if (MyLog.isDebugAble) {
            return "https://shadmessenger2.iranlms.ir";
        }
        ArrayList<String> arrayList = AppFavorUtils.MESSENGER_URL_DEFAULT;
        return arrayList.get(Utilities.random.nextInt(arrayList.size()));
    }

    @Override // ir.aaap.messengercore.network.Network
    public String getDefaultDcMessUrl() {
        return AppFavorUtils.GET_DC_MESS_URL;
    }
}
