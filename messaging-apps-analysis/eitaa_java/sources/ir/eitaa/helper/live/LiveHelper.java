package ir.eitaa.helper.live;

import android.app.Activity;
import android.content.Intent;
import ir.eitaa.messenger.AndroidUtilities;
import ir.eitaa.messenger.FileLog;
import ir.eitaa.messenger.MessageObject;
import ir.eitaa.messenger.MessagesController;
import ir.eitaa.messenger.NotificationCenter;
import ir.eitaa.messenger.SendMessagesHelper;
import ir.eitaa.messenger.UserConfig;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$TL_LiveStreamStateEnded;
import ir.eitaa.tgnet.TLRPC$TL_LiveStreamStateInit;
import ir.eitaa.tgnet.TLRPC$TL_Live_getMedia;
import ir.eitaa.tgnet.TLRPC$TL_Live_getParticipants;
import ir.eitaa.tgnet.TLRPC$TL_Live_participants;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_inputMediaLiveStream;
import ir.eitaa.tgnet.TLRPC$TL_messageMediaLiveStream;
import ir.eitaa.tgnet.TLRPC$TL_messages_editMessage;
import ir.eitaa.tgnet.TLRPC$Updates;
import ir.eitaa.tgnet.TLRPC$User;
import java.util.List;

/* loaded from: classes.dex */
public class LiveHelper implements NotificationCenter.NotificationCenterDelegate {
    private static long dialog_id;
    private int currentAccount = UserConfig.selectedAccount;
    private int state = -1;
    private int previousState = -1;
    private LiveHelperDelegate delegate = null;
    private MessageObject messageObject = null;
    private String writeLink = "";
    private boolean shouldSendResumeSignal = false;
    private boolean pollingState = false;
    private Runnable statePollRunnable = new Runnable() { // from class: ir.eitaa.helper.live.LiveHelper.1
        @Override // java.lang.Runnable
        public void run() {
            if (LiveHelper.this.messageObject != null) {
                LiveHelper.this.pollState();
            }
            if (LiveHelper.this.statePollRunnable != null) {
                AndroidUtilities.runOnUIThread(LiveHelper.this.statePollRunnable, 15000L);
            }
        }
    };

    public interface GetParticipantsCallback {
        void participantsLoaded(List<TLRPC$User> users);
    }

    public interface LiveHelperDelegate {
        void onMessageReceivedByServer(int messageId);

        void onNewMessage(MessageObject messageObject);

        void onNewTotalViewers(int totalViewers);

        void onStateChanged(int newState);
    }

    public static void startLive(final Activity activity, long did, int msgId) {
        Intent intent = new Intent(activity, (Class<?>) LiveVideoBroadcasterActivity.class);
        intent.putExtra("dialog_id", did);
        intent.putExtra("msg_id", msgId);
        intent.putExtra("account", UserConfig.selectedAccount);
        try {
            dialog_id = did;
            activity.startActivity(intent);
        } catch (Throwable th) {
            FileLog.e(th);
        }
    }

    public void sendLiveStartRequest(String caption, byte[] thumb) {
        if (setState(2)) {
            TLRPC$TL_messageMediaLiveStream tLRPC$TL_messageMediaLiveStream = new TLRPC$TL_messageMediaLiveStream();
            tLRPC$TL_messageMediaLiveStream.state = new TLRPC$TL_LiveStreamStateInit();
            SendMessagesHelper.getInstance(this.currentAccount).sendMessage(tLRPC$TL_messageMediaLiveStream, caption, thumb, dialog_id, null, null, null);
        }
    }

    public void setDelegate(LiveHelperDelegate delegate) {
        this.delegate = delegate;
    }

    public String getWriteLink() {
        return this.writeLink;
    }

    public void onBroadcastingStarted() {
        setState(5);
    }

