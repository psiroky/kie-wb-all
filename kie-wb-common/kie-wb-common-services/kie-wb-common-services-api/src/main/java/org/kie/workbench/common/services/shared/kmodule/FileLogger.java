package org.kie.workbench.common.services.shared.kmodule;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class FileLogger
        implements KSessionLogger {

    private String name;
    private String file;
    private boolean threaded;
    private int interval;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public boolean isThreaded() {
        return threaded;
    }

    public void setThreaded(boolean threaded) {
        this.threaded = threaded;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }

        FileLogger that = ( FileLogger ) o;

        if ( interval != that.interval ) {
            return false;
        }
        if ( threaded != that.threaded ) {
            return false;
        }
        if ( file != null ? !file.equals( that.file ) : that.file != null ) {
            return false;
        }
        if ( name != null ? !name.equals( that.name ) : that.name != null ) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = ~~result;
        result = 31 * result + ( file != null ? file.hashCode() : 0 );
        result = ~~result;
        result = 31 * result + ( threaded ? 1 : 0 );
        result = ~~result;
        result = 31 * result + interval;
        result = ~~result;
        return result;
    }
}
