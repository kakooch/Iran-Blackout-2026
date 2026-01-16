package androidMessenger.utilites;

import androidMessenger.proxy.IdStorage;
import ir.aaap.messengercore.CoreMainClass;
import ir.aaap.messengercore.exceptions.InputException;
import ir.aaap.messengercore.model.BotInfo;
import ir.aaap.messengercore.model.ChannelInfo;
import ir.aaap.messengercore.model.ChannelInfoFromServer;
import ir.aaap.messengercore.model.Chat;
import ir.aaap.messengercore.model.ChatAbsObject;
import ir.aaap.messengercore.model.ChatReactionSetting;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.GroupInfo;
import ir.aaap.messengercore.model.GroupInfoFromServer;
import ir.aaap.messengercore.model.InChatMember;
import ir.aaap.messengercore.model.InChatMemberFromServer;
import ir.aaap.messengercore.model.ObjectInfo;
import ir.aaap.messengercore.model.OnlineTimeObject;
import ir.aaap.messengercore.model.ReactionObject;
import ir.aaap.messengercore.model.ServiceInfo;
import ir.aaap.messengercore.model.UserInfo;
import ir.aaap.messengercore.model.api.BotCommandObject;
import ir.resaneh1.iptv.helper.FirebaseEventSender;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.rbmain.tgnet.TLRPC$BotInfo;
import org.rbmain.tgnet.TLRPC$ChannelParticipant;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatFull;
import org.rbmain.tgnet.TLRPC$ChatReactions;
import org.rbmain.tgnet.TLRPC$TL_botCommand;
import org.rbmain.tgnet.TLRPC$TL_botInfo;
import org.rbmain.tgnet.TLRPC$TL_channelFull;
import org.rbmain.tgnet.TLRPC$TL_channelParticipant;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantAdmin;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantBanned;
import org.rbmain.tgnet.TLRPC$TL_channelParticipantCreator;
import org.rbmain.tgnet.TLRPC$TL_channels_channelParticipants;
import org.rbmain.tgnet.TLRPC$TL_chatReactionsAll;
import org.rbmain.tgnet.TLRPC$TL_chatReactionsNone;
import org.rbmain.tgnet.TLRPC$TL_chatReactionsSome;
import org.rbmain.tgnet.TLRPC$TL_inputGroupCall;
import org.rbmain.tgnet.TLRPC$TL_messages_chatFull;
import org.rbmain.tgnet.TLRPC$TL_peerUser;
import org.rbmain.tgnet.TLRPC$TL_userFull;
import org.rbmain.tgnet.TLRPC$TL_userStatusEmpty;
import org.rbmain.tgnet.TLRPC$TL_userStatusLastMonth;
import org.rbmain.tgnet.TLRPC$TL_userStatusLastWeek;
import org.rbmain.tgnet.TLRPC$TL_userStatusOffline;
import org.rbmain.tgnet.TLRPC$TL_userStatusOnline;
import org.rbmain.tgnet.TLRPC$TL_userStatusRecently;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserFull;
import org.rbmain.tgnet.TLRPC$UserStatus;

