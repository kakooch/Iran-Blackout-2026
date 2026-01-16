package com.google.zxing.common.reedsolomon;

/* loaded from: classes.dex */
final class GenericGFPoly {
    private final int[] coefficients;
    private final GenericGF field;

    GenericGFPoly(GenericGF field, int[] coefficients) {
        if (coefficients.length == 0) {
            throw new IllegalArgumentException();
        }
        this.field = field;
        int length = coefficients.length;
        if (length > 1 && coefficients[0] == 0) {
            int i = 1;
            while (i < length && coefficients[i] == 0) {
                i++;
            }
            if (i == length) {
                this.coefficients = new int[]{0};
                return;
            }
            int[] iArr = new int[length - i];
            this.coefficients = iArr;
            System.arraycopy(coefficients, i, iArr, 0, iArr.length);
            return;
        }
        this.coefficients = coefficients;
    }

    int[] getCoefficients() {
        return this.coefficients;
    }

    int getDegree() {
        return this.coefficients.length - 1;
    }

    boolean isZero() {
        return this.coefficients[0] == 0;
    }

    int getCoefficient(int degree) {
        return this.coefficients[(r0.length - 1) - degree];
    }

    int evaluateAt(int a) {
        if (a == 0) {
            return getCoefficient(0);
        }
        if (a == 1) {
            int iAddOrSubtract = 0;
            for (int i : this.coefficients) {
                iAddOrSubtract = GenericGF.addOrSubtract(iAddOrSubtract, i);
            }
            return iAddOrSubtract;
        }
        int[] iArr = this.coefficients;
        int iAddOrSubtract2 = iArr[0];
        int length = iArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            iAddOrSubtract2 = GenericGF.addOrSubtract(this.field.multiply(a, iAddOrSubtract2), this.coefficients[i2]);
        }
        return iAddOrSubtract2;
    }

    GenericGFPoly addOrSubtract(GenericGFPoly other) {
        if (!this.field.equals(other.field)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (isZero()) {
            return other;
        }
        if (other.isZero()) {
            return this;
        }
        int[] iArr = this.coefficients;
        int[] iArr2 = other.coefficients;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = GenericGF.addOrSubtract(iArr2[i - length], iArr[i]);
        }
        return new GenericGFPoly(this.field, iArr3);
    }

    GenericGFPoly multiply(GenericGFPoly other) {
        if (!this.field.equals(other.field)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (isZero() || other.isZero()) {
            return this.field.getZero();
        }
        int[] iArr = this.coefficients;
        int length = iArr.length;
        int[] iArr2 = other.coefficients;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                iArr3[i4] = GenericGF.addOrSubtract(iArr3[i4], this.field.multiply(i2, iArr2[i3]));
            }
        }
        return new GenericGFPoly(this.field, iArr3);
    }

    GenericGFPoly multiply(int scalar) {
        if (scalar == 0) {
            return this.field.getZero();
        }
        if (scalar == 1) {
            return this;
        }
        int length = this.coefficients.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.field.multiply(this.coefficients[i], scalar);
        }
        return new GenericGFPoly(this.field, iArr);
    }

    GenericGFPoly multiplyByMonomial(int degree, int coefficient) {
        if (degree < 0) {
            throw new IllegalArgumentException();
        }
        if (coefficient == 0) {
            return this.field.getZero();
        }
        int length = this.coefficients.length;
        int[] iArr = new int[degree + length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.field.multiply(this.coefficients[i], coefficient);
        }
        return new GenericGFPoly(this.field, iArr);
    }

    GenericGFPoly[] divide(GenericGFPoly other) {
        if (!this.field.equals(other.field)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (other.isZero()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        GenericGFPoly zero = this.field.getZero();
        int iInverse = this.field.inverse(other.getCoefficient(other.getDegree()));
        GenericGFPoly genericGFPolyAddOrSubtract = this;
        while (genericGFPolyAddOrSubtract.getDegree() >= other.getDegree() && !genericGFPolyAddOrSubtract.isZero()) {
            int degree = genericGFPolyAddOrSubtract.getDegree() - other.getDegree();
            int iMultiply = this.field.multiply(genericGFPolyAddOrSubtract.getCoefficient(genericGFPolyAddOrSubtract.getDegree()), iInverse);
            GenericGFPoly genericGFPolyMultiplyByMonomial = other.multiplyByMonomial(degree, iMultiply);
            zero = zero.addOrSubtract(this.field.buildMonomial(degree, iMultiply));
            genericGFPolyAddOrSubtract = genericGFPolyAddOrSubtract.addOrSubtract(genericGFPolyMultiplyByMonomial);
        }
        return new GenericGFPoly[]{zero, genericGFPolyAddOrSubtract};
    }

    public String toString() {
        if (isZero()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(getDegree() * 8);
        for (int degree = getDegree(); degree >= 0; degree--) {
            int coefficient = getCoefficient(degree);
            if (coefficient != 0) {
                if (coefficient < 0) {
                    if (degree == getDegree()) {
                        sb.append("-");
                    } else {
                        sb.append(" - ");
                    }
                    coefficient = -coefficient;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (degree == 0 || coefficient != 1) {
                    int iLog = this.field.log(coefficient);
                    if (iLog == 0) {
                        sb.append('1');
                    } else if (iLog == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(iLog);
                    }
                }
                if (degree != 0) {
                    if (degree == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(degree);
                    }
                }
            }
        }
        return sb.toString();
    }
}
