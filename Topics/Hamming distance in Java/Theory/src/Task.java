// You can experiment here, it won’t be checked

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task {
    public static void main(String[] args) {
        final List<Monitor.LogEntry> entries = List.of(
                new Monitor.LogEntry(new Date(), "aaa", "url1"),
                new Monitor.LogEntry(new Date(), "aaa", "url1"),
                new Monitor.LogEntry(new Date(), "aaa", "url1"),
                new Monitor.LogEntry(new Date(), "aaa", "url1"),
                new Monitor.LogEntry(new Date(), "aaa", "url2"),
                new Monitor.LogEntry(new Date(), "aaa", "url2"),
                new Monitor.LogEntry(new Date(), "aaa", "url2"),
                new Monitor.LogEntry(new Date(), "aaa", "url3"),
                new Monitor.LogEntry(new Date(), "aaa", "url3")
        );
        System.out.println(Monitor.getUrlToNumberOfVisited(entries));
    }
}

class Monitor {

    public static Map<String, Long> getUrlToNumberOfVisited(List<LogEntry> logs) {
        return logs.stream()
                .collect(Collectors.groupingBy(LogEntry::getUrl, Collectors.counting()));
    }


    static class LogEntry {

        private final Date created;
        private final String login;
        private String url;

        public LogEntry(Date created, String login, String url) {
            this.created = created;
            this.login = login;
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof LogEntry)) {
                return false;
            }

            LogEntry logEntry = (LogEntry) o;

            if (!login.equals(logEntry.login)) {
                return false;
            }
            return url.equals(logEntry.url);
        }

        @Override
        public int hashCode() {
            int result = login.hashCode();
            result = 31 * result + url.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "LogEntry{" +
                    ", created=" + created +
                    ", login='" + login + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}
