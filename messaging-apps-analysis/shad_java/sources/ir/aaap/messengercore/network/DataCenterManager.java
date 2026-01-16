package ir.aaap.messengercore.network;

import android.util.Pair;
import ir.aaap.messengercore.CoreMainClassImpl;
import ir.aaap.messengercore.JsonHelper;
import ir.aaap.messengercore.KeyValueStorageHelper;
import ir.aaap.messengercore.TimerHelper;
import ir.aaap.messengercore.model.GetDcsOutput;
import ir.aaap.messengercore.network.NetworkHelper;
import ir.aaap.messengercore.utilites.CoreLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class DataCenterManager {
    public CoreLog coreLog;
    GetDcsOutput getDcsOutput;
    public KeyValueStorageHelper keyValueStorageHelper;
    public NetworkHelper networkHelper;
    public int apiCounter = 0;
    public Map<String, Pair<Integer, Long>> cdnCounterMap = new HashMap();
    private int currentRequestId = -1;
    private long lastTimeIncreased = 0;
    private final Object cdnLock = new Object();

    public DataCenterManager(NetworkHelper networkHelper, KeyValueStorageHelper keyValueStorageHelper, JsonHelper jsonHelper, CoreLog coreLog) {
        this.keyValueStorageHelper = keyValueStorageHelper;
        this.networkHelper = networkHelper;
        this.coreLog = coreLog;
    }

    public String getStorageUrl(String str, String str2, String str3) {
        Map<String, String> map;
        Map<String, ArrayList<String>> map2;
        ArrayList<String> arrayList;
        setDcsObjectFromAppPrefrencesIfNeeeded();
        GetDcsOutput getDcsOutput = this.getDcsOutput;
        if (getDcsOutput == null || (map = getDcsOutput.storages) == null || !map.containsKey(str2)) {
            reloadDcs(str);
            return null;
        }
        if (str3 != null && (map2 = this.getDcsOutput.default_cdn_urls) != null && map2.containsKey(str3) && (arrayList = this.getDcsOutput.default_cdn_urls.get(str3)) != null) {
            Pair<Integer, Long> pair = this.cdnCounterMap.get(str3);
            int iIntValue = pair != null ? ((Integer) pair.first).intValue() : 0;
            int size = arrayList.size();
            if (size > 0) {
                return arrayList.get(iIntValue % size);
            }
        }
        return this.getDcsOutput.storages.get(str2);
    }

    public void init(final String str, TimerHelper timerHelper) {
        this.networkHelper.init(getApiUrl());
        timerHelper.postRunnableDelayed(new Runnable() { // from class: ir.aaap.messengercore.network.DataCenterManager.1
            @Override // java.lang.Runnable
            public void run() {
                DataCenterManager.this.reloadDcs(str);
            }
        }, 200L);
    }

    public String getSocketUrl(int i) {
        ArrayList<String> arrayList;
        setDcsObjectFromAppPrefrencesIfNeeeded();
        GetDcsOutput getDcsOutput = this.getDcsOutput;
        if (getDcsOutput != null && (arrayList = getDcsOutput.default_sockets) != null && arrayList.size() > 0) {
            ArrayList<String> arrayList2 = this.getDcsOutput.default_sockets;
            return arrayList2.get(i % arrayList2.size());
        }
        return this.networkHelper.getDefaultSocketUrl();
    }

    public String getApiUrl() {
        ArrayList<String> arrayList;
        setDcsObjectFromAppPrefrencesIfNeeeded();
        GetDcsOutput getDcsOutput = this.getDcsOutput;
        if (getDcsOutput != null && (arrayList = getDcsOutput.default_api_urls) != null && arrayList.size() > 0) {
            ArrayList<String> arrayList2 = this.getDcsOutput.default_api_urls;
            return arrayList2.get(this.apiCounter % arrayList2.size());
        }
        return this.networkHelper.getDefaultMessengerUrl();
    }

    public String getBotApiUrl() {
        ArrayList<String> arrayList;
        setDcsObjectFromAppPrefrencesIfNeeeded();
        GetDcsOutput getDcsOutput = this.getDcsOutput;
        if (getDcsOutput != null && (arrayList = getDcsOutput.default_bot_urls) != null && arrayList.size() > 0) {
            ArrayList<String> arrayList2 = this.getDcsOutput.default_bot_urls;
            return arrayList2.get(this.apiCounter % arrayList2.size());
        }
        return this.networkHelper.getDefaultMessengerUrl();
    }

    public void setDcsObjectFromAppPrefrencesIfNeeeded() {
        if (this.getDcsOutput == null && this.currentRequestId < 0) {
            this.getDcsOutput = this.keyValueStorageHelper.getDcsOutput();
        }
    }

    public void reloadDcs(String str) {
        if (this.currentRequestId < 0 || this.getDcsOutput == null) {
            try {
                NetworkHelper networkHelper = this.networkHelper;
                this.currentRequestId = networkHelper.getDCs(networkHelper.getDefaultDcMessUrl(), str, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetDcsOutput>() { // from class: ir.aaap.messengercore.network.DataCenterManager.2
                    @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                    public void onResponse(GetDcsOutput getDcsOutput) {
                        DataCenterManager.this.currentRequestId = -1;
                        if (getDcsOutput != null) {
                            DataCenterManager dataCenterManager = DataCenterManager.this;
                            dataCenterManager.getDcsOutput = getDcsOutput;
                            dataCenterManager.keyValueStorageHelper.setDcsOutput(getDcsOutput);
                            DataCenterManager.this.cdnCounterMap.clear();
                        }
                        DataCenterManager dataCenterManager2 = DataCenterManager.this;
                        dataCenterManager2.networkHelper.setMessengerUrl(dataCenterManager2.getApiUrl());
                    }

                    @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                    public void onError(Exception exc) {
                        DataCenterManager.this.currentRequestId = -1;
                    }
                });
            } catch (Exception unused) {
                this.currentRequestId = -1;
            }
        }
    }

    public void increaseApiServerIfNeeded() {
        if (System.currentTimeMillis() - this.lastTimeIncreased > CoreMainClassImpl.ignoreChangeApiTime) {
            this.lastTimeIncreased = System.currentTimeMillis();
            this.apiCounter++;
            this.networkHelper.setMessengerUrl(getApiUrl());
        }
    }

    public void increaseCdnCounterIfNeeded(String str) {
        Map<String, ArrayList<String>> map;
        GetDcsOutput getDcsOutput = this.getDcsOutput;
        if (getDcsOutput == null || (map = getDcsOutput.default_cdn_urls) == null) {
            return;
        }
        boolean z = false;
        String str2 = null;
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            ArrayList<String> arrayList = this.getDcsOutput.default_cdn_urls.get(next);
            if (arrayList != null) {
                Iterator<String> it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else if (it2.next().equals(str)) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                str2 = next;
                break;
            }
        }
        if (z) {
            Pair<Integer, Long> pair = this.cdnCounterMap.get(str2);
            if (pair == null || pair.second == null || System.currentTimeMillis() - ((Long) pair.second).longValue() > CoreMainClassImpl.ignoreChangeApiTime) {
                increaseCdnCounter(str2);
            }
        }
    }

    public void increaseCdnCounter(String str) {
        synchronized (this.cdnLock) {
            Pair<Integer, Long> pair = this.cdnCounterMap.get(str);
            if (pair == null) {
                this.cdnCounterMap.put(str, new Pair<>(1, Long.valueOf(System.currentTimeMillis())));
                this.coreLog.e("ApiReqCore", "increaseCdnCounter cdnTag " + str + " 1");
            } else {
                Map<String, Pair<Integer, Long>> map = this.cdnCounterMap;
                Object obj = pair.first;
                map.put(str, new Pair<>(Integer.valueOf(obj != null ? 1 + ((Integer) obj).intValue() : 1), Long.valueOf(System.currentTimeMillis())));
                this.coreLog.e("ApiReqCore", "increaseCdnCounter cdnTag " + str + pair.first);
            }
        }
    }
}
