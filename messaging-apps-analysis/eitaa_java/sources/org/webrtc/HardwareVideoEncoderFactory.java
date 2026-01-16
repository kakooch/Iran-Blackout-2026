package org.webrtc;

import android.media.MediaCodecInfo;
import android.os.Build;
import ir.eitaa.messenger.voip.Instance;
import ir.eitaa.messenger.voip.VoIPService;
import java.util.ArrayList;
import org.webrtc.EglBase;
import org.webrtc.EglBase14;
import org.webrtc.VideoEncoderFactory;

/* loaded from: classes3.dex */
public class HardwareVideoEncoderFactory implements VideoEncoderFactory {
    private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_L_MS = 15000;
    private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_M_MS = 20000;
    private static final int QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_N_MS = 15000;
    private static final String TAG = "HardwareVideoEncoderFactory";
    private final Predicate<MediaCodecInfo> codecAllowedPredicate;
    private final boolean enableH264HighProfile;
    private final boolean enableIntelVp8Encoder;
    private final EglBase14.Context sharedContext;

    @Override // org.webrtc.VideoEncoderFactory
    public /* synthetic */ VideoEncoderFactory.VideoEncoderSelector getEncoderSelector() {
        return VideoEncoderFactory.CC.$default$getEncoderSelector(this);
    }

    @Override // org.webrtc.VideoEncoderFactory
    public /* synthetic */ VideoCodecInfo[] getImplementations() {
        return getSupportedCodecs();
    }

    public HardwareVideoEncoderFactory(EglBase.Context sharedContext, boolean enableIntelVp8Encoder, boolean enableH264HighProfile) {
        this(sharedContext, enableIntelVp8Encoder, enableH264HighProfile, null);
    }

    public HardwareVideoEncoderFactory(EglBase.Context sharedContext, boolean enableIntelVp8Encoder, boolean enableH264HighProfile, Predicate<MediaCodecInfo> codecAllowedPredicate) {
        if (sharedContext instanceof EglBase14.Context) {
            this.sharedContext = (EglBase14.Context) sharedContext;
        } else {
            Logging.w(TAG, "No shared EglBase.Context.  Encoders will not use texture mode.");
            this.sharedContext = null;
        }
        this.enableIntelVp8Encoder = enableIntelVp8Encoder;
        this.enableH264HighProfile = enableH264HighProfile;
        this.codecAllowedPredicate = codecAllowedPredicate;
    }

    @Deprecated
    public HardwareVideoEncoderFactory(boolean enableIntelVp8Encoder, boolean enableH264HighProfile) {
        this(null, enableIntelVp8Encoder, enableH264HighProfile);
    }

    @Override // org.webrtc.VideoEncoderFactory
    public VideoEncoder createEncoder(VideoCodecInfo input) {
        VideoCodecMimeType videoCodecMimeTypeValueOf;
        MediaCodecInfo mediaCodecInfoFindCodecForType;
        if (Build.VERSION.SDK_INT < 19 || (mediaCodecInfoFindCodecForType = findCodecForType((videoCodecMimeTypeValueOf = VideoCodecMimeType.valueOf(input.name)))) == null) {
            return null;
        }
        String name = mediaCodecInfoFindCodecForType.getName();
        String strMimeType = videoCodecMimeTypeValueOf.mimeType();
        Integer numSelectColorFormat = MediaCodecUtils.selectColorFormat(MediaCodecUtils.TEXTURE_COLOR_FORMATS, mediaCodecInfoFindCodecForType.getCapabilitiesForType(strMimeType));
        Integer numSelectColorFormat2 = MediaCodecUtils.selectColorFormat(MediaCodecUtils.ENCODER_COLOR_FORMATS, mediaCodecInfoFindCodecForType.getCapabilitiesForType(strMimeType));
        if (videoCodecMimeTypeValueOf == VideoCodecMimeType.H264) {
            boolean zIsSameH264Profile = H264Utils.isSameH264Profile(input.params, MediaCodecUtils.getCodecProperties(videoCodecMimeTypeValueOf, true));
            boolean zIsSameH264Profile2 = H264Utils.isSameH264Profile(input.params, MediaCodecUtils.getCodecProperties(videoCodecMimeTypeValueOf, false));
            if (!zIsSameH264Profile && !zIsSameH264Profile2) {
                return null;
            }
            if (zIsSameH264Profile && !isH264HighProfileSupported(mediaCodecInfoFindCodecForType)) {
                return null;
            }
        }
        return new HardwareVideoEncoder(new MediaCodecWrapperFactoryImpl(), name, videoCodecMimeTypeValueOf, numSelectColorFormat, numSelectColorFormat2, input.params, getKeyFrameIntervalSec(videoCodecMimeTypeValueOf), getForcedKeyFrameIntervalMs(videoCodecMimeTypeValueOf, name), createBitrateAdjuster(videoCodecMimeTypeValueOf, name), this.sharedContext);
    }

