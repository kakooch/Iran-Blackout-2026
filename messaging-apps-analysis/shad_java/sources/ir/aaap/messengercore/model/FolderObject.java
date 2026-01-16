package ir.aaap.messengercore.model;

import ir.aaap.messengercore.utilites.Objects;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public class FolderObject {
    public static int DIALOG_FILTER_FLAG_ALL_CHATS = (((1 | 2) | 4) | 8) | 16;
    public static int DIALOG_FILTER_FLAG_BOTS = 16;
    public static int DIALOG_FILTER_FLAG_CHANNELS = 8;
    public static int DIALOG_FILTER_FLAG_CONTACTS = 1;
    public static int DIALOG_FILTER_FLAG_EXCLUDE_ARCHIVED = 128;
    public static int DIALOG_FILTER_FLAG_EXCLUDE_MUTED = 32;
    public static int DIALOG_FILTER_FLAG_EXCLUDE_READ = 64;
    public static int DIALOG_FILTER_FLAG_GROUPS = 4;
    public static int DIALOG_FILTER_FLAG_NON_CONTACTS = 2;
    public static int DIALOG_FILTER_FLAG_ONLY_ARCHIVED = 256;
    public int flags;
    public String folder_id;
    public String name;
    public int order;
    public String suggestion_folder_id;
    public ArrayList<ObjectGuidType> include_objects = new ArrayList<>();
    public ArrayList<ObjectGuidType> exclude_objects = new ArrayList<>();
    public ArrayList<ObjectGuidType> pinned_objects = new ArrayList<>();
    public ArrayList<EnumIncludeChatType> include_chat_types = new ArrayList<>();
    public ArrayList<EnumExcludeChatType> exclude_chat_types = new ArrayList<>();
    public int pinNum = 0;
    public ArrayList<String> chats = new ArrayList<>();
    public Set<String> pinnedDialogsSet = new HashSet();

    public enum EnumExcludeChatType {
        Mute,
        Read
    }

    public enum EnumIncludeChatType {
        Contacts,
        NonConatcts,
        Groups,
        Channels,
        Bots,
        Services
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FolderObject)) {
            return false;
        }
        FolderObject folderObject = (FolderObject) obj;
        return this.order == folderObject.order && this.flags == folderObject.flags && Objects.equals(this.folder_id, folderObject.folder_id) && Objects.equals(this.name, folderObject.name) && Objects.equalsArray(this.include_objects, folderObject.include_objects) && Objects.equalsArray(this.exclude_objects, folderObject.exclude_objects) && Objects.equalsArray(this.pinned_objects, folderObject.pinned_objects) && Objects.equalsArray(this.include_chat_types, folderObject.include_chat_types) && Objects.equalsArray(this.exclude_chat_types, folderObject.exclude_chat_types) && Objects.equals(this.suggestion_folder_id, folderObject.suggestion_folder_id) && getClass().getDeclaredFields().length == 22;
    }

    public int hashCode() {
        return Objects.hash(this.folder_id, this.name, this.include_objects, this.exclude_objects, this.pinned_objects, this.include_chat_types, this.exclude_chat_types, Integer.valueOf(this.order), this.suggestion_folder_id, Integer.valueOf(this.flags), this.chats, this.pinnedDialogsSet);
    }

    public void createFlags() {
        if (this.include_chat_types.contains(EnumIncludeChatType.Contacts)) {
            this.flags |= DIALOG_FILTER_FLAG_CONTACTS;
        }
        if (this.include_chat_types.contains(EnumIncludeChatType.NonConatcts)) {
            this.flags |= DIALOG_FILTER_FLAG_NON_CONTACTS;
        }
        if (this.include_chat_types.contains(EnumIncludeChatType.Groups)) {
            this.flags |= DIALOG_FILTER_FLAG_GROUPS;
        }
        if (this.include_chat_types.contains(EnumIncludeChatType.Channels)) {
            this.flags |= DIALOG_FILTER_FLAG_CHANNELS;
        }
        if (this.include_chat_types.contains(EnumIncludeChatType.Bots)) {
            this.flags |= DIALOG_FILTER_FLAG_BOTS;
        }
        if (this.exclude_chat_types.contains(EnumExcludeChatType.Mute)) {
            this.flags |= DIALOG_FILTER_FLAG_EXCLUDE_MUTED;
        }
        if (this.exclude_chat_types.contains(EnumExcludeChatType.Read)) {
            this.flags |= DIALOG_FILTER_FLAG_EXCLUDE_READ;
        }
    }

    public void makeSetFromArrays() {
        this.pinnedDialogsSet.clear();
        Iterator<ObjectGuidType> it = this.pinned_objects.iterator();
        while (it.hasNext()) {
            this.pinnedDialogsSet.add(it.next().object_guid);
        }
    }
}
