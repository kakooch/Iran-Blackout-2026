package ir.aaap.messengercore.utilites;

import io.github.inflationx.calligraphy3.BuildConfig;
import java.util.Random;

/* loaded from: classes3.dex */
public class DataGenerator {
    private static String[] strs = {"زرد", "میترا", "نگار", "فا\u200cئزه", "سمانه", "فروغ", "آسمان آبی", "دوستان غرب روستای آباد به جز افلاطون و اصغر", "مرکز پیشبینی آثار لویس بر تمدن مردن غرب", "دریای مواج", "پلنگ soorati", "_surena", "_سالوادور_", "لیوان خالی", "cow", "bird", "lion", "zoo", "bank", "carolin", "pasta", "spaghetti", "pizza", "water", "drink", "yellow", "ali", "Samsung", "cloud", "Sky", "Pride", "Cerato*", "MacBook", "Window", "Tree2", "'TV", "Sheep@", "cat", "car", "Vicror%4", "'", "!", "_", "&", BuildConfig.FLAVOR};
    private static String[] names = {"میترا", "نگار", "فا\u200cئزه", "سمانه", "فروغ", "نوشین", "نسترن", "مینا", "مریم", "سارا", "زهرا", "Mitra", "Mina", "Shirin", "Ali", "Arash", "Babak", "Diba", "Donya", "Nazanin", "Negar", "Tina", "Yasi", "pegah", "Reyhane", "Reza", "Parisa", "Paria", "Parna", BuildConfig.FLAVOR};

    public static String[] getMonth() {
        return new String[]{"فروردین", "اردیبهشت", "خرداد", "تیر", "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند"};
    }

    public static int randomIntSeed(long j, int i) {
        return new Random(j).nextInt(i);
    }

    public static boolean randomBooleanSeed(long j) {
        return new Random(randomLongSeed(j)).nextBoolean();
    }

    public static String randomNameSeed(long j) {
        return names[randomIntSeed(j, names.length - 1)];
    }

    public static String randomStringSeed(long j) {
        return strs[randomIntSeed(j, strs.length - 1)];
    }

    public static long randomLongSeed(long j) {
        return new Random(j).nextLong();
    }

    public static boolean isTwoStringEquals(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }
}
