package ir.aaap.messengercore;

import ir.aaap.messengercore.db.DBHelper;
import ir.aaap.messengercore.model.LiveModels;
import ir.aaap.messengercore.network.ApiServerException;
import ir.aaap.messengercore.network.NetworkHelper;
import ir.aaap.messengercore.network.RetryObject;
import ir.aaap.messengercore.usecase.UpdateChatAndMessageUsecase;
import ir.aaap.messengercore.utilites.CoreLog;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class LiveUtils {
    private CoreLog coreLog;
    private LiveModels.LastLiveState lastLiveState;

    public LiveUtils(CoreLog coreLog) {
        this.coreLog = coreLog;
    }

    public int sendLive(String str, String str2, String str3, long j, boolean z, String str4, NetworkHelper networkHelper, DBHelper dBHelper, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final LoadListener<LiveModels.SendLiveResult> loadListener) {
        LiveModels.SendLiveInput sendLiveInput = new LiveModels.SendLiveInput();
        sendLiveInput.object_guid = str;
        sendLiveInput.thumb_inline = str2;
        if (!CoreUtilities.isNotEmpty(str3)) {
            str3 = null;
        }
        sendLiveInput.title = str3;
        sendLiveInput.rnd = j;
        sendLiveInput.device_type = z ? LiveModels.DeviceTypeEnum.Software : LiveModels.DeviceTypeEnum.Mobile;
        try {
            return networkHelper.sendLive(str4, sendLiveInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<LiveModels.SendLiveOutput>(this) { // from class: ir.aaap.messengercore.LiveUtils.1
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(LiveModels.SendLiveOutput sendLiveOutput) {
                    UpdateChatAndMessageUsecase updateChatAndMessageUsecase2;
                    if (sendLiveOutput != null) {
                        if (sendLiveOutput.status == LiveModels.Status.OK && (updateChatAndMessageUsecase2 = updateChatAndMessageUsecase) != null) {
                            updateChatAndMessageUsecase2.processMessageAndChatUpdate(sendLiveOutput.message_update, sendLiveOutput.chat_update, false, true);
                        }
                        LiveModels.SendLiveResult sendLiveResult = new LiveModels.SendLiveResult();
                        sendLiveResult.status = sendLiveOutput.status;
                        sendLiveResult.publish_text = sendLiveOutput.publish_text;
                        sendLiveResult.publish_url = sendLiveOutput.publish_url;
                        sendLiveResult.liveMessage = sendLiveOutput.message_update.message;
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(sendLiveResult);
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

    public int stopLive(final String str, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter) {
        LiveModels.StopLiveInput stopLiveInput = new LiveModels.StopLiveInput();
        stopLiveInput.live_id = str;
        try {
            return networkHelper.stopLive(str2, stopLiveInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<LiveModels.StopLiveOutput>() { // from class: ir.aaap.messengercore.LiveUtils.2
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(LiveModels.StopLiveOutput stopLiveOutput) {
                    if (stopLiveOutput != null) {
                        LiveUtils.this.processLiveStatusChanged(str, stopLiveOutput.live_status, dBHelper, absNotificationCenter);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int setLiveSetting(final String str, boolean z, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter) {
        LiveModels.SetLiveSettingInput setLiveSettingInput = new LiveModels.SetLiveSettingInput();
        setLiveSettingInput.live_id = str;
        ArrayList<LiveModels.EnumParams> arrayList = new ArrayList<>();
        setLiveSettingInput.updated_parameters = arrayList;
        arrayList.add(LiveModels.EnumParams.allow_comment);
        setLiveSettingInput.allow_comment = z;
        try {
            return networkHelper.setLiveSetting(str2, setLiveSettingInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<LiveModels.SetLiveSettingOutput>() { // from class: ir.aaap.messengercore.LiveUtils.3
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(LiveModels.SetLiveSettingOutput setLiveSettingOutput) {
                    if (setLiveSettingOutput != null) {
                        LiveUtils.this.processLiveStatusChanged(str, setLiveSettingOutput.live_status, dBHelper, absNotificationCenter);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int getLiveStatus(final String str, String str2, LiveModels.GetLiveStatusType getLiveStatusType, String str3, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter) {
        LiveModels.GetLiveStatusInput getLiveStatusInput = new LiveModels.GetLiveStatusInput();
        getLiveStatusInput.live_id = str;
        getLiveStatusInput.access_token = str2;
        getLiveStatusInput.type = getLiveStatusType;
        try {
            return networkHelper.getLiveStatus(str3, getLiveStatusInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<LiveModels.GetLiveStatusOutput>() { // from class: ir.aaap.messengercore.LiveUtils.4
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(LiveModels.GetLiveStatusOutput getLiveStatusOutput) {
                    LiveModels.LiveStatus liveStatus;
                    if (getLiveStatusOutput == null || (liveStatus = getLiveStatusOutput.live_status) == null) {
                        return;
                    }
                    liveStatus.isBlocked = getLiveStatusOutput.is_blocked;
                    LiveUtils.this.processLiveStatusChanged(str, liveStatus, dBHelper, absNotificationCenter);
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int getLivePlayUrl(final String str, String str2, String str3, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<LiveModels.GetLivePlayUrlResult> loadListener) {
        LiveModels.GetLivePlayUrlInput getLivePlayUrlInput = new LiveModels.GetLivePlayUrlInput();
        getLivePlayUrlInput.live_id = str;
        getLivePlayUrlInput.access_token = str2;
        try {
            return networkHelper.getLivePlayUrl(str3, getLivePlayUrlInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<LiveModels.GetLivePlayUrlOutput>() { // from class: ir.aaap.messengercore.LiveUtils.5
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(LiveModels.GetLivePlayUrlOutput getLivePlayUrlOutput) {
                    if (getLivePlayUrlOutput != null) {
                        LiveUtils.this.processLiveStatusChanged(str, getLivePlayUrlOutput.live_status, dBHelper, absNotificationCenter);
                        LiveModels.GetLivePlayUrlResult getLivePlayUrlResult = new LiveModels.GetLivePlayUrlResult();
                        getLivePlayUrlResult.play_url = getLivePlayUrlOutput.play_url;
                        getLivePlayUrlResult.play_type = getLivePlayUrlOutput.play_type;
                        getLivePlayUrlResult.is_owner = getLivePlayUrlOutput.is_owner;
                        getLivePlayUrlResult.can_play = getLivePlayUrlOutput.live_status.can_play;
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(getLivePlayUrlResult);
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

    public int addLiveComment(String str, String str2, String str3, String str4, NetworkHelper networkHelper, final LoadListener<LiveModels.AddLiveCommentOutput> loadListener) {
        LiveModels.AddLiveCommentInput addLiveCommentInput = new LiveModels.AddLiveCommentInput();
        addLiveCommentInput.live_id = str;
        addLiveCommentInput.access_token = str2;
        addLiveCommentInput.text = str3;
        try {
            return networkHelper.addLiveComment(str4, addLiveCommentInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<LiveModels.AddLiveCommentOutput>(this) { // from class: ir.aaap.messengercore.LiveUtils.6
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(LiveModels.AddLiveCommentOutput addLiveCommentOutput) {
                    if (addLiveCommentOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(addLiveCommentOutput);
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

    public int getLiveComments(String str, String str2, String str3, String str4, NetworkHelper networkHelper, final LoadListener<LiveModels.GetLiveCommentsOutput> loadListener) {
        LiveModels.GetLiveCommentsInput getLiveCommentsInput = new LiveModels.GetLiveCommentsInput();
        getLiveCommentsInput.live_id = str;
        getLiveCommentsInput.access_token = str2;
        getLiveCommentsInput.start_id = str3;
        try {
            return networkHelper.getLiveComments(str4, getLiveCommentsInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<LiveModels.GetLiveCommentsOutput>(this) { // from class: ir.aaap.messengercore.LiveUtils.7
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(LiveModels.GetLiveCommentsOutput getLiveCommentsOutput) {
                    if (getLiveCommentsOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(getLiveCommentsOutput);
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

    public int getLiveViewers(String str, String str2, String str3, NetworkHelper networkHelper, final LoadListener<LiveModels.GetLiveViewersOutput> loadListener) {
        LiveModels.GetLiveViewersInput getLiveViewersInput = new LiveModels.GetLiveViewersInput();
        getLiveViewersInput.live_id = str;
        getLiveViewersInput.start_id = str2;
        getLiveViewersInput.type = LiveModels.GetLiveViewersType.Live;
        try {
            return networkHelper.getLiveViewers(str3, getLiveViewersInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<LiveModels.GetLiveViewersOutput>(this) { // from class: ir.aaap.messengercore.LiveUtils.8
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(LiveModels.GetLiveViewersOutput getLiveViewersOutput) {
                    if (getLiveViewersOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(getLiveViewersOutput);
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

    public void processLiveStatusChanged(ArrayList<LiveModels.LiveUpdate> arrayList, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<LiveModels.LiveUpdate> it = arrayList.iterator();
        while (it.hasNext()) {
            LiveModels.LiveUpdate next = it.next();
            processLiveStatusChanged(next.live_id, next.live_status, dBHelper, absNotificationCenter);
        }
    }

    public void processLiveStatusChanged(String str, LiveModels.LiveStatus liveStatus, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter) {
        if (liveStatus == null || str == null) {
            return;
        }
        dBHelper.updateMessageLiveStatus(str, liveStatus);
        absNotificationCenter.liveStatusChanged(str, liveStatus);
    }

    public LiveModels.LastLiveState getLastLiveState(KeyValueStorageHelper keyValueStorageHelper) {
        LiveModels.LastLiveState lastLiveState = this.lastLiveState;
        return lastLiveState != null ? lastLiveState : keyValueStorageHelper.getLastLiveState();
    }

    public void setLastLiveState(String str, String str2, boolean z, String str3, KeyValueStorageHelper keyValueStorageHelper) {
        if (str == null) {
            return;
        }
        if (this.lastLiveState == null) {
            this.lastLiveState = new LiveModels.LastLiveState();
        }
        this.lastLiveState.timestamp = System.currentTimeMillis();
        LiveModels.LastLiveState lastLiveState = this.lastLiveState;
        lastLiveState.live_id = str;
        lastLiveState.streamURl = str2;
        lastLiveState.isExternalPublish = z;
        lastLiveState.publishText = str3;
        keyValueStorageHelper.setLastLiveState(lastLiveState);
    }
}
