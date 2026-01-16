package com.bumptech.glide;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.c;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.c;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import ir.nasim.A93;
import ir.nasim.AbstractC13438gE;
import ir.nasim.AbstractC18350oW3;
import ir.nasim.C10848cI7;
import ir.nasim.C11288cl2;
import ir.nasim.C11598dH2;
import ir.nasim.C12241eH2;
import ir.nasim.C12850fH2;
import ir.nasim.C12864fI7;
import ir.nasim.C13482gI7;
import ir.nasim.C13826gt;
import ir.nasim.C16602lZ1;
import ir.nasim.C16807lt7;
import ir.nasim.C17194mZ2;
import ir.nasim.C17824nd2;
import ir.nasim.C18377oZ3;
import ir.nasim.C18968pZ3;
import ir.nasim.C19226pz5;
import ir.nasim.C20150rZ3;
import ir.nasim.C20547sB7;
import ir.nasim.C20596sH2;
import ir.nasim.C21036t02;
import ir.nasim.C21150tB7;
import ir.nasim.C21824uB7;
import ir.nasim.C22600vW4;
import ir.nasim.C23083wK;
import ir.nasim.C23958xo0;
import ir.nasim.C25142zo0;
import ir.nasim.C3601Bo0;
import ir.nasim.C3810Cl2;
import ir.nasim.C4069Do0;
import ir.nasim.C4537Fo0;
import ir.nasim.C4786Go0;
import ir.nasim.C5020Ho0;
import ir.nasim.C5120Hz1;
import ir.nasim.C6841Pf0;
import ir.nasim.C7319Rf0;
import ir.nasim.C7553Sf0;
import ir.nasim.C7790Tf0;
import ir.nasim.C8260Vf0;
import ir.nasim.EW5;
import ir.nasim.HW5;
import ir.nasim.InterfaceC13106fg0;
import ir.nasim.InterfaceC14292hg4;
import ir.nasim.InterfaceC9624aH2;
import ir.nasim.JW5;
import ir.nasim.LJ;
import ir.nasim.NT1;
import ir.nasim.NY6;
import ir.nasim.OX6;
import ir.nasim.PS7;
import ir.nasim.PW5;
import ir.nasim.SX6;
import ir.nasim.TW5;
import ir.nasim.UX6;
import ir.nasim.WI2;
import ir.nasim.YI2;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
abstract class f {

    class a implements WI2.b {
        private boolean a;
        final /* synthetic */ b b;
        final /* synthetic */ List c;
        final /* synthetic */ AbstractC13438gE d;

        a(b bVar, List list, AbstractC13438gE abstractC13438gE) {
            this.b = bVar;
            this.c = list;
            this.d = abstractC13438gE;
        }

