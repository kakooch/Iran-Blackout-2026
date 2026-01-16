package androidMessenger.utilites;

import android.os.SystemClock;
import android.text.TextUtils;
import androidMessenger.ServiceLocator;
import androidMessenger.model.GroupCallSdp;
import androidMessenger.proxy.IdStorage;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.CoreMainClass;
import ir.aaap.messengercore.model.AvatarFileInline;
import ir.aaap.messengercore.model.Chat;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.GroupCallModels;
import ir.aaap.messengercore.model.ObjectGuidType;
import ir.aaap.messengercore.model.UserInfo;
import ir.aaap.messengercore.model.VoiceCallModels;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.rbmain.messenger.ApplicationLoader;
import org.rbmain.messenger.MessageObject;
import org.rbmain.messenger.MessagesController;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$GroupCall;
import org.rbmain.tgnet.TLRPC$PhoneCall;
import org.rbmain.tgnet.TLRPC$PhoneCallDiscardReason;
import org.rbmain.tgnet.TLRPC$PhoneConnection;
import org.rbmain.tgnet.TLRPC$TL_channel;
import org.rbmain.tgnet.TLRPC$TL_groupCall;
import org.rbmain.tgnet.TLRPC$TL_groupCallDiscarded;
import org.rbmain.tgnet.TLRPC$TL_groupCallParticipant;
import org.rbmain.tgnet.TLRPC$TL_peerUser;
import org.rbmain.tgnet.TLRPC$TL_phoneCall;
import org.rbmain.tgnet.TLRPC$TL_phoneCallAccepted;
import org.rbmain.tgnet.TLRPC$TL_phoneCallDiscardReasonBusy;
import org.rbmain.tgnet.TLRPC$TL_phoneCallDiscardReasonDisconnect;
import org.rbmain.tgnet.TLRPC$TL_phoneCallDiscardReasonHangup;
import org.rbmain.tgnet.TLRPC$TL_phoneCallDiscardReasonMissed;
import org.rbmain.tgnet.TLRPC$TL_phoneCallDiscarded;
import org.rbmain.tgnet.TLRPC$TL_phoneCallProtocol;
import org.rbmain.tgnet.TLRPC$TL_phoneCallRequested;
import org.rbmain.tgnet.TLRPC$TL_phoneCallWaiting;
import org.rbmain.tgnet.TLRPC$TL_user;
import org.rbmain.tgnet.TLRPC$User;

/* loaded from: classes.dex */
public class CallConverter {
    public static TLRPC$PhoneCall convertCall(CoreMainClass coreMainClass, String str, VoiceCallModels.PhoneCall phoneCall, boolean z) {
        TLRPC$PhoneCall tLRPC$TL_phoneCall;
        VoiceCallModels.CallStateEnum callStateEnum = phoneCall.state;
        if (callStateEnum == VoiceCallModels.CallStateEnum.Requested) {
            if (z) {
                tLRPC$TL_phoneCall = new TLRPC$TL_phoneCallRequested();
            } else {
                tLRPC$TL_phoneCall = new TLRPC$TL_phoneCallWaiting();
            }
        } else if (callStateEnum == VoiceCallModels.CallStateEnum.Accepted) {
            tLRPC$TL_phoneCall = new TLRPC$TL_phoneCallAccepted();
        } else if (callStateEnum == VoiceCallModels.CallStateEnum.Discarded) {
            tLRPC$TL_phoneCall = new TLRPC$TL_phoneCallDiscarded();
        } else if (callStateEnum == VoiceCallModels.CallStateEnum.Waiting) {
            tLRPC$TL_phoneCall = new TLRPC$TL_phoneCallWaiting();
        } else {
            tLRPC$TL_phoneCall = new TLRPC$TL_phoneCall();
        }
        tLRPC$TL_phoneCall.id = phoneCall.call_id;
        tLRPC$TL_phoneCall.admin_id = (int) IdStorage.getInstance().generateDialogId(str);
        tLRPC$TL_phoneCall.participant_id = (int) IdStorage.getInstance().generateDialogId(phoneCall.other_participants.get(0).object_guid);
        tLRPC$TL_phoneCall.key = phoneCall.key;
        TLRPC$TL_phoneCallProtocol tLRPC$TL_phoneCallProtocol = new TLRPC$TL_phoneCallProtocol();
        tLRPC$TL_phoneCall.protocol = tLRPC$TL_phoneCallProtocol;
        tLRPC$TL_phoneCallProtocol.library_versions = phoneCall.library_versions;
        tLRPC$TL_phoneCallProtocol.max_layer = phoneCall.protocol_layer;
        tLRPC$TL_phoneCall.duration = phoneCall.duration;
        tLRPC$TL_phoneCall.receive_date = phoneCall.receive_time;
        tLRPC$TL_phoneCall.video = phoneCall.call_type == VoiceCallModels.CallType.Video;
        tLRPC$TL_phoneCall.need_rating = phoneCall.report_rating || MyLog.isDebugAble;
        tLRPC$TL_phoneCall.p2p_allowed = phoneCall.p2p_allowed;
        if (phoneCall.connections != null) {
            tLRPC$TL_phoneCall.connections = new ArrayList<>();
            Iterator<VoiceCallModels.PhoneConnection> it = phoneCall.connections.iterator();
            while (it.hasNext()) {
                tLRPC$TL_phoneCall.connections.add(convertConnection(it.next()));
            }
        }
        tLRPC$TL_phoneCall.reason = getDiscardCallReason(phoneCall.discard_reason);
        tLRPC$TL_phoneCall.timestamp = phoneCall.timestamp;
        return tLRPC$TL_phoneCall;
    }

