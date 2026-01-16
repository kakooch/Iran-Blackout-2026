package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class ReedSolomonEncoder {
    private final List<GenericGFPoly> cachedGenerators;
    private final GenericGF field;

    public ReedSolomonEncoder(GenericGF field) {
        this.field = field;
        ArrayList arrayList = new ArrayList();
        this.cachedGenerators = arrayList;
        arrayList.add(new GenericGFPoly(field, new int[]{1}));
    }

    private GenericGFPoly buildGenerator(int degree) {
        if (degree >= this.cachedGenerators.size()) {
            List<GenericGFPoly> list = this.cachedGenerators;
            GenericGFPoly genericGFPolyMultiply = list.get(list.size() - 1);
            for (int size = this.cachedGenerators.size(); size <= degree; size++) {
                GenericGF genericGF = this.field;
                genericGFPolyMultiply = genericGFPolyMultiply.multiply(new GenericGFPoly(genericGF, new int[]{1, genericGF.exp((size - 1) + genericGF.getGeneratorBase())}));
                this.cachedGenerators.add(genericGFPolyMultiply);
            }
        }
        return this.cachedGenerators.get(degree);
    }

    public void encode(int[] toEncode, int ecBytes) {
        if (ecBytes == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = toEncode.length - ecBytes;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        GenericGFPoly genericGFPolyBuildGenerator = buildGenerator(ecBytes);
        int[] iArr = new int[length];
        System.arraycopy(toEncode, 0, iArr, 0, length);
        int[] coefficients = new GenericGFPoly(this.field, iArr).multiplyByMonomial(ecBytes, 1).divide(genericGFPolyBuildGenerator)[1].getCoefficients();
        int length2 = ecBytes - coefficients.length;
        for (int i = 0; i < length2; i++) {
            toEncode[length + i] = 0;
        }
        System.arraycopy(coefficients, 0, toEncode, length + length2, coefficients.length);
    }
}
