package androidMessenger.utilites;

import android.text.TextUtils;
import android.util.Base64;
import androidMessenger.proxy.IdStorage;
import androidx.collection.LongSparseArray;
import io.github.inflationx.calligraphy3.BuildConfig;
import ir.aaap.messengercore.CoreMainClass;
import ir.aaap.messengercore.model.AvatarFileInline;
import ir.aaap.messengercore.model.BotInfo;
import ir.aaap.messengercore.model.Chat;
import ir.aaap.messengercore.model.ChatAbsObject;
import ir.aaap.messengercore.model.ChatExtra;
import ir.aaap.messengercore.model.ChatInviteObject;
import ir.aaap.messengercore.model.ChatMessage;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.ColorObject;
import ir.aaap.messengercore.model.DialogFilterSuggested;
import ir.aaap.messengercore.model.FileInlineObject;
import ir.aaap.messengercore.model.FolderObject;
import ir.aaap.messengercore.model.LiveModels;
import ir.aaap.messengercore.model.ObjectGuidType;
import ir.aaap.messengercore.model.ObjectInfo;
import ir.aaap.messengercore.model.ServiceInfo;
import ir.aaap.messengercore.model.StatsGraph;
import ir.aaap.messengercore.model.UserInfo;
import ir.aaap.messengercore.model.api.ChatAdsObject;
import ir.aaap.messengercore.model.api.GetAllStatisticsOutput;
import ir.aaap.messengercore.model.api.InSearchObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.rbmain.messenger.AccountInstance;
import org.rbmain.messenger.ImageLocation;
import org.rbmain.messenger.MessagesController;
import org.rbmain.tgnet.ConnectionsManager;
import org.rbmain.tgnet.TLObject;
import org.rbmain.tgnet.TLRPC$Chat;
import org.rbmain.tgnet.TLRPC$ChatInvite;
import org.rbmain.tgnet.TLRPC$ChatPhoto;
import org.rbmain.tgnet.TLRPC$Dialog;
import org.rbmain.tgnet.TLRPC$FileLocation;
import org.rbmain.tgnet.TLRPC$InputPeer;
import org.rbmain.tgnet.TLRPC$Message;
import org.rbmain.tgnet.TLRPC$Peer;
import org.rbmain.tgnet.TLRPC$StatsGraph;
import org.rbmain.tgnet.TLRPC$TL_GetLiveCommentResult;
import org.rbmain.tgnet.TLRPC$TL_LiveComment;
import org.rbmain.tgnet.TLRPC$TL_channel;
import org.rbmain.tgnet.TLRPC$TL_channelForbidden;
import org.rbmain.tgnet.TLRPC$TL_chatAdminRights;
import org.rbmain.tgnet.TLRPC$TL_chatBannedRights;
import org.rbmain.tgnet.TLRPC$TL_chatInvite;
import org.rbmain.tgnet.TLRPC$TL_chatPhoto;
import org.rbmain.tgnet.TLRPC$TL_chatPhotoEmpty;
import org.rbmain.tgnet.TLRPC$TL_contacts_found;
import org.rbmain.tgnet.TLRPC$TL_dataJSON;
import org.rbmain.tgnet.TLRPC$TL_dialog;
import org.rbmain.tgnet.TLRPC$TL_dialogAd;
import org.rbmain.tgnet.TLRPC$TL_dialogFilter;
import org.rbmain.tgnet.TLRPC$TL_dialogFilterSuggested;
import org.rbmain.tgnet.TLRPC$TL_fileLocationToBeDeprecated;
import org.rbmain.tgnet.TLRPC$TL_inputPeerChannel;
import org.rbmain.tgnet.TLRPC$TL_inputPeerChat;
import org.rbmain.tgnet.TLRPC$TL_inputPeerUser;
import org.rbmain.tgnet.TLRPC$TL_messages_dialogs;
import org.rbmain.tgnet.TLRPC$TL_peerChannel;
import org.rbmain.tgnet.TLRPC$TL_peerNotifySettings;
import org.rbmain.tgnet.TLRPC$TL_peerUser;
import org.rbmain.tgnet.TLRPC$TL_statsAbsValueAndPrev;
import org.rbmain.tgnet.TLRPC$TL_statsDateRangeDays;
import org.rbmain.tgnet.TLRPC$TL_statsGraph;
import org.rbmain.tgnet.TLRPC$TL_statsGraphAsync;
import org.rbmain.tgnet.TLRPC$TL_statsGraphError;
import org.rbmain.tgnet.TLRPC$TL_statsPercentValue;
import org.rbmain.tgnet.TLRPC$TL_stats_broadcastStats;
import org.rbmain.tgnet.TLRPC$TL_user;
import org.rbmain.tgnet.TLRPC$TL_userProfilePhoto;
import org.rbmain.tgnet.TLRPC$User;
import org.rbmain.tgnet.TLRPC$UserProfilePhoto;
import org.rbmain.tgnet.TLRPC$messages_Dialogs;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Cells.DialogCell;
import org.rbmain.ui.Components.ShareAlert;

/* loaded from: classes.dex */
public class ChatConverter {
    public static TLRPC$messages_Dialogs convertAllChats(CoreMainClass coreMainClass, ArrayList<Chat> arrayList) {
        TLRPC$TL_messages_dialogs tLRPC$TL_messages_dialogs = new TLRPC$TL_messages_dialogs();
        tLRPC$TL_messages_dialogs.count = arrayList.size();
        ArrayList<TLRPC$Chat> arrayList2 = new ArrayList<>();
        ArrayList<TLRPC$User> arrayList3 = new ArrayList<>();
        ArrayList<TLRPC$Message> arrayList4 = new ArrayList<>();
        tLRPC$TL_messages_dialogs.dialogs = new ArrayList<>();
        Iterator<Chat> it = arrayList.iterator();
        while (it.hasNext()) {
            TLRPC$Dialog tLRPC$DialogConvertChat = convertChat(coreMainClass, it.next(), arrayList2, arrayList3, arrayList4);
            if (tLRPC$DialogConvertChat != null) {
                tLRPC$TL_messages_dialogs.dialogKeys.add(Long.valueOf(tLRPC$DialogConvertChat.id));
                tLRPC$TL_messages_dialogs.dialogs.add(tLRPC$DialogConvertChat);
            }
        }
        tLRPC$TL_messages_dialogs.chats = arrayList2;
        tLRPC$TL_messages_dialogs.users = arrayList3;
        tLRPC$TL_messages_dialogs.messages = arrayList4;
        return tLRPC$TL_messages_dialogs;
    }

    public static TLRPC$Dialog convertChat(CoreMainClass coreMainClass, Chat chat, ArrayList<TLRPC$Chat> arrayList, ArrayList<TLRPC$User> arrayList2, ArrayList<TLRPC$Message> arrayList3) {
        ChatAbsObject chatAbsObject;
        TLRPC$Peer tLRPC$TL_peerUser = null;
        if (chat == null) {
            return null;
        }
        TLRPC$TL_dialog tLRPC$TL_dialog = new TLRPC$TL_dialog();
        tLRPC$TL_dialog.folder_id = 0;
        tLRPC$TL_dialog.pinned = chat.is_pinned;
        tLRPC$TL_dialog.last_message_date = (int) chat.lastMessageTime;
        tLRPC$TL_dialog.top_message = chat.lastMessageId;
        tLRPC$TL_dialog.top_message_server = chat.last_message_id;
        ChatExtra chatExtra = chat.chatExtra;
        if (chatExtra == null || chatExtra.local_last_seen_my_mid <= chat.last_seen_my_mid) {
            tLRPC$TL_dialog.unread_count = chat.count_unseen;
        } else {
            tLRPC$TL_dialog.unread_count = Math.min(chat.count_unseen, chatExtra.local_count_unseen);
        }
        tLRPC$TL_dialog.read_inbox_max_id = chat.lastSeenMyMid;
        tLRPC$TL_dialog.read_outbox_max_id = chat.last_seen_peer_mid;
        TLRPC$TL_peerNotifySettings tLRPC$TL_peerNotifySettings = new TLRPC$TL_peerNotifySettings();
        tLRPC$TL_dialog.notify_settings = tLRPC$TL_peerNotifySettings;
        tLRPC$TL_peerNotifySettings.flags |= 4;
        ArrayList<Long> arrayList4 = chat.pinned_message_ids;
        if (arrayList4 != null && arrayList4.size() > 0) {
            tLRPC$TL_dialog.pinnedNum = chat.pinned_message_ids.size();
        }
        ChatAbsObject absInstant = coreMainClass.getAbsInstant(chat.object_guid);
        if (absInstant == null) {
            return null;
        }
        ChatType chatType = absInstant.type;
        ChatType chatType2 = ChatType.User;
        if (chatType == chatType2 || chatType == ChatType.Bot) {
            long jGenerateDialogId = IdStorage.getInstance().generateDialogId(chat.object_guid);
            tLRPC$TL_dialog.id = jGenerateDialogId;
            if (arrayList2 != null) {
                if (absInstant.type == chatType2) {
                    arrayList2.add(convertUser(coreMainClass, jGenerateDialogId, absInstant, (UserInfo) null, chat));
                } else {
                    arrayList2.add(convertBot(coreMainClass, jGenerateDialogId, absInstant, null, chat));
                }
            }
        } else if (chatType == ChatType.Channel || chatType == ChatType.Group) {
            long jGenerateNegativeDialogId = IdStorage.getInstance().generateNegativeDialogId(chat.object_guid);
            tLRPC$TL_dialog.id = jGenerateNegativeDialogId;
            tLRPC$TL_dialog.flags |= 1;
            if (arrayList != null) {
                arrayList.add(convertChannelGroup(coreMainClass, jGenerateNegativeDialogId, absInstant, chat));
            }
        } else if (chatType == ChatType.Service) {
            long jGenerateDialogId2 = IdStorage.getInstance().generateDialogId(chat.object_guid);
            tLRPC$TL_dialog.id = jGenerateDialogId2;
            if (arrayList != null) {
                arrayList2.add(convertService(coreMainClass, jGenerateDialogId2, absInstant, null, chat));
            }
        }
        ChatMessage chatMessage = chat.lastMessage;
        if (chatMessage == null || arrayList3 == null) {
            chatAbsObject = absInstant;
        } else {
            chatAbsObject = absInstant;
            arrayList3.add(MessageConverter.convertMessage(tLRPC$TL_dialog.id, chatMessage, chat.lastMessageTime, chat.isLastMessageLocal ? chat.chatExtra.local_last_message_send_state : -1, chatMessage.message_id > chat.last_seen_peer_mid));
        }
        if (chat.is_mute) {
            tLRPC$TL_dialog.notify_settings.mute_until = ConnectionsManager.DEFAULT_DATACENTER_ID;
        }
        ChatType chatType3 = chatAbsObject.type;
        if (chatType3 == chatType2 || chatType3 == ChatType.Bot || chatType3 == ChatType.Service) {
            tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
            tLRPC$TL_peerUser.user_id = (int) tLRPC$TL_dialog.id;
        } else if (chatType3 == ChatType.Channel || chatType3 == ChatType.Group) {
            tLRPC$TL_peerUser = new TLRPC$TL_peerChannel();
            tLRPC$TL_peerUser.channel_id = (int) (tLRPC$TL_dialog.id * (-1));
        }
        tLRPC$TL_dialog.peer = tLRPC$TL_peerUser;
        return tLRPC$TL_dialog;
    }

