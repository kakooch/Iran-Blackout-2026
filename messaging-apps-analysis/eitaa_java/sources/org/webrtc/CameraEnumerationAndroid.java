package org.webrtc;

import android.graphics.ImageFormat;
import ir.eitaa.messenger.R;
import j$.time.a;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.linphone.mediastream.Factory;

/* loaded from: classes3.dex */
public class CameraEnumerationAndroid {
    static final ArrayList<Size> COMMON_RESOLUTIONS = new ArrayList<>(Arrays.asList(new Size(160, R.styleable.AppCompatTheme_windowNoTitle), new Size(240, 160), new Size(320, 240), new Size(400, 240), new Size(480, 320), new Size(640, 360), new Size(640, 480), new Size(768, 480), new Size(854, 480), new Size(800, 600), new Size(960, 540), new Size(960, 640), new Size(Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV, 576), new Size(Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV, 600), new Size(1280, 720), new Size(1280, Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV), new Size(1920, 1080), new Size(1920, 1440), new Size(2560, 1440), new Size(3840, 2160)));
    private static final String TAG = "CameraEnumerationAndroid";

    public static class CaptureFormat {
        public final FramerateRange framerate;
        public final int height;
        public final int imageFormat = 17;
        public final int width;

        public static class FramerateRange {
            public int max;
            public int min;

            public FramerateRange(int min, int max) {
                this.min = min;
                this.max = max;
            }

            public String toString() {
                return "[" + (this.min / 1000.0f) + ":" + (this.max / 1000.0f) + "]";
            }

            public boolean equals(Object other) {
                if (!(other instanceof FramerateRange)) {
                    return false;
                }
                FramerateRange framerateRange = (FramerateRange) other;
                return this.min == framerateRange.min && this.max == framerateRange.max;
            }

            public int hashCode() {
                return (this.min * 65537) + 1 + this.max;
            }
        }

        public CaptureFormat(int width, int height, int minFramerate, int maxFramerate) {
            this.width = width;
            this.height = height;
            this.framerate = new FramerateRange(minFramerate, maxFramerate);
        }

        public CaptureFormat(int width, int height, FramerateRange framerate) {
            this.width = width;
            this.height = height;
            this.framerate = framerate;
        }

        public int frameSize() {
            return frameSize(this.width, this.height, 17);
        }

        public static int frameSize(int width, int height, int imageFormat) {
            if (imageFormat != 17) {
                throw new UnsupportedOperationException("Don't know how to calculate the frame size of non-NV21 image formats.");
            }
            return ((width * height) * ImageFormat.getBitsPerPixel(imageFormat)) / 8;
        }

        public String toString() {
            return this.width + "x" + this.height + "@" + this.framerate;
        }

        public boolean equals(Object other) {
            if (!(other instanceof CaptureFormat)) {
                return false;
            }
            CaptureFormat captureFormat = (CaptureFormat) other;
            return this.width == captureFormat.width && this.height == captureFormat.height && this.framerate.equals(captureFormat.framerate);
        }

        public int hashCode() {
            return (((this.width * 65497) + this.height) * 251) + 1 + this.framerate.hashCode();
        }
    }

    private static abstract class ClosestComparator<T> implements Comparator<T>, j$.util.Comparator {
        abstract int diff(T supportedParameter);

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ Comparator reversed() {
            return Collections.reverseOrder(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ Comparator thenComparing(Function function) {
            return a.E(this, Comparator.CC.comparing(function));
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }

        private ClosestComparator() {
        }

        @Override // java.util.Comparator, j$.util.Comparator
        public int compare(T t1, T t2) {
            return diff(t1) - diff(t2);
        }
    }

    public static CaptureFormat.FramerateRange getClosestSupportedFramerateRange(List<CaptureFormat.FramerateRange> supportedFramerates, final int requestedFps) {
        return (CaptureFormat.FramerateRange) Collections.min(supportedFramerates, new ClosestComparator<CaptureFormat.FramerateRange>() { // from class: org.webrtc.CameraEnumerationAndroid.1
            private static final int MAX_FPS_DIFF_THRESHOLD = 5000;
            private static final int MAX_FPS_HIGH_DIFF_WEIGHT = 3;
            private static final int MAX_FPS_LOW_DIFF_WEIGHT = 1;
            private static final int MIN_FPS_HIGH_VALUE_WEIGHT = 4;
            private static final int MIN_FPS_LOW_VALUE_WEIGHT = 1;
            private static final int MIN_FPS_THRESHOLD = 8000;

            private int progressivePenalty(int value, int threshold, int lowWeight, int highWeight) {
                if (value < threshold) {
                    return value * lowWeight;
                }
                return ((value - threshold) * highWeight) + (lowWeight * threshold);
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.webrtc.CameraEnumerationAndroid.ClosestComparator
            public int diff(CaptureFormat.FramerateRange range) {
                return progressivePenalty(range.min, MIN_FPS_THRESHOLD, 1, 4) + progressivePenalty(Math.abs((requestedFps * 1000) - range.max), MAX_FPS_DIFF_THRESHOLD, 1, 3);
            }
        });
    }

    public static Size getClosestSupportedSize(List<Size> supportedSizes, final int requestedWidth, final int requestedHeight) {
        return (Size) Collections.min(supportedSizes, new ClosestComparator<Size>() { // from class: org.webrtc.CameraEnumerationAndroid.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // org.webrtc.CameraEnumerationAndroid.ClosestComparator
            public int diff(Size size) {
                return Math.abs(requestedWidth - size.width) + Math.abs(requestedHeight - size.height);
            }
        });
    }

    static void reportCameraResolution(Histogram histogram, Size resolution) {
        histogram.addSample(COMMON_RESOLUTIONS.indexOf(resolution) + 1);
    }
}
