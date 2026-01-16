package com.google.android.exoplayer2.audio;

import android.gov.nist.core.Separators;
import android.media.AudioDeviceInfo;
import com.google.android.exoplayer2.X;
import com.google.android.exoplayer2.y0;
import ir.nasim.C15493jg5;
import ir.nasim.C23763xU;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public interface AudioSink {

    public static final class InitializationException extends Exception {
        public final int a;
        public final boolean b;
        public final X c;

        public InitializationException(int i, int i2, int i3, int i4, X x, boolean z, Exception exc) {
            StringBuilder sb = new StringBuilder();
            sb.append("AudioTrack init failed ");
            sb.append(i);
            sb.append(Separators.SP);
            sb.append("Config(");
            sb.append(i2);
            sb.append(", ");
            sb.append(i3);
            sb.append(", ");
            sb.append(i4);
            sb.append(Separators.RPAREN);
            sb.append(z ? " (recoverable)" : "");
            super(sb.toString(), exc);
            this.a = i;
            this.b = z;
            this.c = x;
        }
    }

    public static final class UnexpectedDiscontinuityException extends Exception {
        public final long a;
        public final long b;

        public UnexpectedDiscontinuityException(long j, long j2) {
            super("Unexpected audio track timestamp discontinuity: expected " + j2 + ", got " + j);
            this.a = j;
            this.b = j2;
        }
    }

    public static final class WriteException extends Exception {
        public final int a;
        public final boolean b;
        public final X c;

        public WriteException(int i, X x, boolean z) {
            super("AudioTrack write failed: " + i);
            this.b = z;
            this.a = i;
            this.c = x;
        }
    }

    public interface a {
        void a(long j);

        void b(boolean z);

        void c(Exception exc);

        void d();

        void e(int i, long j, long j2);

        void f();

        void g();
    }

    boolean b(X x);

    y0 c();

    boolean d();

    void e(y0 y0Var);

    void f(C23763xU c23763xU);

    void flush();

    void g(float f);

    void h();

    void i(AudioDeviceInfo audioDeviceInfo);

    boolean j();

    void k(int i);

    void l();

    void m(com.google.android.exoplayer2.audio.a aVar);

    void n(C15493jg5 c15493jg5);

    boolean o(ByteBuffer byteBuffer, long j, int i);

    void p(a aVar);

    void q();

    int r(X x);

    void reset();

    void s();

    void t();

    long u(boolean z);

    default void v(long j) {
    }

    void w();

    void x();

    void y(X x, int i, int[] iArr);

    void z(boolean z);

    public static final class ConfigurationException extends Exception {
        public final X a;

        public ConfigurationException(Throwable th, X x) {
            super(th);
            this.a = x;
        }

        public ConfigurationException(String str, X x) {
            super(str);
            this.a = x;
        }
    }
}
