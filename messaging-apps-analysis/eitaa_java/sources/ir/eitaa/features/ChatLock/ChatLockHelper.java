package ir.eitaa.features.ChatLock;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class ChatLockHelper {
    public static ArrayList<Long> currentUnlockedChats = new ArrayList<>();

    public static void setChatAsUnlocked(Long id) {
        if (currentUnlockedChats.contains(Long.valueOf(Math.abs(id.longValue())))) {
            return;
        }
        currentUnlockedChats.add(Long.valueOf(Math.abs(id.longValue())));
    }

    public static void removeFromUnlockedChats(Long id) {
        currentUnlockedChats.remove(Long.valueOf(Math.abs(id.longValue())));
    }

    public static boolean isChatUnlocked(Long id) {
        return currentUnlockedChats.contains(Long.valueOf(Math.abs(id.longValue())));
    }
}