    public static TLRPC$User convertService(CoreMainClass coreMainClass, long j, ChatAbsObject chatAbsObject, ServiceInfo serviceInfo, Chat chat) {
        ObjectInfo objectInfo;
        if (chatAbsObject == null) {
            return null;
        }
        TLRPC$TL_user tLRPC$TL_user = new TLRPC$TL_user();
        tLRPC$TL_user.id = (int) j;
        tLRPC$TL_user.deleted = chatAbsObject.is_deleted;
        String str = chatAbsObject.title;
        if (str != null) {
            tLRPC$TL_user.first_name = str;
            tLRPC$TL_user.last_name = BuildConfig.FLAVOR;
        } else {
            tLRPC$TL_user.first_name = chatAbsObject.first_name;
            tLRPC$TL_user.last_name = chatAbsObject.last_name;
        }
        tLRPC$TL_user.support = true;
        tLRPC$TL_user.verified = chatAbsObject.is_verified;
        if (chatAbsObject.avatar_thumbnail != null) {
            tLRPC$TL_user.access_hash = IdStorage.getInstance().generateAccessHash(chatAbsObject.avatar_thumbnail.access_hash_rec);
            tLRPC$TL_user.photo = getUserProfilePhoto(chatAbsObject.avatar_thumbnail);
        }
        if (serviceInfo == null) {
            objectInfo = coreMainClass.getObjectInfoInstant(chatAbsObject.object_guid);
        } else {
            objectInfo = new ObjectInfo();
            objectInfo.serviceInfo = serviceInfo;
        }
        if (objectInfo != null) {
            ObjectInfoConverter.setObjectInfoUserOrBotOrService(coreMainClass, tLRPC$TL_user, objectInfo);
        }
        if (chat != null) {
            tLRPC$TL_user.mutual_contact = chat.is_in_contact;
        }
        return tLRPC$TL_user;
    }

    public static TLRPC$Chat convertChannelGroup(CoreMainClass coreMainClass, ChatAbsObject chatAbsObject, Chat chat) {
        long jGenerateNegativeDialogId;
        if (chat != null) {
            jGenerateNegativeDialogId = IdStorage.getInstance().generateNegativeDialogId(chat.object_guid);
        } else {
            jGenerateNegativeDialogId = chatAbsObject != null ? IdStorage.getInstance().generateNegativeDialogId(chatAbsObject.object_guid) : 0L;
        }
        if (jGenerateNegativeDialogId == 0) {
            return null;
        }
        return convertChannelGroup(coreMainClass, jGenerateNegativeDialogId, chatAbsObject, chat);
    }

    public static TLRPC$Chat convertChannelGroup(CoreMainClass coreMainClass, InSearchObject inSearchObject) {
        return convertChannelGroup(coreMainClass, IdStorage.getInstance().generateNegativeDialogId(inSearchObject.object_guid), inSearchObject);
    }

    public static TLRPC$Chat convertChannelGroup(CoreMainClass coreMainClass, long j, ChatAbsObject chatAbsObject, Chat chat) {
        TLRPC$Chat tLRPC$TL_channel;
        Chat.ChatStatusEnum chatStatusEnum;
        if (chat == null || chat.status != Chat.ChatStatusEnum.NotExist) {
            if (chat != null && ((chatStatusEnum = chat.status) == Chat.ChatStatusEnum.NoAccess || chatStatusEnum == Chat.ChatStatusEnum.ObjRemoved)) {
                tLRPC$TL_channel = new TLRPC$TL_channelForbidden();
            } else {
                tLRPC$TL_channel = new TLRPC$TL_channel();
            }
        } else if (chatAbsObject != null && !chatAbsObject.is_deleted) {
            tLRPC$TL_channel = new TLRPC$TL_channel();
            tLRPC$TL_channel.left = true;
        } else {
            tLRPC$TL_channel = new TLRPC$TL_channel();
            tLRPC$TL_channel.deactivated = true;
        }
        if (chatAbsObject != null && chatAbsObject.type == ChatType.Channel) {
            tLRPC$TL_channel.flags |= 1;
        } else {
            tLRPC$TL_channel.megagroup = true;
        }
        tLRPC$TL_channel.id = (int) ((-1) * j);
        tLRPC$TL_channel.verified = chatAbsObject != null && chatAbsObject.is_verified;
        if (chat != null) {
            tLRPC$TL_channel.date = (int) (chat.time / 1000);
            tLRPC$TL_channel.slowmode_enabled = chat.slow_mode_duration != 0;
            String str = chat.group_voice_chat_id;
            tLRPC$TL_channel.call_active = (str == null || str.isEmpty() || chat.status != Chat.ChatStatusEnum.Active) ? false : true;
            String str2 = chat.group_voice_chat_id;
            tLRPC$TL_channel.call_not_empty = (str2 == null || str2.isEmpty()) ? false : true;
            tLRPC$TL_channel.askSpamAction = chat.show_ask_spam;
            setAccesses(coreMainClass, tLRPC$TL_channel, chat, chatAbsObject != null && chatAbsObject.type == ChatType.Channel);
        }
        setAbsInfoForChannelGroup(tLRPC$TL_channel, chatAbsObject);
        ObjectInfoConverter.setObjectInfoChat(tLRPC$TL_channel, coreMainClass.getObjectInfoInstant(IdStorage.getInstance().getDialogId(j)), chatAbsObject != null && chatAbsObject.type == ChatType.Channel);
        return tLRPC$TL_channel;
    }

    private static TLRPC$Chat convertChannelGroup(CoreMainClass coreMainClass, long j, InSearchObject inSearchObject) {
        TLRPC$TL_channel tLRPC$TL_channel = new TLRPC$TL_channel();
        ChatType chatType = inSearchObject.type;
        ChatType chatType2 = ChatType.Channel;
        if (chatType == chatType2) {
            tLRPC$TL_channel.flags |= 1;
        } else {
            tLRPC$TL_channel.megagroup = true;
        }
        tLRPC$TL_channel.id = (int) (j * (-1));
        tLRPC$TL_channel.verified = inSearchObject.is_verified;
        setAbsInfoForChannelGroup(tLRPC$TL_channel, inSearchObject);
        ObjectInfoConverter.setObjectInfoChat(tLRPC$TL_channel, coreMainClass.getObjectInfoInstant(inSearchObject.object_guid), inSearchObject.type == chatType2);
        return tLRPC$TL_channel;
    }

