package ir.eitaa.tgnet;

import android.content.SharedPreferences;
import ir.eitaa.helper.http.HelperHttp;
import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.Utilities;
import ir.eitaa.tgnet.TcpConnection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class DataCenter {
    private volatile HelperHttp connection;
    public int datacenterId;
    private volatile HelperHttp downloadConnection;
    public volatile TcpConnection tcpConnection;
    private volatile TcpConnection tcpDownloadConnection;
    public volatile TcpConnection tcpPushConnection;
    private volatile TcpConnection tcpUploadConnection;
    private volatile HelperHttp uploadConnection;
    public List<String> addressesIpv4 = new ArrayList();
    public List<String> addressesIpv4Download = new ArrayList();
    public List<String> addressesIpv4Upload = new ArrayList();
    public List<String> tcpAddressesIpv4 = new ArrayList();
    public List<String> tcpAddressesIpv4Download = new ArrayList();
    public List<String> tcpAddressesIpv4Upload = new ArrayList();
    private volatile int currentAddressNumIpv4 = 0;
    private volatile int currentAddressNumIpv4Download = 0;
    private volatile int currentAddressNumIpv4Upload = 0;
    private volatile int currentTcpAddressNumIpv4 = 0;
    private volatile int currentTcpAddressNumIpv4Download = 0;
    private volatile int currentTcpAddressNumIpv4Upload = 0;
    private volatile boolean createNewConnection = false;
    private volatile boolean createNewDownloadConnection = false;
    private volatile boolean createNewUploadConnection = false;
    public HashMap<String, Integer> ports = new HashMap<>();
    public int overridePort = -1;

    public DataCenter(int datacenterId) {
        this.datacenterId = datacenterId;
    }

    public DataCenter(SerializedData data, int version) throws IOException {
        if (version == 0) {
            this.datacenterId = 1;
            int int32 = data.readInt32(false);
            for (int i = 0; i < int32; i++) {
                data.readInt32(false);
                String string = data.readString(false);
                data.readInt32(false);
                if ((data.readInt32(false) & 2) != 0) {
                    this.addressesIpv4Download.add(string);
                    this.addressesIpv4Upload.add(string);
                } else {
                    this.addressesIpv4.add(string);
                }
                this.ports.put(string, 443);
            }
        } else if (version == 1 && data.readInt32(false) == 1) {
            this.datacenterId = data.readInt32(false);
            int int322 = data.readInt32(false);
            for (int i2 = 0; i2 < int322; i2++) {
                String string2 = data.readString(false);
                this.addressesIpv4.add(string2);
                this.ports.put(string2, Integer.valueOf(data.readInt32(false)));
            }
            int int323 = data.readInt32(false);
            for (int i3 = 0; i3 < int323; i3++) {
                String string3 = data.readString(false);
                this.addressesIpv4Download.add(string3);
                this.ports.put(string3, Integer.valueOf(data.readInt32(false)));
            }
            int int324 = data.readInt32(false);
            for (int i4 = 0; i4 < int324; i4++) {
                String string4 = data.readString(false);
                this.addressesIpv4Upload.add(string4);
                this.ports.put(string4, Integer.valueOf(data.readInt32(false)));
            }
            int int325 = data.readInt32(false);
            for (int i5 = 0; i5 < int325; i5++) {
                String string5 = data.readString(false);
                this.tcpAddressesIpv4Upload.add(string5);
                this.ports.put(string5, Integer.valueOf(data.readInt32(false)));
            }
            int int326 = data.readInt32(false);
            for (int i6 = 0; i6 < int326; i6++) {
                String string6 = data.readString(false);
                this.tcpAddressesIpv4Download.add(string6);
                this.ports.put(string6, Integer.valueOf(data.readInt32(false)));
            }
            int int327 = data.readInt32(false);
            for (int i7 = 0; i7 < int327; i7++) {
                String string7 = data.readString(false);
                this.tcpAddressesIpv4.add(string7);
                this.ports.put(string7, Integer.valueOf(data.readInt32(false)));
            }
        }
        readCurrentAddressAndPortNum();
    }

    public synchronized String getCurrentAddress(int flags) {
        int i;
        List<String> list;
        int i2 = flags & 4;
        try {
            if (i2 != 0) {
                i = this.currentAddressNumIpv4Upload;
                list = this.addressesIpv4Upload;
            } else if ((flags & 2) != 0) {
                i = this.currentAddressNumIpv4Download;
                list = this.addressesIpv4Download;
            } else if ((flags & 32) != 0) {
                i = this.currentTcpAddressNumIpv4Upload;
                list = this.tcpAddressesIpv4Upload;
            } else if ((flags & 16) != 0) {
                i = this.currentTcpAddressNumIpv4Download;
                list = this.tcpAddressesIpv4Download;
            } else if ((flags & 64) != 0) {
                i = this.currentTcpAddressNumIpv4;
                list = this.tcpAddressesIpv4;
            } else {
                i = this.currentAddressNumIpv4;
                list = this.addressesIpv4;
            }
            if (list.isEmpty()) {
                return null;
            }
            if (i >= list.size()) {
                i = 0;
                if (i2 != 0) {
                    this.currentAddressNumIpv4Upload = 0;
                } else if ((flags & 2) != 0) {
                    this.currentAddressNumIpv4Download = 0;
                } else if ((flags & 32) != 0) {
                    this.currentTcpAddressNumIpv4Upload = 0;
                } else if ((flags & 16) != 0) {
                    this.currentTcpAddressNumIpv4Download = 0;
                } else if ((flags & 64) != 0) {
                    this.currentTcpAddressNumIpv4 = 0;
                } else {
                    this.currentAddressNumIpv4 = 0;
                }
            }
            return list.get(i);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized int getCurrentPort(int flags) {
        if (this.ports.isEmpty()) {
            int i = this.overridePort;
            return i != -1 ? i : 443;
        }
        Integer num = this.ports.get(getCurrentAddress(flags));
        if (num != null) {
            iIntValue = num.intValue();
        } else {
            int i2 = this.overridePort;
            if (i2 != -1) {
                iIntValue = i2;
            }
        }
        return iIntValue;
    }

    public synchronized void addAddressAndPort(String address, int port, int flags) {
        List<String> list;
        try {
            if ((flags & 4) != 0) {
                list = this.addressesIpv4Upload;
            } else if ((flags & 2) != 0) {
                list = this.addressesIpv4Download;
            } else if ((flags & 32) != 0) {
                list = this.tcpAddressesIpv4Upload;
            } else if ((flags & 16) != 0) {
                list = this.tcpAddressesIpv4Download;
            } else if ((flags & 64) != 0) {
                list = this.tcpAddressesIpv4;
            } else {
                list = this.addressesIpv4;
            }
            if (list.contains(address)) {
                return;
            }
            list.add(address);
            this.ports.put(address, Integer.valueOf(port));
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void nextAddress(int flags) {
        int i;
        List<String> list;
        int i2 = flags & 4;
        try {
            if (i2 != 0) {
                i = this.currentAddressNumIpv4Upload;
                list = this.addressesIpv4Upload;
            } else if ((flags & 2) != 0) {
                i = this.currentAddressNumIpv4Download;
                list = this.addressesIpv4Download;
            } else if ((flags & 32) != 0) {
                i = this.currentTcpAddressNumIpv4Upload;
                list = this.tcpAddressesIpv4Upload;
            } else if ((flags & 16) != 0) {
                i = this.currentTcpAddressNumIpv4Download;
                list = this.tcpAddressesIpv4Download;
            } else if ((flags & 64) != 0) {
                i = this.currentTcpAddressNumIpv4;
                list = this.tcpAddressesIpv4;
            } else {
                i = this.currentAddressNumIpv4;
                list = this.addressesIpv4;
            }
            int i3 = i + 1;
            if (i3 >= list.size()) {
                i3 = 0;
            }
            if (i2 != 0) {
                this.currentAddressNumIpv4Upload = i3;
                this.createNewUploadConnection = true;
            } else if ((flags & 2) != 0) {
                this.currentAddressNumIpv4Download = i3;
                this.createNewDownloadConnection = true;
            } else if ((flags & 32) != 0) {
                this.currentTcpAddressNumIpv4Upload = i3;
                this.createNewUploadConnection = true;
            } else if ((flags & 16) != 0) {
                this.currentAddressNumIpv4Download = i3;
                this.createNewDownloadConnection = true;
            } else if ((flags & 64) != 0) {
                this.currentTcpAddressNumIpv4 = i3;
                this.createNewDownloadConnection = true;
            } else {
                this.currentAddressNumIpv4 = i3;
                this.createNewConnection = true;
            }
            storeCurrentAddressAndPortNum();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void storeCurrentAddressAndPortNum() {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: ir.eitaa.tgnet.DataCenter.1
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor editorEdit = ApplicationLoader.applicationContext.getSharedPreferences("dataconfig", 0).edit();
                editorEdit.putInt("dc" + DataCenter.this.datacenterId + "address", DataCenter.this.currentAddressNumIpv4);
                editorEdit.putInt("dc" + DataCenter.this.datacenterId + "addressD", DataCenter.this.currentAddressNumIpv4Download);
                editorEdit.putInt("dc" + DataCenter.this.datacenterId + "addressU", DataCenter.this.currentAddressNumIpv4Upload);
                editorEdit.commit();
            }
        });
    }

    private synchronized void readCurrentAddressAndPortNum() {
        SharedPreferences sharedPreferences = ApplicationLoader.applicationContext.getSharedPreferences("dataconfig", 0);
        this.currentAddressNumIpv4 = sharedPreferences.getInt("dc" + this.datacenterId + "address", 0);
        this.currentAddressNumIpv4Download = sharedPreferences.getInt("dc" + this.datacenterId + "addressD", 0);
        this.currentAddressNumIpv4Upload = sharedPreferences.getInt("dc" + this.datacenterId + "addressU", 0);
    }

    public synchronized void replaceAddressesAndPorts(List<String> newAddresses, HashMap<String, Integer> newPorts, int flags) {
        List<String> list;
        int i = flags & 4;
        try {
            if (i != 0) {
                list = this.addressesIpv4Upload;
            } else if ((flags & 2) != 0) {
                list = this.addressesIpv4Download;
            } else if ((flags & 32) != 0) {
                list = this.tcpAddressesIpv4Upload;
            } else if ((flags & 16) != 0) {
                list = this.tcpAddressesIpv4Download;
            } else if ((flags & 64) != 0) {
                list = this.tcpAddressesIpv4;
            } else {
                list = this.addressesIpv4;
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.ports.remove(it.next());
            }
            if (i != 0) {
                this.addressesIpv4Upload = newAddresses;
                this.createNewUploadConnection = true;
            } else if ((flags & 2) != 0) {
                this.addressesIpv4Download = newAddresses;
                this.createNewDownloadConnection = true;
            } else if ((flags & 32) != 0) {
                this.tcpAddressesIpv4Upload = newAddresses;
                this.createNewDownloadConnection = true;
            } else if ((flags & 16) != 0) {
                this.tcpAddressesIpv4Download = newAddresses;
                this.createNewDownloadConnection = true;
            } else if ((flags & 64) != 0) {
                this.tcpAddressesIpv4 = newAddresses;
                this.createNewDownloadConnection = true;
            } else {
                this.addressesIpv4 = newAddresses;
                this.createNewConnection = true;
            }
            this.ports.putAll(newPorts);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void SerializeToStream(SerializedData stream) {
        stream.writeInt32(1);
        stream.writeInt32(this.datacenterId);
        stream.writeInt32(this.addressesIpv4.size());
        for (String str : this.addressesIpv4) {
            stream.writeString(str);
            stream.writeInt32(this.ports.get(str).intValue());
        }
        stream.writeInt32(this.addressesIpv4Download.size());
        for (String str2 : this.addressesIpv4Download) {
            stream.writeString(str2);
            stream.writeInt32(this.ports.get(str2).intValue());
        }
        stream.writeInt32(this.addressesIpv4Upload.size());
        for (String str3 : this.addressesIpv4Upload) {
            stream.writeString(str3);
            stream.writeInt32(this.ports.get(str3).intValue());
        }
        stream.writeInt32(this.tcpAddressesIpv4Upload.size());
        for (String str4 : this.tcpAddressesIpv4Upload) {
            stream.writeString(str4);
            stream.writeInt32(this.ports.get(str4).intValue());
        }
        stream.writeInt32(this.tcpAddressesIpv4Download.size());
        for (String str5 : this.tcpAddressesIpv4Download) {
            stream.writeString(str5);
            stream.writeInt32(this.ports.get(str5).intValue());
        }
        stream.writeInt32(this.tcpAddressesIpv4.size());
        for (String str6 : this.tcpAddressesIpv4) {
            stream.writeString(str6);
            stream.writeInt32(this.ports.get(str6).intValue());
        }
    }

    public synchronized HelperHttp getDownloadConnection() {
        if (this.downloadConnection == null || this.createNewDownloadConnection) {
            this.createNewDownloadConnection = false;
            this.downloadConnection = new HelperHttp(getCurrentAddress(2), getCurrentPort(2), "/eitaa/index.php");
        }
        return this.downloadConnection;
    }

    public synchronized HelperHttp getUploadConnection() {
        if (this.uploadConnection == null || this.createNewUploadConnection) {
            this.createNewUploadConnection = false;
            this.uploadConnection = new HelperHttp(getCurrentAddress(4), getCurrentPort(4), "/eitaa/index.php");
        }
        return this.uploadConnection;
    }

    public synchronized HelperHttp getGenericConnection() {
        if (this.connection == null || this.createNewConnection) {
            this.createNewConnection = false;
            this.connection = new HelperHttp(getCurrentAddress(0), getCurrentPort(0), "/eitaa/index.php");
        }
        return this.connection;
    }

    public TcpConnection getTcpDownloadConnection(TcpConnection.TcpConnectionDelegate delegate, int currentAccount) {
        if (this.tcpDownloadConnection == null) {
            this.tcpDownloadConnection = new TcpConnection(this.datacenterId, currentAccount);
            this.tcpDownloadConnection.delegate = delegate;
            this.tcpDownloadConnection.transportRequestClass = 16;
        }
        this.tcpDownloadConnection.connect();
        return this.tcpDownloadConnection;
    }

    public TcpConnection getTcpUploadConnection(TcpConnection.TcpConnectionDelegate delegate, int currentAccount) {
        if (this.tcpUploadConnection == null) {
            this.tcpUploadConnection = new TcpConnection(this.datacenterId, currentAccount);
            this.tcpUploadConnection.delegate = delegate;
            this.tcpUploadConnection.transportRequestClass = 32;
        }
        this.tcpUploadConnection.connect();
        return this.tcpUploadConnection;
    }

    public TcpConnection getTcpGenericConnection(TcpConnection.TcpConnectionDelegate delegate, int currentAccount) {
        if (this.tcpConnection == null) {
            this.tcpConnection = new TcpConnection(this.datacenterId, currentAccount);
            this.tcpConnection.delegate = delegate;
            this.tcpConnection.transportRequestClass = 64;
        }
        this.tcpConnection.connect();
        return this.tcpConnection;
    }

    public void suspendConnections() {
        if (this.tcpConnection != null) {
            this.tcpConnection.suspendConnection(true);
        }
        if (this.tcpDownloadConnection != null) {
            this.tcpUploadConnection.suspendConnection(true);
        }
        if (this.tcpDownloadConnection != null) {
            this.tcpDownloadConnection.suspendConnection(true);
        }
    }
}
