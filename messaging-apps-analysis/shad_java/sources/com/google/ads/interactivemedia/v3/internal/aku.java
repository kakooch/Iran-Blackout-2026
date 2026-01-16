package com.google.ads.interactivemedia.v3.internal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aku {
    public static final agt<BigInteger> A;
    public static final agu B;
    public static final agt<StringBuilder> C;
    public static final agu D;
    public static final agt<StringBuffer> E;
    public static final agu F;
    public static final agt<URL> G;
    public static final agu H;
    public static final agt<URI> I;
    public static final agu J;
    public static final agt<InetAddress> K;
    public static final agu L;
    public static final agt<UUID> M;
    public static final agu N;
    public static final agt<Currency> O;
    public static final agu P;
    public static final agu Q;
    public static final agt<Calendar> R;
    public static final agu S;
    public static final agt<Locale> T;
    public static final agu U;
    public static final agt<agj> V;
    public static final agu W;
    public static final agu X;
    public static final agt<Class> a;
    public static final agu b;
    public static final agt<BitSet> c;
    public static final agu d;
    public static final agt<Boolean> e;
    public static final agt<Boolean> f;
    public static final agu g;
    public static final agt<Number> h;
    public static final agu i;
    public static final agt<Number> j;
    public static final agu k;
    public static final agt<Number> l;
    public static final agu m;
    public static final agt<AtomicInteger> n;
    public static final agu o;
    public static final agt<AtomicBoolean> p;
    public static final agu q;
    public static final agt<AtomicIntegerArray> r;
    public static final agu s;
    public static final agt<Number> t;
    public static final agt<Number> u;
    public static final agu v;
    public static final agt<Character> w;
    public static final agu x;
    public static final agt<String> y;
    public static final agt<BigDecimal> z;

    static {
        agt<Class> agtVarNullSafe = new ajs().nullSafe();
        a = agtVarNullSafe;
        b = b(Class.class, agtVarNullSafe);
        agt<BitSet> agtVarNullSafe2 = new ake().nullSafe();
        c = agtVarNullSafe2;
        d = b(BitSet.class, agtVarNullSafe2);
        akm akmVar = new akm();
        e = akmVar;
        f = new akn();
        g = c(Boolean.TYPE, Boolean.class, akmVar);
        ako akoVar = new ako();
        h = akoVar;
        i = c(Byte.TYPE, Byte.class, akoVar);
        akp akpVar = new akp();
        j = akpVar;
        k = c(Short.TYPE, Short.class, akpVar);
        akq akqVar = new akq();
        l = akqVar;
        m = c(Integer.TYPE, Integer.class, akqVar);
        agt<AtomicInteger> agtVarNullSafe3 = new akr().nullSafe();
        n = agtVarNullSafe3;
        o = b(AtomicInteger.class, agtVarNullSafe3);
        agt<AtomicBoolean> agtVarNullSafe4 = new aks().nullSafe();
        p = agtVarNullSafe4;
        q = b(AtomicBoolean.class, agtVarNullSafe4);
        agt<AtomicIntegerArray> agtVarNullSafe5 = new ajk().nullSafe();
        r = agtVarNullSafe5;
        s = b(AtomicIntegerArray.class, agtVarNullSafe5);
        t = new ajl();
        ajm ajmVar = new ajm();
        u = ajmVar;
        v = b(Number.class, ajmVar);
        ajn ajnVar = new ajn();
        w = ajnVar;
        x = c(Character.TYPE, Character.class, ajnVar);
        ajo ajoVar = new ajo();
        y = ajoVar;
        z = new ajp();
        A = new ajq();
        B = b(String.class, ajoVar);
        ajr ajrVar = new ajr();
        C = ajrVar;
        D = b(StringBuilder.class, ajrVar);
        ajt ajtVar = new ajt();
        E = ajtVar;
        F = b(StringBuffer.class, ajtVar);
        aju ajuVar = new aju();
        G = ajuVar;
        H = b(URL.class, ajuVar);
        ajv ajvVar = new ajv();
        I = ajvVar;
        J = b(URI.class, ajvVar);
        ajw ajwVar = new ajw();
        K = ajwVar;
        L = d(InetAddress.class, ajwVar);
        ajx ajxVar = new ajx();
        M = ajxVar;
        N = b(UUID.class, ajxVar);
        agt<Currency> agtVarNullSafe6 = new ajy().nullSafe();
        O = agtVarNullSafe6;
        P = b(Currency.class, agtVarNullSafe6);
        Q = new aka();
        akb akbVar = new akb();
        R = akbVar;
        S = new akj(Calendar.class, GregorianCalendar.class, akbVar);
        akc akcVar = new akc();
        T = akcVar;
        U = b(Locale.class, akcVar);
        akd akdVar = new akd();
        V = akdVar;
        W = d(agj.class, akdVar);
        X = new akf();
    }

    public static <TT> agu a(akz<TT> akzVar, agt<TT> agtVar) {
        return new akg(akzVar, agtVar);
    }

    public static <TT> agu b(Class<TT> cls, agt<TT> agtVar) {
        return new akh(cls, agtVar);
    }

    public static <TT> agu c(Class<TT> cls, Class<TT> cls2, agt<? super TT> agtVar) {
        return new aki(cls, cls2, agtVar);
    }

    public static <T1> agu d(Class<T1> cls, agt<T1> agtVar) {
        return new akl(cls, agtVar);
    }
}
