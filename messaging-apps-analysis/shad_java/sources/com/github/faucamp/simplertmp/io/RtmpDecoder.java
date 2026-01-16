package com.github.faucamp.simplertmp.io;

import android.util.Log;
import com.github.faucamp.simplertmp.packets.Abort;
import com.github.faucamp.simplertmp.packets.Acknowledgement;
import com.github.faucamp.simplertmp.packets.Audio;
import com.github.faucamp.simplertmp.packets.Command;
import com.github.faucamp.simplertmp.packets.Data;
import com.github.faucamp.simplertmp.packets.RtmpHeader;
import com.github.faucamp.simplertmp.packets.RtmpPacket;
import com.github.faucamp.simplertmp.packets.SetChunkSize;
import com.github.faucamp.simplertmp.packets.SetPeerBandwidth;
import com.github.faucamp.simplertmp.packets.UserControl;
import com.github.faucamp.simplertmp.packets.Video;
import com.github.faucamp.simplertmp.packets.WindowAckSize;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class RtmpDecoder {
    private RtmpSessionInfo rtmpSessionInfo;

    public RtmpDecoder(RtmpSessionInfo rtmpSessionInfo) {
        this.rtmpSessionInfo = rtmpSessionInfo;
    }

    public RtmpPacket readPacket(InputStream inputStream) throws IOException {
        RtmpPacket abort;
        RtmpHeader header = RtmpHeader.readHeader(inputStream, this.rtmpSessionInfo);
        ChunkStreamInfo chunkStreamInfo = this.rtmpSessionInfo.getChunkStreamInfo(header.getChunkStreamId());
        chunkStreamInfo.setPrevHeaderRx(header);
        if (header.getPacketLength() > this.rtmpSessionInfo.getRxChunkSize()) {
            if (!chunkStreamInfo.storePacketChunk(inputStream, this.rtmpSessionInfo.getRxChunkSize())) {
                return null;
            }
            inputStream = chunkStreamInfo.getStoredPacketInputStream();
        }
        switch (AnonymousClass1.$SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$MessageType[header.getMessageType().ordinal()]) {
            case 1:
                SetChunkSize setChunkSize = new SetChunkSize(header);
                setChunkSize.readBody(inputStream);
                Log.d("RtmpDecoder", "readPacket(): Setting chunk size to: " + setChunkSize.getChunkSize());
                this.rtmpSessionInfo.setRxChunkSize(setChunkSize.getChunkSize());
                return null;
            case 2:
                abort = new Abort(header);
                break;
            case 3:
                abort = new UserControl(header);
                break;
            case 4:
                abort = new WindowAckSize(header);
                break;
            case 5:
                abort = new SetPeerBandwidth(header);
                break;
            case 6:
                abort = new Audio(header);
                break;
            case 7:
                abort = new Video(header);
                break;
            case 8:
                abort = new Command(header);
                break;
            case 9:
                abort = new Data(header);
                break;
            case 10:
                abort = new Acknowledgement(header);
                break;
            default:
                throw new IOException("No packet body implementation for message type: " + header.getMessageType());
        }
        abort.readBody(inputStream);
        return abort;
    }

    /* renamed from: com.github.faucamp.simplertmp.io.RtmpDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$MessageType;

        static {
            int[] iArr = new int[RtmpHeader.MessageType.values().length];
            $SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$MessageType = iArr;
            try {
                iArr[RtmpHeader.MessageType.SET_CHUNK_SIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$MessageType[RtmpHeader.MessageType.ABORT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$MessageType[RtmpHeader.MessageType.USER_CONTROL_MESSAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$MessageType[RtmpHeader.MessageType.WINDOW_ACKNOWLEDGEMENT_SIZE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$MessageType[RtmpHeader.MessageType.SET_PEER_BANDWIDTH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$MessageType[RtmpHeader.MessageType.AUDIO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$MessageType[RtmpHeader.MessageType.VIDEO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$MessageType[RtmpHeader.MessageType.COMMAND_AMF0.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$MessageType[RtmpHeader.MessageType.DATA_AMF0.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$github$faucamp$simplertmp$packets$RtmpHeader$MessageType[RtmpHeader.MessageType.ACKNOWLEDGEMENT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }
}