/* loaded from: classes.dex */
public class ObjectInfoConverter {
    public static TLRPC$TL_messages_chatFull convert(CoreMainClass coreMainClass, TLRPC$Chat tLRPC$Chat, ObjectInfo objectInfo, ChatType chatType) {
        ChannelInfo channelInfo;
        ArrayList<Long> arrayList;
        String str;
        GroupInfo groupInfo;
        HashSet<Chat.ChatAccessEnum> hashSet;
        int i;
        if (objectInfo == null) {
            return null;
        }
        TLRPC$TL_messages_chatFull tLRPC$TL_messages_chatFull = new TLRPC$TL_messages_chatFull();
        tLRPC$TL_messages_chatFull.full_chat = new TLRPC$TL_channelFull();
        Chat chatInstant = coreMainClass.getChatInstant(objectInfo.objectGuid);
        if (chatType == ChatType.Group && (groupInfo = objectInfo.groupInfo) != null) {
            ArrayList<TLRPC$User> arrayList2 = new ArrayList<>();
            tLRPC$TL_messages_chatFull.full_chat.id = ((int) IdStorage.getInstance().generateDialogId(objectInfo.objectGuid)) * (-1);
            TLRPC$ChatFull tLRPC$ChatFull = tLRPC$TL_messages_chatFull.full_chat;
            tLRPC$ChatFull.about = groupInfo.description;
            if (chatInstant != null && (i = chatInstant.slow_mode_duration) != 0) {
                tLRPC$ChatFull.slowmode_next_send_date = i + chatInstant.group_my_last_send_time;
            }
            int i2 = groupInfo.slow_mode;
            if (i2 != 0) {
                tLRPC$ChatFull.slowmode_seconds = i2;
            }
            tLRPC$ChatFull.participants_count = (int) groupInfo.count_members;
            tLRPC$TL_messages_chatFull.users = arrayList2;
            if (chatInstant != null && (hashSet = chatInstant.access) != null && hashSet.contains(Chat.ChatAccessEnum.ViewMembers)) {
                tLRPC$TL_messages_chatFull.full_chat.can_view_participants = true;
            }
            TLRPC$ChatFull tLRPC$ChatFull2 = tLRPC$TL_messages_chatFull.full_chat;
            tLRPC$ChatFull2.warningObject = groupInfo.warning_info;
            tLRPC$ChatFull2.hidden_prehistory = groupInfo.chat_history_for_new_members == GroupInfoFromServer.ChatHistoryForNewMembers.Hidden;
            tLRPC$ChatFull2.event_messages = groupInfo.event_messages;
            tLRPC$ChatFull2.available_reactions = convertReactions(groupInfo.chat_reaction_setting, coreMainClass.getAvailableReactions());
        } else if (chatType == ChatType.Channel && (channelInfo = objectInfo.channelInfo) != null) {
            tLRPC$TL_messages_chatFull.full_chat.id = ((int) IdStorage.getInstance().generateDialogId(objectInfo.objectGuid)) * (-1);
            TLRPC$ChatFull tLRPC$ChatFull3 = tLRPC$TL_messages_chatFull.full_chat;
            tLRPC$ChatFull3.about = channelInfo.description;
            tLRPC$ChatFull3.participants_count = (int) channelInfo.count_members;
            ArrayList<TLRPC$Chat> arrayList3 = new ArrayList<>();
            tLRPC$TL_messages_chatFull.chats = arrayList3;
            arrayList3.add(tLRPC$Chat);
            TLRPC$ChatFull tLRPC$ChatFull4 = tLRPC$TL_messages_chatFull.full_chat;
            tLRPC$ChatFull4.warningObject = objectInfo.channelInfo.warning_info;
            tLRPC$ChatFull4.available_reactions = convertReactions(channelInfo.chat_reaction_setting, coreMainClass.getAvailableReactions());
        }
        if (chatInstant != null && (str = chatInstant.group_voice_chat_id) != null && !str.isEmpty()) {
            tLRPC$TL_messages_chatFull.full_chat.call = new TLRPC$TL_inputGroupCall();
            TLRPC$ChatFull tLRPC$ChatFull5 = tLRPC$TL_messages_chatFull.full_chat;
            TLRPC$TL_inputGroupCall tLRPC$TL_inputGroupCall = tLRPC$ChatFull5.call;
            tLRPC$TL_inputGroupCall.id = chatInstant.group_voice_chat_id;
            tLRPC$TL_inputGroupCall.chat_id = tLRPC$ChatFull5.id;
        }
        setObjectInfoChat(tLRPC$Chat, objectInfo, chatType == ChatType.Channel);
        if (chatInstant != null && (arrayList = chatInstant.pinned_message_ids) != null && arrayList.size() > 0) {
            TLRPC$ChatFull tLRPC$ChatFull6 = tLRPC$TL_messages_chatFull.full_chat;
            ArrayList<Long> arrayList4 = chatInstant.pinned_message_ids;
            tLRPC$ChatFull6.pinned_msg_id = arrayList4.get(arrayList4.size() - 1).longValue();
        }
        tLRPC$TL_messages_chatFull.full_chat.online_count = coreMainClass.getGroupOnlineCount(objectInfo.objectGuid);
        setRights(tLRPC$TL_messages_chatFull.full_chat, tLRPC$Chat, chatType);
        ArrayList<TLRPC$Chat> arrayList5 = new ArrayList<>();
        tLRPC$TL_messages_chatFull.chats = arrayList5;
        arrayList5.add(tLRPC$Chat);
        return tLRPC$TL_messages_chatFull;
    }

