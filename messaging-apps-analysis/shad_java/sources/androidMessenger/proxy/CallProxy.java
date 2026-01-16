package androidMessenger.proxy;

import android.util.Base64;
import androidMessenger.proxy.CallProxy;
import androidMessenger.utilites.CallConverter;
import androidMessenger.utilites.ChatConverter;
import androidMessenger.utilites.MyLog;
import ir.aaap.messengercore.CoreMainClass;
import ir.aaap.messengercore.LoadListener;
import ir.aaap.messengercore.model.ChatAbsObject;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.GroupCallModels;
import ir.aaap.messengercore.model.ObjectGuidType;
import ir.aaap.messengercore.model.VoiceCallModels;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.messenger.BaseController;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.Utilities;
import org.rbmain.messenger.voip.VoIPService;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$GroupCall;
import org.rbmain.tgnet.TLRPC$InputPeer;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$PhoneCall;
import org.rbmain.tgnet.TLRPC$TL_dataJSON;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_groupCall;
import org.rbmain.tgnet.TLRPC$TL_groupCallParticipant;
import org.rbmain.tgnet.TLRPC$TL_inputGroupCall;
import org.rbmain.tgnet.TLRPC$TL_inputPeerUser;
import org.rbmain.tgnet.TLRPC$TL_messages_dhConfig;
import org.rbmain.tgnet.TLRPC$TL_messages_setTyping;
import org.rbmain.tgnet.TLRPC$TL_peerChannel;
import org.rbmain.tgnet.TLRPC$TL_peerUser;
import org.rbmain.tgnet.TLRPC$TL_phoneCallProtocol;
import org.rbmain.tgnet.TLRPC$TL_phone_acceptCall;
import org.rbmain.tgnet.TLRPC$TL_phone_createGroupCall;
import org.rbmain.tgnet.TLRPC$TL_phone_discardCall;
import org.rbmain.tgnet.TLRPC$TL_phone_discardGroupCall;
import org.rbmain.tgnet.TLRPC$TL_phone_editGroupCallParticipant;
import org.rbmain.tgnet.TLRPC$TL_phone_editGroupCallTitle;
import org.rbmain.tgnet.TLRPC$TL_phone_getGroupCall;
import org.rbmain.tgnet.TLRPC$TL_phone_getGroupCallJoinAs;
import org.rbmain.tgnet.TLRPC$TL_phone_getGroupParticipants;
import org.rbmain.tgnet.TLRPC$TL_phone_groupCall;
import org.rbmain.tgnet.TLRPC$TL_phone_groupParticipants;
import org.rbmain.tgnet.TLRPC$TL_phone_joinAsPeers;
import org.rbmain.tgnet.TLRPC$TL_phone_joinGroupCall;
import org.rbmain.tgnet.TLRPC$TL_phone_leaveGroupCall;
import org.rbmain.tgnet.TLRPC$TL_phone_phoneCall;
import org.rbmain.tgnet.TLRPC$TL_phone_receivedCall;
import org.rbmain.tgnet.TLRPC$TL_phone_requestCall;
import org.rbmain.tgnet.TLRPC$TL_phone_sendSignalingData;
import org.rbmain.tgnet.TLRPC$TL_phone_setCallRating;
import org.rbmain.tgnet.TLRPC$TL_phone_toggleGroupCallSettings;
import org.rbmain.tgnet.TLRPC$TL_updateGroupCall;
import org.rbmain.tgnet.TLRPC$TL_updateGroupCallConnection;
import org.rbmain.tgnet.TLRPC$TL_updateGroupCallParticipants;
import org.rbmain.tgnet.TLRPC$TL_updatePhoneCall;
import org.rbmain.tgnet.TLRPC$TL_updatePhoneCallSignalingData;
import org.rbmain.tgnet.TLRPC$TL_updates;
import org.rbmain.tgnet.TLRPC$Update;
import org.rbmain.tgnet.TLRPC$User;

/* loaded from: classes.dex */
public class CallProxy extends BaseController {
    private static volatile CallProxy[] Instance = new CallProxy[3];

    public CallProxy(int i) {
        super(i);
        this.currentAccount = i;
    }

    public static CallProxy getInstance(int i) {
        CallProxy callProxy = Instance[i];
        if (callProxy == null) {
            synchronized (MessageProxy.class) {
                callProxy = Instance[i];
                if (callProxy == null) {
                    CallProxy[] callProxyArr = Instance;
                    CallProxy callProxy2 = new CallProxy(i);
                    callProxyArr[i] = callProxy2;
                    callProxy = callProxy2;
                }
            }
        }
        return callProxy;
    }

