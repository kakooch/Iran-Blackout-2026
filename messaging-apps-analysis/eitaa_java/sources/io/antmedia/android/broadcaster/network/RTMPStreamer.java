package io.antmedia.android.broadcaster.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import net.butterflytv.rtmp_client.RTMPMuxer;
import org.linphone.mediastream.Factory;

/* loaded from: classes.dex */
public class RTMPStreamer extends Handler implements IMediaMuxer {
    private static final String TAG = RTMPStreamer.class.getSimpleName();
    private ArrayList<Frame> audioFrameList;
    private long bytesInQueue;
    public int frameCount;
    private Object frameSynchronized;
    private boolean isAudioEnabled;
    private boolean isConnected;
    private int lastAudioFrameTimeStamp;
    private int lastSentFrameTimeStamp;
    private int lastVideoFrameTimeStamp;
    private int mLastReceivedAudioFrameTimeStamp;
    private int mLastReceivedVideoFrameTimeStamp;
    private int mLastVideoFrameTimeStampInQueue;
    private byte[] pcmBufferMuted;
    public int result;
    RTMPMuxer rtmpMuxer;
    private ArrayList<Frame> videoFrameList;

    public class Frame {
        byte[] data;
        int length;
        int timestamp;

        public Frame(byte[] data, int length, int timestamp) {
            this.data = data;
            this.length = length;
            this.timestamp = timestamp;
        }
    }

    public RTMPStreamer(Looper looper) {
        super(looper);
        this.rtmpMuxer = new RTMPMuxer();
        this.pcmBufferMuted = new byte[Factory.DEVICE_HAS_CRAPPY_AAUDIO];
        this.bytesInQueue = 0L;
        this.result = 0;
        this.mLastReceivedVideoFrameTimeStamp = -1;
        this.mLastReceivedAudioFrameTimeStamp = -1;
        this.mLastVideoFrameTimeStampInQueue = -1;
        this.lastSentFrameTimeStamp = -1;
        this.frameSynchronized = new Object();
        this.isConnected = false;
        this.isAudioEnabled = true;
        this.audioFrameList = new ArrayList<>();
        this.videoFrameList = new ArrayList<>();
        this.mLastReceivedVideoFrameTimeStamp = -1;
        this.mLastReceivedAudioFrameTimeStamp = -1;
        this.lastSentFrameTimeStamp = -1;
    }

    public int open(String url) {
        this.frameCount = 0;
        this.bytesInQueue = 0L;
        this.lastVideoFrameTimeStamp = 0;
        this.lastAudioFrameTimeStamp = 0;
        this.mLastReceivedVideoFrameTimeStamp = -1;
        this.mLastReceivedAudioFrameTimeStamp = -1;
        this.lastSentFrameTimeStamp = -1;
        this.isConnected = false;
        int iOpen = this.rtmpMuxer.open(url, 135, 240);
        if (iOpen > 0) {
            this.isConnected = true;
        }
        return iOpen;
    }

    public void close() {
        Log.i(TAG, "close rtmp connection");
        this.isConnected = false;
        this.rtmpMuxer.close();
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        int i;
        int i2;
        int i3 = msg.what;
        if (i3 == 0) {
            int i4 = msg.arg2;
            if (i4 >= this.mLastReceivedAudioFrameTimeStamp && (i = msg.arg1) > 0) {
                this.mLastReceivedAudioFrameTimeStamp = i4;
                if (!this.isAudioEnabled) {
                    msg.obj = this.pcmBufferMuted;
                }
                this.audioFrameList.add(new Frame((byte[]) msg.obj, i, i4));
            } else {
                Log.w(TAG, "discarding audio packet because time stamp is older than last packet or data lenth equal to zero");
            }
            sendFrames();
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            finishframes();
            close();
            return;
        }
        int i5 = msg.arg2;
        if (i5 >= this.mLastReceivedVideoFrameTimeStamp && (i2 = msg.arg1) > 0) {
            this.mLastReceivedVideoFrameTimeStamp = i5;
            this.videoFrameList.add(new Frame((byte[]) msg.obj, i2, i5));
        } else {
            Log.w(TAG, "discarding videp packet because time stamp is older  than last packet or data lenth equal to zero");
        }
        sendFrames();
    }

