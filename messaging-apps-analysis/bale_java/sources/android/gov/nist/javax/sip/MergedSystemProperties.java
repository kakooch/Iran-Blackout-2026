package android.gov.nist.javax.sip;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

/* loaded from: classes.dex */
public class MergedSystemProperties extends Properties {
    private static final long serialVersionUID = -7922854860297151103L;
    private Properties parent;

    public MergedSystemProperties(Properties properties) {
        this.parent = properties;
    }

    @Override // java.util.Hashtable, java.util.Map
    public boolean containsKey(Object obj) {
        return this.parent.containsKey(obj);
    }

    @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
    public Object get(Object obj) {
        return System.getProperty(obj.toString()) != null ? System.getProperty(obj.toString()) : this.parent.getProperty(obj.toString());
    }

    @Override // java.util.Properties
    public String getProperty(String str, String str2) {
        return System.getProperty(str) != null ? System.getProperty(str) : this.parent.getProperty(str, str2);
    }

    @Override // java.util.Properties
    public void list(PrintStream printStream) {
        this.parent.list(printStream);
    }

    @Override // java.util.Properties
    public synchronized void load(InputStream inputStream) {
        this.parent.load(inputStream);
    }

    @Override // java.util.Properties
    public synchronized void loadFromXML(InputStream inputStream) {
        this.parent.loadFromXML(inputStream);
    }

    @Override // java.util.Properties
    public Enumeration<?> propertyNames() {
        return this.parent.propertyNames();
    }

    @Override // java.util.Properties
    public synchronized void save(OutputStream outputStream, String str) {
        this.parent.save(outputStream, str);
    }

    @Override // java.util.Properties
    public synchronized Object setProperty(String str, String str2) {
        return this.parent.setProperty(str, str2);
    }

    @Override // java.util.Properties
    public void store(OutputStream outputStream, String str) throws IOException {
        this.parent.store(outputStream, str);
    }

    @Override // java.util.Properties
    public synchronized void storeToXML(OutputStream outputStream, String str, String str2) {
        this.parent.storeToXML(outputStream, str, str2);
    }

    @Override // java.util.Properties
    public Set<String> stringPropertyNames() {
        throw new RuntimeException("Not implemented for Java 5 compatibility");
    }

    @Override // java.util.Hashtable
    public String toString() {
        return super.toString() + this.parent.toString();
    }

    @Override // java.util.Properties
    public void list(PrintWriter printWriter) {
        this.parent.list(printWriter);
    }

    @Override // java.util.Properties
    public void store(Writer writer, String str) {
        throw new RuntimeException("Not implemented for Java 5 compatibility");
    }

    @Override // java.util.Properties
    public synchronized void load(Reader reader) {
        throw new RuntimeException("Not implemented for Java 5 compatibility");
    }

    @Override // java.util.Properties
    public synchronized void storeToXML(OutputStream outputStream, String str) {
        this.parent.storeToXML(outputStream, str);
    }

    @Override // java.util.Properties
    public String getProperty(String str) {
        if (System.getProperty(str) != null) {
            return System.getProperty(str);
        }
        return this.parent.getProperty(str);
    }
}