    public void onReady() {
        setState(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void resume(int r9) throws java.lang.InterruptedException {
        /*
            r8 = this;
            r0 = 8
            boolean r0 = r8.setState(r0)
            if (r0 == 0) goto L7f
            long r0 = ir.eitaa.helper.live.LiveHelper.dialog_id
            int r2 = (int) r0
            r3 = 0
            if (r2 == 0) goto L15
            int r1 = (int) r0
            if (r1 >= 0) goto L13
            int r0 = -r1
            goto L16
        L13:
            r0 = 0
            goto L17
        L15:
            r0 = 0
        L16:
            r1 = 0
        L17:
            r2 = 1
            if (r0 == 0) goto L74
            ir.eitaa.tgnet.TLRPC$Chat[] r4 = new ir.eitaa.tgnet.TLRPC$Chat[r2]
            int r5 = r8.currentAccount
            ir.eitaa.messenger.MessagesController r5 = ir.eitaa.messenger.MessagesController.getInstance(r5)
            long r6 = (long) r0
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            ir.eitaa.tgnet.TLRPC$Chat r5 = r5.getChat(r6)
            r4[r3] = r5
            r5 = r4[r3]
            if (r5 != 0) goto L5f
            java.util.concurrent.Semaphore r5 = new java.util.concurrent.Semaphore
            r5.<init>(r3)
            int r6 = r8.currentAccount
            ir.eitaa.messenger.MessagesStorage r6 = ir.eitaa.messenger.MessagesStorage.getInstance(r6)
            ir.eitaa.messenger.DispatchQueue r6 = r6.getStorageQueue()
            ir.eitaa.helper.live.LiveHelper$2 r7 = new ir.eitaa.helper.live.LiveHelper$2
            r7.<init>()
            r6.postRunnable(r7)
            r5.acquire()     // Catch: java.lang.Exception -> L4c
            goto L50
        L4c:
            r5 = move-exception
            ir.eitaa.messenger.FileLog.e(r5)
        L50:
            r5 = r4[r3]
            if (r5 == 0) goto L5f
            int r5 = r8.currentAccount
            ir.eitaa.messenger.MessagesController r5 = ir.eitaa.messenger.MessagesController.getInstance(r5)
            r6 = r4[r3]
            r5.putChat(r6, r2)
        L5f:
            r5 = r4[r3]
            if (r5 == 0) goto L74
            r5 = r4[r3]
            boolean r5 = ir.eitaa.messenger.ChatObject.isChannel(r5)
            if (r5 != 0) goto L74
            r4 = r4[r3]
            boolean r4 = ir.eitaa.messenger.ChatObject.isMegagroup(r4)
            if (r4 != 0) goto L74
            goto L76
        L74:
            r3 = r0
            r0 = r1
        L76:
            int r1 = r8.currentAccount
            ir.eitaa.messenger.MediaDataController r1 = ir.eitaa.messenger.MediaDataController.getInstance(r1)
            r1.loadMessage(r3, r0, r9, r2)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.helper.live.LiveHelper.resume(int):void");
    }

    public void onConnectionStarted() {
        setState(11);
    }

    public void onConnectionFailed() {
        setState(15);
    }

    public void onConnectionLost() {
        setState(10);
    }

    public void onClose() {
        if (setState(13) || setState(5)) {
            return;
        }
        setState(14);
    }

    public void onCloseCanceled() {
        setState(this.previousState);
    }

    public void onArchiveClicked() {
        if (setState(16)) {
            TLRPC$TL_messages_editMessage tLRPC$TL_messages_editMessage = new TLRPC$TL_messages_editMessage();
            TLRPC$TL_inputMediaLiveStream tLRPC$TL_inputMediaLiveStream = new TLRPC$TL_inputMediaLiveStream();
            tLRPC$TL_inputMediaLiveStream.flags |= 3;
            tLRPC$TL_messages_editMessage.media = tLRPC$TL_inputMediaLiveStream;
            tLRPC$TL_messages_editMessage.peer = MessagesController.getInstance(this.currentAccount).getInputPeer((int) dialog_id);
            tLRPC$TL_messages_editMessage.id = this.messageObject.getId();
            tLRPC$TL_messages_editMessage.flags |= 16384;
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_editMessage, new RequestDelegate() { // from class: ir.eitaa.helper.live.-$$Lambda$LiveHelper$DDWzR4c1_t7pPDXPkgr7j8Bki2w
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$onArchiveClicked$1$LiveHelper(tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onArchiveClicked$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onArchiveClicked$1$LiveHelper(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            MessagesController.getInstance(this.currentAccount).clearLiveDialogId();
            MessagesController.getInstance(this.currentAccount).processUpdates((TLRPC$Updates) tLObject, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.helper.live.-$$Lambda$LiveHelper$LOV6Ez2C0Si0GaCbygemVMnmzYQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onArchiveClicked$0$LiveHelper();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onArchiveClicked$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onArchiveClicked$0$LiveHelper() {
        setState(14);
    }

    public void onEndClicked() {
        if (setState(16)) {
            TLRPC$TL_messages_editMessage tLRPC$TL_messages_editMessage = new TLRPC$TL_messages_editMessage();
            TLRPC$TL_inputMediaLiveStream tLRPC$TL_inputMediaLiveStream = new TLRPC$TL_inputMediaLiveStream();
            tLRPC$TL_inputMediaLiveStream.flags |= 1;
            tLRPC$TL_messages_editMessage.media = tLRPC$TL_inputMediaLiveStream;
            tLRPC$TL_messages_editMessage.peer = MessagesController.getInstance(this.currentAccount).getInputPeer((int) dialog_id);
            tLRPC$TL_messages_editMessage.id = this.messageObject.getId();
            tLRPC$TL_messages_editMessage.flags |= 16384;
            ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_editMessage, new RequestDelegate() { // from class: ir.eitaa.helper.live.-$$Lambda$LiveHelper$718BM6YpwnqoGTiDMcGBA50jvPg
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$onEndClicked$3$LiveHelper(tLObject, tLRPC$TL_error);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onEndClicked$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onEndClicked$3$LiveHelper(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            MessagesController.getInstance(this.currentAccount).clearLiveDialogId();
            MessagesController.getInstance(this.currentAccount).processUpdates((TLRPC$Updates) tLObject, false);
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.helper.live.-$$Lambda$LiveHelper$tFgUYE9G2R1FJ9fXUq5zzyGtLlg
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onEndClicked$2$LiveHelper();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$onEndClicked$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$onEndClicked$2$LiveHelper() {
        setState(14);
    }

    public void onPause() {
        MessageObject messageObject;
        if (this.state == 2 && (messageObject = this.messageObject) != null && messageObject.isSending()) {
            SendMessagesHelper.getInstance(this.currentAccount).cancelSendingMessage(this.messageObject);
        }
        if (setState(12)) {
            sendPauseSignal();
        }
    }

    public void registerNotifications() {
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.didReceiveNewMessages);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.replaceMessagesObjects);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messageReceivedByServer);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messageSendError);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.messagesDeleted);
        NotificationCenter.getInstance(this.currentAccount).addObserver(this, NotificationCenter.didLoadedMessage);
        AndroidUtilities.runOnUIThread(this.statePollRunnable, 15000L);
    }

    public void unRegisterNotifications() {
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.didReceiveNewMessages);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.replaceMessagesObjects);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messageReceivedByServer);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messageSendError);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.messagesDeleted);
        NotificationCenter.getInstance(this.currentAccount).removeObserver(this, NotificationCenter.didLoadedMessage);
        AndroidUtilities.cancelRunOnUIThread(this.statePollRunnable);
    }

    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0188  */
    @Override // ir.eitaa.messenger.NotificationCenter.NotificationCenterDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void didReceivedNotification(int r6, int r7, java.lang.Object... r8) {
        /*
            Method dump skipped, instructions count: 447
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.helper.live.LiveHelper.didReceivedNotification(int, int, java.lang.Object[]):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pollState() {
        MessageObject messageObject = this.messageObject;
        if (messageObject == null || this.state != 5 || this.pollingState) {
            return;
        }
        this.pollingState = true;
        TLRPC$TL_messageMediaLiveStream tLRPC$TL_messageMediaLiveStream = (TLRPC$TL_messageMediaLiveStream) messageObject.messageOwner.media;
        TLRPC$TL_Live_getMedia tLRPC$TL_Live_getMedia = new TLRPC$TL_Live_getMedia();
        tLRPC$TL_Live_getMedia.id = tLRPC$TL_messageMediaLiveStream.id;
        tLRPC$TL_Live_getMedia.access_hash = tLRPC$TL_messageMediaLiveStream.access_hash;
        tLRPC$TL_Live_getMedia.flags = 2;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_Live_getMedia, new RequestDelegate() { // from class: ir.eitaa.helper.live.LiveHelper.6
            @Override // ir.eitaa.tgnet.RequestDelegate
            public void run(TLObject response, TLRPC$TL_error error) {
                if (error == null) {
                    final TLRPC$TL_messageMediaLiveStream tLRPC$TL_messageMediaLiveStream2 = (TLRPC$TL_messageMediaLiveStream) response;
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.helper.live.LiveHelper.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (tLRPC$TL_messageMediaLiveStream2.total_viewers >= 0 && LiveHelper.this.delegate != null) {
                                LiveHelper.this.delegate.onNewTotalViewers(tLRPC$TL_messageMediaLiveStream2.total_viewers);
                            }
                            if (tLRPC$TL_messageMediaLiveStream2.state instanceof TLRPC$TL_LiveStreamStateEnded) {
                                LiveHelper.this.setState(7);
                            }
                        }
                    });
                }
                LiveHelper.this.pollingState = false;
            }
        });
    }

    public void getParticipants(final GetParticipantsCallback getParticipantsCallback) {
        TLRPC$TL_messageMediaLiveStream tLRPC$TL_messageMediaLiveStream = (TLRPC$TL_messageMediaLiveStream) this.messageObject.messageOwner.media;
        TLRPC$TL_Live_getParticipants tLRPC$TL_Live_getParticipants = new TLRPC$TL_Live_getParticipants();
        tLRPC$TL_Live_getParticipants.id = tLRPC$TL_messageMediaLiveStream.id;
        tLRPC$TL_Live_getParticipants.access_hash = tLRPC$TL_messageMediaLiveStream.access_hash;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_Live_getParticipants, new RequestDelegate() { // from class: ir.eitaa.helper.live.LiveHelper.7
            @Override // ir.eitaa.tgnet.RequestDelegate
            public void run(final TLObject response, TLRPC$TL_error error) {
                if (error == null) {
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.helper.live.LiveHelper.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GetParticipantsCallback getParticipantsCallback2 = getParticipantsCallback;
                            if (getParticipantsCallback2 != null) {
                                getParticipantsCallback2.participantsLoaded(((TLRPC$TL_Live_participants) response).users);
                            }
                        }
                    });
                }
            }
        });
    }

    private void sendPauseSignal() {
        TLRPC$TL_messages_editMessage tLRPC$TL_messages_editMessage = new TLRPC$TL_messages_editMessage();
        TLRPC$TL_inputMediaLiveStream tLRPC$TL_inputMediaLiveStream = new TLRPC$TL_inputMediaLiveStream();
        tLRPC$TL_inputMediaLiveStream.flags = 4;
        tLRPC$TL_messages_editMessage.media = tLRPC$TL_inputMediaLiveStream;
        tLRPC$TL_messages_editMessage.peer = MessagesController.getInstance(this.currentAccount).getInputPeer((int) dialog_id);
        tLRPC$TL_messages_editMessage.id = this.messageObject.getId();
        tLRPC$TL_messages_editMessage.flags |= 16384;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_editMessage, new RequestDelegate() { // from class: ir.eitaa.helper.live.-$$Lambda$LiveHelper$CDo7vHdG5wEOYh7zB6cgJ_hmyYc
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$sendPauseSignal$4$LiveHelper(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendPauseSignal$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendPauseSignal$4$LiveHelper(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.helper.live.LiveHelper.8
                @Override // java.lang.Runnable
                public void run() {
                }
            });
        }
    }

    private void sendResumeSignal() {
        MessageObject messageObject = this.messageObject;
        if (messageObject == null || messageObject.getLiveStream() == null) {
            return;
        }
        TLRPC$TL_messages_editMessage tLRPC$TL_messages_editMessage = new TLRPC$TL_messages_editMessage();
        TLRPC$TL_inputMediaLiveStream tLRPC$TL_inputMediaLiveStream = new TLRPC$TL_inputMediaLiveStream();
        tLRPC$TL_inputMediaLiveStream.flags = 8;
        tLRPC$TL_messages_editMessage.media = tLRPC$TL_inputMediaLiveStream;
        tLRPC$TL_messages_editMessage.peer = MessagesController.getInstance(this.currentAccount).getInputPeer((int) dialog_id);
        tLRPC$TL_messages_editMessage.id = this.messageObject.getId();
        tLRPC$TL_messages_editMessage.flags |= 16384;
        ConnectionsManager.getInstance(this.currentAccount).sendRequest(tLRPC$TL_messages_editMessage, new RequestDelegate() { // from class: ir.eitaa.helper.live.-$$Lambda$LiveHelper$unMmzrZqpdokTcSb3giKFyDG-4A
            @Override // ir.eitaa.tgnet.RequestDelegate
            public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                this.f$0.lambda$sendResumeSignal$5$LiveHelper(tLObject, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$sendResumeSignal$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void lambda$sendResumeSignal$5$LiveHelper(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
        if (tLRPC$TL_error == null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.helper.live.LiveHelper.9
                @Override // java.lang.Runnable
                public void run() {
                }
            });
        }
    }

    public int getMessageStartTimeSec() {
        MessageObject messageObject = this.messageObject;
        if (messageObject != null) {
            return messageObject.messageOwner.date;
        }
        return 0;
    }

    public boolean setState(int newState) {
        int i = this.state;
        if (i == newState) {
            return false;
        }
        if (newState == 1 && i != 0) {
            return false;
        }
        if (newState == 2 && i != 1) {
            return false;
        }
        if (newState == 3 && i != 2) {
            return false;
        }
        if (newState == 8 && i != 0 && i != 12) {
            return false;
        }
        if (newState == 9 && i != 8 && i != 13) {
            return false;
        }
        if (newState == 11 && i != 4 && i != 9 && i != 15 && i != 10) {
            return false;
        }
        if (newState == 10 && i != 5 && i != 13) {
            return false;
        }
        if (newState == 12 && i != 5 && i != 13) {
            return false;
        }
        if (newState == 13 && i != 5 && i != 15 && i != 9) {
            return false;
        }
        if (newState == 5 && i != 13 && i != 11) {
            return false;
        }
        if (newState == 15 && i != 11 && i != 13) {
            return false;
        }
        if (newState == 16 && i != 13) {
            return false;
        }
        if (newState == 14 && i != 16 && i != 1 && i != 10 && i != 7 && i != 17) {
            return false;
        }
        this.previousState = i;
        this.state = newState;
        if (newState == 9) {
            this.shouldSendResumeSignal = true;
        } else if (newState == 5 && this.shouldSendResumeSignal) {
            this.shouldSendResumeSignal = false;
            sendResumeSignal();
        }
        LiveHelperDelegate liveHelperDelegate = this.delegate;
        if (liveHelperDelegate != null) {
            liveHelperDelegate.onStateChanged(newState);
        }
        return true;
    }
}
