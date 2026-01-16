package ir.eitaa.messenger;

/* loaded from: classes.dex */
public abstract class FourierTransform {
    protected static final int LINAVG = 1;
    protected static final int LOGAVG = 2;
    protected static final int NOAVG = 3;
    protected static final float TWO_PI = 6.2831855f;
    protected float[] averages;
    protected int avgPerOctave;
    protected float bandWidth;
    protected float[] imag;
    protected int octaves;
    protected float[] real;
    protected int sampleRate;
    protected float[] spectrum;
    protected int timeSize;
    protected int whichAverage;

    protected abstract void allocateArrays();

    public abstract void forward(float[] buffer);

    public abstract void inverse(float[] buffer);

    public abstract void scaleBand(int i, float s);

    public abstract void setBand(int i, float a);

    FourierTransform(int ts, float sr) {
        this.timeSize = ts;
        int i = (int) sr;
        this.sampleRate = i;
        this.bandWidth = (2.0f / ts) * (i / 2.0f);
        noAverages();
        allocateArrays();
    }

    protected void setComplex(float[] r, float[] i) {
        float[] fArr = this.real;
        if (fArr.length == r.length || this.imag.length == i.length) {
            System.arraycopy(r, 0, fArr, 0, r.length);
            System.arraycopy(i, 0, this.imag, 0, i.length);
        }
    }

    protected void fillSpectrum() {
        float[] fArr;
        int i = 0;
        while (true) {
            fArr = this.spectrum;
            if (i >= fArr.length) {
                break;
            }
            float[] fArr2 = this.real;
            float f = fArr2[i] * fArr2[i];
            float[] fArr3 = this.imag;
            fArr[i] = (float) Math.sqrt(f + (fArr3[i] * fArr3[i]));
            i++;
        }
        int i2 = this.whichAverage;
        if (i2 == 1) {
            int length = fArr.length / this.averages.length;
            for (int i3 = 0; i3 < this.averages.length; i3++) {
                int i4 = 0;
                float f2 = 0.0f;
                while (i4 < length) {
                    int i5 = (i3 * length) + i4;
                    float[] fArr4 = this.spectrum;
                    if (i5 < fArr4.length) {
                        f2 += fArr4[i5];
                        i4++;
                    }
                }
                this.averages[i3] = f2 / (i4 + 1);
            }
            return;
        }
        if (i2 != 2) {
            return;
        }
        int i6 = 0;
        while (true) {
            if (i6 >= this.octaves) {
                return;
            }
            float fPow = i6 == 0 ? 0.0f : (this.sampleRate / 2) / ((float) Math.pow(2.0d, r5 - i6));
            float fPow2 = (((this.sampleRate / 2) / ((float) Math.pow(2.0d, (this.octaves - i6) - 1))) - fPow) / this.avgPerOctave;
            int i7 = 0;
            while (true) {
                int i8 = this.avgPerOctave;
                if (i7 < i8) {
                    float f3 = fPow + fPow2;
                    this.averages[(i8 * i6) + i7] = calcAvg(fPow, f3);
                    i7++;
                    fPow = f3;
                }
            }
            i6++;
        }
    }

    public void noAverages() {
        this.averages = new float[0];
        this.whichAverage = 3;
    }

    public void linAverages(int numAvg) {
        if (numAvg > this.spectrum.length / 2) {
            return;
        }
        this.averages = new float[numAvg];
        this.whichAverage = 1;
    }

    public void logAverages(int minBandwidth, int bandsPerOctave) {
        float f = this.sampleRate / 2.0f;
        this.octaves = 1;
        while (true) {
            f /= 2.0f;
            if (f > minBandwidth) {
                this.octaves++;
            } else {
                this.avgPerOctave = bandsPerOctave;
                this.averages = new float[this.octaves * bandsPerOctave];
                this.whichAverage = 2;
                return;
            }
        }
    }

    public int timeSize() {
        return this.timeSize;
    }

    public int specSize() {
        return this.spectrum.length;
    }

    public float getBand(int i) {
        if (i < 0) {
            i = 0;
        }
        float[] fArr = this.spectrum;
        if (i > fArr.length - 1) {
            i = fArr.length - 1;
        }
        return fArr[i];
    }

