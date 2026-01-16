package ir.aaap.messengercore;

import android.text.TextUtils;
import ir.aaap.messengercore.db.DBHelper;
import ir.aaap.messengercore.db.GetMessagesResultInner;
import ir.aaap.messengercore.exceptions.InputException;
import ir.aaap.messengercore.exceptions.InvalidInputException;
import ir.aaap.messengercore.model.Chat;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.ClickMessageUrlInput;
import ir.aaap.messengercore.model.ClickMessageUrlOutput;
import ir.aaap.messengercore.model.FileInlineObject;
import ir.aaap.messengercore.model.GetLinkFromAppUrlInput;
import ir.aaap.messengercore.model.GetLinkFromAppUrlOutput;
import ir.aaap.messengercore.model.LiveLocationInfo;
import ir.aaap.messengercore.model.LiveLocationObject;
import ir.aaap.messengercore.model.LoadMessagesIntervalResult;
import ir.aaap.messengercore.model.LoadMessagesResult;
import ir.aaap.messengercore.model.LocationObject;
import ir.aaap.messengercore.model.MapViewObject;
import ir.aaap.messengercore.model.Message;
import ir.aaap.messengercore.model.MessageParamUpdateTimeObject;
import ir.aaap.messengercore.model.MessageReactionObject;
import ir.aaap.messengercore.model.MessageUpdateObject;
import ir.aaap.messengercore.model.MessageUpdateResult;
import ir.aaap.messengercore.model.ObjectGuidType;
import ir.aaap.messengercore.model.PinMessageResult;
import ir.aaap.messengercore.model.PollModels;
import ir.aaap.messengercore.model.PollObject;
import ir.aaap.messengercore.model.PollStatusObject;
import ir.aaap.messengercore.model.RubinoPostData;
import ir.aaap.messengercore.model.RubinoStoryData;
import ir.aaap.messengercore.model.SearchChatMessagesResult;
import ir.aaap.messengercore.model.SettingModels;
import ir.aaap.messengercore.model.StickerObject;
import ir.aaap.messengercore.model.StickerSetObject;
import ir.aaap.messengercore.model.UserReactionObject;
import ir.aaap.messengercore.model.WalletTransferDataObject;
import ir.aaap.messengercore.model.api.ActionOnStickersInput;
import ir.aaap.messengercore.model.api.ActionOnStickersOutput;
import ir.aaap.messengercore.model.api.AddToMyGifSetInput;
import ir.aaap.messengercore.model.api.AddToMyGifSetOutput;
import ir.aaap.messengercore.model.api.DeleteMessagesInput;
import ir.aaap.messengercore.model.api.DeleteMessagesOutput;
import ir.aaap.messengercore.model.api.EditMessageInput;
import ir.aaap.messengercore.model.api.EditMessagesOutput;
import ir.aaap.messengercore.model.api.ForwardMessageInput;
import ir.aaap.messengercore.model.api.GetChannelSeenCountInput;
import ir.aaap.messengercore.model.api.GetChannelSeenCountOutput;
import ir.aaap.messengercore.model.api.GetMapViewInput;
import ir.aaap.messengercore.model.api.GetMapViewOutput;
import ir.aaap.messengercore.model.api.GetMessageShareUrlInput;
import ir.aaap.messengercore.model.api.GetMessageShareUrlOutput;
import ir.aaap.messengercore.model.api.GetMessagesByIdInput;
import ir.aaap.messengercore.model.api.GetMessagesByIdOutput;
import ir.aaap.messengercore.model.api.GetMessagesInput;
import ir.aaap.messengercore.model.api.GetMessagesIntervalOutput;
import ir.aaap.messengercore.model.api.GetMessagesOutput;
import ir.aaap.messengercore.model.api.GetMessagesUpdatesInput;
import ir.aaap.messengercore.model.api.GetMessagesUpdatesOutput;
import ir.aaap.messengercore.model.api.GetMyGifSetInput;
import ir.aaap.messengercore.model.api.GetMyGifSetOutput;
import ir.aaap.messengercore.model.api.GetMyStickerSetsInput;
import ir.aaap.messengercore.model.api.GetStickerSetByIdInput;
import ir.aaap.messengercore.model.api.GetStickerSetByIdOutput;
import ir.aaap.messengercore.model.api.GetStickersByEmojiInput;
import ir.aaap.messengercore.model.api.GetStickersByEmojiOutput;
import ir.aaap.messengercore.model.api.GetStickersBySetIDsInput;
import ir.aaap.messengercore.model.api.GetStickersBySetIDsOutput;
import ir.aaap.messengercore.model.api.GetStickersInput;
import ir.aaap.messengercore.model.api.GetStickersOutput;
import ir.aaap.messengercore.model.api.LiveLocationInput;
import ir.aaap.messengercore.model.api.LiveLocationOutput;
import ir.aaap.messengercore.model.api.RemoveFromMyGifSetInput;
import ir.aaap.messengercore.model.api.RemoveFromMyGifSetOutput;
import ir.aaap.messengercore.model.api.ReorderStickerSetsInput;
import ir.aaap.messengercore.model.api.ReorderStickerSetsOutput;
import ir.aaap.messengercore.model.api.SearchChatMessagesInput;
import ir.aaap.messengercore.model.api.SearchChatMessagesOutput;
import ir.aaap.messengercore.model.api.SearchGlobalMessagesInput;
import ir.aaap.messengercore.model.api.SearchGlobalMessagesOutput;
import ir.aaap.messengercore.model.api.SeenChannelMessagesInput;
import ir.aaap.messengercore.model.api.SeenChannelMessagesOutput;
import ir.aaap.messengercore.model.api.SendMessageInput;
import ir.aaap.messengercore.model.api.SendMessageOutput;
import ir.aaap.messengercore.model.api.SendProductMessageInput;
import ir.aaap.messengercore.model.api.SendRubinoPostInput;
import ir.aaap.messengercore.model.api.SendRubinoStoryInput;
import ir.aaap.messengercore.model.api.SendWalletTransactionMessageInput;
import ir.aaap.messengercore.model.api.SetChatUseTimeInput;
import ir.aaap.messengercore.model.api.SetChatUseTimeOutput;
import ir.aaap.messengercore.model.api.SetCurrentLiveLocationInput;
import ir.aaap.messengercore.model.api.SetCurrentLiveLocationOutput;
import ir.aaap.messengercore.model.api.SetPinMessageInput;
import ir.aaap.messengercore.model.api.SetPinMessageOutput;
import ir.aaap.messengercore.network.ApiServerException;
import ir.aaap.messengercore.network.NetworkHelper;
import ir.aaap.messengercore.network.RetryObject;
import ir.aaap.messengercore.usecase.GetChatAccessUseCase;
import ir.aaap.messengercore.usecase.LoadAbsUsecase;
import ir.aaap.messengercore.usecase.UpdateBotInfoUsecase;
import ir.aaap.messengercore.usecase.UpdateChatAndMessageUsecase;
import ir.aaap.messengercore.usecase.UpdateMessageUsecase;
import ir.aaap.messengercore.utilites.CoreLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class MessageUtils {
    private final CoreLog coreLog;
    private int lastSearchChatMessageReqID;
    private int lastSearchGlobalReqID;
    private final RetryObject retry = RetryObject.getDefaultRetry();
    private Set<String> messagesStartedSet = new HashSet();
    private Set<String> actionOnPollSet = new HashSet();
    private Set<String> votePollSet = new HashSet();
    private final Object messageLock = new Object();
    private final Object stickerLock = new Object();
    private final Object gifLock = new Object();
    private final Object pollLock = new Object();
    private final Object liveLocationLock = new Object();
    private final Map<Long, Message> messagesMap = new HashMap();
    private final Map<String, Long> messageUpdatedTimeMap = new HashMap();
    private Map<String, Long> chatUseStartTimeMap = new HashMap();
    private final Map<String, Runnable> updateRunnableMap = new HashMap();
    private final Map<String, Integer> updateRequestIdMap = new HashMap();
    private final Map<String, Integer> pinMessageRequestMap = new HashMap();
    private final Map<String, StickerSetObject> stickerSetObjectMap = new HashMap();
    private final ArrayList<String> myStickerSetsOrder = new ArrayList<>();
    private final ArrayList<FileInlineObject> recentGifArray = new ArrayList<>();
    private final Map<String, ArrayList<StickerObject>> stickerBySetIdMap = new HashMap();
    private final Map<String, PollObject> pollMap = new HashMap();
    private final Map<String, Message> liveLocationsMessageMap = new HashMap();
    private final Set<String> updateLoadingSet = new HashSet();
    private final Map<String, Integer> updateLiveLocationRequestIdMap = new HashMap();
    private boolean isLoadingMessageShareUrl = false;
    private int lastGroupId = 1;
    private final Object groupIdLock = new Object();
    Comparator<Message> messageComparatorToTop = new Comparator<Message>() { // from class: ir.aaap.messengercore.MessageUtils.56
        @Override // java.util.Comparator
        public int compare(Message message, Message message2) {
            return MessageUtils.this.messageComparatorToBottom.compare(message, message2) * (-1);
        }
    };
    Comparator<Message> messageComparatorToBottom = new Comparator<Message>() { // from class: ir.aaap.messengercore.MessageUtils.57
        @Override // java.util.Comparator
        public int compare(Message message, Message message2) {
            if (message.message_id == 0 && message2.message_id == 0) {
                return 0;
            }
            if (message.getSortingMessageId() == message2.getSortingMessageId()) {
                long j = message.message_id;
                if (j >= 0) {
                    long j2 = message2.message_id;
                    if (j2 >= 0) {
                        return MessageUtils.this.compareTo(j, j2);
                    }
                }
                if (j <= 0 && message2.message_id <= 0) {
                    return MessageUtils.this.compareTo(Math.abs(j), Math.abs(message2.message_id));
                }
                return MessageUtils.this.compareTo(j, message2.message_id) * (-1);
            }
            return MessageUtils.this.compareTo(message.getSortingMessageId(), message2.getSortingMessageId());
        }
    };

    public enum FilterTypeEnum {
        Media,
        Voice,
        File,
        Music,
        All
    }

    interface GetMessagesListener {
        void onError(Exception exc);

        void onResponse(GetMessagesResultInner getMessagesResultInner);
    }

    public enum SortType {
        FromMin,
        FromMax
    }

    public int compareTo(long j, long j2) {
        if (j > j2) {
            return 1;
        }
        return j < j2 ? -1 : 0;
    }

    public MessageUtils(CoreLog coreLog) {
        new Comparator<Message>() { // from class: ir.aaap.messengercore.MessageUtils.58
            @Override // java.util.Comparator
            public int compare(Message message, Message message2) {
                long j = message.message_id;
                if (j == 0 && message2.message_id == 0) {
                    return 0;
                }
                if (j >= 0) {
                    long j2 = message2.message_id;
                    if (j2 >= 0) {
                        return MessageUtils.this.compareTo(j, j2);
                    }
                }
                if (j <= 0 && message2.message_id <= 0) {
                    return MessageUtils.this.compareTo(Math.abs(j), Math.abs(message2.message_id));
                }
                return MessageUtils.this.compareTo(j, message2.message_id) * (-1);
            }
        };
        this.coreLog = coreLog;
    }

    private GetMessagesInput createGetMessagesInput(String str, FilterTypeEnum filterTypeEnum, long j, long j2, boolean z, int i) {
        GetMessagesInput getMessagesInput = new GetMessagesInput();
        getMessagesInput.object_guid = str;
        getMessagesInput.limit = i;
        getMessagesInput.filter_type = filterTypeEnum;
        if (z) {
            getMessagesInput.sort = SortType.FromMin;
            getMessagesInput.min_id = Long.valueOf(j);
            getMessagesInput.max_id = j2 > 0 ? Long.valueOf(j2) : null;
        } else {
            getMessagesInput.sort = SortType.FromMax;
            getMessagesInput.min_id = j > 0 ? Long.valueOf(j) : null;
            getMessagesInput.max_id = Long.valueOf(j2);
        }
        return getMessagesInput;
    }

    private GetMessagesInput createGetMessagesIntervalInput(String str, FilterTypeEnum filterTypeEnum, long j) {
        GetMessagesInput getMessagesInput = new GetMessagesInput();
        getMessagesInput.object_guid = str;
        getMessagesInput.middle_message_id = Long.valueOf(j);
        getMessagesInput.filter_type = filterTypeEnum;
        return getMessagesInput;
    }

    private SendMessageInput createSendMessageInput(String str, Message message, boolean z) {
        SendMessageInput sendMessageInput = new SendMessageInput();
        sendMessageInput.object_guid = str;
        sendMessageInput.text = message.text;
        sendMessageInput.rnd = message.message_id;
        sendMessageInput.file_inline = message.file_inline;
        long j = message.reply_to_message_id;
        sendMessageInput.reply_to_message_id = j > 0 ? Long.valueOf(j) : null;
        sendMessageInput.is_mute = z;
        sendMessageInput.aux_data = message.aux_data;
        sendMessageInput.message_contact = message.contact_message;
        sendMessageInput.sticker = message.sticker;
        sendMessageInput.location = message.location;
        sendMessageInput.live_location = message.live_location;
        sendMessageInput.metadata = message.metadata;
        sendMessageInput.via_bot_guid = message.via_bot_guid;
        return sendMessageInput;
    }

    public void addToPollMap(PollObject pollObject) {
        synchronized (this.pollLock) {
            String str = pollObject.poll_id;
            if (str != null) {
                this.pollMap.put(str, pollObject);
            }
        }
    }

    public void getLiveLocationInfoArray(DBHelper dBHelper, KeyValueStorageHelper keyValueStorageHelper, LoadListener<ArrayList<LiveLocationInfo>> loadListener) {
        ArrayList<LiveLocationInfo> arrayList = new ArrayList<>();
        ArrayList<LiveLocationInfo> liveLocationInfoArray = keyValueStorageHelper.getLiveLocationInfoArray();
        if (liveLocationInfoArray != null && liveLocationInfoArray.size() > 0) {
            Iterator<LiveLocationInfo> it = liveLocationInfoArray.iterator();
            while (it.hasNext()) {
                LiveLocationInfo next = it.next();
                Message messageByIdFromMapOrDb = getMessageByIdFromMapOrDb(next.chatGuid, next.messageId, dBHelper);
                if (messageByIdFromMapOrDb != null) {
                    next.messageObject = messageByIdFromMapOrDb;
                    arrayList.add(next);
                }
            }
        }
        if (loadListener != null) {
            loadListener.onDidLoad(arrayList);
        }
    }

    public void addLiveLocationInfo(LiveLocationInfo liveLocationInfo, KeyValueStorageHelper keyValueStorageHelper) {
        if (liveLocationInfo == null) {
            return;
        }
        ArrayList<LiveLocationInfo> liveLocationInfoArray = keyValueStorageHelper.getLiveLocationInfoArray();
        if (liveLocationInfoArray == null) {
            liveLocationInfoArray = new ArrayList<>();
        }
        liveLocationInfoArray.add(liveLocationInfo);
        keyValueStorageHelper.setLiveLocationInfoArray(liveLocationInfoArray);
    }

    public void removeLocationInfo(LiveLocationInfo liveLocationInfo, KeyValueStorageHelper keyValueStorageHelper) {
        ArrayList<LiveLocationInfo> liveLocationInfoArray;
        if (liveLocationInfo == null || (liveLocationInfoArray = keyValueStorageHelper.getLiveLocationInfoArray()) == null) {
            return;
        }
        liveLocationInfoArray.remove(liveLocationInfo);
        keyValueStorageHelper.setLiveLocationInfoArray(liveLocationInfoArray);
    }

    public void removeAllLocationInfos(KeyValueStorageHelper keyValueStorageHelper) {
        ArrayList<LiveLocationInfo> liveLocationInfoArray = keyValueStorageHelper.getLiveLocationInfoArray();
        if (liveLocationInfoArray != null) {
            liveLocationInfoArray.clear();
            keyValueStorageHelper.setLiveLocationInfoArray(liveLocationInfoArray);
        }
    }

    public int getPollStatus(final String str, final ChatType chatType, final long j, String str2, String str3, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter) {
        final PollObject pollObject = this.pollMap.get(str2);
        if (pollObject == null) {
            return 0;
        }
        PollModels.GetPollStatusInput getPollStatusInput = new PollModels.GetPollStatusInput();
        getPollStatusInput.poll_id = pollObject.poll_id;
        try {
            return networkHelper.getPollStatus(str3, getPollStatusInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<PollModels.PollOutput>() { // from class: ir.aaap.messengercore.MessageUtils.1
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(PollModels.PollOutput pollOutput) {
                    MessageUtils.this.processPollStatusChanged(str, chatType, j, pollObject, pollOutput.poll_status, dBHelper, absNotificationCenter);
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int getPollOptionVoters(String str, String str2, String str3, String str4, NetworkHelper networkHelper, final LoadListener<PollModels.GetPollOptionVotersOutput> loadListener) {
        if (str == null || str2 == null) {
            return 0;
        }
        PollModels.GetPollOptionVotersInput getPollOptionVotersInput = new PollModels.GetPollOptionVotersInput();
        getPollOptionVotersInput.poll_id = str;
        getPollOptionVotersInput.selection_index = str2;
        if (!CoreUtilities.isNotEmpty(str3)) {
            str3 = null;
        }
        getPollOptionVotersInput.start_id = str3;
        try {
            return networkHelper.getPollOptionVoters(str4, getPollOptionVotersInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<PollModels.GetPollOptionVotersOutput>(this) { // from class: ir.aaap.messengercore.MessageUtils.2
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(PollModels.GetPollOptionVotersOutput getPollOptionVotersOutput) {
                    if (getPollOptionVotersOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(getPollOptionVotersOutput);
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

    public int votePoll(final String str, final ChatType chatType, final long j, String str2, Integer[] numArr, String str3, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<Integer> loadListener) {
        final PollObject pollObject = this.pollMap.get(str2);
        if (pollObject == null || this.votePollSet.contains(pollObject.poll_id)) {
            return 0;
        }
        this.votePollSet.add(pollObject.poll_id);
        PollModels.VotePollInput votePollInput = new PollModels.VotePollInput();
        votePollInput.poll_id = pollObject.poll_id;
        votePollInput.selection_index = TextUtils.join(",", numArr);
        try {
            return networkHelper.votePoll(str3, votePollInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<PollModels.PollOutput>() { // from class: ir.aaap.messengercore.MessageUtils.3
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(PollModels.PollOutput pollOutput) {
                    MessageUtils.this.votePollSet.remove(pollObject.poll_id);
                    MessageUtils.this.processPollStatusChanged(str, chatType, j, pollObject, pollOutput.poll_status, dBHelper, absNotificationCenter);
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    MessageUtils.this.votePollSet.remove(pollObject.poll_id);
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.votePollSet.remove(pollObject.poll_id);
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
            return 0;
        }
    }

    public int stopPoll(String str, ChatType chatType, long j, String str2, String str3, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, LoadListener<Integer> loadListener) {
        return setPollAction(str, chatType, j, str2, PollModels.ActionEnum.Stop, str3, networkHelper, dBHelper, absNotificationCenter, loadListener);
    }

    public int retractPoll(String str, ChatType chatType, long j, String str2, String str3, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, LoadListener<Integer> loadListener) {
        return setPollAction(str, chatType, j, str2, PollModels.ActionEnum.Retract, str3, networkHelper, dBHelper, absNotificationCenter, loadListener);
    }

    private int setPollAction(final String str, final ChatType chatType, final long j, String str2, PollModels.ActionEnum actionEnum, String str3, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<Integer> loadListener) {
        final PollObject pollObject = this.pollMap.get(str2);
        if (pollObject == null || this.actionOnPollSet.contains(pollObject.poll_id)) {
            return 0;
        }
        this.actionOnPollSet.add(pollObject.poll_id);
        PollModels.SetPollActionInput setPollActionInput = new PollModels.SetPollActionInput();
        setPollActionInput.poll_id = pollObject.poll_id;
        setPollActionInput.action = actionEnum;
        try {
            return networkHelper.setPollAction(str3, setPollActionInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<PollModels.PollOutput>() { // from class: ir.aaap.messengercore.MessageUtils.4
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(PollModels.PollOutput pollOutput) {
                    MessageUtils.this.actionOnPollSet.remove(pollObject.poll_id);
                    MessageUtils.this.processPollStatusChanged(str, chatType, j, pollObject, pollOutput.poll_status, dBHelper, absNotificationCenter);
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    MessageUtils.this.actionOnPollSet.remove(pollObject.poll_id);
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.actionOnPollSet.remove(pollObject.poll_id);
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processPollStatusChanged(String str, ChatType chatType, long j, PollObject pollObject, PollStatusObject pollStatusObject, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter) {
        pollObject.prev_poll_status = pollObject.poll_status;
        pollObject.poll_status = pollStatusObject;
        dBHelper.updateMessagePoll(str, j, pollObject);
        removeFromMessageMap(Long.valueOf(j));
        absNotificationCenter.didUpdatePollResults(str, chatType, j, pollObject);
    }

    public int setCurrentLiveLocation(double d, double d2, String str, NetworkHelper networkHelper, final LoadListener<Integer> loadListener) {
        SetCurrentLiveLocationInput setCurrentLiveLocationInput = new SetCurrentLiveLocationInput();
        LocationObject locationObject = new LocationObject();
        setCurrentLiveLocationInput.location = locationObject;
        locationObject.longitude = d2;
        locationObject.latitude = d;
        try {
            return networkHelper.setCurrentLiveLocation(str, setCurrentLiveLocationInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SetCurrentLiveLocationOutput>(this) { // from class: ir.aaap.messengercore.MessageUtils.5
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SetCurrentLiveLocationOutput setCurrentLiveLocationOutput) {
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

    public int stopLiveLocation(final String str, final long j, String str2, String str3, NetworkHelper networkHelper, final DBHelper dBHelper, final LoadListener<LiveLocationObject> loadListener) {
        LiveLocationInput liveLocationInput = new LiveLocationInput();
        liveLocationInput.live_loc_track_id = str2;
        try {
            return networkHelper.stopLiveLocation(str3, liveLocationInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<LiveLocationOutput>() { // from class: ir.aaap.messengercore.MessageUtils.6
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(LiveLocationOutput liveLocationOutput) {
                    MessageUtils.this.processLiveLocationChanged(str, j, liveLocationOutput.live_location, dBHelper);
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(liveLocationOutput.live_location);
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
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processLiveLocationChanged(String str, long j, LiveLocationObject liveLocationObject, DBHelper dBHelper) {
        dBHelper.updateLiveLocation(str, j, liveLocationObject);
    }

    public void saveMessageSendingState(Message message, DBHelper dBHelper) {
        dBHelper.updateMessageSendState(message);
    }

    public void saveMessageOnLocallyEditChange(Message message, boolean z, DBHelper dBHelper, boolean z2) {
        message.isLocallyEdited = z;
        if (!z && !z2) {
            Message.LocalParametersObject localParametersObject = message.localParametersObject;
            message.text = localParametersObject != null ? localParametersObject.prevText : null;
            message.metadata = localParametersObject != null ? localParametersObject.prevMetadata : null;
        }
        dBHelper.updateMessageOnLocallyEditedChanged(message, z, z2);
    }

    public int forwardMessages(String str, String str2, String str3, boolean z, int i, ArrayList<Long> arrayList, NetworkHelper networkHelper, final LoadListener<SendMessageOutput> loadListener) {
        ForwardMessageInput forwardMessageInput = new ForwardMessageInput();
        forwardMessageInput.from_object_guid = str2;
        forwardMessageInput.to_object_guid = str3;
        forwardMessageInput.message_ids = arrayList;
        forwardMessageInput.is_mute = z;
        forwardMessageInput.rnd = i;
        try {
            return networkHelper.forwardMessages(str, forwardMessageInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SendMessageOutput>(this) { // from class: ir.aaap.messengercore.MessageUtils.7
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SendMessageOutput sendMessageOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(sendMessageOutput);
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
            this.coreLog.handleException(e);
            if (loadListener == null) {
                return 0;
            }
            loadListener.onError(e);
            return 0;
        }
    }

    public int sendMessage(String str, String str2, ChatType chatType, Message message, boolean z, NetworkHelper networkHelper, RubinoUtils rubinoUtils, LoadListener<SendMessageOutput> loadListener) {
        if (message == null) {
            if (loadListener == null) {
                return 0;
            }
            loadListener.onError(new InputException());
            return 0;
        }
        Message.MessageTypeEnum messageTypeEnum = message.type;
        if ((messageTypeEnum == Message.MessageTypeEnum.Poll2 || messageTypeEnum == Message.MessageTypeEnum.Poll) && message.poll != null) {
            return createPoll(str2, chatType, message, z, str, networkHelper, loadListener);
        }
        if (messageTypeEnum == Message.MessageTypeEnum.RubinoPost && message.rubino_post_data != null) {
            return sendRubinoPost(str2, chatType, message, z, str, networkHelper, rubinoUtils, loadListener);
        }
        if (messageTypeEnum == Message.MessageTypeEnum.RubinoStory && message.rubino_story_data != null) {
            return sendRubinoStory(str2, chatType, message, z, str, networkHelper, rubinoUtils, loadListener);
        }
        if (messageTypeEnum == Message.MessageTypeEnum.ProductMessage && message.product_message_data != null) {
            return sendRubinoProduct(str2, chatType, message, z, str, networkHelper, rubinoUtils, loadListener);
        }
        if (messageTypeEnum == Message.MessageTypeEnum.WalletTransfer && message.wallet_transfer_data != null) {
            return sendWalletMessage(str2, chatType, message, z, str, networkHelper, rubinoUtils, loadListener);
        }
        return sendMessageInner(str, str2, chatType, message, z, networkHelper, loadListener);
    }

    private int sendRubinoPost(String str, ChatType chatType, Message message, boolean z, String str2, NetworkHelper networkHelper, RubinoUtils rubinoUtils, final LoadListener<SendMessageOutput> loadListener) {
        SendRubinoPostInput sendRubinoPostInput = rubinoUtils.getSendRubinoPostInput(message.message_id, str, chatType, z, message.rubino_post_data);
        if (sendRubinoPostInput == null) {
            if (loadListener != null) {
                loadListener.onError(new InputException());
            }
            return 0;
        }
        try {
            return networkHelper.sendRubinoPost(str2, sendRubinoPostInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SendMessageOutput>(this) { // from class: ir.aaap.messengercore.MessageUtils.8
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SendMessageOutput sendMessageOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(sendMessageOutput);
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
            this.coreLog.handleException(e);
            return 0;
        }
    }

    private int sendRubinoStory(String str, ChatType chatType, Message message, boolean z, String str2, NetworkHelper networkHelper, RubinoUtils rubinoUtils, final LoadListener<SendMessageOutput> loadListener) {
        SendRubinoStoryInput sendRubinoStoryInput = rubinoUtils.getSendRubinoStoryInput(message.message_id, str, chatType, z, message.rubino_story_data);
        if (sendRubinoStoryInput == null) {
            if (loadListener != null) {
                loadListener.onError(new InputException());
            }
            return 0;
        }
        try {
            return networkHelper.sendRubinoStory(str2, sendRubinoStoryInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SendMessageOutput>(this) { // from class: ir.aaap.messengercore.MessageUtils.9
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SendMessageOutput sendMessageOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(sendMessageOutput);
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
            this.coreLog.handleException(e);
            return 0;
        }
    }

    private int sendRubinoProduct(String str, ChatType chatType, Message message, boolean z, String str2, NetworkHelper networkHelper, RubinoUtils rubinoUtils, final LoadListener<SendMessageOutput> loadListener) {
        SendProductMessageInput sendRubinoProductInput = rubinoUtils.getSendRubinoProductInput(message.message_id, str, message.product_message_data);
        if (sendRubinoProductInput == null) {
            if (loadListener != null) {
                loadListener.onError(new InputException());
            }
            return 0;
        }
        try {
            return networkHelper.sendProductMessage(str2, sendRubinoProductInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SendMessageOutput>(this) { // from class: ir.aaap.messengercore.MessageUtils.10
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SendMessageOutput sendMessageOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(sendMessageOutput);
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
            this.coreLog.handleException(e);
            return 0;
        }
    }

    private int sendWalletMessage(String str, ChatType chatType, Message message, boolean z, String str2, NetworkHelper networkHelper, RubinoUtils rubinoUtils, final LoadListener<SendMessageOutput> loadListener) {
        WalletTransferDataObject walletTransferDataObject = message.wallet_transfer_data;
        if (walletTransferDataObject.transfer_id == null || walletTransferDataObject.access_transfer == null) {
            if (loadListener != null) {
                loadListener.onError(new InputException());
            }
            return 0;
        }
        SendWalletTransactionMessageInput sendWalletTransactionMessageInput = new SendWalletTransactionMessageInput();
        sendWalletTransactionMessageInput.object_guid = str;
        sendWalletTransactionMessageInput.rnd = message.message_id;
        WalletTransferDataObject walletTransferDataObject2 = message.wallet_transfer_data;
        sendWalletTransactionMessageInput.access_transfer = walletTransferDataObject2.access_transfer;
        sendWalletTransactionMessageInput.transfer_id = walletTransferDataObject2.transfer_id;
        try {
            return networkHelper.sendWalletTransferMessage(str2, sendWalletTransactionMessageInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SendMessageOutput>(this) { // from class: ir.aaap.messengercore.MessageUtils.11
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SendMessageOutput sendMessageOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(sendMessageOutput);
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
            this.coreLog.handleException(e);
            return 0;
        }
    }

    private int sendMessageInner(String str, String str2, ChatType chatType, Message message, boolean z, NetworkHelper networkHelper, final LoadListener<SendMessageOutput> loadListener) {
        try {
            return networkHelper.sendMessage(str, createSendMessageInput(str2, message, z), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SendMessageOutput>(this) { // from class: ir.aaap.messengercore.MessageUtils.12
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SendMessageOutput sendMessageOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(sendMessageOutput);
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
            e.printStackTrace();
            return 0;
        }
    }

    private int createPoll(String str, ChatType chatType, Message message, boolean z, String str2, NetworkHelper networkHelper, final LoadListener<SendMessageOutput> loadListener) {
        PollModels.CreatePollInput createPollInput = new PollModels.CreatePollInput();
        createPollInput.object_guid = str;
        PollObject pollObject = message.poll;
        createPollInput.question = pollObject.question;
        createPollInput.options = pollObject.options;
        createPollInput.is_anonymous = pollObject.is_anonymous;
        createPollInput.type = pollObject.type;
        createPollInput.allows_multiple_answers = pollObject.allows_multiple_answers;
        createPollInput.correct_option_index = pollObject.correctOptionIndexLocal;
        createPollInput.explanation = pollObject.explanationTemp;
        createPollInput.rnd = message.message_id;
        createPollInput.reply_to_message_id = Long.valueOf(message.reply_to_message_id);
        if (chatType == ChatType.Channel) {
            createPollInput.is_mute = z;
        }
        try {
            return networkHelper.createPoll(str2, createPollInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SendMessageOutput>(this) { // from class: ir.aaap.messengercore.MessageUtils.13
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SendMessageOutput sendMessageOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(sendMessageOutput);
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
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public int callEditMessage(String str, final Message message, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final LoadListener<Integer> loadListener) {
        EditMessageInput editMessageInput = new EditMessageInput();
        editMessageInput.object_guid = str;
        editMessageInput.message_id = message.message_id;
        editMessageInput.metadata = message.metadata;
        String str3 = message.text;
        editMessageInput.text = str3;
        if (str3 != null && str3.isEmpty()) {
            editMessageInput.text = null;
        }
        try {
            return networkHelper.editMessage(str2, editMessageInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<EditMessagesOutput>() { // from class: ir.aaap.messengercore.MessageUtils.14
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(EditMessagesOutput editMessagesOutput) {
                    Message message2 = message;
                    message2.sendState = 0;
                    MessageUtils.this.saveMessageSendingState(message2, dBHelper);
                    UpdateChatAndMessageUsecase updateChatAndMessageUsecase2 = updateChatAndMessageUsecase;
                    if (updateChatAndMessageUsecase2 != null) {
                        updateChatAndMessageUsecase2.processMessageAndChatUpdate(editMessagesOutput.message_update, editMessagesOutput.chat_update, false, true);
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
            this.coreLog.handleException(e);
            return 0;
        }
    }

    public void addMessageToDb(String str, Message message, DBHelper dBHelper) {
        dBHelper.addMessage(str, message);
    }

    public void removeLocalMessage(String str, long j, DBHelper dBHelper) {
        dBHelper.removeLocalMessageByRnd(str, j);
    }

    public GetMessagesResultInner getMessagesFromDB(DBHelper dBHelper, String str, FilterTypeEnum filterTypeEnum, boolean z, long j, long j2, long j3, long j4, int i) {
        return dBHelper.getMessagesToBottomOrTop(str, filterTypeEnum, z, z ? j : j2, j3, j4, i);
    }

    public GetMessagesResultInner getMessagesIntervalFromDB(DBHelper dBHelper, String str, FilterTypeEnum filterTypeEnum, long j, long j2, long j3, int i, int i2) {
        return dBHelper.getMessagesInterval(str, filterTypeEnum, j, j2, j3, i, i2);
    }

    public ArrayList<Message> getAllUnsentMessages(DBHelper dBHelper, Set<Integer> set) {
        return dBHelper.getAllLocalMessages(set);
    }

    public void loadMessagesWithCheckLocal(final boolean z, String str, NetworkHelper networkHelper, final DBHelper dBHelper, KeyValueStorageHelper keyValueStorageHelper, final String str2, ChatType chatType, final FilterTypeEnum filterTypeEnum, final boolean z2, long j, long j2, final long j3, final long j4, long j5, long j6, int i, Object obj, final LoadMessagesListener loadMessagesListener) {
        loadMessages(str, networkHelper, dBHelper, keyValueStorageHelper, str2, chatType, filterTypeEnum, z2, j, j2, j5, j6, i, obj, new LoadMessagesListener() { // from class: ir.aaap.messengercore.MessageUtils.15
            @Override // ir.aaap.messengercore.LoadMessagesListener
            public void onMessagesDidLoad(LoadMessagesResult loadMessagesResult) {
                loadMessagesResult.minDate = j3;
                loadMessagesResult.maxDate = j4;
                if (z) {
                    MessageUtils.this.checkAndAddLocalMessages(loadMessagesResult, str2, filterTypeEnum, z2, dBHelper);
                }
                LoadMessagesListener loadMessagesListener2 = loadMessagesListener;
                if (loadMessagesListener2 != null) {
                    loadMessagesListener2.onMessagesDidLoad(loadMessagesResult);
                }
            }

            @Override // ir.aaap.messengercore.LoadMessagesListener
            public void onLoadingMessagesFailed(LoadMessagesResult loadMessagesResult) {
                LoadMessagesListener loadMessagesListener2 = loadMessagesListener;
                if (loadMessagesListener2 != null) {
                    loadMessagesListener2.onLoadingMessagesFailed(loadMessagesResult);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadMessages(String str, NetworkHelper networkHelper, DBHelper dBHelper, KeyValueStorageHelper keyValueStorageHelper, final String str2, ChatType chatType, FilterTypeEnum filterTypeEnum, boolean z, long j, long j2, long j3, long j4, int i, Object obj, final LoadMessagesListener loadMessagesListener) {
        new LoadMessagesHelper(str, networkHelper, dBHelper, keyValueStorageHelper, str2, chatType, filterTypeEnum, z, j3, j4, i, obj, new LoadMessagesListener() { // from class: ir.aaap.messengercore.MessageUtils.16
            @Override // ir.aaap.messengercore.LoadMessagesListener
            public void onMessagesDidLoad(LoadMessagesResult loadMessagesResult) {
                MessageUtils.this.checkGroupedImages(loadMessagesResult.messages);
                Iterator<Message> it = loadMessagesResult.messages.iterator();
                while (it.hasNext()) {
                    Message next = it.next();
                    PollObject pollObject = next.poll;
                    if (pollObject != null) {
                        MessageUtils.this.addToPollMap(pollObject);
                    } else if (next.live_location != null) {
                        MessageUtils.this.addToLiveLocationMap(str2, next);
                    }
                }
                LoadMessagesListener loadMessagesListener2 = loadMessagesListener;
                if (loadMessagesListener2 != null) {
                    loadMessagesListener2.onMessagesDidLoad(loadMessagesResult);
                }
            }

            @Override // ir.aaap.messengercore.LoadMessagesListener
            public void onLoadingMessagesFailed(LoadMessagesResult loadMessagesResult) {
                LoadMessagesListener loadMessagesListener2 = loadMessagesListener;
                if (loadMessagesListener2 != null) {
                    loadMessagesListener2.onLoadingMessagesFailed(loadMessagesResult);
                }
            }
        }).loadMessages(j, j2);
    }

    public void loadMessagesIntervalWithCheckLocal(final boolean z, String str, NetworkHelper networkHelper, final DBHelper dBHelper, KeyValueStorageHelper keyValueStorageHelper, final String str2, ChatType chatType, final FilterTypeEnum filterTypeEnum, long j, long j2, long j3, int i, int i2, Object obj, final LoadMessagesIntervalListener loadMessagesIntervalListener) {
        loadMessagesInterval(str, networkHelper, dBHelper, keyValueStorageHelper, str2, chatType, filterTypeEnum, j, j2, j3, i, i2, obj, new LoadMessagesIntervalListener() { // from class: ir.aaap.messengercore.MessageUtils.17
            @Override // ir.aaap.messengercore.LoadMessagesIntervalListener
            public void onMessagesDidLoadInterval(LoadMessagesIntervalResult loadMessagesIntervalResult) {
                if (z) {
                    MessageUtils.this.checkAndAddLocalMessages(loadMessagesIntervalResult, str2, filterTypeEnum, dBHelper);
                }
                LoadMessagesIntervalListener loadMessagesIntervalListener2 = loadMessagesIntervalListener;
                if (loadMessagesIntervalListener2 != null) {
                    loadMessagesIntervalListener2.onMessagesDidLoadInterval(loadMessagesIntervalResult);
                }
            }

            @Override // ir.aaap.messengercore.LoadMessagesIntervalListener
            public void onLoadingMessagesFailedInterval(LoadMessagesIntervalResult loadMessagesIntervalResult) {
                LoadMessagesIntervalListener loadMessagesIntervalListener2 = loadMessagesIntervalListener;
                if (loadMessagesIntervalListener2 != null) {
                    loadMessagesIntervalListener2.onLoadingMessagesFailedInterval(loadMessagesIntervalResult);
                }
            }
        });
    }

    /* renamed from: ir.aaap.messengercore.MessageUtils$18, reason: invalid class name */
    class AnonymousClass18 implements LoadMessagesIntervalListener {
        final /* synthetic */ String val$auth;
        final /* synthetic */ ChatType val$chatType;
        final /* synthetic */ String val$chat_guid;
        final /* synthetic */ DBHelper val$dbHelper;
        final /* synthetic */ Object val$extraInfo;
        final /* synthetic */ FilterTypeEnum val$filterType;
        final /* synthetic */ KeyValueStorageHelper val$keyValueStorageHelper;
        final /* synthetic */ long val$lastDeletedMid;
        final /* synthetic */ long val$lastMessageId;
        final /* synthetic */ LoadMessagesIntervalListener val$loadMessagesListener;
        final /* synthetic */ NetworkHelper val$networkHelper;
        final /* synthetic */ int val$newerLimit;

        AnonymousClass18(LoadMessagesIntervalListener loadMessagesIntervalListener, String str, NetworkHelper networkHelper, DBHelper dBHelper, KeyValueStorageHelper keyValueStorageHelper, String str2, ChatType chatType, FilterTypeEnum filterTypeEnum, long j, long j2, int i, Object obj) {
            this.val$loadMessagesListener = loadMessagesIntervalListener;
            this.val$auth = str;
            this.val$networkHelper = networkHelper;
            this.val$dbHelper = dBHelper;
            this.val$keyValueStorageHelper = keyValueStorageHelper;
            this.val$chat_guid = str2;
            this.val$chatType = chatType;
            this.val$filterType = filterTypeEnum;
            this.val$lastMessageId = j;
            this.val$lastDeletedMid = j2;
            this.val$newerLimit = i;
            this.val$extraInfo = obj;
        }

        @Override // ir.aaap.messengercore.LoadMessagesIntervalListener
        public void onMessagesDidLoadInterval(final LoadMessagesIntervalResult loadMessagesIntervalResult) {
            LoadMessagesIntervalListener loadMessagesIntervalListener;
            ArrayList<Message> arrayList = loadMessagesIntervalResult.messages;
            if (arrayList == null || arrayList.size() == 0) {
                if (!loadMessagesIntervalResult.new_has_continue && !loadMessagesIntervalResult.old_has_continue && (loadMessagesIntervalListener = this.val$loadMessagesListener) != null) {
                    loadMessagesIntervalListener.onMessagesDidLoadInterval(loadMessagesIntervalResult);
                }
                if (loadMessagesIntervalResult.new_has_continue) {
                    MessageUtils.this.loadMessages(this.val$auth, this.val$networkHelper, this.val$dbHelper, this.val$keyValueStorageHelper, this.val$chat_guid, this.val$chatType, this.val$filterType, true, loadMessagesIntervalResult.new_min_id, 0L, this.val$lastMessageId, this.val$lastDeletedMid, this.val$newerLimit, this.val$extraInfo, new LoadMessagesListener() { // from class: ir.aaap.messengercore.MessageUtils.18.1
                        @Override // ir.aaap.messengercore.LoadMessagesListener
                        public void onMessagesDidLoad(LoadMessagesResult loadMessagesResult) {
                            if (loadMessagesResult != null) {
                                LoadMessagesIntervalResult loadMessagesIntervalResult2 = loadMessagesIntervalResult;
                                loadMessagesIntervalResult2.new_min_id = loadMessagesResult.newMinId;
                                loadMessagesIntervalResult2.new_has_continue = loadMessagesResult.hasContinue;
                                ArrayList<Message> arrayList2 = loadMessagesResult.messages;
                                loadMessagesIntervalResult2.messages = arrayList2;
                                if (arrayList2 != null && arrayList2.size() > 0) {
                                    LoadMessagesIntervalListener loadMessagesIntervalListener2 = AnonymousClass18.this.val$loadMessagesListener;
                                    if (loadMessagesIntervalListener2 != null) {
                                        loadMessagesIntervalListener2.onMessagesDidLoadInterval(loadMessagesIntervalResult);
                                        return;
                                    }
                                    return;
                                }
                                AnonymousClass18 anonymousClass18 = AnonymousClass18.this;
                                MessageUtils.this.loadMessages(anonymousClass18.val$auth, anonymousClass18.val$networkHelper, anonymousClass18.val$dbHelper, anonymousClass18.val$keyValueStorageHelper, anonymousClass18.val$chat_guid, anonymousClass18.val$chatType, anonymousClass18.val$filterType, false, 0L, loadMessagesIntervalResult.old_max_id, anonymousClass18.val$lastMessageId, anonymousClass18.val$lastDeletedMid, anonymousClass18.val$newerLimit, anonymousClass18.val$extraInfo, new LoadMessagesListener() { // from class: ir.aaap.messengercore.MessageUtils.18.1.1
                                    @Override // ir.aaap.messengercore.LoadMessagesListener
                                    public void onMessagesDidLoad(LoadMessagesResult loadMessagesResult2) {
                                        if (loadMessagesResult2 != null) {
                                            LoadMessagesIntervalResult loadMessagesIntervalResult3 = loadMessagesIntervalResult;
                                            loadMessagesIntervalResult3.old_max_id = loadMessagesResult2.newMaxId;
                                            loadMessagesIntervalResult3.old_has_continue = loadMessagesResult2.hasContinue;
                                            ArrayList<Message> arrayList3 = loadMessagesResult2.messages;
                                            if (arrayList3 != null) {
                                                if (arrayList3.size() > 0) {
                                                    Collections.reverse(loadMessagesResult2.messages);
                                                    loadMessagesIntervalResult.messages = loadMessagesResult2.messages;
                                                }
                                            } else {
                                                loadMessagesIntervalResult3.messages = new ArrayList<>();
                                            }
                                        }
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        LoadMessagesIntervalListener loadMessagesIntervalListener3 = AnonymousClass18.this.val$loadMessagesListener;
                                        if (loadMessagesIntervalListener3 != null) {
                                            loadMessagesIntervalListener3.onMessagesDidLoadInterval(loadMessagesIntervalResult);
                                        }
                                    }

                                    @Override // ir.aaap.messengercore.LoadMessagesListener
                                    public void onLoadingMessagesFailed(LoadMessagesResult loadMessagesResult2) {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        LoadMessagesIntervalListener loadMessagesIntervalListener3 = AnonymousClass18.this.val$loadMessagesListener;
                                        if (loadMessagesIntervalListener3 != null) {
                                            loadMessagesIntervalListener3.onLoadingMessagesFailedInterval(loadMessagesIntervalResult);
                                        }
                                    }
                                });
                            }
                        }

                        @Override // ir.aaap.messengercore.LoadMessagesListener
                        public void onLoadingMessagesFailed(LoadMessagesResult loadMessagesResult) {
                            LoadMessagesIntervalListener loadMessagesIntervalListener2 = AnonymousClass18.this.val$loadMessagesListener;
                            if (loadMessagesIntervalListener2 != null) {
                                loadMessagesIntervalListener2.onLoadingMessagesFailedInterval(loadMessagesIntervalResult);
                            }
                        }
                    });
                    return;
                } else {
                    if (loadMessagesIntervalResult.old_has_continue) {
                        MessageUtils.this.loadMessages(this.val$auth, this.val$networkHelper, this.val$dbHelper, this.val$keyValueStorageHelper, this.val$chat_guid, this.val$chatType, this.val$filterType, false, 0L, loadMessagesIntervalResult.old_max_id, this.val$lastMessageId, this.val$lastDeletedMid, this.val$newerLimit, this.val$extraInfo, new LoadMessagesListener() { // from class: ir.aaap.messengercore.MessageUtils.18.2
                            @Override // ir.aaap.messengercore.LoadMessagesListener
                            public void onMessagesDidLoad(LoadMessagesResult loadMessagesResult) {
                                if (loadMessagesResult != null) {
                                    LoadMessagesIntervalResult loadMessagesIntervalResult2 = loadMessagesIntervalResult;
                                    loadMessagesIntervalResult2.old_max_id = loadMessagesResult.newMaxId;
                                    loadMessagesIntervalResult2.old_has_continue = loadMessagesResult.hasContinue;
                                    ArrayList<Message> arrayList2 = loadMessagesResult.messages;
                                    if (arrayList2 != null) {
                                        if (arrayList2.size() > 0) {
                                            Collections.reverse(loadMessagesResult.messages);
                                            loadMessagesIntervalResult.messages = loadMessagesResult.messages;
                                        }
                                    } else {
                                        loadMessagesIntervalResult2.messages = new ArrayList<>();
                                    }
                                }
                                LoadMessagesIntervalListener loadMessagesIntervalListener2 = AnonymousClass18.this.val$loadMessagesListener;
                                if (loadMessagesIntervalListener2 != null) {
                                    loadMessagesIntervalListener2.onMessagesDidLoadInterval(loadMessagesIntervalResult);
                                }
                            }

                            @Override // ir.aaap.messengercore.LoadMessagesListener
                            public void onLoadingMessagesFailed(LoadMessagesResult loadMessagesResult) {
                                LoadMessagesIntervalListener loadMessagesIntervalListener2 = AnonymousClass18.this.val$loadMessagesListener;
                                if (loadMessagesIntervalListener2 != null) {
                                    loadMessagesIntervalListener2.onLoadingMessagesFailedInterval(loadMessagesIntervalResult);
                                }
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            Iterator<Message> it = loadMessagesIntervalResult.messages.iterator();
            while (it.hasNext()) {
                Message next = it.next();
                PollObject pollObject = next.poll;
                if (pollObject != null) {
                    MessageUtils.this.addToPollMap(pollObject);
                } else if (next.live_location != null) {
                    MessageUtils.this.addToLiveLocationMap(this.val$chat_guid, next);
                }
            }
            MessageUtils.this.checkGroupedImages(loadMessagesIntervalResult.messages);
            LoadMessagesIntervalListener loadMessagesIntervalListener2 = this.val$loadMessagesListener;
            if (loadMessagesIntervalListener2 != null) {
                loadMessagesIntervalListener2.onMessagesDidLoadInterval(loadMessagesIntervalResult);
            }
        }

        @Override // ir.aaap.messengercore.LoadMessagesIntervalListener
        public void onLoadingMessagesFailedInterval(LoadMessagesIntervalResult loadMessagesIntervalResult) {
            LoadMessagesIntervalListener loadMessagesIntervalListener = this.val$loadMessagesListener;
            if (loadMessagesIntervalListener != null) {
                loadMessagesIntervalListener.onLoadingMessagesFailedInterval(loadMessagesIntervalResult);
            }
        }
    }

    private void loadMessagesInterval(String str, NetworkHelper networkHelper, DBHelper dBHelper, KeyValueStorageHelper keyValueStorageHelper, String str2, ChatType chatType, FilterTypeEnum filterTypeEnum, long j, long j2, long j3, int i, int i2, Object obj, LoadMessagesIntervalListener loadMessagesIntervalListener) {
        loadMessagesIntervalInner(str, networkHelper, dBHelper, keyValueStorageHelper, str2, chatType, filterTypeEnum, j, j2, j3, i, i2, obj, new AnonymousClass18(loadMessagesIntervalListener, str, networkHelper, dBHelper, keyValueStorageHelper, str2, chatType, filterTypeEnum, j2, j3, i2, obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToLiveLocationMap(String str, Message message) {
        synchronized (this.liveLocationLock) {
            if (message.live_location.live_loc_track_id != null) {
                this.liveLocationsMessageMap.put(str, message);
            }
        }
    }

    private void loadMessagesIntervalInner(String str, NetworkHelper networkHelper, DBHelper dBHelper, KeyValueStorageHelper keyValueStorageHelper, String str2, ChatType chatType, FilterTypeEnum filterTypeEnum, long j, long j2, long j3, int i, int i2, Object obj, final LoadMessagesIntervalListener loadMessagesIntervalListener) {
        final LoadMessagesIntervalResult loadMessagesIntervalResult = new LoadMessagesIntervalResult();
        loadMessagesIntervalResult.chatId = str2;
        loadMessagesIntervalResult.chatType = chatType;
        loadMessagesIntervalResult.filterType = filterTypeEnum;
        loadMessagesIntervalResult.middleId = j;
        loadMessagesIntervalResult.extraInfo = obj;
        GetMessagesResultInner messagesIntervalFromDB = getMessagesIntervalFromDB(dBHelper, str2, filterTypeEnum, j, j2, j3, i, i2);
        if (messagesIntervalFromDB != null && messagesIntervalFromDB.isExistInDB) {
            loadMessagesIntervalResult.isFromDb = true;
            ArrayList<Message> arrayList = messagesIntervalFromDB.messages;
            loadMessagesIntervalResult.messages = arrayList;
            loadMessagesIntervalResult.old_max_id = messagesIntervalFromDB.newMaxId;
            loadMessagesIntervalResult.new_min_id = messagesIntervalFromDB.newMinId;
            loadMessagesIntervalResult.old_has_continue = messagesIntervalFromDB.olderHasContinue;
            loadMessagesIntervalResult.new_has_continue = messagesIntervalFromDB.newerHasContinue;
            Collections.sort(arrayList, this.messageComparatorToBottom);
            loadMessagesIntervalListener.onMessagesDidLoadInterval(loadMessagesIntervalResult);
            return;
        }
        loadMessagesIntervalResult.isFromDb = false;
        getMessagesIntervalFromServer(str, networkHelper, dBHelper, keyValueStorageHelper, str2, filterTypeEnum, j, new GetMessagesListener(this) { // from class: ir.aaap.messengercore.MessageUtils.19
            @Override // ir.aaap.messengercore.MessageUtils.GetMessagesListener
            public void onResponse(GetMessagesResultInner getMessagesResultInner) {
                if (getMessagesResultInner != null) {
                    LoadMessagesIntervalResult loadMessagesIntervalResult2 = loadMessagesIntervalResult;
                    loadMessagesIntervalResult2.messages = getMessagesResultInner.messages;
                    loadMessagesIntervalResult2.new_min_id = getMessagesResultInner.newMinId;
                    loadMessagesIntervalResult2.old_max_id = getMessagesResultInner.newMaxId;
                    loadMessagesIntervalResult2.new_has_continue = getMessagesResultInner.newerHasContinue;
                    loadMessagesIntervalResult2.old_has_continue = getMessagesResultInner.olderHasContinue;
                }
                loadMessagesIntervalListener.onMessagesDidLoadInterval(loadMessagesIntervalResult);
            }

            @Override // ir.aaap.messengercore.MessageUtils.GetMessagesListener
            public void onError(Exception exc) {
                loadMessagesIntervalListener.onLoadingMessagesFailedInterval(loadMessagesIntervalResult);
            }
        }, j2);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ir.aaap.messengercore.model.LoadMessagesResult checkAndAddLocalMessages(ir.aaap.messengercore.model.LoadMessagesResult r20, java.lang.String r21, ir.aaap.messengercore.MessageUtils.FilterTypeEnum r22, boolean r23, ir.aaap.messengercore.db.DBHelper r24) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = 9223372036854775806(0x7ffffffffffffffe, double:NaN)
            if (r23 == 0) goto Lf
            long r4 = r1.minDate
            r6 = r2
            goto L18
        Lf:
            long r4 = r1.maxDate
            r6 = 0
            r17 = r4
            r4 = r6
            r6 = r17
        L18:
            java.util.ArrayList<ir.aaap.messengercore.model.Message> r8 = r1.messages
            r11 = 1
            if (r8 == 0) goto L3f
            int r8 = r8.size()
            if (r8 != 0) goto L25
            goto L3f
        L25:
            if (r23 == 0) goto L32
            boolean r6 = r1.hasContinue
            if (r6 == 0) goto L46
            java.util.ArrayList<ir.aaap.messengercore.model.Message> r2 = r1.messages
            long r2 = r0.findMaxDate(r2)
            goto L46
        L32:
            boolean r2 = r1.hasContinue
            if (r2 == 0) goto L49
            java.util.ArrayList<ir.aaap.messengercore.model.Message> r2 = r1.messages
            long r4 = r0.findMinDate(r2)
            r15 = r4
            r13 = r6
            goto L4b
        L3f:
            boolean r8 = r1.hasContinue
            if (r8 == 0) goto L44
            return r1
        L44:
            if (r23 == 0) goto L49
        L46:
            r13 = r2
            r15 = r4
            goto L4b
        L49:
            r13 = r6
            r15 = r11
        L4b:
            r10 = 0
            r2 = r24
            r3 = r21
            r4 = r22
            r5 = r15
            r7 = r13
            r9 = r23
            ir.aaap.messengercore.db.GetMessagesResultInner r2 = r2.getLocalMessages(r3, r4, r5, r7, r9, r10)
            boolean r3 = r2.hasJustLocal
            if (r3 == 0) goto La8
            java.util.ArrayList<ir.aaap.messengercore.model.Message> r3 = r1.messages
            if (r3 != 0) goto L69
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r1.messages = r3
        L69:
            java.util.ArrayList<ir.aaap.messengercore.model.Message> r3 = r1.messages
            java.util.ArrayList<ir.aaap.messengercore.model.Message> r2 = r2.justLocalMessages
            r3.addAll(r2)
            if (r23 == 0) goto L8d
            java.util.ArrayList<ir.aaap.messengercore.model.Message> r2 = r1.messages
            java.util.Comparator<ir.aaap.messengercore.model.Message> r3 = r0.messageComparatorToBottom
            java.util.Collections.sort(r2, r3)
            java.util.ArrayList<ir.aaap.messengercore.model.Message> r2 = r1.messages
            int r3 = r2.size()
            int r3 = r3 + (-1)
            java.lang.Object r2 = r2.get(r3)
            ir.aaap.messengercore.model.Message r2 = (ir.aaap.messengercore.model.Message) r2
            long r2 = r2.timeMillis
            long r2 = r2 + r11
            r1.newMinDate = r2
            goto Lb2
        L8d:
            java.util.ArrayList<ir.aaap.messengercore.model.Message> r2 = r1.messages
            java.util.Comparator<ir.aaap.messengercore.model.Message> r3 = r0.messageComparatorToTop
            java.util.Collections.sort(r2, r3)
            java.util.ArrayList<ir.aaap.messengercore.model.Message> r2 = r1.messages
            int r3 = r2.size()
            int r3 = r3 + (-1)
            java.lang.Object r2 = r2.get(r3)
            ir.aaap.messengercore.model.Message r2 = (ir.aaap.messengercore.model.Message) r2
            long r2 = r2.timeMillis
            long r2 = r2 - r11
            r1.newMaxDate = r2
            goto Lb2
        La8:
            if (r23 == 0) goto Lae
            long r13 = r13 + r11
            r1.newMinDate = r13
            goto Lb2
        Lae:
            long r2 = r15 - r11
            r1.newMaxDate = r2
        Lb2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.aaap.messengercore.MessageUtils.checkAndAddLocalMessages(ir.aaap.messengercore.model.LoadMessagesResult, java.lang.String, ir.aaap.messengercore.MessageUtils$FilterTypeEnum, boolean, ir.aaap.messengercore.db.DBHelper):ir.aaap.messengercore.model.LoadMessagesResult");
    }

    public LoadMessagesIntervalResult checkAndAddLocalMessages(LoadMessagesIntervalResult loadMessagesIntervalResult, String str, FilterTypeEnum filterTypeEnum, DBHelper dBHelper) {
        long jFindMaxDate;
        long jFindMinDate;
        ArrayList<Message> arrayList = loadMessagesIntervalResult.messages;
        if ((arrayList == null || arrayList.size() == 0) && loadMessagesIntervalResult.new_has_continue && loadMessagesIntervalResult.old_has_continue) {
            return loadMessagesIntervalResult;
        }
        ArrayList<Message> arrayList2 = loadMessagesIntervalResult.messages;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            jFindMaxDate = 9223372036854775806L;
            jFindMinDate = 1;
        } else {
            jFindMinDate = findMinDate(loadMessagesIntervalResult.messages);
            jFindMaxDate = findMaxDate(loadMessagesIntervalResult.messages);
        }
        long j = loadMessagesIntervalResult.new_has_continue ? jFindMaxDate : 9223372036854775806L;
        if (!loadMessagesIntervalResult.old_has_continue) {
            jFindMinDate = 1;
        }
        GetMessagesResultInner localMessages = dBHelper.getLocalMessages(str, filterTypeEnum, jFindMinDate, j, true, 0);
        if (localMessages.hasJustLocal) {
            if (loadMessagesIntervalResult.messages == null) {
                loadMessagesIntervalResult.messages = new ArrayList<>();
            }
            loadMessagesIntervalResult.messages.addAll(localMessages.justLocalMessages);
            Collections.sort(loadMessagesIntervalResult.messages, this.messageComparatorToBottom);
            loadMessagesIntervalResult.oldMaxDate = loadMessagesIntervalResult.messages.get(0).timeMillis - 1;
            loadMessagesIntervalResult.newMinDate = loadMessagesIntervalResult.messages.get(r2.size() - 1).timeMillis + 1;
        } else {
            loadMessagesIntervalResult.oldMaxDate = jFindMinDate - 1;
            loadMessagesIntervalResult.newMinDate = j + 1;
        }
        return loadMessagesIntervalResult;
    }

    private long findMinDate(ArrayList<Message> arrayList) {
        long jMin = Long.MAX_VALUE;
        if (arrayList == null) {
            return Long.MAX_VALUE;
        }
        Iterator<Message> it = arrayList.iterator();
        while (it.hasNext()) {
            jMin = Math.min(jMin, it.next().timeMillis);
        }
        return jMin;
    }

    private long findMaxDate(ArrayList<Message> arrayList) {
        long jMax = 0;
        if (arrayList == null) {
            return 0L;
        }
        Iterator<Message> it = arrayList.iterator();
        while (it.hasNext()) {
            jMax = Math.max(jMax, it.next().timeMillis);
        }
        return jMax;
    }

    public void getMessagesFromServer(String str, NetworkHelper networkHelper, final DBHelper dBHelper, final KeyValueStorageHelper keyValueStorageHelper, final String str2, final FilterTypeEnum filterTypeEnum, final long j, final long j2, final boolean z, int i, final long j3, final GetMessagesListener getMessagesListener) {
        try {
            networkHelper.getMessages(str, createGetMessagesInput(str2, filterTypeEnum, j, j2, z, i > 0 ? i : 50), this.retry, new NetworkHelper.ResponseListener<GetMessagesOutput>() { // from class: ir.aaap.messengercore.MessageUtils.20
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetMessagesOutput getMessagesOutput) {
                    GetMessagesResultInner getMessagesResultInner = new GetMessagesResultInner();
                    ArrayList<Message> arrayList = new ArrayList<>();
                    getMessagesResultInner.messages = arrayList;
                    if (getMessagesOutput != null) {
                        arrayList.addAll(getMessagesOutput.messages);
                        getMessagesResultInner.hasContinue = getMessagesOutput.has_continue;
                        getMessagesResultInner.newMaxId = getMessagesOutput.new_max_id;
                        getMessagesResultInner.newMinId = getMessagesOutput.new_min_id;
                        if (keyValueStorageHelper.getMessagesState(str2) == null) {
                            dBHelper.removeAllNotLocalMessagesAndHoles(str2);
                            String str3 = getMessagesOutput.state;
                            if (str3 != null && !str3.isEmpty()) {
                                keyValueStorageHelper.setMessagesState(str2, getMessagesOutput.state, getMessagesOutput.timestamp);
                            }
                        }
                        int size = getMessagesOutput.messages.size();
                        if (!z) {
                            if (size > 0) {
                                MessageUtils.this.fillMessageAttribute(getMessagesOutput.messages, getMessagesOutput.timestamp);
                                dBHelper.addAllMessagesAndFillHoles(str2, getMessagesOutput.messages, getMessagesOutput.has_continue ? getMessagesOutput.new_max_id + 1 : 0L, j2, filterTypeEnum, getMessagesOutput.timestamp, j3);
                            } else {
                                dBHelper.fillHole(str2, getMessagesOutput.has_continue ? getMessagesOutput.new_max_id + 1 : 0L, j2, filterTypeEnum, j3);
                            }
                        } else if (size > 0) {
                            MessageUtils.this.fillMessageAttribute(getMessagesOutput.messages, getMessagesOutput.timestamp);
                            dBHelper.addAllMessagesAndFillHoles(str2, getMessagesOutput.messages, j, getMessagesOutput.new_min_id - 1, filterTypeEnum, getMessagesOutput.timestamp, j3);
                        } else {
                            dBHelper.fillHole(str2, j, getMessagesOutput.new_min_id - 1, filterTypeEnum, j3);
                        }
                    }
                    GetMessagesListener getMessagesListener2 = getMessagesListener;
                    if (getMessagesListener2 != null) {
                        getMessagesListener2.onResponse(getMessagesResultInner);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    GetMessagesListener getMessagesListener2 = getMessagesListener;
                    if (getMessagesListener2 != null) {
                        getMessagesListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (getMessagesListener != null) {
                getMessagesListener.onError(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Message getMessageByIdFromDb(String str, long j, DBHelper dBHelper) {
        return dBHelper.getMessageById(str, j);
    }

    public Message getMessageByIdFromMapOrDb(String str, long j, DBHelper dBHelper) {
        if (str == null) {
            return null;
        }
        Message message = this.messagesMap.get(Long.valueOf(j));
        if (message != null) {
            return message;
        }
        Message messageByIdFromDb = getMessageByIdFromDb(str, j, dBHelper);
        if (messageByIdFromDb != null) {
            addToMessageMap(messageByIdFromDb);
        }
        return messageByIdFromDb;
    }

    private void addToMessageMap(Message message) {
        ArrayList<Message> arrayList = new ArrayList<>();
        arrayList.add(message);
        addToMessageMap(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToMessageMap(ArrayList<Message> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        synchronized (this.messageLock) {
            if (this.messagesMap.size() + arrayList.size() > 1000) {
                this.messagesMap.clear();
            }
            Iterator<Message> it = arrayList.iterator();
            while (it.hasNext()) {
                Message next = it.next();
                this.messagesMap.put(Long.valueOf(next.message_id), next);
            }
        }
    }

    private void removeFromMessageMap(Long l) {
        if (l == null) {
            return;
        }
        synchronized (this.messageLock) {
            this.messagesMap.remove(l);
        }
    }

    public void loadReplyForMessages(String str, final ArrayList<Message> arrayList, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final LoadListener<ArrayList<Message>> loadListener) {
        if (arrayList == null || arrayList.size() == 0) {
            if (loadListener != null) {
                loadListener.onDidLoad(new ArrayList<>());
                return;
            }
            return;
        }
        final HashSet hashSet = new HashSet();
        ArrayList<Message> arrayList2 = new ArrayList<>();
        Iterator<Message> it = arrayList.iterator();
        while (it.hasNext()) {
            Message next = it.next();
            long j = next.reply_to_message_id;
            if (j > 0) {
                Message messageByIdFromMapOrDb = getMessageByIdFromMapOrDb(str, j, dBHelper);
                if (messageByIdFromMapOrDb == null) {
                    hashSet.add(Long.valueOf(next.reply_to_message_id));
                } else {
                    arrayList2.add(messageByIdFromMapOrDb);
                }
            }
        }
        if (arrayList2.size() > 0 && loadListener != null) {
            loadListener.onDidLoad(arrayList2);
        }
        if (hashSet.size() > 0) {
            getMessagesByIdFromServer(str, hashSet, str2, networkHelper, dBHelper, new LoadListener<HashMap<Long, Message>>() { // from class: ir.aaap.messengercore.MessageUtils.21
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(HashMap<Long, Message> map) {
                    if (map == null || map.size() == 0) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(new ArrayList());
                            return;
                        }
                        return;
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        Message message = (Message) it2.next();
                        long j2 = message.reply_to_message_id;
                        if (j2 > 0 && hashSet.contains(Long.valueOf(j2)) && map.containsKey(Long.valueOf(message.reply_to_message_id)) && map.get(Long.valueOf(message.reply_to_message_id)) == null) {
                            message.reply_to_message_id = 0L;
                            Message message2 = (Message) MessageUtils.this.messagesMap.get(Long.valueOf(message.message_id));
                            if (message2 != null) {
                                message2.reply_to_message_id = 0L;
                            }
                            dBHelper.updateMessageReplyTo(message);
                        }
                    }
                    if (loadListener != null) {
                        ArrayList arrayList3 = new ArrayList();
                        for (Message message3 : map.values()) {
                            if (message3 != null) {
                                arrayList3.add(message3);
                            }
                        }
                        loadListener.onDidLoad(arrayList3);
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
        } else {
            if (arrayList2.size() != 0 || loadListener == null) {
                return;
            }
            loadListener.onDidLoad(new ArrayList<>());
        }
    }

    public void loadMessageForChat(String str, long j, String str2, NetworkHelper networkHelper, DBHelper dBHelper, final LoadListener<Integer> loadListener) {
        if (j == 0) {
            if (loadListener != null) {
                loadListener.onDidLoad(1);
                return;
            }
            return;
        }
        HashSet hashSet = new HashSet();
        if (getMessageByIdFromMapOrDb(str, j, dBHelper) == null) {
            hashSet.add(Long.valueOf(j));
        }
        if (hashSet.size() != 0) {
            getMessagesByIdFromServer(str, hashSet, str2, networkHelper, dBHelper, new LoadListener<HashMap<Long, Message>>(this) { // from class: ir.aaap.messengercore.MessageUtils.22
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(HashMap<Long, Message> map) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(1);
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
        } else if (loadListener != null) {
            loadListener.onDidLoad(1);
        }
    }

    public void loadMessagesById(String str, ArrayList<Long> arrayList, String str2, NetworkHelper networkHelper, DBHelper dBHelper, final LoadListener<Map<Long, Message>> loadListener) {
        final HashMap map = new HashMap();
        if (arrayList == null || arrayList.size() == 0) {
            if (loadListener != null) {
                loadListener.onDidLoad(map);
                return;
            }
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<Long> it = arrayList.iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            Message messageByIdFromMapOrDb = getMessageByIdFromMapOrDb(str, jLongValue, dBHelper);
            if (messageByIdFromMapOrDb == null) {
                hashSet.add(Long.valueOf(jLongValue));
            } else {
                map.put(Long.valueOf(messageByIdFromMapOrDb.message_id), messageByIdFromMapOrDb);
            }
        }
        if (hashSet.size() != 0) {
            getMessagesByIdFromServer(str, hashSet, str2, networkHelper, dBHelper, new LoadListener<HashMap<Long, Message>>(this) { // from class: ir.aaap.messengercore.MessageUtils.23
                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(HashMap<Long, Message> map2) {
                    if (map2 != null) {
                        map.putAll(map2);
                    }
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(map);
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
        } else if (loadListener != null) {
            loadListener.onDidLoad(map);
        }
    }

    private void getMessagesByIdFromServer(String str, Set<Long> set, String str2, NetworkHelper networkHelper, DBHelper dBHelper, LoadListener<HashMap<Long, Message>> loadListener) {
        new GetMessagesByIdHelper(str2, networkHelper, dBHelper, loadListener).getMessagesById(str, set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillMessageAttribute(ArrayList<Message> arrayList, long j) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<Message> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().fillAttribute(j);
        }
    }

    public void onChatMessagesDeleted(DBHelper dBHelper, KeyValueStorageHelper keyValueStorageHelper, ArrayList<String> arrayList) {
        dBHelper.removeAllMessagesAndHoles(arrayList);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public void getMessagesIntervalFromServer(String str, NetworkHelper networkHelper, final DBHelper dBHelper, final KeyValueStorageHelper keyValueStorageHelper, final String str2, final FilterTypeEnum filterTypeEnum, long j, final GetMessagesListener getMessagesListener, final long j2) {
        try {
            networkHelper.getMessagesInterval(str, createGetMessagesIntervalInput(str2, filterTypeEnum, j), this.retry, new NetworkHelper.ResponseListener<GetMessagesIntervalOutput>() { // from class: ir.aaap.messengercore.MessageUtils.24
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetMessagesIntervalOutput getMessagesIntervalOutput) {
                    GetMessagesResultInner getMessagesResultInner = new GetMessagesResultInner();
                    getMessagesResultInner.messages = new ArrayList<>();
                    if (getMessagesIntervalOutput != null) {
                        if (keyValueStorageHelper.getMessagesState(str2) == null) {
                            dBHelper.removeAllNotLocalMessagesAndHoles(str2);
                            String str3 = getMessagesIntervalOutput.state;
                            if (str3 != null && !str3.isEmpty()) {
                                keyValueStorageHelper.setMessagesState(str2, getMessagesIntervalOutput.state, getMessagesIntervalOutput.timestamp);
                            }
                        }
                        ArrayList<Message> arrayList = getMessagesIntervalOutput.messages;
                        if (arrayList != null && arrayList.size() > 0) {
                            MessageUtils.this.fillMessageAttribute(getMessagesIntervalOutput.messages, getMessagesIntervalOutput.timestamp);
                            DBHelper dBHelper2 = dBHelper;
                            String str4 = str2;
                            ArrayList<Message> arrayList2 = getMessagesIntervalOutput.messages;
                            long j3 = getMessagesIntervalOutput.old_has_continue ? arrayList2.get(0).message_id : 0L;
                            ArrayList<Message> arrayList3 = getMessagesIntervalOutput.messages;
                            dBHelper2.addAllMessagesAndFillHoles(str4, arrayList2, j3, arrayList3.get(arrayList3.size() - 1).message_id, filterTypeEnum, getMessagesIntervalOutput.timestamp, j2);
                            getMessagesResultInner.messages.addAll(getMessagesIntervalOutput.messages);
                        } else {
                            dBHelper.fillHole(str2, getMessagesIntervalOutput.old_max_id + 1, getMessagesIntervalOutput.new_min_id - 1, filterTypeEnum, j2);
                        }
                        getMessagesResultInner.newerHasContinue = getMessagesIntervalOutput.new_has_continue;
                        getMessagesResultInner.olderHasContinue = getMessagesIntervalOutput.old_has_continue;
                        getMessagesResultInner.newMinId = getMessagesIntervalOutput.new_min_id;
                        getMessagesResultInner.newMaxId = getMessagesIntervalOutput.old_max_id;
                    }
                    GetMessagesListener getMessagesListener2 = getMessagesListener;
                    if (getMessagesListener2 != null) {
                        getMessagesListener2.onResponse(getMessagesResultInner);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    GetMessagesListener getMessagesListener2 = getMessagesListener;
                    if (getMessagesListener2 != null) {
                        getMessagesListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            if (getMessagesListener != null) {
                getMessagesListener.onError(e);
            }
        }
    }

    public void startMessageList(String str, ChatType chatType, String str2, NetworkHelper networkHelper, DBHelper dBHelper, KeyValueStorageHelper keyValueStorageHelper, AbsNotificationCenter absNotificationCenter, TimerHelper timerHelper, UpdateMessageUsecase updateMessageUsecase, GetChatAccessUseCase getChatAccessUseCase, UpdateBotInfoUsecase updateBotInfoUsecase) {
        if (this.messagesStartedSet.contains(str)) {
            return;
        }
        this.messagesStartedSet.add(str);
        this.chatUseStartTimeMap.put(str, Long.valueOf(System.currentTimeMillis()));
        startMessageTimer(str, chatType, str2, networkHelper, dBHelper, absNotificationCenter, keyValueStorageHelper, timerHelper, updateMessageUsecase, getChatAccessUseCase, updateBotInfoUsecase);
    }

    public void onBotInfoLevelChanged(String str, ChatType chatType, String str2, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, KeyValueStorageHelper keyValueStorageHelper, TimerHelper timerHelper, UpdateMessageUsecase updateMessageUsecase, GetChatAccessUseCase getChatAccessUseCase, UpdateBotInfoUsecase updateBotInfoUsecase) {
        if (chatType == ChatType.Bot && this.messagesStartedSet.contains(str)) {
            startMessageTimer(str, chatType, str2, networkHelper, dBHelper, absNotificationCenter, keyValueStorageHelper, timerHelper, updateMessageUsecase, getChatAccessUseCase, updateBotInfoUsecase);
        }
    }

    public void setChatUseTime(String str, String str2, NetworkHelper networkHelper) {
        int iCurrentTimeMillis;
        if (this.chatUseStartTimeMap.containsKey(str2)) {
            long jLongValue = this.chatUseStartTimeMap.get(str2).longValue();
            this.chatUseStartTimeMap.remove(str2);
            if (jLongValue > 0 && (iCurrentTimeMillis = (int) ((System.currentTimeMillis() - jLongValue) / 1000)) >= 3) {
                try {
                    networkHelper.setChatUseTime(str, new SetChatUseTimeInput(str2, iCurrentTimeMillis), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SetChatUseTimeOutput>(this) { // from class: ir.aaap.messengercore.MessageUtils.25
                        @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                        public void onError(Exception exc) {
                        }

                        @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                        public void onResponse(SetChatUseTimeOutput setChatUseTimeOutput) {
                        }
                    });
                } catch (Exception e) {
                    this.coreLog.handleException(e);
                }
            }
        }
    }

    private void startMessageTimer(String str, ChatType chatType, String str2, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, KeyValueStorageHelper keyValueStorageHelper, TimerHelper timerHelper, UpdateMessageUsecase updateMessageUsecase, GetChatAccessUseCase getChatAccessUseCase, UpdateBotInfoUsecase updateBotInfoUsecase) {
        long j = 100;
        if (this.messageUpdatedTimeMap.containsKey(str)) {
            long jLongValue = this.messageUpdatedTimeMap.get(str).longValue();
            if (jLongValue > System.currentTimeMillis()) {
                jLongValue = 0;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
            long botInfoUpdateDuration = (chatType != ChatType.Bot || updateBotInfoUsecase == null) ? 60000L : updateBotInfoUsecase.getBotInfoUpdateDuration();
            if (jCurrentTimeMillis < botInfoUpdateDuration) {
                j = botInfoUpdateDuration - (jCurrentTimeMillis > 0 ? jCurrentTimeMillis : 0L);
            }
        }
        startMessageTimer(j, str, chatType, str2, networkHelper, dBHelper, absNotificationCenter, keyValueStorageHelper, timerHelper, updateMessageUsecase, getChatAccessUseCase, updateBotInfoUsecase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startMessageTimer(long j, final String str, final ChatType chatType, final String str2, final NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final KeyValueStorageHelper keyValueStorageHelper, final TimerHelper timerHelper, final UpdateMessageUsecase updateMessageUsecase, final GetChatAccessUseCase getChatAccessUseCase, final UpdateBotInfoUsecase updateBotInfoUsecase) {
        TimerHelper timerHelper2;
        HashSet<Chat.ChatAccessEnum> chatAccess;
        if (getChatAccessUseCase != null && (chatAccess = getChatAccessUseCase.getChatAccess(str, chatType)) != null && !chatAccess.contains(Chat.ChatAccessEnum.ViewMessages)) {
            this.updateLoadingSet.remove(str);
            Runnable runnable = this.updateRunnableMap.get(str);
            if (runnable != null) {
                timerHelper.cancelRunnable(runnable);
                return;
            }
            return;
        }
        Runnable runnable2 = this.updateRunnableMap.get(str);
        if (runnable2 == null) {
            Runnable runnable3 = new Runnable() { // from class: ir.aaap.messengercore.MessageUtils$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$startMessageTimer$0(str, keyValueStorageHelper, dBHelper, chatType, str2, networkHelper, absNotificationCenter, timerHelper, updateMessageUsecase, getChatAccessUseCase, updateBotInfoUsecase);
                }
            };
            this.updateRunnableMap.put(str, runnable3);
            timerHelper2 = timerHelper;
            runnable2 = runnable3;
        } else {
            timerHelper2 = timerHelper;
        }
        if (timerHelper2 != null) {
            timerHelper2.postRunnableDelayed(runnable2, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startMessageTimer$0(final String str, final KeyValueStorageHelper keyValueStorageHelper, final DBHelper dBHelper, final ChatType chatType, final String str2, final NetworkHelper networkHelper, final AbsNotificationCenter absNotificationCenter, final TimerHelper timerHelper, final UpdateMessageUsecase updateMessageUsecase, final GetChatAccessUseCase getChatAccessUseCase, final UpdateBotInfoUsecase updateBotInfoUsecase) {
        String str3;
        DBHelper dBHelper2;
        String str4;
        MessageUtils messageUtils = this;
        if (messageUtils.updateLoadingSet.contains(str)) {
            return;
        }
        String messagesState = keyValueStorageHelper.getMessagesState(str);
        if (messagesState == null) {
            str3 = str;
            dBHelper2 = dBHelper;
        } else if (messagesState.isEmpty()) {
            dBHelper2 = dBHelper;
            str3 = str;
        } else {
            messageUtils.updateLoadingSet.add(str);
            GetMessagesUpdatesInput getMessagesUpdatesInput = new GetMessagesUpdatesInput();
            getMessagesUpdatesInput.object_guid = str;
            getMessagesUpdatesInput.state = messagesState;
            try {
                try {
                    messageUtils = this;
                    try {
                        str4 = str;
                    } catch (Exception unused) {
                        str4 = str;
                        messageUtils.updateLoadingSet.remove(str4);
                        return;
                    }
                } catch (Exception unused2) {
                    messageUtils = this;
                }
                try {
                    messageUtils.updateRequestIdMap.put(str4, Integer.valueOf(networkHelper.getMessagesUpdates(str2, getMessagesUpdatesInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetMessagesUpdatesOutput>() { // from class: ir.aaap.messengercore.MessageUtils.26
                        @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                        public void onResponse(GetMessagesUpdatesOutput getMessagesUpdatesOutput) {
                            MessageUtils.this.updateLoadingSet.remove(str);
                            MessageUtils.this.processMessageUpdate(getMessagesUpdatesOutput.updated_messages, false, absNotificationCenter, dBHelper, keyValueStorageHelper, null, updateMessageUsecase, true);
                            if (CoreUtilities.isNotEmpty(getMessagesUpdatesOutput.new_state)) {
                                keyValueStorageHelper.setMessagesState(str, getMessagesUpdatesOutput.new_state, getMessagesUpdatesOutput.timestamp);
                            }
                            if (getMessagesUpdatesOutput.status != GetMessagesUpdatesOutput.Status.OldState) {
                                MessageUtils.this.messageUpdatedTimeMap.put(str, Long.valueOf(System.currentTimeMillis()));
                            } else {
                                dBHelper.removeAllNotLocalMessagesAndHoles(str);
                                keyValueStorageHelper.setMessagesState(str, null, 0L);
                                absNotificationCenter.messageUpdatedOldState(str, chatType);
                            }
                            if (MessageUtils.this.messagesStartedSet.contains(str)) {
                                MessageUtils.this.startMessageTimer(60000L, str, chatType, str2, networkHelper, dBHelper, absNotificationCenter, keyValueStorageHelper, timerHelper, updateMessageUsecase, getChatAccessUseCase, updateBotInfoUsecase);
                            }
                        }

                        @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                        public void onError(Exception exc) {
                            MessageUtils.this.updateLoadingSet.remove(str);
                            if (timerHelper == null || !MessageUtils.this.messagesStartedSet.contains(str)) {
                                return;
                            }
                            MessageUtils.this.startMessageTimer(60000L, str, chatType, str2, networkHelper, dBHelper, absNotificationCenter, keyValueStorageHelper, timerHelper, updateMessageUsecase, getChatAccessUseCase, updateBotInfoUsecase);
                        }
                    })));
                    return;
                } catch (Exception unused3) {
                    messageUtils.updateLoadingSet.remove(str4);
                    return;
                }
            } catch (Exception unused4) {
                str4 = str;
            }
        }
        dBHelper2.removeAllNotLocalMessagesAndHoles(str3);
        startMessageTimer(60000L, str, chatType, str2, networkHelper, dBHelper, absNotificationCenter, keyValueStorageHelper, timerHelper, updateMessageUsecase, getChatAccessUseCase, updateBotInfoUsecase);
    }

    public void requestUpdateLiveLocation(final String str, final long j, final String str2, String str3, NetworkHelper networkHelper, final DBHelper dBHelper, final LoadListener<LiveLocationObject> loadListener) {
        Integer numValueOf = this.updateLiveLocationRequestIdMap.get(str2);
        if (numValueOf != null) {
            networkHelper.cancelCall(numValueOf.intValue());
            this.updateLiveLocationRequestIdMap.remove(str2);
        }
        LiveLocationInput liveLocationInput = new LiveLocationInput();
        liveLocationInput.live_loc_track_id = str2;
        try {
            numValueOf = Integer.valueOf(networkHelper.getCurrentLiveLocation(str3, liveLocationInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<LiveLocationOutput>() { // from class: ir.aaap.messengercore.MessageUtils.27
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(LiveLocationOutput liveLocationOutput) {
                    MessageUtils.this.updateLiveLocationRequestIdMap.remove(str2);
                    MessageUtils.this.processLiveLocationChanged(str, j, liveLocationOutput.live_location, dBHelper);
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(liveLocationOutput.live_location);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    MessageUtils.this.updateLiveLocationRequestIdMap.remove(str2);
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            }));
        } catch (Exception e) {
            this.updateLiveLocationRequestIdMap.remove(str2);
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
        this.updateLiveLocationRequestIdMap.put(str2, numValueOf);
    }

    public void stopMessageList(String str, NetworkHelper networkHelper, TimerHelper timerHelper, String str2) {
        setChatUseTime(str, str2, networkHelper);
        if (this.updateLoadingSet.contains(str2)) {
            if (this.updateRequestIdMap.containsKey(str2)) {
                int iIntValue = this.updateRequestIdMap.get(str2).intValue();
                networkHelper.cancelCall(iIntValue);
                this.updateRequestIdMap.remove(Integer.valueOf(iIntValue));
            }
            this.updateLoadingSet.remove(str2);
        }
        if (this.messagesStartedSet.contains(str2)) {
            Runnable runnable = this.updateRunnableMap.get(str2);
            if (timerHelper != null && runnable != null) {
                timerHelper.cancelRunnable(runnable);
                this.updateRunnableMap.remove(str2);
            }
            this.messagesStartedSet.remove(str2);
        }
        generateNewGroupId(true);
    }

    public void deleteMessages(String str, ArrayList<Long> arrayList, DeleteMessagesInput.DeleteMessagesType deleteMessagesType, String str2, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final LoadListener<Integer> loadListener) {
        if (arrayList == null || arrayList.size() == 0) {
            if (loadListener != null) {
                loadListener.onDidLoad(1);
                return;
            }
            return;
        }
        DeleteMessagesInput deleteMessagesInput = new DeleteMessagesInput();
        deleteMessagesInput.object_guid = str;
        deleteMessagesInput.message_ids = arrayList;
        deleteMessagesInput.type = deleteMessagesType;
        try {
            networkHelper.deleteMessages(str2, deleteMessagesInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<DeleteMessagesOutput>(this) { // from class: ir.aaap.messengercore.MessageUtils.28
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(DeleteMessagesOutput deleteMessagesOutput) {
                    UpdateChatAndMessageUsecase updateChatAndMessageUsecase2;
                    if (deleteMessagesOutput != null && (updateChatAndMessageUsecase2 = updateChatAndMessageUsecase) != null) {
                        updateChatAndMessageUsecase2.processMessageAndChatUpdate(deleteMessagesOutput.message_updates, deleteMessagesOutput.chat_update, false, true);
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
            e.printStackTrace();
        }
    }

    public void togglePinMessage(final String str, long j, boolean z, String str2, NetworkHelper networkHelper, DBHelper dBHelper, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final LoadListener<PinMessageResult> loadListener) {
        Integer num = this.pinMessageRequestMap.get(str);
        if (num != null) {
            networkHelper.cancelCall(num.intValue());
            this.pinMessageRequestMap.remove(str);
        }
        SetPinMessageInput setPinMessageInput = new SetPinMessageInput();
        setPinMessageInput.object_guid = str;
        setPinMessageInput.message_id = Long.valueOf(j);
        setPinMessageInput.action = z ? SetPinMessageInput.ActionEnum.Pin : SetPinMessageInput.ActionEnum.Unpin;
        try {
            this.pinMessageRequestMap.put(str, Integer.valueOf(networkHelper.setPinMessage(str2, setPinMessageInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SetPinMessageOutput>() { // from class: ir.aaap.messengercore.MessageUtils.29
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SetPinMessageOutput setPinMessageOutput) {
                    MessageUtils.this.pinMessageRequestMap.remove(str);
                    PinMessageResult pinMessageResult = new PinMessageResult();
                    if (setPinMessageOutput != null) {
                        pinMessageResult.status = setPinMessageOutput.status;
                        UpdateChatAndMessageUsecase updateChatAndMessageUsecase2 = updateChatAndMessageUsecase;
                        if (updateChatAndMessageUsecase2 != null) {
                            updateChatAndMessageUsecase2.processMessageAndChatUpdate(setPinMessageOutput.message_update, setPinMessageOutput.chat_update, false, true);
                        }
                    }
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(pinMessageResult);
                    }
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    MessageUtils.this.pinMessageRequestMap.remove(str);
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            })));
        } catch (Exception e) {
            this.coreLog.handleException(e);
        }
    }

    public void unPinAllMessages(String str, String str2, NetworkHelper networkHelper, DBHelper dBHelper, final UpdateChatAndMessageUsecase updateChatAndMessageUsecase, final LoadListener<PinMessageResult> loadListener) {
        Integer num = this.pinMessageRequestMap.get(str);
        if (num != null) {
            networkHelper.cancelCall(num.intValue());
            this.pinMessageRequestMap.remove(str);
        }
        SetPinMessageInput setPinMessageInput = new SetPinMessageInput();
        setPinMessageInput.object_guid = str;
        setPinMessageInput.action = SetPinMessageInput.ActionEnum.UnpinAllMessages;
        try {
            networkHelper.setPinMessage(str2, setPinMessageInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SetPinMessageOutput>(this) { // from class: ir.aaap.messengercore.MessageUtils.30
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SetPinMessageOutput setPinMessageOutput) {
                    PinMessageResult pinMessageResult = new PinMessageResult();
                    if (setPinMessageOutput != null) {
                        pinMessageResult.status = setPinMessageOutput.status;
                        UpdateChatAndMessageUsecase updateChatAndMessageUsecase2 = updateChatAndMessageUsecase;
                        if (updateChatAndMessageUsecase2 != null) {
                            updateChatAndMessageUsecase2.processMessageAndChatUpdate(setPinMessageOutput.message_update, setPinMessageOutput.chat_update, false, true);
                        }
                    }
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(pinMessageResult);
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
            this.coreLog.handleException(e);
        }
    }

    public void getChannelMessagesSeenCount(String str, ArrayList<Message> arrayList, String str2, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<Message> it = arrayList.iterator();
        long j = Long.MAX_VALUE;
        long j2 = 0;
        while (it.hasNext()) {
            long j3 = it.next().message_id;
            if (j3 > 0 && j3 < j) {
                j = j3;
            }
            if (j3 > j2) {
                j2 = j3;
            }
        }
        getChannelMessagesSeenCount(str, str, j, j2, null, str2, networkHelper, dBHelper, absNotificationCenter);
    }

    public void getForwardedFromChannelMessagesSeenCount(String str, Message message, String str2, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter) {
        if (message == null) {
            return;
        }
        Message.ForwardFromObject forwardFromObject = message.forwarded_from;
        long j = forwardFromObject.message_id;
        getChannelMessagesSeenCount(str, forwardFromObject.object_guid, j, j, message, str2, networkHelper, dBHelper, absNotificationCenter);
    }

    public void getChannelMessagesSeenCount(final String str, String str2, long j, long j2, final Message message, String str3, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter) {
        GetChannelSeenCountInput getChannelSeenCountInput = new GetChannelSeenCountInput();
        getChannelSeenCountInput.channel_guid = str2;
        getChannelSeenCountInput.min_id = j;
        getChannelSeenCountInput.max_id = j2;
        try {
            networkHelper.getChannelSeenCount(str3, getChannelSeenCountInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetChannelSeenCountOutput>() { // from class: ir.aaap.messengercore.MessageUtils.31
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetChannelSeenCountOutput getChannelSeenCountOutput) {
                    Map<Long, Integer> map;
                    Integer num;
                    if (getChannelSeenCountOutput == null || (map = getChannelSeenCountOutput.list) == null || map.size() <= 0) {
                        return;
                    }
                    Message message2 = message;
                    if (message2 != null && (num = getChannelSeenCountOutput.list.get(Long.valueOf(message2.forwarded_from.message_id))) != null) {
                        int iIntValue = num.intValue();
                        Message message3 = message;
                        if (iIntValue != message3.count_seen) {
                            message3.count_seen = num.intValue();
                            getChannelSeenCountOutput.list.put(Long.valueOf(message.message_id), num);
                        }
                    }
                    dBHelper.updateMessagesSeenCount(getChannelSeenCountOutput.list);
                    synchronized (MessageUtils.this.messageLock) {
                        Iterator<Long> it = getChannelSeenCountOutput.list.keySet().iterator();
                        while (it.hasNext()) {
                            long jLongValue = it.next().longValue();
                            Message message4 = (Message) MessageUtils.this.messagesMap.get(Long.valueOf(jLongValue));
                            if (message4 != null) {
                                message4.count_seen = getChannelSeenCountOutput.list.get(Long.valueOf(jLongValue)).intValue();
                            }
                        }
                    }
                    AbsNotificationCenter absNotificationCenter2 = absNotificationCenter;
                    if (absNotificationCenter2 != null) {
                        String str4 = str;
                        Map<Long, Integer> map2 = getChannelSeenCountOutput.list;
                        Message message5 = message;
                        absNotificationCenter2.didUpdateMessagesViews(str4, map2, message5 != null ? message5.message_id : 0L);
                    }
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
        }
    }

    public void actionOnMessageReaction(String str, final long j, String str2, SettingModels.ActionOnMessageReactionTypeEnum actionOnMessageReactionTypeEnum, String str3, NetworkHelper networkHelper, final DBHelper dBHelper, final LoadListener<ArrayList<MessageReactionObject>> loadListener) {
        if (str == null || j == 0 || actionOnMessageReactionTypeEnum == null) {
            if (loadListener != null) {
                loadListener.onError(new InvalidInputException("reaction"));
                return;
            }
            return;
        }
        SettingModels.ActionOnMessageReactionInput actionOnMessageReactionInput = new SettingModels.ActionOnMessageReactionInput();
        actionOnMessageReactionInput.object_guid = str;
        actionOnMessageReactionInput.message_id = j;
        actionOnMessageReactionInput.reaction_id = !TextUtils.isEmpty(str2) ? str2 : null;
        actionOnMessageReactionInput.action = actionOnMessageReactionTypeEnum;
        try {
            networkHelper.actionOnMessageReaction(str3, actionOnMessageReactionInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SettingModels.ActionOnMessageReactionOutput>() { // from class: ir.aaap.messengercore.MessageUtils.32
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SettingModels.ActionOnMessageReactionOutput actionOnMessageReactionOutput) {
                    if (actionOnMessageReactionOutput != null) {
                        HashMap map = new HashMap();
                        map.put(Long.valueOf(j), actionOnMessageReactionOutput.reactions);
                        dBHelper.updateMessagesReactions(map);
                        synchronized (MessageUtils.this.messageLock) {
                            Message message = (Message) MessageUtils.this.messagesMap.get(Long.valueOf(j));
                            if (message != null) {
                                message.reactions = actionOnMessageReactionOutput.reactions;
                            }
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(actionOnMessageReactionOutput.reactions);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onDidLoad(null);
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
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public void getChatReaction(final String str, long j, long j2, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final LoadAbsUsecase loadAbsUsecase, final boolean z) {
        SettingModels.GetChatReactionInput getChatReactionInput = new SettingModels.GetChatReactionInput();
        getChatReactionInput.object_guid = str;
        getChatReactionInput.min_id = j;
        getChatReactionInput.max_id = j2;
        try {
            networkHelper.getChatReaction(str2, getChatReactionInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SettingModels.GetChatReactionOutput>() { // from class: ir.aaap.messengercore.MessageUtils.33
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SettingModels.GetChatReactionOutput getChatReactionOutput) {
                    Map<Long, ArrayList<MessageReactionObject>> map;
                    if (getChatReactionOutput == null || (map = getChatReactionOutput.list) == null || map.size() <= 0) {
                        return;
                    }
                    dBHelper.updateMessagesReactions(getChatReactionOutput.list);
                    synchronized (MessageUtils.this.messageLock) {
                        Iterator<Long> it = getChatReactionOutput.list.keySet().iterator();
                        while (it.hasNext()) {
                            long jLongValue = it.next().longValue();
                            Message message = (Message) MessageUtils.this.messagesMap.get(Long.valueOf(jLongValue));
                            if (message != null) {
                                message.reactions = getChatReactionOutput.list.get(Long.valueOf(jLongValue));
                            }
                        }
                    }
                    AbsNotificationCenter absNotificationCenter2 = absNotificationCenter;
                    if (absNotificationCenter2 != null) {
                        absNotificationCenter2.didUpdateChatMessagesReactions(str, getChatReactionOutput.list);
                    }
                    if (z || loadAbsUsecase == null) {
                        return;
                    }
                    HashSet hashSet = new HashSet();
                    Iterator<Long> it2 = getChatReactionOutput.list.keySet().iterator();
                    while (it2.hasNext()) {
                        ArrayList<MessageReactionObject> arrayList = getChatReactionOutput.list.get(Long.valueOf(it2.next().longValue()));
                        if (arrayList != null) {
                            Iterator<MessageReactionObject> it3 = arrayList.iterator();
                            while (it3.hasNext()) {
                                ArrayList<String> arrayList2 = it3.next().user_guids;
                                if (arrayList2 != null) {
                                    hashSet.addAll(arrayList2);
                                }
                            }
                        }
                    }
                    loadAbsUsecase.loadAbs(hashSet, false, new LoadListener<Set<String>>() { // from class: ir.aaap.messengercore.MessageUtils.33.1
                        @Override // ir.aaap.messengercore.LoadListener
                        public void onError(Exception exc) {
                        }

                        @Override // ir.aaap.messengercore.LoadListener
                        public void onDidLoad(Set<String> set) {
                            AnonymousClass33 anonymousClass33 = AnonymousClass33.this;
                            absNotificationCenter.absForReactionsDidLoad(str, set);
                        }
                    });
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
        }
    }

    public void getMessageReactions(final String str, ChatType chatType, final long j, String str2, String str3, NetworkHelper networkHelper, final DBHelper dBHelper, final LoadListener<SettingModels.GetMessageReactionsOutput> loadListener, final LoadAbsUsecase loadAbsUsecase) {
        if (TextUtils.isEmpty(str) || j <= 0 || chatType == null || chatType == ChatType.Channel) {
            if (loadListener != null) {
                loadListener.onError(new InputException());
                return;
            }
            return;
        }
        SettingModels.GetMessageReactionsInput getMessageReactionsInput = new SettingModels.GetMessageReactionsInput();
        getMessageReactionsInput.object_guid = str;
        getMessageReactionsInput.message_id = j;
        getMessageReactionsInput.start_id = TextUtils.isEmpty(str2) ? null : str2;
        try {
            networkHelper.getMessageReactions(str3, getMessageReactionsInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SettingModels.GetMessageReactionsOutput>() { // from class: ir.aaap.messengercore.MessageUtils.34
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(final SettingModels.GetMessageReactionsOutput getMessageReactionsOutput) {
                    ArrayList<UserReactionObject> arrayList;
                    int i;
                    ArrayList<MessageReactionObject> arrayList2;
                    if (loadAbsUsecase != null) {
                        HashSet hashSet = new HashSet();
                        if (getMessageReactionsOutput != null) {
                            Message messageByIdFromDb = MessageUtils.this.getMessageByIdFromDb(str, j, dBHelper);
                            if (messageByIdFromDb == null || (arrayList2 = messageByIdFromDb.reactions) == null) {
                                i = 0;
                            } else {
                                Iterator<MessageReactionObject> it = arrayList2.iterator();
                                i = 0;
                                while (it.hasNext()) {
                                    int i2 = it.next().reaction_count;
                                    if (i2 <= 0) {
                                        i2 = 0;
                                    }
                                    i += i2;
                                }
                            }
                            getMessageReactionsOutput.reactionCount = i;
                        }
                        if (getMessageReactionsOutput != null && (arrayList = getMessageReactionsOutput.user_message_reactions) != null && arrayList.size() > 0) {
                            Iterator<UserReactionObject> it2 = getMessageReactionsOutput.user_message_reactions.iterator();
                            while (it2.hasNext()) {
                                hashSet.add(it2.next().user_guid);
                            }
                            loadAbsUsecase.loadAbs(hashSet, false, new LoadListener<Set<String>>() { // from class: ir.aaap.messengercore.MessageUtils.34.1
                                @Override // ir.aaap.messengercore.LoadListener
                                public void onDidLoad(Set<String> set) {
                                    LoadListener loadListener2 = loadListener;
                                    if (loadListener2 != null) {
                                        loadListener2.onDidLoad(getMessageReactionsOutput);
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
                            return;
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(getMessageReactionsOutput);
                            return;
                        }
                        return;
                    }
                    LoadListener loadListener3 = loadListener;
                    if (loadListener3 != null) {
                        loadListener3.onDidLoad(getMessageReactionsOutput);
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

    public void seenChannelMessages(String str, long j, long j2, String str2, NetworkHelper networkHelper) {
        SeenChannelMessagesInput seenChannelMessagesInput = new SeenChannelMessagesInput();
        seenChannelMessagesInput.channel_guid = str;
        seenChannelMessagesInput.min_id = j;
        seenChannelMessagesInput.max_id = j2;
        try {
            networkHelper.seenChannelMessages(str2, seenChannelMessagesInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SeenChannelMessagesOutput>(this) { // from class: ir.aaap.messengercore.MessageUtils.35
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SeenChannelMessagesOutput seenChannelMessagesOutput) {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initAndLoadMyStickersIfNeeded(boolean z, String str, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, KeyValueStorageHelper keyValueStorageHelper) {
        boolean z2 = false;
        boolean z3 = System.currentTimeMillis() - keyValueStorageHelper.getLastUpdatedStickerTime() >= 3600000;
        if (!z3 && !z) {
            z2 = true;
        }
        loadMyStickersFromDb(dBHelper, absNotificationCenter, keyValueStorageHelper, z2);
        if (z3 || z) {
            loadMyStickersFromServer(str, networkHelper, dBHelper, absNotificationCenter, keyValueStorageHelper);
        }
    }

    private void loadMyStickersFromDb(DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, KeyValueStorageHelper keyValueStorageHelper, boolean z) {
        ArrayList<GetStickerSetByIdOutput> allMyStickerSets = dBHelper.getAllMyStickerSets();
        ArrayList<String> myStickersOrder = keyValueStorageHelper.getMyStickersOrder();
        synchronized (this.stickerLock) {
            this.myStickerSetsOrder.clear();
            if (myStickersOrder != null) {
                this.myStickerSetsOrder.addAll(myStickersOrder);
            }
            if (allMyStickerSets != null) {
                Iterator<GetStickerSetByIdOutput> it = allMyStickerSets.iterator();
                while (it.hasNext()) {
                    GetStickerSetByIdOutput next = it.next();
                    StickerSetObject stickerSetObject = next.sticker_set;
                    if (stickerSetObject != null) {
                        if (!this.myStickerSetsOrder.contains(stickerSetObject.sticker_set_id)) {
                            this.myStickerSetsOrder.add(next.sticker_set.sticker_set_id);
                        }
                        Map<String, StickerSetObject> map = this.stickerSetObjectMap;
                        StickerSetObject stickerSetObject2 = next.sticker_set;
                        map.put(stickerSetObject2.sticker_set_id, stickerSetObject2);
                        this.stickerBySetIdMap.put(next.sticker_set.sticker_set_id, next.stickers);
                    }
                }
            }
        }
        if (z) {
            absNotificationCenter.myStickersDidLoad();
        }
    }

    private void loadMyStickersFromServer(final String str, final NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final KeyValueStorageHelper keyValueStorageHelper) {
        try {
            networkHelper.getMyStickerSets(str, new GetMyStickerSetsInput(), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetStickersOutput>() { // from class: ir.aaap.messengercore.MessageUtils.36
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetStickersOutput getStickersOutput) {
                    if (getStickersOutput != null && getStickersOutput.sticker_sets != null) {
                        HashSet hashSet = new HashSet();
                        synchronized (MessageUtils.this.stickerLock) {
                            MessageUtils.this.myStickerSetsOrder.clear();
                            Iterator<StickerSetObject> it = getStickersOutput.sticker_sets.iterator();
                            while (it.hasNext()) {
                                StickerSetObject next = it.next();
                                hashSet.add(next.sticker_set_id);
                                MessageUtils.this.myStickerSetsOrder.add(next.sticker_set_id);
                                MessageUtils.this.stickerSetObjectMap.put(next.sticker_set_id, next);
                            }
                            keyValueStorageHelper.setMyStickersOrder(MessageUtils.this.myStickerSetsOrder);
                        }
                        MessageUtils.this.getStickerBySetIdsFromServer(hashSet, str, networkHelper, dBHelper, absNotificationCenter, new LoadListener<HashMap<String, ArrayList<StickerObject>>>() { // from class: ir.aaap.messengercore.MessageUtils.36.1
                            @Override // ir.aaap.messengercore.LoadListener
                            public void onDidLoad(HashMap<String, ArrayList<StickerObject>> map) {
                                ArrayList<GetStickerSetByIdOutput> arrayList = new ArrayList<>();
                                if (map != null && map.size() > 0) {
                                    for (String str2 : map.keySet()) {
                                        StickerSetObject stickerSetObject = (StickerSetObject) MessageUtils.this.stickerSetObjectMap.get(str2);
                                        if (stickerSetObject != null) {
                                            GetStickerSetByIdOutput getStickerSetByIdOutput = new GetStickerSetByIdOutput();
                                            getStickerSetByIdOutput.sticker_set = stickerSetObject;
                                            getStickerSetByIdOutput.stickers = map.get(str2);
                                            arrayList.add(getStickerSetByIdOutput);
                                        }
                                    }
                                }
                                dBHelper.removeAllMyStickerSet();
                                dBHelper.addAllMyStickerSet(arrayList);
                                keyValueStorageHelper.setLastUpdatedStickerTime(System.currentTimeMillis());
                                absNotificationCenter.myStickersDidLoad();
                            }

                            @Override // ir.aaap.messengercore.LoadListener
                            public void onError(Exception exc) {
                                absNotificationCenter.myStickersFailed();
                            }
                        });
                        return;
                    }
                    absNotificationCenter.myStickersFailed();
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                    absNotificationCenter.myStickersFailed();
                }
            });
        } catch (Exception e) {
            absNotificationCenter.myStickersFailed();
            this.coreLog.handleException(e);
        }
    }

    public void getMessageShareUrl(String str, long j, String str2, NetworkHelper networkHelper, final LoadListener<GetMessageShareUrlOutput> loadListener) {
        GetMessageShareUrlInput getMessageShareUrlInput = new GetMessageShareUrlInput(str, j);
        if (this.isLoadingMessageShareUrl) {
            return;
        }
        this.isLoadingMessageShareUrl = true;
        try {
            networkHelper.getMessageShareUrl(str2, getMessageShareUrlInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetMessageShareUrlOutput>() { // from class: ir.aaap.messengercore.MessageUtils.37
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetMessageShareUrlOutput getMessageShareUrlOutput) {
                    MessageUtils.this.isLoadingMessageShareUrl = false;
                    if (getMessageShareUrlOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(getMessageShareUrlOutput);
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
                    MessageUtils.this.isLoadingMessageShareUrl = false;
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onError(exc);
                    }
                }
            });
        } catch (Exception e) {
            this.isLoadingMessageShareUrl = false;
            if (loadListener != null) {
                loadListener.onError(e);
            }
            this.coreLog.handleException(e);
        }
    }

    public int getLinkFromAppUrl(String str, String str2, NetworkHelper networkHelper, final LoadListener<GetLinkFromAppUrlOutput> loadListener) {
        if (str == null || str.isEmpty()) {
            loadListener.onError(new InputException());
            return 0;
        }
        GetLinkFromAppUrlInput getLinkFromAppUrlInput = new GetLinkFromAppUrlInput();
        getLinkFromAppUrlInput.app_url = str;
        try {
            return networkHelper.getLinkFromAppUrl(str2, getLinkFromAppUrlInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetLinkFromAppUrlOutput>(this) { // from class: ir.aaap.messengercore.MessageUtils.38
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetLinkFromAppUrlOutput getLinkFromAppUrlOutput) {
                    if (getLinkFromAppUrlOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(getLinkFromAppUrlOutput);
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

    public void clickMessageUrl(String str, String str2, String str3, String str4, NetworkHelper networkHelper) {
        if (CoreUtilities.isNotEmpty(str) && CoreUtilities.isNotEmpty(str2) && CoreUtilities.isNotEmpty(str3)) {
            ClickMessageUrlInput clickMessageUrlInput = new ClickMessageUrlInput();
            clickMessageUrlInput.link_url = str3;
            clickMessageUrlInput.object_guid = str;
            clickMessageUrlInput.message_id = str2;
            try {
                networkHelper.clickMessageUrl(str4, clickMessageUrlInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<ClickMessageUrlOutput>() { // from class: ir.aaap.messengercore.MessageUtils.40
                    @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                    public void onResponse(ClickMessageUrlOutput clickMessageUrlOutput) {
                    }

                    @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                    public void onError(Exception exc) {
                        MessageUtils.this.coreLog.handleException(exc);
                    }
                });
            } catch (Exception e) {
                this.coreLog.handleException(e);
            }
        }
    }

    public void getStickerSetByID(final String str, String str2, NetworkHelper networkHelper, DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final LoadListener<Integer> loadListener) {
        if (str == null || str.isEmpty()) {
            if (loadListener != null) {
                loadListener.onError(new InputException());
                return;
            }
            return;
        }
        try {
            networkHelper.getStickerSetByID(str2, new GetStickerSetByIdInput(str), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetStickerSetByIdOutput>() { // from class: ir.aaap.messengercore.MessageUtils.41
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetStickerSetByIdOutput getStickerSetByIdOutput) {
                    if (getStickerSetByIdOutput != null && getStickerSetByIdOutput.sticker_set != null && getStickerSetByIdOutput.stickers != null) {
                        HashMap map = new HashMap();
                        map.put(str, getStickerSetByIdOutput.stickers);
                        MessageUtils.this.addStickersToMap(map);
                        MessageUtils.this.addStickerSetToMap(getStickerSetByIdOutput.sticker_set);
                        absNotificationCenter.stickerSetDidLoad(str);
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
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getStickerBySetIdsFromServer(Set<String> set, String str, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, final LoadListener<HashMap<String, ArrayList<StickerObject>>> loadListener) {
        if (set == null) {
            if (loadListener != null) {
                loadListener.onError(new InputException());
            }
        } else {
            if (set.size() == 0) {
                if (loadListener != null) {
                    loadListener.onDidLoad(new HashMap<>());
                    return;
                }
                return;
            }
            GetStickersBySetIDsInput getStickersBySetIDsInput = new GetStickersBySetIDsInput();
            getStickersBySetIDsInput.sticker_set_ids = set;
            try {
                networkHelper.getStickersBySetIDs(str, getStickersBySetIDsInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetStickersBySetIDsOutput>() { // from class: ir.aaap.messengercore.MessageUtils.42
                    @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                    public void onResponse(GetStickersBySetIDsOutput getStickersBySetIDsOutput) {
                        if (getStickersBySetIDsOutput != null && getStickersBySetIDsOutput.stickers != null) {
                            HashMap map = new HashMap();
                            Iterator<StickerObject> it = getStickersBySetIDsOutput.stickers.iterator();
                            while (it.hasNext()) {
                                StickerObject next = it.next();
                                ArrayList arrayList = (ArrayList) map.get(next.sticker_set_id);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                    map.put(next.sticker_set_id, arrayList);
                                }
                                arrayList.add(next);
                            }
                            MessageUtils.this.addStickersToMap(map);
                            LoadListener loadListener2 = loadListener;
                            if (loadListener2 != null) {
                                loadListener2.onDidLoad(map);
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
                this.coreLog.handleException(e);
                if (loadListener != null) {
                    loadListener.onError(e);
                }
            }
        }
    }

    public void getTrendStickerSet(boolean z, String str, String str2, NetworkHelper networkHelper, final KeyValueStorageHelper keyValueStorageHelper, final LoadListener<GetStickersOutput> loadListener) {
        long lastUpdatedTrendStickerSetTime = keyValueStorageHelper.getLastUpdatedTrendStickerSetTime();
        if (z || System.currentTimeMillis() - lastUpdatedTrendStickerSetTime > 432000) {
            GetStickersInput getStickersInput = new GetStickersInput();
            if (str == null || str.isEmpty()) {
                str = null;
            }
            getStickersInput.start_id = str;
            try {
                networkHelper.getTrendStickerSets(str2, getStickersInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetStickersOutput>(this) { // from class: ir.aaap.messengercore.MessageUtils.43
                    @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                    public void onResponse(GetStickersOutput getStickersOutput) {
                        if (getStickersOutput != null) {
                            GetStickersOutput trendStickerSetObject = keyValueStorageHelper.getTrendStickerSetObject();
                            if (trendStickerSetObject != null && trendStickerSetObject.sticker_sets != null) {
                                if (getStickersOutput.sticker_sets == null) {
                                    getStickersOutput.sticker_sets = new ArrayList<>();
                                }
                                getStickersOutput.sticker_sets.addAll(0, trendStickerSetObject.sticker_sets);
                            }
                            keyValueStorageHelper.setLastUpdatedTrendStickerSet(getStickersOutput, System.currentTimeMillis());
                            LoadListener loadListener2 = loadListener;
                            if (loadListener2 != null) {
                                loadListener2.onDidLoad(getStickersOutput);
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
                return;
            } catch (Exception e) {
                this.coreLog.handleException(e);
                if (loadListener != null) {
                    loadListener.onError(e);
                    return;
                }
                return;
            }
        }
        GetStickersOutput trendStickerSetObject = keyValueStorageHelper.getTrendStickerSetObject();
        if (loadListener != null) {
            if (trendStickerSetObject != null) {
                loadListener.onDidLoad(trendStickerSetObject);
            } else {
                loadListener.onError(new Exception());
            }
        }
    }

    public void getMyArchivedStickerSets(String str, String str2, String str3, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, final LoadListener<GetStickersOutput> loadListener) {
        GetStickersInput getStickersInput = new GetStickersInput();
        if (str == null || str.isEmpty()) {
            str = null;
        }
        getStickersInput.start_id = str;
        if (str2 == null || str2.isEmpty()) {
            str2 = null;
        }
        getStickersInput.search_text = str2;
        try {
            networkHelper.getMyArchivedStickerSets(str3, getStickersInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetStickersOutput>(this) { // from class: ir.aaap.messengercore.MessageUtils.44
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetStickersOutput getStickersOutput) {
                    if (getStickersOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(getStickersOutput);
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
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public int searchStickerSets(String str, String str2, String str3, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, final LoadListener<GetStickersOutput> loadListener) {
        GetStickersInput getStickersInput = new GetStickersInput();
        if (str == null || str.isEmpty()) {
            str = null;
        }
        getStickersInput.start_id = str;
        if (str2 == null || str2.isEmpty()) {
            str2 = null;
        }
        getStickersInput.search_text = str2;
        try {
            return networkHelper.searchStickers(str3, getStickersInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetStickersOutput>(this) { // from class: ir.aaap.messengercore.MessageUtils.45
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetStickersOutput getStickersOutput) {
                    if (getStickersOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(getStickersOutput);
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
            this.coreLog.handleException(e);
            if (loadListener == null) {
                return 0;
            }
            loadListener.onError(e);
            return 0;
        }
    }

    public void getStickersByEmoji(String str, String str2, SettingModels.StickerSettingObject.SuggestTypeEnum suggestTypeEnum, String str3, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, final LoadListener<GetStickersByEmojiOutput> loadListener) {
        if (str2 == null || str2.isEmpty()) {
            if (loadListener != null) {
                loadListener.onError(new InputException());
                return;
            }
            return;
        }
        GetStickersByEmojiInput getStickersByEmojiInput = new GetStickersByEmojiInput();
        if (str == null || str.isEmpty()) {
            str = null;
        }
        getStickersByEmojiInput.start_id = str;
        getStickersByEmojiInput.emoji_character = str2;
        getStickersByEmojiInput.suggest_by = suggestTypeEnum;
        try {
            networkHelper.getStickersByEmoji(str3, getStickersByEmojiInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetStickersByEmojiOutput>(this) { // from class: ir.aaap.messengercore.MessageUtils.46
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetStickersByEmojiOutput getStickersByEmojiOutput) {
                    if (getStickersByEmojiOutput != null) {
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(getStickersByEmojiOutput);
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
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public void reorderStickerSets(final ArrayList<String> arrayList, String str, NetworkHelper networkHelper, DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final KeyValueStorageHelper keyValueStorageHelper) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ReorderStickerSetsInput reorderStickerSetsInput = new ReorderStickerSetsInput();
        reorderStickerSetsInput.ordered_sticker_set_ids = arrayList;
        try {
            networkHelper.reorderStickerSets(str, reorderStickerSetsInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<ReorderStickerSetsOutput>() { // from class: ir.aaap.messengercore.MessageUtils.47
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onError(Exception exc) {
                }

                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(ReorderStickerSetsOutput reorderStickerSetsOutput) {
                    synchronized (MessageUtils.this.stickerLock) {
                        MessageUtils.this.myStickerSetsOrder.clear();
                        MessageUtils.this.myStickerSetsOrder.addAll(arrayList);
                        keyValueStorageHelper.setMyStickersOrder(MessageUtils.this.myStickerSetsOrder);
                    }
                    absNotificationCenter.myStickersDidLoad();
                }
            });
        } catch (Exception e) {
            this.coreLog.handleException(e);
        }
    }

    public void removeStickerSet(String str, String str2, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, KeyValueStorageHelper keyValueStorageHelper, LoadListener<ActionOnStickersOutput.StickerStateEnum> loadListener) {
        actionOnStickerSet(str, ActionOnStickersInput.ActionOnStickersEnum.Remove, str2, networkHelper, dBHelper, absNotificationCenter, keyValueStorageHelper, loadListener);
    }

    public void addStickerSet(String str, String str2, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, KeyValueStorageHelper keyValueStorageHelper, LoadListener<ActionOnStickersOutput.StickerStateEnum> loadListener) {
        actionOnStickerSet(str, ActionOnStickersInput.ActionOnStickersEnum.Add, str2, networkHelper, dBHelper, absNotificationCenter, keyValueStorageHelper, loadListener);
    }

    public int getMapView(LocationObject locationObject, String str, NetworkHelper networkHelper, final LoadListener<MapViewObject> loadListener) {
        if (locationObject == null) {
            return 0;
        }
        GetMapViewInput getMapViewInput = new GetMapViewInput();
        getMapViewInput.location = locationObject;
        try {
            return networkHelper.getMapView(str, getMapViewInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetMapViewOutput>(this) { // from class: ir.aaap.messengercore.MessageUtils.48
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetMapViewOutput getMapViewOutput) {
                    MapViewObject mapViewObject;
                    LoadListener loadListener2;
                    if (getMapViewOutput == null || (mapViewObject = getMapViewOutput.map_view) == null || (loadListener2 = loadListener) == null) {
                        return;
                    }
                    loadListener2.onDidLoad(mapViewObject);
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
            e.printStackTrace();
            if (loadListener != null) {
                loadListener.onError(e);
            }
            return 0;
        }
    }

    public void archiveStickerSet(String str, String str2, NetworkHelper networkHelper, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, KeyValueStorageHelper keyValueStorageHelper, LoadListener<ActionOnStickersOutput.StickerStateEnum> loadListener) {
        actionOnStickerSet(str, ActionOnStickersInput.ActionOnStickersEnum.Archive, str2, networkHelper, dBHelper, absNotificationCenter, keyValueStorageHelper, loadListener);
    }

    private void actionOnStickerSet(final String str, ActionOnStickersInput.ActionOnStickersEnum actionOnStickersEnum, final String str2, final NetworkHelper networkHelper, final DBHelper dBHelper, final AbsNotificationCenter absNotificationCenter, final KeyValueStorageHelper keyValueStorageHelper, final LoadListener<ActionOnStickersOutput.StickerStateEnum> loadListener) {
        try {
            networkHelper.actionOnStickerSet(str2, new ActionOnStickersInput(str, actionOnStickersEnum), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<ActionOnStickersOutput>() { // from class: ir.aaap.messengercore.MessageUtils.49
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(ActionOnStickersOutput actionOnStickersOutput) {
                    ActionOnStickersOutput.StickerStateEnum stickerStateEnum;
                    boolean z;
                    if (actionOnStickersOutput != null && (stickerStateEnum = actionOnStickersOutput.new_state) != null) {
                        boolean z2 = true;
                        if (stickerStateEnum == ActionOnStickersOutput.StickerStateEnum.Active) {
                            Iterator it = MessageUtils.this.myStickerSetsOrder.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    z = true;
                                    break;
                                } else if (((String) it.next()).equals(str)) {
                                    z = false;
                                    break;
                                }
                            }
                            if (z) {
                                synchronized (MessageUtils.this.stickerLock) {
                                    MessageUtils.this.myStickerSetsOrder.add(0, str);
                                    keyValueStorageHelper.setMyStickersOrder(MessageUtils.this.myStickerSetsOrder);
                                }
                                GetStickerSetByIdOutput getStickerSetByIdOutput = new GetStickerSetByIdOutput();
                                getStickerSetByIdOutput.sticker_set = MessageUtils.this.getStickerSetByIdInstant(str);
                                getStickerSetByIdOutput.stickers = MessageUtils.this.getStickersBySetIdInstant(str);
                                dBHelper.addMyStickerSet(getStickerSetByIdOutput);
                                MessageUtils.this.initAndLoadMyStickersIfNeeded(true, str2, networkHelper, dBHelper, absNotificationCenter, keyValueStorageHelper);
                            }
                        }
                        ActionOnStickersOutput.StickerStateEnum stickerStateEnum2 = actionOnStickersOutput.new_state;
                        if (stickerStateEnum2 == ActionOnStickersOutput.StickerStateEnum.Removed || stickerStateEnum2 == ActionOnStickersOutput.StickerStateEnum.Archived) {
                            synchronized (MessageUtils.this.stickerLock) {
                                Iterator it2 = MessageUtils.this.myStickerSetsOrder.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        z2 = false;
                                        break;
                                    } else if (((String) it2.next()).equals(str)) {
                                        MessageUtils.this.myStickerSetsOrder.remove(str);
                                        dBHelper.removeMyStickerSet(str);
                                        break;
                                    }
                                }
                                if (z2) {
                                    keyValueStorageHelper.setMyStickersOrder(MessageUtils.this.myStickerSetsOrder);
                                }
                            }
                            if (z2) {
                                MessageUtils.this.initAndLoadMyStickersIfNeeded(true, str2, networkHelper, dBHelper, absNotificationCenter, keyValueStorageHelper);
                            }
                        }
                        LoadListener loadListener2 = loadListener;
                        if (loadListener2 != null) {
                            loadListener2.onDidLoad(actionOnStickersOutput.new_state);
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
            this.coreLog.handleException(e);
            if (loadListener != null) {
                loadListener.onError(e);
            }
        }
    }

    public int searchGlobalMessagesText(String str, String str2, String str3, NetworkHelper networkHelper, DBHelper dBHelper, LoadListener<SearchGlobalMessagesOutput> loadListener) {
        return searchGlobalMessages(str, str2, SearchChatMessagesInput.SearchMessageTypeEnum.Text, str3, networkHelper, dBHelper, loadListener);
    }

    public int searchGlobalMessagesHashtag(String str, String str2, String str3, NetworkHelper networkHelper, DBHelper dBHelper, LoadListener<SearchGlobalMessagesOutput> loadListener) {
        return searchGlobalMessages(str, str2, SearchChatMessagesInput.SearchMessageTypeEnum.Hashtag, str3, networkHelper, dBHelper, loadListener);
    }

    private int searchGlobalMessages(String str, String str2, SearchChatMessagesInput.SearchMessageTypeEnum searchMessageTypeEnum, String str3, NetworkHelper networkHelper, DBHelper dBHelper, final LoadListener<SearchGlobalMessagesOutput> loadListener) {
        SearchGlobalMessagesInput searchGlobalMessagesInput = new SearchGlobalMessagesInput();
        searchGlobalMessagesInput.search_text = str;
        searchGlobalMessagesInput.start_id = str2;
        searchGlobalMessagesInput.type = searchMessageTypeEnum;
        int i = this.lastSearchGlobalReqID;
        if (i != 0) {
            networkHelper.cancelCall(i);
        }
        this.lastSearchGlobalReqID = 0;
        try {
            this.lastSearchGlobalReqID = networkHelper.searchGlobalMessages(str3, searchGlobalMessagesInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SearchGlobalMessagesOutput>(this) { // from class: ir.aaap.messengercore.MessageUtils.50
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SearchGlobalMessagesOutput searchGlobalMessagesOutput) {
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(searchGlobalMessagesOutput);
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
        return this.lastSearchGlobalReqID;
    }

    public int searchChatMessagesText(String str, String str2, String str3, NetworkHelper networkHelper, DBHelper dBHelper, LoadListener<SearchChatMessagesResult> loadListener) {
        return searchChatMessages(str, str2, SearchChatMessagesInput.SearchMessageTypeEnum.Text, str3, networkHelper, dBHelper, loadListener);
    }

    public int searchChatMessagesHashtag(String str, String str2, String str3, NetworkHelper networkHelper, DBHelper dBHelper, LoadListener<SearchChatMessagesResult> loadListener) {
        return searchChatMessages(str, str2, SearchChatMessagesInput.SearchMessageTypeEnum.Hashtag, str3, networkHelper, dBHelper, loadListener);
    }

    private int searchChatMessages(final String str, String str2, SearchChatMessagesInput.SearchMessageTypeEnum searchMessageTypeEnum, final String str3, final NetworkHelper networkHelper, final DBHelper dBHelper, final LoadListener<SearchChatMessagesResult> loadListener) {
        SearchChatMessagesInput searchChatMessagesInput = new SearchChatMessagesInput();
        searchChatMessagesInput.search_text = str2;
        searchChatMessagesInput.object_guid = str;
        searchChatMessagesInput.type = searchMessageTypeEnum;
        int i = this.lastSearchChatMessageReqID;
        if (i != 0) {
            networkHelper.cancelCall(i);
        }
        this.lastSearchChatMessageReqID = 0;
        try {
            this.lastSearchChatMessageReqID = networkHelper.searchChatMessages(str3, searchChatMessagesInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<SearchChatMessagesOutput>() { // from class: ir.aaap.messengercore.MessageUtils.51
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(SearchChatMessagesOutput searchChatMessagesOutput) {
                    final SearchChatMessagesResult searchChatMessagesResult = new SearchChatMessagesResult();
                    searchChatMessagesResult.messageIds = searchChatMessagesOutput.message_ids;
                    searchChatMessagesResult.messages = new HashMap();
                    ArrayList<Long> arrayList = searchChatMessagesOutput.message_ids;
                    if (arrayList != null && arrayList.size() > 0) {
                        MessageUtils.this.loadMessagesById(str, searchChatMessagesOutput.message_ids, str3, networkHelper, dBHelper, new LoadListener<Map<Long, Message>>() { // from class: ir.aaap.messengercore.MessageUtils.51.1
                            @Override // ir.aaap.messengercore.LoadListener
                            public void onDidLoad(Map<Long, Message> map) {
                                if (map != null) {
                                    searchChatMessagesResult.messages.putAll(map);
                                }
                                LoadListener loadListener2 = loadListener;
                                if (loadListener2 != null) {
                                    loadListener2.onDidLoad(searchChatMessagesResult);
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
                        return;
                    }
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(searchChatMessagesResult);
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
        return this.lastSearchChatMessageReqID;
    }

    public ArrayList<StickerObject> getRecentStickersInstant(DBHelper dBHelper) {
        return dBHelper.getRecentStickers();
    }

    public ArrayList<StickerObject> getFavoriteStickersInstant(DBHelper dBHelper) {
        return dBHelper.getFavoriteStickers();
    }

    public void addRecentSticker(ArrayList<StickerObject> arrayList, long j, boolean z, DBHelper dBHelper) {
        if (z) {
            removeAllRecentSticker(dBHelper);
        }
        dBHelper.addAllRecentSticker(arrayList, j);
    }

    public void addFavoriteSticker(ArrayList<StickerObject> arrayList, long j, boolean z, DBHelper dBHelper) {
        if (z) {
            removeAllFavoriteSticker(dBHelper);
        }
        dBHelper.addAllFavoriteSticker(arrayList, j);
    }

    public void removeAllRecentSticker(DBHelper dBHelper) {
        dBHelper.removeAllRecentSticker();
    }

    public void removeAllFavoriteSticker(DBHelper dBHelper) {
        dBHelper.removeAllFavoriteSticker();
    }

    public void removeFavoriteSticker(String str, DBHelper dBHelper) {
        dBHelper.removeFavoriteSticker(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStickersToMap(HashMap<String, ArrayList<StickerObject>> map) {
        synchronized (this.stickerLock) {
            this.stickerBySetIdMap.putAll(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStickerSetToMap(StickerSetObject stickerSetObject) {
        synchronized (this.stickerLock) {
            this.stickerSetObjectMap.put(stickerSetObject.sticker_set_id, stickerSetObject);
        }
    }

    public ArrayList<StickerSetObject> getMyStickerSetInstant() {
        ArrayList<StickerSetObject> arrayList = new ArrayList<>();
        synchronized (this.stickerLock) {
            ArrayList<String> arrayList2 = this.myStickerSetsOrder;
            if (arrayList2 != null && arrayList2.size() != 0) {
                Iterator<String> it = this.myStickerSetsOrder.iterator();
                while (it.hasNext()) {
                    StickerSetObject stickerSetObject = this.stickerSetObjectMap.get(it.next());
                    if (stickerSetObject != null) {
                        arrayList.add(stickerSetObject);
                    }
                }
                return arrayList;
            }
            return arrayList;
        }
    }

    public ArrayList<StickerObject> getStickersBySetIdInstant(String str) {
        return this.stickerBySetIdMap.get(str);
    }

    public StickerSetObject getStickerSetByIdInstant(String str) {
        return this.stickerSetObjectMap.get(str);
    }

    public void addToMyGifSet(String str, long j, final FileInlineObject fileInlineObject, String str2, NetworkHelper networkHelper, final DBHelper dBHelper, final LoadListener<Integer> loadListener) {
        if (fileInlineObject == null || fileInlineObject.type != FileInlineObject.FileInlineType.Gif) {
            return;
        }
        AddToMyGifSetInput addToMyGifSetInput = new AddToMyGifSetInput();
        addToMyGifSetInput.message_id = String.valueOf(j);
        addToMyGifSetInput.object_guid = str;
        try {
            networkHelper.addToMyGifSet(str2, addToMyGifSetInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<AddToMyGifSetOutput>() { // from class: ir.aaap.messengercore.MessageUtils.52
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(AddToMyGifSetOutput addToMyGifSetOutput) {
                    MessageUtils.this.addOrUpdateRecentGif(fileInlineObject, System.currentTimeMillis(), dBHelper);
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

    public void removeFromMyGifSet(final long j, String str, NetworkHelper networkHelper, final DBHelper dBHelper, final LoadListener<Integer> loadListener) {
        RemoveFromMyGifSetInput removeFromMyGifSetInput = new RemoveFromMyGifSetInput();
        removeFromMyGifSetInput.file_id = String.valueOf(j);
        try {
            networkHelper.removeFromMyGifSet(str, removeFromMyGifSetInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<RemoveFromMyGifSetOutput>() { // from class: ir.aaap.messengercore.MessageUtils.53
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(RemoveFromMyGifSetOutput removeFromMyGifSetOutput) {
                    MessageUtils.this.removeRecentGif(j, dBHelper);
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

    public void addOrUpdateRecentGif(FileInlineObject fileInlineObject, long j, DBHelper dBHelper) {
        if (fileInlineObject == null) {
            return;
        }
        dBHelper.addRecentGif(fileInlineObject, j);
        addOrUpdateRecentGifArray(fileInlineObject);
    }

    public void removeRecentGif(long j, DBHelper dBHelper) {
        dBHelper.removeGif(String.valueOf(j));
        removeFromRecentGifArray(j);
    }

    private void addOrUpdateRecentGifArray(FileInlineObject fileInlineObject) {
        if (fileInlineObject == null || fileInlineObject.type != FileInlineObject.FileInlineType.Gif) {
            return;
        }
        synchronized (this.gifLock) {
            Iterator<FileInlineObject> it = this.recentGifArray.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                FileInlineObject next = it.next();
                if (fileInlineObject.file_id == next.file_id) {
                    this.recentGifArray.remove(next);
                    break;
                }
            }
            this.recentGifArray.add(fileInlineObject);
        }
    }

    private void removeFromRecentGifArray(long j) {
        if (j == 0) {
            return;
        }
        synchronized (this.gifLock) {
            Iterator<FileInlineObject> it = this.recentGifArray.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                FileInlineObject next = it.next();
                if (j == next.file_id) {
                    this.recentGifArray.remove(next);
                    break;
                }
            }
        }
    }

    public void initAndLoadMyGifSetIfNeeded(boolean z, String str, NetworkHelper networkHelper, DBHelper dBHelper, KeyValueStorageHelper keyValueStorageHelper, final LoadListener<ArrayList<FileInlineObject>> loadListener) {
        boolean z2 = System.currentTimeMillis() - keyValueStorageHelper.getLastUpdatedGifTime() >= 3600000;
        LoadListener<ArrayList<FileInlineObject>> loadListener2 = new LoadListener<ArrayList<FileInlineObject>>() { // from class: ir.aaap.messengercore.MessageUtils.54
            @Override // ir.aaap.messengercore.LoadListener
            public void onError(Exception exc) {
            }

            @Override // ir.aaap.messengercore.LoadListener
            public void onDidLoad(ArrayList<FileInlineObject> arrayList) {
                synchronized (MessageUtils.this.gifLock) {
                    MessageUtils.this.recentGifArray.clear();
                    if (arrayList != null) {
                        MessageUtils.this.recentGifArray.addAll(arrayList);
                    }
                }
                LoadListener loadListener3 = loadListener;
                if (loadListener3 != null) {
                    loadListener3.onDidLoad(arrayList);
                }
            }
        };
        getAllRecentGifFromDB(dBHelper, loadListener2);
        if (z2 || z) {
            getAllRecentGifFromServer(str, networkHelper, dBHelper, keyValueStorageHelper, loadListener2);
        }
    }

    private void getAllRecentGifFromDB(DBHelper dBHelper, LoadListener<ArrayList<FileInlineObject>> loadListener) {
        ArrayList<FileInlineObject> allRecentGif = dBHelper.getAllRecentGif();
        if (loadListener != null) {
            loadListener.onDidLoad(allRecentGif);
        }
    }

    private void getAllRecentGifFromServer(String str, NetworkHelper networkHelper, final DBHelper dBHelper, final KeyValueStorageHelper keyValueStorageHelper, final LoadListener<ArrayList<FileInlineObject>> loadListener) {
        try {
            networkHelper.getMyGifSet(str, new GetMyGifSetInput(), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetMyGifSetOutput>(this) { // from class: ir.aaap.messengercore.MessageUtils.55
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetMyGifSetOutput getMyGifSetOutput) {
                    if (getMyGifSetOutput != null) {
                        keyValueStorageHelper.setLastUpdatedGifTime(System.currentTimeMillis());
                    }
                    if (getMyGifSetOutput != null && getMyGifSetOutput.gifs != null) {
                        dBHelper.removeAllGif();
                        dBHelper.addAllRecentGif(getMyGifSetOutput.gifs, System.currentTimeMillis());
                    }
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(getMyGifSetOutput.gifs);
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

    public void processMessageUpdate(ArrayList<MessageUpdateObject> arrayList, boolean z, AbsNotificationCenter absNotificationCenter, DBHelper dBHelper, KeyValueStorageHelper keyValueStorageHelper, LoadListener<Integer> loadListener, UpdateMessageUsecase updateMessageUsecase, boolean z2) {
        HashMap map;
        Integer num;
        UpdateMessageUsecase updateMessageUsecase2;
        HashMap map2;
        DBHelper dBHelper2;
        MessageUpdateResult messageUpdateResultProcessMessageUpdateEdit;
        Set<MessageParamUpdateTimeObject.UpdateParameterEnum> set;
        ArrayList<Message> arrayList2;
        MessageUpdateObject messageUpdateObject;
        DBHelper dBHelper3 = dBHelper;
        KeyValueStorageHelper keyValueStorageHelper2 = keyValueStorageHelper;
        LoadListener<Integer> loadListener2 = loadListener;
        UpdateMessageUsecase updateMessageUsecase3 = updateMessageUsecase;
        boolean z3 = z2;
        Integer num2 = 1;
        if (arrayList == null || arrayList.size() == 0) {
            if (loadListener2 != null) {
                loadListener2.onDidLoad(num2);
                return;
            }
            return;
        }
        HashMap map3 = new HashMap();
        new HashMap();
        new HashMap();
        HashMap map4 = new HashMap();
        Iterator<MessageUpdateObject> it = arrayList.iterator();
        while (it.hasNext()) {
            MessageUpdateObject next = it.next();
            long messagesStateTimeStamp = keyValueStorageHelper2.getMessagesStateTimeStamp(next.object_guid);
            if (!z || next.timestamp >= messagesStateTimeStamp) {
                MessageUpdateObject.Action action = next.action;
                if (action == MessageUpdateObject.Action.Delete) {
                    removeFromMessageMap(Long.valueOf(next.message_id));
                    dBHelper.setMessageDeleted(next.object_guid, next.message_id, next.timestamp);
                    if (updateMessageUsecase3 != null) {
                        ArrayList<Long> arrayList3 = new ArrayList<>();
                        arrayList3.add(Long.valueOf(next.message_id));
                        updateMessageUsecase3.onMessagesDeleted(next.object_guid, next.type, arrayList3, z3);
                    }
                    map = map3;
                    num = num2;
                    updateMessageUsecase2 = updateMessageUsecase3;
                    map2 = map4;
                    dBHelper2 = dBHelper3;
                } else {
                    if (action == MessageUpdateObject.Action.New) {
                        if (next.message != null && dBHelper3.getMessageById(next.object_guid, next.message_id) == null && dBHelper3.isMessageIdInDb(next.object_guid, null, next.prev_message_id)) {
                            String messagesState = keyValueStorageHelper2.getMessagesState(next.object_guid);
                            if ((messagesState == null || messagesState.isEmpty()) && CoreUtilities.isNotEmpty(next.state)) {
                                keyValueStorageHelper2.setMessagesState(next.object_guid, next.state, 0L);
                            }
                            ArrayList<Message> arrayList4 = new ArrayList<>();
                            arrayList4.add(next.message);
                            fillMessageAttribute(arrayList4, next.timestamp);
                            String str = next.object_guid;
                            long j = next.prev_message_id;
                            long j2 = next.message.message_id;
                            HashMap map5 = map4;
                            HashMap map6 = map3;
                            num = num2;
                            LoadListener<Integer> loadListener3 = loadListener2;
                            UpdateMessageUsecase updateMessageUsecase4 = updateMessageUsecase3;
                            dBHelper.addAllMessagesAndFillHoles(str, arrayList4, j, j2, null, next.timestamp, j2);
                            if (updateMessageUsecase4 != null) {
                                ArrayList<Message> arrayList5 = new ArrayList<>();
                                messageUpdateObject = next;
                                arrayList5.add(messageUpdateObject.message);
                                map = map6;
                                updateMessageUsecase2 = updateMessageUsecase4;
                                loadListener2 = loadListener3;
                                arrayList2 = arrayList4;
                                updateMessageUsecase.onMessagesAdded(messageUpdateObject.object_guid, messageUpdateObject.type, arrayList5, true, z2);
                            } else {
                                map = map6;
                                updateMessageUsecase2 = updateMessageUsecase4;
                                loadListener2 = loadListener3;
                                arrayList2 = arrayList4;
                                messageUpdateObject = next;
                            }
                            ObjectGuidType objectGuidType = new ObjectGuidType(messageUpdateObject.object_guid, messageUpdateObject.type);
                            map2 = map5;
                            ArrayList<Message> arrayList6 = map2.get(objectGuidType);
                            if (arrayList6 == null) {
                                arrayList6 = new ArrayList<>();
                                map2.put(objectGuidType, arrayList2);
                            }
                            arrayList6.add(messageUpdateObject.message);
                        }
                    } else {
                        map = map3;
                        num = num2;
                        updateMessageUsecase2 = updateMessageUsecase3;
                        map2 = map4;
                        if (action == MessageUpdateObject.Action.Edit) {
                            removeFromMessageMap(Long.valueOf(next.message_id));
                            dBHelper2 = dBHelper;
                            Message messageById = dBHelper2.getMessageById(next.object_guid, next.message_id);
                            if (messageById != null && (messageUpdateResultProcessMessageUpdateEdit = processMessageUpdateEdit(messageById, next, next.timestamp, absNotificationCenter)) != null && (set = messageUpdateResultProcessMessageUpdateEdit.updatedParametersForDatabase) != null && set.size() > 0) {
                                ArrayList<MessageUpdateResult> arrayList7 = map.get(next.object_guid);
                                if (arrayList7 == null) {
                                    arrayList7 = new ArrayList<>();
                                    map.put(next.object_guid, arrayList7);
                                }
                                arrayList7.add(messageUpdateResultProcessMessageUpdateEdit);
                            }
                        }
                    }
                    dBHelper2 = dBHelper;
                }
                keyValueStorageHelper2 = keyValueStorageHelper;
                dBHelper3 = dBHelper2;
                map4 = map2;
                map3 = map;
                updateMessageUsecase3 = updateMessageUsecase2;
                num2 = num;
                z3 = z2;
            }
        }
        HashMap map7 = map3;
        Integer num3 = num2;
        UpdateMessageUsecase updateMessageUsecase5 = updateMessageUsecase3;
        HashMap map8 = map4;
        DBHelper dBHelper4 = dBHelper3;
        if (map7.size() > 0) {
            dBHelper4.updateMessageParameter(map7);
            if (updateMessageUsecase5 != null) {
                for (String str2 : map7.keySet()) {
                    ArrayList<MessageUpdateResult> arrayList8 = map7.get(str2);
                    if (arrayList8.size() > 0) {
                        updateMessageUsecase5.onMessagesUpdated(str2, arrayList8.get(0).chatType, arrayList8, z2);
                    }
                }
            }
        }
        if (map8.size() > 0) {
            absNotificationCenter.onUpdateShowActivitiesWithNewMessages(map8);
        }
        if (loadListener2 != null) {
            loadListener2.onDidLoad(num3);
        }
    }

    MessageUpdateResult processMessageUpdateEdit(Message message, MessageUpdateObject messageUpdateObject, long j, AbsNotificationCenter absNotificationCenter) {
        MessageUpdateResult messageUpdateResultCreateFromMessageUpdateObject = MessageUpdateResult.createFromMessageUpdateObject(messageUpdateObject);
        HashSet hashSet = new HashSet();
        if (j < message.getUpdateTimestamp()) {
            return messageUpdateResultCreateFromMessageUpdateObject;
        }
        Message message2 = messageUpdateObject.message;
        Iterator<MessageParamUpdateTimeObject.UpdateParameterEnum> it = messageUpdateObject.updated_parameters.iterator();
        while (it.hasNext()) {
            MessageParamUpdateTimeObject.UpdateParameterEnum next = it.next();
            if (j > message.getUpdateTimestamp(next)) {
                hashSet.add(next);
                message.setParamUpdateTime(next, j);
                if (next == MessageParamUpdateTimeObject.UpdateParameterEnum.text) {
                    message.text = message2.text;
                } else if (next == MessageParamUpdateTimeObject.UpdateParameterEnum.type) {
                    message.type = message2.type;
                } else if (next == MessageParamUpdateTimeObject.UpdateParameterEnum.inline_keypad) {
                    message.inline_keypad = message2.inline_keypad;
                } else if (next == MessageParamUpdateTimeObject.UpdateParameterEnum.metadata) {
                    message.metadata = message2.metadata;
                } else if (next == MessageParamUpdateTimeObject.UpdateParameterEnum.is_edited) {
                    message.is_edited = message2.is_edited;
                } else if (next == MessageParamUpdateTimeObject.UpdateParameterEnum.message_call) {
                    message.message_call = message2.message_call;
                } else if (next == MessageParamUpdateTimeObject.UpdateParameterEnum.is_banned) {
                    message.is_banned = message2.is_banned;
                }
            }
        }
        messageUpdateResultCreateFromMessageUpdateObject.message = message;
        messageUpdateResultCreateFromMessageUpdateObject.updatedParametersForDatabase = hashSet;
        return messageUpdateResultCreateFromMessageUpdateObject;
    }

    public void updateMessageRubinoStory(String str, long j, RubinoStoryData rubinoStoryData, DBHelper dBHelper) {
        if (j <= 0 || !CoreUtilities.isNotEmpty(str)) {
            return;
        }
        Message message = this.messagesMap.get(Long.valueOf(j));
        if (message != null) {
            message.rubino_story_data = rubinoStoryData;
        }
        dBHelper.updateMessageRubinoStory(str, j, rubinoStoryData);
    }

    public void updateMessageRubinoPost(String str, long j, RubinoPostData rubinoPostData, DBHelper dBHelper) {
        if (j <= 0 || !CoreUtilities.isNotEmpty(str)) {
            return;
        }
        Message message = this.messagesMap.get(Long.valueOf(j));
        if (message != null) {
            message.rubino_post_data = rubinoPostData;
        }
        dBHelper.updateMessageRubinoPost(str, j, rubinoPostData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkGroupedImages(ArrayList<Message> arrayList) {
        long j;
        long jGenerateNewGroupId;
        int i;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        long j2 = 0;
        int i2 = 0;
        long j3 = -1;
        int i3 = 0;
        String str = null;
        String str2 = null;
        boolean z = true;
        long j4 = -1;
        while (i2 < arrayList.size()) {
            try {
                Message message = arrayList.get(i2);
                String fromGuid = getFromGuid(message);
                Message.ForwardFromObject forwardFromObject = message.forwarded_from;
                String str3 = forwardFromObject != null ? forwardFromObject.object_guid : null;
                FileInlineObject fileInlineObject = message.file_inline;
                if (!((fileInlineObject == null || fileInlineObject.type != FileInlineObject.FileInlineType.Image || CoreUtilities.isNotEmpty(message.text)) ? false : true)) {
                    fromGuid = null;
                    str3 = null;
                    i3 = 0;
                    j = -1;
                    z = true;
                    j4 = -1;
                } else if (i3 >= 12 || ((j3 != -1 && Math.abs(message.time - j3) > 60) || ((str != null && !str.equals(fromGuid)) || (((str2 != null || !z) && ((str3 != null || str2 != null) && (str3 == null || !str3.equals(str2)))) || message.reply_to_message_id != j2 || j4 == -1)))) {
                    jGenerateNewGroupId = generateNewGroupId(false);
                    i = 1;
                    i3 = 0;
                    i3 += i;
                    j = message.time;
                    message.groupId = jGenerateNewGroupId;
                    j4 = jGenerateNewGroupId;
                    j2 = message.reply_to_message_id;
                    z = false;
                } else {
                    jGenerateNewGroupId = j4;
                    i = 1;
                    i3 += i;
                    j = message.time;
                    message.groupId = jGenerateNewGroupId;
                    j4 = jGenerateNewGroupId;
                    j2 = message.reply_to_message_id;
                    z = false;
                }
                i2++;
                j3 = j;
                str = fromGuid;
                str2 = str3;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private String getFromGuid(Message message) {
        if (message == null) {
            return null;
        }
        return message.author_object_guid;
    }

    public long generateNewGroupId() {
        return generateNewGroupId(false);
    }

    private long generateNewGroupId(boolean z) {
        long j;
        synchronized (this.groupIdLock) {
            if (z) {
                this.lastGroupId = 0;
            } else {
                this.lastGroupId++;
            }
            j = this.lastGroupId;
        }
        return j;
    }

    public class GetMessagesByIdHelper {
        String auth;
        String chatGuid;
        DBHelper dbHelper;
        LoadListener<HashMap<Long, Message>> loadListener;
        NetworkHelper networkHelper;
        HashMap<Long, Message> result;
        ArrayList<Long> toSend;

        public GetMessagesByIdHelper(String str, NetworkHelper networkHelper, DBHelper dBHelper, LoadListener<HashMap<Long, Message>> loadListener) {
            this.loadListener = loadListener;
            this.auth = str;
            this.networkHelper = networkHelper;
            this.dbHelper = dBHelper;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getMessagesById(String str, Set<Long> set) {
            this.toSend = new ArrayList<>(set);
            this.result = new HashMap<>();
            this.chatGuid = str;
            getMessagesByIdLimited(0, Math.max(1, ((int) ((set.size() * 1.0f) / 20.0f)) * 2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void getMessagesByIdLimited(final int i, final int i2) {
            ArrayList<Long> arrayList;
            if (i2 < 0) {
                this.loadListener.onError(new Exception("recursive loop"));
                return;
            }
            if (i < this.toSend.size()) {
                int i3 = i + 20;
                if (this.toSend.size() >= i3) {
                    arrayList = new ArrayList<>(this.toSend.subList(i, i3));
                } else {
                    ArrayList<Long> arrayList2 = this.toSend;
                    arrayList = new ArrayList<>(arrayList2.subList(i, arrayList2.size()));
                }
                try {
                    final GetMessagesByIdInput getMessagesByIdInput = new GetMessagesByIdInput();
                    getMessagesByIdInput.object_guid = this.chatGuid;
                    getMessagesByIdInput.message_ids = arrayList;
                    this.networkHelper.getMessagesByID(this.auth, getMessagesByIdInput, RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetMessagesByIdOutput>() { // from class: ir.aaap.messengercore.MessageUtils.GetMessagesByIdHelper.1
                        @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                        public void onResponse(GetMessagesByIdOutput getMessagesByIdOutput) {
                            boolean z;
                            boolean z2;
                            Iterator<Long> it = getMessagesByIdInput.message_ids.iterator();
                            while (it.hasNext()) {
                                GetMessagesByIdHelper.this.result.put(it.next(), null);
                            }
                            ArrayList<Message> arrayList3 = getMessagesByIdOutput.messages;
                            if (arrayList3 != null) {
                                GetMessagesByIdHelper getMessagesByIdHelper = GetMessagesByIdHelper.this;
                                getMessagesByIdHelper.dbHelper.addAllMessages(getMessagesByIdHelper.chatGuid, arrayList3, getMessagesByIdOutput.timestamp);
                                MessageUtils.this.addToMessageMap(getMessagesByIdOutput.messages);
                                Iterator<Message> it2 = getMessagesByIdOutput.messages.iterator();
                                while (it2.hasNext()) {
                                    Message next = it2.next();
                                    GetMessagesByIdHelper.this.result.put(Long.valueOf(next.message_id), next);
                                }
                            }
                            ArrayList<Long> arrayList4 = getMessagesByIdInput.message_ids;
                            if (arrayList4 != null && arrayList4.size() > 0) {
                                Iterator<Long> it3 = getMessagesByIdInput.message_ids.iterator();
                                while (it3.hasNext()) {
                                    Long next2 = it3.next();
                                    ArrayList<Message> arrayList5 = getMessagesByIdOutput.messages;
                                    if (arrayList5 != null) {
                                        Iterator<Message> it4 = arrayList5.iterator();
                                        while (it4.hasNext()) {
                                            if (it4.next().message_id == next2.longValue()) {
                                                z2 = true;
                                                break;
                                            }
                                        }
                                        z2 = false;
                                    } else {
                                        z2 = false;
                                    }
                                    if (!z2) {
                                        GetMessagesByIdHelper getMessagesByIdHelper2 = GetMessagesByIdHelper.this;
                                        getMessagesByIdHelper2.dbHelper.setMessageDeleted(getMessagesByIdHelper2.chatGuid, next2.longValue(), getMessagesByIdOutput.timestamp);
                                    }
                                }
                            }
                            ArrayList<Long> arrayList6 = getMessagesByIdInput.message_ids;
                            if (arrayList6 != null && arrayList6.size() > 0) {
                                Iterator<Long> it5 = getMessagesByIdInput.message_ids.iterator();
                                while (it5.hasNext()) {
                                    Long next3 = it5.next();
                                    ArrayList<Message> arrayList7 = getMessagesByIdOutput.messages;
                                    if (arrayList7 != null) {
                                        Iterator<Message> it6 = arrayList7.iterator();
                                        while (it6.hasNext()) {
                                            if (it6.next().message_id == next3.longValue()) {
                                                z = true;
                                                break;
                                            }
                                        }
                                        z = false;
                                    } else {
                                        z = false;
                                    }
                                    if (!z) {
                                        GetMessagesByIdHelper getMessagesByIdHelper3 = GetMessagesByIdHelper.this;
                                        getMessagesByIdHelper3.dbHelper.setMessageDeleted(getMessagesByIdHelper3.chatGuid, next3.longValue(), getMessagesByIdOutput.timestamp);
                                    }
                                }
                            }
                            GetMessagesByIdHelper.this.getMessagesByIdLimited(i + 20, i2 - 1);
                        }

                        @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                        public void onError(Exception exc) {
                            LoadListener<HashMap<Long, Message>> loadListener = GetMessagesByIdHelper.this.loadListener;
                            if (loadListener != null) {
                                loadListener.onError(exc);
                            }
                        }
                    });
                    return;
                } catch (Exception e) {
                    MessageUtils.this.coreLog.handleException(e);
                    return;
                }
            }
            LoadListener<HashMap<Long, Message>> loadListener = this.loadListener;
            if (loadListener != null) {
                loadListener.onDidLoad(this.result);
            }
        }
    }

    private class LoadMessagesHelper {
        String auth;
        String chat_guid;
        DBHelper dbHelper;
        Object extraInfo;
        FilterTypeEnum filterType;
        boolean fromMin;
        KeyValueStorageHelper keyValueStorageHelper;
        long lastDeletedMid;
        long lastMessageId;
        int limit;
        LoadMessagesListener loadMessagesListener;
        LoadMessagesResult loadMessagesResult;
        NetworkHelper networkHelper;

        public LoadMessagesHelper(String str, NetworkHelper networkHelper, DBHelper dBHelper, KeyValueStorageHelper keyValueStorageHelper, String str2, ChatType chatType, FilterTypeEnum filterTypeEnum, boolean z, long j, long j2, int i, Object obj, LoadMessagesListener loadMessagesListener) {
            this.auth = str;
            this.networkHelper = networkHelper;
            this.dbHelper = dBHelper;
            this.keyValueStorageHelper = keyValueStorageHelper;
            this.chat_guid = str2;
            this.filterType = filterTypeEnum;
            this.fromMin = z;
            this.lastMessageId = j;
            this.lastDeletedMid = j2;
            this.limit = i;
            this.extraInfo = obj;
            this.loadMessagesListener = loadMessagesListener;
            LoadMessagesResult loadMessagesResult = new LoadMessagesResult();
            this.loadMessagesResult = loadMessagesResult;
            loadMessagesResult.chatId = str2;
            loadMessagesResult.chatType = chatType;
            loadMessagesResult.filterType = filterTypeEnum;
            loadMessagesResult.extraInfo = obj;
            loadMessagesResult.hasContinue = true;
        }

        public void loadMessages(long j, long j2) {
            LoadMessagesResult loadMessagesResult = this.loadMessagesResult;
            loadMessagesResult.maxId = j2;
            loadMessagesResult.minId = j;
            loadMessagesInner(j, j2, 300);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void loadMessagesInner(long j, long j2, final int i) {
            if (i <= 0) {
                LoadMessagesListener loadMessagesListener = this.loadMessagesListener;
                if (loadMessagesListener != null) {
                    loadMessagesListener.onMessagesDidLoad(this.loadMessagesResult);
                    return;
                }
                return;
            }
            ArrayList<Message> arrayList = this.loadMessagesResult.messages;
            if ((arrayList != null && arrayList.size() > 0) || !this.loadMessagesResult.hasContinue) {
                LoadMessagesListener loadMessagesListener2 = this.loadMessagesListener;
                if (loadMessagesListener2 != null) {
                    loadMessagesListener2.onMessagesDidLoad(this.loadMessagesResult);
                    return;
                }
                return;
            }
            GetMessagesResultInner messagesFromDB = MessageUtils.this.getMessagesFromDB(this.dbHelper, this.chat_guid, this.filterType, this.fromMin, j, j2, this.lastMessageId, this.lastDeletedMid, this.limit);
            if (messagesFromDB != null && messagesFromDB.isExistInDB) {
                LoadMessagesResult loadMessagesResult = this.loadMessagesResult;
                loadMessagesResult.isFromDb = true;
                loadMessagesResult.messages = messagesFromDB.messages;
                long j3 = messagesFromDB.newMinId;
                loadMessagesResult.newMinId = j3;
                long j4 = messagesFromDB.newMaxId;
                loadMessagesResult.newMaxId = j4;
                loadMessagesResult.hasContinue = messagesFromDB.hasContinue;
                if (this.fromMin) {
                    loadMessagesInner(j3, j2, i - 1);
                    return;
                } else {
                    loadMessagesInner(j, j4, i - 1);
                    return;
                }
            }
            this.loadMessagesResult.isFromDb = false;
            MessageUtils.this.getMessagesFromServer(this.auth, this.networkHelper, this.dbHelper, this.keyValueStorageHelper, this.chat_guid, this.filterType, j, j2, this.fromMin, this.limit, this.lastMessageId, new GetMessagesListener() { // from class: ir.aaap.messengercore.MessageUtils.LoadMessagesHelper.1
                @Override // ir.aaap.messengercore.MessageUtils.GetMessagesListener
                public void onResponse(GetMessagesResultInner getMessagesResultInner) {
                    LoadMessagesHelper loadMessagesHelper = LoadMessagesHelper.this;
                    LoadMessagesResult loadMessagesResult2 = loadMessagesHelper.loadMessagesResult;
                    loadMessagesResult2.messages = getMessagesResultInner.messages;
                    long j5 = getMessagesResultInner.newMinId;
                    loadMessagesResult2.newMinId = j5;
                    long j6 = getMessagesResultInner.newMaxId;
                    loadMessagesResult2.newMaxId = j6;
                    loadMessagesResult2.hasContinue = getMessagesResultInner.hasContinue;
                    loadMessagesHelper.loadMessagesInner(j5, j6, i - 1);
                }

                @Override // ir.aaap.messengercore.MessageUtils.GetMessagesListener
                public void onError(Exception exc) {
                    LoadMessagesHelper loadMessagesHelper = LoadMessagesHelper.this;
                    LoadMessagesListener loadMessagesListener3 = loadMessagesHelper.loadMessagesListener;
                    if (loadMessagesListener3 != null) {
                        loadMessagesListener3.onLoadingMessagesFailed(loadMessagesHelper.loadMessagesResult);
                    }
                }
            });
        }
    }
}
