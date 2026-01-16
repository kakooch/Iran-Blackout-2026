package ir.aaap.messengercore;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class StringHelper {
    private static Map<StringKeyEnum, String> stringMap = new HashMap();

    public enum StringKeyEnum {
        StickerMessage,
        ContactMessage,
        ChatLive,
        RubinoPost,
        call,
        Story,
        poll,
        Location,
        LiveLocation,
        Image,
        Video,
        Voice,
        Gif,
        music,
        File,
        You
    }

    private static void initMap() {
        stringMap.put(StringKeyEnum.You, "شما");
        stringMap.put(StringKeyEnum.StickerMessage, "استیکر");
        stringMap.put(StringKeyEnum.ContactMessage, "مخاطب");
        stringMap.put(StringKeyEnum.ChatLive, "پخش زنده");
        stringMap.put(StringKeyEnum.RubinoPost, "پست روبینو");
        stringMap.put(StringKeyEnum.call, "تماس");
        stringMap.put(StringKeyEnum.Story, "استوری");
        stringMap.put(StringKeyEnum.poll, "نظرسنجی");
        stringMap.put(StringKeyEnum.Location, "موقعیت جغرافیایی");
        stringMap.put(StringKeyEnum.LiveLocation, "موقعیت مکانی لحظه ای");
        stringMap.put(StringKeyEnum.Image, "تصویر");
        stringMap.put(StringKeyEnum.Video, "ویدیو");
        stringMap.put(StringKeyEnum.Voice, "پیغام صوتی");
        stringMap.put(StringKeyEnum.Gif, "گیف");
        stringMap.put(StringKeyEnum.music, "موسیقی");
        stringMap.put(StringKeyEnum.File, "فایل");
    }

    public static String getString(StringKeyEnum stringKeyEnum) {
        if (stringMap.size() == 0) {
            initMap();
        }
        String str = stringMap.get(stringKeyEnum);
        return str == null ? BuildConfig.FLAVOR : str;
    }
}
