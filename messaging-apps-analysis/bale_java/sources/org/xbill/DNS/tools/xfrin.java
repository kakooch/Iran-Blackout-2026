package org.xbill.DNS.tools;

import android.gov.nist.core.Separators;
import java.io.PrintStream;
import java.util.Iterator;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Name;
import org.xbill.DNS.Record;
import org.xbill.DNS.TSIG;
import org.xbill.DNS.ZoneTransferIn;

/* loaded from: classes8.dex */
public class xfrin {
    public static void main(String[] strArr) throws NumberFormatException {
        String str;
        String str2 = null;
        int i = -1;
        TSIG tsig = null;
        int i2 = 53;
        int i3 = 0;
        boolean z = false;
        while (i3 < strArr.length) {
            if (strArr[i3].equals("-i")) {
                i3++;
                i = Integer.parseInt(strArr[i3]);
                if (i < 0) {
                    usage("invalid serial number");
                }
            } else if (strArr[i3].equals("-k")) {
                i3++;
                String str3 = strArr[i3];
                int iIndexOf = str3.indexOf(47);
                if (iIndexOf < 0) {
                    usage("invalid key");
                }
                tsig = new TSIG(TSIG.HMAC_MD5, str3.substring(0, iIndexOf), str3.substring(iIndexOf + 1));
            } else if (strArr[i3].equals("-s")) {
                i3++;
                str2 = strArr[i3];
            } else if (strArr[i3].equals("-p")) {
                i3++;
                int i4 = Integer.parseInt(strArr[i3]);
                if (i4 < 0 || i4 > 65535) {
                    usage("invalid port");
                }
                i2 = i4;
            } else if (strArr[i3].equals("-f")) {
                z = true;
            } else if (!strArr[i3].startsWith("-")) {
                break;
            } else {
                usage("invalid option");
            }
            i3++;
        }
        if (i3 >= strArr.length) {
            usage("no zone name specified");
        }
        Name nameFromString = Name.fromString(strArr[i3]);
        if (str2 == null) {
            Lookup lookup = new Lookup(nameFromString, 2);
            Record[] recordArrRun = lookup.run();
            if (recordArrRun == null) {
                System.out.println("failed to look up NS record: " + lookup.getErrorString());
                System.exit(1);
            }
            String strRdataToString = recordArrRun[0].rdataToString();
            System.out.println("sending to server '" + strRdataToString + Separators.QUOTE);
            str = strRdataToString;
        } else {
            str = str2;
        }
        ZoneTransferIn zoneTransferInNewIXFR = i >= 0 ? ZoneTransferIn.newIXFR(nameFromString, i, z, str, i2, tsig) : ZoneTransferIn.newAXFR(nameFromString, str, i2, tsig);
        zoneTransferInNewIXFR.run();
        if (zoneTransferInNewIXFR.isAXFR()) {
            if (i >= 0) {
                System.out.println("AXFR-like IXFR response");
            } else {
                System.out.println("AXFR response");
            }
            Iterator<Record> it = zoneTransferInNewIXFR.getAXFR().iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
            return;
        }
        if (!zoneTransferInNewIXFR.isIXFR()) {
            if (zoneTransferInNewIXFR.isCurrent()) {
                System.out.println("up to date");
                return;
            }
            return;
        }
        System.out.println("IXFR response");
        for (ZoneTransferIn.Delta delta : zoneTransferInNewIXFR.getIXFR()) {
            PrintStream printStream = System.out;
            printStream.println("delta from " + delta.start + " to " + delta.end);
            printStream.println("deletes");
            Iterator<Record> it2 = delta.deletes.iterator();
            while (it2.hasNext()) {
                System.out.println(it2.next());
            }
            System.out.println("adds");
            Iterator<Record> it3 = delta.adds.iterator();
            while (it3.hasNext()) {
                System.out.println(it3.next());
            }
        }
    }

    private static void usage(String str) {
        PrintStream printStream = System.out;
        printStream.println("Error: " + str);
        printStream.println("usage: xfrin [-i serial] [-k keyname/secret] [-s server] [-p port] [-f] zone");
        System.exit(1);
    }
}
