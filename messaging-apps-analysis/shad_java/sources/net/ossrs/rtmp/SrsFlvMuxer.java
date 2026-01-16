package net.ossrs.rtmp;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import com.github.faucamp.simplertmp.DefaultRtmpPublisher;
import com.github.faucamp.simplertmp.RtmpPublisher;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import net.ossrs.rtmp.SrsAllocator;
import org.rbmain.messenger.MessagesController;

/* loaded from: classes4.dex */
public class SrsFlvMuxer {
    private ConnectCheckerRtmp connectCheckerRtmp;
    private volatile boolean connected;
    private SrsFlv flv;
    private Handler handler;
    private boolean isPpsSpsSend;
    private SrsAllocator mAudioAllocator;
    private long mAudioFramesSent;
    private SrsFlvFrame mAudioSequenceHeader;
    private long mDroppedAudioFrames;
    private long mDroppedVideoFrames;
    private volatile BlockingQueue<SrsFlvFrame> mFlvAudioTagCache;
    private volatile BlockingQueue<SrsFlvFrame> mFlvVideoTagCache;
    private SrsAllocator mVideoAllocator;
    private long mVideoFramesSent;
    private SrsFlvFrame mVideoSequenceHeader;
    private boolean needToFindKeyFrame;
    private int numRetry;
    private byte profileIop;
    private RtmpPublisher publisher;
    private int reTries;
    private Runnable runnable;
    private int sampleRate;
    private String url;
    private Thread worker;

    static /* synthetic */ long access$2108(SrsFlvMuxer srsFlvMuxer) {
        long j = srsFlvMuxer.mDroppedVideoFrames;
        srsFlvMuxer.mDroppedVideoFrames = 1 + j;
        return j;
    }

    static /* synthetic */ long access$2208(SrsFlvMuxer srsFlvMuxer) {
        long j = srsFlvMuxer.mDroppedAudioFrames;
        srsFlvMuxer.mDroppedAudioFrames = 1 + j;
        return j;
    }

    public SrsFlvMuxer(ConnectCheckerRtmp connectCheckerRtmp, RtmpPublisher rtmpPublisher) {
        this.connected = false;
        this.flv = new SrsFlv();
        this.needToFindKeyFrame = true;
        this.mVideoAllocator = new SrsAllocator(MessagesController.UPDATE_MASK_REORDER);
        this.mAudioAllocator = new SrsAllocator(4096);
        this.mFlvVideoTagCache = new LinkedBlockingQueue(30);
        this.mFlvAudioTagCache = new LinkedBlockingQueue(30);
        this.sampleRate = 0;
        this.isPpsSpsSend = false;
        this.profileIop = (byte) 0;
        this.mAudioFramesSent = 0L;
        this.mVideoFramesSent = 0L;
        this.mDroppedAudioFrames = 0L;
        this.mDroppedVideoFrames = 0L;
        this.connectCheckerRtmp = connectCheckerRtmp;
        this.publisher = rtmpPublisher;
        this.handler = new Handler(Looper.getMainLooper());
    }

    public SrsFlvMuxer(ConnectCheckerRtmp connectCheckerRtmp) {
        this(connectCheckerRtmp, new DefaultRtmpPublisher(connectCheckerRtmp));
    }

    public void setSpsPPs(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        this.flv.setSpsPPs(byteBuffer, byteBuffer2);
    }

    public void setSampleRate(int i) {
        this.sampleRate = i;
    }

    public void setIsStereo(boolean z) {
        this.flv.setAchannel(z ? 2 : 1);
    }

    public void resetSentAudioFrames() {
        this.mAudioFramesSent = 0L;
    }

    public void resetSentVideoFrames() {
        this.mVideoFramesSent = 0L;
    }

    public void resetDroppedAudioFrames() {
        this.mDroppedAudioFrames = 0L;
    }

    public void resetDroppedVideoFrames() {
        this.mDroppedVideoFrames = 0L;
    }

