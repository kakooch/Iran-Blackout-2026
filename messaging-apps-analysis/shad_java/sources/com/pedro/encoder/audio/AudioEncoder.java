package com.pedro.encoder.audio;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import com.pedro.encoder.BaseEncoder;
import com.pedro.encoder.Frame;
import com.pedro.encoder.input.audio.GetMicrophoneData;
import com.pedro.encoder.utils.CodecUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.rbmain.messenger.MediaController;

/* loaded from: classes3.dex */
public class AudioEncoder extends BaseEncoder implements GetMicrophoneData {
    private GetAacData getAacData;

    @Override // com.pedro.encoder.BaseEncoder
    protected void checkBuffer(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
    }

    @Override // com.pedro.encoder.BaseEncoder
    protected Frame getInputFrame() throws InterruptedException {
        return null;
    }

    public AudioEncoder(GetAacData getAacData) {
        this.getAacData = getAacData;
    }

    public boolean prepareAudioEncoder(int i, int i2, boolean z, int i3) {
        this.isBufferMode = true;
        try {
            List arrayList = new ArrayList();
            CodecUtil.Force force = this.force;
            if (force == CodecUtil.Force.HARDWARE) {
                arrayList = CodecUtil.getAllHardwareEncoders(MediaController.AUIDO_MIME_TYPE);
            } else if (force == CodecUtil.Force.SOFTWARE) {
                arrayList = CodecUtil.getAllSoftwareEncoders(MediaController.AUIDO_MIME_TYPE);
            }
            if (this.force == CodecUtil.Force.FIRST_COMPATIBLE_FOUND) {
                MediaCodecInfo mediaCodecInfoChooseEncoder = chooseEncoder(MediaController.AUIDO_MIME_TYPE);
                if (mediaCodecInfoChooseEncoder != null) {
                    this.codec = MediaCodec.createByCodecName(mediaCodecInfoChooseEncoder.getName());
                } else {
                    Log.e("AudioEncoder", "Valid encoder not found");
                    return false;
                }
            } else {
                if (arrayList.isEmpty()) {
                    Log.e("AudioEncoder", "Valid encoder not found");
                    return false;
                }
                this.codec = MediaCodec.createByCodecName(((MediaCodecInfo) arrayList.get(0)).getName());
            }
            MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat(MediaController.AUIDO_MIME_TYPE, i2, z ? 2 : 1);
            mediaFormatCreateAudioFormat.setInteger("bitrate", i);
            mediaFormatCreateAudioFormat.setInteger("max-input-size", i3);
            mediaFormatCreateAudioFormat.setInteger("aac-profile", 2);
            this.codec.configure(mediaFormatCreateAudioFormat, (Surface) null, (MediaCrypto) null, 1);
            this.running = false;
            Log.i("AudioEncoder", "prepared");
            return true;
        } catch (IOException | IllegalStateException e) {
            Log.e("AudioEncoder", "Create AudioEncoder failed.", e);
            return false;
        }
    }

    @Override // com.pedro.encoder.BaseEncoder
    public void start(boolean z) {
        this.presentTimeUs = System.nanoTime() / 1000;
        this.codec.start();
        this.running = true;
        Log.i("AudioEncoder", "started");
    }

    @Override // com.pedro.encoder.BaseEncoder
    protected void stopImp() {
        Log.i("AudioEncoder", "stopped");
    }

    @Override // com.pedro.encoder.BaseEncoder
    protected void sendBuffer(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        this.getAacData.getAacData(byteBuffer, bufferInfo);
    }

    @Override // com.pedro.encoder.input.audio.GetMicrophoneData
    public void inputPCMData(Frame frame) throws MediaCodec.CryptoException {
        if (this.running) {
            try {
                getDataFromEncoder(frame);
                return;
            } catch (IllegalStateException e) {
                Log.i("AudioEncoder", "Encoding error", e);
                return;
            }
        }
        Log.i("AudioEncoder", "frame discarded");
    }

    protected MediaCodecInfo chooseEncoder(String str) {
        List<MediaCodecInfo> allEncoders = CodecUtil.getAllEncoders(str);
        for (MediaCodecInfo mediaCodecInfo : allEncoders) {
            if (!mediaCodecInfo.getName().toLowerCase().contains("omx.google")) {
                return mediaCodecInfo;
            }
        }
        if (allEncoders.size() > 0) {
            return allEncoders.get(0);
        }
        return null;
    }

    @Override // com.pedro.encoder.EncoderCallback
    public void formatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        this.getAacData.onAudioFormat(mediaFormat);
    }
}
