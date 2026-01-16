package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.facebook.stetho.common.Utf8Charset;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public class apg extends ape {
    static boolean c = false;
    private static Method d;
    private static Method e;
    private static Method f;
    private static Method g;
    private static Method h;
    private static Method i;
    private static Method j;
    private static Method k;
    private static Method l;
    private static Method m;
    private static Method n;
    private static Method o;
    private static String p;
    private static String q;
    private static String r;
    private static long s;
    private static apo t;

    protected apg(Context context, apm apmVar, app appVar) {
        super(context, apmVar, appVar);
    }

    static String e() throws apf {
        String str = p;
        if (str != null) {
            return str;
        }
        throw new apf();
    }

    protected static synchronized void k(Context context, apm apmVar) {
        File file;
        File file2;
        if (c) {
            return;
        }
        try {
            apo apoVar = new apo(apmVar);
            t = apoVar;
            p = "a.3.21.0";
            try {
                byte[] bArrB = apoVar.b();
                byte[] bArrA = t.a(bArrB, "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");
                File cacheDir = context.getCacheDir();
                if (cacheDir == null && (cacheDir = context.getDir("dex", 0)) == null) {
                    throw new apf();
                }
                File fileCreateTempFile = File.createTempFile("ads", ".jar", cacheDir);
                FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                fileOutputStream.write(bArrA, 0, bArrA.length);
                fileOutputStream.close();
                try {
                    DexClassLoader dexClassLoader = new DexClassLoader(fileCreateTempFile.getAbsolutePath(), cacheDir.getAbsolutePath(), null, context.getClassLoader());
                    Class clsLoadClass = dexClassLoader.loadClass(l(bArrB, "13+D8YKo7JA4YclLYFLTkDoLYm79WC6PTAAgd/iaV5l4mfBjRCrtCqwg533KI4Aw"));
                    Class clsLoadClass2 = dexClassLoader.loadClass(l(bArrB, "52UTclpblbgPZlv7Nj6v0rtDMPh43h349e01ntb69/chxdGasn3EykJHT0GFkNS+"));
                    Class clsLoadClass3 = dexClassLoader.loadClass(l(bArrB, "PLcKoSXa/7Erhgptf0Tz500+Zs0BLV22dGPCJPuPX1GNC9pyFVkRFks19kPnvjsE"));
                    Class clsLoadClass4 = dexClassLoader.loadClass(l(bArrB, "BVu9+hfoVnCGMY+PLQku1FUwfoIHRy389bNZXV62hXZUkceukjyax4oNU/CRj5DY"));
                    Class clsLoadClass5 = dexClassLoader.loadClass(l(bArrB, "lO2J0nQ8iUbwpSP7x7JVTRl9z6TOAokJraLnSEcbLEoX9aCYnEQiu/7d/0ADK+Kt"));
                    Class clsLoadClass6 = dexClassLoader.loadClass(l(bArrB, "3STGKgBH0KW29J9eL7SkydCEoMJ5wVqqxnqpt7l1d/UdAE49dT9zzc+xme8GwL0S"));
                    Class clsLoadClass7 = dexClassLoader.loadClass(l(bArrB, "R75TFH8UxzX6KzwmMOIAiEOgZ3w/LZFVVBMgCkszL4MS7jU6KCq3bFshhYLpG/lm"));
                    Class clsLoadClass8 = dexClassLoader.loadClass(l(bArrB, "Cd51XF2SemCUJwXZiKeIYddl4xLKDa/a258CP7t9qBxOqbBbeoj3yUZZjpA6+SrQ"));
                    Class clsLoadClass9 = dexClassLoader.loadClass(l(bArrB, "6Op3Osq/ycP+Tw/h0nZIOiaxu9PqhRTncsN3gXFfkXzFNVbOmFRaKWvs9L9+aZBY"));
                    Class clsLoadClass10 = dexClassLoader.loadClass(l(bArrB, "/RcUmTOFoVKQmYTx4SXUI3MZ+V8YeEVVMyskmyn2LKriaejeXpUmZci+LjJRw7Qi"));
                    Class clsLoadClass11 = dexClassLoader.loadClass(l(bArrB, "6LQAb447ICiHxbmOtmji3D4hpfwXiEjse1ir9OC50xqyamJ/KbX1/nX8AsL+bHcb"));
                    File file3 = cacheDir;
                    try {
                        Class clsLoadClass12 = dexClassLoader.loadClass(l(bArrB, "OJV6xVIR1eh7tYy9riemmYtkPaU/NBCWvnOl95ehf5cPSRNoet0V98Y76fm3gKIx"));
                        file2 = fileCreateTempFile;
                        try {
                            Class clsLoadClass13 = dexClassLoader.loadClass(l(bArrB, "eHOtFwMll5L1Neq7FYSb/mAfmCK3mjwD+kcR5jCosVyfkrvUDmIwRjmV8+q2NHYn"));
                            d = clsLoadClass.getMethod(l(bArrB, "GTcx0b8AlfY1ZowRGVcxzzHzJO55sJlZwAMsaBOasD4="), new Class[0]);
                            e = clsLoadClass2.getMethod(l(bArrB, "H2mF8ih5ZQ8pxTr+44xGtS8h3iHalDiydTmNQvvB9PE="), new Class[0]);
                            f = clsLoadClass3.getMethod(l(bArrB, "6ZHRPIXbN2vTr12hv8v+TAgfU76HlS1m5AiZXFvaSto="), new Class[0]);
                            g = clsLoadClass4.getMethod(l(bArrB, "dx4bb6UNwy6nC3HkcVDqL3Rsfu1d3Z1Pe6GiKK6hZrw="), Context.class);
                            clsLoadClass5.getMethod(l(bArrB, "yTAAp+clNbNF5Td/QjC7p5K6b33nl9lorC0oZXbsQ+A="), MotionEvent.class, DisplayMetrics.class);
                            h = clsLoadClass6.getMethod(l(bArrB, "qb4zfYvhFYr4xgO9UX/SM6bCi7jkPggWD8USiOhVgzo="), Context.class);
                            i = clsLoadClass7.getMethod(l(bArrB, "SOQAY/Yc8NWIdkLAhBUoY0hR/vEv4aG+caNKA29L5T8="), Context.class);
                            j = clsLoadClass8.getMethod(l(bArrB, "MR/p4pF6zrM2yOWsh7Kq5dbwUT5Plh7L/wEZR20DFJc="), Context.class);
                            k = clsLoadClass9.getMethod(l(bArrB, "q9p7XgEInfiuZrB/emAOSeQGTPIFmNmpVflkcIcq4bg="), Context.class);
                            l = clsLoadClass10.getMethod(l(bArrB, "b42TKHdy7hWPdEEpyazy/kll9Hb0px+6KEorIMPWagk="), Context.class);
                            m = clsLoadClass11.getMethod(l(bArrB, "1BCDmMTvausZ3wHdSO9fsXVYA9qCh8/EnuL2Cru5aZ8="), Context.class);
                            n = clsLoadClass12.getMethod(l(bArrB, "foNiPa3eaLdvcAZc5cQJrbbRL+KJK+PxPLQjHS2rrNE="), Context.class);
                            o = clsLoadClass13.getMethod(l(bArrB, "wzEQNL6fxZpDqLLHWbHIQaIaTEFKm5CSEQgkOmhzams="), Context.class);
                            String name = file2.getName();
                            file2.delete();
                            new File(file3, name.replace(".jar", ".dex")).delete();
                            s = f().longValue();
                            c = true;
                        } catch (Throwable th) {
                            th = th;
                            file = file3;
                            String name2 = file2.getName();
                            file2.delete();
                            new File(file, name2.replace(".jar", ".dex")).delete();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        file2 = fileCreateTempFile;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    file = cacheDir;
                    file2 = fileCreateTempFile;
                }
            } catch (apn e2) {
                throw new apf(e2);
            } catch (FileNotFoundException e3) {
                throw new apf(e3);
            } catch (IOException e4) {
                throw new apf(e4);
            } catch (ClassNotFoundException e5) {
                throw new apf(e5);
            } catch (NoSuchMethodException e6) {
                throw new apf(e6);
            } catch (NullPointerException e7) {
                throw new apf(e7);
            }
        } catch (apf unused) {
        } catch (UnsupportedOperationException unused2) {
        }
    }

    private static String l(byte[] bArr, String str) throws apf {
        try {
            return new String(t.a(bArr, str), Utf8Charset.NAME);
        } catch (apn e2) {
            throw new apf(e2);
        } catch (UnsupportedEncodingException e3) {
            throw new apf(e3);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ape
    protected void b(Context context) throws apf {
        Method method;
        Method method2;
        Method method3;
        try {
            try {
                d(1, h());
            } catch (apf unused) {
            }
            try {
                d(2, e());
            } catch (apf unused2) {
            }
            try {
                long jLongValue = f().longValue();
                c(25, jLongValue);
                long j2 = s;
                if (j2 != 0) {
                    c(17, jLongValue - j2);
                    c(23, s);
                }
            } catch (apf unused3) {
            }
            try {
                method3 = j;
            } catch (apf unused4) {
            }
            if (method3 == null) {
                throw new apf();
            }
            try {
                ArrayList arrayList = (ArrayList) method3.invoke(null, context);
                if (arrayList == null || arrayList.size() != 2) {
                    throw new apf();
                }
                c(31, ((Long) arrayList.get(0)).longValue());
                c(32, ((Long) arrayList.get(1)).longValue());
                try {
                    method2 = e;
                } catch (apf unused5) {
                }
                if (method2 == null) {
                    throw new apf();
                }
                try {
                    c(33, ((Long) method2.invoke(null, new Object[0])).longValue());
                    try {
                        apm apmVar = this.b;
                        String strB = q;
                        if (strB == null) {
                            Method method4 = g;
                            if (method4 == null) {
                                throw new apf();
                            }
                            try {
                                ByteBuffer byteBuffer = (ByteBuffer) method4.invoke(null, context);
                                if (byteBuffer == null) {
                                    throw new apf();
                                }
                                strB = apmVar.b(byteBuffer.array());
                                q = strB;
                            } catch (IllegalAccessException e2) {
                                throw new apf(e2);
                            } catch (InvocationTargetException e3) {
                                throw new apf(e3);
                            }
                        }
                        d(27, strB);
                    } catch (apf unused6) {
                    }
                    try {
                        apm apmVar2 = this.b;
                        String strB2 = r;
                        if (strB2 == null) {
                            Method method5 = i;
                            if (method5 == null) {
                                throw new apf();
                            }
                            try {
                                ByteBuffer byteBuffer2 = (ByteBuffer) method5.invoke(null, context);
                                if (byteBuffer2 == null) {
                                    throw new apf();
                                }
                                strB2 = apmVar2.b(byteBuffer2.array());
                                r = strB2;
                            } catch (IllegalAccessException e4) {
                                throw new apf(e4);
                            } catch (InvocationTargetException e5) {
                                throw new apf(e5);
                            }
                        }
                        d(29, strB2);
                    } catch (apf unused7) {
                    }
                    try {
                        method = k;
                    } catch (apf unused8) {
                    }
                    if (method == null) {
                        throw new apf();
                    }
                    try {
                        int[] iArr = (int[]) method.invoke(null, context);
                        c(5, iArr[0]);
                        c(6, iArr[1]);
                        try {
                        } catch (apf unused9) {
                        }
                        if (n == null) {
                            throw new apf();
                        }
                        try {
                            c(12, ((Integer) r1.invoke(null, context)).intValue());
                            try {
                            } catch (apf unused10) {
                            }
                            if (o == null) {
                                throw new apf();
                            }
                            try {
                                c(3, ((Integer) r1.invoke(null, context)).intValue());
                                try {
                                    d(34, i(context));
                                } catch (apf unused11) {
                                }
                                c(35, j(context).longValue());
                            } catch (IllegalAccessException e6) {
                                throw new apf(e6);
                            } catch (InvocationTargetException e7) {
                                throw new apf(e7);
                            }
                        } catch (IllegalAccessException e8) {
                            throw new apf(e8);
                        } catch (InvocationTargetException e9) {
                            throw new apf(e9);
                        }
                    } catch (IllegalAccessException e10) {
                        throw new apf(e10);
                    } catch (InvocationTargetException e11) {
                        throw new apf(e11);
                    }
                } catch (IllegalAccessException e12) {
                    throw new apf(e12);
                } catch (InvocationTargetException e13) {
                    throw new apf(e13);
                }
            } catch (IllegalAccessException e14) {
                throw new apf(e14);
            } catch (InvocationTargetException e15) {
                throw new apf(e15);
            }
        } catch (apf | IOException unused12) {
        }
    }

    static Long f() throws apf {
        Method method = d;
        if (method == null) {
            throw new apf();
        }
        try {
            return (Long) method.invoke(null, new Object[0]);
        } catch (IllegalAccessException e2) {
            throw new apf(e2);
        } catch (InvocationTargetException e3) {
            throw new apf(e3);
        }
    }

    static String g(Context context) throws apf {
        Method method = h;
        if (method == null) {
            throw new apf();
        }
        try {
            String str = (String) method.invoke(null, context);
            if (str != null) {
                return str;
            }
            throw new apf();
        } catch (IllegalAccessException e2) {
            throw new apf(e2);
        } catch (InvocationTargetException e3) {
            throw new apf(e3);
        }
    }

    static String h() throws apf {
        Method method = f;
        if (method == null) {
            throw new apf();
        }
        try {
            return (String) method.invoke(null, new Object[0]);
        } catch (IllegalAccessException e2) {
            throw new apf(e2);
        } catch (InvocationTargetException e3) {
            throw new apf(e3);
        }
    }

    static String i(Context context) throws apf {
        Method method = l;
        if (method == null) {
            throw new apf();
        }
        try {
            return (String) method.invoke(null, context);
        } catch (IllegalAccessException e2) {
            throw new apf(e2);
        } catch (InvocationTargetException e3) {
            throw new apf(e3);
        }
    }

    static Long j(Context context) throws apf {
        Method method = m;
        if (method == null) {
            throw new apf();
        }
        try {
            return (Long) method.invoke(null, context);
        } catch (IllegalAccessException e2) {
            throw new apf(e2);
        } catch (InvocationTargetException e3) {
            throw new apf(e3);
        }
    }
}
