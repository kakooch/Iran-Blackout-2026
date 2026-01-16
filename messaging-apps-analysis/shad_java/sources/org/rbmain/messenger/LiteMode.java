package org.rbmain.messenger;

import android.content.SharedPreferences;
import android.os.BatteryManager;
import android.os.Build;
import androidx.core.math.MathUtils;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import org.rbmain.messenger.SvgHelper;
import org.rbmain.messenger.Utilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.AnimatedEmojiDrawable;

/* loaded from: classes4.dex */
public class LiteMode {
    private static int BATTERY_HIGH = 10;
    private static int BATTERY_LOW = 10;
    private static int BATTERY_MEDIUM = 10;
    public static final int FLAGS_ANIMATED_EMOJI = 28700;
    public static final int FLAGS_ANIMATED_STICKERS = 3;
    public static final int FLAGS_CHAT = 33248;
    public static final int FLAG_ANIMATED_EMOJI_CHAT = 4112;
    public static final int FLAG_ANIMATED_EMOJI_CHAT_NOT_PREMIUM = 4096;
    public static final int FLAG_ANIMATED_EMOJI_CHAT_PREMIUM = 16;
    public static final int FLAG_ANIMATED_EMOJI_KEYBOARD = 16388;
    public static final int FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM = 16384;
    public static final int FLAG_ANIMATED_EMOJI_KEYBOARD_PREMIUM = 4;
    public static final int FLAG_ANIMATED_EMOJI_REACTIONS = 8200;
    public static final int FLAG_ANIMATED_EMOJI_REACTIONS_NOT_PREMIUM = 8192;
    public static final int FLAG_ANIMATED_EMOJI_REACTIONS_PREMIUM = 8;
    public static final int FLAG_ANIMATED_STICKERS_CHAT = 2;
    public static final int FLAG_ANIMATED_STICKERS_KEYBOARD = 1;
    public static final int FLAG_AUTOPLAY_GIFS = 2048;
    public static final int FLAG_AUTOPLAY_VIDEOS = 1024;
    public static final int FLAG_CALLS_ANIMATIONS = 512;
    public static final int FLAG_CHAT_BACKGROUND = 32;
    public static final int FLAG_CHAT_BLUR = 256;
    public static final int FLAG_CHAT_FORUM_TWOCOLUMN = 64;
    public static final int FLAG_CHAT_SCALE = 32768;
    public static final int FLAG_CHAT_SPOILER = 128;
    public static int PRESET_HIGH = 65535;
    public static int PRESET_LOW = 2076;
    public static int PRESET_MEDIUM = 7775;
    public static int PRESET_POWER_SAVER = 0;
    private static int lastBatteryLevelCached = -1;
    private static long lastBatteryLevelChecked;
    private static boolean lastPowerSaverApplied;
    private static boolean loaded;
    private static HashSet<Utilities.Callback16<Boolean>> onPowerSaverAppliedListeners;
    private static int powerSaverLevel;
    private static int value;

    private static int preprocessFlag(int i) {
        if ((i & FLAG_ANIMATED_EMOJI_KEYBOARD) > 0) {
            i = (i & (-16389)) | FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM;
        }
        if ((i & FLAG_ANIMATED_EMOJI_REACTIONS) > 0) {
            i = (i & (-8201)) | 8192;
        }
        return (i & FLAG_ANIMATED_EMOJI_CHAT) > 0 ? (i & (-4113)) | 4096 : i;
    }

    public static int getValue() {
        return getValue(false);
    }

    public static int getValue(boolean z) throws IOException {
        if (!loaded) {
            loadPreference();
        }
        if (!z && Build.VERSION.SDK_INT >= 21) {
            int batteryLevel = getBatteryLevel();
            int i = powerSaverLevel;
            if (batteryLevel <= i && i > 0) {
                if (!lastPowerSaverApplied) {
                    lastPowerSaverApplied = true;
                    onPowerSaverApplied(true);
                }
                return PRESET_POWER_SAVER;
            }
            if (lastPowerSaverApplied) {
                lastPowerSaverApplied = false;
                onPowerSaverApplied(false);
            }
        }
        return value;
    }

