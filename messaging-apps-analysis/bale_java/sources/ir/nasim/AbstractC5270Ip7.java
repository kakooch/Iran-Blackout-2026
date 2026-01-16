package ir.nasim;

import android.os.Build;
import android.util.Log;
import ir.nasim.database.dailogLists.DialogEntity;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: ir.nasim.Ip7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC5270Ip7 {
    public static final b a = new b(null);
    private static final ArrayList b = new ArrayList();
    private static volatile c[] c = new c[0];

    /* renamed from: ir.nasim.Ip7$a */
    public static class a extends c {
        public static final C0425a c = new C0425a(null);
        private static final Pattern d = Pattern.compile("(\\$\\d+)+$");
        private final List b = AbstractC10360bX0.p(AbstractC5270Ip7.class.getName(), b.class.getName(), c.class.getName(), a.class.getName());

        /* renamed from: ir.nasim.Ip7$a$a, reason: collision with other inner class name */
        public static final class C0425a {
            private C0425a() {
            }

            public /* synthetic */ C0425a(ED1 ed1) {
                this();
            }
        }

        @Override // ir.nasim.AbstractC5270Ip7.c
        public String e() {
            String strE = super.e();
            if (strE != null) {
                return strE;
            }
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            AbstractC13042fc3.h(stackTrace, "Throwable().stackTrace");
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (!this.b.contains(stackTraceElement.getClassName())) {
                    return n(stackTraceElement);
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        @Override // ir.nasim.AbstractC5270Ip7.c
        protected void i(int i, String str, String str2, Throwable th) {
            int iMin;
            AbstractC13042fc3.i(str2, DialogEntity.COLUMN_MESSAGE);
            if (str2.length() < 4000) {
                if (i == 7) {
                    Log.wtf(str, str2);
                    return;
                } else {
                    Log.println(i, str, str2);
                    return;
                }
            }
            int length = str2.length();
            int i2 = 0;
            while (i2 < length) {
                int iK0 = AbstractC20762sZ6.k0(str2, '\n', i2, false, 4, null);
                if (iK0 == -1) {
                    iK0 = length;
                }
                while (true) {
                    iMin = Math.min(iK0, i2 + 4000);
                    String strSubstring = str2.substring(i2, iMin);
                    AbstractC13042fc3.h(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (i == 7) {
                        Log.wtf(str, strSubstring);
                    } else {
                        Log.println(i, str, strSubstring);
                    }
                    if (iMin >= iK0) {
                        break;
                    } else {
                        i2 = iMin;
                    }
                }
                i2 = iMin + 1;
            }
        }

        protected String n(StackTraceElement stackTraceElement) {
            AbstractC13042fc3.i(stackTraceElement, "element");
            String className = stackTraceElement.getClassName();
            AbstractC13042fc3.h(className, "element.className");
            String strC1 = AbstractC20762sZ6.c1(className, '.', null, 2, null);
            Matcher matcher = d.matcher(strC1);
            if (matcher.find()) {
                strC1 = matcher.replaceAll("");
                AbstractC13042fc3.h(strC1, "m.replaceAll(\"\")");
            }
            if (strC1.length() <= 23 || Build.VERSION.SDK_INT >= 26) {
                return strC1;
            }
            String strSubstring = strC1.substring(0, 23);
            AbstractC13042fc3.h(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return strSubstring;
        }
    }

    /* renamed from: ir.nasim.Ip7$b */
    public static final class b extends c {
        public /* synthetic */ b(ED1 ed1) {
            this();
        }

        @Override // ir.nasim.AbstractC5270Ip7.c
        public void a(Throwable th, String str, Object... objArr) {
            AbstractC13042fc3.i(objArr, "args");
            for (c cVar : AbstractC5270Ip7.c) {
                cVar.a(th, str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        @Override // ir.nasim.AbstractC5270Ip7.c
        public void b(Throwable th, String str, Object... objArr) {
            AbstractC13042fc3.i(objArr, "args");
            for (c cVar : AbstractC5270Ip7.c) {
                cVar.b(th, str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        @Override // ir.nasim.AbstractC5270Ip7.c
        public void f(Throwable th, String str, Object... objArr) {
            AbstractC13042fc3.i(objArr, "args");
            for (c cVar : AbstractC5270Ip7.c) {
                cVar.f(th, str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        @Override // ir.nasim.AbstractC5270Ip7.c
        protected void i(int i, String str, String str2, Throwable th) {
            AbstractC13042fc3.i(str2, DialogEntity.COLUMN_MESSAGE);
            throw new AssertionError();
        }

        @Override // ir.nasim.AbstractC5270Ip7.c
        public void j(int i, String str, Object... objArr) {
            AbstractC13042fc3.i(objArr, "args");
            for (c cVar : AbstractC5270Ip7.c) {
                cVar.j(i, str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        @Override // ir.nasim.AbstractC5270Ip7.c
        public void l(Throwable th, String str, Object... objArr) {
            AbstractC13042fc3.i(objArr, "args");
            for (c cVar : AbstractC5270Ip7.c) {
                cVar.l(th, str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        @Override // ir.nasim.AbstractC5270Ip7.c
        public void m(Throwable th, String str, Object... objArr) {
            AbstractC13042fc3.i(objArr, "args");
            for (c cVar : AbstractC5270Ip7.c) {
                cVar.m(th, str, Arrays.copyOf(objArr, objArr.length));
            }
        }

        public final List n() {
            List listUnmodifiableList;
            synchronized (AbstractC5270Ip7.b) {
                listUnmodifiableList = Collections.unmodifiableList(AbstractC15401jX0.m1(AbstractC5270Ip7.b));
                AbstractC13042fc3.h(listUnmodifiableList, "unmodifiableList(trees.toList())");
            }
            return listUnmodifiableList;
        }

        public final void o(c cVar) {
            AbstractC13042fc3.i(cVar, "tree");
            if (!(cVar != this)) {
                throw new IllegalArgumentException("Cannot plant Timber into itself.".toString());
            }
            synchronized (AbstractC5270Ip7.b) {
                AbstractC5270Ip7.b.add(cVar);
                Object[] array = AbstractC5270Ip7.b.toArray(new c[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                AbstractC5270Ip7.c = (c[]) array;
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
        }

        public final int p() {
            return AbstractC5270Ip7.c.length;
        }

        public final void q(c cVar) {
            AbstractC13042fc3.i(cVar, "tree");
            synchronized (AbstractC5270Ip7.b) {
                if (!AbstractC5270Ip7.b.remove(cVar)) {
                    throw new IllegalArgumentException(AbstractC13042fc3.q("Cannot uproot tree which is not planted: ", cVar).toString());
                }
                Object[] array = AbstractC5270Ip7.b.toArray(new c[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                AbstractC5270Ip7.c = (c[]) array;
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
        }

        private b() {
        }
    }

    /* renamed from: ir.nasim.Ip7$c */
    public static abstract class c {
        private final ThreadLocal a = new ThreadLocal();

        private final String d(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            String string = stringWriter.toString();
            AbstractC13042fc3.h(string, "sw.toString()");
            return string;
        }

        private final void k(int i, Throwable th, String str, Object... objArr) {
            String strE = e();
            if (h(strE, i)) {
                if (str != null && str.length() != 0) {
                    if (!(objArr.length == 0)) {
                        str = c(str, objArr);
                    }
                    if (th != null) {
                        str = ((Object) str) + '\n' + d(th);
                    }
                } else if (th == null) {
                    return;
                } else {
                    str = d(th);
                }
                i(i, strE, str, th);
            }
        }

        public void a(Throwable th, String str, Object... objArr) {
            AbstractC13042fc3.i(objArr, "args");
            k(3, th, str, Arrays.copyOf(objArr, objArr.length));
        }

        public void b(Throwable th, String str, Object... objArr) {
            AbstractC13042fc3.i(objArr, "args");
            k(6, th, str, Arrays.copyOf(objArr, objArr.length));
        }

        protected String c(String str, Object[] objArr) {
            AbstractC13042fc3.i(str, DialogEntity.COLUMN_MESSAGE);
            AbstractC13042fc3.i(objArr, "args");
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            String str2 = String.format(str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
            AbstractC13042fc3.h(str2, "java.lang.String.format(this, *args)");
            return str2;
        }

        public /* synthetic */ String e() {
            String str = (String) this.a.get();
            if (str != null) {
                this.a.remove();
            }
            return str;
        }

        public void f(Throwable th, String str, Object... objArr) {
            AbstractC13042fc3.i(objArr, "args");
            k(4, th, str, Arrays.copyOf(objArr, objArr.length));
        }

        protected boolean g(int i) {
            return true;
        }

        protected boolean h(String str, int i) {
            return g(i);
        }

        protected abstract void i(int i, String str, String str2, Throwable th);

        public void j(int i, String str, Object... objArr) {
            AbstractC13042fc3.i(objArr, "args");
            k(i, null, str, Arrays.copyOf(objArr, objArr.length));
        }

        public void l(Throwable th, String str, Object... objArr) {
            AbstractC13042fc3.i(objArr, "args");
            k(2, th, str, Arrays.copyOf(objArr, objArr.length));
        }

        public void m(Throwable th, String str, Object... objArr) {
            AbstractC13042fc3.i(objArr, "args");
            k(5, th, str, Arrays.copyOf(objArr, objArr.length));
        }
    }

    public static void d(Throwable th, String str, Object... objArr) {
        a.a(th, str, objArr);
    }

    public static void e(Throwable th, String str, Object... objArr) {
        a.b(th, str, objArr);
    }

    public static final List f() {
        return a.n();
    }

    public static void g(Throwable th, String str, Object... objArr) {
        a.f(th, str, objArr);
    }

    public static void h(int i, String str, Object... objArr) {
        a.j(i, str, objArr);
    }

    public static final void i(c cVar) {
        a.o(cVar);
    }

    public static final int j() {
        return a.p();
    }

    public static void k(Throwable th, String str, Object... objArr) {
        a.l(th, str, objArr);
    }

    public static void l(Throwable th, String str, Object... objArr) {
        a.m(th, str, objArr);
    }
}