        @Override // ir.nasim.WI2.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Registry get() {
            if (this.a) {
                throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
            }
            C16807lt7.a("Glide registry");
            this.a = true;
            try {
                return f.a(this.b, this.c, this.d);
            } finally {
                this.a = false;
                C16807lt7.b();
            }
        }
    }

    static Registry a(b bVar, List list, AbstractC13438gE abstractC13438gE) {
        InterfaceC13106fg0 interfaceC13106fg0F = bVar.f();
        LJ ljE = bVar.e();
        Context applicationContext = bVar.i().getApplicationContext();
        e eVarG = bVar.i().g();
        Registry registry = new Registry();
        b(applicationContext, registry, interfaceC13106fg0F, ljE, eVarG);
        c(applicationContext, bVar, registry, list, abstractC13438gE);
        return registry;
    }

    private static void b(Context context, Registry registry, InterfaceC13106fg0 interfaceC13106fg0, LJ lj, e eVar) {
        HW5 c25142zo0;
        HW5 ox6;
        Class cls;
        Registry registry2;
        registry.o(new DefaultImageHeaderParser());
        int i = Build.VERSION.SDK_INT;
        if (i >= 27) {
            registry.o(new C17824nd2());
        }
        Resources resources = context.getResources();
        List listG = registry.g();
        C4786Go0 c4786Go0 = new C4786Go0(context, listG, interfaceC13106fg0, lj);
        HW5 hw5M = PS7.m(interfaceC13106fg0);
        C16602lZ1 c16602lZ1 = new C16602lZ1(registry.g(), resources.getDisplayMetrics(), interfaceC13106fg0, lj);
        if (i < 28 || !eVar.a(c.b.class)) {
            c25142zo0 = new C25142zo0(c16602lZ1);
            ox6 = new OX6(c16602lZ1, lj);
        } else {
            ox6 = new A93();
            c25142zo0 = new C3601Bo0();
        }
        if (i >= 28) {
            registry.e("Animation", InputStream.class, Drawable.class, C13826gt.f(listG, lj));
            registry.e("Animation", ByteBuffer.class, Drawable.class, C13826gt.a(listG, lj));
        }
        JW5 jw5 = new JW5(context);
        C8260Vf0 c8260Vf0 = new C8260Vf0(lj);
        C6841Pf0 c6841Pf0 = new C6841Pf0();
        C12241eH2 c12241eH2 = new C12241eH2();
        ContentResolver contentResolver = context.getContentResolver();
        registry.a(ByteBuffer.class, new C4069Do0()).a(InputStream.class, new SX6(lj)).e("Bitmap", ByteBuffer.class, Bitmap.class, c25142zo0).e("Bitmap", InputStream.class, Bitmap.class, ox6);
        if (ParcelFileDescriptorRewinder.a()) {
            registry.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new C22600vW4(c16602lZ1));
        }
        registry.e("Bitmap", AssetFileDescriptor.class, Bitmap.class, PS7.c(interfaceC13106fg0));
        registry.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, hw5M).c(Bitmap.class, Bitmap.class, C21824uB7.a.a()).e("Bitmap", Bitmap.class, Bitmap.class, new C20547sB7()).b(Bitmap.class, c8260Vf0).e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new C7319Rf0(resources, c25142zo0)).e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new C7319Rf0(resources, ox6)).e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new C7319Rf0(resources, hw5M)).b(BitmapDrawable.class, new C7553Sf0(interfaceC13106fg0, c8260Vf0)).e("Animation", InputStream.class, C11598dH2.class, new UX6(listG, c4786Go0, lj)).e("Animation", ByteBuffer.class, C11598dH2.class, c4786Go0).b(C11598dH2.class, new C12850fH2()).c(InterfaceC9624aH2.class, InterfaceC9624aH2.class, C21824uB7.a.a()).e("Bitmap", InterfaceC9624aH2.class, Bitmap.class, new C20596sH2(interfaceC13106fg0)).d(Uri.class, Drawable.class, jw5).d(Uri.class, Bitmap.class, new EW5(jw5, interfaceC13106fg0)).p(new C5020Ho0.a()).c(File.class, ByteBuffer.class, new C4537Fo0.b()).c(File.class, InputStream.class, new C3810Cl2.e()).d(File.class, File.class, new C11288cl2()).c(File.class, ParcelFileDescriptor.class, new C3810Cl2.b()).c(File.class, File.class, C21824uB7.a.a()).p(new c.a(lj));
        if (ParcelFileDescriptorRewinder.a()) {
            cls = BitmapDrawable.class;
            registry2 = registry;
            registry2.p(new ParcelFileDescriptorRewinder.a());
        } else {
            cls = BitmapDrawable.class;
            registry2 = registry;
        }
        InterfaceC14292hg4 interfaceC14292hg4G = NT1.g(context);
        InterfaceC14292hg4 interfaceC14292hg4C = NT1.c(context);
        InterfaceC14292hg4 interfaceC14292hg4E = NT1.e(context);
        Class cls2 = Integer.TYPE;
        registry2.c(cls2, InputStream.class, interfaceC14292hg4G).c(Integer.class, InputStream.class, interfaceC14292hg4G).c(cls2, AssetFileDescriptor.class, interfaceC14292hg4C).c(Integer.class, AssetFileDescriptor.class, interfaceC14292hg4C).c(cls2, Drawable.class, interfaceC14292hg4E).c(Integer.class, Drawable.class, interfaceC14292hg4E).c(Uri.class, InputStream.class, TW5.f(context)).c(Uri.class, AssetFileDescriptor.class, TW5.e(context));
        PW5.c cVar = new PW5.c(resources);
        PW5.a aVar = new PW5.a(resources);
        PW5.b bVar = new PW5.b(resources);
        Class cls3 = cls;
        registry2.c(Integer.class, Uri.class, cVar).c(cls2, Uri.class, cVar).c(Integer.class, AssetFileDescriptor.class, aVar).c(cls2, AssetFileDescriptor.class, aVar).c(Integer.class, InputStream.class, bVar).c(cls2, InputStream.class, bVar);
        registry2.c(String.class, InputStream.class, new C5120Hz1.c()).c(Uri.class, InputStream.class, new C5120Hz1.c()).c(String.class, InputStream.class, new NY6.c()).c(String.class, ParcelFileDescriptor.class, new NY6.b()).c(String.class, AssetFileDescriptor.class, new NY6.a()).c(Uri.class, InputStream.class, new C23083wK.c(context.getAssets())).c(Uri.class, AssetFileDescriptor.class, new C23083wK.b(context.getAssets())).c(Uri.class, InputStream.class, new C18968pZ3.a(context)).c(Uri.class, InputStream.class, new C20150rZ3.a(context));
        if (i >= 29) {
            registry2.c(Uri.class, InputStream.class, new C19226pz5.c(context));
            registry2.c(Uri.class, ParcelFileDescriptor.class, new C19226pz5.b(context));
        }
        registry2.c(Uri.class, InputStream.class, new C10848cI7.d(contentResolver)).c(Uri.class, ParcelFileDescriptor.class, new C10848cI7.b(contentResolver)).c(Uri.class, AssetFileDescriptor.class, new C10848cI7.a(contentResolver)).c(Uri.class, InputStream.class, new C13482gI7.a()).c(URL.class, InputStream.class, new C12864fI7.a()).c(Uri.class, File.class, new C18377oZ3.a(context)).c(YI2.class, InputStream.class, new C17194mZ2.a()).c(byte[].class, ByteBuffer.class, new C23958xo0.a()).c(byte[].class, InputStream.class, new C23958xo0.d()).c(Uri.class, Uri.class, C21824uB7.a.a()).c(Drawable.class, Drawable.class, C21824uB7.a.a()).d(Drawable.class, Drawable.class, new C21150tB7()).q(Bitmap.class, cls3, new C7790Tf0(resources)).q(Bitmap.class, byte[].class, c6841Pf0).q(Drawable.class, byte[].class, new C21036t02(interfaceC13106fg0, c6841Pf0, c12241eH2)).q(C11598dH2.class, byte[].class, c12241eH2);
        HW5 hw5D = PS7.d(interfaceC13106fg0);
        registry2.d(ByteBuffer.class, Bitmap.class, hw5D);
        registry2.d(ByteBuffer.class, cls3, new C7319Rf0(resources, hw5D));
    }

    private static void c(Context context, b bVar, Registry registry, List list, AbstractC13438gE abstractC13438gE) {
        Iterator it = list.iterator();
        if (it.hasNext()) {
            AbstractC18350oW3.a(it.next());
            throw null;
        }
        if (abstractC13438gE != null) {
            abstractC13438gE.a(context, bVar, registry);
        }
    }

    static WI2.b d(b bVar, List list, AbstractC13438gE abstractC13438gE) {
        return new a(bVar, list, abstractC13438gE);
    }
}
