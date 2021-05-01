package ermilov.instattestmvpjava.models.videostreammodel;

public class VideoStreamModel {
    public String name;
    public int match_id;
    public int period;
    public int server_id;
    public String quality;
    public String folder;
    public String video_type;
    public String abc;
    public int start_ms;
    public Object checksum;
    public int size;
    public String abc_type;
    public int duration;
    public int fps;
    public String url_root;
    public String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getServer_id() {
        return server_id;
    }

    public void setServer_id(int server_id) {
        this.server_id = server_id;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getVideo_type() {
        return video_type;
    }

    public void setVideo_type(String video_type) {
        this.video_type = video_type;
    }

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    public int getStart_ms() {
        return start_ms;
    }

    public void setStart_ms(int start_ms) {
        this.start_ms = start_ms;
    }

    public Object getChecksum() {
        return checksum;
    }

    public void setChecksum(Object checksum) {
        this.checksum = checksum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getAbc_type() {
        return abc_type;
    }

    public void setAbc_type(String abc_type) {
        this.abc_type = abc_type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getFps() {
        return fps;
    }

    public void setFps(int fps) {
        this.fps = fps;
    }

    public String getUrl_root() {
        return url_root;
    }

    public void setUrl_root(String url_root) {
        this.url_root = url_root;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
