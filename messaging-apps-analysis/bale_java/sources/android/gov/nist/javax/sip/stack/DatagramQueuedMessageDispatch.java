package android.gov.nist.javax.sip.stack;

import java.net.DatagramPacket;

/* loaded from: classes.dex */
public class DatagramQueuedMessageDispatch implements QueuedMessageDispatchBase {
    public DatagramPacket packet;
    long time;

    public DatagramQueuedMessageDispatch(DatagramPacket datagramPacket, long j) {
        this.time = j;
        this.packet = datagramPacket;
    }

    @Override // android.gov.nist.javax.sip.stack.QueuedMessageDispatchBase
    public long getReceptionTime() {
        return this.time;
    }

    @Override // java.lang.Runnable
    public void run() {
    }
}
