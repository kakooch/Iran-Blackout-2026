package org.xbill.DNS.tools;

import android.gov.nist.core.Separators;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.xbill.DNS.CNAMERecord;
import org.xbill.DNS.Cache;
import org.xbill.DNS.DNAMERecord;
import org.xbill.DNS.Header;
import org.xbill.DNS.Message;
import org.xbill.DNS.Name;
import org.xbill.DNS.NameTooLongException;
import org.xbill.DNS.OPTRecord;
import org.xbill.DNS.RRSIGRecord;
import org.xbill.DNS.RRset;
import org.xbill.DNS.Record;
import org.xbill.DNS.SetResponse;
import org.xbill.DNS.TSIG;
import org.xbill.DNS.TSIGRecord;
import org.xbill.DNS.Type;
import org.xbill.DNS.Zone;
import org.xbill.DNS.ZoneTransferException;

/* loaded from: classes8.dex */
public class jnamed {
    static final int FLAG_DNSSECOK = 1;
    static final int FLAG_SIGONLY = 2;
    Map<Integer, Cache> caches;
    Map<Name, TSIG> tsigs;
    Map<Name, Zone> znames;

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public jnamed(java.lang.String r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.tools.jnamed.<init>(java.lang.String):void");
    }

    private void addAdditional(Message message, int i) {
        addAdditional2(message, 1, i);
        addAdditional2(message, 2, i);
    }

    private void addAdditional2(Message message, int i, int i2) {
        Iterator<Record> it = message.getSection(i).iterator();
        while (it.hasNext()) {
            Name additionalName = it.next().getAdditionalName();
            if (additionalName != null) {
                addGlue(message, additionalName, i2);
            }
        }
    }

    private void addCacheNS(Message message, Cache cache, Name name) {
        SetResponse setResponseLookupRecords = cache.lookupRecords(name, 2, 0);
        if (setResponseLookupRecords.isDelegation()) {
            Iterator<Record> it = setResponseLookupRecords.getNS().rrs().iterator();
            while (it.hasNext()) {
                message.addRecord(it.next(), 2);
            }
        }
    }

    private void addGlue(Message message, Name name, int i) {
        RRset rRsetFindExactMatch = findExactMatch(name, 1, 1, true);
        if (rRsetFindExactMatch == null) {
            return;
        }
        addRRset(name, message, rRsetFindExactMatch, 3, i);
    }

    private void addNS(Message message, Zone zone, int i) {
        RRset ns = zone.getNS();
        addRRset(ns.getName(), message, ns, 2, i);
    }

    private void addSOA(Message message, Zone zone) {
        message.addRecord(zone.getSOA(), 2);
    }

    private static String addrport(InetAddress inetAddress, int i) {
        return inetAddress.getHostAddress() + Separators.POUND + i;
    }

    public static void main(String[] strArr) {
        if (strArr.length > 1) {
            System.out.println("usage: jnamed [conf]");
            System.exit(0);
        }
        try {
            new jnamed(strArr.length == 1 ? strArr[0] : "jnamed.conf");
        } catch (IOException e) {
            e = e;
            System.out.println(e);
        } catch (ZoneTransferException e2) {
            e = e2;
            System.out.println(e);
        }
    }

    /* renamed from: TCPclient, reason: merged with bridge method [inline-methods] */
    public void lambda$serveTCP$0(Socket socket) throws IOException {
        byte[] bArrFormerrMessage;
        try {
            InputStream inputStream = socket.getInputStream();
            try {
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                byte[] bArr = new byte[dataInputStream.readUnsignedShort()];
                dataInputStream.readFully(bArr);
                try {
                    bArrFormerrMessage = generateReply(new Message(bArr), bArr, socket);
                    if (bArrFormerrMessage == null) {
                        if (inputStream != null) {
                            inputStream.close();
                            return;
                        }
                        return;
                    }
                } catch (IOException unused) {
                    bArrFormerrMessage = formerrMessage(bArr);
                }
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeShort(bArrFormerrMessage.length);
                dataOutputStream.write(bArrFormerrMessage);
                if (inputStream != null) {
                    inputStream.close();
                }
            } finally {
            }
        } catch (IOException e) {
            System.out.println("TCPclient(" + addrport(socket.getLocalAddress(), socket.getLocalPort()) + "): " + e);
        }
    }

