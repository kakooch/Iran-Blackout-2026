package ir.aaap.messengercore;

import ir.aaap.messengercore.exceptions.InputException;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.GroupCallModels;
import ir.aaap.messengercore.model.ObjectGuidType;
import ir.aaap.messengercore.model.VoiceCallModels;
import ir.aaap.messengercore.network.ApiServerException;
import ir.aaap.messengercore.network.NetworkHelper;
import ir.aaap.messengercore.network.RetryObject;
import ir.aaap.messengercore.usecase.GetMyUserGuidUsecase;
import ir.aaap.messengercore.usecase.LoadAbsUsecase;
import ir.aaap.messengercore.usecase.UpdateChatAndMessageUsecase;
import ir.aaap.messengercore.utilites.CoreLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class CallUtils {
    private CoreLog coreLog;
    private LoadAbsUsecase loadAbsUsecase;
    private final Map<String, Integer> loadingGroupCalls = new HashMap();

    public CallUtils(CoreLog coreLog, GetMyUserGuidUsecase getMyUserGuidUsecase, LoadAbsUsecase loadAbsUsecase) {
        this.coreLog = coreLog;
        this.loadAbsUsecase = loadAbsUsecase;
    }

    public void requestCall(String str, int i, int i2, boolean z, ArrayList<String> arrayList, String str2, NetworkHelper networkHelper, AbsNotificationCenter absNotificationCenter, KeyValueStorageHelper keyValueStorageHelper, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final LoadListener<VoiceCallModels.PhoneCall> loadListener) {
        VoiceCallModels.RequestCallInput requestCallInput = new VoiceCallModels.RequestCallInput();
        requestCallInput.call_type = z ? VoiceCallModels.CallType.Video : VoiceCallModels.CallType.Voice;
        requestCallInput.user_guid = str;
        requestCallInput.min_layer = i;
        requestCallInput.max_layer = i2;
        requestCallInput.library_versions = arrayList;
        try {
            networkHelper.requestCall(str2, requestCallInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<VoiceCallModels.RequestCallOutput>(this) { // from class: ir.aaap.messengercore.CallUtils.1
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(VoiceCallModels.RequestCallOutput requestCallOutput) {
                    updateChatAndMessageUsecase.processMessageAndChatUpdate(requestCallOutput.message_update, requestCallOutput.chat_update, false, true);
                    if (requestCallOutput.call_update != null) {
                        new ArrayList().add(requestCallOutput.call_update);
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(requestCallOutput.call_update.call);
                        }
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public void receivedCall(String str, String str2, NetworkHelper networkHelper, KeyValueStorageHelper keyValueStorageHelper, final AbsNotificationCenter absNotificationCenter, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final LoadListener<Integer> loadListener) {
        VoiceCallModels.ReceivedCallInput receivedCallInput = new VoiceCallModels.ReceivedCallInput();
        receivedCallInput.call_id = str;
        try {
            networkHelper.receivedCall(str2, receivedCallInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<VoiceCallModels.ReceivedCallOutput>(this) { // from class: ir.aaap.messengercore.CallUtils.2
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(VoiceCallModels.ReceivedCallOutput receivedCallOutput) {
                    updateChatAndMessageUsecase.processMessageAndChatUpdate(receivedCallOutput.message_update, receivedCallOutput.chat_update, false, true);
                    if (receivedCallOutput.call_update != null) {
                        ArrayList<VoiceCallModels.CallUpdateObject> arrayList = new ArrayList<>();
                        arrayList.add(receivedCallOutput.call_update);
                        absNotificationCenter.onProcessCallUpdate(arrayList);
                    }
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public void acceptCall(String str, int i, int i2, ArrayList<String> arrayList, String str2, NetworkHelper networkHelper, final AbsNotificationCenter absNotificationCenter, KeyValueStorageHelper keyValueStorageHelper, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final LoadListener<String> loadListener) {
        VoiceCallModels.AcceptCallInput acceptCallInput = new VoiceCallModels.AcceptCallInput();
        acceptCallInput.call_id = str;
        acceptCallInput.min_layer = i;
        acceptCallInput.max_layer = i2;
        acceptCallInput.library_versions = arrayList;
        try {
            networkHelper.acceptCall(str2, acceptCallInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<VoiceCallModels.AcceptCallOutput>(this) { // from class: ir.aaap.messengercore.CallUtils.3
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(VoiceCallModels.AcceptCallOutput acceptCallOutput) {
                    updateChatAndMessageUsecase.processMessageAndChatUpdate(acceptCallOutput.message_update, acceptCallOutput.chat_update, false, true);
                    if (acceptCallOutput.call_update != null) {
                        ArrayList<VoiceCallModels.CallUpdateObject> arrayList2 = new ArrayList<>();
                        arrayList2.add(acceptCallOutput.call_update);
                        absNotificationCenter.onProcessCallUpdate(arrayList2);
                    }
                    VoiceCallModels.CallUpdateObject callUpdateObject = acceptCallOutput.call_update;
                    if (callUpdateObject != null) {
                        loadListener.onDidLoad(callUpdateObject.object_guid);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public int discardCall(String str, int i, VoiceCallModels.EnumDiscardCallReason enumDiscardCallReason, String str2, NetworkHelper networkHelper, final AbsNotificationCenter absNotificationCenter, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final LoadListener<Integer> loadListener) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        VoiceCallModels.DiscardCallInput discardCallInput = new VoiceCallModels.DiscardCallInput();
        discardCallInput.call_id = str;
        discardCallInput.reason = enumDiscardCallReason;
        discardCallInput.duration = i;
        try {
            return networkHelper.discardCall(str2, discardCallInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<VoiceCallModels.DiscardCallOutput>(this) { // from class: ir.aaap.messengercore.CallUtils.4
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(VoiceCallModels.DiscardCallOutput discardCallOutput) {
                    updateChatAndMessageUsecase.processMessageAndChatUpdate(discardCallOutput.message_update, discardCallOutput.chat_update, false, true);
                    if (discardCallOutput.call_update != null) {
                        ArrayList<VoiceCallModels.CallUpdateObject> arrayList = new ArrayList<>();
                        arrayList.add(discardCallOutput.call_update);
                        absNotificationCenter.onProcessCallUpdate(arrayList);
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(1);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public void rateCall(String str, int i, String str2, String str3, NetworkHelper networkHelper) {
        if (str == null || str.isEmpty()) {
            return;
        }
        VoiceCallModels.RateCallInput rateCallInput = new VoiceCallModels.RateCallInput();
        rateCallInput.call_id = str;
        rateCallInput.star_count = i;
        rateCallInput.comment = str2;
        try {
            networkHelper.rateCall(str3, rateCallInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<VoiceCallModels.RateCallOutput>(this) { // from class: ir.aaap.messengercore.CallUtils.5
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(VoiceCallModels.RateCallOutput rateCallOutput) {
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
        }
    }

    public int sendSignalingData(String str, String str2, String str3, NetworkHelper networkHelper, final LoadListener<Integer> loadListener) {
        if (str == null || str.isEmpty() || str2 == null) {
            return 0;
        }
        VoiceCallModels.SendSignalDataInput sendSignalDataInput = new VoiceCallModels.SendSignalDataInput();
        sendSignalDataInput.call_id = str;
        sendSignalDataInput.data = str2;
        try {
            return networkHelper.sendSignalingData(str3, sendSignalDataInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<VoiceCallModels.SendSignalDataOutput>(this) { // from class: ir.aaap.messengercore.CallUtils.6
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(VoiceCallModels.SendSignalDataOutput sendSignalDataOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public void createGroupVoiceChat(String str, int i, String str2, NetworkHelper networkHelper, final AbsNotificationCenter absNotificationCenter, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final LoadListener<GroupCallModels.GroupVoiceChat> loadListener) {
        GroupCallModels.CreateGroupVoiceChatInput createGroupVoiceChatInput = new GroupCallModels.CreateGroupVoiceChatInput();
        createGroupVoiceChatInput.chat_guid = str;
        createGroupVoiceChatInput.rnd = i;
        try {
            networkHelper.createGroupVoiceChat(str2, createGroupVoiceChatInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GroupCallModels.CreateGroupVoiceChatOutput>() { // from class: ir.aaap.messengercore.CallUtils.7
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GroupCallModels.CreateGroupVoiceChatOutput createGroupVoiceChatOutput) {
                    GroupCallModels.GroupVoiceChat groupVoiceChat;
                    GroupCallModels.GroupVoiceChatUpdate groupVoiceChatUpdate;
                    updateChatAndMessageUsecase.processMessageAndChatUpdate(createGroupVoiceChatOutput.message_update, createGroupVoiceChatOutput.chat_update, false, true);
                    GroupCallModels.StatusCreateGroupVoice statusCreateGroupVoice = createGroupVoiceChatOutput.status;
                    if (statusCreateGroupVoice == GroupCallModels.StatusCreateGroupVoice.Done && (groupVoiceChatUpdate = createGroupVoiceChatOutput.group_voice_chat_update) != null) {
                        CallUtils.this.processGroupVoiceChatUpdate(groupVoiceChatUpdate, absNotificationCenter);
                        groupVoiceChat = createGroupVoiceChatOutput.group_voice_chat_update.group_voice_chat;
                    } else if (statusCreateGroupVoice != GroupCallModels.StatusCreateGroupVoice.VoiceChatExist || (groupVoiceChat = createGroupVoiceChatOutput.exist_group_voice_chat) == null) {
                        groupVoiceChat = null;
                    }
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        if (groupVoiceChat != null) {
                            loadListener2.onDidLoad(groupVoiceChat);
                        } else {
                            loadListener2.onError(new ApiServerException());
                        }
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public void getCalls(boolean z, String str, VoiceCallModels.FilterTypeEnum filterTypeEnum, String str2, NetworkHelper networkHelper, final LoadListener<VoiceCallModels.GetCallsOutput> loadListener) {
        VoiceCallModels.GetCallsInput getCallsInput = new VoiceCallModels.GetCallsInput();
        if (z) {
            getCallsInput.sort = VoiceCallModels.SortTypeEnum.FromMax;
            getCallsInput.max_id = str;
        } else {
            getCallsInput.sort = VoiceCallModels.SortTypeEnum.FromMin;
            getCallsInput.min_id = str;
        }
        if (filterTypeEnum == null) {
            getCallsInput.filter_type = VoiceCallModels.FilterTypeEnum.All;
        } else {
            getCallsInput.filter_type = filterTypeEnum;
        }
        try {
            networkHelper.getCalls(str2, getCallsInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<VoiceCallModels.GetCallsOutput>(this) { // from class: ir.aaap.messengercore.CallUtils.8
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(VoiceCallModels.GetCallsOutput getCallsOutput) {
                    if (getCallsOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(getCallsOutput);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public void getDisplayAsInGroupVoiceChat(String str, String str2, String str3, NetworkHelper networkHelper, final LoadListener<GroupCallModels.GetDisplayAsInGroupVoiceChatOutput> loadListener) {
        GroupCallModels.GetDisplayAsInGroupVoiceChatInput getDisplayAsInGroupVoiceChatInput = new GroupCallModels.GetDisplayAsInGroupVoiceChatInput();
        getDisplayAsInGroupVoiceChatInput.chat_guid = str;
        getDisplayAsInGroupVoiceChatInput.start_id = str2;
        try {
            networkHelper.getDisplayAsInGroupVoiceChat(str3, getDisplayAsInGroupVoiceChatInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GroupCallModels.GetDisplayAsInGroupVoiceChatOutput>(this) { // from class: ir.aaap.messengercore.CallUtils.9
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GroupCallModels.GetDisplayAsInGroupVoiceChatOutput getDisplayAsInGroupVoiceChatOutput) {
                    if (getDisplayAsInGroupVoiceChatOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(getDisplayAsInGroupVoiceChatOutput);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public void getGroupVoiceChatParticipants(String str, String str2, String str3, String str4, NetworkHelper networkHelper, final LoadAbsUsecase loadAbsUsecase, final LoadListener<GroupCallModels.GetGroupVoiceChatParticipantsOutput> loadListener) {
        if (str2 == null || str == null) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
                return;
            }
            return;
        }
        if (str3 != null && str3.isEmpty()) {
            str3 = null;
        }
        GroupCallModels.GetGroupVoiceChatParticipantsInput getGroupVoiceChatParticipantsInput = new GroupCallModels.GetGroupVoiceChatParticipantsInput();
        getGroupVoiceChatParticipantsInput.chat_guid = str;
        getGroupVoiceChatParticipantsInput.voice_chat_id = str2;
        getGroupVoiceChatParticipantsInput.start_id = str3;
        try {
            networkHelper.getGroupVoiceChatParticipants(str4, getGroupVoiceChatParticipantsInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GroupCallModels.GetGroupVoiceChatParticipantsOutput>(this) { // from class: ir.aaap.messengercore.CallUtils.10
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(final GroupCallModels.GetGroupVoiceChatParticipantsOutput getGroupVoiceChatParticipantsOutput) {
                    if (getGroupVoiceChatParticipantsOutput != null) {
                        if (getGroupVoiceChatParticipantsOutput.status == GroupCallModels.Status.OK) {
                            HashSet hashSet = new HashSet();
                            Iterator<GroupCallModels.GroupVoiceChatParticipant> it = getGroupVoiceChatParticipantsOutput.participants.iterator();
                            while (it.hasNext()) {
                                hashSet.add(it.next().participant_object_guid_type.object_guid);
                            }
                            loadAbsUsecase.loadAbs(hashSet, false, new LoadListener<Set<String>>() { // from class: ir.aaap.messengercore.CallUtils.10.1
                                @Override // ir.aaap.messengercore.LoadListener
                                public void onDidLoad(Set<String> set) {
                                    LoadListener loadListener2 = loadListener;
                                    if (loadListener2 != null) {
                                        loadListener2.onDidLoad(getGroupVoiceChatParticipantsOutput);
                                    }
                                }

                                @Override // ir.aaap.messengercore.LoadListener
                                public void onError(Exception exc) {
                                    LoadListener loadListener2 = loadListener;
                                    if (loadListener2 != null) {
                                        loadListener2.onError(exc);
                                    }
                                }
                            });
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(getGroupVoiceChatParticipantsOutput);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public void toggleGroupVoiceChatMuteUnMute(String str, String str2, String str3, boolean z, String str4, NetworkHelper networkHelper, AbsNotificationCenter absNotificationCenter, LoadListener<GroupCallModels.SetGroupVoiceChatStateStatusEnum> loadListener) {
        setGroupVoiceChatState(str, str2, str3, z ? GroupCallModels.SetGroupVoiceChatStateActionEnum.Mute : GroupCallModels.SetGroupVoiceChatStateActionEnum.Unmute, str4, networkHelper, absNotificationCenter, loadListener);
    }

    public void setGroupVoiceChatRaiseHand(String str, String str2, String str3, boolean z, String str4, NetworkHelper networkHelper, AbsNotificationCenter absNotificationCenter, LoadListener<GroupCallModels.SetGroupVoiceChatStateStatusEnum> loadListener) {
        setGroupVoiceChatState(str, str2, str3, z ? GroupCallModels.SetGroupVoiceChatStateActionEnum.RequestSpeak : GroupCallModels.SetGroupVoiceChatStateActionEnum.CancelRequestSpeak, str4, networkHelper, absNotificationCenter, loadListener);
    }

    private void setGroupVoiceChatState(String str, String str2, String str3, GroupCallModels.SetGroupVoiceChatStateActionEnum setGroupVoiceChatStateActionEnum, String str4, NetworkHelper networkHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<GroupCallModels.SetGroupVoiceChatStateStatusEnum> loadListener) {
        GroupCallModels.SetGroupVoiceChatStateInput setGroupVoiceChatStateInput = new GroupCallModels.SetGroupVoiceChatStateInput();
        setGroupVoiceChatStateInput.chat_guid = str;
        setGroupVoiceChatStateInput.voice_chat_id = str2;
        setGroupVoiceChatStateInput.participant_object_guid = str3;
        setGroupVoiceChatStateInput.action = setGroupVoiceChatStateActionEnum;
        try {
            networkHelper.setGroupVoiceChatState(str4, setGroupVoiceChatStateInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GroupCallModels.SetGroupVoiceChatStateOutput>() { // from class: ir.aaap.messengercore.CallUtils.11
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GroupCallModels.SetGroupVoiceChatStateOutput setGroupVoiceChatStateOutput) {
                    if (setGroupVoiceChatStateOutput != null) {
                        if (setGroupVoiceChatStateOutput.status == GroupCallModels.SetGroupVoiceChatStateStatusEnum.OK) {
                            CallUtils.this.processGroupVoiceChatParticipantUpdate(setGroupVoiceChatStateOutput.group_voice_chat_participate_update, false, absNotificationCenter);
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(setGroupVoiceChatStateOutput.status);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onError(new ApiServerException());
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public void getGroupVoiceChat(final String str, String str2, String str3, NetworkHelper networkHelper, AbsNotificationCenter absNotificationCenter, final LoadListener<GroupCallModels.GroupVoiceChat> loadListener) {
        GroupCallModels.GetGroupVoiceChatInput getGroupVoiceChatInput = new GroupCallModels.GetGroupVoiceChatInput();
        getGroupVoiceChatInput.chat_guid = str;
        getGroupVoiceChatInput.voice_chat_id = str2;
        Integer num = this.loadingGroupCalls.get(str);
        if (num != null) {
            networkHelper.cancelCall(num.intValue());
        }
        try {
            this.loadingGroupCalls.put(str, Integer.valueOf(networkHelper.getGroupVoiceChat(str3, getGroupVoiceChatInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GroupCallModels.GetGroupVoiceChatOutput>() { // from class: ir.aaap.messengercore.CallUtils.12
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GroupCallModels.GetGroupVoiceChatOutput getGroupVoiceChatOutput) {
                    CallUtils.this.loadingGroupCalls.remove(str);
                    GroupCallModels.GroupVoiceChat groupVoiceChat = (getGroupVoiceChatOutput == null || !getGroupVoiceChatOutput.is_exist) ? null : getGroupVoiceChatOutput.group_voice_chat;
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(groupVoiceChat);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                    CallUtils.this.loadingGroupCalls.remove(str);
                }
            })));
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.loadingGroupCalls.remove(str);
            this.coreLog.handleException(e);
        }
    }

    public void joinGroupVoiceChat(final String str, String str2, final ChatType chatType, final String str3, String str4, String str5, NetworkHelper networkHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<String> loadListener) {
        GroupCallModels.JoinGroupVoiceChatInput joinGroupVoiceChatInput = new GroupCallModels.JoinGroupVoiceChatInput();
        joinGroupVoiceChatInput.chat_guid = str;
        joinGroupVoiceChatInput.voice_chat_id = str3;
        joinGroupVoiceChatInput.sdp_offer_data = str4;
        joinGroupVoiceChatInput.self_object_guid = str2;
        try {
            networkHelper.joinGroupVoiceChat(str5, joinGroupVoiceChatInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GroupCallModels.JoinGroupVoiceChatOutput>() { // from class: ir.aaap.messengercore.CallUtils.13
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GroupCallModels.JoinGroupVoiceChatOutput joinGroupVoiceChatOutput) {
                    CallUtils.this.loadingGroupCalls.remove(str);
                    if (joinGroupVoiceChatOutput != null) {
                        ArrayList<ObjectGuidType> arrayList = joinGroupVoiceChatOutput.deleted_participant_object_guid_types;
                        if (arrayList != null) {
                            Iterator<ObjectGuidType> it = arrayList.iterator();
                            while (it.hasNext()) {
                                ObjectGuidType next = it.next();
                                GroupCallModels.GroupVoiceChatParticipantUpdate groupVoiceChatParticipantUpdate = new GroupCallModels.GroupVoiceChatParticipantUpdate();
                                groupVoiceChatParticipantUpdate.action = GroupCallModels.GroupVoiceChatParticipantUpdateAction.Delete;
                                groupVoiceChatParticipantUpdate.participant_object_guid_type = next;
                                groupVoiceChatParticipantUpdate.timestamp = (int) (System.currentTimeMillis() / 1000);
                                groupVoiceChatParticipantUpdate.voice_chat_id = str3;
                                groupVoiceChatParticipantUpdate.chat_guid_type = new ObjectGuidType(str, chatType);
                                ArrayList<GroupCallModels.GroupVoiceChatParticipantUpdate> arrayList2 = new ArrayList<>();
                                arrayList2.add(groupVoiceChatParticipantUpdate);
                                CallUtils.this.processGroupVoiceChatParticipantUpdate(arrayList2, false, absNotificationCenter);
                            }
                        }
                        CallUtils.this.processGroupVoiceChatUpdate(joinGroupVoiceChatOutput.group_voice_chat_update, absNotificationCenter);
                        CallUtils.this.processGroupVoiceChatParticipantUpdate(joinGroupVoiceChatOutput.group_voice_chat_participate_update, false, absNotificationCenter);
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(joinGroupVoiceChatOutput.sdp_answer_data);
                        }
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void leaveGroupVoiceChat(String str, String str2, String str3, NetworkHelper networkHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<Integer> loadListener) {
        if (str == null || str2 == null) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
                return;
            }
            return;
        }
        GroupCallModels.LeaveGroupVoiceChatInput leaveGroupVoiceChatInput = new GroupCallModels.LeaveGroupVoiceChatInput();
        leaveGroupVoiceChatInput.chat_guid = str;
        leaveGroupVoiceChatInput.voice_chat_id = str2;
        try {
            networkHelper.leaveGroupVoiceChat(str3, leaveGroupVoiceChatInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GroupCallModels.LeaveGroupVoiceChatOutput>() { // from class: ir.aaap.messengercore.CallUtils.14
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GroupCallModels.LeaveGroupVoiceChatOutput leaveGroupVoiceChatOutput) {
                    if (leaveGroupVoiceChatOutput != null) {
                        CallUtils.this.processGroupVoiceChatUpdate(leaveGroupVoiceChatOutput.group_voice_chat_update, absNotificationCenter);
                    }
                    loadListener.onDidLoad(1);
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void discardGroupVoiceChat(String str, String str2, String str3, NetworkHelper networkHelper, final AbsNotificationCenter absNotificationCenter, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final LoadListener<Integer> loadListener) {
        if (str == null || str2 == null) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
                return;
            }
            return;
        }
        GroupCallModels.DiscardGroupVoiceChatInput discardGroupVoiceChatInput = new GroupCallModels.DiscardGroupVoiceChatInput();
        discardGroupVoiceChatInput.chat_guid = str;
        discardGroupVoiceChatInput.voice_chat_id = str2;
        try {
            networkHelper.discardGroupVoiceChat(str3, discardGroupVoiceChatInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GroupCallModels.DiscardGroupVoiceChatOutput>() { // from class: ir.aaap.messengercore.CallUtils.15
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GroupCallModels.DiscardGroupVoiceChatOutput discardGroupVoiceChatOutput) {
                    if (discardGroupVoiceChatOutput != null) {
                        updateChatAndMessageUsecase.processMessageAndChatUpdate(discardGroupVoiceChatOutput.message_update, discardGroupVoiceChatOutput.chat_update, false, true);
                        CallUtils.this.processGroupVoiceChatUpdate(discardGroupVoiceChatOutput.group_voice_chat_update, absNotificationCenter);
                    }
                    loadListener.onDidLoad(1);
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void processGroupVoiceChatParticipantUpdate(ArrayList<GroupCallModels.GroupVoiceChatParticipantUpdate> arrayList, boolean z, AbsNotificationCenter absNotificationCenter) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        absNotificationCenter.processGroupVoiceChatParticipantUpdate(arrayList, z);
    }

    public void loadUnknownParticipants(String str, String str2, Set<String> set, String str3, NetworkHelper networkHelper, final LoadListener<GroupCallModels.GetGroupVoiceChatParticipantsByObjectGuidsOutput> loadListener) {
        GroupCallModels.GetGroupVoiceChatParticipantsByObjectGuidsInput getGroupVoiceChatParticipantsByObjectGuidsInput = new GroupCallModels.GetGroupVoiceChatParticipantsByObjectGuidsInput();
        getGroupVoiceChatParticipantsByObjectGuidsInput.chat_guid = str;
        getGroupVoiceChatParticipantsByObjectGuidsInput.voice_chat_id = str2;
        getGroupVoiceChatParticipantsByObjectGuidsInput.object_guids = set;
        try {
            networkHelper.getGroupVoiceChatParticipantsByObjectGuids(str3, getGroupVoiceChatParticipantsByObjectGuidsInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GroupCallModels.GetGroupVoiceChatParticipantsByObjectGuidsOutput>() { // from class: ir.aaap.messengercore.CallUtils.16
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GroupCallModels.GetGroupVoiceChatParticipantsByObjectGuidsOutput getGroupVoiceChatParticipantsByObjectGuidsOutput) {
                    if (getGroupVoiceChatParticipantsByObjectGuidsOutput.group_voice_chat_participants != null) {
                        HashSet hashSet = new HashSet();
                        int size = getGroupVoiceChatParticipantsByObjectGuidsOutput.group_voice_chat_participants.size();
                        for (int i = 0; i < size; i++) {
                            hashSet.add(getGroupVoiceChatParticipantsByObjectGuidsOutput.group_voice_chat_participants.get(i).participant_object_guid_type.object_guid);
                        }
                        if (CallUtils.this.loadAbsUsecase != null) {
                            CallUtils.this.loadAbsUsecase.loadAbs(hashSet, false, null);
                        }
                    }
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(getGroupVoiceChatParticipantsByObjectGuidsOutput);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void processGroupVoiceChatParticipantUpdate(GroupCallModels.GroupVoiceChatParticipantUpdate groupVoiceChatParticipantUpdate, boolean z, AbsNotificationCenter absNotificationCenter) {
        if (groupVoiceChatParticipantUpdate == null) {
            return;
        }
        ArrayList<GroupCallModels.GroupVoiceChatParticipantUpdate> arrayList = new ArrayList<>(1);
        arrayList.add(groupVoiceChatParticipantUpdate);
        processGroupVoiceChatParticipantUpdate(arrayList, z, absNotificationCenter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processGroupVoiceChatUpdate(GroupCallModels.GroupVoiceChatUpdate groupVoiceChatUpdate, AbsNotificationCenter absNotificationCenter) {
        if (groupVoiceChatUpdate == null) {
            return;
        }
        absNotificationCenter.processGroupCallUpdate(groupVoiceChatUpdate);
    }

    public void getGroupVoiceChatUpdates(String str, String str2, String str3, String str4, NetworkHelper networkHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<GroupCallModels.GetGroupVoiceChatUpdatesResult> loadListener) {
        if (str == null || str3 == null || str2 == null) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
                return;
            }
            return;
        }
        GroupCallModels.GetGroupVoiceChatUpdatesInput getGroupVoiceChatUpdatesInput = new GroupCallModels.GetGroupVoiceChatUpdatesInput();
        getGroupVoiceChatUpdatesInput.chat_guid = str2;
        getGroupVoiceChatUpdatesInput.voice_chat_id = str;
        getGroupVoiceChatUpdatesInput.state = str3;
        try {
            networkHelper.getGroupVoiceChatUpdates(str4, getGroupVoiceChatUpdatesInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GroupCallModels.GetGroupVoiceChatUpdatesOutput>() { // from class: ir.aaap.messengercore.CallUtils.17
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GroupCallModels.GetGroupVoiceChatUpdatesOutput getGroupVoiceChatUpdatesOutput) {
                    GroupCallModels.GetGroupVoiceChatUpdatesResult getGroupVoiceChatUpdatesResult;
                    if (getGroupVoiceChatUpdatesOutput != null) {
                        if (getGroupVoiceChatUpdatesOutput.status == GroupCallModels.GetGroupVoiceChatUpdatesStatus.OK) {
                            CallUtils.this.processGroupVoiceChatParticipantUpdate(getGroupVoiceChatUpdatesOutput.group_voice_chat_participant_updates, false, absNotificationCenter);
                        }
                        getGroupVoiceChatUpdatesResult = new GroupCallModels.GetGroupVoiceChatUpdatesResult();
                        getGroupVoiceChatUpdatesResult.is_joined = getGroupVoiceChatUpdatesOutput.is_joined;
                        getGroupVoiceChatUpdatesResult.new_state = getGroupVoiceChatUpdatesOutput.new_state;
                        getGroupVoiceChatUpdatesResult.status = getGroupVoiceChatUpdatesOutput.status;
                    } else {
                        getGroupVoiceChatUpdatesResult = null;
                    }
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(getGroupVoiceChatUpdatesResult);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void sendGroupVoiceChatActivity(GroupCallModels.SendGroupVoiceChatActivityEnum sendGroupVoiceChatActivityEnum, String str, String str2, String str3, NetworkHelper networkHelper, final LoadListener<GroupCallModels.Status> loadListener) {
        if (sendGroupVoiceChatActivityEnum == null || str == null || str2 == null) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
                return;
            }
            return;
        }
        GroupCallModels.SendGroupVoiceChatActivityInput sendGroupVoiceChatActivityInput = new GroupCallModels.SendGroupVoiceChatActivityInput();
        sendGroupVoiceChatActivityInput.activity = sendGroupVoiceChatActivityEnum;
        sendGroupVoiceChatActivityInput.chat_guid = str;
        sendGroupVoiceChatActivityInput.voice_chat_id = str2;
        try {
            networkHelper.sendGroupVoiceChatActivity(str3, sendGroupVoiceChatActivityInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GroupCallModels.SendGroupVoiceChatActivityOutput>(this) { // from class: ir.aaap.messengercore.CallUtils.18
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GroupCallModels.SendGroupVoiceChatActivityOutput sendGroupVoiceChatActivityOutput) {
                    if (sendGroupVoiceChatActivityOutput != null) {
                        loadListener.onDidLoad(sendGroupVoiceChatActivityOutput.status);
                    } else {
                        loadListener.onDidLoad(null);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void setGroupVoiceChatTitle(String str, String str2, String str3, String str4, NetworkHelper networkHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<GroupCallModels.Status> loadListener) {
        if (str2 == null || str == null || str2.isEmpty() || str.isEmpty()) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
                return;
            }
            return;
        }
        if (str3 != null && str3.isEmpty()) {
            str3 = null;
        }
        GroupCallModels.SetGroupVoiceChatSettingInput setGroupVoiceChatSettingInput = new GroupCallModels.SetGroupVoiceChatSettingInput();
        setGroupVoiceChatSettingInput.chat_guid = str;
        setGroupVoiceChatSettingInput.voice_chat_id = str2;
        setGroupVoiceChatSettingInput.title = str3;
        setGroupVoiceChatSettingInput.updated_parameters.add(GroupCallModels.SettingsEnumParams.title);
        try {
            networkHelper.setGroupVoiceChatSetting(str4, setGroupVoiceChatSettingInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GroupCallModels.SetGroupVoiceChatSettingOutput>() { // from class: ir.aaap.messengercore.CallUtils.19
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GroupCallModels.SetGroupVoiceChatSettingOutput setGroupVoiceChatSettingOutput) {
                    if (setGroupVoiceChatSettingOutput != null) {
                        if (setGroupVoiceChatSettingOutput.status == GroupCallModels.Status.OK) {
                            CallUtils.this.processGroupVoiceChatUpdate(setGroupVoiceChatSettingOutput.group_voice_chat_update, absNotificationCenter);
                        }
                        loadListener.onDidLoad(setGroupVoiceChatSettingOutput.status);
                        return;
                    }
                    loadListener.onDidLoad(null);
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public void setGroupVoiceChatJoinMute(String str, String str2, boolean z, String str3, NetworkHelper networkHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<GroupCallModels.Status> loadListener) {
        if (str2 == null || str == null || str2.isEmpty() || str.isEmpty()) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
                return;
            }
            return;
        }
        GroupCallModels.SetGroupVoiceChatSettingInput setGroupVoiceChatSettingInput = new GroupCallModels.SetGroupVoiceChatSettingInput();
        setGroupVoiceChatSettingInput.chat_guid = str;
        setGroupVoiceChatSettingInput.voice_chat_id = str2;
        setGroupVoiceChatSettingInput.join_muted = z;
        setGroupVoiceChatSettingInput.updated_parameters.add(GroupCallModels.SettingsEnumParams.join_muted);
        try {
            networkHelper.setGroupVoiceChatSetting(str3, setGroupVoiceChatSettingInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GroupCallModels.SetGroupVoiceChatSettingOutput>() { // from class: ir.aaap.messengercore.CallUtils.20
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GroupCallModels.SetGroupVoiceChatSettingOutput setGroupVoiceChatSettingOutput) {
                    if (setGroupVoiceChatSettingOutput != null) {
                        if (setGroupVoiceChatSettingOutput.status == GroupCallModels.Status.OK) {
                            CallUtils.this.processGroupVoiceChatUpdate(setGroupVoiceChatSettingOutput.group_voice_chat_update, absNotificationCenter);
                        }
                        loadListener.onDidLoad(setGroupVoiceChatSettingOutput.status);
                        return;
                    }
                    loadListener.onDidLoad(null);
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public int getSignalingData(String str, String str2, NetworkHelper networkHelper, final LoadListener<VoiceCallModels.GetSignalingDataOutput> loadListener) {
        if (CoreUtilities.isEmpty(str)) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
            }
            return -1;
        }
        VoiceCallModels.GetSignalingDataInput getSignalingDataInput = new VoiceCallModels.GetSignalingDataInput();
        getSignalingDataInput.call_id = str;
        try {
            return networkHelper.getSignalingData(str2, getSignalingDataInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<VoiceCallModels.GetSignalingDataOutput>(this) { // from class: ir.aaap.messengercore.CallUtils.22
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(VoiceCallModels.GetSignalingDataOutput getSignalingDataOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(getSignalingDataOutput);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            return -1;
        }
    }

    public int callStarted(String str, String str2, NetworkHelper networkHelper, final LoadListener<Integer> loadListener) {
        if (CoreUtilities.isEmpty(str)) {
            if (loadListener != null) {
                loadListener.onError(new InputException(InputException.ErrorEnum.IsInvalidInput));
            }
            return -1;
        }
        VoiceCallModels.CallStartedInput callStartedInput = new VoiceCallModels.CallStartedInput();
        callStartedInput.call_id = str;
        try {
            return networkHelper.callStarted(str2, callStartedInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<VoiceCallModels.CallStartedOutput>(this) { // from class: ir.aaap.messengercore.CallUtils.23
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(VoiceCallModels.CallStartedOutput callStartedOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (loadListener != null) {
                loadListener.onError(e);
            }
            return -1;
        }
    }
}
