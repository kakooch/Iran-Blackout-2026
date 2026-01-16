package com.github.faucamp.simplertmp.io;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Map;
import org.rbmain.tgnet.ConnectionsManager;

/* loaded from: classes.dex */
public class RtmpSessionInfo {
    private int acknowledgementWindowSize = ConnectionsManager.DEFAULT_DATACENTER_ID;
    private int rxChunkSize = 128;
    private int txChunkSize = 128;
    private Map<Integer, ChunkStreamInfo> chunkChannels = new HashMap();
    private Map<Integer, String> invokedMethods = new ConcurrentHashMap();

    public ChunkStreamInfo getChunkStreamInfo(int i) {
        ChunkStreamInfo chunkStreamInfo = this.chunkChannels.get(Integer.valueOf(i));
        if (chunkStreamInfo != null) {
            return chunkStreamInfo;
        }
        ChunkStreamInfo chunkStreamInfo2 = new ChunkStreamInfo();
        this.chunkChannels.put(Integer.valueOf(i), chunkStreamInfo2);
        return chunkStreamInfo2;
    }

    public String takeInvokedCommand(int i) {
        return this.invokedMethods.remove(Integer.valueOf(i));
    }

    public String addInvokedCommand(int i, String str) {
        return this.invokedMethods.put(Integer.valueOf(i), str);
    }

    public int getRxChunkSize() {
        return this.rxChunkSize;
    }

    public void setRxChunkSize(int i) {
        this.rxChunkSize = i;
    }

    public int getTxChunkSize() {
        return this.txChunkSize;
    }

    public int getAcknowledgementWindowSize() {
        return this.acknowledgementWindowSize;
    }

    public void setAcknowledgmentWindowSize(int i) {
        this.acknowledgementWindowSize = i;
    }
}
