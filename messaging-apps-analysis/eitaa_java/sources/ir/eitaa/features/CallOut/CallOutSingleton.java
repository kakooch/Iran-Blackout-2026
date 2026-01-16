package ir.eitaa.features.CallOut;

import ir.eitaa.messenger.ApplicationLoader;
import ir.eitaa.messenger.ContactsController;
import ir.eitaa.messenger.SharedConfig;
import ir.eitaa.messenger.Utilities;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.linphone.core.Call;
import org.linphone.core.Core;
import org.linphone.core.Factory;

/* loaded from: classes.dex */
public class CallOutSingleton {
    private static volatile CallOutSingleton instance;
    private static Object mutex = new Object();
    public Core core;
    Factory factory;
    private int lastCrtState = 0;
    public ContactsController.Contact lastCallContact = null;
    public long lastCallStartTime = 0;
    public Call.State lastCallState = null;
    public String lastCallMessage = "";

    interface CallOutDelegate {
        void onInitializeFinished();
    }

    private CallOutSingleton() {
    }

    public static CallOutSingleton getInstance() {
        CallOutSingleton callOutSingleton = instance;
        if (callOutSingleton == null) {
            synchronized (mutex) {
                callOutSingleton = instance;
                if (callOutSingleton == null) {
                    callOutSingleton = new CallOutSingleton();
                    instance = callOutSingleton;
                }
            }
        }
        return callOutSingleton;
    }

    public void start(final CallOutDelegate delegate) {
        Utilities.globalQueue.postRunnable(new Runnable() { // from class: ir.eitaa.features.CallOut.CallOutSingleton.1
            @Override // java.lang.Runnable
            public void run() throws IOException {
                CallOutSingleton callOutSingleton = CallOutSingleton.this;
                if (callOutSingleton.core == null || callOutSingleton.lastCrtState != SharedConfig.crtState) {
                    CallOutSingleton.this.factory = Factory.instance();
                    CallOutSingleton.this.factory.setDebugMode(false, "Linphone");
                    CallOutSingleton callOutSingleton2 = CallOutSingleton.this;
                    callOutSingleton2.core = callOutSingleton2.factory.createCore(null, null, ApplicationLoader.applicationContext);
                    CallOutSingleton.this.lastCrtState = SharedConfig.crtState;
                    String strCopyAssetToInternalStorage = CallOutSingleton.this.copyAssetToInternalStorage("cotlsLong.crt");
                    String strCopyAssetToInternalStorage2 = CallOutSingleton.this.copyAssetToInternalStorage("cotlsLong.key");
                    CallOutSingleton.this.core.setTlsCertPath(strCopyAssetToInternalStorage);
                    CallOutSingleton.this.core.setTlsKeyPath(strCopyAssetToInternalStorage2);
                    delegate.onInitializeFinished();
                    return;
                }
                delegate.onInitializeFinished();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String copyAssetToInternalStorage(String assetName) throws IOException {
        File file = new File(ApplicationLoader.applicationContext.getFilesDir(), assetName);
        if (!file.exists()) {
            try {
                InputStream inputStreamOpen = ApplicationLoader.applicationContext.getAssets().open(assetName);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[org.linphone.mediastream.Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV];
                while (true) {
                    int i = inputStreamOpen.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
                inputStreamOpen.close();
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return file.getAbsolutePath();
    }
}
