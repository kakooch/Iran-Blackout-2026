package com.google.android.exoplayer2t.util;

import android.text.TextUtils;
import java.util.ArrayList;
import org.rbmain.messenger.MediaController;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes.dex */
public final class MimeTypes {
    private static final ArrayList<CustomMimeType> customMimeTypes = new ArrayList<>();

    private static final class CustomMimeType {
        public final String codecPrefix;
        public final String mimeType;
        public final int trackType;
    }

    public static String getMimeTypeFromMp4ObjectType(int i) {
        if (i == 32) {
            return "video/mp4v-es";
        }
        if (i == 33) {
            return MediaController.VIDEO_MIME_TYPE;
        }
        if (i == 35) {
            return "video/hevc";
        }
        if (i == 64) {
            return MediaController.AUIDO_MIME_TYPE;
        }
        if (i == 163) {
            return "video/wvc1";
        }
        if (i == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i == 165) {
            return "audio/ac3";
        }
        if (i == 166) {
            return "audio/eac3";
        }
        switch (i) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return "video/mpeg2";
            case 102:
            case 103:
            case 104:
                return MediaController.AUIDO_MIME_TYPE;
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            default:
                switch (i) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    public static boolean isAudio(String str) {
        return MediaStreamTrack.AUDIO_TRACK_KIND.equals(getTopLevelType(str));
    }

    public static boolean isVideo(String str) {
        return MediaStreamTrack.VIDEO_TRACK_KIND.equals(getTopLevelType(str));
    }

    public static boolean isText(String str) {
        return "text".equals(getTopLevelType(str));
    }

    public static boolean allSamplesAreSyncSamples(String str) {
        if (str == null) {
            return false;
        }
        switch (str) {
        }
        return false;
    }

    public static String getVideoMediaMimeType(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : Util.splitCodecs(str)) {
            String mediaMimeType = getMediaMimeType(str2);
            if (mediaMimeType != null && isVideo(mediaMimeType)) {
                return mediaMimeType;
            }
        }
        return null;
    }

    public static String getAudioMediaMimeType(String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : Util.splitCodecs(str)) {
            String mediaMimeType = getMediaMimeType(str2);
            if (mediaMimeType != null && isAudio(mediaMimeType)) {
                return mediaMimeType;
            }
        }
        return null;
    }

    public static String getMediaMimeType(String str) {
        String mimeTypeFromMp4ObjectType = null;
        if (str == null) {
            return null;
        }
        String lowerInvariant = Util.toLowerInvariant(str.trim());
        if (lowerInvariant.startsWith("avc1") || lowerInvariant.startsWith("avc3")) {
            return MediaController.VIDEO_MIME_TYPE;
        }
        if (lowerInvariant.startsWith("hev1") || lowerInvariant.startsWith("hvc1")) {
            return "video/hevc";
        }
        if (lowerInvariant.startsWith("dvav") || lowerInvariant.startsWith("dva1") || lowerInvariant.startsWith("dvhe") || lowerInvariant.startsWith("dvh1")) {
            return "video/dolby-vision";
        }
        if (lowerInvariant.startsWith("av01")) {
            return "video/av01";
        }
        if (lowerInvariant.startsWith("vp9") || lowerInvariant.startsWith("vp09")) {
            return "video/x-vnd.on2.vp9";
        }
        if (lowerInvariant.startsWith("vp8") || lowerInvariant.startsWith("vp08")) {
            return "video/x-vnd.on2.vp8";
        }
        if (!lowerInvariant.startsWith("mp4a")) {
            return (lowerInvariant.startsWith("ac-3") || lowerInvariant.startsWith("dac3")) ? "audio/ac3" : (lowerInvariant.startsWith("ec-3") || lowerInvariant.startsWith("dec3")) ? "audio/eac3" : lowerInvariant.startsWith("ec+3") ? "audio/eac3-joc" : (lowerInvariant.startsWith("ac-4") || lowerInvariant.startsWith("dac4")) ? "audio/ac4" : (lowerInvariant.startsWith("dtsc") || lowerInvariant.startsWith("dtse")) ? "audio/vnd.dts" : (lowerInvariant.startsWith("dtsh") || lowerInvariant.startsWith("dtsl")) ? "audio/vnd.dts.hd" : lowerInvariant.startsWith("opus") ? "audio/opus" : lowerInvariant.startsWith("vorbis") ? "audio/vorbis" : lowerInvariant.startsWith("flac") ? "audio/flac" : lowerInvariant.startsWith("stpp") ? "application/ttml+xml" : lowerInvariant.startsWith("wvtt") ? "text/vtt" : getCustomMimeTypeForCodec(lowerInvariant);
        }
        if (lowerInvariant.startsWith("mp4a.")) {
            String strSubstring = lowerInvariant.substring(5);
            if (strSubstring.length() >= 2) {
                try {
                    mimeTypeFromMp4ObjectType = getMimeTypeFromMp4ObjectType(Integer.parseInt(Util.toUpperInvariant(strSubstring.substring(0, 2)), 16));
                } catch (NumberFormatException unused) {
                }
            }
        }
        return mimeTypeFromMp4ObjectType == null ? MediaController.AUIDO_MIME_TYPE : mimeTypeFromMp4ObjectType;
    }

    public static int getTrackType(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (isAudio(str)) {
            return 1;
        }
        if (isVideo(str)) {
            return 2;
        }
        if (isText(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
            return 3;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 4;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 5;
        }
        return getTrackTypeForCustomMimeType(str);
    }

    public static int getEncoding(String str) {
        str.hashCode();
        switch (str) {
            case "audio/eac3-joc":
                return 18;
            case "audio/vnd.dts":
                return 7;
            case "audio/ac3":
                return 5;
            case "audio/ac4":
                return 17;
            case "audio/eac3":
                return 6;
            case "audio/mpeg":
                return 9;
            case "audio/vnd.dts.hd":
                return 8;
            case "audio/true-hd":
                return 14;
            default:
                return 0;
        }
    }

    public static int getTrackTypeOfCodec(String str) {
        return getTrackType(getMediaMimeType(str));
    }

    private static String getTopLevelType(String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, iIndexOf);
    }

    private static String getCustomMimeTypeForCodec(String str) {
        int size = customMimeTypes.size();
        for (int i = 0; i < size; i++) {
            CustomMimeType customMimeType = customMimeTypes.get(i);
            if (str.startsWith(customMimeType.codecPrefix)) {
                return customMimeType.mimeType;
            }
        }
        return null;
    }

    private static int getTrackTypeForCustomMimeType(String str) {
        int size = customMimeTypes.size();
        for (int i = 0; i < size; i++) {
            CustomMimeType customMimeType = customMimeTypes.get(i);
            if (str.equals(customMimeType.mimeType)) {
                return customMimeType.trackType;
            }
        }
        return -1;
    }
}
