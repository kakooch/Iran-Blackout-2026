package com.google.android.gms.vision.face;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.internal.vision.zzm;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.zzc;
import java.nio.ByteBuffer;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class FaceDetector extends Detector<Face> {
    private final Object lock;
    private final zzc zzbv;

    @GuardedBy("lock")
    private final com.google.android.gms.vision.face.internal.client.zza zzbw;

    @GuardedBy("lock")
    private boolean zzbx;

    public static class Builder {
        private final Context zze;
        private int zzby = 0;
        private boolean zzbz = false;
        private int zzca = 0;
        private boolean zzcb = true;
        private int mode = 0;
        private float zzcc = -1.0f;

        public Builder(Context context) {
            this.zze = context;
        }

        public FaceDetector build() {
            com.google.android.gms.vision.face.internal.client.zzc zzcVar = new com.google.android.gms.vision.face.internal.client.zzc();
            zzcVar.mode = this.mode;
            zzcVar.zzby = this.zzby;
            zzcVar.zzca = this.zzca;
            zzcVar.zzbz = this.zzbz;
            zzcVar.zzcb = this.zzcb;
            zzcVar.zzcc = this.zzcc;
            return new FaceDetector(new com.google.android.gms.vision.face.internal.client.zza(this.zze, zzcVar));
        }

        public Builder setLandmarkType(int i) {
            if (i == 0 || i == 1) {
                this.zzby = i;
                return this;
            }
            StringBuilder sb = new StringBuilder(34);
            sb.append("Invalid landmark type: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder setMode(int i) {
            if (i == 0 || i == 1) {
                this.mode = i;
                return this;
            }
            StringBuilder sb = new StringBuilder(25);
            sb.append("Invalid mode: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder setTrackingEnabled(boolean z) {
            this.zzcb = z;
            return this;
        }
    }

    private FaceDetector(com.google.android.gms.vision.face.internal.client.zza zzaVar) {
        this.zzbv = new zzc();
        this.lock = new Object();
        this.zzbx = true;
        this.zzbw = zzaVar;
    }

    public final SparseArray<Face> detect(Frame frame) {
        Face[] faceArrZzb;
        if (frame == null) {
            throw new IllegalArgumentException("No frame supplied.");
        }
        ByteBuffer grayscaleImageData = frame.getGrayscaleImageData();
        synchronized (this.lock) {
            if (!this.zzbx) {
                throw new RuntimeException("Cannot use detector after release()");
            }
            faceArrZzb = this.zzbw.zzb(grayscaleImageData, zzm.zzc(frame));
        }
        HashSet hashSet = new HashSet();
        SparseArray<Face> sparseArray = new SparseArray<>(faceArrZzb.length);
        int iMax = 0;
        for (Face face : faceArrZzb) {
            int id = face.getId();
            iMax = Math.max(iMax, id);
            if (hashSet.contains(Integer.valueOf(id))) {
                id = iMax + 1;
                iMax = id;
            }
            hashSet.add(Integer.valueOf(id));
            sparseArray.append(this.zzbv.zzb(id), face);
        }
        return sparseArray;
    }

    protected final void finalize() throws Throwable {
        try {
            synchronized (this.lock) {
                if (this.zzbx) {
                    Log.w("FaceDetector", "FaceDetector was not released with FaceDetector.release()");
                    release();
                }
            }
        } finally {
            super.finalize();
        }
    }

    public final boolean isOperational() {
        return this.zzbw.isOperational();
    }

    @Override // com.google.android.gms.vision.Detector
    public final void release() {
        super.release();
        synchronized (this.lock) {
            if (this.zzbx) {
                this.zzbw.zzo();
                this.zzbx = false;
            }
        }
    }
}
