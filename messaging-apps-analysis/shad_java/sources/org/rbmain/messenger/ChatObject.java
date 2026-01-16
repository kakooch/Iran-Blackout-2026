package org.rbmain.messenger;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidMessenger.ServiceLocator;
import androidMessenger.proxy.CallProxy;
import androidMessenger.proxy.CallProxy$$ExternalSyntheticBackport0;
import androidMessenger.utilites.CallConverter;
import androidx.collection.LongSparseArray;
import androidx.constraintlayout.motion.widget.KeyCycleOscillator$1$$ExternalSyntheticBackport0;
import com.facebook.stetho.websocket.CloseCodes;
import com.google.android.exoplayer2.util.Log;
import ir.aaap.messengercore.LoadListener;
import ir.aaap.messengercore.model.Chat;
import ir.aaap.messengercore.model.GroupCallModels;
import j$.lang.Iterable$EL;
import j$.util.function.Consumer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.rbmain.messenger.ChatObject;
import org.rbmain.messenger.voip.VoIPService;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.RequestDelegate;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$ChatReactions;
import org.rbmain.tgnet.TLRPC$GroupCall;
import org.rbmain.tgnet.TLRPC$InputPeer;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$TL_channel;
import org.rbmain.tgnet.TLRPC$TL_channelForbidden;
import org.rbmain.tgnet.TLRPC$TL_chatAdminRights;
import org.rbmain.tgnet.TLRPC$TL_chatBannedRights;
import org.rbmain.tgnet.TLRPC$TL_chatEmpty;
import org.rbmain.tgnet.TLRPC$TL_chatForbidden;
import org.rbmain.tgnet.TLRPC$TL_chatReactionsAll;
import org.rbmain.tgnet.TLRPC$TL_chatReactionsSome;
import org.rbmain.tgnet.TLRPC$TL_error;
import org.rbmain.tgnet.TLRPC$TL_forumTopic;
import org.rbmain.tgnet.TLRPC$TL_groupCallDiscarded;
import org.rbmain.tgnet.TLRPC$TL_groupCallParticipant;
import org.rbmain.tgnet.TLRPC$TL_groupCallParticipantVideo;
import org.rbmain.tgnet.TLRPC$TL_groupCallParticipantVideoSourceGroup;
import org.rbmain.tgnet.TLRPC$TL_groupCallStreamChannel;
import org.rbmain.tgnet.TLRPC$TL_inputGroupCall;
import org.rbmain.tgnet.TLRPC$TL_inputPeerChannel;
import org.rbmain.tgnet.TLRPC$TL_inputPeerChat;
import org.rbmain.tgnet.TLRPC$TL_inputPeerUser;
import org.rbmain.tgnet.TLRPC$TL_peerChannel;
import org.rbmain.tgnet.TLRPC$TL_peerChat;
import org.rbmain.tgnet.TLRPC$TL_peerUser;
import org.rbmain.tgnet.TLRPC$TL_phone_editGroupCallTitle;
import org.rbmain.tgnet.TLRPC$TL_phone_getGroupCall;
import org.rbmain.tgnet.TLRPC$TL_phone_getGroupParticipants;
import org.rbmain.tgnet.TLRPC$TL_phone_groupCall;
import org.rbmain.tgnet.TLRPC$TL_phone_groupParticipants;
import org.rbmain.tgnet.TLRPC$TL_phone_toggleGroupCallRecord;
import org.rbmain.tgnet.TLRPC$TL_reactionEmoji;
import org.rbmain.tgnet.TLRPC$TL_updateGroupCall;
import org.rbmain.tgnet.TLRPC$TL_updateGroupCallParticipants;
import org.rbmain.tgnet.TLRPC$Updates;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserFull;
import org.rbmain.ui.GroupCallActivity;

/* loaded from: classes4.dex */
public class ChatObject {
    public static final int ACTION_ADD_ADMINS = 4;
    public static final int ACTION_BLOCK_USERS = 2;
    public static final int ACTION_CHANGE_INFO = 1;
    public static final int ACTION_DELETE_MESSAGES = 13;
    public static final int ACTION_EDIT_MESSAGES = 12;
    public static final int ACTION_EMBED_LINKS = 9;
    public static final int ACTION_INVITE = 3;
    public static final int ACTION_MANAGE_CALLS = 14;
    public static final int ACTION_MANAGE_TOPICS = 15;
    public static final int ACTION_PIN = 0;
    public static final int ACTION_POST = 5;
    public static final int ACTION_SEND = 6;
    public static final int ACTION_SEND_DOCUMENTS = 19;
    public static final int ACTION_SEND_GIFS = 23;
    public static final int ACTION_SEND_MEDIA = 7;
    public static final int ACTION_SEND_MUSIC = 18;
    public static final int ACTION_SEND_PHOTO = 16;
    public static final int ACTION_SEND_PLAIN = 22;
    public static final int ACTION_SEND_POLLS = 10;
    public static final int ACTION_SEND_ROUND = 21;
    public static final int ACTION_SEND_STICKERS = 8;
    public static final int ACTION_SEND_VIDEO = 17;
    public static final int ACTION_SEND_VOICE = 20;
    public static final int ACTION_VIEW = 11;
    public static final int ACTION_VIEW_ADMINS = 116;
    public static final int ACTION_VIEW_MEMBERS = 115;
    public static final int ACTION_VIEW_MESSAGES = 117;
    public static final int CHAT_TYPE_CHANNEL = 2;
    public static final int CHAT_TYPE_CHAT = 0;
    public static final int CHAT_TYPE_MEGAGROUP = 4;
    public static final int CHAT_TYPE_USER = 3;
    private static final int MAX_PARTICIPANTS_COUNT = 5000;
    public static final int VIDEO_FRAME_HAS_FRAME = 2;
    public static final int VIDEO_FRAME_NO_FRAME = 0;
    public static final int VIDEO_FRAME_REQUESTING = 1;

    public static boolean canDeleteTopic(int i, TLRPC$Chat tLRPC$Chat, int i2) {
        return false;
    }

    public static boolean canDeleteTopic(int i, TLRPC$Chat tLRPC$Chat, TLRPC$TL_forumTopic tLRPC$TL_forumTopic) {
        return false;
    }

    private static boolean isAdminAction(int i) {
        return i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 12 || i == 13;
    }