    private static void setRights(TLRPC$ChatFull tLRPC$ChatFull, TLRPC$Chat tLRPC$Chat, ChatType chatType) {
        HashSet<Chat.ChatAccessEnum> hashSet;
        if (tLRPC$Chat == null || (hashSet = tLRPC$Chat.accessEnumHashSet) == null) {
            return;
        }
        tLRPC$ChatFull.can_set_username = hashSet.contains(Chat.ChatAccessEnum.ChangeInfo);
        tLRPC$ChatFull.can_view_participants = tLRPC$Chat.accessEnumHashSet.contains(Chat.ChatAccessEnum.ViewMembers);
    }

    public static void setObjectInfoChat(TLRPC$Chat tLRPC$Chat, ObjectInfo objectInfo, boolean z) {
        ChannelInfo channelInfo;
        if (objectInfo == null || tLRPC$Chat == null) {
            return;
        }
        if (z && (channelInfo = objectInfo.channelInfo) != null) {
            tLRPC$Chat.username = channelInfo.username;
            tLRPC$Chat.shareLink = channelInfo.share_url;
            tLRPC$Chat.signatures = channelInfo.sign_messages;
            if (channelInfo.channel_type == ChannelInfoFromServer.ChannelTypeEnum.Public) {
                tLRPC$Chat.flags |= 64;
            }
            tLRPC$Chat.participants_count = (int) channelInfo.count_members;
            return;
        }
        GroupInfo groupInfo = objectInfo.groupInfo;
        if (groupInfo != null) {
            tLRPC$Chat.participants_count = (int) groupInfo.count_members;
        }
    }