    private void finishframes() {
        int size;
        int size2;
        do {
            sendFrames();
            size = this.videoFrameList.size();
            size2 = this.audioFrameList.size();
            if (size <= 0) {
                break;
            }
        } while (size2 > 0);
        if (size > 0) {
            sendVideoFrames(this.videoFrameList.get(size - 1).timestamp);
        } else if (size2 > 0) {
            sendAudioFrames(this.audioFrameList.get(size2 - 1).timestamp);
        }
    }

    private void sendFrames() {
        if (this.videoFrameList.size() > 0) {
            sendAudioFrames(this.videoFrameList.get(0).timestamp);
        }
        if (this.audioFrameList.size() > 0) {
            sendVideoFrames(this.audioFrameList.get(0).timestamp);
        }
    }

    private void sendAudioFrames(int timestamp) {
        Frame next;
        int i;
        Iterator<Frame> it = this.audioFrameList.iterator();
        while (it.hasNext() && (i = (next = it.next()).timestamp) <= timestamp) {
            int i2 = this.lastSentFrameTimeStamp;
            if (i >= i2) {
                if (i == i2) {
                    next.timestamp = i + 1;
                }
                if (this.isConnected && this.rtmpMuxer.writeAudio(next.data, 0, next.length, next.timestamp) < 0) {
                    close();
                }
                int i3 = next.timestamp;
                this.lastAudioFrameTimeStamp = i3;
                this.lastSentFrameTimeStamp = i3;
                synchronized (this.frameSynchronized) {
                    this.frameCount--;
                    this.bytesInQueue -= next.data.length;
                }
            }
            it.remove();
        }
    }

    private void sendVideoFrames(int timestamp) {
        Frame next;
        int i;
        Iterator<Frame> it = this.videoFrameList.iterator();
        while (it.hasNext() && (i = (next = it.next()).timestamp) <= timestamp) {
            int i2 = this.lastSentFrameTimeStamp;
            if (i >= i2) {
                if (i == i2) {
                    next.timestamp = i + 1;
                }
                if (this.isConnected && this.rtmpMuxer.writeVideo(next.data, 0, next.length, next.timestamp) < 0) {
                    close();
                }
                int i3 = next.timestamp;
                this.lastVideoFrameTimeStamp = i3;
                this.lastSentFrameTimeStamp = i3;
                synchronized (this.frameSynchronized) {
                    this.frameCount--;
                    this.bytesInQueue -= next.data.length;
                }
            }
            it.remove();
        }
    }

    @Override // io.antmedia.android.broadcaster.network.IMediaMuxer
    public int getLastAudioFrameTimeStamp() {
        return this.lastAudioFrameTimeStamp;
    }

    @Override // io.antmedia.android.broadcaster.network.IMediaMuxer
    public int getLastVideoFrameTimeStamp() {
        return this.lastVideoFrameTimeStamp;
    }

    public boolean isConnected() {
        return this.isConnected;
    }

    @Override // io.antmedia.android.broadcaster.network.IMediaMuxer
    public void writeAudio(byte[] data, int size, int presentationTime) {
        Message messageObtainMessage = obtainMessage(0, data);
        messageObtainMessage.arg1 = size;
        messageObtainMessage.arg2 = presentationTime;
        sendMessage(messageObtainMessage);
        synchronized (this.frameSynchronized) {
            this.frameCount++;
            this.bytesInQueue += data.length;
        }
    }

    @Override // io.antmedia.android.broadcaster.network.IMediaMuxer
    public void writeVideo(byte[] data, int length, int presentationTime) {
        Message messageObtainMessage = obtainMessage(1, data);
        messageObtainMessage.arg1 = length;
        messageObtainMessage.arg2 = presentationTime;
        sendMessage(messageObtainMessage);
        synchronized (this.frameSynchronized) {
            this.frameCount++;
            this.bytesInQueue += data.length;
        }
        this.mLastVideoFrameTimeStampInQueue = presentationTime;
    }

    @Override // io.antmedia.android.broadcaster.network.IMediaMuxer
    public void stopMuxer() {
        sendEmptyMessage(2);
    }

    public int getLastVideoFrameTimeStampInQueue() {
        return this.mLastVideoFrameTimeStampInQueue;
    }
}