    private static boolean isBannableAction(int i) {
        if (i != 0 && i != 1 && i != 3) {
            switch (i) {
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

    public static boolean isMyTopic(int i, int i2, int i3) {
        return false;
    }

    public static boolean isMyTopic(int i, TLRPC$TL_forumTopic tLRPC$TL_forumTopic) {
        return false;
    }

    public static boolean hasPublicLink(TLRPC$Chat tLRPC$Chat, String str) {
        if (tLRPC$Chat == null || TextUtils.isEmpty(tLRPC$Chat.username)) {
            return false;
        }
        return tLRPC$Chat.username.equalsIgnoreCase(str);
    }

    public static class Call {
        public static final int RECORD_TYPE_AUDIO = 0;
        public static final int RECORD_TYPE_VIDEO_LANDSCAPE = 2;
        public static final int RECORD_TYPE_VIDEO_PORTAIT = 1;
        private static int videoPointer;
        public int activeVideos;
        public TLRPC$GroupCall call;
        public boolean canStreamVideo;
        public int chatId;
        private Runnable checkQueueRunnable;
        public AccountInstance currentAccount;
        private long lastGroupCallReloadTime;
        private int lastLoadGuid;
        public boolean loadedRtmpStreamParticipant;
        private boolean loadingGroupCall;
        public boolean loadingMembers;
        public boolean membersLoadEndReached;
        private String nextLoadOffset;
        public boolean recording;
        public boolean reloadingMembers;
        public VideoParticipant rtmpStreamParticipant;
        public TLRPC$Peer selfPeer;
        public int speakingMembersCount;
        private boolean started;
        private boolean typingUpdateRunnableScheduled;
        private long updatesStartWaitTime;
        public VideoParticipant videoNotAvailableParticipant;
        public SparseArray<TLRPC$TL_groupCallParticipant> participants = new SparseArray<>();
        public final ArrayList<TLRPC$TL_groupCallParticipant> sortedParticipants = new ArrayList<>();
        public final ArrayList<VideoParticipant> visibleVideoParticipants = new ArrayList<>();
        public final ArrayList<TLRPC$TL_groupCallParticipant> visibleParticipants = new ArrayList<>();
        public final HashMap<String, Bitmap> thumbs = new HashMap<>();
        private final HashMap<String, VideoParticipant> videoParticipantsCache = new HashMap<>();
        public ArrayList<Integer> invitedUsers = new ArrayList<>();
        public HashSet<Integer> invitedUsersMap = new HashSet<>();
        public SparseArray<TLRPC$TL_groupCallParticipant> participantsBySources = new SparseArray<>();
        public SparseArray<TLRPC$TL_groupCallParticipant> participantsByVideoSources = new SparseArray<>();
        public SparseArray<TLRPC$TL_groupCallParticipant> participantsByPresentationSources = new SparseArray<>();
        private Runnable typingUpdateRunnable = new Runnable() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$new$0();
            }
        };
        private HashSet<Integer> loadingGuids = new HashSet<>();
        private ArrayList<TLRPC$TL_updateGroupCallParticipants> updatesQueue = new ArrayList<>();
        private HashSet<Integer> loadingUids = new HashSet<>();
        private HashSet<Integer> loadingSsrcs = new HashSet<>();
        public final LongSparseArray<TLRPC$TL_groupCallParticipant> currentSpeakingPeers = new LongSparseArray<>();
        private final Object lock = new Object();
        private final Runnable updateCurrentSpeakingRunnable = new Runnable() { // from class: org.rbmain.messenger.ChatObject.Call.1
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
                    Call.this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallSpeakingUsersUpdated, Integer.valueOf(Call.this.chatId), Call.this.call.id, Boolean.FALSE);
                }
            }
        };
        private String state = null;
        private final Runnable getGroupVoiceChatUpdateRunnable = new Runnable() { // from class: org.rbmain.messenger.ChatObject.Call.2
            private int callRequest = 0;

            @Override // java.lang.Runnable
            public void run() {
                Call call;
                this.callRequest++;
                VoIPService sharedInstance = VoIPService.getSharedInstance();
                boolean z = (sharedInstance == null || (call = sharedInstance.groupCall) == null || (call.call instanceof TLRPC$TL_groupCallDiscarded)) ? false : true;
                if (this.callRequest % 2 == 0 && Call.this.state != null && z) {
                    CallProxy callProxy = Call.this.currentAccount.getCallProxy();
                    Call call2 = Call.this;
                    callProxy.getGroupVoiceChatUpdates(call2.chatId, call2.call.id, call2.state, new AnonymousClass1());
                }
                if (z) {
                    Utilities.stageQueue.postRunnable(Call.this.getGroupVoiceChatUpdateRunnable, 15000L);
                } else {
                    Call.this.stopGroupVoiceChatUpdate();
                }
            }

            /* renamed from: org.rbmain.messenger.ChatObject$Call$2$1, reason: invalid class name */
            class AnonymousClass1 implements LoadListener<GroupCallModels.GetGroupVoiceChatUpdatesResult> {
                AnonymousClass1() {
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onDidLoad(GroupCallModels.GetGroupVoiceChatUpdatesResult getGroupVoiceChatUpdatesResult) {
                    Call call;
                    TLRPC$GroupCall tLRPC$GroupCall;
                    VoIPService sharedInstance;
                    Call call2;
                    TLRPC$GroupCall tLRPC$GroupCall2;
                    String str = getGroupVoiceChatUpdatesResult.new_state;
                    if (str != null && !str.isEmpty()) {
                        Call.this.state = getGroupVoiceChatUpdatesResult.new_state;
                    }
                    GroupCallModels.GetGroupVoiceChatUpdatesStatus getGroupVoiceChatUpdatesStatus = getGroupVoiceChatUpdatesResult.status;
                    if (getGroupVoiceChatUpdatesStatus == GroupCallModels.GetGroupVoiceChatUpdatesStatus.OldState) {
                        Call.this.stopGroupVoiceChatUpdate();
                        Call.this.loadMembers(true);
                    } else if (getGroupVoiceChatUpdatesStatus == GroupCallModels.GetGroupVoiceChatUpdatesStatus.VoiceChatNotExist) {
                        Call.this.stopGroupVoiceChatUpdate();
                        VoIPService sharedInstance2 = VoIPService.getSharedInstance();
                        if (sharedInstance2 != null && (call = sharedInstance2.groupCall) != null && (tLRPC$GroupCall = call.call) != null && Call.this.call.id.equals(tLRPC$GroupCall.id)) {
                            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ChatObject$Call$2$1$$ExternalSyntheticLambda0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ChatObject.Call.AnonymousClass2.AnonymousClass1.lambda$onDidLoad$0();
                                }
                            });
                        }
                    }
                    if (getGroupVoiceChatUpdatesResult.is_joined || (sharedInstance = VoIPService.getSharedInstance()) == null || (call2 = sharedInstance.groupCall) == null || (tLRPC$GroupCall2 = call2.call) == null || !CallProxy$$ExternalSyntheticBackport0.m(tLRPC$GroupCall2.id, Call.this.call.id)) {
                        return;
                    }
                    sharedInstance.reJoin();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static /* synthetic */ void lambda$onDidLoad$0() {
                    VoIPService.getSharedInstance().detectVoiceChatNotExist();
                }

                @Override // ir.aaap.messengercore.LoadListener
                public void onError(Exception exc) {
                    Call.this.stopGroupVoiceChatUpdate();
                }
            }
        };

        public interface OnParticipantsLoad {
            void onLoad(ArrayList<Integer> arrayList);
        }

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes.dex */
        public @interface RecordType {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0() {
            this.typingUpdateRunnableScheduled = false;
            checkOnlineParticipants();
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallTypingsUpdated, new Object[0]);
        }

        public void setCall(AccountInstance accountInstance, int i, TLRPC$TL_phone_groupCall tLRPC$TL_phone_groupCall) {
            this.chatId = i;
            this.currentAccount = accountInstance;
            TLRPC$GroupCall tLRPC$GroupCall = tLRPC$TL_phone_groupCall.call;
            this.call = tLRPC$GroupCall;
            this.recording = tLRPC$GroupCall.record_start_date != 0;
            int iMin = ConnectionsManager.DEFAULT_DATACENTER_ID;
            int size = tLRPC$TL_phone_groupCall.participants.size();
            for (int i2 = 0; i2 < size; i2++) {
                TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = tLRPC$TL_phone_groupCall.participants.get(i2);
                this.participants.put(MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer), tLRPC$TL_groupCallParticipant);
                this.sortedParticipants.add(tLRPC$TL_groupCallParticipant);
                processAllSources(tLRPC$TL_groupCallParticipant, true);
                iMin = Math.min(iMin, tLRPC$TL_groupCallParticipant.date);
            }
            sortParticipants();
            this.nextLoadOffset = tLRPC$TL_phone_groupCall.participants_next_offset;
            loadMembers(true);
            createNoVideoParticipant();
            if (this.call.rtmp_stream) {
                createRtmpStreamParticipant(Collections.emptyList());
            }
        }

        public void createRtmpStreamParticipant(List<TLRPC$TL_groupCallStreamChannel> list) {
            if (!this.loadedRtmpStreamParticipant || this.rtmpStreamParticipant == null) {
                VideoParticipant videoParticipant = this.rtmpStreamParticipant;
                TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = videoParticipant != null ? videoParticipant.participant : new TLRPC$TL_groupCallParticipant();
                TLRPC$TL_peerChat tLRPC$TL_peerChat = new TLRPC$TL_peerChat();
                tLRPC$TL_groupCallParticipant.peer = tLRPC$TL_peerChat;
                tLRPC$TL_peerChat.channel_id = this.chatId;
                tLRPC$TL_groupCallParticipant.video = new TLRPC$TL_groupCallParticipantVideo();
                TLRPC$TL_groupCallParticipantVideoSourceGroup tLRPC$TL_groupCallParticipantVideoSourceGroup = new TLRPC$TL_groupCallParticipantVideoSourceGroup();
                tLRPC$TL_groupCallParticipantVideoSourceGroup.semantics = "SIM";
                Iterator<TLRPC$TL_groupCallStreamChannel> it = list.iterator();
                while (it.hasNext()) {
                    tLRPC$TL_groupCallParticipantVideoSourceGroup.sources.add(Integer.valueOf(it.next().channel));
                }
                tLRPC$TL_groupCallParticipant.video.source_groups.add(tLRPC$TL_groupCallParticipantVideoSourceGroup);
                tLRPC$TL_groupCallParticipant.video.endpoint = "unified";
                tLRPC$TL_groupCallParticipant.videoEndpoint = "unified";
                this.rtmpStreamParticipant = new VideoParticipant(tLRPC$TL_groupCallParticipant, false, false);
                sortParticipants();
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$createRtmpStreamParticipant$1();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$createRtmpStreamParticipant$1() {
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Integer.valueOf(this.chatId), this.call.id, Boolean.FALSE);
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
            tLRPC$TL_groupCallParticipantVideo.endpoint = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            this.videoNotAvailableParticipant = new VideoParticipant(tLRPC$TL_groupCallParticipant, false, false);
        }

        public void addSelfDummyParticipant(boolean z) {
            int selfId = getSelfId();
            if (this.participants.indexOfKey(selfId) >= 0) {
                return;
            }
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = new TLRPC$TL_groupCallParticipant();
            TLRPC$Peer tLRPC$Peer = this.selfPeer;
            tLRPC$TL_groupCallParticipant.peer = tLRPC$Peer;
            if (tLRPC$Peer == null) {
                TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                tLRPC$TL_groupCallParticipant.peer = tLRPC$TL_peerUser;
                tLRPC$TL_peerUser.user_id = selfId;
            }
            boolean z2 = true;
            tLRPC$TL_groupCallParticipant.muted = true;
            tLRPC$TL_groupCallParticipant.self = true;
            tLRPC$TL_groupCallParticipant.video_joined = this.call.can_start_video;
            TLRPC$Chat chat = this.currentAccount.getMessagesController().getChat(Integer.valueOf(this.chatId));
            if (this.call.join_muted && !ChatObject.canManageCalls(chat)) {
                z2 = false;
            }
            tLRPC$TL_groupCallParticipant.can_self_unmute = z2;
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
            if (z) {
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$addSelfDummyParticipant$2();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$addSelfDummyParticipant$2() {
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Integer.valueOf(this.chatId), this.call.id, Boolean.FALSE);
        }

        public void migrateToChat(TLRPC$Chat tLRPC$Chat) {
            this.chatId = tLRPC$Chat.id;
            VoIPService sharedInstance = VoIPService.getSharedInstance();
            if (sharedInstance == null || sharedInstance.getAccount() != this.currentAccount.getCurrentAccount() || sharedInstance.getChat() == null || sharedInstance.getChat().id != (-this.chatId)) {
                return;
            }
            sharedInstance.migrateToChat(tLRPC$Chat);
        }

        public boolean shouldShowPanel() {
            TLRPC$Chat chat = this.currentAccount.getMessagesController().getChat(Integer.valueOf(this.chatId));
            TLRPC$GroupCall tLRPC$GroupCall = this.call;
            return (tLRPC$GroupCall.participants_count > 0 || tLRPC$GroupCall.rtmp_stream || isScheduled()) && !ChatObject.isNotInChat(chat);
        }

        public boolean isScheduled() {
            return (this.call.flags & 128) != 0;
        }

        private int getSelfId() {
            TLRPC$Peer tLRPC$Peer = this.selfPeer;
            if (tLRPC$Peer != null) {
                return MessageObject.getPeerId(tLRPC$Peer);
            }
            return this.currentAccount.getUserConfig().getClientUserId();
        }

        private void onParticipantsLoad(ArrayList<TLRPC$TL_groupCallParticipant> arrayList, boolean z, String str, String str2, int i, int i2, String str3, boolean z2) {
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant;
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant2;
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant3 = this.participants.get(getSelfId());
            SparseArray<TLRPC$TL_groupCallParticipant> sparseArray = null;
            if (TextUtils.isEmpty(str)) {
                if (this.participants.size() != 0) {
                    sparseArray = this.participants;
                    this.participants = new SparseArray<>();
                } else {
                    this.participants.clear();
                }
                this.sortedParticipants.clear();
                this.participantsBySources.clear();
                this.participantsByVideoSources.clear();
                this.participantsByPresentationSources.clear();
                this.loadingGuids.clear();
            }
            this.nextLoadOffset = str2;
            if (arrayList.isEmpty() || TextUtils.isEmpty(this.nextLoadOffset)) {
                this.membersLoadEndReached = true;
            }
            this.membersLoadEndReached = !z2;
            this.state = str3;
            if (TextUtils.isEmpty(str)) {
                TLRPC$GroupCall tLRPC$GroupCall = this.call;
                tLRPC$GroupCall.version = i;
                tLRPC$GroupCall.participants_count = i2;
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("new participants count " + this.call.participants_count);
                }
            }
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onParticipantsLoad$3(jElapsedRealtime);
                }
            });
            int size = arrayList.size();
            boolean z3 = false;
            for (int i3 = 0; i3 <= size; i3++) {
                if (i3 != size) {
                    tLRPC$TL_groupCallParticipant = arrayList.get(i3);
                    if (tLRPC$TL_groupCallParticipant.self) {
                        z3 = true;
                    }
                } else if (z && tLRPC$TL_groupCallParticipant3 != null && !z3) {
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
                } else if (sparseArray != null && (tLRPC$TL_groupCallParticipant2 = sparseArray.get(MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer))) != null) {
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
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onParticipantsLoad$4();
                }
            });
            setParticiapantsVolume();
            startGetGroupVoiceChatUpdate();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onParticipantsLoad$3(long j) {
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.applyGroupCallVisibleParticipants, Long.valueOf(j));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onParticipantsLoad$4() {
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Integer.valueOf(this.chatId), this.call.id, Boolean.FALSE);
        }

        public void loadMembers(final boolean z) {
            if (z) {
                if (this.reloadingMembers) {
                    return;
                }
                this.membersLoadEndReached = false;
                this.nextLoadOffset = null;
                this.state = null;
            } else {
                startGetGroupVoiceChatUpdate();
            }
            boolean z2 = this.membersLoadEndReached;
            if (!z2 && this.state != null) {
                startGetGroupVoiceChatUpdate();
                return;
            }
            if (z2 || this.sortedParticipants.size() > ChatObject.MAX_PARTICIPANTS_COUNT) {
                return;
            }
            if (z) {
                this.reloadingMembers = true;
            }
            this.loadingMembers = true;
            final TLRPC$TL_phone_getGroupParticipants tLRPC$TL_phone_getGroupParticipants = new TLRPC$TL_phone_getGroupParticipants();
            tLRPC$TL_phone_getGroupParticipants.call = getInputGroupCall();
            String str = this.nextLoadOffset;
            if (str == null) {
                str = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            }
            tLRPC$TL_phone_getGroupParticipants.offset = str;
            tLRPC$TL_phone_getGroupParticipants.limit = 20;
            tLRPC$TL_phone_getGroupParticipants.chatId = this.chatId;
            this.currentAccount.getCallProxy().getGroupVoiceChatParticipants(tLRPC$TL_phone_getGroupParticipants, new RequestDelegate() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda28
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadMembers$6(z, tLRPC$TL_phone_getGroupParticipants, tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$loadMembers$6(final boolean z, final TLRPC$TL_phone_getGroupParticipants tLRPC$TL_phone_getGroupParticipants, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadMembers$5(z, tLObject, tLRPC$TL_phone_getGroupParticipants);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$loadMembers$5(boolean z, TLObject tLObject, TLRPC$TL_phone_getGroupParticipants tLRPC$TL_phone_getGroupParticipants) {
            this.loadingMembers = false;
            if (z) {
                this.reloadingMembers = false;
            }
            if (tLObject != null) {
                TLRPC$TL_phone_groupParticipants tLRPC$TL_phone_groupParticipants = (TLRPC$TL_phone_groupParticipants) tLObject;
                this.currentAccount.getMessagesController().putUsers(tLRPC$TL_phone_groupParticipants.users, false);
                this.currentAccount.getMessagesController().putChats(tLRPC$TL_phone_groupParticipants.chats, false);
                onParticipantsLoad(tLRPC$TL_phone_groupParticipants.participants, z, tLRPC$TL_phone_getGroupParticipants.offset, tLRPC$TL_phone_groupParticipants.next_offset, tLRPC$TL_phone_groupParticipants.version, tLRPC$TL_phone_groupParticipants.count, tLRPC$TL_phone_groupParticipants.state, tLRPC$TL_phone_groupParticipants.hasContinue);
            }
        }

        private void startGetGroupVoiceChatUpdate() {
            if (this.started) {
                return;
            }
            synchronized (this.lock) {
                if (!this.started) {
                    this.started = true;
                    Utilities.stageQueue.postRunnable(this.getGroupVoiceChatUpdateRunnable, 5000L);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void stopGroupVoiceChatUpdate() {
            if (this.started) {
                synchronized (this.lock) {
                    if (this.started) {
                        this.started = false;
                        Utilities.stageQueue.cancelRunnable(this.getGroupVoiceChatUpdateRunnable);
                    }
                }
            }
        }

        private void setParticiapantsVolume() {
            VoIPService sharedInstance = VoIPService.getSharedInstance();
            if (sharedInstance == null || sharedInstance.getAccount() != this.currentAccount.getCurrentAccount() || sharedInstance.getChat() == null || sharedInstance.getChat().id != (-this.chatId)) {
                return;
            }
            sharedInstance.setParticipantsVolume();
        }

        public void setTitle(String str) {
            TLRPC$TL_phone_editGroupCallTitle tLRPC$TL_phone_editGroupCallTitle = new TLRPC$TL_phone_editGroupCallTitle();
            tLRPC$TL_phone_editGroupCallTitle.call = getInputGroupCall();
            tLRPC$TL_phone_editGroupCallTitle.title = str;
            this.currentAccount.getCallProxy().setGroupVoiceChatSetting(tLRPC$TL_phone_editGroupCallTitle, new RequestDelegate() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda26
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$setTitle$7(tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setTitle$7(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            if (tLObject != null) {
                this.currentAccount.getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
            }
        }

        public void addInvitedUser(int i) {
            if (this.participants.get(i) != null || this.invitedUsersMap.contains(Integer.valueOf(i))) {
                return;
            }
            this.invitedUsersMap.add(Integer.valueOf(i));
            this.invitedUsers.add(Integer.valueOf(i));
        }

        public void processTypingsUpdate(AccountInstance accountInstance, ArrayList<Integer> arrayList, int i) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda12
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processTypingsUpdate$8(jElapsedRealtime);
                }
            });
            int size = arrayList.size();
            ArrayList<Integer> arrayList2 = null;
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                Integer num = arrayList.get(i2);
                TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = this.participants.get(num.intValue());
                if (tLRPC$TL_groupCallParticipant != null) {
                    if (i - tLRPC$TL_groupCallParticipant.lastTypingDate > 10) {
                        if (tLRPC$TL_groupCallParticipant.lastVisibleDate != i) {
                            tLRPC$TL_groupCallParticipant.active_date = i;
                        }
                        tLRPC$TL_groupCallParticipant.lastTypingDate = i;
                        z = true;
                    }
                } else {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    arrayList2.add(num);
                }
            }
            if (arrayList2 != null) {
                loadUnknownParticipants(arrayList2, true, null);
            }
            if (z) {
                sortParticipants();
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$processTypingsUpdate$9();
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$processTypingsUpdate$8(long j) {
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.applyGroupCallVisibleParticipants, Long.valueOf(j));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$processTypingsUpdate$9() {
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Integer.valueOf(this.chatId), this.call.id, Boolean.FALSE);
        }

        private void loadUnknownParticipants(final ArrayList<Integer> arrayList, boolean z, final OnParticipantsLoad onParticipantsLoad) {
            TLRPC$InputPeer tLRPC$TL_inputPeerChannel;
            final HashSet<Integer> hashSet = z ? this.loadingUids : this.loadingSsrcs;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                if (hashSet.contains(arrayList.get(i))) {
                    arrayList.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
            if (arrayList.isEmpty()) {
                return;
            }
            final int i2 = this.lastLoadGuid + 1;
            this.lastLoadGuid = i2;
            this.loadingGuids.add(Integer.valueOf(i2));
            hashSet.addAll(arrayList);
            TLRPC$TL_phone_getGroupParticipants tLRPC$TL_phone_getGroupParticipants = new TLRPC$TL_phone_getGroupParticipants();
            tLRPC$TL_phone_getGroupParticipants.call = getInputGroupCall();
            int size2 = arrayList.size();
            for (int i3 = 0; i3 < size2; i3++) {
                int iIntValue = arrayList.get(i3).intValue();
                if (!z) {
                    tLRPC$TL_phone_getGroupParticipants.sources.add(Integer.valueOf(iIntValue));
                } else if (iIntValue > 0) {
                    TLRPC$TL_inputPeerUser tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerUser();
                    tLRPC$TL_inputPeerUser.user_id = iIntValue;
                    tLRPC$TL_phone_getGroupParticipants.ids.add(tLRPC$TL_inputPeerUser);
                } else {
                    int i4 = -iIntValue;
                    TLRPC$Chat chat = this.currentAccount.getMessagesController().getChat(Integer.valueOf(i4));
                    if (chat == null || ChatObject.isChannel(chat)) {
                        tLRPC$TL_inputPeerChannel = new TLRPC$TL_inputPeerChannel();
                        tLRPC$TL_inputPeerChannel.channel_id = i4;
                    } else {
                        tLRPC$TL_inputPeerChannel = new TLRPC$TL_inputPeerChat();
                        tLRPC$TL_inputPeerChannel.chat_id = i4;
                    }
                    tLRPC$TL_phone_getGroupParticipants.ids.add(tLRPC$TL_inputPeerChannel);
                }
            }
            tLRPC$TL_phone_getGroupParticipants.offset = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            tLRPC$TL_phone_getGroupParticipants.limit = 100;
            this.currentAccount.getCallProxy().loadUnknownParticipants(tLRPC$TL_phone_getGroupParticipants, new RequestDelegate() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda27
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadUnknownParticipants$12(i2, onParticipantsLoad, arrayList, hashSet, tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$loadUnknownParticipants$12(final int i, final OnParticipantsLoad onParticipantsLoad, final ArrayList arrayList, final HashSet hashSet, final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda11
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadUnknownParticipants$11(i, tLObject, onParticipantsLoad, arrayList, hashSet);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$loadUnknownParticipants$11(int i, TLObject tLObject, OnParticipantsLoad onParticipantsLoad, ArrayList arrayList, final HashSet hashSet) {
            if (this.loadingGuids.remove(Integer.valueOf(i))) {
                if (tLObject != null) {
                    TLRPC$TL_phone_groupParticipants tLRPC$TL_phone_groupParticipants = (TLRPC$TL_phone_groupParticipants) tLObject;
                    this.currentAccount.getMessagesController().putUsers(tLRPC$TL_phone_groupParticipants.users, false);
                    this.currentAccount.getMessagesController().putChats(tLRPC$TL_phone_groupParticipants.chats, false);
                    int size = tLRPC$TL_phone_groupParticipants.participants.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = tLRPC$TL_phone_groupParticipants.participants.get(i2);
                        int peerId = MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer);
                        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant2 = this.participants.get(peerId);
                        if (tLRPC$TL_groupCallParticipant2 != null) {
                            this.sortedParticipants.remove(tLRPC$TL_groupCallParticipant2);
                            processAllSources(tLRPC$TL_groupCallParticipant2, false);
                        }
                        this.participants.put(peerId, tLRPC$TL_groupCallParticipant);
                        this.sortedParticipants.add(tLRPC$TL_groupCallParticipant);
                        processAllSources(tLRPC$TL_groupCallParticipant, true);
                        if (this.invitedUsersMap.contains(Integer.valueOf(peerId))) {
                            Integer numValueOf = Integer.valueOf(peerId);
                            this.invitedUsersMap.remove(numValueOf);
                            this.invitedUsers.remove(numValueOf);
                        }
                    }
                    if (this.call.participants_count < this.participants.size()) {
                        this.call.participants_count = this.participants.size();
                    }
                    sortParticipants();
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda7
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$loadUnknownParticipants$10();
                        }
                    });
                    if (onParticipantsLoad != null) {
                        onParticipantsLoad.onLoad(arrayList);
                    } else {
                        setParticiapantsVolume();
                    }
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    hashSet.getClass();
                    Iterable$EL.forEach(arrayList, new Consumer() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda22
                        @Override // j$.util.function.Consumer
                        public final void accept(Object obj) {
                            hashSet.remove((Integer) obj);
                        }

                        @Override // j$.util.function.Consumer
                        public /* synthetic */ Consumer andThen(Consumer consumer) {
                            return Consumer.CC.$default$andThen(this, consumer);
                        }
                    });
                } else {
                    hashSet.removeAll(arrayList);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$loadUnknownParticipants$10() {
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Integer.valueOf(this.chatId), this.call.id, Boolean.FALSE);
        }

        private void processAllSources(TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant, boolean z) {
            int i;
            int i2 = tLRPC$TL_groupCallParticipant.source;
            if (i2 != 0) {
                if (z) {
                    this.participantsBySources.put(i2, tLRPC$TL_groupCallParticipant);
                } else {
                    this.participantsBySources.remove(i2);
                }
            }
            int i3 = 0;
            while (i3 < 2) {
                TLRPC$TL_groupCallParticipantVideo tLRPC$TL_groupCallParticipantVideo = i3 == 0 ? tLRPC$TL_groupCallParticipant.video : tLRPC$TL_groupCallParticipant.presentation;
                if (tLRPC$TL_groupCallParticipantVideo != null) {
                    if ((2 & tLRPC$TL_groupCallParticipantVideo.flags) != 0 && (i = tLRPC$TL_groupCallParticipantVideo.audio_source) != 0) {
                        if (z) {
                            this.participantsBySources.put(i, tLRPC$TL_groupCallParticipant);
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
                            if (z) {
                                sparseArray.put(iIntValue, tLRPC$TL_groupCallParticipant);
                            } else {
                                sparseArray.remove(iIntValue);
                            }
                        }
                    }
                    if (z) {
                        if (i3 == 0) {
                            tLRPC$TL_groupCallParticipant.videoEndpoint = tLRPC$TL_groupCallParticipantVideo.endpoint;
                        } else {
                            tLRPC$TL_groupCallParticipant.presentationEndpoint = tLRPC$TL_groupCallParticipantVideo.endpoint;
                        }
                    } else if (i3 == 0) {
                        tLRPC$TL_groupCallParticipant.videoEndpoint = null;
                    } else {
                        tLRPC$TL_groupCallParticipant.presentationEndpoint = null;
                    }
                }
                i3++;
            }
        }

        public void processVoiceLevelsUpdate(int[] iArr, float[] fArr, boolean[] zArr) {
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant;
            int i;
            long j;
            long j2;
            boolean z;
            boolean z2;
            int currentTime = this.currentAccount.getConnectionsManager().getCurrentTime();
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            long jUptimeMillis = SystemClock.uptimeMillis();
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda15
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processVoiceLevelsUpdate$13(jElapsedRealtime);
                }
            });
            int i2 = 0;
            ArrayList<Integer> arrayList = null;
            boolean z3 = false;
            boolean z4 = false;
            while (i2 < iArr.length) {
                if (iArr[i2] == 0) {
                    tLRPC$TL_groupCallParticipant = this.participants.get(getSelfId());
                } else {
                    tLRPC$TL_groupCallParticipant = this.participantsBySources.get(iArr[i2]);
                }
                if (tLRPC$TL_groupCallParticipant != null) {
                    tLRPC$TL_groupCallParticipant.hasVoice = zArr[i2];
                    if (zArr[i2] || jElapsedRealtime - tLRPC$TL_groupCallParticipant.lastVoiceUpdateTime > 500) {
                        tLRPC$TL_groupCallParticipant.hasVoiceDelayed = zArr[i2];
                        tLRPC$TL_groupCallParticipant.lastVoiceUpdateTime = jElapsedRealtime;
                    }
                    long peerId = MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer);
                    if (fArr[i2] > 0.1f) {
                        z = z4;
                        if (zArr[i2] && tLRPC$TL_groupCallParticipant.lastTypingDate + 1 < currentTime) {
                            if (jElapsedRealtime != tLRPC$TL_groupCallParticipant.lastVisibleDate) {
                                tLRPC$TL_groupCallParticipant.active_date = currentTime;
                            }
                            tLRPC$TL_groupCallParticipant.lastTypingDate = currentTime;
                            z3 = true;
                        }
                        tLRPC$TL_groupCallParticipant.lastSpeakTime = jUptimeMillis;
                        tLRPC$TL_groupCallParticipant.amplitude = fArr[i2];
                        i = currentTime;
                        if (this.currentSpeakingPeers.get(peerId, null) == null) {
                            if (peerId > 0) {
                                j = jElapsedRealtime;
                                TLRPC$User user = MessagesController.getInstance(this.currentAccount.getCurrentAccount()).getUser(Long.valueOf(peerId));
                                StringBuilder sb = new StringBuilder();
                                sb.append("add to current speaking ");
                                sb.append(peerId);
                                sb.append(" ");
                                sb.append(user == null ? null : user.first_name);
                                Log.d("GroupCall", sb.toString());
                                z2 = z3;
                            } else {
                                j = jElapsedRealtime;
                                z2 = z3;
                                TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount.getCurrentAccount()).getChat(Long.valueOf(-peerId));
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("add to current speaking ");
                                sb2.append(peerId);
                                sb2.append(" ");
                                sb2.append(chat == null ? null : chat.title);
                                Log.d("GroupCall", sb2.toString());
                            }
                            this.currentSpeakingPeers.put(peerId, tLRPC$TL_groupCallParticipant);
                            z3 = z2;
                            j2 = jUptimeMillis;
                            z4 = true;
                        } else {
                            j = jElapsedRealtime;
                            j2 = jUptimeMillis;
                        }
                    } else {
                        i = currentTime;
                        j = jElapsedRealtime;
                        boolean z5 = z4;
                        if (jUptimeMillis - tLRPC$TL_groupCallParticipant.lastSpeakTime < 500 || this.currentSpeakingPeers.get(peerId, null) == null) {
                            j2 = jUptimeMillis;
                            z4 = z5;
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
                                j2 = jUptimeMillis;
                            } else {
                                j2 = jUptimeMillis;
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
                    i2++;
                    jUptimeMillis = j2;
                    currentTime = i;
                    jElapsedRealtime = j;
                } else {
                    i = currentTime;
                    j = jElapsedRealtime;
                    j2 = jUptimeMillis;
                    z = z4;
                    if (iArr[i2] != 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                        }
                        arrayList.add(Integer.valueOf(iArr[i2]));
                    }
                }
                z4 = z;
                i2++;
                jUptimeMillis = j2;
                currentTime = i;
                jElapsedRealtime = j;
            }
            boolean z6 = z4;
            if (arrayList != null) {
                loadUnknownParticipants(arrayList, false, null);
            }
            if (z3) {
                sortParticipants();
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$processVoiceLevelsUpdate$14();
                    }
                });
            }
            if (z6) {
                if (this.currentSpeakingPeers.size() > 0) {
                    AndroidUtilities.cancelRunOnUIThread(this.updateCurrentSpeakingRunnable);
                    AndroidUtilities.runOnUIThread(this.updateCurrentSpeakingRunnable, 550L);
                }
                this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallSpeakingUsersUpdated, Integer.valueOf(this.chatId), this.call.id, Boolean.FALSE);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$processVoiceLevelsUpdate$13(long j) {
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.applyGroupCallVisibleParticipants, Long.valueOf(j));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$processVoiceLevelsUpdate$14() {
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Integer.valueOf(this.chatId), this.call.id, Boolean.FALSE);
        }

        public void updateVisibleParticipants() {
            sortParticipants();
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Integer.valueOf(this.chatId), this.call.id, Boolean.FALSE, 0L);
        }

        public void clearVideFramesInfo() {
            for (int i = 0; i < this.sortedParticipants.size(); i++) {
                this.sortedParticipants.get(i).hasCameraFrame = 0;
                this.sortedParticipants.get(i).hasPresentationFrame = 0;
                this.sortedParticipants.get(i).videoIndex = 0;
            }
            sortParticipants();
        }

        public void processUnknownVideoParticipants(int[] iArr, OnParticipantsLoad onParticipantsLoad) {
            ArrayList<Integer> arrayList = null;
            for (int i = 0; i < iArr.length; i++) {
                if (this.participantsBySources.get(iArr[i]) == null && this.participantsByVideoSources.get(iArr[i]) == null && this.participantsByPresentationSources.get(iArr[i]) == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(Integer.valueOf(iArr[i]));
                }
            }
            if (arrayList == null) {
                onParticipantsLoad.onLoad(null);
            } else if (onParticipantsLoad != null) {
                onParticipantsLoad.onLoad(arrayList);
            }
        }

        private int isValidUpdate(TLRPC$TL_updateGroupCallParticipants tLRPC$TL_updateGroupCallParticipants) {
            int i = this.call.version;
            int i2 = i + 1;
            int i3 = tLRPC$TL_updateGroupCallParticipants.version;
            if (i2 == i3 || i == i3) {
                return 0;
            }
            return i < i3 ? 1 : 2;
        }

        public void setSelfPeer(TLRPC$InputPeer tLRPC$InputPeer) {
            if (tLRPC$InputPeer == null) {
                this.selfPeer = null;
                return;
            }
            if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerUser) {
                TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
                this.selfPeer = tLRPC$TL_peerUser;
                tLRPC$TL_peerUser.user_id = tLRPC$InputPeer.user_id;
            } else if (tLRPC$InputPeer instanceof TLRPC$TL_inputPeerChat) {
                TLRPC$TL_peerChat tLRPC$TL_peerChat = new TLRPC$TL_peerChat();
                this.selfPeer = tLRPC$TL_peerChat;
                tLRPC$TL_peerChat.chat_id = tLRPC$InputPeer.chat_id;
            } else {
                TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
                this.selfPeer = tLRPC$TL_peerChannel;
                tLRPC$TL_peerChannel.channel_id = tLRPC$InputPeer.channel_id;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int lambda$processUpdatesQueue$15(TLRPC$TL_updateGroupCallParticipants tLRPC$TL_updateGroupCallParticipants, TLRPC$TL_updateGroupCallParticipants tLRPC$TL_updateGroupCallParticipants2) {
            return AndroidUtilities.compare(tLRPC$TL_updateGroupCallParticipants.version, tLRPC$TL_updateGroupCallParticipants2.version);
        }

        private void processUpdatesQueue() {
            Collections.sort(this.updatesQueue, new Comparator() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda21
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ChatObject.Call.lambda$processUpdatesQueue$15((TLRPC$TL_updateGroupCallParticipants) obj, (TLRPC$TL_updateGroupCallParticipants) obj2);
                }
            });
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
            ChatObject$Call$$ExternalSyntheticLambda4 chatObject$Call$$ExternalSyntheticLambda4 = new ChatObject$Call$$ExternalSyntheticLambda4(this);
            this.checkQueueRunnable = chatObject$Call$$ExternalSyntheticLambda4;
            AndroidUtilities.runOnUIThread(chatObject$Call$$ExternalSyntheticLambda4, 1000L);
        }

        public void reloadGroupCall() {
            TLRPC$TL_phone_getGroupCall tLRPC$TL_phone_getGroupCall = new TLRPC$TL_phone_getGroupCall();
            tLRPC$TL_phone_getGroupCall.call = getInputGroupCall();
            this.currentAccount.getConnectionsManager().sendRequest(tLRPC$TL_phone_getGroupCall, new RequestDelegate() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda24
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$reloadGroupCall$17(tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$reloadGroupCall$17(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda17
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$reloadGroupCall$16(tLObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$reloadGroupCall$16(TLObject tLObject) {
            if (tLObject instanceof TLRPC$TL_phone_groupCall) {
                TLRPC$TL_phone_groupCall tLRPC$TL_phone_groupCall = (TLRPC$TL_phone_groupCall) tLObject;
                this.call = tLRPC$TL_phone_groupCall.call;
                this.currentAccount.getMessagesController().putUsers(tLRPC$TL_phone_groupCall.users, false);
                this.currentAccount.getMessagesController().putChats(tLRPC$TL_phone_groupCall.chats, false);
            }
        }

        private void loadGroupCall() {
            if (this.loadingGroupCall || SystemClock.elapsedRealtime() - this.lastGroupCallReloadTime < 30000) {
                return;
            }
            this.loadingGroupCall = true;
            TLRPC$TL_phone_getGroupParticipants tLRPC$TL_phone_getGroupParticipants = new TLRPC$TL_phone_getGroupParticipants();
            tLRPC$TL_phone_getGroupParticipants.call = getInputGroupCall();
            tLRPC$TL_phone_getGroupParticipants.offset = io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
            tLRPC$TL_phone_getGroupParticipants.limit = 1;
            this.currentAccount.getConnectionsManager().sendRequest(tLRPC$TL_phone_getGroupParticipants, new RequestDelegate() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda23
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$loadGroupCall$20(tLObject, tLRPC$TL_error);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$loadGroupCall$20(final TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda16
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$loadGroupCall$19(tLObject);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$loadGroupCall$19(TLObject tLObject) {
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
                    AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda8
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.lambda$loadGroupCall$18();
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$loadGroupCall$18() {
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Integer.valueOf(this.chatId), this.call.id, Boolean.FALSE);
        }

        public void processParticipantsUpdate(TLRPC$TL_updateGroupCallParticipants tLRPC$TL_updateGroupCallParticipants, boolean z) {
            int i;
            int i2;
            boolean z2;
            boolean z3;
            int i3;
            boolean z4;
            Object obj;
            long j;
            boolean z5;
            TLRPC$TL_groupCallParticipantVideo tLRPC$TL_groupCallParticipantVideo;
            boolean z6;
            if (!z) {
                int size = tLRPC$TL_updateGroupCallParticipants.participants.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        z6 = false;
                        break;
                    } else {
                        if (tLRPC$TL_updateGroupCallParticipants.participants.get(i4).versioned) {
                            z6 = true;
                            break;
                        }
                        i4++;
                    }
                }
                if (z6 && this.call.version + 1 < tLRPC$TL_updateGroupCallParticipants.version) {
                    if (this.reloadingMembers || this.updatesStartWaitTime == 0 || Math.abs(System.currentTimeMillis() - this.updatesStartWaitTime) <= 1500) {
                        if (this.updatesStartWaitTime == 0) {
                            this.updatesStartWaitTime = System.currentTimeMillis();
                        }
                        if (BuildVars.LOGS_ENABLED) {
                            FileLog.d("add TL_updateGroupCallParticipants to queue " + tLRPC$TL_updateGroupCallParticipants.version);
                        }
                        this.updatesQueue.add(tLRPC$TL_updateGroupCallParticipants);
                        if (this.checkQueueRunnable == null) {
                            ChatObject$Call$$ExternalSyntheticLambda4 chatObject$Call$$ExternalSyntheticLambda4 = new ChatObject$Call$$ExternalSyntheticLambda4(this);
                            this.checkQueueRunnable = chatObject$Call$$ExternalSyntheticLambda4;
                            AndroidUtilities.runOnUIThread(chatObject$Call$$ExternalSyntheticLambda4, 1500L);
                            return;
                        }
                        return;
                    }
                    this.nextLoadOffset = null;
                    loadMembers(true);
                    return;
                }
                if (z6 && tLRPC$TL_updateGroupCallParticipants.version < this.call.version) {
                    if (BuildVars.LOGS_ENABLED) {
                        FileLog.d("ignore processParticipantsUpdate because of version");
                        return;
                    }
                    return;
                }
            }
            int selfId = getSelfId();
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.sortedParticipants.isEmpty()) {
                i = 0;
            } else {
                ArrayList<TLRPC$TL_groupCallParticipant> arrayList = this.sortedParticipants;
                i = arrayList.get(arrayList.size() - 1).date;
            }
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processParticipantsUpdate$21(jElapsedRealtime);
                }
            });
            int size2 = tLRPC$TL_updateGroupCallParticipants.participants.size();
            int i5 = 0;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            while (i5 < size2) {
                TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipantUpdateParticipant = tLRPC$TL_updateGroupCallParticipants.participants.get(i5);
                int peerId = MessageObject.getPeerId(tLRPC$TL_groupCallParticipantUpdateParticipant.peer);
                if (BuildVars.LOGS_ENABLED) {
                    FileLog.d("process participant " + peerId + " left = " + tLRPC$TL_groupCallParticipantUpdateParticipant.left + " versioned " + tLRPC$TL_groupCallParticipantUpdateParticipant.versioned + " flags = " + tLRPC$TL_groupCallParticipantUpdateParticipant.flags + " self = " + selfId + " volume = " + tLRPC$TL_groupCallParticipantUpdateParticipant.volume);
                }
                TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = this.participants.get(peerId);
                GroupCallModels.GroupVoiceChatParticipantUpdate groupVoiceChatParticipantUpdate = tLRPC$TL_groupCallParticipantUpdateParticipant.updateObject;
                if (groupVoiceChatParticipantUpdate == null) {
                    i2 = size2;
                    z3 = z8;
                    z2 = z9;
                } else {
                    i2 = size2;
                    z2 = z9;
                    z3 = z8;
                    if (groupVoiceChatParticipantUpdate.action == GroupCallModels.GroupVoiceChatParticipantUpdateAction.Delete) {
                        if (tLRPC$TL_groupCallParticipant == null && tLRPC$TL_updateGroupCallParticipants.version == this.call.version) {
                            if (BuildVars.LOGS_ENABLED) {
                                FileLog.d("unknowd participant left, reload call");
                            }
                            z7 = true;
                        }
                        if (tLRPC$TL_groupCallParticipant != null) {
                            this.participants.remove(peerId);
                            processAllSources(tLRPC$TL_groupCallParticipant, false);
                            this.sortedParticipants.remove(tLRPC$TL_groupCallParticipant);
                            this.visibleParticipants.remove(tLRPC$TL_groupCallParticipant);
                            long j2 = peerId;
                            if (this.currentSpeakingPeers.get(j2, null) != null) {
                                if (peerId > 0) {
                                    z5 = z7;
                                    TLRPC$User user = MessagesController.getInstance(this.currentAccount.getCurrentAccount()).getUser(Integer.valueOf(peerId));
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("left remove from speaking ");
                                    sb.append(peerId);
                                    sb.append(" ");
                                    sb.append(user == null ? null : user.first_name);
                                    Log.d("GroupCall", sb.toString());
                                } else {
                                    z5 = z7;
                                    TLRPC$Chat chat = MessagesController.getInstance(this.currentAccount.getCurrentAccount()).getChat(Integer.valueOf(-peerId));
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("left remove from speaking ");
                                    sb2.append(peerId);
                                    sb2.append(" ");
                                    sb2.append(chat == null ? null : chat.title);
                                    Log.d("GroupCall", sb2.toString());
                                }
                                this.currentSpeakingPeers.remove(j2);
                                z10 = true;
                            } else {
                                z5 = z7;
                            }
                            int i6 = 0;
                            while (i6 < this.visibleVideoParticipants.size()) {
                                if (MessageObject.getPeerId(this.visibleVideoParticipants.get(i6).participant.peer) == MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer)) {
                                    this.visibleVideoParticipants.remove(i6);
                                    i6--;
                                }
                                i6++;
                            }
                        } else {
                            z5 = z7;
                        }
                        TLRPC$GroupCall tLRPC$GroupCall = this.call;
                        int i7 = tLRPC$GroupCall.participants_count - 1;
                        tLRPC$GroupCall.participants_count = i7;
                        if (i7 < 0) {
                            tLRPC$GroupCall.participants_count = 0;
                        }
                        i3 = i5;
                        z9 = z2;
                        j = 0;
                        obj = null;
                    } else {
                        if (this.invitedUsersMap.contains(Integer.valueOf(peerId))) {
                            Integer numValueOf = Integer.valueOf(peerId);
                            this.invitedUsersMap.remove(numValueOf);
                            this.invitedUsers.remove(numValueOf);
                        }
                        if (tLRPC$TL_groupCallParticipant != null) {
                            if (BuildVars.LOGS_ENABLED) {
                                FileLog.d("new participant, update old");
                            }
                            if (groupVoiceChatParticipantUpdate.action == GroupCallModels.GroupVoiceChatParticipantUpdateAction.Edit) {
                                tLRPC$TL_groupCallParticipantUpdateParticipant = CallConverter.updateParticipant(tLRPC$TL_groupCallParticipant, groupVoiceChatParticipantUpdate, tLRPC$TL_groupCallParticipantUpdateParticipant.updateFromNotif, selfId);
                            }
                            if (tLRPC$TL_groupCallParticipantUpdateParticipant != null) {
                                tLRPC$TL_groupCallParticipant.muted = tLRPC$TL_groupCallParticipantUpdateParticipant.muted;
                                if (tLRPC$TL_groupCallParticipantUpdateParticipant.muted) {
                                    i3 = i5;
                                    long j3 = peerId;
                                    z4 = z7;
                                    obj = null;
                                    if (this.currentSpeakingPeers.get(j3, null) != null) {
                                        this.currentSpeakingPeers.remove(j3);
                                        if (peerId > 0) {
                                            TLRPC$User user2 = MessagesController.getInstance(this.currentAccount.getCurrentAccount()).getUser(Integer.valueOf(peerId));
                                            StringBuilder sb3 = new StringBuilder();
                                            sb3.append("muted remove from speaking ");
                                            sb3.append(peerId);
                                            sb3.append(" ");
                                            sb3.append(user2 == null ? null : user2.first_name);
                                            Log.d("GroupCall", sb3.toString());
                                        } else {
                                            TLRPC$Chat chat2 = MessagesController.getInstance(this.currentAccount.getCurrentAccount()).getChat(Integer.valueOf(-peerId));
                                            StringBuilder sb4 = new StringBuilder();
                                            sb4.append("muted remove from speaking ");
                                            sb4.append(peerId);
                                            sb4.append(" ");
                                            sb4.append(chat2 == null ? null : chat2.title);
                                            Log.d("GroupCall", sb4.toString());
                                        }
                                        z10 = true;
                                    }
                                } else {
                                    i3 = i5;
                                    z4 = z7;
                                    obj = null;
                                }
                                if (!tLRPC$TL_groupCallParticipantUpdateParticipant.min) {
                                    tLRPC$TL_groupCallParticipant.volume = tLRPC$TL_groupCallParticipantUpdateParticipant.volume;
                                    tLRPC$TL_groupCallParticipant.muted_by_you = tLRPC$TL_groupCallParticipantUpdateParticipant.muted_by_you;
                                } else {
                                    int i8 = tLRPC$TL_groupCallParticipantUpdateParticipant.flags;
                                    if ((i8 & 128) != 0 && (tLRPC$TL_groupCallParticipant.flags & 128) == 0) {
                                        tLRPC$TL_groupCallParticipantUpdateParticipant.flags = i8 & (-129);
                                    }
                                    if (tLRPC$TL_groupCallParticipantUpdateParticipant.volume_by_admin && tLRPC$TL_groupCallParticipant.volume_by_admin) {
                                        tLRPC$TL_groupCallParticipant.volume = tLRPC$TL_groupCallParticipantUpdateParticipant.volume;
                                    }
                                }
                                tLRPC$TL_groupCallParticipant.flags = tLRPC$TL_groupCallParticipantUpdateParticipant.flags;
                                tLRPC$TL_groupCallParticipant.can_self_unmute = tLRPC$TL_groupCallParticipantUpdateParticipant.can_self_unmute;
                                tLRPC$TL_groupCallParticipant.video_joined = tLRPC$TL_groupCallParticipantUpdateParticipant.video_joined;
                                if (tLRPC$TL_groupCallParticipant.raise_hand_rating == 0 && tLRPC$TL_groupCallParticipantUpdateParticipant.raise_hand_rating != 0) {
                                    tLRPC$TL_groupCallParticipant.lastRaiseHandDate = SystemClock.elapsedRealtime();
                                }
                                tLRPC$TL_groupCallParticipant.raise_hand_rating = tLRPC$TL_groupCallParticipantUpdateParticipant.raise_hand_rating;
                                tLRPC$TL_groupCallParticipant.date = tLRPC$TL_groupCallParticipantUpdateParticipant.date;
                                int iMax = Math.max(tLRPC$TL_groupCallParticipant.active_date, tLRPC$TL_groupCallParticipantUpdateParticipant.active_date);
                                tLRPC$TL_groupCallParticipant.lastTypingDate = iMax;
                                if (jElapsedRealtime != tLRPC$TL_groupCallParticipant.lastVisibleDate) {
                                    tLRPC$TL_groupCallParticipant.active_date = iMax;
                                }
                                tLRPC$TL_groupCallParticipant.canManageCallVoiceChat = tLRPC$TL_groupCallParticipantUpdateParticipant.canManageCallVoiceChat;
                                if (tLRPC$TL_groupCallParticipant.source != tLRPC$TL_groupCallParticipantUpdateParticipant.source || !isSameVideo(tLRPC$TL_groupCallParticipant.video, tLRPC$TL_groupCallParticipantUpdateParticipant.video) || !isSameVideo(tLRPC$TL_groupCallParticipant.presentation, tLRPC$TL_groupCallParticipantUpdateParticipant.presentation)) {
                                    processAllSources(tLRPC$TL_groupCallParticipant, false);
                                    tLRPC$TL_groupCallParticipant.video = tLRPC$TL_groupCallParticipantUpdateParticipant.video;
                                    tLRPC$TL_groupCallParticipant.presentation = tLRPC$TL_groupCallParticipantUpdateParticipant.presentation;
                                    tLRPC$TL_groupCallParticipant.source = tLRPC$TL_groupCallParticipantUpdateParticipant.source;
                                    processAllSources(tLRPC$TL_groupCallParticipant, true);
                                    tLRPC$TL_groupCallParticipantUpdateParticipant.presentationEndpoint = tLRPC$TL_groupCallParticipant.presentationEndpoint;
                                    tLRPC$TL_groupCallParticipantUpdateParticipant.videoEndpoint = tLRPC$TL_groupCallParticipant.videoEndpoint;
                                    tLRPC$TL_groupCallParticipantUpdateParticipant.videoIndex = tLRPC$TL_groupCallParticipant.videoIndex;
                                } else {
                                    TLRPC$TL_groupCallParticipantVideo tLRPC$TL_groupCallParticipantVideo2 = tLRPC$TL_groupCallParticipant.video;
                                    if (tLRPC$TL_groupCallParticipantVideo2 != null && (tLRPC$TL_groupCallParticipantVideo = tLRPC$TL_groupCallParticipantUpdateParticipant.video) != null) {
                                        tLRPC$TL_groupCallParticipantVideo2.paused = tLRPC$TL_groupCallParticipantVideo.paused;
                                    }
                                }
                                j = 0;
                            }
                        } else {
                            i3 = i5;
                            z4 = z7;
                            obj = null;
                            if (tLRPC$TL_groupCallParticipantUpdateParticipant.just_joined) {
                                TLRPC$GroupCall tLRPC$GroupCall2 = this.call;
                                tLRPC$GroupCall2.participants_count++;
                                if (tLRPC$TL_updateGroupCallParticipants.version == tLRPC$GroupCall2.version) {
                                    if (BuildVars.LOGS_ENABLED) {
                                        FileLog.d("new participant, just joined, reload call");
                                    }
                                    z4 = true;
                                } else if (BuildVars.LOGS_ENABLED) {
                                    FileLog.d("new participant, just joined");
                                }
                            }
                            j = 0;
                            if (tLRPC$TL_groupCallParticipantUpdateParticipant.raise_hand_rating != 0) {
                                tLRPC$TL_groupCallParticipantUpdateParticipant.lastRaiseHandDate = SystemClock.elapsedRealtime();
                            }
                            if (peerId == selfId || this.sortedParticipants.size() < 20 || tLRPC$TL_groupCallParticipantUpdateParticipant.date <= i || tLRPC$TL_groupCallParticipantUpdateParticipant.active_date != 0 || tLRPC$TL_groupCallParticipantUpdateParticipant.can_self_unmute || !tLRPC$TL_groupCallParticipantUpdateParticipant.muted || !tLRPC$TL_groupCallParticipantUpdateParticipant.min || this.membersLoadEndReached) {
                                this.sortedParticipants.add(tLRPC$TL_groupCallParticipantUpdateParticipant);
                            }
                            this.participants.put(peerId, tLRPC$TL_groupCallParticipantUpdateParticipant);
                            this.currentAccount.getDialogsProxy().loadGroupVoiceChatParticipantAbs(peerId);
                            processAllSources(tLRPC$TL_groupCallParticipantUpdateParticipant, true);
                        }
                        if (peerId == selfId && tLRPC$TL_groupCallParticipantUpdateParticipant.active_date == 0 && (tLRPC$TL_groupCallParticipantUpdateParticipant.can_self_unmute || !tLRPC$TL_groupCallParticipantUpdateParticipant.muted)) {
                            tLRPC$TL_groupCallParticipantUpdateParticipant.active_date = this.currentAccount.getConnectionsManager().getCurrentTime();
                        }
                        z5 = z4;
                        z9 = true;
                    }
                    z8 = true;
                    if (peerId == selfId) {
                        z11 = true;
                    }
                    z7 = z5;
                    i5 = i3 + 1;
                    size2 = i2;
                }
                i3 = i5;
                z9 = z2;
                z8 = z3;
                j = 0;
                z5 = z7;
                obj = null;
                z7 = z5;
                i5 = i3 + 1;
                size2 = i2;
            }
            boolean z12 = z7;
            boolean z13 = z8;
            boolean z14 = z9;
            int i9 = tLRPC$TL_updateGroupCallParticipants.version;
            TLRPC$GroupCall tLRPC$GroupCall3 = this.call;
            if (i9 > tLRPC$GroupCall3.version) {
                tLRPC$GroupCall3.version = i9;
                if (!z) {
                    processUpdatesQueue();
                }
            }
            if (this.call.participants_count < this.participants.size()) {
                this.call.participants_count = this.participants.size();
            }
            if (BuildVars.LOGS_ENABLED) {
                FileLog.d("new participants count after update " + this.call.participants_count);
            }
            if (z12) {
                loadGroupCall();
            }
            if (z13) {
                if (z14) {
                    sortParticipants();
                }
                final boolean z15 = z11;
                AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda18
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$processParticipantsUpdate$22(z15);
                    }
                });
            }
            if (z10) {
                this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallSpeakingUsersUpdated, Integer.valueOf(this.chatId), this.call.id, Boolean.FALSE);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$processParticipantsUpdate$21(long j) {
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.applyGroupCallVisibleParticipants, Long.valueOf(j));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$processParticipantsUpdate$22(boolean z) {
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Integer.valueOf(this.chatId), this.call.id, Boolean.valueOf(z));
        }

        private boolean isSameVideo(TLRPC$TL_groupCallParticipantVideo tLRPC$TL_groupCallParticipantVideo, TLRPC$TL_groupCallParticipantVideo tLRPC$TL_groupCallParticipantVideo2) {
            if ((tLRPC$TL_groupCallParticipantVideo == null && tLRPC$TL_groupCallParticipantVideo2 != null) || (tLRPC$TL_groupCallParticipantVideo != null && tLRPC$TL_groupCallParticipantVideo2 == null)) {
                return false;
            }
            if (tLRPC$TL_groupCallParticipantVideo != null && tLRPC$TL_groupCallParticipantVideo2 != null) {
                if (!TextUtils.equals(tLRPC$TL_groupCallParticipantVideo.endpoint, tLRPC$TL_groupCallParticipantVideo2.endpoint) || tLRPC$TL_groupCallParticipantVideo.source_groups.size() != tLRPC$TL_groupCallParticipantVideo2.source_groups.size()) {
                    return false;
                }
                int size = tLRPC$TL_groupCallParticipantVideo.source_groups.size();
                for (int i = 0; i < size; i++) {
                    TLRPC$TL_groupCallParticipantVideoSourceGroup tLRPC$TL_groupCallParticipantVideoSourceGroup = tLRPC$TL_groupCallParticipantVideo.source_groups.get(i);
                    TLRPC$TL_groupCallParticipantVideoSourceGroup tLRPC$TL_groupCallParticipantVideoSourceGroup2 = tLRPC$TL_groupCallParticipantVideo2.source_groups.get(i);
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

        public void processGroupCallUpdate(TLRPC$TL_updateGroupCall tLRPC$TL_updateGroupCall) {
            GroupCallModels.GroupVoiceChatUpdate groupVoiceChatUpdate = tLRPC$TL_updateGroupCall.updateObject;
            if (groupVoiceChatUpdate != null) {
                TLRPC$GroupCall tLRPC$GroupCallUpdateWithCallUpdate = CallConverter.updateWithCallUpdate(this.chatId, this.call, groupVoiceChatUpdate);
                this.call = tLRPC$GroupCallUpdateWithCallUpdate;
                TLRPC$GroupCall tLRPC$GroupCall = tLRPC$TL_updateGroupCall.call;
                if (tLRPC$GroupCall != null) {
                    tLRPC$GroupCallUpdateWithCallUpdate.params = tLRPC$GroupCall.params;
                }
                tLRPC$TL_updateGroupCall.call = tLRPC$GroupCallUpdateWithCallUpdate;
            } else {
                if (this.call.version < tLRPC$TL_updateGroupCall.call.version) {
                    this.nextLoadOffset = null;
                    loadMembers(true);
                }
                this.call = tLRPC$TL_updateGroupCall.call;
            }
            if (this.call instanceof TLRPC$TL_groupCallDiscarded) {
                Utilities.stageQueue.cancelRunnable(this.getGroupVoiceChatUpdateRunnable);
            }
            this.recording = this.call.record_start_date != 0;
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$processGroupCallUpdate$23();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$processGroupCallUpdate$23() {
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Integer.valueOf(this.chatId), this.call.id, Boolean.FALSE);
        }

        public TLRPC$TL_inputGroupCall getInputGroupCall() {
            TLRPC$TL_inputGroupCall tLRPC$TL_inputGroupCall = new TLRPC$TL_inputGroupCall();
            TLRPC$GroupCall tLRPC$GroupCall = this.call;
            tLRPC$TL_inputGroupCall.id = tLRPC$GroupCall.id;
            tLRPC$TL_inputGroupCall.access_hash = tLRPC$GroupCall.access_hash;
            tLRPC$TL_inputGroupCall.chat_id = this.chatId;
            return tLRPC$TL_inputGroupCall;
        }

        public static boolean videoIsActive(TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant, boolean z, Call call) {
            VoIPService sharedInstance;
            VideoParticipant videoParticipant;
            if (tLRPC$TL_groupCallParticipant == null || (sharedInstance = VoIPService.getSharedInstance()) == null) {
                return false;
            }
            if (tLRPC$TL_groupCallParticipant.self) {
                return sharedInstance.getVideoState(z) == 2;
            }
            VideoParticipant videoParticipant2 = call.rtmpStreamParticipant;
            if ((videoParticipant2 == null || videoParticipant2.participant != tLRPC$TL_groupCallParticipant) && (((videoParticipant = call.videoNotAvailableParticipant) == null || videoParticipant.participant != tLRPC$TL_groupCallParticipant) && call.participants.get(MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer)) == null)) {
                return false;
            }
            return z ? tLRPC$TL_groupCallParticipant.presentation != null : tLRPC$TL_groupCallParticipant.video != null;
        }

        public void sortParticipants() {
            TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant;
            int i;
            int size;
            VideoParticipant videoParticipant;
            this.visibleVideoParticipants.clear();
            this.visibleParticipants.clear();
            TLRPC$Chat chat = this.currentAccount.getMessagesController().getChat(Integer.valueOf(this.chatId));
            final boolean zCanManageCalls = ChatObject.canManageCalls(chat);
            VideoParticipant videoParticipant2 = this.rtmpStreamParticipant;
            if (videoParticipant2 != null) {
                this.visibleVideoParticipants.add(videoParticipant2);
            }
            final int selfId = getSelfId();
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
            try {
                Collections.sort(this.sortedParticipants, new Comparator() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda20
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return this.f$0.lambda$sortParticipants$24(selfId, zCanManageCalls, (TLRPC$TL_groupCallParticipant) obj, (TLRPC$TL_groupCallParticipant) obj2);
                    }
                });
            } catch (Exception unused) {
            }
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
                        VideoParticipant videoParticipant3 = this.videoParticipantsCache.get(tLRPC$TL_groupCallParticipant4.videoEndpoint);
                        if (videoParticipant3 == null) {
                            videoParticipant3 = new VideoParticipant(tLRPC$TL_groupCallParticipant4, false, true);
                            this.videoParticipantsCache.put(tLRPC$TL_groupCallParticipant4.videoEndpoint, videoParticipant3);
                        } else {
                            videoParticipant3.participant = tLRPC$TL_groupCallParticipant4;
                            videoParticipant3.presentation = false;
                            videoParticipant3.hasSame = true;
                        }
                        VideoParticipant videoParticipant4 = this.videoParticipantsCache.get(tLRPC$TL_groupCallParticipant4.presentationEndpoint);
                        if (videoParticipant4 == null) {
                            videoParticipant4 = new VideoParticipant(tLRPC$TL_groupCallParticipant4, true, true);
                        } else {
                            videoParticipant4.participant = tLRPC$TL_groupCallParticipant4;
                            videoParticipant4.presentation = true;
                            videoParticipant4.hasSame = true;
                        }
                        this.visibleVideoParticipants.add(videoParticipant3);
                        if (videoParticipant3.aspectRatio > 1.0f) {
                            size4 = this.visibleVideoParticipants.size() - 1;
                        }
                        this.visibleVideoParticipants.add(videoParticipant4);
                        if (videoParticipant4.aspectRatio > 1.0f) {
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
                        VideoParticipant videoParticipant5 = this.videoParticipantsCache.get(zVideoIsActive3 ? tLRPC$TL_groupCallParticipant4.presentationEndpoint : tLRPC$TL_groupCallParticipant4.videoEndpoint);
                        if (videoParticipant5 == null) {
                            videoParticipant5 = new VideoParticipant(tLRPC$TL_groupCallParticipant4, zVideoIsActive3, false);
                            this.videoParticipantsCache.put(zVideoIsActive3 ? tLRPC$TL_groupCallParticipant4.presentationEndpoint : tLRPC$TL_groupCallParticipant4.videoEndpoint, videoParticipant5);
                        } else {
                            videoParticipant5.participant = tLRPC$TL_groupCallParticipant4;
                            videoParticipant5.presentation = zVideoIsActive3;
                            videoParticipant5.hasSame = false;
                        }
                        this.visibleVideoParticipants.add(videoParticipant5);
                        if (videoParticipant5.aspectRatio > 1.0f) {
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
        public /* synthetic */ int lambda$sortParticipants$24(int i, boolean z, TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant, TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant2) {
            int i2;
            int i3 = tLRPC$TL_groupCallParticipant.videoIndex;
            boolean z2 = i3 > 0;
            int i4 = tLRPC$TL_groupCallParticipant2.videoIndex;
            boolean z3 = i4 > 0;
            if (z2 && z3) {
                return i4 - i3;
            }
            if (z2) {
                return -1;
            }
            if (z3) {
                return 1;
            }
            int i5 = tLRPC$TL_groupCallParticipant.active_date;
            if (i5 != 0 && (i2 = tLRPC$TL_groupCallParticipant2.active_date) != 0) {
                return KeyCycleOscillator$1$$ExternalSyntheticBackport0.m(i2, i5);
            }
            if (i5 != 0) {
                return -1;
            }
            if (tLRPC$TL_groupCallParticipant2.active_date != 0) {
                return 1;
            }
            if (MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer) == i) {
                return -1;
            }
            if (MessageObject.getPeerId(tLRPC$TL_groupCallParticipant2.peer) == i) {
                return 1;
            }
            if (z) {
                long j = tLRPC$TL_groupCallParticipant.raise_hand_rating;
                if (j != 0) {
                    long j2 = tLRPC$TL_groupCallParticipant2.raise_hand_rating;
                    if (j2 != 0) {
                        return (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    }
                }
                if (j != 0) {
                    return -1;
                }
                if (tLRPC$TL_groupCallParticipant2.raise_hand_rating != 0) {
                    return 1;
                }
            }
            if (this.call.join_date_asc) {
                return KeyCycleOscillator$1$$ExternalSyntheticBackport0.m(tLRPC$TL_groupCallParticipant.date, tLRPC$TL_groupCallParticipant2.date);
            }
            return KeyCycleOscillator$1$$ExternalSyntheticBackport0.m(tLRPC$TL_groupCallParticipant2.date, tLRPC$TL_groupCallParticipant.date);
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
                AndroidUtilities.runOnUIThread(this.typingUpdateRunnable, iMin * CloseCodes.NORMAL_CLOSURE);
                this.typingUpdateRunnableScheduled = true;
            }
        }

        public void toggleRecord(String str, int i) {
            this.recording = !this.recording;
            TLRPC$TL_phone_toggleGroupCallRecord tLRPC$TL_phone_toggleGroupCallRecord = new TLRPC$TL_phone_toggleGroupCallRecord();
            tLRPC$TL_phone_toggleGroupCallRecord.call = getInputGroupCall();
            tLRPC$TL_phone_toggleGroupCallRecord.start = this.recording;
            if (str != null) {
                tLRPC$TL_phone_toggleGroupCallRecord.title = str;
                tLRPC$TL_phone_toggleGroupCallRecord.flags |= 2;
            }
            if (i == 1 || i == 2) {
                tLRPC$TL_phone_toggleGroupCallRecord.flags |= 4;
            }
            this.currentAccount.getConnectionsManager().sendRequest(tLRPC$TL_phone_toggleGroupCallRecord, new RequestDelegate() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda25
                @Override // org.rbmain.tgnet.RequestDelegate
                public final void run(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
                    this.f$0.lambda$toggleRecord$25(tLObject, tLRPC$TL_error);
                }
            });
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.ChatObject$Call$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$toggleRecord$26();
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$toggleRecord$25(TLObject tLObject, TLRPC$TL_error tLRPC$TL_error) {
            if (tLObject != null) {
                this.currentAccount.getMessagesController().processUpdates((TLRPC$Updates) tLObject, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$toggleRecord$26() {
            this.currentAccount.getNotificationCenter().postNotificationName(NotificationCenter.groupCallUpdated, Integer.valueOf(this.chatId), this.call.id, Boolean.FALSE);
        }
    }

    public static int getParticipantVolume(TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant) {
        if ((tLRPC$TL_groupCallParticipant.flags & 128) != 0) {
            return tLRPC$TL_groupCallParticipant.volume;
        }
        return 10000;
    }

    private static boolean getBannedRight(TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights, int i) {
        if (tLRPC$TL_chatBannedRights == null) {
            return false;
        }
        if (i == 0) {
            return tLRPC$TL_chatBannedRights.pin_messages;
        }
        if (i == 1) {
            return tLRPC$TL_chatBannedRights.change_info;
        }
        if (i == 3) {
            return tLRPC$TL_chatBannedRights.invite_users;
        }
        switch (i) {
        }
        return false;
    }

    public static boolean isActionBannedByDefault(TLRPC$Chat tLRPC$Chat, int i) {
        if (getBannedRight(tLRPC$Chat.banned_rights, i)) {
            return false;
        }
        return getBannedRight(tLRPC$Chat.default_banned_rights, i);
    }

    public static boolean isActionBanned(TLRPC$Chat tLRPC$Chat, int i) {
        return tLRPC$Chat != null && (getBannedRight(tLRPC$Chat.banned_rights, i) || getBannedRight(tLRPC$Chat.default_banned_rights, i));
    }

    public static boolean canUserDoAdminAction(TLRPC$Chat tLRPC$Chat, int i) {
        return canUserDoAction(tLRPC$Chat, i);
    }

    public static boolean canUserDoAction(TLRPC$Chat tLRPC$Chat, int i) {
        HashSet<Chat.ChatAccessEnum> hashSet;
        if (tLRPC$Chat == null || (hashSet = tLRPC$Chat.accessEnumHashSet) == null) {
            return false;
        }
        switch (i) {
            case 0:
                return hashSet.contains(Chat.ChatAccessEnum.PinMessages);
            case 1:
                break;
            case 2:
                return hashSet.contains(Chat.ChatAccessEnum.BanMember) || tLRPC$Chat.accessEnumHashSet.contains(Chat.ChatAccessEnum.SuperAdmin);
            case 3:
                return hashSet.contains(Chat.ChatAccessEnum.AddMember);
            case 4:
                return hashSet.contains(Chat.ChatAccessEnum.SetAdmin);
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return hashSet.contains(Chat.ChatAccessEnum.SendMessages);
            default:
                switch (i) {
                    case 12:
                        break;
                    case 13:
                        break;
                    case 14:
                        break;
                    default:
                        switch (i) {
                        }
                }
                return false;
        }
        return hashSet.contains(Chat.ChatAccessEnum.ChangeInfo);
    }

    public static boolean isLeftFromChat(TLRPC$Chat tLRPC$Chat) {
        return tLRPC$Chat == null || (tLRPC$Chat instanceof TLRPC$TL_chatEmpty) || (tLRPC$Chat instanceof TLRPC$TL_chatForbidden) || (tLRPC$Chat instanceof TLRPC$TL_channelForbidden) || tLRPC$Chat.left || tLRPC$Chat.deactivated;
    }

    public static boolean isKickedFromChat(TLRPC$Chat tLRPC$Chat) {
        TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights;
        return tLRPC$Chat == null || (tLRPC$Chat instanceof TLRPC$TL_chatEmpty) || (tLRPC$Chat instanceof TLRPC$TL_chatForbidden) || (tLRPC$Chat instanceof TLRPC$TL_channelForbidden) || tLRPC$Chat.kicked || tLRPC$Chat.deactivated || ((tLRPC$TL_chatBannedRights = tLRPC$Chat.banned_rights) != null && tLRPC$TL_chatBannedRights.view_messages);
    }

    public static boolean isNotInChat(TLRPC$Chat tLRPC$Chat) {
        return tLRPC$Chat == null || (tLRPC$Chat instanceof TLRPC$TL_chatEmpty) || (tLRPC$Chat instanceof TLRPC$TL_chatForbidden) || (tLRPC$Chat instanceof TLRPC$TL_channelForbidden) || tLRPC$Chat.left || tLRPC$Chat.kicked || tLRPC$Chat.deactivated;
    }

    public static boolean isChannel(TLRPC$Chat tLRPC$Chat) {
        return (tLRPC$Chat instanceof TLRPC$TL_channel) || (tLRPC$Chat instanceof TLRPC$TL_channelForbidden);
    }

    public static boolean isChannelAndNotMegaGroup(TLRPC$Chat tLRPC$Chat) {
        return isChannel(tLRPC$Chat) && !isMegagroup(tLRPC$Chat);
    }

    public static boolean isChannelAndNotMegaGroup(int i, int i2) {
        return isChannelAndNotMegaGroup(MessagesController.getInstance(i2).getChat(Integer.valueOf(i)));
    }

    public static boolean isForum(TLRPC$Chat tLRPC$Chat) {
        return tLRPC$Chat != null && tLRPC$Chat.forum;
    }

    public static boolean isChannelOrGiga(TLRPC$Chat tLRPC$Chat) {
        return ((tLRPC$Chat instanceof TLRPC$TL_channel) || (tLRPC$Chat instanceof TLRPC$TL_channelForbidden)) && (!tLRPC$Chat.megagroup || tLRPC$Chat.gigagroup);
    }

    public static boolean isMegagroup(TLRPC$Chat tLRPC$Chat) {
        return ((tLRPC$Chat instanceof TLRPC$TL_channel) || (tLRPC$Chat instanceof TLRPC$TL_channelForbidden)) && tLRPC$Chat.megagroup;
    }

    public static boolean isMegagroup(int i, int i2) {
        TLRPC$Chat chat = MessagesController.getInstance(i).getChat(Integer.valueOf(i2));
        return isChannel(chat) && chat.megagroup;
    }

    public static boolean hasAdminRights(TLRPC$Chat tLRPC$Chat) {
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights;
        return tLRPC$Chat != null && (tLRPC$Chat.creator || !((tLRPC$TL_chatAdminRights = tLRPC$Chat.admin_rights) == null || tLRPC$TL_chatAdminRights.flags == 0));
    }

    public static boolean canChangeChatInfo(TLRPC$Chat tLRPC$Chat) {
        return canUserDoAction(tLRPC$Chat, 1);
    }

    public static boolean canAddAdmins(TLRPC$Chat tLRPC$Chat) {
        return canUserDoAction(tLRPC$Chat, 4);
    }

    public static boolean canBlockUsers(TLRPC$Chat tLRPC$Chat) {
        return canUserDoAction(tLRPC$Chat, 2);
    }

    public static boolean canManageCalls(TLRPC$Chat tLRPC$Chat) {
        return canUserDoAction(tLRPC$Chat, 14);
    }

    public static boolean canSendStickers(TLRPC$Chat tLRPC$Chat) {
        return canUserDoAction(tLRPC$Chat, 8);
    }

    public static boolean canSendEmbed(TLRPC$Chat tLRPC$Chat) {
        return canUserDoAction(tLRPC$Chat, 9);
    }

    public static boolean canSendMedia(TLRPC$Chat tLRPC$Chat) {
        return canUserDoAction(tLRPC$Chat, 7);
    }

    public static boolean canSendPolls(TLRPC$Chat tLRPC$Chat) {
        return canUserDoAction(tLRPC$Chat, 10);
    }

    public static boolean canSendPlain(TLRPC$Chat tLRPC$Chat) {
        return canSendMessages(tLRPC$Chat);
    }

    public static boolean canSendMessages(TLRPC$Chat tLRPC$Chat) {
        return ServiceLocator.getInstance(UserConfig.selectedAccount).getDialogsProxy().canSendMessage(-tLRPC$Chat.id);
    }

    public static boolean canPost(TLRPC$Chat tLRPC$Chat) {
        return canUserDoAction(tLRPC$Chat, 5);
    }

    public static boolean canAddUsers(TLRPC$Chat tLRPC$Chat) {
        return canUserDoAction(tLRPC$Chat, 3);
    }

    public static boolean shouldSendAnonymously(TLRPC$Chat tLRPC$Chat) {
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights;
        return (tLRPC$Chat == null || (tLRPC$TL_chatAdminRights = tLRPC$Chat.admin_rights) == null || !tLRPC$TL_chatAdminRights.anonymous) ? false : true;
    }

    public static boolean canAddBotsToChat(TLRPC$Chat tLRPC$Chat) {
        if (!isChannel(tLRPC$Chat)) {
            return tLRPC$Chat.migrated_to == null;
        }
        if (!tLRPC$Chat.megagroup) {
            return false;
        }
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights = tLRPC$Chat.admin_rights;
        return (tLRPC$TL_chatAdminRights != null && (tLRPC$TL_chatAdminRights.post_messages || tLRPC$TL_chatAdminRights.add_admins)) || tLRPC$Chat.creator;
    }

    public static boolean canPinMessages(TLRPC$Chat tLRPC$Chat) {
        return canUserDoAction(tLRPC$Chat, 0);
    }

    public static boolean canSendPhoto(TLRPC$Chat tLRPC$Chat) {
        return canSendMessages(tLRPC$Chat);
    }

    public static boolean canSendVoice(TLRPC$Chat tLRPC$Chat) {
        return canSendMessages(tLRPC$Chat);
    }

    public static boolean canSendAnyMedia(TLRPC$Chat tLRPC$Chat) {
        return canSendPhoto(tLRPC$Chat) || canSendVideo(tLRPC$Chat) || canSendRoundVideo(tLRPC$Chat) || canSendVoice(tLRPC$Chat) || canSendDocument(tLRPC$Chat) || canSendMusic(tLRPC$Chat) || canSendStickers(tLRPC$Chat);
    }

    public static boolean canSendMusic(TLRPC$Chat tLRPC$Chat) {
        return canSendMessages(tLRPC$Chat);
    }

    public static boolean canSendDocument(TLRPC$Chat tLRPC$Chat) {
        return canSendMessages(tLRPC$Chat);
    }

    public static boolean canSendVideo(TLRPC$Chat tLRPC$Chat) {
        return canSendMessages(tLRPC$Chat);
    }

    public static boolean canSendRoundVideo(TLRPC$Chat tLRPC$Chat) {
        return canSendMessages(tLRPC$Chat);
    }

    public static boolean reactionIsAvailable(TLRPC$ChatFull tLRPC$ChatFull, String str) {
        TLRPC$ChatReactions tLRPC$ChatReactions = tLRPC$ChatFull.available_reactions;
        if (tLRPC$ChatReactions instanceof TLRPC$TL_chatReactionsAll) {
            return true;
        }
        if (tLRPC$ChatReactions instanceof TLRPC$TL_chatReactionsSome) {
            TLRPC$TL_chatReactionsSome tLRPC$TL_chatReactionsSome = (TLRPC$TL_chatReactionsSome) tLRPC$ChatReactions;
            for (int i = 0; i < tLRPC$TL_chatReactionsSome.reactions.size(); i++) {
                if ((tLRPC$TL_chatReactionsSome.reactions.get(i) instanceof TLRPC$TL_reactionEmoji) && TextUtils.equals(((TLRPC$TL_reactionEmoji) tLRPC$TL_chatReactionsSome.reactions.get(i)).emoticon, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean canCreateTopic(TLRPC$Chat tLRPC$Chat) {
        return canUserDoAction(tLRPC$Chat, 15);
    }

    public static boolean canManageTopics(TLRPC$Chat tLRPC$Chat) {
        return canUserDoAdminAction(tLRPC$Chat, 15);
    }

    public static boolean canManageTopic(int i, TLRPC$Chat tLRPC$Chat, TLRPC$TL_forumTopic tLRPC$TL_forumTopic) {
        return canManageTopics(tLRPC$Chat) || isMyTopic(i, tLRPC$TL_forumTopic);
    }

    public static boolean canManageTopic(int i, TLRPC$Chat tLRPC$Chat, int i2) {
        return canManageTopics(tLRPC$Chat) || isMyTopic(i, tLRPC$Chat, i2);
    }

    public static boolean isMyTopic(int i, TLRPC$Chat tLRPC$Chat, int i2) {
        return tLRPC$Chat != null && tLRPC$Chat.forum && isMyTopic(i, tLRPC$Chat.id, i2);
    }

    public static boolean isChannel(int i, int i2) {
        TLRPC$Chat chat = MessagesController.getInstance(i2).getChat(Integer.valueOf(i));
        return (chat instanceof TLRPC$TL_channel) || (chat instanceof TLRPC$TL_channelForbidden);
    }

    public static boolean isChannelAppp(int i, int i2) {
        TLRPC$Chat chat = MessagesController.getInstance(i2).getChat(Integer.valueOf(i));
        return ((chat instanceof TLRPC$TL_channel) || (chat instanceof TLRPC$TL_channelForbidden)) && !chat.megagroup;
    }

    public static boolean isCanWriteToChannel(int i, int i2) {
        TLRPC$Chat chat = MessagesController.getInstance(i2).getChat(Integer.valueOf(i));
        return canSendMessages(chat) || chat.megagroup;
    }

    public static boolean canWriteToChat(TLRPC$Chat tLRPC$Chat) {
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights;
        return !isChannel(tLRPC$Chat) || tLRPC$Chat.creator || ((tLRPC$TL_chatAdminRights = tLRPC$Chat.admin_rights) != null && tLRPC$TL_chatAdminRights.post_messages) || (!(tLRPC$Chat.broadcast || tLRPC$Chat.gigagroup) || (tLRPC$Chat.gigagroup && hasAdminRights(tLRPC$Chat)));
    }

    public static String getBannedRightsString(TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights) {
        return ((((((((((((((io.github.inflationx.calligraphy3.BuildConfig.FLAVOR + (tLRPC$TL_chatBannedRights.view_messages ? 1 : 0)) + (tLRPC$TL_chatBannedRights.send_messages ? 1 : 0)) + (tLRPC$TL_chatBannedRights.send_media ? 1 : 0)) + (tLRPC$TL_chatBannedRights.send_stickers ? 1 : 0)) + (tLRPC$TL_chatBannedRights.send_gifs ? 1 : 0)) + (tLRPC$TL_chatBannedRights.send_games ? 1 : 0)) + (tLRPC$TL_chatBannedRights.send_inline ? 1 : 0)) + (tLRPC$TL_chatBannedRights.embed_links ? 1 : 0)) + (tLRPC$TL_chatBannedRights.send_polls ? 1 : 0)) + (tLRPC$TL_chatBannedRights.invite_users ? 1 : 0)) + (tLRPC$TL_chatBannedRights.change_info ? 1 : 0)) + (tLRPC$TL_chatBannedRights.pin_messages ? 1 : 0)) + (tLRPC$TL_chatBannedRights.view_members ? 1 : 0)) + (tLRPC$TL_chatBannedRights.view_admins ? 1 : 0)) + tLRPC$TL_chatBannedRights.until_date;
    }

    public static TLRPC$Chat getChatByDialog(long j, int i) {
        int i2 = (int) j;
        if (i2 < 0) {
            return MessagesController.getInstance(i).getChat(Integer.valueOf(-i2));
        }
        return null;
    }

    public static boolean isPublic(TLRPC$Chat tLRPC$Chat) {
        return !TextUtils.isEmpty(getPublicUsername(tLRPC$Chat));
    }

    public static String getRestrictedErrorText(TLRPC$Chat tLRPC$Chat, int i) {
        if (i == 23) {
            if (tLRPC$Chat == null || isActionBannedByDefault(tLRPC$Chat, i)) {
                return LocaleController.getString("GlobalAttachGifRestricted", ir.medu.shad.R.string.GlobalAttachGifRestricted);
            }
            return AndroidUtilities.isBannedForever(tLRPC$Chat.banned_rights) ? LocaleController.formatString("AttachGifRestrictedForever", ir.medu.shad.R.string.AttachGifRestrictedForever, new Object[0]) : LocaleController.formatString("AttachGifRestricted", ir.medu.shad.R.string.AttachGifRestricted, LocaleController.formatDateForBan(tLRPC$Chat.banned_rights.until_date));
        }
        if (i == 8) {
            if (tLRPC$Chat == null || isActionBannedByDefault(tLRPC$Chat, i)) {
                return LocaleController.getString("GlobalAttachStickersRestricted", ir.medu.shad.R.string.GlobalAttachStickersRestricted);
            }
            return AndroidUtilities.isBannedForever(tLRPC$Chat.banned_rights) ? LocaleController.formatString("AttachStickersRestrictedForever", ir.medu.shad.R.string.AttachStickersRestrictedForever, new Object[0]) : LocaleController.formatString("AttachStickersRestricted", ir.medu.shad.R.string.AttachStickersRestricted, LocaleController.formatDateForBan(tLRPC$Chat.banned_rights.until_date));
        }
        if (i == 16) {
            if (tLRPC$Chat == null || isActionBannedByDefault(tLRPC$Chat, i)) {
                return LocaleController.getString("GlobalAttachPhotoRestricted", ir.medu.shad.R.string.GlobalAttachPhotoRestricted);
            }
            return AndroidUtilities.isBannedForever(tLRPC$Chat.banned_rights) ? LocaleController.formatString("AttachPhotoRestrictedForever", ir.medu.shad.R.string.AttachPhotoRestrictedForever, new Object[0]) : LocaleController.formatString("AttachPhotoRestricted", ir.medu.shad.R.string.AttachPhotoRestricted, LocaleController.formatDateForBan(tLRPC$Chat.banned_rights.until_date));
        }
        if (i == 17) {
            if (tLRPC$Chat == null || isActionBannedByDefault(tLRPC$Chat, i)) {
                return LocaleController.getString("GlobalAttachVideoRestricted", ir.medu.shad.R.string.GlobalAttachVideoRestricted);
            }
            return AndroidUtilities.isBannedForever(tLRPC$Chat.banned_rights) ? LocaleController.formatString("AttachVideoRestrictedForever", ir.medu.shad.R.string.AttachVideoRestrictedForever, new Object[0]) : LocaleController.formatString("AttachVideoRestricted", ir.medu.shad.R.string.AttachVideoRestricted, LocaleController.formatDateForBan(tLRPC$Chat.banned_rights.until_date));
        }
        if (i == 19) {
            if (tLRPC$Chat == null || isActionBannedByDefault(tLRPC$Chat, i)) {
                return LocaleController.getString("GlobalAttachDocumentsRestricted", ir.medu.shad.R.string.GlobalAttachDocumentsRestricted);
            }
            return AndroidUtilities.isBannedForever(tLRPC$Chat.banned_rights) ? LocaleController.formatString("AttachDocumentsRestrictedForever", ir.medu.shad.R.string.AttachDocumentsRestrictedForever, new Object[0]) : LocaleController.formatString("AttachDocumentsRestricted", ir.medu.shad.R.string.AttachDocumentsRestricted, LocaleController.formatDateForBan(tLRPC$Chat.banned_rights.until_date));
        }
        if (i == 7) {
            if (tLRPC$Chat == null || isActionBannedByDefault(tLRPC$Chat, i)) {
                return LocaleController.getString("GlobalAttachMediaRestricted", ir.medu.shad.R.string.GlobalAttachMediaRestricted);
            }
            return AndroidUtilities.isBannedForever(tLRPC$Chat.banned_rights) ? LocaleController.formatString("AttachMediaRestrictedForever", ir.medu.shad.R.string.AttachMediaRestrictedForever, new Object[0]) : LocaleController.formatString("AttachMediaRestricted", ir.medu.shad.R.string.AttachMediaRestricted, LocaleController.formatDateForBan(tLRPC$Chat.banned_rights.until_date));
        }
        if (i == 18) {
            if (tLRPC$Chat == null || isActionBannedByDefault(tLRPC$Chat, i)) {
                return LocaleController.getString("GlobalAttachAudioRestricted", ir.medu.shad.R.string.GlobalAttachAudioRestricted);
            }
            return AndroidUtilities.isBannedForever(tLRPC$Chat.banned_rights) ? LocaleController.formatString("AttachAudioRestrictedForever", ir.medu.shad.R.string.AttachAudioRestrictedForever, new Object[0]) : LocaleController.formatString("AttachAudioRestricted", ir.medu.shad.R.string.AttachAudioRestricted, LocaleController.formatDateForBan(tLRPC$Chat.banned_rights.until_date));
        }
        if (i == 22) {
            if (tLRPC$Chat == null || isActionBannedByDefault(tLRPC$Chat, i)) {
                return LocaleController.getString("GlobalAttachPlainRestricted", ir.medu.shad.R.string.GlobalAttachPlainRestricted);
            }
            return AndroidUtilities.isBannedForever(tLRPC$Chat.banned_rights) ? LocaleController.formatString("AttachPlainRestrictedForever", ir.medu.shad.R.string.AttachPlainRestrictedForever, new Object[0]) : LocaleController.formatString("AttachPlainRestricted", ir.medu.shad.R.string.AttachPlainRestricted, LocaleController.formatDateForBan(tLRPC$Chat.banned_rights.until_date));
        }
        if (i == 21) {
            if (tLRPC$Chat == null || isActionBannedByDefault(tLRPC$Chat, i)) {
                return LocaleController.getString("GlobalAttachRoundRestricted", ir.medu.shad.R.string.GlobalAttachRoundRestricted);
            }
            return AndroidUtilities.isBannedForever(tLRPC$Chat.banned_rights) ? LocaleController.formatString("AttachRoundRestrictedForever", ir.medu.shad.R.string.AttachRoundRestrictedForever, new Object[0]) : LocaleController.formatString("AttachRoundRestricted", ir.medu.shad.R.string.AttachRoundRestricted, LocaleController.formatDateForBan(tLRPC$Chat.banned_rights.until_date));
        }
        if (i != 20) {
            return io.github.inflationx.calligraphy3.BuildConfig.FLAVOR;
        }
        if (tLRPC$Chat == null || isActionBannedByDefault(tLRPC$Chat, i)) {
            return LocaleController.getString("GlobalAttachVoiceRestricted", ir.medu.shad.R.string.GlobalAttachVoiceRestricted);
        }
        return AndroidUtilities.isBannedForever(tLRPC$Chat.banned_rights) ? LocaleController.formatString("AttachVoiceRestrictedForever", ir.medu.shad.R.string.AttachVoiceRestrictedForever, new Object[0]) : LocaleController.formatString("AttachVoiceRestricted", ir.medu.shad.R.string.AttachVoiceRestricted, LocaleController.formatDateForBan(tLRPC$Chat.banned_rights.until_date));
    }

    public static String getPublicUsername(TLRPC$Chat tLRPC$Chat) {
        return getPublicUsername(tLRPC$Chat, false);
    }

    public static String getPublicUsername(TLRPC$Chat tLRPC$Chat, boolean z) {
        if (tLRPC$Chat == null || TextUtils.isEmpty(tLRPC$Chat.username) || z) {
            return null;
        }
        return tLRPC$Chat.username;
    }

    public static int getSendAsPeerId(TLRPC$Chat tLRPC$Chat, TLRPC$ChatFull tLRPC$ChatFull) {
        return getSendAsPeerId(tLRPC$Chat, tLRPC$ChatFull, false);
    }

    public static int getSendAsPeerId(TLRPC$Chat tLRPC$Chat, TLRPC$ChatFull tLRPC$ChatFull, boolean z) {
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights;
        TLRPC$Peer tLRPC$Peer;
        if (tLRPC$Chat != null && tLRPC$ChatFull != null && (tLRPC$Peer = tLRPC$ChatFull.default_send_as) != null) {
            int i = tLRPC$Peer.user_id;
            if (i != 0) {
                return i;
            }
            int i2 = tLRPC$Peer.channel_id;
            return z ? -i2 : i2;
        }
        if (tLRPC$Chat != null && (tLRPC$TL_chatAdminRights = tLRPC$Chat.admin_rights) != null && tLRPC$TL_chatAdminRights.anonymous) {
            int i3 = tLRPC$Chat.id;
            return z ? -i3 : i3;
        }
        return UserConfig.getInstance(UserConfig.selectedAccount).getClientUserId();
    }

    public static boolean canSendAsPeers(TLRPC$Chat tLRPC$Chat) {
        return isChannel(tLRPC$Chat) && tLRPC$Chat.megagroup && (isPublic(tLRPC$Chat) || tLRPC$Chat.has_geo || tLRPC$Chat.has_link);
    }

    public static class VideoParticipant {
        public float aspectRatio;
        public int aspectRatioFromHeight;
        public int aspectRatioFromWidth;
        public boolean hasSame;
        public TLRPC$TL_groupCallParticipant participant;
        public boolean presentation;

        public VideoParticipant(TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant, boolean z, boolean z2) {
            this.participant = tLRPC$TL_groupCallParticipant;
            this.presentation = z;
            this.hasSame = z2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            VideoParticipant videoParticipant = (VideoParticipant) obj;
            return this.presentation == videoParticipant.presentation && MessageObject.getPeerId(this.participant.peer) == MessageObject.getPeerId(videoParticipant.participant.peer);
        }

        public void setAspectRatio(int i, int i2, Call call) {
            this.aspectRatioFromWidth = i;
            this.aspectRatioFromHeight = i2;
            setAspectRatio(i / i2, call);
        }

        private void setAspectRatio(float f, Call call) {
            if (this.aspectRatio != f) {
                this.aspectRatio = f;
                if (GroupCallActivity.isLandscapeMode || call.visibleVideoParticipants.size() % 2 != 1) {
                    return;
                }
                call.updateVisibleParticipants();
            }
        }
    }
}
