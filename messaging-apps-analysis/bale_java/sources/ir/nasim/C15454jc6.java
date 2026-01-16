package ir.nasim;

import livekit.org.webrtc.VideoFrame;

/* renamed from: ir.nasim.jc6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C15454jc6 extends AbstractC14668iI0 {
    private int c;
    private int d;

    public C15454jc6(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    @Override // livekit.org.webrtc.CapturerObserver
    public void onFrameCaptured(VideoFrame videoFrame) {
        int iC;
        int i;
        int iC2;
        int i2;
        int i3;
        AbstractC13042fc3.i(videoFrame, "frame");
        if (videoFrame.getRotatedWidth() == this.c && videoFrame.getRotatedHeight() == this.d) {
            a(videoFrame);
            return;
        }
        int width = videoFrame.getBuffer().getWidth();
        int height = videoFrame.getBuffer().getHeight();
        int i4 = this.c;
        if (i4 > width || (i3 = this.d) > height) {
            double dMax = Math.max(i4 / width, this.d / height);
            int iC3 = AbstractC20723sV3.c(this.c / dMax);
            iC = AbstractC20723sV3.c(this.d / dMax);
            i = iC3;
        } else {
            i = i4;
            iC = i3;
        }
        double d = width;
        double d2 = height;
        double d3 = i / iC;
        if (d / d2 > d3) {
            i2 = height;
            iC2 = AbstractC20723sV3.c(d2 * d3);
        } else {
            int iC4 = AbstractC20723sV3.c(d / d3);
            iC2 = width;
            i2 = iC4;
        }
        VideoFrame videoFrame2 = new VideoFrame(videoFrame.getBuffer().cropAndScale((width - iC2) / 2, (height - i2) / 2, iC2, i2, i, iC), videoFrame.getRotation(), videoFrame.getTimestampNs());
        a(videoFrame2);
        videoFrame2.release();
    }
}
