

class Publication {

    private String title;

    public Publication(String title) {
        this.title = title;
    }

    public String getDetails() {
        return String.format("title=\"%s\"", title);
    }

    public static String compose(String details, Object subKey, Object subValue) {
        boolean quotes = subValue instanceof String;
        return String.format("%s, %s=%s%s%s", details, subKey, quotes ? "\"" : "", subValue, quotes ? "\"" : "");
    }

//    public static void main(String[] args) {
//        System.out.println(new Publication("The new era").getDetails());
//        System.out.println(new Newspaper("Football results", "Sport news").getDetails());
//        System.out.println(new Article("Why the Sun is hot", "Dr James Smith").getDetails());
//        System.out.println(new Announcement("Will sell a house", 30).getDetails());
//    }
}

class Newspaper extends Publication {

    private String source;

    public Newspaper(String title, String source) {
        super(title);
        this.source = source;
    }

    @Override
    public String getDetails() {
        return compose(super.getDetails(), "source", source);
    }
}

class Article extends Publication {

    private String author;

    public Article(String title, String author) {
        super(title);
        this.author = author;
    }

    @Override
    public String getDetails() {
        return compose(super.getDetails(), "author", author);
    }
}

class Announcement extends Publication {

    private int daysToExpire;

    public Announcement(String title, int daysToExpire) {
        super(title);
        this.daysToExpire = daysToExpire;
    }

    @Override
    public String getDetails() {
        return compose(super.getDetails(), "daysToExpire", daysToExpire);
    }
}