    @Override // org.webrtc.VideoEncoderFactory
    public VideoCodecInfo[] getSupportedCodecs() {
        if (Build.VERSION.SDK_INT < 19 || !(VoIPService.getSharedInstance() == null || VoIPService.getSharedInstance().groupCall == null)) {
            return new VideoCodecInfo[0];
        }
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
        ArrayList<MediaCodecInfo> sortedCodecsList = MediaCodecUtils.getSortedCodecsList();
        int size = sortedCodecsList.size();
        for (int i = 0; i < size; i++) {
            MediaCodecInfo mediaCodecInfo = sortedCodecsList.get(i);
            if (mediaCodecInfo != null && mediaCodecInfo.isEncoder() && isSupportedCodec(mediaCodecInfo, type)) {
                return mediaCodecInfo;
            }
        }
        return null;
    }

    private boolean isSupportedCodec(MediaCodecInfo info, VideoCodecMimeType type) {
        return MediaCodecUtils.codecSupportsType(info, type) && MediaCodecUtils.selectColorFormat(MediaCodecUtils.ENCODER_COLOR_FORMATS, info.getCapabilitiesForType(type.mimeType())) != null && isHardwareSupportedInCurrentSdk(info, type) && isMediaCodecAllowed(info);
    }

    private boolean isHardwareSupportedInCurrentSdk(MediaCodecInfo info, VideoCodecMimeType type) {
        if (VoIPService.getSharedInstance() != null && VoIPService.getSharedInstance().groupCall != null) {
            return false;
        }
        Instance.ServerConfig globalServerConfig = Instance.getGlobalServerConfig();
        if (!globalServerConfig.enable_h264_encoder && !globalServerConfig.enable_h265_encoder && !globalServerConfig.enable_vp8_encoder && !globalServerConfig.enable_vp9_encoder) {
            return false;
        }
        int i = AnonymousClass1.$SwitchMap$org$webrtc$VideoCodecMimeType[type.ordinal()];
        if (i == 1) {
            return isHardwareSupportedInCurrentSdkVp8(info);
        }
        if (i == 2) {
            return isHardwareSupportedInCurrentSdkVp9(info);
        }
        if (i == 3) {
            return isHardwareSupportedInCurrentSdkH264(info);
        }
        if (i != 4) {
            return false;
        }
        return isHardwareSupportedInCurrentSdkH265(info);
    }

