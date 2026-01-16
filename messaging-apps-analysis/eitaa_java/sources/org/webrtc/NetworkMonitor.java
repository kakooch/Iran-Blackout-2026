package org.webrtc;

import android.content.Context;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.webrtc.NetworkChangeDetector;

/* loaded from: classes3.dex */
public class NetworkMonitor {
    private static final String TAG = "NetworkMonitor";
    private volatile NetworkChangeDetector.ConnectionType currentConnectionType;
    private final ArrayList<Long> nativeNetworkObservers;
    private NetworkChangeDetector networkChangeDetector;
    private NetworkChangeDetectorFactory networkChangeDetectorFactory;
    private final Object networkChangeDetectorLock;
    private final ArrayList<NetworkObserver> networkObservers;
    private int numObservers;

    public interface NetworkObserver {
        void onConnectionTypeChanged(NetworkChangeDetector.ConnectionType connectionType);
    }

    @Deprecated
    public static void init(Context context) {
    }

    private native void nativeNotifyConnectionTypeChanged(long nativeAndroidNetworkMonitor);

    private native void nativeNotifyOfActiveNetworkList(long nativeAndroidNetworkMonitor, NetworkChangeDetector.NetworkInformation[] networkInfos);

    private native void nativeNotifyOfNetworkConnect(long nativeAndroidNetworkMonitor, NetworkChangeDetector.NetworkInformation networkInfo);

    private native void nativeNotifyOfNetworkDisconnect(long nativeAndroidNetworkMonitor, long networkHandle);

    private native void nativeNotifyOfNetworkPreference(long nativeAndroidNetworkMonitor, NetworkChangeDetector.ConnectionType type, int preference);

    private static class InstanceHolder {
        static final NetworkMonitor instance = new NetworkMonitor();

        private InstanceHolder() {
        }
    }

    private NetworkMonitor() {
        this.networkChangeDetectorFactory = new NetworkChangeDetectorFactory() { // from class: org.webrtc.NetworkMonitor.1
            @Override // org.webrtc.NetworkChangeDetectorFactory
            public NetworkChangeDetector create(NetworkChangeDetector.Observer observer, Context context) {
                return new NetworkMonitorAutoDetect(observer, context);
            }
        };
        this.networkChangeDetectorLock = new Object();
        this.nativeNetworkObservers = new ArrayList<>();
        this.networkObservers = new ArrayList<>();
        this.numObservers = 0;
        this.currentConnectionType = NetworkChangeDetector.ConnectionType.CONNECTION_UNKNOWN;
    }

    public void setNetworkChangeDetectorFactory(NetworkChangeDetectorFactory factory) {
        assertIsTrue(this.numObservers == 0);
        this.networkChangeDetectorFactory = factory;
    }

    @CalledByNative
    public static NetworkMonitor getInstance() {
        return InstanceHolder.instance;
    }

