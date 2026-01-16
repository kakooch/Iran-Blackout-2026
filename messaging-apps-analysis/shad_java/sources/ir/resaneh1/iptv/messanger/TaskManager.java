package ir.resaneh1.iptv.messanger;

import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.core.content.ContextCompat;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import ir.resaneh1.iptv.apiMessanger.ApiRequestMessangerRx;
import ir.resaneh1.iptv.model.GetTasksInput;
import ir.resaneh1.iptv.model.GetTasksOutput;
import ir.resaneh1.iptv.model.MessangerOutput;
import ir.resaneh1.iptv.model.messenger.SendTaskResultInput;
import ir.resaneh1.iptv.model.messenger.SendTaskResultOutput;
import ir.resaneh1.iptv.model.messenger.TaskObject;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.ResponseBody;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.BaseController;
import retrofit2.Response;

/* loaded from: classes3.dex */
public class TaskManager extends BaseController {
    private static volatile TaskManager[] Instance = new TaskManager[3];
    CompositeDisposable compositeDisposable;
    ArrayList<TaskObject> downloadTasks;
    private DisposableObserver<MessangerOutput<GetTasksOutput>> getTasksObservable;
    private ArrayList<TaskObject> tasks;
    ArrayList<TaskObject> uploadTask;

    public static TaskManager getInstance(int i) {
        TaskManager taskManager = Instance[i];
        if (taskManager == null) {
            synchronized (TaskManager.class) {
                taskManager = Instance[i];
                if (taskManager == null) {
                    TaskManager[] taskManagerArr = Instance;
                    TaskManager taskManager2 = new TaskManager(i);
                    taskManagerArr[i] = taskManager2;
                    taskManager = taskManager2;
                }
            }
        }
        return taskManager;
    }

    private TaskManager(int i) {
        super(i);
        this.compositeDisposable = new CompositeDisposable();
        this.uploadTask = new ArrayList<>();
        this.downloadTasks = new ArrayList<>();
    }

    public void getTasksIfNeeded() {
        if (this.tasks != null) {
            return;
        }
        DisposableObserver<MessangerOutput<GetTasksOutput>> disposableObserver = this.getTasksObservable;
        if (disposableObserver == null || disposableObserver.isDisposed()) {
            DisposableObserver<MessangerOutput<GetTasksOutput>> disposableObserver2 = (DisposableObserver) getApiRequestMessangerRx().getQualityTasks(new GetTasksInput()).observeOn(Schedulers.io()).subscribeWith(new DisposableObserver<MessangerOutput<GetTasksOutput>>() { // from class: ir.resaneh1.iptv.messanger.TaskManager.1
                @Override // io.reactivex.Observer
                public void onNext(MessangerOutput<GetTasksOutput> messangerOutput) {
                    GetTasksOutput getTasksOutput = messangerOutput.data;
                    if (getTasksOutput.quality_tasks != null) {
                        TaskManager.this.tasks = getTasksOutput.quality_tasks;
                    } else {
                        TaskManager.this.tasks = new ArrayList();
                    }
                    TaskManager.this.scheduleTasks();
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    TaskManager.this.getTasksObservable.dispose();
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    TaskManager.this.getTasksObservable.dispose();
                }
            });
            this.getTasksObservable = disposableObserver2;
            this.compositeDisposable.add(disposableObserver2);
        }
    }

