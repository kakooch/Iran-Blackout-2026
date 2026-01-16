package com.google.ads.interactivemedia.v3.internal;

import android.os.SystemClock;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aen {
    private static final Object a = new Object();
    private static final Object b = new Object();
    private static boolean c = false;
    private static long d = 0;
    private static final String e = "time.android.com";

    public static boolean a() {
        boolean z;
        synchronized (b) {
            z = c;
        }
        return z;
    }

    public static long b() {
        long j;
        synchronized (b) {
            j = c ? d : -9223372036854775807L;
        }
        return j;
    }

    public static void c(ada adaVar, aek aekVar) {
        if (a()) {
            aekVar.a();
            return;
        }
        if (adaVar == null) {
            adaVar = new ada("SntpClient");
        }
        adaVar.e(new aem(null), new ael(aekVar), 1);
    }

    static /* synthetic */ long g() throws Throwable {
        String str;
        long j;
        synchronized (b) {
            str = e;
        }
        InetAddress byName = InetAddress.getByName(str);
        DatagramSocket datagramSocket = new DatagramSocket();
        try {
            datagramSocket.setSoTimeout(10000);
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, byName, 123);
            bArr[0] = 27;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jCurrentTimeMillis == 0) {
                Arrays.fill(bArr, 40, 48, (byte) 0);
                j = jCurrentTimeMillis;
            } else {
                long j2 = jCurrentTimeMillis / 1000;
                Long.signum(j2);
                long j3 = jCurrentTimeMillis - (j2 * 1000);
                long j4 = j2 + 2208988800L;
                j = jCurrentTimeMillis;
                bArr[40] = (byte) (j4 >> 24);
                try {
                    bArr[41] = (byte) (j4 >> 16);
                } catch (Throwable th) {
                    th = th;
                    datagramSocket = datagramSocket;
                }
                try {
                    bArr[42] = (byte) (j4 >> 8);
                    bArr[43] = (byte) j4;
                    long j5 = (j3 * 4294967296L) / 1000;
                    bArr[44] = (byte) (j5 >> 24);
                    bArr[45] = (byte) (j5 >> 16);
                    bArr[46] = (byte) (j5 >> 8);
                    bArr[47] = (byte) (Math.random() * 255.0d);
                    datagramSocket = datagramSocket;
                } catch (Throwable th2) {
                    th = th2;
                    datagramSocket = datagramSocket;
                    Throwable th3 = th;
                    try {
                        datagramSocket.close();
                        throw th3;
                    } catch (Throwable th4) {
                        auf.a(th3, th4);
                        throw th3;
                    }
                }
            }
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(bArr, 48));
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            long j6 = j + (jElapsedRealtime2 - jElapsedRealtime);
            byte b2 = bArr[0];
            int i = (b2 >> 6) & 3;
            int i2 = b2 & 7;
            int i3 = bArr[1] & 255;
            long j7 = j(bArr, 24);
            long j8 = j(bArr, 32);
            long j9 = j(bArr, 40);
            if (i == 3) {
                throw new IOException("SNTP: Unsynchronized server");
            }
            if (i2 != 4 && i2 != 5) {
                StringBuilder sb = new StringBuilder(26);
                sb.append("SNTP: Untrusted mode: ");
                sb.append(i2);
                throw new IOException(sb.toString());
            }
            if (i3 == 0 || i3 > 15) {
                StringBuilder sb2 = new StringBuilder(36);
                sb2.append("SNTP: Untrusted stratum: ");
                sb2.append(i3);
                throw new IOException(sb2.toString());
            }
            if (j9 == 0) {
                throw new IOException("SNTP: Zero transmitTime");
            }
            long j10 = ((j8 - j7) + (j9 - j6)) / 2;
            datagramSocket.close();
            return (j6 + j10) - jElapsedRealtime2;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    private static long j(byte[] bArr, int i) {
        long jK = k(bArr, i);
        long jK2 = k(bArr, i + 4);
        if (jK == 0 && jK2 == 0) {
            return 0L;
        }
        return ((jK - 2208988800L) * 1000) + ((jK2 * 1000) / 4294967296L);
    }

    private static long k(byte[] bArr, int i) {
        int i2 = bArr[i];
        int i3 = bArr[i + 1];
        int i4 = bArr[i + 2];
        int i5 = bArr[i + 3];
        if ((i2 & 128) == 128) {
            i2 = (i2 & 127) + 128;
        }
        if ((i3 & 128) == 128) {
            i3 = (i3 & 127) + 128;
        }
        if ((i4 & 128) == 128) {
            i4 = (i4 & 127) + 128;
        }
        if ((i5 & 128) == 128) {
            i5 = (i5 & 127) + 128;
        }
        return (i2 << 24) + (i3 << 16) + (i4 << 8) + i5;
    }
}