    private static void assertIsTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("Expected to be true");
        }
    }

    public void startMonitoring(Context applicationContext) {
        synchronized (this.networkChangeDetectorLock) {
            this.numObservers++;
            if (this.networkChangeDetector == null) {
                this.networkChangeDetector = createNetworkChangeDetector(applicationContext);
            }
            this.currentConnectionType = this.networkChangeDetector.getCurrentConnectionType();
        }
    }

    @Deprecated
    public void startMonitoring() {
        startMonitoring(ContextUtils.getApplicationContext());
    }

    @CalledByNative
    private void startMonitoring(Context applicationContext, long nativeObserver) {
        Logging.d(TAG, "Start monitoring with native observer " + nativeObserver);
        if (applicationContext == null) {
            applicationContext = ContextUtils.getApplicationContext();
        }
        startMonitoring(applicationContext);
        synchronized (this.nativeNetworkObservers) {
            this.nativeNetworkObservers.add(Long.valueOf(nativeObserver));
        }
        updateObserverActiveNetworkList(nativeObserver);
        notifyObserversOfConnectionTypeChange(this.currentConnectionType);
    }

    public void stopMonitoring() {
        synchronized (this.networkChangeDetectorLock) {
            int i = this.numObservers - 1;
            this.numObservers = i;
            if (i == 0) {
                this.networkChangeDetector.destroy();
                this.networkChangeDetector = null;
            }
        }
    }

    @CalledByNative
    private void stopMonitoring(long nativeObserver) {
        Logging.d(TAG, "Stop monitoring with native observer " + nativeObserver);
        stopMonitoring();
        synchronized (this.nativeNetworkObservers) {
            this.nativeNetworkObservers.remove(Long.valueOf(nativeObserver));
        }
    }

    @CalledByNative
    private boolean networkBindingSupported() {
        boolean z;
        synchronized (this.networkChangeDetectorLock) {
            NetworkChangeDetector networkChangeDetector = this.networkChangeDetector;
            z = networkChangeDetector != null && networkChangeDetector.supportNetworkCallback();
        }
        return z;
    }

    @CalledByNative
    private static int androidSdkInt() {
        return Build.VERSION.SDK_INT;
    }

    private NetworkChangeDetector.ConnectionType getCurrentConnectionType() {
        return this.currentConnectionType;
    }

    private NetworkChangeDetector createNetworkChangeDetector(Context appContext) {
        return this.networkChangeDetectorFactory.create(new NetworkChangeDetector.Observer() { // from class: org.webrtc.NetworkMonitor.2
            @Override // org.webrtc.NetworkChangeDetector.Observer
            public void onConnectionTypeChanged(NetworkChangeDetector.ConnectionType newConnectionType) {
                NetworkMonitor.this.updateCurrentConnectionType(newConnectionType);
            }

            @Override // org.webrtc.NetworkChangeDetector.Observer
            public void onNetworkConnect(NetworkChangeDetector.NetworkInformation networkInfo) {
                NetworkMonitor.this.notifyObserversOfNetworkConnect(networkInfo);
            }

            @Override // org.webrtc.NetworkChangeDetector.Observer
            public void onNetworkDisconnect(long networkHandle) {
                NetworkMonitor.this.notifyObserversOfNetworkDisconnect(networkHandle);
            }

            @Override // org.webrtc.NetworkChangeDetector.Observer
            public void onNetworkPreference(List<NetworkChangeDetector.ConnectionType> types, int preference) {
                NetworkMonitor.this.notifyObserversOfNetworkPreference(types, preference);
            }
        }, appContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCurrentConnectionType(NetworkChangeDetector.ConnectionType newConnectionType) {
        this.currentConnectionType = newConnectionType;
        notifyObserversOfConnectionTypeChange(newConnectionType);
    }

    private void notifyObserversOfConnectionTypeChange(NetworkChangeDetector.ConnectionType newConnectionType) {
        ArrayList arrayList;
        Iterator<Long> it = getNativeNetworkObserversSync().iterator();
        while (it.hasNext()) {
            nativeNotifyConnectionTypeChanged(it.next().longValue());
        }
        synchronized (this.networkObservers) {
            arrayList = new ArrayList(this.networkObservers);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((NetworkObserver) it2.next()).onConnectionTypeChanged(newConnectionType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyObserversOfNetworkConnect(NetworkChangeDetector.NetworkInformation networkInfo) {
        Iterator<Long> it = getNativeNetworkObserversSync().iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkConnect(it.next().longValue(), networkInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyObserversOfNetworkDisconnect(long networkHandle) {
        Iterator<Long> it = getNativeNetworkObserversSync().iterator();
        while (it.hasNext()) {
            nativeNotifyOfNetworkDisconnect(it.next().longValue(), networkHandle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyObserversOfNetworkPreference(List<NetworkChangeDetector.ConnectionType> types, int preference) {
        List<Long> nativeNetworkObserversSync = getNativeNetworkObserversSync();
        for (NetworkChangeDetector.ConnectionType connectionType : types) {
            Iterator<Long> it = nativeNetworkObserversSync.iterator();
            while (it.hasNext()) {
                nativeNotifyOfNetworkPreference(it.next().longValue(), connectionType, preference);
            }
        }
    }

    private void updateObserverActiveNetworkList(long nativeObserver) {
        List<NetworkChangeDetector.NetworkInformation> activeNetworkList;
        synchronized (this.networkChangeDetectorLock) {
            NetworkChangeDetector networkChangeDetector = this.networkChangeDetector;
            activeNetworkList = networkChangeDetector == null ? null : networkChangeDetector.getActiveNetworkList();
        }
        if (activeNetworkList == null || activeNetworkList.size() == 0) {
            return;
        }
        nativeNotifyOfActiveNetworkList(nativeObserver, (NetworkChangeDetector.NetworkInformation[]) activeNetworkList.toArray(new NetworkChangeDetector.NetworkInformation[activeNetworkList.size()]));
    }

    private List<Long> getNativeNetworkObserversSync() {
        ArrayList arrayList;
        synchronized (this.nativeNetworkObservers) {
            arrayList = new ArrayList(this.nativeNetworkObservers);
        }
        return arrayList;
    }

    @Deprecated
    public static void addNetworkObserver(NetworkObserver observer) {
        getInstance().addObserver(observer);
    }

    public void addObserver(NetworkObserver observer) {
        synchronized (this.networkObservers) {
            this.networkObservers.add(observer);
        }
    }

    @Deprecated
    public static void removeNetworkObserver(NetworkObserver observer) {
        getInstance().removeObserver(observer);
    }

    public void removeObserver(NetworkObserver observer) {
        synchronized (this.networkObservers) {
            this.networkObservers.remove(observer);
        }
    }

    public static boolean isOnline() {
        return getInstance().getCurrentConnectionType() != NetworkChangeDetector.ConnectionType.CONNECTION_NONE;
    }

    NetworkChangeDetector getNetworkChangeDetector() {
        NetworkChangeDetector networkChangeDetector;
        synchronized (this.networkChangeDetectorLock) {
            networkChangeDetector = this.networkChangeDetector;
        }
        return networkChangeDetector;
    }

    int getNumObservers() {
        int i;
        synchronized (this.networkChangeDetectorLock) {
            i = this.numObservers;
        }
        return i;
    }

    static NetworkMonitorAutoDetect createAndSetAutoDetectForTest(Context context) {
        NetworkMonitor networkMonitor = getInstance();
        NetworkChangeDetector networkChangeDetectorCreateNetworkChangeDetector = networkMonitor.createNetworkChangeDetector(context);
        networkMonitor.networkChangeDetector = networkChangeDetectorCreateNetworkChangeDetector;
        return (NetworkMonitorAutoDetect) networkChangeDetectorCreateNetworkChangeDetector;
    }
}