    public float getBandWidth() {
        return this.bandWidth;
    }

    public int freqToIndex(float freq) {
        if (freq < getBandWidth() / 2.0f) {
            return 0;
        }
        if (freq > (this.sampleRate / 2) - (getBandWidth() / 2.0f)) {
            return this.spectrum.length - 1;
        }
        return Math.round(this.timeSize * (freq / this.sampleRate));
    }

    public float indexToFreq(int i) {
        float bandWidth = getBandWidth();
        return i == 0 ? bandWidth * 0.25f : i == this.spectrum.length + (-1) ? ((this.sampleRate / 2) - (bandWidth / 2.0f)) + (bandWidth * 0.25f) : i * bandWidth;
    }

    public float calcAvg(float lowFreq, float hiFreq) {
        int iFreqToIndex = freqToIndex(lowFreq);
        int iFreqToIndex2 = freqToIndex(hiFreq);
        float f = 0.0f;
        for (int i = iFreqToIndex; i <= iFreqToIndex2; i++) {
            f += this.spectrum[i];
        }
        return f / ((iFreqToIndex2 - iFreqToIndex) + 1);
    }

    public float[] getSpectrumReal() {
        return this.real;
    }

    public float[] getSpectrumImaginary() {
        return this.imag;
    }

    public void forward(float[] buffer, int startAt) {
        int length = buffer.length - startAt;
        int i = this.timeSize;
        if (length < i) {
            return;
        }
        float[] fArr = new float[i];
        System.arraycopy(buffer, startAt, fArr, 0, i);
        forward(fArr);
    }

    public void inverse(float[] freqReal, float[] freqImag, float[] buffer) {
        setComplex(freqReal, freqImag);
        inverse(buffer);
    }

    public static class FFT extends FourierTransform {
        private float[] coslookup;
        private int[] reverse;
        private float[] sinlookup;

        public FFT(int timeSize, float sampleRate) {
            super(timeSize, sampleRate);
            if ((timeSize & (timeSize - 1)) != 0) {
                throw new IllegalArgumentException("FFT: timeSize must be a power of two.");
            }
            buildReverseTable();
            buildTrigTables();
        }

        @Override // ir.eitaa.messenger.FourierTransform
        protected void allocateArrays() {
            int i = this.timeSize;
            this.spectrum = new float[(i / 2) + 1];
            this.real = new float[i];
            this.imag = new float[i];
        }

        @Override // ir.eitaa.messenger.FourierTransform
        public void scaleBand(int i, float s) {
            if (s < 0.0f) {
                return;
            }
            float[] fArr = this.real;
            fArr[i] = fArr[i] * s;
            float[] fArr2 = this.imag;
            fArr2[i] = fArr2[i] * s;
            float[] fArr3 = this.spectrum;
            fArr3[i] = fArr3[i] * s;
            if (i != 0) {
                int i2 = this.timeSize;
                if (i != i2 / 2) {
                    fArr[i2 - i] = fArr[i];
                    fArr2[i2 - i] = -fArr2[i];
                }
            }
        }

        @Override // ir.eitaa.messenger.FourierTransform
        public void setBand(int i, float a) {
            if (a < 0.0f) {
                return;
            }
            float[] fArr = this.real;
            if (fArr[i] == 0.0f && this.imag[i] == 0.0f) {
                fArr[i] = a;
                this.spectrum[i] = a;
            } else {
                float f = fArr[i];
                float[] fArr2 = this.spectrum;
                fArr[i] = f / fArr2[i];
                float[] fArr3 = this.imag;
                fArr3[i] = fArr3[i] / fArr2[i];
                fArr2[i] = a;
                fArr[i] = fArr[i] * fArr2[i];
                fArr3[i] = fArr3[i] * fArr2[i];
            }
            if (i != 0) {
                int i2 = this.timeSize;
                if (i != i2 / 2) {
                    fArr[i2 - i] = fArr[i];
                    float[] fArr4 = this.imag;
                    fArr4[i2 - i] = -fArr4[i];
                }
            }
        }