    public static void setAbsInfoForChannelGroup(TLRPC$Chat tLRPC$Chat, ChatAbsObject chatAbsObject) {
        if (tLRPC$Chat == null) {
            tLRPC$Chat = new TLRPC$TL_channel();
        }
        if (tLRPC$Chat.id == 0 && chatAbsObject.object_guid != null) {
            tLRPC$Chat.id = ((int) IdStorage.getInstance().generateNegativeDialogId(chatAbsObject.object_guid)) * (-1);
        }
        tLRPC$Chat.title = chatAbsObject.title;
        tLRPC$Chat.megagroup = chatAbsObject.type == ChatType.Group;
        tLRPC$Chat.photo = getChatPhoto(chatAbsObject.avatar_thumbnail);
        if (chatAbsObject.avatar_thumbnail != null) {
            tLRPC$Chat.access_hash = IdStorage.getInstance().generateAccessHash(chatAbsObject.avatar_thumbnail.access_hash_rec);
        }
    }

    public static void setAbsInfoForChannelGroup(TLRPC$Chat tLRPC$Chat, InSearchObject inSearchObject) {
        if (tLRPC$Chat.id == 0 && inSearchObject.object_guid != null) {
            tLRPC$Chat.id = ((int) IdStorage.getInstance().generateNegativeDialogId(inSearchObject.object_guid)) * (-1);
        }
        tLRPC$Chat.title = inSearchObject.title;
        if (inSearchObject.avatar_thumbnail != null) {
            tLRPC$Chat.access_hash = IdStorage.getInstance().generateAccessHash(inSearchObject.avatar_thumbnail.access_hash_rec);
        }
        tLRPC$Chat.megagroup = inSearchObject.type == ChatType.Group;
        tLRPC$Chat.verified = inSearchObject.is_verified;
        tLRPC$Chat.photo = getChatPhoto(inSearchObject.avatar_thumbnail);
    }

    public static TLRPC$FileLocation getProfilePhotoLocation(long j, boolean z) {
        TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated = new TLRPC$TL_fileLocationToBeDeprecated();
        tLRPC$TL_fileLocationToBeDeprecated.local_id = z ? 2 : 3;
        tLRPC$TL_fileLocationToBeDeprecated.volume_id = j;
        return tLRPC$TL_fileLocationToBeDeprecated;
    }

    private static void setAccesses(CoreMainClass coreMainClass, TLRPC$Chat tLRPC$Chat, Chat chat, boolean z) {
        tLRPC$Chat.broadcast = z;
        tLRPC$Chat.default_banned_rights = setBannedRights(coreMainClass, chat);
        tLRPC$Chat.admin_rights = setAdminRights(coreMainClass, chat);
        tLRPC$Chat.accessEnumHashSet = chat.access;
    }

    private static TLRPC$TL_chatBannedRights setBannedRights(CoreMainClass coreMainClass, Chat chat) {
        if (chat == null || chat.access == null) {
            return null;
        }
        TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights = new TLRPC$TL_chatBannedRights();
        tLRPC$TL_chatBannedRights.change_info = !chat.access.contains(Chat.ChatAccessEnum.ChangeInfo);
        tLRPC$TL_chatBannedRights.pin_messages = !chat.access.contains(Chat.ChatAccessEnum.PinMessages);
        HashSet<Chat.ChatAccessEnum> hashSet = chat.access;
        Chat.ChatAccessEnum chatAccessEnum = Chat.ChatAccessEnum.SendMessages;
        tLRPC$TL_chatBannedRights.send_messages = !hashSet.contains(chatAccessEnum);
        tLRPC$TL_chatBannedRights.send_polls = !chat.access.contains(chatAccessEnum);
        tLRPC$TL_chatBannedRights.send_stickers = !chat.access.contains(chatAccessEnum);
        tLRPC$TL_chatBannedRights.send_media = !chat.access.contains(chatAccessEnum);
        tLRPC$TL_chatBannedRights.send_games = !chat.access.contains(chatAccessEnum);
        tLRPC$TL_chatBannedRights.send_gifs = !chat.access.contains(chatAccessEnum);
        tLRPC$TL_chatBannedRights.send_inline = !chat.access.contains(chatAccessEnum);
        tLRPC$TL_chatBannedRights.invite_users = !chat.access.contains(Chat.ChatAccessEnum.AddMember);
        tLRPC$TL_chatBannedRights.until_date = ConnectionsManager.DEFAULT_DATACENTER_ID;
        return tLRPC$TL_chatBannedRights;
    }

    public static ArrayList<Chat.EnumSetGroupAdminAccess> getGroupAdminAccesses(TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights) {
        ArrayList<Chat.EnumSetGroupAdminAccess> arrayList = new ArrayList<>();
        if (tLRPC$TL_chatAdminRights.change_info) {
            arrayList.add(Chat.EnumSetGroupAdminAccess.ChangeInfo);
        }
        if (tLRPC$TL_chatAdminRights.pin_messages) {
            arrayList.add(Chat.EnumSetGroupAdminAccess.PinMessages);
        }
        if (tLRPC$TL_chatAdminRights.delete_messages) {
            arrayList.add(Chat.EnumSetGroupAdminAccess.DeleteGlobalAllMessages);
        }
        if (tLRPC$TL_chatAdminRights.ban_users) {
            arrayList.add(Chat.EnumSetGroupAdminAccess.BanMember);
        }
        if (tLRPC$TL_chatAdminRights.add_admins) {
            arrayList.add(Chat.EnumSetGroupAdminAccess.SetAdmin);
        }
        if (tLRPC$TL_chatAdminRights.invite_users) {
            arrayList.add(Chat.EnumSetGroupAdminAccess.SetJoinLink);
        }
        if (tLRPC$TL_chatAdminRights.change_access) {
            arrayList.add(Chat.EnumSetGroupAdminAccess.SetMemberAccess);
        }
        return arrayList;
    }

    public static ArrayList<Chat.EnumSetChannelAdminAccess> getChannelAdminAccesses(TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights) {
        ArrayList<Chat.EnumSetChannelAdminAccess> arrayList = new ArrayList<>();
        if (tLRPC$TL_chatAdminRights.change_info) {
            arrayList.add(Chat.EnumSetChannelAdminAccess.ChangeInfo);
            arrayList.add(Chat.EnumSetChannelAdminAccess.SetJoinLink);
        }
        if (tLRPC$TL_chatAdminRights.view_members) {
            arrayList.add(Chat.EnumSetChannelAdminAccess.ViewMembers);
        }
        if (tLRPC$TL_chatAdminRights.view_admins) {
            arrayList.add(Chat.EnumSetChannelAdminAccess.ViewAdmins);
        }
        if (tLRPC$TL_chatAdminRights.pin_messages) {
            arrayList.add(Chat.EnumSetChannelAdminAccess.PinMessages);
        }
        if (tLRPC$TL_chatAdminRights.post_messages) {
            arrayList.add(Chat.EnumSetChannelAdminAccess.SendMessages);
        }
        if (tLRPC$TL_chatAdminRights.edit_messages) {
            arrayList.add(Chat.EnumSetChannelAdminAccess.EditAllMessages);
        }
        if (tLRPC$TL_chatAdminRights.delete_messages) {
            arrayList.add(Chat.EnumSetChannelAdminAccess.DeleteGlobalAllMessages);
        }
        if (tLRPC$TL_chatAdminRights.add_users) {
            arrayList.add(Chat.EnumSetChannelAdminAccess.AddMember);
        }
        if (tLRPC$TL_chatAdminRights.invite_users) {
            arrayList.add(Chat.EnumSetChannelAdminAccess.SetJoinLink);
        }
        if (tLRPC$TL_chatAdminRights.add_admins) {
            arrayList.add(Chat.EnumSetChannelAdminAccess.SetAdmin);
        }
        return arrayList;
    }

    public static TLRPC$TL_chatAdminRights setAdminRights(CoreMainClass coreMainClass, Chat chat) {
        if (chat == null || chat.access == null || !coreMainClass.hasAccessToViewSettingPage(chat.object_guid)) {
            return null;
        }
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights = new TLRPC$TL_chatAdminRights();
        tLRPC$TL_chatAdminRights.change_info = chat.access.contains(Chat.ChatAccessEnum.ChangeInfo);
        tLRPC$TL_chatAdminRights.post_messages = chat.access.contains(Chat.ChatAccessEnum.SendMessages);
        tLRPC$TL_chatAdminRights.edit_messages = chat.access.contains(Chat.ChatAccessEnum.EditAllMessages);
        tLRPC$TL_chatAdminRights.invite_users = chat.access.contains(Chat.ChatAccessEnum.SetJoinLink);
        tLRPC$TL_chatAdminRights.add_users = chat.access.contains(Chat.ChatAccessEnum.AddMember);
        tLRPC$TL_chatAdminRights.ban_users = chat.access.contains(Chat.ChatAccessEnum.BanMember);
        tLRPC$TL_chatAdminRights.pin_messages = chat.access.contains(Chat.ChatAccessEnum.PinMessages);
        tLRPC$TL_chatAdminRights.add_admins = chat.access.contains(Chat.ChatAccessEnum.SetAdmin);
        tLRPC$TL_chatAdminRights.delete_messages = chat.access.contains(Chat.ChatAccessEnum.DeleteGlobalAllMessages);
        tLRPC$TL_chatAdminRights.change_access = chat.access.contains(Chat.ChatAccessEnum.SetMemberAccess);
        tLRPC$TL_chatAdminRights.view_members = chat.access.contains(Chat.ChatAccessEnum.ViewMembers);
        tLRPC$TL_chatAdminRights.view_admins = chat.access.contains(Chat.ChatAccessEnum.ViewAdmins);
        tLRPC$TL_chatAdminRights.setFlags();
        return tLRPC$TL_chatAdminRights;
    }

