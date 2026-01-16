package org.xbill.DNS.dnssec;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lombok.Generated;
import org.xbill.DNS.DSRecord;
import org.xbill.DNS.RRset;
import org.xbill.DNS.Record;

/* loaded from: classes8.dex */
class AlgorithmRequirements {
    private static final int MAX_ALGORITHMS = 255;
    private final short[] needs = new short[255];
    private int num;
    private final ValUtils valUtils;

    public AlgorithmRequirements(ValUtils valUtils) {
        this.valUtils = valUtils;
    }

    @Generated
    public int getNum() {
        return this.num;
    }

    List<Integer> initDs(RRset rRset, int i) {
        ArrayList arrayList = new ArrayList();
        this.num = 0;
        Iterator<Record> it = rRset.rrs(false).iterator();
        while (it.hasNext()) {
            DSRecord dSRecord = (DSRecord) it.next();
            if (dSRecord.getDigestID() == i) {
                int algorithm = dSRecord.getAlgorithm();
                if (this.valUtils.isAlgorithmSupported(algorithm)) {
                    short[] sArr = this.needs;
                    if (sArr[algorithm] == 0) {
                        sArr[algorithm] = 1;
                        arrayList.add(Integer.valueOf(algorithm));
                        this.num++;
                    }
                }
            }
        }
        return arrayList;
    }

    void initList(List<Integer> list) {
        this.num = 0;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            this.needs[it.next().intValue()] = 1;
            this.num++;
        }
    }

    int missing() {
        int i = -1;
        int i2 = 0;
        while (true) {
            short[] sArr = this.needs;
            if (i2 >= sArr.length) {
                if (i != -1) {
                    return i;
                }
                return 0;
            }
            short s = sArr[i2];
            if (s == 2) {
                return 0;
            }
            if (s == 1 && i == -1) {
                i = i2;
            }
            i2++;
        }
    }

    void setBogus(int i) {
        short[] sArr = this.needs;
        if (sArr[i] != 0) {
            sArr[i] = 2;
        }
    }

    boolean setSecure(int i) {
        short[] sArr = this.needs;
        if (sArr[i] == 0) {
            return false;
        }
        sArr[i] = 0;
        int i2 = this.num - 1;
        this.num = i2;
        return i2 == 0;
    }
}