    byte addAnswer(Message message, Name name, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (i3 > 6) {
            return (byte) 0;
        }
        if (i == 24 || i == 46) {
            i5 = i4 | 2;
            i6 = 255;
        } else {
            i5 = i4;
            i6 = i;
        }
        Zone zoneFindBestZone = findBestZone(name);
        SetResponse setResponseFindRecords = zoneFindBestZone != null ? zoneFindBestZone.findRecords(name, i6) : getCache(i2).lookupRecords(name, i6, 3);
        if (setResponseFindRecords.isUnknown()) {
            addCacheNS(message, getCache(i2), name);
        }
        if (setResponseFindRecords.isNXDOMAIN()) {
            message.getHeader().setRcode(3);
            if (zoneFindBestZone != null) {
                addSOA(message, zoneFindBestZone);
                if (i3 == 0) {
                    message.getHeader().setFlag(5);
                }
            }
            return (byte) 3;
        }
        if (setResponseFindRecords.isNXRRSET()) {
            if (zoneFindBestZone == null) {
                return (byte) 0;
            }
            addSOA(message, zoneFindBestZone);
            if (i3 != 0) {
                return (byte) 0;
            }
            message.getHeader().setFlag(5);
            return (byte) 0;
        }
        if (setResponseFindRecords.isDelegation()) {
            RRset ns = setResponseFindRecords.getNS();
            addRRset(ns.getName(), message, ns, 2, i5);
            return (byte) 0;
        }
        if (setResponseFindRecords.isCNAME()) {
            CNAMERecord cname = setResponseFindRecords.getCNAME();
            addRRset(name, message, new RRset(cname), 1, i5);
            if (zoneFindBestZone != null && i3 == 0) {
                message.getHeader().setFlag(5);
            }
            return addAnswer(message, cname.getTarget(), i6, i2, i3 + 1, i5);
        }
        if (setResponseFindRecords.isDNAME()) {
            DNAMERecord dname = setResponseFindRecords.getDNAME();
            addRRset(name, message, new RRset(dname), 1, i5);
            try {
                Name nameFromDNAME = name.fromDNAME(dname);
                addRRset(name, message, new RRset(new CNAMERecord(name, i2, 0L, nameFromDNAME)), 1, i5);
                if (zoneFindBestZone != null && i3 == 0) {
                    message.getHeader().setFlag(5);
                }
                return addAnswer(message, nameFromDNAME, i6, i2, i3 + 1, i5);
            } catch (NameTooLongException unused) {
                return (byte) 6;
            }
        }
        if (!setResponseFindRecords.isSuccessful()) {
            return (byte) 0;
        }
        Iterator<RRset> it = setResponseFindRecords.answers().iterator();
        while (it.hasNext()) {
            addRRset(name, message, it.next(), 1, i5);
        }
        if (zoneFindBestZone == null) {
            addCacheNS(message, getCache(i2), name);
            return (byte) 0;
        }
        addNS(message, zoneFindBestZone, i5);
        if (i3 != 0) {
            return (byte) 0;
        }
        message.getHeader().setFlag(5);
        return (byte) 0;
    }

    public void addPrimaryZone(String str, String str2) {
        Zone zone = new Zone(str != null ? Name.fromString(str, Name.root) : null, str2);
        this.znames.put(zone.getOrigin(), zone);
    }

    void addRRset(Name name, Message message, RRset rRset, int i, int i2) {
        for (int i3 = 1; i3 <= i; i3++) {
            if (message.findRRset(name, rRset.getType(), i3)) {
                return;
            }
        }
        if ((i2 & 2) == 0) {
            for (Record recordWithName : rRset.rrs()) {
                if (recordWithName.getName().isWild() && !name.isWild()) {
                    recordWithName = recordWithName.withName(name);
                }
                message.addRecord(recordWithName, i);
            }
        }
        if ((i2 & 3) != 0) {
            for (RRSIGRecord rRSIGRecordWithName : rRset.sigs()) {
                if (rRSIGRecordWithName.getName().isWild() && !name.isWild()) {
                    rRSIGRecordWithName = rRSIGRecordWithName.withName(name);
                }
                message.addRecord(rRSIGRecordWithName, i);
            }
        }
    }

