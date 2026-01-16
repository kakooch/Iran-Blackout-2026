package org.webrtc;

import org.webrtc.EncodedImage;

/* loaded from: classes3.dex */
public interface VideoEncoder {

    /* renamed from: org.webrtc.VideoEncoder$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        @CalledByNative
        public static long $default$createNativeVideoEncoder(VideoEncoder videoEncoder) {
            return 0L;
        }

        @CalledByNative
        public static ResolutionBitrateLimits[] $default$getResolutionBitrateLimits(VideoEncoder videoEncoder) {
            return new ResolutionBitrateLimits[0];
        }

        @CalledByNative
        public static boolean $default$isHardwareEncoder(VideoEncoder videoEncoder) {
            return true;
        }
    }

    public interface Callback {
        void onEncodedFrame(EncodedImage frame, CodecSpecificInfo info);
    }

    public static class CodecSpecificInfo {
    }

    public static class CodecSpecificInfoH264 extends CodecSpecificInfo {
    }

    public static class CodecSpecificInfoVP8 extends CodecSpecificInfo {
    }

    public static class CodecSpecificInfoVP9 extends CodecSpecificInfo {
    }

    @CalledByNative
    long createNativeVideoEncoder();

    @CalledByNative
    VideoCodecStatus encode(VideoFrame frame, EncodeInfo info);

    @CalledByNative
    String getImplementationName();

    @CalledByNative
    ResolutionBitrateLimits[] getResolutionBitrateLimits();

    @CalledByNative
    ScalingSettings getScalingSettings();

    @CalledByNative
    VideoCodecStatus initEncode(Settings settings, Callback encodeCallback);

    @CalledByNative
    boolean isHardwareEncoder();

    @CalledByNative
    VideoCodecStatus release();

    @CalledByNative
    VideoCodecStatus setRateAllocation(BitrateAllocation allocation, int framerate);

    public static class Settings {
        public final boolean automaticResizeOn;
        public final Capabilities capabilities;
        public final int height;
        public final int maxFramerate;
        public final int numberOfCores;
        public final int numberOfSimulcastStreams;
        public final int startBitrate;
        public final int width;

        @Deprecated
        public Settings(int numberOfCores, int width, int height, int startBitrate, int maxFramerate, int numberOfSimulcastStreams, boolean automaticResizeOn) {
            this(numberOfCores, width, height, startBitrate, maxFramerate, numberOfSimulcastStreams, automaticResizeOn, new Capabilities(false));
        }

        @CalledByNative("Settings")
        public Settings(int numberOfCores, int width, int height, int startBitrate, int maxFramerate, int numberOfSimulcastStreams, boolean automaticResizeOn, Capabilities capabilities) {
            this.numberOfCores = numberOfCores;
            this.width = width;
            this.height = height;
            this.startBitrate = startBitrate;
            this.maxFramerate = maxFramerate;
            this.numberOfSimulcastStreams = numberOfSimulcastStreams;
            this.automaticResizeOn = automaticResizeOn;
            this.capabilities = capabilities;
        }
    }

    public static class Capabilities {
        public final boolean lossNotification;

        @CalledByNative("Capabilities")
        public Capabilities(boolean lossNotification) {
            this.lossNotification = lossNotification;
        }
    }

    public static class EncodeInfo {
        public final EncodedImage.FrameType[] frameTypes;

        @CalledByNative("EncodeInfo")
        public EncodeInfo(EncodedImage.FrameType[] frameTypes) {
            this.frameTypes = frameTypes;
        }
    }

    public static class BitrateAllocation {
        public final int[][] bitratesBbs;

        @CalledByNative("BitrateAllocation")
        public BitrateAllocation(int[][] bitratesBbs) {
            this.bitratesBbs = bitratesBbs;
        }

        public int getSum() {
            int i = 0;
            for (int[] iArr : this.bitratesBbs) {
                for (int i2 : iArr) {
                    i += i2;
                }
            }
            return i;
        }
    }

    public static class ScalingSettings {
        public static final ScalingSettings OFF = new ScalingSettings();
        public final Integer high;
        public final Integer low;
        public final boolean on;

        public ScalingSettings(int low, int high) {
            this.on = true;
            this.low = Integer.valueOf(low);
            this.high = Integer.valueOf(high);
        }

        private ScalingSettings() {
            this.on = false;
            this.low = null;
            this.high = null;
        }

        @Deprecated
        public ScalingSettings(boolean on) {
            this.on = on;
            this.low = null;
            this.high = null;
        }

        @Deprecated
        public ScalingSettings(boolean on, int low, int high) {
            this.on = on;
            this.low = Integer.valueOf(low);
            this.high = Integer.valueOf(high);
        }

        public String toString() {
            if (!this.on) {
                return "OFF";
            }
            return "[ " + this.low + ", " + this.high + " ]";
        }
    }

    public static class ResolutionBitrateLimits {
        public final int frameSizePixels;
        public final int maxBitrateBps;
        public final int minBitrateBps;
        public final int minStartBitrateBps;

        public ResolutionBitrateLimits(int frameSizePixels, int minStartBitrateBps, int minBitrateBps, int maxBitrateBps) {
            this.frameSizePixels = frameSizePixels;
            this.minStartBitrateBps = minStartBitrateBps;
            this.minBitrateBps = minBitrateBps;
            this.maxBitrateBps = maxBitrateBps;
        }

        @CalledByNative("ResolutionBitrateLimits")
        public int getFrameSizePixels() {
            return this.frameSizePixels;
        }

        @CalledByNative("ResolutionBitrateLimits")
        public int getMinStartBitrateBps() {
            return this.minStartBitrateBps;
        }

        @CalledByNative("ResolutionBitrateLimits")
        public int getMinBitrateBps() {
            return this.minBitrateBps;
        }

        @CalledByNative("ResolutionBitrateLimits")
        public int getMaxBitrateBps() {
            return this.maxBitrateBps;
        }
    }
}