    private static TLRPC$PhoneConnection convertConnection(VoiceCallModels.PhoneConnection phoneConnection) {
        TLRPC$PhoneConnection tLRPC$PhoneConnection;
        if (phoneConnection.type == VoiceCallModels.ConnectionType.WebRTC) {
            tLRPC$PhoneConnection = new TLRPC$PhoneConnection() { // from class: org.rbmain.tgnet.TLRPC$TL_phoneConnectionWebrtc
                public static int constructor = 1667228533;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
                    int int32 = abstractSerializedData.readInt32(z);
                    this.flags = int32;
                    this.turn = (int32 & 1) != 0;
                    this.stun = (int32 & 2) != 0;
                    this.id = abstractSerializedData.readInt64(z);
                    this.ip = abstractSerializedData.readString(z);
                    this.ipv6 = abstractSerializedData.readString(z);
                    this.port = abstractSerializedData.readInt32(z);
                    this.username = abstractSerializedData.readString(z);
                    this.password = abstractSerializedData.readString(z);
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                    abstractSerializedData.writeInt32(constructor);
                    int i = this.turn ? this.flags | 1 : this.flags & (-2);
                    this.flags = i;
                    int i2 = this.stun ? i | 2 : i & (-3);
                    this.flags = i2;
                    abstractSerializedData.writeInt32(i2);
                    abstractSerializedData.writeInt64(this.id);
                    abstractSerializedData.writeString(this.ip);
                    abstractSerializedData.writeString(this.ipv6);
                    abstractSerializedData.writeInt32(this.port);
                    abstractSerializedData.writeString(this.username);
                    abstractSerializedData.writeString(this.password);
                }
            };
        } else {
            tLRPC$PhoneConnection = new TLRPC$PhoneConnection() { // from class: org.rbmain.tgnet.TLRPC$TL_phoneConnection
                public static int constructor = -1655957568;

                @Override // org.rbmain.tgnet.TLObject
                public void readParams(AbstractSerializedData abstractSerializedData, boolean z) {
                    this.id = abstractSerializedData.readInt64(z);
                    this.ip = abstractSerializedData.readString(z);
                    this.ipv6 = abstractSerializedData.readString(z);
                    this.port = abstractSerializedData.readInt32(z);
                    this.peer_tag = abstractSerializedData.readByteArray(z);
                }

                @Override // org.rbmain.tgnet.TLObject
                public void serializeToStream(AbstractSerializedData abstractSerializedData) {
                    abstractSerializedData.writeInt32(constructor);
                    abstractSerializedData.writeInt64(this.id);
                    abstractSerializedData.writeString(this.ip);
                    abstractSerializedData.writeString(this.ipv6);
                    abstractSerializedData.writeInt32(this.port);
                    abstractSerializedData.writeByteArray(this.peer_tag);
                }
            };
        }
        tLRPC$PhoneConnection.id = phoneConnection.id;
        tLRPC$PhoneConnection.ip = phoneConnection.ip;
        tLRPC$PhoneConnection.ipv6 = phoneConnection.ipv6;
        tLRPC$PhoneConnection.username = phoneConnection.turn_username;
        tLRPC$PhoneConnection.password = phoneConnection.turn_password;
        String str = phoneConnection.peer_tag;
        tLRPC$PhoneConnection.peer_tag = str != null ? str.getBytes() : null;
        tLRPC$PhoneConnection.port = phoneConnection.port;
        tLRPC$PhoneConnection.turn = true;
        return tLRPC$PhoneConnection;
    }

    public static VoiceCallModels.EnumDiscardCallReason getDiscardCallReason(TLRPC$PhoneCallDiscardReason tLRPC$PhoneCallDiscardReason) {
        if (tLRPC$PhoneCallDiscardReason instanceof TLRPC$TL_phoneCallDiscardReasonDisconnect) {
            return VoiceCallModels.EnumDiscardCallReason.Disconnect;
        }
        if (tLRPC$PhoneCallDiscardReason instanceof TLRPC$TL_phoneCallDiscardReasonMissed) {
            return VoiceCallModels.EnumDiscardCallReason.Missed;
        }
        if (tLRPC$PhoneCallDiscardReason instanceof TLRPC$TL_phoneCallDiscardReasonBusy) {
            return VoiceCallModels.EnumDiscardCallReason.Busy;
        }
        if (tLRPC$PhoneCallDiscardReason instanceof TLRPC$TL_phoneCallDiscardReasonHangup) {
            return VoiceCallModels.EnumDiscardCallReason.Hangup;
        }
        return null;
    }

    public static TLRPC$PhoneCallDiscardReason getDiscardCallReason(VoiceCallModels.EnumDiscardCallReason enumDiscardCallReason) {
        if (enumDiscardCallReason == null) {
            return null;
        }
        if (enumDiscardCallReason == VoiceCallModels.EnumDiscardCallReason.Disconnect) {
            return new TLRPC$TL_phoneCallDiscardReasonDisconnect();
        }
        if (enumDiscardCallReason == VoiceCallModels.EnumDiscardCallReason.Missed) {
            return new TLRPC$TL_phoneCallDiscardReasonMissed();
        }
        if (enumDiscardCallReason == VoiceCallModels.EnumDiscardCallReason.Busy) {
            return new TLRPC$TL_phoneCallDiscardReasonBusy();
        }
        if (enumDiscardCallReason == VoiceCallModels.EnumDiscardCallReason.Hangup) {
            return new TLRPC$TL_phoneCallDiscardReasonHangup();
        }
        return null;
    }

    public static TLRPC$GroupCall convertGroupCall(GroupCallModels.GroupVoiceChat groupVoiceChat) {
        TLRPC$GroupCall tLRPC$TL_groupCallDiscarded;
        if (groupVoiceChat.state == GroupCallModels.StateGroupVoiceChat.Running) {
            tLRPC$TL_groupCallDiscarded = new TLRPC$TL_groupCall();
        } else {
            tLRPC$TL_groupCallDiscarded = new TLRPC$TL_groupCallDiscarded();
        }
        tLRPC$TL_groupCallDiscarded.id = groupVoiceChat.voice_chat_id;
        tLRPC$TL_groupCallDiscarded.participants_count = groupVoiceChat.participant_count;
        tLRPC$TL_groupCallDiscarded.join_muted = groupVoiceChat.join_muted;
        tLRPC$TL_groupCallDiscarded.title = groupVoiceChat.title;
        return tLRPC$TL_groupCallDiscarded;
    }

    public static void convertAllGroupVoiceChatParticipants(int i, ArrayList<GroupCallModels.GroupVoiceChatParticipant> arrayList, ArrayList<TLRPC$TL_groupCallParticipant> arrayList2, ArrayList<TLRPC$Chat> arrayList3, ArrayList<TLRPC$User> arrayList4) {
        CoreMainClass coreMainClass = ServiceLocator.getInstance(i).getCoreMainClass();
        Iterator<GroupCallModels.GroupVoiceChatParticipant> it = arrayList.iterator();
        while (it.hasNext()) {
            GroupCallModels.GroupVoiceChatParticipant next = it.next();
            if (next != null) {
                ObjectGuidType objectGuidType = next.participant_object_guid_type;
                long dialogId = ChatConverter.getDialogId(objectGuidType.object_guid, objectGuidType.type);
                TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipantConvertGroupVoiceChatParticipant = convertGroupVoiceChatParticipant(dialogId, next);
                arrayList2.add(tLRPC$TL_groupCallParticipantConvertGroupVoiceChatParticipant);
                String str = next.participant_object_guid_type.object_guid;
                if ((tLRPC$TL_groupCallParticipantConvertGroupVoiceChatParticipant.peer instanceof TLRPC$TL_peerUser) && arrayList4 != null) {
                    arrayList4.add(ChatConverter.convertUser(coreMainClass, dialogId, coreMainClass.getAbsInstant(str), (UserInfo) null, (Chat) null));
                } else if (arrayList3 != null) {
                    int i2 = (int) (-IdStorage.getInstance().generateNegativeDialogId(str));
                    TLRPC$Chat chat = MessagesController.getInstance(i).getChat(Integer.valueOf(i2));
                    ChatConverter.setAbsInfoForChannelGroup(chat, coreMainClass.getAbsInstant(str));
                    if (chat == null) {
                        chat = new TLRPC$TL_channel();
                        chat.id = i2;
                    }
                    arrayList3.add(chat);
                }
            }
        }
    }

    public static TLRPC$TL_groupCallParticipant convertGroupVoiceChatParticipant(GroupCallModels.GroupVoiceChatParticipant groupVoiceChatParticipant) {
        ObjectGuidType objectGuidType = groupVoiceChatParticipant.participant_object_guid_type;
        return convertGroupVoiceChatParticipant(ChatConverter.getDialogId(objectGuidType.object_guid, objectGuidType.type), groupVoiceChatParticipant);
    }

    private static TLRPC$TL_groupCallParticipant convertGroupVoiceChatParticipant(long j, GroupCallModels.GroupVoiceChatParticipant groupVoiceChatParticipant) {
        TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant = new TLRPC$TL_groupCallParticipant();
        ObjectGuidType objectGuidType = groupVoiceChatParticipant.participant_object_guid_type;
        tLRPC$TL_groupCallParticipant.peer = ChatConverter.getPeer(j, objectGuidType.object_guid, objectGuidType.type);
        tLRPC$TL_groupCallParticipant.muted = groupVoiceChatParticipant.is_mute;
        tLRPC$TL_groupCallParticipant.can_self_unmute = groupVoiceChatParticipant.can_self_unmute;
        tLRPC$TL_groupCallParticipant.date = groupVoiceChatParticipant.join_date;
        tLRPC$TL_groupCallParticipant.active_date = groupVoiceChatParticipant.active_date;
        tLRPC$TL_groupCallParticipant.raise_hand_rating = groupVoiceChatParticipant.request_speak;
        tLRPC$TL_groupCallParticipant.about = groupVoiceChatParticipant.about;
        tLRPC$TL_groupCallParticipant.canManageCallVoiceChat = groupVoiceChatParticipant.can_manage_voice_chat;
        return tLRPC$TL_groupCallParticipant;
    }

    public static TLRPC$User getDisplayUser(GroupCallModels.DisplayAsGroupVoiceChat displayAsGroupVoiceChat) {
        if (displayAsGroupVoiceChat == null || displayAsGroupVoiceChat.type != ChatType.User) {
            return null;
        }
        TLRPC$TL_user tLRPC$TL_user = new TLRPC$TL_user();
        tLRPC$TL_user.id = (int) IdStorage.getInstance().generateDialogId(displayAsGroupVoiceChat.object_guid);
        tLRPC$TL_user.first_name = displayAsGroupVoiceChat.title;
        AvatarFileInline avatarFileInline = displayAsGroupVoiceChat.avatar_thumbnail;
        if (avatarFileInline != null) {
            tLRPC$TL_user.photo = ChatConverter.getUserProfilePhoto(avatarFileInline);
            tLRPC$TL_user.access_hash = IdStorage.getInstance().generateAccessHash(displayAsGroupVoiceChat.avatar_thumbnail.access_hash_rec);
        }
        return tLRPC$TL_user;
    }

    public static TLRPC$Chat getDisplayChat(GroupCallModels.DisplayAsGroupVoiceChat displayAsGroupVoiceChat) {
        if (displayAsGroupVoiceChat == null) {
            return null;
        }
        ChatType chatType = displayAsGroupVoiceChat.type;
        if (chatType != ChatType.Channel && chatType != ChatType.Group) {
            return null;
        }
        TLRPC$TL_channel tLRPC$TL_channel = new TLRPC$TL_channel();
        tLRPC$TL_channel.id = -((int) IdStorage.getInstance().generateNegativeDialogId(displayAsGroupVoiceChat.object_guid));
        tLRPC$TL_channel.title = displayAsGroupVoiceChat.title;
        tLRPC$TL_channel.megagroup = displayAsGroupVoiceChat.type == ChatType.Group;
        tLRPC$TL_channel.verified = displayAsGroupVoiceChat.is_verified;
        tLRPC$TL_channel.participants_count = displayAsGroupVoiceChat.count_members;
        AvatarFileInline avatarFileInline = displayAsGroupVoiceChat.avatar_thumbnail;
        if (avatarFileInline != null) {
            tLRPC$TL_channel.photo = ChatConverter.getChatPhoto(avatarFileInline);
            tLRPC$TL_channel.access_hash = IdStorage.getInstance().generateAccessHash(displayAsGroupVoiceChat.avatar_thumbnail.access_hash_rec);
        }
        return tLRPC$TL_channel;
    }

    public static TLRPC$PhoneCall updateWithCallUpdate(TLRPC$PhoneCall tLRPC$PhoneCall, VoiceCallModels.CallUpdateObject callUpdateObject, boolean z) {
        TLRPC$PhoneCall tLRPC$TL_phoneCall;
        if (tLRPC$PhoneCall == null) {
            return null;
        }
        try {
            TLRPC$PhoneCall tLRPC$PhoneCall2 = (TLRPC$PhoneCall) tLRPC$PhoneCall.clone();
            if (callUpdateObject.action == VoiceCallModels.CallUpdateActionEnum.Edit) {
                Iterator<String> it = callUpdateObject.updated_parameters.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    Integer numValueOf = tLRPC$PhoneCall2.updatedTimeStampMap.get(next);
                    if (numValueOf == null) {
                        numValueOf = Integer.valueOf(tLRPC$PhoneCall2.timestamp);
                    }
                    if (numValueOf.intValue() <= callUpdateObject.timestamp) {
                        if (next.equals("state")) {
                            VoiceCallModels.CallStateEnum callStateEnum = callUpdateObject.call.state;
                            if (callStateEnum == VoiceCallModels.CallStateEnum.Requested) {
                                if (z) {
                                    tLRPC$TL_phoneCall = new TLRPC$TL_phoneCallRequested();
                                } else {
                                    tLRPC$TL_phoneCall = new TLRPC$TL_phoneCallWaiting();
                                }
                            } else if (callStateEnum == VoiceCallModels.CallStateEnum.Accepted) {
                                tLRPC$TL_phoneCall = new TLRPC$TL_phoneCallAccepted();
                            } else if (callStateEnum == VoiceCallModels.CallStateEnum.Discarded) {
                                tLRPC$TL_phoneCall = new TLRPC$TL_phoneCallDiscarded();
                            } else if (callStateEnum == VoiceCallModels.CallStateEnum.Waiting) {
                                tLRPC$TL_phoneCall = new TLRPC$TL_phoneCallWaiting();
                            } else {
                                tLRPC$TL_phoneCall = new TLRPC$TL_phoneCall();
                            }
                            tLRPC$PhoneCall2.cloneFields(tLRPC$TL_phoneCall);
                            tLRPC$TL_phoneCall.updatedTimeStampMap.put(next, Integer.valueOf(callUpdateObject.timestamp));
                            tLRPC$PhoneCall2 = tLRPC$TL_phoneCall;
                        }
                        if (next.equals("key")) {
                            tLRPC$PhoneCall2.key = callUpdateObject.call.key;
                            tLRPC$PhoneCall2.updatedTimeStampMap.put(next, Integer.valueOf(callUpdateObject.timestamp));
                        }
                        if (next.equals("connections")) {
                            if (callUpdateObject.call.connections != null) {
                                tLRPC$PhoneCall2.connections = new ArrayList<>();
                                Iterator<VoiceCallModels.PhoneConnection> it2 = callUpdateObject.call.connections.iterator();
                                while (it2.hasNext()) {
                                    tLRPC$PhoneCall2.connections.add(convertConnection(it2.next()));
                                }
                            }
                            tLRPC$PhoneCall2.updatedTimeStampMap.put(next, Integer.valueOf(callUpdateObject.timestamp));
                        }
                        if (next.equals("protocol_layer")) {
                            if (tLRPC$PhoneCall2.protocol == null) {
                                tLRPC$PhoneCall2.protocol = new TLRPC$TL_phoneCallProtocol();
                            }
                            tLRPC$PhoneCall2.protocol.max_layer = callUpdateObject.call.protocol_layer;
                            tLRPC$PhoneCall2.updatedTimeStampMap.put(next, Integer.valueOf(callUpdateObject.timestamp));
                        }
                        if (next.equals("receive_time")) {
                            tLRPC$PhoneCall2.receive_date = callUpdateObject.call.receive_time;
                            tLRPC$PhoneCall2.updatedTimeStampMap.put(next, Integer.valueOf(callUpdateObject.timestamp));
                        }
                        if (next.equals("call_type")) {
                            tLRPC$PhoneCall2.video = callUpdateObject.call.call_type == VoiceCallModels.CallType.Video;
                            tLRPC$PhoneCall2.updatedTimeStampMap.put(next, Integer.valueOf(callUpdateObject.timestamp));
                        }
                        if (next.equals("library_versions")) {
                            if (tLRPC$PhoneCall2.protocol == null) {
                                tLRPC$PhoneCall2.protocol = new TLRPC$TL_phoneCallProtocol();
                            }
                            tLRPC$PhoneCall2.protocol.library_versions = callUpdateObject.call.library_versions;
                            tLRPC$PhoneCall2.updatedTimeStampMap.put(next, Integer.valueOf(callUpdateObject.timestamp));
                        }
                        if (next.equals("duration")) {
                            tLRPC$PhoneCall2.duration = callUpdateObject.call.duration;
                            tLRPC$PhoneCall2.updatedTimeStampMap.put(next, Integer.valueOf(callUpdateObject.timestamp));
                        }
                        if (next.equals("discard_reason")) {
                            tLRPC$PhoneCall2.reason = getDiscardCallReason(callUpdateObject.call.discard_reason);
                            tLRPC$PhoneCall2.updatedTimeStampMap.put(next, Integer.valueOf(callUpdateObject.timestamp));
                        }
                    }
                }
            }
            return tLRPC$PhoneCall2;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static TLRPC$GroupCall updateWithCallUpdate(int i, TLRPC$GroupCall tLRPC$GroupCall, GroupCallModels.GroupVoiceChatUpdate groupVoiceChatUpdate) {
        TLRPC$GroupCall tLRPC$TL_groupCallDiscarded;
        if (tLRPC$GroupCall == null) {
            return null;
        }
        if (groupVoiceChatUpdate == null) {
            return tLRPC$GroupCall;
        }
        try {
            TLRPC$GroupCall tLRPC$GroupCall2 = (TLRPC$GroupCall) tLRPC$GroupCall.clone();
            if (groupVoiceChatUpdate.action == GroupCallModels.GroupVoiceChatUpdateAction.New) {
                ObjectGuidType objectGuidType = groupVoiceChatUpdate.chat_guid_type;
                return i == (-((int) (ChatConverter.getDialogId(objectGuidType.object_guid, objectGuidType.type) * (-1)))) ? convertGroupCall(groupVoiceChatUpdate.group_voice_chat) : tLRPC$GroupCall;
            }
            String str = tLRPC$GroupCall.id;
            if (str == null || !str.equals(groupVoiceChatUpdate.voice_chat_id)) {
                return tLRPC$GroupCall2;
            }
            GroupCallModels.GroupVoiceChatUpdateAction groupVoiceChatUpdateAction = groupVoiceChatUpdate.action;
            if (groupVoiceChatUpdateAction == GroupCallModels.GroupVoiceChatUpdateAction.Edit) {
                Set<String> set = groupVoiceChatUpdate.updated_parameters;
                if (set == null) {
                    return tLRPC$GroupCall2;
                }
                if (set.contains(GroupCallModels.GroupVoiceChatUpdateParameter.state + BuildConfig.FLAVOR)) {
                    if (groupVoiceChatUpdate.group_voice_chat.state == GroupCallModels.StateGroupVoiceChat.Running) {
                        tLRPC$TL_groupCallDiscarded = new TLRPC$TL_groupCall();
                    } else {
                        tLRPC$TL_groupCallDiscarded = new TLRPC$TL_groupCallDiscarded();
                    }
                    tLRPC$GroupCall2.cloneFields(tLRPC$TL_groupCallDiscarded);
                    tLRPC$GroupCall2 = tLRPC$TL_groupCallDiscarded;
                }
                if (groupVoiceChatUpdate.updated_parameters.contains(GroupCallModels.GroupVoiceChatUpdateParameter.join_muted + BuildConfig.FLAVOR)) {
                    tLRPC$GroupCall2.join_muted = groupVoiceChatUpdate.group_voice_chat.join_muted;
                }
                if (groupVoiceChatUpdate.updated_parameters.contains(GroupCallModels.GroupVoiceChatUpdateParameter.participant_count + BuildConfig.FLAVOR)) {
                    tLRPC$GroupCall2.participants_count = groupVoiceChatUpdate.group_voice_chat.participant_count;
                }
                if (!groupVoiceChatUpdate.updated_parameters.contains(GroupCallModels.GroupVoiceChatUpdateParameter.title + BuildConfig.FLAVOR)) {
                    return tLRPC$GroupCall2;
                }
                tLRPC$GroupCall2.title = groupVoiceChatUpdate.group_voice_chat.title;
                return tLRPC$GroupCall2;
            }
            if (groupVoiceChatUpdateAction != GroupCallModels.GroupVoiceChatUpdateAction.Delete) {
                return tLRPC$GroupCall2;
            }
            TLRPC$TL_groupCallDiscarded tLRPC$TL_groupCallDiscarded2 = new TLRPC$TL_groupCallDiscarded();
            tLRPC$GroupCall2.cloneFields(tLRPC$TL_groupCallDiscarded2);
            return tLRPC$TL_groupCallDiscarded2;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static TLRPC$TL_groupCallParticipant updateParticipant(TLRPC$TL_groupCallParticipant tLRPC$TL_groupCallParticipant, GroupCallModels.GroupVoiceChatParticipantUpdate groupVoiceChatParticipantUpdate, boolean z, int i) {
        GroupCallModels.GroupVoiceChatParticipantUpdateAction groupVoiceChatParticipantUpdateAction = groupVoiceChatParticipantUpdate.action;
        if (groupVoiceChatParticipantUpdateAction == GroupCallModels.GroupVoiceChatParticipantUpdateAction.New) {
            return convertGroupVoiceChatParticipant(groupVoiceChatParticipantUpdate.group_voice_chat_participant);
        }
        if (groupVoiceChatParticipantUpdateAction != GroupCallModels.GroupVoiceChatParticipantUpdateAction.Edit) {
            return null;
        }
        GroupCallModels.GroupVoiceChatParticipantUpdateParameter groupVoiceChatParticipantUpdateParameter = GroupCallModels.GroupVoiceChatParticipantUpdateParameter.is_mute;
        if (groupVoiceChatParticipantUpdate.updated_parameters.contains(groupVoiceChatParticipantUpdateParameter + BuildConfig.FLAVOR)) {
            long updateParamTimeStamp = tLRPC$TL_groupCallParticipant.getUpdateParamTimeStamp(groupVoiceChatParticipantUpdateParameter);
            int i2 = groupVoiceChatParticipantUpdate.timestamp;
            if (updateParamTimeStamp <= i2) {
                tLRPC$TL_groupCallParticipant.setUpdateParamTimeStamp(groupVoiceChatParticipantUpdateParameter, i2);
                tLRPC$TL_groupCallParticipant.muted = groupVoiceChatParticipantUpdate.group_voice_chat_participant.is_mute;
            }
        }
        GroupCallModels.GroupVoiceChatParticipantUpdateParameter groupVoiceChatParticipantUpdateParameter2 = GroupCallModels.GroupVoiceChatParticipantUpdateParameter.can_self_unmute;
        if (groupVoiceChatParticipantUpdate.updated_parameters.contains(groupVoiceChatParticipantUpdateParameter2 + BuildConfig.FLAVOR)) {
            long updateParamTimeStamp2 = tLRPC$TL_groupCallParticipant.getUpdateParamTimeStamp(groupVoiceChatParticipantUpdateParameter2);
            int i3 = groupVoiceChatParticipantUpdate.timestamp;
            if (updateParamTimeStamp2 <= i3) {
                tLRPC$TL_groupCallParticipant.setUpdateParamTimeStamp(groupVoiceChatParticipantUpdateParameter2, i3);
                tLRPC$TL_groupCallParticipant.can_self_unmute = groupVoiceChatParticipantUpdate.group_voice_chat_participant.can_self_unmute;
            }
        }
        GroupCallModels.GroupVoiceChatParticipantUpdateParameter groupVoiceChatParticipantUpdateParameter3 = GroupCallModels.GroupVoiceChatParticipantUpdateParameter.join_date;
        if (groupVoiceChatParticipantUpdate.updated_parameters.contains(groupVoiceChatParticipantUpdateParameter3 + BuildConfig.FLAVOR)) {
            long updateParamTimeStamp3 = tLRPC$TL_groupCallParticipant.getUpdateParamTimeStamp(groupVoiceChatParticipantUpdateParameter3);
            int i4 = groupVoiceChatParticipantUpdate.timestamp;
            if (updateParamTimeStamp3 <= i4) {
                tLRPC$TL_groupCallParticipant.setUpdateParamTimeStamp(groupVoiceChatParticipantUpdateParameter3, i4);
                tLRPC$TL_groupCallParticipant.date = groupVoiceChatParticipantUpdate.group_voice_chat_participant.join_date;
            }
        }
        GroupCallModels.GroupVoiceChatParticipantUpdateParameter groupVoiceChatParticipantUpdateParameter4 = GroupCallModels.GroupVoiceChatParticipantUpdateParameter.request_speak;
        if (groupVoiceChatParticipantUpdate.updated_parameters.contains(groupVoiceChatParticipantUpdateParameter4 + BuildConfig.FLAVOR)) {
            long updateParamTimeStamp4 = tLRPC$TL_groupCallParticipant.getUpdateParamTimeStamp(groupVoiceChatParticipantUpdateParameter4);
            int i5 = groupVoiceChatParticipantUpdate.timestamp;
            if (updateParamTimeStamp4 <= i5) {
                tLRPC$TL_groupCallParticipant.setUpdateParamTimeStamp(groupVoiceChatParticipantUpdateParameter4, i5);
                tLRPC$TL_groupCallParticipant.raise_hand_rating = groupVoiceChatParticipantUpdate.group_voice_chat_participant.request_speak;
            }
        }
        GroupCallModels.GroupVoiceChatParticipantUpdateParameter groupVoiceChatParticipantUpdateParameter5 = GroupCallModels.GroupVoiceChatParticipantUpdateParameter.can_manage_voice_chat;
        if (groupVoiceChatParticipantUpdate.updated_parameters.contains(groupVoiceChatParticipantUpdateParameter5 + BuildConfig.FLAVOR)) {
            long updateParamTimeStamp5 = tLRPC$TL_groupCallParticipant.getUpdateParamTimeStamp(groupVoiceChatParticipantUpdateParameter5);
            int i6 = groupVoiceChatParticipantUpdate.timestamp;
            if (updateParamTimeStamp5 <= i6) {
                tLRPC$TL_groupCallParticipant.setUpdateParamTimeStamp(groupVoiceChatParticipantUpdateParameter5, i6);
                tLRPC$TL_groupCallParticipant.canManageCallVoiceChat = groupVoiceChatParticipantUpdate.group_voice_chat_participant.can_manage_voice_chat;
            }
        }
        GroupCallModels.GroupVoiceChatParticipantUpdateParameter groupVoiceChatParticipantUpdateParameter6 = GroupCallModels.GroupVoiceChatParticipantUpdateParameter.active_date;
        if (!groupVoiceChatParticipantUpdate.updated_parameters.contains(groupVoiceChatParticipantUpdateParameter6 + BuildConfig.FLAVOR)) {
            return tLRPC$TL_groupCallParticipant;
        }
        long updateParamTimeStamp6 = tLRPC$TL_groupCallParticipant.getUpdateParamTimeStamp(groupVoiceChatParticipantUpdateParameter6);
        int i7 = groupVoiceChatParticipantUpdate.timestamp;
        if (updateParamTimeStamp6 > i7) {
            return tLRPC$TL_groupCallParticipant;
        }
        tLRPC$TL_groupCallParticipant.setUpdateParamTimeStamp(groupVoiceChatParticipantUpdateParameter6, i7);
        tLRPC$TL_groupCallParticipant.lastTypingDate = Math.max(tLRPC$TL_groupCallParticipant.active_date, groupVoiceChatParticipantUpdate.group_voice_chat_participant.active_date);
        tLRPC$TL_groupCallParticipant.active_date = groupVoiceChatParticipantUpdate.group_voice_chat_participant.active_date;
        if (!z || MessageObject.getPeerId(tLRPC$TL_groupCallParticipant.peer) == i) {
            return tLRPC$TL_groupCallParticipant;
        }
        tLRPC$TL_groupCallParticipant.lastSpeakTime = SystemClock.uptimeMillis();
        return tLRPC$TL_groupCallParticipant;
    }

    private static ArrayList<String> getLines(String[] strArr, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : strArr) {
            if (str2.startsWith(str)) {
                arrayList.add(str2.substring(str.length()));
            }
        }
        return arrayList;
    }

    public static String convertAnswerSdp(String str) {
        if (TextUtils.isEmpty(str)) {
            return BuildConfig.FLAVOR;
        }
        String strReplaceAll = str.replaceAll("\r", BuildConfig.FLAVOR);
        GroupCallSdp.Sdp sdp = new GroupCallSdp.Sdp();
        String[] strArrSplit = strReplaceAll.split("\n");
        sdp.transport = new GroupCallSdp.Transport();
        sdp.audio = new GroupCallSdp.Audio();
        ArrayList<String> lines = getLines(strArrSplit, "a=ice-ufrag:");
        if (lines.size() != 1) {
            return BuildConfig.FLAVOR;
        }
        int i = 0;
        sdp.transport.ufrag = lines.get(0);
        ArrayList<String> lines2 = getLines(strArrSplit, "a=ice-pwd:");
        if (lines2.size() != 1) {
            return BuildConfig.FLAVOR;
        }
        sdp.transport.pwd = lines2.get(0);
        ArrayList<String> lines3 = getLines(strArrSplit, "a=setup:");
        if (lines3.size() != 1) {
            return BuildConfig.FLAVOR;
        }
        Iterator<String> it = getLines(strArrSplit, "a=fingerprint:").iterator();
        while (it.hasNext()) {
            String[] strArrSplit2 = it.next().split(" ");
            if (strArrSplit2.length == 2) {
                GroupCallSdp.Fingerprint fingerprint = new GroupCallSdp.Fingerprint();
                fingerprint.hash = strArrSplit2[0];
                fingerprint.fingerprint = strArrSplit2[1];
                fingerprint.setup = lines3.get(0);
                sdp.transport.fingerprints.add(fingerprint);
            }
        }
        Iterator<String> it2 = getLines(strArrSplit, "a=candidate:").iterator();
        while (it2.hasNext()) {
            String[] strArrSplit3 = it2.next().split(" ");
            if (strArrSplit3.length == 8) {
                GroupCallSdp.Candidate candidate = new GroupCallSdp.Candidate();
                candidate.foundation = strArrSplit3[0];
                candidate.component = strArrSplit3[1];
                candidate.protocol = strArrSplit3[2];
                candidate.priority = strArrSplit3[3];
                candidate.ip = strArrSplit3[4];
                candidate.port = strArrSplit3[5];
                candidate.type = strArrSplit3[7];
                candidate.generation = "0";
                candidate.network = "0";
                candidate.id = strArrSplit3[0];
                sdp.transport.candidates.add(0, candidate);
            }
        }
        HashSet hashSet = new HashSet();
        Iterator<String> it3 = getLines(strArrSplit, "a=ssrc:").iterator();
        while (it3.hasNext()) {
            String[] strArrSplit4 = it3.next().split(" ");
            if (strArrSplit4.length != 0) {
                try {
                    hashSet.add(Integer.valueOf(Integer.parseInt(strArrSplit4[0])));
                } catch (Exception unused) {
                }
            }
        }
        if (!hashSet.isEmpty()) {
            sdp.ssrcs = new int[hashSet.size()];
            Iterator it4 = hashSet.iterator();
            while (it4.hasNext()) {
                sdp.ssrcs[i] = ((Integer) it4.next()).intValue();
                i++;
            }
        }
        return ApplicationLoader.getGson().toJson(sdp);
    }
}
