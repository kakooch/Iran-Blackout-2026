package ir.appp.rghapp.rubinoPostSlider;

/* loaded from: classes3.dex */
public abstract class FourierTransform {
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

    FourierTransform(int i, float f) {
        this.timeSize = i;
        int i2 = (int) f;
        this.sampleRate = i2;
        this.bandWidth = (2.0f / i) * (i2 / 2.0f);
        noAverages();
        allocateArrays();
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

    public float getBandWidth() {
        return this.bandWidth;
    }

    public int freqToIndex(float f) {
        if (f < getBandWidth() / 2.0f) {
            return 0;
        }
        if (f > (this.sampleRate / 2) - (getBandWidth() / 2.0f)) {
            return this.spectrum.length - 1;
        }
        return Math.round(this.timeSize * (f / this.sampleRate));
    }

    public float calcAvg(float f, float f2) {
        int iFreqToIndex = freqToIndex(f);
        int iFreqToIndex2 = freqToIndex(f2);
        float f3 = 0.0f;
        for (int i = iFreqToIndex; i <= iFreqToIndex2; i++) {
            f3 += this.spectrum[i];
        }
        return f3 / ((iFreqToIndex2 - iFreqToIndex) + 1);
    }

    public float[] getSpectrumReal() {
        return this.real;
    }

    public float[] getSpectrumImaginary() {
        return this.imag;
    }

    public static class FFT extends FourierTransform {
        private float[] coslookup;
        private int[] reverse;
        private float[] sinlookup;

        public FFT(int i, float f) {
            super(i, f);
            if ((i & (i - 1)) != 0) {
                throw new IllegalArgumentException("FFT: timeSize must be a power of two.");
            }
            buildReverseTable();
            buildTrigTables();
        }

        @Override // ir.appp.rghapp.rubinoPostSlider.FourierTransform
        protected void allocateArrays() {
            int i = this.timeSize;
            this.spectrum = new float[(i / 2) + 1];
            this.real = new float[i];
            this.imag = new float[i];
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

        public void forward(float[] fArr) {
            if (fArr.length != this.timeSize) {
                return;
            }
            bitReverseSamples(fArr, 0);
            fft();
            fillSpectrum();
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

        private void bitReverseSamples(float[] fArr, int i) {
            for (int i2 = 0; i2 < this.timeSize; i2++) {
                this.real[i2] = fArr[this.reverse[i2] + i];
                this.imag[i2] = 0.0f;
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
