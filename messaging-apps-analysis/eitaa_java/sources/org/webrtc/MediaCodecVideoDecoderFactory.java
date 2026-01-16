package org.webrtc;

import android.media.MediaCodecInfo;
import android.os.Build;
import java.util.ArrayList;
import org.webrtc.EglBase;
import org.webrtc.VideoDecoderFactory;

/* loaded from: classes3.dex */
class MediaCodecVideoDecoderFactory implements VideoDecoderFactory {
    private static final String TAG = "MediaCodecVideoDecoderFactory";
    private final Predicate<MediaCodecInfo> codecAllowedPredicate;
    private final EglBase.Context sharedContext;

    @Override // org.webrtc.VideoDecoderFactory
    public /* synthetic */ VideoDecoder createDecoder(String str) {
        return VideoDecoderFactory.CC.$default$createDecoder(this, str);
    }

    public MediaCodecVideoDecoderFactory(EglBase.Context sharedContext, Predicate<MediaCodecInfo> codecAllowedPredicate) {
        this.sharedContext = sharedContext;
        this.codecAllowedPredicate = codecAllowedPredicate;
    }

    @Override // org.webrtc.VideoDecoderFactory
    public VideoDecoder createDecoder(VideoCodecInfo codecType) {
        VideoCodecMimeType videoCodecMimeTypeValueOf = VideoCodecMimeType.valueOf(codecType.getName());
        MediaCodecInfo mediaCodecInfoFindCodecForType = findCodecForType(videoCodecMimeTypeValueOf);
        if (mediaCodecInfoFindCodecForType == null) {
            return null;
        }
        return new AndroidVideoDecoder(new MediaCodecWrapperFactoryImpl(), mediaCodecInfoFindCodecForType.getName(), videoCodecMimeTypeValueOf, MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, mediaCodecInfoFindCodecForType.getCapabilitiesForType(videoCodecMimeTypeValueOf.mimeType())).intValue(), this.sharedContext);
    }

    @Override // org.webrtc.VideoDecoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        ArrayList arrayList = new ArrayList();
        VideoCodecMimeType[] videoCodecMimeTypeArr = {VideoCodecMimeType.VP8, VideoCodecMimeType.VP9, VideoCodecMimeType.H264, VideoCodecMimeType.H265};
        for (int i = 0; i < 4; i++) {
            VideoCodecMimeType videoCodecMimeType = videoCodecMimeTypeArr[i];
            MediaCodecInfo mediaCodecInfoFindCodecForType = findCodecForType(videoCodecMimeType);
            if (mediaCodecInfoFindCodecForType != null) {
                String strName = videoCodecMimeType.name();
                if (videoCodecMimeType == VideoCodecMimeType.H264 && isH264HighProfileSupported(mediaCodecInfoFindCodecForType)) {
                    arrayList.add(new VideoCodecInfo(strName, MediaCodecUtils.getCodecProperties(videoCodecMimeType, true)));
                }
                arrayList.add(new VideoCodecInfo(strName, MediaCodecUtils.getCodecProperties(videoCodecMimeType, false)));
            }
        }
        return (VideoCodecInfo[]) arrayList.toArray(new VideoCodecInfo[arrayList.size()]);
    }

    private MediaCodecInfo findCodecForType(VideoCodecMimeType type) {
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        ArrayList<MediaCodecInfo> sortedCodecsList = MediaCodecUtils.getSortedCodecsList();
        int size = sortedCodecsList.size();
        for (int i = 0; i < size; i++) {
            MediaCodecInfo mediaCodecInfo = sortedCodecsList.get(i);
            if (mediaCodecInfo != null && !mediaCodecInfo.isEncoder() && isSupportedCodec(mediaCodecInfo, type)) {
                return mediaCodecInfo;
            }
        }
        return null;
    }

    private boolean isSupportedCodec(MediaCodecInfo info, VideoCodecMimeType type) {
        info.getName();
        if (MediaCodecUtils.codecSupportsType(info, type) && MediaCodecUtils.selectColorFormat(MediaCodecUtils.DECODER_COLOR_FORMATS, info.getCapabilitiesForType(type.mimeType())) != null) {
            return isCodecAllowed(info);
        }
        return false;
    }

    private boolean isCodecAllowed(MediaCodecInfo info) {
        Predicate<MediaCodecInfo> predicate = this.codecAllowedPredicate;
        if (predicate == null) {
            return true;
        }
        return predicate.test(info);
    }

    private boolean isH264HighProfileSupported(MediaCodecInfo info) {
        String name = info.getName();
        int i = Build.VERSION.SDK_INT;
        if (i < 21 || !name.startsWith("OMX.qcom.")) {
            return i >= 23 && name.startsWith("OMX.Exynos.");
        }
        return true;
    }
}