    public static TLRPC$TL_chatAdminRights setAdminRights(Set<Chat.EnumSetGroupAdminAccess> set) {
        if (set == null) {
            return null;
        }
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights = new TLRPC$TL_chatAdminRights();
        tLRPC$TL_chatAdminRights.change_info = set.contains(Chat.EnumSetGroupAdminAccess.ChangeInfo);
        tLRPC$TL_chatAdminRights.pin_messages = set.contains(Chat.EnumSetGroupAdminAccess.PinMessages);
        tLRPC$TL_chatAdminRights.delete_messages = set.contains(Chat.EnumSetGroupAdminAccess.DeleteGlobalAllMessages);
        tLRPC$TL_chatAdminRights.ban_users = set.contains(Chat.EnumSetGroupAdminAccess.BanMember);
        tLRPC$TL_chatAdminRights.add_admins = set.contains(Chat.EnumSetGroupAdminAccess.SetAdmin);
        tLRPC$TL_chatAdminRights.change_access = set.contains(Chat.EnumSetGroupAdminAccess.SetMemberAccess);
        tLRPC$TL_chatAdminRights.invite_users = set.contains(Chat.EnumSetGroupAdminAccess.SetJoinLink);
        tLRPC$TL_chatAdminRights.setFlags();
        return tLRPC$TL_chatAdminRights;
    }

    public static TLRPC$TL_chatAdminRights setChannelAdminRights(Set<Chat.EnumSetChannelAdminAccess> set) {
        if (set == null) {
            return null;
        }
        TLRPC$TL_chatAdminRights tLRPC$TL_chatAdminRights = new TLRPC$TL_chatAdminRights();
        tLRPC$TL_chatAdminRights.change_info = set.contains(Chat.EnumSetChannelAdminAccess.ChangeInfo);
        tLRPC$TL_chatAdminRights.view_members = set.contains(Chat.EnumSetChannelAdminAccess.ViewMembers);
        tLRPC$TL_chatAdminRights.view_admins = set.contains(Chat.EnumSetChannelAdminAccess.ViewAdmins);
        tLRPC$TL_chatAdminRights.pin_messages = set.contains(Chat.EnumSetChannelAdminAccess.PinMessages);
        tLRPC$TL_chatAdminRights.post_messages = set.contains(Chat.EnumSetChannelAdminAccess.SendMessages);
        tLRPC$TL_chatAdminRights.edit_messages = set.contains(Chat.EnumSetChannelAdminAccess.EditAllMessages);
        tLRPC$TL_chatAdminRights.delete_messages = set.contains(Chat.EnumSetChannelAdminAccess.DeleteGlobalAllMessages);
        tLRPC$TL_chatAdminRights.invite_users = set.contains(Chat.EnumSetChannelAdminAccess.SetJoinLink);
        tLRPC$TL_chatAdminRights.add_users = set.contains(Chat.EnumSetChannelAdminAccess.AddMember);
        tLRPC$TL_chatAdminRights.add_admins = set.contains(Chat.EnumSetChannelAdminAccess.SetAdmin);
        tLRPC$TL_chatAdminRights.setFlags();
        return tLRPC$TL_chatAdminRights;
    }

    public static TLRPC$User convertUser(CoreMainClass coreMainClass, long j, ChatAbsObject chatAbsObject, UserInfo userInfo, Chat chat) {
        ObjectInfo objectInfo;
        if (chatAbsObject == null) {
            return null;
        }
        TLRPC$TL_user tLRPC$TL_user = new TLRPC$TL_user();
        tLRPC$TL_user.id = (int) j;
        tLRPC$TL_user.deleted = chatAbsObject.is_deleted;
        tLRPC$TL_user.first_name = chatAbsObject.first_name;
        tLRPC$TL_user.last_name = chatAbsObject.last_name;
        tLRPC$TL_user.verified = chatAbsObject.is_verified;
        ChatType chatType = chatAbsObject.type;
        ChatType chatType2 = ChatType.Service;
        if (chatType == chatType2 || chatType == ChatType.Bot) {
            tLRPC$TL_user.first_name = chatAbsObject.title;
        }
        tLRPC$TL_user.bot = chatType == ChatType.Bot;
        tLRPC$TL_user.support = chatType == chatType2;
        tLRPC$TL_user.self = chatAbsObject.object_guid.equals(coreMainClass.getMyGuid());
        tLRPC$TL_user.contact = coreMainClass.isContact(chatAbsObject.object_guid);
        if (chatAbsObject.avatar_thumbnail != null) {
            tLRPC$TL_user.access_hash = IdStorage.getInstance().generateAccessHash(chatAbsObject.avatar_thumbnail.access_hash_rec);
            tLRPC$TL_user.photo = getUserProfilePhoto(chatAbsObject.avatar_thumbnail);
        }
        if (userInfo == null) {
            objectInfo = coreMainClass.getObjectInfoInstant(chatAbsObject.object_guid);
        } else {
            objectInfo = new ObjectInfo();
            objectInfo.userInfo = userInfo;
        }
        if (objectInfo != null) {
            ObjectInfoConverter.setObjectInfoUserOrBotOrService(coreMainClass, tLRPC$TL_user, objectInfo);
        }
        if (chat != null) {
            tLRPC$TL_user.mutual_contact = chat.is_in_contact;
            tLRPC$TL_user.askSpamAction = chat.show_ask_spam;
        }
        return tLRPC$TL_user;
    }

    public static TLRPC$User convertBot(CoreMainClass coreMainClass, long j, ChatAbsObject chatAbsObject, BotInfo botInfo, Chat chat) {
        ObjectInfo objectInfo;
        if (chatAbsObject == null) {
            return null;
        }
        TLRPC$TL_user tLRPC$TL_user = new TLRPC$TL_user();
        tLRPC$TL_user.id = (int) j;
        tLRPC$TL_user.deleted = chatAbsObject.is_deleted;
        String str = chatAbsObject.title;
        if (str != null) {
            tLRPC$TL_user.first_name = str;
            tLRPC$TL_user.last_name = BuildConfig.FLAVOR;
        } else {
            tLRPC$TL_user.first_name = chatAbsObject.first_name;
            tLRPC$TL_user.last_name = chatAbsObject.last_name;
        }
        tLRPC$TL_user.verified = chatAbsObject.is_verified;
        tLRPC$TL_user.self = chatAbsObject.object_guid.equals(coreMainClass.getMyGuid());
        if (chatAbsObject.avatar_thumbnail != null) {
            tLRPC$TL_user.access_hash = IdStorage.getInstance().generateAccessHash(chatAbsObject.avatar_thumbnail.access_hash_rec);
            tLRPC$TL_user.photo = getUserProfilePhoto(chatAbsObject.avatar_thumbnail);
        }
        tLRPC$TL_user.bot = true;
        if (botInfo == null) {
            objectInfo = coreMainClass.getObjectInfoInstant(chatAbsObject.object_guid);
        } else {
            objectInfo = new ObjectInfo();
            objectInfo.botInfo = botInfo;
        }
        if (objectInfo != null) {
            ObjectInfoConverter.setObjectInfoUserOrBotOrService(coreMainClass, tLRPC$TL_user, objectInfo);
        }
        if (chat != null) {
            tLRPC$TL_user.mutual_contact = chat.is_in_contact;
        }
        return tLRPC$TL_user;
    }

    public static TLRPC$User convertUser(CoreMainClass coreMainClass, long j, InSearchObject inSearchObject, boolean z, boolean z2) {
        TLRPC$TL_user tLRPC$TL_user = new TLRPC$TL_user();
        tLRPC$TL_user.id = (int) j;
        tLRPC$TL_user.deleted = inSearchObject.is_deleted;
        tLRPC$TL_user.first_name = inSearchObject.first_name;
        tLRPC$TL_user.last_name = inSearchObject.last_name;
        tLRPC$TL_user.verified = inSearchObject.is_verified;
        if (z || z2) {
            tLRPC$TL_user.first_name = inSearchObject.title;
        }
        tLRPC$TL_user.self = inSearchObject.object_guid.equals(coreMainClass.getMyGuid());
        tLRPC$TL_user.bot = z;
        tLRPC$TL_user.support = z2;
        tLRPC$TL_user.contact = coreMainClass.isContact(inSearchObject.object_guid);
        if (inSearchObject.avatar_thumbnail != null) {
            tLRPC$TL_user.access_hash = IdStorage.getInstance().generateAccessHash(inSearchObject.avatar_thumbnail.access_hash_rec);
            tLRPC$TL_user.photo = getUserProfilePhoto(inSearchObject.avatar_thumbnail);
        }
        ObjectInfo objectInfoInstant = coreMainClass.getObjectInfoInstant(inSearchObject.object_guid);
        if (objectInfoInstant != null) {
            ObjectInfoConverter.setObjectInfoUserOrBotOrService(coreMainClass, tLRPC$TL_user, objectInfoInstant);
        } else {
            long j2 = inSearchObject.timeStamp;
            if (j2 < 0) {
                j2 = 0;
            }
            tLRPC$TL_user.userInfotimeStamp = j2;
        }
        return tLRPC$TL_user;
    }

