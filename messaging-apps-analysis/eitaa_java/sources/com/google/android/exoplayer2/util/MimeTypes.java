package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import ir.eitaa.messenger.MediaController;
import ir.eitaa.messenger.R;
import java.util.ArrayList;
import org.webrtc.MediaStreamTrack;

/* loaded from: classes.dex */
public final class MimeTypes {
    private static final ArrayList<CustomMimeType> customMimeTypes = new ArrayList<>();

    private static final class CustomMimeType {
        public final String codecPrefix;
        public final String mimeType;
        public final int trackType;
    }

    public static String getMimeTypeFromMp4ObjectType(int objectType) {
        if (objectType == 32) {
            return "video/mp4v-es";
        }
        if (objectType == 33) {
            return MediaController.VIDEO_MIME_TYPE;
        }
        if (objectType == 35) {
            return "video/hevc";
        }
        if (objectType == 64) {
            return MediaController.AUIDO_MIME_TYPE;
        }
        if (objectType == 163) {
            return "video/wvc1";
        }
        if (objectType == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (objectType == 165) {
            return "audio/ac3";
        }
        if (objectType == 166) {
            return "audio/eac3";
        }
        switch (objectType) {
            case R.styleable.AppCompatTheme_textAppearanceLargePopupMenu /* 96 */:
            case R.styleable.AppCompatTheme_textAppearanceListItem /* 97 */:
            case R.styleable.AppCompatTheme_textAppearanceListItemSecondary /* 98 */:
            case R.styleable.AppCompatTheme_textAppearanceListItemSmall /* 99 */:
            case R.styleable.AppCompatTheme_textAppearancePopupMenuHeader /* 100 */:
            case R.styleable.AppCompatTheme_textAppearanceSearchResultSubtitle /* 101 */:
                return "video/mpeg2";
            case R.styleable.AppCompatTheme_textAppearanceSearchResultTitle /* 102 */:
            case R.styleable.AppCompatTheme_textAppearanceSmallPopupMenu /* 103 */:
            case R.styleable.AppCompatTheme_textColorAlertDialogListItem /* 104 */:
                return MediaController.AUIDO_MIME_TYPE;
            case R.styleable.AppCompatTheme_textColorSearchUrl /* 105 */:
            case R.styleable.AppCompatTheme_toolbarStyle /* 107 */:
                return "audio/mpeg";
            case R.styleable.AppCompatTheme_toolbarNavigationButtonStyle /* 106 */:
                return "video/mpeg";
            default:
                switch (objectType) {
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

    public static boolean isAudio(String mimeType) {
        return MediaStreamTrack.AUDIO_TRACK_KIND.equals(getTopLevelType(mimeType));
    }

    public static boolean isVideo(String mimeType) {
        return MediaStreamTrack.VIDEO_TRACK_KIND.equals(getTopLevelType(mimeType));
    }

    public static boolean isText(String mimeType) {
        return "text".equals(getTopLevelType(mimeType));
    }

    public static boolean allSamplesAreSyncSamples(String mimeType) {
        if (mimeType == null) {
            return false;
        }
        switch (mimeType) {
        }
        return false;
    }

    public static String getVideoMediaMimeType(String codecs) {
        if (codecs == null) {
            return null;
        }
        for (String str : Util.splitCodecs(codecs)) {
            String mediaMimeType = getMediaMimeType(str);
            if (mediaMimeType != null && isVideo(mediaMimeType)) {
                return mediaMimeType;
            }
        }
        return null;
    }

    public static String getAudioMediaMimeType(String codecs) {
        if (codecs == null) {
            return null;
        }
        for (String str : Util.splitCodecs(codecs)) {
            String mediaMimeType = getMediaMimeType(str);
            if (mediaMimeType != null && isAudio(mediaMimeType)) {
                return mediaMimeType;
            }
        }
        return null;
    }

    public static String getMediaMimeType(String codec) {
        String mimeTypeFromMp4ObjectType = null;
        if (codec == null) {
            return null;
        }
        String lowerInvariant = Util.toLowerInvariant(codec.trim());
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

    public static int getTrackType(String mimeType) {
        if (TextUtils.isEmpty(mimeType)) {
            return -1;
        }
        if (isAudio(mimeType)) {
            return 1;
        }
        if (isVideo(mimeType)) {
            return 2;
        }
        if (isText(mimeType) || "application/cea-608".equals(mimeType) || "application/cea-708".equals(mimeType) || "application/x-mp4-cea-608".equals(mimeType) || "application/x-subrip".equals(mimeType) || "application/ttml+xml".equals(mimeType) || "application/x-quicktime-tx3g".equals(mimeType) || "application/x-mp4-vtt".equals(mimeType) || "application/x-rawcc".equals(mimeType) || "application/vobsub".equals(mimeType) || "application/pgs".equals(mimeType) || "application/dvbsubs".equals(mimeType)) {
            return 3;
        }
        if ("application/id3".equals(mimeType) || "application/x-emsg".equals(mimeType) || "application/x-scte35".equals(mimeType)) {
            return 4;
        }
        if ("application/x-camera-motion".equals(mimeType)) {
            return 5;
        }
        return getTrackTypeForCustomMimeType(mimeType);
    }

    public static int getEncoding(String mimeType) {
        mimeType.hashCode();
        switch (mimeType) {
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

    public static int getTrackTypeOfCodec(String codec) {
        return getTrackType(getMediaMimeType(codec));
    }

    private static String getTopLevelType(String mimeType) {
        int iIndexOf;
        if (mimeType == null || (iIndexOf = mimeType.indexOf(47)) == -1) {
            return null;
        }
        return mimeType.substring(0, iIndexOf);
    }

    private static String getCustomMimeTypeForCodec(String codec) {
        int size = customMimeTypes.size();
        for (int i = 0; i < size; i++) {
            CustomMimeType customMimeType = customMimeTypes.get(i);
            if (codec.startsWith(customMimeType.codecPrefix)) {
                return customMimeType.mimeType;
            }
        }
        return null;
    }

    private static int getTrackTypeForCustomMimeType(String mimeType) {
        int size = customMimeTypes.size();
        for (int i = 0; i < size; i++) {
            CustomMimeType customMimeType = customMimeTypes.get(i);
            if (mimeType.equals(customMimeType.mimeType)) {
                return customMimeType.trackType;
            }
        }
        return -1;
    }
}