    public void setVideoResolution(int i, int i2) {
        this.publisher.setVideoResolution(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disconnect(ConnectCheckerRtmp connectCheckerRtmp) {
        try {
            this.publisher.close();
        } catch (IllegalStateException unused) {
        }
        this.connected = false;
        resetSentAudioFrames();
        resetSentVideoFrames();
        resetDroppedAudioFrames();
        resetDroppedVideoFrames();
        if (connectCheckerRtmp != null) {
            this.reTries = 0;
            connectCheckerRtmp.onDisconnectRtmp();
        }
        Log.i("SrsFlvMuxer", "worker: disconnect ok.");
    }

    public void setReTries(int i) {
        this.numRetry = i;
        this.reTries = i;
    }

    public boolean shouldRetry(String str) {
        return (str.contains("Endpoint malformed") ^ true) && this.reTries > 0;
    }

    public void reConnect(long j) throws InterruptedException {
        this.reTries--;
        stop(null);
        Runnable runnable = new Runnable() { // from class: net.ossrs.rtmp.SrsFlvMuxer.1
            @Override // java.lang.Runnable
            public void run() {
                SrsFlvMuxer srsFlvMuxer = SrsFlvMuxer.this;
                srsFlvMuxer.start(srsFlvMuxer.url);
            }
        };
        this.runnable = runnable;
        this.handler.postDelayed(runnable, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean connect(String str) {
        this.url = str;
        if (!this.connected) {
            Log.i("SrsFlvMuxer", String.format("worker: connecting to RTMP server by url=%s\n", str));
            if (this.publisher.connect(str)) {
                this.connected = this.publisher.publish("live");
            }
        }
        return this.connected;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFlvTag(SrsFlvFrame srsFlvFrame) {
        if (!this.connected || srsFlvFrame == null) {
            return;
        }
        if (srsFlvFrame.is_video()) {
            if (srsFlvFrame.is_keyframe()) {
                Log.i("SrsFlvMuxer", String.format("worker: send frame type=%d, dts=%d, size=%dB", Integer.valueOf(srsFlvFrame.type), Integer.valueOf(srsFlvFrame.dts), Integer.valueOf(srsFlvFrame.flvTag.array().length)));
            }
            this.publisher.publishVideoData(srsFlvFrame.flvTag.array(), srsFlvFrame.flvTag.size(), srsFlvFrame.dts);
            this.mVideoAllocator.release(srsFlvFrame.flvTag);
            this.mVideoFramesSent++;
            return;
        }
        if (srsFlvFrame.is_audio()) {
            this.publisher.publishAudioData(srsFlvFrame.flvTag.array(), srsFlvFrame.flvTag.size(), srsFlvFrame.dts);
            this.mAudioAllocator.release(srsFlvFrame.flvTag);
            this.mAudioFramesSent++;
        }
    }

    public void start(final String str) {
        Thread thread = new Thread(new Runnable() { // from class: net.ossrs.rtmp.SrsFlvMuxer.2
            @Override // java.lang.Runnable
            public void run() throws SecurityException, IllegalArgumentException {
                Process.setThreadPriority(-1);
                if (SrsFlvMuxer.this.connect(str)) {
                    SrsFlvMuxer srsFlvMuxer = SrsFlvMuxer.this;
                    srsFlvMuxer.reTries = srsFlvMuxer.numRetry;
                    SrsFlvMuxer.this.connectCheckerRtmp.onConnectionSuccessRtmp();
                    while (!Thread.interrupted()) {
                        try {
                            BlockingQueue blockingQueue = SrsFlvMuxer.this.mFlvAudioTagCache;
                            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                            SrsFlvFrame srsFlvFrame = (SrsFlvFrame) blockingQueue.poll(1L, timeUnit);
                            if (srsFlvFrame != null) {
                                if (srsFlvFrame.is_sequenceHeader()) {
                                    SrsFlvMuxer.this.mAudioSequenceHeader = srsFlvFrame;
                                }
                                SrsFlvMuxer.this.sendFlvTag(srsFlvFrame);
                            }
                            SrsFlvFrame srsFlvFrame2 = (SrsFlvFrame) SrsFlvMuxer.this.mFlvVideoTagCache.poll(1L, timeUnit);
                            if (srsFlvFrame2 != null) {
                                if (srsFlvFrame2.is_sequenceHeader()) {
                                    SrsFlvMuxer.this.mVideoSequenceHeader = srsFlvFrame2;
                                }
                                SrsFlvMuxer.this.sendFlvTag(srsFlvFrame2);
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        });
        this.worker = thread;
        thread.start();
    }

    public void stop() throws InterruptedException {
        stop(this.connectCheckerRtmp);
    }

    private void stop(final ConnectCheckerRtmp connectCheckerRtmp) throws InterruptedException {
        this.handler.removeCallbacks(this.runnable);
        Thread thread = this.worker;
        if (thread != null) {
            thread.interrupt();
            try {
                this.worker.join(100L);
            } catch (InterruptedException unused) {
                this.worker.interrupt();
            }
            this.worker = null;
        }
        this.mFlvAudioTagCache.clear();
        this.mFlvVideoTagCache.clear();
        this.flv.reset();
        this.needToFindKeyFrame = true;
        Log.i("SrsFlvMuxer", "SrsFlvMuxer closed");
        new Thread(new Runnable() { // from class: net.ossrs.rtmp.SrsFlvMuxer.3
            @Override // java.lang.Runnable
            public void run() {
                SrsFlvMuxer.this.disconnect(connectCheckerRtmp);
            }
        }).start();
    }

    public void sendVideo(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        this.flv.writeVideoSample(byteBuffer, bufferInfo);
    }

    public void sendAudio(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        this.flv.writeAudioSample(byteBuffer, bufferInfo);
    }

    private class SrsAnnexbSearch {
        public boolean match;
        public int nb_start_code;

        private SrsAnnexbSearch(SrsFlvMuxer srsFlvMuxer) {
            this.nb_start_code = 0;
            this.match = false;
        }
    }

    private class SrsFlvFrameBytes {
        public ByteBuffer data;
        public int size;

        private SrsFlvFrameBytes(SrsFlvMuxer srsFlvMuxer) {
        }
    }

    private class SrsFlvFrame {
        public int avc_aac_type;
        public int dts;
        public SrsAllocator.Allocation flvTag;
        public int frame_type;
        public int type;

        private SrsFlvFrame(SrsFlvMuxer srsFlvMuxer) {
        }

        public boolean is_keyframe() {
            return is_video() && this.frame_type == 1;
        }

        public boolean is_sequenceHeader() {
            return this.avc_aac_type == 0;
        }

        public boolean is_video() {
            return this.type == 9;
        }

        public boolean is_audio() {
            return this.type == 8;
        }
    }

    private class SrsRawH264Stream {
        private SrsAnnexbSearch annexb;
        private SrsFlvFrameBytes nalu_header;
        private SrsFlvFrameBytes pps_bb;
        private SrsFlvFrameBytes pps_hdr;
        private SrsFlvFrameBytes seq_hdr;
        private SrsFlvFrameBytes sps_bb;
        private SrsFlvFrameBytes sps_hdr;

        private SrsRawH264Stream() {
            this.annexb = new SrsAnnexbSearch();
            this.nalu_header = new SrsFlvFrameBytes();
            this.seq_hdr = new SrsFlvFrameBytes();
            this.sps_hdr = new SrsFlvFrameBytes();
            this.sps_bb = new SrsFlvFrameBytes();
            this.pps_hdr = new SrsFlvFrameBytes();
            this.pps_bb = new SrsFlvFrameBytes();
        }

        public SrsFlvFrameBytes muxNaluHeader(SrsFlvFrameBytes srsFlvFrameBytes) {
            SrsFlvFrameBytes srsFlvFrameBytes2 = this.nalu_header;
            if (srsFlvFrameBytes2.data == null) {
                srsFlvFrameBytes2.data = ByteBuffer.allocate(4);
                this.nalu_header.size = 4;
            }
            this.nalu_header.data.rewind();
            this.nalu_header.data.putInt(srsFlvFrameBytes.size);
            this.nalu_header.data.rewind();
            return this.nalu_header;
        }

        public void muxSequenceHeader(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ArrayList<SrsFlvFrameBytes> arrayList) {
            SrsFlvFrameBytes srsFlvFrameBytes = this.seq_hdr;
            if (srsFlvFrameBytes.data == null) {
                srsFlvFrameBytes.data = ByteBuffer.allocate(5);
                this.seq_hdr.size = 5;
            }
            this.seq_hdr.data.rewind();
            byte b = byteBuffer.get(1);
            byte b2 = byteBuffer.get(3);
            this.seq_hdr.data.put((byte) 1);
            this.seq_hdr.data.put(b);
            this.seq_hdr.data.put(SrsFlvMuxer.this.profileIop);
            this.seq_hdr.data.put(b2);
            this.seq_hdr.data.put((byte) 3);
            this.seq_hdr.data.rewind();
            arrayList.add(this.seq_hdr);
            SrsFlvFrameBytes srsFlvFrameBytes2 = this.sps_hdr;
            if (srsFlvFrameBytes2.data == null) {
                srsFlvFrameBytes2.data = ByteBuffer.allocate(3);
                this.sps_hdr.size = 3;
            }
            this.sps_hdr.data.rewind();
            this.sps_hdr.data.put((byte) 1);
            this.sps_hdr.data.putShort((short) byteBuffer.array().length);
            this.sps_hdr.data.rewind();
            arrayList.add(this.sps_hdr);
            this.sps_bb.size = byteBuffer.array().length;
            this.sps_bb.data = byteBuffer.duplicate();
            arrayList.add(this.sps_bb);
            SrsFlvFrameBytes srsFlvFrameBytes3 = this.pps_hdr;
            if (srsFlvFrameBytes3.data == null) {
                srsFlvFrameBytes3.data = ByteBuffer.allocate(3);
                this.pps_hdr.size = 3;
            }
            this.pps_hdr.data.rewind();
            this.pps_hdr.data.put((byte) 1);
            this.pps_hdr.data.putShort((short) byteBuffer2.array().length);
            this.pps_hdr.data.rewind();
            arrayList.add(this.pps_hdr);
            this.pps_bb.size = byteBuffer2.array().length;
            this.pps_bb.data = byteBuffer2.duplicate();
            arrayList.add(this.pps_bb);
        }

        public SrsAllocator.Allocation muxFlvTag(ArrayList<SrsFlvFrameBytes> arrayList, int i, int i2) {
            int i3 = 5;
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                i3 += arrayList.get(i4).size;
            }
            SrsAllocator.Allocation allocationAllocate = SrsFlvMuxer.this.mVideoAllocator.allocate(i3);
            allocationAllocate.put((byte) ((i << 4) | 7));
            allocationAllocate.put((byte) i2);
            allocationAllocate.put((byte) 0);
            allocationAllocate.put((byte) 0);
            allocationAllocate.put((byte) 0);
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                SrsFlvFrameBytes srsFlvFrameBytes = arrayList.get(i5);
                srsFlvFrameBytes.data.rewind();
                srsFlvFrameBytes.data.get(allocationAllocate.array(), allocationAllocate.size(), srsFlvFrameBytes.size);
                allocationAllocate.appendOffset(srsFlvFrameBytes.size);
            }
            return allocationAllocate;
        }

        private SrsAnnexbSearch searchStartcode(ByteBuffer byteBuffer, int i) {
            SrsAnnexbSearch srsAnnexbSearch = this.annexb;
            srsAnnexbSearch.match = false;
            srsAnnexbSearch.nb_start_code = 0;
            if (i - 4 > 0) {
                if (byteBuffer.get(0) == 0 && byteBuffer.get(1) == 0 && byteBuffer.get(2) == 0 && byteBuffer.get(3) == 1) {
                    SrsAnnexbSearch srsAnnexbSearch2 = this.annexb;
                    srsAnnexbSearch2.match = true;
                    srsAnnexbSearch2.nb_start_code = 4;
                } else if (byteBuffer.get(0) == 0 && byteBuffer.get(1) == 0 && byteBuffer.get(2) == 1) {
                    SrsAnnexbSearch srsAnnexbSearch3 = this.annexb;
                    srsAnnexbSearch3.match = true;
                    srsAnnexbSearch3.nb_start_code = 3;
                }
            }
            return this.annexb;
        }

        private SrsAnnexbSearch searchAnnexb(ByteBuffer byteBuffer, int i) {
            SrsAnnexbSearch srsAnnexbSearch = this.annexb;
            srsAnnexbSearch.match = false;
            srsAnnexbSearch.nb_start_code = 0;
            int iPosition = byteBuffer.position();
            while (true) {
                if (iPosition >= i - 4) {
                    break;
                }
                if (byteBuffer.get(iPosition) == 0 && byteBuffer.get(iPosition + 1) == 0) {
                    int i2 = iPosition + 2;
                    if (byteBuffer.get(i2) == 1) {
                        SrsAnnexbSearch srsAnnexbSearch2 = this.annexb;
                        srsAnnexbSearch2.match = true;
                        srsAnnexbSearch2.nb_start_code = (iPosition + 3) - byteBuffer.position();
                        break;
                    }
                    if (byteBuffer.get(i2) == 0 && byteBuffer.get(iPosition + 3) == 1) {
                        SrsAnnexbSearch srsAnnexbSearch3 = this.annexb;
                        srsAnnexbSearch3.match = true;
                        srsAnnexbSearch3.nb_start_code = (iPosition + 4) - byteBuffer.position();
                        break;
                    }
                }
                iPosition++;
            }
            return this.annexb;
        }

        public SrsFlvFrameBytes demuxAnnexb(ByteBuffer byteBuffer, int i, boolean z) {
            SrsFlvFrameBytes srsFlvFrameBytes = new SrsFlvFrameBytes();
            if (byteBuffer.position() < i - 4) {
                SrsAnnexbSearch srsAnnexbSearchSearchStartcode = z ? searchStartcode(byteBuffer, i) : searchAnnexb(byteBuffer, i);
                if (!srsAnnexbSearchSearchStartcode.match || srsAnnexbSearchSearchStartcode.nb_start_code < 3) {
                    Log.e("SrsFlvMuxer", "annexb not match.");
                } else {
                    for (int i2 = 0; i2 < srsAnnexbSearchSearchStartcode.nb_start_code; i2++) {
                        byteBuffer.get();
                    }
                    srsFlvFrameBytes.data = byteBuffer.slice();
                    srsFlvFrameBytes.size = i - byteBuffer.position();
                }
            }
            return srsFlvFrameBytes;
        }
    }

    private class SrsFlv {
        private ByteBuffer Pps;
        private ByteBuffer Sps;
        private boolean aac_specific_config_got;
        private int achannel;
        private SrsAllocator.Allocation audio_tag;
        private SrsRawH264Stream avc;
        private ArrayList<SrsFlvFrameBytes> ipbs = new ArrayList<>();
        private SrsAllocator.Allocation video_tag;

        public SrsFlv() {
            this.avc = new SrsRawH264Stream();
            reset();
        }

        public void setAchannel(int i) {
            this.achannel = i;
        }

        public void reset() {
            this.Sps = null;
            this.Pps = null;
            SrsFlvMuxer.this.isPpsSpsSend = false;
            this.aac_specific_config_got = false;
        }

        public void writeAudioSample(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            byte b;
            int i;
            int i2 = (int) (bufferInfo.presentationTimeUs / 1000);
            SrsAllocator.Allocation allocationAllocate = SrsFlvMuxer.this.mAudioAllocator.allocate(bufferInfo.size + 2);
            this.audio_tag = allocationAllocate;
            int i3 = 3;
            if (!this.aac_specific_config_got) {
                byte b2 = (byte) (bufferInfo.flags == 2 ? byteBuffer.get(0) & 248 : (byteBuffer.get(0) & 248) / 2);
                switch (SrsFlvMuxer.this.sampleRate) {
                    case 11025:
                        i = 10;
                        break;
                    case 12000:
                        i = 9;
                        break;
                    case 16000:
                        i = 8;
                        break;
                    case 22050:
                        i = 7;
                        break;
                    case 24000:
                        i = 6;
                        break;
                    case 32000:
                        i = 5;
                        break;
                    case 44100:
                    default:
                        i = 4;
                        break;
                    case 48000:
                        i = 3;
                        break;
                    case 64000:
                        i = 2;
                        break;
                    case 88200:
                        i = 1;
                        break;
                    case 96000:
                        i = 0;
                        break;
                }
                this.audio_tag.put((byte) (b2 | ((i >> 1) & 7)), 2);
                this.audio_tag.put((byte) (((byte) ((i << 7) & 128)) | (((this.achannel == 2 ? 2 : 1) << 3) & 120)), 3);
                this.aac_specific_config_got = true;
                writeAdtsHeader(this.audio_tag.array(), 4);
                this.audio_tag.appendOffset(7);
                b = 0;
            } else {
                byteBuffer.get(allocationAllocate.array(), 2, bufferInfo.size);
                this.audio_tag.appendOffset(bufferInfo.size + 2);
                b = 1;
            }
            int i4 = this.achannel == 2 ? 1 : 0;
            if (SrsFlvMuxer.this.sampleRate == 22050) {
                i3 = 2;
            } else if (SrsFlvMuxer.this.sampleRate == 11025) {
                i3 = 1;
            }
            this.audio_tag.put((byte) (((byte) (((byte) (((byte) (i4 & 1)) | 2)) | ((i3 << 2) & 12))) | 160), 0);
            this.audio_tag.put(b, 1);
            writeRtmpPacket(8, i2, 0, b, this.audio_tag);
        }

        private void writeAdtsHeader(byte[] bArr, int i) {
            bArr[i] = -1;
            int i2 = i + 1;
            bArr[i2] = -16;
            bArr[i2] = (byte) (bArr[i2] | 0);
            bArr[i2] = (byte) (bArr[i2] | 0);
            bArr[i2] = (byte) (bArr[i2] | 1);
            int i3 = i + 2;
            bArr[i3] = 64;
            bArr[i3] = (byte) (bArr[i3] | 16);
            bArr[i3] = (byte) (bArr[i3] | 0);
            int i4 = i + 3;
            bArr[i4] = -128;
            bArr[i4] = (byte) (bArr[i4] | 0);
            bArr[i4] = (byte) (bArr[i4] | 0);
            bArr[i4] = (byte) (bArr[i4] | 0);
            bArr[i4] = (byte) (bArr[i4] | 0);
            bArr[i4] = (byte) (bArr[i4] | (((bArr.length - 2) & 6144) >> 11));
            bArr[i + 4] = (byte) (((bArr.length - 2) & 2040) >> 3);
            int i5 = i + 5;
            bArr[i5] = (byte) (((bArr.length - 2) & 7) << 5);
            bArr[i5] = (byte) (bArr[i5] | 31);
            int i6 = i + 6;
            bArr[i6] = -4;
            bArr[i6] = (byte) (bArr[i6] | 0);
        }

        public void writeVideoSample(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            if (bufferInfo.size < 4) {
                return;
            }
            byteBuffer.rewind();
            int i = (int) (bufferInfo.presentationTimeUs / 1000);
            int i2 = 2;
            SrsFlvFrameBytes srsFlvFrameBytesDemuxAnnexb = this.avc.demuxAnnexb(byteBuffer, bufferInfo.size, true);
            int i3 = srsFlvFrameBytesDemuxAnnexb.data.get(0) & 31;
            if (i3 == 5 || bufferInfo.flags == 1) {
                i2 = 1;
            } else {
                if (i3 == 7 || i3 == 8) {
                    SrsFlvFrameBytes srsFlvFrameBytesDemuxAnnexb2 = this.avc.demuxAnnexb(byteBuffer, bufferInfo.size, false);
                    srsFlvFrameBytesDemuxAnnexb.size = (srsFlvFrameBytesDemuxAnnexb.size - srsFlvFrameBytesDemuxAnnexb2.size) - 4;
                    if (!srsFlvFrameBytesDemuxAnnexb.data.equals(this.Sps)) {
                        byte[] bArr = new byte[srsFlvFrameBytesDemuxAnnexb.size];
                        srsFlvFrameBytesDemuxAnnexb.data.get(bArr);
                        SrsFlvMuxer.this.isPpsSpsSend = false;
                        this.Sps = ByteBuffer.wrap(bArr);
                    }
                    SrsFlvFrameBytes srsFlvFrameBytesDemuxAnnexb3 = this.avc.demuxAnnexb(byteBuffer, bufferInfo.size, false);
                    if (srsFlvFrameBytesDemuxAnnexb3.size > 0 && 6 == (srsFlvFrameBytesDemuxAnnexb3.data.get(0) & 31)) {
                        srsFlvFrameBytesDemuxAnnexb2.size = (srsFlvFrameBytesDemuxAnnexb2.size - srsFlvFrameBytesDemuxAnnexb3.size) - 3;
                    }
                    if (srsFlvFrameBytesDemuxAnnexb2.size <= 0 || srsFlvFrameBytesDemuxAnnexb2.data.equals(this.Pps)) {
                        return;
                    }
                    byte[] bArr2 = new byte[srsFlvFrameBytesDemuxAnnexb2.size];
                    srsFlvFrameBytesDemuxAnnexb2.data.get(bArr2);
                    SrsFlvMuxer.this.isPpsSpsSend = false;
                    this.Pps = ByteBuffer.wrap(bArr2);
                    writeH264SpsPps(i);
                    return;
                }
                if (i3 != 1) {
                    return;
                }
            }
            this.ipbs.add(this.avc.muxNaluHeader(srsFlvFrameBytesDemuxAnnexb));
            this.ipbs.add(srsFlvFrameBytesDemuxAnnexb);
            writeH264IpbFrame(this.ipbs, i2, i);
            this.ipbs.clear();
        }

        public void setSpsPPs(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
            this.Sps = byteBuffer;
            this.Pps = byteBuffer2;
        }

        private void writeH264SpsPps(int i) {
            if (this.Pps == null || this.Sps == null || SrsFlvMuxer.this.isPpsSpsSend) {
                return;
            }
            ArrayList<SrsFlvFrameBytes> arrayList = new ArrayList<>();
            this.avc.muxSequenceHeader(this.Sps, this.Pps, arrayList);
            this.video_tag = this.avc.muxFlvTag(arrayList, 1, 0);
            SrsFlvMuxer.this.isPpsSpsSend = true;
            writeRtmpPacket(9, i, 1, 0, this.video_tag);
            Log.i("SrsFlvMuxer", String.format("flv: h264 sps/pps sent, sps=%dB, pps=%dB", Integer.valueOf(this.Sps.array().length), Integer.valueOf(this.Pps.array().length)));
        }

        private void writeH264IpbFrame(ArrayList<SrsFlvFrameBytes> arrayList, int i, int i2) {
            if (this.Pps == null || this.Sps == null) {
                return;
            }
            SrsAllocator.Allocation allocationMuxFlvTag = this.avc.muxFlvTag(arrayList, i, 1);
            this.video_tag = allocationMuxFlvTag;
            writeRtmpPacket(9, i2, i, 1, allocationMuxFlvTag);
        }

        private void writeRtmpPacket(int i, int i2, int i3, int i4, SrsAllocator.Allocation allocation) {
            SrsFlvFrame srsFlvFrame = new SrsFlvFrame();
            srsFlvFrame.flvTag = allocation;
            srsFlvFrame.type = i;
            srsFlvFrame.dts = i2;
            srsFlvFrame.frame_type = i3;
            srsFlvFrame.avc_aac_type = i4;
            if (srsFlvFrame.is_video()) {
                if (SrsFlvMuxer.this.needToFindKeyFrame) {
                    if (srsFlvFrame.is_keyframe()) {
                        SrsFlvMuxer.this.needToFindKeyFrame = false;
                        flvFrameCacheAdd(srsFlvFrame);
                        return;
                    }
                    return;
                }
                flvFrameCacheAdd(srsFlvFrame);
                return;
            }
            if (srsFlvFrame.is_audio()) {
                flvFrameCacheAdd(srsFlvFrame);
            }
        }

        private void flvFrameCacheAdd(SrsFlvFrame srsFlvFrame) {
            try {
                if (srsFlvFrame.is_video()) {
                    SrsFlvMuxer.this.mFlvVideoTagCache.add(srsFlvFrame);
                } else {
                    SrsFlvMuxer.this.mFlvAudioTagCache.add(srsFlvFrame);
                }
            } catch (IllegalStateException unused) {
                Log.i("SrsFlvMuxer", "frame discarded");
                if (srsFlvFrame.is_video()) {
                    SrsFlvMuxer.access$2108(SrsFlvMuxer.this);
                } else {
                    SrsFlvMuxer.access$2208(SrsFlvMuxer.this);
                }
            }
        }
    }
}
