package org.rbmain.messenger;

import android.text.TextUtils;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.MessageClient;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.Wearable;
import com.google.android.gms.wearable.WearableListenerService;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import org.rbmain.messenger.NotificationCenter;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatPhoto;
import org.rbmain.tgnet.TLRPC$FileLocation;
import org.rbmain.tgnet.TLRPC$MessageEntity;
import org.rbmain.tgnet.TLRPC$ReplyMarkup;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserProfilePhoto;
import org.rbmain.tgnet.TLRPC$WebPage;

/* loaded from: classes4.dex */
public class WearDataLayerListenerService extends WearableListenerService {
    private static boolean watchConnected;
    private int currentAccount = UserConfig.selectedAccount;

    @Override // com.google.android.gms.wearable.WearableListenerService, android.app.Service
    public void onCreate() {
        super.onCreate();
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("WearableDataLayer service created");
        }
    }

    @Override // com.google.android.gms.wearable.WearableListenerService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("WearableDataLayer service destroyed");
        }
    }

    @Override // com.google.android.gms.wearable.WearableListenerService, com.google.android.gms.wearable.ChannelApi$ChannelListener
    public void onChannelOpened(Channel channel) throws InterruptedException, TimeoutException, IOException, BrokenBarrierException {
        TLRPC$ChatPhoto tLRPC$ChatPhoto;
        TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto;
        GoogleApiClient googleApiClientBuild = new GoogleApiClient.Builder(this).addApi(Wearable.API).build();
        if (!googleApiClientBuild.blockingConnect().isSuccess()) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("failed to connect google api client");
                return;
            }
            return;
        }
        String path = channel.getPath();
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("wear channel path: " + path);
        }
        try {
            if ("/getCurrentUser".equals(path)) {
                DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(((Channel.GetOutputStreamResult) channel.getOutputStream(googleApiClientBuild).await()).getOutputStream()));
                if (UserConfig.getInstance(this.currentAccount).isClientActivated()) {
                    final TLRPC$User currentUser = UserConfig.getInstance(this.currentAccount).getCurrentUser();
                    dataOutputStream.writeInt(currentUser.id);
                    dataOutputStream.writeUTF(currentUser.first_name);
                    dataOutputStream.writeUTF(currentUser.last_name);
                    dataOutputStream.writeUTF(currentUser.phone);
                    TLRPC$UserProfilePhoto tLRPC$UserProfilePhoto2 = currentUser.photo;
                    if (tLRPC$UserProfilePhoto2 != null) {
                        final File pathToAttach = FileLoader.getPathToAttach(tLRPC$UserProfilePhoto2.photo_small, true);
                        final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
                        if (!pathToAttach.exists()) {
                            final NotificationCenter.NotificationCenterDelegate notificationCenterDelegate = new NotificationCenter.NotificationCenterDelegate() { // from class: org.rbmain.messenger.WearDataLayerListenerService$$ExternalSyntheticLambda7
                                @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
                                public final void didReceivedNotification(int i, int i2, Object[] objArr) throws InterruptedException, TimeoutException, BrokenBarrierException {
                                    WearDataLayerListenerService.lambda$onChannelOpened$0(pathToAttach, cyclicBarrier, i, i2, objArr);
                                }
                            };
                            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.WearDataLayerListenerService$$ExternalSyntheticLambda6
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onChannelOpened$1(notificationCenterDelegate, currentUser);
                                }
                            });
                            try {
                                cyclicBarrier.await(10L, TimeUnit.SECONDS);
                            } catch (Exception unused) {
                            }
                            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.WearDataLayerListenerService$$ExternalSyntheticLambda5
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f$0.lambda$onChannelOpened$2(notificationCenterDelegate);
                                }
                            });
                        }
                        if (pathToAttach.exists() && pathToAttach.length() <= 52428800) {
                            int length = (int) pathToAttach.length();
                            byte[] bArr = new byte[length];
                            FileInputStream fileInputStream = new FileInputStream(pathToAttach);
                            new DataInputStream(fileInputStream).readFully(bArr);
                            fileInputStream.close();
                            dataOutputStream.writeInt(length);
                            dataOutputStream.write(bArr);
                        } else {
                            dataOutputStream.writeInt(0);
                        }
                    } else {
                        dataOutputStream.writeInt(0);
                    }
                } else {
                    dataOutputStream.writeInt(0);
                }
                dataOutputStream.flush();
                dataOutputStream.close();
            } else {
                TLRPC$FileLocation tLRPC$FileLocation = null;
                if ("/waitForAuthCode".equals(path)) {
                    ConnectionsManager.getInstance(this.currentAccount).setAppPaused(false, false);
                    final String[] strArr = {null};
                    final CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2);
                    final NotificationCenter.NotificationCenterDelegate notificationCenterDelegate2 = new NotificationCenter.NotificationCenterDelegate() { // from class: org.rbmain.messenger.WearDataLayerListenerService$$ExternalSyntheticLambda8
                        @Override // org.rbmain.messenger.NotificationCenter.NotificationCenterDelegate
                        public final void didReceivedNotification(int i, int i2, Object[] objArr) throws InterruptedException, TimeoutException, BrokenBarrierException {
                            WearDataLayerListenerService.lambda$onChannelOpened$3(strArr, cyclicBarrier2, i, i2, objArr);
                        }
                    };
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.WearDataLayerListenerService$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onChannelOpened$4(notificationCenterDelegate2);
                        }
                    });
                    try {
                        cyclicBarrier2.await(30L, TimeUnit.SECONDS);
                    } catch (Exception unused2) {
                    }
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.WearDataLayerListenerService$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$onChannelOpened$5(notificationCenterDelegate2);
                        }
                    });
                    DataOutputStream dataOutputStream2 = new DataOutputStream(((Channel.GetOutputStreamResult) channel.getOutputStream(googleApiClientBuild).await()).getOutputStream());
                    if (strArr[0] != null) {
                        dataOutputStream2.writeUTF(strArr[0]);
                    } else {
                        dataOutputStream2.writeUTF(io.github.inflationx.calligraphy3.BuildConfig.FLAVOR);
                    }
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                    ConnectionsManager.getInstance(this.currentAccount).setAppPaused(true, false);
                } else if ("/getChatPhoto".equals(path)) {
                    try {
                        DataInputStream dataInputStream = new DataInputStream(((Channel.GetInputStreamResult) channel.getInputStream(googleApiClientBuild).await()).getInputStream());
                        try {
                            DataOutputStream dataOutputStream3 = new DataOutputStream(((Channel.GetOutputStreamResult) channel.getOutputStream(googleApiClientBuild).await()).getOutputStream());
                            try {
                                JSONObject jSONObject = new JSONObject(dataInputStream.readUTF());
                                int i = jSONObject.getInt("chat_id");
                                int i2 = jSONObject.getInt("account_id");
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= UserConfig.getActivatedAccountsCount()) {
                                        i3 = -1;
                                        break;
                                    } else if (UserConfig.getInstance(i3).getClientUserId() == i2) {
                                        break;
                                    } else {
                                        i3++;
                                    }
                                }
                                if (i3 != -1) {
                                    if (i > 0) {
                                        TLRPC$User user = MessagesController.getInstance(i3).getUser(Integer.valueOf(i));
                                        if (user != null && (tLRPC$UserProfilePhoto = user.photo) != null) {
                                            tLRPC$FileLocation = tLRPC$UserProfilePhoto.photo_small;
                                        }
                                    } else {
                                        TLRPC$Chat chat = MessagesController.getInstance(i3).getChat(Integer.valueOf(-i));
                                        if (chat != null && (tLRPC$ChatPhoto = chat.photo) != null) {
                                            tLRPC$FileLocation = tLRPC$ChatPhoto.photo_small;
                                        }
                                    }
                                    if (tLRPC$FileLocation != null) {
                                        File pathToAttach2 = FileLoader.getPathToAttach(tLRPC$FileLocation, true);
                                        if (pathToAttach2.exists() && pathToAttach2.length() < 102400) {
                                            dataOutputStream3.writeInt((int) pathToAttach2.length());
                                            FileInputStream fileInputStream2 = new FileInputStream(pathToAttach2);
                                            byte[] bArr2 = new byte[10240];
                                            while (true) {
                                                int i4 = fileInputStream2.read(bArr2);
                                                if (i4 <= 0) {
                                                    break;
                                                } else {
                                                    dataOutputStream3.write(bArr2, 0, i4);
                                                }
                                            }
                                            fileInputStream2.close();
                                        } else {
                                            dataOutputStream3.writeInt(0);
                                        }
                                    } else {
                                        dataOutputStream3.writeInt(0);
                                    }
                                } else {
                                    dataOutputStream3.writeInt(0);
                                }
                                dataOutputStream3.flush();
                                dataOutputStream3.close();
                                dataInputStream.close();
                            } catch (Throwable th) {
                                try {
                                    dataOutputStream3.close();
                                } catch (Throwable unused3) {
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            try {
                                dataInputStream.close();
                            } catch (Throwable unused4) {
                            }
                            throw th2;
                        }
                    } catch (Exception unused5) {
                    }
                }
            }
        } catch (Exception e) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e("error processing wear request", e);
            }
        }
        channel.close(googleApiClientBuild).await();
        googleApiClientBuild.disconnect();
        if (BuildVars.LOGS_ENABLED) {
            FileLog.d("WearableDataLayer channel thread exiting");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onChannelOpened$0(File file, CyclicBarrier cyclicBarrier, int i, int i2, Object[] objArr) throws InterruptedException, TimeoutException, BrokenBarrierException {
        if (i == NotificationCenter.fileDidLoad) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("file loaded: " + objArr[0] + " " + objArr[0].getClass().getName());
            }
            if (objArr[0].equals(file.getName())) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.e("LOADED USER PHOTO");
                }
                try {
                    cyclicBarrier.await(10L, TimeUnit.MILLISECONDS);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onChannelOpened$1(NotificationCenter.NotificationCenterDelegate notificationCenterDelegate, TLRPC$User tLRPC$User) {
        NotificationCenter.getInstance(this.currentAccount).addObserver(notificationCenterDelegate, NotificationCenter.fileDidLoad);
        FileLoader.getInstance(this.currentAccount).loadFile(ImageLocation.getForUserOrChat(tLRPC$User, 1), tLRPC$User, null, 1, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onChannelOpened$2(NotificationCenter.NotificationCenterDelegate notificationCenterDelegate) {
        NotificationCenter.getInstance(this.currentAccount).removeObserver(notificationCenterDelegate, NotificationCenter.fileDidLoad);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onChannelOpened$3(String[] strArr, CyclicBarrier cyclicBarrier, int i, int i2, Object[] objArr) throws InterruptedException, TimeoutException, BrokenBarrierException {
        if (i == NotificationCenter.didReceiveNewMessages && ((Long) objArr[0]).longValue() == 777000) {
            ArrayList arrayList = (ArrayList) objArr[1];
            if (arrayList.size() > 0) {
                MessageObject messageObject = (MessageObject) arrayList.get(0);
                if (TextUtils.isEmpty(messageObject.messageText)) {
                    return;
                }
                Matcher matcher = Pattern.compile("[0-9]+").matcher(messageObject.messageText);
                if (matcher.find()) {
                    strArr[0] = matcher.group();
                    try {
                        cyclicBarrier.await(10L, TimeUnit.MILLISECONDS);
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onChannelOpened$4(NotificationCenter.NotificationCenterDelegate notificationCenterDelegate) {
        NotificationCenter.getInstance(this.currentAccount).addObserver(notificationCenterDelegate, NotificationCenter.didReceiveNewMessages);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onChannelOpened$5(NotificationCenter.NotificationCenterDelegate notificationCenterDelegate) {
        NotificationCenter.getInstance(this.currentAccount).removeObserver(notificationCenterDelegate, NotificationCenter.didReceiveNewMessages);
    }

    @Override // com.google.android.gms.wearable.WearableListenerService, com.google.android.gms.wearable.MessageApi.MessageListener
    public void onMessageReceived(final MessageEvent messageEvent) {
        if ("/reply".equals(messageEvent.getPath())) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.WearDataLayerListenerService$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() throws JSONException {
                    WearDataLayerListenerService.lambda$onMessageReceived$6(messageEvent);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onMessageReceived$6(MessageEvent messageEvent) throws JSONException {
        try {
            ApplicationLoader.postInitApplication();
            JSONObject jSONObject = new JSONObject(new String(messageEvent.getData(), Utf8Charset.NAME));
            String string = jSONObject.getString("text");
            if (string != null && string.length() != 0) {
                long j = jSONObject.getLong("chat_id");
                long j2 = jSONObject.getInt("max_id");
                int i = jSONObject.getInt("account_id");
                int i2 = 0;
                while (true) {
                    if (i2 >= UserConfig.getActivatedAccountsCount()) {
                        i2 = -1;
                        break;
                    } else if (UserConfig.getInstance(i2).getClientUserId() == i) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (j != 0 && j2 != 0 && i2 != -1) {
                    SendMessagesHelper.getInstance(i2).sendMessage(string.toString(), j, (MessageObject) null, (MessageObject) null, (TLRPC$WebPage) null, true, (ArrayList<TLRPC$MessageEntity>) null, (TLRPC$ReplyMarkup) null, (HashMap<String, String>) null, true, 0);
                    MessagesController.getInstance(i2).markDialogAsRead(j, j2, j2, 0, false, 0L, 0, true, 0);
                }
            }
        } catch (Exception e) {
            if (BuildVars.LOGS_ENABLED) {
                FileLog.e(e);
            }
        }
    }

    public static void sendMessageToWatch(final String str, final byte[] bArr, String str2) {
        Wearable.getCapabilityClient(ApplicationLoader.applicationContext).getCapability(str2, 1).addOnCompleteListener(new OnCompleteListener() { // from class: org.rbmain.messenger.WearDataLayerListenerService$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                WearDataLayerListenerService.lambda$sendMessageToWatch$7(str, bArr, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendMessageToWatch$7(String str, byte[] bArr, Task task) {
        CapabilityInfo capabilityInfo = (CapabilityInfo) task.getResult();
        if (capabilityInfo != null) {
            MessageClient messageClient = Wearable.getMessageClient(ApplicationLoader.applicationContext);
            Iterator<Node> it = capabilityInfo.getNodes().iterator();
            while (it.hasNext()) {
                messageClient.sendMessage(it.next().getId(), str, bArr);
            }
        }
    }

    @Override // com.google.android.gms.wearable.WearableListenerService, com.google.android.gms.wearable.CapabilityApi.CapabilityListener
    public void onCapabilityChanged(CapabilityInfo capabilityInfo) {
        if ("remote_notifications".equals(capabilityInfo.getName())) {
            watchConnected = false;
            Iterator<Node> it = capabilityInfo.getNodes().iterator();
            while (it.hasNext()) {
                if (it.next().isNearby()) {
                    watchConnected = true;
                }
            }
        }
    }

    public static void updateWatchConnectionState() {
        try {
            Wearable.getCapabilityClient(ApplicationLoader.applicationContext).getCapability("remote_notifications", 1).addOnCompleteListener(new OnCompleteListener() { // from class: org.rbmain.messenger.WearDataLayerListenerService$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    WearDataLayerListenerService.lambda$updateWatchConnectionState$8(task);
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateWatchConnectionState$8(Task task) {
        watchConnected = false;
        try {
            CapabilityInfo capabilityInfo = (CapabilityInfo) task.getResult();
            if (capabilityInfo == null) {
                return;
            }
            Iterator<Node> it = capabilityInfo.getNodes().iterator();
            while (it.hasNext()) {
                if (it.next().isNearby()) {
                    watchConnected = true;
                }
            }
        } catch (Exception unused) {
        }
    }

    public static boolean isWatchConnected() {
        return watchConnected;
    }
}
