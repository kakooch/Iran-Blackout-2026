package ir.aaap.messengercore;

import ir.aaap.messengercore.db.DBHelper;
import ir.aaap.messengercore.model.ChatAbsObject;
import ir.aaap.messengercore.model.ChatType;
import ir.aaap.messengercore.model.MessengerUpdateObject;
import ir.aaap.messengercore.model.NotificationModels;
import ir.aaap.messengercore.model.api.GetUpdateInput;
import ir.aaap.messengercore.model.api.GetUpdateOutput;
import ir.aaap.messengercore.network.ApiServerException;
import ir.aaap.messengercore.network.NetworkHelper;
import ir.aaap.messengercore.network.RetryObject;
import ir.aaap.messengercore.usecase.NotificationUsecase;
import ir.aaap.messengercore.utilites.CoreLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class NotificationUtils {
    public NotificationUtils(CoreLog coreLog) {
    }

    public void processNotification(boolean z, boolean z2, ArrayList<NotificationModels.ShowNotificationObject> arrayList, ArrayList<NotificationModels.EditNotificationObject> arrayList2, ArrayList<NotificationModels.RemoveNotificationObject> arrayList3, DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, NotificationUsecase notificationUsecase) {
        ArrayList<NotificationModels.ShowNotificationObject> arrayList4;
        NotificationModels.ShowNotificationObject notificationById;
        NotificationModels.RemoveToData removeToData;
        ArrayList<String> notificationIDToMessageIdOrTime;
        if ((arrayList == null || arrayList.size() == 0) && ((arrayList2 == null || arrayList2.size() == 0) && (arrayList3 == null || arrayList3.size() == 0))) {
            return;
        }
        ArrayList<NotificationModels.ShowNotificationObject> arrayList5 = new ArrayList<>();
        ArrayList<String> arrayList6 = new ArrayList<>();
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<NotificationModels.ShowNotificationObject> it = arrayList.iterator();
            while (it.hasNext()) {
                NotificationModels.ShowNotificationObject next = it.next();
                NotificationModels.ShowNotificationTypeEnum showNotificationTypeEnum = next.type;
                if (showNotificationTypeEnum == NotificationModels.ShowNotificationTypeEnum.Message) {
                    next.receivedTime = System.currentTimeMillis() / 1000;
                } else if (showNotificationTypeEnum == NotificationModels.ShowNotificationTypeEnum.NotMessage) {
                    next.receivedTime = next.not_message_data.time;
                }
            }
            dBHelper.addAllNotification(arrayList);
            addAbsIfNotExist(arrayList, notificationUsecase);
        }
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            Iterator<NotificationModels.RemoveNotificationObject> it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                NotificationModels.RemoveNotificationObject next2 = it2.next();
                NotificationModels.RemoveNotificationTypeEnum removeNotificationTypeEnum = next2.type;
                if (removeNotificationTypeEnum == NotificationModels.RemoveNotificationTypeEnum.RemoveOne) {
                    NotificationModels.RemoveOneData removeOneData = next2.remove_one_data;
                    if (removeOneData != null && (notificationById = dBHelper.getNotificationById(removeOneData.notification_id)) != null) {
                        arrayList6.add(next2.remove_one_data.notification_id);
                        arrayList5.add(notificationById);
                    }
                } else if (removeNotificationTypeEnum == NotificationModels.RemoveNotificationTypeEnum.RemoveTo && (removeToData = next2.remove_to_data) != null && (notificationIDToMessageIdOrTime = dBHelper.getNotificationIDToMessageIdOrTime(removeToData.object_guid, removeToData.object_type, removeToData.to_message_id, removeToData.to_time)) != null && notificationIDToMessageIdOrTime.size() > 0) {
                    ArrayList<NotificationModels.ShowNotificationObject> allNotificationById = dBHelper.getAllNotificationById(notificationIDToMessageIdOrTime);
                    arrayList6.addAll(notificationIDToMessageIdOrTime);
                    arrayList5.addAll(allNotificationById);
                }
            }
            if (arrayList6.size() > 0) {
                dBHelper.removeAllNotifications(arrayList6);
            }
        }
        if (arrayList2 == null || arrayList2.isEmpty()) {
            arrayList4 = null;
        } else {
            HashMap map = new HashMap();
            Iterator<NotificationModels.EditNotificationObject> it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                NotificationModels.EditNotificationObject next3 = it3.next();
                map.put(next3.notification_id, next3);
            }
            ArrayList<NotificationModels.ShowNotificationObject> allNotificationById2 = dBHelper.getAllNotificationById(new ArrayList<>(map.keySet()));
            if (allNotificationById2 != null) {
                Iterator<NotificationModels.ShowNotificationObject> it4 = allNotificationById2.iterator();
                while (it4.hasNext()) {
                    NotificationModels.ShowNotificationObject next4 = it4.next();
                    NotificationModels.EditNotificationObject editNotificationObject = (NotificationModels.EditNotificationObject) map.get(next4.notification_id);
                    if (editNotificationObject != null) {
                        next4.text = editNotificationObject.edited_text;
                        next4.text_metadata = editNotificationObject.text_metadata;
                    }
                }
                dBHelper.addAllNotification(allNotificationById2);
            }
            arrayList4 = allNotificationById2;
        }
        if ((arrayList == null || arrayList.isEmpty()) && ((arrayList4 == null || arrayList4.size() == 0) && arrayList5.isEmpty())) {
            return;
        }
        absNotificationCenter.onNewNotif(z, z2, arrayList, arrayList4, arrayList5);
    }

    private void addAbsIfNotExist(ArrayList<NotificationModels.ShowNotificationObject> arrayList, NotificationUsecase notificationUsecase) {
        NotificationModels.NotMessageDataObject notMessageDataObject;
        ArrayList<ChatAbsObject> arrayList2 = new ArrayList<>();
        Iterator<NotificationModels.ShowNotificationObject> it = arrayList.iterator();
        while (it.hasNext()) {
            NotificationModels.ShowNotificationObject next = it.next();
            NotificationModels.ShowNotificationTypeEnum showNotificationTypeEnum = next.type;
            if (showNotificationTypeEnum == NotificationModels.ShowNotificationTypeEnum.Message) {
                NotificationModels.MessageDataObject messageDataObject = next.message_data;
                if (messageDataObject != null) {
                    arrayList2.add(ChatAbsObject.createFromGuidAndType(messageDataObject.object_guid, messageDataObject.object_type, 0L));
                }
            } else if (showNotificationTypeEnum == NotificationModels.ShowNotificationTypeEnum.NotMessage && (notMessageDataObject = next.not_message_data) != null) {
                arrayList2.add(ChatAbsObject.createFromGuidAndType(notMessageDataObject.object_guid, notMessageDataObject.object_type, 0L));
            }
        }
        if (notificationUsecase == null || arrayList2.size() <= 0) {
            return;
        }
        notificationUsecase.addToAbsIfNotExist(arrayList2, 0L);
    }

    public void removeNotificationToMessageId(String str, ChatType chatType, long j, AbsNotificationCenter absNotificationCenter, DBHelper dBHelper) {
        ArrayList<String> notificationToMessageId;
        if (!CoreUtilities.isNotEmpty(str) || chatType == null || (notificationToMessageId = dBHelper.getNotificationToMessageId(str, j)) == null || notificationToMessageId.size() <= 0) {
            return;
        }
        ArrayList<NotificationModels.ShowNotificationObject> allNotificationById = dBHelper.getAllNotificationById(notificationToMessageId);
        dBHelper.removeAllNotifications(notificationToMessageId);
        absNotificationCenter.onNewNotif(true, false, null, null, allNotificationById);
    }

    public void removeAllNotificationByChat(String str, ChatType chatType, AbsNotificationCenter absNotificationCenter, DBHelper dBHelper) {
        ArrayList<String> notificationByChat = dBHelper.getNotificationByChat(str);
        if (notificationByChat == null || notificationByChat.size() <= 0) {
            return;
        }
        ArrayList<NotificationModels.ShowNotificationObject> allNotificationById = dBHelper.getAllNotificationById(notificationByChat);
        dBHelper.removeAllNotifications(notificationByChat);
        absNotificationCenter.onNewNotif(true, false, null, null, allNotificationById);
    }

    public void loadAllNotificationsFromDb(DBHelper dBHelper, AbsNotificationCenter absNotificationCenter, NotificationUsecase notificationUsecase) {
        ArrayList<NotificationModels.ShowNotificationObject> allNotifications = dBHelper.getAllNotifications();
        if (allNotifications == null || allNotifications.size() <= 0) {
            return;
        }
        addAbsIfNotExist(allNotifications, notificationUsecase);
        absNotificationCenter.processLoadedUnreadNotifications(allNotifications);
    }

    public void getUpdate(String str, NetworkHelper networkHelper, final LoadListener<MessengerUpdateObject> loadListener) {
        try {
            networkHelper.getUpdate(str, new GetUpdateInput(), RetryObject.getDefaultRetry(), new NetworkHelper.ResponseListener<GetUpdateOutput>(this) { // from class: ir.aaap.messengercore.NotificationUtils.1
                @Override // ir.aaap.messengercore.network.NetworkHelper.ResponseListener
                public void onResponse(GetUpdateOutput getUpdateOutput) {
                    MessengerUpdateObject messengerUpdateObject;
                    if (getUpdateOutput == null || (messengerUpdateObject = getUpdateOutput.update_data) == null) {
                        return;
                    }
                    LoadListener loadListener2 = loadListener;
                    if (loadListener2 != null) {
                        loadListener2.onDidLoad(messengerUpdateObject);
                    } else if (loadListener2 != null) {
                        loadListener2.onError(new ApiServerException());
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

    public void setNotificationReadByGuid(String str, DBHelper dBHelper) {
        if (str == null || str.isEmpty()) {
            return;
        }
        dBHelper.setNotificationReadByGuid(str);
    }

    public void setAllNotificationRead(DBHelper dBHelper) {
        dBHelper.setAllNotificationsRead();
    }
}
