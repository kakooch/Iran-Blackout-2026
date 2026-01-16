package org.webrtc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class MediaStream {
    private static final String TAG = "MediaStream";
    private long nativeStream;
    public final List<AudioTrack> audioTracks = new ArrayList();
    public final List<VideoTrack> videoTracks = new ArrayList();
    public final List<VideoTrack> preservedVideoTracks = new ArrayList();

    private static native boolean nativeAddAudioTrackToNativeStream(long stream, long nativeAudioTrack);

    private static native boolean nativeAddVideoTrackToNativeStream(long stream, long nativeVideoTrack);

    private static native String nativeGetId(long stream);

    private static native boolean nativeRemoveAudioTrack(long stream, long nativeAudioTrack);

    private static native boolean nativeRemoveVideoTrack(long stream, long nativeVideoTrack);

    @CalledByNative
    public MediaStream(long nativeStream) {
        this.nativeStream = nativeStream;
    }

    public boolean addTrack(AudioTrack track) {
        checkMediaStreamExists();
        if (!nativeAddAudioTrackToNativeStream(this.nativeStream, track.getNativeAudioTrack())) {
            return false;
        }
        this.audioTracks.add(track);
        return true;
    }

    public boolean addTrack(VideoTrack track) {
        checkMediaStreamExists();
        if (!nativeAddVideoTrackToNativeStream(this.nativeStream, track.getNativeVideoTrack())) {
            return false;
        }
        this.videoTracks.add(track);
        return true;
    }

    public boolean addPreservedTrack(VideoTrack track) {
        checkMediaStreamExists();
        if (!nativeAddVideoTrackToNativeStream(this.nativeStream, track.getNativeVideoTrack())) {
            return false;
        }
        this.preservedVideoTracks.add(track);
        return true;
    }

    public boolean removeTrack(AudioTrack track) {
        checkMediaStreamExists();
        this.audioTracks.remove(track);
        return nativeRemoveAudioTrack(this.nativeStream, track.getNativeAudioTrack());
    }

    public boolean removeTrack(VideoTrack track) {
        checkMediaStreamExists();
        this.videoTracks.remove(track);
        this.preservedVideoTracks.remove(track);
        return nativeRemoveVideoTrack(this.nativeStream, track.getNativeVideoTrack());
    }

    @CalledByNative
    public void dispose() {
        checkMediaStreamExists();
        while (!this.audioTracks.isEmpty()) {
            AudioTrack audioTrack = this.audioTracks.get(0);
            removeTrack(audioTrack);
            audioTrack.dispose();
        }
        while (!this.videoTracks.isEmpty()) {
            VideoTrack videoTrack = this.videoTracks.get(0);
            removeTrack(videoTrack);
            videoTrack.dispose();
        }
        while (!this.preservedVideoTracks.isEmpty()) {
            removeTrack(this.preservedVideoTracks.get(0));
        }
        JniCommon.nativeReleaseRef(this.nativeStream);
        this.nativeStream = 0L;
    }

    public String getId() {
        checkMediaStreamExists();
        return nativeGetId(this.nativeStream);
    }

    public String toString() {
        return "[" + getId() + ":A=" + this.audioTracks.size() + ":V=" + this.videoTracks.size() + "]";
    }

    @CalledByNative
    void addNativeAudioTrack(long nativeTrack) {
        this.audioTracks.add(new AudioTrack(nativeTrack));
    }

    @CalledByNative
    void addNativeVideoTrack(long nativeTrack) {
        this.videoTracks.add(new VideoTrack(nativeTrack));
    }

    @CalledByNative
    void removeAudioTrack(long nativeTrack) {
        removeMediaStreamTrack(this.audioTracks, nativeTrack);
    }

    @CalledByNative
    void removeVideoTrack(long nativeTrack) {
        removeMediaStreamTrack(this.videoTracks, nativeTrack);
    }

    long getNativeMediaStream() {
        checkMediaStreamExists();
        return this.nativeStream;
    }

    private void checkMediaStreamExists() {
        if (this.nativeStream == 0) {
            throw new IllegalStateException("MediaStream has been disposed.");
        }
    }

    private static void removeMediaStreamTrack(List<? extends MediaStreamTrack> tracks, long nativeTrack) {
        Iterator<? extends MediaStreamTrack> it = tracks.iterator();
        while (it.hasNext()) {
            MediaStreamTrack next = it.next();
            if (next.getNativeMediaStreamTrack() == nativeTrack) {
                next.dispose();
                it.remove();
                return;
            }
        }
        Logging.e(TAG, "Couldn't not find track");
    }
}