    public void requestCall(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_phone_requestCall) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.CallProxy$$ExternalSyntheticLambda17
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$requestCall$0(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestCall$0(TLObject tLObject, final RequestDelegate requestDelegate) {
        TLRPC$TL_phone_requestCall tLRPC$TL_phone_requestCall = (TLRPC$TL_phone_requestCall) tLObject;
        final String dialogId = IdStorage.getInstance().getDialogId(tLRPC$TL_phone_requestCall.user_id.user_id);
        TLRPC$TL_phoneCallProtocol tLRPC$TL_phoneCallProtocol = tLRPC$TL_phone_requestCall.protocol;
        getCoreMainClass().requestCall(dialogId, tLRPC$TL_phoneCallProtocol.min_layer, tLRPC$TL_phoneCallProtocol.max_layer, tLRPC$TL_phone_requestCall.video, tLRPC$TL_phoneCallProtocol.library_versions, new LoadListener<VoiceCallModels.PhoneCall>() { // from class: androidMessenger.proxy.CallProxy.1
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(VoiceCallModels.PhoneCall phoneCall) {
                TLRPC$PhoneCall tLRPC$PhoneCallConvertCall = CallConverter.convertCall(CallProxy.this.getCoreMainClass(), dialogId, phoneCall, true);
                TLRPC$TL_phone_phoneCall tLRPC$TL_phone_phoneCall = new TLRPC$TL_phone_phoneCall();
                tLRPC$TL_phone_phoneCall.phone_call = tLRPC$PhoneCallConvertCall;
                tLRPC$TL_phone_phoneCall.users = ChatConverter.getUserParticipants(CallProxy.this.getCoreMainClass(), phoneCall.other_participants);
                requestDelegate.run(tLRPC$TL_phone_phoneCall, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Establish Call";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public int secureCall(TLObject tLObject, RequestDelegate requestDelegate) {
        TLRPC$TL_messages_dhConfig tLRPC$TL_messages_dhConfig = new TLRPC$TL_messages_dhConfig();
        tLRPC$TL_messages_dhConfig.random = new byte[256];
        requestDelegate.run(tLRPC$TL_messages_dhConfig, null);
        return -1;
    }

    public void processCallUpdate(final ArrayList<VoiceCallModels.CallUpdateObject> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.CallProxy$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$processCallUpdate$2(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processCallUpdate$2(ArrayList arrayList) throws InterruptedException {
        TLRPC$PhoneCall tLRPC$PhoneCall;
        TLRPC$PhoneCall tLRPC$PhoneCall2;
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            VoiceCallModels.CallUpdateObject callUpdateObject = (VoiceCallModels.CallUpdateObject) it.next();
            VoiceCallModels.PhoneCall phoneCall = callUpdateObject.call;
            VoiceCallModels.CallUpdateActionEnum callUpdateActionEnum = callUpdateObject.action;
            if (callUpdateActionEnum == VoiceCallModels.CallUpdateActionEnum.Edit) {
                if (sharedInstance != null && (tLRPC$PhoneCall = sharedInstance.privateCall) != null && CallProxy$$ExternalSyntheticBackport0.m(callUpdateObject.call_id, tLRPC$PhoneCall.id)) {
                    processCallUpdateResult(CallConverter.updateWithCallUpdate(sharedInstance.privateCall, callUpdateObject, false), callUpdateObject.call.other_participants);
                }
            } else if (callUpdateActionEnum != VoiceCallModels.CallUpdateActionEnum.Delete) {
                VoiceCallModels.CallUpdateActionEnum callUpdateActionEnum2 = VoiceCallModels.CallUpdateActionEnum.New;
                if (callUpdateActionEnum == callUpdateActionEnum2) {
                    phoneCall.timestamp = callUpdateObject.timestamp;
                    processCallUpdateResult(CallConverter.convertCall(getCoreMainClass(), callUpdateObject.object_guid, callUpdateObject.call, callUpdateObject.action == callUpdateActionEnum2), callUpdateObject.call.other_participants);
                }
            } else if (sharedInstance != null && (tLRPC$PhoneCall2 = sharedInstance.privateCall) != null && CallProxy$$ExternalSyntheticBackport0.m(callUpdateObject.call_id, tLRPC$PhoneCall2.id)) {
                onCallFailed();
            }
        }
    }

    private void processCallUpdateResult(TLRPC$PhoneCall tLRPC$PhoneCall, ArrayList<ChatAbsObject> arrayList) throws InterruptedException {
        if (tLRPC$PhoneCall == null) {
            return;
        }
        ArrayList<TLRPC$Update> arrayList2 = new ArrayList<>();
        TLRPC$TL_updatePhoneCall tLRPC$TL_updatePhoneCall = new TLRPC$TL_updatePhoneCall();
        tLRPC$TL_updatePhoneCall.phone_call = tLRPC$PhoneCall;
        ArrayList<TLRPC$User> userParticipants = ChatConverter.getUserParticipants(getCoreMainClass(), arrayList);
        arrayList2.add(tLRPC$TL_updatePhoneCall);
        getMessagesController().processUpdateArray(arrayList2, userParticipants, null, false, 0);
    }

    public void receivedCall(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_phone_receivedCall) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.CallProxy$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$receivedCall$3(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$receivedCall$3(TLObject tLObject, final RequestDelegate requestDelegate) {
        getCoreMainClass().receivedCall(((TLRPC$TL_phone_receivedCall) tLObject).peer.id, new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.CallProxy.3
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                requestDelegate.run(null, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Received Call";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void acceptCall(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_phone_acceptCall) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.CallProxy$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$acceptCall$4(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$acceptCall$4(TLObject tLObject, final RequestDelegate requestDelegate) {
        TLRPC$TL_phone_acceptCall tLRPC$TL_phone_acceptCall = (TLRPC$TL_phone_acceptCall) tLObject;
        TLRPC$TL_phoneCallProtocol tLRPC$TL_phoneCallProtocol = tLRPC$TL_phone_acceptCall.protocol;
        int i = tLRPC$TL_phoneCallProtocol.min_layer;
        int i2 = tLRPC$TL_phoneCallProtocol.max_layer;
        ArrayList<String> arrayList = tLRPC$TL_phoneCallProtocol.library_versions;
        getCoreMainClass().acceptCall(tLRPC$TL_phone_acceptCall.peer.id, i, i2, arrayList, new LoadListener<String>(this) { // from class: androidMessenger.proxy.CallProxy.4
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(String str) {
                requestDelegate.run(new TLRPC$TL_phone_phoneCall(), null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Received Call";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void onCallFailed() {
        AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.CallProxy$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                CallProxy.lambda$onCallFailed$5();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onCallFailed$5() {
        VoIPService sharedInstance = VoIPService.getSharedInstance();
        if (sharedInstance != null) {
            sharedInstance.callFailed();
        }
    }

    public void onSignalingData(TLObject tLObject, RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_phone_sendSignalingData) {
            TLRPC$TL_phone_sendSignalingData tLRPC$TL_phone_sendSignalingData = (TLRPC$TL_phone_sendSignalingData) tLObject;
            getCoreMainClass().sendSignalingData(tLRPC$TL_phone_sendSignalingData.peer.id, Base64.encodeToString(tLRPC$TL_phone_sendSignalingData.data, 0), new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.CallProxy.5
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(Integer num) {
                    MyLog.e("Signaling Data", "Successful");
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    MyLog.e("Signaling Data", "Failed");
                }
            });
        }
    }

    public void onSignalDataReceived(final String str, final String str2) {
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.CallProxy$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$onSignalDataReceived$6(str2, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSignalDataReceived$6(String str, String str2) throws InterruptedException {
        ArrayList<TLRPC$Update> arrayList = new ArrayList<>();
        TLRPC$TL_updatePhoneCallSignalingData tLRPC$TL_updatePhoneCallSignalingData = new TLRPC$TL_updatePhoneCallSignalingData();
        tLRPC$TL_updatePhoneCallSignalingData.data = Base64.decode(str, 0);
        tLRPC$TL_updatePhoneCallSignalingData.phone_call_id = str2;
        arrayList.add(tLRPC$TL_updatePhoneCallSignalingData);
        getMessagesController().processUpdateArray(arrayList, null, null, false, 0);
    }

    public void discardCall(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_phone_discardCall) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.CallProxy$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$discardCall$7(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$discardCall$7(TLObject tLObject, final RequestDelegate requestDelegate) {
        TLRPC$TL_phone_discardCall tLRPC$TL_phone_discardCall = (TLRPC$TL_phone_discardCall) tLObject;
        getCoreMainClass().discardCall(tLRPC$TL_phone_discardCall.peer.id, tLRPC$TL_phone_discardCall.duration, CallConverter.getDiscardCallReason(tLRPC$TL_phone_discardCall.reason), new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.CallProxy.6
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                requestDelegate.run(null, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Discard Call";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void createGroupVoiceChat(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_phone_createGroupCall) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.CallProxy$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$createGroupVoiceChat$9(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createGroupVoiceChat$9(TLObject tLObject, final RequestDelegate requestDelegate) {
        TLRPC$TL_phone_createGroupCall tLRPC$TL_phone_createGroupCall = (TLRPC$TL_phone_createGroupCall) tLObject;
        final int i = tLRPC$TL_phone_createGroupCall.peer.channel_id;
        getCoreMainClass().startGroupCall(IdStorage.getInstance().getDialogId(-i), tLRPC$TL_phone_createGroupCall.random_id, new LoadListener<GroupCallModels.GroupVoiceChat>(this) { // from class: androidMessenger.proxy.CallProxy.8
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(GroupCallModels.GroupVoiceChat groupVoiceChat) {
                if (groupVoiceChat == null) {
                    requestDelegate.run(null, null);
                    return;
                }
                TLRPC$TL_updates tLRPC$TL_updates = new TLRPC$TL_updates();
                TLRPC$TL_updateGroupCall tLRPC$TL_updateGroupCall = new TLRPC$TL_updateGroupCall();
                tLRPC$TL_updateGroupCall.chat_id = i;
                tLRPC$TL_updateGroupCall.call = CallConverter.convertGroupCall(groupVoiceChat);
                tLRPC$TL_updates.updates.add(tLRPC$TL_updateGroupCall);
                requestDelegate.run(tLRPC$TL_updates, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Create Group Voice Chat";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public int getDisplayAsInGroupVoiceChat(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_phone_getGroupCallJoinAs)) {
            return -1;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.CallProxy$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$getDisplayAsInGroupVoiceChat$10(tLObject, requestDelegate);
            }
        });
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getDisplayAsInGroupVoiceChat$10(TLObject tLObject, final RequestDelegate requestDelegate) {
        getCoreMainClass().getDisplayAsInGroupVoiceChat(IdStorage.getInstance().getDialogId(-((TLRPC$TL_phone_getGroupCallJoinAs) tLObject).peer.channel_id), null, new LoadListener<GroupCallModels.GetDisplayAsInGroupVoiceChatOutput>(this) { // from class: androidMessenger.proxy.CallProxy.9
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(GroupCallModels.GetDisplayAsInGroupVoiceChatOutput getDisplayAsInGroupVoiceChatOutput) {
                TLRPC$TL_phone_joinAsPeers tLRPC$TL_phone_joinAsPeers = new TLRPC$TL_phone_joinAsPeers();
                Iterator<GroupCallModels.DisplayAsGroupVoiceChat> it = getDisplayAsInGroupVoiceChatOutput.display_as_object_guids.iterator();
                while (true) {
                    TLRPC$Peer tLRPC$TL_peerChannel = null;
                    if (it.hasNext()) {
                        GroupCallModels.DisplayAsGroupVoiceChat next = it.next();
                        ChatType chatType = next.type;
                        if (chatType == ChatType.User) {
                            tLRPC$TL_peerChannel = new TLRPC$TL_peerUser();
                            tLRPC$TL_peerChannel.user_id = (int) IdStorage.getInstance().generateDialogId(next.object_guid);
                            tLRPC$TL_phone_joinAsPeers.users.add(CallConverter.getDisplayUser(next));
                        } else if (chatType == ChatType.Channel || chatType == ChatType.Group) {
                            tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
                            tLRPC$TL_peerChannel.channel_id = -((int) IdStorage.getInstance().generateNegativeDialogId(next.object_guid));
                            tLRPC$TL_phone_joinAsPeers.chats.add(CallConverter.getDisplayChat(next));
                        }
                        if (tLRPC$TL_peerChannel != null) {
                            tLRPC$TL_phone_joinAsPeers.peers.add(tLRPC$TL_peerChannel);
                        }
                    } else {
                        requestDelegate.run(tLRPC$TL_phone_joinAsPeers, null);
                        return;
                    }
                }
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Get Display As In Group Voice Chat";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public int joinGroupVoiceChatRequest(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_phone_joinGroupCall)) {
            return -1;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.CallProxy$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$joinGroupVoiceChatRequest$11(tLObject, requestDelegate);
            }
        });
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$joinGroupVoiceChatRequest$11(TLObject tLObject, final RequestDelegate requestDelegate) {
        TLRPC$TL_phone_joinGroupCall tLRPC$TL_phone_joinGroupCall = (TLRPC$TL_phone_joinGroupCall) tLObject;
        String str = tLRPC$TL_phone_joinGroupCall.call.id;
        String dialogId = IdStorage.getInstance().getDialogId(tLRPC$TL_phone_joinGroupCall.join_as instanceof TLRPC$TL_inputPeerUser ? r0.user_id : -r0.channel_id);
        String dialogId2 = IdStorage.getInstance().getDialogId(-tLRPC$TL_phone_joinGroupCall.chatId);
        ChatAbsObject absInstant = getCoreMainClass().getAbsInstant(dialogId2);
        if (absInstant == null) {
            return;
        }
        getCoreMainClass().joinGroupVoiceChat(dialogId2, dialogId, absInstant.type, str, tLRPC$TL_phone_joinGroupCall.params.data, new LoadListener<String>(this) { // from class: androidMessenger.proxy.CallProxy.10
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(String str2) {
                TLRPC$TL_updates tLRPC$TL_updates = new TLRPC$TL_updates();
                TLRPC$TL_updateGroupCallConnection tLRPC$TL_updateGroupCallConnection = new TLRPC$TL_updateGroupCallConnection();
                TLRPC$TL_dataJSON tLRPC$TL_dataJSON = new TLRPC$TL_dataJSON();
                tLRPC$TL_updateGroupCallConnection.params = tLRPC$TL_dataJSON;
                tLRPC$TL_dataJSON.data = CallConverter.convertAnswerSdp(str2);
                tLRPC$TL_updates.updates.add(tLRPC$TL_updateGroupCallConnection);
                requestDelegate.run(tLRPC$TL_updates, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Join Group Voice Chat";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void processGroupCallUpdate(final GroupCallModels.GroupVoiceChatUpdate groupVoiceChatUpdate) {
        if (groupVoiceChatUpdate == null) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.CallProxy$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$processGroupCallUpdate$13(groupVoiceChatUpdate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$processGroupCallUpdate$13(GroupCallModels.GroupVoiceChatUpdate groupVoiceChatUpdate) throws InterruptedException {
        String str = groupVoiceChatUpdate.chat_guid_type.object_guid;
        TLRPC$TL_updateGroupCall tLRPC$TL_updateGroupCall = new TLRPC$TL_updateGroupCall();
        tLRPC$TL_updateGroupCall.chat_id = ((int) IdStorage.getInstance().generateNegativeDialogId(str)) * (-1);
        tLRPC$TL_updateGroupCall.updateObject = groupVoiceChatUpdate;
        TLRPC$TL_groupCall tLRPC$TL_groupCall = new TLRPC$TL_groupCall();
        tLRPC$TL_updateGroupCall.call = tLRPC$TL_groupCall;
        tLRPC$TL_groupCall.id = groupVoiceChatUpdate.voice_chat_id;
        ArrayList<TLRPC$Update> arrayList = new ArrayList<>();
        arrayList.add(tLRPC$TL_updateGroupCall);
        getMessagesController().processUpdateArray(arrayList, null, null, false, 0);
    }

    public void getGroupVoiceChatParticipants(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_phone_getGroupParticipants) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.CallProxy$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getGroupVoiceChatParticipants$14(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getGroupVoiceChatParticipants$14(TLObject tLObject, final RequestDelegate requestDelegate) {
        TLRPC$TL_phone_getGroupParticipants tLRPC$TL_phone_getGroupParticipants = (TLRPC$TL_phone_getGroupParticipants) tLObject;
        String dialogId = IdStorage.getInstance().getDialogId(-tLRPC$TL_phone_getGroupParticipants.chatId);
        String str = tLRPC$TL_phone_getGroupParticipants.call.id;
        if (str == null || dialogId == null) {
            return;
        }
        CoreMainClass coreMainClass = getCoreMainClass();
        String str2 = tLRPC$TL_phone_getGroupParticipants.offset;
        if (str2 == null) {
            str2 = null;
        }
        coreMainClass.getGroupVoiceChatParticipants(dialogId, str, str2, new LoadListener<GroupCallModels.GetGroupVoiceChatParticipantsOutput>() { // from class: androidMessenger.proxy.CallProxy.11
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(GroupCallModels.GetGroupVoiceChatParticipantsOutput getGroupVoiceChatParticipantsOutput) {
                TLRPC$TL_phone_groupParticipants tLRPC$TL_phone_groupParticipants = new TLRPC$TL_phone_groupParticipants();
                ArrayList<TLRPC$TL_groupCallParticipant> arrayList = new ArrayList<>();
                ArrayList<TLRPC$Chat> arrayList2 = new ArrayList<>();
                ArrayList<TLRPC$User> arrayList3 = new ArrayList<>();
                CallConverter.convertAllGroupVoiceChatParticipants(((BaseController) CallProxy.this).currentAccount, getGroupVoiceChatParticipantsOutput.participants, arrayList, arrayList2, arrayList3);
                tLRPC$TL_phone_groupParticipants.participants = arrayList;
                tLRPC$TL_phone_groupParticipants.chats = arrayList2;
                tLRPC$TL_phone_groupParticipants.users = arrayList3;
                tLRPC$TL_phone_groupParticipants.next_offset = getGroupVoiceChatParticipantsOutput.next_start_id;
                tLRPC$TL_phone_groupParticipants.state = getGroupVoiceChatParticipantsOutput.state;
                requestDelegate.run(tLRPC$TL_phone_groupParticipants, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed to get group voice chat participants";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void setGroupVoiceChatState(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_phone_editGroupCallParticipant) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.CallProxy$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setGroupVoiceChatState$15(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setGroupVoiceChatState$15(TLObject tLObject, RequestDelegate requestDelegate) {
        String str;
        String dialogId;
        TLRPC$TL_phone_editGroupCallParticipant tLRPC$TL_phone_editGroupCallParticipant = (TLRPC$TL_phone_editGroupCallParticipant) tLObject;
        boolean z = tLRPC$TL_phone_editGroupCallParticipant.raise_hand;
        String dialogId2 = IdStorage.getInstance().getDialogId(-tLRPC$TL_phone_editGroupCallParticipant.chat_id);
        String str2 = tLRPC$TL_phone_editGroupCallParticipant.call.id;
        TLRPC$InputPeer tLRPC$InputPeer = tLRPC$TL_phone_editGroupCallParticipant.participant;
        if (tLRPC$InputPeer.user_id != 0) {
            dialogId = IdStorage.getInstance().getDialogId(tLRPC$TL_phone_editGroupCallParticipant.participant.user_id);
        } else if (tLRPC$InputPeer.channel_id != 0) {
            dialogId = IdStorage.getInstance().getDialogId(tLRPC$TL_phone_editGroupCallParticipant.participant.channel_id * (-1));
        } else {
            if (tLRPC$InputPeer.chat_id == 0) {
                str = null;
                if (str != null || dialogId2 == null || str2 == null) {
                    requestDelegate.run(null, new TLRPC$TL_error());
                }
                AnonymousClass12 anonymousClass12 = new AnonymousClass12(this, requestDelegate, str2);
                if ((tLRPC$TL_phone_editGroupCallParticipant.flags & 4) == 0) {
                    getCoreMainClass().toggleGroupVoiceChatMuteUnMute(dialogId2, str2, str, tLRPC$TL_phone_editGroupCallParticipant.muted, anonymousClass12);
                    return;
                } else {
                    getCoreMainClass().setGroupVoiceChatRaiseHand(dialogId2, str2, str, z, anonymousClass12);
                    return;
                }
            }
            dialogId = IdStorage.getInstance().getDialogId(tLRPC$TL_phone_editGroupCallParticipant.participant.chat_id * (-1));
        }
        str = dialogId;
        if (str != null) {
        }
        requestDelegate.run(null, new TLRPC$TL_error());
    }

    /* renamed from: androidMessenger.proxy.CallProxy$12, reason: invalid class name */
    class AnonymousClass12 implements LoadListener<GroupCallModels.SetGroupVoiceChatStateStatusEnum> {
        final /* synthetic */ RequestDelegate val$onComplete;
        final /* synthetic */ String val$voiceChatId;

        AnonymousClass12(CallProxy callProxy, RequestDelegate requestDelegate, String str) {
            this.val$onComplete = requestDelegate;
            this.val$voiceChatId = str;
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onDidLoad(GroupCallModels.SetGroupVoiceChatStateStatusEnum setGroupVoiceChatStateStatusEnum) {
            ChatObject.Call call;
            TLRPC$GroupCall tLRPC$GroupCall;
            if (setGroupVoiceChatStateStatusEnum == GroupCallModels.SetGroupVoiceChatStateStatusEnum.OK) {
                this.val$onComplete.run(null, null);
                return;
            }
            if (setGroupVoiceChatStateStatusEnum == GroupCallModels.SetGroupVoiceChatStateStatusEnum.VoiceChatNotExist) {
                VoIPService sharedInstance = VoIPService.getSharedInstance();
                if (sharedInstance == null || (call = sharedInstance.groupCall) == null || (tLRPC$GroupCall = call.call) == null || !this.val$voiceChatId.equals(tLRPC$GroupCall.id)) {
                    return;
                }
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: androidMessenger.proxy.CallProxy$12$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        CallProxy.AnonymousClass12.lambda$onDidLoad$0();
                    }
                });
                return;
            }
            TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
            tLRPC$TL_error.text = setGroupVoiceChatStateStatusEnum.name();
            this.val$onComplete.run(null, tLRPC$TL_error);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$onDidLoad$0() {
            VoIPService.getSharedInstance().detectVoiceChatNotExist();
        }

        @Override // ir.aaap.messengercore.LoadListener
        public void onError(Exception exc) {
            TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
            tLRPC$TL_error.text = "Failed to change state";
            this.val$onComplete.run(null, tLRPC$TL_error);
        }
    }

    public void leaveGroupVoiceChat(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_phone_leaveGroupCall) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.CallProxy$$ExternalSyntheticLambda21
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$leaveGroupVoiceChat$16(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$leaveGroupVoiceChat$16(TLObject tLObject, final RequestDelegate requestDelegate) {
        getCoreMainClass().leaveGroupVoiceChat(IdStorage.getInstance().getDialogId(r5.call.chat_id * (-1)), ((TLRPC$TL_phone_leaveGroupCall) tLObject).call.id, new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.CallProxy.13
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                requestDelegate.run(null, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed to leave group voice chat";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void discardGroupVoiceChat(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_phone_discardGroupCall) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.CallProxy$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$discardGroupVoiceChat$17(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$discardGroupVoiceChat$17(TLObject tLObject, final RequestDelegate requestDelegate) {
        getCoreMainClass().discardGroupVoiceChat(IdStorage.getInstance().getDialogId(r5.call.chat_id * (-1)), ((TLRPC$TL_phone_discardGroupCall) tLObject).call.id, new LoadListener<Integer>(this) { // from class: androidMessenger.proxy.CallProxy.14
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(Integer num) {
                requestDelegate.run(null, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed to leave group voice chat";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void getGroupCall(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_phone_getGroupCall) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.CallProxy$$ExternalSyntheticLambda18
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$getGroupCall$18(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getGroupCall$18(TLObject tLObject, final RequestDelegate requestDelegate) {
        getCoreMainClass().getGroupVoiceChat(IdStorage.getInstance().getDialogId(r5.call.chat_id * (-1)), ((TLRPC$TL_phone_getGroupCall) tLObject).call.id, new LoadListener<GroupCallModels.GroupVoiceChat>(this) { // from class: androidMessenger.proxy.CallProxy.15
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(GroupCallModels.GroupVoiceChat groupVoiceChat) {
                TLRPC$TL_phone_groupCall tLRPC$TL_phone_groupCall = new TLRPC$TL_phone_groupCall();
                if (groupVoiceChat != null) {
                    tLRPC$TL_phone_groupCall.call = CallConverter.convertGroupCall(groupVoiceChat);
                    requestDelegate.run(tLRPC$TL_phone_groupCall, null);
                } else {
                    TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                    tLRPC$TL_error.text = "Not Exist";
                    requestDelegate.run(null, tLRPC$TL_error);
                }
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed to get group voice chat";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void getGroupVoiceChatUpdates(int i, String str, String str2, LoadListener<GroupCallModels.GetGroupVoiceChatUpdatesResult> loadListener) {
        getCoreMainClass().getGroupVoiceChatUpdates(IdStorage.getInstance().getDialogId(-i), str, str2, loadListener);
    }

    public void sendGroupVoiceChatActivity(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_messages_setTyping) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.CallProxy$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$sendGroupVoiceChatActivity$19(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendGroupVoiceChatActivity$19(TLObject tLObject, final RequestDelegate requestDelegate) {
        getCoreMainClass().sendGroupVoiceChatActivity(GroupCallModels.SendGroupVoiceChatActivityEnum.Speaking, IdStorage.getInstance().getDialogId(-r5.chat_id), ((TLRPC$TL_messages_setTyping) tLObject).call.id, new LoadListener<GroupCallModels.Status>(this) { // from class: androidMessenger.proxy.CallProxy.16
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(GroupCallModels.Status status) {
                if (status == GroupCallModels.Status.OK) {
                    requestDelegate.run(null, null);
                } else if (status == GroupCallModels.Status.VoiceChatNotExist) {
                    TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                    tLRPC$TL_error.text = "Voice Chat Not Exists";
                    tLRPC$TL_error.code = 100;
                    requestDelegate.run(null, tLRPC$TL_error);
                }
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed to send activity";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void setGroupVoiceChatSetting(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_phone_toggleGroupCallSettings) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.CallProxy$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setGroupVoiceChatSetting$20(tLObject, requestDelegate);
                }
            });
        } else if (tLObject instanceof TLRPC$TL_phone_editGroupCallTitle) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.CallProxy$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$setGroupVoiceChatSetting$21(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setGroupVoiceChatSetting$20(TLObject tLObject, final RequestDelegate requestDelegate) {
        TLRPC$TL_phone_toggleGroupCallSettings tLRPC$TL_phone_toggleGroupCallSettings = (TLRPC$TL_phone_toggleGroupCallSettings) tLObject;
        getCoreMainClass().setGroupVoiceChatJoinMuted(IdStorage.getInstance().getDialogId(-r0.chat_id), tLRPC$TL_phone_toggleGroupCallSettings.call.id, tLRPC$TL_phone_toggleGroupCallSettings.join_muted, new LoadListener<GroupCallModels.Status>(this) { // from class: androidMessenger.proxy.CallProxy.17
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(GroupCallModels.Status status) {
                requestDelegate.run(null, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Toggle Admin Speak";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setGroupVoiceChatSetting$21(TLObject tLObject, final RequestDelegate requestDelegate) {
        TLRPC$TL_phone_editGroupCallTitle tLRPC$TL_phone_editGroupCallTitle = (TLRPC$TL_phone_editGroupCallTitle) tLObject;
        getCoreMainClass().setGroupVoiceChatTitle(IdStorage.getInstance().getDialogId(-r0.chat_id), tLRPC$TL_phone_editGroupCallTitle.call.id, tLRPC$TL_phone_editGroupCallTitle.title, new LoadListener<GroupCallModels.Status>(this) { // from class: androidMessenger.proxy.CallProxy.18
            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(GroupCallModels.Status status) {
                requestDelegate.run(null, null);
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
                TLRPC$TL_error tLRPC$TL_error = new TLRPC$TL_error();
                tLRPC$TL_error.text = "Failed To Change Title";
                requestDelegate.run(null, tLRPC$TL_error);
            }
        });
    }

    public void rateCall(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (tLObject instanceof TLRPC$TL_phone_setCallRating) {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.CallProxy$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$rateCall$23(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$rateCall$23(TLObject tLObject, RequestDelegate requestDelegate) {
        TLRPC$TL_phone_setCallRating tLRPC$TL_phone_setCallRating = (TLRPC$TL_phone_setCallRating) tLObject;
        String str = tLRPC$TL_phone_setCallRating.comment;
        if (str != null && str.isEmpty()) {
            str = null;
        }
        getCoreMainClass().rateCall(tLRPC$TL_phone_setCallRating.peer.id, tLRPC$TL_phone_setCallRating.rating, str);
        requestDelegate.run(null, null);
    }

    public void proxyGroupParticipantUpdate(final ArrayList<GroupCallModels.GroupVoiceChatParticipantUpdate> arrayList, final boolean z) {
        if (arrayList == null) {
            return;
        }
        Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.CallProxy$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                this.f$0.lambda$proxyGroupParticipantUpdate$24(arrayList, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$proxyGroupParticipantUpdate$24(ArrayList arrayList, boolean z) throws InterruptedException {
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant;
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            GroupCallModels.GroupVoiceChatParticipantUpdate groupVoiceChatParticipantUpdate = (GroupCallModels.GroupVoiceChatParticipantUpdate) it.next();
            if (groupVoiceChatParticipantUpdate != null) {
                TLRPC$TL_updateGroupCallParticipants tLRPC$TL_updateGroupCallParticipants = (TLRPC$TL_updateGroupCallParticipants) map.get(groupVoiceChatParticipantUpdate.voice_chat_id);
                if (tLRPC$TL_updateGroupCallParticipants == null) {
                    tLRPC$TL_updateGroupCallParticipants = new TLRPC$TL_updateGroupCallParticipants();
                    TLRPC$TL_inputGroupCall tLRPC$TL_inputGroupCall = new TLRPC$TL_inputGroupCall();
                    tLRPC$TL_updateGroupCallParticipants.call = tLRPC$TL_inputGroupCall;
                    tLRPC$TL_inputGroupCall.id = groupVoiceChatParticipantUpdate.voice_chat_id;
                    tLRPC$TL_updateGroupCallParticipants.participants = new ArrayList<>();
                    map.put(groupVoiceChatParticipantUpdate.voice_chat_id, tLRPC$TL_updateGroupCallParticipants);
                }
                if (groupVoiceChatParticipantUpdate.action == GroupCallModels.GroupVoiceChatParticipantUpdateAction.New) {
                    tLRPC$TL_groupCallParticipant = CallConverter.convertGroupVoiceChatParticipant(groupVoiceChatParticipantUpdate.group_voice_chat_participant);
                    tLRPC$TL_groupCallParticipant.updateObject = groupVoiceChatParticipantUpdate;
                } else {
                    tLRPC$TL_groupCallParticipant = new TLRPC$TL_groupCallParticipant();
                    ObjectGuidType objectGuidType = groupVoiceChatParticipantUpdate.participant_object_guid_type;
                    long dialogId = ChatConverter.getDialogId(objectGuidType.object_guid, objectGuidType.type);
                    ObjectGuidType objectGuidType2 = groupVoiceChatParticipantUpdate.participant_object_guid_type;
                    tLRPC$TL_groupCallParticipant.peer = ChatConverter.getPeer(dialogId, objectGuidType2.object_guid, objectGuidType2.type);
                    tLRPC$TL_groupCallParticipant.updateObject = groupVoiceChatParticipantUpdate;
                    tLRPC$TL_groupCallParticipant.updateFromNotif = z;
                }
                tLRPC$TL_updateGroupCallParticipants.participants.add(tLRPC$TL_groupCallParticipant);
            }
        }
        getMessagesController().processUpdateArray(new ArrayList<>(map.values()), null, null, false, 0);
    }

    public void loadUnknownParticipants(final TLObject tLObject, final RequestDelegate requestDelegate) {
        if (!(tLObject instanceof TLRPC$TL_phone_getGroupParticipants)) {
            requestDelegate.run(null, new TLRPC$TL_error());
        } else {
            Utilities.stageQueue.postRunnable(new Runnable() { // from class: androidMessenger.proxy.CallProxy$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadUnknownParticipants$25(tLObject, requestDelegate);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0050 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x001d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ void lambda$loadUnknownParticipants$25(org.rbmain.tgnet.TLObject r8, final org.rbmain.tgnet.RequestDelegate r9) {
        /*
            r7 = this;
            org.rbmain.tgnet.TLRPC$TL_phone_getGroupParticipants r8 = (org.rbmain.tgnet.TLRPC$TL_phone_getGroupParticipants) r8
            androidMessenger.proxy.IdStorage r0 = androidMessenger.proxy.IdStorage.getInstance()
            int r1 = r8.chatId
            int r1 = -r1
            long r1 = (long) r1
            java.lang.String r0 = r0.getDialogId(r1)
            org.rbmain.tgnet.TLRPC$TL_inputGroupCall r1 = r8.call
            java.lang.String r1 = r1.id
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$InputPeer> r8 = r8.ids
            java.util.Iterator r8 = r8.iterator()
        L1d:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L54
            java.lang.Object r3 = r8.next()
            org.rbmain.tgnet.TLRPC$InputPeer r3 = (org.rbmain.tgnet.TLRPC$InputPeer) r3
            r4 = 0
            boolean r6 = r3 instanceof org.rbmain.tgnet.TLRPC$TL_inputPeerUser
            if (r6 == 0) goto L33
            int r3 = r3.user_id
        L31:
            long r4 = (long) r3
            goto L42
        L33:
            boolean r6 = r3 instanceof org.rbmain.tgnet.TLRPC$TL_inputPeerChannel
            if (r6 == 0) goto L3b
            int r3 = r3.channel_id
        L39:
            int r3 = -r3
            goto L31
        L3b:
            boolean r6 = r3 instanceof org.rbmain.tgnet.TLRPC$TL_inputPeerChat
            if (r6 == 0) goto L42
            int r3 = r3.chat_id
            goto L39
        L42:
            androidMessenger.proxy.IdStorage r3 = androidMessenger.proxy.IdStorage.getInstance()
            java.lang.String r3 = r3.getDialogId(r4)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L1d
            r2.add(r3)
            goto L1d
        L54:
            ir.aaap.messengercore.CoreMainClass r8 = r7.getCoreMainClass()
            androidMessenger.proxy.CallProxy$19 r3 = new androidMessenger.proxy.CallProxy$19
            r3.<init>(r7)
            r8.loadUnknownParticipants(r0, r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidMessenger.proxy.CallProxy.lambda$loadUnknownParticipants$25(org.rbmain.tgnet.TLObject, org.rbmain.tgnet.RequestDelegate):void");
    }
}
