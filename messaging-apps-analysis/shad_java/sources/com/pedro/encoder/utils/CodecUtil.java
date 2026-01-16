package com.pedro.encoder.utils;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class CodecUtil {

    public enum Force {
        FIRST_COMPATIBLE_FOUND,
        SOFTWARE,
        HARDWARE
    }

    private static boolean isValid(String str) {
        return true;
    }

    public static List<MediaCodecInfo> getAllCodecs(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            arrayList.addAll(Arrays.asList(new MediaCodecList(1).getCodecInfos()));
        } else {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i = 0; i < codecCount; i++) {
                arrayList.add(MediaCodecList.getCodecInfoAt(i));
            }
        }
        return z ? filterBrokenCodecs(arrayList) : arrayList;
    }

    public static List<MediaCodecInfo> getAllHardwareEncoders(String str) {
        List<MediaCodecInfo> allEncoders = getAllEncoders(str);
        ArrayList arrayList = new ArrayList();
        for (MediaCodecInfo mediaCodecInfo : allEncoders) {
            if (isHardwareAccelerated(mediaCodecInfo)) {
                arrayList.add(mediaCodecInfo);
            }
        }
        return arrayList;
    }

    public static List<MediaCodecInfo> getAllSoftwareEncoders(String str) {
        List<MediaCodecInfo> allEncoders = getAllEncoders(str);
        ArrayList arrayList = new ArrayList();
        for (MediaCodecInfo mediaCodecInfo : allEncoders) {
            if (isSoftwareOnly(mediaCodecInfo)) {
                arrayList.add(mediaCodecInfo);
            }
        }
        return arrayList;
    }

    public static List<MediaCodecInfo> getAllEncoders(String str) {
        ArrayList arrayList = new ArrayList();
        for (MediaCodecInfo mediaCodecInfo : getAllCodecs(true)) {
            if (mediaCodecInfo.isEncoder()) {
                for (String str2 : mediaCodecInfo.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        arrayList.add(mediaCodecInfo);
                    }
                }
            }
        }
        return arrayList;
    }

    private static boolean isHardwareAccelerated(MediaCodecInfo mediaCodecInfo) {
        if (Build.VERSION.SDK_INT >= 29) {
            return mediaCodecInfo.isHardwareAccelerated();
        }
        return !isSoftwareOnly(mediaCodecInfo);
    }

    private static boolean isSoftwareOnly(MediaCodecInfo mediaCodecInfo) {
        if (Build.VERSION.SDK_INT >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        String lowerCase = mediaCodecInfo.getName().toLowerCase();
        if (lowerCase.startsWith("arc.")) {
            return false;
        }
        return lowerCase.startsWith("omx.google.") || lowerCase.startsWith("omx.ffmpeg.") || (lowerCase.startsWith("omx.sec.") && lowerCase.contains(".sw.")) || lowerCase.equals("omx.qcom.video.decoder.hevcswvdec") || lowerCase.startsWith("c2.android.") || lowerCase.startsWith("c2.google.") || !(lowerCase.startsWith("omx.") || lowerCase.startsWith("c2."));
    }

    private static List<MediaCodecInfo> filterBrokenCodecs(List<MediaCodecInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (MediaCodecInfo mediaCodecInfo : list) {
            if (isValid(mediaCodecInfo.getName())) {
                arrayList.add(mediaCodecInfo);
            }
        }
        return arrayList;
    }
}
