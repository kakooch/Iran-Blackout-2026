package ir.appp.rghapp.video;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.googlecode.mp4parser.util.Matrix;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class Mp4Movie {
    private File cacheFile;
    private Matrix matrix = Matrix.ROTATE_0;
    private ArrayList<Track> tracks = new ArrayList<>();

    public void setSize(int i, int i2) {
    }

    public Matrix getMatrix() {
        return this.matrix;
    }

    public void setCacheFile(File file) {
        this.cacheFile = file;
    }

    public void setRotation(int i) {
        if (i == 0) {
            this.matrix = Matrix.ROTATE_0;
            return;
        }
        if (i == 90) {
            this.matrix = Matrix.ROTATE_90;
        } else if (i == 180) {
            this.matrix = Matrix.ROTATE_180;
        } else if (i == 270) {
            this.matrix = Matrix.ROTATE_270;
        }
    }

    public ArrayList<Track> getTracks() {
        return this.tracks;
    }

    public File getCacheFile() {
        return this.cacheFile;
    }

    public void addSample(int i, long j, MediaCodec.BufferInfo bufferInfo) {
        if (i < 0 || i >= this.tracks.size()) {
            return;
        }
        this.tracks.get(i).addSample(j, bufferInfo);
    }

    public int addTrack(MediaFormat mediaFormat, boolean z) {
        this.tracks.add(new Track(this.tracks.size(), mediaFormat, z));
        return this.tracks.size() - 1;
    }

    public long getLastFrameTimestamp(int i) {
        if (i < 0 || i >= this.tracks.size()) {
            return 0L;
        }
        return this.tracks.get(i).getLastFrameTimestamp();
    }
}