    public static TLRPC$UserProfilePhoto getUserProfilePhoto(FileInlineObject fileInlineObject) {
        if (fileInlineObject == null) {
            return null;
        }
        TLRPC$TL_userProfilePhoto tLRPC$TL_userProfilePhoto = new TLRPC$TL_userProfilePhoto();
        tLRPC$TL_userProfilePhoto.photo_id = fileInlineObject.file_id;
        tLRPC$TL_userProfilePhoto.dc_id = IdStorage.getInstance().generateDcId(fileInlineObject.dc_id);
        tLRPC$TL_userProfilePhoto.photo_small = getProfilePhotoLocation(fileInlineObject.file_id, false);
        tLRPC$TL_userProfilePhoto.photo_big = getProfilePhotoLocation(fileInlineObject.file_id, true);
        return tLRPC$TL_userProfilePhoto;
    }

    public static TLRPC$TL_GetLiveCommentResult covertAllLiveComments(CoreMainClass coreMainClass, LiveModels.GetLiveCommentsOutput getLiveCommentsOutput) {
        TLRPC$TL_GetLiveCommentResult tLRPC$TL_GetLiveCommentResult = new TLRPC$TL_GetLiveCommentResult();
        if (getLiveCommentsOutput == null) {
            return tLRPC$TL_GetLiveCommentResult;
        }
        tLRPC$TL_GetLiveCommentResult.nextStartId = getLiveCommentsOutput.next_start_id;
        tLRPC$TL_GetLiveCommentResult.comments = new ArrayList<>();
        ArrayList<LiveModels.LiveCommentObjectFromServer> arrayList = getLiveCommentsOutput.live_comments;
        if (arrayList != null) {
            Iterator<LiveModels.LiveCommentObjectFromServer> it = arrayList.iterator();
            while (it.hasNext()) {
                tLRPC$TL_GetLiveCommentResult.comments.add(convertLiveCommentToTlObject(coreMainClass, it.next()));
            }
        }
        return tLRPC$TL_GetLiveCommentResult;
    }

    public static TLRPC$TL_LiveComment convertLiveCommentToTlObject(CoreMainClass coreMainClass, LiveModels.LiveCommentObjectFromServer liveCommentObjectFromServer) {
        TLRPC$TL_LiveComment tLRPC$TL_LiveComment = new TLRPC$TL_LiveComment();
        if (liveCommentObjectFromServer == null) {
            return tLRPC$TL_LiveComment;
        }
        tLRPC$TL_LiveComment.commentId = liveCommentObjectFromServer.comment_id;
        tLRPC$TL_LiveComment.text = liveCommentObjectFromServer.text;
        ChatAbsObject chatAbsObject = liveCommentObjectFromServer.comment_user_info;
        if (chatAbsObject != null) {
            String str = chatAbsObject.object_guid;
            tLRPC$TL_LiveComment.user = convertUser(coreMainClass, IdStorage.getInstance().generateDialogId(liveCommentObjectFromServer.comment_user_info.object_guid), liveCommentObjectFromServer.comment_user_info, (UserInfo) null, (Chat) null);
            tLRPC$TL_LiveComment.absObject = liveCommentObjectFromServer.comment_user_info;
        }
        return tLRPC$TL_LiveComment;
    }

