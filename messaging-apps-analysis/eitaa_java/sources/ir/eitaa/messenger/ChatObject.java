package ir.eitaa.messenger;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import com.google.android.exoplayer2.util.Log;
import ir.eitaa.messenger.voip.VoIPService;
import ir.eitaa.tgnet.ConnectionsManager;
import ir.eitaa.tgnet.RequestDelegate;
import ir.eitaa.tgnet.TLObject;
import ir.eitaa.tgnet.TLRPC$Chat;
import ir.eitaa.tgnet.TLRPC$ChatFull;
import ir.eitaa.tgnet.TLRPC$ChatPhoto;
import ir.eitaa.tgnet.TLRPC$GroupCall;
import ir.eitaa.tgnet.TLRPC$InputPeer;
import ir.eitaa.tgnet.TLRPC$Peer;
import ir.eitaa.tgnet.TLRPC$TL_channel;
import ir.eitaa.tgnet.TLRPC$TL_channelForbidden;
import ir.eitaa.tgnet.TLRPC$TL_channel_layer48;
import ir.eitaa.tgnet.TLRPC$TL_channel_layer67;
import ir.eitaa.tgnet.TLRPC$TL_channel_layer72;
import ir.eitaa.tgnet.TLRPC$TL_channel_layer77;
import ir.eitaa.tgnet.TLRPC$TL_channel_layer92;
import ir.eitaa.tgnet.TLRPC$TL_channel_old;
import ir.eitaa.tgnet.TLRPC$TL_chat;
import ir.eitaa.tgnet.TLRPC$TL_chatAdminRights;
import ir.eitaa.tgnet.TLRPC$TL_chatBannedRights;
import ir.eitaa.tgnet.TLRPC$TL_chatEmpty;
import ir.eitaa.tgnet.TLRPC$TL_chatForbidden;
import ir.eitaa.tgnet.TLRPC$TL_chatPhotoEmpty;
import ir.eitaa.tgnet.TLRPC$TL_chat_layer92;
import ir.eitaa.tgnet.TLRPC$TL_chat_old;
import ir.eitaa.tgnet.TLRPC$TL_chat_old2;
import ir.eitaa.tgnet.TLRPC$TL_error;
import ir.eitaa.tgnet.TLRPC$TL_groupCallParticipant;
import ir.eitaa.tgnet.TLRPC$TL_groupCallParticipantVideo;
import ir.eitaa.tgnet.TLRPC$TL_groupCallParticipantVideoSourceGroup;
import ir.eitaa.tgnet.TLRPC$TL_inputGroupCall;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerChannel;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerChat;
import ir.eitaa.tgnet.TLRPC$TL_inputPeerUser;
import ir.eitaa.tgnet.TLRPC$TL_peerChannel;
import ir.eitaa.tgnet.TLRPC$TL_peerChat;
import ir.eitaa.tgnet.TLRPC$TL_peerUser;
import ir.eitaa.tgnet.TLRPC$TL_phone_editGroupCallTitle;
import ir.eitaa.tgnet.TLRPC$TL_phone_getGroupCall;
import ir.eitaa.tgnet.TLRPC$TL_phone_getGroupParticipants;
import ir.eitaa.tgnet.TLRPC$TL_phone_groupCall;
import ir.eitaa.tgnet.TLRPC$TL_phone_groupParticipants;
import ir.eitaa.tgnet.TLRPC$TL_phone_toggleGroupCallRecord;
import ir.eitaa.tgnet.TLRPC$TL_updateGroupCall;
import ir.eitaa.tgnet.TLRPC$TL_updateGroupCallParticipants;
import ir.eitaa.tgnet.TLRPC$Updates;
import ir.eitaa.tgnet.TLRPC$User;
import ir.eitaa.tgnet.TLRPC$UserFull;
import ir.eitaa.ui.GroupCallActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public class ChatObject {
    public static final int ACTION_ADD_ADMINS = 4;
    public static final int ACTION_BLOCK_USERS = 2;
    public static final int ACTION_CHANGE_INFO = 1;
    public static final int ACTION_DELETE_MESSAGES = 13;
    public static final int ACTION_EDIT_MESSAGES = 12;
    public static final int ACTION_EMBED_LINKS = 9;
    public static final int ACTION_INVITE = 3;
    public static final int ACTION_MANAGE_CALLS = 14;
    public static final int ACTION_PIN = 0;
    public static final int ACTION_POST = 5;
    public static final int ACTION_SEND = 6;
    public static final int ACTION_SEND_FORWARD = 15;
    public static final int ACTION_SEND_MEDIA = 7;
    public static final int ACTION_SEND_POLLS = 10;
    public static final int ACTION_SEND_STICKERS = 8;
    public static final int ACTION_VIEW = 11;
    public static final int CHAT_TYPE_CHANNEL = 2;
    public static final int CHAT_TYPE_CHAT = 0;
    public static final int CHAT_TYPE_MEGAGROUP = 4;
    public static final int CHAT_TYPE_USER = 3;
    private static final int MAX_PARTICIPANTS_COUNT = 5000;
    public static final int VIDEO_FRAME_HAS_FRAME = 2;
    public static final int VIDEO_FRAME_NO_FRAME = 0;
    public static final int VIDEO_FRAME_REQUESTING = 1;

    public static boolean canManageCalls(TLRPC$Chat chat) {
        return false;
    }

    private static boolean isAdminAction(int action) {
        return action == 0 || action == 1 || action == 2 || action == 3 || action == 4 || action == 5 || action == 12 || action == 13;
    }

    private static boolean isBannableAction(int action) {
        if (action != 0 && action != 1 && action != 3 && action != 15) {
            switch (action) {
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public static class Call {
        private static int videoPointer;
        public int activeVideos;
        public TLRPC$GroupCall call;
        public boolean canStreamVideo;
        public long chatId;
        private Runnable checkQueueRunnable;
        public AccountInstance currentAccount;
        private long lastGroupCallReloadTime;
        private int lastLoadGuid;
        private boolean loadingGroupCall;
        public boolean loadingMembers;
        public boolean membersLoadEndReached;
        private String nextLoadOffset;
        public boolean recording;
        public boolean reloadingMembers;
        public TLRPC$Peer selfPeer;
        public int speakingMembersCount;
        private boolean typingUpdateRunnableScheduled;
        private long updatesStartWaitTime;
        public VideoParticipant videoNotAvailableParticipant;
        public LongSparseArray<TLRPC$TL_groupCallParticipant> participants = new LongSparseArray<>();
        public final ArrayList<TLRPC$TL_groupCallParticipant> sortedParticipants = new ArrayList<>();
        public final ArrayList<VideoParticipant> visibleVideoParticipants = new ArrayList<>();
        public final ArrayList<TLRPC$TL_groupCallParticipant> visibleParticipants = new ArrayList<>();
        public final HashMap<String, Bitmap> thumbs = new HashMap<>();
        private final HashMap<String, VideoParticipant> videoParticipantsCache = new HashMap<>();
        public ArrayList<Long> invitedUsers = new ArrayList<>();
        public HashSet<Long> invitedUsersMap = new HashSet<>();
        public SparseArray<TLRPC$TL_groupCallParticipant> participantsBySources = new SparseArray<>();
        public SparseArray<TLRPC$TL_groupCallParticipant> participantsByVideoSources = new SparseArray<>();
        public SparseArray<TLRPC$TL_groupCallParticipant> participantsByPresentationSources = new SparseArray<>();
        private Runnable typingUpdateRunnable = new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ChatObject$Call$PXl-SuSNqiNR2XcZA5wkJBGsi4c
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0$ChatObject$Call();
            }
        };
        private HashSet<Integer> loadingGuids = new HashSet<>();
        private ArrayList<TLRPC$TL_updateGroupCallParticipants> updatesQueue = new ArrayList<>();
        private HashSet<Long> loadingUids = new HashSet<>();
        private HashSet<Long> loadingSsrcs = new HashSet<>();
        public final LongSparseArray<TLRPC$TL_groupCallParticipant> currentSpeakingPeers = new LongSparseArray<>();
        private final Runnable updateCurrentSpeakingRunnable = new Runnable() { // from class: ir.eitaa.messenger.ChatObject.Call.1
            @Override // java.lang.Runnable
            public void run() {
                long jUptimeMillis = SystemClock.uptimeMillis();
                int i = 0;
                boolean z = false;
                while (i < Call.this.currentSpeakingPeers.size()) {
                    long jKeyAt = Call.this.currentSpeakingPeers.keyAt(i);
                    if (jUptimeMillis - Call.this.currentSpeakingPeers.get(jKeyAt).lastSpeakTime >= 500) {
                        Call.this.currentSpeakingPeers.remove(jKeyAt);
                        if (jKeyAt > 0) {
                            TLRPC$User user = MessagesController.getInstance(Call.this.currentAccount.getCurrentAccount()).getUser(Long.valueOf(jKeyAt));
                            StringBuilder sb = new StringBuilder();
                            sb.append("remove from speaking ");
                            sb.append(jKeyAt);
                            sb.append(" ");
                            sb.append(user != null ? user.first_name : null);
                            Log.d("GroupCall", sb.toString());
                        } else {
                            TLRPC$Chat chat = MessagesController.getInstance(Call.this.currentAccount.getCurrentAccount()).getChat(Long.valueOf(-jKeyAt));
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("remove from speaking ");
                            sb2.append(jKeyAt);
                            sb2.append(" ");
                            sb2.append(chat != null ? chat.title : null);
                            Log.d("GroupCall", sb2.toString());
                        }
                        i--;
                        z = true;
                    }
                    i++;
                }
                if (Call.this.currentSpeakingPeers.size() > 0) {
                    AndroidUtilities.runOnUIThread(Call.this.updateCurrentSpeakingRunnable, 550L);
                }
                if (z) {
                    Call.this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallSpeakingUsersUpdated, Long.valueOf(Call.this.chatId), Long.valueOf(Call.this.call.id), Boolean.FALSE);
                }
            }
        };

        public interface OnParticipantsLoad {
            void onLoad(ArrayList<Long> ssrcs);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$new$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$new$0$ChatObject$Call() {
            this.typingUpdateRunnableScheduled = false;
            checkOnlineParticipants();
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallTypingsUpdated, new Object[0]);
        }

        public void setCall(AccountInstance account, long chatId, TLRPC$TL_phone_groupCall groupCall) {
            this.chatId = chatId;
            this.currentAccount = account;
            TLRPC$GroupCall tLRPC$GroupCall = groupCall.call;
            this.call = tLRPC$GroupCall;
            this.recording = tLRPC$GroupCall.record_start_date != 0;
            int iMin = ConnectionsManager.DEFAULT_DATACENTER_ID;
            int size = groupCall.participants.size();
            for (int i = 0; i < size; i++) {
                TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = groupCall.participants.get(i);
                this.participants.put(MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer), tLRPC$TL_groupCallParticipant);
                this.sortedParticipants.add(tLRPC$TL_groupCallParticipant);
                processAllSources(tLRPC$TL_groupCallParticipant, true);
                iMin = Math.min(iMin, tLRPC$TL_groupCallParticipant.date);
            }
            sortParticipants();
            this.nextLoadOffset = groupCall.participants_next_offset;
            loadMembers(true);
            createNoVideoParticipant();
        }

        public void createNoVideoParticipant() {
            if (this.videoNotAvailableParticipant != null) {
                return;
            }
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = new TLRPC$TL_groupCallParticipant();
            TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
            tLRPC$TL_groupCallParticipant.peer = tLRPC$TL_peerChannel;
            tLRPC$TL_peerChannel.channel_id = this.chatId;
            tLRPC$TL_groupCallParticipant.muted = true;
            TLRPC$TL_groupCallParticipantVideo tLRPC$TL_groupCallParticipantVideo = new TLRPC$TL_groupCallParticipantVideo();
            tLRPC$TL_groupCallParticipant.video = tLRPC$TL_groupCallParticipantVideo;
            tLRPC$TL_groupCallParticipantVideo.paused = true;
            tLRPC$TL_groupCallParticipantVideo.endpoint = "";
            this.videoNotAvailableParticipant = new VideoParticipant(tLRPC$TL_groupCallParticipant, false, false);
        }

        public void addSelfDummyParticipant(boolean notify) {
            long selfId = getSelfId();
            if (this.participants.indexOfKey(selfId) >= 0) {
                return;
            }
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = new TLRPC$TL_groupCallParticipant();
            tLRPC$TL_groupCallParticipant.peer = this.selfPeer;
            tLRPC$TL_groupCallParticipant.muted = true;
            tLRPC$TL_groupCallParticipant.self = true;
            tLRPC$TL_groupCallParticipant.video_joined = this.call.can_start_video;
            TLRPC$Chat chat = this.currentAccount.getMessagesController().getChat(Long.valueOf(this.chatId));
            tLRPC$TL_groupCallParticipant.can_self_unmute = !this.call.join_muted || ChatObject.canManageCalls(chat);
            tLRPC$TL_groupCallParticipant.date = this.currentAccount.getConnectionsManager().getCurrentTime();
            if (ChatObject.canManageCalls(chat) || !ChatObject.isChannel(chat) || chat.megagroup || tLRPC$TL_groupCallParticipant.can_self_unmute) {
                tLRPC$TL_groupCallParticipant.active_date = this.currentAccount.getConnectionsManager().getCurrentTime();
            }
            if (selfId > 0) {
                TLRPC$UserFull userFull = MessagesController.getInstance(this.currentAccount.getCurrentAccount()).getUserFull(selfId);
                if (userFull != null) {
                    tLRPC$TL_groupCallParticipant.about = userFull.about;
                }
            } else {
                TLRPC$ChatFull chatFull = MessagesController.getInstance(this.currentAccount.getCurrentAccount()).getChatFull(-selfId);
                if (chatFull != null) {
                    tLRPC$TL_groupCallParticipant.about = chatFull.about;
                }
            }
            this.participants.put(selfId, tLRPC$TL_groupCallParticipant);
            this.sortedParticipants.add(tLRPC$TL_groupCallParticipant);
            sortParticipants();
            if (notify) {
                this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Long.valueOf(this.chatId), Long.valueOf(this.call.id), Boolean.FALSE);
            }
        }

        public void migrateToChat(TLRPC$Chat chat) {
            this.chatId = chat.id;
            VoIPService sharedInstance = VoIPService.getSharedInstance();
            if (sharedInstance == null || sharedInstance.getAccount() != this.currentAccount.getCurrentAccount() || sharedInstance.getChat() == null || sharedInstance.getChat().id != (-this.chatId)) {
                return;
            }
            sharedInstance.migrateToChat(chat);
        }

        public boolean shouldShowPanel() {
            return this.call.participants_count > 0 || isScheduled();
        }

        public boolean isScheduled() {
            return (this.call.flags & 128) != 0;
        }

        private long getSelfId() {
            TLRPC$Peer tLRPC$Peer = this.selfPeer;
            if (tLRPC$Peer != null) {
                return MessageObject.getPeerId(tLRPC$Peer);
            }
            return this.currentAccount.getUserConfig().getClientUserId();
        }

        private void onParticipantsLoad(ArrayList<TLRPC$TL_groupCallParticipant> loadedParticipants, boolean fromBegin, String reqOffset, String nextOffset, int version, int participantCount) {
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant;
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant2;
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant3 = this.participants.get(getSelfId());
            LongSparseArray<TLRPC$TL_groupCallParticipant> longSparseArray = null;
            if (TextUtils.isEmpty(reqOffset)) {
                if (this.participants.size() != 0) {
                    longSparseArray = this.participants;
                    this.participants = new LongSparseArray<>();
                } else {
                    this.participants.clear();
                }
                this.sortedParticipants.clear();
                this.participantsBySources.clear();
                this.participantsByVideoSources.clear();
                this.participantsByPresentationSources.clear();
                this.loadingGuids.clear();
            }
            this.nextLoadOffset = nextOffset;
            if (loadedParticipants.isEmpty() || TextUtils.isEmpty(this.nextLoadOffset)) {
                this.membersLoadEndReached = true;
            }
            if (TextUtils.isEmpty(reqOffset)) {
                TLRPC$GroupCall tLRPC$GroupCall = this.call;
                tLRPC$GroupCall.version = version;
                tLRPC$GroupCall.participants_count = participantCount;
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("new participants count " + this.call.participants_count);
                }
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.applyGroupCallVisibleParticipants, Long.valueOf(jElapsedRealtime));
            int size = loadedParticipants.size();
            boolean z = false;
            for (int i = 0; i <= size; i++) {
                if (i != size) {
                    tLRPC$TL_groupCallParticipant = loadedParticipants.get(i);
                    if (tLRPC$TL_groupCallParticipant.self) {
                        z = true;
                    }
                } else if (fromBegin && tLRPC$TL_groupCallParticipant3 != null && !z) {
                    tLRPC$TL_groupCallParticipant = tLRPC$TL_groupCallParticipant3;
                }
                TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant4 = this.participants.get(MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer));
                if (tLRPC$TL_groupCallParticipant4 != null) {
                    this.sortedParticipants.remove(tLRPC$TL_groupCallParticipant4);
                    processAllSources(tLRPC$TL_groupCallParticipant4, false);
                    if (tLRPC$TL_groupCallParticipant4.self) {
                        tLRPC$TL_groupCallParticipant.lastTypingDate = tLRPC$TL_groupCallParticipant4.active_date;
                    } else {
                        tLRPC$TL_groupCallParticipant.lastTypingDate = Math.max(tLRPC$TL_groupCallParticipant.active_date, tLRPC$TL_groupCallParticipant4.active_date);
                    }
                    if (jElapsedRealtime != tLRPC$TL_groupCallParticipant.lastVisibleDate) {
                        tLRPC$TL_groupCallParticipant.active_date = tLRPC$TL_groupCallParticipant.lastTypingDate;
                    }
                } else if (longSparseArray != null && (tLRPC$TL_groupCallParticipant2 = longSparseArray.get(MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer))) != null) {
                    if (tLRPC$TL_groupCallParticipant2.self) {
                        tLRPC$TL_groupCallParticipant.lastTypingDate = tLRPC$TL_groupCallParticipant2.active_date;
                    } else {
                        tLRPC$TL_groupCallParticipant.lastTypingDate = Math.max(tLRPC$TL_groupCallParticipant.active_date, tLRPC$TL_groupCallParticipant2.active_date);
                    }
                    if (jElapsedRealtime != tLRPC$TL_groupCallParticipant.lastVisibleDate) {
                        tLRPC$TL_groupCallParticipant.active_date = tLRPC$TL_groupCallParticipant.lastTypingDate;
                    } else {
                        tLRPC$TL_groupCallParticipant.active_date = tLRPC$TL_groupCallParticipant2.active_date;
                    }
                }
                this.participants.put(MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer), tLRPC$TL_groupCallParticipant);
                this.sortedParticipants.add(tLRPC$TL_groupCallParticipant);
                processAllSources(tLRPC$TL_groupCallParticipant, true);
            }
            if (this.call.participants_count < this.participants.size()) {
                this.call.participants_count = this.participants.size();
            }
            sortParticipants();
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Long.valueOf(this.chatId), Long.valueOf(this.call.id), Boolean.FALSE);
            setParticiapantsVolume();
        }

        public void loadMembers(final boolean fromBegin) {
            if (fromBegin) {
                if (this.reloadingMembers) {
                    return;
                }
                this.membersLoadEndReached = false;
                this.nextLoadOffset = null;
            }
            if (this.membersLoadEndReached || this.sortedParticipants.size() > ChatObject.MAX_PARTICIPANTS_COUNT) {
                return;
            }
            if (fromBegin) {
                this.reloadingMembers = true;
            }
            this.loadingMembers = true;
            final TLRPC$TL_phone_getGroupParticipants tLRPC$TL_phone_getGroupParticipants = new TLRPC$TL_phone_getGroupParticipants();
            tLRPC$TL_phone_getGroupParticipants.call = getInputGroupCall();
            String str = this.nextLoadOffset;
            if (str == null) {
                str = "";
            }
            tLRPC$TL_phone_getGroupParticipants.offset = str;
            tLRPC$TL_phone_getGroupParticipants.limit = 20;
            this.currentAccount.getConnectionsManager().sendRequest(tLRPC$TL_phone_getGroupParticipants, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$ChatObject$Call$fBdLgWEjxjq2uWhSjJ6oXyjz1jE
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadMembers$2$ChatObject$Call(fromBegin, tLRPC$TL_phone_getGroupParticipants, tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$loadMembers$2, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$loadMembers$2$ChatObject$Call(final boolean z, final TLRPC$TL_phone_getGroupParticipants tLRPC$TL_phone_getGroupParticipants, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ChatObject$Call$rr7o9-PpVDdSGAjzKZwXc2TRXwY
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadMembers$1$ChatObject$Call(z, tLObject, tLRPC$TL_phone_getGroupParticipants);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$loadMembers$1, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$loadMembers$1$ChatObject$Call(boolean z, TLObject tLObject, TLRPC$TL_phone_getGroupParticipants tLRPC$TL_phone_getGroupParticipants) {
            this.loadingMembers = false;
            if (z) {
                this.reloadingMembers = false;
            }
            if (tLObject != null) {
                TLRPC$TL_phone_groupParticipants tLRPC$TL_phone_groupParticipants = (TLRPC$TL_phone_groupParticipants) tLObject;
                this.currentAccount.getMessagesController().putUsers(tLRPC$TL_phone_groupParticipants.users, false);
                this.currentAccount.getMessagesController().putChats(tLRPC$TL_phone_groupParticipants.chats, false);
                onParticipantsLoad(tLRPC$TL_phone_groupParticipants.participants, z, tLRPC$TL_phone_getGroupParticipants.offset, tLRPC$TL_phone_groupParticipants.next_offset, tLRPC$TL_phone_groupParticipants.version, tLRPC$TL_phone_groupParticipants.count);
            }
        }

        private void setParticiapantsVolume() {
            VoIPService sharedInstance = VoIPService.getSharedInstance();
            if (sharedInstance == null || sharedInstance.getAccount() != this.currentAccount.getCurrentAccount() || sharedInstance.getChat() == null || sharedInstance.getChat().id != (-this.chatId)) {
                return;
            }
            sharedInstance.setParticipantsVolume();
        }

        public void setTitle(String title) {
            TLRPC$TL_phone_editGroupCallTitle tLRPC$TL_phone_editGroupCallTitle = new TLRPC$TL_phone_editGroupCallTitle();
            tLRPC$TL_phone_editGroupCallTitle.call = getInputGroupCall();
            tLRPC$TL_phone_editGroupCallTitle.title = title;
            this.currentAccount.getConnectionsManager().sendRequest(tLRPC$TL_phone_editGroupCallTitle, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$ChatObject$Call$EECSHPSqu-6ZJw-T0lKWI8-Vmac
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$setTitle$3$ChatObject$Call(tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$setTitle$3, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$setTitle$3$ChatObject$Call(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            if (tLObject != null) {
                this.currentAccount.getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
            }
        }

        public void addInvitedUser(long uid) {
            if (this.participants.get(uid) != null || this.invitedUsersMap.contains(Long.valueOf(uid))) {
                return;
            }
            this.invitedUsersMap.add(Long.valueOf(uid));
            this.invitedUsers.add(Long.valueOf(uid));
        }

        public void processTypingsUpdate(AccountInstance accountInstance, ArrayList<Long> uids, int date) {
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.applyGroupCallVisibleParticipants, Long.valueOf(SystemClock.elapsedRealtime()));
            int size = uids.size();
            ArrayList<Long> arrayList = null;
            boolean z = false;
            for (int i = 0; i < size; i++) {
                Long l = uids.get(i);
                TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = this.participants.get(l.longValue());
                if (tLRPC$TL_groupCallParticipant != null) {
                    if (date - tLRPC$TL_groupCallParticipant.lastTypingDate > 10) {
                        if (tLRPC$TL_groupCallParticipant.lastVisibleDate != date) {
                            tLRPC$TL_groupCallParticipant.active_date = date;
                        }
                        tLRPC$TL_groupCallParticipant.lastTypingDate = date;
                        z = true;
                    }
                } else {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(l);
                }
            }
            if (arrayList != null) {
                loadUnknownParticipants(arrayList, true, null);
            }
            if (z) {
                sortParticipants();
                this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Long.valueOf(this.chatId), Long.valueOf(this.call.id), Boolean.FALSE);
            }
        }

        private void loadUnknownParticipants(final ArrayList<Long> participantsToLoad, boolean isIds, final OnParticipantsLoad onLoad) {
            TLRPC$InputPeer tLRPC$TL_inputPeerChannel;
            final HashSet<Long> hashSet = isIds ? this.loadingUids : this.loadingSsrcs;
            int size = participantsToLoad.size();
            int i = 0;
            while (i < size) {
                if (hashSet.contains(participantsToLoad.get(i))) {
                    participantsToLoad.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
            if (participantsToLoad.isEmpty()) {
                return;
            }
            final int i2 = this.lastLoadGuid + 1;
            this.lastLoadGuid = i2;
            this.loadingGuids.add(Integer.valueOf(i2));
            hashSet.addAll(participantsToLoad);
            TLRPC$TL_phone_getGroupParticipants tLRPC$TL_phone_getGroupParticipants = new TLRPC$TL_phone_getGroupParticipants();
            tLRPC$TL_phone_getGroupParticipants.call = getInputGroupCall();
            int size2 = participantsToLoad.size();
            for (int i3 = 0; i3 < size2; i3++) {
                long jLongValue = participantsToLoad.get(i3).longValue();
                if (!isIds) {
                    tLRPC$TL_phone_getGroupParticipants.sources.add(Integer.valueOf((int) jLongValue));
                } else if (jLongValue > 0) {
                    TLRPC$TL_inputPeerUser tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerUser();
                    tLRPC$TL_inputPeerUser.user_id = jLongValue;
                    tLRPC$TL_phone_getGroupParticipants.ids.add(tLRPC$TL_inputPeerUser);
                } else {
                    long j = -jLongValue;
                    TLRPC$Chat chat = this.currentAccount.getMessagesController().getChat(Long.valueOf(j));
                    if (chat == null || ChatObject.isChannel(chat)) {
                        tLRPC$TL_inputPeerChannel = new TLRPC$TL_inputPeerChannel();
                        tLRPC$TL_inputPeerChannel.channel_id = j;
                    } else {
                        tLRPC$TL_inputPeerChannel = new TLRPC$TL_inputPeerChat();
                        tLRPC$TL_inputPeerChannel.chat_id = j;
                    }
                    tLRPC$TL_phone_getGroupParticipants.ids.add(tLRPC$TL_inputPeerChannel);
                }
            }
            tLRPC$TL_phone_getGroupParticipants.offset = "";
            tLRPC$TL_phone_getGroupParticipants.limit = 100;
            this.currentAccount.getConnectionsManager().sendRequest(tLRPC$TL_phone_getGroupParticipants, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$ChatObject$Call$PicBYG8StE9ryITdypNFxk17Hhw
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadUnknownParticipants$5$ChatObject$Call(i2, onLoad, participantsToLoad, hashSet, tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$loadUnknownParticipants$5, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$loadUnknownParticipants$5$ChatObject$Call(final int i, final OnParticipantsLoad onParticipantsLoad, final ArrayList arrayList, final HashSet hashSet, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ChatObject$Call$uKvnkYCXUxVqMXjzNB3E1I-6vd4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadUnknownParticipants$4$ChatObject$Call(i, tLObject, onParticipantsLoad, arrayList, hashSet);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$loadUnknownParticipants$4, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$loadUnknownParticipants$4$ChatObject$Call(int i, TLObject tLObject, OnParticipantsLoad onParticipantsLoad, ArrayList arrayList, HashSet hashSet) {
            if (this.loadingGuids.remove(Integer.valueOf(i))) {
                if (tLObject != null) {
                    TLRPC$TL_phone_groupParticipants tLRPC$TL_phone_groupParticipants = (TLRPC$TL_phone_groupParticipants) tLObject;
                    this.currentAccount.getMessagesController().putUsers(tLRPC$TL_phone_groupParticipants.users, false);
                    this.currentAccount.getMessagesController().putChats(tLRPC$TL_phone_groupParticipants.chats, false);
                    int size = tLRPC$TL_phone_groupParticipants.participants.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = tLRPC$TL_phone_groupParticipants.participants.get(i2);
                        long peerId = MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer);
                        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant2 = this.participants.get(peerId);
                        if (tLRPC$TL_groupCallParticipant2 != null) {
                            this.sortedParticipants.remove(tLRPC$TL_groupCallParticipant2);
                            processAllSources(tLRPC$TL_groupCallParticipant2, false);
                        }
                        this.participants.put(peerId, tLRPC$TL_groupCallParticipant);
                        this.sortedParticipants.add(tLRPC$TL_groupCallParticipant);
                        processAllSources(tLRPC$TL_groupCallParticipant, true);
                        if (this.invitedUsersMap.contains(Long.valueOf(peerId))) {
                            Long lValueOf = Long.valueOf(peerId);
                            this.invitedUsersMap.remove(lValueOf);
                            this.invitedUsers.remove(lValueOf);
                        }
                    }
                    if (this.call.participants_count < this.participants.size()) {
                        this.call.participants_count = this.participants.size();
                    }
                    sortParticipants();
                    this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Long.valueOf(this.chatId), Long.valueOf(this.call.id), Boolean.FALSE);
                    if (onParticipantsLoad != null) {
                        onParticipantsLoad.onLoad(arrayList);
                    } else {
                        setParticiapantsVolume();
                    }
                }
                hashSet.removeAll(arrayList);
            }
        }

        private void processAllSources(TLRPC$TL_groupCallParticipant participant, boolean add) {
            int i;
            int i2 = participant.source;
            if (i2 != 0) {
                if (add) {
                    this.participantsBySources.put(i2, participant);
                } else {
                    this.participantsBySources.remove(i2);
                }
            }
            int i3 = 0;
            while (i3 < 2) {
                TLRPC$TL_groupCallParticipantVideo tLRPC$TL_groupCallParticipantVideo = i3 == 0 ? participant.video : participant.presentation;
                if (tLRPC$TL_groupCallParticipantVideo != null) {
                    if ((2 & tLRPC$TL_groupCallParticipantVideo.flags) != 0 && (i = tLRPC$TL_groupCallParticipantVideo.audio_source) != 0) {
                        if (add) {
                            this.participantsBySources.put(i, participant);
                        } else {
                            this.participantsBySources.remove(i);
                        }
                    }
                    SparseArray<TLRPC$TL_groupCallParticipant> sparseArray = i3 == 0 ? this.participantsByVideoSources : this.participantsByPresentationSources;
                    int size = tLRPC$TL_groupCallParticipantVideo.source_groups.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        TLRPC$TL_groupCallParticipantVideoSourceGroup tLRPC$TL_groupCallParticipantVideoSourceGroup = tLRPC$TL_groupCallParticipantVideo.source_groups.get(i4);
                        int size2 = tLRPC$TL_groupCallParticipantVideoSourceGroup.sources.size();
                        for (int i5 = 0; i5 < size2; i5++) {
                            int iIntValue = tLRPC$TL_groupCallParticipantVideoSourceGroup.sources.get(i5).intValue();
                            if (add) {
                                sparseArray.put(iIntValue, participant);
                            } else {
                                sparseArray.remove(iIntValue);
                            }
                        }
                    }
                    if (add) {
                        if (i3 == 0) {
                            participant.videoEndpoint = tLRPC$TL_groupCallParticipantVideo.endpoint;
                        } else {
                            participant.presentationEndpoint = tLRPC$TL_groupCallParticipantVideo.endpoint;
                        }
                    } else if (i3 == 0) {
                        participant.videoEndpoint = null;
                    } else {
                        participant.presentationEndpoint = null;
                    }
                }
                i3++;
            }
        }

        public void processVoiceLevelsUpdate(int[] ssrc, float[] levels, boolean[] voice) {
            boolean z;
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant;
            long j;
            ArrayList<Long> arrayList;
            boolean z2;
            int i;
            int currentTime = this.currentAccount.getConnectionsManager().getCurrentTime();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long jUptimeMillis = SystemClock.uptimeMillis();
            int i2 = 1;
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.applyGroupCallVisibleParticipants, Long.valueOf(jElapsedRealtime));
            int i3 = 0;
            ArrayList<Long> arrayList2 = null;
            boolean z3 = false;
            boolean z4 = false;
            while (i3 < ssrc.length) {
                if (ssrc[i3] == 0) {
                    z = z4;
                    tLRPC$TL_groupCallParticipant = this.participants.get(getSelfId());
                } else {
                    z = z4;
                    tLRPC$TL_groupCallParticipant = this.participantsBySources.get(ssrc[i3]);
                }
                if (tLRPC$TL_groupCallParticipant != null) {
                    tLRPC$TL_groupCallParticipant.hasVoice = voice[i3];
                    if (voice[i3] || jElapsedRealtime - tLRPC$TL_groupCallParticipant.lastVoiceUpdateTime > 500) {
                        tLRPC$TL_groupCallParticipant.hasVoiceDelayed = voice[i3];
                        tLRPC$TL_groupCallParticipant.lastVoiceUpdateTime = jElapsedRealtime;
                    }
                    long peerId = MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer);
                    if (levels[i3] > 0.1f) {
                        if (voice[i3]) {
                            z2 = z3;
                            arrayList = arrayList2;
                            if (tLRPC$TL_groupCallParticipant.lastTypingDate + i2 < currentTime) {
                                if (jElapsedRealtime != tLRPC$TL_groupCallParticipant.lastVisibleDate) {
                                    tLRPC$TL_groupCallParticipant.active_date = currentTime;
                                }
                                tLRPC$TL_groupCallParticipant.lastTypingDate = currentTime;
                                z2 = true;
                            }
                        } else {
                            arrayList = arrayList2;
                            z2 = z3;
                        }
                        tLRPC$TL_groupCallParticipant.lastSpeakTime = jUptimeMillis;
                        tLRPC$TL_groupCallParticipant.amplitude = levels[i3];
                        if (this.currentSpeakingPeers.get(peerId, null) == null) {
                            if (peerId > 0) {
                                TLRPC$User user = MessagesController.getInstance(this.currentAccount.getCurrentAccount()).getUser(Long.valueOf(peerId));
                                StringBuilder sb = new StringBuilder();
                                sb.append("add to current speaking ");
                                sb.append(peerId);
                                sb.append(" ");
                                sb.append(user == null ? null : user.first_name);
                                Log.d("GroupCall", sb.toString());
                                i = currentTime;
                                j = jElapsedRealtime;
                            } else {
                                i = currentTime;
                                j = jElapsedRealtime;
                                TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount.getCurrentAccount()).getChat(Long.valueOf(-peerId));
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("add to current speaking ");
                                sb2.append(peerId);
                                sb2.append(" ");
                                sb2.append(chat == null ? null : chat.title);
                                Log.d("GroupCall", sb2.toString());
                            }
                            this.currentSpeakingPeers.put(peerId, tLRPC$TL_groupCallParticipant);
                            z4 = true;
                        } else {
                            i = currentTime;
                            j = jElapsedRealtime;
                        }
                    } else {
                        j = jElapsedRealtime;
                        arrayList = arrayList2;
                        z2 = z3;
                        i = currentTime;
                        if (jUptimeMillis - tLRPC$TL_groupCallParticipant.lastSpeakTime < 500 || this.currentSpeakingPeers.get(peerId, null) == null) {
                            z4 = z;
                        } else {
                            this.currentSpeakingPeers.remove(peerId);
                            if (peerId > 0) {
                                TLRPC$User user2 = MessagesController.getInstance(this.currentAccount.getCurrentAccount()).getUser(Long.valueOf(peerId));
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("remove from speaking ");
                                sb3.append(peerId);
                                sb3.append(" ");
                                sb3.append(user2 == null ? null : user2.first_name);
                                Log.d("GroupCall", sb3.toString());
                            } else {
                                TLRPC$Chat chat2 = MessagesController.getInstance(this.currentAccount.getCurrentAccount()).getChat(Long.valueOf(-peerId));
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("remove from speaking ");
                                sb4.append(peerId);
                                sb4.append(" ");
                                sb4.append(chat2 == null ? null : chat2.title);
                                Log.d("GroupCall", sb4.toString());
                            }
                            z4 = true;
                        }
                        tLRPC$TL_groupCallParticipant.amplitude = 0.0f;
                    }
                    arrayList2 = arrayList;
                    i3++;
                    currentTime = i;
                    z3 = z2;
                    jElapsedRealtime = j;
                    i2 = 1;
                } else {
                    j = jElapsedRealtime;
                    arrayList = arrayList2;
                    z2 = z3;
                    i = currentTime;
                    if (ssrc[i3] != 0) {
                        arrayList2 = arrayList == null ? new ArrayList<>() : arrayList;
                        arrayList2.add(Long.valueOf(ssrc[i3]));
                        z4 = z;
                        i3++;
                        currentTime = i;
                        z3 = z2;
                        jElapsedRealtime = j;
                        i2 = 1;
                    }
                }
                z4 = z;
                arrayList2 = arrayList;
                i3++;
                currentTime = i;
                z3 = z2;
                jElapsedRealtime = j;
                i2 = 1;
            }
            ArrayList<Long> arrayList3 = arrayList2;
            boolean z5 = z3;
            boolean z6 = z4;
            if (arrayList3 != null) {
                loadUnknownParticipants(arrayList3, false, null);
            }
            if (z5) {
                sortParticipants();
                this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Long.valueOf(this.chatId), Long.valueOf(this.call.id), Boolean.FALSE);
            }
            if (z6) {
                if (this.currentSpeakingPeers.size() > 0) {
                    AndroidUtilities.cancelRunOnUIThread(this.updateCurrentSpeakingRunnable);
                    AndroidUtilities.runOnUIThread(this.updateCurrentSpeakingRunnable, 550L);
                }
                this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallSpeakingUsersUpdated, Long.valueOf(this.chatId), Long.valueOf(this.call.id), Boolean.FALSE);
            }
        }

        public void updateVisibleParticipants() {
            sortParticipants();
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Long.valueOf(this.chatId), Long.valueOf(this.call.id), Boolean.FALSE, 0L);
        }

        public void clearVideFramesInfo() {
            for (int i = 0; i < this.sortedParticipants.size(); i++) {
                this.sortedParticipants.get(i).hasCameraFrame = 0;
                this.sortedParticipants.get(i).hasPresentationFrame = 0;
                this.sortedParticipants.get(i).videoIndex = 0;
            }
            sortParticipants();
        }

        public void processUnknownVideoParticipants(int[] ssrc, OnParticipantsLoad onLoad) {
            ArrayList<Long> arrayList = null;
            for (int i = 0; i < ssrc.length; i++) {
                if (this.participantsBySources.get(ssrc[i]) == null && this.participantsByVideoSources.get(ssrc[i]) == null && this.participantsByPresentationSources.get(ssrc[i]) == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(Long.valueOf(ssrc[i]));
                }
            }
            if (arrayList != null) {
                loadUnknownParticipants(arrayList, false, onLoad);
            } else {
                onLoad.onLoad(null);
            }
        }

        private int isValidUpdate(TLRPC$TL_updateGroupCallParticipants update) {
            int i = this.call.version;
            int i2 = i + 1;
            int i3 = update.version;
            if (i2 == i3 || i == i3) {
                return 0;
            }
            return i < i3 ? 1 : 2;
        }

        public void setSelfPeer(TLRPC$InputPeer peer) {
            if (peer == null) {
                this.selfPeer = null;
                return;
            }
            if (peer instanceof TLRPC$TL_inputPeerUser) {
                TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                this.selfPeer = tLRPC$TL_peerUser;
                tLRPC$TL_peerUser.user_id = peer.user_id;
            } else if (peer instanceof TLRPC$TL_inputPeerChat) {
                TLRPC$TL_peerChat tLRPC$TL_peerChat = new TLRPC$TL_peerChat();
                this.selfPeer = tLRPC$TL_peerChat;
                tLRPC$TL_peerChat.chat_id = peer.chat_id;
            } else {
                TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
                this.selfPeer = tLRPC$TL_peerChannel;
                tLRPC$TL_peerChannel.channel_id = peer.channel_id;
            }
        }

        private void processUpdatesQueue() {
            Collections.sort(this.updatesQueue, $$Lambda$ChatObject$Call$x6yKW3u_XSe7xOiuP2PADL2gmvI.INSTANCE);
            ArrayList<TLRPC$TL_updateGroupCallParticipants> arrayList = this.updatesQueue;
            if (arrayList != null && !arrayList.isEmpty()) {
                boolean z = false;
                while (this.updatesQueue.size() > 0) {
                    TLRPC$TL_updateGroupCallParticipants tLRPC$TL_updateGroupCallParticipants = this.updatesQueue.get(0);
                    int iIsValidUpdate = isValidUpdate(tLRPC$TL_updateGroupCallParticipants);
                    if (iIsValidUpdate == 0) {
                        processParticipantsUpdate(tLRPC$TL_updateGroupCallParticipants, true);
                        this.updatesQueue.remove(0);
                        z = true;
                    } else {
                        if (iIsValidUpdate == 1) {
                            if (this.updatesStartWaitTime != 0 && (z || Math.abs(System.currentTimeMillis() - this.updatesStartWaitTime) <= 1500)) {
                                if (BuildVars.LOGS_ENABLED) {
                                    FileLog.d("HOLE IN GROUP CALL UPDATES QUEUE - will wait more time");
                                }
                                if (z) {
                                    this.updatesStartWaitTime = System.currentTimeMillis();
                                    return;
                                }
                                return;
                            }
                            if (BuildVars.LOGS_ENABLED) {
                                FileLog.d("HOLE IN GROUP CALL UPDATES QUEUE - reload participants");
                            }
                            this.updatesStartWaitTime = 0L;
                            this.updatesQueue.clear();
                            this.nextLoadOffset = null;
                            loadMembers(true);
                            return;
                        }
                        this.updatesQueue.remove(0);
                    }
                }
                this.updatesQueue.clear();
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("GROUP CALL UPDATES QUEUE PROCEED - OK");
                }
            }
            this.updatesStartWaitTime = 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void checkQueue() {
            this.checkQueueRunnable = null;
            if (this.updatesStartWaitTime != 0 && System.currentTimeMillis() - this.updatesStartWaitTime >= 1500) {
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("QUEUE GROUP CALL UPDATES WAIT TIMEOUT - CHECK QUEUE");
                }
                processUpdatesQueue();
            }
            if (this.updatesQueue.isEmpty()) {
                return;
            }
            $$Lambda$ChatObject$Call$qDlsUfpBbrIWrBzcI0AefskOldo __lambda_chatobject_call_qdlsufpbbriwrbzci0aefskoldo = new $$Lambda$ChatObject$Call$qDlsUfpBbrIWrBzcI0AefskOldo(this);
            this.checkQueueRunnable = __lambda_chatobject_call_qdlsufpbbriwrbzci0aefskoldo;
            AndroidUtilities.runOnUIThread(__lambda_chatobject_call_qdlsufpbbriwrbzci0aefskoldo, 1000L);
        }

        public void reloadGroupCall() {
            TLRPC$TL_phone_getGroupCall tLRPC$TL_phone_getGroupCall = new TLRPC$TL_phone_getGroupCall();
            tLRPC$TL_phone_getGroupCall.call = getInputGroupCall();
            tLRPC$TL_phone_getGroupCall.limit = 100;
            this.currentAccount.getConnectionsManager().sendRequest(tLRPC$TL_phone_getGroupCall, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$ChatObject$Call$Uj9fnWHASZgw-JaAbtNzHqGZ9gw
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$reloadGroupCall$8$ChatObject$Call(tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$reloadGroupCall$8, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$reloadGroupCall$8$ChatObject$Call(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ChatObject$Call$W05XaeJnVU_imH5XbSJtIyVkYIA
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$reloadGroupCall$7$ChatObject$Call(tLObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$reloadGroupCall$7, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$reloadGroupCall$7$ChatObject$Call(TLObject tLObject) {
            if (tLObject instanceof TLRPC$TL_phone_groupCall) {
                TLRPC$TL_phone_groupCall tLRPC$TL_phone_groupCall = (TLRPC$TL_phone_groupCall) tLObject;
                this.call = tLRPC$TL_phone_groupCall.call;
                this.currentAccount.getMessagesController().putUsers(tLRPC$TL_phone_groupCall.users, false);
                this.currentAccount.getMessagesController().putChats(tLRPC$TL_phone_groupCall.chats, false);
                ArrayList<TLRPC$TL_groupCallParticipant> arrayList = tLRPC$TL_phone_groupCall.participants;
                String str = tLRPC$TL_phone_groupCall.participants_next_offset;
                TLRPC$GroupCall tLRPC$GroupCall = tLRPC$TL_phone_groupCall.call;
                onParticipantsLoad(arrayList, true, "", str, tLRPC$GroupCall.version, tLRPC$GroupCall.participants_count);
            }
        }

        private void loadGroupCall() {
            if (this.loadingGroupCall || SystemClock.elapsedRealtime() - this.lastGroupCallReloadTime < 30000) {
                return;
            }
            this.loadingGroupCall = true;
            TLRPC$TL_phone_getGroupParticipants tLRPC$TL_phone_getGroupParticipants = new TLRPC$TL_phone_getGroupParticipants();
            tLRPC$TL_phone_getGroupParticipants.call = getInputGroupCall();
            tLRPC$TL_phone_getGroupParticipants.offset = "";
            tLRPC$TL_phone_getGroupParticipants.limit = 1;
            this.currentAccount.getConnectionsManager().sendRequest(tLRPC$TL_phone_getGroupParticipants, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$ChatObject$Call$WZbVRCZ-4iAUz9Lyi5k6FNxYRTg
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadGroupCall$10$ChatObject$Call(tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$loadGroupCall$10, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$loadGroupCall$10$ChatObject$Call(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: ir.eitaa.messenger.-$$Lambda$ChatObject$Call$1KntY2c7ZX_KMQe7c41dSY_enw4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadGroupCall$9$ChatObject$Call(tLObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$loadGroupCall$9, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$loadGroupCall$9$ChatObject$Call(TLObject tLObject) {
            this.lastGroupCallReloadTime = SystemClock.elapsedRealtime();
            this.loadingGroupCall = false;
            if (tLObject != null) {
                TLRPC$TL_phone_groupParticipants tLRPC$TL_phone_groupParticipants = (TLRPC$TL_phone_groupParticipants) tLObject;
                this.currentAccount.getMessagesController().putUsers(tLRPC$TL_phone_groupParticipants.users, false);
                this.currentAccount.getMessagesController().putChats(tLRPC$TL_phone_groupParticipants.chats, false);
                TLRPC$GroupCall tLRPC$GroupCall = this.call;
                int i = tLRPC$GroupCall.participants_count;
                int i2 = tLRPC$TL_phone_groupParticipants.count;
                if (i != i2) {
                    tLRPC$GroupCall.participants_count = i2;
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d("new participants reload count " + this.call.participants_count);
                    }
                    this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Long.valueOf(this.chatId), Long.valueOf(this.call.id), Boolean.FALSE);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:163:0x03e3  */
        /* JADX WARN: Removed duplicated region for block: B:166:0x03ed  */
        /* JADX WARN: Removed duplicated region for block: B:180:0x040f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void processParticipantsUpdate(ir.eitaa.tgnet.TLRPC$TL_updateGroupCallParticipants r28, boolean r29) {
            /*
                Method dump skipped, instructions count: 1270
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ir.eitaa.messenger.ChatObject.Call.processParticipantsUpdate(ir.eitaa.tgnet.TLRPC$TL_updateGroupCallParticipants, boolean):void");
        }

        private boolean isSameVideo(TLRPC$TL_groupCallParticipantVideo oldVideo, TLRPC$TL_groupCallParticipantVideo newVideo) {
            if ((oldVideo == null && newVideo != null) || (oldVideo != null && newVideo == null)) {
                return false;
            }
            if (oldVideo != null && newVideo != null) {
                if (!TextUtils.equals(oldVideo.endpoint, newVideo.endpoint) || oldVideo.source_groups.size() != newVideo.source_groups.size()) {
                    return false;
                }
                int size = oldVideo.source_groups.size();
                for (int i = 0; i < size; i++) {
                    TLRPC$TL_groupCallParticipantVideoSourceGroup tLRPC$TL_groupCallParticipantVideoSourceGroup = oldVideo.source_groups.get(i);
                    TLRPC$TL_groupCallParticipantVideoSourceGroup tLRPC$TL_groupCallParticipantVideoSourceGroup2 = newVideo.source_groups.get(i);
                    if (!TextUtils.equals(tLRPC$TL_groupCallParticipantVideoSourceGroup.semantics, tLRPC$TL_groupCallParticipantVideoSourceGroup2.semantics) || tLRPC$TL_groupCallParticipantVideoSourceGroup.sources.size() != tLRPC$TL_groupCallParticipantVideoSourceGroup2.sources.size()) {
                        return false;
                    }
                    int size2 = tLRPC$TL_groupCallParticipantVideoSourceGroup.sources.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        if (!tLRPC$TL_groupCallParticipantVideoSourceGroup2.sources.contains(tLRPC$TL_groupCallParticipantVideoSourceGroup.sources.get(i2))) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        public void processGroupCallUpdate(TLRPC$TL_updateGroupCall update) {
            if (this.call.version < update.call.version) {
                this.nextLoadOffset = null;
                loadMembers(true);
            }
            this.call = update.call;
            this.participants.get(getSelfId());
            this.recording = this.call.record_start_date != 0;
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Long.valueOf(this.chatId), Long.valueOf(this.call.id), Boolean.FALSE);
        }

        public TLRPC$TL_inputGroupCall getInputGroupCall() {
            TLRPC$TL_inputGroupCall tLRPC$TL_inputGroupCall = new TLRPC$TL_inputGroupCall();
            TLRPC$GroupCall tLRPC$GroupCall = this.call;
            tLRPC$TL_inputGroupCall.id = tLRPC$GroupCall.id;
            tLRPC$TL_inputGroupCall.access_hash = tLRPC$GroupCall.access_hash;
            return tLRPC$TL_inputGroupCall;
        }

        public static boolean videoIsActive(TLRPC$TL_groupCallParticipant participant, boolean presentation, Call call) {
            VoIPService sharedInstance;
            if (participant == null || (sharedInstance = VoIPService.getSharedInstance()) == null) {
                return false;
            }
            if (participant.self) {
                return sharedInstance.getVideoState(presentation) == 2;
            }
            VideoParticipant videoParticipant = call.videoNotAvailableParticipant;
            if ((videoParticipant == null || videoParticipant.participant != participant) && call.participants.get(MessageObject.getPeerId(participant.peer)) == null) {
                return false;
            }
            return presentation ? participant.presentation != null : participant.video != null;
        }

        public void sortParticipants() {
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant;
            int i;
            int size;
            VideoParticipant videoParticipant;
            this.visibleVideoParticipants.clear();
            this.visibleParticipants.clear();
            TLRPC$Chat chat = this.currentAccount.getMessagesController().getChat(Long.valueOf(this.chatId));
            boolean zCanManageCalls = ChatObject.canManageCalls(chat);
            long selfId = getSelfId();
            VoIPService.getSharedInstance();
            this.participants.get(selfId);
            this.canStreamVideo = true;
            this.activeVideos = 0;
            int size2 = this.sortedParticipants.size();
            boolean z = false;
            for (int i2 = 0; i2 < size2; i2++) {
                TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant2 = this.sortedParticipants.get(i2);
                boolean zVideoIsActive = videoIsActive(tLRPC$TL_groupCallParticipant2, false, this);
                boolean zVideoIsActive2 = videoIsActive(tLRPC$TL_groupCallParticipant2, true, this);
                boolean z2 = tLRPC$TL_groupCallParticipant2.self;
                if (!z2 && (zVideoIsActive || zVideoIsActive2)) {
                    this.activeVideos++;
                }
                if (zVideoIsActive || zVideoIsActive2) {
                    if (this.canStreamVideo) {
                        if (tLRPC$TL_groupCallParticipant2.videoIndex == 0) {
                            if (z2) {
                                tLRPC$TL_groupCallParticipant2.videoIndex = ConnectionsManager.DEFAULT_DATACENTER_ID;
                            } else {
                                int i3 = videoPointer + 1;
                                videoPointer = i3;
                                tLRPC$TL_groupCallParticipant2.videoIndex = i3;
                            }
                        }
                    } else {
                        tLRPC$TL_groupCallParticipant2.videoIndex = 0;
                    }
                    z = true;
                } else if (z2 || !this.canStreamVideo || (tLRPC$TL_groupCallParticipant2.video == null && tLRPC$TL_groupCallParticipant2.presentation == null)) {
                    tLRPC$TL_groupCallParticipant2.videoIndex = 0;
                }
            }
            Collections.sort(this.sortedParticipants, new $$Lambda$ChatObject$Call$JTf8l2zEdcDNWBcmMvVdHz2OvU(this, selfId, zCanManageCalls));
            if (this.sortedParticipants.isEmpty()) {
                tLRPC$TL_groupCallParticipant = null;
            } else {
                ArrayList<TLRPC$TL_groupCallParticipant> arrayList = this.sortedParticipants;
                tLRPC$TL_groupCallParticipant = arrayList.get(arrayList.size() - 1);
            }
            if ((videoIsActive(tLRPC$TL_groupCallParticipant, false, this) || videoIsActive(tLRPC$TL_groupCallParticipant, true, this)) && (i = this.call.unmuted_video_count) > this.activeVideos) {
                this.activeVideos = i;
                VoIPService sharedInstance = VoIPService.getSharedInstance();
                if (sharedInstance != null && sharedInstance.groupCall == this && (sharedInstance.getVideoState(false) == 2 || sharedInstance.getVideoState(true) == 2)) {
                    this.activeVideos--;
                }
            }
            if (this.sortedParticipants.size() > ChatObject.MAX_PARTICIPANTS_COUNT && (!ChatObject.canManageCalls(chat) || tLRPC$TL_groupCallParticipant.raise_hand_rating == 0)) {
                int size3 = this.sortedParticipants.size();
                for (int i4 = ChatObject.MAX_PARTICIPANTS_COUNT; i4 < size3; i4++) {
                    TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant3 = this.sortedParticipants.get(ChatObject.MAX_PARTICIPANTS_COUNT);
                    if (tLRPC$TL_groupCallParticipant3.raise_hand_rating == 0) {
                        processAllSources(tLRPC$TL_groupCallParticipant3, false);
                        this.participants.remove(MessageObject.getPeerId(tLRPC$TL_groupCallParticipant3.peer));
                        this.sortedParticipants.remove(ChatObject.MAX_PARTICIPANTS_COUNT);
                    }
                }
            }
            checkOnlineParticipants();
            if (!this.canStreamVideo && z && (videoParticipant = this.videoNotAvailableParticipant) != null) {
                this.visibleVideoParticipants.add(videoParticipant);
            }
            int size4 = 0;
            for (int i5 = 0; i5 < this.sortedParticipants.size(); i5++) {
                TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant4 = this.sortedParticipants.get(i5);
                if (this.canStreamVideo && tLRPC$TL_groupCallParticipant4.videoIndex != 0) {
                    if (!tLRPC$TL_groupCallParticipant4.self && videoIsActive(tLRPC$TL_groupCallParticipant4, true, this) && videoIsActive(tLRPC$TL_groupCallParticipant4, false, this)) {
                        VideoParticipant videoParticipant2 = this.videoParticipantsCache.get(tLRPC$TL_groupCallParticipant4.videoEndpoint);
                        if (videoParticipant2 == null) {
                            videoParticipant2 = new VideoParticipant(tLRPC$TL_groupCallParticipant4, false, true);
                            this.videoParticipantsCache.put(tLRPC$TL_groupCallParticipant4.videoEndpoint, videoParticipant2);
                        } else {
                            videoParticipant2.participant = tLRPC$TL_groupCallParticipant4;
                            videoParticipant2.presentation = false;
                            videoParticipant2.hasSame = true;
                        }
                        VideoParticipant videoParticipant3 = this.videoParticipantsCache.get(tLRPC$TL_groupCallParticipant4.presentationEndpoint);
                        if (videoParticipant3 == null) {
                            videoParticipant3 = new VideoParticipant(tLRPC$TL_groupCallParticipant4, true, true);
                        } else {
                            videoParticipant3.participant = tLRPC$TL_groupCallParticipant4;
                            videoParticipant3.presentation = true;
                            videoParticipant3.hasSame = true;
                        }
                        this.visibleVideoParticipants.add(videoParticipant2);
                        if (videoParticipant2.aspectRatio > 1.0f) {
                            size4 = this.visibleVideoParticipants.size() - 1;
                        }
                        this.visibleVideoParticipants.add(videoParticipant3);
                        if (videoParticipant3.aspectRatio > 1.0f) {
                            size = this.visibleVideoParticipants.size();
                            size4 = size - 1;
                        }
                    } else if (tLRPC$TL_groupCallParticipant4.self) {
                        if (videoIsActive(tLRPC$TL_groupCallParticipant4, true, this)) {
                            this.visibleVideoParticipants.add(new VideoParticipant(tLRPC$TL_groupCallParticipant4, true, false));
                        }
                        if (videoIsActive(tLRPC$TL_groupCallParticipant4, false, this)) {
                            this.visibleVideoParticipants.add(new VideoParticipant(tLRPC$TL_groupCallParticipant4, false, false));
                        }
                    } else {
                        boolean zVideoIsActive3 = videoIsActive(tLRPC$TL_groupCallParticipant4, true, this);
                        VideoParticipant videoParticipant4 = this.videoParticipantsCache.get(zVideoIsActive3 ? tLRPC$TL_groupCallParticipant4.presentationEndpoint : tLRPC$TL_groupCallParticipant4.videoEndpoint);
                        if (videoParticipant4 == null) {
                            videoParticipant4 = new VideoParticipant(tLRPC$TL_groupCallParticipant4, zVideoIsActive3, false);
                            this.videoParticipantsCache.put(zVideoIsActive3 ? tLRPC$TL_groupCallParticipant4.presentationEndpoint : tLRPC$TL_groupCallParticipant4.videoEndpoint, videoParticipant4);
                        } else {
                            videoParticipant4.participant = tLRPC$TL_groupCallParticipant4;
                            videoParticipant4.presentation = zVideoIsActive3;
                            videoParticipant4.hasSame = false;
                        }
                        this.visibleVideoParticipants.add(videoParticipant4);
                        if (videoParticipant4.aspectRatio > 1.0f) {
                            size = this.visibleVideoParticipants.size();
                            size4 = size - 1;
                        }
                    }
                } else {
                    this.visibleParticipants.add(tLRPC$TL_groupCallParticipant4);
                }
            }
            if (GroupCallActivity.isLandscapeMode || this.visibleVideoParticipants.size() % 2 != 1) {
                return;
            }
            this.visibleVideoParticipants.add(this.visibleVideoParticipants.remove(size4));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$sortParticipants$11, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ int lambda$sortParticipants$11$ChatObject$Call(long j, boolean z, TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant, TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant2) {
            int i;
            int i2 = tLRPC$TL_groupCallParticipant.videoIndex;
            boolean z2 = i2 > 0;
            int i3 = tLRPC$TL_groupCallParticipant2.videoIndex;
            boolean z3 = i3 > 0;
            if (z2 && z3) {
                return i3 - i2;
            }
            if (z2) {
                return -1;
            }
            if (z3) {
                return 1;
            }
            int i4 = tLRPC$TL_groupCallParticipant.active_date;
            if (i4 != 0 && (i = tLRPC$TL_groupCallParticipant2.active_date) != 0) {
                return ChatObject$Call$$ExternalSynthetic0.m0(i, i4);
            }
            if (i4 != 0) {
                return -1;
            }
            if (tLRPC$TL_groupCallParticipant2.active_date != 0) {
                return 1;
            }
            if (MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer) == j) {
                return -1;
            }
            if (MessageObject.getPeerId(tLRPC$TL_groupCallParticipant2.peer) == j) {
                return 1;
            }
            if (z) {
                long j2 = tLRPC$TL_groupCallParticipant.raise_hand_rating;
                if (j2 != 0) {
                    long j3 = tLRPC$TL_groupCallParticipant2.raise_hand_rating;
                    if (j3 != 0) {
                        return (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                    }
                }
                if (j2 != 0) {
                    return -1;
                }
                if (tLRPC$TL_groupCallParticipant2.raise_hand_rating != 0) {
                    return 1;
                }
            }
            if (this.call.join_date_asc) {
                return ChatObject$Call$$ExternalSynthetic0.m0(tLRPC$TL_groupCallParticipant.date, tLRPC$TL_groupCallParticipant2.date);
            }
            return ChatObject$Call$$ExternalSynthetic0.m0(tLRPC$TL_groupCallParticipant2.date, tLRPC$TL_groupCallParticipant.date);
        }

        public boolean canRecordVideo() {
            if (!this.canStreamVideo) {
                return false;
            }
            VoIPService sharedInstance = VoIPService.getSharedInstance();
            return (sharedInstance != null && sharedInstance.groupCall == this && (sharedInstance.getVideoState(false) == 2 || sharedInstance.getVideoState(true) == 2)) || this.activeVideos < this.call.unmuted_video_limit;
        }

        public void saveActiveDates() {
            int size = this.sortedParticipants.size();
            for (int i = 0; i < size; i++) {
                this.sortedParticipants.get(i).lastActiveDate = r2.active_date;
            }
        }

        private void checkOnlineParticipants() {
            if (this.typingUpdateRunnableScheduled) {
                AndroidUtilities.cancelRunOnUIThread(this.typingUpdateRunnable);
                this.typingUpdateRunnableScheduled = false;
            }
            this.speakingMembersCount = 0;
            int currentTime = this.currentAccount.getConnectionsManager().getCurrentTime();
            int size = this.sortedParticipants.size();
            int iMin = ConnectionsManager.DEFAULT_DATACENTER_ID;
            for (int i = 0; i < size; i++) {
                TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = this.sortedParticipants.get(i);
                int i2 = currentTime - tLRPC$TL_groupCallParticipant.active_date;
                if (i2 < 5) {
                    this.speakingMembersCount++;
                    iMin = Math.min(i2, iMin);
                }
                if (Math.max(tLRPC$TL_groupCallParticipant.date, tLRPC$TL_groupCallParticipant.active_date) <= currentTime - 5) {
                    break;
                }
            }
            if (iMin != Integer.MAX_VALUE) {
                AndroidUtilities.runOnUIThread(this.typingUpdateRunnable, iMin * 1000);
                this.typingUpdateRunnableScheduled = true;
            }
        }

        public void toggleRecord(String title, int type) {
            this.recording = !this.recording;
            TLRPC$TL_phone_toggleGroupCallRecord tLRPC$TL_phone_toggleGroupCallRecord = new TLRPC$TL_phone_toggleGroupCallRecord();
            tLRPC$TL_phone_toggleGroupCallRecord.call = getInputGroupCall();
            tLRPC$TL_phone_toggleGroupCallRecord.start = this.recording;
            if (title != null) {
                tLRPC$TL_phone_toggleGroupCallRecord.title = title;
                tLRPC$TL_phone_toggleGroupCallRecord.flags |= 2;
            }
            if (type == 1 || type == 2) {
                tLRPC$TL_phone_toggleGroupCallRecord.flags |= 4;
                tLRPC$TL_phone_toggleGroupCallRecord.video = true;
                tLRPC$TL_phone_toggleGroupCallRecord.video_portrait = type == 1;
            }
            this.currentAccount.getConnectionsManager().sendRequest(tLRPC$TL_phone_toggleGroupCallRecord, new RequestDelegate() { // from class: ir.eitaa.messenger.-$$Lambda$ChatObject$Call$CIKCjIbljFdGKrJkYPHFw2zy1To
                @Override // ir.eitaa.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$toggleRecord$12$ChatObject$Call(tLObject, tLRPC$TL_error);
                }
            });
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Long.valueOf(this.chatId), Long.valueOf(this.call.id), Boolean.FALSE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: lambda$toggleRecord$12, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void lambda$toggleRecord$12$ChatObject$Call(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            if (tLObject != null) {
                this.currentAccount.getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
            }
        }
    }

    public static int getParticipantVolume(TLRPC$TL_groupCallParticipant participant) {
        if ((participant.flags & 128) != 0) {
            return participant.volume;
        }
        return 10000;
    }

    private static boolean getBannedRight(TLRPC$TL_chatBannedRights rights, int action) {
        if (rights == null) {
            return false;
        }
        if (action == 0) {
            return rights.pin_messages;
        }
        if (action == 1) {
            return true;
        }
        if (action == 3) {
            return rights.invite_users;
        }
        if (action == 15) {
            return rights.send_forwarded_messages;
        }
        switch (action) {
        }
        return false;
    }

    public static boolean isActionBannedByDefault(TLRPC$Chat chat, int action) {
        if (getBannedRight(chat.banned_rights, action)) {
            return false;
        }
        return getBannedRight(chat.default_banned_rights, action);
    }

    public static boolean isActionBanned(TLRPC$Chat chat, int action) {
        return chat != null && (getBannedRight(chat.banned_rights, action) || getBannedRight(chat.default_banned_rights, action));
    }

    public static boolean canUserDoAdminAction(TLRPC$Chat chat, int action) {
        boolean z;
        if (chat == null) {
            return false;
        }
        if (chat.creator) {
            return true;
        }
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights = chat.admin_rights;
        if (tLRPC$TL_chatAdminRights != null) {
            if (action == 0) {
                z = tLRPC$TL_chatAdminRights.pin_messages;
            } else if (action == 1) {
                z = tLRPC$TL_chatAdminRights.change_info;
            } else if (action == 2) {
                z = tLRPC$TL_chatAdminRights.ban_users;
            } else if (action == 3) {
                z = tLRPC$TL_chatAdminRights.invite_users;
            } else if (action == 4) {
                z = tLRPC$TL_chatAdminRights.add_admins;
            } else if (action == 5) {
                z = tLRPC$TL_chatAdminRights.post_messages;
            } else {
                switch (action) {
                    case 12:
                        z = tLRPC$TL_chatAdminRights.edit_messages;
                        break;
                    case 13:
                        z = tLRPC$TL_chatAdminRights.delete_messages;
                        break;
                    case 14:
                        z = tLRPC$TL_chatAdminRights.manage_call;
                        break;
                    default:
                        z = false;
                        break;
                }
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public static boolean canUserDoAction(TLRPC$Chat chat, int action) {
        if (chat == null || canUserDoAdminAction(chat, action)) {
            return true;
        }
        if (getBannedRight(chat.banned_rights, action) || !isBannableAction(action)) {
            return false;
        }
        if (chat.admin_rights != null && !isAdminAction(action)) {
            return true;
        }
        TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights = chat.default_banned_rights;
        if (tLRPC$TL_chatBannedRights == null && ((chat instanceof TLRPC$TL_chat_layer92) || (chat instanceof TLRPC$TL_chat_old) || (chat instanceof TLRPC$TL_chat_old2) || (chat instanceof TLRPC$TL_channel_layer92) || (chat instanceof TLRPC$TL_channel_layer77) || (chat instanceof TLRPC$TL_channel_layer72) || (chat instanceof TLRPC$TL_channel_layer67) || (chat instanceof TLRPC$TL_channel_layer48) || (chat instanceof TLRPC$TL_channel_old))) {
            return true;
        }
        return !(tLRPC$TL_chatBannedRights == null || getBannedRight(tLRPC$TL_chatBannedRights, action)) || (chat instanceof TLRPC$TL_chat);
    }

    public static boolean isLeftFromChat(TLRPC$Chat chat) {
        return chat == null || (chat instanceof TLRPC$TL_chatEmpty) || (chat instanceof TLRPC$TL_chatForbidden) || (chat instanceof TLRPC$TL_channelForbidden) || chat.left || chat.deactivated;
    }

    public static boolean isKickedFromChat(TLRPC$Chat chat) {
        TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights;
        return chat == null || (chat instanceof TLRPC$TL_chatEmpty) || (chat instanceof TLRPC$TL_chatForbidden) || (chat instanceof TLRPC$TL_channelForbidden) || chat.kicked || chat.deactivated || ((tLRPC$TL_chatBannedRights = chat.banned_rights) != null && tLRPC$TL_chatBannedRights.view_messages);
    }

    public static boolean isNotInChat(TLRPC$Chat chat) {
        return chat == null || (chat instanceof TLRPC$TL_chatEmpty) || (chat instanceof TLRPC$TL_chatForbidden) || (chat instanceof TLRPC$TL_channelForbidden) || chat.left || chat.kicked || chat.deactivated;
    }

    public static boolean isChannel(TLRPC$Chat chat) {
        return (chat instanceof TLRPC$TL_channel) || (chat instanceof TLRPC$TL_channelForbidden);
    }

    public static boolean isChannelOrGiga(TLRPC$Chat chat) {
        return ((chat instanceof TLRPC$TL_channel) || (chat instanceof TLRPC$TL_channelForbidden)) && (!chat.megagroup || chat.gigagroup);
    }

    public static boolean isMegagroup(TLRPC$Chat chat) {
        return ((chat instanceof TLRPC$TL_channel) || (chat instanceof TLRPC$TL_channelForbidden)) && chat.megagroup;
    }

    public static boolean isMegagroup(int currentAccount, long chatId) {
        TLRPC$Chat chat = MessagesController.getInstance(currentAccount).getChat(Long.valueOf(chatId));
        return isChannel(chat) && chat.megagroup;
    }

    public static boolean hasAdminRights(TLRPC$Chat chat) {
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights;
        return chat != null && (chat.creator || !((tLRPC$TL_chatAdminRights = chat.admin_rights) == null || tLRPC$TL_chatAdminRights.flags == 0));
    }

    public static boolean canChangeChatInfo(TLRPC$Chat chat) {
        return canUserDoAction(chat, 1);
    }

    public static boolean canAddAdmins(TLRPC$Chat chat) {
        return canUserDoAction(chat, 4);
    }

    public static boolean canBlockUsers(TLRPC$Chat chat) {
        return canUserDoAction(chat, 2);
    }

    public static boolean canSendStickers(TLRPC$Chat chat) {
        return canUserDoAction(chat, 8);
    }

    public static boolean canSendEmbed(TLRPC$Chat chat) {
        return canUserDoAction(chat, 9);
    }

    public static boolean canSendMedia(TLRPC$Chat chat) {
        return canUserDoAction(chat, 7);
    }

    public static boolean canSendPolls(TLRPC$Chat chat) {
        return canUserDoAction(chat, 10);
    }

    public static boolean canSendForward(TLRPC$Chat chat) {
        return canUserDoAction(chat, 15);
    }

    public static boolean canSendMessages(TLRPC$Chat chat) {
        return canUserDoAction(chat, 6);
    }

    public static boolean canPost(TLRPC$Chat chat) {
        return canUserDoAction(chat, 5);
    }

    public static boolean canAddUsers(TLRPC$Chat chat) {
        return canUserDoAction(chat, 3);
    }

    public static boolean shouldSendAnonymously(TLRPC$Chat chat) {
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights;
        return (chat == null || (tLRPC$TL_chatAdminRights = chat.admin_rights) == null || !tLRPC$TL_chatAdminRights.anonymous) ? false : true;
    }

    public static boolean canAddBotsToChat(TLRPC$Chat chat) {
        if (!isChannel(chat)) {
            return chat.migrated_to == null;
        }
        if (!chat.megagroup) {
            return false;
        }
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights = chat.admin_rights;
        return (tLRPC$TL_chatAdminRights != null && (tLRPC$TL_chatAdminRights.post_messages || tLRPC$TL_chatAdminRights.add_admins)) || chat.creator;
    }

    public static boolean canPinMessages(TLRPC$Chat chat) {
        if (canUserDoAdminAction(chat, 0)) {
            return isChannel(chat) || chat.megagroup;
        }
        return false;
    }

    public static boolean isChannel(long chatId, int currentAccount) {
        TLRPC$Chat chat = MessagesController.getInstance(currentAccount).getChat(Long.valueOf(chatId));
        return (chat instanceof TLRPC$TL_channel) || (chat instanceof TLRPC$TL_channelForbidden);
    }

    public static boolean isCanWriteToChannel(long chatId, int currentAccount) {
        TLRPC$Chat chat = MessagesController.getInstance(currentAccount).getChat(Long.valueOf(chatId));
        return canSendMessages(chat) || chat.megagroup;
    }

    public static boolean canWriteToChat(TLRPC$Chat chat) {
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights;
        return !isChannel(chat) || chat.creator || ((tLRPC$TL_chatAdminRights = chat.admin_rights) != null && tLRPC$TL_chatAdminRights.post_messages) || (!(chat.broadcast || chat.gigagroup) || (chat.gigagroup && hasAdminRights(chat)));
    }

    public static String getBannedRightsString(TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights) {
        return (((((((((((((("" + (tLRPC$TL_chatBannedRights.view_messages ? 1 : 0)) + (tLRPC$TL_chatBannedRights.send_messages ? 1 : 0)) + (tLRPC$TL_chatBannedRights.send_forwarded_messages ? 1 : 0)) + (tLRPC$TL_chatBannedRights.send_media ? 1 : 0)) + (tLRPC$TL_chatBannedRights.send_stickers ? 1 : 0)) + (tLRPC$TL_chatBannedRights.send_gifs ? 1 : 0)) + (tLRPC$TL_chatBannedRights.send_games ? 1 : 0)) + (tLRPC$TL_chatBannedRights.send_inline ? 1 : 0)) + (tLRPC$TL_chatBannedRights.embed_links ? 1 : 0)) + (tLRPC$TL_chatBannedRights.send_polls ? 1 : 0)) + (tLRPC$TL_chatBannedRights.invite_users ? 1 : 0)) + (tLRPC$TL_chatBannedRights.change_info ? 1 : 0)) + (tLRPC$TL_chatBannedRights.pin_messages ? 1 : 0)) + (tLRPC$TL_chatBannedRights.view_participants ? 1 : 0)) + tLRPC$TL_chatBannedRights.until_date;
    }

    public static boolean hasPhoto(TLRPC$Chat chat) {
        TLRPC$ChatPhoto tLRPC$ChatPhoto;
        return (chat == null || (tLRPC$ChatPhoto = chat.photo) == null || (tLRPC$ChatPhoto instanceof TLRPC$TL_chatPhotoEmpty)) ? false : true;
    }

    public static TLRPC$ChatPhoto getPhoto(TLRPC$Chat chat) {
        if (hasPhoto(chat)) {
            return chat.photo;
        }
        return null;
    }

    public static class VideoParticipant {
        public float aspectRatio;
        public boolean hasSame;
        public TLRPC$TL_groupCallParticipant participant;
        public boolean presentation;

        public VideoParticipant(TLRPC$TL_groupCallParticipant participant, boolean presentation, boolean hasSame) {
            this.participant = participant;
            this.presentation = presentation;
            this.hasSame = hasSame;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            VideoParticipant videoParticipant = (VideoParticipant) o;
            return this.presentation == videoParticipant.presentation && MessageObject.getPeerId(this.participant.peer) == MessageObject.getPeerId(videoParticipant.participant.peer);
        }

        public void setAspectRatio(float aspectRatio, Call call) {
            if (this.aspectRatio != aspectRatio) {
                this.aspectRatio = aspectRatio;
                if (GroupCallActivity.isLandscapeMode || call.visibleVideoParticipants.size() % 2 != 1) {
                    return;
                }
                call.updateVisibleParticipants();
            }
        }
    }
}