    public static TLRPC$UserFull convert(CoreMainClass coreMainClass, TLRPC$User tLRPC$User, ObjectInfo objectInfo, ChatType chatType, Chat chat) {
        if (objectInfo == null || tLRPC$User == null) {
            return null;
        }
        TLRPC$TL_userFull tLRPC$TL_userFull = new TLRPC$TL_userFull();
        if (chatType == ChatType.User) {
            UserInfo userInfo = objectInfo.userInfo;
            if (userInfo != null) {
                tLRPC$TL_userFull.about = userInfo.bio;
                tLRPC$TL_userFull.phone_calls_available = userInfo.can_receive_call;
                tLRPC$TL_userFull.video_calls_available = userInfo.can_video_call;
                tLRPC$TL_userFull.common_chats_count = (int) userInfo.count_common_groups;
            } else {
                FirebaseEventSender.setKey("convert", "chatType" + chatType + objectInfo.objectGuid + " " + chat.object_guid);
                FirebaseEventSender.recordException(new InputException());
            }
            if (chat != null) {
                tLRPC$TL_userFull.blocked = chat.is_blocked;
                HashSet<Chat.ChatAccessEnum> hashSet = chat.access;
                if (hashSet != null && hashSet.contains(Chat.ChatAccessEnum.PinMessages)) {
                    z = true;
                }
                tLRPC$TL_userFull.can_pin_message = z;
                ArrayList<Long> arrayList = chat.pinned_message_ids;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList<Long> arrayList2 = chat.pinned_message_ids;
                    tLRPC$TL_userFull.pinned_msg_id = arrayList2.get(arrayList2.size() - 1).longValue();
                }
            }
            setObjectInfoUserOrBotOrService(coreMainClass, tLRPC$User, objectInfo);
            tLRPC$TL_userFull.user = tLRPC$User;
            tLRPC$TL_userFull.warningObject = objectInfo.userInfo.warning_info;
        } else if (chatType == ChatType.Bot) {
            BotInfo botInfo = objectInfo.botInfo;
            if (chat != null) {
                tLRPC$TL_userFull.blocked = chat.status == Chat.ChatStatusEnum.Stopped || chat.is_blocked;
            }
            tLRPC$TL_userFull.bot_info = convertBotInfoObject(botInfo);
            setObjectInfoUserOrBotOrService(coreMainClass, tLRPC$User, objectInfo);
            tLRPC$TL_userFull.user = tLRPC$User;
            tLRPC$TL_userFull.warningObject = objectInfo.botInfo.warning_info;
        } else if (chatType == ChatType.Service) {
            if (chat != null) {
                tLRPC$TL_userFull.blocked = chat.status == Chat.ChatStatusEnum.Stopped || chat.is_blocked;
            }
            setObjectInfoUserOrBotOrService(coreMainClass, tLRPC$User, objectInfo);
            ServiceInfo serviceInfo = objectInfo.serviceInfo;
            tLRPC$TL_userFull.about = serviceInfo.description;
            tLRPC$TL_userFull.user = tLRPC$User;
            tLRPC$TL_userFull.warningObject = serviceInfo.warning_info;
        }
        return tLRPC$TL_userFull;
    }

    private static TLRPC$BotInfo convertBotInfoObject(BotInfo botInfo) {
        TLRPC$TL_botInfo tLRPC$TL_botInfo = new TLRPC$TL_botInfo();
        tLRPC$TL_botInfo.description = botInfo.description;
        tLRPC$TL_botInfo.user_id = (int) IdStorage.getInstance().generateDialogId(botInfo.bot_guid);
        tLRPC$TL_botInfo.start_message = botInfo.start_message;
        ArrayList<BotCommandObject> arrayList = botInfo.commands;
        if (arrayList != null) {
            Iterator<BotCommandObject> it = arrayList.iterator();
            while (it.hasNext()) {
                BotCommandObject next = it.next();
                TLRPC$TL_botCommand tLRPC$TL_botCommand = new TLRPC$TL_botCommand();
                tLRPC$TL_botCommand.command = next.command;
                tLRPC$TL_botCommand.description = next.description;
                tLRPC$TL_botInfo.commands.add(tLRPC$TL_botCommand);
            }
        }
        return tLRPC$TL_botInfo;
    }

    public static TLRPC$User setObjectInfoUserOrBotOrService(CoreMainClass coreMainClass, TLRPC$User tLRPC$User, ObjectInfo objectInfo) {
        UserInfo userInfo;
        BotInfo botInfo;
        if (objectInfo != null && ((userInfo = objectInfo.userInfo) != null || objectInfo.botInfo != null || objectInfo.serviceInfo != null)) {
            if (tLRPC$User.bot && (botInfo = objectInfo.botInfo) != null) {
                tLRPC$User.username = botInfo.username;
            } else if ((!tLRPC$User.support || objectInfo.serviceInfo == null) && userInfo != null) {
                tLRPC$User.username = userInfo.username;
                tLRPC$User.phone = userInfo.phone;
                tLRPC$User.status = getUserStatus(coreMainClass, userInfo.online_time);
                long j = userInfo.timeStamp;
                if (j < 0) {
                    j = 0;
                }
                tLRPC$User.userInfotimeStamp = j;
            }
        }
        return tLRPC$User;
    }

    public static TLRPC$UserStatus getUserStatus(CoreMainClass coreMainClass, OnlineTimeObject onlineTimeObject) {
        TLRPC$UserStatus tLRPC$TL_userStatusOnline;
        if (onlineTimeObject != null && onlineTimeObject.type == OnlineTimeObject.Type.Exact) {
            int i = (int) onlineTimeObject.exact_time;
            int timeMillis = (int) (coreMainClass.getTimeMillis() / 1000);
            int diffForOnline = coreMainClass.getDiffForOnline();
            int i2 = timeMillis - i;
            if (i2 > 7776000) {
                return new TLRPC$TL_userStatusEmpty();
            }
            if (i2 > diffForOnline) {
                tLRPC$TL_userStatusOnline = new TLRPC$TL_userStatusOffline();
            } else {
                tLRPC$TL_userStatusOnline = new TLRPC$TL_userStatusOnline();
            }
            tLRPC$TL_userStatusOnline.expires = i;
            return tLRPC$TL_userStatusOnline;
        }
        if (onlineTimeObject != null && onlineTimeObject.type == OnlineTimeObject.Type.Approximate) {
            OnlineTimeObject.ApproximatePeriodEnum approximatePeriodEnum = onlineTimeObject.approximate_period;
            if (approximatePeriodEnum == OnlineTimeObject.ApproximatePeriodEnum.MonthAgo) {
                return new TLRPC$TL_userStatusLastMonth();
            }
            if (approximatePeriodEnum == OnlineTimeObject.ApproximatePeriodEnum.WeekAgo) {
                return new TLRPC$TL_userStatusLastWeek();
            }
            if (approximatePeriodEnum == OnlineTimeObject.ApproximatePeriodEnum.LongAgo) {
                return new TLRPC$TL_userStatusEmpty();
            }
            if (approximatePeriodEnum == OnlineTimeObject.ApproximatePeriodEnum.Recently) {
                return new TLRPC$TL_userStatusRecently();
            }
        }
        return null;
    }

    public static TLRPC$TL_channels_channelParticipants convertMembers(CoreMainClass coreMainClass, ArrayList<InChatMember> arrayList) {
        TLRPC$ChannelParticipant tLRPC$TL_channelParticipant;
        TLRPC$TL_channels_channelParticipants tLRPC$TL_channels_channelParticipants = new TLRPC$TL_channels_channelParticipants();
        ArrayList<TLRPC$ChannelParticipant> arrayList2 = new ArrayList<>();
        ArrayList<TLRPC$User> arrayList3 = new ArrayList<>();
        Iterator<InChatMember> it = arrayList.iterator();
        while (it.hasNext()) {
            InChatMember next = it.next();
            long jGenerateDialogId = IdStorage.getInstance().generateDialogId(next.member_guid);
            InChatMemberFromServer.JoinTypeEnum joinTypeEnum = next.join_type;
            if (joinTypeEnum == InChatMemberFromServer.JoinTypeEnum.Creator) {
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipantCreator();
            } else if (joinTypeEnum == InChatMemberFromServer.JoinTypeEnum.Admin) {
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipantAdmin();
            } else if (joinTypeEnum == InChatMemberFromServer.JoinTypeEnum.None) {
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipantBanned();
            } else {
                tLRPC$TL_channelParticipant = new TLRPC$TL_channelParticipant();
            }
            if (next.promoted_by_object_guid != null) {
                tLRPC$TL_channelParticipant.promoted_by = (int) IdStorage.getInstance().generateDialogId(next.promoted_by_object_guid);
                tLRPC$TL_channelParticipant.can_edit = next.promoted_by_object_guid.equals(coreMainClass.getMyGuid());
            }
            if (next.removed_by_object_guid != null) {
                tLRPC$TL_channelParticipant.kicked_by = (int) IdStorage.getInstance().generateDialogId(next.removed_by_object_guid);
            }
            tLRPC$TL_channelParticipant.rank = next.custom_title;
            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
            tLRPC$TL_channelParticipant.peer = tLRPC$TL_peerUser;
            tLRPC$TL_peerUser.user_id = (int) jGenerateDialogId;
            tLRPC$TL_channelParticipant.self = next.member_guid.equals(coreMainClass.getMyGuid());
            String str = next.promoted_by_object_guid;
            tLRPC$TL_channelParticipant.can_edit = str != null && str.equals(coreMainClass.getMyGuid());
            arrayList2.add(tLRPC$TL_channelParticipant);
            ChatAbsObject absInstant = coreMainClass.getAbsInstant(next.member_guid);
            if (absInstant != null) {
                TLRPC$User tLRPC$UserConvertUser = ChatConverter.convertUser(coreMainClass, jGenerateDialogId, absInstant, (UserInfo) null, (Chat) null);
                tLRPC$UserConvertUser.status = getUserStatus(coreMainClass, next.online_time);
                long j = next.timeStamp;
                if (j < 0) {
                    j = 0;
                }
                tLRPC$UserConvertUser.userInfotimeStamp = j;
                tLRPC$UserConvertUser.username = next.username;
                arrayList3.add(tLRPC$UserConvertUser);
            }
        }
        tLRPC$TL_channels_channelParticipants.users = arrayList3;
        tLRPC$TL_channels_channelParticipants.participants = arrayList2;
        return tLRPC$TL_channels_channelParticipants;
    }

    public static TLRPC$User convertMemberToUser(CoreMainClass coreMainClass, InChatMember inChatMember) {
        ChatAbsObject absInstant = coreMainClass.getAbsInstant(inChatMember.member_guid);
        if (absInstant == null) {
            return null;
        }
        TLRPC$User tLRPC$UserConvertUser = ChatConverter.convertUser(coreMainClass, IdStorage.getInstance().generateDialogId(inChatMember.member_guid), absInstant, (UserInfo) null, (Chat) null);
        tLRPC$UserConvertUser.status = getUserStatus(coreMainClass, inChatMember.online_time);
        long j = inChatMember.timeStamp;
        if (j < 0) {
            j = 0;
        }
        tLRPC$UserConvertUser.userInfotimeStamp = j;
        tLRPC$UserConvertUser.username = inChatMember.username;
        return tLRPC$UserConvertUser;
    }

    private static TLRPC$ChatReactions convertReactions(ChatReactionSetting chatReactionSetting, ArrayList<ReactionObject> arrayList) {
        TLRPC$ChatReactions tLRPC$TL_chatReactionsAll = null;
        if (chatReactionSetting == null) {
            return null;
        }
        boolean zIsEmpty = false;
        ChatReactionSetting.ReactionType reactionType = chatReactionSetting.reaction_type;
        if (reactionType == ChatReactionSetting.ReactionType.All) {
            tLRPC$TL_chatReactionsAll = new TLRPC$TL_chatReactionsAll();
        } else if (reactionType != ChatReactionSetting.ReactionType.Selected || chatReactionSetting.selected_reactions == null || arrayList == null) {
            zIsEmpty = true;
        } else {
            TLRPC$TL_chatReactionsSome tLRPC$TL_chatReactionsSome = new TLRPC$TL_chatReactionsSome();
            tLRPC$TL_chatReactionsSome.reactions = new ArrayList<>();
            Iterator<ReactionObject> it = arrayList.iterator();
            while (it.hasNext()) {
                ReactionObject next = it.next();
                if (chatReactionSetting.selected_reactions.contains(next.reaction_id)) {
                    tLRPC$TL_chatReactionsSome.reactions.add(ContactConverter.convertReaction(next));
                }
            }
            zIsEmpty = tLRPC$TL_chatReactionsSome.reactions.isEmpty();
            tLRPC$TL_chatReactionsAll = tLRPC$TL_chatReactionsSome;
        }
        return zIsEmpty ? new TLRPC$TL_chatReactionsNone() : tLRPC$TL_chatReactionsAll;
    }
}