    /* renamed from: org.webrtc.HardwareVideoEncoderFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$webrtc$VideoCodecMimeType;

        static {
            int[] iArr = new int[VideoCodecMimeType.values().length];
            $SwitchMap$org$webrtc$VideoCodecMimeType = iArr;
            try {
                iArr[VideoCodecMimeType.VP8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$webrtc$VideoCodecMimeType[VideoCodecMimeType.VP9.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$webrtc$VideoCodecMimeType[VideoCodecMimeType.H264.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$webrtc$VideoCodecMimeType[VideoCodecMimeType.H265.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private boolean isHardwareSupportedInCurrentSdkVp8(MediaCodecInfo info) {
        if (!Instance.getGlobalServerConfig().enable_vp8_encoder) {
            return false;
        }
        String name = info.getName();
        return (name.startsWith("OMX.qcom.") && Build.VERSION.SDK_INT >= 19) || (name.startsWith("OMX.hisi.") && Build.VERSION.SDK_INT >= 19) || ((name.startsWith("OMX.Exynos.") && Build.VERSION.SDK_INT >= 23) || (name.startsWith("OMX.Intel.") && Build.VERSION.SDK_INT >= 21 && this.enableIntelVp8Encoder));
    }

    private boolean isHardwareSupportedInCurrentSdkVp9(MediaCodecInfo info) {
        if (!Instance.getGlobalServerConfig().enable_vp9_encoder) {
            return false;
        }
        String name = info.getName();
        return (name.startsWith("OMX.qcom.") || name.startsWith("OMX.Exynos.") || name.startsWith("OMX.hisi.")) && Build.VERSION.SDK_INT >= 24;
    }

    private boolean isHardwareSupportedInCurrentSdkH264(MediaCodecInfo info) {
        if (!Instance.getGlobalServerConfig().enable_h264_encoder) {
            return false;
        }
        String name = info.getName();
        return (name.startsWith("OMX.qcom.") && Build.VERSION.SDK_INT >= 19) || (name.startsWith("OMX.Exynos.") && Build.VERSION.SDK_INT >= 21);
    }

    private boolean isHardwareSupportedInCurrentSdkH265(MediaCodecInfo info) {
        if (!Instance.getGlobalServerConfig().enable_h265_encoder) {
            return false;
        }
        String name = info.getName();
        return (name.startsWith("OMX.qcom.") && Build.VERSION.SDK_INT >= 19) || (name.startsWith("OMX.Exynos.") && Build.VERSION.SDK_INT >= 21);
    }

    private boolean isMediaCodecAllowed(MediaCodecInfo info) {
        Predicate<MediaCodecInfo> predicate = this.codecAllowedPredicate;
        if (predicate == null) {
            return true;
        }
        return predicate.test(info);
    }

    private int getKeyFrameIntervalSec(VideoCodecMimeType type) {
        int i = AnonymousClass1.$SwitchMap$org$webrtc$VideoCodecMimeType[type.ordinal()];
        if (i == 1 || i == 2) {
            return 100;
        }
        if (i == 3 || i == 4) {
            return 20;
        }
        throw new IllegalArgumentException("Unsupported VideoCodecMimeType " + type);
    }

    private int getForcedKeyFrameIntervalMs(VideoCodecMimeType type, String codecName) {
        if (type != VideoCodecMimeType.VP8 || !codecName.startsWith("OMX.qcom.")) {
            return 0;
        }
        int i = Build.VERSION.SDK_INT;
        if (i != 21 && i != 22) {
            if (i == 23) {
                return QCOM_VP8_KEY_FRAME_INTERVAL_ANDROID_M_MS;
            }
            if (i <= 23) {
                return 0;
            }
        }
        return 15000;
    }

    private BitrateAdjuster createBitrateAdjuster(VideoCodecMimeType type, String codecName) {
        if (codecName.startsWith("OMX.Exynos.")) {
            if (type == VideoCodecMimeType.VP8) {
                return new DynamicBitrateAdjuster();
            }
            return new FramerateBitrateAdjuster();
        }
        return new BaseBitrateAdjuster();
    }

    private boolean isH264HighProfileSupported(MediaCodecInfo info) {
        return this.enableH264HighProfile && Build.VERSION.SDK_INT > 23 && info.getName().startsWith("OMX.Exynos.");
    }
}