    public static int getBatteryLevel() {
        BatteryManager batteryManager;
        if ((lastBatteryLevelCached < 0 || System.currentTimeMillis() - lastBatteryLevelChecked > 12000) && (batteryManager = (BatteryManager) ApplicationLoader.applicationContext.getSystemService("batterymanager")) != null) {
            lastBatteryLevelCached = batteryManager.getIntProperty(4);
            lastBatteryLevelChecked = System.currentTimeMillis();
        }
        return lastBatteryLevelCached;
    }

    public static boolean isEnabled(int i) {
        if (i == 64 && AndroidUtilities.isTablet()) {
            return true;
        }
        return (preprocessFlag(i) & getValue()) > 0;
    }

    public static boolean isEnabledSetting(int i) {
        return (i & getValue(true)) > 0;
    }

    public static void toggleFlag(int i) {
        toggleFlag(i, !isEnabled(i));
    }

    public static void toggleFlag(int i, boolean z) {
        int value2;
        if (z) {
            value2 = i | getValue(true);
        } else {
            value2 = (i ^ (-1)) & getValue(true);
        }
        setAllFlags(value2);
    }

    public static void setAllFlags(int i) {
        value = i;
        savePreference();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void updatePresets(org.rbmain.tgnet.TLRPC$TL_jsonObject r8) throws java.io.IOException {
        /*
            r0 = 0
            r1 = 0
        L2:
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$TL_jsonObjectValue> r2 = r8.value
            int r2 = r2.size()
            if (r1 >= r2) goto L8e
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$TL_jsonObjectValue> r2 = r8.value
            java.lang.Object r2 = r2.get(r1)
            org.rbmain.tgnet.TLRPC$TL_jsonObjectValue r2 = (org.rbmain.tgnet.TLRPC$TL_jsonObjectValue) r2
            java.lang.String r3 = r2.key
            java.lang.String r4 = "settings_mask"
            boolean r3 = r4.equals(r3)
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L50
            org.rbmain.tgnet.TLRPC$JSONValue r3 = r2.value
            boolean r6 = r3 instanceof org.rbmain.tgnet.TLRPC$TL_jsonArray
            if (r6 == 0) goto L50
            org.rbmain.tgnet.TLRPC$TL_jsonArray r3 = (org.rbmain.tgnet.TLRPC$TL_jsonArray) r3
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$JSONValue> r2 = r3.value
            java.lang.Object r3 = r2.get(r0)     // Catch: java.lang.Exception -> L4b
            org.rbmain.tgnet.TLRPC$TL_jsonNumber r3 = (org.rbmain.tgnet.TLRPC$TL_jsonNumber) r3     // Catch: java.lang.Exception -> L4b
            double r6 = r3.value     // Catch: java.lang.Exception -> L4b
            int r3 = (int) r6     // Catch: java.lang.Exception -> L4b
            org.rbmain.messenger.LiteMode.PRESET_LOW = r3     // Catch: java.lang.Exception -> L4b
            java.lang.Object r3 = r2.get(r5)     // Catch: java.lang.Exception -> L4b
            org.rbmain.tgnet.TLRPC$TL_jsonNumber r3 = (org.rbmain.tgnet.TLRPC$TL_jsonNumber) r3     // Catch: java.lang.Exception -> L4b
            double r5 = r3.value     // Catch: java.lang.Exception -> L4b
            int r3 = (int) r5     // Catch: java.lang.Exception -> L4b
            org.rbmain.messenger.LiteMode.PRESET_MEDIUM = r3     // Catch: java.lang.Exception -> L4b
            java.lang.Object r2 = r2.get(r4)     // Catch: java.lang.Exception -> L4b
            org.rbmain.tgnet.TLRPC$TL_jsonNumber r2 = (org.rbmain.tgnet.TLRPC$TL_jsonNumber) r2     // Catch: java.lang.Exception -> L4b
            double r2 = r2.value     // Catch: java.lang.Exception -> L4b
            int r2 = (int) r2     // Catch: java.lang.Exception -> L4b
            org.rbmain.messenger.LiteMode.PRESET_HIGH = r2     // Catch: java.lang.Exception -> L4b
            goto L8a
        L4b:
            r2 = move-exception
            org.rbmain.messenger.FileLog.e(r2)
            goto L8a
        L50:
            java.lang.String r3 = r2.key
            java.lang.String r6 = "battery_low"
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L8a
            org.rbmain.tgnet.TLRPC$JSONValue r2 = r2.value
            boolean r3 = r2 instanceof org.rbmain.tgnet.TLRPC$TL_jsonArray
            if (r3 == 0) goto L8a
            org.rbmain.tgnet.TLRPC$TL_jsonArray r2 = (org.rbmain.tgnet.TLRPC$TL_jsonArray) r2
            java.util.ArrayList<org.rbmain.tgnet.TLRPC$JSONValue> r2 = r2.value
            java.lang.Object r3 = r2.get(r0)     // Catch: java.lang.Exception -> L86
            org.rbmain.tgnet.TLRPC$TL_jsonNumber r3 = (org.rbmain.tgnet.TLRPC$TL_jsonNumber) r3     // Catch: java.lang.Exception -> L86
            double r6 = r3.value     // Catch: java.lang.Exception -> L86
            int r3 = (int) r6     // Catch: java.lang.Exception -> L86
            org.rbmain.messenger.LiteMode.BATTERY_LOW = r3     // Catch: java.lang.Exception -> L86
            java.lang.Object r3 = r2.get(r5)     // Catch: java.lang.Exception -> L86
            org.rbmain.tgnet.TLRPC$TL_jsonNumber r3 = (org.rbmain.tgnet.TLRPC$TL_jsonNumber) r3     // Catch: java.lang.Exception -> L86
            double r5 = r3.value     // Catch: java.lang.Exception -> L86
            int r3 = (int) r5     // Catch: java.lang.Exception -> L86
            org.rbmain.messenger.LiteMode.BATTERY_MEDIUM = r3     // Catch: java.lang.Exception -> L86
            java.lang.Object r2 = r2.get(r4)     // Catch: java.lang.Exception -> L86
            org.rbmain.tgnet.TLRPC$TL_jsonNumber r2 = (org.rbmain.tgnet.TLRPC$TL_jsonNumber) r2     // Catch: java.lang.Exception -> L86
            double r2 = r2.value     // Catch: java.lang.Exception -> L86
            int r2 = (int) r2     // Catch: java.lang.Exception -> L86
            org.rbmain.messenger.LiteMode.BATTERY_HIGH = r2     // Catch: java.lang.Exception -> L86
            goto L8a
        L86:
            r2 = move-exception
            org.rbmain.messenger.FileLog.e(r2)
        L8a:
            int r1 = r1 + 1
            goto L2
        L8e:
            loadPreference()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.rbmain.messenger.LiteMode.updatePresets(org.rbmain.tgnet.TLRPC$TL_jsonObject):void");
    }

    public static void loadPreference() throws IOException {
        int i = PRESET_HIGH;
        int i2 = BATTERY_HIGH;
        if (SharedConfig.getDevicePerformanceClass() == 0) {
            i = PRESET_LOW;
            i2 = BATTERY_LOW;
        } else if (SharedConfig.getDevicePerformanceClass() == 1) {
            i = PRESET_MEDIUM;
            i2 = BATTERY_MEDIUM;
        }
        SharedPreferences globalMainSettings = MessagesController.getGlobalMainSettings();
        if (!globalMainSettings.contains("lite_mode2")) {
            if (globalMainSettings.contains("lite_mode")) {
                i = globalMainSettings.getInt("lite_mode", i);
                if (i == 4095) {
                    i = PRESET_HIGH;
                }
            } else {
                if (globalMainSettings.contains("light_mode")) {
                    if ((globalMainSettings.getInt("light_mode", SharedConfig.getDevicePerformanceClass() == 0 ? 1 : 0) & 1) > 0) {
                        i = PRESET_LOW;
                    } else {
                        i = PRESET_HIGH;
                    }
                }
                if (globalMainSettings.contains("loopStickers")) {
                    i = globalMainSettings.getBoolean("loopStickers", true) ? i | 2 : i & (-3);
                }
                if (globalMainSettings.contains("autoplay_video")) {
                    i = globalMainSettings.getBoolean("autoplay_video", true) || globalMainSettings.getBoolean("autoplay_video_liteforce", false) ? i | 1024 : i & (-1025);
                }
                if (globalMainSettings.contains("autoplay_gif")) {
                    i = globalMainSettings.getBoolean("autoplay_gif", true) ? i | 2048 : i & (-2049);
                }
                if (globalMainSettings.contains("chatBlur")) {
                    i = globalMainSettings.getBoolean("chatBlur", true) ? i | 256 : i & (-257);
                }
            }
        }
        int i3 = value;
        int i4 = globalMainSettings.getInt("lite_mode2", i);
        value = i4;
        if (loaded) {
            onFlagsUpdate(i3, i4);
        }
        powerSaverLevel = globalMainSettings.getInt("lite_mode_battery_level", i2);
        loaded = true;
    }

    public static void savePreference() {
        MessagesController.getGlobalMainSettings().edit().putInt("lite_mode2", value).putInt("lite_mode_battery_level", powerSaverLevel).apply();
    }

    public static int getPowerSaverLevel() {
        if (!loaded) {
            loadPreference();
        }
        return powerSaverLevel;
    }

    public static void setPowerSaverLevel(int i) throws IOException {
        powerSaverLevel = MathUtils.clamp(i, 0, 100);
        savePreference();
        getValue(false);
    }

    public static boolean isPowerSaverApplied() throws IOException {
        getValue(false);
        return lastPowerSaverApplied;
    }

    private static void onPowerSaverApplied(final boolean z) throws IOException {
        if (z) {
            onFlagsUpdate(getValue(true), PRESET_POWER_SAVER);
        } else {
            onFlagsUpdate(PRESET_POWER_SAVER, getValue(true));
        }
        if (onPowerSaverAppliedListeners != null) {
            AndroidUtilities.runOnUIThread(new Runnable() { // from class: org.rbmain.messenger.LiteMode$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LiteMode.lambda$onPowerSaverApplied$0(z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onPowerSaverApplied$0(boolean z) {
        Iterator<Utilities.Callback16<Boolean>> it = onPowerSaverAppliedListeners.iterator();
        while (it.hasNext()) {
            Utilities.Callback16<Boolean> next = it.next();
            if (next != null) {
                next.run(Boolean.valueOf(z));
            }
        }
    }

    private static void onFlagsUpdate(int i, int i2) throws IOException {
        int i3 = (i ^ (-1)) & i2;
        if ((i3 & FLAGS_ANIMATED_EMOJI) > 0) {
            AnimatedEmojiDrawable.updateAll();
        }
        int i4 = i3 & 32;
        if (i4 > 0) {
            SvgHelper.SvgDrawable.updateLiteValues();
        }
        if (i4 > 0) {
            Theme.reloadWallpaper(true);
        }
    }

    public static void addOnPowerSaverAppliedListener(Utilities.Callback16<Boolean> callback16) {
        if (onPowerSaverAppliedListeners == null) {
            onPowerSaverAppliedListeners = new HashSet<>();
        }
        onPowerSaverAppliedListeners.add(callback16);
    }

    public static void removeOnPowerSaverAppliedListener(Utilities.Callback16<Boolean> callback16) {
        HashSet<Utilities.Callback16<Boolean>> hashSet = onPowerSaverAppliedListeners;
        if (hashSet != null) {
            hashSet.remove(callback16);
        }
    }
}