    public static ArrayList<MessagesController.DialogFilter> covertAllFolders(int i, ArrayList<FolderObject> arrayList) {
        ArrayList<MessagesController.DialogFilter> arrayList2 = new ArrayList<>();
        Iterator<FolderObject> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(convertFolder(i, it.next()));
        }
        return arrayList2;
    }

    public static MessagesController.DialogFilter convertFolder(int i, FolderObject folderObject) {
        MessagesController.DialogFilter dialogFilter = new MessagesController.DialogFilter();
        dialogFilter.id = IdStorage.getInstance().generateFolderId(folderObject.folder_id);
        dialogFilter.name = folderObject.name;
        dialogFilter.order = folderObject.order;
        String str = folderObject.suggestion_folder_id;
        dialogFilter.suggestedFolderId = str;
        dialogFilter.isSuggested = (str == null || str.isEmpty()) ? false : true;
        fillFolderArrays(dialogFilter.alwaysShow, folderObject.include_objects);
        fillFolderArrays(dialogFilter.neverShow, folderObject.exclude_objects);
        fillFolderArrays(dialogFilter.pinnedDialogs, folderObject.pinned_objects);
        dialogFilter.flags = folderObject.flags;
        dialogFilter.unreadCount = AccountInstance.getInstance(i).getCoreMainClass().getFolderUnreadCount(folderObject.folder_id);
        return dialogFilter;
    }

    private static TLRPC$TL_dialogFilter convertFolderToFilter(FolderObject folderObject, String str) {
        ArrayList<ObjectGuidType> arrayList;
        ArrayList<TLRPC$InputPeer> arrayList2;
        TLRPC$TL_dialogFilter tLRPC$TL_dialogFilter = new TLRPC$TL_dialogFilter();
        int i = folderObject.flags;
        tLRPC$TL_dialogFilter.id = IdStorage.getInstance().generateFolderId(folderObject.folder_id);
        String str2 = folderObject.suggestion_folder_id;
        tLRPC$TL_dialogFilter.suggested_folder_id = str2 != null ? str2 : str;
        tLRPC$TL_dialogFilter.is_suggested = ((str2 == null || str2.isEmpty()) && (str == null || str.isEmpty())) ? false : true;
        tLRPC$TL_dialogFilter.contacts = (MessagesController.DIALOG_FILTER_FLAG_CONTACTS & i) != 0;
        tLRPC$TL_dialogFilter.non_contacts = (MessagesController.DIALOG_FILTER_FLAG_NON_CONTACTS & i) != 0;
        tLRPC$TL_dialogFilter.groups = (MessagesController.DIALOG_FILTER_FLAG_GROUPS & i) != 0;
        tLRPC$TL_dialogFilter.broadcasts = (MessagesController.DIALOG_FILTER_FLAG_CHANNELS & i) != 0;
        tLRPC$TL_dialogFilter.bots = (MessagesController.DIALOG_FILTER_FLAG_BOTS & i) != 0;
        tLRPC$TL_dialogFilter.exclude_muted = (MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_MUTED & i) != 0;
        tLRPC$TL_dialogFilter.exclude_read = (MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_READ & i) != 0;
        tLRPC$TL_dialogFilter.exclude_archived = (MessagesController.DIALOG_FILTER_FLAG_EXCLUDE_ARCHIVED & i) != 0;
        tLRPC$TL_dialogFilter.title = folderObject.name;
        tLRPC$TL_dialogFilter.flags = i;
        for (int i2 = 0; i2 < 2; i2++) {
            if (i2 == 0) {
                arrayList = folderObject.include_objects;
                arrayList2 = tLRPC$TL_dialogFilter.include_peers;
            } else {
                arrayList = folderObject.exclude_objects;
                arrayList2 = tLRPC$TL_dialogFilter.exclude_peers;
            }
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ObjectGuidType objectGuidType = arrayList.get(i3);
                ChatType chatType = objectGuidType.type;
                if (chatType == ChatType.User || chatType == ChatType.Bot || chatType == ChatType.Service) {
                    int iGenerateDialogId = (int) IdStorage.getInstance().generateDialogId(objectGuidType.object_guid);
                    TLRPC$TL_inputPeerUser tLRPC$TL_inputPeerUser = new TLRPC$TL_inputPeerUser();
                    tLRPC$TL_inputPeerUser.user_id = iGenerateDialogId;
                    arrayList2.add(tLRPC$TL_inputPeerUser);
                } else if (chatType == ChatType.Group || chatType == ChatType.Channel) {
                    int iGenerateNegativeDialogId = (int) IdStorage.getInstance().generateNegativeDialogId(objectGuidType.object_guid);
                    TLRPC$TL_inputPeerChannel tLRPC$TL_inputPeerChannel = new TLRPC$TL_inputPeerChannel();
                    tLRPC$TL_inputPeerChannel.channel_id = -iGenerateNegativeDialogId;
                    arrayList2.add(tLRPC$TL_inputPeerChannel);
                }
            }
        }
        return tLRPC$TL_dialogFilter;
    }

    private static void fillFolderArrays(ArrayList<Integer> arrayList, ArrayList<ObjectGuidType> arrayList2) {
        Iterator<ObjectGuidType> it = arrayList2.iterator();
        while (it.hasNext()) {
            ObjectGuidType next = it.next();
            ChatType chatType = next.type;
            if (chatType == ChatType.User || chatType == ChatType.Bot || chatType == ChatType.Service) {
                arrayList.add(Integer.valueOf((int) IdStorage.getInstance().generateDialogId(next.object_guid)));
            } else {
                arrayList.add(Integer.valueOf((int) IdStorage.getInstance().generateNegativeDialogId(next.object_guid)));
            }
        }
    }

    private static void fillFolderArrays(LongSparseArray<Integer> longSparseArray, ArrayList<ObjectGuidType> arrayList) {
        Iterator<ObjectGuidType> it = arrayList.iterator();
        while (it.hasNext()) {
            ObjectGuidType next = it.next();
            ChatType chatType = next.type;
            if (chatType == ChatType.User || chatType == ChatType.Bot || chatType == ChatType.Service) {
                longSparseArray.put(IdStorage.getInstance().generateDialogId(next.object_guid), 1);
            } else {
                longSparseArray.put(IdStorage.getInstance().generateNegativeDialogId(next.object_guid), 1);
            }
        }
    }

    public static ArrayList<ObjectGuidType> getObjectGuidsFrom(int i, ArrayList<TLRPC$InputPeer> arrayList) {
        long j;
        int i2;
        int i3;
        String dialogId;
        ChatAbsObject absInstant;
        ArrayList<ObjectGuidType> arrayList2 = new ArrayList<>();
        Iterator<TLRPC$InputPeer> it = arrayList.iterator();
        while (it.hasNext()) {
            TLRPC$InputPeer next = it.next();
            if (next instanceof TLRPC$TL_inputPeerUser) {
                i3 = next.user_id;
            } else {
                if (next instanceof TLRPC$TL_inputPeerChat) {
                    i2 = next.chat_id;
                } else if (next instanceof TLRPC$TL_inputPeerChannel) {
                    i2 = next.channel_id;
                } else {
                    j = 0;
                    if (j == 0 && (absInstant = AccountInstance.getInstance(i).getCoreMainClass().getAbsInstant((dialogId = IdStorage.getInstance().getDialogId(j)))) != null) {
                        arrayList2.add(new ObjectGuidType(dialogId, absInstant.type));
                    }
                }
                i3 = -i2;
            }
            j = i3;
            if (j == 0) {
            }
        }
        return arrayList2;
    }

    public static ArrayList<TLRPC$TL_dialogFilterSuggested> convertAllSuggestedFilters(ArrayList<DialogFilterSuggested> arrayList) {
        ArrayList<TLRPC$TL_dialogFilterSuggested> arrayList2 = new ArrayList<>();
        Iterator<DialogFilterSuggested> it = arrayList.iterator();
        while (it.hasNext()) {
            DialogFilterSuggested next = it.next();
            TLRPC$TL_dialogFilterSuggested tLRPC$TL_dialogFilterSuggested = new TLRPC$TL_dialogFilterSuggested();
            String str = next.suggestion_folder_id;
            tLRPC$TL_dialogFilterSuggested.suggested_folder_id = str;
            tLRPC$TL_dialogFilterSuggested.description = next.description;
            tLRPC$TL_dialogFilterSuggested.filter = convertFolderToFilter(next.folder, str);
            arrayList2.add(tLRPC$TL_dialogFilterSuggested);
        }
        return arrayList2;
    }

    public static TLRPC$TL_chatBannedRights setDefaultAccessList(Set<Chat.EnumSetGroupMemberAccess> set) {
        TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights = new TLRPC$TL_chatBannedRights();
        Chat.EnumSetGroupMemberAccess enumSetGroupMemberAccess = Chat.EnumSetGroupMemberAccess.SendMessages;
        tLRPC$TL_chatBannedRights.send_messages = !set.contains(enumSetGroupMemberAccess);
        tLRPC$TL_chatBannedRights.send_inline = !set.contains(enumSetGroupMemberAccess);
        tLRPC$TL_chatBannedRights.send_gifs = !set.contains(enumSetGroupMemberAccess);
        tLRPC$TL_chatBannedRights.send_games = !set.contains(enumSetGroupMemberAccess);
        tLRPC$TL_chatBannedRights.send_media = !set.contains(enumSetGroupMemberAccess);
        tLRPC$TL_chatBannedRights.send_stickers = !set.contains(enumSetGroupMemberAccess);
        tLRPC$TL_chatBannedRights.send_polls = !set.contains(enumSetGroupMemberAccess);
        tLRPC$TL_chatBannedRights.view_members = !set.contains(Chat.EnumSetGroupMemberAccess.ViewMembers);
        tLRPC$TL_chatBannedRights.view_admins = !set.contains(Chat.EnumSetGroupMemberAccess.ViewAdmins);
        tLRPC$TL_chatBannedRights.invite_users = !set.contains(Chat.EnumSetGroupMemberAccess.AddMember);
        return tLRPC$TL_chatBannedRights;
    }

    public static ArrayList<Chat.EnumSetGroupMemberAccess> getDefaultAccessList(TLRPC$TL_chatBannedRights tLRPC$TL_chatBannedRights) {
        ArrayList<Chat.EnumSetGroupMemberAccess> arrayList = new ArrayList<>();
        if (!tLRPC$TL_chatBannedRights.view_members) {
            arrayList.add(Chat.EnumSetGroupMemberAccess.ViewMembers);
        }
        if (!tLRPC$TL_chatBannedRights.view_admins) {
            arrayList.add(Chat.EnumSetGroupMemberAccess.ViewAdmins);
        }
        if (!tLRPC$TL_chatBannedRights.send_messages) {
            arrayList.add(Chat.EnumSetGroupMemberAccess.SendMessages);
        }
        if (!tLRPC$TL_chatBannedRights.invite_users) {
            arrayList.add(Chat.EnumSetGroupMemberAccess.AddMember);
        }
        return arrayList;
    }

    public static TLRPC$TL_contacts_found convertAllInSearchObjects(CoreMainClass coreMainClass, ArrayList<InSearchObject> arrayList) {
        TLRPC$TL_contacts_found tLRPC$TL_contacts_found = new TLRPC$TL_contacts_found();
        ArrayList<TLRPC$Chat> arrayList2 = new ArrayList<>();
        ArrayList<TLRPC$User> arrayList3 = new ArrayList<>();
        ArrayList<TLRPC$Peer> arrayList4 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<InSearchObject> it = arrayList.iterator();
            while (it.hasNext()) {
                convertInSearchObject(coreMainClass, it.next(), arrayList2, arrayList3, arrayList4, null, null, null);
            }
        }
        tLRPC$TL_contacts_found.chats = arrayList2;
        tLRPC$TL_contacts_found.users = arrayList3;
        tLRPC$TL_contacts_found.results = arrayList4;
        return tLRPC$TL_contacts_found;
    }

    public static void convertAllInSearchObject(CoreMainClass coreMainClass, ArrayList<InSearchObject> arrayList, ArrayList<InSearchObject> arrayList2, ArrayList<Object> arrayList3, ArrayList<CharSequence> arrayList4, ArrayList<Object> arrayList5) {
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        HashSet hashSet = new HashSet();
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<InSearchObject> it = arrayList.iterator();
            while (it.hasNext()) {
                InSearchObject next = it.next();
                if (!hashSet.contains(next.object_guid)) {
                    hashSet.add(next.object_guid);
                    convertInSearchObject(coreMainClass, next, arrayList6, arrayList7, arrayList8, arrayList3, arrayList4, arrayList5);
                }
            }
        }
        if (arrayList2 != null) {
            Iterator<InSearchObject> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                InSearchObject next2 = it2.next();
                if (!hashSet.contains(next2.object_guid)) {
                    hashSet.add(next2.object_guid);
                    convertInSearchObject(coreMainClass, next2, arrayList6, arrayList7, arrayList8, arrayList3, arrayList4, arrayList5);
                }
            }
        }
    }

    private static void convertInSearchObject(CoreMainClass coreMainClass, InSearchObject inSearchObject, ArrayList<TLRPC$Chat> arrayList, ArrayList<TLRPC$User> arrayList2, ArrayList<TLRPC$Peer> arrayList3, ArrayList<Object> arrayList4, ArrayList<CharSequence> arrayList5, ArrayList<Object> arrayList6) {
        if (inSearchObject == null) {
            return;
        }
        TLRPC$Peer tLRPC$TL_peerChannel = null;
        ShareAlert.DialogSearchResult dialogSearchResult = arrayList6 != null ? new ShareAlert.DialogSearchResult() : null;
        ChatType chatType = inSearchObject.type;
        ChatType chatType2 = ChatType.User;
        if (chatType == chatType2 || chatType == ChatType.Bot || chatType == ChatType.Service) {
            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
            tLRPC$TL_peerUser.user_id = (int) IdStorage.getInstance().generateDialogId(inSearchObject.object_guid);
            TLRPC$TL_user tLRPC$TL_user = new TLRPC$TL_user();
            tLRPC$TL_user.deleted = inSearchObject.is_deleted;
            tLRPC$TL_user.verified = inSearchObject.is_verified;
            tLRPC$TL_user.contact = coreMainClass.isContact(inSearchObject.object_guid);
            tLRPC$TL_user.id = tLRPC$TL_peerUser.user_id;
            if (inSearchObject.type == chatType2) {
                tLRPC$TL_user.first_name = inSearchObject.first_name;
                tLRPC$TL_user.last_name = inSearchObject.last_name;
            } else {
                tLRPC$TL_user.first_name = inSearchObject.title;
            }
            tLRPC$TL_user.username = inSearchObject.username;
            tLRPC$TL_user.self = inSearchObject.object_guid.equals(coreMainClass.getMyGuid());
            if (inSearchObject.avatar_thumbnail != null) {
                tLRPC$TL_user.access_hash = IdStorage.getInstance().generateAccessHash(inSearchObject.avatar_thumbnail.access_hash_rec);
                tLRPC$TL_user.photo = getUserProfilePhoto(inSearchObject.avatar_thumbnail);
            }
            tLRPC$TL_user.status = inSearchObject.type == chatType2 ? ObjectInfoConverter.getUserStatus(coreMainClass, inSearchObject.lastOnline) : null;
            long j = inSearchObject.timeStamp;
            if (j < 0) {
                j = 0;
            }
            tLRPC$TL_user.userInfotimeStamp = j;
            ChatType chatType3 = inSearchObject.type;
            tLRPC$TL_user.bot = chatType3 == ChatType.Bot;
            tLRPC$TL_user.support = chatType3 == ChatType.Service;
            arrayList2.add(tLRPC$TL_user);
            if (arrayList4 != null && !arrayList4.contains(tLRPC$TL_user)) {
                arrayList4.add(tLRPC$TL_user);
                if (arrayList5 != null) {
                    arrayList5.add(inSearchObject.searchMatchName);
                }
            }
            if (dialogSearchResult != null) {
                dialogSearchResult.name = inSearchObject.searchMatchName;
                dialogSearchResult.object = tLRPC$TL_user;
                TLRPC$TL_dialog tLRPC$TL_dialog = new TLRPC$TL_dialog();
                tLRPC$TL_dialog.id = tLRPC$TL_user.id;
                dialogSearchResult.dialog = tLRPC$TL_dialog;
            }
            tLRPC$TL_peerChannel = tLRPC$TL_peerUser;
        } else {
            ChatType chatType4 = ChatType.Group;
            if (chatType == chatType4 || chatType == ChatType.Channel) {
                tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
                tLRPC$TL_peerChannel.channel_id = ((int) IdStorage.getInstance().generateNegativeDialogId(inSearchObject.object_guid)) * (-1);
                TLRPC$TL_channel tLRPC$TL_channel = new TLRPC$TL_channel();
                tLRPC$TL_channel.id = tLRPC$TL_peerChannel.channel_id;
                tLRPC$TL_channel.participants_count = (int) inSearchObject.count_members;
                tLRPC$TL_channel.title = inSearchObject.title;
                if (inSearchObject.avatar_thumbnail != null) {
                    tLRPC$TL_channel.access_hash = IdStorage.getInstance().generateAccessHash(inSearchObject.avatar_thumbnail.access_hash_rec);
                }
                tLRPC$TL_channel.photo = getChatPhoto(inSearchObject.avatar_thumbnail);
                tLRPC$TL_channel.deactivated = inSearchObject.is_deleted;
                tLRPC$TL_channel.verified = inSearchObject.is_verified;
                tLRPC$TL_channel.username = inSearchObject.username;
                tLRPC$TL_channel.megagroup = inSearchObject.type == chatType4;
                arrayList.add(tLRPC$TL_channel);
                if (arrayList4 != null && !arrayList4.contains(tLRPC$TL_channel)) {
                    arrayList4.add(tLRPC$TL_channel);
                    if (arrayList5 != null) {
                        arrayList5.add(inSearchObject.searchMatchName);
                    }
                }
                if (dialogSearchResult != null) {
                    dialogSearchResult.name = inSearchObject.searchMatchName;
                    dialogSearchResult.object = tLRPC$TL_channel;
                    TLRPC$TL_dialog tLRPC$TL_dialog2 = new TLRPC$TL_dialog();
                    tLRPC$TL_dialog2.id = -tLRPC$TL_channel.id;
                    dialogSearchResult.dialog = tLRPC$TL_dialog2;
                }
            }
        }
        if (tLRPC$TL_peerChannel != null && !arrayList3.contains(tLRPC$TL_peerChannel)) {
            arrayList3.add(tLRPC$TL_peerChannel);
        }
        if (dialogSearchResult != null) {
            arrayList6.add(dialogSearchResult);
        }
    }

    public static TLRPC$ChatInvite convertChatPreview(CoreMainClass coreMainClass, ChatInviteObject chatInviteObject, ObjectInfo objectInfo, ChatAbsObject chatAbsObject) {
        if (objectInfo == null || chatAbsObject == null) {
            return null;
        }
        TLRPC$TL_chatInvite tLRPC$TL_chatInvite = new TLRPC$TL_chatInvite();
        tLRPC$TL_chatInvite.title = chatAbsObject.title;
        ChatType chatType = chatAbsObject.type;
        ChatType chatType2 = ChatType.Channel;
        tLRPC$TL_chatInvite.channel = chatType == chatType2;
        tLRPC$TL_chatInvite.photo = MessageConverter.convertToPhoto(chatAbsObject.avatar_thumbnail, null, 0);
        tLRPC$TL_chatInvite.megagroup = chatAbsObject.type == ChatType.Group;
        TLRPC$TL_channel tLRPC$TL_channel = new TLRPC$TL_channel();
        tLRPC$TL_chatInvite.chat = tLRPC$TL_channel;
        setAbsInfoForChannelGroup(tLRPC$TL_channel, chatAbsObject);
        if (!chatInviteObject.has_joined) {
            tLRPC$TL_chatInvite.chat.left = true;
        }
        ObjectInfoConverter.setObjectInfoChat(tLRPC$TL_chatInvite.chat, objectInfo, chatAbsObject.type == chatType2);
        tLRPC$TL_chatInvite.participants = ObjectInfoConverter.convertMembers(coreMainClass, chatInviteObject.top_participants).users;
        tLRPC$TL_chatInvite.participants_count = chatInviteObject.top_participants.size();
        return tLRPC$TL_chatInvite;
    }

    public static DialogCell.CustomDialog createAdDialog(TLRPC$Dialog tLRPC$Dialog) {
        if (!(tLRPC$Dialog instanceof TLRPC$TL_dialogAd)) {
            return null;
        }
        ChatAdsObject chatAdsObject = ((TLRPC$TL_dialogAd) tLRPC$Dialog).adsObject;
        DialogCell.CustomDialog customDialog = new DialogCell.CustomDialog();
        customDialog.isAd = true;
        customDialog.sent = -1;
        customDialog.id = (int) tLRPC$Dialog.id;
        String str = chatAdsObject.title;
        customDialog.name = str;
        if (TextUtils.isEmpty(str)) {
            customDialog.name = "بدون نام";
        }
        customDialog.message = chatAdsObject.text;
        customDialog.pinned = true;
        customDialog.type = 0;
        customDialog.isMedia = true;
        if (chatAdsObject.image != null) {
            ImageLocation imageLocation = new ImageLocation();
            imageLocation.dc_id = IdStorage.getInstance().generateDcId(chatAdsObject.image.dc_id);
            TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated = new TLRPC$TL_fileLocationToBeDeprecated();
            imageLocation.location = tLRPC$TL_fileLocationToBeDeprecated;
            String str2 = chatAdsObject.image.thumb_inline;
            if (str2 != null) {
                tLRPC$TL_fileLocationToBeDeprecated.file_reference = Base64.decode(str2, 0);
            }
            imageLocation.access_hash = IdStorage.getInstance().generateAccessHash(chatAdsObject.image.access_hash_rec);
            AvatarFileInline avatarFileInline = chatAdsObject.image;
            imageLocation.cdnTag = avatarFileInline.cdn_tag;
            TLRPC$TL_fileLocationToBeDeprecated tLRPC$TL_fileLocationToBeDeprecated2 = imageLocation.location;
            tLRPC$TL_fileLocationToBeDeprecated2.local_id = 2;
            long j = avatarFileInline.file_id;
            tLRPC$TL_fileLocationToBeDeprecated2.volume_id = j;
            imageLocation.photoId = j;
            customDialog.imageLocation = imageLocation;
        }
        customDialog.action = chatAdsObject.action_text;
        customDialog.hasAction = chatAdsObject.has_action;
        ColorObject colorObject = chatAdsObject.action_background_color;
        customDialog.actionBackgroundColor = colorObject != null ? colorObject.getColor() : Theme.getColor(Theme.key_windowBackgroundGray);
        customDialog.noticeText = chatAdsObject.notice_text;
        ColorObject colorObject2 = chatAdsObject.notice_color;
        customDialog.noticeColor = colorObject2 != null ? colorObject2.getColor() : Theme.getColor(Theme.key_dialogTextBlack);
        return customDialog;
    }

    public static long getDialogId(String str, ChatType chatType) {
        if (chatType == null || TextUtils.isEmpty(str)) {
            return 0L;
        }
        if (chatType == ChatType.User || chatType == ChatType.Bot || chatType == ChatType.Service) {
            return IdStorage.getInstance().generateDialogId(str);
        }
        return IdStorage.getInstance().generateNegativeDialogId(str);
    }

    public static TLRPC$Peer getPeer(long j, String str, ChatType chatType) {
        if (j == 0) {
            j = getDialogId(str, chatType);
        }
        if (chatType == ChatType.User || chatType == ChatType.Bot || chatType == ChatType.Service) {
            TLRPC$TL_peerUser tLRPC$TL_peerUser = new TLRPC$TL_peerUser();
            tLRPC$TL_peerUser.user_id = (int) j;
            return tLRPC$TL_peerUser;
        }
        TLRPC$TL_peerChannel tLRPC$TL_peerChannel = new TLRPC$TL_peerChannel();
        tLRPC$TL_peerChannel.channel_id = (int) (-j);
        return tLRPC$TL_peerChannel;
    }

    private static TLRPC$StatsGraph convertStatsGraphToTlStats(StatsGraph statsGraph) {
        if (statsGraph == null) {
            return null;
        }
        StatsGraph.Type type = statsGraph.type;
        if (type == StatsGraph.Type.Local) {
            TLRPC$TL_statsGraph tLRPC$TL_statsGraph = new TLRPC$TL_statsGraph();
            tLRPC$TL_statsGraph.zoom_token = statsGraph.zoom_token;
            TLRPC$TL_dataJSON tLRPC$TL_dataJSON = new TLRPC$TL_dataJSON();
            tLRPC$TL_statsGraph.json = tLRPC$TL_dataJSON;
            tLRPC$TL_dataJSON.data = statsGraph.graph_schema;
            return tLRPC$TL_statsGraph;
        }
        if (type == StatsGraph.Type.Async) {
            TLRPC$TL_statsGraphAsync tLRPC$TL_statsGraphAsync = new TLRPC$TL_statsGraphAsync();
            tLRPC$TL_statsGraphAsync.token = statsGraph.async_token;
            return tLRPC$TL_statsGraphAsync;
        }
        if (type != StatsGraph.Type.Error) {
            return null;
        }
        TLRPC$TL_statsGraphError tLRPC$TL_statsGraphError = new TLRPC$TL_statsGraphError();
        tLRPC$TL_statsGraphError.error = statsGraph.error;
        return tLRPC$TL_statsGraphError;
    }

    private static TLRPC$TL_statsDateRangeDays convertStatsDateRangeToTlDataRange(GetAllStatisticsOutput.StatsDateRangeDays statsDateRangeDays) {
        if (statsDateRangeDays == null) {
            return null;
        }
        TLRPC$TL_statsDateRangeDays tLRPC$TL_statsDateRangeDays = new TLRPC$TL_statsDateRangeDays();
        tLRPC$TL_statsDateRangeDays.min_date = statsDateRangeDays.min_date;
        tLRPC$TL_statsDateRangeDays.max_date = statsDateRangeDays.max_date;
        return tLRPC$TL_statsDateRangeDays;
    }

    private static TLRPC$TL_statsAbsValueAndPrev convertStatsAbsValueAndPrev(GetAllStatisticsOutput.StatsAbsValueAndPrev statsAbsValueAndPrev) {
        if (statsAbsValueAndPrev == null) {
            return null;
        }
        TLRPC$TL_statsAbsValueAndPrev tLRPC$TL_statsAbsValueAndPrev = new TLRPC$TL_statsAbsValueAndPrev();
        tLRPC$TL_statsAbsValueAndPrev.current = statsAbsValueAndPrev.current;
        tLRPC$TL_statsAbsValueAndPrev.previous = statsAbsValueAndPrev.previous;
        return tLRPC$TL_statsAbsValueAndPrev;
    }

    private static TLRPC$TL_statsPercentValue convertStatsPercentValue(GetAllStatisticsOutput.StatsPercentValue statsPercentValue) {
        if (statsPercentValue == null) {
            return null;
        }
        TLRPC$TL_statsPercentValue tLRPC$TL_statsPercentValue = new TLRPC$TL_statsPercentValue();
        tLRPC$TL_statsPercentValue.part = statsPercentValue.part;
        tLRPC$TL_statsPercentValue.total = statsPercentValue.total;
        return tLRPC$TL_statsPercentValue;
    }

    public static TLRPC$TL_stats_broadcastStats convertStatsOutputToTlStats(GetAllStatisticsOutput getAllStatisticsOutput) {
        if (getAllStatisticsOutput == null) {
            return null;
        }
        TLRPC$TL_stats_broadcastStats tLRPC$TL_stats_broadcastStats = new TLRPC$TL_stats_broadcastStats();
        tLRPC$TL_stats_broadcastStats.period = convertStatsDateRangeToTlDataRange(getAllStatisticsOutput.period);
        tLRPC$TL_stats_broadcastStats.followers = convertStatsAbsValueAndPrev(getAllStatisticsOutput.followers);
        tLRPC$TL_stats_broadcastStats.views_per_post = convertStatsAbsValueAndPrev(getAllStatisticsOutput.views_per_post);
        tLRPC$TL_stats_broadcastStats.shares_per_post = convertStatsAbsValueAndPrev(getAllStatisticsOutput.shares_per_post);
        tLRPC$TL_stats_broadcastStats.enabled_notifications = convertStatsPercentValue(getAllStatisticsOutput.enabled_notifications);
        tLRPC$TL_stats_broadcastStats.growth_graph = convertStatsGraphToTlStats(getAllStatisticsOutput.growth_graph);
        tLRPC$TL_stats_broadcastStats.followers_graph = convertStatsGraphToTlStats(getAllStatisticsOutput.followers_graph);
        tLRPC$TL_stats_broadcastStats.mute_graph = convertStatsGraphToTlStats(getAllStatisticsOutput.mute_graph);
        tLRPC$TL_stats_broadcastStats.interactions_graph = convertStatsGraphToTlStats(getAllStatisticsOutput.interactions_graph);
        tLRPC$TL_stats_broadcastStats.views_by_source_graph = convertStatsGraphToTlStats(getAllStatisticsOutput.views_graph);
        return tLRPC$TL_stats_broadcastStats;
    }

    public static ArrayList<TLRPC$User> getUserParticipants(CoreMainClass coreMainClass, ArrayList<ChatAbsObject> arrayList) {
        ArrayList<TLRPC$User> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<ChatAbsObject> it = arrayList.iterator();
            while (it.hasNext()) {
                ChatAbsObject next = it.next();
                long dialogId = getDialogId(next.object_guid, next.type);
                ObjectInfo objectInfoInstant = coreMainClass.getObjectInfoInstant(next.object_guid);
                arrayList2.add(convertUser(coreMainClass, dialogId, next, objectInfoInstant != null ? objectInfoInstant.userInfo : null, coreMainClass.getChatInstant(next.object_guid)));
            }
        }
        return arrayList2;
    }

    public static TLObject convertChatAbsToTlObject(CoreMainClass coreMainClass, ChatAbsObject chatAbsObject) {
        if (chatAbsObject != null) {
            long dialogId = getDialogId(chatAbsObject.object_guid, chatAbsObject.type);
            ObjectInfo objectInfoInstant = coreMainClass.getObjectInfoInstant(chatAbsObject.object_guid);
            ChatType chatType = chatAbsObject.type;
            if (chatType == ChatType.User) {
                return convertUser(coreMainClass, dialogId, chatAbsObject, objectInfoInstant != null ? objectInfoInstant.userInfo : null, coreMainClass.getChatInstant(chatAbsObject.object_guid));
            }
            if (chatType == ChatType.Bot) {
                return convertBot(coreMainClass, dialogId, chatAbsObject, objectInfoInstant != null ? objectInfoInstant.botInfo : null, coreMainClass.getChatInstant(chatAbsObject.object_guid));
            }
            if (chatType == ChatType.Service) {
                return convertService(coreMainClass, dialogId, chatAbsObject, objectInfoInstant != null ? objectInfoInstant.serviceInfo : null, coreMainClass.getChatInstant(chatAbsObject.object_guid));
            }
            if (chatType == ChatType.Channel || chatType == ChatType.Group) {
                return convertChannelGroup(coreMainClass, dialogId, chatAbsObject, coreMainClass.getChatInstant(chatAbsObject.object_guid));
            }
        }
        return null;
    }

    public static TLRPC$ChatPhoto getChatPhoto(AvatarFileInline avatarFileInline) {
        if (avatarFileInline != null) {
            TLRPC$TL_chatPhoto tLRPC$TL_chatPhoto = new TLRPC$TL_chatPhoto();
            tLRPC$TL_chatPhoto.dc_id = IdStorage.getInstance().generateDcId(avatarFileInline.dc_id);
            tLRPC$TL_chatPhoto.photo_small = getProfilePhotoLocation(avatarFileInline.file_id, false);
            tLRPC$TL_chatPhoto.photo_big = getProfilePhotoLocation(avatarFileInline.file_id, true);
            return tLRPC$TL_chatPhoto;
        }
        return new TLRPC$TL_chatPhotoEmpty();
    }
}