        private void fft() {
            for (int i = 1; i < this.real.length; i *= 2) {
                float fCos = cos(i);
                float fSin = sin(i);
                float f = 1.0f;
                float f2 = 0.0f;
                int i2 = 0;
                while (i2 < i) {
                    int i3 = i2;
                    while (true) {
                        float[] fArr = this.real;
                        if (i3 < fArr.length) {
                            int i4 = i3 + i;
                            float f3 = fArr[i4] * f;
                            float[] fArr2 = this.imag;
                            float f4 = f3 - (fArr2[i4] * f2);
                            float f5 = (fArr2[i4] * f) + (fArr[i4] * f2);
                            fArr[i4] = fArr[i3] - f4;
                            fArr2[i4] = fArr2[i3] - f5;
                            fArr[i3] = fArr[i3] + f4;
                            fArr2[i3] = fArr2[i3] + f5;
                            i3 += i * 2;
                        }
                    }
                    float f6 = (f * fCos) - (f2 * fSin);
                    f2 = (f2 * fCos) + (f * fSin);
                    i2++;
                    f = f6;
                }
            }
        }

        @Override // ir.eitaa.messenger.FourierTransform
        public void forward(float[] buffer) {
            if (buffer.length != this.timeSize) {
                return;
            }
            bitReverseSamples(buffer, 0);
            fft();
            fillSpectrum();
        }

        @Override // ir.eitaa.messenger.FourierTransform
        public void forward(float[] buffer, int startAt) {
            if (buffer.length - startAt < this.timeSize) {
                return;
            }
            bitReverseSamples(buffer, startAt);
            fft();
            fillSpectrum();
        }

        public void forward(float[] buffReal, float[] buffImag) {
            int length = buffReal.length;
            int i = this.timeSize;
            if (length == i && buffImag.length == i) {
                setComplex(buffReal, buffImag);
                bitReverseComplex();
                fft();
                fillSpectrum();
            }
        }

        @Override // ir.eitaa.messenger.FourierTransform
        public void inverse(float[] buffer) {
            if (buffer.length > this.real.length) {
                return;
            }
            for (int i = 0; i < this.timeSize; i++) {
                float[] fArr = this.imag;
                fArr[i] = fArr[i] * (-1.0f);
            }
            bitReverseComplex();
            fft();
            for (int i2 = 0; i2 < buffer.length; i2++) {
                buffer[i2] = this.real[i2] / r1.length;
            }
        }

        private void buildReverseTable() {
            int i = this.timeSize;
            int[] iArr = new int[i];
            this.reverse = iArr;
            iArr[0] = 0;
            int i2 = i / 2;
            int i3 = 1;
            while (i3 < i) {
                for (int i4 = 0; i4 < i3; i4++) {
                    int[] iArr2 = this.reverse;
                    iArr2[i4 + i3] = iArr2[i4] + i2;
                }
                i3 <<= 1;
                i2 >>= 1;
            }
        }

        private void bitReverseSamples(float[] samples, int startAt) {
            for (int i = 0; i < this.timeSize; i++) {
                this.real[i] = samples[this.reverse[i] + startAt];
                this.imag[i] = 0.0f;
            }
        }

        private void bitReverseComplex() {
            float[] fArr = new float[this.real.length];
            float[] fArr2 = new float[this.imag.length];
            int i = 0;
            while (true) {
                float[] fArr3 = this.real;
                if (i < fArr3.length) {
                    int[] iArr = this.reverse;
                    fArr[i] = fArr3[iArr[i]];
                    fArr2[i] = this.imag[iArr[i]];
                    i++;
                } else {
                    this.real = fArr;
                    this.imag = fArr2;
                    return;
                }
            }
        }

        private float sin(int i) {
            return this.sinlookup[i];
        }

        private float cos(int i) {
            return this.coslookup[i];
        }

        private void buildTrigTables() {
            int i = this.timeSize;
            this.sinlookup = new float[i];
            this.coslookup = new float[i];
            for (int i2 = 0; i2 < i; i2++) {
                double d = (-3.1415927f) / i2;
                this.sinlookup[i2] = (float) Math.sin(d);
                this.coslookup[i2] = (float) Math.cos(d);
            }
        }
    }
}