    public void addSecondaryZone(String str, String str2) {
        Name nameFromString = Name.fromString(str, Name.root);
        this.znames.put(nameFromString, new Zone(nameFromString, 1, str2));
    }

    public void addTCP(final InetAddress inetAddress, final int i) {
        new Thread(new Runnable() { // from class: ir.nasim.ke8
            @Override // java.lang.Runnable
            public final void run() {
                this.a.lambda$addTCP$1(inetAddress, i);
            }
        }).start();
    }

    public void addTSIG(String str, String str2, String str3) {
        this.tsigs.put(Name.fromString(str2, Name.root), new TSIG(str, str2, str3));
    }

    public void addUDP(final InetAddress inetAddress, final int i) {
        new Thread(new Runnable() { // from class: ir.nasim.me8
            @Override // java.lang.Runnable
            public final void run() {
                this.a.lambda$addUDP$2(inetAddress, i);
            }
        }).start();
    }

    byte[] buildErrorMessage(Header header, int i, Record record) {
        Message message = new Message();
        message.setHeader(header);
        for (int i2 = 0; i2 < 4; i2++) {
            message.removeAllRecords(i2);
        }
        if (i == 2) {
            message.addRecord(record, 0);
        }
        header.setRcode(i);
        return message.toWire();
    }

