package com.google.zxing.common.reedsolomon;

/* loaded from: classes.dex */
public final class ReedSolomonDecoder {
    private final GenericGF field;

    public ReedSolomonDecoder(GenericGF field) {
        this.field = field;
    }

    public void decode(int[] received, int twoS) throws ReedSolomonException {
        GenericGFPoly genericGFPoly = new GenericGFPoly(this.field, received);
        int[] iArr = new int[twoS];
        boolean z = true;
        for (int i = 0; i < twoS; i++) {
            GenericGF genericGF = this.field;
            int iEvaluateAt = genericGFPoly.evaluateAt(genericGF.exp(genericGF.getGeneratorBase() + i));
            iArr[(twoS - 1) - i] = iEvaluateAt;
            if (iEvaluateAt != 0) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        GenericGFPoly[] genericGFPolyArrRunEuclideanAlgorithm = runEuclideanAlgorithm(this.field.buildMonomial(twoS, 1), new GenericGFPoly(this.field, iArr), twoS);
        GenericGFPoly genericGFPoly2 = genericGFPolyArrRunEuclideanAlgorithm[0];
        GenericGFPoly genericGFPoly3 = genericGFPolyArrRunEuclideanAlgorithm[1];
        int[] iArrFindErrorLocations = findErrorLocations(genericGFPoly2);
        int[] iArrFindErrorMagnitudes = findErrorMagnitudes(genericGFPoly3, iArrFindErrorLocations);
        for (int i2 = 0; i2 < iArrFindErrorLocations.length; i2++) {
            int length = (received.length - 1) - this.field.log(iArrFindErrorLocations[i2]);
            if (length < 0) {
                throw new ReedSolomonException("Bad error location");
            }
            received[length] = GenericGF.addOrSubtract(received[length], iArrFindErrorMagnitudes[i2]);
        }
    }

    private GenericGFPoly[] runEuclideanAlgorithm(GenericGFPoly a, GenericGFPoly b, int R) throws ReedSolomonException {
        if (a.getDegree() < b.getDegree()) {
            b = a;
            a = b;
        }
        GenericGFPoly zero = this.field.getZero();
        GenericGFPoly one = this.field.getOne();
        do {
            GenericGFPoly genericGFPoly = b;
            b = a;
            a = genericGFPoly;
            GenericGFPoly genericGFPoly2 = one;
            GenericGFPoly genericGFPoly3 = zero;
            zero = genericGFPoly2;
            if (a.getDegree() >= R / 2) {
                if (a.isZero()) {
                    throw new ReedSolomonException("r_{i-1} was zero");
                }
                GenericGFPoly zero2 = this.field.getZero();
                int iInverse = this.field.inverse(a.getCoefficient(a.getDegree()));
                while (b.getDegree() >= a.getDegree() && !b.isZero()) {
                    int degree = b.getDegree() - a.getDegree();
                    int iMultiply = this.field.multiply(b.getCoefficient(b.getDegree()), iInverse);
                    zero2 = zero2.addOrSubtract(this.field.buildMonomial(degree, iMultiply));
                    b = b.addOrSubtract(a.multiplyByMonomial(degree, iMultiply));
                }
                one = zero2.multiply(zero).addOrSubtract(genericGFPoly3);
            } else {
                int coefficient = zero.getCoefficient(0);
                if (coefficient == 0) {
                    throw new ReedSolomonException("sigmaTilde(0) was zero");
                }
                int iInverse2 = this.field.inverse(coefficient);
                return new GenericGFPoly[]{zero.multiply(iInverse2), a.multiply(iInverse2)};
            }
        } while (b.getDegree() < a.getDegree());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial?");
    }

    private int[] findErrorLocations(GenericGFPoly errorLocator) throws ReedSolomonException {
        int degree = errorLocator.getDegree();
        int i = 0;
        if (degree == 1) {
            return new int[]{errorLocator.getCoefficient(1)};
        }
        int[] iArr = new int[degree];
        for (int i2 = 1; i2 < this.field.getSize() && i < degree; i2++) {
            if (errorLocator.evaluateAt(i2) == 0) {
                iArr[i] = this.field.inverse(i2);
                i++;
            }
        }
        if (i == degree) {
            return iArr;
        }
        throw new ReedSolomonException("Error locator degree does not match number of roots");
    }

    private int[] findErrorMagnitudes(GenericGFPoly errorEvaluator, int[] errorLocations) {
        int length = errorLocations.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            int iInverse = this.field.inverse(errorLocations[i]);
            int iMultiply = 1;
            for (int i2 = 0; i2 < length; i2++) {
                if (i != i2) {
                    int iMultiply2 = this.field.multiply(errorLocations[i2], iInverse);
                    iMultiply = this.field.multiply(iMultiply, (iMultiply2 & 1) == 0 ? iMultiply2 | 1 : iMultiply2 & (-2));
                }
            }
            iArr[i] = this.field.multiply(errorEvaluator.evaluateAt(iInverse), this.field.inverse(iMultiply));
            if (this.field.getGeneratorBase() != 0) {
                iArr[i] = this.field.multiply(iArr[i], iInverse);
            }
        }
        return iArr;
    }
}