    boolean isWifiConnected() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) ApplicationLoader.applicationActivity.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 1;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    boolean isMobileDataConnected() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) ApplicationLoader.applicationActivity.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 0;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleTasks() {
        ArrayList<TaskObject> arrayList = this.tasks;
        if (arrayList == null) {
            return;
        }
        Iterator<TaskObject> it = arrayList.iterator();
        while (it.hasNext()) {
            final TaskObject next = it.next();
            this.compositeDisposable.add((Disposable) Observable.just(1).delay(next.start_delay, TimeUnit.SECONDS).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.messanger.TaskManager.2
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                }

                @Override // io.reactivex.Observer
                public void onNext(Integer num) {
                    TaskObject taskObject = next;
                    TaskObject.TaskType taskType = taskObject.task_type;
                    TaskObject.TaskType taskType2 = TaskObject.TaskType.Get;
                    if (taskType == taskType2 || taskType == TaskObject.TaskType.Ping) {
                        if (taskObject.force_network_type != TaskObject.NetworkType.Wifi || TaskManager.this.isWifiConnected()) {
                            if (next.force_network_type != TaskObject.NetworkType.Mobile || TaskManager.this.isMobileDataConnected()) {
                                if (next.force_location_available && TaskManager.this.getLastKnowLocation() == null) {
                                    return;
                                }
                                TaskObject taskObject2 = next;
                                TaskObject.TaskType taskType3 = taskObject2.task_type;
                                if (taskType3 == TaskObject.TaskType.Ping) {
                                    TaskManager.this.doPingTask(taskObject2);
                                    return;
                                } else {
                                    if (taskType3 == taskType2) {
                                        TaskManager.this.doGetTask(taskObject2);
                                        return;
                                    }
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    }
                    if (taskType == TaskObject.TaskType.Upload) {
                        TaskManager.this.uploadTask.add(taskObject);
                    } else if (taskType == TaskObject.TaskType.Download) {
                        TaskManager.this.downloadTasks.add(taskObject);
                    }
                }
            }));
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:0|2|(1:(1:15)(14:14|17|59|(1:19)(1:(2:21|(1:23)(1:25))(0))|61|26|(1:36)(4:32|57|33|34)|37|(1:39)|(1:41)(1:(1:43)(1:44))|(1:48)|(1:52)|53|54))(1:8)|16|17|59|(0)(0)|61|26|(2:28|36)(0)|37|(0)|(0)(0)|(2:46|48)|(2:50|52)|53|54) */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0042 A[Catch: Exception -> 0x0074, TRY_ENTER, TryCatch #1 {Exception -> 0x0074, blocks: (B:19:0x0042, B:21:0x005d, B:23:0x006b), top: B:59:0x0040 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0074 A[PHI: r6
      0x0074: PHI (r6v2 ??) = (r6v1 ??), (r6v0 ??), (r6v0 ??) binds: [B:56:0x0074, B:20:0x005b, B:22:0x0069] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c2  */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v7, types: [android.telephony.TelephonyManager] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0074 -> B:61:0x0075). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void fillNetworkAndLocationInfo(ir.resaneh1.iptv.model.messenger.SendTaskResultInput r13) {
        /*
            r12 = this;
            org.rbmain.ui.LaunchActivity r0 = org.rbmain.messenger.ApplicationLoader.applicationActivity
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()
            r1 = 1
            r2 = 0
            java.lang.String r3 = ""
            r4 = 0
            if (r0 == 0) goto L23
            boolean r5 = r0.isConnected()
            if (r5 == 0) goto L23
            int r5 = r0.getType()
            if (r5 != r1) goto L23
            r0 = 1
            goto L3d
        L23:
            if (r0 == 0) goto L3c
            boolean r5 = r0.isConnected()
            if (r5 == 0) goto L3c
            int r5 = r0.getType()
            if (r5 != 0) goto L3c
            java.lang.String r4 = r0.getSubtypeName()
            java.lang.String r3 = r0.getExtraInfo()
            r0 = 0
            r5 = 1
            goto L3e
        L3c:
            r0 = 0
        L3d:
            r5 = 0
        L3e:
            java.lang.String r6 = "phone"
            if (r0 == 0) goto L5b
            android.content.Context r7 = org.rbmain.messenger.ApplicationLoader.applicationContext     // Catch: java.lang.Exception -> L74
            java.lang.String r8 = "wifi"
            java.lang.Object r7 = r7.getSystemService(r8)     // Catch: java.lang.Exception -> L74
            android.net.wifi.WifiManager r7 = (android.net.wifi.WifiManager) r7     // Catch: java.lang.Exception -> L74
            android.net.wifi.WifiInfo r7 = r7.getConnectionInfo()     // Catch: java.lang.Exception -> L74
            int r7 = r7.getRssi()     // Catch: java.lang.Exception -> L74
            r8 = 5
            int r7 = android.net.wifi.WifiManager.calculateSignalLevel(r7, r8)     // Catch: java.lang.Exception -> L74
            int r7 = r7 + r1
            goto L75
        L5b:
            if (r5 == 0) goto L74
            org.rbmain.ui.LaunchActivity r7 = org.rbmain.messenger.ApplicationLoader.applicationActivity     // Catch: java.lang.Exception -> L74
            java.lang.Object r7 = r7.getSystemService(r6)     // Catch: java.lang.Exception -> L74
            android.telephony.TelephonyManager r7 = (android.telephony.TelephonyManager) r7     // Catch: java.lang.Exception -> L74
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L74
            r9 = 28
            if (r8 < r9) goto L74
            android.telephony.SignalStrength r7 = r7.getSignalStrength()     // Catch: java.lang.Exception -> L74
            int r7 = r7.getLevel()     // Catch: java.lang.Exception -> L74
            goto L75
        L74:
            r7 = 0
        L75:
            org.rbmain.ui.LaunchActivity r8 = org.rbmain.messenger.ApplicationLoader.applicationActivity     // Catch: java.lang.Exception -> La1
            java.lang.Object r6 = r8.getSystemService(r6)     // Catch: java.lang.Exception -> La1
            android.telephony.TelephonyManager r6 = (android.telephony.TelephonyManager) r6     // Catch: java.lang.Exception -> La1
            int r8 = r6.getPhoneType()     // Catch: java.lang.Exception -> La1
            if (r8 != r1) goto La1
            org.rbmain.ui.LaunchActivity r1 = org.rbmain.messenger.ApplicationLoader.applicationActivity     // Catch: java.lang.Exception -> La1
            java.lang.String r8 = "android.permission.ACCESS_FINE_LOCATION"
            int r1 = androidx.core.content.ContextCompat.checkSelfPermission(r1, r8)     // Catch: java.lang.Exception -> La1
            if (r1 != 0) goto La1
            android.telephony.CellLocation r1 = r6.getCellLocation()     // Catch: java.lang.Exception -> La1
            android.telephony.gsm.GsmCellLocation r1 = (android.telephony.gsm.GsmCellLocation) r1     // Catch: java.lang.Exception -> La1
            if (r1 == 0) goto La1
            int r6 = r1.getCid()     // Catch: java.lang.Exception -> La1
            int r1 = r1.getLac()     // Catch: java.lang.Exception -> L9f
            r2 = r1
            goto La2
        L9f:
            goto La2
        La1:
            r6 = 0
        La2:
            android.location.Location r1 = r12.getLastKnowLocation()
            r13.cell_id = r6
            r13.lac_id = r2
            if (r1 == 0) goto Lbb
            ir.resaneh1.iptv.model.LocationObject r2 = new ir.resaneh1.iptv.model.LocationObject
            double r8 = r1.getLatitude()
            double r10 = r1.getLongitude()
            r2.<init>(r8, r10)
            r13.location = r2
        Lbb:
            if (r0 == 0) goto Lc2
            ir.resaneh1.iptv.model.messenger.TaskObject$NetworkType r0 = ir.resaneh1.iptv.model.messenger.TaskObject.NetworkType.Wifi
            r13.network_type = r0
            goto Lcd
        Lc2:
            if (r5 == 0) goto Lc9
            ir.resaneh1.iptv.model.messenger.TaskObject$NetworkType r0 = ir.resaneh1.iptv.model.messenger.TaskObject.NetworkType.Mobile
            r13.network_type = r0
            goto Lcd
        Lc9:
            ir.resaneh1.iptv.model.messenger.TaskObject$NetworkType r0 = ir.resaneh1.iptv.model.messenger.TaskObject.NetworkType.None
            r13.network_type = r0
        Lcd:
            if (r3 == 0) goto Ld7
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto Ld7
            r13.mobile_operator = r3
        Ld7:
            if (r4 == 0) goto Le1
            boolean r0 = r4.isEmpty()
            if (r0 != 0) goto Le1
            r13.mobile_type_network = r4
        Le1:
            r13.signal_level = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.resaneh1.iptv.messanger.TaskManager.fillNetworkAndLocationInfo(ir.resaneh1.iptv.model.messenger.SendTaskResultInput):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Location getLastKnowLocation() {
        LocationManager locationManager;
        try {
            locationManager = (LocationManager) ApplicationLoader.applicationActivity.getSystemService("location");
        } catch (Exception unused) {
        }
        if (ContextCompat.checkSelfPermission(ApplicationLoader.applicationActivity, "android.permission.ACCESS_FINE_LOCATION") != 0 && ContextCompat.checkSelfPermission(ApplicationLoader.applicationActivity, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            return null;
        }
        List<String> providers = locationManager.getProviders(true);
        for (int size = providers.size() - 1; size >= 0; size--) {
            Location lastKnownLocation = locationManager.getLastKnownLocation(providers.get(size));
            if (lastKnownLocation != null) {
                return lastKnownLocation;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doGetTask(final TaskObject taskObject) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.compositeDisposable.add((Disposable) getApiRequestMessangerRx().getURl(taskObject.get_task.get_url).subscribeWith(new DisposableObserver<Response<ResponseBody>>() { // from class: ir.resaneh1.iptv.messanger.TaskManager.3
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onNext(Response<ResponseBody> response) {
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                SendTaskResultInput.GetResult getResult = new SendTaskResultInput.GetResult();
                getResult.is_successful = true;
                if (response.body() != null) {
                    getResult.get_size = response.body().contentLength();
                }
                TaskObject taskObject2 = taskObject;
                getResult.get_url = taskObject2.get_task.get_url;
                getResult.get_time = jCurrentTimeMillis2;
                TaskManager.this.sendTaskResult(taskObject2, getResult, null, null, null);
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                SendTaskResultInput.GetResult getResult = new SendTaskResultInput.GetResult();
                getResult.is_successful = false;
                TaskObject taskObject2 = taskObject;
                getResult.get_url = taskObject2.get_task.get_url;
                getResult.get_time = jCurrentTimeMillis2;
                TaskManager.this.sendTaskResult(taskObject2, getResult, null, null, null);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPingTask(final TaskObject taskObject) {
        this.compositeDisposable.add((Disposable) Observable.just(1).observeOn(Schedulers.io()).subscribeWith(new DisposableObserver<Integer>() { // from class: ir.resaneh1.iptv.messanger.TaskManager.4
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(Integer num) throws IOException {
                try {
                    InetAddress byName = InetAddress.getByName(taskObject.ping_task.ping_ip);
                    long j = 0;
                    int i = 0;
                    int i2 = 0;
                    for (int i3 = 0; i3 < taskObject.ping_task.ping_count; i3++) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        boolean zIsReachable = byName.isReachable(3000);
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        if (zIsReachable) {
                            i++;
                            j += jCurrentTimeMillis2 - jCurrentTimeMillis;
                        } else {
                            i2++;
                        }
                    }
                    SendTaskResultInput.PingResult pingResult = new SendTaskResultInput.PingResult();
                    TaskObject taskObject2 = taskObject;
                    pingResult.ping_ip = taskObject2.ping_task.ping_ip;
                    pingResult.ping_loss = (i2 * 1.0f) / r12.ping_count;
                    pingResult.ping_time = j / i;
                    TaskManager.this.sendTaskResult(taskObject2, null, pingResult, null, null);
                } catch (IOException unused) {
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendTaskResult(TaskObject taskObject, SendTaskResultInput.GetResult getResult, SendTaskResultInput.PingResult pingResult, SendTaskResultInput.DownloadResult downloadResult, SendTaskResultInput.UploadResult uploadResult) {
        SendTaskResultInput sendTaskResultInput = new SendTaskResultInput();
        sendTaskResultInput.task_type = taskObject.task_type;
        sendTaskResultInput.task_id = taskObject.task_id;
        sendTaskResultInput.get_result = getResult;
        sendTaskResultInput.ping_result = pingResult;
        sendTaskResultInput.download_result = downloadResult;
        sendTaskResultInput.upload_result = uploadResult;
        fillNetworkAndLocationInfo(sendTaskResultInput);
        this.compositeDisposable.add((Disposable) ApiRequestMessangerRx.getInstance(this.currentAccount).sendTaskResult(sendTaskResultInput).subscribeWith(new DisposableObserver<MessangerOutput<SendTaskResultOutput>>(this) { // from class: ir.resaneh1.iptv.messanger.TaskManager.5
            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onNext(MessangerOutput<SendTaskResultOutput> messangerOutput) {
            }
        }));
    }
}