    byte[] doAXFR(Name name, Message message, TSIG tsig, TSIGRecord tSIGRecord, Socket socket) throws IOException {
        Zone zone = this.znames.get(name);
        if (zone == null) {
            return errorMessage(message, 5);
        }
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            int id = message.getHeader().getID();
            Iterator<RRset> itAXFR = zone.AXFR();
            TSIGRecord tsig2 = tSIGRecord;
            boolean z = true;
            while (itAXFR.hasNext()) {
                RRset next = itAXFR.next();
                Message message2 = new Message(id);
                Header header = message2.getHeader();
                header.setFlag(0);
                header.setFlag(5);
                addRRset(next.getName(), message2, next, 1, 1);
                if (tsig != null) {
                    tsig.apply(message2, tsig2, z);
                    tsig2 = message2.getTSIG();
                }
                byte[] wire = message2.toWire();
                dataOutputStream.writeShort(wire.length);
                dataOutputStream.write(wire);
                z = false;
            }
        } catch (IOException unused) {
            System.out.println("AXFR failed");
        }
        try {
            socket.close();
            return null;
        } catch (IOException unused2) {
            return null;
        }
    }

    public byte[] errorMessage(Message message, int i) {
        return buildErrorMessage(message.getHeader(), i, message.getQuestion());
    }

    public Zone findBestZone(Name name) {
        Zone zone = this.znames.get(name);
        if (zone != null) {
            return zone;
        }
        int iLabels = name.labels();
        for (int i = 1; i < iLabels; i++) {
            Zone zone2 = this.znames.get(new Name(name, i));
            if (zone2 != null) {
                return zone2;
            }
        }
        return null;
    }

    public RRset findExactMatch(Name name, int i, int i2, boolean z) {
        Zone zoneFindBestZone = findBestZone(name);
        if (zoneFindBestZone != null) {
            return zoneFindBestZone.findExactMatch(name, i);
        }
        Cache cache = getCache(i2);
        List<RRset> listFindAnyRecords = z ? cache.findAnyRecords(name, i) : cache.findRecords(name, i);
        if (listFindAnyRecords == null) {
            return null;
        }
        return listFindAnyRecords.get(0);
    }

    public byte[] formerrMessage(byte[] bArr) {
        try {
            return buildErrorMessage(new Header(bArr), 1, null);
        } catch (IOException unused) {
            return null;
        }
    }

    byte[] generateReply(Message message, byte[] bArr, Socket socket) {
        TSIG tsig;
        int iMax;
        Header header = message.getHeader();
        if (header.getFlag(0)) {
            return null;
        }
        if (header.getRcode() != 0) {
            return errorMessage(message, 1);
        }
        if (header.getOpcode() != 0) {
            return errorMessage(message, 4);
        }
        Record question = message.getQuestion();
        TSIGRecord tsig2 = message.getTSIG();
        if (tsig2 != null) {
            TSIG tsig3 = this.tsigs.get(tsig2.getName());
            if (tsig3 == null || tsig3.verify(message, bArr, null) != 0) {
                return formerrMessage(bArr);
            }
            tsig = tsig3;
        } else {
            tsig = null;
        }
        OPTRecord opt = message.getOPT();
        if (socket != null) {
            iMax = 65535;
        } else {
            iMax = 512;
            if (opt != null) {
                iMax = Math.max(opt.getPayloadSize(), 512);
            }
        }
        int i = iMax;
        int i2 = (opt == null || (opt.getFlags() & 32768) == 0) ? 0 : 1;
        Message message2 = new Message(message.getHeader().getID());
        message2.getHeader().setFlag(0);
        if (message.getHeader().getFlag(7)) {
            message2.getHeader().setFlag(7);
        }
        message2.addRecord(question, 0);
        Name name = question.getName();
        int type = question.getType();
        int dClass = question.getDClass();
        if (type == 252 && socket != null) {
            return doAXFR(name, message, tsig, tsig2, socket);
        }
        if (!Type.isRR(type) && type != 255) {
            return errorMessage(message, 4);
        }
        int i3 = i2;
        byte bAddAnswer = addAnswer(message2, name, type, dClass, 0, i3);
        if (bAddAnswer != 0 && bAddAnswer != 3) {
            return errorMessage(message, bAddAnswer);
        }
        addAdditional(message2, i3);
        if (opt != null) {
            message2.addRecord(new OPTRecord(4096, bAddAnswer, 0, i3 == 1 ? 32768 : 0), 3);
        }
        message2.setTSIG(tsig, 0, tsig2);
        return message2.toWire(i);
    }

    public Cache getCache(int i) {
        return this.caches.computeIfAbsent(Integer.valueOf(i), new Function() { // from class: ir.nasim.ne8
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return new Cache(((Integer) obj).intValue());
            }
        });
    }

    /* renamed from: serveTCP, reason: merged with bridge method [inline-methods] */
    public void lambda$addTCP$1(InetAddress inetAddress, int i) {
        try {
            while (true) {
                try {
                    final Socket socketAccept = new ServerSocket(i, 128, inetAddress).accept();
                    new Thread(new Runnable() { // from class: ir.nasim.le8
                        @Override // java.lang.Runnable
                        public final void run() throws IOException {
                            this.a.lambda$serveTCP$0(socketAccept);
                        }
                    }).start();
                } finally {
                }
            }
        } catch (IOException e) {
            System.out.println("serveTCP(" + addrport(inetAddress, i) + "): " + e);
        }
    }

    /* renamed from: serveUDP, reason: merged with bridge method [inline-methods] */
    public void lambda$addUDP$2(InetAddress inetAddress, int i) {
        byte[] bArrFormerrMessage;
        try {
            DatagramSocket datagramSocket = new DatagramSocket(i, inetAddress);
            try {
                byte[] bArr = new byte[512];
                DatagramPacket datagramPacket = new DatagramPacket(bArr, 512);
                DatagramPacket datagramPacket2 = null;
                while (true) {
                    datagramPacket.setLength(512);
                    try {
                        datagramSocket.receive(datagramPacket);
                        try {
                            bArrFormerrMessage = generateReply(new Message(bArr), bArr, null);
                        } catch (IOException unused) {
                            bArrFormerrMessage = formerrMessage(bArr);
                        }
                    } catch (InterruptedIOException unused2) {
                    }
                    if (bArrFormerrMessage != null) {
                        if (datagramPacket2 == null) {
                            datagramPacket2 = new DatagramPacket(bArrFormerrMessage, bArrFormerrMessage.length, datagramPacket.getAddress(), datagramPacket.getPort());
                        } else {
                            datagramPacket2.setData(bArrFormerrMessage);
                            datagramPacket2.setLength(bArrFormerrMessage.length);
                            datagramPacket2.setAddress(datagramPacket.getAddress());
                            datagramPacket2.setPort(datagramPacket.getPort());
                        }
                        datagramSocket.send(datagramPacket2);
                    }
                }
            } finally {
            }
        } catch (IOException e) {
            System.out.println("serveUDP(" + addrport(inetAddress, i) + "): " + e);
        }
    }
}
