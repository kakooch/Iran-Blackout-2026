package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public class ConfigCacheClient {
    private Task<ConfigContainer> cachedContainerTask = null;
    private final ExecutorService executorService;
    private final ConfigStorageClient storageClient;
    private static final Map<String, ConfigCacheClient> clientInstances = new HashMap();
    private static final Executor DIRECT_EXECUTOR = ConfigCacheClient$$Lambda$4.instance;

    private ConfigCacheClient(ExecutorService executorService, ConfigStorageClient configStorageClient) {
        this.executorService = executorService;
        this.storageClient = configStorageClient;
    }

    public synchronized Task<ConfigContainer> get() {
        Task<ConfigContainer> task = this.cachedContainerTask;
        if (task == null || (task.isComplete() && !this.cachedContainerTask.isSuccessful())) {
            ExecutorService executorService = this.executorService;
            ConfigStorageClient configStorageClient = this.storageClient;
            configStorageClient.getClass();
            this.cachedContainerTask = Tasks.call(executorService, ConfigCacheClient$$Lambda$3.lambdaFactory$(configStorageClient));
        }
        return this.cachedContainerTask;
    }

    public static synchronized ConfigCacheClient getInstance(ExecutorService executorService, ConfigStorageClient configStorageClient) {
        String fileName;
        Map<String, ConfigCacheClient> map;
        fileName = configStorageClient.getFileName();
        map = clientInstances;
        if (!map.containsKey(fileName)) {
            map.put(fileName, new ConfigCacheClient(executorService, configStorageClient));
        }
        return map.get(fileName);
    }
}
