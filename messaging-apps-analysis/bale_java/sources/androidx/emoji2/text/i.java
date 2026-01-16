package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.gov.nist.core.Separators;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.emoji2.text.e;
import ir.nasim.AbstractC15682jz7;
import ir.nasim.AbstractC18580ot7;
import ir.nasim.AbstractC4980Hj5;
import ir.nasim.AbstractC6245Mu2;
import ir.nasim.C19767qu2;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes2.dex */
public class i extends e.c {
    private static final a k = new a();

    public static class a {
        public Typeface a(Context context, AbstractC6245Mu2.b bVar) {
            return AbstractC6245Mu2.a(context, null, new AbstractC6245Mu2.b[]{bVar});
        }

        public AbstractC6245Mu2.a b(Context context, C19767qu2 c19767qu2) {
            return AbstractC6245Mu2.b(context, null, c19767qu2);
        }

        public void c(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b implements e.h {
        private final Context a;
        private final C19767qu2 b;
        private final a c;
        private final Object d = new Object();
        private Handler e;
        private Executor f;
        private ThreadPoolExecutor g;
        e.i h;
        private ContentObserver i;
        private Runnable j;

        b(Context context, C19767qu2 c19767qu2, a aVar) {
            AbstractC4980Hj5.h(context, "Context cannot be null");
            AbstractC4980Hj5.h(c19767qu2, "FontRequest cannot be null");
            this.a = context.getApplicationContext();
            this.b = c19767qu2;
            this.c = aVar;
        }

        private void b() {
            synchronized (this.d) {
                try {
                    this.h = null;
                    ContentObserver contentObserver = this.i;
                    if (contentObserver != null) {
                        this.c.c(this.a, contentObserver);
                        this.i = null;
                    }
                    Handler handler = this.e;
                    if (handler != null) {
                        handler.removeCallbacks(this.j);
                    }
                    this.e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f = null;
                    this.g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private AbstractC6245Mu2.b e() {
            try {
                AbstractC6245Mu2.a aVarB = this.c.b(this.a, this.b);
                if (aVarB.c() == 0) {
                    AbstractC6245Mu2.b[] bVarArrB = aVarB.b();
                    if (bVarArrB == null || bVarArrB.length == 0) {
                        throw new RuntimeException("fetchFonts failed (empty result)");
                    }
                    return bVarArrB[0];
                }
                throw new RuntimeException("fetchFonts failed (" + aVarB.c() + Separators.RPAREN);
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException("provider not found", e);
            }
        }

        @Override // androidx.emoji2.text.e.h
        public void a(e.i iVar) {
            AbstractC4980Hj5.h(iVar, "LoaderCallback cannot be null");
            synchronized (this.d) {
                this.h = iVar;
            }
            d();
        }

        void c() {
            synchronized (this.d) {
                try {
                    if (this.h == null) {
                        return;
                    }
                    try {
                        AbstractC6245Mu2.b bVarE = e();
                        int iB = bVarE.b();
                        if (iB == 2) {
                            synchronized (this.d) {
                            }
                        }
                        if (iB != 0) {
                            throw new RuntimeException("fetchFonts result is not OK. (" + iB + Separators.RPAREN);
                        }
                        try {
                            AbstractC18580ot7.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            Typeface typefaceA = this.c.a(this.a, bVarE);
                            ByteBuffer byteBufferF = AbstractC15682jz7.f(this.a, null, bVarE.d());
                            if (byteBufferF == null || typefaceA == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            l lVarB = l.b(typefaceA, byteBufferF);
                            AbstractC18580ot7.b();
                            synchronized (this.d) {
                                try {
                                    e.i iVar = this.h;
                                    if (iVar != null) {
                                        iVar.b(lVarB);
                                    }
                                } finally {
                                }
                            }
                            b();
                        } catch (Throwable th) {
                            AbstractC18580ot7.b();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        synchronized (this.d) {
                            try {
                                e.i iVar2 = this.h;
                                if (iVar2 != null) {
                                    iVar2.a(th2);
                                }
                                b();
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        void d() {
            synchronized (this.d) {
                try {
                    if (this.h == null) {
                        return;
                    }
                    if (this.f == null) {
                        ThreadPoolExecutor threadPoolExecutorB = androidx.emoji2.text.b.b("emojiCompat");
                        this.g = threadPoolExecutorB;
                        this.f = threadPoolExecutorB;
                    }
                    this.f.execute(new Runnable() { // from class: androidx.emoji2.text.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.a.c();
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void f(Executor executor) {
            synchronized (this.d) {
                this.f = executor;
            }
        }
    }

    public i(Context context, C19767qu2 c19767qu2) {
        super(new b(context, c19767qu2, k));
    }

    public i c(Executor executor) {
        ((b) a()).f(executor);
        return this;
    }
}
