package stream;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UpperInputStream extends FilterInputStream {

    public UpperInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toUpperCase((char)c));
    }
    
    @Override
    public int read(byte[] b) throws IOException {
        return this.read(b, 0, b.length);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int ret = super.read(b, off, len);
        for (int i = 0; i < b.length; ++i) {
            b[i] = (byte) Character.toUpperCase((byte)b[i]);
        }
        return ret;
    }
    
}
