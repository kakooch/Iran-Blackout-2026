package ir.nasim;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* renamed from: ir.nasim.qY6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC19553qY6 {
    public static AbstractC22735vk3 a(C12523el3 c12523el3) {
        boolean z;
        try {
            try {
                c12523el3.G();
                z = false;
                try {
                    return (AbstractC22735vk3) AbstractC7010Px7.V.b(c12523el3);
                } catch (EOFException e) {
                    e = e;
                    if (z) {
                        return C8074Uk3.a;
                    }
                    throw new JsonSyntaxException(e);
                }
            } catch (EOFException e2) {
                e = e2;
                z = true;
            }
        } catch (MalformedJsonException e3) {
            throw new JsonSyntaxException(e3);
        } catch (IOException e4) {
            throw new JsonIOException(e4);
        } catch (NumberFormatException e5) {
            throw new JsonSyntaxException(e5);
        }
    }

    public static void b(AbstractC22735vk3 abstractC22735vk3, C22155ul3 c22155ul3) {
        AbstractC7010Px7.V.d(c22155ul3, abstractC22735vk3);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new b(appendable);
    }

    /* renamed from: ir.nasim.qY6$b */
    private static final class b extends Writer {
        private final Appendable a;
        private final a b = new a();

        /* renamed from: ir.nasim.qY6$b$a */
        private static class a implements CharSequence {
            private char[] a;
            private String b;

            private a() {
            }

            void a(char[] cArr) {
                this.a = cArr;
                this.b = null;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i) {
                return this.a[i];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i, int i2) {
                return new String(this.a, i, i2 - i);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.b == null) {
                    this.b = new String(this.a);
                }
                return this.b;
            }
        }

        b(Appendable appendable) {
            this.a = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) throws IOException {
            this.b.a(cArr);
            this.a.append(this.b, i, i2 + i);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) throws IOException {
            this.a.append(charSequence);
            return this;
        }

        @Override // java.io.Writer
        public void write(int i) throws IOException {
            this.a.append((char) i);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i, int i2) throws IOException {
            this.a.append(charSequence, i, i2);
            return this;
        }

        @Override // java.io.Writer
        public void write(String str, int i, int i2) throws IOException {
            Objects.requireNonNull(str);
            this.a.append(str, i, i2 + i);
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }
    }
}
